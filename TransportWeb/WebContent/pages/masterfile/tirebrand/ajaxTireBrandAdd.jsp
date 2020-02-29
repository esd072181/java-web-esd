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

<div class="row">
	<div class="col-sm-2">
	
		<!-- Left Menu -->
		<div style="padding-top: 15px; padding-left: 12px;">
		  	<!-- jQuery ui -->
		  	<ul id="menu" style="width: 150px;">
			  <li class="ui-widget-header">Options</li>
			  <li onclick="goToTireBrand();"><a href="#">Search Record</a></li>
			  <li onclick="goToAddTireBrand();"><a href="#">Add New Record</a></li>
			  <%@ include file="/template/menu_left_masterfile.jsp" %>
			</ul>
		</div>
	</div>
	
 	<div class="col-sm-10">

		<div style="height: 30%;">
			<h3 style="font-weight: bolder;">Tire Brand - Add New Record</h3>
			<html:form action="/tirebrand.do" styleId="idForm">
			
				<fieldset>
				
				<div>
					<html:errors/>
				</div>
				<div>
					<h4 style="color: blue;"><c:out value="${tireBrandForm.transactionMessage}"></c:out></h4>
				</div> 
						<div>
							<div class="control-group">
								<label  class="control-label" for="name">Name:</label>	
								 <div class="controls">
										<html:text styleId="nameId" property="name" styleClass="input-xlarge"  size="50" maxlength="30" value="${tireBrandForm.name}" disabled="${tireBrandForm.transactionStatus}"></html:text><br>
								 </div>						
							</div>
							<div class="control-group">
								<label  class="control-label" for="description">Description:</label>	
								 <div class="controls">
										<html:text styleId="descriptionId" property="description" styleClass="input-xlarge"  size="100" maxlength="500" value="${tireBrandForm.description}" disabled="${tireBrandForm.transactionStatus}"></html:text><br>
								 </div>						
							</div>
															
							<br>
							 <div class="control-group">
							 	 <div class="controls">
									<c:choose>
										<c:when test="${tireBrandForm.transactionStatus == true}">
											<html:button property="btnAddNew" styleClass="btn btn-primary" onclick="goToAddTireBrand();" value="Add New Record"></html:button>
											<html:button property="btnClose" styleClass="btn btn-primary" onclick="goToTireBrand();" value="Close"></html:button>
										</c:when>
										<c:otherwise>
											<html:button property="btnSave" styleClass="btn btn-primary" onclick="saveTireBrand();" value="Save"></html:button>
											<html:button property="btnCancel" styleClass="btn btn-primary" onclick="goToTireBrand();" value="Cancel"></html:button>
										</c:otherwise>
									</c:choose>								 	 
							 	 </div>
							 </div>
						</div>
				</fieldset>	
				
			</html:form>
		</div>
	
	</div>
</div>	
	