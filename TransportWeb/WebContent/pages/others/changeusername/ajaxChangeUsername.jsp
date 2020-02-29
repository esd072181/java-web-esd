<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
$(function() {
    $( "#menu" ).menu({
      items: "> :not(.ui-widget-header)"
    });
  });
  
</script>



<div class="row">
	
 	<div class="col-sm-10">

		<div style="height: 30%; margin-left: 20px;">
		<h3 style="font-weight: bolder;">Change Username and Password</h3>
			<html:form action="/changeUsername.do" styleId="idForm" >
				<fieldset>
				
				<div>
					<html:errors/>
				</div>
				<div>
					<h4 style="color: blue;"><c:out value="${changeUsernameForm.transactionMessage}"></c:out></h4>
				</div> 
						<div>
							<!--  User name -->
							<div class="control-group">
								<label  class="control-label top-spacing" for="userName">User name:</label>	
								 <div class="controls">
										<html:text styleId="userNameId" property="userName" styleClass="input-xlarge"  size="30" maxlength="30" value="${changeUsernameForm.userName}" disabled="${changeUsernameForm.transactionStatus}"></html:text><br>
								 </div>						
							</div>
							
							<!--  Password -->
							<div class="control-group">
								<label  class="control-label top-spacing" for="password">Password:</label>	
								 <div class="controls">
										<html:password styleId="passwordId" property="password" styleClass="input-xlarge"  size="30" maxlength="30" value="${changeUsernameForm.password}" disabled="${changeUsernameForm.transactionStatus}"></html:password><br>
								 </div>						
							</div>
							
							<!-- Re-Enter Password -->
							<div class="control-group">
								<label  class="control-label top-spacing" for="reEnterPassword">Re-Enter Password:</label>	
								 <div class="controls">
										<html:password styleId="reEnterPasswordId" property="reEnterPassword" styleClass="input-xlarge"  size="30" maxlength="30" value="${changeUsernameForm.reEnterPassword}" disabled="${changeUsernameForm.transactionStatus}"></html:password><br>
								 </div>						
							</div>
														
							<br>
							 <div class="control-group">
							 	 <div class="controls">
									<c:choose>
										<c:when test="${changeUsernameForm.transactionStatus == true}">
											<html:button property="btnClose" styleClass="btn btn-primary" onclick="goToMainByAjax();" value="Close"></html:button>
										</c:when>
										<c:otherwise>
											<html:button property="btnUpdate" styleClass="btn btn-primary" onclick="updateChangeUsername();" value="Update"></html:button>
											<html:button property="btnCancel" styleClass="btn btn-primary" onclick="goToMainByAjax();" value="Cancel"></html:button>
										</c:otherwise>
									</c:choose>								 	 
							 	 </div>
							 </div>
						</div>
						
				</fieldset>				

			</html:form>
		</div>
	
	</div>
	<script type="text/javascript">document.forms[0].elements['userName'].focus();</script>
</div>	
	