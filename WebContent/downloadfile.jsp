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

			String query = "Select * from files where filenameextn='"+ request.getParameter("file") +"' and uploder = '"+  request.getParameter("uploder") +"'";
			ResultSet rs = db.getResultSet(query);
			while (rs.next()) 
			{
				String fname = rs.getString("file");
				String file =rs.getString("filenameextn");
				String uploader =rs.getString("uploder");
		%>
		        <div class="col-lg-4" >
		        </div><!-- /.col-lg-4 -->		          
				      <div class="col-lg-4" id="mycol-lg-4">
				        <form action="filedownloder" method="post">
				          <img src="<%=rs.getString("logo")%>" alt="" style="height:100px;"/>
				          <h2 style="font-size:15px;"><%=fname%></h2>
				          <p>Size:-<%=rs.getString("filesize")%></p>
				          <p>
				          	<input type="hidden" name="file" value="<%=file%>">
				          	<input type="text" name="deckey" placeholder="Enter Decryption Key Here" required>
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