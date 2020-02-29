<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>SIMS</title>
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
		   $('#dtDateOfInventoryDatePicker').datepicker({});
			$('#dtDateOfInventoryDatePicker').focus();
		});
		
		function viewPhysicalInventory(piId) {
			window.location.href = '/simsweb/viewPhysicalInventory?piId=' + piId;
		}
	</script>
</head>
<body>

	<div style="width: 100%;">
	
		<div align="left" style="padding: 10px 10px 0px 30px;">
	    	<a href="./goToMain" >Back to Home</a>
	    </div>
	    
		<div align="center">
		    <img src="resources/img/login.jpg" alt="PhysicalInventory" height="50" width="50">
		    <label style="font-size: 24px;">Add Physical Inventory</label>		
		</div>
	
		<br>

		<form:form action="/simsweb/savePhysicalInventory" method="post" modelAttribute="physicalInventory" cssClass="form-horizontal">
				
			<table style="width: 100%;">
				<tr>
					<td width="33%"></td>
					<td>
						<div class="form-group">
							<form:label path="dateOfInventory" cssClass="col-sm-2 control-label">Date Of Inventory:</form:label>
							<div class="col-xs-3">
								<c:choose>
									<c:when test="${isSuccess == true}">
										<form:input readonly="true" path="dateOfInventory" cssClass="form-control input-sm"/>
									</c:when>
									<c:otherwise>
										<form:input id="dtDateOfInventoryDatePicker" placeholder="MM/dd/yyyy" path="dateOfInventory" cssClass="form-control input-sm"/>
										<form:errors path="dateOfInventory" cssClass="error"></form:errors>
									</c:otherwise>
								</c:choose>
			    			</div>
						</div>					
					</td>
				</tr>
				<tr>
					<td width="33%"></td>
					<td>
						<div class="form-group">
							<form:label path="inventoryBy" cssClass="col-sm-2 control-label">Inventory By:</form:label>
							<div class="col-xs-3">
								<c:choose>
									<c:when test="${isSuccess == true}">
										<form:input readonly="true"  path="inventoryBy" cssClass="form-control input-sm"/>
									</c:when>
									<c:otherwise>
										<form:input path="inventoryBy" cssClass="form-control input-sm"/>
									</c:otherwise>
								</c:choose>
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
								<c:choose>
									<c:when test="${isSuccess == true}">
										<form:input readonly="true"  path="remarks" cssClass="form-control input-sm"/>
									</c:when>
									<c:otherwise>
										<form:input path="remarks" cssClass="form-control input-sm"/>
									</c:otherwise>
								</c:choose>
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
									<input class="btn btn-default" type="button" value="Proceed to Physical Inventory Details" onclick="viewPhysicalInventory(${physicalInventory.id});">
								</c:when>
								<c:otherwise>
									<input class="btn btn-default" type="submit" value="Submit/Save">
									<input class="btn btn-default" type="button" value="Cancel" onclick="window.location.href = '/simsweb/goToSearchPhysicalInventory';">
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