<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
$(function() {
    
    $('#dtDateOfDiagnosisPicker').datepicker({}); 
    $('#statementOfDiagnosisId').focus();
    
  });
</script>

<div>
	<h3 style="font-style: bold;">Diagnosis</h3>
	<div>
		<html:errors/>
	</div>
	<div>
		<h5 style="color: blue;"><c:out value="${diagnosisForm.transactionMessage}"></c:out></h5>
	</div> 
	<html:form action="/diagnosis.do" styleId="idFormChild">
		<table>
			<html:hidden property="diagnosisId" value="${diagnosisForm.diagnosisId}"/>
			<html:hidden property="patientCaseSystemId" value="${diagnosisForm.patientCaseSystemId}"/>
			<tr>
 				<td valign="top">Statement of Diagnosis</td>
        		<td class="padLeft5" colspan="5"><html:textarea rows="2" cols="100" styleId="statementOfDiagnosisId" property="statementOfDiagnosis" value="${diagnosisForm.statementOfDiagnosis}" ></html:textarea></td>
			</tr>
			<tr class="hMargin5"></tr>
			<tr>
 				<td valign="top">Remarks</td>
        		<td class="padLeft5" colspan="5"><html:textarea rows="2" cols="100" styleId="remarksId" property="remarks" value="${diagnosisForm.remarks}" ></html:textarea></td>
			</tr>
			<tr class="hMargin5"></tr>
			<tr>
				<td>Date of Diagnosis</td>
				<td class="padLeft5"><input type="text" style="text-align: right;" class="textboxCol1" name="dateOfDiagnosis" id="dtDateOfDiagnosisPicker" value="${diagnosisForm.dateOfDiagnosis}" placeholder="mm/dd/yyyy"></td>
			</tr>
			<tr class="hMargin10"></tr>
			<tr>
				<td><html:button property="btnSave" styleClass="btn btn-primary btnSaveAndUpdate" onclick="saveDiagnosis();" value="Save/Update"></html:button></td>
				<td><html:button property="btnClose" styleClass="btn btn-primary btnCancelClose" onclick="closeDiagnosis();" value="Close"></html:button></td>
			</tr>
		</table>	
	</html:form>

</div>

