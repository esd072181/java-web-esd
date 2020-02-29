<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>CRMS</title>
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
			$('#descriptionId').focus();
		});
	</script>
</head>
<body>

	<div style="width: 100%;">

		<form:form action="/crmsweb/saveMed" method="post" modelAttribute="medicine" cssClass="form-horizontal">
		
			<div style="overflow:hidden;">
				<div style="float:left; padding: 5px 0px 0px 10px;">
					<a href="./goToMain" >Back to Home</a><br>					
				</div>			
			</div>
		    
		    <div align="center">
		    	<img src="resources/img/med05.png" alt="LabExam" height="50" width="50">
		    	<label style="font-size: 24px;">Add Medicine</label>		
		    </div>
				
			<c:if test="${isSuccess == true}">
				<div align="center" >
					<h4 style="color: blue;">Record Successfully Saved!</h4>
				</div>
			</c:if>
			
			<table style="width: 100%;">
					<tr>
						<td width="33%"></td>
						<td>
							<div class="form-group">
								<form:label path="itemCode" cssClass="col-sm-2 control-label">Item Code:</form:label>
								<div class="col-xs-3">
				      				<form:input path="itemCode" cssClass="form-control input-sm"/>
				    			</div>
							</div>						
						</td>
					</tr>
					<tr>
						<td width="33%"></td>
						<td>
							<div class="form-group">
								<form:label path="description" cssClass="col-sm-2 control-label">Description:</form:label>
								<div class="col-xs-3">
				      				<form:input id="descriptionId" path="description" cssClass="form-control input-sm"/>
									<form:errors path="description" cssClass="error"></form:errors>
				    			</div>
							</div>							
						</td>
					</tr>
					<tr>
						<td width="33%"></td>
						<td>
							<div class="form-group">
								<form:label path="genericName" cssClass="col-sm-2 control-label">Generic Name:</form:label>
								<div class="col-xs-3">
				      				<form:input path="genericName" cssClass="form-control input-sm"/>
				    			</div>
							</div>							
						</td>
					</tr>
					<tr>
						<td width="33%"></td>
						<td>
							<div class="form-group">
								<form:label path="remarks" cssClass="col-sm-2 control-label">Remarks:</form:label>
								<div class="col-xs-3">
				      				<form:input path="remarks" cssClass="form-control input-sm"/>
				    			</div>
							</div>							
						</td>
					</tr>
					<tr>
						<td width="33%"></td>
						<td>
							<div class="form-group">
								<form:label path="lotNo" cssClass="col-sm-2 control-label">Lot No:</form:label>
								<div class="col-xs-3">
				      				<form:input path="lotNo" cssClass="form-control input-sm"/>
				    			</div>
							</div>							
						</td>
					</tr>
					<tr>
						<td width="33%"></td>
						<td>
							<div class="form-group">
								<form:label path="dateManufactured" cssClass="col-sm-2 control-label">Date Manufactured:</form:label>
								<div class="col-xs-3">
				      				<form:input path="dateManufactured" cssClass="form-control input-sm"/>
				    			</div>
							</div>							
						</td>
					</tr>
					<tr>
						<td width="33%"></td>
						<td>
							<div class="form-group">
								<form:label path="expirationDate" cssClass="col-sm-2 control-label">Expiration Date:</form:label>
								<div class="col-xs-3">
				      				<form:input path="expirationDate" cssClass="form-control input-sm"/>
				    			</div>
							</div>							
						</td>
					</tr>
					<tr>
						<td width="33%"></td>
						<td>
							<div class="form-group">
								<form:label path="retailSellingPrice" cssClass="col-sm-2 control-label">Retail Selling Price:</form:label>
								<div class="col-xs-3">
				      				<form:input path="retailSellingPrice" cssClass="form-control input-sm"/>
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
										<input class="btn btn-default" type="button" value="Close" onclick="window.location.href = '/crmsweb/goToSearchMed';">
									</c:when>
									<c:otherwise>
										<input class="btn btn-default" type="submit" value="Submit/Save">
										<input class="btn btn-default" type="button" value="Cancel" onclick="window.location.href = '/crmsweb/goToSearchMed';">
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