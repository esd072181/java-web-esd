<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
$(function() {
    $( "#menu" ).menu({
      items: "> :not(.ui-widget-header)"
    });
    
    $('#lorryNoId').focus();
  });
  
</script>

<div style="height: 30%; padding-left: 10px;">
			<h3 style="font-weight: bolder;">Lorry - Add New Record</h3>
			<html:form action="/lorry.do" styleId="idForm">
			
				<fieldset>
				
				<div>
					<html:errors/>
				</div>
				<div>
					<h4 style="color: blue;"><c:out value="${lorryForm.transactionMessage}"></c:out></h4>
				</div> 
						<div>
							<div class="control-group">
								 <div class="controls">
									 <label  class="control-label" for="lorryNo">Lorry No:</label>
									<html:text styleId="lorryNoId" property="lorryNo" styleClass="input-xlarge"  size="20" maxlength="50" value="${lorryForm.lorryNo}" disabled="${lorryForm.transactionStatus}"></html:text><br>
								 </div>						
							</div>

							<div class="control-group">
								<div class="controls">
									<label  class="control-label top-spacing" for="plateNo">Plate No:</label>
									<html:text styleId="plateNoId" property="plateNo" styleClass="input-xlarge"  size="20" maxlength="50" value="${lorryForm.plateNo}" disabled="${lorryForm.transactionStatus}"></html:text><br>
								</div>
							</div>
							
							<div class="control-group">
								<div class="controls">
									<label  class="control-label top-spacing" for="trailerNo">Trailer No:</label>
									<html:text styleId="trailerNoId" property="trailerNo" styleClass="input-xlarge"  size="20" maxlength="50" value="${lorryForm.trailerNo}" disabled="${lorryForm.transactionStatus}"></html:text><br>
								</div>
							</div>

							<div class="control-group">
								<div class="controls">
									<label  class="control-label top-spacing" for="capacity">Capacity (KL):</label>
									<html:text styleId="capacityId" property="capacity" styleClass="input-xlarge"  size="10" maxlength="5" value="${lorryForm.capacity}" disabled="${lorryForm.transactionStatus}"></html:text><br>
								</div>
							</div>
							
							<div class="control-group">
								<div class="controls">
									<label  class="control-label top-spacing" for="capacity">Make/Model (Tractor):</label>
									<html:text styleId="tractorModelId" property="tractorModel" styleClass="input-xlarge"  size="25" maxlength="140" value="${lorryForm.tractorModel}" disabled="${lorryForm.transactionStatus}"></html:text>
									Year:<html:text styleId="tractorYearId" property="tractorYear" styleClass="input-xlarge"  size="10" maxlength="4" value="${lorryForm.tractorYear}" disabled="${lorryForm.transactionStatus}"></html:text><br>
								</div>
							</div>
							
							<div class="control-group">
								<div class="controls">
									<label  class="control-label top-spacing" for="capacity">Make/Model (Trailer):</label>
									<html:text styleId="trailerModelId" property="trailerModel" styleClass="input-xlarge"  size="25" maxlength="140" value="${lorryForm.trailerModel}" disabled="${lorryForm.transactionStatus}"></html:text>
									Year:<html:text styleId="trailerYearId" property="trailerYear" styleClass="input-xlarge"  size="10" maxlength="4" value="${lorryForm.trailerYear}" disabled="${lorryForm.transactionStatus}"></html:text><br>
								</div>
							</div>

							<div class="control-group">
								<div class="controls">
									<label  class="control-label top-spacing" for=lorryCategory>Category:</label>
									<html:select  name="lorryForm" property="lorryCategory" disabled="${lorryForm.transactionStatus}">
								 		<html:optionsCollection name="lorryForm" property="categoryLOV" label="listValue" value="listValue"/>				 		
								 	</html:select>
								</div>
							</div>
							
							<div class="control-group">
								<div class="controls">
									<label  class="control-label top-spacing" for="transportId">Transport:</label>
									<html:select  name="lorryForm" property="transportId" disabled="${lorryForm.transactionStatus}">
								 		<html:optionsCollection name="lorryForm" property="transportProgramLOV" label="listValue" value="id"/>				 		
								 	</html:select>
								</div>
							</div>
							
								 											
							<br>
							 <div class="control-group">
							 	 <div class="controls">
									<c:choose>
										<c:when test="${lorryForm.transactionStatus == true}">
											<html:button property="btnAddNew" styleClass="btn btn-primary" onclick="goToAddLorry();" value="Add New Record"></html:button>
											<html:button property="btnClose" styleClass="btn btn-primary" onclick="goToLorry();" value="Close"></html:button>
										</c:when>
										<c:otherwise>
											<html:button property="btnSave" styleClass="btn btn-primary" onclick="saveLorry();" value="Save"></html:button>
											<html:button property="btnCancel" styleClass="btn btn-primary" onclick="goToLorry();" value="Cancel"></html:button>
										</c:otherwise>
									</c:choose>								 	 
							 	 </div>
							 </div>
						</div>
				</fieldset>	
				
			</html:form>
</div>
	