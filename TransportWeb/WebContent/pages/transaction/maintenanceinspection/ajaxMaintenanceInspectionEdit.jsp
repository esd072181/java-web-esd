<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<script>
$(function() {
    $('#dtInspectionDate').datepicker({}); 
    $('#dtInspectionDate').attr('placeholder','mm/dd/yyyy'); 
    $('#lorryNoId').focus();
  });
  
</script>
<style>
	.title-background {
		 background-color: #D3D3D3;
	}
</style>

<div style="height: 30%; padding-left: 10px;">
			<h3 style="font-weight: bolder;">Maintenance Inspection Checklist - Edit Record</h3>
			<html:form action="/maintenanceInspection.do" styleId="idForm" >
				<fieldset>
				
				<div>
					<html:errors/>
				</div>
				<div>
					<h4 style="color: blue;"><c:out value="${maintenanceInspectionForm.transactionMessage}"></c:out></h4>
				</div>
				
				<div style="width: 100%; font-size: small;"> <!-- table -->
				
	                        	<!-- ID -->
	                        	<html:hidden property="id" value="${maintenanceInspectionForm.id}"/>
                            		
                            	<table> 
                                    <tr>
                                    	<td id="selectLorryLabelId" style="font-weight: bold;">Lorry</td>
  								 		<td colspan="5" style="padding-left: 5px;">
  								 			<html:select  styleId="lorryNoId" style="width: 171px; height: 22px;"  name="maintenanceInspectionForm" property="lorryNo" disabled="${maintenanceInspectionForm.transactionStatus}" >
								 				<html:option value="">--Select--</html:option>
								 				<html:optionsCollection name="maintenanceInspectionForm" property="lorryList" label="lorryNo" value="lorryNo"/>				 		
								 			</html:select>
								 		</td>	
								 	</tr>                              									 	
								</table>
									
								 <br>
								 
								 <table border="1"> 
								 	<tr>
								 		<td colspan="4" align="center" style="font-weight: bold;">CHECK ITEMS</td>
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
												
													<tr>
														<td style="font-weight: bold;" width="30" align="center">${categoryModel.categoryNo}</td><!-- categoryno -->
														<td style="font-weight: bold; padding-left: 5px;" colspan="3">${categoryModel.categoryName}</td><!-- category name -->
														<td width="60"></td>
														<td width="60"></td>
														<td width="60"></td>
														<td width="60"></td>
														<td width="350"></td>
													</tr>
													
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
												
												</logic:iterate>		
	
									</logic:iterate>
								 
								 
								 </table>
																	 
							<!-- buttons -->
							 <br>			 
							 <div class="control-group">
							 	 <div class="controls">
									<c:choose>	
										<c:when test="${maintenanceInspectionForm.transactionStatus == true}">
											<html:button property="btnClose" styleClass="btn btn-primary" onclick="goToMaintenanceInspection();" value="Close"></html:button>
										</c:when>
										<c:otherwise>
											<html:button property="btnUpdate" styleClass="btn btn-primary" onclick="updateMaintenanceInspection();" value="Update"></html:button>
											<html:button property="btnCancel" styleClass="btn btn-primary" onclick="goToMaintenanceInspection();" value="Cancel"></html:button>
										</c:otherwise>
									</c:choose>					 	 
							 	 </div>
							 	 
							 </div>
							 <br>
		
					</div> <!-- table -->
				</fieldset>				

			</html:form>
</div>
	