<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User page</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
<link rel="stylesheet" type="text/css" href="css/userPage.css">

</head>
<body>

	<div class="w3-top">
		<div class="w3-bar w3-theme w3-top w3-left-align w3-large">
			<a href="#" class="w3-bar-item w3-button w3-theme-l1">Logo</a> <a
				href="MainServlet?command=logout"
				class="w3-bar-item w3-button w3-theme-l1 w3-right" id="bttLogout">Logout</a>
		</div>
	</div>

	<nav
		class="w3-sidebar w3-bar-block w3-collapse w3-large w3-theme-l5 w3-animate-left"
		id="mySidebar">
		<h4 class="w3-bar-item">
			<b>Menu</b>
		</h4>
		<button class="w3-bar-item w3-button w3-hover-black"
			id="AVAILABLEBOOKS" type="button">Show books</button>
		<button class="w3-bar-item w3-button w3-hover-black" id="PROFILE"
			type="button">Profile</button>
		<button class="w3-bar-item w3-button w3-hover-black" id="MYBOOKS"
			type="button">My books</button>
		<button class="w3-bar-item w3-button w3-hover-black" id="history"
			type="button">My books history</button>
	</nav>

	<div class="w3-main" style="margin-left: 250px">

		<div class="w3-row w3-padding-64">
			<div class="w3-twothird w3-container">
				<h1 class="w3-text-teal" id="header">User page</h1>

				<div id="info-output"></div>
				<div id="info-results">
					<img
						src="http://beloweb.ru/wp-content/uploads/2017/09/5465464654-190.jpg"
						alt="here used to be a cat" />
				</div>

			</div>
			<!-- <div class="w3-third w3-container">
				<p class="w3-border w3-padding-large w3-padding-32 w3-center">place
					for advertising</p>
				<p class="w3-border w3-padding-large w3-padding-64 w3-center">place
					for advertising</p>
			</div>-->
		</div>



		<footer id="myFooter">
			<div class="w3-container w3-theme-l2 w3-padding-32">
				<h4>Footer</h4>
			</div>

			<div class="w3-container w3-theme-l1">
				<p>
					Powered by <a href="https://www.w3schools.com/w3css/default.asp"
						target="_blank">w3.css</a>
				</p>
			</div>
		</footer>

	</div>

	<script type="text/javascript" src="js/jquery-3.0.0.min.js"></script>
	<script type="text/javascript" src="js/buttonEventsInit.js"></script>
	<script type="text/javascript" src="js/resultsPrinter.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/v/dt/dt-1.10.12/datatables.min.js"></script>
</body>
</html>