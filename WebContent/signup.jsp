<jsp:include page="header.jsp"></jsp:include>
<div class="main">	 
	 <div class="contact about-desc">
   		<div class="container">
   			<div class="row">
   				<div id="signupdiv" class="col-md-4">
   					<div class="contact_right">
   					<div class="contact-form_grid">
					   <form method="post" action="registartion">
						 <span class="textlabel">Enter Full Name:-</span> 
						 	<input type="text" class="textbox" placeholder="Your name" name="name" required>
						 <span class="textlabel">Enter Email-Id:-</span> 
						 	<input type="email" class="textbox" placeholder="Your email" name="email" required>
						 <span class="textlabel">Enter Mobile Number:-</span> 
						 	<input type="text" class="textbox" placeholder="Your Mobile Number" name="mobile" required>
<!-- 						 <textarea value="Message:" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Message';}">Message</textarea> -->
						 <span class="textlabel">Enter Username:-</span> 
						 	<input type="text" class="textbox" placeholder="Your username" name="username" required>
						 <span class="textlabel">Enter Password:-</span> 
						 	<input type="password" class="textbox" placeholder="Your password" name="password" required>
						 <input type="submit" value="Send">
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