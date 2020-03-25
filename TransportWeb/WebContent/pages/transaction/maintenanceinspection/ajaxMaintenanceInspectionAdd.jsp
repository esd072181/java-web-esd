<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<script>
$(function() {
    
    $('#dtInspectionDate').datepicker({}); 
    $('#dtInspectionDate').attr('placeholder','mm/dd/yyyy'); 
    $('#lorryNoId').focus();
  });
function getLorryNoAndPlateNo() {
	var res = $('#lorryNoId option:selected').text().split("(");
	$('#plateNoId').val(res[1].replace(")",""));
}
function hideItems(index) {	
	var className = "category" + index;
	var x = document.getElementsByClassName(className);
	var i;
	for (i = 0; i < x.length; i++) {
	  if (x[i].style.display == "none") {
		  $('.' + className).show();
	  } else {
		  $('.' + className).hide();
	  }
	  break;
	}
	return false; 
}
</script>
<style>
	.title-background {
		 background-color: #D3D3D3;
	}
</style>

<div style="height: 30%; padding-left: 10px;">
			<h3 style="font-weight: bolder;">Maintenance Inspection Checklist - Add New Record</h3>
			
			<hr>
			
			<html:form action="/maintenanceInspection.do" styleId="idForm">
			
				<fieldset>
				
				<div>
					<html:errors/>
				</div>
				<div>
					<h4 style="color: blue;"><c:out value="${maintenanceInspectionForm.transactionMessage}"></c:out></h4>
				</div> 
				
					<div style="width: 100%; font-size: small;" > <!-- table -->
						
                            	<table> 
                            		<tr>
                            			<td colspan="10" style="padding-left: 5px; font-weight: bold; font-size: 18px;">GD CANLAS PREVENTIVE MAINTENANCE INSPECTION CHECKLIST</td>
                            		</tr>
                            		<tr height="15px;"></tr>
                                    <tr>
                                    	<td id="selectLorryLabelId" style="padding-left: 5px; font-weight: bold;">LORRY:</td>
  								 		<td colspan="5" style="padding-left: 5px;">
  								 			<html:select  styleId="lorryNoId" style="width: 100px; height: 22px;"  name="maintenanceInspectionForm" property="lorryNo" onchange="getLorryNoAndPlateNo();" disabled="${maintenanceInspectionForm.transactionStatus}" >
								 				<html:option value="">--Select--</html:option>
								 				<html:optionsCollection name="maintenanceInspectionForm" property="lorryList" label="lorryNoWithPlateNo" value="lorryNo"/>				 		
								 			</html:select>
								 		</td>
								 		<td style="font-weight: bold; padding-left: 10px;">PLATE NUMBER:</td>
								 		<td style="padding-left: 5px;"><html:text styleId="plateNoId" property="plateNo" style="width: 100px; height: 22px;" readonly="readonly"></</html:text></td>	
								 		<td style="font-weight: bold; padding-left: 10px;">ODOMETER:</td>
								 		<td style="padding-left: 5px;"><html:text property="odometer" style="width: 100px; height: 22px;"></html:text></td>
								 		<td style="font-weight: bold; padding-left: 10px;">HUB ODOMETER:</td>
								 		<td style="padding-left: 5px;"><html:text property="hubOdometer" style="width: 100px; height: 22px;"></html:text></td>	
								 	</tr>                              	
								 	<tr height="15px;"></tr>
								</table>
									
								<table>
									<tr>
								 		<td style="font-weight: bold; padding-left: 5px;">INSPECTOR(S):</td>
								 		<td style="padding-left: 5px;"><html:text property="inspectors" style="width: 280px; height: 22px;"></html:text></td>
								 		<td style="font-weight: bold; padding-left: 10px;">FOR ANNUAL: </td>
								 		<c:choose>
								 			<c:when test="${maintenanceInspectionForm.forAnnual == 'YES'}">
								 				<td style="padding-left: 5px;" ><input type="checkbox" name="forAnnual" value="YES" checked="checked"/></td>
								 			</c:when>
								 			<c:otherwise>
								 				<td style="padding-left: 5px;"><input type="checkbox" name="forAnnual" value="YES"/></td>
								 			</c:otherwise>
								 		</c:choose>
								 		<td style="font-weight: bold; padding-left: 10px;">FOR PM: </td>
								 		<c:choose>
								 			<c:when test="${maintenanceInspectionForm.forPm == 'YES'}">
								 				<td style="padding-left: 5px;"><input type="checkbox" name="forPm" value="YES" checked="checked"/></td>
								 			</c:when>
								 			<c:otherwise>
								 				<td style="padding-left: 5px;"><input type="checkbox" name="forPm" value="YES"/></td>
								 			</c:otherwise>
								 		</c:choose>
								 		<td style="font-weight: bold; padding-left: 20px;">DATE: </td>
								 		<td style="padding-left: 10px;"><html:text  style="width: 170px;" property="inspectionDate" styleId="dtInspectionDate"></html:text></td>
								 		<td colspan="3" style="padding-left: 15px;">
									 		<div class="control-group">
											 	 <div class="controls">
													<c:choose>  
														<c:when test="${maintenanceInspectionForm.transactionStatus == true}">
															<html:button property="btnAddNew" style="width: 150px;" styleClass="btn btn-primary" onclick="goToAddMaintenanceInspection();" value="Add New Record"></html:button>
															<html:button property="btnClose" style="width: 80px;" styleClass="btn btn-primary" onclick="goToMaintenanceInspection();" value="Close"></html:button>
														</c:when>
														<c:otherwise>
															<html:button property="btnSave"  style="width: 80px;" styleClass="btn btn-primary" onclick="saveMaintenanceInspection();" value="Save"></html:button>
															<html:button property="btnCancel"  style="width: 80px;" styleClass="btn btn-primary" onclick="goToMaintenanceInspection();" value="Cancel"></html:button>
														</c:otherwise>
													</c:choose>								 	 
											 	 </div>
											 </div>
								 		</td>
								 	</tr>
								</table>
								 	
								 <br>
								 	
								 <table border="1"> 
								 	<tr>
								 		<td colspan="4" align="center" width="410" style="font-weight: bold;">CHECK ITEMS</td>
								 		<td align="center" style="font-weight: bold;" width="60">Good</td>
								 		<td align="center" style="font-weight: bold;" width="60">Repair</td>
								 		<td align="center" style="font-weight: bold;" width="60">Replace</td>
								 		<td align="center" style="font-weight: bold;" width="60">N/A</td>
								 		<td align="center" style="font-weight: bold;" width="350">Remarks</td>
								 	</tr>
								 	<tr>
								 		<td colspan="4" align="left" class="title-background" style="padding-left: 5px;font-weight: bold; font-style: italic;">SAFETY CHECK ITEMS</td>
								 		<td class="title-background"></td>
								 		<td class="title-background"></td>
								 		<td class="title-background"></td>
								 		<td class="title-background"></td>
								 		<td class="title-background"></td>
								 	</tr>
								 
								 	
								 	<c:set var="categoryName" value=""></c:set>
								 	<c:set var="categoryCounter" value=""></c:set>
								 	<logic:iterate name="maintenanceInspectionForm" property="mainCategoryList" type="java.lang.String" id="mainCategoryModel">
								 	
										 	<tr>
										 		<td colspan="4" align="center" class="title-background" style="font-weight: bold;">${mainCategoryModel}</td>
										 		<td class="title-background"></td>
										 		<td class="title-background"></td>
										 		<td class="title-background"></td>
										 		<td class="title-background"></td>
										 		<td class="title-background"></td>
										 	</tr>	
										 	
										 	<logic:iterate name="maintenanceInspectionForm" property="categoryList" type="com.transport.model.Inspection" id="categoryModel">
												
													<c:set var="categoryCounter" value="${categoryCounter+1}"></c:set>
												
													<tr>
														<td onclick="hideItems(${categoryCounter});" style="font-weight: bold;" width="30" align="center">${categoryModel.categoryNo}</td><!-- categoryno -->
														<td onclick="hideItems(${categoryCounter});" style="font-weight: bold; padding-left: 5px;" colspan="3">${categoryModel.categoryName}</td><!-- category name -->
														<td width="60"></td>
														<td width="60"></td>
														<td width="60"></td>
														<td width="60"></td>
														<td width="350"></td>
													</tr>
													<c:choose>
														<c:when test="${maintenanceInspectionForm.transactionStatus == false}">
															<logic:iterate name="maintenanceInspectionForm" property="inspectionList" type="com.transport.model.Inspection" id="innerModel">
																<c:if test="${innerModel.categoryName == categoryModel.categoryName}">
																	
																	<c:choose>
																		<c:when test="${innerModel.subItemNo == ''}">
																			<tr class="category${categoryCounter}">
																				<td>
																					<c:if test="${innerModel.labelOnly == false}">
																						<html:hidden property="inspectionId" value="${innerModel.id}"/>
																						<html:hidden property="inspectionStatusId" value="${innerModel.id}"/><!-- key-value technique in array -->
																						<html:hidden property="inspectionRemarks" value="${innerModel.id}"/><!-- key-value technique in array -->																			
																					</c:if>
																				</td>
																				<td colspan="3" style="padding: 0px 5px 0px 5px;">${innerModel.itemNo} ${innerModel.description}</td>
																				<c:choose>
																					<c:when test="${innerModel.labelOnly == true}">
																						<td></td>
																						<td></td>
																						<td></td>
																						<td></td>
																						<td></td>
																					</c:when>	
																					<c:otherwise>
																						<td width="60" align="center"><html:checkbox property="inspectionStatusId" value="1601"></html:checkbox></td>
																						<td width="60" align="center"><html:checkbox property="inspectionStatusId" value="1602"></html:checkbox></td>
																						<td width="60" align="center"><html:checkbox property="inspectionStatusId" value="1603"></html:checkbox></td>
																						<td width="60" align="center"><html:checkbox property="inspectionStatusId" value="1604"></html:checkbox></td>
																						<td width="350" align="center"><html:text property="inspectionRemarks" style="width: 345px;"></html:text></td>																																				
																					</c:otherwise>																	
																				</c:choose>
																			</tr>
																		</c:when>
																		<c:otherwise>
																			<tr class="category${categoryCounter}"></tr>
																			<tr class="category${categoryCounter}">
																				<td>
																					<c:if test="${innerModel.labelOnly == false}">
																						<html:hidden property="inspectionId" value="${innerModel.id}"/>
																						<html:hidden property="inspectionStatusId" value="${innerModel.id}"/><!-- key-value technique in array -->
																						<html:hidden property="inspectionRemarks" value="${innerModel.id}"/><!-- key-value technique in array -->																			
																					</c:if>
																				</td>
																				<td  colspan="3" style="padding: 0px 5px 0px 25px;">${innerModel.subItemNo} ${innerModel.description}</td>
																				<c:choose>
																					<c:when test="${innerModel.labelOnly == true}">
																						<td></td>
																						<td></td>
																						<td></td>
																						<td></td>
																						<td></td>
																					</c:when>	
																					<c:otherwise>
																						<td width="60" align="center"><html:checkbox property="inspectionStatusId" value="1601"></html:checkbox></td>
																						<td width="60" align="center"><html:checkbox property="inspectionStatusId" value="1602"></html:checkbox></td>
																						<td width="60" align="center"><html:checkbox property="inspectionStatusId" value="1603"></html:checkbox></td>
																						<td width="60" align="center"><html:checkbox property="inspectionStatusId" value="1604"></html:checkbox></td>
																						<td width="350" align="center"><html:text property="inspectionRemarks" style="width: 345px;"></html:text></td>				
																					</c:otherwise>
																				</c:choose>
																			</tr>
																		</c:otherwise>
																	</c:choose>	
																																
																</c:if>
															</logic:iterate>														
														</c:when>
														<c:otherwise>
															<logic:iterate name="maintenanceInspectionForm" property="modelDetailsList" type="com.transport.model.InspectionDetails" id="innerModel">
																<c:if test="${innerModel.categoryName == categoryModel.categoryName}">
																	<c:choose>
																		<c:when test="${innerModel.subItemNo == ''}">
																			<tr>
																				<td>
																					<c:if test="${innerModel.labelOnly == false}">
																						<html:hidden property="inspectionId" value="${innerModel.id}"/><!-- use this details id -->
																						<html:hidden property="inspectionStatusId" value="${innerModel.id}"/><!-- key-value technique in array -->
																						<html:hidden property="inspectionRemarks" value="${innerModel.id}"/><!-- key-value technique in array -->																			
																					</c:if>
																				</td>
																				<td colspan="3" style="padding: 0px 5px 0px 5px;">${innerModel.itemNo} ${innerModel.description}</td>
																				<c:choose>
																					<c:when test="${innerModel.labelOnly == true}">
																						<td></td>
																						<td></td>
																						<td></td>
																						<td></td>
																						<td></td>
																					</c:when>	
																					<c:otherwise>
																						<c:choose>
																							<c:when test="${innerModel.statusId == '1601'}">
																								<td width="60" align="center"><input type="checkbox" name="inspectionStatusId" value="1601" checked="checked" /></td>
																							</c:when>
																							<c:otherwise>
																								<td width="60" align="center"><html:checkbox property="inspectionStatusId" value="1601" ></html:checkbox></td>
																							</c:otherwise>
																						</c:choose>
																						<c:choose>
																							<c:when test="${innerModel.statusId == '1602'}">
																								<td width="60" align="center"><input type="checkbox" name="inspectionStatusId" value="1602" checked="checked"/></td>
																							</c:when>
																							<c:otherwise>
																								<td width="60" align="center"><html:checkbox property="inspectionStatusId" value="1602"></html:checkbox></td>
																							</c:otherwise>
																						</c:choose>
																						<c:choose>
																							<c:when test="${innerModel.statusId == '1603'}">
																								<td width="60" align="center"><input type="checkbox" name="inspectionStatusId" value="1603" checked="checked"/></td>
																							</c:when>
																							<c:otherwise>
																								<td width="60" align="center"><html:checkbox property="inspectionStatusId" value="1603"></html:checkbox></td>
																							</c:otherwise>
																						</c:choose>
																						<c:choose>
																							<c:when test="${innerModel.statusId == '1604'}">
																								<td width="60" align="center"><input type="checkbox" name="inspectionStatusId" value="1604" checked="checked"/></td>
																							</c:when>
																							<c:otherwise>
																								<td width="60" align="center"><html:checkbox property="inspectionStatusId" value="1604"></html:checkbox></td>
																							</c:otherwise>
																						</c:choose>
																						<td width="350" align="center"><html:text property="inspectionRemarks" style="width: 345px;" value="${innerModel.remarks}" disabled="${maintenanceInspectionForm.transactionStatus}"></html:text></td>																																				
																					</c:otherwise>																	
																				</c:choose>
																			</tr>
																		</c:when>
																		<c:otherwise>
																			<tr></tr>
																			<tr>
																				<td>
																					<c:if test="${innerModel.labelOnly == false}">
																						<html:hidden property="inspectionId" value="${innerModel.id}"/>
																						<html:hidden property="inspectionStatusId" value="${innerModel.id}"/><!-- key-value technique in array -->
																						<html:hidden property="inspectionRemarks" value="${innerModel.id}"/><!-- key-value technique in array -->																			
																					</c:if>
																				</td>
																				<td  colspan="3" style="padding: 0px 5px 0px 25px;">${innerModel.subItemNo} ${innerModel.description}</td>
																				<c:choose>
																					<c:when test="${innerModel.labelOnly == true}">
																						<td></td>
																						<td></td>
																						<td></td>
																						<td></td>
																						<td></td>
																					</c:when>	
																					<c:otherwise>
																						<c:choose>
																							<c:when test="${innerModel.statusId == '1601'}">
																								<td width="60" align="center"><input type="checkbox" name="inspectionStatusId" value="1601" checked="checked"/></td>
																							</c:when>
																							<c:otherwise>
																								<td width="60" align="center"><html:checkbox property="inspectionStatusId" value="1601"></html:checkbox></td>
																							</c:otherwise>
																						</c:choose>
																						<c:choose>
																							<c:when test="${innerModel.statusId == '1602'}">
																								<td width="60" align="center"><input type="checkbox" name="inspectionStatusId" value="1602" checked="checked"/></td>
																							</c:when>
																							<c:otherwise>
																								<td width="60" align="center"><html:checkbox property="inspectionStatusId" value="1602"></html:checkbox></td>
																							</c:otherwise>
																						</c:choose>
																						<c:choose>
																							<c:when test="${innerModel.statusId == '1603'}">
																								<td width="60" align="center"><input type="checkbox" name="inspectionStatusId" value="1603" checked="checked"/></td>
																							</c:when>
																							<c:otherwise>
																								<td width="60" align="center"><html:checkbox property="inspectionStatusId" value="1603"></html:checkbox></td>
																							</c:otherwise>
																						</c:choose>
																						<c:choose>
																							<c:when test="${innerModel.statusId == '1604'}">
																								<td width="60" align="center"><input type="checkbox" name="inspectionStatusId" value="1604" checked="checked"/></td>
																							</c:when>
																							<c:otherwise>
																								<td width="60" align="center"><html:checkbox property="inspectionStatusId" value="1604"></html:checkbox></td>
																							</c:otherwise>
																						</c:choose>											
																						<td width="350" align="center"><html:text property="inspectionRemarks" style="width: 345px;" value="${innerModel.remarks}" disabled="${maintenanceInspectionForm.transactionStatus}"></html:text></td>				
																						
																					</c:otherwise>
																				</c:choose>
																			</tr>
																		</c:otherwise>
																	</c:choose>																
																</c:if>
															</logic:iterate>																
														</c:otherwise>
													</c:choose>
																									
												</logic:iterate>	
												
												
	
									</logic:iterate>
																		
                                </table>
                                
                                <table>
                                	<tr height="10px"></tr>
                                	<tr>
                                		<td valign="top" style="font-weight: bold; padding-left: 5px;">REMARKS:</td>
								 		<td style="padding-left: 5px;"><html:textarea cols="128" rows="3" property="remarks" ></html:textarea></td>
                                	</tr>
                                </table>
							
							<!-- buttons -->
							<br>
							<div class="control-group">
							 	 <div class="controls">
									<c:choose>  
										<c:when test="${maintenanceInspectionForm.transactionStatus == true}">
											<html:button property="btnAddNew" style="width: 150px;" styleClass="btn btn-primary" onclick="goToAddMaintenanceInspection();" value="Add New Record"></html:button>
											<html:button property="btnClose" style="width: 80px;" styleClass="btn btn-primary" onclick="goToMaintenanceInspection();" value="Close"></html:button>
										</c:when>
										<c:otherwise>
											<html:button property="btnSave" style="width: 80px;" styleClass="btn btn-primary" onclick="saveMaintenanceInspection();" value="Save"></html:button>
											<html:button property="btnCancel" style="width: 80px;" styleClass="btn btn-primary" onclick="goToMaintenanceInspection();" value="Cancel"></html:button>
										</c:otherwise>
									</c:choose>								 	 
							 	 </div>
							 </div>

					</div> 
				</fieldset>	
				
			</html:form>
</div>
	