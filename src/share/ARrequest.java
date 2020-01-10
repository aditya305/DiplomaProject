package share;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dropbox.core.DbxException;


import sendmail.SimpleSendEmail;
import uploader.path;
import fakeobject.Signature;
import databaseconnection.DatabaseConnection;

/**
 * Servlet implementation class Share
 */
@WebServlet("/ARrequest")
public class ARrequest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ARrequest() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		String email = request.getParameter("email");
		String file = request.getParameter("file");
		String reqdate = request.getParameter("reqdate");
		String name = request.getParameter("name");
		String reqtime = request.getParameter("reqtime");
		
		
		//String sharename = request.getParameter("sharename");
		
		HttpSession session = request.getSession();

		String username = (String) session.getAttribute("user");

		DatabaseConnection db = new DatabaseConnection();
		db.dbconnection();
		PrintWriter out = response.getWriter();
		
	 if(action.equals("A"))
	 {
			String sql = "Update request Set action='"+action+"' Where reqfile='"+file+"' and reqdate='"+reqdate+"' and reqtime ='"+reqtime+"'";
			db.getUpdate(sql);

				String sql1 = "select enckey,filenamedrive from files where file = '"+ file + "'";
				ResultSet rs = db.getResultSet(sql1);

				try {
					if (rs.next()) 
					{
						SimpleSendEmail emails = new SimpleSendEmail(email,"Request details",file+ " shared by user "+ name+ " you can decrypt this file using this key: "+ rs.getString("enckey"));
						
						out.println("<script type=\"text/javascript\">");
						out.println("alert('Request Accepted');");
						out.println("location=\"viewrequest.jsp\";");
						out.println("</script>");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		else
		{
			String sql = "Update request Set action='"+action+"' Where reqfile='"+file+"' and reqdate='"+reqdate+"' and reqtime ='"+reqtime+"'";
			db.getUpdate(sql);

				String sql1 = "select enckey from files where file = '"+ file + "'";
				ResultSet rs = db.getResultSet(sql1);

				try {
					if (rs.next()) 
					{
						SimpleSendEmail emails = new SimpleSendEmail(email,"Request details","Your file key request is rejected from user");			
						out.println("<script type=\"text/javascript\">");
						out.println("alert('Request rejected');");
						out.println("location=\"viewrequest.jsp\";");
						out.println("</script>");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

}
