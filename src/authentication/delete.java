package authentication;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;

import databaseconnection.DatabaseConnection;

/**
 * Servlet implementation class delete
 */
@WebServlet("/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String file = request.getParameter("file");
		
		PrintWriter out = response.getWriter();
		
		DatabaseConnection db = new DatabaseConnection();
		db.dbconnection();
		
					String query = "delete from files Where filenameextn='"+file+"'";
					int i=db.getUpdate(query);
					
					String query1 = "delete from sharefiles Where filenameextn='"+file+"'";
					int i1=db.getUpdate(query1);
					
					String fileNameWithOutExt = FilenameUtils
							.removeExtension(file);
					String query2 = "delete from request Where reqfile='"+file+"'";
					int i2=db.getUpdate(query2);
					if(i==1)
					{
						out.println("<script type=\"text/javascript\">");
			        	out.println("alert('File deleted Successfully')");
			        	out.println("location=\"viewfiles.jsp\"");
			        	out.println("</script>");
					}
					else
					{
						out.println("<script type=\"text/javascript\">");
			        	out.println("alert('Error In delition')");
			        	out.println("location=\"viewfiles.jsp\"");
			        	out.println("</script>");
					}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
