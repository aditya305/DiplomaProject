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
import javax.servlet.http.HttpSession;

import databaseconnection.DatabaseConnection;

/**
 * Servlet implementation class createg
 */
@WebServlet("/createg")
public class createg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createg() {
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
		HttpSession session=request.getSession();
		String username=(String) session.getAttribute("user");
		String gname = request.getParameter("gname");
		String total = request.getParameter("total");
		int mtotal=Integer.parseInt(total);
		String member="";
		int j=1;
		for(int i=0;i<mtotal;i++)
		{
			String name = request.getParameter("name"+j);
			if(member!="")
			{
				member=member+","+name;
			}
			else
			{
				member=name;
			}
			j++;
		}

		PrintWriter out = response.getWriter();
		
		DatabaseConnection db = new DatabaseConnection();
		db.dbconnection();
		
		String query = "select * from cgroup where gname ='"+gname+"'";

		ResultSet rs = db.getResultSet(query);
		try {
				if (rs.next()) 
				{
					out.println("<script type=\"text/javascript\">");
		        	out.println("alert('Group name already in use')");
		        	out.println("location=\"creategroup.jsp\"");
		        	out.println("</script>");
				} 
				else 
				{
					String query1 = "insert into cgroup values('"+gname+"','"+member+"','"+total+"','"+username+"')";
					int i=db.getUpdate(query1);
					if(i==1)
					{
						out.println("<script type=\"text/javascript\">");
			        	out.println("alert('Group Created Successfully')");
			        	out.println("location=\"creategroup.jsp\"");
			        	out.println("</script>");
					}
					else
					{
						out.println("<script type=\"text/javascript\">");
			        	out.println("alert('Error In Creation')");
			        	out.println("location=\"creategroup.jsp\"");
			        	out.println("</script>");
					}
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
