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
		$(function() {
		  // Handler for .ready() called.
		  
		  $('#dtBirthdayPicker').datepicker({});
		  
			var str = $('#lastNameId').val();
			$('#lastNameId').focus().val("").val(str);
		});
	</script>
</head>
<body>

	<div style="width: 100%;">

		<form:form action="/drmsweb/updatePatient" method="post" modelAttribute="patient"  cssClass="form-horizontal">
		
		
			<form:hidden path="id"/>
				
			<div style="overflow:hidden;">
				<div style="float:left; padding: 5px 0px 0px 10px;">
					<a href="./goToMain" >Back to Home</a><br>					
				</div>			
			</div>

		    <div align="center">
		    	<img src="resources/img/patient_reg.png" alt="Patient" height="50" width="50">
		    	<label style="font-size: 24px;">Update Patient</label>		
		    </div>
			
			<c:if test="${isSuccess == true}">
				<br>
				<div align="center">
					<h4 style="color: blue;">Record Successfully Updated!</h4>
				</div>
			</c:if>
			
			<br>
			
			<table style="width: 100%;">
				<tr>
					<td width="33%"></td>
					<td>
						<div class="form-group">
							<form:label path="lastName" cssClass="col-sm-2 control-label">Last Name:</form:label>
							<div class="col-xs-3">
			      				<form:input id="lastNameId" path="lastName" cssClass="form-control input-sm"/>
								<form:errors path="lastName" cssClass="error"></form:errors>
			    			</div>
						</div>						
					</td>
				</tr>
				<tr>
					<td width="33%"></td>
					<td>
						<div class="form-group">
							<form:label path="firstName" cssClass="col-sm-2 control-label">First Name:</form:label>
							<div class="col-xs-3">
			      				<form:input path="firstName" cssClass="form-control input-sm"/>
								<form:errors path="firstName" cssClass="error"></form:errors>
			    			</div>
						</div>						
					</td>
				</tr>
				<tr>
					<td width="33%"></td>
					<td>
						<div class="form-group">
							<form:label path="middleName" cssClass="col-sm-2 control-label">Middle Name:</form:label>
							<div class="col-xs-3">
			      				<form:input path="middleName" cssClass="form-control input-sm"/>
			    			</div>
						</div>					
					</td>
				</tr>
				<tr>
					<td width="33%"></td>
					<td>
						<div class="form-group">
							<form:label path="gender" cssClass="col-sm-2 control-label">Gender:</form:label>
							<div class="col-xs-3">
								<form:select path="gender" cssClass="form-control input-sm">
									<form:option value="Male">Male</form:option>
									<form:option value="Female">Female</form:option>
								</form:select>
			    			</div>
						</div>						
					</td>
				</tr>
				<tr>
					<td width="33%"></td>
					<td>
						<div class="form-group">
							<form:label path="birthday" cssClass="col-sm-2 control-label">Birthday:</form:label>
							<div class="col-xs-3">
			      				<form:input id="dtBirthdayPicker" placeholder="MM/dd/yyyy" path="birthday" cssClass="form-control input-sm"/>
			    				<form:errors path="birthday" cssClass="error"></form:errors>
			    			</div>
			    			<form:label path="contactNo" cssClass="col-sm-2 control-label">Contact No:</form:label>
							<div class="col-xs-3">
			      				<form:input path="contactNo" cssClass="form-control input-sm"/>
			    			</div>
						</div>						
					</td>
				</tr>
				<tr>
					<td width="33%"></td>
					<td>
						<div class="form-group">
							<form:label path="addressLine1" cssClass="col-sm-2 control-label">Address Line 1:</form:label>
							<div class="col-xs-3">
			      				<form:input path="addressLine1" cssClass="form-control input-sm"/>
			    			</div>
			    			<form:label path="addressLine2" cssClass="col-sm-2 control-label">Address Line 2:</form:label>
							<div class="col-xs-3">
			      				<form:input path="addressLine2" cssClass="form-control input-sm"/>
			    			</div>
						</div>						
					</td>
				</tr>
				<tr>
					<td width="33%"></td>
					<td>
						<div class="form-group">
							<form:label path="town" cssClass="col-sm-2 control-label">Town:</form:label>
							<div class="col-xs-3">
			      				<form:input path="town" cssClass="form-control input-sm"/>
			    			</div>
			    			<form:label path="province" cssClass="col-sm-2 control-label">Province:</form:label>
							<div class="col-xs-3">
			      				<form:input path="province" cssClass="form-control input-sm"/>
			    			</div>
						</div>						
					</td>
				</tr>		
				<tr>
					<td width="33%"></td>
					<td>
						<div class="form-group">
							<form:label path="zipCode" cssClass="col-sm-2 control-label">Zip Code:</form:label>
							<div class="col-xs-3">
			      				<form:input path="zipCode" cssClass="form-control input-sm"/>
			    			</div>
						</div>					
					</td>
				</tr>
				<tr>
					<td width="33%"></td>
					<td>
						<div class="form-group">
							<form:label path="contactPerson" cssClass="col-sm-2 control-label">Contact Person:</form:label>
							<div class="col-xs-3">
			      				<form:input path="contactPerson" cssClass="form-control input-sm"/>
			    			</div>
			    			<form:label path="contactPersonNo" cssClass="col-sm-2 control-label">Contact No:</form:label>
							<div class="col-xs-3">
			      				<form:input path="contactPersonNo" cssClass="form-control input-sm"/>
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
									<input class="btn btn-default" type="button" value="Close" onclick="window.location.href = '/drmsweb/goToSearchPatient';">
								</c:when>
								<c:otherwise>
									<input class="btn btn-default" type="submit" value="Submit/Update">
									<input class="btn btn-default" type="button" value="Cancel" onclick="window.location.href = '/drmsweb/goToSearchPatient';">
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