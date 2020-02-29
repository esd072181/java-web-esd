<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
$(function() {
    
    $('#dtDateOfPrognosisPicker').datepicker({}); 
    $('#statementOfPrognosisId').focus();
    
  });
</script>

<div>
	<h3 style="font-style: bold;">Prognosis</h3>
	<div>
		<html:errors/>
	</div>
	<div>
		<h5 style="color: blue;"><c:out value="${prognosisForm.transactionMessage}"></c:out></h5>
	</div> 
	<html:form action="/prognosis.do" styleId="idFormChild">
		<table>
			<html:hidden property="prognosisId" value="${prognosisForm.prognosisId}"/>
			<html:hidden property="patientCaseSystemId" value="${prognosisForm.patientCaseSystemId}"/>
			<tr>
 				<td valign="top">Statement of Prognosis</td>
        		<td class="padLeft5" colspan="5"><html:textarea rows="2" cols="100" styleId="statementOfPrognosisId" property="statementOfPrognosis" value="${prognosisForm.statementOfPrognosis}" ></html:textarea></td>
			</tr>
			<tr class="hMargin5"></tr>
			<tr>
 				<td valign="top">Remarks</td>
        		<td class="padLeft5" colspan="5"><html:textarea rows="2" cols="100" styleId="remarksId" property="remarks" value="${prognosisForm.remarks}" ></html:textarea></td>
			</tr>
			<tr class="hMargin5"></tr>
			<tr>
				<td valign="top">Date of Prognosis</td>
				<td class="padLeft5" class="padLeft5"><input type="text" style="text-align: right;" class="textboxCol1" name="dateOfPrognosis" id="dtDateOfPrognosisPicker" value="${prognosisForm.dateOfPrognosis}" placeholder="mm/dd/yyyy"></td>
			</tr>
			<tr class="hMargin10"></tr>
			<tr>
				<td><html:button property="btnSave" styleClass="btn btn-primary btnSaveAndUpdate" onclick="savePrognosis();" value="Save/Update"></html:button></td>
				<td><html:button property="btnClose" styleClass="btn btn-primary btnCancelClose" onclick="closePrognosis();" value="Close"></html:button></td>
			</tr>
		</table>	
	</html:form>

</div>

