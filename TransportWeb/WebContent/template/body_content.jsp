<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="contentDIV">
	<!-- ajax powered content DIV -->
	<div  align="left" style=" height: 5px;">
		<!-- space only -->
	</div>
	
	<!-- Menu Transaction Icons -->
  		<div style="padding-left: 15px; padding-top: 15px;">
			<table>
				<tr style="padding: 10px 10px 10px 10px;">
		        	<c:forEach items="${sessionScope.user_access_list}" var="item">
		        	    <c:if test="${item == 901}">
		        	    	<td align="center">
		    					<img onclick="goToVerificationAndValidation();" src="resources/vnv.jpg" alt="Verification and Validation Compliance of Tracker" height="100" width="100">	
		    				</td>
		    				<td width="30px"></td>	
		    			</c:if>
		        		<c:if test="${item == 902}">
		    				<td align="center">
		    					<img onclick="goToWorkPermit();" src="resources/workpermit.jpg" alt="Work Permit" height="100" width="100">	
		    				</td>
		    				<td width="30px"></td>		        		
		        		</c:if>
		      			<c:if test="${item == 922}">
		      				<td align="center">
		    					<img onclick="goToMaintenanceMonitoring();" src="resources/maintenance.jpg" alt="Maintenance Monitoring" height="100" width="100">	
		    				</td>
		    				<td width="30px"></td>	
		    			</c:if>
		    			<c:if test="${item == 924}">
		    				<c:choose>
		    					<c:when test="${sessionScope.user_role_session=='Driver'}">
		  							<td align="center">
										<img onclick="viewDriverTrainingSummaryForDriver('${sessionScope.user_emp_id_session}');" src="resources/driver.png" alt="Driver Training and Information" height="100" width="100">	
									</td>
									<td width="30px"></td>	    					
								</c:when>
		    					<c:otherwise> 
		    						<td align="center">
		    							<img onclick="goToDriverTraining();" src="resources/driver.png" alt="Driver Training and Information" height="100" width="100">	
		    						</td>
		    						<td width="30px"></td> 
		    					</c:otherwise>
		    				</c:choose>
		    			</c:if>
		    			<c:if test="${item == 927}">
		      				<td align="center">
		    					<img onclick="goToDriverIncident();" src="resources/driver_incident.png" alt="Driver Incident" height="100" width="100">	
		    				</td>
		    				<td width="30px"></td>	
		    			</c:if>
		    			<c:if test="${item == 928}">
		      				<td align="center">
		    					<img onclick="goToMaintenanceInspection();" src="resources/inspection_checklist.png" alt="Maintenance Inspection Checklist" height="100" width="100">	
		    				</td>
		    				<td width="30px"></td>	
		    			</c:if>
					</c:forEach>				
				</tr>
				<tr>
		        	<c:forEach items="${sessionScope.user_access_list}" var="item">
		        		<c:if test="${item == 901}">
		        			<td align="center"><a href="#" onclick="goToVerificationAndValidation();">V and V Compliance of Tracker</a></td>
							<td width="30px"></td>	
		        		</c:if>
		        	    <c:if test="${item == 902}">
		    				<td align="center"><a href="#" onclick="goToWorkPermit();">Work Permit</a></td>
							<td width="30px"></td>	
		    			</c:if>
		    			<c:if test="${item == 922}">
		    				<td align="center"><a href="#" onclick="goToMaintenanceMonitoring();">Maintenance Monitoring</a></td>
							<td width="30px"></td>	
		    			</c:if>
		    			<c:if test="${item == 924}">
		    				<c:choose>
		    					<c:when test="${sessionScope.user_role_session=='Driver'}">
									<td align="center"><a href="#" onclick="viewDriverTrainingSummaryForDriver('${sessionScope.user_emp_id_session}');">Driver Training and Information</a></td>
									<td width="30px"></td>    					
								</c:when>
		    					<c:otherwise>
		    						<td align="center"><a href="#" onclick="goToDriverTraining();">Driver Training and Information</a></td>
									<td width="30px"></td>		    					
								</c:otherwise>
		    				</c:choose>
		    			</c:if>
		    			<c:if test="${item == 927}">
		    				<td align="center"><a href="#" onclick="goToDriverIncident();">Driver Incident</a></td>
							<td width="30px"></td>	
		    			</c:if>
		    			<c:if test="${item == 928}">
		    				<td align="center"><a href="#" onclick="goToMaintenanceInspection();">Maintenance Inspection Checklist</a></td>
							<td width="30px"></td>	
		    			</c:if>
					</c:forEach>					
				</tr>
			</table> 
  		</div>


		<div align="center">
			<div id="tablePresentationDIV">
			<!-- ajax part of table data -->
			</div>
		</div>
		
		<!-- Reminder from Verification and Validation -->
		<c:if test="${sessionScope.user_role_session!='Driver'}">
			  <script>
				getReminders(1);
			</script>		
		</c:if>	

	
</div>