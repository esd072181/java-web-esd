<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
$(function() {
    
    $('#dtDateUsedPicker').datepicker({}); 
    $('#daysId').val('');
    $('#daysId').focus();
    
  });
</script>

<div>
	<h3 style="font-style: bold;">Room</h3>
	<div>
		<html:errors/>
	</div>
	<div>
		<h5 style="color: blue;"><c:out value="${monitorRoomForm.transactionMessage}"></c:out></h5>
	</div> 
	<html:form action="/saveMonitorRoom.do" styleId="idFormChild">
		<table>
			<html:hidden property="patientCaseSystemId" value="${monitorRoomForm.patientCaseSystemId}"/>
			<html:hidden property="roomId" value="${monitorRoomForm.roomId}"/>
			<tr>
 				<td>Room No</td>
        		<td class="padLeft5"><input type="text" name="roomNo" value="${monitorRoomForm.roomNo}" readonly="readonly"></td>
 				<td class="padLeft5">Category</td>
        		<td class="padLeft5"><input type="text" name="roomCategory" value="${monitorRoomForm.roomCategory}" readonly="readonly"></td>
 				<td class="padLeft5">Fee</td>
        		<td class="padLeft5"><input style="text-align: right;" type="text" name="fee" value="${monitorRoomForm.fee}" readonly="readonly"></td>
			</tr>
			<tr class="hMargin5"></tr>
			<tr>
 				<td>Days</td>
        		<td class="padLeft5"><input style="text-align: right;" type="text" id="daysId" name="days" value="${monitorRoomForm.days}"></td>
				<td class="padLeft5">Date Used</td>
				<td class="padLeft5"><input type="text"  style="text-align: right;" name="dateUsed" id="dtDateUsedPicker" value="${monitorRoomForm.dateUsed}" placeholder="mm/dd/yyyy"></td>
				<td class="padLeft5">Time Used</td>
        		<td class="padLeft5"><input type="text" style="text-align: right;" name="timeUsed" value="${monitorRoomForm.timeUsed}"></td>
			</tr>
			<tr class="hMargin10"></tr>
			<tr>
				<td colspan="2">
					<c:choose>
						<c:when test="${monitorRoomForm.transactionStatus == true}">
							<html:button property="btnClose" styleClass="btn btn-primary btnCancelClose" onclick="closeMonitorRoom();" value="Close"></html:button>		
						</c:when>
						<c:otherwise>
							<html:button property="btnSave" styleClass="btn btn-primary btnSaveUpdate" onclick="saveMonitorRoom();" value="Save"></html:button>
							<html:button property="btnCancel" styleClass="btn btn-primary btnCancelClose" onclick="cancelMonitorRoom('${monitorRoomForm.patientCaseSystemId}');" value="Cancel"></html:button>	
						</c:otherwise>
					</c:choose>	
				</td>			
			</tr>
		</table>	
	</html:form>

</div>

