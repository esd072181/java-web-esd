<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
$(function() {
    
    $('#dtDateTakenPicker').datepicker({}); 
    $('#qtyId').focus();
    
  });
</script>

<div>
	<h3 style="font-style: bold;">Additional Services Request - Edit Record</h3>
	<div>
		<html:errors/>
	</div>
	<div>
		<h5 style="color: blue;"><c:out value="${monitorAdditionalServicesForm.transactionMessage}"></c:out></h5>
	</div> 
	<html:form action="/saveMonitorAdditionalServices.do" styleId="idFormChild">
		<table>
		<html:hidden property="id" value="${monitorAdditionalServicesForm.id}"/>
			<html:hidden property="patientCaseSystemId" value="${monitorAdditionalServicesForm.patientCaseSystemId}"/>
			<html:hidden property="additionalServicesId" value="${monitorAdditionalServicesForm.additionalServicesId}"/>
			<tr>
				<td >Description</td>
        		<td class="padLeft5"><input type="text" name="itemDescription" value="${monitorAdditionalServicesForm.itemDescription}" readonly="readonly"></td>
 				<td class="padLeft5">Category</td>
        		<td class="padLeft5"><input type="text" name="itemType" value="${monitorAdditionalServicesForm.itemType}" readonly="readonly"></td>
				<td class="padLeft5">Fee</td>
        		<td class="padLeft5"><input style="text-align: right;" type="text" name="fee" value="${monitorAdditionalServicesForm.fee}" ></td><!-- Fee not readonly on this module -->
			</tr>
			<tr class="hMargin5"></tr>
			<tr>
 				<td >Qty</td>
        		<td class="padLeft5"><input style="text-align: right;" type="text" id="qtyId" name="qty" value="${monitorAdditionalServicesForm.qty}"></td>
 				<td class="padLeft5">Date Taken</td>
				<td class="padLeft5"><input type="text"  style="text-align: right;" name="dateTaken" id="dtDateTakenPicker" value="${monitorAdditionalServicesForm.dateTaken}" placeholder="mm/dd/yyyy"></td>
				<td class="padLeft5">Time Taken</td>
        		<td class="padLeft5"><input type="text" style="text-align: right;" name="timeTaken" value="${monitorAdditionalServicesForm.timeTaken}"></td>
 			</tr>
			<tr class="hMargin10"></tr>
			<tr>
			</tr>
			<tr style="height: 20px;"></tr>
			<tr>
				<td colspan="2">
					<c:choose>
						<c:when test="${monitorAdditionalServicesForm.transactionStatus == true}">
							<html:button property="btnClose" styleClass="btn btn-primary btnCancelClose" onclick="closeMonitorAdditionalServices();" value="Close"></html:button>		
						</c:when>
						<c:otherwise>
							<html:button property="btnUpdate" styleClass="btn btn-primary btnSaveUpdate" onclick="updateMonitorAdditionalServices();" value="Update"></html:button>
							<html:button property="btnCancel" styleClass="btn btn-primary btnCancelClose" onclick="cancelMonitorAdditionalServices('${monitorAdditionalServicesForm.patientCaseSystemId}');" value="Cancel"></html:button>	
						</c:otherwise>
					</c:choose>	
				</td>			
			</tr>
		</table>	
	</html:form>

</div>

