<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div style="padding-left: 10px;">

			<h3 style="font-style: bold;">Monitor Patient</h3>
			
			<html:form action="/monitorPatient.do" styleId="idForm">
			
						<hr>
						<!-- Patient Info -->
						<div>
							<html:hidden property="id" value="${monitorPatientForm.id}"/>
                            <table>
                            		<tr>
                            		    <td><label style="width: 112px; padding-left: 5px;">Name:</label></td>
                                    	<td><input type="text" style="width: 200px; color: blue;" value="${monitorPatientForm.admission.patientFullName}" readonly="readonly"/></td>
                                    	<td><label style="width: 112px; padding-left: 5px;">Age:</label></td>
                                    	<td><input type="text" style="width: 200px; color: blue;" value="${monitorPatientForm.admission.ageAdmitted}"></td>
                            		</tr>
                            		<tr style="height: 5px;" ></tr>
                                    <tr>
                                    	<td><label style="width: 112px; padding-left: 5px;">Room:</label></td>
                                    	<c:choose>
  	                                  		<c:when test="${monitorPatientForm.admission.roomNoTransfer != null}">
  	                                  			<td><input type="text" style="width: 200px; color: blue;" value="${monitorPatientForm.admission.roomNoTransfer}"></td>
                                    		</c:when>
                                    		<c:otherwise>
                                    			<td><input type="text" style="width: 200px; color: blue;" value="${monitorPatientForm.admission.roomNo}"></td>	
                                    		</c:otherwise>
                                    	</c:choose>
                                    	<td><label style="width: 112px; padding-left: 5px;">Doctor:</label></td>
                                    	<td colspan="3"><input type="text" style="width: 200px; color: blue; padding-left: 5px;" value="${monitorPatientForm.admission.doctor}"></td>	                 
                                    </tr>
                                    <tr style="height: 5px;" ></tr>
                                	<tr>
                                        <td><label style="width: 112px; padding-left: 5px;">Date Admitted:</label></td>
                                        <td><input type="text" style="width: 200px; color: blue;" value="${monitorPatientForm.dateAdmitted}"></td>
                                        <td><label style="width: 112px; padding-left: 5px;">Time Admitted:</label></td>
                                        <td><input type="text" style="width: 200px; color: blue; padding-left: 5px;" value="${monitorPatientForm.timeAdmitted}"></td>
                                        <td><label style="width: 73px; padding-left: 5px;">Case No:</label></td> 
                                        <td><input type="text" style="width: 200px; color: blue;" value="${monitorPatientForm.admission.caseNo}"></td>                                           
                                    </tr>
                             </table>                                
						</div>
						
						<hr>
						
						<!-- Buttons -->
						<div>
                              <table>
                                    <tr>
                                    	<td colspan="10">
                                     	    <html:button property="btnRoomTransfer" styleClass="btn btn-primary btnMonitoringSmall" onclick="goToMonitorRoomTransfer('${monitorPatientForm.id}');" value="Room Transfer"></html:button>                  
                                    		<html:button property="btnRoom" styleClass="btn btn-primary btnMonitoringSmall" onclick="goToMonitorRoom('${monitorPatientForm.id}');" value="Other Room"></html:button>
                                    		<html:button property="btnDoctor" styleClass="btn btn-primary btnMonitoringSmall" onclick="goToMonitorDoctor('${monitorPatientForm.id}');" value="Other Doctor/Professional"></html:button>
                                    		<html:button property="btnNursery" styleClass="btn btn-primary btnMonitoringSmall" onclick="goToMonitorNursery('${monitorPatientForm.id}');" value="Nursery"></html:button>
                                    		<html:button property="btnPhysicalExamination" styleClass="btn btn-primary btnMonitoringMed" onclick="goToMonitorPhysicalExamination('${monitorPatientForm.id}');" value="Physical Examination"></html:button>
                                    		<html:button property="btnBack" styleClass="btn btn-primary btnBackToSearch" onclick="backToMonitorPatientSearch();" value="Back to Search"></html:button>
                                    		<html:button property="btnGoTo" styleClass="btn btn-primary btnBackToSearch" onclick="goToBilling('${monitorPatientForm.id}');" value="Go To Billing"></html:button> 
                                    	</td>
                                    </tr>
                                    <tr style="height: 5px;" ></tr>
                                    <tr>
                                    	<td colspan="10">
											<html:button property="btnDiagnosis" styleClass="btn btn-primary btnMonitoringSmall" onclick="goToDiagnosis('${monitorPatientForm.id}');" value="Diagnosis"></html:button>
											<html:button property="btnMedicationStatement" styleClass="btn btn-primary btnMonitoringLong" onclick="goToMedicationStatement('${monitorPatientForm.id}');" value="Medication Statement"></html:button>
											<html:button property="btnPrognosis" styleClass="btn btn-primary btnMonitoringSmall" onclick="goToPrognosis('${monitorPatientForm.id}');" value="Prognosis"></html:button>
											<html:button property="btnLaboratoryExamination" styleClass="btn btn-primary btnMonitoringLong" onclick="goToMonitorLaboratoryExamination('${monitorPatientForm.id}');" value="Laboratory Examination"></html:button>
											<html:button property="btnMedicalSupply" styleClass="btn btn-primary btnMonitoringSmall" onclick="goToMonitorMedicalSupply('${monitorPatientForm.id}');" value="Medical Supply"></html:button>
											<html:button property="btnRadiology" styleClass="btn btn-primary btnMonitoringSmall" onclick="goToMonitorRadiology('${monitorPatientForm.id}');" value="Radiology"></html:button>
											<html:button property="btnSurgery" styleClass="btn btn-primary btnMonitoringSmall" onclick="goToMonitorSurgery('${monitorPatientForm.id}');" value="Surgery"></html:button>
											<html:button property="btnAdditional Services" styleClass="btn btn-primary btnMonitoringMed" onclick="goToMonitorAdditionalServices('${monitorPatientForm.id}');" value="Additional Services"></html:button>
											<html:button property="btnEquipment" styleClass="btn btn-primary btnMonitoringSmall" onclick="goToMonitorEquipment('${monitorPatientForm.id}');" value="Equipment"></html:button>
										</td>
									</tr>    
                             </table>
						</div>
						
			</html:form>
		</div>
		
		<hr>
	
		<!-- ajax part of child module data of monitor patient -->
		<div id="childDIV" style="padding-left: 10px;">
				<h3>Summary</h3>
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

		</div>
	
	