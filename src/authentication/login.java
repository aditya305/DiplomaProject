package authentication;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import databaseconnection.DatabaseConnection;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public login() {
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
		PrintWriter out = response.getWriter();

			try {
				DatabaseConnection db = new DatabaseConnection();
				db.dbconnection();
				
				String query = "select * from user where username = '" + username+ "' and password = '" + password + "'";
				ResultSet rs = (ResultSet) db.getResultSet(query);

				if (rs.next()) 
				{
					HttpSession session = request.getSession();
					if (rs.getString("type").equals("auditor")) 
					{
						session.setAttribute("type", "auditor");
					}
					session.setAttribute("user", username);
					response.sendRedirect("userhome.jsp");
				}
				else 
				{
					out.println("<script type=\"text/javascript\">");
		        	out.println("alert('Please provide valid login details')");
		        	out.println("location=\"index.jsp\"");
		        	out.println("</script>");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
