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
	 				<th>File Size</th>
	 				<th>Receiver</th>
	 				<th>Action</th>
	 			</tr>
	 			<tr>
	 	<%
			DatabaseConnection db = new DatabaseConnection();
			db.dbconnection();

			String query = "Select * from sharefiles where uploder='"+ session.getAttribute("user") + "'";
			ResultSet rs = db.getResultSet(query);
			while (rs.next()) 
			{
				String fname = rs.getString("file");
				String filename ="";
				if(fname.length() > 16)
				{
					filename = fname.substring(0, 16)+"...";
				}
				else{
					filename =fname;
				}
				String rcname="";
				String query1 = "Select * from user where username='"+ rs.getString("receiver") + "'";
				ResultSet rs1 = db.getResultSet(query1);
				if(rs1.next()) 
				{
					rcname=rs1.getString("name");
				}
				else
				{
					rcname=rs.getString("receiver");
				}
		%>		
		     <td><img src="<%=rs.getString("logo")%>" alt="" style="height:50px;"/></td>
		     <td><%=filename%></td>
		     <td><%=rs.getString("filesize")%></td>
		     
		     <td><%=rcname%></td>
		     <td><p><input type="submit" class="read-more" value="Cancel Sharing"></p></td>
		</tr>
		<%
			}
		%>
</table>
<br><br>
<div class="testimonials-news">.
</div>
<jsp:include page="footer.jsp"></jsp:include>