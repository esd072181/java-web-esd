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
			<h3 style="font-weight: bolder;">Tire Management - Edit Record</h3>
			
				<div>
					<html:errors/>
				</div>
				<div>
					<h4 style="color: blue;"><c:out value="${tireManagementForm.transactionMessage}"></c:out></h4>
				</div> 			
			
			<hr>
			
			<html:form action="/updateTireManagementEdit.do" styleId="idForm" >
			
				<html:hidden property="id" value="${tireManagementForm.id}"/>
				<html:hidden property="recapNo" value="${tireManagementForm.recapNo}"/>
				
				<fieldset>
								
					<div style="width: 100%; padding-left: 20px; font-size: small;" >
						
                            	<table>
								 	<tr style="height: 5px;" ></tr>
									<tr>
										<td>Lorry No:</td>
										<td style="padding-left: 5px;"><html:text style="width: 50px;" property="lorryNo" readonly="true"></html:text></td>										
									</tr>
									<tr style="height: 5px;" ></tr>
									<tr>
										<td>Position</td>
										<td style="padding-left: 5px;"><html:text style="width: 50px;" styleId="wheelPositionId" property="wheelPosition" value="${tireManagementForm.wheelPosition}" readonly="true"></html:text></td>
									</tr>
									<tr style="height: 5px;" ></tr>
									<tr>
										<td>Serial No:</td>
										<td style="padding-left: 5px;"><html:text style="width: 130px;" styleId="serialNoId" property="serialNo" value="${tireManagementForm.serialNo}" readonly="true"></html:text></td>
								 	</tr>	
								 	<tr style="height: 5px;" ></tr>
								 	<tr>
								 		<td>Hub Odometer:</td>
										<td style="padding-left: 5px;">
											<html:text style="width: 130px;" styleId="odometerId" property="odometer" value="${tireManagementForm.odometer}"></html:text>	
										</td>
								 	</tr>	
								 	<tr style="height: 5px;" ></tr>
								 	<tr>
								 		<td>Thread:</td>
										<td style="padding-left: 5px;">
											<html:text style="width: 30px;" property="thread1" value="${tireManagementForm.thread1}"></html:text>
											<html:text style="width: 30px;" property="thread2" value="${tireManagementForm.thread2}"></html:text>
											<html:text style="width: 30px;" property="thread3" value="${tireManagementForm.thread3}"></html:text>
										</td>
								 	</tr>	
								 	<tr style="height: 5px;" ></tr>
								 	<tr>
								 		<td>Date:</td>
								 		<td style="padding-left: 5px;"><html:text styleId="dateUpdatedId" style="width: 130px;" property="dateUpdated" value="${tireManagementForm.dateUpdated}"></html:text></td>
								 	</tr>
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
											<html:button property="btnUpdate" styleClass="btn btn-primary" onclick="updateTireManagementEdit();" value="Update"></html:button>
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
	