<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
$(function() {
    $( "#menu" ).menu({
      items: "> :not(.ui-widget-header)"
    });
    
    $('#idCorrections').focus();
  });
  
</script>

 	<div style="padding-left: 10px;">

		<div style="height: 30%; padding-top: 0px;" align="left" >
			<h3 style="font-weight: bolder;">Closure on Corrective Actions  - Add New Record</h3>
			<html:form action="/closure.do" styleId="idForm">
			
				<table>
					<tr>
						<td colspan="2"><html:errors/></td>
					</tr>
					<tr>
						<td colspan="2"><h4 style="color: blue;"><c:out value="${closureForm.transactionMessage}"></c:out></h4></td>
					</tr>
					<tr>
						<td><label>Corrective Actions:</label></td>
						<td style="padding-left: 5px;">
							<html:select  styleId="idCorrections" name="closureForm" property="correctionsId" disabled="${closureForm.transactionStatus}">
								<html:option value="0">--Select--</html:option>
								 <html:optionsCollection name="closureForm" property="correctionsList" label="description" value="id"/>				 		
							</html:select>	
						</td>
					</tr>
					<tr height="5px;"></tr>
					<tr>
						<td><label>Closure Description:</label></td>
						<td style="padding-left: 5px;">
							<html:text styleId="descriptionId" property="description" styleClass="input-xlarge"  size="100" maxlength="500" value="${closureForm.description}" disabled="${closureForm.transactionStatus}"></html:text><br>
						</td>
					</tr>
				</table>
			
				<br>
				
				<fieldset>
					<div class="control-group">
						<div class="controls">
							<c:choose>
								<c:when test="${closureForm.transactionStatus == true}">
									<html:button property="btnAddNew" styleClass="btn btn-primary" onclick="goToAddClosure();" value="Add New Record"></html:button>
									<html:button property="btnClose" styleClass="btn btn-primary" onclick="goToClosure();" value="Close"></html:button>
								</c:when>
								<c:otherwise>
									<html:button property="btnSave" styleClass="btn btn-primary" onclick="saveClosure();" value="Save"></html:button>
									<html:button property="btnCancel" styleClass="btn btn-primary" onclick="goToClosure();" value="Cancel"></html:button>
								</c:otherwise>
							</c:choose>								 	 
						</div>
					</div>
				</fieldset>	
				
			</html:form>
		</div>
	
	</div>

	