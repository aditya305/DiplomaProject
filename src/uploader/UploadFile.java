package uploader;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import databaseconnection.DatabaseConnection;
import dbmanager.datamanager;
import endecryption.EncryptFile;
import endecryption.file_encryption;
import endecryption.getName;
import endecryption.key;

/**
 * Servlet to handle File upload request from Client
 * 
 * @author Javin Paul
 */
@WebServlet("/UploadFile")
public class UploadFile extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();

		// process only if its multipart content
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				List<FileItem> multiparts = new ServletFileUpload(
						new DiskFileItemFactory()).parseRequest(request);

				for (FileItem item : multiparts) {
					if (!item.isFormField()) {

						String name = new File(item.getName()).getName();
						System.out.println(name); // print with extenssion

						long sizeInBytes = item.getSize();
						System.out.println("byte" + sizeInBytes);
						double kilobytes = sizeInBytes / 1024.0;
						String kb = String.valueOf(kilobytes);
						System.out.println("byte :" + kilobytes);

						String fileNameWithOutExt = FilenameUtils
								.removeExtension(name);
						System.out.println(fileNameWithOutExt); // print

						path p = new path();
						String username = (String) session.getAttribute("user");

						File udir = new File(p.path + username);
						if (!(udir.exists())) {
							udir.mkdir();
						}

						File a = new File(udir + "//" + name);
						String absolutePath = udir + "//" + name;

						String destination = udir + "//Enc_" + name;
						int i = 0;
						while (a.exists()) {
							i++;
							a = new File(udir + "//" + i + name);
							absolutePath = udir + "//" + i + name;
							name = i + name;
							destination = udir + "//Enc_" + name;

						}

						System.out.println(absolutePath);
						item.write(a);

						String bky = key.passer();
						EncryptFile enc = new EncryptFile(bky);
						enc.encrypt(a.getAbsolutePath(), destination);

						String drivename = getName.name(name);

						Dropbox.fileUpload_to_dropbox(destination, "/"+ drivename);

						// absolutePath = absolutePath.replaceAll("\\", "\\");
						System.out.println(absolutePath);
						datamanager dm = new datamanager();
						extnslector sx = new extnslector();
						String LOgoPath = sx.extnslector(name);
						dm.UploadLog(name.substring(0, name.lastIndexOf('.')),
								name, drivename, username, kilobytes + "",
								LOgoPath, bky);

						out.println("<script type=\"text/javascript\">");
						out.println("alert('File Uploding done')");
						out.println("</script>");

						// a.deleteOnExit();
						// File b = new File(destination);
						// b.deleteOnExit();

						System.out.println("Attempting to delete "
								+ a.getAbsolutePath());
						if (!a.exists())
							System.out.println("  Doesn't exist");
						else if (!a.canWrite())
							System.out.println("  No write permission");
						else {
							if (a.delete())
								System.out.println("  Deleted!");
							else
								System.out
										.println("  Delete failed - reason unknown");
						}

						// System.out.println("Attempting to delete " +
						// b.getAbsolutePath());
						// if (!b.exists())
						// System.out.println("  Doesn't exist");
						// else if (!b.canWrite())
						// System.out.println("  No write permission");
						// else
						// {
						// if (b.delete())
						// System.out.println("  Deleted!");
						// else
						// System.out.println("  Delete failed - reason unknown");
						// }
						request.getRequestDispatcher("index.jsp").include(
								request, response);

					}

				}
			} catch (Exception ex) {
				System.out.println(ex);
			}
		} else {
			request.setAttribute("message",
					"Sorry this Servlet only handles file upload request");
		}
	}
}