<%@page import="java.sql.*"%>
<%@page import="databaseconnection.DatabaseConnection"%>
<!-- End Header -->
<jsp:include page="Aheader.jsp"></jsp:include>
<!-- End Header -->
<script type="text/javascript">
	function submitf1(){
		form = document.forms[0] //assuming only form.
		form.submit();
	}
</script>
	 	<div class="features">
	 		<div class="row">
	 	<%
			DatabaseConnection db = new DatabaseConnection();
			db.dbconnection();

			String query = "Select * from files where filenameextn='"+ request.getParameter("file") +"' and uploder ='"+session.getAttribute("user")+"'";
			ResultSet rs = db.getResultSet(query);
			if (rs.next()) 
			{
				String fname = rs.getString("file");
				String file =rs.getString("filenameextn");
				String uploader =rs.getString("uploder");
		%>
		        <div class="col-lg-4" id="my1col-lg-4">
		        </div><!-- /.col-lg-4 -->
		        
		        
				       	<div class="col-lg-4" id="mycol-lg-4">
				          <img src="<%=rs.getString("logo")%>" alt="" style="height:100px;"/>
				          <h2 style="font-size:15px;"><%=fname%></h2>
				          <p>Size:-<%=rs.getString("filesize")%></p>
				          <form id="f1" action="Share" method="post">
				          <p>
				          	<select name="selecteduser" style="height:32px;" required>
				          		<option value="0">Select User name for share</option>
				          		<%
								String query1 = "Select * from user where username !='"+ session.getAttribute("user") +"'";
								ResultSet rs1 = db.getResultSet(query1);
								while (rs1.next()) 
								{
									String name = rs1.getString("name");
									String username =rs1.getString("username");
								%>
									<option value="<%=username%>"><%=name%></option>
								<%
								}
								%>
				          	</select>
				          	<br>
				          	OR
				          	<br>
				          	<select name="selectedgroup" style="height:32px;" required>
				          		<option value="0">Select Group name for share</option>
				          		<%
								String query2 = "Select * from cgroup where createby ='"+ session.getAttribute("user") +"'";
								ResultSet rs2 = db.getResultSet(query2);
								while (rs2.next()) 
								{
									String gname = rs2.getString("gname");
									String member = rs2.getString("member");
								%>
									<option value="<%=gname%>"><%=gname%></option>
								<%
								}
								%>
				          	</select>
				          	<br><br>
				          	<input type="hidden" name="file" value="<%=file%>">
				          </p>
				          <p><input type="submit" class="read-more" value="Share File"></p>
				          </form>
				        </div><!-- /.col-lg-4 -->
				        
				        <div class="col-lg-4" id="mycol-lg-4">
				        <form action="filedownloder" method="post">
				          <img src="<%=rs.getString("logo")%>" alt="" style="height:100px;"/>
				          <h2 style="font-size:15px;"><%=fname%></h2>
				          <p>Size:-<%=rs.getString("filesize")%></p>
				          <p>
				          	<input type="text" name="deckey" placeholder="Enter Decryption Key Here" required>
				          	<input type="hidden" name="file" value="<%=file%>">
				          	<input type="hidden" name="uploader" value="<%=uploader%>">
				          </p>
				          <p><input type="submit" class="read-more" value="Download"></p>
				        </form>
				        </div><!-- /.col-lg-4 -->
		        
		        
		        <div class="col-lg-4" id="my1col-lg-4">
		        </div>
		        <div class="col-lg-4" id="my1col-lg-4">
		        </div>
		<%
			}
		%>
		      </div>
		   </div><br><br>
<div class="testimonials-news">.
</div>
<jsp:include page="footer.jsp"></jsp:include>