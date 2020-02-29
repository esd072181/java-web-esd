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
		
		function selectItem(itemId) {
			
			$.ajax({
				  type: "GET",
				  url: "selectItem",
				  cache: false,
				  data: { itemId: itemId }
				})
				  .done(function( result ) {
					$("#ItemSystemQtyDIV").html(result);
					$('#physicalCountId').val('');
					$('#physicalCountId').focus();
				  });
		}
		
		function clearItemQty() {
			$('#systemQtyId').val('');
			$('#physicalCountId').val('');
		}
		
		function addNewPhysicalInventoryDetails(physicalInventoryId, itemId, systemQty, physicalCount) {
			
			$.ajax({
				  type: "GET",
				  url: "addNewPhysicalInventoryDetails",
				  cache: false,
				  data: { physicalInventoryId: physicalInventoryId, 
					  	  itemId: itemId,
					  	  systemQty: systemQty,
					  	  physicalCount: physicalCount }
				})
				  .done(function( result ) {
					$("#PhysicalInventoryDetailsDIV").html(result);
					$('#systemQtyId').val('');
					$('#physicalCountId').val('');
					$('#itemSelectedId').focus();	
				  });
				
		}
										
	</script>
</head>
<body>

	<div style="width: 100%;">

		<form:form action="/simsweb/saveUpdatePhysicalInventoryDetails" method="post" modelAttribute="physicalInventory" cssClass="form-horizontal">
		
			<div align="left" style="padding: 10px 0px 0px 30px;">
	    		<a href="./goToMain" >Back to Home</a><br>
	    		<a href="./goToSearchPhysicalInventory" >Back to Search</a>
	    	</div>

			<div align="center">
				<img src="resources/img/browse_consult01.jpg" alt="PhysicalInventory" height="50" width="50">
				<label style="font-size: 24px;">Physical Inventory Details</label>		
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
					<td></td>
					<td>
						<div class="form-group">
							<form:label path="dateOfInventory" cssClass="col-sm-1 control-label">Date:</form:label>
							<div class="col-xs-2" style="width: 120px;">
			      				<form:input path="dateOfInventory" cssClass="form-control input-sm" readonly="true" cssStyle="color: blue; "/>
			    			</div>
			    			<form:label path="inventoryBy" cssClass="col-sm-1 control-label">By:</form:label>
							<div class="col-xs-2">
			      				<form:input path="inventoryBy" cssClass="form-control input-sm" readonly="true" cssStyle="color: blue;"/>
			    			</div>
			    			<form:label path="remarks" cssClass="col-sm-1 control-label">Remarks:</form:label>
							<div class="col-xs-2">
			      				<form:input path="remarks" cssClass="form-control input-sm" readonly="true" cssStyle="color: blue;"/>
			    			</div>
			    			<form:label path="piNo" cssClass="col-sm-1 control-label">PINo:</form:label>
							<div class="col-xs-2">
			      				<form:input path="piNo" cssClass="form-control input-sm" readonly="true" cssStyle="color: blue;"/>
			    			</div>
						</div>						
					</td>
				</tr>
			</table>
			
			<br>

			<!-- Add new Physical Inventory Details -->
			<div>
					<div class="form-group">
						<form:label path="itemId" cssClass="col-sm-1 control-label">Item:</form:label>
						<div class="col-xs-3">  
							<form:select id="itemSelectedId" onchange="clearItemQty();" path="itemId" items="${itemList}"  itemValue="id"  itemLabel="description" cssClass="form-control input-sm">
							</form:select>
						</div>
						<div class="col-xs-2">
							<input class="btn btn-default" type="button" value="Select Item for Inventory" onclick="selectItem(document.getElementById('itemSelectedId').value);">
						</div>	
						<div id="ItemSystemQtyDIV" class="col-xs-1" style="width: 170px;">
							<label>System Qty</label>
							<input type="text" readonly="readonly" id="systemQtyId" name="systemQty" style="width: 50px; text-align: right; background-color: yellow; color: blue; font-weight: bold;"/>
						</div>	
						<div class="col-xs-2" >
							<label>Physical Count</label>
							<input type="text" id="physicalCountId" name="physicalCount" style="width: 50px; text-align: right;"/>						
			    		</div>
			    		<div>
							<input class="btn btn-default" type="button" value="Save Physical Count" onclick="addNewPhysicalInventoryDetails(${physicalInventory.id},document.getElementById('itemSelectedId').value,document.getElementById('systemQtyId').value,document.getElementById('physicalCountId').value);">
						</div>	
					</div>
			</div>

					
			<div id="PhysicalInventoryDetailsDIV" style="padding-left: 20px;">
				<c:choose>
					<c:when test="${physicalInventory.piDetailsList.size() > 0}">
						<!-- Physical Inventory Details Item -->					
						<div  align="center" class="table-responsive" style="width: 70%; padding-left: 10px;">
									<table class="table table-striped table-hover table-bordered table-responsive" style="font-size: 9px;">
										<tr style="font-weight: bold;">
											<td align="right">No</td>
											<td>Item</td>
											<td align="right">System Qty</td>
											<td align="right">Physical Count</td>
											<td align="right">QtyVariance</td>
											<td>Variance</td>
										</tr>
										<!-- loop here -->
										<c:forEach items="${physicalInventory.piDetailsList}" var="model" varStatus = "row">
										    <tr>
										    	<td align="right">${row.count}</td>
												<td>${model.item.description}</td>
												<td align="right">${model.systemQty}</td>
												<td align="right">${model.physicalCount}</td>
												<td align="right">${model.qtyVariance}</td>
												<td>${model.variance}</td>		
										    </tr>
										</c:forEach>
										
									</table>
						</div>
					</c:when>		
					<c:otherwise>
						<div  align="center" class="table-responsive" style="width: 70%; padding-left: 10px;">
							<table class="table table-striped table-hover table-bordered table-responsive" style="font-size: 9px;">
								<tr style="font-weight: bold;">
									<td align="right">No</td>
									<td>Item</td>
									<td align="right">System Qty</td>
									<td align="right">Physical Count</td>
									<td align="right">QtyVariance</td>
									<td>Variance</td>
								</tr>
								<tr>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
							</table>
						</div>
					
					</c:otherwise>
				
				</c:choose>
			</div>	

		</form:form>

	</div>
	
</body>
</html>