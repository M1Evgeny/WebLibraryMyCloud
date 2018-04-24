<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User overdue page</title>
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
<style>
html, body, h1, h2, h3, h4, h5, h6 {
	font-family: "Roboto", sans-serif;
}

.w3-sidebar {
	z-index: 3;
	width: 250px;
	top: 43px;
	bottom: 0;
	height: inherit;
}
.w3-main {
	width: 1250px;
	top: 43px;
	bottom: 0;
	height: 750px;
}
#overdue {
  -webkit-animation-name: colorOverdue;
  -webkit-animation-duration: 2s;
  -webkit-animation-iteration-count: infinite;
}
@-webkit-keyframes colorOverdue {
 from { background-color: rgbrgb(255, 0, 62); -webkit-box-shadow: 0 0 9px #333; }
  50% { background-color: rgb(255, 255, 81); -webkit-box-shadow: 0 0 18px #91bd09; }
  to { background-color: rgb(255, 0, 62); -webkit-box-shadow: 0 0 9px #333; }
}

</style>

</head>
<body>

	<!-- Navbar -->
	<div class="w3-top">
		<div class="w3-bar w3-theme w3-top w3-left-align w3-large">
			<a href="MainServlet?command=logout"
				class="w3-bar-item w3-button w3-theme-l1 w3-right" id="bttLogout">Logout</a>
		</div>
	</div>

	<!-- Sidebar -->
	<nav
		class="w3-sidebar w3-bar-block w3-collapse w3-large w3-theme-l5 w3-animate-left"
		id="mySidebar">
		<h4 class="w3-bar-item">
			<b>Menu</b>
		</h4>
				<button class="w3-bar-item w3-button w3-hover-black" id="AVAILABLEBOOKS"
			type="button" disabled>Show books</button>
		<button class="w3-bar-item w3-button w3-hover-black" id="PROFILE"
			type="button" disabled>Profile</button>
		<button class="w3-bar-item w3-button w3-hover-black" id="MYBOOKS" type="button" disabled>My books</button>
		<button class="w3-bar-item w3-button w3-hover-black" id="history" type="button" disabled>My books history</button>
	</nav>

	<!-- Main content: shift it to the right by 250 pixels when the sidebar is visible -->
	<div class="w3-main" style="margin-left: 250px">

		<div class="w3-row w3-padding-64">
			<div class="w3-twothird w3-container">
				<h1 class="w3-text-teal" id="header">Overdue books</h1>

				<div id="info-output">
					<table id="overdue_books">
						<thead>
							<tr>
								<th>Title</th>
								<th>Return date</th>
								<th>button</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="book" items="${catalog}">
								<tr>
									<td><c:out value="${book.title}" /></td>
									<td id="overdue"><c:out value="${book.returnDate}" /></td>
									<td><form action="MainServlet" method="GET">
											<input type="hidden" name="command" value="RETURNBOOK" />
											<input type="hidden" name="bookId" value="<c:out value="${book.id}" />" />
											 <input
												type="submit" class="button color" name="button"
												 value="Check in"/>
										</form></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

				</div>
				<div id="info-results">
					<img
						src="http://beloweb.ru/wp-content/uploads/2017/09/5465464654-190.jpg"
						alt="here used to be a cat" />
				</div>

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

	<script type="text/javascript" src="js/jquery-3.0.0.min.js"></script>
	<script type="text/javascript" src="js/buttonEventsInit.js"></script>
	<script type="text/javascript" src="js/resultsPrinter.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/v/dt/dt-1.10.12/datatables.min.js"></script>
		
		 <script>
  $(function(){
    $("#overdue_books").dataTable();
  })
  </script>
		
</body>
</html>