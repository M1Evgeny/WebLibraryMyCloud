	$(document).ready(function() {
		$("button").click(function(event) {
			var buttonID = event.target.id;
			$.get('SignUpController', {
				"command" : buttonID
			}, function(resp) {
				if (buttonID == "PROFILE")
					userProfile(resp);
				else if (buttonID == "AVAILABLEBOOKS")
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
				if (buttonID == "MYBOOKS")
					printUserBooks(resp);	
				else if(buttonID == "history")
					printUserBooksHistory(resp);
			}).fail(function() {
				alert("Request failed.");
			});
		});
	});
