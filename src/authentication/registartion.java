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

import databaseconnection.DatabaseConnection;

/**
 * Servlet implementation class registartion
 */
@WebServlet("/registartion")
public class registartion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public registartion() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String name = request.getParameter("name");
		
		PrintWriter out = response.getWriter();
		
		DatabaseConnection db = new DatabaseConnection();
		db.dbconnection();
		
		String query = "select * from user where username = '" + username + "'";

		ResultSet rs = db.getResultSet(query);
		try {
				if (rs.next()) 
				{
					out.println("<script type=\"text/javascript\">");
		        	out.println("alert(" + username	+ " already in use)");
		        	out.println("location=\"signup.jsp\"");
		        	out.println("</script>");
				} 
				else 
				{
					String query1 = "insert into user values('" + name + "','" + email+ "','" + mobile + "','" + username + "','" + password + "','user')";
					int i=db.getUpdate(query1);
					if(i==1)
					{
						out.println("<script type=\"text/javascript\">");
			        	out.println("alert('Register Successfully')");
			        	out.println("location=\"index.jsp\"");
			        	out.println("</script>");
					}
					else
					{
						out.println("<script type=\"text/javascript\">");
			        	out.println("alert('Error In registartion')");
			        	out.println("location=\"signup.jsp\"");
			        	out.println("</script>");
					}
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
