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

			$("#retailSellingPriceId").keydown(function (e) {
		        // Allow: backspace, delete, tab, escape, enter, comma and .
		        if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110, 188, 190]) !== -1 ||
		             // Allow: Ctrl/cmd+A
		            (e.keyCode == 65 && (e.ctrlKey === true || e.metaKey === true)) ||
		             // Allow: Ctrl/cmd+C
		            (e.keyCode == 67 && (e.ctrlKey === true || e.metaKey === true)) ||
		             // Allow: Ctrl/cmd+X
		            (e.keyCode == 88 && (e.ctrlKey === true || e.metaKey === true)) ||
		             // Allow: home, end, left, right
		            (e.keyCode >= 35 && e.keyCode <= 39)) {
		                 // let it happen, don't do anything
		                 return;
		        }
		        // Ensure that it is a number and stop the keypress
		        if ( (e.shiftKey || (e.keyCode < 44 || e.keyCode > 57)) && (e.keyCode < 96 || (e.keyCode > 105)) ) {
		            e.preventDefault();
		        }   
		    });
			
		  var str = $('#descriptionId').val();
			$('#descriptionId').focus().val("").val(str);
		});
	</script>
</head>
<body>

	<div style="width: 100%;">

		<form:form action="/drmsweb/updateMed" method="post" modelAttribute="medicine"  cssClass="form-horizontal">
				
			<form:hidden path="id"/>
							
			<div style="overflow:hidden;">
				<div style="float:left; padding: 5px 0px 0px 10px;">
					<a href="./goToMain" >Back to Home</a><br>					
				</div>			
			</div>
		    
		    <div align="center">
		    	<img src="resources/img/med05.png" alt="LabExam" height="50" width="50">
		    	<label style="font-size: 24px;">Update Medicine</label>		
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
			      				<form:input path="retailSellingPrice" id="retailSellingPriceId" style="text-align: right;" cssClass="form-control input-sm"/>
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
									<input class="btn btn-default" type="button" value="Close" onclick="window.location.href = '/drmsweb/goToSearchMed';">
								</c:when>
								<c:otherwise>
									<input class="btn btn-default" type="submit" value="Submit/Update">
									<input class="btn btn-default" type="button" value="Cancel" onclick="window.location.href = '/drmsweb/goToSearchMed';">
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