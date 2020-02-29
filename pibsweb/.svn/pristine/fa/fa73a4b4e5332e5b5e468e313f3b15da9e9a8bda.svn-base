<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
$(function() {
    $( "#menu" ).menu({
      items: "> :not(.ui-widget-header)"
    });
    
    $('#dtManufacturedDatePicker').datepicker({}); 
    
    $('#dtExpirationDatePicker').datepicker({}); 
    

    //limit the characters in textarea Remarks field
    $("#remarksId").keyup(function(){
      if($(this).val().length > remarksLength){
          $(this).val($(this).val().substr(0, remarksLength));
  	  }
    });  

    $("#retailSellingPriceId").keydown(function (e) {
        // Allow: backspace, delete, tab, escape, enter and .
        if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110, 190]) !== -1 ||
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
        if ( (e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || (e.keyCode > 105)) ) {
            e.preventDefault();
        }   
    });
    
    $('#medicalSupplyTypeIdId').focus();
    
  });
  
</script>



<div class="row">
	<div class="col-sm-2">
	
		<!-- Left Menu -->
		<div style="padding-top: 15px; padding-left: 12px;">
		  	<!-- jQuery ui -->
		  	<ul id="menu">
			  <li class="ui-widget-header">Menu</li>
			  <li onclick="goToAddMedicalSupply();"><a href="#">Add New Record</a></li>
			  <li onclick="goToMedicalSupply();"><a href="#">Search/Update Record</a></li>
              <%@ include file="/template/menu_left_masterfile.jsp" %>
			</ul>
		</div>
	</div>
	
 	<div class="col-sm-10 divSpace">

		<div style="height: 30%; padding-top: 0px;" align="left">
		<h3>Medical Supply - Edit Record</h3>
			<html:form action="/medicalSupply.do" styleId="idForm" >
				<fieldset>
				
					<div>
						<html:errors/>
					</div>
					<div>
						<h4 style="color: blue;"><c:out value="${medicalSupplyForm.transactionMessage}"></c:out></h4>
					</div> 
					
					<html:hidden property="id" value="${medicalSupplyForm.id}"/>
					<table>
						<tr>
							<td><label  class="control-label top-spacing" for="roleId">Type</label></td>
							<td style="padding-left: 5px;">
								<html:select  styleId="medicalSupplyTypeIdId" name="medicalSupplyForm" property="medicalSupplyTypeId" disabled="${medicalSupplyForm.transactionStatus}">
									 <html:option value="0">--Select--</html:option>
									 <html:optionsCollection name="medicalSupplyForm" property="medicalSupplyTypeLOV" label="listValue" value="id"/>				 		
								</html:select>						
							</td>
						</tr>
						<tr height="5px;"></tr>
						<tr>
							<td><label  class="control-label" for="itemCode">Item Code</label>	</td>
							<td style="padding-left: 5px;">
								<html:text styleId="itemCodeId" property="itemCode" styleClass="input-xlarge"  size="20" maxlength="20" value="${medicalSupplyForm.itemCode}" disabled="${medicalSupplyForm.transactionStatus}"></html:text><br>
							</td>
						</tr>
						<tr height="5px;"></tr>
						<tr>
							<td><label  class="control-label" for="description">Description</label></td>
							<td style="padding-left: 5px;">
								<html:text styleId="descriptionId" property="description" styleClass="input-xlarge"  size="20" maxlength="20" value="${medicalSupplyForm.description}" disabled="${medicalSupplyForm.transactionStatus}"></html:text><br>
							</td>					
						</tr>
						<tr height="5px;"></tr>
						<tr>
							<td><label  class="control-label" for="genericName">Generic Name</label>	</td>
							<td style="padding-left: 5px;">
								<html:text styleId="genericNameId" property="genericName" styleClass="input-xlarge"  size="20" maxlength="20" value="${medicalSupplyForm.genericName}" disabled="${medicalSupplyForm.transactionStatus}"></html:text><br>
							</td>
						</tr>
						<tr height="5px;"></tr>
						<tr>
							<td><label  class="control-label" for="remarks">Remarks</label></td>
							<td style="padding-left: 5px;">
								<html:textarea styleId="remarksId" rows="3" property="remarks" cols="40" styleClass="input-xlarge"  value="${medicalSupplyForm.remarks}" disabled="${medicalSupplyForm.transactionStatus}"></html:textarea><br>
							</td>
						</tr>
						<tr height="5px;"></tr>
						<tr>
							<td><label  class="control-label" for="lotNo">Lot No</label></td>
							<td style="padding-left: 5px;">
								<html:textarea styleId="lotNoId" rows="3" property="lotNo" cols="40" styleClass="input-xlarge"  value="${medicalSupplyForm.lotNo}" disabled="${medicalSupplyForm.transactionStatus}"></html:textarea><br>
							</td>
						</tr>
						<tr height="5px;"></tr>
						<tr>
							<td><label class="control-label top-spacing" for="dateManufactured">Manufactured Date</label></td>
							<td style="padding-left: 5px;">
								<c:choose>
									<c:when test="${medicalSupplyForm.transactionStatus == true}">
										<input style="text-align: right;" type="text" name="dateManufactured" id="dtManufacturedDatePicker"  value="${medicalSupplyForm.dateManufactured}" placeholder="mm/dd/yyyy"  disabled="disabled"/>	
									</c:when>
									<c:otherwise>
										<input style="text-align: right;" type="text" name="dateManufactured" id="dtManufacturedDatePicker"  value="${medicalSupplyForm.dateManufactured}" placeholder="mm/dd/yyyy" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr height="5px;"></tr>
						<tr>
							<td><label class="control-label top-spacing" for="expirationDate">Expiration Date</label></td>
							<td style="padding-left: 5px;">
								<c:choose>
									<c:when test="${medicalSupplyForm.transactionStatus == true}">
										<input style="text-align: right;" type="text" name="expirationDate" id="dtExpirationDatePicker" value="${medicalSupplyForm.expirationDate}" placeholder="mm/dd/yyyy" disabled="disabled"/>	
									</c:when>
									<c:otherwise>
										<input style="text-align: right;" type="text" name="expirationDate" id="dtExpirationDatePicker" value="${medicalSupplyForm.expirationDate}" placeholder="mm/dd/yyyy" />
									</c:otherwise>	
								</c:choose>
							</td>
						</tr>
						<tr height="5px;"></tr>
						<tr>
							<td><label  class="control-label" for="retailSellingPrice">Retail Selling Price (Php)</label>	</td>
							<td style="padding-left: 5px;">
								<html:text style="text-align: right;" styleId="retailSellingPriceId" property="retailSellingPrice" styleClass="input-xlarge"  size="20" maxlength="20" value="${medicalSupplyForm.retailSellingPrice}" disabled="${medicalSupplyForm.transactionStatus}"></html:text><br>
							</td>
						</tr>
						<tr height="15px"></tr>				
						<tr>
							<td></td>
							<td style="padding-left: 5px;">
								<div class="control-group">
									<div class="controls">
										<c:choose>
											<c:when test="${medicalSupplyForm.transactionStatus == true}">
												<html:button property="btnClose" styleClass="btn btn-primary" style="width: 100px;" onclick="goToMedicalSupply();" value="Close"></html:button>
											</c:when>
											<c:otherwise>
												<html:button property="btnUpdate" styleClass="btn btn-primary" style="width: 100px;" onclick="updateMedicalSupply();" value="Update"></html:button>
												&nbsp;&nbsp;
												<html:button property="btnCancel" styleClass="btn btn-primary" style="width: 100px;" onclick="goToMedicalSupply();" value="Cancel"></html:button>
											</c:otherwise>
										</c:choose>						
									</div>							
								</div>
							</td>
						</tr>
					</table>
						
				</fieldset>				

			</html:form>
		</div>
	
	</div>
	
</div>	
	