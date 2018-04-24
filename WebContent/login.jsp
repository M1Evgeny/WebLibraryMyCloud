<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://www.w3schools.com/lib/w3-theme-black.css">

<script type="text/javascript" src="js/jquery-3.0.0.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script>
	$(document).ready(function() {
		$('#login_form').validate({
			rules : {
				login : {
					required : true,
					rangelength : [4,16]	
				},
				password : {
					required : true,
					rangelength : [4,16]
				} 
			},
			messages: {
				login: {
					required : "Please, enter your login",
					rangelength: "Your login must be betwen 4 to 16 chars",
				},
				password: {
					required : "Please, enter your password",
					rangelength: "Your password must be betwen 4 to 16 chars"
				}
			}
		});
	})
</script>
<style>
#login_form input.error, #login_form select.error {
	background: rgbrgb(255, 0, 62);
	border: 1px solid red;
}
</style>
</head>
<body>


	<div>
		<header class=" w3-container w3-theme">

			<h1>Login</h1>
				<a href="index.jsp"
					class="w3-bar-item w3-button w3-theme w3-right"
					style="width: 35%">Home</a>
			
		</header>
		<div class="w3-container w3-padding">

			<div class="login-page">
				<div class="form">
					<form class="register-form"></form>
				</div>
				<form name="loginForm" method="POST" action="MainServlet"
					class="login-form w3-container w3-card-4" id="login_form">
					<input class="w3-input" type="hidden" name="command" value="LOGIN" />
					<h2>User name</h2>
					<p>
						<input class="w3-input" type="text" name="login"
							placeholder="username" style="width: 60%" />
					</p>
					<h2>Password</h2>
					<p>
						<input class="w3-input" type="password" name="password"
							placeholder="password" style="width: 60%" />
					</p>
					<button class="w3-button w3-section w3-theme w3-ripple"
						style="width: 55%">Login</button>
				</form>
			</div>

		</div>
	</div>
</body>
</html>