<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
	
		$(document).ready(function(){
		
		  $('#qtyId').val(1);
		  //$('#itemSelectedId').focus();	
			
		  $('#reportId').click(function(){
		    window.open(this.href);
		    return false;
		  });
		  
		});
		
		function addNewPODetails(poHeaderId, itemId, qty) {
			
			$.ajax({
				  type: "GET",
				  url: "addNewPODetails",
				  cache: false,
				  data: { poHeaderId: poHeaderId, 
					  	  itemId: itemId,
					  	   qty: qty }
				})
				  .done(function( result ) {
					$("#PODetailsDIV").html(result);
					$('#qtyId').val(1);
					$('#itemSelectedId').focus();
				  });
				
		}
				
		function deletePODetails(poHeaderId,poDetailsId) {
			var ans = confirm("Are you sure you want to delete this item?");
			if (ans) {
				
				$.ajax({
					  type: "GET",
					  url: "deletePODetails",
					  cache: false,
					  data: { poHeaderId: poHeaderId, 
						  	  poDetailsId: poDetailsId }
					})
					  .done(function( result ) {
						$("#PODetailsDIV").html(result);
						$('#qtyId').val(1);
						$('#itemSelectedId').focus();
					  });
				
			}
		}
						
	</script>
</head>
<body>

	<div style="width: 100%;">

		<form:form action="/simsweb/saveUpdatePODetails" method="post" modelAttribute="poHeader" cssClass="form-horizontal">
		
			<div align="left" style="padding: 10px 0px 0px 30px;">
	    		<a href="./goToMain" >Back to Home</a><br>
	    		<a href="./goToSearchPOInRO" >Back to Search</a>
	    	</div>

			<div align="center">
				<img src="resources/img/browse_consult01.jpg" alt="POHeader" height="50" width="50">
				<label style="font-size: 24px;">Receive Order Details</label>		
			</div>
				
			<c:if test="${isUpdated == true}">
				<br>
				<div align="center">
					<h4 style="color: blue;">Record successfully updated!</h4>
				</div>
			</c:if>
			
			<br>
			
			
			<table style="width: 100%;">
				<tr>
					<td width="2%"></td>
					<td>
						<div class="form-group">
							<form:label path="supplier.name" cssClass="col-sm-2 control-label">Supplier:</form:label>
							<div class="col-xs-3">
			      				<form:input path="supplier.name" cssClass="form-control input-sm" readonly="true" cssStyle="color: blue;"/>
			    			</div>
			    			<form:label path="poNo" cssClass="col-sm-2 control-label">PO No:</form:label>
							<div class="col-xs-3">
			      				<form:input path="poNo" cssClass="form-control input-sm" readonly="true" cssStyle="color: blue;"/>
			    			</div>
						</div>						
					</td>
				</tr>
				<tr>
					<td width="2%"></td>
					<td>
						<div class="form-group">
							<form:label path="transDate" cssClass="col-sm-2 control-label">Transaction Date:</form:label>
							<div class="col-xs-3">
			      				<form:input path="transDate" cssClass="form-control input-sm" readonly="true" cssStyle="color: blue;"/>
			    			</div>
							<form:label path="requestedBy" cssClass="col-sm-2 control-label">Requested By:</form:label>
							<div class="col-xs-3">
			      				<form:input path="requestedBy" cssClass="form-control input-sm" readonly="true" cssStyle="color: blue;"/>
			    			</div>
						</div>					
					</td>
				</tr>	
			</table>
			
			<br>

			<!-- Add new PO Details Item -->
			<c:if test="${poHeader.status.id == 601}">
				<div style="padding-left: 10px;">
					<div class="form-group">
						<div class="col-xs-1">
							<form:label path="itemId">Select Item:</form:label>
						</div>
						<div class="col-xs-3">  
							<form:select id="itemSelectedId" path="itemId" items="${itemList}"  itemValue="id"  itemLabel="description" cssClass="form-control input-sm">
							</form:select>
						</div>
					</div>
					<div class="form-group">
						<div class="col-xs-1">
							<label>Qty</label>
						</div>
						<div class="col-xs-1">
							<input type="text" id="qtyId" name="qty" style="width: 30px; text-align: right;"/>
						</div>				
					</div>
					<div class="form-group">
						<div class="col-xs-1">
							<label></label>
						</div>
						<div class="col-xs-1">
							<input class="btn btn-default" type="button" value="Add Selected Item" onclick="addNewPODetails(${poHeader.id},document.getElementById('itemSelectedId').value,document.getElementById('qtyId').value);">
						</div>			
					</div>
				</div>
			</c:if>
					
			<div id="PODetailsDIV">
				<c:if test="${roHeader.roDetailsList.size() > 0}">
					<!-- Total Amount -->	
					<div align="left" style="padding-left: 10px;">
						<div style="width: 60%;" align="right" >
							<label>Total Amount (Php):</label>
					    	<input type="text" style="width: 120px; color: blue; font-size: 15px; text-align: right; background-color: yellow; font-weight: bold;" value="<fmt:formatNumber type="currency" currencySymbol="" value="${totalAmount}"  maxFractionDigits="2"></fmt:formatNumber>" readonly="readonly" />						
						</div>
						<label>Received Items:</label>
					</div>
					<!-- RO Details Item -->					
					<div  align="center" class="table-responsive" style="width: 60%; padding-left: 10px;">
								<table class="table table-striped table-hover table-bordered table-responsive" style="font-size: 11px;">
									<tr style="font-weight: bold;">
										<td align="right">No</td>
										<td>Item</td>
										<td align="right">Qty</td>
										<td align="right">Price</td>
										<td align="right">Amount</td>
										<c:if test="${poHeader.status.id == 601}">
											<td width="50px;"></td>		
										</c:if>
									</tr>
									<!-- loop here -->
									<c:forEach items="${poHeader.poDetailsList}" var="model" varStatus = "row">
									    <tr>
									    	<td align="right">${row.count}</td>
											<td>${model.item.description}</td>
											<td align="right">${model.qty}</td>
											<td align="right"><fmt:formatNumber type="currency" currencySymbol="" value="${model.price}"  maxFractionDigits="2"></fmt:formatNumber></td>
											<td align="right"><fmt:formatNumber type="currency" currencySymbol="" value="${model.amount}"  maxFractionDigits="2"></fmt:formatNumber></td>
											<c:if test="${poHeader.status.id == 601}">
												<td align="center"><input type="button" value="Delete" onclick="deletePODetails(${poHeader.id},${model.id});"></td>		
											</c:if>
									    </tr>
									</c:forEach>
									
								</table>
					</div>
				</c:if>		
			</div>	

		</form:form>

	</div>
	
</body>
</html>