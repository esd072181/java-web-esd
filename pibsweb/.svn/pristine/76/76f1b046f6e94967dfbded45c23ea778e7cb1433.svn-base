<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
$(function() {
    
    $('#dtDateAttendedPicker').datepicker({}); 
    $('#daysId').focus();
    
  });
</script>

<div>
	<h3 style="font-style: bold;">Doctor</h3>
	<div>
		<html:errors/>
	</div>
	<div>
		<h5 style="color: blue;"><c:out value="${monitorDoctorForm.transactionMessage}"></c:out></h5>
	</div> 
	<html:form action="/saveMonitorDoctor.do" styleId="idFormChild">
		<table>
			<html:hidden property="id" value="${monitorDoctorForm.id}"/>
			<html:hidden property="patientCaseSystemId" value="${monitorDoctorForm.patientCaseSystemId}"/>
			<html:hidden property="professionalId" value="${monitorDoctorForm.professionalId}"/>
			<tr>
 				<td >Name</td>
        		<td class="padLeft5"><input type="text" name="name" value="${monitorDoctorForm.name}" readonly="readonly"></td>
				<td class="padLeft5">Specialization</td>
        		<td class="padLeft5"><input type="text" name="specialization" value="${monitorDoctorForm.specialization}" readonly="readonly"></td>
 				<td class="padLeft5">Fee</td>
        		<td class="padLeft5"><input style="text-align: right;" type="text" name="fee" value="${monitorDoctorForm.fee}" readonly="readonly"></td>			
			</tr>
			<tr class="hMargin5"></tr>
			<tr>
 				<td >Days</td>
        		<td class="padLeft5"><input style="text-align: right;" type="text" id="daysId" name="days" value="${monitorDoctorForm.days}"></td>
				<td class="padLeft5">Date Attended</td>
				<td class="padLeft5"><input type="text"  style="text-align: right;" name="dateAttended" id="dtDateAttendedPicker" value="${monitorDoctorForm.dateAttended}" placeholder="mm/dd/yyyy"></td>
				<td class="padLeft5">Time Taken</td>
        		<td class="padLeft5"><input type="text" style="text-align: right;" name="timeAttended" value="${monitorDoctorForm.timeAttended}"></td>
			</tr>
			<tr class="hMargin10"></tr>
			<tr>
				<td colspan="2">
					<c:choose>
						<c:when test="${monitorDoctorForm.transactionStatus == true}">
							<html:button property="btnClose" styleClass="btn btn-primary btnCancelClose" onclick="closeMonitorDoctor();" value="Close"></html:button>		
						</c:when>
						<c:otherwise>
							<html:button property="btnUpdate" styleClass="btn btn-primary btnSaveUpdate" onclick="updateMonitorDoctor();" value="Save"></html:button>
							<html:button property="btnCancel" styleClass="btn btn-primary btnCancelClose" onclick="cancelMonitorDoctor('${monitorDoctorForm.patientCaseSystemId}');" value="Cancel"></html:button>	
						</c:otherwise>
					</c:choose>	
				</td>			
			</tr>
		</table>	
	</html:form>

</div>

