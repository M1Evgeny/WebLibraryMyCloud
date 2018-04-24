	$(document).ready(function() {
		$("button").click(function(event) {
			var buttonID = event.target.id;
			$.get('SignUpController', {
				"command" : buttonID
			}, function(resp) {
				if (buttonID == "USERS")
					printUsers(resp);
				else if (buttonID == "BOOKS")
					printBooks(resp);				
			}).fail(function() {
				alert("Request failed.");
			});
		});
	});

	$(document).ready(function() {
		$("button").click(function(event) {
			var buttonID = event.target.id;
			$.get('SignUpController', {
				"command" : buttonID
			}, function(resp) {
				if (buttonID == "OVERDUE")
					printReport(resp);			
			}).fail(function() {
				alert("Request failed.");
			});
		});
	});
	
	$(document).ready(function() {
		$('#ADDBOOK').click(function() {
			var command = 'ADDBOOK';
			$.get('SignUpController',{"command" : command},
					function(resp) {
				$("#info-results").empty().load(resp);	
					}).fail(function() {
				alert("Request failed.");
			});
										});
					});