<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
$(function() {
    $('#nameId').focus().val($('#nameId').val());
  });
  
 
</script>

<div style="padding-left:10px;">

		<div style="height: 30%;">
		<h3 style="font-weight: bolder;">Tire Brand - Edit Record</h3>
			<html:form action="/tirebrand.do" styleId="idForm" >
				<fieldset>
				
				<div>
					<html:errors/>
				</div>
				<div>
					<h4 style="color: blue;"><c:out value="${tireBrandForm.transactionMessage}"></c:out></h4>
				</div> 
						<div>
							<html:hidden property="id" value="${tireBrandForm.id}"/><!-- need to add hidden because the the text property for id is disabled -->
							<table>
								<tr>
									<td><label  class="control-label" for="name">Name:</label></td>
									<td style="padding-left:5px;">
										<div class="control-group">	
									 		<div class="controls">
												<html:text styleId="nameId" property="name" styleClass="input-xlarge"  size="50" maxlength="30" value="${tireBrandForm.name}" disabled="${tireBrandForm.transactionStatus}"></html:text><br>
									 		</div>						
										</div>
									</td>
								</tr>
							</table>
											
							<br>
							 <div class="control-group">
							 	 <div class="controls">
									<c:choose>
										<c:when test="${tireBrandForm.transactionStatus == true}">
											<html:button property="btnClose" styleClass="btn btn-primary" onclick="goToTireBrand();" value="Close"></html:button>
										</c:when>
										<c:otherwise>
											<html:button property="btnUpdate" styleClass="btn btn-primary" onclick="updateTireBrand();" value="Update"></html:button>
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
	