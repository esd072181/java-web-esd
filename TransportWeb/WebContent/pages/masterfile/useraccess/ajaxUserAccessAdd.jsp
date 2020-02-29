<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
$(function() {
    $( "#menu" ).menu({
      items: "> :not(.ui-widget-header)"
    });
    
    $('#idEmployee').focus();
  });
  
</script>

<div style="height: 30%; padding-left: 10px;">
			<h3 style="font-weight: bolder;">User Access - Add New Record</h3>
			<html:form action="/userAccess.do" styleId="idForm">
			
				<fieldset>
				
				<div>
					<html:errors/>
				</div>
				<div>
					<h4 style="color: blue;"><c:out value="${userAccessForm.transactionMessage}"></c:out></h4>
				</div> 
						<div>
	
							<html:hidden property="userId" value="${userAccessForm.userId}"/>
							<div class="control-group">
								<label  class="control-label" for="employeeId">User:</label>	
								 <div class="controls">
								 	<html:select  styleId="userIdId" name="userAccessForm" property="userId" disabled="true">
								 		<html:optionsCollection name="userAccessForm" property="userList" label="name" value="id"/>				 		
								 	</html:select>									 			
								 </div>						
							</div>
	
							<div class="control-group">
								<label  class="control-label top-spacing" for="accessId">Module:</label>	
								 <div class="controls">
								 	<html:select  name="userAccessForm" property="accessId" disabled="${userAccessForm.transactionStatus}">
								 		<html:option value="0">--Select--</html:option>
								 		<html:optionsCollection name="userAccessForm" property="userAccessLOV" label="listValue" value="id"/>				 		
								 	</html:select>									 			
								 </div>						
							</div>
																
							<br>
							 <div class="control-group">
							 	 <div class="controls">
									<c:choose>
										<c:when test="${userAccessForm.transactionStatus == true}">
											<html:button property="btnAddNew" styleClass="btn btn-primary" onclick="goToAddUserAccess($('#userIdId').val());" value="Add Another User Access"></html:button>
											<html:button property="btnClose" styleClass="btn btn-primary" onclick="goToUserAccess();" value="Close"></html:button>
										</c:when>
										<c:otherwise>
											<html:button property="btnSave" styleClass="btn btn-primary" onclick="saveUserAccess();" value="Save"></html:button>
											<html:button property="btnCancel" styleClass="btn btn-primary" onclick="goToUserAccess();" value="Cancel"></html:button>
										</c:otherwise>
									</c:choose>								 	 
							 	 </div>
							 </div>
						</div>
				</fieldset>	
				
			</html:form>
</div>
	