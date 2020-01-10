<!DOCTYPE html>
<html>
<head>
<title>Secure Cloud System</title>
<!-- Custom Theme files -->
<link href="uploadcss/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<script src="uploadcss/jquery.min.js"></script>
<!-- Custom Theme files -->
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

</head>
<body>

<h1>LEAK FILE UPLOADER</h1>

<div class="upload">

		<div class="login-form">

			<form id="upload" method="post" action="checkleak" enctype="multipart/form-data">

				<div id="drop">
					<a>Upload Leak File</a>
					<input type="file" name="upl" multiple />
				</div>

				<ul>
				<!-- The file uploads will be shown here -->
				</ul>

			</form>

		</div>
			
	<!-- JavaScript Includes -->
		<script src="uploadcss/jquery.knob.js"></script>
	<!-- JavaScript Includes -->

	<!-- jQuery File Upload Dependencies -->
		<script src="uploadcss/jquery.ui.widget.js"></script>
		<script src="uploadcss/jquery.iframe-transport.js"></script>
		<script src="uploadcss/jquery.fileupload.js"></script>
	<!-- jQuery File Upload Dependencies -->
		
	<!-- Main JavaScript file -->
		<script src="uploadcss/script.js"></script>
	<!-- Main JavaScript file -->

	<div class="button">

	<div class="cancel"><a href="index.html">Cancel</a></div>
	<div class="done"><a href="#">Done</a></div>

	<div class="clear"> </div>

	</div>
	
</div>
</body>
</html>