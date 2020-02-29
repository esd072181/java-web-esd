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

//Title case for text
function convertToTitleCase(str) {
	return str.replace(/\w\S*/g, function(txt){
				return txt.charAt(0).toUpperCase() + txt.substr(1);
			});	
}

function showDateCriteria(searchCriteria) {
	//for Patient, Medical Supply
	if (searchCriteria == 1506 || searchCriteria == 1605 || searchCriteria == 1606 || searchCriteria == 2601) {
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
