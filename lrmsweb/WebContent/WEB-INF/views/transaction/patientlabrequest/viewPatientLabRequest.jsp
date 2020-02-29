<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>LRMS</title>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/bootbox.js"></script>
	<script type="text/javascript" src="resources/js/jquery-1.11.1.js" ></script>
 	<script type="text/javascript" src="resources/js/jquery-ui.min.js" ></script>
	<link rel="stylesheet" href="resources/style/bootstrap.min.css">
	<style type="text/css">
		.error {
			color: red;
		}
	</style>
	<script>
	
		$(document).ready(function(){
		  $('#inputExamResult1').click(function(){
		    window.open(this.href);
		    return false;
		  });
		  $('#inputExamResult2').click(function(){
			    window.open(this.href);
			    return false;
			  });
		  $('#inputExamResult3').click(function(){
			    window.open(this.href);
			    return false;
			  });
		  $('#inputExamResult4').click(function(){
			    window.open(this.href);
			    return false;
			  });
		  $('#inputExamResult5').click(function(){
			    window.open(this.href);
			    return false;
			  });
		});
		
		function goToPayNow(labRequestId) {
			var ans = confirm("Are you sure you want to process payment?");
			if (ans) {
				window.location.href = 'goToPayNow?labRequestId=' + labRequestId;	
			}
		}
		
		function addNewLabExam(labRequestId, labExamId) {
			var ans = confirm("Are you sure you want add new lab exam request?");
			if (ans) {
				window.location.href = 'addNewLabExam?labRequestId=' + labRequestId + "&labExamId=" + labExamId;	
			}
		}
		
		function searchPatientLabRequest(page,lastName) {
			window.location.href = 'searchPatientLabRequest?page=' + page + '&lastName=' + lastName;
		}
		function deletePatientLabExam(labRequestId,patientLabExamId) {
			var ans = confirm("Are you sure you want to delete this lab exam request?");
			if (ans) {
				window.location.href = 'deletePatientLabExam?labRequestId=' + labRequestId + "&patientLabExamId=" + patientLabExamId;	
			}
		}
		function releaseLabExamResult(labRequestId) {
			var ans = confirm("Are you sure you want to release lab exam result?");
			if (ans) {
				window.location.href = 'releaseLabExamResult?labRequestId=' + labRequestId;	
			}
		}
	</script>
</head>
<body>

	<div style="width: 100%;">

		<form:form action="/lrmsweb/releaseLabExamResult" method="post" modelAttribute="patientLabRequest" cssClass="form-horizontal">
		
			<div align="left" style="padding: 10px 0px 0px 30px;">
	    		<a href="./goToMain" >Back to Home</a><br>
	    		<a href="./goToSearchPatientLabRequest" >Back to Search</a>
	    	</div>

			<div align="center">
				<img src="resources/img/browse_labreq.jpg" alt="PatientLabRequest" height="50" width="50">
				<label style="font-size: 24px;">Patient Laboratory Examination Request Details</label>		
			</div>
				
			<c:if test="${isUpdated == true}">
				<br>
				<div align="center">
					<h4 style="color: blue;">Record successfully updated!</h4>
				</div>
			</c:if>
			
			<br>
			
			<form:hidden path="patient.id"/>
			
			<table style="width: 100%;">
				<tr>
					<td width="33%"></td>
					<td>
						<div class="form-group">
							<form:label path="labRequestNo" cssClass="col-sm-2 control-label">Lab Request No:</form:label>
							<div class="col-xs-3">
			      				<form:input path="labRequestNo" cssClass="form-control input-sm" readonly="true" cssStyle="color: blue;"/>
			    			</div>
						</div>					
					</td>
				</tr>
				<tr>
					<td width="33%"></td>
					<td>
						<div class="form-group">
							<form:label path="patient.fullName" cssClass="col-sm-2 control-label">Name:</form:label>
							<div class="col-xs-3">
			      				<form:input path="patient.fullName" cssClass="form-control input-sm" readonly="true" cssStyle="color: blue;"/>
			    			</div>
						</div>						
					</td>
				</tr>
				<tr>
					<td width="33%"></td>
					<td>
						<div class="form-group">
							<form:label path="age" cssClass="col-sm-2 control-label">Age:</form:label>
							<div class="col-xs-3">
			      				<form:input path="age" cssClass="form-control input-sm" readonly="true" cssStyle="color: blue;"/>
			    			</div>
						</div>					
					</td>
				</tr>
				<tr>
					<td width="33%"></td>
					<td>
						<div class="form-group">
							<form:label path="professional.fullName" cssClass="col-sm-2 control-label">Requesting Physician:</form:label>
							<div class="col-xs-3">
			      				<form:input path="professional.fullName" cssClass="form-control input-sm" readonly="true" cssStyle="color: blue;"/>
			    			</div>
						</div>					
					</td>
				</tr>
				<tr>
					<td width="33%"></td>
					<td>
						<div class="form-group">
							<form:label path="requestDate" cssClass="col-sm-2 control-label">Date Request:</form:label>
							<div class="col-xs-3">
			      				<form:input path="requestDate" cssClass="form-control input-sm" readonly="true" cssStyle="color: blue;"/>
			    			</div>
						</div>					
					</td>
				</tr>						
			</table>
					
			<div  align="left" style="padding-left: 10px;">
				<h4>Lab Exams Requested:</h4>
			</div>
							
				<div  align="center" class="table-responsive" style="width: 100%; padding-left: 10px;">
						<table class="table table-striped table-hover table-bordered table-responsive" style="font-size: 11px;">
							<tr style="font-weight: bold;">
								<td>No</td>
								<td>Description</td>
								<td align="right">Fee</td>
								<td></td>
								<c:if test="${roleid == 601}">
									<c:if test="${patientLabRequest.paymentStatus.id == 301}">
										<td></td>
									</c:if>
								</c:if>
							</tr>
							<!-- loop here -->
							<c:forEach items="${patientLabRequest.patientLabExamRecords}" var="model" varStatus = "row">
							    <tr>
							    	<td>${row.count}</td>
									<td>${model.labExam.description}</td>
									<td align="right">${model.amount}</td>
									<c:if test="${patientLabRequest.status.id == 201}">
										<td align="center"><a id="inputExamResult${row.count}" href="./goToReportTemplate?patientLabExamId=${model.id}&labRequestId=${patientLabRequest.id}&templateId=${model.labExam.reportTemplate.id}">Input Lab Exam Result</a></td>
									</c:if>
									<c:if test="${patientLabRequest.status.id == 202}">
										<td align="center"><a id="inputExamResult${row.count}" href="./goToReportTemplate?patientLabExamId=${model.id}&labRequestId=${patientLabRequest.id}&templateId=${model.labExam.reportTemplate.id}">View Exam Result</a></td>
									</c:if>
									<!-- Below delete code is for Admin only -->
									<c:if test="${roleid == 601}">
										<c:if test="${patientLabRequest.paymentStatus.id == 301}">
											<td align="center"><a href="#" onclick="deletePatientLabExam(${patientLabRequest.id},${model.id});" >Delete</a></td>		
										</c:if>
									</c:if>
							    </tr>
							</c:forEach>
							
						</table>
					</div>
					
			<div class="form-group">
				<form:label path="totalAmount" cssClass="col-sm-2 control-label">Total Fee (Php):</form:label>
				<div class="col-xs-1">
		      		<form:input path="totalAmount" cssClass="form-control input-sm" readonly="true"/>
		    	</div>
		    	<form:label path="paymentStatus.listValue" cssClass="col-sm-2 control-label">Payment Status:</form:label>
				<div class="col-xs-1">
		    		<form:input path="paymentStatus.listValue" cssClass="form-control input-sm" readonly="true"/>
		    	</div>
		    	<c:if test="${patientLabRequest.paymentStatus.id == 301}">
		    		<input class="btn btn-default" type="button" value="Pay Now" onclick="goToPayNow(${patientLabRequest.id});">
		    	</c:if>
		    	<c:if test="${patientLabRequest.paymentStatus.id == 302 && patientLabRequest.status.id == 201}">		
		    		<input class="btn btn-default" type="button" value="Release Lab Exam Results" onclick="releaseLabExamResult(${patientLabRequest.id});">
		    	</c:if>
		    	<c:if test="${patientLabRequest.status.id == 202}">
		    		<form:label path="status.listValue" cssClass="col-sm-2 control-label">Request Status:</form:label>
					<div class="col-xs-1">
		      			<form:input path="status.listValue" cssClass="form-control input-sm" disabled="true"/>
		    		</div>
		    	</c:if>
			</div>
					
			<!-- Add new lab exam -->
			<c:if test="${patientLabRequest.paymentStatus.id == 301}">
				<div>
					<div class="form-group">
						<form:label path="labExamId" cssClass="col-sm-2 control-label">Select Lab Exam to Add:</form:label>
						<div class="col-xs-3">
							<form:select id="labExamSelectedId" path="labExamId" items="${labExamList}"  itemValue="id"   itemLabel="description" cssClass="form-control input-sm">
							</form:select>
				    	</div>
				    		<input class="btn btn-default" type="button" value="Add New Lab Exam Request" onclick="addNewLabExam(${patientLabRequest.id},document.getElementById('labExamSelectedId').value);">
					</div>
				</div>
			</c:if>
				
		</form:form>

	</div>
	
</body>
</html>