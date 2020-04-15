<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>
$(function() {
	//onload set the tire details color
	$('#colorRowBigId').addClass('${tireManagementForm.color}');
});

</script>
<style>
	.threadRowBig {
		width: 300px; 
		border-top: 1px solid black; 
		border-left: 1px solid black; 
		border-right: 1px solid black; 
		background-color: yellow;
		font-size: 30px; 
	}
	.colorRowBig{
		width: 300px; 
		border: 1px solid black; 
		cursor: pointer;
		font-size: 80px; 
	}
	.serialNoRowBig{
		width: 300px; 
		border-bottom: 1px solid black; 
		border-left: 1px solid black; 
		border-right: 1px solid black;
		font-size: 30px; 
	}
	.BLUE{
		color: white;
		background-color: #2545F8;
	}
	.LIME{
		background-color: #44FA13;
	}
	.YELLOW{
		background-color: yellow;
	}
	.ORANGE{
		background-color: orange;
	}
	.RED{
		background-color: red;
	}
	.GRAY{
		background-color: gray;
	}
	.BLACK{
		color: white;
		background-color: black;
	}
</style>
<table>
	<tr>
		<td>Brand:</td> 
		<td width="100" style="padding-left: 5px; font-weight: bolder;">${tireManagementForm.brandName}</td>
		<td width="100"></td>
		<td>Recap:</td>
		<td id="recapNoId" style="padding-left: 5px; font-weight: bolder;">${tireManagementForm.recapNo}</td>
	</tr>
	<tr height="5"></tr>
</table>
						
<table>
	<tr height="40">
		<td class="threadRowBig" align="center">${tireManagementForm.thread1}&nbsp;&nbsp;&nbsp;${tireManagementForm.thread2}&nbsp;&nbsp;&nbsp;${tireManagementForm.thread3}</td>	
	</tr>
	<tr height="200">
		<td id="colorRowBigId" class="colorRowBig" valign="middle" align="center">${tireManagementForm.wheelPosition}</td>
	</tr>
	<tr height="40">
		<td id="serialNoRowBigId" class="serialNoRowBig" align="center">${tireManagementForm.serialNo}</td>
		<td width="5"></td>
		<c:choose>
			<c:when test="${tireManagementForm.serialNo == ''}">
				<td>
					<html:button property="command" styleId="btnAssignTireId" onclick="goToTireManagementAssign($('#lorryNoId').val(),$('#wheelPositionId').val());" value="Assign Tire" styleClass="btn btn-primary"></html:button>
				</td>			
			</c:when>
			<c:otherwise>
				<td>
					<html:button property="command" styleId="btnRemoveTireId" onclick="goToTireManagementRemove($('#lorryNoId').val(),$('#wheelPositionId').val(),$('#serialNoRowBigId').text(),$('#recapNoId').text());" value="Remove Tire" styleClass="btn btn-primary"></html:button>
				</td>
				<td width="5"></td>
				<td>
					<html:button property="command" styleId="btnAddTireDetailsId" onclick="goToTireManagementAddDetails($('#lorryNoId').val(),$('#wheelPositionId').val(),$('#serialNoRowBigId').text(),$('#recapNoId').text());" value="Add Details" styleClass="btn btn-primary"></html:button>
				</td>
			</c:otherwise>
		</c:choose>

	</tr>
	<tr height="5">
</table>

<c:if test="${tireManagementForm.tireDetailsList != null && tireManagementForm.tireDetailsList.size() > 0}">
	<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 400px; font-size: xx-small;">  
				<tr>
					<th></th>
					<th>Thread1</th>
					<th>Thread2</th>
					<th>Thread3</th>
					<th>LorryNo</th>
					<th>PlateNo</th>
					<th>Position</th>
					<th>RecapNo</th>
					<th>OdoFitted</th>
					<th>DateFitted</th>
					<th>DistTraveled</th>
					<!--  
					<th>DateRemoved</th>
					<th>OdometerRemoved</th>
					<th>ReasonForRemoval</th>
					<th>DateUpdated</th>
					-->
					<th>Active</th>	
				</tr>
				<logic:iterate name="tireManagementForm" property="tireDetailsList" type="com.transport.model.TireDetails" id="model" indexId="index">
					<tr>		
						<td><a href="#" onclick="goToTireManagementEdit('${model.id}');">Edit</a></td>		 
						<td><bean:write name="model" property="threadDepth1"/></td>
						<td><bean:write name="model" property="threadDepth2"/></td>
						<td><bean:write name="model" property="threadDepth3"/></td>
						<td><bean:write name="model" property="lorryNo"/></td>
						<td><bean:write name="model" property="plateNo"/></td>
						<td><bean:write name="model" property="wheelPosition"/></td>
						<td><bean:write name="model" property="recapNo"/></td>
						<td><bean:write name="model" property="odometerFitted"/></td>
						<td><bean:write name="model" property="dateFitted" format='MM/dd/yyyy'/></td>
						<td><bean:write name="model" property="distanceTraveled"/></td>
						<!--  
						<td><bean:write name="model" property="dateRemoved"/></td>
						<td><bean:write name="model" property="odometerRemoved"/></td>
						<td><bean:write name="model" property="reasonForRemoval"/></td>
						<td><bean:write name="model" property="dateUpdated"/></td>
						-->
						<td><bean:write name="model" property="active"/></td>
					</tr>
				</logic:iterate>
	</table>
</c:if>
