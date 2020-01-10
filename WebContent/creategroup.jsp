<%@page import="java.sql.*"%>
<%@page import="databaseconnection.DatabaseConnection"%>
<jsp:include page="Aheader.jsp"></jsp:include>
<script type="text/javascript">
	function savetotal()
	{
		var cclick=document.getElementById("cclick").value;
		var total=parseInt(document.getElementById("total").value);
	 	//var inttotal=parseInt(total,10);
 		var int1total="";
		if($('#cclick').is(':checked'))
		{
			int1total=total+1;
			document.getElementById("total").value=int1total;
		}
		else
		{
			int1total=total-1;
			document.getElementById("total").value=int1total;
		}
	}
</script>
<div class="main">	 
	 <div class="contact about-desc">
   		<div class="container">
   			<div class="row">
   				<div id="signupdiv" class="col-md-4">
   					<div class="contact_right">
   					<div class="contact-form_grid">
					   <form method="post" action="createg">
						 <span class="textlabel">Group Name:-</span> 
						 	<input type="text" class="textbox" placeholder="Your group name" name="gname" required>
						 	<input type="hidden" id="total" value="0" name="total"/>
						  <%
						 	DatabaseConnection db = new DatabaseConnection();
							db.dbconnection();
							int i=1;
							String query = "Select * from user Where username !='"+session.getAttribute("user")+"'";
							ResultSet rs = db.getResultSet(query);
							while (rs.next()) 
							{
								String name = rs.getString("name");
								String username = rs.getString("username");
						  %>
						  <span class="textlabel">
						  	<input type="checkbox" id="cclick" class="textbox" name="name<%=i%>" value="<%=username%>" onclick="savetotal()">
						  	<%=name%> &nbsp;&nbsp;&nbsp;
<!-- 						  	<input type="checkbox" class="textbox" name="email" required> -->
<!-- 						  	Enter Email-Id -->
						  </span>
						  <br><br>
						  <%
						  		i++;
							}
						  %>	
						  <br><br>					
						 <input type="submit" value="Create Group">
					   </form>
			      	</div>
   			     </div>
   				</div>
   			</div>
   		</div>
   	</div>
</div>
</body>
</html>