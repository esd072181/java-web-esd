<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>DRMS</title>
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
		$(function() {
		  // Handler for .ready() called.
			$('#chiefComplaintId').focus();
		});
		function viewConsultation(consultId) {
			window.location.href = 'goToViewPatientConsultation?consultId=' + consultId;
		}
	</script>
</head>
<body>

	<div style="width: 100%;">

		<form:form action="/drmsweb/saveConsultation" method="post" modelAttribute="patientConsultation" cssClass="form-horizontal">

			<br>

			<div align="center">
				<img src="resources/img/consult01.png" alt="PatientConsultation" height="50" width="50">
				<label style="font-size: 24px;">Consultation Form</label>		
			</div>
					
				
				<c:if test="${isSuccess == true}">
					<div align="center">
						<h4 style="color: blue;">Record Successfully Saved!</h4>
					</div>
				</c:if>
			
			    <form:hidden path="id"/>
				<form:hidden path="patient.id"/>
				
				<br>
				
				<table style="width: 100%;">
					<tr>
						<td width="33%"></td>
						<td>
							<div class="form-group">
								<form:label path="patient.patientNo" cssClass="col-sm-2 control-label">Patient No:</form:label>
								<div class="col-xs-3">
				      				<form:input path="patient.patientNo" cssClass="form-control input-sm" readonly="true"/>
				    			</div>
							</div>				
						</td>
					</tr>
					<tr>
						<td width="33%"></td>
						<td>
							<div class="form-group">
								<form:label path="patient.lastName" cssClass="col-sm-2 control-label">Last Name:</form:label>
								<div class="col-xs-3">
				      				<form:input path="patient.lastName" cssClass="form-control input-sm" readonly="true"/>
				    			</div>
							</div>				
						</td>
					</tr>
					<tr>
						<td width="33%"></td>
						<td>
							<div class="form-group">
								<form:label path="patient.firstName" cssClass="col-sm-2 control-label">First Name:</form:label>
								<div class="col-xs-3">
				      				<form:input path="patient.firstName" cssClass="form-control input-sm" readonly="true"/>
				    			</div>
							</div>				
						</td>
					</tr>
					<tr>
						<td width="33%"></td>
						<td>
							<div class="form-group">
								<form:label path="patient.middleName" cssClass="col-sm-2 control-label">Middle Name:</form:label>
								<div class="col-xs-3">
				      				<form:input path="patient.middleName" cssClass="form-control input-sm" readonly="true"/>
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
				      				<form:input path="age" cssClass="form-control input-sm" readonly="true"/>
				    			</div>
							</div>			
						</td>
					</tr>
					<tr>
						<td width="33%"></td>
						<td>
							<div class="form-group">
								<form:label path="height" cssClass="col-sm-2 control-label">Height:</form:label>
								<div class="col-xs-3">
				      				<form:input path="height" cssClass="form-control input-sm"/>
				    			</div>
							</div>			
						</td>
					</tr>
					<tr>
						<td width="33%"></td>
						<td>
							<div class="form-group">
				    			<form:label path="weight" cssClass="col-sm-2 control-label">Weight:</form:label>
								<div class="col-xs-3">
				      				<form:input path="weight" cssClass="form-control input-sm" />
				    			</div>
				    		</div>
						</td>
					</tr>
					<tr>
						<td width="33%"></td>
						<td>
							<div class="form-group">
				    			<form:label path="chiefComplaint" cssClass="col-sm-2 control-label">Chief Complaint/Request:</form:label>
								<div class="col-xs-3">
				      				<form:textarea id="chiefComplaintId" path="chiefComplaint" cssClass="form-control input-sm" />
				    			</div>
				    		</div>
						</td>
					</tr>
					<tr>
						<td width="33%"></td>
						<td>
							<div class="form-group">
								<form:label path="professional.id" cssClass="col-sm-2 control-label">Dentist:</form:label>
								<div class="col-xs-3">
									<form:select path="professional.id" items="${physicians}"  itemValue="id"   itemLabel="fullName" cssClass="form-control input-sm">
									</form:select>
				    			</div>
							</div>	
						</td>
					</tr>
					<tr>
						<td width="33%"></td>
						<td>
							<div class="form-group">
								<div class="col-xs-5" align="right">
								<c:choose>
									<c:when test="${isSuccess == true}">
									<input class="btn btn-default" type="button" value="Go To Consultation Details" onclick="viewConsultation(${patientConsultation.id});">
										<input class="btn btn-default" type="button" value="Close" onclick="window.location.href = '/drmsweb/goToSearchPatientForConsultation';">
									</c:when>
									<c:otherwise>
										<input class="btn btn-default" type="submit" value="Submit/Save">
										<input class="btn btn-default" type="button" value="Cancel" onclick="window.location.href = '/drmsweb/goToSearchPatientForConsultation';">
									</c:otherwise>
								</c:choose>
								</div>
							</div>
						</td>
					</tr>													
				</table>

		</form:form>

	</div>

</body>
</html>