<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
$(function() {
    
    $('#dtDateOfBirth').datepicker({}); 
    $('#lastNameId').focus();
    
  });
</script>

	<label style="font-weight: bold; font-size: 20px;">Nursery - Edit Record</label>
	
	<div>
		<html:errors/>
	</div>
	<div>
		<h5 style="color: blue;"><c:out value="${monitorNurseryForm.transactionMessage}"></c:out></h5>
	</div> 
	<html:form action="/updateMonitorNursery.do" styleId="idFormChild">
		<table>
			<html:hidden property="id" value="${monitorNurseryForm.id}"/>
			<html:hidden property="patientCaseSystemId" value="${monitorNurseryForm.patientCaseSystemId}"/>
			<tr>
 				<td>Last Name</td>
        		<td class="padLeft5"><input type="text"  id="lastNameId" name="lastName" value="${monitorNurseryForm.lastName}" ></td>
 				<td class="padLeft5">First Name</td>
        		<td class="padLeft5"><input type="text" name="firstName" value="${monitorNurseryForm.firstName}" ></td>
 				<td class="padLeft5">Gender</td>
        		<td class="padLeft5">
        			<html:select style="width: 175px;" styleClass="dropdownCol1" name="monitorNurseryForm" property="gender" disabled="${monitorNurseryForm.transactionStatus}" value="Male">
						<html:option value="0">--Select--</html:option>
						<html:optionsCollection name="monitorNurseryForm" property="genderLOV" label="listValue" value="listValue"/>				 		
					</html:select>	
				</td>
			</tr>
			<tr class="hMargin5"></tr>
			<tr>
				<td>Date Of Birth</td>
				<td class="padLeft5"><input type="text"  style="text-align: right;" name="dateOfBirth" id="dtDateOfBirth" value="${monitorNurseryForm.dateOfBirth}" placeholder="mm/dd/yyyy"/></td>
				<td class="padLeft5">Time Of Birth</td>
        		<td class="padLeft5"><input type="text" style="text-align: right;" name="timeOfBirth" value="${monitorNurseryForm.timeOfBirth}"></td>
 				<td class="padLeft5">Weight</td>
        		<td class="padLeft5"><input type="text" style="text-align: right;"  name="weight" value="${monitorNurseryForm.weight}" ></td>
			</tr>
        	<tr class="hMargin5"></tr>
        	<tr>
 				<td>Remarks</td>
        		<td colspan="6" class="padLeft5">
        			<input type="text" style="width: 671px;" name="remarks" value="${monitorNurseryForm.remarks}" >
        		</td>
        	</tr>
			<tr class="hMargin10"></tr>
			<tr>
				<td colspan="2">
					<c:choose>
						<c:when test="${monitorNurseryForm.transactionStatus == true}">
							<html:button property="btnClose" styleClass="btn btn-primary btnCancelClose" onclick="closeMonitorNursery();" value="Close"></html:button>		
						</c:when>
						<c:otherwise>
							<html:button property="btnUpdate" styleClass="btn btn-primary btnSaveUpdate" onclick="updateMonitorNursery();" value="Update"></html:button>
							<html:button property="btnCancel" styleClass="btn btn-primary btnCancelClose" onclick="cancelMonitorNursery('${monitorNurseryForm.patientCaseSystemId}');" value="Cancel"></html:button>	
						</c:otherwise>
					</c:choose>	
				</td>			
			</tr>
		</table>	
	</html:form>


