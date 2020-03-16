<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Not used anymore since v1.6.5 -->
		<c:choose>
			<c:when test="${maintenanceMonitoringForm.modelList != null}">
				<a style="color: blue; font-size: 11px;" href="reports/maintenancemonitoring.xls" >Click here to download the file</a>
				<script>
					alert('Excel file successfully generated. Click the link to download the file.');
				</script>
			</c:when>
			<c:otherwise>
				<label><span style="color: blue;">No record found!</span></label>
			</c:otherwise>		
		</c:choose>
	
	

