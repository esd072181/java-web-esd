<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

	<div class="table-responsive" style="padding-left: 10px;">
		<!-- Employee -->
		<c:if test="${archiveForm.employeeList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%;">  
				<tr>
					<th>Id</th>
					<th>Last Name</th>
					<th>First Name</th>
					<th>Middle Name</th>
					<th>Category</th>
					<th></th>
				</tr>
				<logic:iterate name="archiveForm" property="employeeList" type="com.transport.model.Employee" id="model">
					<tr>				 
						<%--<td><bean:write name="resultsId" property="id"/><bean:message key="Building.Id"/></td>--%>
						<td><bean:write name="model" property="id"/></td>
						<td><bean:write name="model" property="lastName"/></td>	
						<td><bean:write name="model" property="firstName"/></td>
						<td><bean:write name="model" property="middleName"/></td>
						<td><bean:write name="model" property="empCategory"/></td>
						<td align="center"><a href="#" onclick="javascript: restoreEntity('<bean:write name="model" property="id"/>',${archiveForm.currentPage})">Restore</a></td>	
					</tr>
				</logic:iterate>
			</table>
		</c:if>
		<!-- Lorry -->
		<c:if test="${archiveForm.lorryList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%;">  
				<tr>					
					<th>Id</th>
					<th>Lorry No</th>
					<th>Plate No</th>
					<th>Trailer No</th>
					<th></th>
				</tr>
				<logic:iterate name="archiveForm" property="lorryList" type="com.transport.model.Lorry" id="model">
					<tr>				 
						<%--<td><bean:write name="resultsId" property="id"/><bean:message key="Building.Id"/></td>--%>
						<td><bean:write name="model" property="id"/></td>
						<td><bean:write name="model" property="lorryNo"/></td>	
						<td><bean:write name="model" property="plateNo"/></td>
						<td><bean:write name="model" property="trailerNo"/></td>
						<td align="center"><a href="#" onclick="javascript: restoreEntity('<bean:write name="model" property="id"/>',${archiveForm.currentPage})">Restore</a></td>		
					</tr>
				</logic:iterate>
			</table>
		</c:if>
		<!-- Items -->
		<c:if test="${archiveForm.itemsList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%;">  
				<tr>
					<th>Id</th>
					<th>Description</th>
					<th></th>
				</tr>
				<logic:iterate name="archiveForm" property="itemsList" type="com.transport.model.Items" id="model">
					<tr>				 
						<%--<td><bean:write name="resultsId" property="id"/><bean:message key="Building.Id"/></td>--%>
						<td><bean:write name="model" property="id"/></td>
						<td><bean:write name="model" property="description"/></td>
						<td align="center"><a href="#" onclick="javascript: restoreEntity('<bean:write name="model" property="id"/>',${archiveForm.currentPage})">Restore</a></td>
					</tr>
				</logic:iterate>
			</table>
		</c:if>
		<!-- Corrective Actions -->
		<c:if test="${archiveForm.correctionsList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%;">  
				<tr>
					<th>Id</th>
					<th>Description</th>
					<th></th>
				</tr>
				<logic:iterate name="archiveForm" property="correctionsList" type="com.transport.model.Corrections" id="model">
					<tr>				 
						<%--<td><bean:write name="resultsId" property="id"/><bean:message key="Building.Id"/></td>--%>
						<td><bean:write name="model" property="id"/></td>
						<td><bean:write name="model" property="description"/></td>
						<td align="center"><a href="#" onclick="javascript: restoreEntity('<bean:write name="model" property="id"/>',${archiveForm.currentPage})">Restore</a></td>
					</tr>
				</logic:iterate>
			</table>
		</c:if>	
		<!-- Follow Up -->
		<c:if test="${archiveForm.followUpList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%;">  
				<tr>
					<th>Id</th>
					<th>Description</th>
					<th></th>
				</tr>
				<logic:iterate name="archiveForm" property="followUpList" type="com.transport.model.FollowUp" id="model">
					<tr>				 
						<%--<td><bean:write name="resultsId" property="id"/><bean:message key="Building.Id"/></td>--%>
						<td><bean:write name="model" property="id"/></td>
						<td><bean:write name="model" property="description"/></td>
						<td align="center"><a href="#" onclick="javascript: restoreEntity('<bean:write name="model" property="id"/>',${archiveForm.currentPage})">Restore</a></td>
					</tr>
				</logic:iterate>
			</table>
		</c:if>			
	
			<!-- Remarks -->
		<c:if test="${archiveForm.remarksList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%;">  
				<tr>
					<th>Id</th>
					<th>Description</th>
					<th></th>
				</tr>
				<logic:iterate name="archiveForm" property="remarksList" type="com.transport.model.Remarks" id="model">
					<tr>				 
						<%--<td><bean:write name="resultsId" property="id"/><bean:message key="Building.Id"/></td>--%>
						<td><bean:write name="model" property="id"/></td>
						<td><bean:write name="model" property="description"/></td>
						<td align="center"><a href="#" onclick="javascript: restoreEntity('<bean:write name="model" property="id"/>',${archiveForm.currentPage})">Restore</a></td>
					</tr>
				</logic:iterate>
			</table>
		</c:if>	

		<!-- Terminal -->
		<c:if test="${archiveForm.terminalList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%;">  
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th></th>
				</tr>
				<logic:iterate name="archiveForm" property="terminalList" type="com.transport.model.Terminal" id="model">
					<tr>				 
						<%--<td><bean:write name="resultsId" property="id"/><bean:message key="Building.Id"/></td>--%>
						<td><bean:write name="model" property="id"/></td>
						<td><bean:write name="model" property="name"/></td>
						<td align="center"><a href="#" onclick="javascript: restoreEntity('<bean:write name="model" property="id"/>',${archiveForm.currentPage})">Restore</a></td>
					</tr>
				</logic:iterate>
			</table>
		</c:if>	
				
		<!-- User -->
		<c:if test="${archiveForm.userList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%;">  
				<tr>
					<th>Id</th>
					<th>Employee Name</th>
					<th>Role</th>
					<th>User Name</th>
					<th></th>
				</tr>
				<logic:iterate name="archiveForm" property="userList" type="com.transport.model.User" id="model">
					<tr>				 
						<%--<td><bean:write name="resultsId" property="id"/><bean:message key="Building.Id"/></td>--%>
						<td><bean:write name="model" property="id"/></td>
						<td><bean:write name="model" property="name"/></td>
						<td><bean:write name="model" property="role"/></td>
						<td><bean:write name="model" property="userName"/></td>
						<td align="center"><a href="#" onclick="javascript: restoreEntity('<bean:write name="model" property="id"/>',${archiveForm.currentPage})">Restore</a></td>	
					</tr>
				</logic:iterate>
			</table>
		</c:if>	
		
		<!-- Findings -->
		<c:if test="${archiveForm.findingsList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%;">  
				<tr>
					<th>Id</th>
					<th>Description</th>
					<th></th>
				</tr>
				<logic:iterate name="archiveForm" property="findingsList" type="com.transport.model.Findings" id="model">
					<tr>				 
						<%--<td><bean:write name="resultsId" property="id"/><bean:message key="Building.Id"/></td>--%>
						<td><bean:write name="model" property="id"/></td>
						<td><bean:write name="model" property="description"/></td>
						<td align="center"><a href="#" onclick="javascript: restoreEntity('<bean:write name="model" property="id"/>',${archiveForm.currentPage})">Restore</a></td>
					</tr>
				</logic:iterate>
			</table>
		</c:if>	
						
		<!-- Verification and Validation Compliance Tracker -->
		<c:if test="${archiveForm.verificationList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%; font-size: xx-small;">  
				<tr>
					<th colspan="10" ><div align="center">VERIFICATION</div></th>
					<th colspan="8" ><div align="center">VALIDATION</div></th>
					<th></th>
					<th></th>
				</tr>
				<tr>
					<th>Id</th>
					<th>Item</th>
					<th>Findings</th>
					<th>Driver</th>
					<th>Terminal</th>
					<th>LorryNo</th>
					<th>TrailerNo</th>
					<th>Date</th>
					<th>Corrective</th>
					<th>CheckedBy</th>
					<th>FollowUp</th>
					<th>Driver</th>
					<th>Terminal</th>
					<th>LorryNo</th>
					<th>TrailerNo</th>
					<th>Date</th>
					<th>CheckedBy</th>
					<th>Remarks</th>
					<th>RootCause</th>
					<th></th>	
				</tr>
				<logic:iterate name="archiveForm" property="verificationList" type="com.transport.model.VerificationAndValidation" id="model">
					<tr>				 
						<%--<td><bean:write name="resultsId" property="id"/><bean:message key="Building.Id"/></td>--%>
						<td><bean:write name="model" property="id"/></td>
						<td><bean:write name="model" property="item"/></td>
						<td><bean:write name="model" property="findings"/></td>
						<td><bean:write name="model" property="driver"/></td>	
						<td><bean:write name="model" property="terminal"/></td>
						<td><bean:write name="model" property="lorry"/></td>
						<td><bean:write name="model" property="trailer"/></td>	
						<td><bean:write name="model" property="verificationDateStr"/></td>	
						<td><bean:write name="model" property="corrections"/></td>	
						<td><bean:write name="model" property="verificationCheckedBy"/></td>	
						<td><bean:write name="model" property="followUp"/></td>
						<td><bean:write name="model" property="driverValidation"/></td>	
						<td><bean:write name="model" property="terminalValidation"/></td>
						<td><bean:write name="model" property="lorryValidation"/></td>
						<td><bean:write name="model" property="trailerValidation"/></td>	
						<td><bean:write name="model" property="validationDateStr"/></td>
						<td><bean:write name="model" property="validationCheckedBy"/></td>
						<td><bean:write name="model" property="remarks"/></td>
						<td><bean:write name="model" property="rootCause"/></td>
						<td align="center"><a href="#" onclick="javascript: restoreEntity('<bean:write name="model" property="id"/>',${archiveForm.currentPage})">Restore</a></td>
					</tr>
				</logic:iterate>
			</table>
		</c:if>			
		
		<!-- Root Cause -->
		<c:if test="${archiveForm.rootCauseList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%;">  
				<tr>
					<th>Id</th>
					<th>Description</th>
					<th></th>
				</tr>
				<logic:iterate name="archiveForm" property="rootCauseList" type="com.transport.model.RootCause" id="model">
					<tr>				 
						<%--<td><bean:write name="resultsId" property="id"/><bean:message key="Building.Id"/></td>--%>
						<td><bean:write name="model" property="id"/></td>
						<td><bean:write name="model" property="description"/></td>
						<td align="center"><a href="#" onclick="javascript: restoreEntity('<bean:write name="model" property="id"/>',${archiveForm.currentPage})">Restore</a></td>
						</tr>
				</logic:iterate>
			</table>
		</c:if>
		
		<!-- Closure -->
		<c:if test="${archiveForm.closureList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%;">  
				<tr>
					<th>Id</th>
					<th>Closure Description</th>
					<th>Corrective Actions</th>
					<th></th>
				</tr>
				<logic:iterate name="archiveForm" property="closureList" type="com.transport.model.Closure" id="model">
					<tr>				 
						<%--<td><bean:write name="resultsId" property="id"/><bean:message key="Building.Id"/></td>--%>
						<td><bean:write name="model" property="id"/></td>
						<td><bean:write name="model" property="description"/></td>
						<td><bean:write name="model" property="corrections"/></td>
						<td align="center"><a href="#" onclick="javascript: restoreEntity('<bean:write name="model" property="id"/>',${archiveForm.currentPage})">Restore</a></td>
					</tr>
				</logic:iterate>
			</table>
		</c:if>

		<!-- Work Permit -->
		<c:if test="${archiveForm.workPermitList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%; font-size: xx-small;">  
				<tr>
					<th>Permit No</th>
					<th>Plate No</th>
					<th>Lorry No</th>
					<th>Item Repair</th>
					<th>Item Replace</th>
					<th>Gas Free</th>
					<th>Hot Work</th>
					<th>Mechanic</th>
					<th>Permit Issuer</th>
					<th>Date Started</th>
					<th>Time Started</th>
					<th>Date Ended</th>
					<th>Time Ended</th>
					<th>Rescue</th>
					<th>Odometer</th>
					<th>Hub</th>
					<th>Transport</th>
					<th></th>
				</tr>
				<logic:iterate name="archiveForm" property="workPermitList" type="com.transport.model.WorkPermit" id="model">
					<tr>				 
						<%--<td><bean:write name="resultsId" property="id"/><bean:message key="Building.Id"/></td>--%>
						<td align="right"><bean:write name="model" property="permitNo"/></td>
						<td><bean:write name="model" property="plateNo"/></td>
						<td align="right"><bean:write name="model" property="lorryNo"/></td>
						<td><bean:write name="model" property="itemRepair"/></td>
						<td><bean:write name="model" property="itemReplace"/></td>	
						<td><bean:write name="model" property="gasFree"/></td>
						<td><bean:write name="model" property="hotWork"/></td>
						<td><bean:write name="model" property="mechanic"/></td>	
						<td><bean:write name="model" property="permitIssuer"/></td>	
						<td><bean:write name="model" property="dateStarted" format='MM/dd/yyyy'/></td>
						<td><bean:write name="model" property="timeStarted"/></td>	
						<td><bean:write name="model" property="dateEnded" format='MM/dd/yyyy'/></td>
						<td><bean:write name="model" property="timeEnded"/></td>
						<td><bean:write name="model" property="rescue"/></td>
						<td align="right"><bean:write name="model" property="odometer"/></td>
						<td align="right"><bean:write name="model" property="hub"/></td>
						<td><bean:write name="model" property="transport"/></td>
						<td align="center"><a href="#" onclick="javascript: restoreEntity('<bean:write name="model" property="id"/>',${archiveForm.currentPage})">Restore</a></td>
					</tr>
				</logic:iterate>
			</table>		
		</c:if>
				
		<!--Driver Training and Information  -->
		  <c:if test="${archiveForm.driverTrainingList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%; font-size: xx-small;">  
				<tr>
					<th>Full Name</th>
					<th>SSS No</th>
					<th>Pagibig No</th>
					<th>TIN</th>
					<th>Driver Picture</th>
					<th>Terminal</th>
					<th>Articulated</th>
					<th>Age</th>
					<th></th>
				</tr>
				<logic:iterate name="archiveForm" property="driverTrainingList" type="com.transport.model.DriverTraining" id="model">
					<tr>				 
						<td><bean:write name="model" property="fullName"/></td>
						<td align="right"><bean:write name="model" property="sss" format='MM/dd/yyyy'/></td>
						<td align="right"><bean:write name="model" property="pagibig" format='MM/dd/yyyy'/></td>
						<td align="right"><bean:write name="model" property="tin" format='MM/dd/yyyy'/></td>
						<td><html:image src="data:image/jpeg;base64,${model.picStr}" alt="" style="width: 50px; height: 60px; pointer-events: none;"></html:image></td>		
						<td><bean:write name="model" property="terminalName"/></td>	
						<td><bean:write name="model" property="articulated"/></td>
						<c:choose>
							<c:when test="${model.age > 0}">
								<td align="right"><bean:write name="model" property="age"/></td>	
							</c:when>
							<c:otherwise>
							    <td></td>
							</c:otherwise>
						</c:choose>
						<td align="center"><a href="#" onclick="javascript: restoreEntity('<bean:write name="model" property="id"/>',${archiveForm.currentPage})">Restore</a></td>	
					</tr>
				</logic:iterate>
			</table>
		  </c:if>
		  
		  <!--Driver Incident  -->
		  <c:if test="${archiveForm.driverIncidentList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%; font-size: xx-small;">  
				<tr>
					<th>Incident Date</th>
					<th>Name (Position)</th>
					<th>Name (Position)</th>
					<th>Acknowledge..</th>
					<th>Report..</th>
					<th>Company..</th>
					<th>INCAB Footages..</th>
					<th>DWH / PSWM</th>
					<th>GPS Data</th>
					<th>EB Button</th>
					<th>Alcohol..</th>
					<th>Drivers..</th>
					<th>Police..</th>
					<th>Photo Copy of..</th>
					<th>Pic of Damage..</th>
					<th>Pic of Plate..</th>
					<th>Start Discussion..</th>
					<th>With Investigating..</th>
					<th>Prior to..</th>
					<th></th>
				</tr>
				<logic:iterate name="archiveForm" property="driverIncidentList" type="com.transport.model.DriverIncident" id="model">
					<tr>			 
						<td><bean:write name="model" property="incidentDate" format='MM/dd/yyyy'/></td>
						<td><bean:write name="model" property="nameOne"/> (<bean:write name="model" property="positionOne" />)</td>
						<td><bean:write name="model" property="nameTwo"/> (<bean:write name="model" property="positionTwo" />)</td>
						<td><bean:write name="model" property="acknowStat" /> - <bean:write name="model" property="acknowRemarks" /></td>
						<td><bean:write name="model" property="reportStat" /> - <bean:write name="model" property="reportRemarks" /></td>
						<td><bean:write name="model" property="companyStat" /> - <bean:write name="model" property="companyRemarks" /></td>
						<td><bean:write name="model" property="incabStat" /> - <bean:write name="model" property="incabRemarks" /></td>
						<td><bean:write name="model" property="dwhStat" /> - <bean:write name="model" property="dwhRemarks" /></td>
						<td><bean:write name="model" property="gpsStat" /> - <bean:write name="model" property="gpsRemarks" /></td>
						<td><bean:write name="model" property="ebStat" /> - <bean:write name="model" property="ebRemarks" /></td>
						<td><bean:write name="model" property="alcoholStat" /> - <bean:write name="model" property="alcoholRemarks" /></td>
						<td><bean:write name="model" property="driversStat" /> - <bean:write name="model" property="driversRemarks" /></td>
						<td><bean:write name="model" property="policeStat" /> - <bean:write name="model" property="policeRemarks" /></td>
						<td><bean:write name="model" property="photoStat" /> - <bean:write name="model" property="photoRemarks" /></td>
						<td><bean:write name="model" property="picDamageStat" /> - <bean:write name="model" property="picDamageRemarks" /></td>
						<td><bean:write name="model" property="picPlateStat" /> - <bean:write name="model" property="picPlateRemarks" /></td>
						<td><bean:write name="model" property="startStat" /> - <bean:write name="model" property="startRemarks" /></td>
						<td><bean:write name="model" property="withInvestStat" /> - <bean:write name="model" property="withInvestRemarks" /></td>
						<td><bean:write name="model" property="priorStat" /> - <bean:write name="model" property="priorRemarks" /></td>
						<td align="center"><a href="#" onclick="javascript: restoreEntity('<bean:write name="model" property="id"/>',${archiveForm.currentPage})">Restore</a></td>
					</tr>
				</logic:iterate>
			</table>
		  </c:if>
		  
		  <!-- Maintenance Inspection -->
		  <c:if test="${archiveForm.inspectionHeaderList != null}">
		  
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%; font-size: xx-small;">  
				<tr>
					<th>InspectionDate</th>
					<th>LorryNo</th>
					<th>PlateNo</th>
					<th>Odometer</th>
					<th>HubOdometer</th>
					<th>Inspectors</th>
					<th>ForAnnual</th>
					<th>ForPM</th>
					<th>Remarks</th>
					<th></th>
				</tr>
				<logic:iterate name="archiveForm" property="inspectionHeaderList" type="com.transport.model.InspectionHeader" id="model">
					<tr>
						<td><bean:write name="model" property="inspectionDate" format='MM/dd/yyyy'/></td>
						<td><bean:write name="model" property="lorryNo"/></td>
						<td><bean:write name="model" property="plateNo"/></td>
						<td><bean:write name="model" property="odometer"/></td>
						<td><bean:write name="model" property="hubOdometer"/></td>	
						<td><bean:write name="model" property="inspectors"/></td>
						<td><bean:write name="model" property="forAnnual"/></td>
						<td><bean:write name="model" property="forPm"/></td>	
						<td><bean:write name="model" property="remarks"/></td>
						<td align="center"><a href="#" onclick="javascript: restoreEntity('<bean:write name="model" property="id"/>',${archiveForm.currentPage})">Restore</a></td>
					</tr>
				</logic:iterate>
			</table>
		  </c:if>


				
	</div>
	
	<div style="height: 50px; width: 98%;">
		<div style="position: relative; top: -15px; float: left;">
			<ul class="pager">
				<c:if test="${archiveForm.currentPage != 1 && archiveForm.noOfPages > 0}">
					<li><a href="#" onclick="getArchive(${archiveForm.currentPage - 1});">Previous</a></li>
				</c:if>
				<c:if test="${archiveForm.currentPage lt archiveForm.noOfPages}">
				  	<li><a href="#" onclick="getArchive(${archiveForm.currentPage + 1});">Next</a></li>
				</c:if>
			</ul>
		</div>
		<div style="position: relative; top: -15px; float: right;" >
			<ul class="pagination">
			
				<c:if test="${archiveForm.currentPage != 1 && archiveForm.noOfPages > 0}">
					<li><a href="#" onclick="getArchive(${archiveForm.currentPage - 1});">&laquo;</a></li>
				</c:if>
					
				<c:forEach begin="1" end="${archiveForm.noOfPages}" var="i">
	                <c:choose>
	                    <c:when test="${archiveForm.currentPage eq i}">
	                        <li class="active"><a href="#">${i}</a></li>
	                    </c:when>
	                    <c:otherwise>
	                         <li><a href="#" onclick="getArchive(${i});">${i}</a></li>
	                    </c:otherwise>
	                </c:choose>
	            </c:forEach>
	           	<c:if test="${archiveForm.currentPage lt archiveForm.noOfPages}">
	               	<li><a href="#" onclick="getArchive(${archiveForm.currentPage + 1});">&raquo;</a></li>
	            </c:if>

			</ul>
		</div>
	</div>

