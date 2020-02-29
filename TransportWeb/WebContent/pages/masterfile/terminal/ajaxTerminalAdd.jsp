<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
$(function() {
    $( "#menu" ).menu({
      items: "> :not(.ui-widget-header)"
    });
    
    $('#nameId').focus();
  });
  
//limit the characters in textarea field - sample script
/*
$("#descriptionId").keyup(function(){
    if($(this).val().length > remarksLength){
        $(this).val($(this).val().substr(0, remarksLength));
	}
});*/

</script>

<div style="height: 30%; padding-left: 10px;">
			<h3 style="font-weight: bolder;">Terminal - Add New Record</h3>
			<html:form action="/terminal.do" styleId="idForm">
			
				<fieldset>
				
				<div>
					<html:errors/>
				</div>
				<div>
					<h4 style="color: blue;"><c:out value="${terminalForm.transactionMessage}"></c:out></h4>
				</div> 
						<div>
							<div class="control-group">
								<label  class="control-label" for="name">Name:</label>	
								 <div class="controls">
										<html:text styleId="nameId" property="name" styleClass="input-xlarge"  size="75" maxlength="500" value="${terminalForm.name}" disabled="${terminalForm.transactionStatus}"></html:text><br>
								 </div>						
							</div>
															
							<br>
							 <div class="control-group">
							 	 <div class="controls">
									<c:choose>
										<c:when test="${terminalForm.transactionStatus == true}">
											<html:button property="btnAddNew" styleClass="btn btn-primary" onclick="goToAddTerminal();" value="Add New Record"></html:button>
											<html:button property="btnClose" styleClass="btn btn-primary" onclick="goToTerminal();" value="Close"></html:button>
										</c:when>
										<c:otherwise>
											<html:button property="btnSave" styleClass="btn btn-primary" onclick="saveTerminal();" value="Save"></html:button>
											<html:button property="btnCancel" styleClass="btn btn-primary" onclick="goToTerminal();" value="Cancel"></html:button>
										</c:otherwise>
									</c:choose>								 	 
							 	 </div>
							 </div>
						</div>
				</fieldset>	
				
			</html:form>
</div>
	