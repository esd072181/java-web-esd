<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
$(function() {
    
    $('#dtDateRecordedPicker').datepicker({}); 
    $('#bpId').focus();
    
  });
</script>

	<label style="font-weight: bold; font-size: 20px;">Physical Examination - Edit Record</label>
	
	<div>
		<html:errors/>
	</div>
	<div>
		<h5 style="color: blue;"><c:out value="${monitorPhysicalExaminationForm.transactionMessage}"></c:out></h5>
	</div> 
	<html:form action="/updateMonitorPhysicalExamination.do" styleId="idFormChild">
		<table>
		<html:hidden property="id" value="${monitorPhysicalExaminationForm.id}"/>
			<html:hidden property="patientCaseSystemId" value="${monitorPhysicalExaminationForm.patientCaseSystemId}"/>
			<tr>
 				<td>BP</td>
        		<td class="padLeft5"><input type="text" id="Idbp" name="bp" value="${monitorPhysicalExaminationForm.bp}"></td>
				<td class="padLeft5">Temp</td>
        		<td class="padLeft5"><input type="text" name="temp" value="${monitorPhysicalExaminationForm.temp}"></td>
        		<td class="padLeft5">Cardiac Rate</td>
        		<td class="padLeft5"><input type="text" name="cr" value="${monitorPhysicalExaminationForm.cr}"></td>
        		
			</tr>
			<tr class="hMargin5"></tr>
			<tr>
 				<td>Respiratory Rate</td>
        		<td class="padLeft5"><input style="text-align: right;" type="text" name="rr" value="${monitorPhysicalExaminationForm.rr}"></td>
 				<td class="padLeft5">Weight</td>
        		<td class="padLeft5"><input style="text-align: right;" type="text" name="weight" value="${monitorPhysicalExaminationForm.weight}"></td>
				<td class="padLeft5">HEENT</td>
        		<td class="padLeft5"><input style="text-align: right;" type="text" name="heent" value="${monitorPhysicalExaminationForm.heent}"></td>
			</tr>
			<tr class="hMargin5"></tr>
			<tr>
 				<td>Chest</td>
        		<td class="padLeft5"><input style="text-align: right;" type="text" name="chest" value="${monitorPhysicalExaminationForm.chest}"></td>
 				<td class="padLeft5">Heart</td>
        		<td class="padLeft5"><input style="text-align: right;" type="text" name="heart" value="${monitorPhysicalExaminationForm.heart}"></td>
				<td class="padLeft5">Abdomen</td>
        		<td class="padLeft5"><input style="text-align: right;" type="text" name="abdomen" value="${monitorPhysicalExaminationForm.abdomen}"></td>
			</tr>
			<tr class="hMargin5"></tr>
			<tr>
 				<td>Extremities</td>
        		<td class="padLeft5"><input style="text-align: right;" type="text" name="extrimities" value="${monitorPhysicalExaminationForm.extrimities}"></td>
 				<td class="padLeft5">Skin</td>
        		<td class="padLeft5"><input style="text-align: right;" type="text" name="skin" value="${monitorPhysicalExaminationForm.skin}"></td>
				<td class="padLeft5">Remarks</td>
        		<td class="padLeft5"><input style="text-align: right;" type="text" name="remarks" value="${monitorPhysicalExaminationForm.remarks}"></td>
			</tr>
			<tr class="hMargin5"></tr>
			<tr>
				<td>Date Recorded</td>
				<td class="padLeft5"><input type="text" style="text-align: right;" name="dateRecorded" id="dtDateRecordedPicker" value="${monitorPhysicalExaminationForm.dateRecorded}" placeholder="mm/dd/yyyy"></td>
				<td class="padLeft5">Time Taken</td>
        		<td class="padLeft5"><input type="text" style="text-align: right;" name="timeRecorded" value="${monitorPhysicalExaminationForm.timeRecorded}"></td>
			</tr>
			<tr class="hMargin10"></tr>
			<tr>
				<td colspan="2">
					<c:choose>
						<c:when test="${monitorPhysicalExaminationForm.transactionStatus == true}">
							<html:button property="btnClose" styleClass="btn btn-primary btnCancelClose" onclick="closeMonitorPhysicalExamination();" value="Close"></html:button>		
						</c:when>
						<c:otherwise>
							<html:button property="btnUpdate" styleClass="btn btn-primary btnSaveUpdate" onclick="updateMonitorPhysicalExamination();" value="Update"></html:button>
							<html:button property="btnCancel" styleClass="btn btn-primary btnCancelClose" onclick="cancelMonitorPhysicalExamination('${monitorPhysicalExaminationForm.patientCaseSystemId}');" value="Cancel"></html:button>	
						</c:otherwise>
					</c:choose>	
				</td>			
			</tr>
		</table>	
	</html:form>


