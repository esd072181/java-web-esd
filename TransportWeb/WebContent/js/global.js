//Utility functions

//Press Enter for Searching
function executeSearch(event) {
	//using event.keyCode
	var key = event.keyCode;
	//alert(key); //Enter == 13 (keycode)
	if (key == 13) {
		$('#btnSearchFilter').click();
	}
}

function showDateCriteria(searchCriteria) {
	//for verification date, validation date, work permit date started and date ended
	if (searchCriteria == 406 || searchCriteria == 413 || searchCriteria == 809 || searchCriteria == 811) {
		$('#dateFromDatePicker').removeAttr("disabled");
		$('#dateToDatePicker').removeAttr("disabled");
		$('#idSearchValue').val("");
		$('#idSearchValue').attr("disabled","disabled");
		$('#dateDivId').show();
	} else {
		$('#dateFromDatePicker').val("");
		$('#dateToDatePicker').val("");
		$('#dateFromDatePicker').attr("disabled","disabled");
		$('#dateToDatePicker').attr("disabled","disabled");
		$('#idSearchValue').removeAttr("disabled");
		$('#dateDivId').hide();
	}
}

function closeWindow(){
	window.close();
}

//Change Username and Password
function goToChangeUsername() {
	
	$.ajax({
		  type: "GET",
		  url: "changeUsername.do?command=ajaxGoTo",
		  cache: false
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});
}

function goToChangeUsernameMobile() {
	
	$.ajax({
		  type: "GET",
		  url: "changeUsernameMobile.do?command=ajaxGoTo",
		  cache: false
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});
}

function checkChangeUsername() {
	
	$.ajax({
		type: "POST",
		url: "checkUsername.do?command=ajaxSearch",
		data: $("#idForm").serialize() 
		})
		.done(function( result ) {
			$("#contentDIV").html(result);
		});
}

function checkChangeUsernameMobile() {
	
	$.ajax({
		type: "POST",
		url: "checkUsernameMobile.do?command=ajaxSearch",
		data: $("#idForm").serialize() 
		})
		.done(function( result ) {
			$("#contentDIV").html(result);
		});
}

function updateChangeUsernameMobile() {
	
	bootbox.confirm("Are you sure you want to update this record?", function(ans) {
		  //Example.show("Confirm result: "+result);
		 if (ans) {
				$.ajax({
					  type: "POST",
					  url: "updateChangeUsernameMobile.do?command=ajaxUpdate",
					  data: $("#idForm").serialize() 
					})
					  .done(function( result ) {
						$("#contentDIV").html(result);
				});
		 } 
	}); 

}
function updateChangeUsername() {
	
	bootbox.confirm("Are you sure you want to update this record?", function(ans) {
		  //Example.show("Confirm result: "+result);
		 if (ans) {
				$.ajax({
					  type: "POST",
					  url: "updateChangeUsername.do?command=ajaxUpdate",
					  data: $("#idForm").serialize() 
					})
					  .done(function( result ) {
						$("#contentDIV").html(result);
				});
		 } 
	}); 

}

//Transport Revision 1
function getReminders(pageCriteria) {
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "verificationAndValidation.do?command=ajaxPopulateReminders&page="+pageCriteria
		})
		  .done(function( result ) {
			$("#tablePresentationDIV").html(result);
		});
}

function getDriverTrainingInfo2(driverId) {
	$.ajax({
		  type: "GET",
		  url: "driverTraining.do?",
		  cache: false,
		  data: { command: "ajaxView", driverId: driverId  }
		})
		  .done(function( result ) {
			$("#tablePresentationDIV").html(result);
		});

}