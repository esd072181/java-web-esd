//Patient Registration
   function goToAddPatient() {
		$.ajax({
			  type: "GET",
			  url: "patientRegistration.do?",
			  cache: false,
			  data: { command: "ajaxAdd" }
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
				$("#descriptionId").focus();
			});
	}

	function savePatient() {

		if ($("#lastNameId").val()!=null) {
			$("#lastNameId").val(convertToTitleCase($("#lastNameId").val()));
		}
		if ($("#firstNameId").val()!=null) {
			$("#firstNameId").val(convertToTitleCase($("#firstNameId").val()));
		}
		if ($("#middleNameId").val()!=null) {
			$("#middleNameId").val(convertToTitleCase($("#middleNameId").val()));
		}
		if ($("#addressId").val()!=null) {
			$("#addressId").val(convertToTitleCase($("#addressId").val()));
		}
		if ($("#contactPersonId").val()!=null) {
			$("#contactPersonId").val(convertToTitleCase($("#contactPersonId").val()));
		}
		
		$.ajax({
			  type: "POST",
			  url: "savePatient.do?command=ajaxSave",
			  data: $("#idForm").serialize() 
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});

	}
	
	function cancelPatientRegistration() {
		
		bootbox.confirm("Are you sure you want to cancel Patient Registration?", function(ans) {
			  //Example.show("Confirm result: "+result);
			 if (ans) {
				 goToMainByAjax();
			 } 
		}); 
	}
	
	//Admission
	function goToAdmissionSearch() {
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "admission.do?",
			  data: { command: "ajaxGoToSearch" }
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});
	}
	
	function getPatientForAdmission(pageCriteria, category, isDeleted) {

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
			  url: "admission.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
			  cache: false,
			  data: $("#idForm").serialize() 
			})
			  .done(function( result ) {
				$("#tablePresentationDIV").html(result);
			});
	}
		
	function goToAdmission(patientSystemId) {
				
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "admission.do?",
			  data: { command: "ajaxGoTo", 
				  patientSystemId: patientSystemId
			  		}
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});
	}

	function saveAdmission() {
		
				 $.ajax({
					  type: "POST",
					  url: "saveAdmission.do?command=ajaxSave",
					  data: $("#idForm").serialize() 
					})
					  .done(function( result ) {
						$("#contentDIV").html(result);
					});
	}
	
	function cancelAdmission() {
		
		bootbox.confirm("Are you sure you want to cancel Admission?", function(ans) {
			  //Example.show("Confirm result: "+result);
			 if (ans) {
					$.ajax({
						  type: "GET",
						  cache: false,
						  url: "admission.do?",
						  data: { command: "ajaxGoToSearch" }
						})
						  .done(function( result ) {
							$("#contentDIV").html(result);
						});
			 } 
		}); 
	}

	function closeAdmission() {
		 goToMainByAjax();
	}
	
	function backToAdmissionSearch() {
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "admission.do?",
			  data: { command: "ajaxGoToSearch" }
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});
	}
	
	//MonitorPatient
	function goToMonitorPatientSearch() {
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "monitorPatient.do?",
			  data: { command: "ajaxGoToSearch" }
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});
	}
	
	function getPatientForMonitorPatient(pageCriteria, category, isDeleted) {

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
			  url: "monitorPatient.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
			  cache: false,
			  data: $("#idForm").serialize() 
			})
			  .done(function( result ) {
				$("#tablePresentationDIV").html(result);
			});
	}
	
	
	function goToMonitorPatient(patientCaseSystemId) {
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "monitorPatient.do?",
			  data: { command: "ajaxGoTo", 
				  	  patientCaseSystemId: patientCaseSystemId
			  		}
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});
	}
	
	function backToMonitorPatientSearch() {
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "monitorPatient.do?",
			  data: { command: "ajaxGoToSearch" }
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});
	}
	
	//Diagnosis
	function goToDiagnosis(patientSystemCaseId) {
				
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "diagnosis.do?",
			  data: { command: "ajaxGoToChild", 
				  		patientSystemCaseId: patientSystemCaseId
			  		}
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
			});
	}
	
	function saveDiagnosis() {
		
		$.ajax({
			  type: "POST",
			  url: "saveDiagnosis.do?command=ajaxSave",
			  data: $("#idFormChild").serialize() 
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
			});

	}
	
	function closeDiagnosis() {
		$("#childDIV").html("");
	}

	//Medication Statement
	function goToMedicationStatement(patientSystemCaseId) {
				
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "medicationStatement.do?",
			  data: { command: "ajaxGoToChild", 
				  		patientSystemCaseId: patientSystemCaseId
			  		}
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
			});
	}
	
	function saveMedicationStatement() {
		
		$.ajax({
			  type: "POST",
			  url: "saveMedicationStatement.do?command=ajaxSave",
			  data: $("#idFormChild").serialize() 
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
			});

	}
	
	function closeMedicationStatement() {
		$("#childDIV").html("");
	}

	//Prognosis
	function goToPrognosis(patientSystemCaseId) {
				
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "prognosis.do?",
			  data: { command: "ajaxGoToChild", 
				  		patientSystemCaseId: patientSystemCaseId
			  		}
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
			});
	}
	
	function savePrognosis() {
		
		$.ajax({
			  type: "POST",
			  url: "savePrognosis.do?command=ajaxSave",
			  data: $("#idFormChild").serialize() 
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
			});

	}
	
	function closePrognosis() {
		$("#childDIV").html("");
	}
	
	//Monitor Laboratory Examination
	function goToMonitorLaboratoryExamination(patientCaseSystemId,isDeleted) {
				
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "monitorLaboratoryExamination.do?",
			  data: { command: "ajaxGoToChild", 
				      patientCaseSystemId: patientCaseSystemId
			  		}
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
				if (isDeleted) {
					$("#msgId").show();
					setTimeout( "$('#msgId').hide();", 1500 );
				}
			});
	}
	
	
	function goToMonitorLaboratoryExaminationSearch(patientCaseSystemId) {
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "monitorLaboratoryExamination.do?",
			  data: { command: "ajaxGoToChildSearch", 
				  	  patientCaseSystemId: patientCaseSystemId
			  		}
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
			});
	}
	
	function getLabExamForMonitorPatient(pageCriteria, category, patientCaseSystemId) {
		
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
			  url: "monitorLaboratoryExamination.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
			  cache: false,
			  data: $("#idForm").serialize() 
			})
			  .done(function( result ) {
				$("#tablePresentationDIV").html(result);
			});
	}
	
	function goToMonitorLaboratoryExaminationAdd(laboratoryexaminationid, patientCaseSystemId) {
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "monitorLaboratoryExamination.do?",
			  data: { command: "ajaxAdd", 
				  	  laboratoryexaminationid: laboratoryexaminationid,
				  	  patientCaseSystemId: patientCaseSystemId
			  		}
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
			});
	}
	
	
	function saveMonitorLaboratoryExamination() {
		
		$.ajax({
			  type: "POST",
			  url: "saveMonitorLaboratoryExamination.do?command=ajaxSave",
			  data: $("#idFormChild").serialize() 
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
				$("#msgId").show();
				setTimeout( "$('#msgId').hide();", 1500 );
			});

	}
	
	function cancelMonitorLaboratoryExamination(patientCaseSystemId) {
		goToMonitorLaboratoryExamination(patientCaseSystemId);
	}
	
	function editMonitorLaboratoryExamination(id) {
		
		$.ajax({
			  type: "GET",
			  url: "monitorLaboratoryExamination.do?",
			  cache: false,
			  data: { command: "ajaxEdit", id: id  }
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
			});

	}
	
	function updateMonitorLaboratoryExamination() {
		
		bootbox.confirm("Are you sure you want to update this record?", function(ans) {
			  //Example.show("Confirm result: "+result);
			 if (ans) {
					$.ajax({
						  type: "POST",
						  url: "updateMonitorLaboratoryExamination.do?command=ajaxUpdate",
						  data: $("#idFormChild").serialize() 
						})
						  .done(function( result ) {
							  $("#childDIV").html(result);
							  $("#msgId").show();
							  setTimeout( "$('#msgId').hide();", 1500 );
						  });
			 } 
		}); 

	}
	
	function deleteMonitorLaboratoryExamination(id, patientCaseSystemId) {
		
		
		bootbox.confirm("Are you sure you want to remove this record?", function(ans) {
			  //Example.show("Confirm result: "+result);
			if (ans) {
				$.ajax({
					  type: "GET",
					  cache: false,
					  url: "monitorLaboratoryExamination.do?",
					  data: { command: "ajaxDelete", 
						  	  id: id
					  		}
					})
					  .done(function( result ) {
						  goToMonitorLaboratoryExamination(patientCaseSystemId, true);
					});	
			} 
		}); 
		
	}
	
	//Monitor Medical Supply
	function goToMonitorMedicalSupply(patientCaseSystemId,isDeleted) {
				
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "monitorMedicalSupply.do?",
			  data: { command: "ajaxGoToChild", 
				      patientCaseSystemId: patientCaseSystemId
			  		}
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
				if (isDeleted) {
					$("#msgId").show();
					setTimeout( "$('#msgId').hide();", 1500 );	
				}
			});
	}
	
	
	function goToMonitorMedicalSupplySearch(patientCaseSystemId) {
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "monitorMedicalSupply.do?",
			  data: { command: "ajaxGoToChildSearch", 
				  	  patientCaseSystemId: patientCaseSystemId
			  		}
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
			});
	}
	
	function getMedicalSupplyForMonitorPatient(pageCriteria, category, patientCaseSystemId) {
		
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
			  url: "monitorMedicalSupply.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
			  cache: false,
			  data: $("#idForm").serialize() 
			})
			  .done(function( result ) {
				$("#tablePresentationDIV").html(result);
			});
	}
	
	function goToMonitorMedicalSupplyAdd(medicalSupplyId, patientCaseSystemId) {
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "monitorMedicalSupply.do?",
			  data: { command: "ajaxAdd", 
				      medicalSupplyId: medicalSupplyId,
				  	  patientCaseSystemId: patientCaseSystemId
			  		}
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
			});
	}
	
	
	function saveMonitorMedicalSupply() {
		
		$.ajax({
			  type: "POST",
			  url: "saveMonitorMedicalSupply.do?command=ajaxSave",
			  data: $("#idFormChild").serialize() 
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
				  $("#msgId").show();
				  setTimeout( "$('#msgId').hide();", 1500 );
			});

	}
	
	function editMonitorMedicalSupply(id) {
		
		$.ajax({
			  type: "GET",
			  url: "monitorMedicalSupply.do?",
			  cache: false,
			  data: { command: "ajaxEdit", id: id  }
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
			});

	}
	
	function updateMonitorMedicalSupply() {
		
		bootbox.confirm("Are you sure you want to update this record?", function(ans) {
			  //Example.show("Confirm result: "+result);
			 if (ans) {
					$.ajax({
						  type: "POST",
						  url: "updateMonitorMedicalSupply.do?command=ajaxUpdate",
						  data: $("#idFormChild").serialize() 
						})
						  .done(function( result ) {
							  $("#childDIV").html(result);
							  $("#msgId").show();
							  setTimeout( "$('#msgId').hide();", 1500 );
					});
			 } 
		}); 

	}
	
	
	function cancelMonitorMedicalSupply(patientCaseSystemId) {
		goToMonitorMedicalSupply(patientCaseSystemId);
	}
	
	function deleteMonitorMedicalSupply(id, patientCaseSystemId) {
		
		bootbox.confirm("Are you sure you want to remove this record?", function(ans) {
			
			if (ans) {
				$.ajax({
					  type: "GET",
					  cache: false,
					  url: "monitorMedicalSupply.do?",
					  data: { command: "ajaxDelete", 
						  	  id: id
					  		}
					})
					  .done(function( result ) {
						  goToMonitorMedicalSupply(patientCaseSystemId, true);
					});
			}
		});
				

	}
	
	//Monitor Radiology
	function goToMonitorRadiology(patientCaseSystemId, isDeleted) {
				
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "monitorRadiology.do?",
			  data: { command: "ajaxGoToChild", 
				      patientCaseSystemId: patientCaseSystemId
			  		}
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
				if (isDeleted){
					$("#msgId").show();
					setTimeout( "$('#msgId').hide();", 1500 );	
				} 
			});
	}
	
	
	function goToMonitorRadiologySearch(patientCaseSystemId) {
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "monitorRadiology.do?",
			  data: { command: "ajaxGoToChildSearch", 
				  	  patientCaseSystemId: patientCaseSystemId
			  		}
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
			});
	}
	
	function getRadiologyForMonitorPatient(pageCriteria, category, patientCaseSystemId) {
		
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
			  url: "monitorRadiology.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
			  cache: false,
			  data: $("#idForm").serialize() 
			})
			  .done(function( result ) {
				$("#tablePresentationDIV").html(result);
			});
	}
	
	function goToMonitorRadiologyAdd(radiologyId, patientCaseSystemId) {
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "monitorRadiology.do?",
			  data: { command: "ajaxAdd", 
				      radiologyId: radiologyId,
				  	  patientCaseSystemId: patientCaseSystemId
			  		}
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
			});
	}
	
	
	function saveMonitorRadiology() {
		
		$.ajax({
			  type: "POST",
			  url: "saveMonitorRadiology.do?command=ajaxSave",
			  data: $("#idFormChild").serialize() 
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
				$("#msgId").show();
				setTimeout( "$('#msgId').hide();", 1500 );	
			});

	}
	
	function editMonitorRadiology(id) {
		
		$.ajax({
			  type: "GET",
			  url: "monitorRadiology.do?",
			  cache: false,
			  data: { command: "ajaxEdit", id: id  }
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
			});

	}
	
	function updateMonitorRadiology() {
		
		bootbox.confirm("Are you sure you want to update this record?", function(ans) {
			  //Example.show("Confirm result: "+result);
			 if (ans) {
					$.ajax({
						  type: "POST",
						  url: "updateMonitorRadiology.do?command=ajaxUpdate",
						  data: $("#idFormChild").serialize() 
						})
						  .done(function( result ) {
							  $("#childDIV").html(result);//solution
								$("#msgId").show();
								setTimeout( "$('#msgId').hide();", 1500 );	
						  });
			 } 
		}); 

	}

	function cancelMonitorRadiology(patientCaseSystemId) {
		goToMonitorRadiology(patientCaseSystemId);
	}
	
	function deleteMonitorRadiology(id, patientCaseSystemId) {
				
		bootbox.confirm("Are you sure you want to remove this record?", function(ans) {
			if (ans) {
				$.ajax({
					  type: "GET",
					  cache: false,
					  url: "monitorRadiology.do?",
					  data: { command: "ajaxDelete", 
						  	  id: id
					  		}
					})
					  .done(function( result ) {
						  goToMonitorRadiology(patientCaseSystemId,true);
					});		
			}
			
		});
		
	}
	
	//Monitor Surgery
	function goToMonitorSurgery(patientCaseSystemId,isDeleted) {
				
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "monitorSurgery.do?",
			  data: { command: "ajaxGoToChild", 
				      patientCaseSystemId: patientCaseSystemId
			  		}
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
				if (isDeleted) {
					$("#msgId").show();
					setTimeout( "$('#msgId').hide();", 1500 );	
				}
			});
	}
	
	
	function goToMonitorSurgerySearch(patientCaseSystemId) {
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "monitorSurgery.do?",
			  data: { command: "ajaxGoToChildSearch", 
				  	  patientCaseSystemId: patientCaseSystemId
			  		}
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
			});
	}
	
	function getSurgeryForMonitorPatient(pageCriteria, category, patientCaseSystemId) {
		
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
			  url: "monitorSurgery.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
			  cache: false,
			  data: $("#idForm").serialize() 
			})
			  .done(function( result ) {
				$("#tablePresentationDIV").html(result);
			});
	}
	
	function goToMonitorSurgeryAdd(surgeryId, patientCaseSystemId) {
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "monitorSurgery.do?",
			  data: { command: "ajaxAdd", 
				      surgeryId: surgeryId,
				  	  patientCaseSystemId: patientCaseSystemId
			  		}
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
			});
	}
	
	
	function saveMonitorSurgery() {
		
		$.ajax({
			  type: "POST",
			  url: "saveMonitorSurgery.do?command=ajaxSave",
			  data: $("#idFormChild").serialize() 
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
				$("#msgId").show();
				setTimeout( "$('#msgId').hide();", 1500 );	
			});

	}
	
	function cancelMonitorSurgery(patientCaseSystemId) {
		goToMonitorSurgery(patientCaseSystemId);
	}

	function editMonitorSurgery(id) {
		
		$.ajax({
			  type: "GET",
			  url: "monitorSurgery.do?",
			  cache: false,
			  data: { command: "ajaxEdit", id: id  }
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
			});

	}
	
	function updateMonitorSurgery() {
		
		bootbox.confirm("Are you sure you want to update this record?", function(ans) {
			  //Example.show("Confirm result: "+result);
			 if (ans) {
					$.ajax({
						  type: "POST",
						  url: "updateMonitorSurgery.do?command=ajaxUpdate",
						  data: $("#idFormChild").serialize() 
						})
						  .done(function( result ) {
							  $("#childDIV").html(result);//solution
								$("#msgId").show();
								setTimeout( "$('#msgId').hide();", 1500 );	
						  });
			 } 
		}); 

	}

	function deleteMonitorSurgery(id, patientCaseSystemId) {
		
		bootbox.confirm("Are you sure you want to update this record?", function(ans) {
			
			if (ans) {
				$.ajax({
					  type: "GET",
					  cache: false,
					  url: "monitorSurgery.do?",
					  data: { command: "ajaxDelete", 
						  	  id: id
					  		}
					})
					  .done(function( result ) {
						  goToMonitorSurgery(patientCaseSystemId,true);
					});
			}
			
		});
				

	}

	//Monitor Additional Services
	function goToMonitorAdditionalServices(patientCaseSystemId,isDeleted) {
				
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "monitorAdditionalServices.do?",
			  data: { command: "ajaxGoToChild", 
				      patientCaseSystemId: patientCaseSystemId
			  		}
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
				if (isDeleted) {
					$("#msgId").show();
					setTimeout( "$('#msgId').hide();", 1500 );	
				}
			});
	}
	
	
	function goToMonitorAdditionalServicesSearch(patientCaseSystemId) {
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "monitorAdditionalServices.do?",
			  data: { command: "ajaxGoToChildSearch", 
				  	  patientCaseSystemId: patientCaseSystemId
			  		}
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
			});
	}
	
	function getAdditionalServicesForMonitorPatient(pageCriteria, category, patientCaseSystemId) {
		
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
			  url: "monitorAdditionalServices.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
			  cache: false,
			  data: $("#idForm").serialize() 
			})
			  .done(function( result ) {
				$("#tablePresentationDIV").html(result);
			});
	}
	
	function goToMonitorAdditionalServicesAdd(additionalServicesId, patientCaseSystemId) {
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "monitorAdditionalServices.do?",
			  data: { command: "ajaxAdd", 
				      additionalServicesId: additionalServicesId,
				  	  patientCaseSystemId: patientCaseSystemId
			  		}
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
			});
	}
	
	
	function saveMonitorAdditionalServices() {
		
		$.ajax({
			  type: "POST",
			  url: "saveMonitorAdditionalServices.do?command=ajaxSave",
			  data: $("#idFormChild").serialize() 
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
				$("#msgId").show();
				setTimeout( "$('#msgId').hide();", 1500 );	
			});

	}

	function editMonitorAdditionalServices(id) {
		
		$.ajax({
			  type: "GET",
			  url: "monitorAdditionalServices.do?",
			  cache: false,
			  data: { command: "ajaxEdit", id: id  }
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
			});

	}
	
	function updateMonitorAdditionalServices() {
		
		bootbox.confirm("Are you sure you want to update this record?", function(ans) {
			  //Example.show("Confirm result: "+result);
			 if (ans) {
					$.ajax({
						  type: "POST",
						  url: "updateMonitorAdditionalServices.do?command=ajaxUpdate",
						  data: $("#idFormChild").serialize() 
						})
						  .done(function( result ) {
							  $("#childDIV").html(result);//solution
								$("#msgId").show();
								setTimeout( "$('#msgId').hide();", 1500 );	
						  });
			 } 
		}); 

	}
	
	function cancelMonitorAdditionalServices(patientCaseSystemId) {
		goToMonitorAdditionalServices(patientCaseSystemId);
	}
	
	function deleteMonitorAdditionalServices(id, patientCaseSystemId) {
		
		bootbox.confirm("Are you sure you want to remove this record?", function(ans) {
			
			if (ans) {
				$.ajax({
					  type: "GET",
					  cache: false,
					  url: "monitorAdditionalServices.do?",
					  data: { command: "ajaxDelete", 
						  	  id: id
					  		}
					})
					  .done(function( result ) {
						  goToMonitorAdditionalServices(patientCaseSystemId,true);
					});
			}
			
		});
		

	}

	
	//Monitor Equipment
	function goToMonitorEquipment(patientCaseSystemId,isDeleted) {
				
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "monitorEquipment.do?",
			  data: { command: "ajaxGoToChild", 
				      patientCaseSystemId: patientCaseSystemId
			  		}
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
				if (isDeleted) {
					$("#msgId").show();
					setTimeout( "$('#msgId').hide();", 1500 );	
				}
			});
	}
	
	
	function goToMonitorEquipmentSearch(patientCaseSystemId) {
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "monitorEquipment.do?",
			  data: { command: "ajaxGoToChildSearch", 
				  	  patientCaseSystemId: patientCaseSystemId
			  		}
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
			});
	}
	
	function getEquipmentForMonitorPatient(pageCriteria, category, patientCaseSystemId) {
		
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
			  url: "monitorEquipment.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
			  cache: false,
			  data: $("#idForm").serialize() 
			})
			  .done(function( result ) {
				$("#tablePresentationDIV").html(result);
			});
	}
	
	function goToMonitorEquipmentAdd(equipmentId, patientCaseSystemId) {
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "monitorEquipment.do?",
			  data: { command: "ajaxAdd", 
				      equipmentId: equipmentId,
				  	  patientCaseSystemId: patientCaseSystemId
			  		}
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
			});
	}
	
	
	function saveMonitorEquipment() {
		
		$.ajax({
			  type: "POST",
			  url: "saveMonitorEquipment.do?command=ajaxSave",
			  data: $("#idFormChild").serialize() 
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
				$("#msgId").show();
				setTimeout( "$('#msgId').hide();", 1500 );	
			});

	}

	function editMonitorEquipment(id) {
		
		$.ajax({
			  type: "GET",
			  url: "monitorEquipment.do?",
			  cache: false,
			  data: { command: "ajaxEdit", id: id  }
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
			});

	}
	
	function updateMonitorEquipment() {
		
		bootbox.confirm("Are you sure you want to update this record?", function(ans) {
			  //Example.show("Confirm result: "+result);
			 if (ans) {
					$.ajax({
						  type: "POST",
						  url: "updateMonitorEquipment.do?command=ajaxUpdate",
						  data: $("#idFormChild").serialize() 
						})
						  .done(function( result ) {
							  $("#childDIV").html(result);//solution
								$("#msgId").show();
								setTimeout( "$('#msgId').hide();", 1500 );	
						  });
			 } 
		}); 

	}
	
	function cancelMonitorEquipment(patientCaseSystemId) {
		goToMonitorEquipment(patientCaseSystemId);
	}
	
	function deleteMonitorEquipment(id, patientCaseSystemId) {
				
		bootbox.confirm("Are you sure you want to update this record?", function(ans) {
			
			if (ans) {
				$.ajax({
					  type: "GET",
					  cache: false,
					  url: "monitorEquipment.do?",
					  data: { command: "ajaxDelete", 
						  	  id: id
					  		}
					})
					  .done(function( result ) {
						  goToMonitorEquipment(patientCaseSystemId, true);
					});
			}
			
		});
	}

	//Monitor PhysicalExamination
	function goToMonitorPhysicalExamination(patientCaseSystemId,isDeleted) {
				
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "monitorPhysicalExamination.do?",
			  data: { command: "ajaxGoToChild", 
				      patientCaseSystemId: patientCaseSystemId
			  		}
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
				if (isDeleted) {
					$("#msgId").show();
					setTimeout( "$('#msgId').hide();", 1500 );	
				}
			});
	}
	
	
	function goToMonitorPhysicalExaminationAdd(patientCaseSystemId) {
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "monitorPhysicalExamination.do?",
			  data: { command: "ajaxAdd", 
				  	  patientCaseSystemId: patientCaseSystemId
			  		}
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
			});
	}
	
	
	function saveMonitorPhysicalExamination() {
		
		$.ajax({
			  type: "POST",
			  url: "saveMonitorPhysicalExamination.do?command=ajaxSave",
			  data: $("#idFormChild").serialize() 
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
				$("#msgId").show();
				setTimeout( "$('#msgId').hide();", 1500 );	
			});

	}

	function editMonitorPhysicalExamination(id) {
		
		$.ajax({
			  type: "GET",
			  url: "monitorPhysicalExamination.do?",
			  cache: false,
			  data: { command: "ajaxEdit", id: id  }
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
			});

	}
	
	function updateMonitorPhysicalExamination() {
		
		bootbox.confirm("Are you sure you want to update this record?", function(ans) {
			  //Example.show("Confirm result: "+result);
			 if (ans) {
					$.ajax({
						  type: "POST",
						  url: "updateMonitorPhysicalExamination.do?command=ajaxUpdate",
						  data: $("#idFormChild").serialize() 
						})
						  .done(function( result ) {
							  $("#childDIV").html(result);//solution
								$("#msgId").show();
								setTimeout( "$('#msgId').hide();", 1500 );	
						  });
			 } 
		}); 

	}
	
	function cancelMonitorPhysicalExamination(patientCaseSystemId) {
		goToMonitorPhysicalExamination(patientCaseSystemId);
	}
	
	function deleteMonitorPhysicalExamination(id, patientCaseSystemId) {
				
		bootbox.confirm("Are you sure you want to update this record?", function(ans) {
			
			if (ans) {
				$.ajax({
					  type: "GET",
					  cache: false,
					  url: "monitorPhysicalExamination.do?",
					  data: { command: "ajaxDelete", 
						  	  id: id
					  		}
					})
					  .done(function( result ) {
						  goToMonitorPhysicalExamination(patientCaseSystemId,true);
					});
			}
		});
		

	}

	//Monitor Doctor
	function goToMonitorDoctor(patientCaseSystemId,isDeleted) {
				
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "monitorDoctor.do?",
			  data: { command: "ajaxGoToChild", 
				      patientCaseSystemId: patientCaseSystemId
			  		}
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
				if (isDeleted) {
					$("#msgId").show();
					setTimeout( "$('#msgId').hide();", 1500 );	
				}
			});
	}
	
	
	function goToMonitorDoctorSearch(patientCaseSystemId) {
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "monitorDoctor.do?",
			  data: { command: "ajaxGoToChildSearch", 
				  	  patientCaseSystemId: patientCaseSystemId
			  		}
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
			});
	}
	
	function getDoctorForMonitorPatient(pageCriteria, category, patientCaseSystemId) {
		
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
			  url: "monitorDoctor.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
			  cache: false,
			  data: $("#idForm").serialize() 
			})
			  .done(function( result ) {
				$("#tablePresentationDIV").html(result);
			});
	}
	
	function goToMonitorDoctorAdd(doctorId, patientCaseSystemId) {
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "monitorDoctor.do?",
			  data: { command: "ajaxAdd", 
				      doctorId: doctorId,
				  	  patientCaseSystemId: patientCaseSystemId
			  		}
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
			});
	}
	
	
	function saveMonitorDoctor() {
		
		$.ajax({
			  type: "POST",
			  url: "saveMonitorDoctor.do?command=ajaxSave",
			  data: $("#idFormChild").serialize() 
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
				$("#msgId").show();
				setTimeout( "$('#msgId').hide();", 1500 );	
			});

	}

	function editMonitorDoctor(id) {
		
		$.ajax({
			  type: "GET",
			  url: "monitorDoctor.do?",
			  cache: false,
			  data: { command: "ajaxEdit", id: id  }
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
			});

	}
	
	function updateMonitorDoctor() {
		
		bootbox.confirm("Are you sure you want to update this record?", function(ans) {
			  //Example.show("Confirm result: "+result);
			 if (ans) {
					$.ajax({
						  type: "POST",
						  url: "updateMonitorDoctor.do?command=ajaxUpdate",
						  data: $("#idFormChild").serialize() 
						})
						  .done(function( result ) {
							  $("#childDIV").html(result);//solution
								$("#msgId").show();
								setTimeout( "$('#msgId').hide();", 1500 );	
						  });
			 } 
		}); 

	}
	
	function cancelMonitorDoctor(patientCaseSystemId) {
		goToMonitorDoctor(patientCaseSystemId);
	}
	
	function deleteMonitorDoctor(id, patientCaseSystemId) {
		
		bootbox.confirm("Are you sure you want to remove this record?", function(ans) {
			
			if (ans) {
				$.ajax({
					  type: "GET",
					  cache: false,
					  url: "monitorDoctor.do?",
					  data: { command: "ajaxDelete", 
						  	  id: id
					  		}
					})
					  .done(function( result ) {
						  goToMonitorDoctor(patientCaseSystemId,true);
					});				
			}
			
		});

	}

	//Monitor Room
	function goToMonitorRoom(patientCaseSystemId,isDeleted) {
				
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "monitorRoom.do?",
			  data: { command: "ajaxGoToChild", 
				      patientCaseSystemId: patientCaseSystemId
			  		}
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
				if (isDeleted) {
					$("#msgId").show();
					setTimeout( "$('#msgId').hide();", 1500 );	
				}
			});
	}
	
	
	function goToMonitorRoomSearch(patientCaseSystemId) {
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "monitorRoom.do?",
			  data: { command: "ajaxGoToChildSearch", 
				  	  patientCaseSystemId: patientCaseSystemId
			  		}
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
			});
	}
	
	function getRoomForMonitorPatient(pageCriteria, category, patientCaseSystemId) {
		
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
			  url: "monitorRoom.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
			  cache: false,
			  data: $("#idForm").serialize() 
			})
			  .done(function( result ) {
				$("#tablePresentationDIV").html(result);
			});
	}
	
	function goToMonitorRoomAdd(roomId, patientCaseSystemId) {
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "monitorRoom.do?",
			  data: { command: "ajaxAdd", 
				      roomId: roomId,
				  	  patientCaseSystemId: patientCaseSystemId
			  		}
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
			});
	}
	
	
	function saveMonitorRoom() {
		
		$.ajax({
			  type: "POST",
			  url: "saveMonitorRoom.do?command=ajaxSave",
			  data: $("#idFormChild").serialize() 
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
				$("#msgId").show();
				setTimeout( "$('#msgId').hide();", 1500 );	
			});

	}

	function editMonitorRoom(id) {
		
		$.ajax({
			  type: "GET",
			  url: "monitorRoom.do?",
			  cache: false,
			  data: { command: "ajaxEdit", id: id  }
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
			});

	}
	
	function updateMonitorRoom() {
		
		bootbox.confirm("Are you sure you want to update this record?", function(ans) {
			  //Example.show("Confirm result: "+result);
			 if (ans) {
					$.ajax({
						  type: "POST",
						  url: "updateMonitorRoom.do?command=ajaxUpdate",
						  data: $("#idFormChild").serialize() 
						})
						  .done(function( result ) {
							  $("#childDIV").html(result);//solution
								$("#msgId").show();
								setTimeout( "$('#msgId').hide();", 1500 );
						  });
			 } 
		}); 

	}
	
	function cancelMonitorRoom(patientCaseSystemId) {
		goToMonitorRoom(patientCaseSystemId);
	}
	
	function deleteMonitorRoom(id, patientCaseSystemId) {
		
		bootbox.confirm("Are you sure you want to remove this record?", function(ans) {
			
			if (ans) {
				$.ajax({
					  type: "GET",
					  cache: false,
					  url: "monitorRoom.do?",
					  data: { command: "ajaxDelete", 
						  	  id: id
					  		}
					})
					  .done(function( result ) {
						  goToMonitorRoom(patientCaseSystemId,true);
					});
			}
			
		});

	}

	//Monitor Room Transfer
	function goToMonitorRoomTransfer(patientCaseSystemId,isDeleted) {
				
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "monitorRoomTransfer.do?",
			  data: { command: "ajaxGoToChild", 
				      patientCaseSystemId: patientCaseSystemId
			  		}
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
				if (isDeleted) {
					$("#msgId").show();
					setTimeout( "$('#msgId').hide();", 1500 );	
				}
			});
	}
	
	
	function goToMonitorRoomTransferSearch(patientCaseSystemId) {
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "monitorRoomTransfer.do?",
			  data: { command: "ajaxGoToChildSearch", 
				  	  patientCaseSystemId: patientCaseSystemId
			  		}
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
			});
	}
	
	function getRoomTransferForMonitorPatient(pageCriteria, category, patientCaseSystemId) {
		
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
			  url: "monitorRoomTransfer.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
			  cache: false,
			  data: $("#idForm").serialize() 
			})
			  .done(function( result ) {
				$("#tablePresentationDIV").html(result);
			});
	}
	
	function goToMonitorRoomTransferAdd(roomTransferId, patientCaseSystemId) {
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "monitorRoomTransfer.do?",
			  data: { command: "ajaxAdd", 
				      roomTransferId: roomTransferId,
				  	  patientCaseSystemId: patientCaseSystemId
			  		}
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
			});
	}
	
	
	function saveMonitorRoomTransfer() {
		
		$.ajax({
			  type: "POST",
			  url: "saveMonitorRoomTransfer.do?command=ajaxSave",
			  data: $("#idForm").serialize() 
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
				$("#msgId").show();
				setTimeout( "$('#msgId').hide();", 1500 );	
			});

	}
	
	function cancelMonitorRoomTransfer(patientCaseSystemId) {
		goToMonitorRoomTransfer(patientCaseSystemId);
	}
	
	function deleteMonitorRoomTransfer(id, patientCaseSystemId) {
				
		bootbox.confirm("Are you sure you want to remove this record?", function(ans) {
			
			if (ans) {
				$.ajax({
					  type: "GET",
					  cache: false,
					  url: "monitorRoomTransfer.do?",
					  data: { command: "ajaxDelete", 
						  	  id: id
					  		}
					})
					  .done(function( result ) {
						  goToMonitorRoomTransfer(patientCaseSystemId,true);
					});				
			}
		});

	}

	//Monitor Nursery
	function goToMonitorNursery(patientCaseSystemId,isDeleted) {
				
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "monitorNursery.do?",
			  data: { command: "ajaxGoToChild", 
				      patientCaseSystemId: patientCaseSystemId
			  		}
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
				if (isDeleted) {
					$("#msgId").show();
					setTimeout( "$('#msgId').hide();", 1500 );	
				}
			});
	}
	
	
	function goToMonitorNurseryAdd(patientCaseSystemId) {
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "monitorNursery.do?",
			  data: { command: "ajaxAdd", 
				  	  patientCaseSystemId: patientCaseSystemId
			  		}
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
			});
	}
	
	
	function saveMonitorNursery() {
		
		if ($("#lastNameId").val()!=null) {
			$("#lastNameId").val(convertToTitleCase($("#lastNameId").val()));
		}
		if ($("#firstNameId").val()!=null) {
			$("#firstNameId").val(convertToTitleCase($("#firstNameId").val()));
		}
		
		$.ajax({
			  type: "POST",
			  url: "saveMonitorNursery.do?command=ajaxSave",
			  data: $("#idFormChild").serialize() 
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
				$("#msgId").show();
				setTimeout( "$('#msgId').hide();", 1500 );	
			});

	}

	function editMonitorNursery(id) {
		
		$.ajax({
			  type: "GET",
			  url: "monitorNursery.do?",
			  cache: false,
			  data: { command: "ajaxEdit", id: id  }
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
			});

	}
	
	function updateMonitorNursery() {
		
		if ($("#lastNameId").val()!=null) {
			$("#lastNameId").val(convertToTitleCase($("#lastNameId").val()));
		}
		if ($("#firstNameId").val()!=null) {
			$("#firstNameId").val(convertToTitleCase($("#firstNameId").val()));
		}
		
		bootbox.confirm("Are you sure you want to update this record?", function(ans) {
			  //Example.show("Confirm result: "+result);
			 if (ans) {
					$.ajax({
						  type: "POST",
						  url: "updateMonitorNursery.do?command=ajaxUpdate",
						  data: $("#idFormChild").serialize() 
						})
						  .done(function( result ) {
							  $("#childDIV").html(result);//solution
								$("#msgId").show();
								setTimeout( "$('#msgId').hide();", 1500 );	
						  });
			 } 
		}); 

	}
	
	function cancelMonitorNursery(patientCaseSystemId) {
		goToMonitorNursery(patientCaseSystemId);
	}
	
	function deleteMonitorNursery(id, patientCaseSystemId) {
				
		bootbox.confirm("Are you sure you want to remove this record?", function(ans) {
			
			if (ans) {
				$.ajax({
					  type: "GET",
					  cache: false,
					  url: "monitorNursery.do?",
					  data: { command: "ajaxDelete", 
						  	  id: id
					  		}
					})
					  .done(function( result ) {
						  goToMonitorNursery(patientCaseSystemId, true);
					});
			}
			
		});

	}
	
	//Billing
	function goToBillingSearch() {
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "billing.do?",
			  data: { command: "ajaxGoToSearch" }
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});
	}
	
	function getPatientForBilling(pageCriteria, category, isDeleted) {

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
			  url: "billing.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
			  cache: false,
			  data: $("#idForm").serialize() 
			})
			  .done(function( result ) {
				$("#tablePresentationDIV").html(result);
			});
	}
	
	
	function goToBilling(patientCaseSystemId) {
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "billing.do?",
			  data: { command: "ajaxGoTo", 
				  	  patientCaseSystemId: patientCaseSystemId
			  		}
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});
	}
	
	function backToBillingSearch() {
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "billing.do?",
			  data: { command: "ajaxGoToSearch" }
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});
	}
	

	//Billing Discount
	function goToBillingDiscount(patientCaseSystemId,isDeleted) {
				
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "billingDiscount.do?",
			  data: { command: "ajaxGoToChild", 
				      patientCaseSystemId: patientCaseSystemId
			  		}
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
				if (isDeleted) {
					$("#msgId").show();
					setTimeout( "$('#msgId').hide();", 1500 );	
				}
			});
	}
	
	
	function goToBillingDiscountSearch(patientCaseSystemId) {
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "billingDiscount.do?",
			  data: { command: "ajaxGoToChildSearch", 
				  	  patientCaseSystemId: patientCaseSystemId
			  		}
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
			});
	}
	
	function getDiscountForBilling(pageCriteria, category, patientCaseSystemId) {
		
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
			  url: "billingDiscount.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
			  cache: false,
			  data: $("#idForm").serialize() 
			})
			  .done(function( result ) {
				$("#tablePresentationDIV").html(result);
			});
	}
	
	function goToBillingDiscountAdd(discountId, patientCaseSystemId) {
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "billingDiscount.do?",
			  data: { command: "ajaxAdd", 
				      discountId: discountId,
				  	  patientCaseSystemId: patientCaseSystemId
			  		}
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
			});
	}
	
	
	function saveBillingDiscount() {
		
		$.ajax({
			  type: "POST",
			  url: "saveBillingDiscount.do?command=ajaxSave",
			  data: $("#idFormChild").serialize() 
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
				$("#msgId").show();
				setTimeout( "$('#msgId').hide();", 1500 );	
			});

	}
	
	function editBillingDiscount(id) {
		
		$.ajax({
			  type: "GET",
			  url: "billingDiscount.do?",
			  cache: false,
			  data: { command: "ajaxEdit", id: id  }
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
			});

	}
	
	function updateBillingDiscount() {
		
		bootbox.confirm("Are you sure you want to update this record?", function(ans) {
			  //Example.show("Confirm result: "+result);
			 if (ans) {
					$.ajax({
						  type: "POST",
						  url: "updateBillingDiscount.do?command=ajaxUpdate",
						  data: $("#idFormChild").serialize() 
						})
						  .done(function( result ) {
							  $("#childDIV").html(result);//solution
								$("#msgId").show();
								setTimeout( "$('#msgId').hide();", 1500 );	
						  });
			 } 
		}); 

	}
	
	function cancelBillingDiscount(patientCaseSystemId) {
		goToBillingDiscount(patientCaseSystemId);
	}
	
	function deleteBillingDiscount(id, patientCaseSystemId) {
				
		bootbox.confirm("Are you sure you want to remove this record?", function(ans) {
			
			if (ans) {
				$.ajax({
					  type: "GET",
					  cache: false,
					  url: "billingDiscount.do?",
					  data: { command: "ajaxDelete", 
						  	  id: id
					  		}
					})
					  .done(function( result ) {
						  goToBillingDiscount(patientCaseSystemId,true);
					});	
			}
			
		});

	}

	//Billing Details
	function goToBillingDetails(patientCaseSystemId, caseNo) {
				
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "billingDetails.do?",
			  data: { command: "ajaxGoToChild", 
				      patientCaseSystemId: patientCaseSystemId,
				      caseNo: caseNo
			  		}
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
			});
	}

	//Billing Payment
	function goToBillingPayment(patientCaseSystemId, caseNo) {
				
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "billingPayment.do?",
			  data: { command: "ajaxGoToChild", 
				      patientCaseSystemId: patientCaseSystemId,
				      caseNo: caseNo
			  		}
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
			});
	}
	
	function saveBillingPayment() {
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "saveBillingPayment.do?command=ajaxSave",
			  data: $("#idForm").serialize() 
			})
			  .done(function( result ) {
				$("#childDIV").html(result);
			});
	}
	
	function closeBillingPayment () {
		 goToMainByAjax();
	}
	
    //Billing Details Report
	function  viewBillingDetailsReport (caseNo) {
		var filename="Bill_" + caseNo + ".pdf"
		document.getElementById("billReportId").href= "reports/billing/"+filename; 
	}
	
	//Patient Inquiry
	function goToPatientInquirySearch() {
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "patientInquiry.do?",
			  data: { command: "ajaxGoToSearch" }
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});
	}
	
	function getPatientForPatientInquiry(pageCriteria, category, isDeleted) {

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
			  url: "patientInquiry.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
			  cache: false,
			  data: $("#idForm").serialize() 
			})
			  .done(function( result ) {
				$("#tablePresentationDIV").html(result);
			});
	}
	
	//Room Inquiry
	function goToRoomInquirySearch() {
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "roomInquiry.do?",
			  data: { command: "ajaxGoToSearch" }
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});
	}
	
	function getRoomForRoomInquiry(pageCriteria, category, isDeleted) {

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
			  url: "roomInquiry.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
			  cache: false,
			  data: $("#idForm").serialize() 
			})
			  .done(function( result ) {
				$("#tablePresentationDIV").html(result);
			});
	}

	//Patient History
	function goToPatientHistorySearch() {
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "patientHistory.do?",
			  data: { command: "ajaxGoToSearch" }
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});
	}
	
	function getPatientForPatientHistory(pageCriteria, category, isDeleted) {

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
			  url: "patientHistory.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
			  cache: false,
			  data: $("#idForm").serialize() 
			})
			  .done(function( result ) {
				$("#tablePresentationDIV").html(result);
			});
	}
		
	function goToPatientHistory(patientSystemId) {

		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "patientHistory.do?",
			  data: { command: "ajaxGoTo", 
					  patientSystemId: patientSystemId
			  		}
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});
	}
	

	function closePatientHistory() {
		 goToMainByAjax();
	}
	
	function backToPatientHistorySearch() {
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "patientHistory.do?",
			  data: { command: "ajaxGoToSearch" }
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});
	}

	//Medical Abstract
	function goToMedicalAbstractSearch() {
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "medicalAbstract.do?",
			  data: { command: "ajaxGoToSearch" }
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});
	}
	
	function getPatientForMedicalAbstract(pageCriteria, category, isDeleted) {

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
			  url: "medicalAbstract.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
			  cache: false,
			  data: $("#idForm").serialize() 
			})
			  .done(function( result ) {
				$("#tablePresentationDIV").html(result);
			});
	}
		
	function goToMedicalAbstract(patientSystemId) {
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "medicalAbstract.do?",
			  data: { command: "ajaxGoTo", 
					  patientSystemId: patientSystemId
			  		}
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});
	}
	

	function closeMedicalAbstract() {
		 goToMainByAjax();
	}
	
	function backToMedicalAbstractSearch() {
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "medicalAbstract.do?",
			  data: { command: "ajaxGoToSearch" }
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});
	}
	
	function generateMedicalAbstract() {

		if ($("#doctorId").val()!=null) {
			$("#doctorId").val(convertToTitleCase($("#doctorId").val()));
		}
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "medicalAbstract.do?command=ajaxGenerate",
			  data: $("#idForm").serialize() 
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});
	}
	
    //Medical Abstract Report
	function  viewMedicalAbstractReport (patientId) {
		var filename="MedicalAbstract_" + patientId + ".pdf"
		document.getElementById("reportId").href= "reports/medicalabstract/"+filename; 
	}

	//Nursery Inquiry
	function goToNurseryInquirySearch() {
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "nurseryInquiry.do?",
			  data: { command: "ajaxGoToSearch" }
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});
	}
	
	function getBabyForNurseryInquiry(pageCriteria, category, isDeleted) {

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
			  url: "nurseryInquiry.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
			  cache: false,
			  data: $("#idForm").serialize() 
			})
			  .done(function( result ) {
				$("#tablePresentationDIV").html(result);
			});
	}

	function editNurseryInquiry(id) {
		
		$.ajax({
			  type: "GET",
			  url: "nurseryInquiry.do?",
			  cache: false,
			  data: { command: "ajaxEdit", id: id  }
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});

	}

	function updateNurseryInquiry() {
	
		if ($("#lastNameId").val()!=null) {
			$("#lastNameId").val(convertToTitleCase($("#lastNameId").val()));
		}
		if ($("#firstNameId").val()!=null) {
			$("#firstNameId").val(convertToTitleCase($("#firstNameId").val()));
		}
		
		bootbox.confirm("Are you sure you want to update this record?", function(ans) {
			  //Example.show("Confirm result: "+result);
			 if (ans) {
					$.ajax({
						  type: "POST",
						  url: "updateNurseryInquiry.do?command=ajaxUpdate",
						  data: $("#idForm").serialize() 
						})
						  .done(function( result ) {
							$("#contentDIV").html(result);
					});
			 } 
		}); 

	}

	function deleteNurseryInquiry(id, category, currentPage) {
		
		bootbox.confirm("Are you sure you want to delete this record?", function(ans) {
			  //Example.show("Confirm result: "+result);
			if (ans) {
				$.ajax({
					  type: "POST",
					  url: "deleteNurseryInquiry.do?",
					  data: { command: "ajaxDelete", id: id  }
					})
					  .done(function( result ) {
						 //$("#contentDIV").html(result);
						  getBabyForNurseryInquiry(currentPage,category, true);//show the updated list after delete
					});		
			} 
		}); 
		
	}
	//Patient Bill History
	function goToPatientBillHistorySearch() {
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "patientBillHistory.do?",
			  data: { command: "ajaxGoToSearch" }
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});
	}
	
	function getPatientForPatientBillHistory(pageCriteria, category, isDeleted) {

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
			  url: "patientBillHistory.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
			  cache: false,
			  data: $("#idForm").serialize() 
			})
			  .done(function( result ) {
				$("#tablePresentationDIV").html(result);
			});
	}
		
	function goToPatientBillHistory(patientSystemId) {

		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "patientBillHistory.do?",
			  data: { command: "ajaxGoTo", 
					  patientSystemId: patientSystemId
			  		}
			})
			  .done(function( result ) {
				  $("#tablePresentationDIV").html(result);
			});
	}

	function goToPatientBillHistoryDetails(caseNo) {
		var filename="Bill_" + caseNo + ".pdf";
		document.getElementById(caseNo).href= "reports/billing/"+filename; 
	}

	function closePatientBillHistory() {
		 goToMainByAjax();
	}
	
	function backToPatientBillHistorySearch() {
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "patientBillHistory.do?",
			  data: { command: "ajaxGoToSearch" }
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});
	}	
