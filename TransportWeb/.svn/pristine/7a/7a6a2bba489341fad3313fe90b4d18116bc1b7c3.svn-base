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
			<h3 style="font-weight: bolder;">Items - Add New Record</h3>
			<html:form action="/items.do" styleId="idForm">
			
				<fieldset>
				
				<div>
					<html:errors/>
				</div>
				<div>
					<h4 style="color: blue;"><c:out value="${itemsForm.transactionMessage}"></c:out></h4>
				</div> 
						<div>
							<div class="control-group">
								<label  class="control-label" for="description">Description:</label>	
								 <div class="controls">
										<html:text styleId="descriptionId" property="description" styleClass="input-xlarge"  size="75" maxlength="400" value="${itemsForm.description}" disabled="${itemsForm.transactionStatus}"></html:text><br>
								 </div>						
							</div>
															
							<br>
							 <div class="control-group">
							 	 <div class="controls">
									<c:choose>
										<c:when test="${itemsForm.transactionStatus == true}">
											<html:button property="btnAddNew" styleClass="btn btn-primary" onclick="goToAddItems();" value="Add New Record"></html:button>
											<html:button property="btnClose" styleClass="btn btn-primary" onclick="goToItems();" value="Close"></html:button>
										</c:when>
										<c:otherwise>
											<html:button property="btnSave" styleClass="btn btn-primary" onclick="saveItems();" value="Save"></html:button>
											<html:button property="btnCancel" styleClass="btn btn-primary" onclick="goToItems();" value="Cancel"></html:button>
										</c:otherwise>
									</c:choose>								 	 
							 	 </div>
							 </div>
						</div>
				</fieldset>	
				
			</html:form>
</div>
	