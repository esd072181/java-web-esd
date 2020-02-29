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
		<h3 style="font-weight: bolder;">Remarks/Status - Edit Record</h3>
			<html:form action="/remarks.do" styleId="idForm" >
				<fieldset>
				
				<div>
					<html:errors/>
				</div>
				<div>
					<h4 style="color: blue;"><c:out value="${remarksForm.transactionMessage}"></c:out></h4>
				</div> 
						<div>
							<div class="control-group">
								<label  class="control-label" for="id">Id:</label>	
								 <div class="controls">
								 		<html:hidden property="id" value="${remarksForm.id}"/><!-- need to add hidden because the the text property for id is disabled -->
										<html:text property="id" styleClass="input-xlarge"  style="text-align: right;" size="2" value="${remarksForm.id}" disabled="true"></html:text><br>
								 </div>						
							</div>
							
							<div class="control-group">
								<label  class="control-label top-spacing" for="description">Description:</label>	
								 <div class="controls">
										<html:text styleId="descriptionId" property="description" styleClass="input-xlarge"  size="100" maxlength="500" value="${remarksForm.description}" disabled="${remarksForm.transactionStatus}"></html:text><br>
								 </div>						
							</div>
														
							<br>
							 <div class="control-group">
							 	 <div class="controls">
									<c:choose>
										<c:when test="${remarksForm.transactionStatus == true}">
											<html:button property="btnClose" styleClass="btn btn-primary" onclick="goToRemarks();" value="Close"></html:button>
										</c:when>
										<c:otherwise>
											<html:button property="btnUpdate" styleClass="btn btn-primary" onclick="updateRemarks();" value="Update"></html:button>
											<html:button property="btnCancel" styleClass="btn btn-primary" onclick="goToRemarks();" value="Cancel"></html:button>
										</c:otherwise>
									</c:choose>								 	 
							 	 </div>
							 </div>
						</div>
						
				</fieldset>				

			</html:form>
</div>
	
<script type="text/javascript">document.forms[0].elements['description'].focus();</script>	
	