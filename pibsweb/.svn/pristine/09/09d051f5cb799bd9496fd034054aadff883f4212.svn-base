<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
$(function() {
    $( "#menu" ).menu({
      items: "> :not(.ui-widget-header)"
    });
 
  //limit the characters in textarea Remarks field
    $("#remarksId").keyup(function(){
        if($(this).val().length > remarksLength){
            $(this).val($(this).val().substr(0, remarksLength));
    	}
    });
  
    $("#entityNameId").focus();
    
  });
  
</script>

<div class="row">
	<div class="col-sm-2">
	
		<!-- Left Menu -->
		<div style="padding-top: 15px; padding-left: 12px;">
		  	<!-- jQuery ui -->
		  	<ul id="menu">
			  <li class="ui-widget-header">Menu</li>
			  <li onclick="goToAddSpecialization();"><a href="#">Add New Record</a></li>
			  <li onclick="goToSpecialization();"><a href="#">Search/Update Record</a></li>
			  <%@ include file="/template/menu_left_masterfile.jsp" %>
			</ul>
		</div>
	</div>
	
 	<div class="col-sm-10 divSpace">

		<div style="height: 30%; padding-top: 0px;" align="left">
			<h3>Specialization - Add New Record</h3>
			<html:form action="/specialization.do" styleId="idForm">
			
				<fieldset>
				
					<div>
						<html:errors/>
					</div>
					<div>
						<h4 style="color: blue;"><c:out value="${specializationForm.transactionMessage}"></c:out></h4>
					</div> 
					
					<table>
						<tr>
							<td><label  class="control-label" for="entityName">Name</label></td>
							<td style="padding-left: 5px;">
								<html:text styleId="entityNameId" property="entityName" styleClass="input-xlarge"  size="20" maxlength="20" value="${specializationForm.entityName}" disabled="${specializationForm.transactionStatus}"></html:text><br>
							</td>
						</tr>
						<tr height="5px"></tr>
						<tr>
							<td valign="top"><label  class="control-label" for="description">Description</label></td>
							<td style="padding-left: 5px;">
								<html:textarea styleId="descriptionId" rows="3" property="description" cols="40" styleClass="input-xlarge"  value="${specializationForm.description}" disabled="${specializationForm.transactionStatus}"></html:textarea><br>
							</td>
						</tr>
						<tr height="15px"></tr>
						<tr>
							<td></td>
							<td style="padding-left: 5px;">
								<div class="control-group">
									<div class="controls">
										<c:choose>
											<c:when test="${specializationForm.transactionStatus == true}">
												<html:button property="btnAddNew" styleClass="btn btn-primary" onclick="goToAddSpecialization();" value="Add New Record"></html:button>
												&nbsp;&nbsp;
												<html:button property="btnClose" styleClass="btn btn-primary" style="width: 100px;" onclick="goToSpecialization();" value="Close"></html:button>
											</c:when>
											<c:otherwise>
												<html:button property="btnSave" styleClass="btn btn-primary" style="width: 100px;" onclick="saveSpecialization();" value="Save"></html:button>
												&nbsp;&nbsp;
												<html:button property="btnCancel" styleClass="btn btn-primary" style="width: 100px;" onclick="goToSpecialization();" value="Cancel"></html:button>
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
	