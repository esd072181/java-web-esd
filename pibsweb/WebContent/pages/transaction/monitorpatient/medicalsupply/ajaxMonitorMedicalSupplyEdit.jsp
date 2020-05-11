<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
$(function() {
    
    $('#dtDateTakenPicker').datepicker({}); 
    $('#qtyId').focus();
    
  });
</script>


	<label style="font-weight: bold; font-size: 20px;">Medical Supply Request - Edit Record</label>
	
	<div>
		<html:errors/>
	</div>
	<div>
		<h5 style="color: blue;"><c:out value="${monitorMedicalSupplyForm.transactionMessage}"></c:out></h5>
	</div> 
	<html:form action="/updateMonitorMedicalSupply.do" styleId="idFormChild">
		<table>
		<html:hidden property="id" value="${monitorMedicalSupplyForm.id}"/>
			<html:hidden property="patientCaseSystemId" value="${monitorMedicalSupplyForm.patientCaseSystemId}"/>
			<html:hidden property="medicalSupplyId" value="${monitorMedicalSupplyForm.medicalSupplyId}"/>
			<tr>
				<td >Description</td>
        		<td class="padLeft5"><input type="text" name="itemDescription" value="${monitorMedicalSupplyForm.itemDescription}" readonly="readonly"></td>
 				<td class="padLeft5">Type</td>
        		<td class="padLeft5"><input type="text" name="itemType" value="${monitorMedicalSupplyForm.itemType}" readonly="readonly"></td>
				<td class="padLeft5">Price</td>
        		<td class="padLeft5"><input style="text-align: right;" type="text" name="price" value="${monitorMedicalSupplyForm.price}" readonly="readonly"></td>
			</tr>
			<tr class="hMargin5"></tr>
			<tr>
 				<td >Qty</td>
        		<td class="padLeft5"><input style="text-align: right;" type="text" id="qtyId" name="qty" value="${monitorMedicalSupplyForm.qty}"></td>
 				<td class="padLeft5" >Date Taken</td>
				<td class="padLeft5"><input type="text" style="text-align: right;" name="dateTaken" id="dtDateTakenPicker" value="${monitorMedicalSupplyForm.dateTaken}" placeholder="mm/dd/yyyy"></td>
				<td class="padLeft5" >Time Taken</td>
        		<td class="padLeft5"><input type="text"  style="text-align: right;"name="timeTaken" value="${monitorMedicalSupplyForm.timeTaken}"></td>
			</tr>
			<tr class="hMargin10"></tr>
			<tr>
				<td colspan="2">
					<c:choose>
						<c:when test="${monitorMedicalSupplyForm.transactionStatus == true}">
							<html:button property="btnClose" styleClass="btn btn-primary btnCancelClose" onclick="closeMonitorMedicalSupply();" value="Close"></html:button>		
						</c:when>
						<c:otherwise>
							<html:button property="btnUpdate" styleClass="btn btn-primary btnSaveUpdate" onclick="updateMonitorMedicalSupply();" value="Update"></html:button>
							<html:button property="btnCancel" styleClass="btn btn-primary btnCancelClose" onclick="cancelMonitorMedicalSupply('${monitorMedicalSupplyForm.patientCaseSystemId}');" value="Cancel"></html:button>	
						</c:otherwise>
					</c:choose>	
				</td>			
			</tr>
		</table>	
	</html:form>


