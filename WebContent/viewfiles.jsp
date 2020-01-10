<%@page import="java.sql.*"%>
<%@page import="databaseconnection.DatabaseConnection"%>
<style>
.profile-img-container {
    position: relative;
    display: inline-block; /* added */
    overflow: hidden; /* added */
}
.profile-img-container img:hover {
    opacity: 0.5
}
.profile-img-container:hover a {
    opacity: 1; /* added */
    top: 0; /* added */
    z-index: 500;
}
/* added */
.profile-img-container:hover a span {
	font-size:80px;
    top: 50%;
    position: absolute;
    left: 0;
    right: 0;
    transform: translateY(-50%);
}
/* added */
.profile-img-container a {
    display: block;
    position: absolute;
    top: -100%;
    opacity: 0;
    left: 0;
    bottom: 0;
    right: 0;
    text-align: center;
    color: inherit;
}
	@media only screen and (min-device-width: 320px) and (max-device-width: 768px) {
		.fileheadname{
			margin-left:0px;
		}
	}
</style>
<!-- End Header -->
<jsp:include page="Aheader.jsp"></jsp:include>
<!-- End Header -->
<br>
<span class="fileheadname">Your Uploaded Files</span>
	 	<div class="features">
	 		 			
	 		<div class="row">
	 	<%
			DatabaseConnection db = new DatabaseConnection();
			db.dbconnection();
			String username=(String)session.getAttribute("user");
			int i=0;
			String query = "Select * from files where uploder='"+ session.getAttribute("user") + "'";
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
				if(i==5)
				{
		%>
					.<br><br>
		<%
				}
		%>
		        <div class="col-lg-4" id="mycol-lg-4">
		        	<div class="profile-img-container">
						<img src="<%=rs.getString("logo")%>" style="height:100px;"/>
						<a href="delete?file=<%=rs.getString("filenameextn")%>"><span class="fa fa-trash-o"></span></a>
					</div>
		          <h2 style="font-size:15px;"><%=filename%></h2>
		          <p>Size:-<%=rs.getString("filesize")%></p>
		          <p><a class="read-more" href="sharefile.jsp?file=<%=rs.getString("filenameextn")%>">Download/Share</a></p>
		        </div><!-- /.col-lg-4 -->
		<%
				i++;
			}
		%>
		      </div>
		   </div>
<br>
<span style="font-variant:small-caps;font-size:35px;margin-left:430px;font-weight:bold;font-family:Times New Roman;">Files Share with you from other</span>
	 	<div class="features">
	 		 			
	 		<div class="row">
	 	<%
	 		int i1=0;
			String query1 = "Select * from sharefiles where receiver='"+ session.getAttribute("user") + "'";
			ResultSet rs1 = db.getResultSet(query1);
			while (rs1.next()) 
			{
				String fname1 = rs1.getString("file");
				String logo = rs1.getString("logo");
				String uploder = rs1.getString("uploder");
				String filename1 ="";
				if(fname1.length() > 16)
				{
					filename1 = fname1.substring(0, 16)+"...";
				}
				else{
					filename1 =fname1;
				}
				if(i1==5)
				{
		%>
					.<br><br>
		<%
				}
		%>
		        <div class="col-lg-4" id="mycol-lg-4">
		          <img src="<%=logo%>" alt="" style="height:100px;"/>
		          <h2 style="font-size:15px;"><%=filename1%></h2>
		          <p>Size:-<%=rs1.getString("filesize")%></p>
		          <form action="sendrequest" method="post">
		          <p>
		          	<input type="hidden" name="file" value="<%=fname1%>"/>
		          	<input type="hidden" name="logo" value="<%=logo%>"/>
		          	<input type="hidden" name="to" value="<%=uploder%>"/>
		          	<input type="submit" class="read-more" value="Request"/>
		          </p>
		          </form>
		        </div><!-- /.col-lg-4 -->
		<%
				i1++;
			}
		%>
		      </div>
		   </div>	
		   
		   <span style="font-variant:small-caps;font-size:35px;margin-left:430px;font-weight:bold;font-family:Times New Roman;">Group Sharing files</span>
	 	<div class="features">
	 		 			
	 		<div class="row">
	 	<%
	 	String query3 = "Select * from cgroup Where member like '%"+username+"%'";
		ResultSet rs3 = db.getResultSet(query3);
		while (rs3.next()) 
		{
			String gname = rs3.getString("gname");
			
			int i2=0;
			String query2 = "Select * from sharefiles where receiver='"+gname+ "'";
			ResultSet rs2 = db.getResultSet(query2);
			while(rs2.next()) 
			{
				String member = rs3.getString("member");
				String[] alluser=member.split(",");
				for(int k=0; k<alluser.length; k++)
				{
					if(username.equals(alluser[k]))
					{
					String fname2 = rs2.getString("file");
					String logo = rs2.getString("logo");
					String uploder = rs2.getString("uploder");
					String filename1 ="";
					if(fname2.length() > 16)
					{
						filename1 = fname2.substring(0, 16)+"...";
					}
					else{
						filename1 =fname2;
					}
					if(i2==5)
					{
		%>
					.<br><br>
		<%
					}
		%>
		        <div class="col-lg-4" id="mycol-lg-4">
		          <img src="<%=logo%>" alt="" style="height:100px;"/>
		          <h2 style="font-size:15px;"><%=filename1%></h2>
		          <p>Size:-<%=rs2.getString("filesize")%></p>
		          <form action="sendrequest" method="post">
		          <p>
		          	<input type="hidden" name="file" value="<%=fname2%>"/>
		          	<input type="hidden" name="logo" value="<%=logo%>"/>
		          	<input type="hidden" name="to" value="<%=uploder%>"/>
		          	<input type="submit" class="read-more" value="Request"/>
		          </p>
		          </form>
		        </div><!-- /.col-lg-4 -->
		<%
					}
				}
				i2++;
			}
		}
		%>
		      </div>
		   </div>	   
<br><br>
<div class="testimonials-news">.
</div>
<jsp:include page="footer.jsp"></jsp:include>