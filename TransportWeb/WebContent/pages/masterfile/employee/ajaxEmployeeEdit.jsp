<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
$(function() {
    $( "#menu" ).menu({
      items: "> :not(.ui-widget-header)"
    });
    
  });
  
 
</script>

<div style="height: 30%; padding-left: 10px;">
		<h3 style="font-weight: bolder;">Employee - Edit Record</h3>
			<html:form action="/employee.do" styleId="idForm" >
				<fieldset>
				
				<div>
					<html:errors/>
				</div>
				<div>
					<h4 style="color: blue;"><c:out value="${employeeForm.transactionMessage}"></c:out></h4>
				</div> 
						<div>
							<div class="control-group">
								<label  class="control-label" for="id">Id:</label>	
								 <div class="controls">
								 		<html:hidden property="id" value="${employeeForm.id}"/><!-- need to add hidden because the the text property for id is disabled -->
										<html:text property="id" styleClass="input-xlarge"  style="text-align: right;" size="2" value="${employeeForm.id}" disabled="true"></html:text><br>
								 </div>						
							</div>
							
							<div class="control-group">
								<label  class="control-label" for="lastName">Last Name:</label>	
								 <div class="controls">
										<html:text property="lastName" styleClass="input-xlarge"  size="20" maxlength="30" value="${employeeForm.lastName}" disabled="${employeeForm.transactionStatus}"></html:text><br>
								 </div>						
							</div>

							<div class="control-group">
								<label  class="control-label top-spacing" for="firstName">First Name:</label>
								<div class="controls">
									<html:text styleId="firstNameId" property="firstName" styleClass="input-xlarge"   size="20" maxlength="30" value="${employeeForm.firstName}" disabled="${employeeForm.transactionStatus}"></html:text><br>
								</div>
							</div>
							
							<div class="control-group">
								<label  class="control-label top-spacing" for="middleName">Middle Name:</label>
								<div class="controls">
									<html:text styleId="middleNameId" property="middleName" styleClass="input-xlarge"   size="20" maxlength="30" value="${employeeForm.middleName}" disabled="${employeeForm.transactionStatus}"></html:text><br>
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
											<html:button property="btnClose" styleClass="btn btn-primary" onclick="goToEmployee();" value="Close"></html:button>
										</c:when>
										<c:otherwise>
											<html:button property="btnUpdate" styleClass="btn btn-primary" onclick="updateEmployee();" value="Update"></html:button>
											<html:button property="btnCancel" styleClass="btn btn-primary" onclick="goToEmployee();" value="Cancel"></html:button>
										</c:otherwise>
									</c:choose>								 	 
							 	 </div>
							 </div>
						</div>
						
				</fieldset>				

			</html:form>
</div>
	
<script type="text/javascript">document.forms[0].elements['lastName'].focus();</script>
	