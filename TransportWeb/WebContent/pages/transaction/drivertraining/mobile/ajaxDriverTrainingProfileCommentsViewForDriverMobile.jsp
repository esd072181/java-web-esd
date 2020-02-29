<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<div>

	<div align="left">
		 <html:button property="command" onclick="viewDriverTrainingSummaryForDriver('${sessionScope.user_emp_id_session}');" value="Go Back" styleClass="btn btn-primary" style="font-size: 34px;"></html:button>
	</div>
	<br>
	<div align="left">
		<h4 style="font-family: Tahoma; font-size: 60px; font-weight: bolder;">
			Driver Training Profile Comments
		</h4>
	</div>

	<hr>
	
	<div>
			<table>
				<tr style="height: 20px;"></tr>
				<tr>
					<c:choose>
						<c:when test="${driverTrainingForm.innerModule == 253}">
							<td valign="top"><label style="font-size: 34px; font: Tahoma;">VNV: </label></td>
						</c:when>
						<c:when test="${driverTrainingForm.innerModule == 254}">
							<td valign="top"><label style="font-size: 34px; font: Tahoma;">Incab: </label></td>
						</c:when>
						<c:when test="${driverTrainingForm.innerModule == 255}">
							<td valign="top"><label style="font-size: 34px; font: Tahoma;">Spotcheck: </label></td>
						</c:when>
						<c:when test="${driverTrainingForm.innerModule == 256}">
							<td valign="top"><label style="font-size: 34px; font: Tahoma;">Incident: </label></td>
						</c:when>
						<c:otherwise></c:otherwise>
					</c:choose>
					<td style="padding-left: 5px;"><textarea readonly="readonly" rows="5" cols="48" style="font-size: 34px; font-weight: bolder; font: Tahoma; background-color: #F5F5F5;">${driverTrainingForm.remarks}</textarea> </td>
				</tr>
			</table>
	</div>
	
	<br>
	
	<div align="center">
		 <html:button styleClass="btn btn-primary" style="font-size: 34px;" property="" value="Add New Comment" onclick="goToAddDriverTrainingProfileCommentsForDriver('${driverTrainingForm.driverTrainingId}','${driverTrainingForm.driverTrainingProfileId}','${driverTrainingForm.remarks}','${driverTrainingForm.driverName}','${driverTrainingForm.innerModule}');"></html:button>
	</div>
	
	<br>
	<br>
	
	<c:choose>
		<c:when test="${driverTrainingForm.commentList != null}">
					 	<div class="table-responsive" >
							<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 100%; font-size: 26px;">  
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
						</div>
		</c:when>
		<c:otherwise>
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 100%; font-size: 26px;">  
				<tr>
					<th>Comment</th>
					<th>By</th>
				</tr>		
			</table>
		</c:otherwise>
	</c:choose>
	


</div>

