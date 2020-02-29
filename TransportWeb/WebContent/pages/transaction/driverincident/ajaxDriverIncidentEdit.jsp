<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
$(function() {
    $('#dtIncidentDateId').datepicker({}); 
    $('#dtIncidentDateId').attr('placeholder','mm/dd/yyyy'); 
    
    $('#acknowStatIdYes').focus();
  });
 
</script>


<div style="padding-left: 10px;">

		<div style="height: 30%;">
			<h3 style="font-weight: bolder;">Driver Incident - Edit Record</h3>
			<html:form action="/driverIncident.do" styleId="idForm"  >
				<fieldset>
				
				<div>
					<html:errors/>
				</div>
				<div>
					<h4 style="color: blue;"><c:out value="${driverIncidentForm.transactionMessage}"></c:out></h4>
					<c:if test="${driverIncidentForm.transactionStatus == true}">
						<html:button property="btnClose" styleClass="btn btn-primary" onclick="goToDriverIncident();" value="Close"></html:button>
						<br>
					</c:if>
				</div>
				
				<div style="width: 100%; font-size: small;"> <!-- table -->
				
				
				<html:hidden name="driverIncidentForm" property="id"/>
				
                           	<table border="1">
								 	<tr style="height: 5px;" ></tr>
									<tr>
										<td></td>
										<td align="center" style="font-weight: bolder; color: white; background-color: black; font-size: 16px;">INVESTIGATION CHECKLIST</td>
										<td colspan="3"></td>
									</tr>
									<tr>
										<td></td>
										<td align="center" style="font-weight: bolder;">METHOD OF INVESTIGATION</td>
										<td colspan="2" align="center" style="font-weight: bolder;">STATUS</td>
										<td align="center" style="font-weight: bolder;">REMARKS</td>
									</tr>
									<tr>
										<td class="paddingtd" style="color: white; background-color: black;">STEP 1</td>
										<td class="paddingtd">ACKNOWLEDGE THE NOTIFICATION AND PREPARATION</td>
										<c:choose>
											<c:when test="${driverIncidentForm.acknowStat == 'YES'}">
												<td class="paddingtd">
													<input type="radio" id="acknowStatIdYes" name="acknowStat" onclick="toggleOption(1, this, $('#acknowStatIdNo'));" value="YES" checked="checked">YES
												</td>
												<td class="paddingtd">
													<input type="radio" id="acknowStatIdNo" name="acknowStat" onclick="toggleOption(2, $('#acknowStatIdYes'), this);" value="NO" >NO
												</td>					
											</c:when>
											<c:otherwise>
												<td class="paddingtd">
													<input type="radio" id="acknowStatIdYes" name="acknowStat" onclick="toggleOption(1, this, $('#acknowStatIdNo'));" value="YES" >YES
												</td>
												<td class="paddingtd">
													<input type="radio" id="acknowStatIdNo" name="acknowStat" onclick="toggleOption(2, $('#acknowStatIdYes'), this);" value="NO" checked="checked">NO
												</td>											
											</c:otherwise>
										</c:choose>
										<td class="paddingtd"><html:text size="80px" property="acknowRemarks"></html:text></td>
									</tr>
									<tr>
										<td></td>
										<td class="paddingtd">REPORT A LOSS/ NEAR LOSS</td>
										<c:choose>
											<c:when test="${driverIncidentForm.reportStat == 'YES'}">
												<td class="paddingtd">
													<input type="radio" id="reportStatIdYes" name="reportStat" onclick="toggleOption(1, this, $('#reportStatIdNo'));" value="YES" checked="checked">YES
												</td>
												<td class="paddingtd">
													<input type="radio" id="reportStatIdNo" name="reportStat" onclick="toggleOption(2, $('#reportStatIdYes'), this);" value="NO" >NO
												</td>					
											</c:when>
											<c:otherwise>
												<td class="paddingtd">
													<input type="radio" id="reportStatIdYes" name="reportStat" onclick="toggleOption(1, this, $('#reportStatIdNo'));" value="YES" >YES
												</td>
												<td class="paddingtd">
													<input type="radio" id="reportStatIdNo" name="reportStat" onclick="toggleOption(2, $('#reportStatIdYes'), this);" value="NO" checked="checked">NO
												</td>											
											</c:otherwise>
										</c:choose>
										<td class="paddingtd"><html:text size="80px" property="reportRemarks"></html:text></td>									
									</tr>
									<tr>
										<td class="paddingtd" style="color: white; background-color: black;">STEP 2</td>
										<td class="paddingtd">COMPANY REPRESENTATIVE WILL RESPOND TO THE INCIDENT <br> SITE AS APPLICABLE FOR LOSS AND RISK ASSESSMENT</td>
										<c:choose>
											<c:when test="${driverIncidentForm.companyStat == 'YES'}">
												<td class="paddingtd">
													<input type="radio" id="companyStatIdYes" name="companyStat" onclick="toggleOption(1, this, $('#companyStatIdNo'));" value="YES" checked="checked">YES
												</td>
												<td class="paddingtd">
													<input type="radio" id="companyStatIdNo" name="companyStat" onclick="toggleOption(2, $('#companyStatIdYes'), this);" value="NO" >NO
												</td>					
											</c:when>
											<c:otherwise>
												<td class="paddingtd">
													<input type="radio" id="companyStatIdYes" name="companyStat" onclick="toggleOption(1, this, $('#companyStatIdNo'));" value="YES" >YES
												</td>
												<td class="paddingtd">
													<input type="radio" id="companyStatIdNo" name="companyStat" onclick="toggleOption(2, $('#companyStatIdYes'), this);" value="NO" checked="checked">NO
												</td>											
											</c:otherwise>
										</c:choose>
										<td class="paddingtd"><html:text size="80px" property="companyRemarks"></html:text></td>									
									</tr>									
									<tr>
										<td class="paddingtd" style="color: white; background-color: black;">STEP 3</td>
										<td colspan="4" style="color: red; background-color: black;">GATHERING DATAS</td>
									</tr>
									<tr>
										<td></td>
										<td class="paddingtd">INCAB FOOTAGES</td>
										<c:choose>
											<c:when test="${driverIncidentForm.incabStat == 'YES'}">
												<td class="paddingtd">
													<input type="radio" id="incabStatIdYes" name="incabStat" onclick="toggleOption(1, this, $('#incabStatIdNo'));" value="YES" checked="checked">YES
												</td>
												<td class="paddingtd">
													<input type="radio" id="incabStatIdNo" name="incabStat" onclick="toggleOption(2, $('#incabStatIdYes'), this);" value="NO" >NO
												</td>					
											</c:when>
											<c:otherwise>
												<td class="paddingtd">
													<input type="radio" id="incabStatIdYes" name="incabStat" onclick="toggleOption(1, this, $('#incabStatIdNo'));" value="YES" >YES
												</td>
												<td class="paddingtd">
													<input type="radio" id="incabStatIdNo" name="incabStat" onclick="toggleOption(2, $('#incabStatIdYes'), this);" value="NO" checked="checked">NO
												</td>											
											</c:otherwise>
										</c:choose>
										<td class="paddingtd"><html:text size="80px" property="incabRemarks"></html:text></td>	
									</tr>
									<tr>
										<td></td>
										<td class="paddingtd">DWH / PSWM</td>
										<c:choose>
											<c:when test="${driverIncidentForm.dwhStat == 'YES'}">
												<td class="paddingtd">
													<input type="radio" id="dwhStatIdYes" name="dwhStat" onclick="toggleOption(1, this, $('#dwhStatIdNo'));" value="YES" checked="checked">YES
												</td>
												<td class="paddingtd">
													<input type="radio" id="dwhStatIdNo" name="dwhStat" onclick="toggleOption(2, $('#dwhStatIdYes'), this);" value="NO" >NO
												</td>					
											</c:when>
											<c:otherwise>
												<td class="paddingtd">
													<input type="radio" id="dwhStatIdYes" name="dwhStat" onclick="toggleOption(1, this, $('#dwhStatIdNo'));" value="YES" >YES
												</td>
												<td class="paddingtd">
													<input type="radio" id="dwhStatIdNo" name="dwhStat" onclick="toggleOption(2, $('#dwhStatIdYes'), this);" value="NO" checked="checked">NO
												</td>											
											</c:otherwise>
										</c:choose>
										<td class="paddingtd"><html:text size="80px" property="dwhRemarks"></html:text></td>	
									</tr>									
									<tr>
										<td></td>
										<td class="paddingtd">GPS DATA</td>
										<c:choose>
											<c:when test="${driverIncidentForm.gpsStat == 'YES'}">
												<td class="paddingtd">
													<input type="radio" id="gpsStatIdYes" name="gpsStat" onclick="toggleOption(1, this, $('#gpsStatIdNo'));" value="YES" checked="checked">YES
												</td>
												<td class="paddingtd">
													<input type="radio" id="gpsStatIdNo" name="gpsStat" onclick="toggleOption(2, $('#gpsStatIdYes'), this);" value="NO" >NO
												</td>					
											</c:when>
											<c:otherwise>
												<td class="paddingtd">
													<input type="radio" id="gpsStatIdYes" name="gpsStat" onclick="toggleOption(1, this, $('#dwhStatIdNo'));" value="YES" >YES
												</td>
												<td class="paddingtd">
													<input type="radio" id="dwhStatIdNo" name="gpsStat" onclick="toggleOption(2, $('#gpsStatIdYes'), this);" value="NO" checked="checked">NO
												</td>											
											</c:otherwise>
										</c:choose>
										<td class="paddingtd"><html:text size="80px" property="gpsRemarks"></html:text></td>	
									</tr>						
									<tr>
										<td></td>
										<td class="paddingtd">EB BUTTON</td>
										<c:choose>
											<c:when test="${driverIncidentForm.ebStat == 'YES'}">
												<td class="paddingtd">
													<input type="radio" id="ebStatIdYes" name="ebStat" onclick="toggleOption(1, this, $('#ebStatIdNo'));" value="YES" checked="checked">YES
												</td>
												<td class="paddingtd">
													<input type="radio" id="ebStatIdNo" name="ebStat" onclick="toggleOption(2, $('#ebStatIdYes'), this);" value="NO" >NO
												</td>					
											</c:when>
											<c:otherwise>
												<td class="paddingtd">
													<input type="radio" id="ebStatIdYes" name="ebStat" onclick="toggleOption(1, this, $('#ebStatIdNo'));" value="YES" >YES
												</td>
												<td class="paddingtd">
													<input type="radio" id="ebStatIdNo" name="ebStat" onclick="toggleOption(2, $('#ebStatIdYes'), this);" value="NO" checked="checked">NO
												</td>											
											</c:otherwise>
										</c:choose>
										<td class="paddingtd"><html:text size="80px" property="ebRemarks"></html:text></td>	
									</tr>	
									<tr>
										<td></td>
										<td class="paddingtd">ALCOHOL</td>
										<c:choose>
											<c:when test="${driverIncidentForm.alcoholStat == 'YES'}">
												<td class="paddingtd">
													<input type="radio" id="alcoholStatIdYes" name="alcoholStat" onclick="toggleOption(1, this, $('#alcoholStatIdNo'));" value="YES" checked="checked">YES
												</td>
												<td class="paddingtd">
													<input type="radio" id="alcoholStatIdNo" name="alcoholStat" onclick="toggleOption(2, $('#alcoholStatIdYes'), this);" value="NO" >NO
												</td>					
											</c:when>
											<c:otherwise>
												<td class="paddingtd">
													<input type="radio" id="alcoholStatIdYes" name="alcoholStat" onclick="toggleOption(1, this, $('#alcoholStatIdNo'));" value="YES" >YES
												</td>
												<td class="paddingtd">
													<input type="radio" id="alcoholStatIdNo" name="alcoholStat" onclick="toggleOption(2, $('#alcoholStatIdYes'), this);" value="NO" checked="checked">NO
												</td>											
											</c:otherwise>
										</c:choose>
										<td class="paddingtd"><html:text size="80px" property="alcoholRemarks"></html:text></td>	
									</tr>										
									<tr>
										<td></td>
										<td class="paddingtd">DRIVERS HISTORY BASE ON DRIVERS PROFILING</td>
										<c:choose>
											<c:when test="${driverIncidentForm.driversStat == 'YES'}">
												<td class="paddingtd">
													<input type="radio" id="driversStatIdYes" name="driversStat" onclick="toggleOption(1, this, $('#driversStatIdNo'));" value="YES" checked="checked">YES
												</td>
												<td class="paddingtd">
													<input type="radio" id="driversStatIdNo" name="driversStat" onclick="toggleOption(2, $('#driversStatIdYes'), this);" value="NO" >NO
												</td>					
											</c:when>
											<c:otherwise>
												<td class="paddingtd">
													<input type="radio" id="driversStatIdYes" name="driversStat" onclick="toggleOption(1, this, $('#driversStatIdNo'));" value="YES" >YES
												</td>
												<td class="paddingtd">
													<input type="radio" id="driversStatIdNo" name="driversStat" onclick="toggleOption(2, $('#driversStatIdYes'), this);" value="NO" checked="checked">NO
												</td>											
											</c:otherwise>
										</c:choose>
										<td class="paddingtd"><html:text size="80px" property="driversRemarks"></html:text></td>	
									</tr>	
									<tr>
										<td class="paddingtd" style="color: white; background-color: black;">STEP 4</td>
										<td colspan="4" style="color: red; background-color: black;">DOCUMENTS NEEDED</td>
									</tr>									
									<tr>
										<td></td>
										<td class="paddingtd">POLICE REPORT</td>
										<c:choose>
											<c:when test="${driverIncidentForm.policeStat == 'YES'}">
												<td class="paddingtd">
													<input type="radio" id="policeStatIdYes" name="policeStat" onclick="toggleOption(1, this, $('#policeStatIdNo'));" value="YES" checked="checked">YES
												</td>
												<td class="paddingtd">
													<input type="radio" id="policeStatIdNo" name="policeStat" onclick="toggleOption(2, $('#policeStatIdYes'), this);" value="NO" >NO
												</td>					
											</c:when>
											<c:otherwise>
												<td class="paddingtd">
													<input type="radio" id="policeStatIdYes" name="policeStat" onclick="toggleOption(1, this, $('#policeStatIdNo'));" value="YES" >YES
												</td>
												<td class="paddingtd">
													<input type="radio" id="policeStatIdNo" name="policeStat" onclick="toggleOption(2, $('#policeStatIdYes'), this);" value="NO" checked="checked">NO
												</td>											
											</c:otherwise>
										</c:choose>
										<td class="paddingtd"><html:text size="80px" property="policeRemarks"></html:text></td>	
									</tr>										
									<tr>
										<td></td>
										<td class="paddingtd">PHOTO COPY OF DRIVERS LICENSE</td>
										<c:choose>
											<c:when test="${driverIncidentForm.photoStat == 'YES'}">
												<td class="paddingtd">
													<input type="radio" id="photoStatIdYes" name="photoStat" onclick="toggleOption(1, this, $('#photoStatIdNo'));" value="YES" checked="checked">YES
												</td>
												<td class="paddingtd">
													<input type="radio" id="photoStatIdNo" name="photoStat" onclick="toggleOption(2, $('#photoStatIdYes'), this);" value="NO" >NO
												</td>					
											</c:when>
											<c:otherwise>
												<td class="paddingtd">
													<input type="radio" id="photoStatIdYes" name="photoStat" onclick="toggleOption(1, this, $('#photoStatIdNo'));" value="YES" >YES
												</td>
												<td class="paddingtd">
													<input type="radio" id="photoStatIdNo" name="photoStat" onclick="toggleOption(2, $('#photoStatIdYes'), this);" value="NO" checked="checked">NO
												</td>											
											</c:otherwise>
										</c:choose>
										<td class="paddingtd"><html:text size="80px" property="photoRemarks"></html:text></td>	
									</tr>									
									<tr>
										<td></td>
										<td class="paddingtd">PICTURE OF DAMAGE</td>
										<c:choose>
											<c:when test="${driverIncidentForm.picDamageStat == 'YES'}">
												<td class="paddingtd">
													<input type="radio" id="picDamageStatIdYes" name="picDamageStat" onclick="toggleOption(1, this, $('#picDamageStatIdNo'));" value="YES" checked="checked">YES
												</td>
												<td class="paddingtd">
													<input type="radio" id="picDamageStatIdNo" name="picDamageStat" onclick="toggleOption(2, $('#picDamageStatIdYes'), this);" value="NO" >NO
												</td>					
											</c:when>
											<c:otherwise>
												<td class="paddingtd">
													<input type="radio" id="picDamageStatIdYes" name="picDamageStat" onclick="toggleOption(1, this, $('#picDamageStatIdNo'));" value="YES" >YES
												</td>
												<td class="paddingtd">
													<input type="radio" id="picDamageStatIdNo" name="picDamageStat" onclick="toggleOption(2, $('#picDamageStatIdYes'), this);" value="NO" checked="checked">NO
												</td>											
											</c:otherwise>
										</c:choose>
										<td class="paddingtd"><html:text size="80px" property="picDamageRemarks"></html:text></td>	
									</tr>									
									<tr>
										<td></td>
										<td class="paddingtd">PICTURE OF PLATE NUMBER (3RD PARTY)</td>
										<c:choose>
											<c:when test="${driverIncidentForm.picPlateStat == 'YES'}">
												<td class="paddingtd">
													<input type="radio" id="picPlateStatIdYes" name="picPlateStat" onclick="toggleOption(1, this, $('#picPlateStatIdNo'));" value="YES" checked="checked">YES
												</td>
												<td class="paddingtd">
													<input type="radio" id="picPlateStatIdNo" name="picPlateStat" onclick="toggleOption(2, $('#picPlateStatIdYes'), this);" value="NO" >NO
												</td>					
											</c:when>
											<c:otherwise>
												<td class="paddingtd">
													<input type="radio" id="picPlateStatIdYes" name="picPlateStat" onclick="toggleOption(1, this, $('#picPlateStatIdNo'));" value="YES" >YES
												</td>
												<td class="paddingtd">
													<input type="radio" id="picPlateStatIdNo" name="picPlateStat" onclick="toggleOption(2, $('#picPlateStatIdYes'), this);" value="NO" checked="checked">NO
												</td>											
											</c:otherwise>
										</c:choose>
										<td class="paddingtd"><html:text size="80px" property="picPlateRemarks"></html:text></td>	
									</tr>
									<tr>
										<td class="paddingtd" style="color: white; background-color: black;">STEP 5</td>
										<td colspan="4" style="color: red; background-color: black;">COLLECT AND REVIEW ALL EVEDENCES THEN</td>
									</tr>										
									<tr>
										<td></td>
										<td class="paddingtd">START DISCUSSION WITH THE COMMITTEE</td>
										<c:choose>
											<c:when test="${driverIncidentForm.startStat == 'YES'}">
												<td class="paddingtd">
													<input type="radio" id="startStatIdYes" name="startStat" onclick="toggleOption(1, this, $('#startStatIdNo'));" value="YES" checked="checked">YES
												</td>
												<td class="paddingtd">
													<input type="radio" id="startStatIdNo" name="startStat" onclick="toggleOption(2, $('#startStatIdYes'), this);" value="NO" >NO
												</td>					
											</c:when>
											<c:otherwise>
												<td class="paddingtd">
													<input type="radio" id="startStatIdYes" name="startStat" onclick="toggleOption(1, this, $('#startStatIdNo'));" value="YES" >YES
												</td>
												<td class="paddingtd">
													<input type="radio" id="startStatIdNo" name="startStat" onclick="toggleOption(2, $('#startStatIdYes'), this);" value="NO" checked="checked">NO
												</td>											
											</c:otherwise>
										</c:choose>
										<td class="paddingtd"><html:text size="80px" property="startRemarks"></html:text></td>	
									</tr>
									<tr>
										<td class="paddingtd" style="color: white; background-color: black;">STEP 6</td>
										<td colspan="4" style="color: red; background-color: black;">ROOT CAUSE ANALYSIS APPLY FACTORS AND SOLUTION</td>
									</tr>	
									<tr>
										<td></td>
										<td class="paddingtd">WITH INVESTIGATING COMMITTEE</td>
										<c:choose>
											<c:when test="${driverIncidentForm.withInvestStat == 'YES'}">
												<td class="paddingtd">
													<input type="radio" id="withInvestStatIdYes" name="withInvestStat" onclick="toggleOption(1, this, $('#withInvestStatIdNo'));" value="YES" checked="checked">YES
												</td>
												<td class="paddingtd">
													<input type="radio" id="withInvestStatIdNo" name="withInvestStat" onclick="toggleOption(2, $('#withInvestStatIdYes'), this);" value="NO" >NO
												</td>					
											</c:when>
											<c:otherwise>
												<td class="paddingtd">
													<input type="radio" id="withInvestStatIdYes" name="withInvestStat" onclick="toggleOption(1, this, $('#withInvestStatIdNo'));" value="YES" >YES
												</td>
												<td class="paddingtd">
													<input type="radio" id="withInvestStatIdNo" name="withInvestStat" onclick="toggleOption(2, $('#withInvestStatIdYes'), this);" value="NO" checked="checked">NO
												</td>											
											</c:otherwise>
										</c:choose>
										<td class="paddingtd"><html:text size="80px" property="withInvestRemarks"></html:text></td>	
									</tr>
									<tr>
										<td class="paddingtd" style="color: white; background-color: black;">STEP 7</td>
										<td colspan="4" style="color: red; background-color: black;">INCIDENT REPORT/ CLOSURE AND FINAL REVIEW</td>
									</tr>																												
									<tr>
										<td></td>
										<td class="paddingtd">PRIOR TO SUBMISSION</td>
										<c:choose>
											<c:when test="${driverIncidentForm.priorStat == 'YES'}">
												<td class="paddingtd">
													<input type="radio" id="priorStatIdYes" name="priorStat" onclick="toggleOption(1, this, $('#priorStatIdNo'));" value="YES" checked="checked">YES
												</td>
												<td class="paddingtd">
													<input type="radio" id="priorStatIdNo" name="priorStat" onclick="toggleOption(2, $('#priorStatIdYes'), this);" value="NO" >NO
												</td>					
											</c:when>
											<c:otherwise>
												<td class="paddingtd">
													<input type="radio" id="priorStatIdYes" name="priorStat" onclick="toggleOption(1, this, $('#priorStatIdNo'));" value="YES" >YES
												</td>
												<td class="paddingtd">
													<input type="radio" id="priorStatIdNo" name="priorStat" onclick="toggleOption(2, $('#priorStatIdYes'), this);" value="NO" checked="checked">NO
												</td>											
											</c:otherwise>
										</c:choose>
										<td class="paddingtd"><html:text size="80px" property="priorRemarks"></html:text></td>	
									</tr>
									<tr>
										<td class="paddingtd" style="color: white; background-color: black;">STEP 8</td>
										<td colspan="4" style="color: red; background-color: black;">VERIFICATION AND VALIDATION OF SOLUTION</td>
									</tr>									
									<tr>
										<td></td>
										<td colspan="2" style="color: red; background-color: black;">NAME AND SIGNATURE</td>
										<td colspan="2" style="color: red; background-color: black;">NAME AND SIGNATURE</td>
									</tr>
									<tr>
										<td></td>
										<td colspan="2">
										  	<html:select  styleId="nameOneId" style="width: 250px; height: 22px;"  name="driverIncidentForm" property="nameOne" disabled="${driverIncidentForm.transactionStatus}">
								 				<html:option value="">--Select--</html:option>
								 				<html:optionsCollection name="driverIncidentForm" property="driverList" label="fullName2" value="fullName2"/>				 		
								 			</html:select>
								 		</td>
										<td colspan="2">
											<html:select  styleId="nameTwoId" style="width: 350px; height: 22px;"  name="driverIncidentForm" property="nameTwo" disabled="${driverIncidentForm.transactionStatus}">
								 				<html:option value="">--Select--</html:option>
								 				<html:optionsCollection name="driverIncidentForm" property="staffList" label="fullName2" value="fullName2"/>				 		
								 			</html:select>
								 		</td>
									</tr>
									<tr>
										<td></td>
										<td colspan="2" style="color: red; background-color: black;">POSITION</td>
										<td colspan="2" style="color: red; background-color: black;">POSITION</td>
									</tr>
									<tr>
										<td></td>
										<td colspan="2"><html:text size="80px" property="positionOne" value="Driver" readonly="true"></html:text></td>
										<td colspan="2"><html:text size="80px" property="positionTwo" value="Safety Officer" readonly="true"></html:text></td>
									</tr>																																																																							
                                </table>

				<br>

				<div style="padding-left: 5px;">
					<span style="font-weight: bolder;">Incident Date</span>
					<html:text  property="incidentDate" style="width: 180px; text-align: right;" styleId="dtIncidentDateId" disabled="${driverIncidentForm.transactionStatus}"></html:text>
				</div>
																	 
							<!-- buttons -->
							 <br>			 
							 <div class="control-group">
							 	 <div class="controls">
									<c:choose>	
										<c:when test="${driverIncidentForm.transactionStatus == true}">
											<html:button property="btnClose" styleClass="btn btn-primary" onclick="goToDriverIncident();" value="Close"></html:button>
										</c:when>
										<c:otherwise>
											<html:button property="btnUpdate" styleClass="btn btn-primary" onclick="updateDriverIncident();" value="Update"></html:button>
											&nbsp;&nbsp;<html:button property="btnCancel" styleClass="btn btn-primary" onclick="goToDriverIncident();" value="Cancel"></html:button>
										</c:otherwise>
									</c:choose>					 	 
							 	 </div>
							 	 
							 </div>
							 <br>
		
					</div>
				</fieldset>				

			</html:form>
		</div>
	
</div>	
	