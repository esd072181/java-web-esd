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
		<br>
	</div> 
	<html:form action="/diagnosis.do" styleId="idForm">
		<table>
			<html:hidden property="diagnosisId" value="${diagnosisForm.diagnosisId}"/>
			<html:hidden property="patientCaseSystemId" value="${diagnosisForm.patientCaseSystemId}"/>
			<tr>
 				<td valign="top">Statement of Diagnosis</td>
        		<td colspan="5"><html:textarea rows="3" cols="59" styleId="statementOfDiagnosisId" property="statementOfDiagnosis" value="${diagnosisForm.statementOfDiagnosis}" ></html:textarea></td>
			</tr>
			<tr style="height: 10px;"></tr>
			<tr>
 				<td valign="top">Remarks</td>
        		<td colspan="5"><html:textarea rows="3" cols="59" styleId="remarksId" property="remarks" value="${diagnosisForm.remarks}" ></html:textarea></td>
			</tr>
			<tr style="height: 10px;"></tr>
			<tr>
				<td valign="top">Date of Diagnosis:</td>
				<td><html:text styleClass="textboxCol1" property="dateOfDiagnosis" styleId="dtDateOfDiagnosisPicker"></html:text><label style="padding-left: 5px;">(mm/dd/yyyy)</label></td>
			</tr>
			<tr style="height: 20px;"></tr>
			<tr>
				<td><html:button property="btnSave" styleClass="btn btn-primary btnSaveAndUpdate" onclick="saveDiagnosis();" value="Save/Update"></html:button></td>
				<td><html:button property="btnClose" styleClass="btn btn-primary btnCancelClose" onclick="closeDiagnosis();" value="Close"></html:button></td>
			</tr>
		</table>	
	</html:form>

</div>

