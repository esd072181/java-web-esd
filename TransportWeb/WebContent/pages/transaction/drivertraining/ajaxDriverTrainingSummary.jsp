<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<script>
function generateReport(driverTrainingId,driverName) {
	
	$("#tablePresentationDIV").html("");//reset the status
	
	$.ajax({
		  type: "GET",
		  cache: false,
		  url: "driverTrainingSummary.do?",
		  data: { 
			  	command: "ajaxView", 
			  	driverTrainingId: driverTrainingId, 
			  	driverName: driverName, 
			  	generateReport : "true" 
		  }
		})
		  .done(function( result ) {
			$("#tablePresentationDIV").html(result);
		});
}

</script>

<div style="height: 30%; padding-left: 10px;">
		<h3 style="font-weight: bolder;">Driver Training and Information Summary</h3>
			<table>
				<tr style="height: 10px;">
				<tr>
					<td>
						<html:button property="command" onclick="goToDriverTraining();" value="Go Back to Main" styleClass="btn btn-primary"></html:button>	
					</td>
					<td style="padding-left: 10px;">
						<html:button property="command" onclick="generateReport('${driverTrainingForm.id}','${driverTrainingForm.driverName}');" value="Generate Report" styleClass="btn btn-primary"></html:button>	
					</td>
					<td style="padding-left: 20px;">
						<!-- show message if report is generated -->
						<div id="tablePresentationDIV">
							<!-- ajax part of table data -->
						</div>
					</td>
				</tr>
			</table>
			<table>
			    <!-- Driver Information section -->
				<tr style="height: 10px;">
				<tr>
					<td style="padding-left: 5px;"><label style="font-family: Tahoma; font-weight: lighter;">Name:</label></td>
					<td>&nbsp;&nbsp;<label style="font-size: 14px; font-weight: bolder; font: Tahoma;">${driverTrainingForm.driverName}</label> </td>
				</tr>
				<tr style="height: 5px;" ></tr>
				<tr>
					<td valign="top" style="padding-left: 5px;"><label style="font-family: Tahoma; font-weight: lighter;">Picture:</label></td>
					<c:choose>
                    	<c:when test="${driverTrainingForm.picStr!=null}">
                        	<td style="padding-left: 5px;"><html:image src="data:image/jpeg;base64,${driverTrainingForm.picStr}" alt="" style="width: 50px; height: 60px; pointer-events: none;" border="1px"></html:image></td>
                        </c:when>
                        <c:otherwise>
                            <td style="padding-left: 5px;"><label style="font-style: italic; font-size: 10px; color: blue;">No picture saved</label></td>
                        </c:otherwise>
                    </c:choose>					
				</tr>
				<tr style="height: 5px;" ></tr>
				<tr><td colspan="2"><h5 style="font-weight: bold; color: blue;">Driver's Information</h5></td></tr>
			</table>
			<table border="1">	
				<tr>
                    <td width="100"><label style="padding: 5px 5px 5px 5px; font-family: Tahoma; font-weight: lighter;">Date Hired: </label></td>
                    <td width="150"><label style="padding: 5px 5px 5px 5px;; font-size: 14px; font-weight: bolder; font: Tahoma;">${driverTrainingForm.dateHired}</label> </td>
                    <td width="100"><label style="padding: 5px 5px 5px 5px;font-family: Tahoma; font-weight: lighter;">License No: </label></td>
                    <td width="150"><label style="padding: 5px 5px 5px 5px;font-size: 14px; font-weight: bolder; font: Tahoma;">${driverTrainingForm.licenseNo}</label> </td>
                    <td width="100"><label style="padding: 5px 5px 5px 5px;font-family: Tahoma; font-weight: lighter;">Validity: </label></td>
                    <td width="150"><label style="padding: 5px 5px 5px 5px;font-size: 14px; font-weight: bolder; font: Tahoma;">${driverTrainingForm.licenseValidity}</label> </td>
                </tr>
				<tr style="height: 5px;" ></tr>
			</table>
			<table><tr><td><h5 style="font-weight: bold; color: blue;">Personal Data</h5></td></tr></table>
			<table border="1">	
				<tr>
                    <td width="100"><label style="padding: 5px 5px 5px 5px; font-family: Tahoma; font-weight: lighter;">Birthday: </label></td>
                    <td width="150"><label style="padding: 5px 5px 5px 5px;; font-size: 14px; font-weight: bolder; font: Tahoma;">${driverTrainingForm.birthday}</label> </td>
                    <td width="100"><label style="padding: 5px 5px 5px 5px;font-family: Tahoma; font-weight: lighter;">Contact No: </label></td>
                    <td width="150"><label style="padding: 5px 5px 5px 5px;font-size: 14px; font-weight: bolder; font: Tahoma;">${driverTrainingForm.contactNo}</label> </td>
                    <td width="100"><label style="padding: 5px 5px 5px 5px;font-family: Tahoma; font-weight: lighter;">Religion: </label></td>
                    <td width="150"><label style="padding: 5px 5px 5px 5px;font-size: 14px; font-weight: bolder; font: Tahoma;">${driverTrainingForm.religion}</label> </td>
                </tr>
				<tr style="height: 5px;" ></tr>
				<tr>
                    <td width="100"><label style="padding: 5px 5px 5px 5px; font-family: Tahoma; font-weight: lighter;">Gender: </label></td>
                    <td width="150"><label style="padding: 5px 5px 5px 5px;; font-size: 14px; font-weight: bolder; font: Tahoma;">${driverTrainingForm.gender}</label> </td>
                    <td width="100"><label style="padding: 5px 5px 5px 5px;font-family: Tahoma; font-weight: lighter;">Civil Status: </label></td>
                    <td width="150"><label style="padding: 5px 5px 5px 5px;font-size: 14px; font-weight: bolder; font: Tahoma;">${driverTrainingForm.civilStatus}</label> </td>
                    <td width="100"><label style="padding: 5px 5px 5px 5px;font-family: Tahoma; font-weight: lighter;">SSS No: </label></td>
                    <td width="150"><label style="padding: 5px 5px 5px 5px;font-size: 14px; font-weight: bolder; font: Tahoma;">${driverTrainingForm.sss}</label> </td>
                </tr>
                <tr style="height: 5px;" ></tr>
				<tr>
                    <td width="100"><label style="padding: 5px 5px 5px 5px; font-family: Tahoma; font-weight: lighter;">Age: </label></td>
                    <td width="150"><label style="padding: 5px 5px 5px 5px;; font-size: 14px; font-weight: bolder; font: Tahoma;">${driverTrainingForm.age}</label> </td>
                    <td width="100"><label style="padding: 5px 5px 5px 5px;font-family: Tahoma; font-weight: lighter;">Spouse: </label></td>
                    <td width="150"><label style="padding: 5px 5px 5px 5px;font-size: 14px; font-weight: bolder; font: Tahoma;">${driverTrainingForm.spouse}</label> </td>
                    <td width="100"><label style="padding: 5px 5px 5px 5px;font-family: Tahoma; font-weight: lighter;">Philhealth No: </label></td>
                    <td width="150"><label style="padding: 5px 5px 5px 5px;font-size: 14px; font-weight: bolder; font: Tahoma;">${driverTrainingForm.philhealthNo}</label> </td>
                </tr>
                <tr style="height: 5px;" ></tr>
				<tr>
                    <td width="100"><label style="padding: 5px 5px 5px 5px; font-family: Tahoma; font-weight: lighter;">Height (cm): </label></td>
                    <td width="150"><label style="padding: 5px 5px 5px 5px;; font-size: 14px; font-weight: bolder; font: Tahoma;">${driverTrainingForm.height}</label> </td>
                    <td width="100"><label style="padding: 5px 5px 5px 5px;font-family: Tahoma; font-weight: lighter;">Mother's Name: </label></td>
                    <td width="150"><label style="padding: 5px 5px 5px 5px;font-size: 14px; font-weight: bolder; font: Tahoma;">${driverTrainingForm.mothersName}</label> </td>
                    <td width="100"><label style="padding: 5px 5px 5px 5px;font-family: Tahoma; font-weight: lighter;">Pagibig No: </label></td>
                    <td width="150"><label style="padding: 5px 5px 5px 5px;font-size: 14px; font-weight: bolder; font: Tahoma;">${driverTrainingForm.pagibig}</label> </td>
                </tr> 
				<tr style="height: 5px;" ></tr>
				<tr>
                    <td width="100"><label style="padding: 5px 5px 5px 5px; font-family: Tahoma; font-weight: lighter;">Weight (cm): </label></td>
                    <td width="150"><label style="padding: 5px 5px 5px 5px;; font-size: 14px; font-weight: bolder; font: Tahoma;">${driverTrainingForm.weight}</label> </td>
                    <td width="100"><label style="padding: 5px 5px 5px 5px;font-family: Tahoma; font-weight: lighter;">Father's Name: </label></td>
                    <td width="150"><label style="padding: 5px 5px 5px 5px;font-size: 14px; font-weight: bolder; font: Tahoma;">${driverTrainingForm.fathersName}</label> </td>
                    <td width="100"><label style="padding: 5px 5px 5px 5px;font-family: Tahoma; font-weight: lighter;">TIN: </label></td>
                    <td width="150"><label style="padding: 5px 5px 5px 5px;font-size: 14px; font-weight: bolder; font: Tahoma;">${driverTrainingForm.tin}</label> </td>
                </tr> 
                <tr style="height: 5px;" ></tr>
                <tr>
                	<td><label style="padding: 5px 5px 5px 5px; font-family: Tahoma; font-weight: lighter;">Address: </label></td>
                	<td colspan="5"><label style="padding: 5px 5px 5px 5px;; font-size: 14px; font-weight: bolder; font: Tahoma;">${driverTrainingForm.address}</label> </td>
                </tr>
                <tr style="height: 5px;" ></tr>
			</table>
			<table><tr><td><h5 style="font-weight: bold; color: blue;">Educational Background</h5></td></tr></table>
			<table border="1">	
				<tr>
                    <td width="100"><label style="padding: 5px 5px 5px 5px; font-family: Tahoma; font-weight: lighter;">Elementary: </label></td>
                    <td colspan="4" width="500"><label style="padding: 5px 5px 5px 5px;; font-size: 14px; font-weight: bolder; font: Tahoma;">${driverTrainingForm.elementary}</label> </td>
                    <td width="150"><label style="padding: 5px 5px 5px 5px;; font-size: 14px; font-weight: bolder; font: Tahoma;">${driverTrainingForm.elementaryDate}</label> </td>
                </tr>
                <tr style="height: 5px;" ></tr>
                <tr>
                    <td width="100"><label style="padding: 5px 5px 5px 5px; font-family: Tahoma; font-weight: lighter;">Secondary: </label></td>
                    <td colspan="4" width="500"><label style="padding: 5px 5px 5px 5px;; font-size: 14px; font-weight: bolder; font: Tahoma;">${driverTrainingForm.secondary}</label> </td>
                    <td width="150"><label style="padding: 5px 5px 5px 5px;; font-size: 14px; font-weight: bolder; font: Tahoma;">${driverTrainingForm.secondaryDate}</label> </td>
                </tr>
                <tr style="height: 5px;" ></tr>
                <tr>
                    <td width="100"><label style="padding: 5px 5px 5px 5px; font-family: Tahoma; font-weight: lighter;">Tertiary: </label></td>
                    <td colspan="4" width="500"><label style="padding: 5px 5px 5px 5px;; font-size: 14px; font-weight: bolder; font: Tahoma;">${driverTrainingForm.tertiary}</label> </td>
                    <td width="150"><label style="padding: 5px 5px 5px 5px;; font-size: 14px; font-weight: bolder; font: Tahoma;">${driverTrainingForm.tertiaryDate}</label> </td>
                </tr>
                <tr style="height: 5px;" ></tr>
            </table>
            <table><tr><td><h5 style="font-weight: bold; color: blue;">Employment Record</h5></td></tr></table>
            <table border="1">		
				<tr>
                    <td width="100"><label style="padding: 5px 5px 5px 5px; font-family: Tahoma; font-weight: lighter;">From</label></td>
                    <td width="100"><label style="padding: 5px 5px 5px 5px; font-family: Tahoma; font-weight: lighter;">To</label></td>
                    <td colspan="2" width="275"><label style="padding: 5px 5px 5px 5px; font-family: Tahoma; font-weight: lighter;">Position</label></td>
                    <td colspan="2" width="275"><label style="padding: 5px 5px 5px 5px; font-family: Tahoma; font-weight: lighter;">Company</label></td>
                </tr>
                <tr style="height: 5px;" ></tr>
                <tr>
                    <td width="100"><label style="padding: 5px 5px 5px 5px;; font-size: 14px; font-weight: bolder; font: Tahoma;">${driverTrainingForm.employmentDateFrom1}</label></td>
                    <td width="100"><label style="padding: 5px 5px 5px 5px;; font-size: 14px; font-weight: bolder; font: Tahoma;">${driverTrainingForm.employmentDateTo1}</label></td>
                    <td colspan="2" width="275"><label style="padding: 5px 5px 5px 5px;; font-size: 14px; font-weight: bolder; font: Tahoma;">${driverTrainingForm.employmentPosition1}</label></td>
                    <td colspan="2" width="275"><label style="padding: 5px 5px 5px 5px;; font-size: 14px; font-weight: bolder; font: Tahoma;">${driverTrainingForm.employmentCompany1}</label></td>
                </tr>	
                <tr style="height: 5px;" ></tr>
                <tr>
                    <td width="100"><label style="padding: 5px 5px 5px 5px;; font-size: 14px; font-weight: bolder; font: Tahoma;">${driverTrainingForm.employmentDateFrom2}</label></td>
                    <td width="100"><label style="padding: 5px 5px 5px 5px;; font-size: 14px; font-weight: bolder; font: Tahoma;">${driverTrainingForm.employmentDateTo2}</label></td>
                    <td colspan="2" width="275"><label style="padding: 5px 5px 5px 5px;; font-size: 14px; font-weight: bolder; font: Tahoma;">${driverTrainingForm.employmentPosition2}</label></td>
                    <td colspan="2" width="275"><label style="padding: 5px 5px 5px 5px;; font-size: 14px; font-weight: bolder; font: Tahoma;">${driverTrainingForm.employmentCompany2}</label></td>
                </tr>
                <tr style="height: 5px;" ></tr>
                <tr>
                    <td width="100"><label style="padding: 5px 5px 5px 5px;; font-size: 14px; font-weight: bolder; font: Tahoma;">${driverTrainingForm.employmentDateFrom3}</label></td>
                    <td width="100"><label style="padding: 5px 5px 5px 5px;; font-size: 14px; font-weight: bolder; font: Tahoma;">${driverTrainingForm.employmentDateTo3}</label></td>
                    <td colspan="2" width="275"><label style="padding: 5px 5px 5px 5px;; font-size: 14px; font-weight: bolder; font: Tahoma;">${driverTrainingForm.employmentPosition3}</label></td>
                    <td colspan="2" width="275"><label style="padding: 5px 5px 5px 5px;; font-size: 14px; font-weight: bolder; font: Tahoma;">${driverTrainingForm.employmentCompany3}</label></td>
                </tr>
                 <tr style="height: 5px;" ></tr>
			</table>
			<table><tr><td><h5 style="font-weight: bold; color: blue;">Other Details</h5></td></tr></table>
			<table border="1">		
			    <tr> 
                	<td width="100"><label style="padding: 5px 5px 5px 5px; font-family: Tahoma; font-weight: lighter;">FTW:</label></td>
                    <td style="padding-left: 5px;" width="200"><label style="font-size: 12px; font-weight: bolder; font: Tahoma;">${driverTrainingForm.ftw}</label></td>				 		
                </tr>
             	<tr>
                	<td><label style="padding: 5px 5px 5px 5px; font-family: Tahoma; font-weight: lighter;">NBI:</label></td>
                    <td style="padding-left: 5px;"><label style="font-size: 12px; font-weight: bolder; font: Tahoma;">${driverTrainingForm.nbi}</label></td>				 		
                </tr>
                <tr style="height: 5px;" ></tr>
				<tr>
                	<td><label style="padding: 5px 5px 5px 5px; font-family: Tahoma; font-weight: lighter;">Terminal:</label></td>
					 <td style="padding-left: 5px;"><label style="font-size: 12px; font-weight: bolder; font: Tahoma;">${driverTrainingForm.terminalName}</label></td>	
                </tr>
				<tr style="height: 5px;" ></tr>
				<tr>
                	<td><label style="padding: 5px 5px 5px 5px; font-family: Tahoma; font-weight: lighter;">Articulated:</label></td>
                    <td style="padding-left: 5px;"><label style="font-size: 12px; font-weight: bolder; font: Tahoma;">${driverTrainingForm.articulated}</label></td>				 		
                </tr>
			</table>
			
			<br>
			<!-- Training Section -->
			<h5 style="font-weight: bold;">List of Training</h5>
			<div class="table-responsive" >
					<c:choose>
					  <c:when test="${driverTrainingForm.trainingList != null && driverTrainingForm.trainingList.size() > 0}">
						<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%; font-size: xx-small;">  
							<tr>
								<th>Training</th>
								<th>Expiry Date</th>
							</tr>
							<logic:iterate name="driverTrainingForm" property="trainingList" type="com.transport.model.DriverTrainingInfo" id="model">
								<tr>				 
									<td><bean:write name="model" property="training"/></td>
									<td align="right"><bean:write name="model" property="expiryDate" format='MM/dd/yyyy'/></td>
								</tr>
							</logic:iterate>
						</table>
					  </c:when>
					  <c:otherwise>
					  	<div style="color: blue;">No training record found!</div>
					  </c:otherwise>
					</c:choose>
			</div>
			
			<!-- Profile Section -->
			<h5 style="font-weight: bold;">Driver Profile</h5>
			<div class="table-responsive" >
					<c:choose>
					  <c:when test="${driverTrainingForm.profileList != null && driverTrainingForm.profileList.size() > 0}">
						<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%; font-size: xx-small;">  
							<tr>
								<th>VNV</th>
								<th>Incab</th>
								<th>Spotcheck</th>
								<th>Incident</th>
								<th>Notes</th>
								<th>Profile Date</th>
								<th>Status</th>
							</tr>
							<logic:iterate name="driverTrainingForm" property="profileList" type="com.transport.model.DriverTrainingProfile" id="model">
								<tr>				 
									<td><a href="#" onclick="goToDriverTrainingProfileComments('${driverTrainingForm.driverTrainingId}','${model.id}','${model.vnv}','${driverTrainingForm.driverName}','253','true');"><bean:write name="model" property="vnv"/></a></td>
									<td><a href="#" onclick="goToDriverTrainingProfileComments('${driverTrainingForm.driverTrainingId}','${model.id}','${model.incab}','${driverTrainingForm.driverName}','254','true');"><bean:write name="model" property="incab"/></a></td>
									<td><a href="#" onclick="goToDriverTrainingProfileComments('${driverTrainingForm.driverTrainingId}','${model.id}','${model.spotcheck}','${driverTrainingForm.driverName}','255','true');"><bean:write name="model" property="spotcheck"/></a></td>
									<td><a href="#" onclick="goToDriverTrainingProfileComments('${driverTrainingForm.driverTrainingId}','${model.id}','${model.incident}','${driverTrainingForm.driverName}','256','true');"><bean:write name="model" property="incident"/></a></td>
									<td><bean:write name="model" property="notes"/></td>
									<td align="right"><bean:write name="model" property="profileDate" format='MM/dd/yyyy'/></td>
									<c:choose>
										<c:when test="${model.status == 'Closed'}">
											<td><span style="color: blue;"><bean:write name="model" property="status"/></span></td>	
										</c:when>
										<c:otherwise>
											<td><span style="color: red;"><bean:write name="model" property="status"/></span></td>
										</c:otherwise>
									</c:choose>
								</tr>
							</logic:iterate>
						</table>
					  </c:when>
					  <c:otherwise>
					  	<div style="color: blue;">No profile record found!</div>
					  </c:otherwise>
					</c:choose>
			</div>
										
		
</div>

