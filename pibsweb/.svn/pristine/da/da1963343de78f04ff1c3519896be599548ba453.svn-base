<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
$(function() {
    
    $('#dtDateOfStatementPicker').datepicker({}); 
    $('#medicationStatementId').focus();
    
  });
</script>

<div>
	<h3 style="font-style: bold;">Medication Statement</h3>
	<div>
		<html:errors/>
	</div>
	<div>
		<h5 style="color: blue;"><c:out value="${medicationStatementForm.transactionMessage}"></c:out></h5>
	</div> 
	<html:form action="/medicationStatement.do" styleId="idFormChild">
		<table>
			<html:hidden property="medicationStatementId" value="${medicationStatementForm.medicationStatementId}"/>
			<html:hidden property="patientCaseSystemId" value="${medicationStatementForm.patientCaseSystemId}"/>
			<tr>
 				<td valign="top">Medication Statement</td>
        		<td class="padLeft5" colspan="5"><html:textarea rows="2" cols="100" styleId="medicationStatementId" property="medicationStatement" value="${medicationStatementForm.medicationStatement}" ></html:textarea></td>
			</tr>
			<tr class="hMargin5"></tr>
			<tr>
 				<td valign="top">Remarks</td>
        		<td class="padLeft5" colspan="5"><html:textarea rows="2" cols="100" styleId="remarksId" property="remarks" value="${medicationStatementForm.remarks}" ></html:textarea></td>
			</tr>
			<tr class="hMargin5"></tr>
			<tr>
				<td valign="top">Date of Statement</td>
				<td class="padLeft5"><input type="text" style="text-align: right;" class="textboxCol1" name="dateOfStatement" id="dtDateOfStatementPicker"  value="${medicationStatementForm.dateOfStatement}" placeholder="mm/dd/yyyy"></td>
			</tr>
			<tr class="hMargin10"></tr>
			<tr>
				<td><html:button property="btnSave" styleClass="btn btn-primary btnSaveAndUpdate" onclick="saveMedicationStatement();" value="Save/Update"></html:button></td>
				<td><html:button property="btnClose" styleClass="btn btn-primary btnCancelClose" onclick="closeMedicationStatement();" value="Close"></html:button></td>
			</tr>
		</table>	
	</html:form>

</div>

