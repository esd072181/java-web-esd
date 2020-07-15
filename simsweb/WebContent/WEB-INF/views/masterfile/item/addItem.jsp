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
	<script type="text/javascript" src="resources/js/global.js"></script>
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
		  $("form").bind("keypress", function (e) {  
				if (e.keyCode == 13) {  
					return false;  
				}  
			});
		  
		   $('#dtManufacturedDatePicker').datepicker({});
		   $('#dtExpiryDatePicker').datepicker({});
		  
		   $('#itemCodeId').focus();
		});
		
	</script>
</head>
<body>

	<div style="width: 100;">

		<form:form action="/simsweb/saveItem" method="post" modelAttribute="item" cssClass="form-horizontal">
		
			<div align="left" style="padding: 10px 10px 0px 30px;">
			   	<a href="./goToMain" >Back to Home</a>
			</div>

		    <div align="center">
		    	<img src="resources/img/patient_reg.png" alt="Item" height="50" width="50">
		    	<label style="font-size: 24px;">Add Item</label>		
		    </div>
				
			<c:if test="${isSuccess == true}">
				<br>
				<div align="center">
					<h4 style="color: blue;">Record Successfully Saved!</h4>
				</div>
			</c:if>
				
			<table style="width: 100%;">
				<tr>
					<td width="12%"></td>
					<td>
						<div class="form-group">
							<div class="col-xs-10" align="right">
							<c:choose>
								<c:when test="${isSuccess == true}">
									<input class="btn btn-default" type="button" value="Close" onclick="window.location.href = '/simsweb/goToSearchItem';">
								</c:when>
								<c:otherwise>
									<input class="btn btn-default" type="submit" value="Submit/Save">
									<input class="btn btn-default" type="button" value="Cancel" onclick="window.location.href = '/simsweb/goToSearchItem';">
								</c:otherwise>
							</c:choose>
							</div>
						</div>				
					</td>
				</tr>		
			</table>
					
			<table style="width: 100%;">
				<tr>
					<td width="12%"></td>
					<td>
						<div class="form-group">
							<form:label path="type.id" cssClass="col-sm-2 control-label">Type:</form:label>
							<div class="col-xs-3">
								<form:select id="typeListId" path="type.id"  items="${typeList}"  itemValue="id"   itemLabel="listValue" cssClass="form-control input-sm">
								</form:select>
			    			</div>
			    			<form:label path="itemCode" cssClass="col-sm-2 control-label">Item Code:</form:label>
							<div class="col-xs-3">
			      				<form:input id="itemCodeId" path="itemCode" cssClass="form-control input-sm"/>
								<form:errors path="itemCode" cssClass="error"></form:errors>
			    			</div>
						</div>						
					</td>
				</tr>
				<tr>
					<td width="12%"></td>
					<td>
						<div class="form-group">
							<form:label path="description" cssClass="col-sm-2 control-label">Description:</form:label>
							<div class="col-xs-3">
			      				<form:textarea id="descriptionId" rows="2" path="description" cssClass="form-control input-sm"/>
								<form:errors path="description" cssClass="error"></form:errors>
			    			</div>
			    			<form:label path="uom.id" cssClass="col-sm-2 control-label">UOM:</form:label>
							<div class="col-xs-3">
								<form:select id="uomId" path="uom.id"  items="${uomList}"  itemValue="id"   itemLabel="listValue" cssClass="form-control input-sm">
								</form:select>
			    			</div>
						</div>						
					</td>
				</tr>
				<tr>
					<td width="12%"></td>
					<td>
						<div class="form-group">
							<form:label path="brand.id" cssClass="col-sm-2 control-label">Brand:</form:label>
							<div class="col-xs-3">
								<form:select id="brandId" path="brand.id"  items="${brandList}"  itemValue="id"   itemLabel="name" cssClass="form-control input-sm">
								</form:select>
			    			</div>
			    			<form:label path="category.id" cssClass="col-sm-2 control-label">Category:</form:label>
							<div class="col-xs-3">
								<form:select id="categoryId" path="category.id"  items="${categoryList}"  itemValue="id"   itemLabel="name" onchange="filterSubCategory(this);" cssClass="form-control input-sm">
								</form:select>
			    			</div>
						</div>					
					</td>
				</tr>
				<tr>
					<td width="12%"></td>
					<td>
						<div class="form-group">
							<form:label path="" cssClass="col-sm-2 control-label"></form:label>
							<div class="col-xs-3">
								<form:checkbox id="vatId" path="vat" onchange="computeSellingPrice();" /> VAT(12%)
							</div>
			    			<form:label path="subCategory.id" cssClass="col-sm-2 control-label">SubCategory:</form:label>
							<div class="col-xs-3" id="subCategoryDIVId">
								<form:select id="subCategoryId" path="subCategory.id"  items="${subCategoryList}"  itemValue="id"   itemLabel="name" cssClass="form-control input-sm">
								</form:select>
			    			</div>
						</div>					
					</td>
				</tr>	
				<tr>
					<td width="12%"></td>
					<td>
						<div class="form-group">
							<form:label path="retailOrigPrice" cssClass="col-sm-2 control-label">Retail Original Price:</form:label>
							<div class="col-xs-3">
			      				<form:input path="retailOrigPrice" style="text-align: right;" id="retailOrigPriceId" onkeyup="computeRetailSellingPrice();" cssClass="form-control input-sm"/>
			    			</div>
			    			<form:label path="retailMarkupPercent" cssClass="col-sm-2 control-label">Retail Markup Percent:</form:label>
							<div class="col-xs-3">
			      				<form:input path="retailMarkupPercent" style="text-align: right;" id="retailMarkupPercentId" onkeypress="return isNumberKey(event);" onkeyup="computeRetailSellingPriceByMarkupPercent();" cssClass="form-control input-sm"/>
			    			</div>
						</div>						
					</td>
				</tr>
				<tr>
					<td width="12%"></td>
					<td>
						<div class="form-group">
			    			<form:label path="retailMarkupPrice" cssClass="col-sm-2 control-label">Retail Markup Price:</form:label>
							<div class="col-xs-3">
			      				<form:input path="retailMarkupPrice" style="text-align: right;" id="retailMarkupPriceId" onkeypress="return isNumberKey(event);" onkeyup="computeRetailSellingPriceByMarkupPrice();" cssClass="form-control input-sm"/>
			    			</div>
			    			<form:label path="retailSellingPrice" cssClass="col-sm-2 control-label">Retail Selling Price:</form:label>
							<div class="col-xs-3">
			      				<form:input path="retailSellingPrice" style="text-align: right;" id="retailSellingPriceId" cssClass="form-control input-sm"/>
			    			</div>
						</div>						
					</td>
				</tr>							
				<tr>
					<td width="12%"></td>
					<td>
						<div class="form-group">
							<form:label path="wholesaleOrigPrice" cssClass="col-sm-2 control-label">Wholesale Original Price:</form:label>
							<div class="col-xs-3">
			      				<form:input path="wholesaleOrigPrice" style="text-align: right;" id="wholesaleOrigPriceId" onkeyup="computeWholesaleSellingPrice();" cssClass="form-control input-sm"/>
			    			</div>
			    			<form:label path="wholesaleMarkupPercent" cssClass="col-sm-2 control-label">Wholesale Markup Percent:</form:label>
							<div class="col-xs-3">
			      				<form:input path="wholesaleMarkupPercent" style="text-align: right;" id="wholesaleMarkupPercentId" onkeypress="return isNumberKey(event);" onkeyup="computeWholesaleSellingPriceByMarkupPercent();" cssClass="form-control input-sm"/>
			    			</div>
						</div>						
					</td>
				</tr>				
				<tr>
					<td width="12%"></td>
					<td>
						<div class="form-group">
							<form:label path="wholesaleMarkupPrice" cssClass="col-sm-2 control-label">Wholesale Markup Price:</form:label>
							<div class="col-xs-3">
			      				<form:input path="wholesaleMarkupPrice" style="text-align: right;" id="wholesaleMarkupPriceId" onkeypress="return isNumberKey(event);" onkeyup="computeWholesaleSellingPriceByMarkupPrice();" cssClass="form-control input-sm"/>
			    			</div>
			    			<form:label path="wholesaleSellingPrice" cssClass="col-sm-2 control-label">Wholesale Selling Price:</form:label>
							<div class="col-xs-3">
			      				<form:input path="wholesaleSellingPrice" style="text-align: right;" id="wholesaleSellingPriceId" cssClass="form-control input-sm"/>
			    			</div>
						</div>						
					</td>
				</tr>	
				<tr>
					<td width="12%"></td>
					<td>
						<div class="form-group">
							<form:label path="discountPercent" cssClass="col-sm-2 control-label">Discount Percent:</form:label>
							<div class="col-xs-3">
			      				<form:input path="discountPercent" style="text-align: right;" id="discountPercentId" onkeypress="return isNumberKey(event);" onkeyup="computeDiscountAmtByPercent();" cssClass="form-control input-sm"/>
			    			</div>
			    			<form:label path="discountAmount" cssClass="col-sm-2 control-label">Discount Amount:</form:label>
							<div class="col-xs-3">
			      				<form:input path="discountAmount" style="text-align: right;" id="discountAmountId" onkeypress="return isNumberKey(event);"  cssClass="form-control input-sm"/>
			    			</div>
						</div>						
					</td>
				</tr>			
				<tr>
					<td width="12%"></td>
					<td>
						<div class="form-group">
							<form:label path="criticalLevel" cssClass="col-sm-2 control-label">Critical Level:</form:label>
							<div class="col-xs-3">
			      				<form:input path="criticalLevel" style="text-align: right;" cssClass="form-control input-sm"/>
			    			</div>
			    			<form:label path="optimumLevel" cssClass="col-sm-2 control-label">Optimum Level:</form:label>
							<div class="col-xs-3">
			      				<form:input path="optimumLevel" style="text-align: right;" cssClass="form-control input-sm"/>
			    			</div>
						</div>					
					</td>
				</tr>
				<tr>
					<td width="12%"></td>
					<td>
						<div class="form-group">
							<form:label path="maximumLevel" cssClass="col-sm-2 control-label">Maximum Level:</form:label>
							<div class="col-xs-3">
			      				<form:input path="maximumLevel" style="text-align: right;" cssClass="form-control input-sm"/>
			    			</div>
						</div>						
					</td>
				</tr>
				<tr>
					<td width="12%"></td>
					<td>
						<div class="form-group">
							<div class="col-xs-10" align="right">
							<c:choose>
								<c:when test="${isSuccess == true}">
									<input class="btn btn-default" type="button" value="Close" onclick="window.location.href = '/simsweb/goToSearchItem';">
								</c:when>
								<c:otherwise>
									<input class="btn btn-default" type="submit" value="Submit/Save">
									<input class="btn btn-default" type="button" value="Cancel" onclick="window.location.href = '/simsweb/goToSearchItem';">
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