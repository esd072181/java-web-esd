<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div>

	<div align="left">
		<html:button property="command" onclick="goBackToMobileMain();" value="Back To Main" styleClass="btn btn-primary" style="font-size: 34px;"></html:button>
	</div>
	<br>
	<div align="left">
		<h4 style="font-family: Tahoma; font-size: 60px; font-weight: bolder;">
			Driver Training and Information
		</h4>
	</div>

	<hr>
	<table>
		<tr>
			<td width="180px" style="padding-left: 5px;">
				<label style="font-family: Tahoma; font-size: 34px;">Name:</label>
			</td>
			<td>
				<label style="font-size: 34px; font-weight: bolder; font: Tahoma; color: blue;">${driverTrainingForm.driverName}</label> 
			</td>			
		</tr>
		<tr>
			<td >
				<label style="font-family: Tahoma; font-size: 34px;">SSS No:</label>
			</td>
			<td>
				<label style="font-size: 34px; font-weight: bolder; font: Tahoma; color: blue;">${driverTrainingForm.sss}</label> 
			</td>
		</tr>
		<tr>
			<td >
				<label style="font-family: Tahoma; font-size: 34px;">Pagibig No:</label>
			</td>
			<td>
				<label style="font-size: 34px; font-weight: bolder; font: Tahoma; color: blue;">${driverTrainingForm.pagibig}</label> 
			</td>
		</tr>
		<tr>
			<td >
				<label style="font-family: Tahoma; font-size: 34px;">TIN:</label>
			</td>
			<td>
				<label style="font-size: 34px; font-weight: bolder; font: Tahoma; color: blue;">${driverTrainingForm.tin}</label> 
			</td>
		</tr>
		<tr>
			<td valign="top" >
				<label style="font-family: Tahoma; font-size: 34px;">Picture:</label>
			</td>
			<td>
				<c:choose>
                    	<c:when test="${driverTrainingForm.picStr!=null}">
                        	<html:image src="data:image/jpeg;base64,${driverTrainingForm.picStr}" alt="" style="width: 250px; height: 250px; pointer-events: none;" border="1px"></html:image>
                        </c:when>
                        <c:otherwise>
                           <span style="font-size: 34px; font-weight: bolder; font: Tahoma; color: blue;">No Picture</span> 
                        </c:otherwise>
                </c:choose>					
                
			</td>
		</tr>
		<tr>
			<td >
				<label style="font-family: Tahoma; font-size: 34px;">Terminal:</label>
			</td>
			<td>
				<label style="font-size: 34px; font-weight: bolder; font: Tahoma; color: blue;">${driverTrainingForm.terminalName}</label>
			</td>
		</tr>
		<tr>
			<td >
				<label style="font-family: Tahoma; font-size: 34px;">Articulated:</label>
			</td>
			<td>
				<label style="font-size: 34px; font-weight: bolder; font: Tahoma; color: blue;">${driverTrainingForm.articulated}</label>
			</td>
		</tr>
		<tr>
			<td >
				<label style="font-family: Tahoma; font-size: 34px;">Birthday:</label>
			</td>
			<td>
				<label style="font-size: 34px; font-weight: bolder; font: Tahoma; color: blue;">${driverTrainingForm.birthday}</label>
			</td>
		</tr>
		<tr>
			<td >
				<label style="font-family: Tahoma; font-size: 34px;">Age:</label>
			</td>
			<td>
				<label style="font-size: 34px; font-weight: bolder; font: Tahoma; color: blue;">${driverTrainingForm.age}</label>
			</td>
		</tr>
	</table>

	<hr>

		<!-- Training Section -->
		<c:choose>
			<c:when test="${driverTrainingForm.trainingList != null && driverTrainingForm.trainingList.size() > 0}">
			<h2 style="font-weight: bold; font-size: 34px;">List of Training</h2>
				<div class="ui-grid-a">
					<div class="ui-block-a">
						<div class="ui-bar ui-bar-a" style="height: 60px; font-size: 26px;">
							Training
						</div>
						<logic:iterate name="driverTrainingForm" property="trainingList" type="com.transport.model.DriverTrainingInfo" id="model">
							<div class="ui-bar ui-bar-a" style="height: 200px; font-size: 26px; background-color: white; font-weight: normal;">
								<bean:write name="model" property="training"/>
							</div>
						</logic:iterate>
					</div>
					<div class="ui-block-b">
						<div class="ui-bar ui-bar-a" style="height: 60px; font-size: 26px;">
							ExpiryDate
						</div>
						<logic:iterate name="driverTrainingForm" property="trainingList" type="com.transport.model.DriverTrainingInfo" id="model">
							<div class="ui-bar ui-bar-a" style="height: 200px; font-size: 26px; background-color: white; font-weight: normal;">
								<bean:write name="model" property="expiryDate" format='MM/dd/yyyy'/>
							</div>
						</logic:iterate>
					</div>			
				</div>			
			
			</c:when>
			<c:otherwise>
				<div style="color: blue;">No training record found!</div>
			</c:otherwise>
		</c:choose>	
	
	<br>
	
	<!-- Profile Section -->
	<c:choose>
		<c:when test="${driverTrainingForm.profileList != null && driverTrainingForm.profileList.size() > 0}">
			<h5 style="font-weight: bold; font-size: 34px;">Driver Profile <span style="color: blue; font-size: 24px; font-style: italic;">(Scroll the Grid below to the right to see other details)</span></h5>
			
			<div class="table-responsive" style="width: 900px;">
						<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 100%; font-size: 26px;">  
							<tr>
								<th>Status</th>
								<th>Profile Date</th>
								<th>VNV</th>
								<th>Incab</th>
								<th>Spotcheck</th>
								<th>Incident</th>
								<th>Notes</th>
							</tr>
							<logic:iterate name="driverTrainingForm" property="profileList" type="com.transport.model.DriverTrainingProfile" id="model">
								<tr>
									<c:choose>
										<c:when test="${model.status == 'Closed'}">
											<td><span style="color: blue;"><bean:write name="model" property="status"/></span></td>	
										</c:when>
										<c:otherwise>
											<td><span style="color: red;"><bean:write name="model" property="status"/></span></td>
										</c:otherwise>
									</c:choose>
									<td align="right"><bean:write name="model" property="profileDate" format='MM/dd/yyyy'/></td>				 
									<td><a href="#" onclick="goToDriverTrainingProfileCommentsForDriver('${driverTrainingForm.driverTrainingId}','${model.id}','${model.vnv}','${driverTrainingForm.driverName}','253','true');"><bean:write name="model" property="vnv"/></a></td>
									<td><a href="#" onclick="goToDriverTrainingProfileCommentsForDriver('${driverTrainingForm.driverTrainingId}','${model.id}','${model.incab}','${driverTrainingForm.driverName}','254','true');"><bean:write name="model" property="incab"/></a></td>
									<td><a href="#" onclick="goToDriverTrainingProfileCommentsForDriver('${driverTrainingForm.driverTrainingId}','${model.id}','${model.spotcheck}','${driverTrainingForm.driverName}','255','true');"><bean:write name="model" property="spotcheck"/></a></td>
									<td><a href="#" onclick="goToDriverTrainingProfileCommentsForDriver('${driverTrainingForm.driverTrainingId}','${model.id}','${model.incident}','${driverTrainingForm.driverName}','256','true');"><bean:write name="model" property="incident"/></a></td>
									<td><bean:write name="model" property="notes"/></td>
								</tr>
							</logic:iterate>
						</table>
			</div>
		
		</c:when>
		<c:otherwise>
			<div style="color: blue;">No profile record found!</div>
		</c:otherwise>
	</c:choose>		
		
			
</div>


 

