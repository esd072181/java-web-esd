//Patient Report
function goToRptPatient() {
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "rptPatient.do?"
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});
}


function getRptPatient() {
	
	$("#tablePresentationDIV").html("");//reset the status
	
	var searchCriteria = $('#searchCriteriaId').val();

	if (searchCriteria=='1506') {
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
		  url: "rptPatient.do?command=ajaxSearch",
		  cache: false,
		  data: $("#idForm").serialize() 
		})
		  .done(function( result ) {
			$("#tablePresentationDIV").html(result);
		});
}

//Medical Supply Report
function goToRptMedicalSupply() {
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "rptMedicalSupply.do?"
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});
}


function getRptMedicalSupply() {
	
	$("#tablePresentationDIV").html("");//reset the status
	
	var searchCriteria = $('#searchCriteriaId').val();

	if (searchCriteria=='1605' || searchCriteria=='1606') {
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
		  url: "rptMedicalSupply.do?command=ajaxSearch",
		  cache: false,
		  data: $("#idForm").serialize() 
		})
		  .done(function( result ) {
			$("#tablePresentationDIV").html(result);
		});
}

//Equipment Report
function goToRptEquipment() {
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "rptEquipment.do?"
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});
}


function getRptEquipment() {
	
	$("#tablePresentationDIV").html("");//reset the status
	
	var searchCriteria = $('#searchCriteriaId').val();

	$.ajax({
		  type: "GET",
		  url: "rptEquipment.do?command=ajaxSearch",
		  cache: false,
		  data: $("#idForm").serialize() 
		})
		  .done(function( result ) {
			$("#tablePresentationDIV").html(result);
		});
}

//Laboratory Examination Report
function goToRptLaboratoryExamination() {
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "rptLaboratoryExamination.do?"
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});
}


function getRptLaboratoryExamination() {
	
	$("#tablePresentationDIV").html("");//reset the status
	
	var searchCriteria = $('#searchCriteriaId').val();

	$.ajax({
		  type: "GET",
		  url: "rptLaboratoryExamination.do?command=ajaxSearch",
		  cache: false,
		  data: $("#idForm").serialize() 
		})
		  .done(function( result ) {
			$("#tablePresentationDIV").html(result);
		});
}

//Radiology Report
function goToRptRadiology() {
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "rptRadiology.do?"
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});
}


function getRptRadiology() {
	
	$("#tablePresentationDIV").html("");//reset the status
	
	var searchCriteria = $('#searchCriteriaId').val();

	$.ajax({
		  type: "GET",
		  url: "rptRadiology.do?command=ajaxSearch",
		  cache: false,
		  data: $("#idForm").serialize() 
		})
		  .done(function( result ) {
			$("#tablePresentationDIV").html(result);
		});
}

//Surgery Report
function goToRptSurgery() {
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "rptSurgery.do?"
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});
}


function getRptSurgery() {
	
	$("#tablePresentationDIV").html("");//reset the status
	
	var searchCriteria = $('#searchCriteriaId').val();

	$.ajax({
		  type: "GET",
		  url: "rptSurgery.do?command=ajaxSearch",
		  cache: false,
		  data: $("#idForm").serialize() 
		})
		  .done(function( result ) {
			$("#tablePresentationDIV").html(result);
		});
}

//AdditionalServices Report
function goToRptAdditionalServices() {
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "rptAdditionalServices.do?"
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});
}


function getRptAdditionalServices() {
	
	$("#tablePresentationDIV").html("");//reset the status
	
	var searchCriteria = $('#searchCriteriaId').val();

	$.ajax({
		  type: "GET",
		  url: "rptAdditionalServices.do?command=ajaxSearch",
		  cache: false,
		  data: $("#idForm").serialize() 
		})
		  .done(function( result ) {
			$("#tablePresentationDIV").html(result);
		});
}

//Discount Report
function goToRptDiscount() {
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "rptDiscount.do?"
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});
}


function getRptDiscount() {
	
	$("#tablePresentationDIV").html("");//reset the status
	
	var searchCriteria = $('#searchCriteriaId').val();

	$.ajax({
		  type: "GET",
		  url: "rptDiscount.do?command=ajaxSearch",
		  cache: false,
		  data: $("#idForm").serialize() 
		})
		  .done(function( result ) {
			$("#tablePresentationDIV").html(result);
		});
}

//Professional Report
function goToRptProfessional() {
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "rptProfessional.do?"
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});
}


function getRptProfessional() {
	
	$("#tablePresentationDIV").html("");//reset the status
	
	var searchCriteria = $('#searchCriteriaId').val();

	$.ajax({
		  type: "GET",
		  url: "rptProfessional.do?command=ajaxSearch",
		  cache: false,
		  data: $("#idForm").serialize() 
		})
		  .done(function( result ) {
			$("#tablePresentationDIV").html(result);
		});
}

//Room Report
function goToRptRoom() {
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "rptRoom.do?"
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});
}


function getRptRoom() {
	
	$("#tablePresentationDIV").html("");//reset the status
	
	var searchCriteria = $('#searchCriteriaId').val();

	$.ajax({
		  type: "GET",
		  url: "rptRoom.do?command=ajaxSearch",
		  cache: false,
		  data: $("#idForm").serialize() 
		})
		  .done(function( result ) {
			$("#tablePresentationDIV").html(result);
		});
}

//Employee Report
function goToRptEmployee() {
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "rptEmployee.do?"
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});
}


function getRptEmployee() {
	
	$("#tablePresentationDIV").html("");//reset the status
	
	var searchCriteria = $('#searchCriteriaId').val();

	$.ajax({
		  type: "GET",
		  url: "rptEmployee.do?command=ajaxSearch",
		  cache: false,
		  data: $("#idForm").serialize() 
		})
		  .done(function( result ) {
			$("#tablePresentationDIV").html(result);
		});
}

//Nursery Report
function goToRptNursery() {
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "rptNursery.do?"
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});
}


function getRptNursery() {
	
	$("#tablePresentationDIV").html("");//reset the status
	
	var searchCriteria = $('#searchCriteriaId').val();

	$.ajax({
		  type: "GET",
		  url: "rptNursery.do?command=ajaxSearch",
		  cache: false,
		  data: $("#idForm").serialize() 
		})
		  .done(function( result ) {
			$("#tablePresentationDIV").html(result);
		});
}

//Patient History Report
function goToRptPatientHistorySearch() {
	
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "rptPatientHistory.do?",
		  data: { command: "ajaxGoToSearch" }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});
}

function getPatientForRptPatientHistory(pageCriteria, category, isDeleted) {

	//validation for search criteria
	if (category == 'filter') {
		if ( $("#idSearchCriteria").val().trim() == '') {
			$("#validationMessageId").show();
			$("#idSearchCriteria").focus(); 
			setTimeout( "$('#validationMessageId').hide();",1500 );
			return false;
		}
	}

	$.ajax({
		  type: "GET",
		  url: "rptPatientHistory.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
		  cache: false,
		  data: $("#idForm").serialize() 
		})
		  .done(function( result ) {
			$("#tablePresentationDIV").html(result);
		});
}
	
function goToRptPatientHistory(patientSystemId) {

	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "rptPatientHistory.do?",
		  data: { command: "ajaxGoTo", 
				  patientSystemId: patientSystemId
		  		}
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});
}

function backToRptPatientHistorySearch() {
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "rptPatientHistory.do?",
		  data: { command: "ajaxGoToSearch" }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});
}
