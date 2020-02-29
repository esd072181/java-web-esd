<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script>

function saveDriverTrainingProfileCommentsForDriverMobile(driverTrainingId,driverTrainingProfileId,remarks,driverName,innerModule) {

	$.ajax({
		  type: "POST",
		  url: "saveDriverTrainingProfileCommentsForDriverMobile.do?command=ajaxSaveInner&driverTrainingId=" + driverTrainingId + "&driverTrainingProfileId= " + driverTrainingProfileId + "&remarks=" + remarks + "&driverName=" + driverName + "&innerModule=" + innerModule,
		  data: $("#idForm").serialize(),
		})
		  .done(function( result ) {
			$("#contentDIV").html(result);
		});
}

</script>
<div>

	<div align="left">
		 <html:button property="command" onclick="viewDriverTrainingSummaryForDriver('${sessionScope.user_emp_id_session}');" value="Go Back" styleClass="btn btn-primary" style="font-size: 34px;"></html:button>
	</div>
	<br>
	<div align="left">
		<h4 style="font-family: Tahoma; font-size: 60px; font-weight: bolder;">
			Driver Training Profile Comment Add New Record
		</h4>
	</div>

	<hr>

	<div style="font-size: 34px;">
		<html:errors />
	</div>
	<div>
		<h4 style="color: blue; font-size: 34px;">
			<c:out value="${driverTrainingForm.transactionMessage}"></c:out>
		</h4>
	</div>

	<div>
		
		<html:form action="/driverTrainingProfileCommentsForDriver.do" styleId="idForm">
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
					<td style="padding-left: 5px;">
						<textarea readonly="readonly" rows="5" cols="42" style="font-size: 34px; font-weight: bolder; font: Tahoma; background-color: #F5F5F5;">${driverTrainingForm.remarks}</textarea> 
					</td>
				</tr>
				<tr style="height: 10px;"></tr>
				<tr>
					<td valign="top"><label style="font-size: 34px; font: Tahoma;">Comment:</label></td>
 
 					<c:choose>
 						<c:when test="${driverTrainingForm.transactionStatus == true}">
		 					<td style="padding-left: 5px;">
								<textarea rows="5" cols="45" name="comment" style="font-size: 34px; text-align: left;" id="commentId" readonly="readonly">${driverTrainingForm.comment}</textarea>
							</td>						
 						</c:when>
 						<c:otherwise>
 							<td style="padding-left: 5px;">
								<textarea rows="5" cols="45" name="comment" style="font-size: 34px; text-align: left;" id="commentId"></textarea>
							</td>							
 						</c:otherwise>
 					</c:choose>

				
				</tr>
			</table>
		</html:form>
	</div>

	<!-- buttons -->
	<br>
	<div class="control-group" align="center" style="padding-left: 100px;">
							<div class="controls">
								<c:choose>
									<c:when test="${driverTrainingForm.transactionStatus == true}">
										<html:button property="btnAddNew" styleClass="btn btn-primary"  style="font-size: 34px;"
											onclick="goToAddDriverTrainingProfileCommentsForDriver('${driverTrainingForm.driverTrainingId}','${driverTrainingForm.driverTrainingProfileId}','${driverTrainingForm.remarks}','${driverTrainingForm.driverName}','${driverTrainingForm.innerModule}');"
											value="Add New Comment"></html:button>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<html:button property="btnClose"
											styleClass="btn btn-primary"
											style="font-size: 34px;"
											onclick="goToDriverTrainingProfileCommentsForDriver('${driverTrainingForm.driverTrainingId}','${driverTrainingForm.driverTrainingProfileId}','${driverTrainingForm.remarks}','${driverTrainingForm.driverName}','${driverTrainingForm.innerModule}', 'true');"
											value="Close"></html:button>
									</c:when>
									<c:otherwise>
										<html:button property="btnSave" styleClass="btn btn-primary" style="font-size: 34px; width: 200px;"
											onclick="saveDriverTrainingProfileCommentsForDriverMobile('${driverTrainingForm.driverTrainingId}','${driverTrainingForm.driverTrainingProfileId}','${driverTrainingForm.remarks}','${driverTrainingForm.driverName}','${driverTrainingForm.innerModule}');"
											value="Save"></html:button>
									</c:otherwise>
								</c:choose>
							</div>

	</div>
	
	
</div>
