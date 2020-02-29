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
	<h3 style="font-style: bold;">Equipment Request</h3>
	<div>
		<html:errors/>
	</div>
	<div>
		<h5 style="color: blue;"><c:out value="${monitorEquipmentForm.transactionMessage}"></c:out></h5>
	</div> 
	<html:form action="/saveMonitorEquipment.do" styleId="idFormChild">
		<table>
			<html:hidden property="patientCaseSystemId" value="${monitorEquipmentForm.patientCaseSystemId}"/>
			<html:hidden property="equipmentId" value="${monitorEquipmentForm.equipmentId}"/>
			<tr>
 				<td>Name</td>
        		<td class="padLeft5"><input type="text" name="itemName" value="${monitorEquipmentForm.itemName}" readonly="readonly"></td>
				<td class="padLeft5">Description</td>
        		<td class="padLeft5"><input type="text" name="itemDescription" value="${monitorEquipmentForm.itemDescription}" readonly="readonly"></td>
 				<td class="padLeft5">Fee</td>
        		<td class="padLeft5"><input style="text-align: right;" type="text" name="fee" value="${monitorEquipmentForm.fee}" readonly="readonly"></td>
			</tr>
			<tr class="hMargin5"></tr>
			<tr>
 				<td>Qty</td>
        		<td class="padLeft5"><input style="text-align: right;" type="text" id="qtyId" name="qty" value="${monitorEquipmentForm.qty}"></td>
				<td class="padLeft5">Date Taken</td>
				<td class="padLeft5"><input type="text"  name="dateTaken" id="dtDateTakenPicker"  value="${monitorEquipmentForm.dateTaken}" placeholder="mm/dd/yyyy"></td>
				<td class="padLeft5">Time Taken</td>
        		<td class="padLeft5"><input type="text" name="timeTaken" value="${monitorEquipmentForm.timeTaken}"></td>
			</tr>
			<tr class="hMargin10"></tr>
			<tr>
				<td colspan="2">
					<c:choose>
						<c:when test="${monitorEquipmentForm.transactionStatus == true}">
							<html:button property="btnClose" styleClass="btn btn-primary btnCancelClose" onclick="closeMonitorEquipment();" value="Close"></html:button>		
						</c:when>
						<c:otherwise>
							<html:button property="btnSave" styleClass="btn btn-primary btnSaveUpdate" onclick="saveMonitorEquipment();" value="Save"></html:button>
							<html:button property="btnCancel" styleClass="btn btn-primary btnCancelClose" onclick="cancelMonitorEquipment('${monitorEquipmentForm.patientCaseSystemId}');" value="Cancel"></html:button>	
						</c:otherwise>
					</c:choose>	
				</td>			
			</tr>
		</table>	
	</html:form>

</div>

