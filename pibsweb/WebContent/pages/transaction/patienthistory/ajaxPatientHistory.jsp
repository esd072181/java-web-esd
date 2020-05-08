<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<script>  
function showPatientHistory(divId) {
	if (document.getElementById(divId).style.display == "none") {
		document.getElementById(divId).style.display = "block";
	} else {
		document.getElementById(divId).style.display = "none";
	}
	
}
</script>

<div style="padding-left: 10px;">
	
	<div style="position: sticky; top: 150px; background-color: white;">
		<h3 style="font-style: bold;">Patient History</h3>
        <label>Name:</label>
        <span style="color: blue;">${patientHistoryForm.fullName}</span>
        <hr>
   	</div>
   								
   	<div>
   		<logic:iterate name="patientHistoryForm" property="modelList" type="com.pibs.model.Patient" id="model">
						<table>
    	                	<tr>
        	                     <td>CASE NO:</td>
            	                 <td style="padding-left: 5px;"><a href="#" onclick="showPatientHistory('<bean:write name="model" property="caseNo"/>');">  <bean:write name="model" property="caseNo"/></a></td>
   							</tr>
   							<tr style="height: 5px;"></tr>
   						</table>
   						<div id="<bean:write name="model" property="caseNo"/>" style="display: none;">
   							<table style="margin-left: 20px;">
   								<tr>
   									<td>Age: <span style="color: blue;"><bean:write name="model" property="ageAdmitted"/></span></td>
   								</tr>
   								<tr style="height: 5px;"></tr>
   								<tr>
        	                		<td>Chief Complaint:  <span style="color: blue;"><bean:write name="model" property="chiefComplaint"/></span></td>
   								</tr>
   								<tr style="height: 5px;"></tr>
   								<tr>
        	                		<td>Diagnosis:  <span style="color: blue;"><bean:write name="model" property="diagnosis"/></span></td>
   								</tr>
   								<tr style="height: 5px;"></tr>
   								<tr>
        	                		<td style="padding-left: 20px;">Remarks:  <span style="color: blue;"><bean:write name="model" property="diagnosisRemarks"/></span></td>
   								</tr>
   								<tr style="height: 5px;"></tr>
   								<tr>
        	                		<td>Date of Diagnosis:  <span style="color: blue;"><bean:write name="model" property="dateOfDiagnosis"/></span></td>
   								</tr>
   								<tr style="height: 5px;"></tr>
   								<tr>
        	                		<td>Medication Statement:  <span style="color: blue;"><bean:write name="model" property="medicationStatement"/></span></td>
   								</tr>
   								<tr style="height: 5px;"></tr>
   								<tr>
        	                		<td style="padding-left: 20px;">Remarks:  <span style="color: blue;"><bean:write name="model" property="medicationStatementRemarks"/></span></td>
   								</tr>
   								<tr style="height: 5px;"></tr>
   								<tr>
        	                		<td>Date of Medication Statement:  <span style="color: blue;"><bean:write name="model" property="dateOfMedicationStatement"/></span></td>
   								</tr>
   								<tr style="height: 5px;"></tr>
   								<tr>
        	                		<td>Prognosis:  <span style="color: blue;"><bean:write name="model" property="prognosis"/></span></td>
   								</tr>
   								<tr style="height: 5px;"></tr>
   								<tr>
        	                		<td style="padding-left: 20px;">Remarks:  <span style="color: blue;"><bean:write name="model" property="prognosisRemarks"/></span></td>
   								</tr>
   								<tr style="height: 5px;"></tr>
   								<tr>
        	                		<td>Date of Prognosis:  <span style="color: blue;"><bean:write name="model" property="dateOfPrognosis"/></span></td>
   								</tr>
   								<tr style="height: 5px;"></tr>
   								<tr>
        	                		<td>Doctor:  <span style="color: blue;"><bean:write name="model" property="doctor"/></span></td>
   								</tr>
   								<tr style="height: 5px;"></tr>
   								<tr>
        	                		<td>Date Admitted:  <span style="color: blue;"><bean:write name="model" property="dateAdmitted"/></span></td>
   								</tr>
   								<tr style="height: 5px;"></tr>
   								<tr>
        	                		<td>Date Discharged:  <span style="color: blue;"><bean:write name="model" property="dateDischarged"/></span></td>
   								</tr>
   						 	</table>
   						 	<hr>	 
						</div>
		</logic:iterate>	
   	</div>	
   							
   	<div style="padding-top: 10px;">		
		<html:button property="btnClose" styleClass="btn btn-primary btnCancelClose" onclick="closePatientHistory();" value="Close"></html:button>	
		<html:button property="btnBack" styleClass="btn btn-primary btnBackToSearch" onclick="backToPatientHistorySearch();" value="Back to Search"></html:button>	
	</div>
	
</div>	
	