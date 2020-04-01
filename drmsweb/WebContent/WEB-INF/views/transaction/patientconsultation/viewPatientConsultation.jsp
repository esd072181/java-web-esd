<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>DRMS</title>
	<script type="text/javascript" src="resources/js/jquery-1.11.1.js" ></script>
 	<script type="text/javascript" src="resources/js/jquery-ui.min.js" ></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/bootbox.js"></script>
	<link rel="stylesheet" href="resources/style/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="resources/style/jquery-ui.css">
	<style type="text/css">
		.error {
			color: red;
		}
	</style>
	<script>
	
		$(document).ready(function(){
			
		   $('#dtNextConsultDatePicker').datepicker({});
			
		  $('#consultationProcedureId').focus();	
			
		  $('#reportId').click(function(){
		    window.open(this.href);
		    return false;
		  });
		});

		function searchPatientConsultation(page,lastName) {
			window.location.href = 'searchPatientConsultation?page=' + page + '&lastName=' + lastName;
		}
		
		function saveUpdateConsultation(consultId) {
			window.location.href = 'saveUpdateConsultation?consultId=' + consultId;	
		}
		
		function putToMedStatement(medDescription) {
			var str = $('#medicationStatementId').val()
			if (str != '') {
				str = str + ",\n" + medDescription + " - ";
				$('#medicationStatementId').focus().val("").val(str);
			} else {
				medDescription = medDescription + " - "
				$('#medicationStatementId').focus().val("").val(medDescription);
			}

		}

		function addNewMed(consultId, medId, qty) {
			var ans = confirm("Are you sure that patient want to purchase this medicine?");
			if (ans) {
				window.location.href = 'addNewMed?consultId=' + consultId + "&medId=" + medId + "&qty=" + qty;	
			}
		}
		
		function deletePatientMed(consultId,patientMedId) {
			var ans = confirm("Are you sure you want to delete this med?");
			if (ans) {
				window.location.href = 'deletePatientMed?consultId=' + consultId + "&patientMedId=" + patientMedId;	
			}
		}
		
		function goToPayNow(consultId) {
			var totalBill = parseFloat($('#totalBillId').val());
			var tenderedAmt = parseFloat($('#tenderedAmountId').val());
			
			if (isNaN(tenderedAmt)) {
				alert('Invalid tendered amount. Only numbers are allowed.');
				$('#tenderedAmountId').val('')
				$('#tenderedAmountId').focus();
				return false;
			}
			
			if (totalBill>tenderedAmt) {
				alert('Invalid tendered amount! Tendered amount should be equal or greater than the total bill.');
				$('#tenderedAmountId').val('')
				$('#tenderedAmountId').focus();
				return false;
			}
			
			var ans = confirm("Are you sure you want to process payment?");
			if (ans) {
				window.location.href = 'goToPayNow?consultId=' + consultId+'&tenderedAmt='+tenderedAmt;	
			}
			return false;
		}
		
		function updateFee(consultId,fee) {
			window.location.href = 'updateFee?consultId=' + consultId + '&fee=' + fee;	
		}
		
		function showPatientHistory(patientId,page) {
			window.open('/drmsweb/showPatientHistory?patientId=' + patientId + '&page=' + page,'popUpWindow','height=600,width=1000,left=100,top=100,resizable=yes,scrollbars=yes,toolbar=yes,menubar=no,location=no,directories=no, status=yes');
		}
						
	</script>
</head>
<body>

	<div style="width: 100%;">

		<form:form action="/drmsweb/saveUpdateConsultation" method="post" modelAttribute="patientConsultation" cssClass="form-horizontal">
		
			<div style="overflow:hidden;">
				<div style="float:left; padding: 5px 0px 0px 10px;">
					<a href="./goToMain" >Back to Home</a><br>					
				</div>
				<div style="float:right; padding: 5px 10px 0px 0px;">
					<a href="./goToSearchPatientConsultation" >Back to Search</a>
				</div>			
			</div>
		
			<div align="center">
				<img src="resources/img/browse_consult01.jpg" alt="PatientConsultation" height="50" width="50">
				<label style="font-size: 24px;">Patient Consultation Details</label>		
			</div>
				
			<c:if test="${isUpdated == true}">
				<br>
				<div align="center">
					<h4 style="color: blue;">Record successfully updated!</h4>
				</div>
			</c:if>
			
			<br>
			
			<form:hidden path="id"/>
			<form:hidden path="patient.id"/>
			
			<table style="width: 100%;">
				<tr>
					<td width="2%"></td>
					<td>
						<div class="form-group">
							<form:label path="patient.fullName" cssClass="col-sm-2 control-label">Name:</form:label>
							<div class="col-xs-3">
			      				<form:input path="patient.fullName" cssClass="form-control input-sm" readonly="true" cssStyle="color: blue;"/>
			    			</div>
			    			<form:label path="consultNo" cssClass="col-sm-2 control-label">Consultation No:</form:label>
							<div class="col-xs-3">
			      				<form:input path="consultNo" cssClass="form-control input-sm" readonly="true" cssStyle="color: blue;"/>
			    			</div>
						</div>						
					</td>
				</tr>
				<tr>
					<td width="2%"></td>
					<td>
						<div class="form-group">
							<form:label path="age" cssClass="col-sm-2 control-label">Age:</form:label>
							<div class="col-xs-3">
			      				<form:input path="age" cssClass="form-control input-sm" readonly="true" cssStyle="color: blue;"/>
			    			</div>
			    			<form:label path="professional.fullName" cssClass="col-sm-2 control-label">Dentist:</form:label>
							<div class="col-xs-3">
			      				<form:input path="professional.fullName" cssClass="form-control input-sm" readonly="true" cssStyle="color: blue;"/>
			    			</div>
						</div>					
					</td>
				</tr>	
				<tr>
					<td width="2%"></td>
					<td>
						<div class="form-group">
							<form:label path="chiefComplaint" cssClass="col-sm-2 control-label">Chief Complaint/Request:</form:label>
							<div class="col-xs-3">
			      				<form:textarea path="chiefComplaint" cssClass="form-control input-sm" readonly="true" cssStyle="color: blue;"/>
			    			</div>
			    			<form:label path="consultDate" cssClass="col-sm-2 control-label">Consultation Date:</form:label>
							<div class="col-xs-3">
			      				<form:input path="consultDate" cssClass="form-control input-sm" readonly="true" cssStyle="color: blue;"/>
			    			</div>
						</div>					
					</td>
				</tr>
				<tr>
					<td width="2%"></td>
					<td>
						<div class="form-group">
							<form:label path="diagnosis" cssClass="col-sm-2 control-label">Diagnosis:</form:label>
							<div class="col-xs-3">
								<c:choose>
									<c:when test="${roleid == 501}">
										<form:textarea id="diagnosisId" path="diagnosis" cssClass="form-control input-sm" cssStyle="color: blue;"/>
									</c:when>
									<c:otherwise>
										<form:textarea readonly="true" id="diagnosisId" path="diagnosis" cssClass="form-control input-sm" cssStyle="color: blue;"/>
									</c:otherwise>
								</c:choose>
			    			</div>
							<form:label path="medicationStatement" cssClass="col-sm-2 control-label">Medication Statement:</form:label>
							<div class="col-xs-3">
								<c:choose>
									<c:when test="${roleid == 501}">
										<form:textarea id="medicationStatementId" path="medicationStatement" cssClass="form-control input-sm" cssStyle="color: blue;"/>
									</c:when>
									<c:otherwise>
										<form:textarea readonly="true" id="medicationStatementId" path="medicationStatement" cssClass="form-control input-sm" cssStyle="color: blue;"/>
									</c:otherwise>
								</c:choose>
			    			</div>
						</div>					
					</td>
				</tr>
				<tr>
					<td width="2%"></td>
					<td>
						<div class="form-group">
							<form:label path="consultationProcedure" cssClass="col-sm-2 control-label">Consultation Procedure:</form:label>
							<div class="col-xs-8">
								<c:choose>
									<c:when test="${roleid == 501}">
										<form:textarea id="consultationProcedureId" cols="50" rows="2" path="consultationProcedure" cssClass="form-control input-sm" cssStyle="color: blue;"/>
									</c:when>
									<c:otherwise>
										<form:textarea disabled="true" cols="50" rows="2" path="consultationProcedure" cssClass="form-control input-sm" cssStyle="color: blue;"/>
									</c:otherwise>
								</c:choose>
			    			</div>
						</div>					
					</td>
				</tr>
				<tr>
					<td width="2%"></td>
					<td>
						<div class="form-group">
							<form:label path="nextConsultDate" cssClass="col-sm-2 control-label">Next Consultation Date:</form:label>
							<div class="col-xs-3">
				      			<form:input id="dtNextConsultDatePicker" placeholder="MM/dd/yyyy" path="nextConsultDate" cssClass="form-control input-sm" cssStyle="color: blue;"/>
				    		</div>
				    		<form:label path="status.listValue" cssClass="col-sm-2 control-label">Consultation Status:</form:label>
						    <div class="col-xs-3">
						    	<c:choose>
							    	<c:when test="${patientConsultation.status.listValue  == 'Completed'}">
							    		<form:input path="status.listValue" cssClass="form-control input-sm" readonly="true" cssStyle="color: blue;"/>
							    	</c:when>
							    	<c:otherwise>
							    		<form:input path="status.listValue" cssClass="form-control input-sm" readonly="true" cssStyle="color: red;"/>
							    	</c:otherwise>
						    	</c:choose>
						    </div>
						</div>
					</td>
				</tr>
			</table>
			
			<c:choose>
				<c:when test="${roleid == 501}">
					<table style="width: 100%;">
						<tr align="center">
							<td>
								<input class="btn btn-default" type="submit" value="Save/Update Consultation Details" >
								<a style="padding-left: 20px;" id="reportId" href="./viewPrescriptionReport?consultId=${patientConsultation.id}" >Click here to view Prescription</a>
								<a href="#" onclick="showPatientHistory(${patientConsultation.patient.id},1);" style="padding-left: 20px;">Show Patient History</a>
							</td>
						</tr>
					</table>
				</c:when>
				<c:otherwise>	
					<table style="width: 100%;">
						<tr align="center">
							<td>
								<a style="padding-left: 20px;" id="reportId" href="./viewPrescriptionReport?consultId=${patientConsultation.id}" >Click here to view Prescription</a>
							</td>
						</tr>
					</table>					
				</c:otherwise>	
			</c:choose>

			<hr>

			<!-- Add new Med -->
			<c:if test="${patientConsultation.paymentStatus.id == 301}">
				<div>
					<div class="form-group">
						<form:label path="medId" cssClass="col-sm-2 control-label">Select Medicine:</form:label>
				    	<c:choose>
							<c:when test="${roleid == 501}">
								<!-- Put it in the Medication Statement only for Admin/Doctor -->
								<div class="col-xs-3">
									<form:select id="medSelectedId" path="medId" items="${medList}"  itemValue="description"   itemLabel="description" cssClass="form-control input-sm">
									</form:select>
						    	</div>
								<input class="btn btn-default" type="button" value="Add New Medicine in Medication Statement" onclick="putToMedStatement(document.getElementById('medSelectedId').value);">
							</c:when>
							<c:otherwise>
								<!-- Purchase Medicine -->
								<div class="col-xs-3">
									<form:select id="medSelectedId" path="medId" items="${medList}"  itemValue="id"   itemLabel="description" cssClass="form-control input-sm">
									</form:select>
						    	</div>
						    	<label>Qty</label>
						    	<input type="text" id="qtyId" name="qty" style="width: 30px;"/>
								<input class="btn btn-default" type="button" value="Purchase Medicine" onclick="addNewMed(${patientConsultation.id},document.getElementById('medSelectedId').value,document.getElementById('qtyId').value);">
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</c:if>
						
			<c:if test="${patientConsultation.patientMedRecords.size() > 0}">
				<!-- Medicine -->		
				<div align="left" style="padding-left: 20px;">
					<h4>Purchased Medicines:</h4>
				</div>
								
					<div align="center" class="table-responsive" style="width: 60%; padding-left: 20px;">
							<table class="table table-striped table-hover table-bordered table-responsive" style="font-size: 11px;">
								<tr style="font-weight: bold;">
									<td>No</td>
									<td>Description</td>
									<td align="right">Qty</td>
									<td align="right">Price</td>
									<td align="right">Amount</td>
									<c:if test="${patientConsultation.paymentStatus.id == 301}">
										<td></td>
									</c:if>
								</tr>
								<!-- loop here -->
								<c:forEach items="${patientConsultation.patientMedRecords}" var="model" varStatus = "row">
								    <tr>
								    	<td>${row.count}</td>
										<td>${model.med.description}</td>
										<td>${model.qty}</td>
										<td>${model.price}</td>
										<td align="right">${model.amount}</td>
										<!-- Below Med delete code is for Admin and User -->
										<c:if test="${patientConsultation.paymentStatus.id == 301}">
											<td align="center"><a href="#" onclick="deletePatientMed(${patientConsultation.id},${model.id});" >Delete</a></td>		
										</c:if>
								    </tr>
								</c:forEach>
								
							</table>
						</div>
						
				<div class="form-group">
					<form:label path="totalMedAmount" cssClass="col-sm-2 control-label">Total Medicine (Php):</form:label>
					<div class="col-xs-1">
			      		<form:input path="totalMedAmount" cssClass="form-control input-sm" cssStyle="text-align:right;" readonly="true"/>
			    	</div>
				</div>	
			</c:if>	

				
								
			<div class="form-group">
				<!-- Consultation Fee -->		
				<form:label path="" cssClass="col-sm-2 control-label">Consultation Fee (Php):</form:label>
				<c:choose>
					<c:when test="${patientConsultation.status.id == 201}">
						<div class="col-xs-1">
							<form:input id="consultFeeInputId" path="" cssClass="form-control input-sm" value="${consultFee}" cssStyle="text-align:right;"/>
						</div>
					</c:when>
					<c:otherwise>
						<div class="col-xs-1">
			      			<form:input id="consultFeeInputId" path="" cssClass="form-control input-sm" value="${consultFee}" cssStyle="text-align:right;" readonly="true"/>
			    		</div>
					</c:otherwise>
				</c:choose>
				<c:if test="${patientConsultation.status.id == 201}">
					<input class="btn btn-default" type="button" value="Update Fee" onclick="updateFee(${patientConsultation.id},document.getElementById('consultFeeInputId').value);">
				</c:if> 
			</div>

			<div class="form-group">
				<form:label path="" cssClass="col-sm-2 control-label">Total Bill (Php):</form:label>
				<div class="col-xs-1">
					<form:input id="totalBillId" path="" cssClass="form-control input-sm" value="${totalBill}" cssStyle="text-align:right; color:blue; font-weight:bold; font-size: 14px;" readonly="true"/>
				</div>
			</div>
			
			<c:if test="${patientConsultation.paymentStatus.id == 301}">
				<div class="form-group">
					<form:label path="" cssClass="col-sm-2 control-label">Tendered Amount (Php):</form:label>
					<div class="col-xs-1">
						<form:input id="tenderedAmountId" path="" cssClass="form-control input-sm" value="${tenderedAmt}" cssStyle="text-align:right; color:blue; font-size: 14px;"/>
					</div>
				</div>		
			</c:if>
			
			<!-- Show both fields after payment done -->
			<c:if test="${changeAmt!=null}">
				<div class="form-group">
					<form:label path="" cssClass="col-sm-2 control-label">Tendered Amount (Php):</form:label>
					<div class="col-xs-1">
						<form:input id="tenderedAmountId" path="" cssClass="form-control input-sm" value="${tenderedAmt}" cssStyle="text-align:right; color:blue; font-size: 14px;" readonly="true"/>
					</div>
				</div>	
	
				<div class="form-group">
					<form:label path="" cssClass="col-sm-2 control-label">Change Amount (Php):</form:label>
					<div class="col-xs-1">
						<form:input id="changeAmountId" path="" cssClass="form-control input-sm" value="${changeAmt}" cssStyle="text-align:right; color:blue; font-weight:bold; font-size: 14px;" readonly="true"/>
					</div>
				</div>			
			</c:if>

			<div class="form-group">	
				<form:label path="paymentStatus.listValue" cssClass="col-sm-2 control-label">Payment Status:</form:label>
				<div class="col-xs-1">
					<c:choose>
						<c:when test="${patientConsultation.paymentStatus.id == 301}">
							<form:input path="paymentStatus.listValue" cssClass="form-control input-sm" cssStyle="color:red;" readonly="true"/>	
						</c:when>
						<c:otherwise>
							<form:input path="paymentStatus.listValue" cssClass="form-control input-sm" cssStyle="color:blue;" readonly="true"/>
						</c:otherwise>
					</c:choose>
					
				</div>
				<c:if test="${patientConsultation.paymentStatus.id == 301}">
					<input class="btn btn-default" type="button" value="Pay Now" onclick="goToPayNow(${patientConsultation.id});">
				</c:if>
			</div>	
			
		</form:form>

	</div>
	
</body>
</html>