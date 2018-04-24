<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add book</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style type="text/css">

</style>
<script type="text/javascript" src="js/jquery-3.0.0.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script>
	$(document).ready(function() {
		$('#addBookForm').validate({
			rules : {
				title : {
					required : true,
					minlength : 4,	
				},
				author : 'required'
			}
		});
	})
</script>

<script>
$(document).ready(function() {
	$('#submit').click(function() {
		var command = 'ADDBOOKINFO';
		var title = $("#title").val();
		var author = $("#author").val();
		var year = $("#year").val();
		$.get('SignUpController',{"command":command, "title":title, "author":author, "year":year},
				function(resp) {
			if(resp==true) {
				$("#result").append("<h3>Succsess</h3>");
			} else {
				$("#result").append("<h3>Failer</h3>");
			}	
				}).fail(function() {
			alert("Request failed.");
		});
		$('#addBookForm').trigger( 'reset' )
		return false;
									});
				});
</script>
</head>
<body>

<div>
		<header class="w3-container w3-purple">
			<h1>Add book</h1>
		</header>
		<div class="w3-container w3-padding">
			<div class="addBook-page">
				<div class="form">
					<form class="addBook-form"></form>
				</div>
				<div id="result"></div>
				<form name="addBookForm" class="login-form w3-container w3-card-4" id="addBookForm">
					<input class="w3-input" type="hidden" name="command" id="ADDBOOKINFO" />
					<h2>Book title</h2>
					<p>
						<input class="w3-input" type="text" name="title" id="title"
							placeholder="book title" style="width: 60%" />
					</p>
					<h2>Author</h2>
					<p>
						<input class="w3-input" type="text" name="author" id="author"
							placeholder="author" style="width: 60%" />
					</p>
					<h2>Publish year</h2>
					<p>
						<input class="w3-input" type="text" id="year"
							placeholder="Publish year" style="width: 60%" />
					</p>
					<button class="w3-button w3-section w3-purple w3-ripple" id="submit"
						style="width: 55%">Submit</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>