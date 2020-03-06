$(document).ready(function(){
	
	loadTable();
	
	$("#addTransaction").click(function() {
		$("#addTxDialog").show(200);
	});
	
	$("#saveTransaction").click(function() {
		saveTransaction();
	});
	
	$("#closeNewTxBtn").click(function() {
		closeNewTxDialog();
	});
	
});

function saveTransaction() {
	var newTx = {};
	newTx["description"] = $("#txDescription").val();
	newTx["creditor"] = $("#txCreditor").val();
	newTx["debitor"] = $("#txDebtor").val();
	
	$.ajax({
		url: "/rest/transactions", 
		data: JSON.stringify(newTx),
		success: function(savedTx) {
					console.log("Saved: " + savedTx);
				    loadTable();
				 },
		type: "POST",
		contentType: "application/json; charset=utf-8",
		dataType: "json"});
}

function loadTable() {
	closeNewTxDialog();	
	$.get( "/rest/transactions", function(transactions) {
		toggleTransactions(transactions.length > 0);
		var tableBody = "";
		$.each(transactions, function(ind, transaction) {
			tableBody += "<tr><td>";
			tableBody += transaction["transactionId"];
			tableBody += "</td><td>"
			tableBody += transaction["description"];
			tableBody += "</td><td>"
			tableBody += transaction["creditor"];
			tableBody += "</td><td>"
			tableBody += transaction["debitor"];
			tableBody += "</td><td>"
			tableBody += transaction["timeStamp"];
			tableBody += "</td></tr>"
		});
		$("#transactionTableBody").html(tableBody);
	});
}

function closeNewTxDialog() {
	$("#addTxDialog input").val("");
	$("#addTxDialog").hide();
}

function toggleTransactions(isTransactionsPresent) {
	if(isTransactionsPresent) {
		$("#noTransactionsMsg").hide();
		$("#transactionsTable").show();
		$("#transactionsTitle").show();
	} else {
		$("#noTransactionsMsg").show();
		$("#transactionsTable").hide();
		$("#transactionsTitle").hide();
	}
}