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
			$('#professionalTypeListId').focus();
		});
	</script>
</head>
<body>

	<div style="width: 100%;">

		<form:form action="/drmsweb/saveProfessional" method="post" modelAttribute="professional" cssClass="form-horizontal">
				
			<div style="overflow:hidden;">
				<div style="float:left; padding: 5px 0px 0px 10px;">
					<a href="./goToMain" >Back to Home</a><br>					
				</div>			
			</div>		
		
		    <div align="center">
		    	<img src="resources/img/prof03.jpg" alt="Professional" height="50" width="50">
		    	<label style="font-size: 24px;">Add Professional</label>		
		    </div>
				
				<c:if test="${isSuccess == true}">
					<br>
					<div align="center">
						<h4 style="color: blue;">Record Successfully Saved!</h4>
					</div>
				</c:if>
				
				<br>

				<table style="width: 100%;">
					<tr>
						<td width="33%"></td>
						<td>
							<div class="form-group">
								<form:label path="professionalType.id" cssClass="col-sm-2 control-label">Type:</form:label>
								<div class="col-xs-3">
									<form:select id="professionalTypeListId" path="professionalType.id"  items="${professionalTypeList}"  itemValue="id"   itemLabel="listValue" cssClass="form-control input-sm">
									</form:select>
				    			</div>
							</div>						
						</td>
					</tr>
					<tr>
						<td width="33%"></td>
						<td>
							<div class="form-group">
								<form:label path="designation" cssClass="col-sm-2 control-label">Designation:</form:label>
								<div class="col-xs-3">
									<form:select path="designation" cssClass="form-control input-sm">
										<form:option value="Dr.">Dr.</form:option>
										<form:option value="Dra.">Dra.</form:option>
										<form:option value="Mr.">Mr.</form:option>
										<form:option value="Ms.">Ms.</form:option>
										<form:option value="Mrs.">Mrs.</form:option>
									</form:select>
					    		</div>
							</div>						
						</td>
					</tr>
					<tr>
						<td width="33%"></td>
						<td>
							<div class="form-group">
								<form:label path="lastName" cssClass="col-sm-2 control-label">Last Name:</form:label>
								<div class="col-xs-3">
				      				<form:input path="lastName" cssClass="form-control input-sm"/>
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
								<form:label path="fee" cssClass="col-sm-2 control-label">Fee:</form:label>
								<div class="col-xs-3">
				      				<form:input path="fee" cssClass="form-control input-sm"/>
				    			</div>
							</div>							
						</td>
					</tr>
					<tr height="10px"></tr>
					<tr>
						<td width="33%"></td>
						<td>
							<div class="form-group">
								<div class="col-xs-5" align="right">
								<c:choose>
									<c:when test="${isSuccess == true}">
										<input class="btn btn-default" type="button" value="Close" onclick="window.location.href = '/drmsweb/goToSearchProfessional';">
									</c:when>
									<c:otherwise>
										<input class="btn btn-default" type="submit" value="Submit/Save">
										<input class="btn btn-default" type="button" value="Cancel" onclick="window.location.href = '/drmsweb/goToSearchProfessional';">
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