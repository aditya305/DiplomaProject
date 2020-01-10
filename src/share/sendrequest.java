package share;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sendmail.SimpleSendEmail;
import databaseconnection.DatabaseConnection;

/**
 * Servlet implementation class Share
 */
@WebServlet("/sendrequest")
public class sendrequest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public sendrequest() {
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
		
		String file = request.getParameter("file");
		String logo = request.getParameter("logo");
		String to = request.getParameter("to");
		 	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	        Date date = new Date();
	        String currdate=dateFormat.format(date);
	        //System.out.println(currdate);
	        
	        DateFormat timeFormat = new SimpleDateFormat("hh.mm a");
	        Date time = new Date();
	        String currtime=timeFormat.format(time);
	        //System.out.println(currtime);

		HttpSession session = request.getSession();

		String username = (String) session.getAttribute("user");

		DatabaseConnection db = new DatabaseConnection();
		db.dbconnection();
		PrintWriter out = response.getWriter();
		
			String sql = "insert into request values('"+file+"','"+currdate+"','"+currtime+"','"+username+"','"+to+"','"+logo+"','P')";
			int i=db.getUpdate(sql);
			if(i==1)
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Request Send Successfully');");
				out.println("location=\"viewfiles.jsp\";");
				out.println("</script>");
			}
			else
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Problem while send request');");
				out.println("location=\"viewfiles.jsp\";");
				out.println("</script>");
			}
	}

}
