//JS of Master files

//constants
var remarksLength = 50;


//functions
function goToMain(){
	 window.location = '/transportweb/main.do';
	 window.scrollTo(0,0);
}

function goToMainByAjax(){
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "navigate.do?"
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			window.scrollTo(0,0);
		});
}

//Employee
function goToEmployee() {
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "employee.do?"
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});
}

function goToAddEmployee() {
	$.ajax({
		  type: "GET",
		  url: "employee.do?",
		  cache: false,
		  data: { command: "add" }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			$("#lastNameId").focus();
		});
}

function getEmployee(pageCriteria, category, isDeleted) {

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
		  url: "employee.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
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

function saveEmployee() {
	
	$.ajax({
		  type: "POST",
		  url: "saveEmployee.do?command=ajaxSave",
		  data: $("#idForm").serialize() 
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});

}

function editEmployee(id) {
	$.ajax({
		  type: "GET",
		  url: "employee.do?",
		  cache: false,
		  data: { command: "ajaxEdit", id: id  }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});

}

function updateEmployee() {
	
	bootbox.confirm("Are you sure you want to update this record?", function(ans) {
		  //Example.show("Confirm result: "+result);
		 if (ans) {
				$.ajax({
					  type: "POST",
					  url: "updateEmployee.do?command=ajaxUpdate",
					  data: $("#idForm").serialize() 
					})
					  .done(function( result ) {
						$("#contentDIV").html(result);
				});
		 } 
	}); 

}

function deleteEmployee(id, category, currentPage) {
	
	bootbox.confirm("Are you sure you want to delete this record?", function(ans) {
		  //Example.show("Confirm result: "+result);
		if (ans) {
			$.ajax({
				  type: "POST",
				  url: "deleteEmployee.do?",
				  data: { command: "ajaxDelete", id: id  }
				})
				  .done(function( result ) {
					 //$("#contentDIV").html(result);
					getEmployee(currentPage,category, true);//show the updated list after delete
				});		
		} 
	}); 

}

//Lorry
function goToLorry() {
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "lorry.do?"
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});
}

function goToAddLorry() {
	$.ajax({
		  type: "GET",
		  url: "lorry.do?",
		  cache: false,
		  data: { command: "add" }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			$("#descriptionId").focus();
		});
}

function getLorry(pageCriteria, category, isDeleted) {

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
		  url: "lorry.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
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

function saveLorry() {
	
	$.ajax({
		  type: "POST",
		  url: "saveLorry.do?command=ajaxSave",
		  data: $("#idForm").serialize() 
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});

}

function editLorry(id) {
	$.ajax({
		  type: "GET",
		  url: "lorry.do?",
		  cache: false,
		  data: { command: "ajaxEdit", id: id  }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});

}

function updateLorry() {
	
	bootbox.confirm("Are you sure you want to update this record?", function(ans) {
		  //Example.show("Confirm result: "+result);
		 if (ans) {
				$.ajax({
					  type: "POST",
					  url: "updateLorry.do?command=ajaxUpdate",
					  data: $("#idForm").serialize() 
					})
					  .done(function( result ) {
						$("#contentDIV").html(result);
				});
		 } 
	}); 

}

function deleteLorry(id, category, currentPage) {
	
	bootbox.confirm("Are you sure you want to delete this record?", function(ans) {
		  //Example.show("Confirm result: "+result);
		if (ans) {
			$.ajax({
				  type: "POST",
				  url: "deleteLorry.do?",
				  data: { command: "ajaxDelete", id: id  }
				})
				  .done(function( result ) {
					 //$("#contentDIV").html(result);
					getLorry(currentPage,category, true);//show the updated list after delete
				});		
		} 
	}); 

}

//Items
function goToItems() {
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "items.do?"
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});
}

function goToAddItems() {
	$.ajax({
		  type: "GET",
		  url: "items.do?",
		  cache: false,
		  data: { command: "add" }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			$("#descriptionId").focus();
		});
}

function getItems(pageCriteria, category, isDeleted) {

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
		  url: "items.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
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

function saveItems() {
	
	$.ajax({
		  type: "POST",
		  url: "saveItems.do?command=ajaxSave",
		  data: $("#idForm").serialize() 
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});

}

function editItems(id) {
	$.ajax({
		  type: "GET",
		  url: "items.do?",
		  cache: false,
		  data: { command: "ajaxEdit", id: id  }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});

}

function updateItems() {
	
	bootbox.confirm("Are you sure you want to update this record?", function(ans) {
		  //Example.show("Confirm result: "+result);
		 if (ans) {
				$.ajax({
					  type: "POST",
					  url: "updateItems.do?command=ajaxUpdate",
					  data: $("#idForm").serialize() 
					})
					  .done(function( result ) {
						$("#contentDIV").html(result);
				});
		 } 
	}); 

}

function deleteItems(id, category, currentPage) {
	
	bootbox.confirm("Are you sure you want to delete this record?", function(ans) {
		  //Example.show("Confirm result: "+result);
		if (ans) {
			$.ajax({
				  type: "POST",
				  url: "deleteItems.do?",
				  data: { command: "ajaxDelete", id: id  }
				})
				  .done(function( result ) {
					 //$("#contentDIV").html(result);
					getItems(currentPage,category, true);//show the updated list after delete
				});		
		} 
	}); 

}

//Corrective Actions
function goToCorrections() {
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "corrections.do?"
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});
}

function goToAddCorrections() {
	$.ajax({
		  type: "GET",
		  url: "corrections.do?",
		  cache: false,
		  data: { command: "add" }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			$("#descriptionId").focus();
		});
}

function getCorrections(pageCriteria, category, isDeleted) {

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
		  url: "corrections.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
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

function saveCorrections() {
	
	$.ajax({
		  type: "POST",
		  url: "saveCorrections.do?command=ajaxSave",
		  data: $("#idForm").serialize() 
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});

}

function editCorrections(id) {
	$.ajax({
		  type: "GET",
		  url: "corrections.do?",
		  cache: false,
		  data: { command: "ajaxEdit", id: id  }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});

}

function updateCorrections() {
	
	bootbox.confirm("Are you sure you want to update this record?", function(ans) {
		  //Example.show("Confirm result: "+result);
		 if (ans) {
				$.ajax({
					  type: "POST",
					  url: "updateCorrections.do?command=ajaxUpdate",
					  data: $("#idForm").serialize() 
					})
					  .done(function( result ) {
						$("#contentDIV").html(result);
				});
		 } 
	}); 

}

function deleteCorrections(id, category, currentPage) {
	
	bootbox.confirm("Are you sure you want to delete this record?", function(ans) {
		  //Example.show("Confirm result: "+result);
		if (ans) {
			$.ajax({
				  type: "POST",
				  url: "deleteCorrections.do?",
				  data: { command: "ajaxDelete", id: id  }
				})
				  .done(function( result ) {
					 //$("#contentDIV").html(result);
					getCorrections(currentPage,category, true);//show the updated list after delete
				});		
		} 
	}); 

}


//Follow Up
function goToFollowUp() {
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "followUp.do?"
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});
}

function goToAddFollowUp() {
	$.ajax({
		  type: "GET",
		  url: "followUp.do?",
		  cache: false,
		  data: { command: "add" }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			$("#descriptionId").focus();
		});
}

function getFollowUp(pageCriteria, category, isDeleted) {

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
		  url: "followUp.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
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

function saveFollowUp() {
	
	$.ajax({
		  type: "POST",
		  url: "saveFollowUp.do?command=ajaxSave",
		  data: $("#idForm").serialize() 
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});

}

function editFollowUp(id) {
	$.ajax({
		  type: "GET",
		  url: "followUp.do?",
		  cache: false,
		  data: { command: "ajaxEdit", id: id  }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});

}

function updateFollowUp() {
	
	bootbox.confirm("Are you sure you want to update this record?", function(ans) {
		  //Example.show("Confirm result: "+result);
		 if (ans) {
				$.ajax({
					  type: "POST",
					  url: "updateFollowUp.do?command=ajaxUpdate",
					  data: $("#idForm").serialize() 
					})
					  .done(function( result ) {
						$("#contentDIV").html(result);
				});
		 } 
	}); 

}

function deleteFollowUp(id, category, currentPage) {
	
	bootbox.confirm("Are you sure you want to delete this record?", function(ans) {
		  //Example.show("Confirm result: "+result);
		if (ans) {
			$.ajax({
				  type: "POST",
				  url: "deleteFollowUp.do?",
				  data: { command: "ajaxDelete", id: id  }
				})
				  .done(function( result ) {
					 //$("#contentDIV").html(result);
					getFollowUp(currentPage,category, true);//show the updated list after delete
				});		
		} 
	}); 

}

//Remarks
function goToRemarks() {
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "remarks.do?"
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});
}

function goToAddRemarks() {
	$.ajax({
		  type: "GET",
		  url: "remarks.do?",
		  cache: false,
		  data: { command: "add" }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			$("#descriptionId").focus();
		});
}

function getRemarks(pageCriteria, category, isDeleted) {

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
		  url: "remarks.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
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

function saveRemarks() {
	
	$.ajax({
		  type: "POST",
		  url: "saveRemarks.do?command=ajaxSave",
		  data: $("#idForm").serialize() 
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});

}

function editRemarks(id) {
	$.ajax({
		  type: "GET",
		  url: "remarks.do?",
		  cache: false,
		  data: { command: "ajaxEdit", id: id  }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});

}

function updateRemarks() {
	
	bootbox.confirm("Are you sure you want to update this record?", function(ans) {
		  //Example.show("Confirm result: "+result);
		 if (ans) {
				$.ajax({
					  type: "POST",
					  url: "updateRemarks.do?command=ajaxUpdate",
					  data: $("#idForm").serialize() 
					})
					  .done(function( result ) {
						$("#contentDIV").html(result);
				});
		 } 
	}); 

}

function deleteRemarks(id, category, currentPage) {
	
	bootbox.confirm("Are you sure you want to delete this record?", function(ans) {
		  //Example.show("Confirm result: "+result);
		if (ans) {
			$.ajax({
				  type: "POST",
				  url: "deleteRemarks.do?",
				  data: { command: "ajaxDelete", id: id  }
				})
				  .done(function( result ) {
					 //$("#contentDIV").html(result);
					getRemarks(currentPage,category, true);//show the updated list after delete
				});		
		} 
	}); 

}

//Terminal
function goToTerminal() {
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "terminal.do?"
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});
}

function goToAddTerminal() {
	$.ajax({
		  type: "GET",
		  url: "terminal.do?",
		  cache: false,
		  data: { command: "add" }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			$("#descriptionId").focus();
		});
}

function getTerminal(pageCriteria, category, isDeleted) {

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
		  url: "terminal.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
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

function saveTerminal() {
	
	$.ajax({
		  type: "POST",
		  url: "saveTerminal.do?command=ajaxSave",
		  data: $("#idForm").serialize() 
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});

}

function editTerminal(id) {
	$.ajax({
		  type: "GET",
		  url: "terminal.do?",
		  cache: false,
		  data: { command: "ajaxEdit", id: id  }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});

}

function updateTerminal() {
	
	bootbox.confirm("Are you sure you want to update this record?", function(ans) {
		  //Example.show("Confirm result: "+result);
		 if (ans) {
				$.ajax({
					  type: "POST",
					  url: "updateTerminal.do?command=ajaxUpdate",
					  data: $("#idForm").serialize() 
					})
					  .done(function( result ) {
						$("#contentDIV").html(result);
				});
		 } 
	}); 

}

function deleteTerminal(id, category, currentPage) {
	
	bootbox.confirm("Are you sure you want to delete this record?", function(ans) {
		  //Example.show("Confirm result: "+result);
		if (ans) {
			$.ajax({
				  type: "POST",
				  url: "deleteTerminal.do?",
				  data: { command: "ajaxDelete", id: id  }
				})
				  .done(function( result ) {
					 //$("#contentDIV").html(result);
					getTerminal(currentPage,category, true);//show the updated list after delete
				});		
		} 
	}); 

}


//User
function goToUser() {
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "user.do?"
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});
}

function goToAddUser() {
	$.ajax({
		  type: "GET",
		  url: "user.do?",
		  cache: false,
		  data: { command: "add" }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			$("#descriptionId").focus();
		});
}

function getUser(pageCriteria, category, isDeleted) {

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
		  url: "user.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
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

function saveUser() {
	
	$.ajax({
		  type: "POST",
		  url: "saveUser.do?command=ajaxSave",
		  data: $("#idForm").serialize() 
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});

}

function editUser(id) {
	$.ajax({
		  type: "GET",
		  url: "user.do?",
		  cache: false,
		  data: { command: "ajaxEdit", id: id  }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});

}

function updateUser() {
	
	bootbox.confirm("Are you sure you want to update this record?", function(ans) {
		  //Example.show("Confirm result: "+result);
		 if (ans) {
				$.ajax({
					  type: "POST",
					  url: "updateUser.do?command=ajaxUpdate",
					  data: $("#idForm").serialize() 
					})
					  .done(function( result ) {
						$("#contentDIV").html(result);
				});
		 } 
	}); 

}

function deleteUser(id, category, currentPage) {
	
	bootbox.confirm("Are you sure you want to delete this record?", function(ans) {
		  //Example.show("Confirm result: "+result);
		if (ans) {
			$.ajax({
				  type: "POST",
				  url: "deleteUser.do?",
				  data: { command: "ajaxDelete", id: id  }
				})
				  .done(function( result ) {
					 //$("#contentDIV").html(result);
					getUser(currentPage,category, true);//show the updated list after delete
				});		
		} 
	}); 

}


//Findings
function goToFindings() {
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "findings.do?"
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});
}

function goToAddFindings() {
	$.ajax({
		  type: "GET",
		  url: "findings.do?",
		  cache: false,
		  data: { command: "add" }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			$("#descriptionId").focus();
		});
}

function getFindings(pageCriteria, category, isDeleted) {

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
		  url: "findings.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
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

function saveFindings() {
	
	$.ajax({
		  type: "POST",
		  url: "saveFindings.do?command=ajaxSave",
		  data: $("#idForm").serialize() 
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});

}

function editFindings(id) {
	$.ajax({
		  type: "GET",
		  url: "findings.do?",
		  cache: false,
		  data: { command: "ajaxEdit", id: id  }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});

}

function updateFindings() {
	
	bootbox.confirm("Are you sure you want to update this record?", function(ans) {
		  //Example.show("Confirm result: "+result);
		 if (ans) {
				$.ajax({
					  type: "POST",
					  url: "updateFindings.do?command=ajaxUpdate",
					  data: $("#idForm").serialize() 
					})
					  .done(function( result ) {
						$("#contentDIV").html(result);
				});
		 } 
	}); 

}

function deleteFindings(id, category, currentPage) {
	
	bootbox.confirm("Are you sure you want to delete this record?", function(ans) {
		  //Example.show("Confirm result: "+result);
		if (ans) {
			$.ajax({
				  type: "POST",
				  url: "deleteFindings.do?",
				  data: { command: "ajaxDelete", id: id  }
				})
				  .done(function( result ) {
					 //$("#contentDIV").html(result);
					getFindings(currentPage,category, true);//show the updated list after delete
				});		
		} 
	}); 

}


//START Added for Revision 1 Dec 20 2015 ESD 
//Root Cause
function goToRootCause() {
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "rootcause.do?"
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});
}

function goToAddRootCause() {
	$.ajax({
		  type: "GET",
		  url: "rootcause.do?",
		  cache: false,
		  data: { command: "add" }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			$("#descriptionId").focus();
		});
}

function getRootCause(pageCriteria, category, isDeleted) {

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
		  url: "rootcause.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
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

function saveRootCause() {
	
	$.ajax({
		  type: "POST",
		  url: "saveRootcause.do?command=ajaxSave",
		  data: $("#idForm").serialize() 
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});

}

function editRootCause(id) {
	$.ajax({
		  type: "GET",
		  url: "rootcause.do?",
		  cache: false,
		  data: { command: "ajaxEdit", id: id  }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});

}

function updateRootCause() {
	
	bootbox.confirm("Are you sure you want to update this record?", function(ans) {
		  //Example.show("Confirm result: "+result);
		 if (ans) {
				$.ajax({
					  type: "POST",
					  url: "updateRootcause.do?command=ajaxUpdate",
					  data: $("#idForm").serialize() 
					})
					  .done(function( result ) {
						$("#contentDIV").html(result);
				});
		 } 
	}); 

}

function deleteRootCause(id, category, currentPage) {
	
	bootbox.confirm("Are you sure you want to delete this record?", function(ans) {
		  //Example.show("Confirm result: "+result);
		if (ans) {
			$.ajax({
				  type: "POST",
				  url: "deleteRootcause.do?",
				  data: { command: "ajaxDelete", id: id  }
				})
				  .done(function( result ) {
					 //$("#contentDIV").html(result);
					getRootCause(currentPage,category, true);//show the updated list after delete
				});		
		} 
	}); 

}
//Closure on Corrective Actions
function goToClosure() {
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "closure.do?"
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});
}

function goToAddClosure() {
	$.ajax({
		  type: "GET",
		  url: "closure.do?",
		  cache: false,
		  data: { command: "add" }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			$("#descriptionId").focus();
		});
}

function getClosure(pageCriteria, category, isDeleted) {

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
		  url: "closure.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
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

function saveClosure() {
	
	$.ajax({
		  type: "POST",
		  url: "saveClosure.do?command=ajaxSave",
		  data: $("#idForm").serialize() 
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});

}

function editClosure(id) {
	$.ajax({
		  type: "GET",
		  url: "closure.do?",
		  cache: false,
		  data: { command: "ajaxEdit", id: id  }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});

}

function updateClosure() {
	
	bootbox.confirm("Are you sure you want to update this record?", function(ans) {
		  //Example.show("Confirm result: "+result);
		 if (ans) {
				$.ajax({
					  type: "POST",
					  url: "updateClosure.do?command=ajaxUpdate",
					  data: $("#idForm").serialize() 
					})
					  .done(function( result ) {
						$("#contentDIV").html(result);
				});
		 } 
	}); 

}

function deleteClosure(id, category, currentPage) {
	
	bootbox.confirm("Are you sure you want to delete this record?", function(ans) {
		  //Example.show("Confirm result: "+result);
		 
		if (ans) {
			$.ajax({
				  type: "POST",
				  url: "deleteClosure.do?",
				  data: { command: "ajaxDelete", id: id  }
				})
				  .done(function( result ) {
					 //$("#contentDIV").html(result);
					getClosure(currentPage,category, true);//show the updated list after delete
				});		
		} 
	}); 

}

//END Added for Revision 1 Dec 20 2015 ESD 

//START Added for Website Enhancement 1 21Aug2016
//Tire Brand
function goToTireBrand() {
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "tirebrand.do?"
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			window.scrollTo(0,0);
		});
}

function goToAddTireBrand() {
	$.ajax({
		  type: "GET",
		  url: "tirebrand.do?",
		  cache: false,
		  data: { command: "add" }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			window.scrollTo(0,0);
		});
}

function getTireBrand(pageCriteria, category, isDeleted) {

	$.ajax({
		  type: "GET",
		  url: "tirebrand.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
		  cache: false,
		  data: $("#idForm").serialize() 
		})
		  .done(function( result ) {
			$("#tablePresentationDIV").html(result);
			if (isDeleted) {
				$("#msgDeletedId").show();
				setTimeout( "$('#msgDeletedId').hide();", 1500 );
				window.scrollTo(0,0);
			}
		});
}

function saveTireBrand() {
	
	$.ajax({
		  type: "POST",
		  url: "saveTireBrand.do?command=ajaxSave",
		  data: $("#idForm").serialize() 
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			window.scrollTo(0,0);
		});

}

function editTireBrand(id) {
	$.ajax({
		  type: "GET",
		  url: "tirebrand.do?",
		  cache: false,
		  data: { command: "ajaxEdit", id: id  }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			window.scrollTo(0,0);
		});

}

function updateTireBrand() {
	
	bootbox.confirm("Are you sure you want to update this record?", function(ans) {
		  //Example.show("Confirm result: "+result);
		 if (ans) {
				$.ajax({
					  type: "POST",
					  url: "updateTireBrand.do?command=ajaxUpdate",
					  data: $("#idForm").serialize() 
					})
					  .done(function( result ) {
						$("#contentDIV").html(result);
						window.scrollTo(0,0);
				});
		 } 
	}); 

}

function deleteTireBrand(id, category, currentPage) {
	
	bootbox.confirm("Are you sure you want to delete this record?", function(ans) {
		  //Example.show("Confirm result: "+result);
		 
		if (ans) {
			$.ajax({
				  type: "POST",
				  url: "deleteTireBrand.do?",
				  data: { command: "ajaxDelete", id: id  }
				})
				  .done(function( result ) {
					 //$("#contentDIV").html(result);
					getTireBrand(currentPage,category, true);//show the updated list after delete
				});		
		} 
	}); 

}

//Tire
function goToTire() {
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "tire.do?"
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			window.scrollTo(0,0);
		});
}

function goToAddTire() {
	$.ajax({
		  type: "GET",
		  url: "tire.do?",
		  cache: false,
		  data: { command: "add" }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			window.scrollTo(0,0);
		});
}

function getTire(pageCriteria, category, isDeleted) {

	$.ajax({
		  type: "GET",
		  url: "tire.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
		  cache: false,
		  data: $("#idForm").serialize() 
		})
		  .done(function( result ) {
			$("#tablePresentationDIV").html(result);
			if (isDeleted) {
				$("#msgDeletedId").show();
				setTimeout( "$('#msgDeletedId').hide();", 1500 );
				window.scrollTo(0,0);
			}
		});
}

function saveTire() {
	
	$.ajax({
		  type: "POST",
		  url: "saveTire.do?command=ajaxSave",
		  data: $("#idForm").serialize() 
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			window.scrollTo(0,0);
		});

}

function editTire(id) {
	$.ajax({
		  type: "GET",
		  url: "tire.do?",
		  cache: false,
		  data: { command: "ajaxEdit", id: id  }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			window.scrollTo(0,0);
		});
}

function recapTire(id) {
	$.ajax({
		  type: "GET",
		  url: "tire.do?",
		  cache: false,
		  data: { command: "ajaxEdit", id: id, recap: true  }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			window.scrollTo(0,0);
		});

}

function updateTire() {
	
	bootbox.confirm("Are you sure you want to update this record?", function(ans) {
		  //Example.show("Confirm result: "+result);
		 if (ans) {
				$.ajax({
					  type: "POST",
					  url: "updateTire.do?command=ajaxUpdate",
					  data: $("#idForm").serialize() 
					})
					  .done(function( result ) {
						$("#contentDIV").html(result);
						window.scrollTo(0,0);
				});
		 } 
	}); 

}

function updateTireRecap() {
	
	bootbox.confirm("Are you sure you want to update this record?", function(ans) {
		  //Example.show("Confirm result: "+result);
		 if (ans) {
				$.ajax({
					  type: "POST",
					  url: "updateTire.do?command=ajaxUpdate&recap=true",
					  data: $("#idForm").serialize() 
					})
					  .done(function( result ) {
						$("#contentDIV").html(result);
						window.scrollTo(0,0);
				});
		 } 
	}); 

}

function deleteTire(id, category, currentPage) {
	
	bootbox.confirm("Are you sure you want to delete this record?", function(ans) {
		  //Example.show("Confirm result: "+result);
		 
		if (ans) {
			$.ajax({
				  type: "POST",
				  url: "deleteTire.do?",
				  data: { command: "ajaxDelete", id: id  }
				})
				  .done(function( result ) {
					 //$("#contentDIV").html(result);
					getTire(currentPage,category, true);//show the updated list after delete
				});		
		} 
	}); 

}

//END Added for Website Enhancement 1 21Aug2016

//User Access
function goToUserAccess() {
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "userAccess.do?"
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});
}

function goToAddUserAccess(userId) {
	
	$.ajax({
		  type: "GET",
		  url: "userAccess.do?",
		  cache: false,
		  data: { command: "add", 
			  	  userId: userId
		  		}
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
			//$("#descriptionId").focus();
		});
}

function getUserAccess(pageCriteria, category, isDeleted) {
	$.ajax({
		  type: "GET",
		  url: "userAccess.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
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

function saveUserAccess() {
	$.ajax({
		  type: "POST",
		  url: "saveUserAccess.do?command=ajaxSave",
		  data: $("#idForm").serialize() 
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});

}

function deleteUserAccess(id, category, currentPage) {
	//Note: Delete is updating user access to Inactive only
	bootbox.confirm("Are you sure you want to delete this access for this user?", function(ans) {
		  //Example.show("Confirm result: "+result);
		  //Example.show("Confirm result: "+result);
		if (ans) {
			$.ajax({
				  type: "POST",
				  url: "deleteUserAccess.do?",
				  data: { command: "ajaxDelete", id: id  }
				})
				  .done(function( result ) {
					 //$("#contentDIV").html(result);
					  getUserAccess(currentPage, category, true);//show the updated list after delete
					
				});		
		} 
	}); 
}