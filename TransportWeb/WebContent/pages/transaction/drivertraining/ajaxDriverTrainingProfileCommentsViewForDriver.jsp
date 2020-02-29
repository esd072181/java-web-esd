<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

	
<div style="height: 30%; padding-left: 10px;">
		<h3 style="font-weight: bolder;">Driver Training Profile Comments</h3>
			<table>
				<tr style="height: 10px;"></tr>
				<tr>
					<td colspan="2">
						<html:button styleClass="btn btn-primary" property="" value="Add New Comment" onclick="goToAddDriverTrainingProfileCommentsForDriver('${driverTrainingForm.driverTrainingId}','${driverTrainingForm.driverTrainingProfileId}','${driverTrainingForm.remarks}','${driverTrainingForm.driverName}','${driverTrainingForm.innerModule}');"></html:button>
						&nbsp;&nbsp;<html:button property="command" onclick="viewDriverTrainingSummaryForDriver('${sessionScope.user_emp_id_session}');" value="Go Back" styleClass="btn btn-primary"></html:button>
					</td>
				</tr>
				<tr style="height: 10px;"></tr>
				<tr>
					<td><label style="font-size: 12px; font: Tahoma;">Name: </label></td>
					<td>&nbsp;&nbsp;<label style="font-size: 16px; font-weight: bolder; font: Tahoma; color: blue;">${driverTrainingForm.driverName}</label> </td>
				</tr>
				<tr>
					<c:choose>
						<c:when test="${driverTrainingForm.innerModule == 253}">
							<td><label style="font-size: 12px; font: Tahoma;">VNV: </label></td>
						</c:when>
						<c:when test="${driverTrainingForm.innerModule == 254}">
							<td><label style="font-size: 12px; font: Tahoma;">Incab: </label></td>
						</c:when>
						<c:when test="${driverTrainingForm.innerModule == 255}">
							<td><label style="font-size: 12px; font: Tahoma;">Spotcheck: </label></td>
						</c:when>
						<c:when test="${driverTrainingForm.innerModule == 256}">
							<td><label style="font-size: 12px; font: Tahoma;">Incident: </label></td>
						</c:when>
						<c:otherwise></c:otherwise>
					</c:choose>
					<td>&nbsp;&nbsp;<label style="font-size: 12px; font-weight: bolder; font: Tahoma; color: blue;">${driverTrainingForm.remarks}</label> </td>
				</tr>
				<tr style="height: 5px;"></tr>
			</table>

				<div class="table-responsive" >
					<c:choose>
					  <c:when test="${driverTrainingForm.commentList != null}">
						<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%; font-size: xx-small;">  
							<tr>
								<th>Comment</th>
								<th>By</th>
							</tr>
							<logic:iterate name="driverTrainingForm" property="commentList" type="com.transport.model.DriverTrainingProfileComment" id="model">
								<tr>
									<td>${model.remarks}</td>
									<td>${model.empName}</td>
								</tr>
							</logic:iterate>
						</table>
					  </c:when>
					  <c:otherwise>
					  	<div style="color: blue;">No comment record found!</div>
					  </c:otherwise>
					</c:choose>
				</div>

</div>


