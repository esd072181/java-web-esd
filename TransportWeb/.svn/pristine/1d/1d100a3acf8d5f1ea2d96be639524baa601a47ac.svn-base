<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
$(function() {
    $( "#menu" ).menu({
      items: "> :not(.ui-widget-header)"
    });
    
    $('#descriptionId').focus();
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
			<h3 style="font-weight: bolder;">Remarks/Status - Add New Record</h3>
			<html:form action="/remarks.do" styleId="idForm">
			
				<fieldset>
				
				<div>
					<html:errors/>
				</div>
				<div>
					<h4 style="color: blue;"><c:out value="${remarksForm.transactionMessage}"></c:out></h4>
				</div> 
						<div>
							<div class="control-group">
								<label  class="control-label" for="description">Description:</label>	
								 <div class="controls">
										<html:text styleId="descriptionId" property="description" styleClass="input-xlarge"  size="100" maxlength="500" value="${remarksForm.description}" disabled="${remarksForm.transactionStatus}"></html:text><br>
								 </div>						
							</div>
															
							<br>
							 <div class="control-group">
							 	 <div class="controls">
									<c:choose>
										<c:when test="${remarksForm.transactionStatus == true}">
											<html:button property="btnAddNew" styleClass="btn btn-primary" onclick="goToAddRemarks();" value="Add New Record"></html:button>
											<html:button property="btnClose" styleClass="btn btn-primary" onclick="goToRemarks();" value="Close"></html:button>
										</c:when>
										<c:otherwise>
											<html:button property="btnSave" styleClass="btn btn-primary" onclick="saveRemarks();" value="Save"></html:button>
											<html:button property="btnCancel" styleClass="btn btn-primary" onclick="goToRemarks();" value="Cancel"></html:button>
										</c:otherwise>
									</c:choose>								 	 
							 	 </div>
							 </div>
						</div>
				</fieldset>	
				
			</html:form>
</div>
	