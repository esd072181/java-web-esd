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

<div class="row">
	<div class="col-sm-2">
	
		<!-- Left Menu -->
		<div style="padding-top: 15px; padding-left: 12px;">
		  	<!-- jQuery ui -->
		  	<ul id="menu" >
			  <li class="ui-widget-header">Options</li>
			  <li onclick="goToAddUser();"><a href="#">Add New Record</a></li>
			  <li onclick="goToUser();"><a href="#">Search Record</a></li>
		 	  <%@ include file="/template/menu_left_masterfile.jsp" %>
			</ul>
		</div>
	</div>
	
 	<div class="col-sm-10" style="padding-left: 40px;">

		<div style="height: 30%;">
			<h3 style="font-weight: bolder;">User - Add New Record</h3>
			<html:form action="/user.do" styleId="idForm">
			
				<fieldset>
				
					<div>
						<html:errors/>
					</div>
					<div>
						<h4 style="color: blue;"><c:out value="${userForm.transactionMessage}"></c:out></h4>
					</div> 
					
					<table>
						<tr>
							<td><label  class="control-label" for="employeeId">Employee Name</label></td>
							<td style="padding-left: 5px;">
								<html:select  styleId="idEmployee" name="userForm" property="employeeId" disabled="${userForm.transactionStatus}">
									 <html:option value="0">--Select--</html:option>
									 <html:optionsCollection name="userForm" property="employeeList" label="name" value="empId"/>				 		
								</html:select>						
							</td>
						</tr>
						<tr height="5px;"></tr>
						<tr>
							<td><label  class="control-label top-spacing" for="roleId">Role</label></td>
							<td style="padding-left: 5px;">
								<html:select  name="userForm" property="roleId" disabled="${userForm.transactionStatus}">
									 <html:option value="0">--Select--</html:option>
									 <html:optionsCollection name="userForm" property="userRoleLOV" label="listValue" value="id"/>				 		
								</html:select>	
							</td>
						</tr>
						<tr height="5px;"></tr>
						<tr>
							<td><label  class="control-label top-spacing" for="userName">User Name</label></td>
							<td style="padding-left: 5px;">
								<html:text styleId="userNameId" property="userName" styleClass="input-xlarge"  size="15" maxlength="15" value="${userForm.userName}" disabled="${userForm.transactionStatus}"></html:text><br>
							</td>
						</tr>
						<tr height="5px;"></tr>
						<tr>
							<td><label  class="control-label top-spacing" for="password">Password:</label></td>
							<td style="padding-left: 5px;">
								<html:password styleId="passwordId" property="password" styleClass="input-xlarge"  size="15" maxlength="15" value="${userForm.password}" disabled="${userForm.transactionStatus}"></html:password><br>
							</td>
						</tr>
						<tr height="15px"></tr>
						<tr>
							<td></td>
							<td style="padding-left: 5px;">
								<div class="control-group">
									<div class="controls">
										<c:choose>
											<c:when test="${userForm.transactionStatus == true}">
												<html:button property="btnAddNew" styleClass="btn btn-primary" onclick="goToAddUser();" value="Add New Record"></html:button>
												&nbsp;&nbsp;
												<html:button property="btnClose" styleClass="btn btn-primary" style="width: 100px;" onclick="goToUser();" value="Close"></html:button>
											</c:when>
											<c:otherwise>
												<html:button property="btnSave" styleClass="btn btn-primary" style="width: 100px;" onclick="saveUser();" value="Save"></html:button>
												&nbsp;&nbsp;
												<html:button property="btnCancel" styleClass="btn btn-primary" style="width: 100px;" onclick="goToUser();" value="Cancel"></html:button>
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
	