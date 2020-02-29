<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
$(function() {
    $( "#menu" ).menu({
      items: "> :not(.ui-widget-header)"
    });
    
    $('#datePurchasedDatePicker').datepicker({}); 
    $('#dateRetiredDatePicker').datepicker({}); 
    
    $('#brandId').focus();
  });
  
</script>

<div class="row">
	<div class="col-sm-2">
	
		<!-- Left Menu -->
		<div style="padding-top: 15px; padding-left: 12px;">
		  	<!-- jQuery ui -->
		  	<ul id="menu" style="width: 150px;">
			  <li class="ui-widget-header">Options</li>
			  <li onclick="goToTire();"><a href="#">Search Record</a></li>
			  <li onclick="goToAddTire();"><a href="#">Add New Record</a></li>
			  <%@ include file="/template/menu_left_masterfile.jsp" %>
			</ul>
		</div>
	</div>
	
 	<div class="col-sm-10">

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
						
							<div class="control-group">
								<label  class="control-label" for="brandId">Brand:</label>	
								 <div class="controls">
								 	<html:select  styleId="idBrand" name="tireForm" property="brandId" disabled="${tireForm.transactionStatus}">
								 		<html:option value="0">--Select--</html:option>
								 		<html:optionsCollection name="tireForm" property="brandList" label="name" value="id"/>				 		
								 	</html:select>									 			
								 </div>						
							</div>
							
							
							<div class="control-group">
								<label  class="control-label" for="serialNo">Serial No:</label>	
								 <div class="controls">
										<html:text styleId="serialNoId" property="serialNo" styleClass="input-xlarge"  size="30" maxlength="20" value="${tireForm.serialNo}" disabled="${tireForm.transactionStatus}"></html:text><br>
								 </div>						
							</div>
							
							<div class="control-group">
								<label  class="control-label" for="retired">Recap No:</label>	
								 <div class="controls">
								 		<html:select styleId="recapNoId" property="recapNo" value="${tireForm.recapNo}" disabled="${tireForm.transactionStatus}">
								 			<html:option value="N/A">N/A</html:option>
								 			<html:option value="1">1</html:option>
								 			<html:option value="2">2</html:option>
								 			<html:option value="3">3</html:option>
								 			<html:option value="4">4</html:option>
								 			<html:option value="5">5</html:option>
								 			<html:option value="6">6</html:option>
								 			<html:option value="7">7</html:option>
								 			<html:option value="8">8</html:option>
								 			<html:option value="9">9</html:option>
								 			<html:option value="10">10</html:option>
								 		</html:select>
								 </div>						
							</div>
							
							<div class="control-group">
							<label class="control-label" for="sizeAndPly">Size and Ply:</label>
							<div class="controls">
										<html:text styleId="sizeAndPlyId" property="sizeAndPly" styleClass="input-xlarge"  size="30" maxlength="20" value="${tireForm.sizeAndPly}" disabled="${tireForm.transactionStatus}"></html:text><br>
								 </div>						
							</div>
							
							<div>
								<label class="control-label top-spacing" for="datePurchased">Date Purchased:</label>
								<div class="controls">
									<html:text property="datePurchased" styleId="datePurchasedDatePicker"></html:text>
								</div>
							</div>
							
							<div class="control-group">
								<label  class="control-label" for="retired">Retired:</label>	
								 <div class="controls">
										<!--<html:text  property="retired" styleClass="input-xlarge"  size="5" maxlength="3" value="${tireForm.retired}" disabled="${tireForm.transactionStatus}"></html:text><br>-->
								 		<html:select styleId="retiredId" property="retired" value="${tireForm.retired}" disabled="${tireForm.transactionStatus}">
								 			<html:option value="No">No</html:option>
								 			<html:option value="Yes">Yes</html:option>
								 		</html:select>
								 </div>						
							</div>
							
							<div>
								<label class="control-label top-spacing" for="dateRetired">Date Retired:</label>
								<div class="controls">
									<html:text property="dateRetired" styleId="dateRetiredDatePicker"></html:text>
								</div>
							</div>
																															
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

</div>	
	