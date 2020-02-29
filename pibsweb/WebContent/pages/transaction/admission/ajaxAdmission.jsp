<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
$(function() {
     
	$('#dtDateAdmittedId').datepicker({}); 
	
    $('#suspectedDiagnosisId').focus();
    
  });
</script>

<div class="row">
	 
	
 	<div class="col-sm-10" style="padding-left: 40px;">

		<div style="height: 30%; padding-top: 0px;" align="left">
			<h3 style="font-style: bold;">Admission</h3>
			<html:form action="/admission.do" styleId="idForm">
			
				<fieldset>
					<!--<legend></legend>--><!-- leave this as blank to show the line separator -->
				
				<div>
					<html:errors/>
				</div>
				<div>
					<h5 style="color: blue;"><c:out value="${admissionForm.transactionMessage}"></c:out></h5>
				</div> 

						<div>
								<html:hidden property="patientSystemId" value="${admissionForm.patient.id}"/>
								<html:hidden property="id" value="${admissionForm.id}"/>
                            	<table>
                            		<tr>
                            		    <td>Admission ID</td>
                                        <td><input type="text" value="${admissionForm.caseNo}" readonly="readonly" placeholder="auto-generated"></td>
                            		</tr>
                            		<tr style="height: 5px;"></tr>
                                	<tr>
                                    	<td>Patient ID</td>
                                    	<td><label style="width: 150px; color: blue;">${admissionForm.patient.patientId}</label></td>
                                     </tr>
									<tr style="height: 5px;"></tr>
                            		<tr>
                            		    <td><label style="width: 75px; font-weight: normal;">Patient:</label></td>
                                    	<td><label style="width: 150px; color: blue;">${admissionForm.patient.fullName}</label></td>
                            		</tr>
                                    <tr style="height: 5px;"></tr>
                                    <tr>
                                     	<td><label style="width: 75px; font-weight: normal;">Age:</label></td>  
                                    	<td style="padding-left: 5px;"><input type="text"  style="width: 20px; text-align: right;" name="ageAdmitted" value="${admissionForm.ageAdmitted}"  readonly="readonly"/></td>
                                   	</tr>
                                    <tr style="height: 5px;"></tr>
                                    <tr>
                                        <td valign="top">Chief Complaint</td>
                                        <td style="padding-left: 5px;" colspan="5"><html:textarea  rows="2" cols="59" styleId="suspectedDiagnosisId" property="chiefComplaint" value="${admissionForm.chiefComplaint}" disabled="${admissionForm.transactionStatus}"></html:textarea></td>
                                    </tr>
                                    <tr style="height: 5px;"></tr>
                                    <tr>
                                        <td>Select Room</td>
                                        <td style="padding-left: 5px;">                    
                                        	<html:select  style="width: 180px; height: 25px;" name="admissionForm" property="roomId" disabled="${admissionForm.transactionStatus}">
								 				<html:option value="0">--Select--</html:option>
								 				<html:optionsCollection name="admissionForm" property="roomList" label="roomFullName" value="id"/>					 		
								 			</html:select>              									 	
                                        </td>
                                    </tr>
                                    <tr style="height: 5px;"></tr>
                                    <tr>
                                        <td>Select Doctor</td>
                                        <td style="padding-left: 5px;">
                                        	<html:select  style="width: 180px; height: 25px;" name="admissionForm" property="professionalId" disabled="${admissionForm.transactionStatus}">
								 				<html:option value="0">--Select--</html:option>
								 				<html:optionsCollection name="admissionForm" property="doctorList" label="fullName" value="id"/>					 		
								 			</html:select>
                                       </td>
                                    </tr>
                                    <tr style="height: 5px;"></tr>
                                    <tr>
										<td>Date Admitted</td>
										<td style="padding-left: 5px;" colspan="2">
											<input type="text"  style="width: 180px; text-align: right;" name="dateAdmitted" id="dtDateAdmittedId" value="${admissionForm.dateAdmitted}" placeholder="mm/dd/yyyy"/>
										</td>
									</tr>
									<tr style="height: 5px;"></tr>
									<tr>
									 	<td>Time Admitted</td>
										<td style="padding-left: 5px;" colspan="2">
											<input type="text"  style="width: 180px; text-align: right;" name="timeAdmitted" value="${admissionForm.timeAdmitted}" placeholder="hh:mm:ss AM/PM"/>
										</td>
									</tr> 
                                    <tr style="height: 15px;"></tr>
                                    <tr>
                                    	<td></td>
                                        <td colspan="4">
	                                        <c:choose>
											  <c:when test="${admissionForm.transactionStatus == true}">
											     <html:button property="btnClose" styleClass="btn btn-primary btnCancelClose" onclick="closeAdmission();" value="Close"></html:button>	
											     <html:button property="btnBack" styleClass="btn btn-primary btnBackToSearch" onclick="backToAdmissionSearch();" value="Back to Search"></html:button>	
												 <html:button property="btnGoTo" styleClass="btn btn-primary btnGoTo" onclick="goToMonitorPatient('${admissionForm.id}');" value="Go To Monitor Patient"></html:button>
											  </c:when>
											  <c:otherwise>
											  	<html:button property="btnSave" styleClass="btn btn-primary btnSaveUpdate" onclick="saveAdmission();" value="Save"></html:button>
												<html:button property="btnCancel" styleClass="btn btn-primary btnCancelClose" onclick="cancelAdmission();" value="Cancel"></html:button>	
											  </c:otherwise>
										  </c:choose>										
                                        </td>
                                    </tr>
                                </table>
                                
						</div>
				</fieldset>	
				
			</html:form>
		</div>
	
	</div>
	
</div>	
	