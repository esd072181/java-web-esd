<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
$(function() {
    
    $('#dtDateTakenPicker').datepicker({}); 
    $('#qtyId').val('1');
    $('#qtyId').focus();
    
  });
</script>

	
	<label style="font-weight: bold; font-size: 20px;">Radiology Request</label>
	
	<div>
		<html:errors/>
	</div>
	<div>
		<h5 style="color: blue;"><c:out value="${monitorRadiologyForm.transactionMessage}"></c:out></h5>
	</div> 
	<html:form action="/saveMonitorRadiology.do" styleId="idFormChild">
		<table>
			<html:hidden property="patientCaseSystemId" value="${monitorRadiologyForm.patientCaseSystemId}"/>
			<html:hidden property="radiologyId" value="${monitorRadiologyForm.radiologyId}"/>
			<tr>
			 	<td>Description</td>
        		<td class="padLeft5"><input type="text" name="itemDescription" value="${monitorRadiologyForm.itemDescription}" readonly="readonly"></td>
 				<td class="padLeft5">Type</td>
        		<td class="padLeft5"><input type="text" name="itemType" value="${monitorRadiologyForm.itemType}" readonly="readonly"></td>
				<td class="padLeft5" >Fee</td>
        		<td class="padLeft5"><input style="text-align: right;" type="text" name="fee" value="${monitorRadiologyForm.fee}" readonly="readonly"></td>
			</tr>
			<tr class="hMargin5"></tr>
			<tr>
				<td>Qty</td>
        		<td class="padLeft5"><input style="text-align: right;" type="text" id="qtyId" name="qty" value="${monitorRadiologyForm.qty}"></td>
 				<td class="padLeft5">Date Taken</td>
				<td class="padLeft5"><input type="text" style="text-align: right;" name="dateTaken" id="dtDateTakenPicker" value="${monitorRadiologyForm.dateTaken}" placeholder="mm/dd/yyyy"></td>
				<td class="padLeft5">Time Taken</td>
        		<td class="padLeft5"><input type="text" style="text-align: right;" name="timeTaken" value="${monitorRadiologyForm.timeTaken}"></td>
			</tr>
			<tr class="hMargin10"></tr>
			<tr>
				<td colspan="2">
					<c:choose>
						<c:when test="${monitorRadiologyForm.transactionStatus == true}">
							<html:button property="btnClose" styleClass="btn btn-primary btnCancelClose" onclick="closeMonitorRadiology();" value="Close"></html:button>		
						</c:when>
						<c:otherwise>
							<html:button property="btnSave" styleClass="btn btn-primary btnSaveUpdate" onclick="saveMonitorRadiology();" value="Save"></html:button>
							<html:button property="btnCancel" styleClass="btn btn-primary btnCancelClose" onclick="cancelMonitorRadiology('${monitorRadiologyForm.patientCaseSystemId}');" value="Cancel"></html:button>	
						</c:otherwise>
					</c:choose>	
				</td>			
			</tr>
		</table>	
	</html:form>


