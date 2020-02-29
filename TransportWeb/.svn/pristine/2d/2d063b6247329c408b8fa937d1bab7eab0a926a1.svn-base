<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
$(function() {
    $('#dtBirthdayId').datepicker({}); 
    $('#dtDateHiredId').datepicker({}); 
    $('#dtLicenseValidityId').datepicker({}); 
    $('#dtFtwId').datepicker({}); 
    $('#dtNbiId').datepicker({}); 
    $('#dtBirthdayId').attr('placeholder','mm/dd/yyyy');
    $('#dtDateHiredId').attr('placeholder','mm/dd/yyyy');
    $('#dtLicenseValidityId').attr('placeholder','mm/dd/yyyy');
    $('#dtFtwId').attr('placeholder','mm/dd/yyyy');
    $('#dtNbiId').attr('placeholder','mm/dd/yyyy');
    $('#driverIdId').focus();
  });

function getAge(DOB) {
    var today = new Date();
    var birthDate = new Date(DOB);
    var age = today.getFullYear() - birthDate.getFullYear();
    var m = today.getMonth() - birthDate.getMonth();
    if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
        age = age - 1;
    }
	if (age > 0 && age < 101) {
		$('#ageId').val(age);	
	} else {
		$('#ageId').val('');	
	}
    return false;
}
</script>

<div style="height: 30%; padding-left: 10px;">
			<h3 style="font-weight: bolder;">Driver Training and Information - Edit Record</h3>
			<html:form action="/driverTraining.do" styleId="idForm" >
				<fieldset>
				
				<div>
					<html:errors/>
				</div>
				<div>
					<h4 style="color: blue;"><c:out value="${driverTrainingForm.transactionMessage}"></c:out></h4>
					<c:if test="${driverTrainingForm.transactionStatus == true}">
						<html:button property="btnClose" styleClass="btn btn-primary" onclick="goToDriverTraining();" value="Close"></html:button>
						<br>
						<br>
					</c:if>
				</div>
				
				<div style="width: 100%; font-size: small;"> <!-- table -->
				
                           	<table>
                           	        <html:hidden property="id" value="${driverTrainingForm.id}"/>
                            		<!-- Driver  -->
                                    <tr>
                                    	<td>Select Driver</td>
  								 		<td style="padding-left: 5px;">
  								 			<html:select  styleId="driverIdId" style="width: 180px; height: 22px;"  name="driverTrainingForm" property="driverId" disabled="${driverTrainingForm.transactionStatus}">
								 				<html:option value="0">--Select--</html:option>
								 				<html:optionsCollection name="driverTrainingForm" property="driverList" label="fullName2" value="id"/>				 		
								 			</html:select>
								 		</td>	
								 	</tr>
								 	<tr style="height: 5px;" ></tr>
								 	<tr>
                                        <td valign="top">Picture</td>
                                        <c:choose>
                                        	<c:when test="${driverTrainingForm.transactionStatus == false}">
                                        		<c:choose>
                                        			<c:when test="${driverTrainingForm.picStr!=null}">
                                        				<td style="padding-left: 5px;"><html:image src="data:image/jpeg;base64,${driverTrainingForm.picStr}" alt="" style="width: 50px; height: 60px; pointer-events: none;" border="1px"></html:image><input type="file" name="file"  style="width: 180px;"></td>
                                        			</c:when>
                                        			<c:otherwise>
                                        				<td style="padding-left: 5px;"><label style="font-style: italic; font-size: 10px; color: blue;">No picture saved</label><input type="file" name="file" style="width: 180px;"></td>
                                        			</c:otherwise>
                                        		</c:choose>                                        		
                                        	</c:when>
                                        	<c:otherwise>
                                        		<c:choose>
                                        			<c:when test="${driverTrainingForm.picStr!=null}">
                                        				<td style="padding-left: 5px;"><html:image src="data:image/jpeg;base64,${driverTrainingForm.picStr}" alt="" style="width: 50px; height: 60px; pointer-events: none;" border="1px"></html:image></td>
                                        			</c:when>
                                        			<c:otherwise>
                                        				<td style="padding-left: 5px;"><label style="font-style: italic; font-size: 10px; color: blue;">No picture saved</label></td>
                                        			</c:otherwise>
                                        		</c:choose>
                                        	</c:otherwise>
                                        </c:choose>
                                    </tr>
								 	<tr style="height: 5px;" ></tr>
								 	<tr><td colspan="2"><h5 style="font-weight: bold; color: blue;">Driver's Information</h5></td></tr>
								 	<tr>
                                        <td>Date Hired</td>
                                        <td style="padding-left: 5px;"><html:text  property="dateHired" style="width: 180px; text-align: right;" styleId="dtDateHiredId" disabled="${driverTrainingForm.transactionStatus}"></html:text></td>
                                    	<td style="padding-left: 10px;">License No</td>
                                    	<td style="padding-left: 5px;"><html:text  property="licenseNo" style="width: 180px; text-align: right;" disabled="${driverTrainingForm.transactionStatus}"></html:text></td>
                                    	<td style="padding-left: 10px;">Validity</td>
                                        <td style="padding-left: 5px;"><html:text  property="licenseValidity" style="width: 180px; text-align: right;" styleId="dtLicenseValidityId" disabled="${driverTrainingForm.transactionStatus}"></html:text></td>
                                    </tr>
								 	<tr style="height: 5px;" ></tr>
								 	<tr><td><h5 style="font-weight: bold; color: blue;">Personal Data</h5></td></tr>
									<tr style="height: 5px;" ></tr>	
								    <tr>
                                        <td>Birthday</td>
                                        <td style="padding-left: 5px;"><html:text  property="birthday"  onkeyup="getAge($('#dtBirthdayId').val());" style="width: 180px; text-align: right;" styleId="dtBirthdayId" disabled="${driverTrainingForm.transactionStatus}"></html:text></td>
                                    	<td style="padding-left: 10px;">Contact No</td>
                                    	<td style="padding-left: 5px;"><html:text  property="contactNo" style="width: 180px; text-align: right;" disabled="${driverTrainingForm.transactionStatus}"></html:text></td>
                                    	<td style="padding-left: 10px;">Religion</td>
                                         <td style="padding-left: 5px;">
                                        	<html:select style="width: 180px; height: 22px;"  name="driverTrainingForm" property="religion" disabled="${driverTrainingForm.transactionStatus}">
								 				<html:option value="Catholic">Catholic</html:option>
								 				<html:option value="Church of Christ">Church of Christ</html:option>
								 				<html:option value="Church of God">Church of God</html:option>
								 				<html:option value="Christian">Christian</html:option>
								 				<html:option value="Islam">Islam</html:option>
								 				<html:option value="Aglipay">Aglipay</html:option>
								 				<html:option value="Other">Other</html:option>								 				
								 				<html:option value="N/A">N/A</html:option>
								 				<html:option value=""></html:option>			 		
								 			</html:select>
                                        </td>
                                    </tr>	
                                    <tr style="height: 5px;" ></tr>
                                    <tr>
                                        <td>Gender</td>
                                        <td style="padding-left: 5px;">
                                        	<html:select style="width: 180px; height: 22px;"  name="driverTrainingForm" property="gender" value="Male" disabled="${driverTrainingForm.transactionStatus}">
								 				<html:option value="Male">Male</html:option>
								 				<html:option value="Female">Female</html:option>			 		
								 			</html:select>
                                        </td>
                                    	<td style="padding-left: 10px;">Civil Status</td>
                                    	<td style="padding-left: 5px;">
                                        	<html:select style="width: 180px; height: 22px;"  name="driverTrainingForm" property="civilStatus" disabled="${driverTrainingForm.transactionStatus}">
								 				<html:option value="Married">Married</html:option>
								 				<html:option value="Single">Single</html:option>
								 				<html:option value="Widower">Widower</html:option>
								 				<html:option value="N/A">N/A</html:option>
								 			</html:select>
                                        </td>
                                    	<td style="padding-left: 10px;">SSS No</td>
                                        <td style="padding-left: 5px;"><html:text  property="sss" style="width: 180px; text-align: right;" disabled="${driverTrainingForm.transactionStatus}"></html:text></td>
                                    </tr>	
									<tr style="height: 5px;" ></tr>
									<tr>
                                        <td>Age</td>
                                        <td style="padding-left: 5px;"><input type="text" id="ageId"  style="width: 180px; text-align: right; background-color: #F5F5F5;" onfocus="getAge($('#dtBirthdayId').val());" onclick="getAge($('#dtBirthdayId').val());" readonly="readonly"></td>
                                    	<td style="padding-left: 10px;">Spouse</td>
                                    	<td style="padding-left: 5px;"><html:text  property="spouse" style="width: 180px; text-align: left;" disabled="${driverTrainingForm.transactionStatus}"></html:text></td>
                                    	<td style="padding-left: 10px;">Philhealth No</td>
                                        <td style="padding-left: 5px;"><html:text  property="philhealthNo" style="width: 180px; text-align: right;" disabled="${driverTrainingForm.transactionStatus}"></html:text></td>
                                    </tr>
                                    <tr style="height: 5px;" ></tr>
									<tr>
                                        <td>Height (cm)</td>
                                        <td style="padding-left: 5px;"><html:text  property="height" style="width: 180px; text-align: right;" disabled="${driverTrainingForm.transactionStatus}"></html:text></td>
                                    	<td style="padding-left: 10px;">Mother's Name</td>
                                    	<td style="padding-left: 5px;"><html:text  property="mothersName" style="width: 180px; text-align: left;" disabled="${driverTrainingForm.transactionStatus}"></html:text></td>
                                    	<td style="padding-left: 10px;">Pagibig No</td>
                                        <td style="padding-left: 5px;"><html:text  property="pagibig" style="width: 180px; text-align: right;" disabled="${driverTrainingForm.transactionStatus}"></html:text></td>
                                    </tr>		
									<tr style="height: 5px;" ></tr>
									<tr>
                                        <td>Weight (kg)</td>
                                        <td style="padding-left: 5px;"><html:text  property="weight" style="width: 180px; text-align: right;" disabled="${driverTrainingForm.transactionStatus}"></html:text></td>
                                    	<td style="padding-left: 10px;">Father's Name</td>
                                    	<td style="padding-left: 5px;"><html:text  property="fathersName" style="width: 180px; text-align: left;" disabled="${driverTrainingForm.transactionStatus}"></html:text></td>
                                    	<td style="padding-left: 10px;">TIN</td>
                                        <td style="padding-left: 5px;"><html:text  property="tin" style="width: 180px; text-align: right;" disabled="${driverTrainingForm.transactionStatus}"></html:text></td>
                                    </tr>	
                                    <tr style="height: 5px;" ></tr>
									<tr>
										<td valign="top">Address</td>
										<td colspan="5" style="padding-left: 5px;">
											<html:textarea  rows="2" cols="112" property="address" style="text-align: left;"  disabled="${driverTrainingForm.transactionStatus}"></html:textarea>
										</td>
									</tr>
									<tr style="height: 5px;" ></tr>
									<tr><td colspan="2"><h5 style="font-weight: bold; color: blue;">Educational Background</h5></td></tr>
									<tr style="height: 5px;" ></tr>
									<tr>
                                        <td>Elementary</td>
                                        <td colspan="4" style="padding-left: 5px;"><html:text  title="Elementary school name" property="elementary" style="width: 550px; text-align: left;" disabled="${driverTrainingForm.transactionStatus}"></html:text></td>
                                        <td><html:text  title="date" property="elementaryDate" style="width: 180px; text-align: center;" disabled="${driverTrainingForm.transactionStatus}"></html:text></td>
                                    </tr>
									<tr style="height: 5px;" ></tr>
									<tr>
                                        <td>Secondary</td>
                                        <td colspan="4" style="padding-left: 5px;"><html:text  title="Secondary school name" property="secondary" style="width: 550px; text-align: left;" disabled="${driverTrainingForm.transactionStatus}"></html:text></td>
                                        <td><html:text  title="date" property="secondaryDate" style="width: 180px; text-align: center;" disabled="${driverTrainingForm.transactionStatus}"></html:text></td>
                                    </tr>
                                    <tr style="height: 5px;" ></tr>
									<tr>
                                        <td>Tertiary</td>
                                        <td colspan="4" style="padding-left: 5px;"><html:text  title="Tertiary school name" property="tertiary" style="width: 550px; text-align: left;" disabled="${driverTrainingForm.transactionStatus}"></html:text></td>
                                        <td><html:text  title="date" property="tertiaryDate" style="width: 180px; text-align: center;" disabled="${driverTrainingForm.transactionStatus}"></html:text></td>
                                    </tr>									
									<tr style="height: 5px;" ></tr>
									<tr><td colspan="2"><h5 style="font-weight: bold; color: blue;">Employment Record</h5></td></tr>
									<tr style="height: 5px;" ></tr>
									<tr>
                                        <td style="font-weight: bold;">From</td>
                                        <td style="padding-left: 5px; font-weight: bold;">To</td>
                                        <td colspan="2" style="padding-left: 5px; font-weight: bold;">Position</td>
                                        <td colspan="3" style="padding-left: 5px; font-weight: bold;">Company</td>
                                    </tr>					
									<tr style="height: 5px;" ></tr>
									<tr>
										<td><html:text  property="employmentDateFrom1" style="width: 90px; text-align: center;" disabled="${driverTrainingForm.transactionStatus}"></html:text></td>
										<td style="padding-left: 5px;"><html:text  property="employmentDateTo1" style="width: 180px; text-align: center;" disabled="${driverTrainingForm.transactionStatus}"></html:text></td>
										<td colspan="2" style="padding-left: 5px;"><html:text  property="employmentPosition1" style="width: 280px; text-align: left;" disabled="${driverTrainingForm.transactionStatus}"></html:text></td>
										<td colspan="2" style="padding-left: 5px;"><html:text  property="employmentCompany1" style="width: 270px; text-align: left;" disabled="${driverTrainingForm.transactionStatus}"></html:text></td>
									</tr>
									<tr style="height: 5px;" ></tr>
									<tr>
										<td><html:text  property="employmentDateFrom2" style="width: 90px; text-align: center;" disabled="${driverTrainingForm.transactionStatus}"></html:text></td>
										<td style="padding-left: 5px;"><html:text  property="employmentDateTo2" style="width: 180px; text-align: center;" disabled="${driverTrainingForm.transactionStatus}"></html:text></td>
										<td colspan="2" style="padding-left: 5px;"><html:text  property="employmentPosition2" style="width: 280px; text-align: left;" disabled="${driverTrainingForm.transactionStatus}"></html:text></td>
										<td colspan="2" style="padding-left: 5px;"><html:text  property="employmentCompany2" style="width: 270px; text-align: left;" disabled="${driverTrainingForm.transactionStatus}"></html:text></td>
									</tr>
									<tr style="height: 5px;" ></tr>
									<tr>
										<td><html:text  property="employmentDateFrom3" style="width: 90px; text-align: center;" disabled="${driverTrainingForm.transactionStatus}"></html:text></td>
										<td style="padding-left: 5px;"><html:text  property="employmentDateTo3" style="width: 180px; text-align: center;" disabled="${driverTrainingForm.transactionStatus}"></html:text></td>
										<td colspan="2" style="padding-left: 5px;"><html:text  property="employmentPosition3" style="width: 280px; text-align: left;" disabled="${driverTrainingForm.transactionStatus}"></html:text></td>
										<td colspan="2" style="padding-left: 5px;"><html:text  property="employmentCompany3" style="width: 270px; text-align: left;" disabled="${driverTrainingForm.transactionStatus}"></html:text></td>
									</tr>
									<tr style="height: 5px;" ></tr>
									<tr><td colspan="2"><h5 style="font-weight: bold; color: blue;">Other Details</h5></td></tr>
									<tr style="height: 5px;" ></tr>
									<tr>
										<td>FTW</td>
                                        <td style="padding-left: 5px;"><html:text  property="ftw"  style="width: 180px; text-align: right;" styleId="dtFtwId" disabled="${driverTrainingForm.transactionStatus}"></html:text></td>
									</tr>
									<tr style="height: 5px;" ></tr>
									<tr>
										<td>NBI</td>
                                        <td style="padding-left: 5px;"><html:text  property="nbi"  style="width: 180px; text-align: right;" styleId="dtNbiId" disabled="${driverTrainingForm.transactionStatus}"></html:text></td>
									</tr>
									<tr style="height: 5px;" ></tr>								
								 	<tr>
                                        <td>Terminal</td>
                                        <td style="padding-left: 5px;">
  								 			<html:select  styleId="terminalIdId" style="width: 180px; height: 22px;"  name="driverTrainingForm" property="terminalId" disabled="${driverTrainingForm.transactionStatus}">
								 				<html:option value="0">--Select--</html:option>
								 				<html:optionsCollection name="driverTrainingForm" property="terminalList" label="name" value="id"/>				 		
								 			</html:select>
								 		</td>
                                    </tr>
                                    <tr style="height: 5px;" ></tr>
									<tr>
                                        <td>Articulated</td>
                                        <td style="padding-left: 5px;">
                                       		<html:select  styleId="articulatedId" style="width: 180px; height: 22px;"  name="driverTrainingForm" property="articulated" disabled="${driverTrainingForm.transactionStatus}">
								 				<html:option value="">--Select--</html:option>
								 				<html:option value="Rigid">Rigid</html:option>
								 				<html:option value="Trailer">Trailer</html:option>			 		
								 			</html:select>
								 		</td>
                                    </tr>
                                    <tr style="height: 5px;" ></tr>
                                </table>
																	 
							<!-- buttons -->
							 <br>			 
							 <div class="control-group">
							 	 <div class="controls">
									<c:choose>	
										<c:when test="${driverTrainingForm.transactionStatus == true}">
											<html:button property="btnClose" styleClass="btn btn-primary" onclick="goToDriverTraining();" value="Close"></html:button>
										</c:when>
										<c:otherwise>
											<html:button property="btnUpdate" styleClass="btn btn-primary" onclick="updateDriverTraining();" value="Update"></html:button>
											&nbsp;&nbsp;<html:button property="btnCancel" styleClass="btn btn-primary" onclick="goToDriverTraining();" value="Cancel"></html:button>
										</c:otherwise>
									</c:choose>					 	 
							 	 </div>
							 	 
							 </div>
							 <br>
		
					</div>
				</fieldset>				

			</html:form>
</div>
	