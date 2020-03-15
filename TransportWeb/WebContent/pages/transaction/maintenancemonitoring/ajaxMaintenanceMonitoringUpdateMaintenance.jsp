<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>     
	 <script src="js/jquery-1.11.1.js" type="text/javascript"></script>
 	 <script src="js/bootstrap.min.js"></script>
 	 <script src="js/jquery-ui.min.js"></script>
	 <script src="js/transaction.js"></script>
</head>

<script>
$(function() {

	$('#maintenanceId').focus();
	
  });
  
</script>

<html>
	<body>
	
		<form action="/updateMaintenanceMonitoring" name="maintenanceMonitoringForm" id="idPopupForm">
			<input type="hidden" name="id" value="${maintenanceMonitoringForm.id}"/>
			<input type="hidden" name="day" value="${maintenanceMonitoringForm.day}"/>
			<input type="hidden" name="capacity" value="${maintenanceMonitoringForm.capacity}"/>
			<table>
					<tr><td><h2>Maintenance</h2></td></tr>
					<tr>
						<td><label>Tractor Plate No</label></td>
						<td><input type="text" value="${maintenanceMonitoringForm.plateNo}" style="background-color: #F8F8FF;" readonly="readonly"/></td>
					</tr>
					<tr>
						<td><label>Trailer Plate No</label></td>
						<td><input type="text" value="${maintenanceMonitoringForm.trailerNo}" style="background-color: #F8F8FF;" readonly="readonly"/></td>
					</tr>
					<tr>
						<td><label>Lorry No</label></td>
						<td><input type="text" value="${maintenanceMonitoringForm.lorryNo}" style="background-color: #F8F8FF;" readonly="readonly"/></td>
					</tr>
					<tr>
						<td><label>Capacity</label></td>
						<td><input type="text" value="${maintenanceMonitoringForm.capacity}" style="background-color: #F8F8FF;" readonly="readonly"/></td>
					</tr>
					<tr>
						<td><label>Year</label></td>
						<td><input type="text" value="${maintenanceMonitoringForm.year}" style="background-color: #F8F8FF;" readonly="readonly"/></td>
					</tr>
					<tr>
						<td><label>Month</label></td>
						<td><input type="text" value="${maintenanceMonitoringForm.month}" style="background-color: #F8F8FF;" readonly="readonly"/></td>
					</tr>
					<tr>
						<td><label>Day</label></td>
						<td><input type="text" value="${maintenanceMonitoringForm.day}" style="background-color: #F8F8FF;" readonly="readonly"/></td>
					</tr>
					<tr>
						<td><label>Maintenance</label></td>
						<td><input type="text" disabled="disabled" name="maintenance" value="${maintenanceMonitoringForm.maintenance}" id="maintenanceId" placeholder="Enter 1 or blank"/></td>
					</tr>
					<tr>
						<td><label>Maintenance Color</label></td>
						<td>
							<html:select disabled="true" styleClass="" style="width:250px;" name="maintenanceMonitoringForm" property="maintenanceColor" styleId="maintenanceColorId">
								 <html:option value="">--Select--</html:option>
								 <html:optionsCollection name="maintenanceMonitoringForm" property="maintenancePersonnelOptionsLOV" label="listValue" value="id"/>					 		
							</html:select>
						</td>
					</tr>
					<tr>
						<td><label>Maintenance Category</label></td>
						<td>
							<html:select disabled="true" styleClass="" style="width:250px;" name="maintenanceMonitoringForm" property="maintenanceCategory" styleId="maintenanceCategoryId">
								 <html:option value="">--Select--</html:option>
								 <html:optionsCollection name="maintenanceMonitoringForm" property="maintenanceCategoryLOV" label="listValue" value="id"/>					 		
							</html:select>
						</td>
					</tr>
					<tr>
						<td valign="top"><label>Maintenance Remarks</label></td>
						<td>
							<html:textarea  disabled="true" readonly="false" rows="5" cols="45" styleId="maintenanceRemarksId" property="maintenanceRemarks" value="${maintenanceMonitoringForm.maintenanceRemarks}"></html:textarea>
						</td>
					</tr>
					<tr height="10px;" ></tr>
					<tr>
						<td></td>
						<td>
							<c:forEach items="${sessionScope.user_access_list}" var="item">
	        					<c:if test="${item == 925 && sessionScope.isEditStatusLocked == 'N'}">
	        						<script>
	        							$('#maintenanceId').attr("disabled", false);
	        							$('#maintenanceColorId').attr("disabled", false);
	        							$('#maintenanceRemarksId').attr("disabled", false);
	        							$('#maintenanceCategoryId').attr("disabled", false);
	        						</script>
	        						<input type="button" style="margin-left: 275px;" name="updateBtn" value="Update" onclick="updateMaintenanceMonitoring('242');" />
	        					</c:if>
	        				</c:forEach>
        				</td>
					</tr>
			</table>
				
		</form>
	
	</body>
</html>

