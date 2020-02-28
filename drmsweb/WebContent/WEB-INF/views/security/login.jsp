<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>DRMS</title>
	<script type="text/javascript" src="resources/js/jquery-1.11.1.js" ></script>
	<script>
		$(function() {
		  // Handler for .ready() called.
		 	$('#userNameId').val('');
			$('#userNameId').focus();
		});
	</script>
</head>
<body>
	<form:form action="/drmsweb/loginValidate" method="post" modelAttribute="userAccount" cssClass="form-horizontal">
	
	<div style="width: 100%" align="center">
		
		<div>
			<h1>Dental Records Management System</h1>
		</div>
	
		<br>
		<table>
			<tr>
				<td colspan="2" align="center">
					<img src="resources/img/login.jpg" alt="Login" height="100" width="100">
				</td>
			</tr>
			<c:if test="${isValidated == 'failed'}">
				<tr>
					<td align="center" colspan="2"><label style="color: red; font-style: italic;">Invalid user name or password!</label></td>
				</tr>
			</c:if>
			<tr height="10px"></tr>
			<tr>
				<td><form:label path="userName">User Name:</form:label></td>
				<td><form:input id="userNameId" path="userName" cssStyle="width: 150px;"/></td>
			</tr>
			<tr>
				<td><form:label path="password">Password:</form:label></td>
				<td><form:password path="password" cssStyle="width: 150px;"/></td>
			</tr>
			<tr height="10px"></tr>
			<tr>
				<td></td>
				<td align="right"><input type="submit" value="Submit"></td>
			</tr>	
		</table>
		
	</div>
	
	</form:form>
	
</body>
</html>