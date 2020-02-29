<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
$(function() {
    
    $('#dtDateTakenPicker').datepicker({}); 
    $('#qtyId').val('');
    $('#qtyId').focus();
    
  });
</script>

<div>
	<h3 style="font-style: bold;">Laboratory Examination Request</h3>
	<div>
		<html:errors/>
	</div>
	<div>
		<h5 style="color: blue;"><c:out value="${monitorLaboratoryExaminationForm.transactionMessage}"></c:out></h5>
	</div> 
	<html:form action="/saveMonitorLaboratoryExamination.do" styleId="idFormChild">
		<table>
			<html:hidden property="patientCaseSystemId" value="${monitorLaboratoryExaminationForm.patientCaseSystemId}"/>
			<html:hidden property="laboratoryExaminationId" value="${monitorLaboratoryExaminationForm.laboratoryExaminationId}"/>
			<tr>
 				<td>Description</td>
        		<td class = "padLeft5" ><input type="text" name="itemDescription" value="${monitorLaboratoryExaminationForm.itemDescription}" readonly="readonly"></td>
				<td class = "padLeft5" >Remarks</td>
        		<td class = "padLeft5" ><input type="text" name="itemRemarks" value="${monitorLaboratoryExaminationForm.itemRemarks}" readonly="readonly"></td>
				<td class = "padLeft5" >Fee (Php)</td>
        		<td class = "padLeft5" ><input style="text-align: right;" type="text" name="fee" value="${monitorLaboratoryExaminationForm.fee}" readonly="readonly"></td>
			</tr>
			<tr class="hMargin5"></tr>
			<tr>
 				<td>Qty</td>
        		<td class = "padLeft5" ><input style="text-align: right;" type="text" id="qtyId" name="qty" value="${monitorLaboratoryExaminationForm.qty}"></td>
 				<td class = "padLeft5" >Date Taken</td>
				<td class = "padLeft5" ><input type="text"  style="text-align: right;" name="dateTaken" id="dtDateTakenPicker" value="${monitorLaboratoryExaminationForm.dateTaken}" placeholder="mm/dd/yyyy"></td>
				<td class = "padLeft5" >Time Taken</td>
        		<td class = "padLeft5" ><input type="text" style="text-align: right;" name="timeTaken" value="${monitorLaboratoryExaminationForm.timeTaken}"></td>
 			</tr>
			<tr class="hMargin10"></tr>
			<tr>
				<td colspan="2">
					<c:choose>
						<c:when test="${monitorLaboratoryExaminationForm.transactionStatus == true}">
							<html:button property="btnClose" styleClass="btn btn-primary btnCancelClose" onclick="closeMonitorLaboratoryExamination();" value="Close"></html:button>		
						</c:when>
						<c:otherwise>
							<html:button property="btnSave" styleClass="btn btn-primary btnSaveUpdate" onclick="saveMonitorLaboratoryExamination();" value="Save"></html:button>
							<html:button property="btnCancel" styleClass="btn btn-primary btnCancelClose" onclick="cancelMonitorLaboratoryExamination('${monitorLaboratoryExaminationForm.patientCaseSystemId}');" value="Cancel"></html:button>	
						</c:otherwise>
					</c:choose>	
				</td>			
			</tr>
		</table>	
	</html:form>

</div>

