<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin page</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/adminPage.css">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">

<script type="text/javascript" src="js/jquery-3.0.0.min.js"></script>
<script type="text/javascript" src="js/adminResultsPrinter.js"></script>
<script type="text/javascript" src="js/adminButtonEventsInit.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/v/dt/dt-1.10.12/datatables.min.js"></script>
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
		<button class="w3-bar-item w3-button w3-hover-black" id="USERS"
			type="button">Show users</button>
		<button class="w3-bar-item w3-button w3-hover-black" id="BOOKS"
			type="button">Show books</button>
		<button class="w3-bar-item w3-button w3-hover-black" id="ADDBOOK"
			type="button">Add book</button>
		<button class="w3-bar-item w3-button w3-hover-black" id="OVERDUE"
			type="button">Overdue book</button>
	</nav>

	<div class="w3-main" style="margin-left: 250px">

		<div class="w3-row w3-padding-64">
			<div class="w3-twothird w3-container">
				<h1 class="w3-text-teal">Heading</h1>

				<div id="info-results"></div>

			</div>
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
</body>
</html>