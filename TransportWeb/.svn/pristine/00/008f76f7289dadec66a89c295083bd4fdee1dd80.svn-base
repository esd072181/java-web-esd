<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
$(function() {
    $( "#menu" ).menu({
      items: "> :not(.ui-widget-header)"
    });
    
    $('#descriptionId').focus();
  });
  
</script>

<div style="height: 30%; padding-left: 10px;">
			<h3 style="font-weight: bolder;">Findings - Add New Record</h3>
			<html:form action="/findings.do" styleId="idForm">
			
				<fieldset>
				
				<div>
					<html:errors/>
				</div>
				<div>
					<h4 style="color: blue;"><c:out value="${findingsForm.transactionMessage}"></c:out></h4>
				</div> 
						<div>
						
							<div class="control-group">
								<label  class="control-label" for="itemId">Item:</label>	
								 <div class="controls">
								 	<html:select  styleId="idItem" name="findingsForm" property="itemId" disabled="${findingsForm.transactionStatus}">
								 		<html:option value="0">--Select--</html:option>
								 		<html:optionsCollection name="findingsForm" property="itemList" label="description" value="id"/>				 		
								 	</html:select>									 			
								 </div>						
							</div>
										
							<div class="control-group">
								<label  class="control-label" for="description">Description:</label>
								 <div class="controls">
										<html:text styleId="descriptionId" property="description" styleClass="input-xlarge"  size="100" maxlength="500" value="${findingsForm.description}" disabled="${findingsForm.transactionStatus}"></html:text><br>
								 </div>						
							</div>
							
							<div class="control-group">
								<label  class="control-label top-spacing" for="typeId">Type:</label>	
								 <div class="controls">
								 	<html:select  name="findingsForm" property="typeId" disabled="${findingsForm.transactionStatus}">
								 		<html:option value="0">--Select--</html:option>
								 		<html:optionsCollection name="findingsForm" property="findingsTypeLOV" label="listValue" value="id"/>				 		
								 	</html:select>									 			
								 </div>						
							</div>							
							
															
							<br>
							 <div class="control-group">
							 	 <div class="controls">
									<c:choose>
										<c:when test="${findingsForm.transactionStatus == true}">
											<html:button property="btnAddNew" styleClass="btn btn-primary" onclick="goToAddFindings();" value="Add New Record"></html:button>
											<html:button property="btnClose" styleClass="btn btn-primary" onclick="goToFindings();" value="Close"></html:button>
										</c:when>
										<c:otherwise>
											<html:button property="btnSave" styleClass="btn btn-primary" onclick="saveFindings();" value="Save"></html:button>
											<html:button property="btnCancel" styleClass="btn btn-primary" onclick="goToFindings();" value="Cancel"></html:button>
										</c:otherwise>
									</c:choose>								 	 
							 	 </div>
							 </div>
						</div>
				</fieldset>	
				
			</html:form>
</div>
	