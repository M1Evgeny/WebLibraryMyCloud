	function printBooks(json) {
		$("#header").empty().append('<h1 class="w3-text-teal" id="header">Book catalog</h1>');
		$("#info-results").empty();	
		/*$("#info-results").append('<table id="testTable">');
		$("#info-results table").append('<thead>');	
		$("#info-results table thead").append('<tr>');		
		$("#info-results table tr").append('<th>Book title</th> <th>Author</th> <th>Publish year</th> <th>button</th>');	
		$("#info-results table").append('<tfoot>');	
		$("#info-results table").append('<tbody>');	*/
		var title = "Publish year";
		createTable(title);
		$.each(json, function(book, bookInfo) {
			$("#info-results table tbody").append(
					'<tr><td id="title">'+bookInfo.title +'</td><td>'+bookInfo.author +'</td><td id="year">'+bookInfo.year +'</td><td>'+'<input type="button" class="paginate_button" id="'
					+ bookInfo.id
					+ '" value="Check out" onClick = "checkoutbook(this)">'+'</td></tr>'
					);
		});
		/*
		$("#info-output").append('<table id="input_tabl">');
		$("#info-output table").append('<tbody>');	
		$("#info-output table tbody").append('<tr>');
		$("#info-output table tr").append('<th id="title"><input type="text" placeholder="title..."></th>');	
		$("#info-output table tr").append('<th id="year"><input type="text" placeholder="year  ..."></th>');*/
		
		 $("#testTable").dataTable();
	}
	
	/*
	 * $("#info-results table thead tr").append('<th><input type="text" id="_filterText0" class="_filterText"></th> <th><input type="text" id="_filterText1" class="_filterText"></th> <tb><input type="text" id="_filterText2" class="_filterText"></th> <th><input type="text" id="_filterText3" class="_filterText"></th>');
	 * '<tr class="rowa"><td class="_filterCol0">'+bookInfo.title +'</td><td class="_filterCol1">'+bookInfo.author +'</td><td class="_filterCol2">'+bookInfo.year +'</td><td>'+'<input type="button" id="'
					+ bookInfo.id
					+ '" value="Check out" onClick = "checkoutbook(this)">'+'</td></tr>'
					
					info-results table tbody
					
							$("#header").append('<table id="table">');
		$("#header table tr").append('<th id="thnaim"><input type="text" placeholder="type..."></th>');	
		$("#header table tr").append('<th id="thinv"><input type="text" placeholder="number  ..."></th>');
	 
	 *in method below i inserted ATOMIC BUTTON 
	 */ 
	
	function printUserBooks(json) {
		$("#header").empty().append('<h1 class="w3-text-teal" id="header">Book catalog</h1>');
		$("#info-results").empty();
		var date = "Return date";
		createTable(date);	
		$.each(json, function(book, bookInfo) {
			$("#info-results table tbody").append(
					'<tr><td id="title">'+bookInfo.title +'</td><td>'+bookInfo.author +'</td><td id="year">'+bookInfo.returnDate +'</td><td>'+'<input type="button" class="button color" id="'
					+ bookInfo.id
					+ '" value="Check in" onClick = "checkInBook(this)">'+'</td></tr>'
					);
		});
		$("#testTable").dataTable();
		/*
		$.each(json, function(book, bookInfo) {
			$("#info-results").append(
					bookInfo.title + " , return date:  "+ bookInfo.returnDate +"  "+ '<input type="button" id="'
							+ bookInfo.id
							+ '" value="Check in" onClick = "checkInBook(this)">'
							+ "  </br>");
		});*/
	}

	function printUserBooksHistory(json) {
		$("#header").empty().append('<h1 class="w3-text-teal" id="header">Book catalog history</h1>');
		$("#info-results").empty();
		createHistoryTable();
		$.each(json, function(book, bookInfo) {
			$("#info-results table tbody").append(
					'<tr><td id="title">'+bookInfo.title +'</td><td>'+bookInfo.author +'</td><td id="year">'+bookInfo.year +'</td></tr>'
					);
		});
		$("#testTable").dataTable();
	}

	function userProfile(json) {
		$("#header").empty().append('<h1 class="w3-text-teal" id="header">Hello, '+json.name+'</h1>');
		$("#info-results").empty();
			$("#info-results").append(
					json.name + "   " + '<input type="button" id="'
							+ json.id
							+ '" value="Edit profile" onClick = "editProfile(this)">'
							+ "  </br>");
	}

	function checkoutbook(obj) {
		var command = 'CHECKOUT';
		$.get('SignUpController',{"command" : command, "id" : obj.id},
				function(resp) {
			if(resp=true){
				$("#info-results").empty().append(
				"<h3>Book checked out successfully</h3>");
			}else{
				$("#info-results").empty().append(
				"<h3>Sorry, somethig went wrong</h3>");
			}					
				}).fail(function() {
			alert("Request failed");
		});
	}

	function checkInBook(obj) {
		var command = 'CHECKIN';
		$.get('SignUpController',{"command" : command, "id" : obj.id},
				function(resp) {
			if(resp=true){
				$("#info-results").empty().append(
				"<h3>Book checked in successfully</h3>");
			}else{
				$("#info-results").empty().append(
				"<h3>Sorry, somethig went wrong</h3>");
			}					
				}).fail(function() {
			alert("Request failed");
		});
	}
	
	
	function createTable(title){
		$("#info-results").append('<table id="testTable">');
		$("#info-results table").append('<thead>');	
		$("#info-results table thead").append('<tr>');		
		$("#info-results table tr").append('<th>Book title</th> <th>Author</th> <th>'+title+'</th> <th>Button</th>');	
		$("#info-results table").append('<tfoot>');	
		$("#info-results table").append('<tbody>');	
	}
	
	function createHistoryTable(){
		$("#info-results").append('<table id="testTable">');
		$("#info-results table").append('<thead>');	
		$("#info-results table thead").append('<tr>');		
		$("#info-results table tr").append('<th>Book title</th> <th>Author</th> <th>Publish year</th>');	
		$("#info-results table").append('<tfoot>');	
		$("#info-results table").append('<tbody>');	
	}

/*		  
	
$("#input_tabl input").on("keyup", function(){
    var filterN = $("#title input").val(),
        filterI = $("#year input").val();

    $("#testTable tr").each(function () {
        var n = $(this).find('#title').text(),
            i = $(this).find('#year').text();
        if (n.search(new RegExp(filterN,"i")) < 0 ||
            i.search(new RegExp(filterI,"i")) < 0) {
            $(this).hide();
        } else {
            $(this).show();
        }
    });
});	 */ 
