<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script>
	$(function() {

		$('#commentId').focus();
	});
</script>

<div style="height: 30%; padding-left: 10px;">
			<h3 style="font-weight: bolder;">Driver Training Profile Comment - Add New Record</h3>
			<html:form action="/driverTrainingProfileCommentsForDriver.do" styleId="idForm">

				<fieldset>

					<div>
						<html:errors />
					</div>
					<div>
						<h4 style="color: blue;">
							<c:out value="${driverTrainingForm.transactionMessage}"></c:out>
						</h4>
					</div>

					<div style="width: 100%; font-size: small;">
						<!-- table -->
						<html:hidden property="driverTrainingId" value="${driverTrainingForm.driverTrainingId}" />
						<html:hidden property="driverTrainingProfileId" value="${driverTrainingForm.driverTrainingProfileId}" />
						<html:hidden property="driverName" value="${driverTrainingForm.driverName}" />
						<table>

							<tr>
								<td><label style="font-size: 12px; font: Tahoma;">Name:
								</label></td>
								<td>&nbsp;&nbsp;<label
									style="font-size: 16px; font-weight: bolder; font: Tahoma; color: blue;">${driverTrainingForm.driverName}</label>
								</td>
							</tr>
							<tr style="height: 5px;"></tr>
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
							<tr>
								<td><label style="font-size: 12px; font: Tahoma;">Comment:</label></td>
								<td style="padding-left: 5px;"><html:text property="comment"
										style="width: 600px; text-align: left;" styleId="commentId"
										disabled="${driverTrainingForm.transactionStatus}"></html:text>
								</td>
							</tr>

						</table>

						<!-- buttons -->
						<br>
						<div class="control-group">
							<div class="controls">
								<c:choose>
									<c:when test="${driverTrainingForm.transactionStatus == true}">
										<html:button property="btnAddNew" styleClass="btn btn-primary"
											onclick="goToAddDriverTrainingProfileCommentsForDriver('${driverTrainingForm.driverTrainingId}','${driverTrainingForm.driverTrainingProfileId}','${driverTrainingForm.remarks}','${driverTrainingForm.driverName}','${driverTrainingForm.innerModule}');"
											value="Add New Comment"></html:button>
											&nbsp;&nbsp;<html:button property="btnClose"
											styleClass="btn btn-primary"
											onclick="goToDriverTrainingProfileCommentsForDriver('${driverTrainingForm.driverTrainingId}','${driverTrainingForm.driverTrainingProfileId}','${driverTrainingForm.remarks}','${driverTrainingForm.driverName}','${driverTrainingForm.innerModule}', 'true');"
											value="Close"></html:button>
									</c:when>
									<c:otherwise>
										<html:button property="btnSave" styleClass="btn btn-primary"
											onclick="saveDriverTrainingProfileCommentsForDriver('${driverTrainingForm.driverTrainingId}','${driverTrainingForm.driverTrainingProfileId}','${driverTrainingForm.remarks}','${driverTrainingForm.driverName}','${driverTrainingForm.innerModule}');"
											value="Save"></html:button>
											&nbsp;&nbsp;<html:button property="btnCancel"
											styleClass="btn btn-primary"
											onclick="goToDriverTrainingProfileCommentsForDriver('${driverTrainingForm.driverTrainingId}','${driverTrainingForm.driverTrainingProfileId}','${driverTrainingForm.remarks}','${driverTrainingForm.driverName}','${driverTrainingForm.innerModule}','true');"
											value="Cancel"></html:button>
									</c:otherwise>
								</c:choose>
							</div>

						</div>
						<br>

					</div>
					<!-- table -->
				</fieldset>

			</html:form>
</div>
