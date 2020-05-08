<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
$(function() {
    
    $('#datePurchasedDatePicker').datepicker({}); 
    $('#dateRetiredDatePicker').datepicker({}); 

	$("#priceId").keydown(function (e) {
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
    
    $('#brandId').focus();
	 
  });
  
</script>

<div style="padding-left: 10px;">

		<div style="height: 30%;">
			<h3 style="font-weight: bolder;">Tire  - Add New Record</h3>
			<html:form action="/tire.do" styleId="idForm">
			
				<fieldset>
				
				<div>
					<html:errors/>
				</div>
				<div>
					<h4 style="color: blue;"><c:out value="${tireForm.transactionMessage}"></c:out></h4>
				</div> 
				
						<div>
						
							<table>
								<tr>
									<td><label  class="control-label top-spacing" for="brandId">Brand:</label>	</td>
									<td style="padding-left: 5px;">
										<div class="control-group">
											 <div class="controls">
											 	<html:select  styleId="idBrand" style="width: 220px;" name="tireForm" property="brandId" value="${tireForm.brandId}" disabled="${tireForm.transactionStatus}">
											 		<html:option value="0">--Select--</html:option>
											 		<html:optionsCollection name="tireForm" property="brandList" label="name" value="id"/>				 		
											 	</html:select>									 			
											 </div>						
										</div>
									</td>
								</tr>
								<tr>
									<td><label  class="control-label top-spacing" for="serialNo">Serial No:</label></td>
									<td style="padding-left: 5px;">
										<div class="control-group">
											 <div class="controls">
											 	<html:text styleId="serialNoId" property="serialNo" styleClass="input-xlarge"  size="30" maxlength="40" value="${tireForm.serialNo}" disabled="${tireForm.transactionStatus}"></html:text><br>								 			
											 </div>						
										</div>
									</td>
								</tr>
								<tr>
									<td><label  class="control-label top-spacing" for="retired">Recap No:</label></td>
									<td style="padding-left: 5px;">
										<div class="control-group">
											 <div class="controls">
											 	<html:select styleId="recapNoId" property="recapNo" value="${tireForm.recapNo}" disabled="${tireForm.transactionStatus}">
										 			<html:option value="N/A">N/A</html:option>
										 			<html:option value="1">1</html:option>
										 			<html:option value="2">2</html:option>
										 		</html:select>								 			
											 </div>						
										</div>
									</td>
								</tr>
								<tr>
									<td><label class="control-label top-spacing" for="sizeAndPly">Size and Ply:</label></td>
									<td style="padding-left: 5px;">
										<div class="control-group">
											 <div class="controls">
											 	<html:text styleId="sizeAndPlyId" property="sizeAndPly" styleClass="input-xlarge"  size="20" maxlength="40" value="${tireForm.sizeAndPly}" disabled="${tireForm.transactionStatus}"></html:text><br>							 			
											 </div>						
										</div>
									</td>
								</tr>
								<tr>
									<td><label class="control-label top-spacing" for="price">Price (Php):</label></td>
									<td style="padding-left: 5px;">
										<div class="control-group">
											 <div class="controls">
											 	<html:text styleId="priceId" property="price" style="text-align: right;" styleClass="input-xlarge"  size="20" maxlength="20" value="${tireForm.price}" disabled="${tireForm.transactionStatus}"></html:text><br>							 			
											 </div>						
										</div>
									</td>
								</tr>
								<tr>
									<td><label class="control-label top-spacing" for="datePurchased">Date Purchased:</label></td>
									<td style="padding-left: 5px;">
										<div class="control-group">
											 <div class="controls">
											 	<html:text property="datePurchased" styleId="datePurchasedDatePicker" value="${tireForm.datePurchased}"></html:text>							 			
											 </div>						
										</div>
									</td>
								</tr>
								<tr>
									<td><label class="control-label top-spacing" for="invoiceNo">Invoice No:</label></td>
									<td style="padding-left: 5px;">
										<div class="control-group">
											 <div class="controls">
											 	<html:text styleId="invoiceNoId" property="invoiceNo" styleClass="input-xlarge"  size="20" maxlength="20" value="${tireForm.invoiceNo}" disabled="${tireForm.transactionStatus}"></html:text><br>							 			
											 </div>						
										</div>
									</td>
								</tr>
								<tr>
									<td><label class="control-label top-spacing" for="analysis">Analysis:</label></td>
									<td style="padding-left: 5px;">
										<div class="control-group">
											 <div class="controls">
											 	<html:text styleId="analysisId" property="analysis" styleClass="input-xlarge"  size="50" maxlength="40" value="${tireForm.analysis}" disabled="${tireForm.transactionStatus}"></html:text><br>							 			
											 </div>						
										</div>
									</td>
								</tr>
								<tr>
									<td><label class="control-label top-spacing" for="comments">Comments:</label></td>
									<td style="padding-left: 5px;">
										<div class="control-group">
											 <div class="controls">
											 	<html:text styleId="commentsId" property="comments" styleClass="input-xlarge"  size="50" maxlength="40" value="${tireForm.comments}" disabled="${tireForm.transactionStatus}"></html:text><br>							 			
											 </div>						
										</div>
									</td>
								</tr>
	
							</table>
																													
							<br>
							 <div class="control-group">
							 	 <div class="controls">
									<c:choose>
										<c:when test="${tireForm.transactionStatus == true}">
											<html:button property="btnAddNew" styleClass="btn btn-primary" onclick="goToAddTire();" value="Add New Record"></html:button>
											<html:button property="btnClose" styleClass="btn btn-primary" onclick="goToTire();" value="Close"></html:button>
										</c:when>
										<c:otherwise>
											<html:button property="btnSave" styleClass="btn btn-primary" onclick="saveTire();" value="Save"></html:button>
											<html:button property="btnCancel" styleClass="btn btn-primary" onclick="goToTire();" value="Cancel"></html:button>
										</c:otherwise>
									</c:choose>								 	 
							 	 </div>
							 </div>
						</div>
				</fieldset>	
				
			</html:form>
		</div>

</div>	
	