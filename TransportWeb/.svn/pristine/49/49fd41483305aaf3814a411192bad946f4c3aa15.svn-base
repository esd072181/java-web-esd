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
			<h3 style="font-weight: bolder;">User - Add New Record</h3>
			<html:form action="/user.do" styleId="idForm">
			
				<fieldset>
				
				<div>
					<html:errors/>
				</div>
				<div>
					<h4 style="color: blue;"><c:out value="${userForm.transactionMessage}"></c:out></h4>
				</div> 
						<div>
	
							
							<div class="control-group">
								<label  class="control-label" for="employeeId">Employee Name:</label>	
								 <div class="controls">
								 	<html:select  styleId="idEmployee" name="userForm" property="employeeId" disabled="${userForm.transactionStatus}">
								 		<html:option value="0">--Select--</html:option>
								 		<html:optionsCollection name="userForm" property="employeeList" label="name" value="empId"/>				 		
								 	</html:select>									 			
								 </div>						
							</div>
	
							<div class="control-group">
								<label  class="control-label top-spacing" for="roleId">Role:</label>	
								 <div class="controls">
								 	<html:select  name="userForm" property="roleId" disabled="${userForm.transactionStatus}">
								 		<html:option value="0">--Select--</html:option>
								 		<html:optionsCollection name="userForm" property="userRoleLOV" label="listValue" value="id"/>				 		
								 	</html:select>									 			
								 </div>						
							</div>
												
							<div class="control-group">
								<label  class="control-label top-spacing" for="userName">User Name:</label>	
								 <div class="controls">
										<html:text styleId="userNameId" property="userName" styleClass="input-xlarge"  size="15" maxlength="15" value="${userForm.userName}" disabled="${userForm.transactionStatus}"></html:text><br>
								 </div>						
							</div>
							
								<div class="control-group">
								<label  class="control-label top-spacing" for="password">Password:</label>	
								 <div class="controls">
										<html:password styleId="passwordId" property="password" styleClass="input-xlarge"  size="15" maxlength="15" value="${userForm.password}" disabled="${userForm.transactionStatus}"></html:password><br>
								 </div>						
							</div>
																
							<br>
							 <div class="control-group">
							 	 <div class="controls">
									<c:choose>
										<c:when test="${userForm.transactionStatus == true}">
											<html:button property="btnAddNew" styleClass="btn btn-primary" onclick="goToAddUser();" value="Add New Record"></html:button>
											<html:button property="btnClose" styleClass="btn btn-primary" onclick="goToUser();" value="Close"></html:button>
										</c:when>
										<c:otherwise>
											<html:button property="btnSave" styleClass="btn btn-primary" onclick="saveUser();" value="Save"></html:button>
											<html:button property="btnCancel" styleClass="btn btn-primary" onclick="goToUser();" value="Cancel"></html:button>
										</c:otherwise>
									</c:choose>								 	 
							 	 </div>
							 </div>
						</div>
				</fieldset>	
				
			</html:form>
</div>
	