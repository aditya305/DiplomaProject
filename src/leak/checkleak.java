package leak;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.UserDefinedFileAttributeView;
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
import org.apache.commons.io.FilenameUtils;


import uploader.extnslector;
import uploader.path;
import fakeobject.Signature;
import databaseconnection.DatabaseConnection;
import dbmanager.datamanager;
import endecryption.file_encryption;
import endecryption.getName;
import endecryption.key;

/**
 * Servlet implementation class checkleak
 */
@WebServlet("/checkleak")
public class checkleak extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkleak() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		DatabaseConnection db = new DatabaseConnection();
		db.dbconnection();

		// process only if its multipart content
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				List<FileItem> multiparts = new ServletFileUpload(
						new DiskFileItemFactory()).parseRequest(request);

				for (FileItem item : multiparts) {
					if (!item.isFormField()) {

						String name = new File(item.getName()).getName();
						System.out.println(name); // print with extenssion

						path p = new path();
						String username = (String) session.getAttribute("user");

						File udir = new File(p.leakpath+ username);
						if (!(udir.exists())) {
							udir.mkdir();
						}

						File a = new File(udir + "//" + name);					
						item.write(a);

						String  absolutePath = udir + "//" + name;			
						System.out.println(absolutePath);
						
//						Signature sign = new Signature();
//				        String water=sign.getSignature(absolutePath);
						
				        final Path file = Paths.get(absolutePath);
				        final UserDefinedFileAttributeView view = Files.getFileAttributeView(file, UserDefinedFileAttributeView.class);
				        // The file attribute
				        final String findername = "Reciver";
				        // Read the property
				        final ByteBuffer readBuffer = ByteBuffer.allocate(view.size(findername));
				        view.read(findername, readBuffer);
				        readBuffer.flip();
				        final String valueFromAttributes = new String(readBuffer.array(), "UTF-8");
				        System.out.println("File Attribute: " + valueFromAttributes);
				        
				   if(!username.equals(valueFromAttributes))
				   {
				        String query1 = "insert into leak values('" + name + "','" + username+ "','" + valueFromAttributes + "')";
						int i=db.getUpdate(query1);
						if(i==1)
						{
							out.println("<script type=\"text/javascript\">");
				        	out.println("alert('Leaker finding done')");
				        	out.println("location=\"index.jsp\"");
				        	out.println("</script>");
						}
						else
						{
							out.println("<script type=\"text/javascript\">");
				        	out.println("alert('Error occure')");
				        	out.println("location=\"signup.jsp\"");
				        	out.println("</script>");
						}
				        System.out.println(valueFromAttributes);
					}
						
//						a.deleteOnExit();
//						File b = new File(destination);
//						b.deleteOnExit();
						
						
						
						System.out.println("Attempting to delete " + a.getAbsolutePath());
						if (!a.exists())
						  System.out.println("  Doesn't exist");
						else if (!a.canWrite())
						  System.out.println("  No write permission");
						else
						{
						  if (a.delete())
						    System.out.println("  Deleted!");
						  else
						    System.out.println("  Delete failed - reason unknown");
						}
						
						
//						System.out.println("Attempting to delete " + b.getAbsolutePath());
//						if (!b.exists())
//						  System.out.println("  Doesn't exist");
//						else if (!b.canWrite())
//						  System.out.println("  No write permission");
//						else
//						{
//						  if (b.delete())
//						    System.out.println("  Deleted!");
//						  else
//						    System.out.println("  Delete failed - reason unknown");
//						}
						request.getRequestDispatcher("index.jsp").include(request,
								response);
						
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
