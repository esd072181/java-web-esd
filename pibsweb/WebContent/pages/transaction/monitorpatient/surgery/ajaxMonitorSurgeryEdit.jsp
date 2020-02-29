<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
$(function() {
    
    $('#dtDateTakenPicker').datepicker({}); 
    $('#qtyId').focus();
    
  });
</script>

<div>
	<h3 style="font-style: bold;">Surgery Request - Edit Record</h3>
	<div>
		<html:errors/>
	</div>
	<div>
		<h5 style="color: blue;"><c:out value="${monitorSurgeryForm.transactionMessage}"></c:out></h5>
	</div> 
	<html:form action="/updateMonitorSurgery.do" styleId="idFormChild">
		<table>
			<html:hidden property="id" value="${monitorSurgeryForm.id}"/>
			<html:hidden property="patientCaseSystemId" value="${monitorSurgeryForm.patientCaseSystemId}"/>
			<html:hidden property="surgeryId" value="${monitorSurgeryForm.surgeryId}"/>
				<tr>
 				<td>Type</td>
        		<td class="padLeft5"><input type="text" name="itemType" value="${monitorSurgeryForm.itemType}" readonly="readonly"></td>
				<td class="padLeft5">Description</td>
        		<td class="padLeft5"><input type="text" name="itemDescription" value="${monitorSurgeryForm.itemDescription}" readonly="readonly"></td>
  				<td class="padLeft5">Fee</td>
        		<td class="padLeft5"><input style="text-align: right;" type="text" name="fee" value="${monitorSurgeryForm.fee}" readonly="readonly"></td>
			</tr>
			<tr class="hMargin5"></tr>
			<tr>
 				<td>Qty</td>
        		<td class="padLeft5"><input type="text" style="text-align: right;" id="qtyId" name="qty" value="${monitorSurgeryForm.qty}"></td>
 				<td class="padLeft5">Date Taken</td>
				<td class="padLeft5"><input type="text" style="text-align: right;" name="dateTaken" id="dtDateTakenPicker" value="${monitorSurgeryForm.dateTaken}" placeholder="mm/dd/yyyy"></td>
				<td class="padLeft5">Time Taken</td>
        		<td class="padLeft5"><input type="text" style="text-align: right;" name="timeTaken" value="${monitorSurgeryForm.timeTaken}"></td>
 			</tr>
			<tr class="hMargin10"></tr>
			<tr>
				<td colspan="2">
					<c:choose>
						<c:when test="${monitorSurgeryForm.transactionStatus == true}">
							<html:button property="btnClose" styleClass="btn btn-primary btnCancelClose" onclick="closeMonitorSurgery();" value="Close"></html:button>		
						</c:when>
						<c:otherwise>
							<html:button property="btnUpdate" styleClass="btn btn-primary btnSaveUpdate" onclick="updateMonitorSurgery();" value="Update"></html:button>
							<html:button property="btnCancel" styleClass="btn btn-primary btnCancelClose" onclick="cancelMonitorSurgery('${monitorSurgeryForm.patientCaseSystemId}');" value="Cancel"></html:button>	
						</c:otherwise>
					</c:choose>	
				</td>			
			</tr>
		</table>	
	</html:form>

</div>

