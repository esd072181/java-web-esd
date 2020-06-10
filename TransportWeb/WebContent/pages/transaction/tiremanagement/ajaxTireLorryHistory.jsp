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
	<h3>${tireManagementForm.lorryNo} - Lorry History</h3>
	<hr>			
	<c:choose>
		<c:when test="${tireManagementForm.tireDetailsList != null && tireManagementForm.tireDetailsList.size() > 0}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 400px; font-size: xx-small;">  
						<tr>
							<th>No</th>
							<th>SerialNo</th>
							<th>Active</th>
						</tr>
						<logic:iterate name="tireManagementForm" property="tireDetailsList" type="com.transport.model.TireDetails" id="model" indexId="index">
							<tr>
								<td><c:out value="${index+1}"/></td>
								<c:choose>
									<c:when test="${model.active == true}">
										<td style="color: blue;"><bean:write name="model" property="serialNo"/></td>
									</c:when>
									<c:otherwise>
										<td><bean:write name="model" property="serialNo"/></td>
									</c:otherwise>
								</c:choose>		 
								
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
