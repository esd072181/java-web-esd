<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
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
<script>
$(function() {
    $('#dateUpdatedId').datepicker({}); 
    $('#dateUpdatedId').attr('placeholder','mm/dd/yyyy'); 
    
    $('#odometerId').focus();
  });
</script>

<div id="contentDIVAssign" style="padding-left: 10px;">

		<div style="height: 30%;">
			<h3 style="font-weight: bolder;">Tire Management - Add Details</h3>
			
				<div>
					<html:errors/>
				</div>
				<div>
					<h4 style="color: blue;"><c:out value="${tireManagementForm.transactionMessage}"></c:out></h4>
				</div> 			
			
			<hr>
			
			<html:form action="/saveTireManagementDetails.do" styleId="idForm" >
			
				<fieldset>
								
					<div style="width: 100%; padding-left: 20px; font-size: small;" >
						
                            	<table>
								 	<tr style="height: 5px;" ></tr>
									<tr>
										<td>Lorry No:</td>
										<td><html:text style="width: 50px;" property="lorryNo" readonly="true"></html:text></td>										
									</tr>
									<tr style="height: 5px;" ></tr>
									<tr>
										<c:choose>
											<c:when test="${tireManagementForm.tractor == true}">
												<td style="padding-left: 10px;">
												 	Tractor: <input type="radio" id="tractorPlateNoId" name="tractorPlateNo" onclick="toggleOptionPlateNo(1);" value="${tireManagementForm.tractorPlateNo}" readonly="readonly" checked="checked"> &nbsp;&nbsp;${tireManagementForm.tractorPlateNo}
												</td>
												<td style="padding-left: 10px;">
													Trailer: <input type="radio" id="trailerPlateNoId" name="trailerPlateNo" onclick="toggleOptionPlateNo(2);" value="${tireManagementForm.trailerPlateNo}" readonly="readonly"  >&nbsp;&nbsp;${tireManagementForm.trailerPlateNo}
												</td>											
											</c:when>
											<c:otherwise>
												<td style="padding-left: 10px;">
												 	Tractor: <input type="radio" id="tractorPlateNoId" name="tractorPlateNo" onclick="toggleOptionPlateNo(1);" value="${tireManagementForm.tractorPlateNo}" readonly="readonly"> &nbsp;&nbsp;${tireManagementForm.tractorPlateNo}
												</td>
												<td style="padding-left: 10px;">
													Trailer: <input type="radio" id="trailerPlateNoId" name="trailerPlateNo" onclick="toggleOptionPlateNo(2);" value="${tireManagementForm.trailerPlateNo}" readonly="readonly" checked="checked">&nbsp;&nbsp;${tireManagementForm.trailerPlateNo}
												</td>
											</c:otherwise>
										</c:choose>
									</tr>
									<tr style="height: 5px;" ></tr>
									<tr>
										<td>Position</td>
										<td><html:text style="width: 50px;" styleId="wheelPositionId" property="wheelPosition" value="${tireManagementForm.wheelPosition}" readonly="true"></html:text></td>
									</tr>
									<tr style="height: 5px;" ></tr>
									<tr>
										<td>Serial No:</td>
										<td><html:text style="width: 200px;" styleId="serialNoId" property="serialNo" value="${tireManagementForm.serialNo}" readonly="true"></html:text></td>
								 	</tr>	
								 	<tr style="height: 5px;" ></tr>
								 	<tr>
								 		<td>Recap No:</td>
										<td><html:text style="width: 50px;" styleId="recapNoId" property="recapNo" value="${tireManagementForm.recapNo}" readonly="true"></html:text></td>
								 	</tr>
								 	<tr style="height: 5px;" ></tr>
								 	<tr>
								 		<td>Hub Odometer:</td>
										<td>
											<div id="ContentDIVOdometer">
												<html:text style="width: 130px;" styleId="odometerId" property="odometer" value="${tireManagementForm.odometer}"></html:text>	
											</div>
										</td>
								 	</tr>	
								 	<tr style="height: 5px;" ></tr>
								 	<tr>
								 		<td><input type="checkbox" id="odometer2Id" name="odometer2" value="YES" onchange="getLatestOdometerReadingBySerialNo(this,$('#serialNoId').val())" /> &nbsp;Odometer</td>
										<td>Start: <html:text style="width: 90px;" styleId="odometerStartId" property="odometerStart" value="${tireManagementForm.odometerStart}"></html:text></td>
										<td>End: <html:text style="width: 90px;" property="odometerEnd" value="${tireManagementForm.odometerEnd}"></html:text></td>
								 	</tr>	
								 	<tr style="height: 5px;" ></tr>
								 	<tr>
								 		<td>Thread:</td>
										<td>
											<html:text style="width: 30px;" property="thread1" value="${tireManagementForm.thread1}"></html:text>
											<html:text style="width: 30px;" property="thread2" value="${tireManagementForm.thread2}"></html:text>
											<html:text style="width: 30px;" property="thread3" value="${tireManagementForm.thread3}"></html:text>
										</td>
								 	</tr>	
								 	<tr style="height: 5px;" ></tr>
								 	<tr>
								 		<td>Date:</td>
								 		<td><html:text styleId="dateUpdatedId" style="width: 130px;" property="dateUpdated" value="${tireManagementForm.dateUpdated}"></html:text></td>
								 	</tr>
								 	<tr style="height: 5px;" ></tr>
								 	
                                </table>
											
							<!-- buttons -->
							<hr>
							<div class="control-group">
							 	 <div class="controls">
									<c:choose>  
										<c:when test="${tireManagementForm.transactionStatus == true}">
											<html:button property="btnClose" styleClass="btn btn-primary" onclick="closeWindow();" value="Close"></html:button>
										</c:when>
										<c:otherwise>
											<html:button property="btnSave" styleClass="btn btn-primary" onclick="saveTireManagementAddDetails();" value="Save"></html:button>
										</c:otherwise>
									</c:choose>								 	 
							 	 </div>
							 	
							 </div>
							 <br>

					</div> <!-- table -->
				</fieldset>	
				
			</html:form>
		</div>
</div>	
	