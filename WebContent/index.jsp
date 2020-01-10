<!DOCTYPE HTML>
<html>
<head>
<title>Secure Cloud System</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/font-awesome.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/carousel.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/owl.carousel.css" rel="stylesheet" type="text/css" media="all" />
<script src="js/jquery-1.10.2.min.js" type="text/javascript"></script>
<script src="js/bootstrap.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/owl.carousel.js" type="text/javascript"></script>
  <script>
    $(document).ready(function() {

      var owl = $("#owl-demo");

      owl.owlCarousel({

      items :4, //10 items above 1000px browser width
      itemsDesktop : [1000,4], //5 items between 1000px and 901px
      itemsDesktopSmall : [900,3], // 3 items betweem 900px and 601px
      itemsTablet: [600,2], //2 items between 600 and 0;
      itemsMobile : false // itemsMobile disabled - inherit from itemsTablet option
      
      });

      // Custom Navigation Events
      $(".next").click(function(){
        owl.trigger('owl.next');
      })
      $(".prev").click(function(){
        owl.trigger('owl.prev');
      })

    });
    </script>
  <script type="text/javascript">
  // Login Form
	$(function() {
	    var button = $('#loginButton');
	    var box = $('#loginBox');
	    var form = $('#loginForm');
	    button.removeAttr('href');
	    button.mouseup(function(login) {
	        box.toggle();
	        button.toggleClass('active');
	    });
	    form.mouseup(function() { 
	        return false;
	    });
	    $(this).mouseup(function(login) {
	        if(!($(login.target).parent('#loginButton').length > 0)) {
	            button.removeClass('active');
	            box.hide();
	        }
	    });
	});
  </script>
</head>
<body>
   <!-- Start Header -->
       <div class="header">	
   	 	    <div class="header-top">
   	 	      <div class="wrap"> 
   	 	    	 <div class="header-top-left">
   	 	    	 	<p>Support: +0123456789</p>
   	 	    	 </div>
   				  <div class="header-top-right">
				        <ul>
				            <li><a href"#"><i class="fa fa-comments"></i>Sales Chat</a></li>
				            <li  class="login">
				              <div id="loginContainer">
				            	   <a href="#" id="loginButton"><span><i class="fa fa-lock"></i>Login</span></a>
						                <div id="loginBox" class="login-form">    
						                	<h3>Login into Your Account</h3>            
						                      <form id="loginForm" action="login" method="post">
						                                <span>
											 	    		<i><img src="images/user.png" alt="" /></i>
											 	    		 <input type="text" placeholder="Your username" name="username" required>
											 	    	</span>
						                                <span>
												 	     <i><img src="images/lock.png" alt="" /></i>
											 	         <input type="password" placeholder="........." name="password" required>
												 	    </span>
						                               <input type="submit" value="Login">
						                       </form>
						                  </div>
						             </div>
				               </li>
				               <li><a href="signup.jsp" ><i class="fa fa-sign-in"></i>Sign Up</a></li>
				         </ul>
				    </div>
			      <div class="clear"></div>
			     </div> 
		      </div>
             <div class="header-logo-nav">
             	  <div class="navbar navbar-inverse navbar-static-top nav-bg" role="navigation">
				      <div class="container">
				        <div class="navbar-header">
				          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
				            <span class="sr-only">Toggle navigation</span>
				            <span class="icon-bar"></span>
				            <span class="icon-bar"></span>
				            <span class="icon-bar"></span>
				          </button>
				         <div class="logo"> <a class="navbar-brand" href="index.jsp"><img src="images/logo.png" alt="" /></a></div>
				          <div class="clear"></div>
				        </div>
				        <div class="collapse navbar-collapse">
				          <ul class=" menu nav navbar-nav">
				            <li class="active"><a href="index.jsp">Home</a></li>
				            <li><a href="about.jsp">About</a></li>
				            <li><a href="contact.jsp">Contact Us</a></li>
				          </ul>
				        </div><!--/.nav-collapse -->
				      </div>
				    </div>
		         <div class="clear"></div>
	        </div>
	        <div class="header-banner">
	        	
			    <!-- Carousel ================================================== -->
			    <div id="myCarousel" class="carousel slide" data-ride="carousel">
			     <div class="wrap">
			      <div class="carousel-inner">
			        <div class="item active">
			           <div class="row">
				        <div class="col-md-6">
				          <div class="banner-desc">
				        	<h2>Get the right cloud for you app.</h2>
				           <ul>
				          	<li><span><i class="fa fa-chevron-right"></i>more than 12,3456 clients trust us</span></li>
				            <li><span><i class="fa fa-chevron-right"></i>24/7 support</span></li>
				            <li><span><i class="fa fa-chevron-right"></i>performance, reliability, security</span></li>
				            <li><span><i class="fa fa-chevron-right"></i>Flexible contracts</span></li>
				          </ul>
				          <div class="see-features"><a href="#">See Features</a></div>
				          </div>
				        </div>
				        <div class="col-md-6">
				        	<div class="banner-img">
			                <img src="images/devices.png" alt="First slide" />
			             </div>
				        </div>
				      </div>
			        </div>
			        
			         <div class="item">
			          <div class="row">
			          	<div class="col-md-6">
				        	<div class="banner-img">
			                <img src="images/1.jpg" alt="First slide" />
			             </div>
				        </div>
				        <div class="col-md-6">
				        	<div class="banner-desc">
				        	<h2>Get the right cloud for you app.</h2>
				          <ul>
				          	<li><span><i class="fa fa-chevron-right"></i>more than 12,3456 clients trust us</span></li>
				            <li><span><i class="fa fa-chevron-right"></i>24/7 support</span></li>
				            <li><span><i class="fa fa-chevron-right"></i>performance, reliability, security</span></li>
				            <li><span><i class="fa fa-chevron-right"></i>Flexible contracts</span></li>
				          </ul>
				          <div class="see-features"><a href="#">See Features</a></div>
				          </div>
				         </div>
				      </div>
			        </div>
			        
			        <div class="item">
			         
			          <div class="row">
			          	<div class="col-md-6">
				        	<div class="banner-img">
			                <img src="images/2.png" alt="First slide" />
			             </div>
				        </div>
				        <div class="col-md-6">
				        	<div class="banner-desc">
				        	<h2>Get the right cloud for you app.</h2>
				          <ul>
				          	<li><span><i class="fa fa-chevron-right"></i>more than 12,3456 clients trust us</span></li>
				            <li><span><i class="fa fa-chevron-right"></i>24/7 support</span></li>
				            <li><span><i class="fa fa-chevron-right"></i>performance, reliability, security</span></li>
				            <li><span><i class="fa fa-chevron-right"></i>Flexible contracts</span></li>
				          </ul>
				          <div class="see-features"><a href="#">See Features</a></div>
				          </div>
				         </div>
				      </div>
			        </div>
			        
			       </div>
			      </div>
			      <a class="left carousel-control left-arrow" href="#myCarousel" data-slide="prev"><span><i class="fa fa-chevron-left"></i></span></a>
			      <a class="right carousel-control right-arrow" href="#myCarousel" data-slide="next"><span><i class="fa fa-chevron-right"></i></span></a>
			    </div><!-- /.carousel -->
	           </div>
	          <span class="big-arrow"></span>
             </div>
   <!-- End Header -->
   
   <!-- Start Main Content -->
	 <div class="main">	 
	 	 <div class="wrap">
	 	<div class="features">
	 		<div class="row">
		        <div class="col-lg-4">
		          <img src="images/private-cloud.png" alt="" />
		          <h2>Private Cloud</h2>
		          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi faucibus augue vitae est volutpat eleifend. </p>
		          <p><a class="read-more" href="#">Read More</a></p>
		        </div><!-- /.col-lg-4 -->
		        <div class="col-lg-4">
		        <img src="images/dedicated-servers.png" alt="" />
		          <h2>Dedicated Servers</h2>
		          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi faucibus augue vitae est volutpat eleifend. </p>
		          <p><a class="read-more" href="#">Read More</a></p>
		        </div><!-- /.col-lg-4 -->
		        <div class="col-lg-4">
		          <img src="images/hybrid-cloud.png" alt="" />
		          <h2>Hybrid Cloud</h2>
		          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi faucibus augue vitae est volutpat eleifend. </p>
		          <p><a class="read-more" href="#">Read More</a></p>
		        </div><!-- /.col-lg-4 -->
		      </div>
		   </div>
		   
		   <div class="support">
		   	<div class="container-fluid">
			  <div class="row">
			   <div class="col-lg-10">
			   	<h2>24/7 Service & Support</h2>
			   	<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi faucibus augue vitae est volutpat eleifend. </p>
			   </div>
			    <div class="col-lg-2">
			      <p><a class="read-more" href="#">Live Chat</a></p>
			   </div>
			  </div>
			</div>
		   </div>
		   
		   <div class="list-performance">
		   	 <div class="row">
			   <div class="col-lg-6">
			   	<h2>What We Provide</h2>
			   	<ul>
			   		<li><i class="fa fa-check"></i>Lorem ipsum dolor sit amet, consectetur adipiscing</li>
			   		<li><i class="fa fa-check"></i>Cras bibendum ornare mauris porta aliquam</li>
			   		<li><i class="fa fa-check"></i>Maecenas quis rutrum quam</li>
			   		<li><i class="fa fa-check"></i>Suspendisse imperdiet sapien eu metus adipiscing</li>
			   		<li><i class="fa fa-check"></i>Maecenas quis rutrum quam, ut vulputate quam.</li>
			   		<li><i class="fa fa-check"></i>Mauris accumsan at leo ut fringilla. In bibendum varius nulla at ornare.</li>
			   	</ul>
			   </div>
			    <div class="col-lg-6">
			     <h2>Performance</h2>
			     <ul class="progress-bars">
			     	<li><div class="progress">
                           <div class="bar" style="width:95%;"></div>
                        </div>
                    </li>
			     	<li><div class="progress">
                           <div class="bar" style="width:97%;"></div>
                        </div></li>
			     	<li><div class="progress">
                           <div class="bar" style="width:90%;"></div>
                        </div></li>
			     	<li><div class="progress">
                           <div class="bar" style="width:88%;"></div>
                        </div></li>
			     </ul>
			   </div>
			 </div>
		   </div>
		 </div>  
		 <div class="testimonials-news">
		   <div class="clients">
		   	 <h2>what Our Clients are Saying</h2>
		   	     <div class="testimonials">
		   	      <div id="carousel-demo">
		   	      	<div class="wrap">
		                <div id="owl-demo" class="owl-carousel">		                
		                <div class="item">
		                	<img class="img-circle" src="images/clints-img.png" alt="" />
		                	<h3>Lorem ipsum</h3>
		                	<p>“Proin malesuada egestas nunc tristique aliquet.”</p>
		                </div>
		                 <div class="item">
		                	<img class="img-circle" src="images/clints-img.png" alt="" />
		                	<h3>Lorem ipsum</h3>
		                	<p>“Proin malesuada egestas nunc tristique aliquet.”</p>
		                </div>
		                 <div class="item">
		                	<img class="img-circle" src="images/clints-img.png" alt="" />
		                	<h3>Lorem ipsum</h3>
		                	<p>“Proin malesuada egestas nunc tristique aliquet.”</p>
		                </div>
		                 <div class="item">
		                	<img class="img-circle" src="images/clints-img.png" alt="" />
		                	<h3>Lorem ipsum</h3>
		                	<p>“Proin malesuada egestas nunc tristique aliquet.”</p>
		                </div>
		                 <div class="item">
		                	<img class="img-circle" src="images/clints-img.png" alt="" />
		                	<h3>Lorem ipsum</h3>
		                	<p>“Proin malesuada egestas nunc tristique aliquet.”</p>
		                </div>
		                 <div class="item">
		                	<img class="img-circle" src="images/clints-img.png" alt="" />
		                	<h3>Lorem ipsum</h3>
		                	<p>“Proin malesuada egestas nunc tristique aliquet.”</p>
		                </div>
		                 <div class="item">
		                	<img class="img-circle" src="images/clints-img.png" alt="" />
		                	<h3>Lorem ipsum</h3>
		                	<p>“Proin malesuada egestas nunc tristique aliquet.”</p>
		                </div>
		               </div>
		              </div>
		               <div class="customNavigation">
		                <a class="btn prev"><i class="fa fa-chevron-left"></i></a>
		                <a class="btn next"><i class="fa fa-chevron-right"></i></a>             
		              </div>
		         </div>
		      </div>
	       </div>
	       
	      <div class="news">
	      	<div class="wrap">
	      	  <h2>News</h2>
	      	  <div class="row">
		        <div class="col-lg-3 news-grid">
		          <img src="images/news-img.jpg" alt="" />
		          <div class="news-desc">
		          <h2>this is your last news</h2>
		          <p>Sed quis augue vitae diam condimentum mollis. Quisque bibendum, urna quis ornare accumsan, nisl justo placerat sem [...]</p>
		          <p><a class="read-more" href="#">Read More</a></p>
		            <div class="news-desc-bottom">
		            	<p class="left">Category: Something</p>
		            	<p class="right"><i class="fa fa-comment"></i> 125</p>
		               <div class="clear"></div>
		            </div>
		            <div class="image-icon"><span><i class="fa fa-align-left"></i></span></div>
		          </div>
		        </div><!-- /.col-lg-4 -->
		        <div class="col-lg-3 news-grid news-grid-middle">
		        <img src="images/news-img.jpg" alt="" />
		         <div class="news-desc">
		          <h2>this is your last news</h2>
		          <p>Sed quis augue vitae diam condimentum mollis. Quisque bibendum, urna quis ornare accumsan, nisl justo placerat sem [...]</p>
		          <p><a class="read-more" href="#">Read More</a></p>
		            <div class="news-desc-bottom">
		            	<p class="left">Category: Something</p>
		            	<p class="right"><i class="fa fa-comment"></i> 125</p>
		               <div class="clear"></div>
		            </div>
		            <div class="image-icon"><span><i class="fa fa-align-left"></i></span></div>
		          </div>
		        </div><!-- /.col-lg-4 -->
		        <div class="col-lg-3 news-grid">
		          <img src="images/news-img.jpg" alt="" />
		         <div class="news-desc">
		          <h2>this is your last news</h2>
		          <p>Sed quis augue vitae diam condimentum mollis. Quisque bibendum, urna quis ornare accumsan, nisl justo placerat sem [...]</p>
		          <p><a class="read-more" href="#">Read More</a></p>
		            <div class="news-desc-bottom">
		            	<p class="left">Category: Something</p>
		            	<p class="right"><i class="fa fa-comment"></i> 125</p>
		               <div class="clear"></div>
		            </div>
		            <div class="image-icon"><span><i class="fa fa-align-left"></i></span></div>
		          </div>
		        </div><!-- /.col-lg-4 -->
		      </div>
	      	 </div>
	      </div>
	 </div>
    </div>
   <!-- End Main Content -->
	   
  <!-- Start Footer -->
       <span class="footer-arrow"></span>
       <div class="footer">	  
       	 <div class="wrap">	      
		  <div class="row">
			   <div class="col-lg-6">
			   	<h2>About Open Cloud</h2>
			   	<p>Vivamus non elementum enim. Vestibulum fringilla placerat vestibulum. Donec consequat scelerisque lorem, quis laoreet tortor dapibus nec. Duis sodales quis odio quis pretium. Etiam auctor sollicitudin enim. Duis tempus semper sodales. </p>
			    <ul class="links">
			    	<li><a href="#">About</a> /</li>
			    	<li><a href="#">Term of Services</a> /</li>
			    	<li><a href="#">Press</a> /</li>
			    	<li><a href="#">Staff</a> /</li>
			    	<li><a href="#">News</a></li>
			    </ul> 
			   </div>
			    <div class="col-lg-6">
			     <h2>Products</h2>
			     <div class="products-list">
			     <ul>
			     	<li><a href="#"><i class="fa fa-chevron-right"></i> Private cloud  </a></li>
			     	<li><a href="#"><i class="fa fa-chevron-right"></i>  DEDICATED SERVER    </a></li>
			     	<li><a href="#"><i class="fa fa-chevron-right"></i>  Hybrid cloud</a></li>
			     	<li><a href="#"><i class="fa fa-chevron-right"></i> support </a></li>
			     </ul>
			     <ul>	                         
			       <li><a href="#"><i class="fa fa-chevron-right"></i> dedicated hosting</a></li>
                   <li><a href="#"><i class="fa fa-chevron-right"></i> email hosting </a></li>
                   <li><a href="#"><i class="fa fa-chevron-right"></i> solutions</a></li>
                   <li><a href="#"><i class="fa fa-chevron-right"></i> Knowledge Center</a></li>
			     </ul>
			     <div class="clear"></div>
			    </div>
			     <div class="subscribe">
			    	<form>
			    		<input type="text" placeholder="youremail@domain.com" />
			    		<input type="submit" value="Subscribe" />
			    	</form>
			    </div>
			   </div>
			  </div>
			 </div>
		   </div>
			 <div class="footer-bottom">
			 	<div class="wrap">
			 	<div class="copy-right">
			 		<p>open cloud Copyright 2013 all right reserved. Template by  <a href="http://w3layouts.com" target="_blank">w3layouts</a></p>
			 	</div>
			 	<div class="social-icons">
			 		<ul>
			 			<li><a href="#"><i class="fa fa-twitter"></i></a></li>
			 			<li><a href="#"><i class="fa fa-facebook"></i></a></li>
			 			<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
			 			<li><a href="#"><i class="fa fa-rss"></i></a></li>
			 			<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
			 		</ul>
			 	</div>
			 	<div class="clear"></div>
			 </div>
	       </div>
  <!-- End Footer -->
  </body>
</html>

    	
    	
            