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
		$(function() {
		  // Handler for .ready() called.
		  var str = $('#descriptionId').val();
			$('#descriptionId').focus().val("").val(str);
		});
	</script>
</head>
<body>

	<div style="width: 100%;">

		<form:form action="/lrmsweb/updateLabExam" method="post" modelAttribute="labExam"  cssClass="form-horizontal">
				
			<form:hidden path="id"/>
							
			<div style="overflow:hidden;">
				<div style="float:left; padding: 5px 0px 0px 10px;">
					<a href="./goToMain" >Back to Home</a><br>					
				</div>			
			</div>
		    
		    <div align="center">
		    	<img src="resources/img/lab01.jpg" alt="LabExam" height="50" width="50">
		    	<label style="font-size: 24px;">Update Laboratory Examination</label>		
		    </div>
			
			<c:if test="${isSuccess == true}">
				<br>
				<div align="center">
					<h4 style="color: blue;">Record Successfully Updated!</h4>
				</div>
			</c:if>
			
			<br>
			
			<table style="width: 100%">
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
							<form:label path="fee" cssClass="col-sm-2 control-label">Fee (Php):</form:label>
							<div class="col-xs-3">
			      				<form:input path="fee" cssClass="form-control input-sm"/>
			    			</div>
						</div>						
					</td>			
				</tr>
				<tr>
					<td width="33%"></td>
					<td>
						<div class="form-group">
							<form:label path="reportTemplate.id" cssClass="col-sm-2 control-label">Report Template:</form:label>
							<div class="col-xs-3">
								<form:select path="reportTemplate.id"  items="${reportTemplateList}"  itemValue="id"   itemLabel="listValue" cssClass="form-control input-sm">
								</form:select>
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
									<input class="btn btn-default" type="button" value="Close" onclick="window.location.href = '/lrmsweb/goToSearchLabExam';">
								</c:when>
								<c:otherwise>
									<input class="btn btn-default" type="submit" value="Submit/Update">
									<input class="btn btn-default" type="button" value="Cancel" onclick="window.location.href = '/lrmsweb/goToSearchLabExam';">
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