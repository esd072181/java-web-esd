//Verification and Validation Report
function goToRptVerification() {
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "rptVerification.do?"
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});
}


function getRptVerification() {
	
	$("#tablePresentationDIV").html("");//reset the status
	
	var searchCriteria = $('#searchCriteriaId').val();

	//validation if search criteria is verificationdate or validationdate
	if (searchCriteria=='406' || searchCriteria=='413') {
		var dateFrom = $('#dateFromDatePicker').val();
		var dateTo = $('#dateToDatePicker').val();
		//Date From
		if (dateFrom==null || dateFrom=='') {
			alert("Date From is required for Date search criteria.");
			return false;
		}
		//Date To
		if (dateTo==null || dateTo=='') {
			alert("Date To is required for Date search criteria.");
			return false;
		}
	}
	

	$.ajax({
		  type: "GET",
		  url: "rptVerification.do?command=ajaxSearch",
		  cache: false,
		  data: $("#idForm").serialize() 
		})
		  .done(function( result ) {
			$("#tablePresentationDIV").html(result);
		});
}

//Work Permit Report
function goToRptWorkPermit() {
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "rptWorkPermit.do?"
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});
}


function getRptWorkPermit() {
	
	$("#tablePresentationDIV").html("");//reset the status
	
	var searchCriteria = $('#searchCriteriaId').val();

	//validation if search criteria is verificationdate or validationdate
	if (searchCriteria=='809' || searchCriteria=='811') {
		var dateFrom = $('#dateFromDatePicker').val();
		var dateTo = $('#dateToDatePicker').val();
		//Date From
		if (dateFrom==null || dateFrom=='') {
			alert("Date From is required for Date search criteria.");
			return false;
		}
		//Date To
		if (dateTo==null || dateTo=='') {
			alert("Date To is required for Date search criteria.");
			return false;
		}
	}
	

	$.ajax({
		  type: "GET",
		  url: "rptWorkPermit.do?command=ajaxSearch",
		  cache: false,
		  data: $("#idForm").serialize() 
		})
		  .done(function( result ) {
			$("#tablePresentationDIV").html(result);
		});
}

