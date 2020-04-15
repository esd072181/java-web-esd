<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
$(function() {
	$('#datePurchasedDatePicker').datepicker({}); 
    $('#recapNoId').focus();
  });
  
</script>



<div style="padding-left: 10px;">
	
		<div style="height: 30%;">
		<h3 style="font-weight: bolder;">Tire - Recap</h3>
			<html:form action="/tire.do" styleId="idForm" >
				<fieldset>
				
				<div>
					<html:errors/>
				</div>
				<div>
					<h4 style="color: blue;"><c:out value="${tireForm.transactionMessage}"></c:out></h4>
				</div> 
				
							<html:hidden property="id" value="${tireForm.id}"/><!-- need to add hidden because the the text property for id is disabled -->
							<html:hidden property="brandId" value="${tireForm.brandId}"/>
							<html:hidden property="serialNo" value="${tireForm.serialNo}"/>
													
							<table>
								<tr>
									<td><label  class="control-label top-spacing" for="brandId">Brand:</label>	</td>
									<td style="padding-left: 5px;">
										<div class="control-group">
											 <div class="controls">
											 	<html:select  styleId="idBrand" style="width: 220px;" name="tireForm" property="brandId" value="${tireForm.brandId}" disabled="true">
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
											 	<html:text styleId="serialNoId" property="serialNo" styleClass="input-xlarge"  size="30" maxlength="40" value="${tireForm.serialNo}"  disabled="true"></html:text><br>								 			
											 </div>						
										</div>
									</td>
								</tr>
							
								<tr>
									<td><label  class="control-label top-spacing" for="recapNo">Recap No:</label></td>
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
									<td><label class="control-label top-spacing" for="datePurchased">Date Purchased:</label></td>
									<td style="padding-left: 5px;">
										<div class="control-group">
											 <div class="controls">
											 	<html:text property="datePurchased" styleId="datePurchasedDatePicker" value="${tireForm.datePurchased}"></html:text>							 			
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
											<html:button property="btnClose" styleClass="btn btn-primary" onclick="goToTire();" value="Close"></html:button>
										</c:when>
										<c:otherwise>
											<html:button property="btnUpdate" styleClass="btn btn-primary" onclick="updateTireRecap();" value="Update"></html:button>
											<html:button property="btnCancel" styleClass="btn btn-primary" onclick="goToTire();" value="Cancel"></html:button>
										</c:otherwise>
									</c:choose>								 	 
							 	 </div>
							 </div>
						
						
				</fieldset>				

			</html:form>
		</div>
	
	
</div>	
	