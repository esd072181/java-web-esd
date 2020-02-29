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
			<h3 style="font-weight: bolder;">Corrective Actions - Add New Record</h3>
			<html:form action="/corrections.do" styleId="idForm">
			
				<fieldset>
				
				<div>
					<html:errors/>
				</div>
				<div>
					<h4 style="color: blue;"><c:out value="${correctionsForm.transactionMessage}"></c:out></h4>
				</div> 
						<div>
							<div class="control-group">
								<label  class="control-label" for="description">Description:</label>	
								 <div class="controls">
										<html:text styleId="descriptionId" property="description" styleClass="input-xlarge"  size="100" maxlength="500" value="${correctionsForm.description}" disabled="${correctionsForm.transactionStatus}"></html:text><br>
								 </div>						
							</div>
							
							<div class="control-group">
								<label  class="control-label" for="itemId">Root Cause:</label>	
								 <div class="controls">
								 	<html:select  styleId="idItem" name="correctionsForm" property="rootCauseId" disabled="${correctionsForm.transactionStatus}">
								 		<html:option value="0">--Select--</html:option>
								 		<html:optionsCollection name="correctionsForm" property="rootCauseList" label="description" value="id"/>				 		
								 	</html:select>									 			
								 </div>						
							</div>
															
							<br>
							 <div class="control-group">
							 	 <div class="controls">
									<c:choose>
										<c:when test="${correctionsForm.transactionStatus == true}">
											<html:button property="btnAddNew" styleClass="btn btn-primary" onclick="goToAddCorrections();" value="Add New Record"></html:button>
											<html:button property="btnClose" styleClass="btn btn-primary" onclick="goToCorrections();" value="Close"></html:button>
										</c:when>
										<c:otherwise>
											<html:button property="btnSave" styleClass="btn btn-primary" onclick="saveCorrections();" value="Save"></html:button>
											<html:button property="btnCancel" styleClass="btn btn-primary" onclick="goToCorrections();" value="Cancel"></html:button>
										</c:otherwise>
									</c:choose>								 	 
							 	 </div>
							 </div>
						</div>
				</fieldset>	
				
			</html:form>
</div>
	