<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>SIMS</title>
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
			$('#nameId').focus();
		});
	</script>
</head>
<body>

	<div style="width: 100%;">

		<form:form action="/simsweb/saveCategory" method="post" modelAttribute="category" cssClass="form-horizontal">
		
			<div align="left" style="padding: 10px 10px 0px 30px;">
		    	<a href="./goToMain" >Back to Home</a>
		    </div>
		    
		    <div align="center">
		    	<img src="resources/img/lab01.png" alt="Category" height="50" width="50">
		    	<label style="font-size: 24px;">Add Category</label>		
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
								<form:label path="name" cssClass="col-sm-2 control-label">Name:</form:label>
								<div class="col-xs-3">
				      				<form:input path="name" id="nameId"  cssClass="form-control input-sm"/>
				      				<form:errors path="name" cssClass="error"></form:errors>
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
				      				<form:input path="description" cssClass="form-control input-sm"/>
				    			</div>
							</div>							
						</td>
					</tr>
					<tr height="10px;"></tr>	
					<tr>
						<td width="33%"></td>
						<td>
							<div class="form-group">
								<div class="col-xs-5" align="right">
								<c:choose>
									<c:when test="${isSuccess == true}">
										<input class="btn btn-default" type="button" value="Close" onclick="window.location.href = '/simsweb/goToSearchCategory';">
									</c:when>
									<c:otherwise>
										<input class="btn btn-default" type="submit" value="Submit/Save">
										<input class="btn btn-default" type="button" value="Cancel" onclick="window.location.href = '/simsweb/goToSearchCategory';">
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