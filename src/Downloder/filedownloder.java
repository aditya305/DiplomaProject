package Downloder;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uploader.path;

import com.dropbox.core.DbxException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import databaseconnection.DatabaseConnection;

/**
 * Servlet implementation class filedownloder
 */
@WebServlet("/filedownloder")
public class filedownloder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public filedownloder() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @param path
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
//		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("user");
		String file = request.getParameter("file");
		String key = request.getParameter("deckey");
		String uploader = request.getParameter("uploader");
		String ip = request.getParameter("ip");

		String filePath = path.path + uploader;

		File pathToCreate = new File(filePath);
		while (!(pathToCreate.exists())) {
			pathToCreate.mkdir();
		}

		filePath = path.path + uploader + "//" + file;
		// DatabaseConnection db = new DatabaseConnection();
		// db.dbconnection();
		// String sql =
		// " select filenamedrive,enckey from  files where uploder='" + user
		// + "' and enckey = '" + key + "' and filenameextn='" + file
		// + "'";
		// System.out.println(sql);
		//
		// ResultSet rs = db.getResultSet(sql);
		DatabaseConnection db = new DatabaseConnection();
		db.dbconnection();
		String dcryptPath = preProcessing.preProcessing(uploader, key, file,
				db, user);

		try {
			if (!(dcryptPath.equals(""))) {
				// String filenamedrive= rs.getString("filenamedrive");
				// DriveDownload.DriveDownload(rs.getString("filenamedrive"),
				// rs.getString("filenamedrive"), user);
				// System.out.println(rs.getString("enckey"));
				//
				//
				// decryptor.main(path.path+user+"/"+filenamedrive,
				// path.path+user+"/"+random()+filenamedrive, key);
				//
				// FileInputStream fileInputStream = new
				// FileInputStream(dcryptPath);
				//
				// int i;
				// while ((i=fileInputStream.read()) != -1) {
				// out.write(i);
				// }
				// fileInputStream.close();
				// out.close();

				File downloadFile = new File(dcryptPath);
				FileInputStream inStream = new FileInputStream(downloadFile);

				// if you want to use a relative path to context root:
				String relativePath = getServletContext().getRealPath("");
				System.out.println("relativePath = " + relativePath);

				// obtains ServletContext
				ServletContext context = getServletContext();

				// gets MIME type of the file
				String mimeType = context.getMimeType(filePath);
				if (mimeType == null) {
					// set to binary type if MIME mapping not found
					mimeType = "application/octet-stream";
				}
				System.out.println("MIME type: " + mimeType);

				// modifies response
				response.setContentType(mimeType);
				response.setContentLength((int) downloadFile.length());

				// forces download
				String headerKey = "Content-Disposition";
				String headerValue = String.format(
						"attachment; filename=\"%s\"", downloadFile.getName());
				response.setHeader(headerKey, headerValue);

				// obtains response's output stream
				OutputStream outStream = response.getOutputStream();

				byte[] buffer = new byte[4096];
				int bytesRead = -1;

				while ((bytesRead = inStream.read(buffer)) != -1) {
					outStream.write(buffer, 0, bytesRead);
				}

				inStream.close();
				outStream.close();

				db.closeConnection(db);
			} else {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Wrong key for file decryption')");
				out.println("location=\"sharefile.jsp?file=" + file + "\"");
				out.println("</script>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
