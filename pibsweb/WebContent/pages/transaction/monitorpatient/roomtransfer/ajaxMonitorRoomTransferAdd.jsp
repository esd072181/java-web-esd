<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
$(function() {
    
    $('#dtDateTransferredPicker').datepicker({}); 
    $('#dtDateTransferredPicker').focus();
    
  });
</script>

	<label style="font-weight: bold; font-size: 20px;">Room Transfer</label>
	
	<div>
		<html:errors/>
	</div>
	<div>
		<h5 style="color: blue;"><c:out value="${monitorRoomTransferForm.transactionMessage}"></c:out></h5>
	</div> 
	<html:form action="/saveMonitorRoomTransfer.do" styleId="idForm">
		<table>
			<html:hidden property="patientCaseSystemId" value="${monitorRoomTransferForm.patientCaseSystemId}"/>
			<html:hidden property="roomIdTransfer" value="${monitorRoomTransferForm.roomIdTransfer}"/>
			<tr>
 				<td valign="top">Room No</td>
        		<td><input type="text" name="name" value="${monitorRoomTransferForm.roomNoTransfer}" readonly="readonly"></td>
			</tr>
			<tr style="height: 10px;"></tr>
			<tr>
				<td valign="top">Date Transfer</td>
				<td><html:text  property="dateTransferred" styleId="dtDateTransferredPicker"></html:text><label style="padding: 0px 3px 0px 3px;">(mm/dd/yyyy)</label></td>
			</tr>
			<tr style="height: 20px;"></tr>
			<tr>
				<td colspan="2">
					<c:choose>
						<c:when test="${monitorRoomTransferForm.transactionStatus == true}">
							<html:button property="btnClose" styleClass="btn btn-primary btnCancelClose" onclick="closeMonitorRoomTransfer();" value="Close"></html:button>		
						</c:when>
						<c:otherwise>
							<html:button property="btnSave" styleClass="btn btn-primary btnSaveUpdate" onclick="saveMonitorRoomTransfer();" value="Save"></html:button>
							<html:button property="btnCancel" styleClass="btn btn-primary btnCancelClose" onclick="cancelMonitorRoomTransfer('${monitorRoomTransferForm.patientCaseSystemId}');" value="Cancel"></html:button>	
						</c:otherwise>
					</c:choose>	
				</td>			
			</tr>
		</table>	
	</html:form>


