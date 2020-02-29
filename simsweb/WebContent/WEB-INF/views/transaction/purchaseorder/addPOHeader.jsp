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
			$('#supplierListId').focus();
		});
		
		function viewPOHeader(poId) {
			window.location.href = '/simsweb/viewPOHeader?poId=' + poId;
		}
	</script>
</head>
<body>

	<div style="width: 100%;">
	
		<div align="left" style="padding: 10px 10px 0px 30px;">
	    	<a href="./goToMain" >Back to Home</a>
	    </div>
	    
		<div align="center">
		    <img src="resources/img/login.jpg" alt="POHeader" height="50" width="50">
		    <label style="font-size: 24px;">Add Purchase Order</label>		
		</div>
	
		<br>

		<form:form action="/simsweb/savePOHeader" method="post" modelAttribute="poHeader" cssClass="form-horizontal">
				
			<table style="width: 100%;">
				<tr>
					<td width="33%"></td>
					<td>
						<div class="form-group">
							<form:label path="supplier.id" cssClass="col-sm-2 control-label">Supplier:</form:label>
							<div class="col-xs-3">
								<c:choose>
									<c:when test="${isSuccess == true}">
										<form:select disabled="true" id="supplierListId" path="supplier.id"  items="${supplierList}"  itemValue="id"   itemLabel="name" cssClass="form-control input-sm">
										</form:select>	
									</c:when>
									<c:otherwise>
										<form:select id="supplierListId" path="supplier.id"  items="${supplierList}"  itemValue="id"   itemLabel="name" cssClass="form-control input-sm">
										</form:select>	
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
									<input class="btn btn-default" type="button" value="Proceed to PO Details" onclick="viewPOHeader(${poHeader.id});">
								</c:when>
								<c:otherwise>
									<input class="btn btn-default" type="submit" value="Submit/Save">
									<input class="btn btn-default" type="button" value="Cancel" onclick="window.location.href = '/simsweb/goToSearchPO';">
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