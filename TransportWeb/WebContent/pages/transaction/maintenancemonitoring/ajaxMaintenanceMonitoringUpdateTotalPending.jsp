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

	$('#remarksId').focus();
	
  });
  
</script>

<html>
	<body>
	
		<form action="/updateMaintenanceMonitoring" name="maintenanceMonitoringForm" id="idPopupForm">
			<input type="hidden" name="idTotalPending" value="${maintenanceMonitoringForm.idTotalPending}"/>
			<input type="hidden" name="day" value="${maintenanceMonitoringForm.day}"/>
			<table>
					<tr>
						<td colspan="2"><h2>TOTAL PENDING</h2></td>
					</tr>
					<tr>
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
						<td valign="top"><label>Remarks</label></td>
						<td>
							<html:textarea  disabled="true" readonly="false" rows="5" cols="50" styleId="remarksId" property="remarks" value="${maintenanceMonitoringForm.remarks}"></html:textarea>
						</td>
					</tr>
					<tr height="10px"><td></td></tr>
					<tr>
						<td></td>
						<td>
							<c:forEach items="${sessionScope.user_access_list}" var="item">
	        					<c:if test="${item == 925 && sessionScope.isEditStatusLocked == 'N'}">
	        						<script>
	        							$('#remarksId').attr("disabled", false);
	        						</script>
	        						<input type="button" style="margin-left: 313px;" name="updateBtn" value="Update" onclick="updateMaintenanceMonitoring('2435');" />
	        					</c:if>
	        				</c:forEach>
						</td>
					</tr>
			</table>
				
		</form>
	
	</body>
</html>

