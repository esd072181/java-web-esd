<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
$(function() {
     

  });
</script>

<div class="row">
	   
 	<div class="col-sm-10" style="padding-left: 40px;">

		<div style="height: 30%; padding-top: 0px;" align="left">
			<h3 style="font-style: bold;">Monitor Patient</h3>
			<html:form action="/monitorPatient.do" styleId="idForm">
			
				<fieldset>
					<!--<legend></legend>--><!-- leave this as blank to show the line separator -->
				
						<div>
								<html:hidden property="id" value="${monitorPatientForm.id}"/>
                            	<table>
                            		<tr>
                            		    <td><label style="width: 75px; font-weight: normal;">Patient:</label></td>
                                    	<td><label style="width: 150px; color: blue;">${monitorPatientForm.admission.patientFullName}</label></td>
                                    	<td><label style="width: 75px; font-weight: normal;">Age:</label></td>
                                    	<td><label style="width: 75px; color: blue;">${monitorPatientForm.admission.ageAdmitted}</label></td>
                            		</tr>
                                	<tr>
                                        <td><label style="width: 75px; font-weight: normal;">Case No:</label></td> 
                                        <td><label style="width: 200px; color: blue;">${monitorPatientForm.admission.caseNo}</label></td>
                                        <td><label style="width: 100px; font-weight: normal;">Date Admitted:</label></td>
                                        <td><label style="width: 120px; color: blue;">${monitorPatientForm.dateAdmitted}</label></td>
                                        <td><label style="width: 100px; font-weight: normal;">Time Admitted:</label></td>
                                        <td><label style="width: 95px; color: blue;">${monitorPatientForm.timeAdmitted}</label></td>                                           <td><html:button property="btnBack" styleClass="btn btn-primary btnBackToSearch" onclick="backToMonitorPatientSearch();" value="Back to Search"></html:button>	</td>
                                    	<td><html:button property="btnGoTo" styleClass="btn btn-primary btnBackToSearch" onclick="goToBilling('${monitorPatientForm.id}');" value="Go To Billing"></html:button>	</td>
                                    </tr>
                                    <tr style="height: 5px;" ></tr>
                                    <tr>
                                    	<td>Room No:</td>
                                    	<c:choose>
  	                                  		<c:when test="${monitorPatientForm.admission.roomNoTransfer != null}">
  	                                  			<td><label style="width: 200px; color: blue;">${monitorPatientForm.admission.roomNoTransfer}</label></td>
                                    		</c:when>
                                    		<c:otherwise>
                                    			<td><label style="width: 200px; color: blue;">${monitorPatientForm.admission.roomNo}</label></td>	
                                    		</c:otherwise>
                                    	</c:choose>
                                    	<td>Doctor:</td>
                                    	<td colspan="3"><label style="width: 250px; color: blue;">${monitorPatientForm.admission.doctor}</label></td>	                 

                                    </tr>
                                    <tr style="height: 5px;" ></tr>
                                    <tr>
                                    	<td colspan="5">
                                     	    <html:button property="btnRoomTransfer" styleClass="btn btn-primary btnMonitoringSmall" onclick="goToMonitorRoomTransfer('${monitorPatientForm.id}');" value="Room Transfer"></html:button>                  
                                    		<html:button property="btnRoom" styleClass="btn btn-primary btnMonitoringSmall" onclick="goToMonitorRoom('${monitorPatientForm.id}');" value="Other Room"></html:button>
                                    		<html:button property="btnDoctor" styleClass="btn btn-primary btnMonitoringSmall" onclick="goToMonitorDoctor('${monitorPatientForm.id}');" value="Other Doctor/Professional"></html:button>
                                    		<html:button property="btnNursery" styleClass="btn btn-primary btnMonitoringSmall" onclick="goToMonitorNursery('${monitorPatientForm.id}');" value="Nursery"></html:button>
                                    	</td>
                                    </tr>
                                    <tr style="height: 5px;" ></tr>
                                </table>
						</div>
						<div>
							<table>
								<tr>
									<td><html:button property="btnDiagnosis" styleClass="btn btn-primary btnMonitoringSmall" onclick="goToDiagnosis('${monitorPatientForm.id}');" value="Diagnosis"></html:button></td>
									<td><html:button property="btnMedicationStatement" styleClass="btn btn-primary btnMonitoringLong" onclick="goToMedicationStatement('${monitorPatientForm.id}');" value="Medication Statement"></html:button></td>
									<td><html:button property="btnPrognosis" styleClass="btn btn-primary btnMonitoringSmall" onclick="goToPrognosis('${monitorPatientForm.id}');" value="Prognosis"></html:button></td>
									<td><html:button property="btnLaboratoryExamination" styleClass="btn btn-primary btnMonitoringLong" onclick="goToMonitorLaboratoryExamination('${monitorPatientForm.id}');" value="Laboratory Examination"></html:button></td>
									<td><html:button property="btnMedicalSupply" styleClass="btn btn-primary btnMonitoringSmall" onclick="goToMonitorMedicalSupply('${monitorPatientForm.id}');" value="Medical Supply"></html:button></td>
									<td><html:button property="btnRadiology" styleClass="btn btn-primary btnMonitoringSmall" onclick="goToMonitorRadiology('${monitorPatientForm.id}');" value="Radiology"></html:button></td>
									<td><html:button property="btnSurgery" styleClass="btn btn-primary btnMonitoringSmall" onclick="goToMonitorSurgery('${monitorPatientForm.id}');" value="Surgery"></html:button></td>
									<td><html:button property="btnAdditional Services" styleClass="btn btn-primary btnMonitoringMed" onclick="goToMonitorAdditionalServices('${monitorPatientForm.id}');" value="Additional Services"></html:button></td>
									<td><html:button property="btnEquipment" styleClass="btn btn-primary btnMonitoringSmall" onclick="goToMonitorEquipment('${monitorPatientForm.id}');" value="Equipment"></html:button></td>
									<td><html:button property="btnPhysicalExamination" styleClass="btn btn-primary btnMonitoringMed" onclick="goToMonitorPhysicalExamination('${monitorPatientForm.id}');" value="Physical Examination"></html:button></td>
								</tr>
							</table>
						</div>
				</fieldset>	
			</html:form>
		</div>
	
		<!-- ajax part of child module data of monitor patient -->
		<div id="childDIV">
			<br>
			<fieldset>
				<legend>Summary</legend>
				<div>
					<!-- Chief Complaint -->
					<table>
						<tr>
							<td>Chief Complaint: <span style="padding-left:5px; color: blue; text-decoration: underline;">${monitorPatientForm.admission.chiefComplaint}</span></td>
						</tr>
					</table>
					<!-- Diagnosis -->
					<c:if test="${monitorPatientForm.diagnosis != null}">
						<table>
							<tr>
								<td>Diagnosis: <span style="padding-left:5px; color: blue; text-decoration: underline;">${monitorPatientForm.diagnosis.statementOfDiagnosis}</span></td>
							</tr>
							<tr>
								<td>Remarks: <span style="padding-left:5px;">${monitorPatientForm.diagnosis.remarks}</span></td>
							</tr>
						</table>
						<table><tr height="5px"></tr></table>
					</c:if>
					
					<!-- Medication Statement -->
					<c:if test="${monitorPatientForm.statement != null}">
						<table>
							<tr>
								<td>Medication Statement: <span style="padding-left:5px; color: blue; text-decoration: underline;">${monitorPatientForm.statement.medicationStatement}</span></td>
							</tr>
							<tr>
								<td>Remarks:<span style="padding-left:5px;">${monitorPatientForm.statement.remarks}</span></td>
							</tr>
						</table>
						<table><tr height="5px"></tr></table>
					</c:if>
					<!-- Prognosis -->
					<c:if test="${monitorPatientForm.prognosis != null}">
						<table>
							<tr>
								<td>Prognosis: <span style="padding-left:5px; color: blue; text-decoration: underline;">${monitorPatientForm.prognosis.statementOfPrognosis}</span></td>
							</tr>
							<tr>
								<td>Remarks: <span style="padding-left:5px;">${monitorPatientForm.prognosis.remarks}</span> </td>
							</tr>
						</table>					
					</c:if>
					
					<c:if test="${monitorPatientForm.diagnosis == null && monitorPatientForm.statement == null && monitorPatientForm.prognosis == null}">
						<table>
							<tr>
								<td>No Diagnosis, Medication Statement and Prognosis</td>
							</tr>
						</table>
					</c:if>
				</div>
			</fieldset>
		</div>
	
	
	</div>
	
</div>	
	