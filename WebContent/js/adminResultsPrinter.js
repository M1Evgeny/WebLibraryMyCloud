	function printUsers(json) {
		$("#header").empty().append('<h1 class="w3-text-teal" id="header">Users info</h1>');
		$("#info-results").empty();
		createUserTable();
		$.each(json, function(user, userInfo) {
			$("#info-results table tbody").append('<tr><td>'+userInfo.name +'</td><td>'+'<input type="button" id="'+ userInfo.id+ '" value="info" onClick = "getdetails(this)">'+'</td></tr>');});
		$("#adminTable").dataTable();
	};

	function printBooks(json) {
		$("#header").empty().append('<h1 class="w3-text-teal" id="header">Book catalog</h1>');
		$("#info-results").empty();
		createBookCatalogTable();
		$.each(json, function(book, bookInfo) {
			$("#info-results table tbody").append('<tr><td>'+bookInfo.title +'</td><td>'+'<input type="button" id="'+ bookInfo.id+ '" value="info" onClick = "getbook(this)">'+'</td></tr>');
			});
		$("#adminTable").dataTable();
	};	

	function printReport(json) {
		$("#header").empty().append('<h1 class="w3-text-teal" id="header">Overdue Books</h1>');
		$("#info-results").empty();
		createOverdueCatalogTable()
		$.each(json, function(report, reportInfo) {
			$("#info-results table tbody").append('<tr><td>'+reportInfo.bookTitle +'</td><td id="overdue">'+ reportInfo.bookReturnDate +'</td> <td>'+reportInfo.userLogin+'</td></tr>');
		});
		$("#adminTable").dataTable();
	};

	function getdetails(obj) {
		var command = 'INFOUSER';
		$.get('SignUpController',{"command" : command,"id" : obj.id},
				function(resp) {
					$("#info-results").empty().append(
							"<h3>User info</h3>" + "  </br>" + "User name: "
									+ resp.name + ", password: "
									+ resp.password);		
				}).fail(function() {
			alert("Request failed.");
		});
	}

	function getbook(obj) {
		var command = 'INFOBOOK';
		$.get('SignUpController',{"command" : command,"id" : obj.id},
				function(resp) {
					$("#info-results").empty().append(
							"<h3>Book info</h3>" + "  </br>" + "Book title: "
									+ resp.title + ", author: " + resp.author
									+ ", publish year: " + resp.year +"    "+ '<input type="button" id="'
									+ resp.id
									+ '" value="delete" onClick = "deletebook(this)">'+" "+'<input type="button" id="'
									+ resp.id
									+ '" value="update" onClick = "updatebook(this)">'+" "+"</br>");
				}).fail(function() {
			alert("Request failed.");
		});
	}

	function updatebook(obj) {
		var command = 'UPDATEBOOK';
		$.get('SignUpController',{"command" : command,"id" : obj.id},
				function(resp) {
					$("#info-results").empty().append(
							'<div id="bookId" value="'+obj.id+'"></div>'+"</br>" + '<div id="updatebook"></div>');
					$("#updatebook").empty().load("updateBook.jsp");
				}).fail(function() {
			alert("Request failed.");
		});
	}

	function deletebook(obj) {
		var command = 'deletebook';
		$.get('SignUpController',{"command" : command,"id" : obj.id},
				function(resp) {
			if(resp==true){
				$("#info-results").empty().append(
				"<h3>Book deleted</h3>");	
			}else{
				$("#info-results").empty().append(
				"<h3>Somethig went wrong</h3>");
			}
						
				}).fail(function() {
			alert("Request failed.");
		});
	}

	function createUserTable(){
		$("#info-results").append('<table id="adminTable">');
		$("#info-results table").append('<thead>');	
		$("#info-results table thead").append('<tr>');		
		$("#info-results table tr").append('<th>Login</th> <th>Get details</th>');	
		$("#info-results table").append('<tfoot>');	
		$("#info-results table").append('<tbody>');	
	}

	function createBookCatalogTable(){
		$("#info-results").append('<table id="adminTable">');
		$("#info-results table").append('<thead>');	
		$("#info-results table thead").append('<tr>');		
		$("#info-results table tr").append('<th>Title</th> <th>Book info</th>');	
		$("#info-results table").append('<tfoot>');	
		$("#info-results table").append('<tbody>');	
	}
	
	function createOverdueCatalogTable(){
		$("#info-results").append('<table id="adminTable">');
		$("#info-results table").append('<thead>');	
		$("#info-results table thead").append('<tr>');		
		$("#info-results table tr").append('<th>Title</th> <th>Return date</th> <th>User login</th>');	
		$("#info-results table").append('<tfoot>');	
		$("#info-results table").append('<tbody>');	
	}