//JS of Master files

//constants
var remarksLength = 50;


//functions
function goToMain(){
	 window.location = '/PIBSweb/main.do';
}

function goToMainByAjax(){
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "navigate.do?"
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});
}

//Building
function goToBuilding() {
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "building.do?"
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});
}

function goToAddBuilding() {
	$.ajax({
		  type: "GET",
		  url: "building.do?",
		  cache: false,
		  data: { command: "ajaxAdd" }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});
}

function getBuilding(pageCriteria, category, isDeleted) {

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
		  url: "building.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
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

function saveBuilding() {
	
	if ($("#descriptionId").val()!=null) {
		$("#descriptionId").val(convertToTitleCase($("#descriptionId").val()));
	}
	
	$.ajax({
		  type: "POST",
		  url: "saveBuilding.do?command=ajaxSave",
		  data: $("#idForm").serialize() 
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});

}

function editBuilding(id) {
	$.ajax({
		  type: "GET",
		  url: "building.do?",
		  cache: false,
		  data: { command: "ajaxEdit", id: id  }
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});

}

function updateBuilding() {
	
	if ($("#descriptionId").val()!=null) {
		$("#descriptionId").val(convertToTitleCase($("#descriptionId").val()));
	}
	
	bootbox.confirm("Are you sure you want to update this record?", function(ans) {
		  //Example.show("Confirm result: "+result);
		 if (ans) {
				$.ajax({
					  type: "POST",
					  url: "updateBuilding.do?command=ajaxUpdate",
					  data: $("#idForm").serialize() 
					})
					  .done(function( result ) {
						$("#contentDIV").html(result);
				});
		 } 
	}); 

}

function deleteBuilding(id, category, currentPage) {
	
	bootbox.confirm("Are you sure you want to delete this record?", function(ans) {
		  //Example.show("Confirm result: "+result);
		if (ans) {
			$.ajax({
				  type: "POST",
				  url: "deleteBuilding.do?",
				  data: { command: "ajaxDelete", id: id  }
				})
				  .done(function( result ) {
					 //$("#contentDIV").html(result);
					getBuilding(currentPage,category, true);//show the updated list after delete
				});		
		} 
	}); 

}

//Room Category
	function goToRoomCategory() {
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "roomCategory.do?"
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});
	}

	function goToAddRoomCategory() {
		$.ajax({
			  type: "GET",
			  url: "roomCategory.do?",
			  cache: false,
			  data: { command: "ajaxAdd" }
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});
	}

	function getRoomCategory(pageCriteria, category, isDeleted) {

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
			  url: "roomCategory.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
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

	function saveRoomCategory() {
		
		if ($("#descriptionId").val()!=null) {
			$("#descriptionId").val(convertToTitleCase($("#descriptionId").val()));
		}
		
		$.ajax({
			  type: "POST",
			  url: "saveRoomCategory.do?command=ajaxSave",
			  data: $("#idForm").serialize() 
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});

	}

	function editRoomCategory(id) {
		$.ajax({
			  type: "GET",
			  url: "roomCategory.do?",
			  cache: false,
			  data: { command: "ajaxEdit", id: id  }
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});

	}

	function updateRoomCategory() {
		
		if ($("#descriptionId").val()!=null) {
			$("#descriptionId").val(convertToTitleCase($("#descriptionId").val()));
		}
		
		bootbox.confirm("Are you sure you want to update this record?", function(ans) {
			  //Example.show("Confirm result: "+result);
			 if (ans) {
					$.ajax({
						  type: "POST",
						  url: "updateRoomCategory.do?command=ajaxUpdate",
						  data: $("#idForm").serialize() 
						})
						  .done(function( result ) {
							$("#contentDIV").html(result);
					});
			 } 
		}); 

	}

	function deleteRoomCategory(id, category, currentPage) {
		
		bootbox.confirm("Are you sure you want to delete this record?", function(ans) {
			  //Example.show("Confirm result: "+result);
			if (ans) {
				$.ajax({
					  type: "POST",
					  url: "deleteRoomCategory.do?",
					  data: { command: "ajaxDelete", id: id  }
					})
					  .done(function( result ) {
						 //$("#contentDIV").html(result);
						getRoomCategory(currentPage,category, true);//show the updated list after delete
					});		
			} 
		}); 
		
	}


	//Room 
	function goToRoom() {
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "room.do?"
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});
	}

	function goToAddRoom() {
		$.ajax({
			  type: "GET",
			  url: "room.do?",
			  cache: false,
			  data: { command: "ajaxAdd" }
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});
	}

	function getRoom(pageCriteria, category, isDeleted) {

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
			  url: "room.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
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

	function saveRoom() {
		
		$.ajax({
			  type: "POST",
			  url: "saveRoom.do?command=ajaxSave",
			  data: $("#idForm").serialize() 
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});

	}

	function editRoom(id, buildingId) {
		$.ajax({
			  type: "GET",
			  url: "room.do?",
			  cache: false,
			  data: { command: "ajaxEdit", id: id, buildingId: buildingId }
			})
			  .done(function( result ) {
				//populate the noOffLoor
				$('#contentDIV').html(result);
				//populateNoOfFloorByBuilding				//set the floorNo in the dropdown -- problem here
				//$('#floorNoId').val(floorNo);Id(buildingId);

			});

	}

	function updateRoom() {
		
		bootbox.confirm("Are you sure you want to update this record?", function(ans) {
			  //Example.show("Confirm result: "+result);
			 if (ans) {
					$.ajax({
						  type: "POST",
						  url: "updateRoom.do?command=ajaxUpdate",
						  data: $("#idForm").serialize() 
						})
						  .done(function( result ) {
							$("#contentDIV").html(result);
					});
			 } 
		}); 

	}

	function deleteRoom(id, category, currentPage) {
		
		bootbox.confirm("Are you sure you want to delete this record?", function(ans) {
			  //Example.show("Confirm result: "+result);
			if (ans) {
				$.ajax({
					  type: "POST",
					  url: "deleteRoom.do?",
					  data: { command: "ajaxDelete", id: id  }
					})
					  .done(function( result ) {
						 //$("#contentDIV").html(result);
						getRoom(currentPage,category, true);//show the updated list after delete
					});		
			} 
		}); 
		
	}

	function populateNoOfFloorByBuildingId(id) {
	
		$.ajax({
			  type: "GET",
			  url: "room.do?command=ajaxGetNoOfFloorByBuildingId&buildingId="+id,
			  cache: false,
			  data: $("#idForm").serialize() 
			})
			  .done(function( result ) {
				$("#noOfFloorDIVId").html(result);
			});
		
	}
	
	
	//Equipment
	function goToEquipment() {
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "equipment.do?"
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});
	}

	function goToAddEquipment() {
		$.ajax({
			  type: "GET",
			  url: "equipment.do?",
			  cache: false,
			  data: { command: "ajaxAdd" }
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});
	}

	function getEquipment(pageCriteria, category, isDeleted) {

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
			  url: "equipment.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
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

	function saveEquipment() {

		if ($("#entityNameId").val()!=null) {
			$("#entityNameId").val(convertToTitleCase($("#entityNameId").val()));
		}
		
		$.ajax({
			  type: "POST",
			  url: "saveEquipment.do?command=ajaxSave",
			  data: $("#idForm").serialize() 
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});

	}

	function editEquipment(id) {
		$.ajax({
			  type: "GET",
			  url: "equipment.do?",
			  cache: false,
			  data: { command: "ajaxEdit", id: id  }
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});

	}

	function updateEquipment() {
		
		if ($("#entityNameId").val()!=null) {
			$("#entityNameId").val(convertToTitleCase($("#entityNameId").val()));
		}
		
		bootbox.confirm("Are you sure you want to update this record?", function(ans) {
			  //Example.show("Confirm result: "+result);
			 if (ans) {
					$.ajax({
						  type: "POST",
						  url: "updateEquipment.do?command=ajaxUpdate",
						  data: $("#idForm").serialize() 
						})
						  .done(function( result ) {
							$("#contentDIV").html(result);
					});
			 } 
		}); 

	}

	function deleteEquipment(id, category, currentPage) {
		
		bootbox.confirm("Are you sure you want to delete this record?", function(ans) {
			  //Example.show("Confirm result: "+result);
			if (ans) {
				$.ajax({
					  type: "POST",
					  url: "deleteEquipment.do?",
					  data: { command: "ajaxDelete", id: id  }
					})
					  .done(function( result ) {
						 //$("#contentDIV").html(result);
						getEquipment(currentPage,category, true);//show the updated list after delete
					});		
			} 
		}); 
		
	}

	//Specialization
	function goToSpecialization() {
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "specialization.do?"
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});
	}

	function goToAddSpecialization() {
		$.ajax({
			  type: "GET",
			  url: "specialization.do?",
			  cache: false,
			  data: { command: "ajaxAdd" }
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});
	}

	function getSpecialization(pageCriteria, category, isDeleted) {

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
			  url: "specialization.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
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

	function saveSpecialization() {
		
		if ($("#entityNameId").val()!=null) {
			$("#entityNameId").val(convertToTitleCase($("#entityNameId").val()));
		}
		
		$.ajax({
			  type: "POST",
			  url: "saveSpecialization.do?command=ajaxSave",
			  data: $("#idForm").serialize() 
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});

	}

	function editSpecialization(id) {
		$.ajax({
			  type: "GET",
			  url: "specialization.do?",
			  cache: false,
			  data: { command: "ajaxEdit", id: id  }
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});

	}

	function updateSpecialization() {
		
		if ($("#entityNameId").val()!=null) {
			$("#entityNameId").val(convertToTitleCase($("#entityNameId").val()));
		}
		
		bootbox.confirm("Are you sure you want to update this record?", function(ans) {
			  //Example.show("Confirm result: "+result);
			 if (ans) {
					$.ajax({
						  type: "POST",
						  url: "updateSpecialization.do?command=ajaxUpdate",
						  data: $("#idForm").serialize() 
						})
						  .done(function( result ) {
							$("#contentDIV").html(result);
					});
			 } 
		}); 

	}

	function deleteSpecialization(id, category, currentPage) {
		
		bootbox.confirm("Are you sure you want to delete this record?", function(ans) {
			  //Example.show("Confirm result: "+result);
			if (ans) {
				$.ajax({
					  type: "POST",
					  url: "deleteSpecialization.do?",
					  data: { command: "ajaxDelete", id: id  }
					})
					  .done(function( result ) {
						 //$("#contentDIV").html(result);
						getSpecialization(currentPage,category, true);//show the updated list after delete
					});		
			} 
		}); 
		
	}
	
	//Other Services
	function goToOtherServices() {
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "otherServices.do?"
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});
	}

	function goToAddOtherServices() {
		$.ajax({
			  type: "GET",
			  url: "otherServices.do?",
			  cache: false,
			  data: { command: "ajaxAdd" }
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
				$("#descriptionId").focus();
			});
	}

	function getOtherServices(pageCriteria, category, isDeleted) {

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
			  url: "otherServices.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
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

	function saveOtherServices() {
		
		$.ajax({
			  type: "POST",
			  url: "saveOtherServices.do?command=ajaxSave",
			  data: $("#idForm").serialize() 
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});

	}

	function editOtherServices(id) {
		$.ajax({
			  type: "GET",
			  url: "otherServices.do?",
			  cache: false,
			  data: { command: "ajaxEdit", id: id  }
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});

	}

	function updateOtherServices() {
		
		bootbox.confirm("Are you sure you want to update this record?", function(ans) {
			  //Example.show("Confirm result: "+result);
			 if (ans) {
					$.ajax({
						  type: "POST",
						  url: "updateOtherServices.do?command=ajaxUpdate",
						  data: $("#idForm").serialize() 
						})
						  .done(function( result ) {
							$("#contentDIV").html(result);
					});
			 } 
		}); 

	}

	function deleteOtherServices(id, category, currentPage) {
		
		bootbox.confirm("Are you sure you want to delete this record?", function(ans) {
			  //Example.show("Confirm result: "+result);
			if (ans) {
				$.ajax({
					  type: "POST",
					  url: "deleteOtherServices.do?",
					  data: { command: "ajaxDelete", id: id  }
					})
					  .done(function( result ) {
						 //$("#contentDIV").html(result);
						getOtherServices(currentPage,category, true);//show the updated list after delete
					});		
			} 
		}); 
		
	}
		
	//Additional Services
	function goToAdditionalServices() {
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "additionalServices.do?"
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});
	}

	function goToAddAdditionalServices() {
		$.ajax({
			  type: "GET",
			  url: "additionalServices.do?",
			  cache: false,
			  data: { command: "ajaxAdd" }
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});
	}

	function getAdditionalServices(pageCriteria, category, isDeleted) {

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
			  url: "additionalServices.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
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

	function saveAdditionalServices() {
		
		if ($("#descriptionId").val()!=null) {
			$("#descriptionId").val(convertToTitleCase($("#descriptionId").val()));
		}
		
		$.ajax({
			  type: "POST",
			  url: "saveAdditionalServices.do?command=ajaxSave",
			  data: $("#idForm").serialize() 
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});

	}

	function editAdditionalServices(id) {
		$.ajax({
			  type: "GET",
			  url: "additionalServices.do?",
			  cache: false,
			  data: { command: "ajaxEdit", id: id  }
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});

	}

	function updateAdditionalServices() {
		
		if ($("#descriptionId").val()!=null) {
			$("#descriptionId").val(convertToTitleCase($("#descriptionId").val()));
		}
		
		bootbox.confirm("Are you sure you want to update this record?", function(ans) {
			  //Example.show("Confirm result: "+result);
			 if (ans) {
					$.ajax({
						  type: "POST",
						  url: "updateAdditionalServices.do?command=ajaxUpdate",
						  data: $("#idForm").serialize() 
						})
						  .done(function( result ) {
							$("#contentDIV").html(result);
					});
			 } 
		}); 

	}

	function deleteAdditionalServices(id, category, currentPage) {
		
		bootbox.confirm("Are you sure you want to delete this record?", function(ans) {
			  //Example.show("Confirm result: "+result);
			if (ans) {
				$.ajax({
					  type: "POST",
					  url: "deleteAdditionalServices.do?",
					  data: { command: "ajaxDelete", id: id  }
					})
					  .done(function( result ) {
						 //$("#contentDIV").html(result);
						getAdditionalServices(currentPage,category, true);//show the updated list after delete
					});		
			} 
		}); 
		
	}
	
	//Additional Services Category
	function goToAdditionalServicesCategory() {
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "additionalServicesCategory.do?"
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});
	}

	function goToAddAdditionalServicesCategory() {
		$.ajax({
			  type: "GET",
			  url: "additionalServicesCategory.do?",
			  cache: false,
			  data: { command: "ajaxAdd" }
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
				$("#descriptionId").focus();
			});
	}

	function getAdditionalServicesCategory(pageCriteria, category, isDeleted) {

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
			  url: "additionalServicesCategory.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
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

	function saveAdditionalServicesCategory() {
		
		if ($("#descriptionId").val()!=null) {
			$("#descriptionId").val(convertToTitleCase($("#descriptionId").val()));
		}
		
		$.ajax({
			  type: "POST",
			  url: "saveAdditionalServicesCategory.do?command=ajaxSave",
			  data: $("#idForm").serialize() 
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});

	}

	function editAdditionalServicesCategory(id) {
		$.ajax({
			  type: "GET",
			  url: "additionalServicesCategory.do?",
			  cache: false,
			  data: { command: "ajaxEdit", id: id  }
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});

	}

	function updateAdditionalServicesCategory() {
		
		if ($("#descriptionId").val()!=null) {
			$("#descriptionId").val(convertToTitleCase($("#descriptionId").val()));
		}
		
		bootbox.confirm("Are you sure you want to update this record?", function(ans) {
			  //Example.show("Confirm result: "+result);
			 if (ans) {
					$.ajax({
						  type: "POST",
						  url: "updateAdditionalServicesCategory.do?command=ajaxUpdate",
						  data: $("#idForm").serialize() 
						})
						  .done(function( result ) {
							$("#contentDIV").html(result);
					});
			 } 
		}); 

	}

	function deleteAdditionalServicesCategory(id, category, currentPage) {
		
		bootbox.confirm("Are you sure you want to delete this record?", function(ans) {
			  //Example.show("Confirm result: "+result);
			if (ans) {
				$.ajax({
					  type: "POST",
					  url: "deleteAdditionalServicesCategory.do?",
					  data: { command: "ajaxDelete", id: id  }
					})
					  .done(function( result ) {
						 //$("#contentDIV").html(result);
						getAdditionalServicesCategory(currentPage,category, true);//show the updated list after delete
					});		
			} 
		}); 
		
	}
	
	//Radiology
	function goToRadiology() {
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "radiology.do?"
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});
	}

	function goToAddRadiology() {
		$.ajax({
			  type: "GET",
			  url: "radiology.do?",
			  cache: false,
			  data: { command: "ajaxAdd" }
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});
	}

	function getRadiology(pageCriteria, category, isDeleted) {

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
			  url: "radiology.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
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

	function saveRadiology() {
		
		if ($("#descriptionId").val()!=null) {
			$("#descriptionId").val(convertToTitleCase($("#descriptionId").val()));
		}
		
		$.ajax({
			  type: "POST",
			  url: "saveRadiology.do?command=ajaxSave",
			  data: $("#idForm").serialize() 
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});

	}

	function editRadiology(id) {
		$.ajax({
			  type: "GET",
			  url: "radiology.do?",
			  cache: false,
			  data: { command: "ajaxEdit", id: id  }
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});

	}

	function updateRadiology() {
		
		if ($("#descriptionId").val()!=null) {
			$("#descriptionId").val(convertToTitleCase($("#descriptionId").val()));
		}
		
		bootbox.confirm("Are you sure you want to update this record?", function(ans) {
			  //Example.show("Confirm result: "+result);
			 if (ans) {
					$.ajax({
						  type: "POST",
						  url: "updateRadiology.do?command=ajaxUpdate",
						  data: $("#idForm").serialize() 
						})
						  .done(function( result ) {
							$("#contentDIV").html(result);
					});
			 } 
		}); 

	}

	function deleteRadiology(id, category, currentPage) {
		
		bootbox.confirm("Are you sure you want to delete this record?", function(ans) {
			  //Example.show("Confirm result: "+result);
			if (ans) {
				$.ajax({
					  type: "POST",
					  url: "deleteRadiology.do?",
					  data: { command: "ajaxDelete", id: id  }
					})
					  .done(function( result ) {
						 //$("#contentDIV").html(result);
						getRadiology(currentPage,category, true);//show the updated list after delete
					});		
			} 
		}); 
		
	}
	
	//Medical Supply
	function goToMedicalSupply() {
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "medicalSupply.do?"
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});
	}

	function goToAddMedicalSupply() {
		$.ajax({
			  type: "GET",
			  url: "medicalSupply.do?",
			  cache: false,
			  data: { command: "ajaxAdd" }
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});
	}

	function getMedicalSupply(pageCriteria, category, isDeleted) {

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
			  url: "medicalSupply.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
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

	function saveMedicalSupply() {
		
		if ($("#descriptionId").val()!=null) {
			$("#descriptionId").val(convertToTitleCase($("#descriptionId").val()));
		}
		if ($("#genericNameId").val()!=null) {
			$("#genericNameId").val(convertToTitleCase($("#genericNameId").val()));
		}
		
		$.ajax({
			  type: "POST",
			  url: "saveMedicalSupply.do?command=ajaxSave",
			  data: $("#idForm").serialize() 
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});

	}

	function editMedicalSupply(id) {
		$.ajax({
			  type: "GET",
			  url: "medicalSupply.do?",
			  cache: false,
			  data: { command: "ajaxEdit", id: id  }
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});

	}

	function updateMedicalSupply() {
		
		if ($("#descriptionId").val()!=null) {
			$("#descriptionId").val(convertToTitleCase($("#descriptionId").val()));
		}
		if ($("#genericNameId").val()!=null) {
			$("#genericNameId").val(convertToTitleCase($("#genericNameId").val()));
		}
		
		bootbox.confirm("Are you sure you want to update this record?", function(ans) {
			  //Example.show("Confirm result: "+result);
			 if (ans) {
					$.ajax({
						  type: "POST",
						  url: "updateMedicalSupply.do?command=ajaxUpdate",
						  data: $("#idForm").serialize() 
						})
						  .done(function( result ) {
							$("#contentDIV").html(result);
					});
			 } 
		}); 

	}

	function deleteMedicalSupply(id, category, currentPage) {
		
		bootbox.confirm("Are you sure you want to delete this record?", function(ans) {
			  //Example.show("Confirm result: "+result);
			if (ans) {
				$.ajax({
					  type: "POST",
					  url: "deleteMedicalSupply.do?",
					  data: { command: "ajaxDelete", id: id  }
					})
					  .done(function( result ) {
						 //$("#contentDIV").html(result);
						getMedicalSupply(currentPage,category, true);//show the updated list after delete
					});		
			} 
		}); 
		
	}
			
	//Laboratory Examination
	function goToLaboratoryExamination() {
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "laboratoryExamination.do?"
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});
	}

	function goToAddLaboratoryExamination() {
		$.ajax({
			  type: "GET",
			  url: "laboratoryExamination.do?",
			  cache: false,
			  data: { command: "ajaxAdd" }
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});
	}

	function getLaboratoryExamination(pageCriteria, category, isDeleted) {

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
			  url: "laboratoryExamination.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
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

	function saveLaboratoryExamination() {
		
		if ($("#descriptionId").val()!=null) {
			$("#descriptionId").val(convertToTitleCase($("#descriptionId").val()));
		}
		
		$.ajax({
			  type: "POST",
			  url: "saveLaboratoryExamination.do?command=ajaxSave",
			  data: $("#idForm").serialize() 
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});

	}

	function editLaboratoryExamination(id) {
		$.ajax({
			  type: "GET",
			  url: "laboratoryExamination.do?",
			  cache: false,
			  data: { command: "ajaxEdit", id: id  }
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});

	}

	function updateLaboratoryExamination() {
		
		if ($("#descriptionId").val()!=null) {
			$("#descriptionId").val(convertToTitleCase($("#descriptionId").val()));
		}
		
		bootbox.confirm("Are you sure you want to update this record?", function(ans) {
			  //Example.show("Confirm result: "+result);
			 if (ans) {
					$.ajax({
						  type: "POST",
						  url: "updateLaboratoryExamination.do?command=ajaxUpdate",
						  data: $("#idForm").serialize() 
						})
						  .done(function( result ) {
							$("#contentDIV").html(result);
					});
			 } 
		}); 

	}

	function deleteLaboratoryExamination(id, category, currentPage) {
		
		bootbox.confirm("Are you sure you want to delete this record?", function(ans) {
			  //Example.show("Confirm result: "+result);
			if (ans) {
				$.ajax({
					  type: "POST",
					  url: "deleteLaboratoryExamination.do?",
					  data: { command: "ajaxDelete", id: id  }
					})
					  .done(function( result ) {
						 //$("#contentDIV").html(result);
						getLaboratoryExamination(currentPage,category, true);//show the updated list after delete
					});		
			} 
		}); 
		
	}
	
	
	
	//Professional Type
	function goToProfessionalType() {
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "professionalType.do?"
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});
	}

	function goToAddProfessionalType() {
		$.ajax({
			  type: "GET",
			  url: "professionalType.do?",
			  cache: false,
			  data: { command: "ajaxAdd" }
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});
	}

	function getProfessionalType(pageCriteria, category, isDeleted) {

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
			  url: "professionalType.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
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

	function saveProfessionalType() {
		
		if ($("#descriptionId").val()!=null) {
			$("#descriptionId").val(convertToTitleCase($("#descriptionId").val()));
		}
		
		$.ajax({
			  type: "POST",
			  url: "saveProfessionalType.do?command=ajaxSave",
			  data: $("#idForm").serialize() 
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});

	}

	function editProfessionalType(id) {
		$.ajax({
			  type: "GET",
			  url: "professionalType.do?",
			  cache: false,
			  data: { command: "ajaxEdit", id: id  }
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});

	}

	function updateProfessionalType() {
		
		if ($("#descriptionId").val()!=null) {
			$("#descriptionId").val(convertToTitleCase($("#descriptionId").val()));
		}
		
		bootbox.confirm("Are you sure you want to update this record?", function(ans) {
			  //Example.show("Confirm result: "+result);
			 if (ans) {
					$.ajax({
						  type: "POST",
						  url: "updateProfessionalType.do?command=ajaxUpdate",
						  data: $("#idForm").serialize() 
						})
						  .done(function( result ) {
							$("#contentDIV").html(result);
					});
			 } 
		}); 

	}

	function deleteProfessionalType(id, category, currentPage) {
		
		bootbox.confirm("Are you sure you want to delete this record?", function(ans) {
			  //Example.show("Confirm result: "+result);
			if (ans) {
				$.ajax({
					  type: "POST",
					  url: "deleteProfessionalType.do?",
					  data: { command: "ajaxDelete", id: id  }
					})
					  .done(function( result ) {
						 //$("#contentDIV").html(result);
						getProfessionalType(currentPage,category, true);//show the updated list after delete
					});		
			} 
		}); 
		
	}

	//Surgery
	function goToSurgery() {
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "surgery.do?"
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});
	}

	function goToAddSurgery() {
		$.ajax({
			  type: "GET",
			  url: "surgery.do?",
			  cache: false,
			  data: { command: "ajaxAdd" }
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});
	}

	function getSurgery(pageCriteria, category, isDeleted) {

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
			  url: "surgery.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
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

	function saveSurgery() {
		
		if ($("#descriptionId").val()!=null) {
			$("#descriptionId").val(convertToTitleCase($("#descriptionId").val()));
		}
		
		$.ajax({
			  type: "POST",
			  url: "saveSurgery.do?command=ajaxSave",
			  data: $("#idForm").serialize() 
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});

	}

	function editSurgery(id) {
		$.ajax({
			  type: "GET",
			  url: "surgery.do?",
			  cache: false,
			  data: { command: "ajaxEdit", id: id  }
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});

	}

	function updateSurgery() {
		
		if ($("#descriptionId").val()!=null) {
			$("#descriptionId").val(convertToTitleCase($("#descriptionId").val()));
		}
		
		bootbox.confirm("Are you sure you want to update this record?", function(ans) {
			  //Example.show("Confirm result: "+result);
			 if (ans) {
					$.ajax({
						  type: "POST",
						  url: "updateSurgery.do?command=ajaxUpdate",
						  data: $("#idForm").serialize() 
						})
						  .done(function( result ) {
							$("#contentDIV").html(result);
					});
			 } 
		}); 

	}

	function deleteSurgery(id, category, currentPage) {
		
		bootbox.confirm("Are you sure you want to delete this record?", function(ans) {
			  //Example.show("Confirm result: "+result);
			if (ans) {
				$.ajax({
					  type: "POST",
					  url: "deleteSurgery.do?",
					  data: { command: "ajaxDelete", id: id  }
					})
					  .done(function( result ) {
						 //$("#contentDIV").html(result);
						getSurgery(currentPage,category, true);//show the updated list after delete
					});		
			} 
		}); 
		
	}
	
	
	//Professional
	function goToProfessional() {
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "professional.do?"
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});
	}

	function goToAddProfessional() {
		$.ajax({
			  type: "GET",
			  url: "professional.do?",
			  cache: false,
			  data: { command: "ajaxAdd" }
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});
	}

	function getProfessional(pageCriteria, category, isDeleted) {

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
			  url: "professional.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
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

	function saveProfessional() {
		
		if ($("#lastNameId").val()!=null) {
			$("#lastNameId").val(convertToTitleCase($("#lastNameId").val()));
		}
		if ($("#firstNameId").val()!=null) {
			$("#firstNameId").val(convertToTitleCase($("#firstNameId").val()));
		}
		if ($("#middleNameId").val()!=null) {
			$("#middleNameId").val(convertToTitleCase($("#middleNameId").val()));
		}
		
		$.ajax({
			  type: "POST",
			  url: "saveProfessional.do?command=ajaxSave",
			  data: $("#idForm").serialize() 
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});

	}

	function editProfessional(id) {
		$.ajax({
			  type: "GET",
			  url: "professional.do?",
			  cache: false,
			  data: { command: "ajaxEdit", id: id  }
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});

	}

	function updateProfessional() {
		
		if ($("#lastNameId").val()!=null) {
			$("#lastNameId").val(convertToTitleCase($("#lastNameId").val()));
		}
		if ($("#firstNameId").val()!=null) {
			$("#firstNameId").val(convertToTitleCase($("#firstNameId").val()));
		}
		if ($("#middleNameId").val()!=null) {
			$("#middleNameId").val(convertToTitleCase($("#middleNameId").val()));
		}
		
		bootbox.confirm("Are you sure you want to update this record?", function(ans) {
			  //Example.show("Confirm result: "+result);
			 if (ans) {
					$.ajax({
						  type: "POST",
						  url: "updateProfessional.do?command=ajaxUpdate",
						  data: $("#idForm").serialize() 
						})
						  .done(function( result ) {
							$("#contentDIV").html(result);
					});
			 } 
		}); 

	}

	function deleteProfessional(id, category, currentPage) {
		
		bootbox.confirm("Are you sure you want to delete this record?", function(ans) {
			  //Example.show("Confirm result: "+result);
			if (ans) {
				$.ajax({
					  type: "POST",
					  url: "deleteProfessional.do?",
					  data: { command: "ajaxDelete", id: id  }
					})
					  .done(function( result ) {
						 //$("#contentDIV").html(result);
						getProfessional(currentPage,category, true);//show the updated list after delete
					});		
			} 
		}); 
		
	}

	//Discount
	function goToDiscount() {
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "discount.do?"
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});
	}

	function goToAddDiscount() {
		$.ajax({
			  type: "GET",
			  url: "discount.do?",
			  cache: false,
			  data: { command: "ajaxAdd" }
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});
	}

	function getDiscount(pageCriteria, category, isDeleted) {

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
			  url: "discount.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
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

	function saveDiscount() {
		
		if ($("#descriptionId").val()!=null) {
			$("#descriptionId").val(convertToTitleCase($("#descriptionId").val()));
		}
		
		$.ajax({
			  type: "POST",
			  url: "saveDiscount.do?command=ajaxSave",
			  data: $("#idForm").serialize() 
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});

	}

	function editDiscount(id) {
		$.ajax({
			  type: "GET",
			  url: "discount.do?",
			  cache: false,
			  data: { command: "ajaxEdit", id: id  }
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});

	}

	function updateDiscount() {
		
		if ($("#descriptionId").val()!=null) {
			$("#descriptionId").val(convertToTitleCase($("#descriptionId").val()));
		}
		
		bootbox.confirm("Are you sure you want to update this record?", function(ans) {
			  //Example.show("Confirm result: "+result);
			 if (ans) {
					$.ajax({
						  type: "POST",
						  url: "updateDiscount.do?command=ajaxUpdate",
						  data: $("#idForm").serialize() 
						})
						  .done(function( result ) {
							$("#contentDIV").html(result);
					});
			 } 
		}); 

	}

	function deleteDiscount(id, category, currentPage) {
		
		bootbox.confirm("Are you sure you want to delete this record?", function(ans) {
			  //Example.show("Confirm result: "+result);
			if (ans) {
				$.ajax({
					  type: "POST",
					  url: "deleteDiscount.do?",
					  data: { command: "ajaxDelete", id: id  }
					})
					  .done(function( result ) {
						 //$("#contentDIV").html(result);
						getDiscount(currentPage,category, true);//show the updated list after delete
					});		
			} 
		}); 
		
	}
	
	//Patient
	function goToPatient() {
		
		$.ajax({
			  type: "GET",
			  cache: false,
			  url: "patient.do?"
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});
	}

	function getPatient(pageCriteria, category, isDeleted) {

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
			  url: "patient.do?command=ajaxSearch&page="+pageCriteria+"&category="+category,
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

	function editPatient(id) {
		$.ajax({
			  type: "GET",
			  url: "patient.do?",
			  cache: false,
			  data: { command: "ajaxEdit", id: id  }
			})
			  .done(function( result ) {
				$("#contentDIV").html(result);
			});

	}

	function updatePatient() {
		
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
		
		bootbox.confirm("Are you sure you want to update this record?", function(ans) {
			  //Example.show("Confirm result: "+result);
			 if (ans) {
					$.ajax({
						  type: "POST",
						  url: "updatePatient.do?command=ajaxUpdate",
						  data: $("#idForm").serialize() 
						})
						  .done(function( result ) {
							$("#contentDIV").html(result);
					});
			 } 
		}); 

	}

	function deletePatient(id, category, currentPage) {
		
		bootbox.confirm("Are you sure you want to delete this record?", function(ans) {
			  //Example.show("Confirm result: "+result);
			if (ans) {
				$.ajax({
					  type: "POST",
					  url: "deletePatient.do?",
					  data: { command: "ajaxDelete", id: id  }
					})
					  .done(function( result ) {
						 //$("#contentDIV").html(result);
						getPatient(currentPage,category, true);//show the updated list after delete
					});		
			} 
		}); 	
	}

	function cancelPatientEdit() {
		
		bootbox.confirm("Are you sure you want to cancel?", function(ans) {
			  //Example.show("Confirm result: "+result);
			 if (ans) {
				 goToPatient();
			 } 
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
			  data: { command: "ajaxAdd" }
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
		
		if ($("#lastNameId").val()!=null) {
			$("#lastNameId").val(convertToTitleCase($("#lastNameId").val()));
		}
		if ($("#firstNameId").val()!=null) {
			$("#firstNameId").val(convertToTitleCase($("#firstNameId").val()));
		}
		if ($("#middleNameId").val()!=null) {
			$("#middleNameId").val(convertToTitleCase($("#middleNameId").val()));
		}
		
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
		
		if ($("#lastNameId").val()!=null) {
			$("#lastNameId").val(convertToTitleCase($("#lastNameId").val()));
		}
		if ($("#firstNameId").val()!=null) {
			$("#firstNameId").val(convertToTitleCase($("#firstNameId").val()));
		}
		if ($("#middleNameId").val()!=null) {
			$("#middleNameId").val(convertToTitleCase($("#middleNameId").val()));
		}
		
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
			  data: { command: "ajaxAdd" }
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
			  data: { command: "ajaxAdd", 
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