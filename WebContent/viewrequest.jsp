<%@page import="java.sql.*"%>
<%@page import="databaseconnection.DatabaseConnection"%>
<!-- End Header -->
<jsp:include page="Aheader.jsp"></jsp:include>
<!-- End Header -->
<style>
.mytable {
	position:relative;
    border-collapse: collapse;
    border-spacing: 0;
    width: 80%;
    border: 1px solid cyan;
    margin-left:130px;
    margin-top:40px;
}
.mytable th {
	background-color:cyan;
	font-size:18px;
	font-weight:bold;
	font-family:Times New Roman;
}
.mytable th, .mytable td {
    border: none;
    text-align: center;
    padding: 8px;
}
tr:nth-child(even){background-color: #eee;}

.mytable input[type="submit"].read-more{
	display:inline-block;
	color:#FFF;
	font-size:14px;
	font-weight:600;
	padding:12px 20px;
	background:#77a1a0;
	border-bottom:4px solid #576f6f;
	border-radius:5px;
	-webkit-border-radius:5px;
	-moz-border-radius:5px;
	-o-border-radius:5px;
	text-decoration:none;
	text-transform:uppercase;
	transition: all 0.3s ease-out;
	-webkit-transition: all 0.3s ease-out;
	-moz-transition: all 0.3s ease-out;
	-o-transition: all 0.3s ease-out;
	margin-top:10px;
}
.mytable input[type="submit"].read-more:hover{
	background:#EC7945;
	border-bottom:4px solid #D1612E;
}
.mytable input[type="submit"].read-more:active{
	position:relative;
	bottom:-2px;
}

@media screen and (max-width: 640px) {
	.mytable {
		overflow-x: auto;
		display: block;
		position:relative;
	    border-collapse: collapse;
	    border-spacing: 0;
	    width: 95%;
	    border: 1px solid cyan;
	    margin-left:10px;
	}
}
</style>
	<table class="mytable">
	 			<tr>
	 				<th>File</th>
	 				<th>File Name</th>
	 				<th>From</th>
	 				<th>Request Date</th>
	 				<th>Request Time</th>
	 				<th>Trustworthiness</th>
	 				<th>Action</th>
	 			</tr>
	 			<tr>
	 	<%
			DatabaseConnection db = new DatabaseConnection();
			db.dbconnection();
			String username=(String)session.getAttribute("user");
			String query = "Select * from request where reqto='"+username + "'";
			ResultSet rs = db.getResultSet(query);
			while (rs.next()) 
			{
				String fname = rs.getString("reqfile");
				String action = rs.getString("action");
				String reqdate = rs.getString("reqdate");
				String reqtime = rs.getString("reqtime");
				String reqfrom=rs.getString("reqfrom");
				String filename ="";
				if(fname.length() > 16)
				{
					filename = fname.substring(0, 16)+"...";
				}
				else{
					filename =fname;
				}
				String query1 = "Select * from user where username='"+reqfrom+ "'";
				ResultSet rs1 = db.getResultSet(query1);
				if(rs1.next()) 
				{
					String emailid=rs1.getString("emailid");
					String name=rs1.getString("name");
		%>		
		     <td><img src="<%=rs.getString("logo")%>" alt="" style="height:50px;"/></td>
		     <td><%=filename%></td>
		     <td><%=rs1.getString("name")%></td>
		     <td><%=reqdate%></td>
		     <td><%=rs.getString("reqtime")%></td>
		     <td><p><a href="chart.jsp?trustuser=<%=reqfrom%>" class="read-more" >View Trust</a></p></td>
		     <td>
		     <%
		     	if(action.equals("P"))
		     	{
		     %>
		     	 <form action="ARrequest" method="post">
		     	 	<input type="hidden" name="action" value="A">
		     	 	<input type="hidden" name="email" value="<%=emailid%>">
		     	 	<input type="hidden" name="file" value="<%=fname%>">
		     	 	<input type="hidden" name="reqdate" value="<%=reqdate%>">
		     	 	<input type="hidden" name="name" value="<%=name%>">
		     	 	<input type="hidden" name="sharename" value="<%=reqfrom%>">
		     	 	<input type="hidden" name="reqtime" value="<%=reqtime%>">
			     	<p><input type="submit" class="read-more" value="Accept"></p>
			     </form>
			     <form action="ARrequest" method="post">
			     <input type="hidden" name="reqtime" value="<%=reqtime%>">
			     	<input type="hidden" name="action" value="R">
		     	 	<input type="hidden" name="email" value="<%=emailid%>">
		     	 	<input type="hidden" name="file" value="<%=fname%>">
		     	 	<input type="hidden" name="reqdate" value="<%=reqdate%>">
		     	 	<input type="hidden" name="name" value="<%=name%>">
		     	 	<input type="hidden" name="shraename" value="<%=reqfrom%>">
			     	<p><input type="submit" class="read-more" value="Reject"></p>
			     </form>
			 <%
				}
		     	else if(action.equals("R"))
		     	{
			 %>
					<p>Rejected</p>
			<%
				}
			    else
			    {
			%>
					<p>Accepted</p>
			<%
			     }
			%>
			</td>
		</tr>
		<%
				}
			}
		%>
</table>
<br><br>
<div class="testimonials-news">.
</div>
	<table class="mytable">
	 			<tr>
	 				<th>File</th>
	 				<th>File Name</th>
	 				<th>From</th>
	 				<th>Request Date</th>
	 				<th>Request Time</th>
	 				<th>Action</th>
	 			</tr>
	 			<tr>
	 	<%
			String query12 = "Select * from request where reqfrom='"+username+ "'";
			ResultSet rs12 = db.getResultSet(query12);
			while (rs12.next()) 
			{
				String fname = rs12.getString("reqfile");
				String action = rs12.getString("action");
				String reqdate = rs12.getString("reqdate");
				String reqfrom=rs12.getString("reqfrom");
				String reqto=rs12.getString("reqto");
				String file ="";
				
				String querytxt = "Select * from files where file='"+fname+ "'";
				ResultSet res = db.getResultSet(querytxt);
				while (res.next()) 
				{
					file = res.getString("filenameextn");
				}
				
				String filename ="";
				if(fname.length() > 16)
				{
					filename = fname.substring(0, 16)+"...";
				}
				else{
					filename =fname;
				}
				String query11 = "Select * from user where username='"+reqto+ "'";
				ResultSet rs11 = db.getResultSet(query11);
				if(rs11.next()) 
				{
					String emailid=rs11.getString("emailid");
					String name=rs11.getString("name");
		%>		
		     <td><img src="<%=rs12.getString("logo")%>" alt="" style="height:50px;"/></td>
		     <td><%=filename%></td>
		     <td><%=rs11.getString("name")%></td>
		     <td><%=reqdate%></td>
		     <td><%=rs12.getString("reqtime")%></td>
		     <td>
		     <%
		     	if(action.equals("P"))
		     	{
		     %>
			     	<p>Pending</p>
			 <%
				}
		     	else if(action.equals("R"))
		     	{
			 %>
					<p>Rejected</p>
			<%
				}
			    else
			    {
			%>
<!-- 				 <form action="downloadfile.jsp" method="post"> -->
<%-- 		     	 	<input type="hidden" name="email" value="<%=emailid%>"> --%>
<%-- 		     	 	<input type="hidden" name="file" value="<%=file%>"> --%>
<%-- 		     	 	<input type="hidden" name="reqdate" value="<%=reqdate%>"> --%>
<%-- 		     	 	<input type="hidden" name="name" value="<%=name%>"> --%>
<%-- 		     	 	<input type="hidden" name="shraename" value="<%=reqfrom%>"> --%>
			     	<p><a  class="read-more" href="downloadfile.jsp?file=<%=file%>&uploder=<%=reqto%>">Download File</a></p>
<!-- 			     </form> -->
			<%
			     }
			%>
			</td>
		</tr>
		<%
				}
			}
		%>
</table>
<br><br>
<div class="testimonials-news">.
</div>
<jsp:include page="footer.jsp"></jsp:include>