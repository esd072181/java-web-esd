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
			$('#profListId').focus();
		});
	</script>
</head>
<body>

	<div style="width: 100%;">
	
			<div style="overflow:hidden;">
				<div style="float:left; padding: 5px 0px 0px 10px;">
					<a href="./goToMain" >Back to Home</a><br>					
				</div>			
			</div>
	    
		<div align="center">
		    <img src="resources/img/login.jpg" alt="UserAccount" height="50" width="50">
		    <label style="font-size: 24px;">Add User Account</label>		
		</div>
	
		<br>

		<form:form action="/crmsweb/saveUserAccount" method="post" modelAttribute="userAccount" cssClass="form-horizontal">
						
			<c:if test="${isSuccess == true}">
				<div align="center">
					<h4 style="color: blue;">Record Successfully Saved!</h4>
				</div>
			</c:if>
				
			<table style="width: 100%;">
				<tr>
					<td width="33%"></td>
					<td>
						<div class="form-group">
							<form:label path="prof.id" cssClass="col-sm-2 control-label">Professional:</form:label>
							<div class="col-xs-3">
								<form:select id="profListId" path="prof.id"  items="${profList}"  itemValue="id"   itemLabel="fullName" cssClass="form-control input-sm">
								</form:select>
			    			</div>
						</div>					
					</td>
				</tr>
				<tr>
					<td width="33%"></td>
					<td>
						<div class="form-group">
							<form:label path="role.id" cssClass="col-sm-2 control-label">Role:</form:label>
							<div class="col-xs-3">
								<form:select id="roleTypeListId" path="role.id"  items="${roleTypeList}"  itemValue="id"   itemLabel="listValue" cssClass="form-control input-sm">
								</form:select>
			    			</div>
						</div>						
					</td>
				</tr>
				<tr>
					<td width="33%"></td>
					<td>
						<div class="form-group">
							<form:label path="userName" cssClass="col-sm-2 control-label">User Name:</form:label>
							<div class="col-xs-3">
			      				<form:input path="userName" cssClass="form-control input-sm"/>
								<form:errors path="userName" cssClass="error"></form:errors>
			    			</div>
						</div>						
					</td>
				</tr>
				<tr>
					<td width="33%"></td>
					<td>
						<div class="form-group">
							<form:label path="password" cssClass="col-sm-2 control-label">Password:</form:label>
							<div class="col-xs-3">
			      				<form:password showPassword="true" path="password" cssClass="form-control input-sm"/>
			      				<form:errors path="password" cssClass="error"></form:errors>
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
									<input class="btn btn-default" type="button" value="Close" onclick="window.location.href = '/crmsweb/goToSearchUserAccount';">
								</c:when>
								<c:otherwise>
									<input class="btn btn-default" type="submit" value="Submit/Save">
									<input class="btn btn-default" type="button" value="Cancel" onclick="window.location.href = '/crmsweb/goToSearchUserAccount';">
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