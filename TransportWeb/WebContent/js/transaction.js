//Verification and Validation Compliance Tracker

function goToVerificationAndValidation() {
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "verificationAndValidation.do?"
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			window.scrollTo(0,0);
		});
}

function goToAddVerificationAndValidationRefreshDropdownList() {
	$.ajax({
		  type: "GET",
		  url: "verificationAndValidation.do?",
		  cache: false,
		  data: { command: "Add_Refresh_Dropdown_List" }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			$("#descriptionId").focus();
			window.scrollTo(0,0);
		});
}
function goToAddVerificationAndValidation() {
	$.ajax({
		  type: "GET",
		  url: "verificationAndValidation.do?",
		  cache: false,
		  data: { command: "add" }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			$("#descriptionId").focus();
			window.scrollTo(0,0);
		});
}

function getVerificationAndValidation(pageCriteria, category, isDeleted) {

	var searchCriteria = $('#searchCriteriaId').val();

	//validation if search criteria is verificationdate or validationdate
	if (searchCriteria=='406' || searchCriteria=='413') {
		var dateFrom = $('#dateFromDatePicker').val();
		var dateTo = $('#dateToDatePicker').val();
		//Date From
		if (dateFrom==null || dateFrom=='') {
			alert("Date From is required for Date search criteria.");
			window.scrollTo(0,0);
			return false;
		}
		//Date To
		if (dateTo==null || dateTo=='') {
			alert("Date To is required for Date search criteria.");
			window.scrollTo(0,0);
			return false;
		}
	}
	
	
	//validation for search criteria
	if (category == 'filter' && searchCriteria!='406' && searchCriteria != '413') {
		if ( $("#idSearchValue").val().trim() == '') {
			$("#validationMessageId").show();
			$("#idSearchValue").focus(); 
			setTimeout( "$('#validationMessageId').hide();",1500 );
			window.scrollTo(0,0);
			return false;
		}

	}

	$.ajax({
		  type: "GET",
		  url: "verificationAndValidation.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
		  cache: false,
		  data: $("#idForm").serialize() 
		})
		  .done(function( result ) {
			$("#tablePresentationDIV").html(result);
			if (isDeleted) {
				$("#msgDeletedId").show();
				setTimeout( "$('#msgDeletedId').hide();", 1500 );
			}
		});
}

function saveVerificationAndValidation() {
	
	$.ajax({
		  type: "POST",
		  url: "saveVerificationAndValidation.do?command=ajaxSave",
		  data: $("#idForm").serialize() 
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			window.scrollTo(0,0);
		});

}

function editVerificationAndValidation(id) {
	$.ajax({
		  type: "GET",
		  url: "verificationAndValidation.do?",
		  cache: false,
		  data: { command: "ajaxEdit", id: id  }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			//call the isPositive() 
			isPositiveFindings($("#findingsID").val(), true);
			window.scrollTo(0,0);
		});

}

function updateVerificationAndValidation() {
	
	bootbox.confirm("Are you sure you want to update this record?", function(ans) {
		  //Example.show("Confirm result: "+result);
		 if (ans) {
				$.ajax({
					  type: "POST",
					  url: "updateVerificationAndValidation.do?command=ajaxUpdate",
					  data: $("#idForm").serialize() 
					})
					  .done(function( result ) {
						$("#contentDIV").html(result);
						window.scrollTo(0,0);
				});
		 } 
	}); 

}

function deleteVerificationAndValidation(id, category, currentPage) {
	
	bootbox.confirm("Are you sure you want to delete this record?", function(ans) {
		  //Example.show("Confirm result: "+result);
		if (ans) {
			$.ajax({
				  type: "POST",
				  url: "deleteVerificationAndValidation.do?",
				  data: { command: "ajaxDelete", id: id  }
				})
				  .done(function( result ) {
					 //$("#contentDIV").html(result);
					getVerificationAndValidation(currentPage,category, true);//show the updated list after delete
					window.scrollTo(0,0);
				  });		
		} 
	}); 

}

//Transport Revision 1 Dec2015
function getFindingsByItem(itemId){
	
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "verificationAndValidation.do?command=ajaxPopulateFindingsByItem&itemId="+itemId
		})
		  .done(function( result ) {
			$("#findingsDIVId").html(result);
			//$("#findingsID").val(0);//default to --Select-- this code should be for Add screen only
		});	
}

function getClosureByCorrections(correctionsId){
	
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "verificationAndValidation.do?command=ajaxPopulateClosureByCorrections&correctionsId="+correctionsId
		})
		  .done(function( result ) {
			$("#closureDIVId").html(result);
		});
}

function getCorrectionsByRootCause(rootCauseId){
	
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "verificationAndValidation.do?command=ajaxPopulateCorrectionsByRootCause&rootCauseId="+rootCauseId
		})
		  .done(function( result ) {
			$("#correctionsDIVId").html(result);
		});
}

function isPositiveFindings(findingsId){
	
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "verificationAndValidation.do?command=ajaxIsPositiveFindings&findingsId="+findingsId
		})
		  .done(function( result ) {
			if (result == 'true') {
				$("#rootCauseID").prop("disabled", true);
				$("#correctionsID").prop("disabled", true);
				$("#remarksID").val(3);
			} else {
				$("#rootCauseID").prop("disabled", false);
				$("#correctionsID").prop("disabled", false);
				$("#remarksID").val(1);
			}
		});
}

//Work Permit Enhancement
function goToWorkPermit() {
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "workPermit.do?"
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			window.scrollTo(0,0);
		});
}

function goToAddWorkPermit() {
	$.ajax({
		  type: "GET",
		  url: "workPermit.do?",
		  cache: false,
		  data: { command: "add" }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			$("#permitNoId").focus();
			window.scrollTo(0,0);
		});
}

function getWorkPermit(pageCriteria, category, isDeleted) {

	var searchCriteria = $('#searchCriteriaId').val();

	//validation if search criteria is date started
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
	
	
	//validation for search criteria
	if (category == 'filter' && searchCriteria!='809' && searchCriteria!='811') {
		if ( $("#idSearchValue").val().trim() == '') {
			$("#validationMessageId").show();
			$("#idSearchValue").focus(); 
			setTimeout( "$('#validationMessageId').hide();",1500 );
			return false;
		}

	}

	$.ajax({
		  type: "GET",
		  url: "workPermit.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
		  cache: false,
		  data: $("#idForm").serialize() 
		})
		  .done(function( result ) {
			$("#tablePresentationDIV").html(result);
			if (isDeleted) {
				$("#msgDeletedId").show();
				setTimeout( "$('#msgDeletedId').hide();", 1500 );
			}
		});
}

function saveWorkPermit() {
	
	$.ajax({
		  type: "POST",
		  url: "saveWorkPermit.do?command=ajaxSave",
		  data: $("#idForm").serialize() 
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			window.scrollTo(0,0);
		});

}

function editWorkPermit(id) {
	$.ajax({
		  type: "GET",
		  url: "workPermit.do?",
		  cache: false,
		  data: { command: "ajaxEdit", id: id  }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			window.scrollTo(0,0);
		});

}

function updateWorkPermit() {
	
	bootbox.confirm("Are you sure you want to update this record?", function(ans) {
		  //Example.show("Confirm result: "+result);
		 if (ans) {
				$.ajax({
					  type: "POST",
					  url: "updateWorkPermit.do?command=ajaxUpdate",
					  data: $("#idForm").serialize() 
					})
					  .done(function( result ) {
						$("#contentDIV").html(result);
						window.scrollTo(0,0);
				});
		 } 
	}); 

}

function deleteWorkPermit(id, category, currentPage) {
	
	bootbox.confirm("Are you sure you want to delete this record?", function(ans) {
		  //Example.show("Confirm result: "+result);
		if (ans) {
			$.ajax({
				  type: "POST",
				  url: "deleteWorkPermit.do?",
				  data: { command: "ajaxDelete", id: id  }
				})
				  .done(function( result ) {
					 //$("#contentDIV").html(result);
					getWorkPermit(currentPage,category, true);//show the updated list after delete
					window.scrollTo(0,0);
				});		
		} 
	}); 

}

function selectPermitIssuer(isHide, permitIssuer) {
	if (permitIssuer==0) {
		return false;
	}
	
	if (isHide) {
		$("#permitIssuerId").css("visibility","visible");
		$("#permitIssuerId").val(permitIssuer);
		$("#permitIssuerFullNameId").hide();
		$("#editPermitIssuerLinkId").show();
	} else {
		$("#permitIssuerId").css("visibility","hidden");
		$("#permitIssuerFullNameId").show();
		$("#editPermitIssuerLinkId").hide();
		$("#permitIssuerFullNameId").focus();
	}

}

function selectLorry(isHide, value) {
	if (value==0) {
		return false;
	}
	
	if (isHide) {
		//$("#lorryAndPlateNoId").css("display","none"); or use hide() for jquery
		$("#lorryAndPlateNoId").hide();
		$("#selectLorryLabelId").hide();
		$("#plateNoId").show();
		$("#lorryNoId").show();
		$("#plateNoLabelId").show();
		$("#lorryNoLabelId").show();
		//$("#plateNoId").css('visibility','visible');
		//$("#lorryNoId").css('visibility','visible');
		//$("#plateNoLabelId").css('visibility','visible');
		//$("#lorryNoLabelId").css('visibility','visible');
		$("#editLorryLinkId").show();
		
		var lorryArr = value.split("|");
		$("#plateNoId").val(lorryArr[0]);
		$("#lorryNoId").val(lorryArr[1]);		
	} else {
		$("#lorryAndPlateNoId").show();
		$("#selectLorryLabelId").show();
		$("#plateNoId").hide();
		$("#lorryNoId").hide();
		$("#plateNoLabelId").hide();
		$("#lorryNoLabelId").hide();
		//$("#plateNoId").css('visibility','hidden');
		//$("#lorryNoId").css('visibility','hidden');
		//$("#plateNoLabelId").css('visibility','hidden');
		//$("#lorryNoLabelId").css('visibility','hidden');
		$("#editLorryLinkId").hide();
		$("#lorryAndPlateNoId").focus();
	}
	
}  
  
function addMechanic(value) {
	if ($("#mechanicId").val().trim() == '') {
		$("#mechanicId").val(value);
	} else {
		$("#mechanicId").val($("#mechanicId").val() + ",\n" + value);
	}
	
}

//Maintenance Monitoring
function goToMaintenanceMonitoring() {
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "maintenanceMonitoring.do?"
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			window.scrollTo(0,0);
		});
}

function goToAddMaintenanceMonitoring() {
	$.ajax({
		  type: "GET",
		  url: "maintenanceMonitoring.do?",
		  cache: false,
		  data: { command: "add" }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			$("#permitNoId").focus();
			window.scrollTo(0,0);
		});
}

function getMaintenanceMonitoring(isGenerateExcelFile) {
	
	//isGenerateExcelFile: Values 1 or 0: 1-Yes, 0-No

	var yearCriteria = $('#idYearCriteria').val();
	var monthCriteria = $('#idMonthCriteria').val();
	var lorryNoCriteria = $('#idLorryNoCriteria').val();

	$.ajax({
		type: "GET",
		url: "maintenanceMonitoring.do?command=ajaxSearch&yearCriteria="+yearCriteria+"&monthCriteria="+monthCriteria+"&lorryNoCriteria="+lorryNoCriteria+"&isGenerateExcelFile="+isGenerateExcelFile,
		cache: false,
		data: $("#idForm").serialize() 
	})
		.done(function( result ) {
			if (isGenerateExcelFile == '0') {
				$("#tablePresentationDIV").html(result);
			} else {
				var popUpWindow = window.open('reports/maintenancemonitoring.xls','popUpWindow','height=100,width=500,left=100,top=100,resizable=yes,scrollbars=yes,toolbar=yes,menubar=no,location=no,directories=no, status=yes');
				popUpWindow.document.title = 'Maintenance Monitoring Excel File';
				alert('File (maintenancemonitoring.xls) successfully downloaded. \nPlease check your Downloads folder.');
				setTimeout(function(){ popUpWindow.close(); }, 6000);
			}
	});
	
}

function saveMaintenanceMonitoring() {
	
	if ($('#plateNoId').val() == '') {
		alert("Please select lorry.");
		return false;
	} else {
		$.ajax({
			  type: "POST",
			  url: "saveMaintenanceMonitoring.do?command=ajaxSave",
			  data: $("#idPopupForm").serialize() 
			})
			  .done(function( result ) {
				  alert('Record successfully saved!');
				  window.scrollTo(0,0);
			});		
	}
	
}

function updateMaintenanceMonitoring(moduleInner) {
	
	$.ajax({
		  type: "POST",
		  url: "updateMaintenanceMonitoring.do?command=ajaxUpdate&moduleInner="+moduleInner,
		  data: $("#idPopupForm").serialize() 
		})
		  .done(function( result ) {
			  window.scrollTo(0,0);
			  alert('Record successfully updated!');
			  window.close();
	}); 
	
}

//Driver Training Enhancement
function goToDriverTraining() {
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "driverTraining.do?"
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			window.scrollTo(0,0);
		});
}

function goToAddDriverTraining() {
	$.ajax({
		  type: "GET",
		  url: "driverTraining.do?",
		  cache: false,
		  data: { command: "add" }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			$("#driverId").focus();
			window.scrollTo(0,0);
		});
}

function getDriverTraining(pageCriteria, category, isDeleted) {

	$.ajax({
		  type: "GET",
		  url: "driverTraining.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
		  cache: false,
		  data: $("#idForm").serialize() 
		})
		  .done(function( result ) {
			$("#tablePresentationDIV").html(result);
			if (isDeleted) {
				$("#msgDeletedId").show();
				setTimeout( "$('#msgDeletedId').hide();", 1500 );
			}
		});
}

function saveDriverTraining() {

	//var form = $("#idForm")[0];
	//var data = new FormData(form);
	
	$.ajax({
		  type: "POST",
		  url: "saveDriverTraining.do?command=ajaxSave",
		  //data: $("#idForm").serialize(),
		  data: new FormData(document.getElementById("idForm")),
          enctype: 'multipart/form-data',
          processData: false, 
          contentType: false 
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			window.scrollTo(0,0);
		});

}

function editDriverTraining(id) {
	$.ajax({
		  type: "GET",
		  url: "driverTraining.do?",
		  cache: false,
		  data: { command: "ajaxEdit", id: id  }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			window.scrollTo(0,0);
		});

}

function updateDriverTraining() {
	
	bootbox.confirm("Are you sure you want to update this record?", function(ans) {
		  //Example.show("Confirm result: "+result);
		 if (ans) {
				$.ajax({
					  type: "POST",
					  url: "updateDriverTraining.do?command=ajaxUpdate",
					  data: new FormData(document.getElementById("idForm")),
			          enctype: 'multipart/form-data',
			          processData: false, 
			          contentType: false 
					})
					  .done(function( result ) {
						$("#contentDIV").html(result);
						window.scrollTo(0,0);
				});
		 } 
	}); 

}

function deleteDriverTraining(id, category, currentPage, driverName) {
	
	bootbox.confirm("Are you sure you want to delete this record?", function(ans) {
		  //Example.show("Confirm result: "+result);
		if (ans) {
			$.ajax({
				  type: "POST",
				  url: "deleteDriverTraining.do?",
				  data: { command: "ajaxDelete", id: id  }
				})
				  .done(function( result ) {
					 //$("#contentDIV").html(result);
					getDriverTraining(currentPage,category, true, driverName);//show the updated list after delete
					window.scrollTo(0,0);
				  });		
		} 
	}); 

}

//Driver Training Info
function goToDriverTrainingInfo(driverTrainingId,driverName) {
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "driverTrainingInfo.do?",
		  data: { command: "ajaxGoTo", driverTrainingId: driverTrainingId, driverName: driverName, "innerModule": 251 }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			window.scrollTo(0,0);
		});
}

function goToAddDriverTrainingInfo(driverTrainingId,driverName) {
	$.ajax({
		  type: "GET",
		  url: "driverTrainingInfo.do?",
		  cache: false,
		  data: { command: "addInner", driverTrainingId: driverTrainingId, driverName: driverName, "innerModule": 251 }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			$("#trainingId").focus();
			window.scrollTo(0,0);
		});
}

function saveDriverTrainingInfo(driverTrainingId,driverName) {

	$.ajax({
		  type: "POST",
		  url: "saveDriverTrainingInfo.do?command=ajaxSaveInner&driverTrainingId=" + driverTrainingId + "&driverName=" + driverName + "&innerModule=251",
		  data: $("#idForm").serialize(),
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			window.scrollTo(0,0);
		});

}

function getDriverTrainingInfo(pageCriteria, category, isDeleted, driverName) {

	$.ajax({
		  type: "GET",
		  url: "driverTrainingInfo.do?command=ajaxSearchInner&page="+pageCriteria+"&category="+category+ "&innerModule=251&driverName="+driverName,
		  cache: false,
		  data: $("#idForm").serialize() 
		})
		  .done(function( result ) {
			$("#tablePresentationDIV").html(result);
			if (isDeleted) {
				$("#msgDeletedId").show();
				setTimeout( "$('#msgDeletedId').hide();", 1500 );
			}
		});
}


function editDriverTrainingInfo(id,driverName) {
	$.ajax({
		  type: "GET",
		  url: "driverTrainingInfo.do?",
		  cache: false,
		  data: { command: "ajaxEditInner", id: id , innerModule: 251 ,driverName: driverName }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			window.scrollTo(0,0);
		});

}

function updateDriverTrainingInfo() {
	
	bootbox.confirm("Are you sure you want to update this record?", function(ans) {
		  //Example.show("Confirm result: "+result);
		 if (ans) {
				$.ajax({
					  type: "POST",
					  url: "updateDriverTrainingInfo.do?command=ajaxUpdateInner&innerModule=251",
					  data: $("#idForm").serialize() 
					})
					  .done(function( result ) {
						$("#contentDIV").html(result);
						window.scrollTo(0,0);
				});
		 } 
	}); 

}

function deleteDriverTrainingInfo(id, category, currentPage, driverName) {
	
	bootbox.confirm("Are you sure you want to delete this record?", function(ans) {
		  //Example.show("Confirm result: "+result);
		if (ans) {
			$.ajax({
				  type: "POST",
				  url: "deleteDriverTrainingInfo.do?",
				  data: { command: "ajaxDeleteInner", id: id , innerModule: 251}
				})
				  .done(function( result ) {
					 //$("#contentDIV").html(result);
					getDriverTrainingInfo(currentPage,category, true, driverName);//show the updated list after delete
					window.scrollTo(0,0);
				  });		
		} 
	}); 

}

//Driver Training Profile
function goToDriverTrainingProfile(driverTrainingId,driverName) {
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "driverTrainingProfile.do?",
		  data: { command: "ajaxGoTo", driverTrainingId: driverTrainingId, driverName: driverName, "innerModule": 252 }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			window.scrollTo(0,0);
		});
}

function goToAddDriverTrainingProfile(driverTrainingId,driverName) {
	$.ajax({
		  type: "GET",
		  url: "driverTrainingProfile.do?",
		  cache: false,
		  data: { command: "addInner", driverTrainingId: driverTrainingId, driverName: driverName, "innerModule": 252 }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			$("#trainingId").focus();
			window.scrollTo(0,0);
		});
}

function saveDriverTrainingProfile(driverTrainingId,driverName) {

	$.ajax({
		  type: "POST",
		  url: "saveDriverTrainingProfile.do?command=ajaxSaveInner&driverTrainingId=" + driverTrainingId + "&driverName=" + driverName + "&innerModule=252",
		  data: $("#idForm").serialize(),
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			window.scrollTo(0,0);
		});

}

function getDriverTrainingProfile(pageCriteria, category, isDeleted, driverTrainingId, driverName) {

	$.ajax({
		  type: "GET",
		  url: "driverTrainingProfile.do?command=ajaxSearchInner&page="+pageCriteria+"&category="+category + "&driverTrainingId=" + driverTrainingId + "&innerModule=252&driverName="+driverName,
		  cache: false,
		  data: $("#idForm").serialize() 
		})
		  .done(function( result ) {
			$("#tablePresentationDIV").html(result);
			if (isDeleted) {
				$("#msgDeletedId").show();
				setTimeout( "$('#msgDeletedId').hide();", 1500 );
			}
		});
}

function editDriverTrainingProfile(id,driverName) {
	$.ajax({
		  type: "GET",
		  url: "driverTrainingProfile.do?",
		  cache: false,
		  data: { command: "ajaxEditInner", id: id , innerModule: 252 ,driverName: driverName }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			window.scrollTo(0,0);
		});

}

function updateDriverTrainingProfile() {
	
	bootbox.confirm("Are you sure you want to update this record?", function(ans) {
		  //Example.show("Confirm result: "+result);
		 if (ans) {
				$.ajax({
					  type: "POST",
					  url: "updateDriverTrainingProfile.do?command=ajaxUpdateInner&innerModule=252",
					  data: $("#idForm").serialize() 
					})
					  .done(function( result ) {
						$("#contentDIV").html(result);
						window.scrollTo(0,0);
				});
		 } 
	}); 

}

function deleteDriverTrainingProfile(id, category, currentPage, driverTrainingId, driverName) {
	
	bootbox.confirm("Are you sure you want to delete this record?", function(ans) {
		  //Example.show("Confirm result: "+result);
		if (ans) {
			$.ajax({
				  type: "POST",
				  url: "deleteDriverTrainingProfile.do?",
				  data: { command: "ajaxDeleteInner", id: id , innerModule: 252}
				})
				  .done(function( result ) {
					 //$("#contentDIV").html(result);
					getDriverTrainingProfile(currentPage,category, true, driverTrainingId, driverName);//show the updated list after delete
					window.scrollTo(0,0);
				  });		
		} 
	}); 

}

//Driver Training Profile Comments
function goToDriverTrainingProfileComments(driverTrainingId,driverTrainingProfileId,remarks,driverName,innerModule, isViewSummary) {
	
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "driverTrainingProfileComments.do?",
		  data: { command: "ajaxGoTo", driverTrainingId: driverTrainingId, driverTrainingProfileId: driverTrainingProfileId, remarks: remarks, driverName: driverName, innerModule: innerModule, isViewSummary: isViewSummary  }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			window.scrollTo(0,0);
		});
}

function goToAddDriverTrainingProfileComments(driverTrainingId,driverTrainingProfileId,remarks,driverName,innerModule) {
	
	$.ajax({
		  type: "GET",
		  url: "driverTrainingProfileComments.do?",
		  cache: false,
		  data: { command: "addInner", driverTrainingId: driverTrainingId, driverTrainingProfileId: driverTrainingProfileId, remarks: remarks, driverName: driverName, innerModule: innerModule }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			$("#trainingId").focus();
			window.scrollTo(0,0);
		});
}

function saveDriverTrainingProfileComments(driverTrainingId,driverTrainingProfileId,remarks,driverName,innerModule) {

	$.ajax({
		  type: "POST",
		  url: "saveDriverTrainingProfileComments.do?command=ajaxSaveInner&driverTrainingId=" + driverTrainingId + "&driverTrainingProfileId= " + driverTrainingProfileId + "&remarks=" + remarks + "&driverName=" + driverName + "&innerModule=" + innerModule,
		  data: $("#idForm").serialize(),
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			window.scrollTo(0,0);
		});
}

function getDriverTrainingProfileComments(pageCriteria, category, isDeleted, driverTrainingId, driverTrainingProfileId, remarks, driverName, innerModule) {

	$.ajax({
		  type: "GET",
		  url: "driverTrainingProfileComments.do?command=ajaxSearchInner&page="+pageCriteria+"&category="+category+ "&driverTrainingId="+ driverTrainingId + "&driverTrainingProfileId=" + driverTrainingProfileId + "&remarks=" + remarks+ "&driverName=" + driverName + "&innerModule=" + innerModule,
		  cache: false,
		  data: $("#idForm").serialize() 
		})
		  .done(function( result ) {
			$("#tablePresentationDIV").html(result);
			if (isDeleted) {
				$("#msgDeletedId").show();
				setTimeout( "$('#msgDeletedId').hide();", 1500 );
			}
		});
}

function editDriverTrainingProfileComments(id,driverTrainingId,driverTrainingProfileId,remarks,driverName,innerModule) {
	$.ajax({
		  type: "GET",
		  url: "driverTrainingProfileComments.do?",
		  cache: false,
		  data: { command: "ajaxEditInner", id: id , driverTrainingId: driverTrainingId ,driverTrainingProfileId: driverTrainingProfileId, remarks: remarks, driverName: driverName, innerModule: innerModule }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			window.scrollTo(0,0);
		});

}

function updateDriverTrainingProfileComments(driverTrainingId,driverTrainingProfileId,remarks,driverName,innerModule) {
	
	bootbox.confirm("Are you sure you want to update this record?", function(ans) {
		  //Example.show("Confirm result: "+result);
		 if (ans) {
				$.ajax({
					  type: "POST",
					  url: "updateDriverTrainingProfileComments.do?command=ajaxUpdateInner&driverTrainingId="+driverTrainingId+"&driverTrainingProfileId="+driverTrainingProfileId+"&remarks="+remarks+"&driverName="+driverName+"&innerModule="+innerModule,
					  data: $("#idForm").serialize() 
					})
					  .done(function( result ) {
						$("#contentDIV").html(result);
						window.scrollTo(0,0);
				});
		 } 
	}); 

}

function deleteDriverTrainingProfileComments(id, category, currentPage, driverTrainingId, driverTrainingProfileId, remarks,driverName, innerModule) {
	
	bootbox.confirm("Are you sure you want to delete this record?", function(ans) {
		  //Example.show("Confirm result: "+result);
		if (ans) {
			$.ajax({
				  type: "POST",
				  url: "deleteDriverTrainingProfileComments.do?",
				  data: { command: "ajaxDeleteInner", id: id , innerModule: innerModule}
				})
				  .done(function( result ) {
					 //$("#contentDIV").html(result);
					getDriverTrainingProfileComments(currentPage,category, true, driverTrainingId, driverTrainingProfileId, remarks,driverName, innerModule);//show the updated list after delete
					window.scrollTo(0,0);
				  });		
		} 
	}); 

}

//Driver Training Summary
function viewDriverTrainingSummary(driverTrainingId,driverName) {
			
			$.ajax({
				  type: "GET",
				  cache: false,
				  url: "driverTrainingSummary.do?",
				  data: { command: "ajaxView", driverTrainingId: driverTrainingId, driverName: driverName}
				})
				  .done(function( result ) {
					$("#contentDIV").html(result);
					window.scrollTo(0,0);
				});
}

function viewDriverTrainingSummaryForDriver(empId) {
	
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "driverTrainingSummaryForDriver.do?",
		  data: { command: "ajaxView", empId: empId}
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			window.scrollTo(0,0);
		});
}


function goToDriverTrainingProfileCommentsForDriver(driverTrainingId,driverTrainingProfileId,remarks,driverName,innerModule, isViewSummary) {
	
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "driverTrainingProfileCommentsForDriver.do?",
		  data: { command: "ajaxGoTo", driverTrainingId: driverTrainingId, driverTrainingProfileId: driverTrainingProfileId, remarks: remarks, driverName: driverName, innerModule: innerModule, isViewSummary: isViewSummary  }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			window.scrollTo(0,0);
		});
}

function goToAddDriverTrainingProfileCommentsForDriver(driverTrainingId,driverTrainingProfileId,remarks,driverName,innerModule) {
	
	$.ajax({
		  type: "GET",
		  url: "driverTrainingProfileCommentsForDriver.do?",
		  cache: false,
		  data: { command: "addInner", driverTrainingId: driverTrainingId, driverTrainingProfileId: driverTrainingProfileId, remarks: remarks, driverName: driverName, innerModule: innerModule }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			$("#trainingId").focus();
			window.scrollTo(0,0);
		});
}

function saveDriverTrainingProfileCommentsForDriver(driverTrainingId,driverTrainingProfileId,remarks,driverName,innerModule) {

	$.ajax({
		  type: "POST",
		  url: "saveDriverTrainingProfileCommentsForDriver.do?command=ajaxSaveInner&driverTrainingId=" + driverTrainingId + "&driverTrainingProfileId= " + driverTrainingProfileId + "&remarks=" + remarks + "&driverName=" + driverName + "&innerModule=" + innerModule,
		  data: $("#idForm").serialize(),
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			window.scrollTo(0,0);
		});
}

function goBackToMobileMain () {
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "driverTrainingSummaryForDriver.do?",
		  data: { command: "ajaxMobileMain"}
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});
}

//Driver Incident
function goToDriverIncident() {
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "driverIncident.do?"
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});
	
	window.scrollTo(0,0);
}

function goToAddDriverIncident() {
	$.ajax({
		  type: "GET",
		  url: "driverIncident.do?",
		  cache: false,
		  data: { command: "add" }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			window.scrollTo(0,0);
		});
}

function getDriverIncident(pageCriteria, category, isDeleted) {

	$.ajax({
		  type: "GET",
		  url: "driverIncident.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
		  cache: false,
		  data: $("#idForm").serialize() 
		})
		  .done(function( result ) {
			$("#tablePresentationDIV").html(result);
			if (isDeleted) {
				$("#msgDeletedId").show();
				setTimeout( "$('#msgDeletedId').hide();", 1500 );
			}
		});
}

function saveDriverIncident() {
	
	$.ajax({
		  type: "POST",
		  url: "saveDriverIncident.do?command=ajaxSave",
		  data: $("#idForm").serialize(),
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			window.scrollTo(0,0);
		});

}

function editDriverIncident(id) {
	$.ajax({
		  type: "GET",
		  url: "driverIncident.do?",
		  cache: false,
		  data: { command: "ajaxEdit", id: id  }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			window.scrollTo(0,0);
		});

}

function updateDriverIncident() {
	
	bootbox.confirm("Are you sure you want to update this record?", function(ans) {
		  //Example.show("Confirm result: "+result);
		 if (ans) {
				$.ajax({
					  type: "POST",
					  url: "updateDriverIncident.do?command=ajaxUpdate",
					  data: $("#idForm").serialize(),
					})
					  .done(function( result ) {
						$("#contentDIV").html(result);
						window.scrollTo(0,0);
				});
		 } 
	}); 

}

function deleteDriverIncident(id, category, currentPage) {
	
	bootbox.confirm("Are you sure you want to delete this record?", function(ans) {
		  //Example.show("Confirm result: "+result);
		if (ans) {
			$.ajax({
				  type: "POST",
				  url: "deleteDriverIncident.do?",
				  data: { command: "ajaxDelete", id: id  }
				})
				  .done(function( result ) {
					 //$("#contentDIV").html(result);
					getDriverIncident(currentPage,category, true);//show the updated list after delete
					window.scrollTo(0,0);
				});		
		} 
	}); 
}

//For Driver Incident Radio buttons
function toggleOption(option, objYes, objNo) {
	
	if (option == 1) {
		objYes.checked = true;
		objNo.checked = false;
	} else {
		objYes.checked = false;
		objNo.checked = true;
	}
}

function viewDriverIncidentReport(id) {
		
	$.ajax({
		  type: "GET",
		  url: "driverIncident.do?",
		  cache: false,
		  data: { command: "ajaxView", id: id  }
		})
		  .done(function( report ) {
			  window.open('/TransportWeb/reports/'+report,'popUpWindow','height=1700,width=1000,left=100,top=100,resizable=yes,scrollbars=yes,toolbar=yes,menubar=no,location=no,directories=no, status=yes');
		  });

}


//Maintenance Inspection
function goToMaintenanceInspection() {
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "maintenanceInspection.do?"
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			window.scrollTo(0,0);
		});
}

function goToAddMaintenanceInspection() {
	$.ajax({
		  type: "GET",
		  url: "maintenanceInspection.do?",
		  cache: false,
		  data: { command: "add" }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			//$("#permitNoId").focus();
			window.scrollTo(0,0);
		});
}

function getMaintenanceInspection(pageCriteria, category, isDeleted) {

	var searchCriteria = $('#searchCriteriaId').val();

	$.ajax({
		  type: "GET",
		  url: "maintenanceInspection.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
		  cache: false,
		  data: $("#idForm").serialize() 
		})
		  .done(function( result ) {
			$("#tablePresentationDIV").html(result);
			if (isDeleted) {
				$("#msgDeletedId").show();
				setTimeout( "$('#msgDeletedId').hide();", 1500 );
			}
		});
}

function saveMaintenanceInspection() {
	
	if ($('#lorryNoId').val()=='') {
		alert('Please select lorry no.');
		$('#lorryNoId').focus();
		return false;
	}
	
	$.ajax({
		  type: "POST",
		  url: "saveMaintenanceInspection.do?command=ajaxSave",
		  data: $("#idForm").serialize() 
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			window.scrollTo(0,0);
		});

}

function editMaintenanceInspection(id) {
	$.ajax({
		  type: "GET",
		  url: "maintenanceInspection.do?",
		  cache: false,
		  data: { command: "ajaxEdit", id: id  }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			window.scrollTo(0,0);
		});

}

function updateMaintenanceInspection() {
	
	bootbox.confirm("Are you sure you want to update this record?", function(ans) {
		  //Example.show("Confirm result: "+result);
		 if (ans) {
				$.ajax({
					  type: "POST",
					  url: "updateMaintenanceInspection.do?command=ajaxUpdate",
					  data: $("#idForm").serialize() 
					})
					  .done(function( result ) {
						$("#contentDIV").html(result);
						window.scrollTo(0,0);
				});
		 } 
	}); 

}

function deleteMaintenanceInspection(id, category, currentPage) {
	
	bootbox.confirm("Are you sure you want to delete this record?", function(ans) {
		  //Example.show("Confirm result: "+result);
		if (ans) {
			$.ajax({
				  type: "POST",
				  url: "deleteMaintenanceInspection.do?",
				  data: { command: "ajaxDelete", id: id  }
				})
				  .done(function( result ) {
					 //$("#contentDIV").html(result);
					getMaintenanceInspection(currentPage,category, true);//show the updated list after delete
					window.scrollTo(0,0);
				});		
		} 
	}); 

}

function viewMaintenanceInspectionReport(id) {
	
	$.ajax({
		  type: "GET",
		  url: "maintenanceInspection.do?",
		  cache: false,
		  data: { command: "ajaxView", id: id  }
		})
		  .done(function( report ) {
			  window.open('/TransportWeb/reports/'+report,'popUpWindow','height=1700,width=1000,left=100,top=100,resizable=yes,scrollbars=yes,toolbar=yes,menubar=no,location=no,directories=no, status=yes');
		  });

}


//Tire Management
function goToTireManagement() {
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "tireManagement.do?"
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			window.scrollTo(0,0);
		});
}

function getTireDetailsByLorryNo() {

	var lorryNo = $('#lorryNoid').val();

	$.ajax({
		  type: "GET",
		  url: "tireManagement.do?command=ajaxSearchByCriteria&lorryNo="+lorryNo,
		  cache: false,
		  data: $("#idForm").serialize() 
		})
		  .done(function( result ) {
			$("#tablePresentationDIV").html(result);
		});
}

function goToTireManagementAssign() {
	
	window.open('/TransportWeb/tireManagement.do?command=add','popUpWindow','height=550,width=500,left=100,top=100,resizable=yes,scrollbars=yes,toolbar=yes,menubar=no,location=no,directories=no, status=yes');
}

function saveTireManagementAssign() {
	
	if ($('#serialNoId').val()=='') {
		alert('Please select Tire.');
		$('#serialNoId').focus();
		return false;
	}
	
	$.ajax({
		  type: "POST",
		  url: "saveMaintenanceInspection.do?command=ajaxSave",
		  data: $("#idForm").serialize() 
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			window.scrollTo(0,0);
		});
}

