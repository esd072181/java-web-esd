<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
$(function() {
    $( "#menu" ).menu({
      items: "> :not(.ui-widget-header)"
    });
    
    $('.timeStarted').timepicker({ 
    	timeFormat: 'h:mm p',
    		dynamic: false,
    	    dropdown: false,
    	    scrollbar: false});

    $('.timeEnded').timepicker({ 
    	timeFormat: 'h:mm p',
    		dynamic: false,
    	    dropdown: false,
    	    scrollbar: false});
    
    $('#mechanicId').attr('placeholder','Select mechanic and click Add button');
    
    $('.timeStarted').attr('placeholder','hh:mm AM/PM');
    $('.timeEnded').attr('placeholder','hh:mm AM/PM');
    
    $('#dtDateStarted').datepicker({}); 
    $('#dtDateStarted').attr('placeholder','mm/dd/yyyy'); 
    $('#dtDateEnded').datepicker({}); 
    $('#dtDateEnded').attr('placeholder','mm/dd/yyyy');
    $('#permitNoId').focus();
  });
  
</script>

<div style="height: 30%; padding-left: 10px;">
			<h3 style="font-weight: bolder;">Work Permit - Edit Record</h3>
			<html:form action="/workPermit.do" styleId="idForm" >
				<fieldset>
				
				<div>
					<html:errors/>
				</div>
				<div>
					<h4 style="color: blue;"><c:out value="${workPermitForm.transactionMessage}"></c:out></h4>
				</div>
				
				<div style="width: 100%; font-size: small;"> <!-- table -->
				
	                        	<table>
	                        		<!-- ID -->
	                        		<html:hidden property="id" value="${workPermitForm.id}"/>
                            		<!-- Permit No  -->
                                	<tr>
                                        <td>Permit No</td>
                                        <td><html:text styleId="permitNoId" property="permitNo" value="${workPermitForm.permitNo}" disabled="${workPermitForm.transactionStatus}"></html:text> </td>
                                    </tr>
                                    <tr style="height: 5px;" ></tr>
                                    <tr>
                                    	<td id="selectLorryLabelId"  style="display: none;">Select Lorry</td>
  								 		<td colspan="5">
  								 			<html:select  styleId="lorryAndPlateNoId" style="width: 171px; height: 22px; display: none;"  name="workPermitForm" property="lorryAndPlateNo" disabled="${WorkPermitForm.transactionStatus}" onchange="selectLorry(true, this.value);">
								 				<html:option value="0">--Select--</html:option>
								 				<html:optionsCollection name="workPermitForm" property="lorryList" label="lorryAndPlateNo" value="lorryAndPlateNo"/>				 		
								 			</html:select>
								 		</td>	
								 	</tr>
								 	<tr style="height: 5px;" ></tr>
								 	<tr>
								 		<td id="plateNoLabelId" >Plate No</td>
								 		<td>
								 			<input id="plateNoId" name="plateNo" type="text" style="margin-right: 10px;" value="${workPermitForm.plateNo}" readonly="readonly">
								 			<a id="editLorryLinkId" href="#" onclick="selectLorry(false)">Edit Lorry</a>
								 		</td>
								 	</tr>
								 	<tr style="height: 5px;" ></tr>
								 	<tr>
                                        <td id="lorryNoLabelId" >Lorry No</td>
                                        <td><input id="lorryNoId" name="lorryNo" type="text" style="margin-right: 10px; " value="${workPermitForm.lorryNo}" readonly="readonly"></td>
                                    </tr>
                                    <tr style="height: 5px;" ></tr>
                                    <tr>
                                        <td valign="top">Item Repair:</td>
                                        <td colspan="5"><html:textarea  readonly="false" rows="3" cols="70" styleId="itemRepairId" property="itemRepair" value="${workPermitForm.itemRepair}" disabled="${workPermitForm.transactionStatus}"></html:textarea></td>
                                     </tr>
                                    <tr style="height: 5px;" ></tr>
                                    <tr>
                                        <td valign="top">Item Replace:</td>
                                        <td colspan="5"><html:textarea  readonly="false" rows="3" cols="70" styleId="itemReplaceId" property="itemReplace" value="${workPermitForm.itemReplace}" disabled="${workPermitForm.transactionStatus}"></html:textarea></td>
                                     </tr>
                                     <tr style="height: 5px;" ></tr>
                                     <tr>
                                     	<td>Gas Free</td>
                                     	 <td>
  								 			<html:select style="height: 22px;" name="workPermitForm" property="gasFree" disabled="${workPermitForm.transactionStatus}">
								 				<html:option value="No">--Select--</html:option>
								 				<html:optionsCollection name="workPermitForm" property="booleanYNLOV" label="listValue" value="listValue"/>				 		
								 			</html:select>
								 		</td>	
                                     </tr>
                                     <tr style="height: 5px;" ></tr>
                                     <tr>
                                     	<td>Hot Work</td>
                                     	 <td>
  								 			<html:select  style="height: 22px;" name="workPermitForm" property="hotWork" disabled="${workPermitForm.transactionStatus}">
								 				<html:option value="No">--Select--</html:option>
								 				<html:optionsCollection name="workPermitForm" property="booleanYNLOV" label="listValue" value="listValue"/>				 		
								 			</html:select>
								 		</td>	
                                     </tr>
 									<tr style="height: 5px;" ></tr>
									<tr>
                                  		<td>Mechanic</td>
  								 		<td>
  								 			<html:select style="width: 171px; height: 22px;"  styleId="mechanicFullNameId" name="workPermitForm" property="mechanicFullName" disabled="${workPermitForm.transactionStatus}">
								 				<html:option value="0">--Select--</html:option>
								 				<html:optionsCollection name="workPermitForm" property="mechanicList" label="fullName" value="fullName"/>				 		
								 			</html:select>
								 			<html:button property="btnAddMechanic" onclick="addMechanic($('#mechanicFullNameId').val());" value="Add"></html:button>
								 		</td>	
									</tr>
									<tr style="height: 5px;" ></tr>
									<tr>
										<td></td>
                                        <td colspan="5"><html:textarea  readonly="false" rows="4" cols="22" styleId="mechanicId" property="mechanic" value="${workPermitForm.mechanic}" disabled="${workPermitForm.transactionStatus}"></html:textarea></td>
									</tr>
 									<tr style="height: 5px;" ></tr>
									<tr>
                                  		<td style="padding-right: 10px;">Permit Issuer</td>
  								 		<td colspan="4">
  								 			<html:select  styleId="permitIssuerFullNameId" style="width: 171px; height: 22px; display: none;" name="workPermitForm" property="permitIssuerFullName" disabled="${workPermitForm.transactionStatus}" onchange="selectPermitIssuer(true, this.value);">
								 				<html:option value="0">--Select--</html:option>
								 				<html:optionsCollection name="workPermitForm" property="permitIssuerList" label="fullName" value="fullName"/>				 		
								 			</html:select>
								 			<input id="permitIssuerId" name="permitIssuer" type="text" style="margin-right: 10px;" value="${workPermitForm.permitIssuer}" >
								 			<a id="editPermitIssuerLinkId" href="#" onclick="selectPermitIssuer(false)">Edit Permit Issuer</a>
								 		</td>	
									</tr>
									<tr style="height: 5px;" ></tr>
									<tr>
										<td>Date Started</td>
										<td><html:text property="dateStarted" styleId="dtDateStarted"></html:text></td>
										<td>Time Started</td>
										<td><html:text styleClass="timeStarted" property="timeStarted" value="${workPermitForm.timeStarted}" ></html:text></td>
									</tr>
									<tr style="height: 5px;" ></tr>
									<tr>
										<td>Date Ended</td>
										<td><html:text property="dateEnded" styleId="dtDateEnded"></html:text></td>
										<td>Time Ended</td>
										<td><html:text styleClass="timeEnded" property="timeEnded" value="${workPermitForm.timeEnded}"></html:text></td>
									</tr>
                                    <tr style="height: 5px;" ></tr>
                                    <tr>
                                     	<td>Rescue</td>
                                     	 <td>
  								 			<html:select  name="workPermitForm" property="rescue" disabled="${workPermitForm.transactionStatus}">
								 				<html:option value="No">--Select--</html:option>
								 				<html:optionsCollection name="workPermitForm" property="booleanYNLOV" label="listValue" value="listValue"/>				 		
								 			</html:select>
								 		</td>	
                                    </tr>									
									<tr style="height: 5px;" ></tr>
									<tr>
										<td>Odometer</td>
										<td>
											<html:text property="odometer" value="${workPermitForm.odometer}"></html:text>
										</td>
									</tr>									
									<tr style="height: 5px;" ></tr>
									<tr>
										<td>Hub</td>
										<td>
											<html:text property="hub" value="${workPermitForm.hub}"></html:text>
										</td>
									</tr>
                                    <tr style="height: 10px;" ></tr>
                                    <tr>
                                     	<td>Transport</td>
                                     	 <td>
  								 			<html:select  name="workPermitForm" property="transportId" disabled="${workPermitForm.transactionStatus}">
								 				<html:option value="0">--Select--</html:option>
								 				<html:optionsCollection name="workPermitForm" property="transportProgramLOV" label="listValue" value="id"/>				 		
								 			</html:select>
								 		</td>	
                                    </tr>																		
                                </table>
																	 
							<!-- buttons -->
							 <br>			 
							 <div class="control-group">
							 	 <div class="controls">
									<c:choose>	
										<c:when test="${workPermitForm.transactionStatus == true}">
											<html:button property="btnClose" styleClass="btn btn-primary" onclick="goToWorkPermit();" value="Close"></html:button>
										</c:when>
										<c:otherwise>
											<html:button property="btnUpdate" styleClass="btn btn-primary" onclick="updateWorkPermit();" value="Update"></html:button>
											<html:button property="btnCancel" styleClass="btn btn-primary" onclick="goToWorkPermit();" value="Cancel"></html:button>
										</c:otherwise>
									</c:choose>					 	 
							 	 </div>
							 	 
							 </div>
							 <br>
		
					</div> <!-- table -->
				</fieldset>				

			</html:form>
</div>
	