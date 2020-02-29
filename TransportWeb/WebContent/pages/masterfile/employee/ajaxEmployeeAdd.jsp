<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
$(function() {
    $( "#menu" ).menu({
      items: "> :not(.ui-widget-header)"
    });
    
    $('#lastNameId').focus();
  });
</script>

<div style="height: 30%; padding-left: 10px;">
			<h3 style="font-weight: bolder;">Employee - Add New Record</h3>
			<html:form action="/employee.do" styleId="idForm">
			
				<fieldset>
				
				<div>
					<html:errors/>
				</div>
				<div>
					<h4 style="color: blue;"><c:out value="${employeeForm.transactionMessage}"></c:out></h4>
				</div> 
						<div>
							<div class="control-group">
								<label  class="control-label" for="lastName">Last Name:</label>	
								 <div class="controls">
										<html:text styleId="lastNameId" property="lastName" styleClass="input-xlarge"  size="20" maxlength="30" value="${employeeForm.lastName}" disabled="${employeeForm.transactionStatus}"></html:text><br>
								 </div>						
							</div>

							<div class="control-group">
								<label  class="control-label top-spacing" for="firstName">First Name:</label>
								<div class="controls">
									<html:text styleId="firstNameId" property="firstName" styleClass="input-xlarge"  size="20" maxlength="30" value="${employeeForm.firstName}" disabled="${employeeForm.transactionStatus}"></html:text><br>
								</div>
							</div>
							
							<div class="control-group">
								<label  class="control-label top-spacing" for="middleName">Middle Name:</label>
								<div class="controls">
									<html:text styleId="middleNameId" property="middleName" styleClass="input-xlarge"  size="20" maxlength="30" value="${employeeForm.middleName}" disabled="${employeeForm.transactionStatus}"></html:text><br>
								</div>
							</div>	
							
							<div class="control-group">
								<label  class="control-label top-spacing" for="roleId">Category:</label>	
								 <div class="controls">
								 	<html:select  name="employeeForm" property="empCategoryId" disabled="${employeeForm.transactionStatus}">
								 		<html:option value="0">--Select--</html:option>
								 		<html:optionsCollection name="employeeForm" property="empCategoryLOV" label="listValue" value="id"/>				 		
								 	</html:select>									 			
								 </div>						
							</div>
							
							<br>
							<div class="control-group">
								<label  class="control-label top-spacing" for="permitIssuer">Permit Issuer:</label>
								<html:checkbox  styleId="permitIssuerId" name="employeeForm" property="permitIssuer" styleClass="input-xlarge" disabled="${employeeForm.transactionStatus}"></html:checkbox>
								(Tick box if permit issuer)
							</div>
																						
							<br>
							 <div class="control-group">
							 	 <div class="controls">
									<c:choose>
										<c:when test="${employeeForm.transactionStatus == true}">
											<html:button property="btnAddNew" styleClass="btn btn-primary" onclick="goToAddEmployee();" value="Add New Record"></html:button>
											<html:button property="btnClose" styleClass="btn btn-primary" onclick="goToEmployee();" value="Close"></html:button>
										</c:when>
										<c:otherwise>
											<html:button property="btnSave" styleClass="btn btn-primary" onclick="saveEmployee();" value="Save"></html:button>
											<html:button property="btnCancel" styleClass="btn btn-primary" onclick="goToEmployee();" value="Cancel"></html:button>
										</c:otherwise>
									</c:choose>								 	 
							 	 </div>
							 </div>
						</div>
				</fieldset>	
				
			</html:form>
</div>

	
