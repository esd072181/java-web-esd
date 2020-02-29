<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

				<c:if test="${maintenanceMonitoringForm.modelListPreventive!=null}">
					<logic:iterate name="maintenanceMonitoringForm" property="modelListPreventive" type="com.transport.model.MaintenanceMonitoringPreventive" id="model">
						<tr>
							<td colspan="2" align="center" style="font-weight: bold;">PREVENTIVE MAINTENANCE</td>
							<td colspan="2" align="center" style="font-weight: bold;">Garage</td> <!-- cyan -->
							<td></td> 
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pgarage1" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','1','2431')" />
									<span class="tooltiptext1">
										Day: 1 <br>
										Remarks: ${model.pgarageremarks1}
									</span>
								</div>
							</td>
							<td></td><td></td>  
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pgarage2" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','2','2431')"/>
									<span class="tooltiptext1">
										Day: 2 <br>
										Remarks: ${model.pgarageremarks2}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pgarage3" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','3','2431')"/>
									<span class="tooltiptext1">
										Day: 3 <br>
										Remarks: ${model.pgarageremarks3}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pgarage4" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','4','2431')"/>
									<span class="tooltiptext1">
										Day: 4 <br>
										Remarks: ${model.pgarageremarks4}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pgarage5" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','5','2431')"/>
									<span class="tooltiptext1">
										Day: 5 <br>
										Remarks: ${model.pgarageremarks5}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pgarage6" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','6','2431')"/>
									<span class="tooltiptext1">
										Day: 6 <br>
										Remarks: ${model.pgarageremarks6}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pgarage7" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','7','2431')"/>
									<span class="tooltiptext1">
										Day: 7 <br>
										Remarks: ${model.pgarageremarks7}
									</span>
								</div>
							</td>
							<td></td><td></td><td></td>
							<td></td> 
							<td></td> 
							<td></td>  
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pgarage8" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','8','2431')"/>
									<span class="tooltiptext1">
										Day: 8 <br>
										Remarks: ${model.pgarageremarks8}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pgarage9" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','9','2431')"/>
									<span class="tooltiptext1">
										Day: 9 <br>
										Remarks: ${model.pgarageremarks9}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pgarage10" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','10','2431')"/>
									<span class="tooltiptext1">
										Day: 10 <br>
										Remarks: ${model.pgarageremarks10}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pgarage11" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','11','2431')"/>
									<span class="tooltiptext1">
										Day: 11 <br>
										Remarks: ${model.pgarageremarks11}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pgarage12" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','12','2431')"/>
									<span class="tooltiptext1">
										Day: 12 <br>
										Remarks: ${model.pgarageremarks12}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pgarage13" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','13','2431')"/>
									<span class="tooltiptext1">
										Day: 13 <br>
										Remarks: ${model.pgarageremarks13}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pgarage14" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','14','2431')"/>
									<span class="tooltiptext1">
										Day: 14 <br>
										Remarks: ${model.pgarageremarks14}
									</span>
								</div>
							</td>
							<td></td><td></td><td></td>
							<td></td> 
							<td></td> 
							<td></td>  
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pgarage15" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','15','2431')"/>
									<span class="tooltiptext1">
										Day: 15 <br>
										Remarks: ${model.pgarageremarks15}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pgarage16" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','16','2431')"/>
									<span class="tooltiptext1">
										Day: 16 <br>
										Remarks: ${model.pgarageremarks16}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pgarage17" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','17','2431')"/>
									<span class="tooltiptext1">
										Day: 17 <br>
										Remarks: ${model.pgarageremarks17}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pgarage18" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','18','2431')"/>
									<span class="tooltiptext1">
										Day: 18 <br>
										Remarks: ${model.pgarageremarks18}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pgarage19" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','19','2431')"/>
									<span class="tooltiptext1">
										Day: 19 <br>
										Remarks: ${model.pgarageremarks19}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pgarage20" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','20','2431')"/>
									<span class="tooltiptext1">
										Day: 20 <br>
										Remarks: ${model.pgarageremarks20}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pgarage21" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','21','2431')"/>
									<span class="tooltiptext1">
										Day: 21 <br>
										Remarks: ${model.pgarageremarks21}
									</span>
								</div>
							</td>
							<td></td><td></td><td></td>
							<td></td> 
							<td></td> 
							<td></td>  
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pgarage22" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','22','2431')"/>
									<span class="tooltiptext1">
										Day: 22 <br>
										Remarks: ${model.pgarageremarks22}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pgarage23" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','23','2431')"/>
									<span class="tooltiptext1">
										Day: 23 <br>
										Remarks: ${model.pgarageremarks23}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pgarage24" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','24','2431')"/>
									<span class="tooltiptext1">
										Day: 24 <br>
										Remarks: ${model.pgarageremarks24}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pgarage25" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','25','2431')"/>
									<span class="tooltiptext1">
										Day: 25 <br>
										Remarks: ${model.pgarageremarks25}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pgarage26" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','26','2431')"/>
									<span class="tooltiptext1">
										Day: 26 <br>
										Remarks: ${model.pgarageremarks26}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pgarage27" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','27','2431')"/>
									<span class="tooltiptext1">
										Day: 27 <br>
										Remarks: ${model.pgarageremarks27}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pgarage28" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','28','2431')"/>
									<span class="tooltiptext1">
										Day: 28 <br>
										Remarks: ${model.pgarageremarks28}
									</span>
								</div>
							</td>
							<td></td><td></td><td></td>
							<td></td> 
							<td></td> 
							<td></td>  
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pgarage29" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','29','2431')"/>
									<span class="tooltiptext1">
										Day: 29 <br>
										Remarks: ${model.pgarageremarks29}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pgarage30" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','30','2431')"/>
									<span class="tooltiptext1">
										Day: 30 <br>
										Remarks: ${model.pgarageremarks30}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pgarage31" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','31','2431')"/>
									<span class="tooltiptext1">
										Day: 31 <br>
										Remarks: ${model.pgarageremarks31}
									</span>
								</div>
							</td>
							<td></td><td></td><td></td><td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>			
						<tr>
							<td colspan="2" align="center" style="font-weight: bold;"></td>
							<td colspan="2" align="center" style="font-weight: bold;">Fieldbase</td> <!-- cyan -->
							<td></td> 
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pfbase1" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','1','2432')"/>
									<span class="tooltiptext1">
										Day: 1 <br>
										Remarks: ${model.pfbaseremarks1}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pfbase2" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','2','2432')"/>
									<span class="tooltiptext1">
										Day: 2 <br>
										Remarks: ${model.pfbaseremarks2}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pfbase3" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','3','2432')"/>
									<span class="tooltiptext1">
										Day: 3 <br>
										Remarks: ${model.pfbaseremarks3}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pfbase4" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','4','2432')"/>
									<span class="tooltiptext1">
										Day: 4 <br>
										Remarks: ${model.pfbaseremarks4}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pfbase5" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','5','2432')"/>
									<span class="tooltiptext1">
										Day: 5 <br>
										Remarks: ${model.pfbaseremarks5}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pfbase6" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','6','2432')"/>
									<span class="tooltiptext1">
										Day: 6 <br>
										Remarks: ${model.pfbaseremarks6}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pfbase7" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','7','2432')"/>
									<span class="tooltiptext1">
										Day: 7 <br>
										Remarks: ${model.pfbaseremarks7}
									</span>
								</div>
							</td>
							<td></td><td></td><td></td>
							<td></td> 
							<td></td> 
							<td></td>  
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pfbase8" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','8','2432')"/>
									<span class="tooltiptext1">
										Day: 8 <br>
										Remarks: ${model.pfbaseremarks8}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pfbase9" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','9','2432')"/>
									<span class="tooltiptext1">
										Day: 9 <br>
										Remarks: ${model.pfbaseremarks9}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pfbase10" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','10','2432')"/>
									<span class="tooltiptext1">
										Day: 10 <br>
										Remarks: ${model.pfbaseremarks10}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pfbase11" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','11','2432')"/>
									<span class="tooltiptext1">
										Day: 11 <br>
										Remarks: ${model.pfbaseremarks11}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pfbase12" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','12','2432')"/>
									<span class="tooltiptext1">
										Day: 12 <br>
										Remarks: ${model.pfbaseremarks12}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pfbase13" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','13','2432')"/>
									<span class="tooltiptext1">
										Day: 13 <br>
										Remarks: ${model.pfbaseremarks13}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pfbase14" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','14','2432')"/>
									<span class="tooltiptext1">
										Day: 14 <br>
										Remarks: ${model.pfbaseremarks14}
									</span>
								</div>
							</td>
							<td></td><td></td><td></td>
							<td></td> 
							<td></td> 
							<td></td>  
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pfbase15" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','15','2432')"/>
									<span class="tooltiptext1">
										Day: 15 <br>
										Remarks: ${model.pfbaseremarks15}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pfbase16" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','16','2432')"/>
									<span class="tooltiptext1">
										Day: 16 <br>
										Remarks: ${model.pfbaseremarks16}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pfbase17" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','17','2432')"/>
									<span class="tooltiptext1">
										Day: 17 <br>
										Remarks: ${model.pfbaseremarks17}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pfbase18" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','18','2432')"/>
									<span class="tooltiptext1">
										Day: 18 <br>
										Remarks: ${model.pfbaseremarks18}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pfbase19" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','19','2432')"/>
									<span class="tooltiptext1">
										Day: 19 <br>
										Remarks: ${model.pfbaseremarks19}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pfbase20" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','20','2432')"/>
									<span class="tooltiptext1">
										Day: 20 <br>
										Remarks: ${model.pfbaseremarks20}
									</span>
								</div>
							</td>
							<td></td><td></td> 
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pfbase21" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','21','2432')"/>
									<span class="tooltiptext1">
										Day: 21 <br>
										Remarks: ${model.pfbaseremarks21}
									</span>
								</div>
							</td>
							<td></td><td></td><td></td>
							<td></td> 
							<td></td> 
							<td></td>  
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pfbase22" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','22','2432')"/>
									<span class="tooltiptext1">
										Day: 22 <br>
										Remarks: ${model.pfbaseremarks22}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pfbase23" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','23','2432')"/>
									<span class="tooltiptext1">
										Day: 23 <br>
										Remarks: ${model.pfbaseremarks23}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pfbase24" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','24','2432')"/>
									<span class="tooltiptext1">
										Day: 24 <br>
										Remarks: ${model.pfbaseremarks24}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pfbase25" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','25','2432')"/>
									<span class="tooltiptext1">
										Day: 25 <br>
										Remarks: ${model.pfbaseremarks25}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pfbase26" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','26','2432')"/>
									<span class="tooltiptext1">
										Day: 26 <br>
										Remarks: ${model.pfbaseremarks26}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pfbase27" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','27','2432')"/>
									<span class="tooltiptext1">
										Day: 27 <br>
										Remarks: ${model.pfbaseremarks27}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pfbase28" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','28','2432')"/>
									<span class="tooltiptext1">
										Day: 28 <br>
										Remarks: ${model.pfbaseremarks28}
									</span>
								</div>
							</td>
							<td></td><td></td><td></td>
							<td></td> 
							<td></td> 
							<td></td>  
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pfbase29" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','29','2432')"/>
									<span class="tooltiptext1">
										Day: 29 <br>
										Remarks: ${model.pfbaseremarks29}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pfbase30" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','30','2432')"/>
									<span class="tooltiptext1">
										Day: 30 <br>
										Remarks: ${model.pfbaseremarks30}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #00FFFF;" size="1px" value="<bean:write name="model" property="pfbase31" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','31','2432')"/>
									<span class="tooltiptext1">
										Day: 31 <br>
										Remarks: ${model.pfbaseremarks31}
									</span>
								</div>
							</td>
							<td></td><td></td><td></td><td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>			
						<tr>
							<td colspan="2" align="center" style="font-weight: bold;">BREAKDOWN</td>
							<td colspan="2" align="center" style="font-weight: bold;">Garage</td> <!-- cyan -->
							<td></td> 
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bgarage1" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','1','2433')"/>
									<span class="tooltiptext1">
										Day: 1 <br>
										Remarks: ${model.bgarageremarks1}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bgarage2" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','2','2433')"/>
									<span class="tooltiptext1">
										Day: 2 <br>
										Remarks: ${model.bgarageremarks2}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bgarage3" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','3','2433')"/>
									<span class="tooltiptext1">
										Day: 3 <br>
										Remarks: ${model.bgarageremarks3}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bgarage4" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','4','2433')"/>
									<span class="tooltiptext1">
										Day: 4 <br>
										Remarks: ${model.bgarageremarks4}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bgarage5" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','5','2433')"/>
									<span class="tooltiptext1">
										Day: 5 <br>
										Remarks: ${model.bgarageremarks5}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bgarage6" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','6','2433')"/>
									<span class="tooltiptext1">
										Day: 6 <br>
										Remarks: ${model.bgarageremarks6}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bgarage7" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','7','2433')"/>
									<span class="tooltiptext1">
										Day: 7 <br>
										Remarks: ${model.bgarageremarks7}
									</span>
								</div>
							</td>
							<td></td><td></td><td></td>
							<td></td> 
							<td></td> 
							<td></td>  
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bgarage8" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','8','2433')"/>
									<span class="tooltiptext1">
										Day: 8 <br>
										Remarks: ${model.bgarageremarks8}
									</span>
								</div>
							</td>
							<td></td><td></td> 
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bgarage9" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','9','2433')"/>
									<span class="tooltiptext1">
										Day: 9 <br>
										Remarks: ${model.bgarageremarks9}
									</span>
								</div>
							</td>
							<td></td><td></td> 
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bgarage10" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','10','2433')"/>
									<span class="tooltiptext1">
										Day: 10 <br>
										Remarks: ${model.bgarageremarks10}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bgarage11" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','11','2433')"/>
									<span class="tooltiptext1">
										Day: 11 <br>
										Remarks: ${model.bgarageremarks11}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bgarage12" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','12','2433')"/>
									<span class="tooltiptext1">
										Day: 12 <br>
										Remarks: ${model.bgarageremarks12}
									</span>
								</div>
							</td>
							<td></td><td></td> 
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bgarage13" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','13','2433')"/>
									<span class="tooltiptext1">
										Day: 13 <br>
										Remarks: ${model.bgarageremarks13}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bgarage14" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','14','2433')"/>
									<span class="tooltiptext1">
										Day: 14 <br>
										Remarks: ${model.bgarageremarks14}
									</span>
								</div>
							</td>
							<td></td> <td></td><td></td>
							<td></td> 
							<td></td> 
							<td></td> 
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bgarage15" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','15','2433')"/>
									<span class="tooltiptext1">
										Day: 15 <br>
										Remarks: ${model.bgarageremarks15}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bgarage16" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','16','2433')"/>
									<span class="tooltiptext1">
										Day: 16 <br>
										Remarks: ${model.bgarageremarks16}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bgarage17" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','17','2433')"/>
									<span class="tooltiptext1">
										Day: 17 <br>
										Remarks: ${model.bgarageremarks17}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bgarage18" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','18','2433')"/>
									<span class="tooltiptext1">
										Day: 18 <br>
										Remarks: ${model.bgarageremarks18}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bgarage19" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','19','2433')"/>
									<span class="tooltiptext1">
										Day: 19 <br>
										Remarks: ${model.bgarageremarks19}
									</span>
								</div>
							</td>
							<td></td><td></td> 
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bgarage20" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','20','2433')"/>
									<span class="tooltiptext1">
										Day: 20 <br>
										Remarks: ${model.bgarageremarks20}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bgarage21" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','21','2433')"/>
									<span class="tooltiptext1">
										Day: 21 <br>
										Remarks: ${model.bgarageremarks21}
									</span>
								</div>
							</td>
							<td></td><td></td><td></td>
							<td></td> 
							<td></td> 
							<td></td>  
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bgarage22" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','22','2433')"/>
									<span class="tooltiptext1">
										Day: 22 <br>
										Remarks: ${model.bgarageremarks22}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bgarage23" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','23','2433')"/>
									<span class="tooltiptext1">
										Day: 23 <br>
										Remarks: ${model.bgarageremarks23}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bgarage24" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','24','2433')"/>
									<span class="tooltiptext1">
										Day: 24 <br>
										Remarks: ${model.bgarageremarks24}
									</span>
								</div>
							</td>
							<td></td><td></td> 
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bgarage25" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','25','2433')"/>
									<span class="tooltiptext1">
										Day: 25 <br>
										Remarks: ${model.bgarageremarks25}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bgarage26" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','26','2433')"/>
									<span class="tooltiptext1">
										Day: 26 <br>
										Remarks: ${model.bgarageremarks26}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bgarage27" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','27','2433')"/>
									<span class="tooltiptext1">
										Day: 27 <br>
										Remarks: ${model.bgarageremarks27}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bgarage28" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','28','2433')"/>
									<span class="tooltiptext1">
										Day: 28 <br>
										Remarks: ${model.bgarageremarks28}
									</span>
								</div>
							</td>
							<td></td><td></td><td></td>
							<td></td> 
							<td></td> 
							<td></td>  
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bgarage29" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','29','2433')"/>
									<span class="tooltiptext1">
										Day: 29 <br>
										Remarks: ${model.bgarageremarks29}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bgarage30" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','30','2433')"/>
									<span class="tooltiptext1">
										Day: 30 <br>
										Remarks: ${model.bgarageremarks30}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bgarage31" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','31','2433')"/>
									<span class="tooltiptext1">
										Day: 31 <br>
										Remarks: ${model.bgarageremarks31}
									</span>
								</div>
							</td>
							<td></td><td></td><td></td><td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>			
						<tr>
							<td colspan="2" align="center" style="font-weight: bold;"></td>
							<td colspan="2" align="center" style="font-weight: bold;">Fieldbase</td> <!-- cyan -->
							<td></td> 
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bfbase1" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','1','2434')"/>
									<span class="tooltiptext1">
										Day: 1 <br>
										Remarks: ${model.bfbaseremarks1}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bfbase2" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','2','2434')"/>
									<span class="tooltiptext1">
										Day: 2 <br>
										Remarks: ${model.bfbaseremarks2}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bfbase3" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','3','2434')"/>
									<span class="tooltiptext1">
										Day: 3 <br>
										Remarks: ${model.bfbaseremarks3}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bfbase4" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','4','2434')"/>
									<span class="tooltiptext1">
										Day: 4 <br>
										Remarks: ${model.bfbaseremarks4}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bfbase5" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','5','2434')"/>
									<span class="tooltiptext1">
										Day: 5 <br>
										Remarks: ${model.bfbaseremarks5}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bfbase6" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','6','2434')"/>
									<span class="tooltiptext1">
										Day: 6 <br>
										Remarks: ${model.bfbaseremarks6}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bfbase7" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','7','2434')"/>
									<span class="tooltiptext1">
										Day: 7 <br>
										Remarks: ${model.bfbaseremarks7}
									</span>
								</div>
							</td>
							<td></td><td></td><td></td>
							<td></td> 
							<td></td> 
							<td></td>  
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bfbase8" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','8','2434')"/>
									<span class="tooltiptext1">
										Day: 8 <br>
										Remarks: ${model.bfbaseremarks8}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bfbase9" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','9','2434')"/>
									<span class="tooltiptext1">
										Day: 9 <br>
										Remarks: ${model.bfbaseremarks9}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bfbase10" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','10','2434')"/>
									<span class="tooltiptext1">
										Day: 10 <br>
										Remarks: ${model.bfbaseremarks10}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bfbase11" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','11','2434')"/>
									<span class="tooltiptext1">
										Day: 11 <br>
										Remarks: ${model.bfbaseremarks11}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bfbase12" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','12','2434')"/>
									<span class="tooltiptext1">
										Day: 12 <br>
										Remarks: ${model.bfbaseremarks12}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bfbase13" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','13','2434')"/>
									<span class="tooltiptext1">
										Day: 13 <br>
										Remarks: ${model.bfbaseremarks13}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bfbase14" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','14','2434')"/>
									<span class="tooltiptext1">
										Day: 14 <br>
										Remarks: ${model.bfbaseremarks14}
									</span>
								</div>
							</td>
							<td></td><td></td><td></td>
							<td></td> 
							<td></td> 
							<td></td>  
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bfbase15" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','15','2434')"/>
									<span class="tooltiptext1">
										Day: 15 <br>
										Remarks: ${model.bfbaseremarks15}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bfbase16" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','16','2434')"/>
									<span class="tooltiptext1">
										Day: 16 <br>
										Remarks: ${model.bfbaseremarks16}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bfbase17" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','17','2434')"/>
									<span class="tooltiptext1">
										Day: 17 <br>
										Remarks: ${model.bfbaseremarks17}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bfbase18" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','18','2434')"/>
									<span class="tooltiptext1">
										Day: 18 <br>
										Remarks: ${model.bfbaseremarks18}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bfbase19" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','19','2434')"/>
									<span class="tooltiptext1">
										Day: 19 <br>
										Remarks: ${model.bfbaseremarks19}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bfbase20" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','20','2434')"/>
									<span class="tooltiptext1">
										Day: 20 <br>
										Remarks: ${model.bfbaseremarks20}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bfbase21" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','21','2434')"/>
									<span class="tooltiptext1">
										Day: 21 <br>
										Remarks: ${model.bfbaseremarks21}
									</span>
								</div>
							</td>
							<td></td><td></td><td></td>
							<td></td> 
							<td></td> 
							<td></td>  
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bfbase22" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','22','2434')"/>
									<span class="tooltiptext1">
										Day: 22 <br>
										Remarks: ${model.bfbaseremarks22}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bfbase23" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','23','2434')"/>
									<span class="tooltiptext1">
										Day: 23 <br>
										Remarks: ${model.bfbaseremarks23}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bfbase24" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','24','2434')"/>
									<span class="tooltiptext1">
										Day: 24 <br>
										Remarks: ${model.bfbaseremarks24}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bfbase25" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','25','2434')"/>
									<span class="tooltiptext1">
										Day: 25 <br>
										Remarks: ${model.bfbaseremarks25}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bfbase26" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','26','2434')"/>
									<span class="tooltiptext1">
										Day: 26 <br>
										Remarks: ${model.bfbaseremarks26}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bfbase27" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','27','2434')"/>
									<span class="tooltiptext1">
										Day: 27 <br>
										Remarks: ${model.bfbaseremarks27}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bfbase28" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','28','2434')"/>
									<span class="tooltiptext1">
										Day: 28 <br>
										Remarks: ${model.bfbaseremarks28}
									</span>
								</div>
							</td>
							<td></td><td></td><td></td>
							<td></td> 
							<td></td> 
							<td></td>  
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bfbase29" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','29','2434')"/>
									<span class="tooltiptext1">
										Day: 29 <br>
										Remarks: ${model.bfbaseremarks29}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bfbase30" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','30','2434')"/>
									<span class="tooltiptext1">
										Day: 30 <br>
										Remarks: ${model.bfbaseremarks30}
									</span>
								</div>
							</td>
							<td></td> <td></td>
							<td>
								<div class="tooltip1">
									<input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="bfbase31" />" onclick="openUpdatePreventiveWindow('${model.id}','${model.year}','${model.month}','31','2434')"/>
									<span class="tooltiptext1">
										Day: 31 <br>
										Remarks: ${model.bfbaseremarks31}
									</span>
								</div>
							</td>
							<td></td><td></td><td></td><td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
					</logic:iterate>
				</c:if>
