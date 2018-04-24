<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home page</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://www.w3schools.com/lib/w3-theme-black.css">
<style type="text/css">
.w3-container {
	width: 450px;
}

#signup input.error, #signup select.error {
	background: #FFA9B8;
	border: 1px solid red;
}
</style>

<script type="text/javascript" src="js/jquery-3.0.0.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script>
	$(document).ready(function() {
		$('#signup').validate({
			rules : {
				login : {
					required : true,
					rangelength : [4,16],	
					remote : {
					   type : 'GET',
						url : 'AjaxController'
					} 
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
					remote : "Login alredy taking"
				},
				password: {
					required : "Please, enter your password",
					rangelength: "Your password must be betwen 4 to 16 chars"
				}
			}
		});
	})
</script>
</head>
<body>

	<div class="w3-bar w3-border w3-theme">
		<a href="login.jsp"
			class="w3-bar-item w3-button w3-border-right w3-border-left w3-right">Log
			in</a> 
			<a href="#" class="w3-bar-item w3-button w3-border-left w3-right">Something</a>
	</div>

	<div class="w3-container w3-padding w3-display-right">

		<div class="login-page">
			<div class="form">
				<form class="register-form"></form>
			</div>
			<form name="loginForm" method="POST" action="MainServlet"
				class="login-form w3-container w3-card-4" id="signup">
				<input class="w3-input" type="hidden" name="command" value="SINGUP" />
				<input class="w3-input" type="hidden" name="ajaxCommand" value="CHECK_LOGIN" />
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
					style="width: 65%">Sign Up</button>
			</form>
		</div>
	</div>

</body>
</html>