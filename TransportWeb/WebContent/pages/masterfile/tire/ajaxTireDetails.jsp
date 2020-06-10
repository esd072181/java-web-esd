<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script src="js/jquery-1.11.1.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery-ui.min.js"></script>
<script src="js/jquery.timepicker.min.js"></script>
<script src="js/transaction.js"></script>
<script src="js/global.js"></script>
<script src="js/bootbox.js"></script>
<link rel="stylesheet" href="style/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="style/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="style/jquery.timepicker.min.css">
		
<div style="padding-left: 10px;">
	<h3>Tire Details</h3>
	<div style="padding-left: 5px;">
		<table>
			<tr>
				<td>Brand: &nbsp; <span style="color: blue;">${tireForm.brandName}</span></td>
			</tr>
			<tr height="5px;"></tr>
			<tr>
				<td>SerialNo: &nbsp; <span style="color: blue;">${tireForm.serialNo}</span></td>
			</tr>
		</table>
	</div>
	<hr>			
	<c:choose>
		<c:when test="${tireForm.tireDetailsList != null && tireForm.tireDetailsList.size() > 0}">
			<table class="table table-bordered table-striped table-condensed table-hover" style="width: 400px; font-size: xx-small;">  
						<tr>
							<th>No</th>
							<th>RecapNo</th>
							<th>LorryNo</th>
							<th>PlateNo</th>
							<th>Position</th>
							<th>Thread1</th>
							<th>Thread2</th>
							<th>Thread3</th>
							<th>OdoFitted</th>
							<th>DateFitted</th>
							<th>DistTraveled</th>
							<th>OdoRemoved</th>
							<th>DateRemoved</th>
							<th>ReasonForRemoval</th>
							<th>DateUpdated</th>
							<th>Active</th>
						</tr>
						<logic:iterate name="tireForm" property="tireDetailsList" type="com.transport.model.TireDetails" id="model" indexId="index">
							<tr>		 
								<td><bean:write name="model" property="rowNo"/></td>
								<td><bean:write name="model" property="recapNo"/></td>
								<td><bean:write name="model" property="lorryNo"/></td>
								<td><bean:write name="model" property="plateNo"/></td>
								<td><bean:write name="model" property="wheelPosition"/></td>
								<td><bean:write name="model" property="threadDepth1"/></td>
								<td><bean:write name="model" property="threadDepth2"/></td>
								<td><bean:write name="model" property="threadDepth3"/></td>
								<td><bean:write name="model" property="odometerFitted"/></td>
								<td><bean:write name="model" property="dateFitted" format="MM/dd/yyyy"/></td>
								<td><bean:write name="model" property="distanceTraveled"/></td>
								<td><bean:write name="model" property="odometerRemoved"/></td>
								<td><bean:write name="model" property="dateRemoved" format="MM/dd/yyyy"/></td>
								<td><bean:write name="model" property="reasonForRemoval"/></td>
								<td><bean:write name="model" property="dateUpdated" format="MM/dd/yyyy"/></td>
								<c:choose>
									<c:when test="${model.active == true}">
										<td style="color: blue;">Yes</td>
									</c:when>
									<c:otherwise>
										<td></td>
									</c:otherwise>
								</c:choose>
							</tr>
						</logic:iterate>
			</table>
		</c:when>
		<c:otherwise>
			<div style="color: blue;">No record found!</div>
		</c:otherwise>
	</c:choose>
</div>

