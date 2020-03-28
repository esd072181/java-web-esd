<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

	<div style="padding-left: 10px; padding-bottom: 10px;">
		<h4 style="color: blue;"><c:out value="${maintenanceMonitoringForm.transactionMessage}"></c:out></h4>
		<c:choose>
			<c:when test="${maintenanceMonitoringForm.isEditStatusLocked == 'Y'}">
				<label style="font-size: 20px; font-weight: bold; color: blue;"><c:out value="${maintenanceMonitoringForm.monthStr}"></c:out>&nbsp; <c:out value="${maintenanceMonitoringForm.year}"></c:out> </label>
				&nbsp;
				<label style="font-size: 14px;">Edit Status:</label>
				&nbsp;
				<label style="font-size: 14px; font-weight: bold; color: blue;">LOCKED</label>
			</c:when>
			<c:when test="${maintenanceMonitoringForm.isEditStatusLocked == 'N'}">
				<label style="font-size: 20px; font-weight: bold; color: blue;"><c:out value="${maintenanceMonitoringForm.monthStr}"></c:out>&nbsp; <c:out value="${maintenanceMonitoringForm.year}"></c:out> </label>
				&nbsp;
				<label style="font-size: 14px;">Edit Status:</label>
				&nbsp;
				<label style="font-size: 14px; font-weight: bold; color: blue;">OPEN</label>
				<c:forEach items="${sessionScope.user_access_list}" var="item">
				     <c:if test="${item == 926}">
				        &nbsp;
						<html:button styleId="btnSecurity" property="command" onclick="lockMaintenanceMonitoringByYearMonth();" value="Lock" styleClass="btn btn-primary"></html:button>
				     </c:if>
				</c:forEach>
			</c:when>
			<c:otherwise></c:otherwise>
		</c:choose>
	</div>
							
	<div class="table-responsive" style="padding-left: 10px; height: 520px;">
		<c:choose>
		  <c:when test="${maintenanceMonitoringForm.modelList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="font-size: xx-small;">  
				<tr>
					<th colspan="4" align="right">Day</th>
					<th colspan="3">1</th>
					<th colspan="3">2</th>
					<th colspan="3">3</th>
					<th colspan="3">4</th>
					<th colspan="3">5</th>
					<th colspan="3">6</th>
					<th colspan="3">7</th>
					<th style="text-align: center; background-color: #FF8C00;">GPS Trips Week 1</th>
					<th style="text-align: center; background-color: #FFFF00;">Qty/Week1 (ltrs)</th>
					<th style="text-align: center; background-color: #FF8C00;">Availability</th>
					<th style="text-align: center; background-color: #FF8C00;">Percentage</th>
					<th colspan="3">8</th>
					<th colspan="3">9</th>
					<th colspan="3">10</th>
					<th colspan="3">11</th>
					<th colspan="3">12</th>
					<th colspan="3">13</th>
					<th colspan="3">14</th>
					<th style="text-align: center; background-color: #FF8C00;">GPS Trips Week 2</th>
					<th style="text-align: center; background-color: #FFFF00;">Qty/Week2 (ltrs)</th>
					<th style="text-align: center; background-color: #FF8C00;">Availability</th>
					<th style="text-align: center; background-color: #FF8C00;">Percentage</th>
					<th colspan="3">15</th>
					<th colspan="3">16</th>
					<th colspan="3">17</th>
					<th colspan="3">18</th>
					<th colspan="3">19</th>
					<th colspan="3">20</th>
					<th colspan="3">21</th>
					<th style="text-align: center; background-color: #FF8C00;">GPS Trips Week 3</th>
					<th style="text-align: center; background-color: #FFFF00;">Qty/Week3 (ltrs)</th>
					<th style="text-align: center; background-color: #FF8C00;">Availability</th>
					<th style="text-align: center; background-color: #FF8C00;">Percentage</th>
					<th colspan="3">22</th>
					<th colspan="3">23</th>
					<th colspan="3">24</th>
					<th colspan="3">25</th>
					<th colspan="3">26</th>
					<th colspan="3">27</th>
					<th colspan="3">28</th>
					<th style="text-align: center; background-color: #FF8C00;">GPS Trips Week 4</th>
					<th style="text-align: center; background-color: #FFFF00;">Qty/Week4 (ltrs)</th>
					<th style="text-align: center; background-color: #FF8C00;">Availability</th>
					<th style="text-align: center; background-color: #FF8C00;">Percentage</th>
					<th colspan="3">29</th>
					<th colspan="3">30</th>
					<th colspan="3">31</th>
					<th style="text-align: center; background-color: #FF8C00;">GPS Trips Week 5</th>
					<th style="text-align: center; background-color: #FFFF00;">Qty/Week5 (ltrs)</th>
					<th style="text-align: center; background-color: #FFFF00;">Qty/Month (ltrs)</th>
					<th></th>
					<th>Breakdown</th>
					<th>PM</th>
					<th>Pending</th>
					<th>Target Date</th>
					<th>Extended</th>
					<th>Early Done</th>
					<th>GPS Trips/Month</th>
					<th>Percentage</th>
					<th>GPS Trip Terminal Issue (TI)</th>
					<th>GPS Trip Maintenance Issue (MI)</th>
					<th>GPS Trip Driver Issue (DI)</th>
					<th>GPS Trip Customer Issue (CI)</th>
					<th>GPS Trip Low Volume (LV)</th>
					<th>GPS Trip Long Haul (LH)</th>
					<th>GPS Trip Truck Ban Issue (TBI)</th>
					<th>GPS Trip Road Issue (RI)</th>
				</tr>
				<tr>
					<td>TractorPlateNo</td>
					<td>TrailerPlateNo</td>
					<td>LorryNo</td>
					<td>(kl)</td>
					<td>IDLE</td><td></td><td>Qty (ltrs)</td>
					<td>IDLE</td><td></td><td>Qty (ltrs)</td>
					<td>IDLE</td><td></td><td>Qty (ltrs)</td>
					<td>IDLE</td><td></td><td>Qty (ltrs)</td>
					<td>IDLE</td><td></td><td>Qty (ltrs)</td>
					<td>IDLE</td><td></td><td>Qty (ltrs)</td>
					<td>IDLE</td><td></td><td>Qty (ltrs)</td>
					<td style="text-align: center; background-color: #FF8C00;"></td>
					<td style="text-align: center; background-color: #FFFF00;"></td>
					<td style="text-align: center; background-color: #FF8C00;"></td>
					<td style="text-align: center; background-color: #FF8C00;"></td>
					<td>IDLE</td><td></td><td>Qty (ltrs)</td>
					<td>IDLE</td><td></td><td>Qty (ltrs)</td>
					<td>IDLE</td><td></td><td>Qty (ltrs)</td>
					<td>IDLE</td><td></td><td>Qty (ltrs)</td>
					<td>IDLE</td><td></td><td>Qty (ltrs)</td>
					<td>IDLE</td><td></td><td>Qty (ltrs)</td>
					<td>IDLE</td><td></td><td>Qty (ltrs)</td>
					<td style="text-align: center; background-color: #FF8C00;"></td>
					<td style="text-align: center; background-color: #FFFF00;"></td>
					<td style="text-align: center; background-color: #FF8C00;"></td>
					<td style="text-align: center; background-color: #FF8C00;"></td>
					<td>IDLE</td><td></td><td>Qty (ltrs)</td>
					<td>IDLE</td><td></td><td>Qty (ltrs)</td>
					<td>IDLE</td><td></td><td>Qty (ltrs)</td>
					<td>IDLE</td><td></td><td>Qty (ltrs)</td>
					<td>IDLE</td><td></td><td>Qty (ltrs)</td>
					<td>IDLE</td><td></td><td>Qty (ltrs)</td>
					<td>IDLE</td><td></td><td>Qty (ltrs)</td>
					<td style="text-align: center; background-color: #FF8C00;"></td>
					<td style="text-align: center; background-color: #FFFF00;"></td>
					<td style="text-align: center; background-color: #FF8C00;"></td>
					<td style="text-align: center; background-color: #FF8C00;"></td>
					<td>IDLE</td><td></td><td>Qty (ltrs)</td>
					<td>IDLE</td><td></td><td>Qty (ltrs)</td>
					<td>IDLE</td><td></td><td>Qty (ltrs)</td>
					<td>IDLE</td><td></td><td>Qty (ltrs)</td>
					<td>IDLE</td><td></td><td>Qty (ltrs)</td>
					<td>IDLE</td><td></td><td>Qty (ltrs)</td>
					<td>IDLE</td><td></td><td>Qty (ltrs)</td>
					<td style="text-align: center; background-color: #FF8C00;"></td>
					<td style="text-align: center; background-color: #FFFF00;"></td>
					<td style="text-align: center; background-color: #FF8C00;"></td>
					<td style="text-align: center; background-color: #FF8C00;"></td>
					<td>IDLE</td><td></td><td>Qty (ltrs)</td>
					<td>IDLE</td><td></td><td>Qty (ltrs)</td>
					<td>IDLE</td><td></td><td>Qty (ltrs)</td>
					<td style="text-align: center; background-color: #FF8C00;"></td>
					<td style="text-align: center; background-color: #FFFF00;"></td>
					<td style="text-align: center; background-color: #FFFF00;"></td>
					<td>Total</td>
					<td style="background-color: #FF0000;"></td><!-- red -->
					<td style="background-color: #00FFFF;"></td><!-- cyan -->
					<td style="background-color: #808080;"></td><!-- gray -->
					<td style="background-color: #006400;"></td><!-- dark green -->
					<td style="background-color: #000000;"></td><!-- black -->
					<td style="background-color: #EE82EE;"></td><!-- violet -->
					<td style="background-color: #FF8C00;"></td><!-- dark orange -->
					<td style="background-color: #FF8C00;"></td><!-- dark orange -->
					<td style="background-color: #FF8C00;"></td><!-- dark orange -->
					<td style="background-color: #FF8C00;"></td><!-- dark orange -->
					<td style="background-color: #FF8C00;"></td><!-- dark orange -->
					<td style="background-color: #FF8C00;"></td><!-- dark orange -->
					<td style="background-color: #FF8C00;"></td><!-- dark orange -->
					<td style="background-color: #FF8C00;"></td><!-- dark orange -->
					<td style="background-color: #FF8C00;"></td><!-- dark orange -->
					<td style="background-color: #FF8C00;"></td><!-- dark orange -->
				</tr>
				<c:set var="category" value=""></c:set>
				<c:set var="committedVolume" value=""></c:set>
				<c:set var="capacityOfTerminal" value=""></c:set>
				<c:set var="sumTrip1" value="0"></c:set>
				<c:set var="sumTrip2" value="0"></c:set>
				<c:set var="sumTrip3" value="0"></c:set>
				<c:set var="sumTrip4" value="0"></c:set>
				<c:set var="sumTrip5" value="0"></c:set>
				<c:set var="sumTrip6" value="0"></c:set>
				<c:set var="sumTrip7" value="0"></c:set>
				<c:set var="sumTrip8" value="0"></c:set>
				<c:set var="sumTrip9" value="0"></c:set>
				<c:set var="sumTrip10" value="0"></c:set>
				<c:set var="sumTrip11" value="0"></c:set>
				<c:set var="sumTrip12" value="0"></c:set>
				<c:set var="sumTrip13" value="0"></c:set>
				<c:set var="sumTrip14" value="0"></c:set>
				<c:set var="sumTrip15" value="0"></c:set>
				<c:set var="sumTrip16" value="0"></c:set>
				<c:set var="sumTrip17" value="0"></c:set>
				<c:set var="sumTrip18" value="0"></c:set>
				<c:set var="sumTrip19" value="0"></c:set>
				<c:set var="sumTrip20" value="0"></c:set>
				<c:set var="sumTrip21" value="0"></c:set>
				<c:set var="sumTrip22" value="0"></c:set>
				<c:set var="sumTrip23" value="0"></c:set>
				<c:set var="sumTrip24" value="0"></c:set>
				<c:set var="sumTrip25" value="0"></c:set>
				<c:set var="sumTrip26" value="0"></c:set>
				<c:set var="sumTrip27" value="0"></c:set>
				<c:set var="sumTrip28" value="0"></c:set>
				<c:set var="sumTrip29" value="0"></c:set>
				<c:set var="sumTrip30" value="0"></c:set>
				<c:set var="sumTrip31" value="0"></c:set>
				<c:set var="sumMaintenance1" value="0"></c:set>
				<c:set var="sumMaintenance2" value="0"></c:set>
				<c:set var="sumMaintenance3" value="0"></c:set>
				<c:set var="sumMaintenance4" value="0"></c:set>
				<c:set var="sumMaintenance5" value="0"></c:set>
				<c:set var="sumMaintenance6" value="0"></c:set>
				<c:set var="sumMaintenance7" value="0"></c:set>
				<c:set var="sumMaintenance8" value="0"></c:set>
				<c:set var="sumMaintenance9" value="0"></c:set>
				<c:set var="sumMaintenance10" value="0"></c:set>
				<c:set var="sumMaintenance11" value="0"></c:set>
				<c:set var="sumMaintenance12" value="0"></c:set>
				<c:set var="sumMaintenance13" value="0"></c:set>
				<c:set var="sumMaintenance14" value="0"></c:set>
				<c:set var="sumMaintenance15" value="0"></c:set>
				<c:set var="sumMaintenance16" value="0"></c:set>
				<c:set var="sumMaintenance17" value="0"></c:set>
				<c:set var="sumMaintenance18" value="0"></c:set>
				<c:set var="sumMaintenance19" value="0"></c:set>
				<c:set var="sumMaintenance20" value="0"></c:set>
				<c:set var="sumMaintenance21" value="0"></c:set>
				<c:set var="sumMaintenance22" value="0"></c:set>
				<c:set var="sumMaintenance23" value="0"></c:set>
				<c:set var="sumMaintenance24" value="0"></c:set>
				<c:set var="sumMaintenance25" value="0"></c:set>
				<c:set var="sumMaintenance26" value="0"></c:set>
				<c:set var="sumMaintenance27" value="0"></c:set>
				<c:set var="sumMaintenance28" value="0"></c:set>
				<c:set var="sumMaintenance29" value="0"></c:set>
				<c:set var="sumMaintenance30" value="0"></c:set>
				<c:set var="sumMaintenance31" value="0"></c:set>
				<c:set var="sumVol1" value="0"></c:set>
				<c:set var="sumVol2" value="0"></c:set>
				<c:set var="sumVol3" value="0"></c:set>
				<c:set var="sumVol4" value="0"></c:set>
				<c:set var="sumVol5" value="0"></c:set>
				<c:set var="sumVol6" value="0"></c:set>
				<c:set var="sumVol7" value="0"></c:set>
				<c:set var="sumVol8" value="0"></c:set>
				<c:set var="sumVol9" value="0"></c:set>
				<c:set var="sumVol10" value="0"></c:set>
				<c:set var="sumVol11" value="0"></c:set>
				<c:set var="sumVol12" value="0"></c:set>
				<c:set var="sumVol13" value="0"></c:set>
				<c:set var="sumVol14" value="0"></c:set>
				<c:set var="sumVol15" value="0"></c:set>
				<c:set var="sumVol16" value="0"></c:set>
				<c:set var="sumVol17" value="0"></c:set>
				<c:set var="sumVol18" value="0"></c:set>
				<c:set var="sumVol19" value="0"></c:set>
				<c:set var="sumVol20" value="0"></c:set>
				<c:set var="sumVol21" value="0"></c:set>
				<c:set var="sumVol22" value="0"></c:set>
				<c:set var="sumVol23" value="0"></c:set>
				<c:set var="sumVol24" value="0"></c:set>
				<c:set var="sumVol25" value="0"></c:set>
				<c:set var="sumVol26" value="0"></c:set>
				<c:set var="sumVol27" value="0"></c:set>
				<c:set var="sumVol28" value="0"></c:set>
				<c:set var="sumVol29" value="0"></c:set>
				<c:set var="sumVol30" value="0"></c:set>
				<c:set var="sumVol31" value="0"></c:set>
				
				<c:set var="sumVolWeek1" value="0"></c:set>
				<c:set var="sumVolWeek2" value="0"></c:set>
				<c:set var="sumVolWeek3" value="0"></c:set>
				<c:set var="sumVolWeek4" value="0"></c:set>
				<c:set var="sumVolWeek5" value="0"></c:set>

				<c:set var="totalLorryCountPerCategory" value="0"></c:set>
				<c:set var="grandTotalPending1" value="0"></c:set>
				<c:set var="grandTotalPending2" value="0"></c:set>
				<c:set var="grandTotalPending3" value="0"></c:set>
				<c:set var="grandTotalPending4" value="0"></c:set>
				<c:set var="grandTotalPending5" value="0"></c:set>
				<c:set var="grandTotalPending6" value="0"></c:set>
				<c:set var="grandTotalPending7" value="0"></c:set>
				<c:set var="grandTotalPending8" value="0"></c:set>
				<c:set var="grandTotalPending9" value="0"></c:set>
				<c:set var="grandTotalPending10" value="0"></c:set>
				<c:set var="grandTotalPending11" value="0"></c:set>
				<c:set var="grandTotalPending12" value="0"></c:set>
				<c:set var="grandTotalPending13" value="0"></c:set>
				<c:set var="grandTotalPending14" value="0"></c:set>
				<c:set var="grandTotalPending15" value="0"></c:set>
				<c:set var="grandTotalPending16" value="0"></c:set>
				<c:set var="grandTotalPending17" value="0"></c:set>
				<c:set var="grandTotalPending18" value="0"></c:set>
				<c:set var="grandTotalPending19" value="0"></c:set>
				<c:set var="grandTotalPending20" value="0"></c:set>
				<c:set var="grandTotalPending21" value="0"></c:set>
				<c:set var="grandTotalPending22" value="0"></c:set>
				<c:set var="grandTotalPending23" value="0"></c:set>
				<c:set var="grandTotalPending24" value="0"></c:set>
				<c:set var="grandTotalPending25" value="0"></c:set>
				<c:set var="grandTotalPending26" value="0"></c:set>
				<c:set var="grandTotalPending27" value="0"></c:set>
				<c:set var="grandTotalPending28" value="0"></c:set>
				<c:set var="grandTotalPending29" value="0"></c:set>
				<c:set var="grandTotalPending30" value="0"></c:set>
				<c:set var="grandTotalPending31" value="0"></c:set>
				<logic:iterate name="maintenanceMonitoringForm" property="modelList" type="com.transport.model.MaintenanceMonitoring" id="model">
					<!-- filter for shell lorry only -->
					<c:if test="${model.transportId == 601}">
						<c:if test="${model.category!=category}">
							<c:if test="${category!=''}">
								<tr>
									<td colspan="4" align="center"><span style="font-weight: bold;">Total Available &nbsp; <c:out value="${category}"></c:out> &nbsp; in Maintenance</span></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip1}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance1}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol1}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip2}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance2}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol2}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip3}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance3}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol3}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip4}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance4}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol4}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip5}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance5}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol5}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip6}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance6}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol6}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip7}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance7}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol7}" ></td>
									<td></td>
									<td align="center"><input type="text" size="5px" style="text-align: center; font-weight: bold; background-color: #FFFF00; "value="${sumVolWeek1}" ></td>
									<td></td>
									<td></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip8}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance8}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol8}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip9}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance9}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol9}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip10}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance10}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol10}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip11}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance11}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol11}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip12}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance12}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol12}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip13}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance13}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol13}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip14}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance14}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol14}" ></td>
									<td></td>
									<td align="center"><input type="text" size="5px" style="text-align: center; font-weight: bold; background-color: #FFFF00; "value="${sumVolWeek2}" ></td>
									<td></td>
									<td></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip15}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance15}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol15}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip16}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance16}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol16}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip17}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance17}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol17}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip18}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance18}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol18}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip19}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance19}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol19}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip20}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance20}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol20}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip21}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance21}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol21}" ></td>
									<td></td>
									<td align="center"><input type="text" size="5px" style="text-align: center; font-weight: bold; background-color: #FFFF00; "value="${sumVolWeek3}" ></td>
									<td></td>
									<td></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip22}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance22}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol22}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip23}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance23}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol23}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip24}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance24}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol24}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip25}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance25}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol25}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip26}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance26}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol26}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip27}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance27}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol27}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip28}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance28}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol28}" ></td>
									<td></td>
									<td align="center"><input type="text" size="5px" style="text-align: center; font-weight: bold; background-color: #FFFF00; "value="${sumVolWeek4}" ></td>
									<td></td>
									<td></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip29}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance29}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol29}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip30}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance30}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol30}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip31}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance31}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol31}" ></td>
									<td></td>
									<td align="center"><input type="text" size="5px" style="text-align: center; font-weight: bold; background-color: #FFFF00; "value="${sumVolWeek5}" ></td>
									<td align="center"><input type="text" size="8px" style="text-align: center; font-weight: bold; background-color: #FFFF00; "value="${sumVolWeek1+sumVolWeek2+sumVolWeek3+sumVolWeek4+sumVolWeek5}" ></td>
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
								<!-- Committed Volume -->
								<tr>
									<td colspan="2" style="color:red; background-color:lightgreen;">COMMITED VOLUME</td>
									<td style="color:red; background-color:lightgreen;">${committedVolume}</td>
									<!-- Batangas Black is Single Shift only -->
									<c:choose>
										<c:when test="${category=='BATANGAS BLACK'}">
											<td style="color:red; background-color:lightgreen;">${capacityOfTerminal*1000}</td>
										</c:when>
										<c:otherwise>
											<td style="color:red; background-color:lightgreen;">${capacityOfTerminal*1000*2}</td>
										</c:otherwise>
									</c:choose>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol1-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol2-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol3-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol4-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol5-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol6-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol7-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol8-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol9-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol10-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol11-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol12-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol13-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol14-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol15-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol16-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol17-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol18-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol19-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol20-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol21-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol22-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol23-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol24-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol25-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol26-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol27-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol28-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol29-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol30-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol31-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>	
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
								</tr>			

								<tr>
									<td colspan="4" align="center"><span style="font-weight: bold;">Daily Percentages &nbsp; <c:out value="${category}"></c:out> &nbsp;</span></td>
									<td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance1/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance2/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance3/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance4/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance5/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance6/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance7/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td></td>
									<td></td>
									<td></td>
									<td></td>
									<td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance8/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance9/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance10/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance11/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance12/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance13/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance14/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td></td>
									<td></td>
									<td></td>
									<td></td>
									<td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance15/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance16/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance17/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance18/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance19/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance20/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance21/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td></td>
									<td></td>
									<td></td>
									<td></td>
									<td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance22/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance23/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance24/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance25/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance26/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance27/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance28/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td></td>
									<td></td>
									<td></td>
									<td></td>
									<td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance29/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance30/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance31/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td></td><td></td>
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
									<td></td>
								</tr>
							</c:if>
							<c:set var="sumTrip1" value="0"></c:set>
							<c:set var="sumTrip2" value="0"></c:set>
							<c:set var="sumTrip3" value="0"></c:set>
							<c:set var="sumTrip4" value="0"></c:set>
							<c:set var="sumTrip5" value="0"></c:set>
							<c:set var="sumTrip6" value="0"></c:set>
							<c:set var="sumTrip7" value="0"></c:set>
							<c:set var="sumTrip8" value="0"></c:set>
							<c:set var="sumTrip9" value="0"></c:set>
							<c:set var="sumTrip10" value="0"></c:set>
							<c:set var="sumTrip11" value="0"></c:set>
							<c:set var="sumTrip12" value="0"></c:set>
							<c:set var="sumTrip13" value="0"></c:set>
							<c:set var="sumTrip14" value="0"></c:set>
							<c:set var="sumTrip15" value="0"></c:set>
							<c:set var="sumTrip16" value="0"></c:set>
							<c:set var="sumTrip17" value="0"></c:set>
							<c:set var="sumTrip18" value="0"></c:set>
							<c:set var="sumTrip19" value="0"></c:set>
							<c:set var="sumTrip20" value="0"></c:set>
							<c:set var="sumTrip21" value="0"></c:set>
							<c:set var="sumTrip22" value="0"></c:set>
							<c:set var="sumTrip23" value="0"></c:set>
							<c:set var="sumTrip24" value="0"></c:set>
							<c:set var="sumTrip25" value="0"></c:set>
							<c:set var="sumTrip26" value="0"></c:set>
							<c:set var="sumTrip27" value="0"></c:set>
							<c:set var="sumTrip28" value="0"></c:set>
							<c:set var="sumTrip29" value="0"></c:set>
							<c:set var="sumTrip30" value="0"></c:set>
							<c:set var="sumTrip31" value="0"></c:set>	
							<c:set var="sumMaintenance1" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance2" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance3" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance4" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance5" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance6" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance7" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance8" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance9" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance10" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance11" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance12" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance13" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance14" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance15" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance16" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance17" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance18" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance19" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance20" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance21" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance22" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance23" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance24" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance25" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance26" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance27" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance28" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance29" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance30" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance31" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumVol1" value="0"></c:set>
							<c:set var="sumVol2" value="0"></c:set>
							<c:set var="sumVol3" value="0"></c:set>
							<c:set var="sumVol4" value="0"></c:set>
							<c:set var="sumVol5" value="0"></c:set>
							<c:set var="sumVol6" value="0"></c:set>
							<c:set var="sumVol7" value="0"></c:set>
							<c:set var="sumVol8" value="0"></c:set>
							<c:set var="sumVol9" value="0"></c:set>
							<c:set var="sumVol10" value="0"></c:set>
							<c:set var="sumVol11" value="0"></c:set>
							<c:set var="sumVol12" value="0"></c:set>
							<c:set var="sumVol13" value="0"></c:set>
							<c:set var="sumVol14" value="0"></c:set>
							<c:set var="sumVol15" value="0"></c:set>
							<c:set var="sumVol16" value="0"></c:set>
							<c:set var="sumVol17" value="0"></c:set>
							<c:set var="sumVol18" value="0"></c:set>
							<c:set var="sumVol19" value="0"></c:set>
							<c:set var="sumVol20" value="0"></c:set>
							<c:set var="sumVol21" value="0"></c:set>
							<c:set var="sumVol22" value="0"></c:set>
							<c:set var="sumVol23" value="0"></c:set>
							<c:set var="sumVol24" value="0"></c:set>
							<c:set var="sumVol25" value="0"></c:set>
							<c:set var="sumVol26" value="0"></c:set>
							<c:set var="sumVol27" value="0"></c:set>
							<c:set var="sumVol28" value="0"></c:set>
							<c:set var="sumVol29" value="0"></c:set>
							<c:set var="sumVol30" value="0"></c:set>
							<c:set var="sumVol31" value="0"></c:set>
							
							<c:set var="sumVolWeek1" value="0"></c:set>
							<c:set var="sumVolWeek2" value="0"></c:set>
							<c:set var="sumVolWeek3" value="0"></c:set>
							<c:set var="sumVolWeek4" value="0"></c:set>
							<c:set var="sumVolWeek5" value="0"></c:set>
							
							<c:set var="totalLorryCountPerCategory" value="0"></c:set>
							<c:set var="category" value="${model.category}"></c:set>
							<c:set var="committedVolume" value="${model.committedVolume}"></c:set>
							<c:set var="capacityOfTerminal" value="0"></c:set>
							<tr>
								<td colspan="4" align="center"><span style="font-weight: bold;"><bean:write name="model" property="category"/></span></td>
								<td colspan="129"></td>
							</tr>	
						</c:if>							
						<c:set var="totalLorryCountPerCategory" value="${totalLorryCountPerCategory + 1}"></c:set>
						<c:set var="capacityOfTerminal" value="${capacityOfTerminal + model.capacity}"></c:set>
						<c:set var="sumTrip1" value="${sumTrip1 + model.gps1}"></c:set>
						<c:set var="sumTrip2" value="${sumTrip2 + model.gps2}"></c:set>
						<c:set var="sumTrip3" value="${sumTrip3 + model.gps3}"></c:set>
						<c:set var="sumTrip4" value="${sumTrip4 + model.gps4}"></c:set>
						<c:set var="sumTrip5" value="${sumTrip5 + model.gps5}"></c:set>
						<c:set var="sumTrip6" value="${sumTrip6 + model.gps6}"></c:set>
						<c:set var="sumTrip7" value="${sumTrip7 + model.gps7}"></c:set>
						<c:set var="sumTrip8" value="${sumTrip8 + model.gps8}"></c:set>
						<c:set var="sumTrip9" value="${sumTrip9 + model.gps9}"></c:set>
						<c:set var="sumTrip10" value="${sumTrip10 + model.gps10}"></c:set>
						<c:set var="sumTrip11" value="${sumTrip11 + model.gps11}"></c:set>
						<c:set var="sumTrip12" value="${sumTrip12 + model.gps12}"></c:set>
						<c:set var="sumTrip13" value="${sumTrip13 + model.gps13}"></c:set>
						<c:set var="sumTrip14" value="${sumTrip14 + model.gps14}"></c:set>
						<c:set var="sumTrip15" value="${sumTrip15 + model.gps15}"></c:set>
						<c:set var="sumTrip16" value="${sumTrip16 + model.gps16}"></c:set>
						<c:set var="sumTrip17" value="${sumTrip17 + model.gps17}"></c:set>
						<c:set var="sumTrip18" value="${sumTrip18 + model.gps18}"></c:set>
						<c:set var="sumTrip19" value="${sumTrip19 + model.gps19}"></c:set>
						<c:set var="sumTrip20" value="${sumTrip20 + model.gps20}"></c:set>
						<c:set var="sumTrip21" value="${sumTrip21 + model.gps21}"></c:set>
						<c:set var="sumTrip22" value="${sumTrip22 + model.gps22}"></c:set>
						<c:set var="sumTrip23" value="${sumTrip23 + model.gps23}"></c:set>
						<c:set var="sumTrip24" value="${sumTrip24 + model.gps24}"></c:set>
						<c:set var="sumTrip25" value="${sumTrip25 + model.gps25}"></c:set>
						<c:set var="sumTrip26" value="${sumTrip26 + model.gps26}"></c:set>
						<c:set var="sumTrip27" value="${sumTrip27 + model.gps27}"></c:set>
						<c:set var="sumTrip28" value="${sumTrip28 + model.gps28}"></c:set>
						<c:set var="sumTrip29" value="${sumTrip29 + model.gps29}"></c:set>
						<c:set var="sumTrip30" value="${sumTrip30 + model.gps30}"></c:set>
						<c:set var="sumTrip31" value="${sumTrip31 + model.gps31}"></c:set>
						<c:if test="${model.maintenance1 == '1'}">
							<c:set var="sumMaintenance1" value="${sumMaintenance1 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance2 == '1'}">
							<c:set var="sumMaintenance2" value="${sumMaintenance2 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance3 == '1'}">
							<c:set var="sumMaintenance3" value="${sumMaintenance3 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance4 == '1'}">
							<c:set var="sumMaintenance4" value="${sumMaintenance4 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance5 == '1'}">
							<c:set var="sumMaintenance5" value="${sumMaintenance5 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance6 == '1'}">
							<c:set var="sumMaintenance6" value="${sumMaintenance6 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance7 == '1'}">
							<c:set var="sumMaintenance7" value="${sumMaintenance7 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance8 == '1'}">
							<c:set var="sumMaintenance8" value="${sumMaintenance8 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance9 == '1'}">
							<c:set var="sumMaintenance9" value="${sumMaintenance9 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance10 == '1'}">
							<c:set var="sumMaintenance10" value="${sumMaintenance10 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance11 == '1'}">
							<c:set var="sumMaintenance11" value="${sumMaintenance11 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance12 == '1'}">
							<c:set var="sumMaintenance12" value="${sumMaintenance12 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance13 == '1'}">
							<c:set var="sumMaintenance13" value="${sumMaintenance13 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance14 == '1'}">
							<c:set var="sumMaintenance14" value="${sumMaintenance14 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance15 == '1'}">
							<c:set var="sumMaintenance15" value="${sumMaintenance15 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance16 == '1'}">
							<c:set var="sumMaintenance16" value="${sumMaintenance16 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance17 == '1'}">
							<c:set var="sumMaintenance17" value="${sumMaintenance17 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance18 == '1'}">
							<c:set var="sumMaintenance18" value="${sumMaintenance18 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance19 == '1'}">
							<c:set var="sumMaintenance19" value="${sumMaintenance19 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance20 == '1'}">
							<c:set var="sumMaintenance20" value="${sumMaintenance20 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance21 == '1'}">
							<c:set var="sumMaintenance21" value="${sumMaintenance21 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance22 == '1'}">
							<c:set var="sumMaintenance22" value="${sumMaintenance22 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance23 == '1'}">
							<c:set var="sumMaintenance23" value="${sumMaintenance23 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance24 == '1'}">
							<c:set var="sumMaintenance24" value="${sumMaintenance24 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance25 == '1'}">
							<c:set var="sumMaintenance25" value="${sumMaintenance25 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance26 == '1'}">
							<c:set var="sumMaintenance26" value="${sumMaintenance26 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance27 == '1'}">
							<c:set var="sumMaintenance27" value="${sumMaintenance27 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance28 == '1'}">
							<c:set var="sumMaintenance28" value="${sumMaintenance28 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance29 == '1'}">
							<c:set var="sumMaintenance29" value="${sumMaintenance29 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance30 == '1'}">
							<c:set var="sumMaintenance30" value="${sumMaintenance30 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance31 == '1'}">
							<c:set var="sumMaintenance31" value="${sumMaintenance31 + 1}"></c:set>
						</c:if>
						<c:set var="sumVol1" value="${sumVol1 + model.gps1Vol}"></c:set>
						<c:set var="sumVol2" value="${sumVol2 + model.gps2Vol}"></c:set>
						<c:set var="sumVol3" value="${sumVol3 + model.gps3Vol}"></c:set>
						<c:set var="sumVol4" value="${sumVol4 + model.gps4Vol}"></c:set>
						<c:set var="sumVol5" value="${sumVol5 + model.gps5Vol}"></c:set>
						<c:set var="sumVol6" value="${sumVol6 + model.gps6Vol}"></c:set>
						<c:set var="sumVol7" value="${sumVol7 + model.gps7Vol}"></c:set>
						<c:set var="sumVol8" value="${sumVol8 + model.gps8Vol}"></c:set>
						<c:set var="sumVol9" value="${sumVol9 + model.gps9Vol}"></c:set>
						<c:set var="sumVol10" value="${sumVol10 + model.gps10Vol}"></c:set>
						<c:set var="sumVol11" value="${sumVol11 + model.gps11Vol}"></c:set>
						<c:set var="sumVol12" value="${sumVol12 + model.gps12Vol}"></c:set>
						<c:set var="sumVol13" value="${sumVol13 + model.gps13Vol}"></c:set>
						<c:set var="sumVol14" value="${sumVol14 + model.gps14Vol}"></c:set>
						<c:set var="sumVol15" value="${sumVol15 + model.gps15Vol}"></c:set>
						<c:set var="sumVol16" value="${sumVol16 + model.gps16Vol}"></c:set>
						<c:set var="sumVol17" value="${sumVol17 + model.gps17Vol}"></c:set>
						<c:set var="sumVol18" value="${sumVol18 + model.gps18Vol}"></c:set>
						<c:set var="sumVol19" value="${sumVol19 + model.gps19Vol}"></c:set>
						<c:set var="sumVol20" value="${sumVol20 + model.gps20Vol}"></c:set>
						<c:set var="sumVol21" value="${sumVol21 + model.gps21Vol}"></c:set>
						<c:set var="sumVol22" value="${sumVol22 + model.gps22Vol}"></c:set>
						<c:set var="sumVol23" value="${sumVol23 + model.gps23Vol}"></c:set>
						<c:set var="sumVol24" value="${sumVol24 + model.gps24Vol}"></c:set>
						<c:set var="sumVol25" value="${sumVol25 + model.gps25Vol}"></c:set>
						<c:set var="sumVol26" value="${sumVol26 + model.gps26Vol}"></c:set>
						<c:set var="sumVol27" value="${sumVol27 + model.gps27Vol}"></c:set>
						<c:set var="sumVol28" value="${sumVol28 + model.gps28Vol}"></c:set>
						<c:set var="sumVol29" value="${sumVol29 + model.gps29Vol}"></c:set>
						<c:set var="sumVol30" value="${sumVol30 + model.gps30Vol}"></c:set>
						<c:set var="sumVol31" value="${sumVol31 + model.gps31Vol}"></c:set>		
						
						<c:set var="sumVolWeek1" value="${sumVolWeek1 + model.gpsWeek1Vol}"></c:set>
						<c:set var="sumVolWeek2" value="${sumVolWeek2 + model.gpsWeek2Vol}"></c:set>
						<c:set var="sumVolWeek3" value="${sumVolWeek3 + model.gpsWeek3Vol}"></c:set>
						<c:set var="sumVolWeek4" value="${sumVolWeek4 + model.gpsWeek4Vol}"></c:set>
						<c:set var="sumVolWeek5" value="${sumVolWeek5 + model.gpsWeek5Vol}"></c:set>		
										
						<c:if test="${model.maintenanceColor1 == '1105'}">
							<c:set var="grandTotalPending1" value="${grandTotalPending1 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor2 == '1105'}">
							<c:set var="grandTotalPending2" value="${grandTotalPending2 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor3 == '1105'}">
							<c:set var="grandTotalPending3" value="${grandTotalPending3 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor4 == '1105'}">
							<c:set var="grandTotalPending4" value="${grandTotalPending4 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor5 == '1105'}">
							<c:set var="grandTotalPending5" value="${grandTotalPending5 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor6 == '1105'}">
							<c:set var="grandTotalPending6" value="${grandTotalPending6 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor7 == '1105'}">
							<c:set var="grandTotalPending7" value="${grandTotalPending7 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor8 == '1105'}">
							<c:set var="grandTotalPending8" value="${grandTotalPending8 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor9 == '1105'}">
							<c:set var="grandTotalPending9" value="${grandTotalPending9 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor10 == '1105'}">
							<c:set var="grandTotalPending10" value="${grandTotalPending10 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor11 == '1105'}">
							<c:set var="grandTotalPending11" value="${grandTotalPending11 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor12 == '1105'}">
							<c:set var="grandTotalPending12" value="${grandTotalPending12 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor13 == '1105'}">
							<c:set var="grandTotalPending13" value="${grandTotalPending13 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor14 == '1105'}">
							<c:set var="grandTotalPending14" value="${grandTotalPending14 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor15 == '1105'}">
							<c:set var="grandTotalPending15" value="${grandTotalPending15 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor16 == '1105'}">
							<c:set var="grandTotalPending16" value="${grandTotalPending16 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor17 == '1105'}">
							<c:set var="grandTotalPending17" value="${grandTotalPending17 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor18 == '1105'}">
							<c:set var="grandTotalPending18" value="${grandTotalPending18 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor19 == '1105'}">
							<c:set var="grandTotalPending19" value="${grandTotalPending19 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor20 == '1105'}">
							<c:set var="grandTotalPending20" value="${grandTotalPending20 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor21 == '1105'}">
							<c:set var="grandTotalPending21" value="${grandTotalPending21 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor22 == '1105'}">
							<c:set var="grandTotalPending22" value="${grandTotalPending22 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor23 == '1105'}">
							<c:set var="grandTotalPending23" value="${grandTotalPending23 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor24 == '1105'}">
							<c:set var="grandTotalPending24" value="${grandTotalPending24 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor25 == '1105'}">
							<c:set var="grandTotalPending25" value="${grandTotalPending25 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor26 == '1105'}">
							<c:set var="grandTotalPending26" value="${grandTotalPending26 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor27 == '1105'}">
							<c:set var="grandTotalPending27" value="${grandTotalPending27 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor28 == '1105'}">
							<c:set var="grandTotalPending28" value="${grandTotalPending28 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor29 == '1105'}">
							<c:set var="grandTotalPending29" value="${grandTotalPending29 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor30 == '1105'}">
							<c:set var="grandTotalPending30" value="${grandTotalPending30 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor31 == '1105'}">
							<c:set var="grandTotalPending31" value="${grandTotalPending31 + 1}"></c:set>
						</c:if>
						<tr>				 
							<td><bean:write name="model" property="plateNo"/></td>
							<td><bean:write name="model" property="trailerNo"/></td>
							<td><bean:write name="model" property="lorryNo"/></td>
							<td align="right"><bean:write name="model" property="capacity"/></td>
							<c:choose>
								<c:when test="${model.gpsColor1 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;" value="<bean:write name="model" property="gps1"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','1','241');">
											<span class="tooltiptext1">
												Day: 1 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks1} <br>
												Trip Issue: ${model.gpsTripIssue1Desc}
											</span>
										</div>	
									</td>								
								</c:when>
								<c:when test="${model.gpsColor1 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;" value="<bean:write name="model" property="gps1"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','1','241');">
											<span class="tooltiptext1">
												Day: 1 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks1}<br>
												Trip Issue: ${model.gpsTripIssue1Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor1 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps1"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','1','241');">
											<span class="tooltiptext1">
												Day: 1 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks1}<br>
												Trip Issue: ${model.gpsTripIssue1Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor1 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps1"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','1','241');">
											<span class="tooltiptext1">
												Day: 1 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks1}<br>
												Trip Issue: ${model.gpsTripIssue1Desc}
											</span>
										</div>										
									</td>
								</c:when>								
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;" value="<bean:write name="model" property="gps1"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','1','241');">
											<span class="tooltiptext1">
												Day: 1 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks1}<br>
												Trip Issue: ${model.gpsTripIssue1Desc}
											</span>
										</div>									
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor1 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance1"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','1','242');">
											<span class="tooltiptext1">
												Day: 1 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks1}<br>
												Category: ${model.maintenanceCategory1Desc}
											</span>
										</div>	
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor1 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance1"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','1','242');">
											<span class="tooltiptext1">
												Day: 1 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks1}<br>
												Category: ${model.maintenanceCategory1Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor1 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance1"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','1','242');">
											<span class="tooltiptext1">
												Day: 1 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks1}<br>
												Category: ${model.maintenanceCategory1Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor1 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance1"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','1','242');">
											<span class="tooltiptext1">
												Day: 1 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks1}<br>
												Category: ${model.maintenanceCategory1Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor1 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance1"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','1','242');">
											<span class="tooltiptext1">
												Day: 1 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks1}<br>
												Category: ${model.maintenanceCategory1Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor1 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance1"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','1','242');">
											<span class="tooltiptext1">
												Day: 1 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks1}<br>
												Category: ${model.maintenanceCategory1Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance1"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','1','242');">
											<span class="tooltiptext1">
												Day: 1 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks1}<br>
												Category: ${model.maintenanceCategory1Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps1Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor2 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;" value="<bean:write name="model" property="gps2"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','2','241');">
											<span class="tooltiptext1">
												Day: 2 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks2}<br>
												Trip Issue: ${model.gpsTripIssue2Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor2 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;" value="<bean:write name="model" property="gps2"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','2','241');">
											<span class="tooltiptext1">
												Day: 2 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks2}<br>
												Trip Issue: ${model.gpsTripIssue2Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor2 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps2"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','2','241');">
											<span class="tooltiptext1">
												Day: 2 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks2}<br>
												Trip Issue: ${model.gpsTripIssue2Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor2 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps2"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','2','241');">
											<span class="tooltiptext1">
												Day: 2 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks2}<br>
												Trip Issue: ${model.gpsTripIssue2Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;" value="<bean:write name="model" property="gps2"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','2','241');">
											<span class="tooltiptext1">
												Day: 2 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks2}<br>
												Trip Issue: ${model.gpsTripIssue2Desc}
											</span>
										</div>									
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor2 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance2"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','2','242');">
											<span class="tooltiptext1">
												Day: 2 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks2}<br>
												Category: ${model.maintenanceCategory2Desc}
											</span>
										</div>									
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor2 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance2"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','2','242');">
											<span class="tooltiptext1">
												Day: 2 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks2}<br>
												Category: ${model.maintenanceCategory2Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor2 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance2"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','2','242');">
											<span class="tooltiptext1">
												Day: 2 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks2}<br>
												Category: ${model.maintenanceCategory2Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor2 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance2"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','2','242');">
											<span class="tooltiptext1">
												Day: 2 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks2}<br>
												Category: ${model.maintenanceCategory2Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor2 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance2"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','2','242');">
											<span class="tooltiptext1">
												Day: 2 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks2}<br>
												Category: ${model.maintenanceCategory2Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor2 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance2"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','2','242');">
											<span class="tooltiptext1">
												Day: 2 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks2}<br>
												Category: ${model.maintenanceCategory2Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance2"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','2','242');">
											<span class="tooltiptext1">
												Day: 2 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks2}<br>
												Category: ${model.maintenanceCategory2Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps2Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor3 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;" value="<bean:write name="model" property="gps3"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','3','241');">
											<span class="tooltiptext1">
												Day: 3 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks3} <br>
												Trip Issue: ${model.gpsTripIssue3Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor3 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;" value="<bean:write name="model" property="gps3"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','3','241');">
											<span class="tooltiptext1">
												Day: 3 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks3} <br>
												Trip Issue: ${model.gpsTripIssue3Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor3 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps3"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','3','241');">
											<span class="tooltiptext1">
												Day: 3 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks3} <br>
												Trip Issue: ${model.gpsTripIssue3Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor3 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps3"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','3','241');">
											<span class="tooltiptext1">
												Day: 3 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks3} <br>
												Trip Issue: ${model.gpsTripIssue3Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;" value="<bean:write name="model" property="gps3"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','3','241');">
											<span class="tooltiptext1">
												Day: 3 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks3} <br>
												Trip Issue: ${model.gpsTripIssue3Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor3 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance3"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','3','242');">
											<span class="tooltiptext1">
												Day: 3 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks3}<br>
												Category: ${model.maintenanceCategory3Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor3 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance3"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','3','242');">
											<span class="tooltiptext1">
												Day: 3 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks3}<br>
												Category: ${model.maintenanceCategory3Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor3 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance3"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','3','242');">
											<span class="tooltiptext1">
												Day: 3 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks3}<br>
												Category: ${model.maintenanceCategory3Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor3 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance3"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','3','242');">
											<span class="tooltiptext1">
												Day: 3 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks3}<br>
												Category: ${model.maintenanceCategory3Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor3 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance3"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','3','242');">
											<span class="tooltiptext1">
												Day: 3 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks3}<br>
												Category: ${model.maintenanceCategory3Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor3 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance3"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','3','242');">
											<span class="tooltiptext1">
												Day: 3 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks3}<br>
												Category: ${model.maintenanceCategory3Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance3"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','3','242');">
											<span class="tooltiptext1">
												Day: 3 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks3}<br>
												Category: ${model.maintenanceCategory3Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps3Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor4 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;" value="<bean:write name="model" property="gps4"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','4','241');">
											<span class="tooltiptext1">
												Day: 4 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks4} <br>
												Trip Issue: ${model.gpsTripIssue4Desc}
											</span>
										</div>	
									</td>
								</c:when>
								<c:when test="${model.gpsColor4 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;" value="<bean:write name="model" property="gps4"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','4','241');">
											<span class="tooltiptext1">
												Day: 4 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks4} <br>
												Trip Issue: ${model.gpsTripIssue4Desc}
											</span>
										</div>	
									</td>
								</c:when>
								<c:when test="${model.gpsColor4 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps4"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','4','241');">
											<span class="tooltiptext1">
												Day: 4 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks4} <br>
												Trip Issue: ${model.gpsTripIssue4Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor4 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps4"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','4','241');">
											<span class="tooltiptext1">
												Day: 4 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks4}<br>
												Trip Issue: ${model.gpsTripIssue4Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;" value="<bean:write name="model" property="gps4"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','4','241');">
											<span class="tooltiptext1">
												Day: 4 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks4}<br>
												Trip Issue: ${model.gpsTripIssue4Desc}
											</span>
										</div>	
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor4 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance4"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','4','242');">
											<span class="tooltiptext1">
												Day: 4 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks4}<br>
												Category: ${model.maintenanceCategory4Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor4 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance4"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','4','242');">
											<span class="tooltiptext1">
												Day: 4 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks4}<br>
												Category: ${model.maintenanceCategory4Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor4 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance4"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','4','242');">
											<span class="tooltiptext1">
												Day: 4 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks4}<br>
												Category: ${model.maintenanceCategory4Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor4 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance4"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','4','242');">
											<span class="tooltiptext1">
												Day: 4 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks4}<br>
												Category: ${model.maintenanceCategory4Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor4 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance4"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','4','242');">
											<span class="tooltiptext1">
												Day: 4 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks4}<br>
												Category: ${model.maintenanceCategory4Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor4 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance4"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','4','242');">
											<span class="tooltiptext1">
												Day: 4 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks4}<br>
												Category: ${model.maintenanceCategory4Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance4"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','4','242');">
											<span class="tooltiptext1">
												Day: 4 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks4}<br>
												Category: ${model.maintenanceCategory4Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps4Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor5 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;" value="<bean:write name="model" property="gps5"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','5','241');">
											<span class="tooltiptext1">
												Day: 5 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks5}<br>
												Trip Issue: ${model.gpsTripIssue5Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor5 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;" value="<bean:write name="model" property="gps5"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','5','241');">
											<span class="tooltiptext1">
												Day: 5 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks5}<br>
												Trip Issue: ${model.gpsTripIssue5Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor5 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps5"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','5','241');">
											<span class="tooltiptext1">
												Day: 5 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks5}<br>
												Trip Issue: ${model.gpsTripIssue5Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor5 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps5"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','5','241');">
											<span class="tooltiptext1">
												Day: 5 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks5}<br>
												Trip Issue: ${model.gpsTripIssue5Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;" value="<bean:write name="model" property="gps5"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','5','241');">
											<span class="tooltiptext1">
												Day: 5 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks5}<br>
												Trip Issue: ${model.gpsTripIssue5Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor5 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance5"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','5','242');">
											<span class="tooltiptext1">
												Day: 5 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks5}<br>
												Category: ${model.maintenanceCategory5Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor5 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance5"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','5','242');">
											<span class="tooltiptext1">
												Day: 5 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks5}<br>
												Category: ${model.maintenanceCategory5Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor5 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance5"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','5','242');">
											<span class="tooltiptext1">
												Day: 5 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks5}<br>
												Category: ${model.maintenanceCategory5Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor5 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance5"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','5','242');">
											<span class="tooltiptext1">
												Day: 5 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks5}<br>
												Category: ${model.maintenanceCategory5Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor5 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance5"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','5','242');">
											<span class="tooltiptext1">
												Day: 5 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks5}<br>
												Category: ${model.maintenanceCategory5Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor5 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance5"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','5','242');">
											<span class="tooltiptext1">
												Day: 5 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks5}<br>
												Category: ${model.maintenanceCategory5Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance5"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','5','242');">
											<span class="tooltiptext1">
												Day: 5 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks5}<br>
												Category: ${model.maintenanceCategory5Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps5Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor6 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;" value="<bean:write name="model" property="gps6"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','6','241');">
											<span class="tooltiptext1">
												Day: 6 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks6}<br>
												Trip Issue: ${model.gpsTripIssue6Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor6 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;" value="<bean:write name="model" property="gps6"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','6','241');">
											<span class="tooltiptext1">
												Day: 6 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks6}<br>
												Trip Issue: ${model.gpsTripIssue6Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor6 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps6"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','6','241');">
											<span class="tooltiptext1">
												Day: 6 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks6}<br>
												Trip Issue: ${model.gpsTripIssue6Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor6 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps6"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','6','241');">
											<span class="tooltiptext1">
												Day: 6 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks6}<br>
												Trip Issue: ${model.gpsTripIssue6Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;" value="<bean:write name="model" property="gps6"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','6','241');">
											<span class="tooltiptext1">
												Day: 6 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks6}<br>
												Trip Issue: ${model.gpsTripIssue6Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor6 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance6"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','6','242');">
											<span class="tooltiptext1">
												Day: 6 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks6}<br>
												Category: ${model.maintenanceCategory6Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor6 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance6"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','6','242');">
											<span class="tooltiptext1">
												Day: 6 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks6}<br>
												Category: ${model.maintenanceCategory6Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor6 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance6"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','6','242');">
											<span class="tooltiptext1">
												Day: 6 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks6}<br>
												Category: ${model.maintenanceCategory6Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor6 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance6"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','6','242');">
											<span class="tooltiptext1">
												Day: 6 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks6}<br>
												Category: ${model.maintenanceCategory6Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor6 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance6"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','6','242');">
											<span class="tooltiptext1">
												Day: 6 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks6}<br>
												Category: ${model.maintenanceCategory6Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor6 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance6"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','6','242');">
											<span class="tooltiptext1">
												Day: 6 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks6}<br>
												Category: ${model.maintenanceCategory6Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance6"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','6','242');">
											<span class="tooltiptext1">
												Day: 6 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks6}<br>
												Category: ${model.maintenanceCategory6Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps6Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor7 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;" value="<bean:write name="model" property="gps7"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','7','241');">
											<span class="tooltiptext1">
												Day: 7 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks7}<br>
												Trip Issue: ${model.gpsTripIssue7Desc}
											</span>
										</div>	
									</td>
								</c:when>
								<c:when test="${model.gpsColor7 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;" value="<bean:write name="model" property="gps7"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','7','241');">
											<span class="tooltiptext1">
												Day: 7 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks7}<br>
												Trip Issue: ${model.gpsTripIssue7Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor7 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps7"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','7','241');">
											<span class="tooltiptext1">
												Day: 7 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks7}<br>
												Trip Issue: ${model.gpsTripIssue7Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor7 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps7"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','7','241');">
											<span class="tooltiptext1">
												Day: 7 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks7}<br>
												Trip Issue: ${model.gpsTripIssue7Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;" value="<bean:write name="model" property="gps7"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','7','241');">
											<span class="tooltiptext1">
												Day: 7 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks7}<br>
												Trip Issue: ${model.gpsTripIssue7Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor7 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance7"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','7','242');">
											<span class="tooltiptext1">
												Day: 7 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks7}<br>
												Category: ${model.maintenanceCategory7Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor7 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance7"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','7','242');">
											<span class="tooltiptext1">
												Day: 7 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks7}<br>
												Category: ${model.maintenanceCategory7Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor7 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance7"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','7','242');">
											<span class="tooltiptext1">
												Day: 7 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks7}<br>
												Category: ${model.maintenanceCategory7Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor7 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance7"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','7','242');">
											<span class="tooltiptext1">
												Day: 7 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks7}<br>
												Category: ${model.maintenanceCategory7Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor7 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance7"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','7','242');">
											<span class="tooltiptext1">
												Day: 7 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks7}<br>
												Category: ${model.maintenanceCategory7Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor7 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance7"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','7','242');">
											<span class="tooltiptext1">
												Day: 7 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks7}<br>
												Category: ${model.maintenanceCategory7Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance7"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','7','242');">
											<span class="tooltiptext1">
												Day: 7 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks7}<br>
												Category: ${model.maintenanceCategory7Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps7Vol}" readonly="readonly"/></td>
							<td align="center" style="text-align: center; background-color: #FF8C00;"><input style="text-align: center; " type="text" size="1px" value="<bean:write name="model" property="totalTripsGPSWeek1"/>"></td>
							<td align="center"><input type="text" style="text-align: center; background-color: #FFFF00;" size="5px" value="${model.gpsWeek1Vol}" readonly="readonly"/></td>
							<td align="center" style="text-align: center; background-color: #FF8C00;"><input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="totalAvailabilityWeek1"/>"></td>
							<td align="center" style="text-align: center; background-color: #FF8C00;"><input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="percentageWeek1"/>"></td>
							<c:choose>
								<c:when test="${model.gpsColor8 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;" value="<bean:write name="model" property="gps8"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','8','241');">
											<span class="tooltiptext1">
												Day: 8 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks8}<br>
												Trip Issue: ${model.gpsTripIssue8Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor8 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;" value="<bean:write name="model" property="gps8"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','8','241');">
											<span class="tooltiptext1">
												Day: 8 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks8}<br>
												Trip Issue: ${model.gpsTripIssue8Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor8 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps8"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','8','241');">
											<span class="tooltiptext1">
												Day: 8 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks8}<br>
												Trip Issue: ${model.gpsTripIssue8Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor8 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps8"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','8','241');">
											<span class="tooltiptext1">
												Day: 8 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks8}<br>
												Trip Issue: ${model.gpsTripIssue8Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;" value="<bean:write name="model" property="gps8"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','8','241');">
											<span class="tooltiptext1">
												Day: 8 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks8}<br>
												Trip Issue: ${model.gpsTripIssue8Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor8 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance8"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','8','242');">
											<span class="tooltiptext1">
												Day: 8 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks8}<br>
												Category: ${model.maintenanceCategory8Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor8 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance8"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','8','242');">
											<span class="tooltiptext1">
												Day: 8 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks8}<br>
												Category: ${model.maintenanceCategory8Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor8 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance8"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','8','242');">
											<span class="tooltiptext1">
												Day: 8 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks8}<br>
												Category: ${model.maintenanceCategory8Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor8 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance8"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','8','242');">
											<span class="tooltiptext1">
												Day: 8 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks8}<br>
												Category: ${model.maintenanceCategory8Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor8 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance8"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','8','242');">
											<span class="tooltiptext1">
												Day: 8 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks8}<br>
												Category: ${model.maintenanceCategory8Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor8 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance8"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','8','242');">
											<span class="tooltiptext1">
												Day: 8 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks8}<br>
												Category: ${model.maintenanceCategory8Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance8"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','8','242');">
											<span class="tooltiptext1">
												Day: 8 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks8}<br>
												Category: ${model.maintenanceCategory8Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps8Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor9 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;" value="<bean:write name="model" property="gps9"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','9','241');">
											<span class="tooltiptext1">
												Day: 9 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks9}<br>
												Trip Issue: ${model.gpsTripIssue9Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor9 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;" value="<bean:write name="model" property="gps9"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','9','241');">
											<span class="tooltiptext1">
												Day: 9 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks9}<br>
												Trip Issue: ${model.gpsTripIssue9Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor9 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps9"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','9','241');">
											<span class="tooltiptext1">
												Day: 9 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks9}<br>
												Trip Issue: ${model.gpsTripIssue9Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor9 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps9"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','9','241');">
											<span class="tooltiptext1">
												Day: 9 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks9}<br>
												Trip Issue: ${model.gpsTripIssue9Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;" value="<bean:write name="model" property="gps9"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','9','241');">
											<span class="tooltiptext1">
												Day: 9 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks9}<br>
												Trip Issue: ${model.gpsTripIssue9Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor9 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance9"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','9','242');">
											<span class="tooltiptext1">
												Day: 9 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks9}<br>
												Category: ${model.maintenanceCategory9Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor9 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance9"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','9','242');">
											<span class="tooltiptext1">
												Day: 9 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks9}<br>
												Category: ${model.maintenanceCategory9Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor9 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance9"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','9','242');">
											<span class="tooltiptext1">
												Day: 9 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks9}<br>
												Category: ${model.maintenanceCategory9Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor9 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance9"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','9','242');">
											<span class="tooltiptext1">
												Day: 9 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks9}<br>
												Category: ${model.maintenanceCategory9Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor9 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance9"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','9','242');">
											<span class="tooltiptext1">
												Day: 9 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks9}<br>
												Category: ${model.maintenanceCategory9Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor9 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance9"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','9','242');">
											<span class="tooltiptext1">
												Day: 9 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks9}<br>
												Category: ${model.maintenanceCategory9Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance9"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','9','242');">
											<span class="tooltiptext1">
												Day: 9 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks9}<br>
												Category: ${model.maintenanceCategory9Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps9Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor10 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;" value="<bean:write name="model" property="gps10"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','10','241');">
											<span class="tooltiptext1">
												Day: 10 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks10}<br>
												Trip Issue: ${model.gpsTripIssue10Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor10 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;" value="<bean:write name="model" property="gps10"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','10','241');">
											<span class="tooltiptext1">
												Day: 10 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks10}<br>
												Trip Issue: ${model.gpsTripIssue10Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor10 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps10"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','10','241');">
											<span class="tooltiptext1">
												Day: 10 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks10}<br>
												Trip Issue: ${model.gpsTripIssue10Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor10 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps10"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','10','241');">
											<span class="tooltiptext1">
												Day: 10 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks10}<br>
												Trip Issue: ${model.gpsTripIssue10Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;" value="<bean:write name="model" property="gps10"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','10','241');">
											<span class="tooltiptext1">
												Day: 10 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks10}<br>
												Trip Issue: ${model.gpsTripIssue10Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor10 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance10"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','10','242');">
											<span class="tooltiptext1">
												Day: 10 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks10}<br>
												Category: ${model.maintenanceCategory10Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor10 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance10"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','10','242');">
											<span class="tooltiptext1">
												Day: 10 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks10}<br>
												Category: ${model.maintenanceCategory10Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor10 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance10"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','10','242');">
											<span class="tooltiptext1">
												Day: 10 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks10}<br>
												Category: ${model.maintenanceCategory10Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor10 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance10"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','10','242');">
											<span class="tooltiptext1">
												Day: 10 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks10}<br>
												Category: ${model.maintenanceCategory10Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor10 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance10"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','10','242');">
											<span class="tooltiptext1">
												Day: 10 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks10}<br>
												Category: ${model.maintenanceCategory10Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor10 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance10"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','10','242');">
											<span class="tooltiptext1">
												Day: 10 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks10}<br>
												Category: ${model.maintenanceCategory10Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance10"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','10','242');">
											<span class="tooltiptext1">
												Day: 10 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks10}<br>
												Category: ${model.maintenanceCategory10Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps10Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor11 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;" value="<bean:write name="model" property="gps11"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','11','241');">
											<span class="tooltiptext1">
												Day: 11 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks11}<br>
												Trip Issue: ${model.gpsTripIssue11Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor11 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;" value="<bean:write name="model" property="gps11"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','11','241');">
											<span class="tooltiptext1">
												Day: 11 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks11}<br>
												Trip Issue: ${model.gpsTripIssue11Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor11 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps11"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','11','241');">
											<span class="tooltiptext1">
												Day: 11 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks11}<br>
												Trip Issue: ${model.gpsTripIssue11Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor11 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps11"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','11','241');">
											<span class="tooltiptext1">
												Day: 11 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks11}<br>
												Trip Issue: ${model.gpsTripIssue11Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;" value="<bean:write name="model" property="gps11"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','11','241');">
											<span class="tooltiptext1">
												Day: 11 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks11}<br>
												Trip Issue: ${model.gpsTripIssue11Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor11 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance11"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','11','242');">
											<span class="tooltiptext1">
												Day: 11 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks11}<br>
												Category: ${model.maintenanceCategory11Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor11 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance11"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','11','242');">
											<span class="tooltiptext1">
												Day: 11 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks11}<br>
												Category: ${model.maintenanceCategory11Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor11 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance11"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','11','242');">
											<span class="tooltiptext1">
												Day: 11 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks11}<br>
												Category: ${model.maintenanceCategory11Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor11 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance11"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','11','242');">
											<span class="tooltiptext1">
												Day: 11 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks11}<br>
												Category: ${model.maintenanceCategory11Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor11 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance11"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','11','242');">
											<span class="tooltiptext1">
												Day: 11 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks11}<br>
												Category: ${model.maintenanceCategory11Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor11 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance11"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','11','242');">
											<span class="tooltiptext1">
												Day: 11 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks11}<br>
												Category: ${model.maintenanceCategory11Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance11"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','11','242');">
											<span class="tooltiptext1">
												Day: 11 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks11}<br>
												Category: ${model.maintenanceCategory11Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps11Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor12 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;" value="<bean:write name="model" property="gps12"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','12','241');">
											<span class="tooltiptext1">
												Day: 12 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks12}<br>
												Trip Issue: ${model.gpsTripIssue12Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor12 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;" value="<bean:write name="model" property="gps12"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','12','241');">
											<span class="tooltiptext1">
												Day: 12 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks12}<br>
												Trip Issue: ${model.gpsTripIssue12Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor12 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps12"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','12','241');">
											<span class="tooltiptext1">
												Day: 12 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks12}<br>
												Trip Issue: ${model.gpsTripIssue12Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor12 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps12"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','12','241');">
											<span class="tooltiptext1">
												Day: 12 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks12}<br>
												Trip Issue: ${model.gpsTripIssue12Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;" value="<bean:write name="model" property="gps12"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','12','241');">
											<span class="tooltiptext1">
												Day: 12 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks12}<br>
												Trip Issue: ${model.gpsTripIssue12Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor12 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance12"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','12','242');">
											<span class="tooltiptext1">
												Day: 12 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks12}<br>
												Category: ${model.maintenanceCategory12Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor12 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance12"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','12','242');">
											<span class="tooltiptext1">
												Day: 12 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks12}<br>
												Category: ${model.maintenanceCategory12Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor12 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance12"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','12','242');">
											<span class="tooltiptext1">
												Day: 12 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks12}<br>
												Category: ${model.maintenanceCategory12Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor12 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance12"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','12','242');">
											<span class="tooltiptext1">
												Day: 12 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks12}<br>
												Category: ${model.maintenanceCategory12Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor12 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance12"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','12','242');">
											<span class="tooltiptext1">
												Day: 12 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks12}<br>
												Category: ${model.maintenanceCategory12Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor12 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance12"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','12','242');">
											<span class="tooltiptext1">
												Day: 12 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks12}<br>
												Category: ${model.maintenanceCategory12Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance12"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','12','242');">
											<span class="tooltiptext1">
												Day: 12 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks12}<br>
												Category: ${model.maintenanceCategory12Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps12Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor13 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;" value="<bean:write name="model" property="gps13"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','13','241');">
											<span class="tooltiptext1">
												Day: 13 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks13}<br>
												Trip Issue: ${model.gpsTripIssue13Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor13 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;" value="<bean:write name="model" property="gps13"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','13','241');">
											<span class="tooltiptext1">
												Day: 13 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks13}<br>
												Trip Issue: ${model.gpsTripIssue13Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor13 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps13"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','13','241');">
											<span class="tooltiptext1">
												Day: 13 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks13}<br>
												Trip Issue: ${model.gpsTripIssue13Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor13 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps13"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','13','241');">
											<span class="tooltiptext1">
												Day: 13 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks13}<br>
												Trip Issue: ${model.gpsTripIssue13Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;" value="<bean:write name="model" property="gps13"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','13','241');">
											<span class="tooltiptext1">
												Day: 13 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks13}<br>
												Trip Issue: ${model.gpsTripIssue13Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor13 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance13"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','13','242');">
											<span class="tooltiptext1">
												Day: 13 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks13}<br>
												Category: ${model.maintenanceCategory13Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor13 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance13"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','13','242');">
											<span class="tooltiptext1">
												Day: 13 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks13}<br>
												Category: ${model.maintenanceCategory13Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor13 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance13"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','13','242');">
											<span class="tooltiptext1">
												Day: 13 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks13}<br>
												Category: ${model.maintenanceCategory13Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor13 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance13"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','13','242');">
											<span class="tooltiptext1">
												Day: 13 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks13}<br>
												Category: ${model.maintenanceCategory13Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor13 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance13"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','13','242');">
											<span class="tooltiptext1">
												Day: 13 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks13}<br>
												Category: ${model.maintenanceCategory13Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor13 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance13"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','13','242');">
											<span class="tooltiptext1">
												Day: 13 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks13}<br>
												Category: ${model.maintenanceCategory13Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance13"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','13','242');">
											<span class="tooltiptext1">
												Day: 13 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks13}<br>
												Category: ${model.maintenanceCategory13Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps3Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor14 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;" value="<bean:write name="model" property="gps14"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','14','241');">
											<span class="tooltiptext1">
												Day: 14 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks14}<br>
												Trip Issue: ${model.gpsTripIssue14Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor14 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;" value="<bean:write name="model" property="gps14"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','14','241');">
											<span class="tooltiptext1">
												Day: 14 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks14}<br>
												Trip Issue: ${model.gpsTripIssue14Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor14 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps14"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','14','241');">
											<span class="tooltiptext1">
												Day: 14 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks14}<br>
												Trip Issue: ${model.gpsTripIssue14Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor14 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps14"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','14','241');">
											<span class="tooltiptext1">
												Day: 14 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks14}<br>
												Trip Issue: ${model.gpsTripIssue14Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;" value="<bean:write name="model" property="gps14"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','14','241');">
											<span class="tooltiptext1">
												Day: 14 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks14}<br>
												Trip Issue: ${model.gpsTripIssue14Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor14 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance14"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','14','242');">
											<span class="tooltiptext1">
												Day: 14 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks14}<br>
												Category: ${model.maintenanceCategory14Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor14 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance14"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','14','242');">
											<span class="tooltiptext1">
												Day: 14 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks14}<br>
												Category: ${model.maintenanceCategory14Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor14 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance14"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','14','242');">
											<span class="tooltiptext1">
												Day: 14 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks14}<br>
												Category: ${model.maintenanceCategory14Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor14 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance14"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','14','242');">
											<span class="tooltiptext1">
												Day: 14 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks14}<br>
												Category: ${model.maintenanceCategory14Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor14 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance14"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','14','242');">
											<span class="tooltiptext1">
												Day: 14 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks14}<br>
												Category: ${model.maintenanceCategory14Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor14 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance14"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','14','242');">
											<span class="tooltiptext1">
												Day: 14 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks14}<br>
												Category: ${model.maintenanceCategory14Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance14"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','14','242');">
											<span class="tooltiptext1">
												Day: 14 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks14}<br>
												Category: ${model.maintenanceCategory14Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps14Vol}" readonly="readonly"/></td>
							<td align="center" style="text-align: center; background-color: #FF8C00;"><input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="totalTripsGPSWeek2"/>"></td>
							<td align="center"><input type="text" style="text-align: center; background-color: #FFFF00;" size="5px" value="${model.gpsWeek2Vol}" readonly="readonly"/></td>
							<td align="center" style="text-align: center; background-color: #FF8C00;"><input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="totalAvailabilityWeek2"/>"></td>
							<td align="center" style="text-align: center; background-color: #FF8C00;"><input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="percentageWeek2"/>"></td>
							<c:choose>
								<c:when test="${model.gpsColor15 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;" value="<bean:write name="model" property="gps15"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','15','241');">
											<span class="tooltiptext1">
												Day: 15 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks15}<br>
												Trip Issue: ${model.gpsTripIssue15Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor15 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;" value="<bean:write name="model" property="gps15"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','15','241');">
											<span class="tooltiptext1">
												Day: 15 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks15}<br>
												Trip Issue: ${model.gpsTripIssue15Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor15 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps15"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','15','241');">
											<span class="tooltiptext1">
												Day: 15 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks15}<br>
												Trip Issue: ${model.gpsTripIssue15Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor15 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps15"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','15','241');">
											<span class="tooltiptext1">
												Day: 15 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks15}<br>
												Trip Issue: ${model.gpsTripIssue15Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;" value="<bean:write name="model" property="gps15"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','15','241');">
											<span class="tooltiptext1">
												Day: 15 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks15}<br>
												Trip Issue: ${model.gpsTripIssue15Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor15 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance15"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','15','242');">
											<span class="tooltiptext1">
												Day: 15 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks15}<br>
												Category: ${model.maintenanceCategory15Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor15 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance15"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','15','242');">
											<span class="tooltiptext1">
												Day: 15 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks15}<br>
												Category: ${model.maintenanceCategory15Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor15 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance15"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','15','242');">
											<span class="tooltiptext1">
												Day: 15 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks15}<br>
												Category: ${model.maintenanceCategory15Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor15 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance15"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','15','242');">
											<span class="tooltiptext1">
												Day: 15 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks15}<br>
												Category: ${model.maintenanceCategory15Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor15 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance15"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','15','242');">
											<span class="tooltiptext1">
												Day: 15 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks15}<br>
												Category: ${model.maintenanceCategory15Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor15 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance15"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','15','242');">
											<span class="tooltiptext1">
												Day: 15 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks15}<br>
												Category: ${model.maintenanceCategory15Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance15"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','15','242');">
											<span class="tooltiptext1">
												Day: 15 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks15}<br>
												Category: ${model.maintenanceCategory15Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps15Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor16 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;" value="<bean:write name="model" property="gps16"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','16','241');">
											<span class="tooltiptext1">
												Day: 16 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks16}<br>
												Trip Issue: ${model.gpsTripIssue16Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor16 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;" value="<bean:write name="model" property="gps16"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','16','241');">
											<span class="tooltiptext1">
												Day: 16 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks16}<br>
												Trip Issue: ${model.gpsTripIssue16Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor16 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps16"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','16','241');">
											<span class="tooltiptext1">
												Day: 16 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks16}<br>
												Trip Issue: ${model.gpsTripIssue16Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor16 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps16"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','16','241');">
											<span class="tooltiptext1">
												Day: 16 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks16}<br>
												Trip Issue: ${model.gpsTripIssue16Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;" value="<bean:write name="model" property="gps16"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','16','241');">
											<span class="tooltiptext1">
												Day: 16 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks16}<br>
												Trip Issue: ${model.gpsTripIssue16Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor16 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance16"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','16','242');">
											<span class="tooltiptext1">
												Day: 16 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks16}<br>
												Category: ${model.maintenanceCategory16Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor16 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance16"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','16','242');">
											<span class="tooltiptext1">
												Day: 16 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks16}<br>
												Category: ${model.maintenanceCategory16Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor16 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance16"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','16','242');">
											<span class="tooltiptext1">
												Day: 16 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks16}<br>
												Category: ${model.maintenanceCategory16Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor16 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance16"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','16','242');">
											<span class="tooltiptext1">
												Day: 16 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks16}<br>
												Category: ${model.maintenanceCategory16Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor16 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance16"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','16','242');">
											<span class="tooltiptext1">
												Day: 16 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks16}<br>
												Category: ${model.maintenanceCategory16Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor16 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance16"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','16','242');">
											<span class="tooltiptext1">
												Day: 16 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks16}<br>
												Category: ${model.maintenanceCategory16Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance16"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','16','242');">
											<span class="tooltiptext1">
												Day: 16 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks16}<br>
												Category: ${model.maintenanceCategory16Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps16Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor17 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;" value="<bean:write name="model" property="gps17"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','17','241');">
											<span class="tooltiptext1">
												Day: 17 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks17}<br>
												Trip Issue: ${model.gpsTripIssue17Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor17 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;" value="<bean:write name="model" property="gps17"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','17','241');">
											<span class="tooltiptext1">
												Day: 17 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks17}<br>
												Trip Issue: ${model.gpsTripIssue17Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor17 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps17"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','17','241');">
											<span class="tooltiptext1">
												Day: 17 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks17}<br>
												Trip Issue: ${model.gpsTripIssue17Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor17 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps17"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','17','241');">
											<span class="tooltiptext1">
												Day: 17 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks17}<br>
												Trip Issue: ${model.gpsTripIssue17Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;" value="<bean:write name="model" property="gps17"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','17','241');">
											<span class="tooltiptext1">
												Day: 17 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks17}<br>
												Trip Issue: ${model.gpsTripIssue17Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor17 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance17"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','17','242');">
											<span class="tooltiptext1">
												Day: 17 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks17}<br>
												Category: ${model.maintenanceCategory17Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor17 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance17"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','17','242');">
											<span class="tooltiptext1">
												Day: 17 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks17}<br>
												Category: ${model.maintenanceCategory17Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor17 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance17"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','17','242');">
											<span class="tooltiptext1">
												Day: 17 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks17}<br>
												Category: ${model.maintenanceCategory17Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor17 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance17"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','17','242');">
											<span class="tooltiptext1">
												Day: 17 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks17}<br>
												Category: ${model.maintenanceCategory17Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor17 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance17"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','17','242');">
											<span class="tooltiptext1">
												Day: 17 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks17}<br>
												Category: ${model.maintenanceCategory17Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor17 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance17"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','17','242');">
											<span class="tooltiptext1">
												Day: 17 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks17}<br>
												Category: ${model.maintenanceCategory17Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance17"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','17','242');">
											<span class="tooltiptext1">
												Day: 17 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks17}<br>
												Category: ${model.maintenanceCategory17Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps17Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor18 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;" value="<bean:write name="model" property="gps18"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','18','241');">
											<span class="tooltiptext1">
												Day: 18 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks18}<br>
												Trip Issue: ${model.gpsTripIssue18Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor18 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;" value="<bean:write name="model" property="gps18"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','18','241');">
											<span class="tooltiptext1">
												Day: 18 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks18}<br>
												Trip Issue: ${model.gpsTripIssue18Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor18 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps18"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','18','241');">
											<span class="tooltiptext1">
												Day: 18 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks18}<br>
												Trip Issue: ${model.gpsTripIssue18Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor18 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps18"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','18','241');">
											<span class="tooltiptext1">
												Day: 18 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks18}<br>
												Trip Issue: ${model.gpsTripIssue18Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;" value="<bean:write name="model" property="gps18"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','18','241');">
											<span class="tooltiptext1">
												Day: 18 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks18}<br>
												Trip Issue: ${model.gpsTripIssue18Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor18 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance18"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','18','242');">
											<span class="tooltiptext1">
												Day: 18 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks18}<br>
												Category: ${model.maintenanceCategory18Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor18 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance18"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','18','242');">
											<span class="tooltiptext1">
												Day: 18 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks18}<br>
												Category: ${model.maintenanceCategory18Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor18 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance18"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','18','242');">
											<span class="tooltiptext1">
												Day: 18 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks18}<br>
												Category: ${model.maintenanceCategory18Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor18 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance18"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','18','242');">
											<span class="tooltiptext1">
												Day: 18 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks18}<br>
												Category: ${model.maintenanceCategory18Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor18 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance18"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','18','242');">
											<span class="tooltiptext1">
												Day: 18 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks18}<br>
												Category: ${model.maintenanceCategory18Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor18 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance18"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','18','242');">
											<span class="tooltiptext1">
												Day: 18 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks18}<br>
												Category: ${model.maintenanceCategory18Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance18"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','18','242');">
											<span class="tooltiptext1">
												Day: 18 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks18}<br>
												Category: ${model.maintenanceCategory18Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps18Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor19 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;" value="<bean:write name="model" property="gps19"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','19','241');">
											<span class="tooltiptext1">
												Day: 19 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks19}<br>
												Trip Issue: ${model.gpsTripIssue19Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor19 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;" value="<bean:write name="model" property="gps19"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','19','241');">
											<span class="tooltiptext1">
												Day: 19 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks19}<br>
												Trip Issue: ${model.gpsTripIssue19Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor19 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps19"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','19','241');">
											<span class="tooltiptext1">
												Day: 19 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks19}<br>
												Trip Issue: ${model.gpsTripIssue19Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor19 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps19"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','19','241');">
											<span class="tooltiptext1">
												Day: 19 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks19}<br>
												Trip Issue: ${model.gpsTripIssue19Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;" value="<bean:write name="model" property="gps19"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','19','241');">
											<span class="tooltiptext1">
												Day: 19 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks19}<br>
												Trip Issue: ${model.gpsTripIssue19Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor19 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance19"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','19','242');">
											<span class="tooltiptext1">
												Day: 19 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks19}<br>
												Category: ${model.maintenanceCategory19Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor19 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance19"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','19','242');">
											<span class="tooltiptext1">
												Day: 19 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks19}<br>
												Category: ${model.maintenanceCategory19Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor19 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance19"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','19','242');">
											<span class="tooltiptext1">
												Day: 19 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks19}<br>
												Category: ${model.maintenanceCategory19Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor19 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance19"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','19','242');">s
											<span class="tooltiptext1">
												Day: 19 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks19}<br>
												Category: ${model.maintenanceCategory19Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor19 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance19"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','19','242');">
											<span class="tooltiptext1">
												Day: 19 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks19}<br>
												Category: ${model.maintenanceCategory19Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor19 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance19"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','19','242');">
											<span class="tooltiptext1">
												Day: 19 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks19}<br>
												Category: ${model.maintenanceCategory19Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance19"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','19','242');">
											<span class="tooltiptext1">
												Day: 19 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks19}<br>
												Category: ${model.maintenanceCategory19Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps19Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor20 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;" value="<bean:write name="model" property="gps20"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','20','241');">
											<span class="tooltiptext1">
												Day: 20 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks20}<br>
												Trip Issue: ${model.gpsTripIssue20Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor20 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;" value="<bean:write name="model" property="gps20"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','20','241');">
											<span class="tooltiptext1">
												Day: 20 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks20}<br>
												Trip Issue: ${model.gpsTripIssue20Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor20 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps20"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','20','241');">
											<span class="tooltiptext1">
												Day: 20 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks20}<br>
												Trip Issue: ${model.gpsTripIssue20Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor20 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps20"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','20','241');">
											<span class="tooltiptext1">
												Day: 20 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks20}<br>
												Trip Issue: ${model.gpsTripIssue20Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;" value="<bean:write name="model" property="gps20"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','20','241');">
											<span class="tooltiptext1">
												Day: 20 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks20}<br>
												Trip Issue: ${model.gpsTripIssue20Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor20 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance20"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','20','242');">
											<span class="tooltiptext1">
												Day: 20 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks20}<br>
												Category: ${model.maintenanceCategory20Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor20 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance20"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','20','242');">
											<span class="tooltiptext1">
												Day: 20 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks20}<br>
												Category: ${model.maintenanceCategory20Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor20 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance20"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','20','242');">
											<span class="tooltiptext1">
												Day: 20 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks20}<br>
												Category: ${model.maintenanceCategory20Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor20 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance20"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','20','242');">
											<span class="tooltiptext1">
												Day: 20 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks20}<br>
												Category: ${model.maintenanceCategory20Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor20 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance20"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','20','242');">
											<span class="tooltiptext1">
												Day: 20 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks20}<br>
												Category: ${model.maintenanceCategory20Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor20 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance20"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','20','242');">
											<span class="tooltiptext1">
												Day: 20 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks20}<br>
												Category: ${model.maintenanceCategory20Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance20"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','20','242');">
											<span class="tooltiptext1">
												Day: 20 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks20}<br>
												Category: ${model.maintenanceCategory20Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps20Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor21 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;" value="<bean:write name="model" property="gps21"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','21','241');">
											<span class="tooltiptext1">
												Day: 21 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks21}<br>
												Trip Issue: ${model.gpsTripIssue21Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor21 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;" value="<bean:write name="model" property="gps21"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','21','241');">
											<span class="tooltiptext1">
												Day: 21 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks21}<br>
												Trip Issue: ${model.gpsTripIssue21Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor21 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps21"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','21','241');">
											<span class="tooltiptext1">
												Day: 21 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks21}<br>
												Trip Issue: ${model.gpsTripIssue21Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor21 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps21"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','21','241');">
											<span class="tooltiptext1">
												Day: 21 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks21}<br>
												Trip Issue: ${model.gpsTripIssue21Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;" value="<bean:write name="model" property="gps21"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','21','241');">
											<span class="tooltiptext1">
												Day: 21 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks21}<br>
												Trip Issue: ${model.gpsTripIssue21Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor21 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance21"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','21','242');">
											<span class="tooltiptext1">
												Day: 21 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks21}<br>
												Category: ${model.maintenanceCategory21Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor21 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance21"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','21','242');">
											<span class="tooltiptext1">
												Day: 21 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks21}<br>
												Category: ${model.maintenanceCategory21Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor21 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance21"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','21','242');">
											<span class="tooltiptext1">
												Day: 21 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks21}<br>
												Category: ${model.maintenanceCategory21Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor21 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance21"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','21','242');">
											<span class="tooltiptext1">
												Day: 21 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks21}<br>
												Category: ${model.maintenanceCategory21Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor21 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance21"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','21','242');">
											<span class="tooltiptext1">
												Day: 21 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks21}<br>
												Category: ${model.maintenanceCategory21Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor21 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance21"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','21','242');">
											<span class="tooltiptext1">
												Day: 21 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks21}<br>
												Category: ${model.maintenanceCategory21Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance21"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','21','242');">
											<span class="tooltiptext1">
												Day: 21 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks21}<br>
												Category: ${model.maintenanceCategory21Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps21Vol}" readonly="readonly"/></td>
							<td align="center" style="text-align: center; background-color: #FF8C00;"><input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="totalTripsGPSWeek3"/>"></td>
							<td align="center"><input type="text" style="text-align: center; background-color: #FFFF00;" size="5px" value="${model.gpsWeek3Vol}" readonly="readonly"/></td>
							<td align="center" style="text-align: center; background-color: #FF8C00;"><input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="totalAvailabilityWeek3"/>"></td>
							<td align="center" style="text-align: center; background-color: #FF8C00;"><input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="percentageWeek3"/>"></td>
							<c:choose>
								<c:when test="${model.gpsColor22 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;" value="<bean:write name="model" property="gps22"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','22','241');">
											<span class="tooltiptext1">
												Day: 22 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks22}<br>
												Trip Issue: ${model.gpsTripIssue22Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor22 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;" value="<bean:write name="model" property="gps22"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','22','241');">
											<span class="tooltiptext1">
												Day: 22 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks22}<br>
												Trip Issue: ${model.gpsTripIssue22Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor22 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps22"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','22','241');">
											<span class="tooltiptext1">
												Day: 22 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks22}<br>
												Trip Issue: ${model.gpsTripIssue22Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor22 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps22"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','22','241');">
											<span class="tooltiptext1">
												Day: 22 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks22}<br>
												Trip Issue: ${model.gpsTripIssue22Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;" value="<bean:write name="model" property="gps22"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','22','241');">
											<span class="tooltiptext1">
												Day: 22 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks22}<br>
												Trip Issue: ${model.gpsTripIssue22Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor22 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance22"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','22','242');">
											<span class="tooltiptext1">
												Day: 22 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks22}<br>
												Category: ${model.maintenanceCategory22Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor22 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance22"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','22','242');">
											<span class="tooltiptext1">
												Day: 22 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks22}<br>
												Category: ${model.maintenanceCategory22Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor22 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance22"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','22','242');">
											<span class="tooltiptext1">
												Day: 22 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks22}<br>
												Category: ${model.maintenanceCategory22Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor22 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance22"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','22','242');">
											<span class="tooltiptext1">
												Day: 22 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks22}<br>
												Category: ${model.maintenanceCategory22Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor22 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance22"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','22','242');">
											<span class="tooltiptext1">
												Day: 22 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks22}<br>
												Category: ${model.maintenanceCategory22Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor22 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance22"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','22','242');">
											<span class="tooltiptext1">
												Day: 22 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks22}<br>
												Category: ${model.maintenanceCategory22Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance22"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','22','242');">
											<span class="tooltiptext1">
												Day: 22 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks22}<br>
												Category: ${model.maintenanceCategory22Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps22Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor23 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;" value="<bean:write name="model" property="gps23"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','23','241');">
											<span class="tooltiptext1">
												Day: 23 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks23}<br>
												Trip Issue: ${model.gpsTripIssue23Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor23 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;" value="<bean:write name="model" property="gps23"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','23','241');">
											<span class="tooltiptext1">
												Day: 23 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks23}<br>
												Trip Issue: ${model.gpsTripIssue23Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor23 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps23"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','23','241');">
											<span class="tooltiptext1">
												Day: 23 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks23}<br>
												Trip Issue: ${model.gpsTripIssue23Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor23 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps23"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','23','241');">
											<span class="tooltiptext1">
												Day: 23 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks23}<br>
												Trip Issue: ${model.gpsTripIssue23Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;" value="<bean:write name="model" property="gps23"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','23','241');">
											<span class="tooltiptext1">
												Day: 23 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks23}<br>
												Trip Issue: ${model.gpsTripIssue23Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor23 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance23"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','23','242');">
											<span class="tooltiptext1">
												Day: 23 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks23}<br>
												Category: ${model.maintenanceCategory23Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor23 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance23"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','23','242');">
											<span class="tooltiptext1">
												Day: 23 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks23}<br>
												Category: ${model.maintenanceCategory23Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor23 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance23"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','23','242');">
											<span class="tooltiptext1">
												Day: 23 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks23}<br>
												Category: ${model.maintenanceCategory23Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor23 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance23"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','23','242');">
											<span class="tooltiptext1">
												Day: 23 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks23}<br>
												Category: ${model.maintenanceCategory23Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor23 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance23"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','23','242');">
											<span class="tooltiptext1">
												Day: 23 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks23}<br>
												Category: ${model.maintenanceCategory23Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor23 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance23"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','23','242');">
											<span class="tooltiptext1">
												Day: 23 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks23}<br>
												Category: ${model.maintenanceCategory23Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance23"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','23','242');">
											<span class="tooltiptext1">
												Day: 23 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks23}<br>
												Category: ${model.maintenanceCategory23Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps23Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor24 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;" value="<bean:write name="model" property="gps24"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','24','241');">
											<span class="tooltiptext1">
												Day: 24 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks24}<br>
												Trip Issue: ${model.gpsTripIssue24Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor24 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;" value="<bean:write name="model" property="gps24"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','24','241');">
											<span class="tooltiptext1">
												Day: 24 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks24}<br>
												Trip Issue: ${model.gpsTripIssue24Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor24 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps24"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','24','241');">
											<span class="tooltiptext1">
												Day: 24 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks24}<br>
												Trip Issue: ${model.gpsTripIssue24Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor24 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps24"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','24','241');">
											<span class="tooltiptext1">
												Day: 24 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks24}<br>
												Trip Issue: ${model.gpsTripIssue24Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;" value="<bean:write name="model" property="gps24"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','24','241');">
											<span class="tooltiptext1">
												Day: 24 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks24}<br>
												Trip Issue: ${model.gpsTripIssue24Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor24 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance24"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','24','242');">
											<span class="tooltiptext1">
												Day: 24 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks24}<br>
												Category: ${model.maintenanceCategory24Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor24 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance24"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','24','242');">
											<span class="tooltiptext1">
												Day: 24 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks24}<br>
												Category: ${model.maintenanceCategory24Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor24 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance24"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','24','242');">
											<span class="tooltiptext1">
												Day: 24 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks24}<br>
												Category: ${model.maintenanceCategory24Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor24 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance24"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','24','242');">
											<span class="tooltiptext1">
												Day: 24 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks24}<br>
												Category: ${model.maintenanceCategory24Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor24 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance24"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','24','242');">
											<span class="tooltiptext1">
												Day: 24 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks24}<br>
												Category: ${model.maintenanceCategory24Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor24 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance24"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','24','242');">
											<span class="tooltiptext1">
												Day: 24 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks24}<br>
												Category: ${model.maintenanceCategory24Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance24"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','24','242');">
											<span class="tooltiptext1">
												Day: 24 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks24}<br>
												Category: ${model.maintenanceCategory24Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps24Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor25 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;" value="<bean:write name="model" property="gps25"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','25','241');">
											<span class="tooltiptext1">
												Day: 25 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks25}<br>
												Trip Issue: ${model.gpsTripIssue25Desc}
											</span>
										</div>	
									</td>
								</c:when>
								<c:when test="${model.gpsColor25 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;" value="<bean:write name="model" property="gps25"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','25','241');">
											<span class="tooltiptext1">
												Day: 25 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks25}<br>
												Trip Issue: ${model.gpsTripIssue25Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor25 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps25"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','25','241');">
											<span class="tooltiptext1">
												Day: 25 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks25}<br>
												Trip Issue: ${model.gpsTripIssue25Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor25 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps25"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','25','241');">
											<span class="tooltiptext1">
												Day: 25 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks25}<br>
												Trip Issue: ${model.gpsTripIssue25Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;" value="<bean:write name="model" property="gps25"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','25','241');">
											<span class="tooltiptext1">
												Day: 25 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks25}<br>
												Trip Issue: ${model.gpsTripIssue25Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor25 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance25"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','25','242');">
											<span class="tooltiptext1">
												Day: 25 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks25}<br>
												Category: ${model.maintenanceCategory25Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor25 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance25"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','25','242');">
											<span class="tooltiptext1">
												Day: 25 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks25}<br>
												Category: ${model.maintenanceCategory25Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor25 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance25"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','25','242');">
											<span class="tooltiptext1">
												Day: 25 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks25}<br>
												Category: ${model.maintenanceCategory25Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor25 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance25"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','25','242');">
											<span class="tooltiptext1">
												Day: 25 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks25}<br>
												Category: ${model.maintenanceCategory25Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor25 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance25"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','25','242');">
											<span class="tooltiptext1">
												Day: 25 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks25}<br>
												Category: ${model.maintenanceCategory25Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor25 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance25"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','25','242');">
											<span class="tooltiptext1">
												Day: 25 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks25}<br>
												Category: ${model.maintenanceCategory25Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance25"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','25','242');">
											<span class="tooltiptext1">
												Day: 25 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks25}<br>
												Category: ${model.maintenanceCategory25Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps25Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor26 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;" value="<bean:write name="model" property="gps26"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','26','241');">
											<span class="tooltiptext1">
												Day: 26 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks26}<br>
												Trip Issue: ${model.gpsTripIssue26Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor26 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;" value="<bean:write name="model" property="gps26"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','26','241');">
											<span class="tooltiptext1">
												Day: 26 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks26}<br>
												Trip Issue: ${model.gpsTripIssue26Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor26 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps26"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','26','241');">
											<span class="tooltiptext1">
												Day: 26 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks26}<br>
												Trip Issue: ${model.gpsTripIssue26Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor26 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps26"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','26','241');">
											<span class="tooltiptext1">
												Day: 26 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks26}<br>
												Trip Issue: ${model.gpsTripIssue26Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;" value="<bean:write name="model" property="gps26"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','26','241');">
											<span class="tooltiptext1">
												Day: 26 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks26}<br>
												Trip Issue: ${model.gpsTripIssue26Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor26 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance26"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','26','242');">
											<span class="tooltiptext1">
												Day: 26 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks26}<br>
												Category: ${model.maintenanceCategory26Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor26 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance26"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','26','242');">
											<span class="tooltiptext1">
												Day: 26 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks26}<br>
												Category: ${model.maintenanceCategory26Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor26 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance26"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','26','242');">
											<span class="tooltiptext1">
												Day: 26 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks26}<br>
												Category: ${model.maintenanceCategory26Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor26 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance26"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','26','242');">
											<span class="tooltiptext1">
												Day: 26 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks26}<br>
												Category: ${model.maintenanceCategory26Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor26 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance26"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','26','242');">
											<span class="tooltiptext1">
												Day: 26 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks26}<br>
												Category: ${model.maintenanceCategory26Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor26 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance26"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','26','242');">
											<span class="tooltiptext1">
												Day: 26 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks26}<br>
												Category: ${model.maintenanceCategory26Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance26"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','26','242');">
											<span class="tooltiptext1">
												Day: 26 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks26}<br>
												Category: ${model.maintenanceCategory26Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps26Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor27 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;" value="<bean:write name="model" property="gps27"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','27','241');">
											<span class="tooltiptext1">
												Day: 27 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks27}<br>
												Trip Issue: ${model.gpsTripIssue27Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor27 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;" value="<bean:write name="model" property="gps27"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','27','241');">
											<span class="tooltiptext1">
												Day: 27 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks27}<br>
												Trip Issue: ${model.gpsTripIssue27Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor27 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps27"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','27','241');">
											<span class="tooltiptext1">
												Day: 27 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks27}<br>
												Trip Issue: ${model.gpsTripIssue27Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor27 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps27"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','27','241');">
											<span class="tooltiptext1">
												Day: 27 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks27}<br>
												Trip Issue: ${model.gpsTripIssue27Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;" value="<bean:write name="model" property="gps27"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','27','241');">
											<span class="tooltiptext1">
												Day: 27 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks27}<br>
												Trip Issue: ${model.gpsTripIssue27Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor27 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance27"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','27','242');">
											<span class="tooltiptext1">
												Day: 27 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks27}<br>
												Category: ${model.maintenanceCategory27Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor27 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance27"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','27','242');">
											<span class="tooltiptext1">
												Day: 27 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks27}<br>
												Category: ${model.maintenanceCategory27Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor27 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance27"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','27','242');">
											<span class="tooltiptext1">
												Day: 27 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks27}<br>
												Category: ${model.maintenanceCategory27Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor27 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance27"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','27','242');">
											<span class="tooltiptext1">
												Day: 27 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks27}<br>
												Category: ${model.maintenanceCategory27Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor27 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance27"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','27','242');">
											<span class="tooltiptext1">
												Day: 27 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks27}<br>
												Category: ${model.maintenanceCategory27Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor27 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance27"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','27','242');">
											<span class="tooltiptext1">
												Day: 27 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks27}<br>
												Category: ${model.maintenanceCategory27Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance27"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','27','242');">
											<span class="tooltiptext1">
												Day: 27 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks27}<br>
												Category: ${model.maintenanceCategory27Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps27Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor28 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;" value="<bean:write name="model" property="gps28"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','28','241');">
											<span class="tooltiptext1">
												Day: 28 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks28}<br>
												Trip Issue: ${model.gpsTripIssue28Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor28 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;" value="<bean:write name="model" property="gps28"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','28','241');">
											<span class="tooltiptext1">
												Day: 28 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks28}<br>
												Trip Issue: ${model.gpsTripIssue28Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor28 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps28"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','28','241');">
											<span class="tooltiptext1">
												Day: 28 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks28}<br>
												Trip Issue: ${model.gpsTripIssue28Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor28 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps28"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','28','241');">
											<span class="tooltiptext1">
												Day: 28 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks28}<br>
												Trip Issue: ${model.gpsTripIssue28Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;" value="<bean:write name="model" property="gps28"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','28','241');">
											<span class="tooltiptext1">
												Day: 28 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks28}<br>
												Trip Issue: ${model.gpsTripIssue28Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor28 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance28"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','28','242');">
											<span class="tooltiptext1">
												Day: 28 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks28}<br>
												Category: ${model.maintenanceCategory28Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor28 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance28"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','28','242');">
											<span class="tooltiptext1">
												Day: 28 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks28}<br>
												Category: ${model.maintenanceCategory28Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor28 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance28"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','28','242');">
											<span class="tooltiptext1">
												Day: 28 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks28}<br>
												Category: ${model.maintenanceCategory28Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor28 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance28"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','28','242');">
											<span class="tooltiptext1">
												Day: 28 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks28}<br>
												Category: ${model.maintenanceCategory28Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor28 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance28"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','28','242');">
											<span class="tooltiptext1">
												Day: 28 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks28}<br>
												Category: ${model.maintenanceCategory28Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor28 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance28"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','28','242');">
											<span class="tooltiptext1">
												Day: 28 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks28}<br>
												Category: ${model.maintenanceCategory28Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance28"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','28','242');">
											<span class="tooltiptext1">
												Day: 28 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks28}<br>
												Category: ${model.maintenanceCategory28Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps28Vol}" readonly="readonly"/></td>
							<td align="center" style="text-align: center; background-color: #FF8C00;"><input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="totalTripsGPSWeek4"/>"></td>
							<td align="center"><input type="text" style="text-align: center; background-color: #FFFF00;" size="5px" value="${model.gpsWeek4Vol}" readonly="readonly"/></td>
							<td align="center" style="text-align: center; background-color: #FF8C00;"><input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="totalAvailabilityWeek4"/>"></td>
							<td align="center" style="text-align: center; background-color: #FF8C00;"><input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="percentageWeek4"/>"></td>
							<c:choose>
								<c:when test="${model.gpsColor29 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;" value="<bean:write name="model" property="gps29"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','29','241');">
											<span class="tooltiptext1">
												Day: 29 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks29}<br>
												Trip Issue: ${model.gpsTripIssue29Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor29 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;" value="<bean:write name="model" property="gps29"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','29','241');">
											<span class="tooltiptext1">
												Day: 29 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks29}<br>
												Trip Issue: ${model.gpsTripIssue29Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor29 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps29"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','29','241');">
											<span class="tooltiptext1">
												Day: 29 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks29}<br>
												Trip Issue: ${model.gpsTripIssue29Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor29 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps29"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','29','241');">
											<span class="tooltiptext1">
												Day: 29 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks29}<br>
												Trip Issue: ${model.gpsTripIssue29Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;" value="<bean:write name="model" property="gps29"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','29','241');">
											<span class="tooltiptext1">
												Day: 29 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks29}<br>
												Trip Issue: ${model.gpsTripIssue29Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor29 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance29"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','29','242');">
											<span class="tooltiptext1">
												Day: 29 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks29}<br>
												Category: ${model.maintenanceCategory29Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor29 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance29"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','29','242');">
											<span class="tooltiptext1">
												Day: 29 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks29}<br>
												Category: ${model.maintenanceCategory29Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor29 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance29"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','29','242');">
											<span class="tooltiptext1">
												Day: 29 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks29}<br>
												Category: ${model.maintenanceCategory29Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor29 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance29"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','29','242');">
											<span class="tooltiptext1">
												Day: 29 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks29}<br>
												Category: ${model.maintenanceCategory29Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor29 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance29"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','29','242');">
											<span class="tooltiptext1">
												Day: 29 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks29}<br>
												Category: ${model.maintenanceCategory29Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor29 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance29"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','29','242');">
											<span class="tooltiptext1">
												Day: 29 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks29}<br>
												Category: ${model.maintenanceCategory29Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance29"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','29','242');">
											<span class="tooltiptext1">
												Day: 29 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks29}<br>
												Category: ${model.maintenanceCategory29Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps29Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor30 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;" value="<bean:write name="model" property="gps30"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','30','241');">
											<span class="tooltiptext1">
												Day: 30 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks30}<br>
												Trip Issue: ${model.gpsTripIssue30Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor30 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;" value="<bean:write name="model" property="gps30"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','30','241');">
											<span class="tooltiptext1">
												Day: 30 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks30}<br>
												Trip Issue: ${model.gpsTripIssue30Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor30 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps30"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','30','241');">
											<span class="tooltiptext1">
												Day: 30 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks30}<br>
												Trip Issue: ${model.gpsTripIssue30Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor30 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps30"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','30','241');">
											<span class="tooltiptext1">
												Day: 30 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks30}<br>
												Trip Issue: ${model.gpsTripIssue30Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;" value="<bean:write name="model" property="gps30"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','30','241');">
											<span class="tooltiptext1">
												Day: 30 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks30}<br>
												Trip Issue: ${model.gpsTripIssue30Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor30 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance30"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','30','242');">
											<span class="tooltiptext1">
												Day: 30 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks30}<br>
												Category: ${model.maintenanceCategory30Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor30 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance30"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','30','242');">
											<span class="tooltiptext1">
												Day: 30 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks30}<br>
												Category: ${model.maintenanceCategory30Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor30 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance30"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','30','242');">
											<span class="tooltiptext1">
												Day: 30 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks30}<br>
												Category: ${model.maintenanceCategory30Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor30 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance30"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','30','242');">
											<span class="tooltiptext1">
												Day: 30 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks30}<br>
												Category: ${model.maintenanceCategory30Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor30 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance30"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','30','242');">
											<span class="tooltiptext1">
												Day: 30 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks30}<br>
												Category: ${model.maintenanceCategory30Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor30 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance30"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','30','242');">
											<span class="tooltiptext1">
												Day: 30 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks30}<br>
												Category: ${model.maintenanceCategory30Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance30"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','30','242');">
											<span class="tooltiptext1">
												Day: 30 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks30}<br>
												Category: ${model.maintenanceCategory30Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps30Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor31 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;" value="<bean:write name="model" property="gps31"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','31','241');">
											<span class="tooltiptext1">
												Day: 31 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks31}<br>
												Trip Issue: ${model.gpsTripIssue31Desc}
											</span>
										</div>	
									</td>
								</c:when>
								<c:when test="${model.gpsColor31 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;" value="<bean:write name="model" property="gps31"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','31','241');">
											<span class="tooltiptext1">
												Day: 31 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks31}<br>
												Trip Issue: ${model.gpsTripIssue31Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor31 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps31"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','31','241');">
											<span class="tooltiptext1">
												Day: 31 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks31}<br>
												Trip Issue: ${model.gpsTripIssue31Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor31 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps31"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','31','241');">
											<span class="tooltiptext1">
												Day: 31 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks31}<br>
												Trip Issue: ${model.gpsTripIssue31Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;" value="<bean:write name="model" property="gps31"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','31','241');">
											<span class="tooltiptext1">
												Day: 31 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks31}<br>
												Trip Issue: ${model.gpsTripIssue31Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor31 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance31"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','31','242');">
											<span class="tooltiptext1">
												Day: 31 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks31}<br>
												Category: ${model.maintenanceCategory31Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor31 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance31"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','31','242');">
											<span class="tooltiptext1">
												Day: 31 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks31}<br>
												Category: ${model.maintenanceCategory31Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor31 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance31"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','31','242');">
											<span class="tooltiptext1">
												Day: 31 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks31}<br>
												Category: ${model.maintenanceCategory31Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor31 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance31"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','31','242');">
											<span class="tooltiptext1">
												Day: 31 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks31}<br>
												Category: ${model.maintenanceCategory31Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor31 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance31"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','31','242');">
											<span class="tooltiptext1">
												Day: 31 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks31}<br>
												Category: ${model.maintenanceCategory31Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor31 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance31"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','31','242');">
											<span class="tooltiptext1">
												Day: 31 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks31}<br>
												Category: ${model.maintenanceCategory31Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance31"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','31','242');">
											<span class="tooltiptext1">
												Day: 31 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks31}<br>
												Category: ${model.maintenanceCategory31Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps31Vol}" readonly="readonly"/></td>
							<td align="center" style="text-align: center; background-color: #FF8C00;"><input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="totalTripsGPSWeek5"/>"></td>
							<td align="center"><input type="text" style="text-align: center; background-color: #FFFF00;" size="5px" value="${model.gpsWeek5Vol}" readonly="readonly"/></td>
							<td align="center"><input type="text" style="text-align: center; background-color: #FFFF00;" size="7px" value="${model.gpsMonthVol}" readonly="readonly"/></td>
							<td><input style="text-align: center; font-weight: bold;" type="text" size="1px" value="<bean:write name="model" property="totalMaintenance"/>"></td>	<!-- Total Maintenance of each lorry per month -->
							<td align="center" style="background-color: #FF0000;"><input readonly="readonly" style="text-align: center; font-weight: bold;" type="text" size="1px" value="<bean:write name="model" property="totalBreakdown"/>"></td>	<!-- color RED (total number of days breakdown) -->
							<td align="center" style="background-color: #00FFFF;"><input readonly="readonly" style="text-align: center; font-weight: bold;" type="text" size="1px" value="<bean:write name="model" property="totalPM"/>"></td>	<!-- color CYAN (total number of days PM) -->
							<td align="center" style="background-color: #808080;"><input readonly="readonly" style="text-align: center; font-weight: bold;" type="text" size="1px" value="<bean:write name="model" property="totalPending"/>"></td>	<!-- color GRAY (total number of days pending, for pullout, no driver) -->
							<td align="center" style="background-color: #006400;"><input readonly="readonly" style="text-align: center; font-weight: bold;" type="text" size="1px" value="<bean:write name="model" property="totalTargetDate"/>"></td>	<!-- color DARK GREEN (Target Date) -->
							<td align="center" style="background-color: #000000;"><input readonly="readonly" style="text-align: center; font-weight: bold;" type="text" size="1px" value="<bean:write name="model" property="totalExtended"/>"></td>	<!-- color BLACK (Extended) -->
							<td align="center" style="background-color: #EE82EE;"><input readonly="readonly" style="text-align: center; font-weight: bold;" type="text" size="1px" value="<bean:write name="model" property="totalEarlyDone"/>"></td>	<!-- color VIOLET (Early Done) -->
							<td align="center" style="background-color: #FF8C00;"><input readonly="readonly" style="text-align: center; font-weight: bold;" type="text" size="1px" value="<bean:write name="model" property="totalTripsGPS"/>"></td>	<!-- Orange Background color, BLACK GPS total trips per month -->
							<td align="center" style="background-color: #FF8C00;"><input readonly="readonly" style="text-align: center; font-weight: bold;" type="text" size="1px" value="<bean:write name="model" property="totalPercentage"/>"></td>	<!-- Orange (Percentages) formulated in GPS total trips/month and total available in maintenance/month -->
							<td align="center" style="background-color: #FF8C00;">
								<div class="tooltip1">
									<input readonly="readonly" style="text-align: center; font-weight: bold;" type="text" size="1px" value="<bean:write name="model" property="totalGpsTripIssueTI"/>"><!-- GPS Trip Issue: Terminal Issue (TI) -->
									<span class="tooltiptext1">
										Terminal Issue (TI)<br>
										PlateNo: ${model.plateNo} <br>
										TrailerNo: ${model.trailerNo} <br>
										LorryNo: ${model.lorryNo} <br>
									</span>
								</div>
							</td>
							<td align="center" style="background-color: #FF8C00;">
								<div class="tooltip1">
									<input readonly="readonly" style="text-align: center; font-weight: bold;" type="text" size="1px" value="<bean:write name="model" property="totalGpsTripIssueMI"/>">	<!-- GPS Trip Issue: Maintenance Issue (MI) -->
									<span class="tooltiptext1">
										Maintenance Issue (MI)<br>
										PlateNo: ${model.plateNo} <br>
										TrailerNo: ${model.trailerNo} <br>
										LorryNo: ${model.lorryNo} <br>
									</span>
								</div>
							</td>
							<td align="center" style="background-color: #FF8C00;">
								<div class="tooltip1">
									<input readonly="readonly" style="text-align: center; font-weight: bold;" type="text" size="1px" value="<bean:write name="model" property="totalGpsTripIssueDI"/>">	<!-- GPS Trip Issue: Driver Issue (DI) -->
									<span class="tooltiptext1">
										Driver Issue (DI)<br>
										PlateNo: ${model.plateNo} <br>
										TrailerNo: ${model.trailerNo} <br>
										LorryNo: ${model.lorryNo} <br>
									</span>
								</div>
							</td>
							<td align="center" style="background-color: #FF8C00;">
								<div class="tooltip1">
									<input readonly="readonly" style="text-align: center; font-weight: bold;" type="text" size="1px" value="<bean:write name="model" property="totalGpsTripIssueCI"/>">	<!-- GPS Trip Issue: Customer Issue (CI) -->
									<span class="tooltiptext1">
										Customer Issue (CI)<br>
										PlateNo: ${model.plateNo} <br>
										TrailerNo: ${model.trailerNo} <br>
										LorryNo: ${model.lorryNo} <br>
									</span>
								</div>
							</td>
							<td align="center" style="background-color: #FF8C00;">
								<div class="tooltip1">
									<input readonly="readonly" style="text-align: center; font-weight: bold;" type="text" size="1px" value="<bean:write name="model" property="totalGpsTripIssueLV"/>">	<!-- GPS Trip Issue: Low Volume (LV) -->
									<span class="tooltiptext1">
										Low Volume (LV)<br>
										PlateNo: ${model.plateNo} <br>
										TrailerNo: ${model.trailerNo} <br>
										LorryNo: ${model.lorryNo} <br>
									</span>
								</div>
							</td>
							<td align="center" style="background-color: #FF8C00;">
								<div class="tooltip1">
									<input readonly="readonly" style="text-align: center; font-weight: bold;" type="text" size="1px" value="<bean:write name="model" property="totalGpsTripIssueLH"/>">	<!-- GPS Trip Issue: Long Haul (LH) -->
									<span class="tooltiptext1">
										Long Haul (LH)<br>
										PlateNo: ${model.plateNo} <br>
										TrailerNo: ${model.trailerNo} <br>
										LorryNo: ${model.lorryNo} <br>
									</span>
								</div>
							</td>
							<td align="center" style="background-color: #FF8C00;">
								<div class="tooltip1">
									<input readonly="readonly" style="text-align: center; font-weight: bold;" type="text" size="1px" value="<bean:write name="model" property="totalGpsTripIssueTBI"/>">	<!-- GPS Trip Issue: Truck Ban Issue (TBI) -->
									<span class="tooltiptext1">
										Truck Ban Issue (TBI)<br>
										PlateNo: ${model.plateNo} <br>
										TrailerNo: ${model.trailerNo} <br>
										LorryNo: ${model.lorryNo} <br>
									</span>
								</div>
							</td>
							<td align="center" style="background-color: #FF8C00;">
								<div class="tooltip1">
									<input readonly="readonly" style="text-align: center; font-weight: bold;" type="text" size="1px" value="<bean:write name="model" property="totalGpsTripIssueRI"/>">	<!-- GPS Trip Issue: Road Issue (RI) -->
									<span class="tooltiptext1">
										Road Issue (RI)<br>
										PlateNo: ${model.plateNo} <br>
										TrailerNo: ${model.trailerNo} <br>
										LorryNo: ${model.lorryNo} <br>
									</span>
								</div>
							</td>
						</tr>
					</c:if>
				</logic:iterate>

				<!-- Last row for Total of Category of Shell-->
				<c:if test="${category!=''}">
					<tr>
						<td colspan="4" align="center"><span style="font-weight: bold;">Total Available &nbsp; <c:out value="${category}"></c:out> &nbsp; in Maintenance</span></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip1}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance1}" ></td>
						<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol1}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip2}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance2}" ></td>
						<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol2}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip3}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance3}" ></td>
						<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol3}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip4}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance4}" ></td>
						<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol4}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip5}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance5}" ></td>
						<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol5}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip6}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance6}" ></td>
						<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol6}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip7}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance7}" ></td>
						<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol7}" ></td>
						<td></td>
						<td align="center"><input type="text" size="5px" style="text-align: center; font-weight: bold; background-color: #FFFF00; "value="${sumVolWeek1}" ></td>
						<td></td>
						<td></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip8}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance8}" ></td>
						<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol8}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip9}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance9}" ></td>
						<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol9}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip10}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance10}" ></td>
						<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol10}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip11}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance11}" ></td>
						<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol11}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip12}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance12}" ></td>
						<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol12}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip13}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance13}" ></td>
						<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol13}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip14}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance14}" ></td>
						<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol14}" ></td>
						<td></td>
						<td align="center"><input type="text" size="5px" style="text-align: center; font-weight: bold; background-color: #FFFF00; "value="${sumVolWeek2}" ></td>
						<td></td>
						<td></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip15}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance15}" ></td>
						<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol15}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip16}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance16}" ></td>
						<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol16}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip17}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance17}" ></td>
						<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol17}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip18}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance18}" ></td>
						<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol18}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip19}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance19}" ></td>
						<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol19}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip20}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance20}" ></td>
						<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol20}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip21}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance21}" ></td>
						<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol21}" ></td>
						<td></td>
						<td align="center"><input type="text" size="5px" style="text-align: center; font-weight: bold; background-color: #FFFF00; "value="${sumVolWeek3}" ></td>
						<td></td>
						<td></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip22}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance22}" ></td>
						<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol22}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip23}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance23}" ></td>
						<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol23}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip24}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance24}" ></td>
						<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol24}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip25}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance25}" ></td>
						<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol25}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip26}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance26}" ></td>
						<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol26}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip27}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance27}" ></td>
						<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol27}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip28}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance28}" ></td>
						<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol28}" ></td>
						<td></td>
						<td align="center"><input type="text" size="5px" style="text-align: center; font-weight: bold; background-color: #FFFF00; "value="${sumVolWeek4}" ></td>
						<td></td>
						<td></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip29}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance29}" ></td>
						<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol29}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip30}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance30}" ></td>
						<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol30}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip31}" ></td>
						<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance31}" ></td>
						<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol31}" ></td>
						<td></td>
						<td align="center"><input type="text" size="5px" style="text-align: center; font-weight: bold; background-color: #FFFF00; "value="${sumVolWeek5}" ></td>
						<td align="center"><input type="text" size="8px" style="text-align: center; font-weight: bold; background-color: #FFFF00; "value="${sumVolWeek1+sumVolWeek2+sumVolWeek3+sumVolWeek4+sumVolWeek5}" ></td>
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
					<!-- Committed Volume -->
					<tr>
						<td colspan="2" style="color:red; background-color:lightgreen;">COMMITED VOLUME</td>
						<td style="color:red; background-color:lightgreen;">${committedVolume}</td>
						<!-- Batangas Black is Single Shift only -->
						<c:choose>
							<c:when test="${category=='BATANGAS BLACK'}">
								<td style="color:red; background-color:lightgreen;">${capacityOfTerminal*1000}</td>
							</c:when>
							<c:otherwise>
								<td style="color:red; background-color:lightgreen;">${capacityOfTerminal*1000*2}</td>
							</c:otherwise>
						</c:choose>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol1-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol2-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol3-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol4-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol5-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol6-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol7-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol8-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol9-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol10-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol11-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol12-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol13-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol14-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol15-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol16-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol17-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol18-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol19-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol20-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol21-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol22-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol23-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol24-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol25-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol26-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol27-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol28-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol29-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol30-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol31-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>	
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
					</tr>			
					<!-- Row for Daily Percentage Per category -->
					<tr>
						<td colspan="4" align="center"><span style="font-weight: bold;">Daily Percentages &nbsp; <c:out value="${category}"></c:out> &nbsp;</span></td>
						<td style="background-color: #32CD32;"></td><!-- lime green -->
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance1/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance2/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance3/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance4/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance5/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance6/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance7/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td></td>
						<td></td>
						<td></td>
						<td></td>
						<td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance8/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance9/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance10/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance11/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance12/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance13/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance14/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td></td>
						<td></td>
						<td></td>
						<td></td>
						<td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance15/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance16/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance17/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance18/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance19/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance20/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance21/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td></td>
						<td></td>
						<td></td>
						<td></td>
						<td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance22/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance23/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance24/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance25/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance26/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance27/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance28/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td></td>
						<td></td>
						<td></td>
						<td></td>
						<td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance29/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance30/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance31/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td></td><td></td>
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
						<td></td>
					</tr>
				</c:if>

				<!-- Shell Fleet Availability -->
				<logic:iterate name="maintenanceMonitoringForm" property="modelListShellFleet" type="com.transport.model.MaintenanceMonitoringFleet" id="model">
					<tr>
						<td colspan="4" align="center" style="font-weight: bold;">Shell Transport Daily Availability</td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG1" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM1" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG2" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM2" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG3" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM3" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG4" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM4" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG5" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM5" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG6" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM6" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG7" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM7" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="GPSTotalWeek1" />"/></td><td></td>
						<td></td>
						<td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG8" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM8" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG9" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM9" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG10" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM10" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG11" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM11" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG12" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM12" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG13" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM13" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG14" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM14" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="GPSTotalWeek2" />"/></td><td></td>
						<td></td>
						<td></td>						
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG15" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM15" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG16" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM16" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG17" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM17" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG18" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM18" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG19" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM19" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG20" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM20" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG21" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM21" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="GPSTotalWeek3" />"/></td><td></td>
						<td></td>
						<td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG22" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM22" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG23" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM23" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG24" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM24" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG25" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM25" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG26" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM26" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG27" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM27" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG28" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM28" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="GPSTotalWeek4" />"/></td><td></td>
						<td></td>
						<td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG29" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM29" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG30" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM30" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG31" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM31" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="GPSTotalWeek5" />"/></td><td></td><td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td align="center" style="background-color: #FF8C00;"><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="GPSGrandTotal" />"/></td>
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
					<!-- Total Transport Shell Fleet -->
				<tr>
					<td colspan="4" align="center" style="font-weight: bold;">Total Transport Shell Fleet</td>
						<td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td><td></td>
						<td></td>
						<td></td>
						<td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td><td></td>
						<td></td>
						<td></td>
						<td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td><td></td>
						<td></td>
						<td></td>
						<td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td><td></td>
						<td></td>
						<td></td>
						<td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
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
					<!-- Shell Fleet Unavailable -->
					<tr>
						<td colspan="4" align="center" style="font-weight: bold;">Shell Transport Unavailable</td>
						<td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU1" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU2" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU3" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU4" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU5" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU6" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU7" />"/></td>
						<td></td><td></td><td></td>
						<td></td>
						<td></td>
						<td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU8" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU9" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU10" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU11" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU12" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU13" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU14" />"/></td>
						<td></td><td></td><td></td>
						<td></td>
						<td></td>
						<td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU15" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU16" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU17" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU18" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU19" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU20" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU21" />"/></td>
						<td></td><td></td><td></td>
						<td></td>
						<td></td>
						<td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU22" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU23" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU24" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU25" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU26" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU27" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU28" />"/></td>
						<td></td><td></td><td></td>
						<td></td>
						<td></td>
						<td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU29" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU30" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU31" />"/></td>
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

				<c:set var="category" value=""></c:set>
				<c:set var="sumTrip1" value="0"></c:set>
				<c:set var="sumTrip2" value="0"></c:set>
				<c:set var="sumTrip3" value="0"></c:set>
				<c:set var="sumTrip4" value="0"></c:set>
				<c:set var="sumTrip5" value="0"></c:set>
				<c:set var="sumTrip6" value="0"></c:set>
				<c:set var="sumTrip7" value="0"></c:set>
				<c:set var="sumTrip8" value="0"></c:set>
				<c:set var="sumTrip9" value="0"></c:set>
				<c:set var="sumTrip10" value="0"></c:set>
				<c:set var="sumTrip11" value="0"></c:set>
				<c:set var="sumTrip12" value="0"></c:set>
				<c:set var="sumTrip13" value="0"></c:set>
				<c:set var="sumTrip14" value="0"></c:set>
				<c:set var="sumTrip15" value="0"></c:set>
				<c:set var="sumTrip16" value="0"></c:set>
				<c:set var="sumTrip17" value="0"></c:set>
				<c:set var="sumTrip18" value="0"></c:set>
				<c:set var="sumTrip19" value="0"></c:set>
				<c:set var="sumTrip20" value="0"></c:set>
				<c:set var="sumTrip21" value="0"></c:set>
				<c:set var="sumTrip22" value="0"></c:set>
				<c:set var="sumTrip23" value="0"></c:set>
				<c:set var="sumTrip24" value="0"></c:set>
				<c:set var="sumTrip25" value="0"></c:set>
				<c:set var="sumTrip26" value="0"></c:set>
				<c:set var="sumTrip27" value="0"></c:set>
				<c:set var="sumTrip28" value="0"></c:set>
				<c:set var="sumTrip29" value="0"></c:set>
				<c:set var="sumTrip30" value="0"></c:set>
				<c:set var="sumTrip31" value="0"></c:set>
				<c:set var="sumMaintenance1" value="0"></c:set>
				<c:set var="sumMaintenance2" value="0"></c:set>
				<c:set var="sumMaintenance3" value="0"></c:set>
				<c:set var="sumMaintenance4" value="0"></c:set>
				<c:set var="sumMaintenance5" value="0"></c:set>
				<c:set var="sumMaintenance6" value="0"></c:set>
				<c:set var="sumMaintenance7" value="0"></c:set>
				<c:set var="sumMaintenance8" value="0"></c:set>
				<c:set var="sumMaintenance9" value="0"></c:set>
				<c:set var="sumMaintenance10" value="0"></c:set>
				<c:set var="sumMaintenance11" value="0"></c:set>
				<c:set var="sumMaintenance12" value="0"></c:set>
				<c:set var="sumMaintenance13" value="0"></c:set>
				<c:set var="sumMaintenance14" value="0"></c:set>
				<c:set var="sumMaintenance15" value="0"></c:set>
				<c:set var="sumMaintenance16" value="0"></c:set>
				<c:set var="sumMaintenance17" value="0"></c:set>
				<c:set var="sumMaintenance18" value="0"></c:set>
				<c:set var="sumMaintenance19" value="0"></c:set>
				<c:set var="sumMaintenance20" value="0"></c:set>
				<c:set var="sumMaintenance21" value="0"></c:set>
				<c:set var="sumMaintenance22" value="0"></c:set>
				<c:set var="sumMaintenance23" value="0"></c:set>
				<c:set var="sumMaintenance24" value="0"></c:set>
				<c:set var="sumMaintenance25" value="0"></c:set>
				<c:set var="sumMaintenance26" value="0"></c:set>
				<c:set var="sumMaintenance27" value="0"></c:set>
				<c:set var="sumMaintenance28" value="0"></c:set>
				<c:set var="sumMaintenance29" value="0"></c:set>
				<c:set var="sumMaintenance30" value="0"></c:set>
				<c:set var="sumMaintenance31" value="0"></c:set>
				<c:set var="sumVol1" value="0"></c:set>
				<c:set var="sumVol2" value="0"></c:set>
				<c:set var="sumVol3" value="0"></c:set>
				<c:set var="sumVol4" value="0"></c:set>
				<c:set var="sumVol5" value="0"></c:set>
				<c:set var="sumVol6" value="0"></c:set>
				<c:set var="sumVol7" value="0"></c:set>
				<c:set var="sumVol8" value="0"></c:set>
				<c:set var="sumVol9" value="0"></c:set>
				<c:set var="sumVol10" value="0"></c:set>
				<c:set var="sumVol11" value="0"></c:set>
				<c:set var="sumVol12" value="0"></c:set>
				<c:set var="sumVol13" value="0"></c:set>
				<c:set var="sumVol14" value="0"></c:set>
				<c:set var="sumVol15" value="0"></c:set>
				<c:set var="sumVol16" value="0"></c:set>
				<c:set var="sumVol17" value="0"></c:set>
				<c:set var="sumVol18" value="0"></c:set>
				<c:set var="sumVol19" value="0"></c:set>
				<c:set var="sumVol20" value="0"></c:set>
				<c:set var="sumVol21" value="0"></c:set>
				<c:set var="sumVol22" value="0"></c:set>
				<c:set var="sumVol23" value="0"></c:set>
				<c:set var="sumVol24" value="0"></c:set>
				<c:set var="sumVol25" value="0"></c:set>
				<c:set var="sumVol26" value="0"></c:set>
				<c:set var="sumVol27" value="0"></c:set>
				<c:set var="sumVol28" value="0"></c:set>
				<c:set var="sumVol29" value="0"></c:set>
				<c:set var="sumVol30" value="0"></c:set>
				<c:set var="sumVol31" value="0"></c:set>
				<c:set var="sumVolWeek1" value="0"></c:set>
				<c:set var="sumVolWeek2" value="0"></c:set>
				<c:set var="sumVolWeek3" value="0"></c:set>
				<c:set var="sumVolWeek4" value="0"></c:set>
				<c:set var="sumVolWeek5" value="0"></c:set>
				<c:set var="totalLorryCountPerCategory" value="0"></c:set>
				<c:set var="capacityOfTerminal" value="0"></c:set>
				<logic:iterate name="maintenanceMonitoringForm" property="modelList" type="com.transport.model.MaintenanceMonitoring" id="model">
					<!-- filter for chevron lorry only -->
					<c:if test="${model.transportId == 602}">
						<c:if test="${model.category!=category}">
							<c:if test="${category!=''}">
								<tr>
									<td colspan="4" align="center"><span style="font-weight: bold;">Total Available &nbsp; <c:out value="${category}"></c:out> &nbsp; in Maintenance</span></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip1}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance1}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol1}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip2}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance2}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol2}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip3}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance3}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol3}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip4}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance4}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol4}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip5}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance5}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol5}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip6}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance6}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol6}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip7}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance7}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol7}" ></td>
									<td></td>
									<td align="center"><input type="text" size="5px" style="text-align: center; font-weight: bold; background-color: #FFFF00; "value="${sumVolWeek1}" ></td>
									<td></td>
									<td></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip8}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance8}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol8}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip9}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance9}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol9}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip10}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance10}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol10}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip11}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance11}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol11}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip12}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance12}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol12}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip13}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance13}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol13}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip14}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance14}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol14}" ></td>
									<td></td>
									<td align="center"><input type="text" size="5px" style="text-align: center; font-weight: bold; background-color: #FFFF00; "value="${sumVolWeek2}" ></td>
									<td></td>
									<td></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip15}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance15}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol15}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip16}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance16}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol16}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip17}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance17}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol17}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip18}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance18}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol18}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip19}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance19}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol19}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip20}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance20}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol20}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip21}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance21}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol21}" ></td>
									<td></td>
									<td align="center"><input type="text" size="5px" style="text-align: center; font-weight: bold; background-color: #FFFF00; "value="${sumVolWeek3}" ></td>
									<td></td>
									<td></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip22}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance22}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol22}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip23}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance23}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol23}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip24}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance24}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol24}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip25}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance25}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol25}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip26}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance26}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol26}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip27}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance27}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol27}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip28}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance28}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol28}" ></td>
									<td></td>
									<td align="center"><input type="text" size="5px" style="text-align: center; font-weight: bold; background-color: #FFFF00; "value="${sumVolWeek4}" ></td>
									<td></td>
									<td></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip29}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance29}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol29}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip30}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance30}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol30}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip31}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance31}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol31}" ></td>
									<td></td>
									<td align="center"><input type="text" size="5px" style="text-align: center; font-weight: bold; background-color: #FFFF00; "value="${sumVolWeek5}" ></td>
									<td align="center"><input type="text" size="8px" style="text-align: center; font-weight: bold; background-color: #FFFF00; "value="${sumVolWeek1+sumVolWeek2+sumVolWeek3+sumVolWeek4+sumVolWeek5}" ></td>
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
								<!-- Committed Volume -->
								<tr>
									<td colspan="2" style="color:red; background-color:lightgreen;">COMMITED VOLUME</td>
									<td style="color:red; background-color:lightgreen;">${committedVolume}</td>
									<!-- Batangas Black is Single Shift only -->
									<c:choose>
										<c:when test="${category=='BATANGAS BLACK'}">
											<td style="color:red; background-color:lightgreen;">${capacityOfTerminal*1000}</td>
										</c:when>
										<c:otherwise>
											<td style="color:red; background-color:lightgreen;">${capacityOfTerminal*1000*2}</td>
										</c:otherwise>
									</c:choose>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol1-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol2-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol3-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol4-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol5-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol6-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol7-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol8-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol9-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol10-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol11-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol12-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol13-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol14-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol15-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol16-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol17-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol18-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol19-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol20-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol21-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol22-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol23-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol24-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol25-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol26-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol27-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol28-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol29-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol30-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol31-committedVolume}" ></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>	
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
									<td style="background-color:lightgreen;"></td>
								</tr>			

								<tr>
									<td colspan="4" align="center"><span style="font-weight: bold;">Daily Percentages &nbsp; <c:out value="${category}"></c:out> &nbsp;</span></td>
									<td style="background-color: #32CD32;"></td><!-- lime green -->
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance1/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance2/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance3/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance4/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance5/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance6/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance7/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td></td>
									<td></td>
									<td></td>
									<td></td>
									<td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance8/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance9/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance10/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance11/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance12/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance13/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance14/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td></td>
									<td></td>
									<td></td>
									<td></td>
									<td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance15/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance16/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance17/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance18/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance19/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance20/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance21/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td></td>
									<td></td>
									<td></td>
									<td></td>
									<td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance22/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance23/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance24/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance25/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance26/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance27/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance28/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td></td>
									<td></td>
									<td></td>
									<td></td>
									<td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance29/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance30/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        							<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance31/totalLorryCountPerCategory}" />" ></td> 
									<td style="background-color: #32CD32;"></td><td></td><td></td>
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
							</c:if>	
							<c:set var="sumTrip1" value="0"></c:set>
							<c:set var="sumTrip2" value="0"></c:set>
							<c:set var="sumTrip3" value="0"></c:set>
							<c:set var="sumTrip4" value="0"></c:set>
							<c:set var="sumTrip5" value="0"></c:set>
							<c:set var="sumTrip6" value="0"></c:set>
							<c:set var="sumTrip7" value="0"></c:set>
							<c:set var="sumTrip8" value="0"></c:set>
							<c:set var="sumTrip9" value="0"></c:set>
							<c:set var="sumTrip10" value="0"></c:set>
							<c:set var="sumTrip11" value="0"></c:set>
							<c:set var="sumTrip12" value="0"></c:set>
							<c:set var="sumTrip13" value="0"></c:set>
							<c:set var="sumTrip14" value="0"></c:set>
							<c:set var="sumTrip15" value="0"></c:set>
							<c:set var="sumTrip16" value="0"></c:set>
							<c:set var="sumTrip17" value="0"></c:set>
							<c:set var="sumTrip18" value="0"></c:set>
							<c:set var="sumTrip19" value="0"></c:set>
							<c:set var="sumTrip20" value="0"></c:set>
							<c:set var="sumTrip21" value="0"></c:set>
							<c:set var="sumTrip22" value="0"></c:set>
							<c:set var="sumTrip23" value="0"></c:set>
							<c:set var="sumTrip24" value="0"></c:set>
							<c:set var="sumTrip25" value="0"></c:set>
							<c:set var="sumTrip26" value="0"></c:set>
							<c:set var="sumTrip27" value="0"></c:set>
							<c:set var="sumTrip28" value="0"></c:set>
							<c:set var="sumTrip29" value="0"></c:set>
							<c:set var="sumTrip30" value="0"></c:set>
							<c:set var="sumTrip31" value="0"></c:set>
							<c:set var="sumMaintenance1" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance2" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance3" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance4" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance5" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance6" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance7" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance8" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance9" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance10" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance11" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance12" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance13" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance14" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance15" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance16" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance17" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance18" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance19" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance20" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance21" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance22" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance23" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance24" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance25" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance26" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance27" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance28" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance29" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance30" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumMaintenance31" value="0"></c:set><!-- Reset to 0 for next category -->
							<c:set var="sumVol1" value="0"></c:set>
							<c:set var="sumVol2" value="0"></c:set>
							<c:set var="sumVol3" value="0"></c:set>
							<c:set var="sumVol4" value="0"></c:set>
							<c:set var="sumVol5" value="0"></c:set>
							<c:set var="sumVol6" value="0"></c:set>
							<c:set var="sumVol7" value="0"></c:set>
							<c:set var="sumVol8" value="0"></c:set>
							<c:set var="sumVol9" value="0"></c:set>
							<c:set var="sumVol10" value="0"></c:set>
							<c:set var="sumVol11" value="0"></c:set>
							<c:set var="sumVol12" value="0"></c:set>
							<c:set var="sumVol13" value="0"></c:set>
							<c:set var="sumVol14" value="0"></c:set>
							<c:set var="sumVol15" value="0"></c:set>
							<c:set var="sumVol16" value="0"></c:set>
							<c:set var="sumVol17" value="0"></c:set>
							<c:set var="sumVol18" value="0"></c:set>
							<c:set var="sumVol19" value="0"></c:set>
							<c:set var="sumVol20" value="0"></c:set>
							<c:set var="sumVol21" value="0"></c:set>
							<c:set var="sumVol22" value="0"></c:set>
							<c:set var="sumVol23" value="0"></c:set>
							<c:set var="sumVol24" value="0"></c:set>
							<c:set var="sumVol25" value="0"></c:set>
							<c:set var="sumVol26" value="0"></c:set>
							<c:set var="sumVol27" value="0"></c:set>
							<c:set var="sumVol28" value="0"></c:set>
							<c:set var="sumVol29" value="0"></c:set>
							<c:set var="sumVol30" value="0"></c:set>
							<c:set var="sumVol31" value="0"></c:set>
							<c:set var="sumVolWeek1" value="0"></c:set>
							<c:set var="sumVolWeek2" value="0"></c:set>
							<c:set var="sumVolWeek3" value="0"></c:set>
							<c:set var="sumVolWeek4" value="0"></c:set>
							<c:set var="sumVolWeek5" value="0"></c:set>
							<c:set var="totalLorryCountPerCategory" value="0"></c:set>
							<c:set var="category" value="${model.category}"></c:set>
							<c:set var="committedVolume" value="${model.committedVolume}"></c:set>
							<c:set var="capacityOfTerminal" value="0"></c:set>
							<tr>
								<td colspan="4" align="center"><span style="font-weight: bold;"><bean:write name="model" property="category"/></span></td>
								<td colspan="129"></td>
							</tr>	
						</c:if>	
						<c:set var="totalLorryCountPerCategory" value="${totalLorryCountPerCategory + 1}"></c:set>
						<c:set var="capacityOfTerminal" value="${capacityOfTerminal + model.capacity}"></c:set>
						<c:set var="sumTrip1" value="${sumTrip1 + model.gps1}"></c:set>
						<c:set var="sumTrip2" value="${sumTrip2 + model.gps2}"></c:set>
						<c:set var="sumTrip3" value="${sumTrip3 + model.gps3}"></c:set>
						<c:set var="sumTrip4" value="${sumTrip4 + model.gps4}"></c:set>
						<c:set var="sumTrip5" value="${sumTrip5 + model.gps5}"></c:set>
						<c:set var="sumTrip6" value="${sumTrip6 + model.gps6}"></c:set>
						<c:set var="sumTrip7" value="${sumTrip7 + model.gps7}"></c:set>
						<c:set var="sumTrip8" value="${sumTrip8 + model.gps8}"></c:set>
						<c:set var="sumTrip9" value="${sumTrip9 + model.gps9}"></c:set>
						<c:set var="sumTrip10" value="${sumTrip10 + model.gps10}"></c:set>
						<c:set var="sumTrip11" value="${sumTrip11 + model.gps11}"></c:set>
						<c:set var="sumTrip12" value="${sumTrip12 + model.gps12}"></c:set>
						<c:set var="sumTrip13" value="${sumTrip13 + model.gps13}"></c:set>
						<c:set var="sumTrip14" value="${sumTrip14 + model.gps14}"></c:set>
						<c:set var="sumTrip15" value="${sumTrip15 + model.gps15}"></c:set>
						<c:set var="sumTrip16" value="${sumTrip16 + model.gps16}"></c:set>
						<c:set var="sumTrip17" value="${sumTrip17 + model.gps17}"></c:set>
						<c:set var="sumTrip18" value="${sumTrip18 + model.gps18}"></c:set>
						<c:set var="sumTrip19" value="${sumTrip19 + model.gps19}"></c:set>
						<c:set var="sumTrip20" value="${sumTrip20 + model.gps20}"></c:set>
						<c:set var="sumTrip21" value="${sumTrip21 + model.gps21}"></c:set>
						<c:set var="sumTrip22" value="${sumTrip22 + model.gps22}"></c:set>
						<c:set var="sumTrip23" value="${sumTrip23 + model.gps23}"></c:set>
						<c:set var="sumTrip24" value="${sumTrip24 + model.gps24}"></c:set>
						<c:set var="sumTrip25" value="${sumTrip25 + model.gps25}"></c:set>
						<c:set var="sumTrip26" value="${sumTrip26 + model.gps26}"></c:set>
						<c:set var="sumTrip27" value="${sumTrip27 + model.gps27}"></c:set>
						<c:set var="sumTrip28" value="${sumTrip28 + model.gps28}"></c:set>
						<c:set var="sumTrip29" value="${sumTrip29 + model.gps29}"></c:set>
						<c:set var="sumTrip30" value="${sumTrip30 + model.gps30}"></c:set>
						<c:set var="sumTrip31" value="${sumTrip31 + model.gps31}"></c:set>
						<c:if test="${model.maintenance1 == '1'}">
							<c:set var="sumMaintenance1" value="${sumMaintenance1 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance2 == '1'}">
							<c:set var="sumMaintenance2" value="${sumMaintenance2 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance3 == '1'}">
							<c:set var="sumMaintenance3" value="${sumMaintenance3 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance4 == '1'}">
							<c:set var="sumMaintenance4" value="${sumMaintenance4 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance5 == '1'}">
							<c:set var="sumMaintenance5" value="${sumMaintenance5 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance6 == '1'}">
							<c:set var="sumMaintenance6" value="${sumMaintenance6 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance7 == '1'}">
							<c:set var="sumMaintenance7" value="${sumMaintenance7 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance8 == '1'}">
							<c:set var="sumMaintenance8" value="${sumMaintenance8 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance9 == '1'}">
							<c:set var="sumMaintenance9" value="${sumMaintenance9 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance10 == '1'}">
							<c:set var="sumMaintenance10" value="${sumMaintenance10 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance11 == '1'}">
							<c:set var="sumMaintenance11" value="${sumMaintenance11 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance12 == '1'}">
							<c:set var="sumMaintenance12" value="${sumMaintenance12 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance13 == '1'}">
							<c:set var="sumMaintenance13" value="${sumMaintenance13 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance14 == '1'}">
							<c:set var="sumMaintenance14" value="${sumMaintenance14 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance15 == '1'}">
							<c:set var="sumMaintenance15" value="${sumMaintenance15 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance16 == '1'}">
							<c:set var="sumMaintenance16" value="${sumMaintenance16 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance17 == '1'}">
							<c:set var="sumMaintenance17" value="${sumMaintenance17 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance18 == '1'}">
							<c:set var="sumMaintenance18" value="${sumMaintenance18 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance19 == '1'}">
							<c:set var="sumMaintenance19" value="${sumMaintenance19 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance20 == '1'}">
							<c:set var="sumMaintenance20" value="${sumMaintenance20 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance21 == '1'}">
							<c:set var="sumMaintenance21" value="${sumMaintenance21 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance22 == '1'}">
							<c:set var="sumMaintenance22" value="${sumMaintenance22 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance23 == '1'}">
							<c:set var="sumMaintenance23" value="${sumMaintenance23 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance24 == '1'}">
							<c:set var="sumMaintenance24" value="${sumMaintenance24 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance25 == '1'}">
							<c:set var="sumMaintenance25" value="${sumMaintenance25 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance26 == '1'}">
							<c:set var="sumMaintenance26" value="${sumMaintenance26 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance27 == '1'}">
							<c:set var="sumMaintenance27" value="${sumMaintenance27 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance28 == '1'}">
							<c:set var="sumMaintenance28" value="${sumMaintenance28 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance29 == '1'}">
							<c:set var="sumMaintenance29" value="${sumMaintenance29 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance30 == '1'}">
							<c:set var="sumMaintenance30" value="${sumMaintenance30 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenance31 == '1'}">
							<c:set var="sumMaintenance31" value="${sumMaintenance31 + 1}"></c:set>
						</c:if>
						<c:set var="sumVol1" value="${sumVol1 + model.gps1Vol}"></c:set>
						<c:set var="sumVol2" value="${sumVol2 + model.gps2Vol}"></c:set>
						<c:set var="sumVol3" value="${sumVol3 + model.gps3Vol}"></c:set>
						<c:set var="sumVol4" value="${sumVol4 + model.gps4Vol}"></c:set>
						<c:set var="sumVol5" value="${sumVol5 + model.gps5Vol}"></c:set>
						<c:set var="sumVol6" value="${sumVol6 + model.gps6Vol}"></c:set>
						<c:set var="sumVol7" value="${sumVol7 + model.gps7Vol}"></c:set>
						<c:set var="sumVol8" value="${sumVol8 + model.gps8Vol}"></c:set>
						<c:set var="sumVol9" value="${sumVol9 + model.gps9Vol}"></c:set>
						<c:set var="sumVol10" value="${sumVol10 + model.gps10Vol}"></c:set>
						<c:set var="sumVol11" value="${sumVol11 + model.gps11Vol}"></c:set>
						<c:set var="sumVol12" value="${sumVol12 + model.gps12Vol}"></c:set>
						<c:set var="sumVol13" value="${sumVol13 + model.gps13Vol}"></c:set>
						<c:set var="sumVol14" value="${sumVol14 + model.gps14Vol}"></c:set>
						<c:set var="sumVol15" value="${sumVol15 + model.gps15Vol}"></c:set>
						<c:set var="sumVol16" value="${sumVol16 + model.gps16Vol}"></c:set>
						<c:set var="sumVol17" value="${sumVol17 + model.gps17Vol}"></c:set>
						<c:set var="sumVol18" value="${sumVol18 + model.gps18Vol}"></c:set>
						<c:set var="sumVol19" value="${sumVol19 + model.gps19Vol}"></c:set>
						<c:set var="sumVol20" value="${sumVol20 + model.gps20Vol}"></c:set>
						<c:set var="sumVol21" value="${sumVol21 + model.gps21Vol}"></c:set>
						<c:set var="sumVol22" value="${sumVol22 + model.gps22Vol}"></c:set>
						<c:set var="sumVol23" value="${sumVol23 + model.gps23Vol}"></c:set>
						<c:set var="sumVol24" value="${sumVol24 + model.gps24Vol}"></c:set>
						<c:set var="sumVol25" value="${sumVol25 + model.gps25Vol}"></c:set>
						<c:set var="sumVol26" value="${sumVol26 + model.gps26Vol}"></c:set>
						<c:set var="sumVol27" value="${sumVol27 + model.gps27Vol}"></c:set>
						<c:set var="sumVol28" value="${sumVol28 + model.gps28Vol}"></c:set>
						<c:set var="sumVol29" value="${sumVol29 + model.gps29Vol}"></c:set>
						<c:set var="sumVol30" value="${sumVol30 + model.gps30Vol}"></c:set>
						<c:set var="sumVol31" value="${sumVol31 + model.gps31Vol}"></c:set>
						
						<c:set var="sumVolWeek1" value="${sumVolWeek1 + model.gpsWeek1Vol}"></c:set>
						<c:set var="sumVolWeek2" value="${sumVolWeek2 + model.gpsWeek2Vol}"></c:set>
						<c:set var="sumVolWeek3" value="${sumVolWeek3 + model.gpsWeek3Vol}"></c:set>
						<c:set var="sumVolWeek4" value="${sumVolWeek4 + model.gpsWeek4Vol}"></c:set>
						<c:set var="sumVolWeek5" value="${sumVolWeek5 + model.gpsWeek5Vol}"></c:set>		
						
						<c:if test="${model.maintenanceColor1 == '1105'}">
							<c:set var="grandTotalPending1" value="${grandTotalPending1 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor2 == '1105'}">
							<c:set var="grandTotalPending2" value="${grandTotalPending2 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor3 == '1105'}">
							<c:set var="grandTotalPending3" value="${grandTotalPending3 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor4 == '1105'}">
							<c:set var="grandTotalPending4" value="${grandTotalPending4 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor5 == '1105'}">
							<c:set var="grandTotalPending5" value="${grandTotalPending5 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor6 == '1105'}">
							<c:set var="grandTotalPending6" value="${grandTotalPending6 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor7 == '1105'}">
							<c:set var="grandTotalPending7" value="${grandTotalPending7 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor8 == '1105'}">
							<c:set var="grandTotalPending8" value="${grandTotalPending8 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor9 == '1105'}">
							<c:set var="grandTotalPending9" value="${grandTotalPending9 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor10 == '1105'}">
							<c:set var="grandTotalPending10" value="${grandTotalPending10 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor11 == '1105'}">
							<c:set var="grandTotalPending11" value="${grandTotalPending11 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor12 == '1105'}">
							<c:set var="grandTotalPending12" value="${grandTotalPending12 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor13 == '1105'}">
							<c:set var="grandTotalPending13" value="${grandTotalPending13 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor14 == '1105'}">
							<c:set var="grandTotalPending14" value="${grandTotalPending14 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor15 == '1105'}">
							<c:set var="grandTotalPending15" value="${grandTotalPending15 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor16 == '1105'}">
							<c:set var="grandTotalPending16" value="${grandTotalPending16 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor17 == '1105'}">
							<c:set var="grandTotalPending17" value="${grandTotalPending17 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor18 == '1105'}">
							<c:set var="grandTotalPending18" value="${grandTotalPending18 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor19 == '1105'}">
							<c:set var="grandTotalPending19" value="${grandTotalPending19 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor20 == '1105'}">
							<c:set var="grandTotalPending20" value="${grandTotalPending20 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor21 == '1105'}">
							<c:set var="grandTotalPending21" value="${grandTotalPending21 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor22 == '1105'}">
							<c:set var="grandTotalPending22" value="${grandTotalPending22 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor23 == '1105'}">
							<c:set var="grandTotalPending23" value="${grandTotalPending23 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor24 == '1105'}">
							<c:set var="grandTotalPending24" value="${grandTotalPending24 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor25 == '1105'}">
							<c:set var="grandTotalPending25" value="${grandTotalPending25 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor26 == '1105'}">
							<c:set var="grandTotalPending26" value="${grandTotalPending26 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor27 == '1105'}">
							<c:set var="grandTotalPending27" value="${grandTotalPending27 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor28 == '1105'}">
							<c:set var="grandTotalPending28" value="${grandTotalPending28 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor29 == '1105'}">
							<c:set var="grandTotalPending29" value="${grandTotalPending29 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor30 == '1105'}">
							<c:set var="grandTotalPending30" value="${grandTotalPending30 + 1}"></c:set>
						</c:if>
						<c:if test="${model.maintenanceColor31 == '1105'}">
							<c:set var="grandTotalPending31" value="${grandTotalPending31 + 1}"></c:set>
						</c:if>
						<tr>				 
							<td><bean:write name="model" property="plateNo"/></td>
							<td><bean:write name="model" property="trailerNo"/></td>
							<td><bean:write name="model" property="lorryNo"/></td>
							<td align="right"><bean:write name="model" property="capacity"/></td>
							<c:choose>
								<c:when test="${model.gpsColor1 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;" value="<bean:write name="model" property="gps1"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','1','241');">
											<span class="tooltiptext1">
												Day: 1 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks1}<br>
												Trip Issue: ${model.gpsTripIssue1Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor1 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;" value="<bean:write name="model" property="gps1"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','1','241');">
											<span class="tooltiptext1">
												Day: 1 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks1}<br>
												Trip Issue: ${model.gpsTripIssue1Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor1 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps1"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','1','241');">
											<span class="tooltiptext1">
												Day: 1 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks1}<br>
												Trip Issue: ${model.gpsTripIssue1Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor1 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps1"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','1','241');">
											<span class="tooltiptext1">
												Day: 1 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks1}<br>
												Trip Issue: ${model.gpsTripIssue1Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;" value="<bean:write name="model" property="gps1"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','1','241');">
											<span class="tooltiptext1">
												Day: 1 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks1}<br>
												Trip Issue: ${model.gpsTripIssue1Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor1 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance1"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','1','242');">
											<span class="tooltiptext1">
												Day: 1 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks1}<br>
												Category: ${model.maintenanceCategory1Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor1 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance1"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','1','242');">
											<span class="tooltiptext1">
												Day: 1 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks1}<br>
												Category: ${model.maintenanceCategory1Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor1 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance1"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','1','242');">
											<span class="tooltiptext1">
												Day: 1 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks1}<br>
												Category: ${model.maintenanceCategory1Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor1 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance1"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','1','242');">
											<span class="tooltiptext1">
												Day: 1 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks1}<br>
												Category: ${model.maintenanceCategory1Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor1 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance1"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','1','242');">
											<span class="tooltiptext1">
												Day: 1 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks1}<br>
												Category: ${model.maintenanceCategory1Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor1 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance1"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','1','242');">
											<span class="tooltiptext1">
												Day: 1 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks1}<br>
												Category: ${model.maintenanceCategory1Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance1"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','1','242');">
											<span class="tooltiptext1">
												Day: 1 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks1}<br>
												Category: ${model.maintenanceCategory1Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps1Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor2 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;" value="<bean:write name="model" property="gps2"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','2','241');">
											<span class="tooltiptext1">
												Day: 2 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks2}<br>
												Trip Issue: ${model.gpsTripIssue2Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor2 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;" value="<bean:write name="model" property="gps2"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','2','241');">
											<span class="tooltiptext1">
												Day: 2 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks2}<br>
												Trip Issue: ${model.gpsTripIssue2Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor2 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps2"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','2','241');">
											<span class="tooltiptext1">
												Day: 2 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks2}<br>
												Trip Issue: ${model.gpsTripIssue2Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor2 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps2"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','2','241');">
											<span class="tooltiptext1">
												Day: 2 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks2}<br>
												Trip Issue: ${model.gpsTripIssue2Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;" value="<bean:write name="model" property="gps2"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','2','241');">
											<span class="tooltiptext1">
												Day: 2 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks2}<br>
												Trip Issue: ${model.gpsTripIssue2Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor2 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance2"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','2','242');">
											<span class="tooltiptext1">
												Day: 2 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks2}<br>
												Category: ${model.maintenanceCategory2Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor2 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance2"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','2','242');">
											<span class="tooltiptext1">
												Day: 2 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks2}<br>
												Category: ${model.maintenanceCategory2Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor2 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance2"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','2','242');">
											<span class="tooltiptext1">
												Day: 2 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks2}<br>
												Category: ${model.maintenanceCategory2Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor2 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance2"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','2','242');">
											<span class="tooltiptext1">
												Day: 2 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks2}<br>
												Category: ${model.maintenanceCategory2Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor2 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance2"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','2','242');">
											<span class="tooltiptext1">
												Day: 2 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks2}<br>
												Category: ${model.maintenanceCategory2Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor2 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance2"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','2','242');">
											<span class="tooltiptext1">
												Day: 2 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks2}<br>
												Category: ${model.maintenanceCategory2Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance2"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','2','242');">
											<span class="tooltiptext1">
												Day: 2 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks2}<br>
												Category: ${model.maintenanceCategory2Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps2Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor3 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;" value="<bean:write name="model" property="gps3"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','3','241');">
											<span class="tooltiptext1">
												Day: 3 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks3}<br>
												Trip Issue: ${model.gpsTripIssue3Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor3 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;" value="<bean:write name="model" property="gps3"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','3','241');">
											<span class="tooltiptext1">
												Day: 3 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks3}<br>
												Trip Issue: ${model.gpsTripIssue3Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor3 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps3"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','3','241');">
											<span class="tooltiptext1">
												Day: 3 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks3}<br>
												Trip Issue: ${model.gpsTripIssue3Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor3 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps3"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','3','241');">
											<span class="tooltiptext1">
												Day: 3 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks3}<br>
												Trip Issue: ${model.gpsTripIssue3Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;" value="<bean:write name="model" property="gps3"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','3','241');">
											<span class="tooltiptext1">
												Day: 3 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks3}<br>
												Trip Issue: ${model.gpsTripIssue3Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor3 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance3"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','3','242');">
											<span class="tooltiptext1">
												Day: 3 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks3}<br>
												Category: ${model.maintenanceCategory3Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor3 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance3"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','3','242');">
											<span class="tooltiptext1">
												Day: 3 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks3}<br>
												Category: ${model.maintenanceCategory3Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor3 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance3"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','3','242');">
											<span class="tooltiptext1">
												Day: 3 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks3}<br>
												Category: ${model.maintenanceCategory3Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor3 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance3"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','3','242');">
											<span class="tooltiptext1">
												Day: 3 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks3}<br>
												Category: ${model.maintenanceCategory3Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor3 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance3"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','3','242');">
											<span class="tooltiptext1">
												Day: 3 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks3}<br>
												Category: ${model.maintenanceCategory3Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor3 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance3"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','3','242');">
											<span class="tooltiptext1">
												Day: 3 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks3}<br>
												Category: ${model.maintenanceCategory3Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance3"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','3','242');">
											<span class="tooltiptext1">
												Day: 3 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks3}<br>
												Category: ${model.maintenanceCategory3Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps3Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor4 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;" value="<bean:write name="model" property="gps4"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','4','241');">
											<span class="tooltiptext1">
												Day: 4 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks4}<br>
												Trip Issue: ${model.gpsTripIssue4Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor4 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;" value="<bean:write name="model" property="gps4"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','4','241');">
											<span class="tooltiptext1">
												Day: 4 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks4}<br>
												Trip Issue: ${model.gpsTripIssue4Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor4 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps4"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','4','241');">
											<span class="tooltiptext1">
												Day: 4 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks4}<br>
												Trip Issue: ${model.gpsTripIssue4Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor4 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps4"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','4','241');">
											<span class="tooltiptext1">
												Day: 4 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks4}<br>
												Trip Issue: ${model.gpsTripIssue4Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;" value="<bean:write name="model" property="gps4"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','4','241');">
											<span class="tooltiptext1">
												Day: 4 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks4}<br>
												Trip Issue: ${model.gpsTripIssue4Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor4 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance4"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','4','242');">
											<span class="tooltiptext1">
												Day: 4 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks4}<br>
												Category: ${model.maintenanceCategory4Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor4 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance4"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','4','242');">
											<span class="tooltiptext1">
												Day: 4 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks4}<br>
												Category: ${model.maintenanceCategory4Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor4 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance4"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','4','242');">
											<span class="tooltiptext1">
												Day: 4 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks4}<br>
												Category: ${model.maintenanceCategory4Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor4 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance4"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','4','242');">
											<span class="tooltiptext1">
												Day: 4 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks4}<br>
												Category: ${model.maintenanceCategory4Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor4 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance4"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','4','242');">
											<span class="tooltiptext1">
												Day: 4 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks4}<br>
												Category: ${model.maintenanceCategory4Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor4 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance4"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','4','242');">
											<span class="tooltiptext1">
												Day: 4 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks4}<br>
												Category: ${model.maintenanceCategory4Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance4"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','4','242');">
											<span class="tooltiptext1">
												Day: 4 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks4}<br>
												Category: ${model.maintenanceCategory4Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps4Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor5 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;" value="<bean:write name="model" property="gps5"/>"  onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','5','241');">
											<span class="tooltiptext1">
												Day: 5 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks5}<br>
												Trip Issue: ${model.gpsTripIssue5Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor5 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;" value="<bean:write name="model" property="gps5"/>"  onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','5','241');">
											<span class="tooltiptext1">
												Day: 5 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks5}<br>
												Trip Issue: ${model.gpsTripIssue5Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor5 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps5"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','5','241');">
											<span class="tooltiptext1">
												Day: 5 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks5}<br>
												Trip Issue: ${model.gpsTripIssue5Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor5 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps5"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','5','241');">
											<span class="tooltiptext1">
												Day: 5 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks5}<br>
												Trip Issue: ${model.gpsTripIssue5Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;" value="<bean:write name="model" property="gps5"/>"  onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','5','241');">
											<span class="tooltiptext1">
												Day: 5 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks5}<br>
												Trip Issue: ${model.gpsTripIssue5Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor5 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance5"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','5','242');">
											<span class="tooltiptext1">
												Day: 5 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks5}<br>
												Category: ${model.maintenanceCategory5Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor5 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance5"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','5','242');">
											<span class="tooltiptext1">
												Day: 5 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks5}<br>
												Category: ${model.maintenanceCategory5Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor5 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance5"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','5','242');">
											<span class="tooltiptext1">
												Day: 5 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks5}<br>
												Category: ${model.maintenanceCategory5Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor5 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance5"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','5','242');">
											<span class="tooltiptext1">
												Day: 5 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks5}<br>
												Category: ${model.maintenanceCategory5Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor5 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance5"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','5','242');">
											<span class="tooltiptext1">
												Day: 5 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks5}<br>
												Category: ${model.maintenanceCategory5Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor5 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance5"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','5','242');">
											<span class="tooltiptext1">
												Day: 5 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks5}<br>
												Category: ${model.maintenanceCategory5Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance5"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','5','242');">
											<span class="tooltiptext1">
												Day: 5 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks5}<br>
												Category: ${model.maintenanceCategory5Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps5Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor6 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;" value="<bean:write name="model" property="gps6"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','6','241');">
											<span class="tooltiptext1">
												Day: 6 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks6}<br>
												Trip Issue: ${model.gpsTripIssue6Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor6 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;" value="<bean:write name="model" property="gps6"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','6','241');">
											<span class="tooltiptext1">
												Day: 6 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks6}<br>
												Trip Issue: ${model.gpsTripIssue6Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor6 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps6"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','6','241');">
											<span class="tooltiptext1">
												Day: 6 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks6}<br>
												Trip Issue: ${model.gpsTripIssue6Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor6 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps6"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','6','241');">
											<span class="tooltiptext1">
												Day: 6 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks6}<br>
												Trip Issue: ${model.gpsTripIssue6Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;" value="<bean:write name="model" property="gps6"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','6','241');">
											<span class="tooltiptext1">
												Day: 6 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks6}<br>
												Trip Issue: ${model.gpsTripIssue6Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor6 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance6"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','6','242');">
											<span class="tooltiptext1">
												Day: 6 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks6}<br>
												Category: ${model.maintenanceCategory6Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor6 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance6"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','6','242');">
											<span class="tooltiptext1">
												Day: 6 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks6}<br>
												Category: ${model.maintenanceCategory6Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor6 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance6"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','6','242');">
											<span class="tooltiptext1">
												Day: 6 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks6}<br>
												Category: ${model.maintenanceCategory6Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor6 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance6"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','6','242');">
											<span class="tooltiptext1">
												Day: 6 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks6}<br>
												Category: ${model.maintenanceCategory6Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor6 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance6"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','6','242');">
											<span class="tooltiptext1">
												Day: 6 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks6}<br>
												Category: ${model.maintenanceCategory6Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor6 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance6"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','6','242');">
											<span class="tooltiptext1">
												Day: 6 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks6}<br>
												Category: ${model.maintenanceCategory6Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance6"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','6','242');">
											<span class="tooltiptext1">
												Day: 6 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks6}<br>
												Category: ${model.maintenanceCategory6Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps6Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor7 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;" value="<bean:write name="model" property="gps7"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','7','241');">
											<span class="tooltiptext1">
												Day: 7 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks7}<br>
												Trip Issue: ${model.gpsTripIssue7Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor7 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;" value="<bean:write name="model" property="gps7"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','7','241');">
											<span class="tooltiptext1">
												Day: 7 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks7}<br>
												Trip Issue: ${model.gpsTripIssue7Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor7 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps7"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','7','241');">
											<span class="tooltiptext1">
												Day: 7 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks7}<br>
												Trip Issue: ${model.gpsTripIssue7Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor7 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps7"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','7','241');">
											<span class="tooltiptext1">
												Day: 7 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks7}<br>
												Trip Issue: ${model.gpsTripIssue7Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;"  value="<bean:write name="model" property="gps7"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','7','241');">
											<span class="tooltiptext1">
												Day: 7 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks7}<br>
												Trip Issue: ${model.gpsTripIssue7Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor7 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance7"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','7','242');">
											<span class="tooltiptext1">
												Day: 7 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks7}<br>
												Category: ${model.maintenanceCategory7Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor7 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance7"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','7','242');">
											<span class="tooltiptext1">
												Day: 7 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks7}<br>
												Category: ${model.maintenanceCategory7Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor7 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance7"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','7','242');">
											<span class="tooltiptext1">
												Day: 7 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks7}<br>
												Category: ${model.maintenanceCategory7Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor7 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance7"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','7','242');">
											<span class="tooltiptext1">
												Day: 7 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks7}<br>
												Category: ${model.maintenanceCategory7Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor7 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance7"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','7','242');">
											<span class="tooltiptext1">
												Day: 7 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks7}<br>
												Category: ${model.maintenanceCategory7Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor7 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance7"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','7','242');">
											<span class="tooltiptext1">
												Day: 7 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks7}<br>
												Category: ${model.maintenanceCategory7Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance7"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','7','242');">
											<span class="tooltiptext1">
												Day: 7 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks7}<br>
												Category: ${model.maintenanceCategory7Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps7Vol}" readonly="readonly"/></td>
							<td align="center" style="text-align: center; background-color: #FFA500;"><input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="totalTripsGPSWeek1"/>"></td>
							<td align="center"><input type="text" style="text-align: center; background-color: #FFFF00;" size="5px" value="${model.gpsWeek1Vol}" readonly="readonly"/></td>
							<td align="center" style="text-align: center; background-color: #FFA500;"><input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="totalAvailabilityWeek1"/>"></td>
							<td align="center" style="text-align: center; background-color: #FFA500;"><input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="percentageWeek1"/>"></td>
							<c:choose>
								<c:when test="${model.gpsColor8 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;"  value="<bean:write name="model" property="gps8"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','8','241');">
											<span class="tooltiptext1">
												Day: 8 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks8}<br>
												Trip Issue: ${model.gpsTripIssue8Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor8 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;"  value="<bean:write name="model" property="gps8"/>"  onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','8','241');">
											<span class="tooltiptext1">
												Day: 8 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks8}<br>
												Trip Issue: ${model.gpsTripIssue8Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor8 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps8"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','8','241');">
											<span class="tooltiptext1">
												Day: 8 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks8}<br>
												Trip Issue: ${model.gpsTripIssue8Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor8 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps8"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','8','241');">
											<span class="tooltiptext1">
												Day: 8 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks8}<br>
												Trip Issue: ${model.gpsTripIssue8Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;"  value="<bean:write name="model" property="gps8"/>"  onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','8','241');">
											<span class="tooltiptext1">
												Day: 8 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks8}<br>
												Trip Issue: ${model.gpsTripIssue8Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor8 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance8"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','8','242');">
											<span class="tooltiptext1">
												Day: 8 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks8}<br>
												Category: ${model.maintenanceCategory8Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor8 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance8"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','8','242');">
											<span class="tooltiptext1">
												Day: 8 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks8}<br>
												Category: ${model.maintenanceCategory8Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor8 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance8"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','8','242');">
											<span class="tooltiptext1">
												Day: 8 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks8}<br>
												Category: ${model.maintenanceCategory8Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor8 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance8"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','8','242');">
											<span class="tooltiptext1">
												Day: 8 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks8}<br>
												Category: ${model.maintenanceCategory8Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor8 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance8"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','8','242');">
											<span class="tooltiptext1">
												Day: 8 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks8}<br>
												Category: ${model.maintenanceCategory8Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor8 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance8"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','8','242');">
											<span class="tooltiptext1">
												Day: 8 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks8}<br>
												Category: ${model.maintenanceCategory8Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance8"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','8','242');">
											<span class="tooltiptext1">
												Day: 8 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks8}<br>
												Category: ${model.maintenanceCategory8Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps8Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor9 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;"  value="<bean:write name="model" property="gps9"/>"  onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','9','241');">
											<span class="tooltiptext1">
												Day: 9 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks9}<br>
												Trip Issue: ${model.gpsTripIssue9Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor9 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;"  value="<bean:write name="model" property="gps9"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','9','241');">
											<span class="tooltiptext1">
												Day: 9 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks9}<br>
												Trip Issue: ${model.gpsTripIssue9Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor9 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps9"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','9','241');">
											<span class="tooltiptext1">
												Day: 9 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks9}<br>
												Trip Issue: ${model.gpsTripIssue9Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor9 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps9"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','9','241');">
											<span class="tooltiptext1">
												Day: 9 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks9}<br>
												Trip Issue: ${model.gpsTripIssue9Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;"  value="<bean:write name="model" property="gps9"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','9','241');">
											<span class="tooltiptext1">
												Day: 9 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks9}<br>
												Trip Issue: ${model.gpsTripIssue9Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor9 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance9"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','9','242');">
											<span class="tooltiptext1">
												Day: 9 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks9}<br>
												Category: ${model.maintenanceCategory9Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor9 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance9"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','9','242');">
											<span class="tooltiptext1">
												Day: 9 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks9}<br>
												Category: ${model.maintenanceCategory9Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor9 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance9"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','9','242');">
											<span class="tooltiptext1">
												Day: 9 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks9}<br>
												Category: ${model.maintenanceCategory9Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor9 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance9"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','9','242');">
											<span class="tooltiptext1">
												Day: 9 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks9}<br>
												Category: ${model.maintenanceCategory9Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor9 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance9"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','9','242');">
											<span class="tooltiptext1">
												Day: 9 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks9}<br>
												Category: ${model.maintenanceCategory9Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor9 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance9"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','9','242');">
											<span class="tooltiptext1">
												Day: 9 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks9}<br>
												Category: ${model.maintenanceCategory9Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance9"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','9','242');">
											<span class="tooltiptext1">
												Day: 9 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks9}<br>
												Category: ${model.maintenanceCategory9Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps9Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor10 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;"  value="<bean:write name="model" property="gps10"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','10','241');">
											<span class="tooltiptext1">
												Day: 10 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks10}<br>
												Trip Issue: ${model.gpsTripIssue10Desc}
											</span>
										</div>	
									</td>
								</c:when>
								<c:when test="${model.gpsColor10 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;"  value="<bean:write name="model" property="gps10"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','10','241');">
											<span class="tooltiptext1">
												Day: 10 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks10}<br>
												Trip Issue: ${model.gpsTripIssue10Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor10 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps10"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','10','241');">
											<span class="tooltiptext1">
												Day: 10 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks10}<br>
												Trip Issue: ${model.gpsTripIssue10Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor10 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps10"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','10','241');">
											<span class="tooltiptext1">
												Day: 10 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks10}<br>
												Trip Issue: ${model.gpsTripIssue10Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;"  value="<bean:write name="model" property="gps10"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','10','241');">
											<span class="tooltiptext1">
												Day: 10 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks10}<br>
												Trip Issue: ${model.gpsTripIssue10Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor10 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance10"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','10','242');">
											<span class="tooltiptext1">
												Day: 10 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks10}<br>
												Category: ${model.maintenanceCategory10Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor10 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance10"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','10','242');">
											<span class="tooltiptext1">
												Day: 10 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks10}<br>
												Category: ${model.maintenanceCategory10Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor10 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance10"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','10','242');">
											<span class="tooltiptext1">
												Day: 10 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks10}<br>
												Category: ${model.maintenanceCategory10Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor10 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance10"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','10','242');">
											<span class="tooltiptext1">
												Day: 10 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks10}<br>
												Category: ${model.maintenanceCategory10Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor10 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance10"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','10','242');">
											<span class="tooltiptext1">
												Day: 10 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks10}<br>
												Category: ${model.maintenanceCategory10Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor10 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance10"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','10','242');">
											<span class="tooltiptext1">
												Day: 10 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks10}<br>
												Category: ${model.maintenanceCategory10Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance10"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','10','242');">
											<span class="tooltiptext1">
												Day: 10 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks10}<br>
												Category: ${model.maintenanceCategory10Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps10Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor11 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;"  value="<bean:write name="model" property="gps11"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','11','241');">
											<span class="tooltiptext1">
												Day: 11 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks11}<br>
												Trip Issue: ${model.gpsTripIssue11Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor11 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;"  value="<bean:write name="model" property="gps11"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','11','241');">
											<span class="tooltiptext1">
												Day: 11 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks11}<br>
												Trip Issue: ${model.gpsTripIssue11Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor11 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps11"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','11','241');">
											<span class="tooltiptext1">
												Day: 11 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks11}<br>
												Trip Issue: ${model.gpsTripIssue11Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor11 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps11"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','11','241');">
											<span class="tooltiptext1">
												Day: 11 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks11}<br>
												Trip Issue: ${model.gpsTripIssue11Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;"  value="<bean:write name="model" property="gps11"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','11','241');">
											<span class="tooltiptext1">
												Day: 11 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks11}<br>
												Trip Issue: ${model.gpsTripIssue11Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor11 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance11"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','11','242');">
											<span class="tooltiptext1">
												Day: 11 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks11}<br>
												Category: ${model.maintenanceCategory11Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor11 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance11"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','11','242');">
											<span class="tooltiptext1">
												Day: 11 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks11}<br>
												Category: ${model.maintenanceCategory11Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor11 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance11"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','11','242');">
											<span class="tooltiptext1">
												Day: 11 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks11}<br>
												Category: ${model.maintenanceCategory11Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor11 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance11"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','11','242');">
											<span class="tooltiptext1">
												Day: 11 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks11}<br>
												Category: ${model.maintenanceCategory11Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor11 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance11"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','11','242');">
											<span class="tooltiptext1">
												Day: 11 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks11}<br>
												Category: ${model.maintenanceCategory11Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor11 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance11"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','11','242');">
											<span class="tooltiptext1">
												Day: 11 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks11}<br>
												Category: ${model.maintenanceCategory11Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance11"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','11','242');">
											<span class="tooltiptext1">
												Day: 11 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks11}<br>
												Category: ${model.maintenanceCategory11Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps11Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor12 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;"  value="<bean:write name="model" property="gps12"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','12','241');">
											<span class="tooltiptext1">
												Day: 12 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks12}<br>
												Trip Issue: ${model.gpsTripIssue12Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor12 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;"  value="<bean:write name="model" property="gps12"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','12','241');">
											<span class="tooltiptext1">
												Day: 12 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks12}<br>
												Trip Issue: ${model.gpsTripIssue12Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor12 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps12"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','12','241');">
											<span class="tooltiptext1">
												Day: 12 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks12}<br>
												Trip Issue: ${model.gpsTripIssue12Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor12 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps12"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','12','241');">
											<span class="tooltiptext1">
												Day: 12 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks12}<br>
												Trip Issue: ${model.gpsTripIssue12Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;"  value="<bean:write name="model" property="gps12"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','12','241');">
											<span class="tooltiptext1">
												Day: 12 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks12}<br>
												Trip Issue: ${model.gpsTripIssue12Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor12 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance12"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','12','242');">
											<span class="tooltiptext1">
												Day: 12 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks12}<br>
												Category: ${model.maintenanceCategory12Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor12 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance12"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','12','242');">
											<span class="tooltiptext1">
												Day: 12 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks12}<br>
												Category: ${model.maintenanceCategory12Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor12 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance12"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','12','242');">
											<span class="tooltiptext1">
												Day: 12 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks12}<br>
												Category: ${model.maintenanceCategory12Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor12 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance12"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','12','242');">
											<span class="tooltiptext1">
												Day: 12 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks12}<br>
												Category: ${model.maintenanceCategory12Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor12 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance12"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','12','242');">
											<span class="tooltiptext1">
												Day: 12 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks12}<br>
												Category: ${model.maintenanceCategory12Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor12 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance12"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','12','242');">
											<span class="tooltiptext1">
												Day: 12 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks12}<br>
												Category: ${model.maintenanceCategory12Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance12"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','12','242');">
											<span class="tooltiptext1">
												Day: 12 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks12}<br>
												Category: ${model.maintenanceCategory12Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps12Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor13 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;"  value="<bean:write name="model" property="gps13"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','13','241');">
											<span class="tooltiptext1">
												Day: 13 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks13}<br>
												Trip Issue: ${model.gpsTripIssue13Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor13 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;"  value="<bean:write name="model" property="gps13"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','13','241');">
											<span class="tooltiptext1">
												Day: 13 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks13}<br>
												Trip Issue: ${model.gpsTripIssue13Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor13 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps13"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','13','241');">
											<span class="tooltiptext1">
												Day: 13 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks13}<br>
												Trip Issue: ${model.gpsTripIssue13Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor13 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps13"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','13','241');">
											<span class="tooltiptext1">
												Day: 13 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks13}<br>
												Trip Issue: ${model.gpsTripIssue13Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;"  value="<bean:write name="model" property="gps13"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','13','241');">
											<span class="tooltiptext1">
												Day: 13 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks13}<br>
												Trip Issue: ${model.gpsTripIssue13Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor13 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance13"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','13','242');">
											<span class="tooltiptext1">
												Day: 13 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks13}<br>
												Category: ${model.maintenanceCategory13Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor13 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance13"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','13','242');">
											<span class="tooltiptext1">
												Day: 13 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks13}<br>
												Category: ${model.maintenanceCategory13Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor13 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance13"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','13','242');">
											<span class="tooltiptext1">
												Day: 13 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks13}<br>
												Category: ${model.maintenanceCategory13Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor13 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance13"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','13','242');">
											<span class="tooltiptext1">
												Day: 13 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks13}<br>
												Category: ${model.maintenanceCategory13Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor13 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance13"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','13','242');">
											<span class="tooltiptext1">
												Day: 13 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks13}<br>
												Category: ${model.maintenanceCategory13Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor13 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance13"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','13','242');">
											<span class="tooltiptext1">
												Day: 13 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks13}<br>
												Category: ${model.maintenanceCategory13Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance13"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','13','242');">
											<span class="tooltiptext1">
												Day: 13 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks13}<br>
												Category: ${model.maintenanceCategory13Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps13Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor14 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;"  value="<bean:write name="model" property="gps14"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','14','241');">
											<span class="tooltiptext1">
												Day: 14 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks14}<br>
												Trip Issue: ${model.gpsTripIssue14Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor14 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;"  value="<bean:write name="model" property="gps14"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','14','241');">
											<span class="tooltiptext1">
												Day: 14 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks14}<br>
												Trip Issue: ${model.gpsTripIssue14Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor14 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps14"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','14','241');">
											<span class="tooltiptext1">
												Day: 14 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks14}<br>
												Trip Issue: ${model.gpsTripIssue14Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor14 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps14"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','14','241');">
											<span class="tooltiptext1">
												Day: 14 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks14}<br>
												Trip Issue: ${model.gpsTripIssue14Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;"  value="<bean:write name="model" property="gps14"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','14','241');">
											<span class="tooltiptext1">
												Day: 14 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks14}<br>
												Trip Issue: ${model.gpsTripIssue14Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor14 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance14"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','14','242');">
											<span class="tooltiptext1">
												Day: 14 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks14}<br>
												Category: ${model.maintenanceCategory14Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor14 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance14"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','14','242');">
											<span class="tooltiptext1">
												Day: 14 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks14}<br>
												Category: ${model.maintenanceCategory14Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor14 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance14"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','14','242');">
											<span class="tooltiptext1">
												Day: 14 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks14}<br>
												Category: ${model.maintenanceCategory14Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor14 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance14"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','14','242');">
											<span class="tooltiptext1">
												Day: 14 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks14}<br>
												Category: ${model.maintenanceCategory14Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor14 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance14"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','14','242');">
											<span class="tooltiptext1">
												Day: 14 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks14}<br>
												Category: ${model.maintenanceCategory14Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor14 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance14"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','14','242');">
											<span class="tooltiptext1">
												Day: 14 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks14}<br>
												Category: ${model.maintenanceCategory14Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance14"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','14','242');">
											<span class="tooltiptext1">
												Day: 14 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks14}<br>
												Category: ${model.maintenanceCategory14Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps14Vol}" readonly="readonly"/></td>
							<td align="center" style="text-align: center; background-color: #FFA500;"><input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="totalTripsGPSWeek2"/>"></td>
							<td align="center"><input type="text" style="text-align: center; background-color: #FFFF00;" size="5px" value="${model.gpsWeek2Vol}" readonly="readonly"/></td>
							<td align="center" style="text-align: center; background-color: #FFA500;"><input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="totalAvailabilityWeek2"/>"></td>
							<td align="center" style="text-align: center; background-color: #FFA500;"><input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="percentageWeek2"/>"></td>
							<c:choose>
								<c:when test="${model.gpsColor15 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;"  value="<bean:write name="model" property="gps15"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','15','241');">
											<span class="tooltiptext1">
												Day: 15 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks15}<br>
												Trip Issue: ${model.gpsTripIssue15Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor15 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;"  value="<bean:write name="model" property="gps15"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','15','241');">
											<span class="tooltiptext1">
												Day: 15 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks15}<br>
												Trip Issue: ${model.gpsTripIssue15Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor15 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps15"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','15','241');">
											<span class="tooltiptext1">
												Day: 15 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks15}<br>
												Trip Issue: ${model.gpsTripIssue15Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor15 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps15"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','15','241');">
											<span class="tooltiptext1">
												Day: 15 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks15}<br>
												Trip Issue: ${model.gpsTripIssue15Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;"  value="<bean:write name="model" property="gps15"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','15','241');">
											<span class="tooltiptext1">
												Day: 15 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks15}<br>
												Trip Issue: ${model.gpsTripIssue15Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor15 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance15"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','15','242');">
											<span class="tooltiptext1">
												Day: 15 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks15}<br>
												Category: ${model.maintenanceCategory15Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor15 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance15"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','15','242');">
											<span class="tooltiptext1">
												Day: 15 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks15}<br>
												Category: ${model.maintenanceCategory15Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor15 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance15"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','15','242');">
											<span class="tooltiptext1">
												Day: 15 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks15}<br>
												Category: ${model.maintenanceCategory15Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor15 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance15"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','15','242');">
											<span class="tooltiptext1">
												Day: 15 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks15}<br>
												Category: ${model.maintenanceCategory15Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor15 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance15"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','15','242');">
											<span class="tooltiptext1">
												Day: 15 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks15}<br>
												Category: ${model.maintenanceCategory15Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor15 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance15"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','15','242');">
											<span class="tooltiptext1">
												Day: 15 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks15}<br>
												Category: ${model.maintenanceCategory15Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance15"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','15','242');">
											<span class="tooltiptext1">
												Day: 15 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks15}<br>
												Category: ${model.maintenanceCategory15Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps15Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor16 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;"  value="<bean:write name="model" property="gps16"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','16','241');">
											<span class="tooltiptext1">
												Day: 16 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks16}<br>
												Trip Issue: ${model.gpsTripIssue16Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor16 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;"  value="<bean:write name="model" property="gps16"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','16','241');">
											<span class="tooltiptext1">
												Day: 16 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks16}<br>
												Trip Issue: ${model.gpsTripIssue16Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor16 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps16"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','16','241');">
											<span class="tooltiptext1">
												Day: 16 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks16}<br>
												Trip Issue: ${model.gpsTripIssue16Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor16 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps16"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','16','241');">
											<span class="tooltiptext1">
												Day: 16 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks16}<br>
												Trip Issue: ${model.gpsTripIssue16Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;"  value="<bean:write name="model" property="gps16"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','16','241');">
											<span class="tooltiptext1">
												Day: 16 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks16}<br>
												Trip Issue: ${model.gpsTripIssue16Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor16 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance16"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','16','242');">
											<span class="tooltiptext1">
												Day: 16 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks16}<br>
												Category: ${model.maintenanceCategory16Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor16 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance16"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','16','242');">
											<span class="tooltiptext1">
												Day: 16 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks16}<br>
												Category: ${model.maintenanceCategory16Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor16 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance16"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','16','242');">
											<span class="tooltiptext1">
												Day: 16 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks16}<br>
												Category: ${model.maintenanceCategory16Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor16 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance16"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','16','242');">
											<span class="tooltiptext1">
												Day: 16 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks16}<br>
												Category: ${model.maintenanceCategory16Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor16 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance16"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','16','242');">
											<span class="tooltiptext1">
												Day: 16 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks16}<br>
												Category: ${model.maintenanceCategory16Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor16 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance16"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','16','242');">
											<span class="tooltiptext1">
												Day: 16 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks16}<br>
												Category: ${model.maintenanceCategory16Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance16"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','16','242');">
											<span class="tooltiptext1">
												Day: 16 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks16}<br>
												Category: ${model.maintenanceCategory16Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps16Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor17 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;"  value="<bean:write name="model" property="gps17"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','17','241');">
											<span class="tooltiptext1">
												Day: 17 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks17}<br>
												Trip Issue: ${model.gpsTripIssue17Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor17 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;"  value="<bean:write name="model" property="gps17"/>"  onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','17','241');">
											<span class="tooltiptext1">
												Day: 17 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks17}<br>
												Trip Issue: ${model.gpsTripIssue17Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor17 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps17"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','17','241');">
											<span class="tooltiptext1">
												Day: 17 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks17}<br>
												Trip Issue: ${model.gpsTripIssue17Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor17 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps17"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','17','241');">
											<span class="tooltiptext1">
												Day: 17 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks17}<br>
												Trip Issue: ${model.gpsTripIssue17Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;"  value="<bean:write name="model" property="gps17"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','17','241');">
											<span class="tooltiptext1">
												Day: 17 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks17}<br>
												Trip Issue: ${model.gpsTripIssue17Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor17 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance17"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','17','242');">
											<span class="tooltiptext1">
												Day: 17 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks17}<br>
												Category: ${model.maintenanceCategory17Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor17 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance17"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','17','242');">
											<span class="tooltiptext1">
												Day: 17 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks17}<br>
												Category: ${model.maintenanceCategory17Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor17 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance17"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','17','242');">
											<span class="tooltiptext1">
												Day: 17 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks17}<br>
												Category: ${model.maintenanceCategory17Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor17 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance17"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','17','242');">
											<span class="tooltiptext1">
												Day: 17 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks17}<br>
												Category: ${model.maintenanceCategory17Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor17 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance17"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','17','242');">
											<span class="tooltiptext1">
												Day: 17 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks17}<br>
												Category: ${model.maintenanceCategory17Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor17 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance17"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','17','242');">
											<span class="tooltiptext1">
												Day: 17 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks17}<br>
												Category: ${model.maintenanceCategory17Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance17"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','17','242');">
											<span class="tooltiptext1">
												Day: 17 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks17}<br>
												Category: ${model.maintenanceCategory17Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps17Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor18 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;"  value="<bean:write name="model" property="gps18"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','18','241');">
											<span class="tooltiptext1">
												Day: 18 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks18}<br>
												Trip Issue: ${model.gpsTripIssue18Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor18 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;"  value="<bean:write name="model" property="gps18"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','18','241');">
											<span class="tooltiptext1">
												Day: 18 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks18}<br>
												Trip Issue: ${model.gpsTripIssue18Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor18 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps18"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','18','241');">
											<span class="tooltiptext1">
												Day: 18 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks18}<br>
												Trip Issue: ${model.gpsTripIssue18Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor18 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps18"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','18','241');">
											<span class="tooltiptext1">
												Day: 18 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks18}<br>
												Trip Issue: ${model.gpsTripIssue18Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;"  value="<bean:write name="model" property="gps18"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','18','241');">
											<span class="tooltiptext1">
												Day: 18 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks18}<br>
												Trip Issue: ${model.gpsTripIssue18Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor18 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance18"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','18','242');">
											<span class="tooltiptext1">
												Day: 18 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks18}<br>
												Category: ${model.maintenanceCategory18Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor18 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance18"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','18','242');">
											<span class="tooltiptext1">
												Day: 18 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks18}<br>
												Category: ${model.maintenanceCategory18Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor18 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance18"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','18','242');">
											<span class="tooltiptext1">
												Day: 18 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks18}<br>
												Category: ${model.maintenanceCategory18Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor18 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance18"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','18','242');">
											<span class="tooltiptext1">
												Day: 18 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks18}<br>
												Category: ${model.maintenanceCategory18Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor18 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance18"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','18','242');">
											<span class="tooltiptext1">
												Day: 18 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks18}<br>
												Category: ${model.maintenanceCategory18Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor18 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance18"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','18','242');">
											<span class="tooltiptext1">
												Day: 18 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks18}<br>
												Category: ${model.maintenanceCategory18Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance18"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','18','242');">
											<span class="tooltiptext1">
												Day: 18 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks18}<br>
												Category: ${model.maintenanceCategory18Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps18Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor19 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;"  value="<bean:write name="model" property="gps19"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','19','241');">
											<span class="tooltiptext1">
												Day: 19 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks19}<br>
												Trip Issue: ${model.gpsTripIssue19Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor19 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;"  value="<bean:write name="model" property="gps19"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','19','241');">
											<span class="tooltiptext1">
												Day: 19 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks19}<br>
												Trip Issue: ${model.gpsTripIssue19Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor19 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps19"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','19','241');">
											<span class="tooltiptext1">
												Day: 19 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks19}<br>
												Trip Issue: ${model.gpsTripIssue19Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor19 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps19"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','19','241');">
											<span class="tooltiptext1">
												Day: 19 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks19}<br>
												Trip Issue: ${model.gpsTripIssue19Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;"  value="<bean:write name="model" property="gps19"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','19','241');">
											<span class="tooltiptext1">
												Day: 19 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks19}<br>
												Trip Issue: ${model.gpsTripIssue19Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor19 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance19"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','19','242');">
											<span class="tooltiptext1">
												Day: 19 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks19}<br>
												Category: ${model.maintenanceCategory19Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor19 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance19"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','19','242');">
											<span class="tooltiptext1">
												Day: 19 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks19}<br>
												Category: ${model.maintenanceCategory19Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor19 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance19"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','19','242');">
											<span class="tooltiptext1">
												Day: 19 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks19}<br>
												Category: ${model.maintenanceCategory19Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor19 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance19"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','19','242');">
											<span class="tooltiptext1">
												Day: 19 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks19}<br>
												Category: ${model.maintenanceCategory19Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor19 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance19"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','19','242');">
											<span class="tooltiptext1">
												Day: 19 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks19}<br>
												Category: ${model.maintenanceCategory19Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor19 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance19"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','19','242');">
											<span class="tooltiptext1">
												Day: 19 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks19}<br>
												Category: ${model.maintenanceCategory19Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance19"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','19','242');">
											<span class="tooltiptext1">
												Day: 19 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks19}<br>
												Category: ${model.maintenanceCategory19Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps19Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor20 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;"  value="<bean:write name="model" property="gps20"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','20','241');">
											<span class="tooltiptext1">
												Day: 20 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks20}<br>
												Trip Issue: ${model.gpsTripIssue20Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor20 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;"  value="<bean:write name="model" property="gps20"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','20','241');">
											<span class="tooltiptext1">
												Day: 20 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks20}<br>
												Trip Issue: ${model.gpsTripIssue20Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor20 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps20"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','20','241');">
											<span class="tooltiptext1">
												Day: 20 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks20}<br>
												Trip Issue: ${model.gpsTripIssue20Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor20 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps20"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','20','241');">
											<span class="tooltiptext1">
												Day: 20 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks20}<br>
												Trip Issue: ${model.gpsTripIssue20Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;"  value="<bean:write name="model" property="gps20"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','20','241');">
											<span class="tooltiptext1">
												Day: 20 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks20}<br>
												Trip Issue: ${model.gpsTripIssue20Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor20 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance20"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','20','242');">
											<span class="tooltiptext1">
												Day: 20 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks20}<br>
												Category: ${model.maintenanceCategory20Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor20 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance20"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','20','242');">
											<span class="tooltiptext1">
												Day: 20 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks20}<br>
												Category: ${model.maintenanceCategory20Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor20 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance20"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','20','242');">
											<span class="tooltiptext1">
												Day: 20 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks20}<br>
												Category: ${model.maintenanceCategory20Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor20 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance20"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','20','242');">
											<span class="tooltiptext1">
												Day: 20 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks20}<br>
												Category: ${model.maintenanceCategory20Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor20 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance20"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','20','242');">
											<span class="tooltiptext1">
												Day: 20 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks20}<br>
												Category: ${model.maintenanceCategory20Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor20 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance20"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','20','242');">
											<span class="tooltiptext1">
												Day: 20 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks20}<br>
												Category: ${model.maintenanceCategory20Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance20"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','20','242');">
											<span class="tooltiptext1">
												Day: 20 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks20}<br>
												Category: ${model.maintenanceCategory20Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps20Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor21 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;"  value="<bean:write name="model" property="gps21"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','21','241');">
											<span class="tooltiptext1">
												Day: 21 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks21}<br>
												Trip Issue: ${model.gpsTripIssue21Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor21 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;"  value="<bean:write name="model" property="gps21"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','21','241');">
											<span class="tooltiptext1">
												Day: 21 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks21}<br>
												Trip Issue: ${model.gpsTripIssue21Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor21 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps21"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','21','241');">
											<span class="tooltiptext1">
												Day: 21 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks21}<br>
												Trip Issue: ${model.gpsTripIssue21Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor21 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps21"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','21','241');">
											<span class="tooltiptext1">
												Day: 21 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks21}<br>
												Trip Issue: ${model.gpsTripIssue21Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;"  value="<bean:write name="model" property="gps21"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','21','241');">
											<span class="tooltiptext1">
												Day: 21 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks21}<br>
												Trip Issue: ${model.gpsTripIssue21Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor21 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance21"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','21','242');">
											<span class="tooltiptext1">
												Day: 21 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks21}<br>
												Category: ${model.maintenanceCategory21Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor21 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance21"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','21','242');">
											<span class="tooltiptext1">
												Day: 21 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks21}<br>
												Category: ${model.maintenanceCategory21Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor21 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance21"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','21','242');">
											<span class="tooltiptext1">
												Day: 21 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks21}<br>
												Category: ${model.maintenanceCategory21Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor21 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance21"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','21','242');">
											<span class="tooltiptext1">
												Day: 21 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks21}<br>
												Category: ${model.maintenanceCategory21Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor21 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance21"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','21','242');">
											<span class="tooltiptext1">
												Day: 21 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks21}<br>
												Category: ${model.maintenanceCategory21Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor21 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance21"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','21','242');">
											<span class="tooltiptext1">
												Day: 21 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks21}<br>
												Category: ${model.maintenanceCategory21Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance21"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','21','242');">
											<span class="tooltiptext1">
												Day: 21 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks21}<br>
												Category: ${model.maintenanceCategory21Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps21Vol}" readonly="readonly"/></td>
							<td align="center" style="text-align: center; background-color: #FFA500;"><input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="totalTripsGPSWeek3"/>"></td>
							<td align="center"><input type="text" style="text-align: center; background-color: #FFFF00;" size="5px" value="${model.gpsWeek3Vol}" readonly="readonly"/></td>
							<td align="center" style="text-align: center; background-color: #FFA500;"><input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="totalAvailabilityWeek3"/>"></td>
							<td align="center" style="text-align: center; background-color: #FFA500;"><input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="percentageWeek3"/>"></td>
							<c:choose>
								<c:when test="${model.gpsColor22 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;"  value="<bean:write name="model" property="gps22"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','22','241');">
											<span class="tooltiptext1">
												Day: 22 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks22}<br>
												Trip Issue: ${model.gpsTripIssue22Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor22 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;"  value="<bean:write name="model" property="gps22"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','22','241');">
											<span class="tooltiptext1">
												Day: 22 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks22}<br>
												Trip Issue: ${model.gpsTripIssue22Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor22 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps22"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','22','241');">
											<span class="tooltiptext1">
												Day: 22 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks22}<br>
												Trip Issue: ${model.gpsTripIssue22Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor22 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps22"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','22','241');">
											<span class="tooltiptext1">
												Day: 22 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks22}<br>
												Trip Issue: ${model.gpsTripIssue22Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;"  value="<bean:write name="model" property="gps22"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','22','241');">
											<span class="tooltiptext1">
												Day: 22 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks22}<br>
												Trip Issue: ${model.gpsTripIssue22Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor22 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance22"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','22','242');">
											<span class="tooltiptext1">
												Day: 22 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks22}<br>
												Category: ${model.maintenanceCategory22Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor22 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance22"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','22','242');">
											<span class="tooltiptext1">
												Day: 22 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks22}<br>
												Category: ${model.maintenanceCategory22Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor22 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance22"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','22','242');">
											<span class="tooltiptext1">
												Day: 22 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks22}<br>
												Category: ${model.maintenanceCategory22Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor22 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance22"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','22','242');">
											<span class="tooltiptext1">
												Day: 22 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks22}<br>
												Category: ${model.maintenanceCategory22Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor22 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance22"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','22','242');">
											<span class="tooltiptext1">
												Day: 22 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks22}<br>
												Category: ${model.maintenanceCategory22Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor22 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance22"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','22','242');">
											<span class="tooltiptext1">
												Day: 22 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks22}<br>
												Category: ${model.maintenanceCategory22Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance22"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','22','242');">
											<span class="tooltiptext1">
												Day: 22 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks22}<br>
												Category: ${model.maintenanceCategory22Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps22Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor23 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;"  value="<bean:write name="model" property="gps23"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','23','241');">
											<span class="tooltiptext1">
												Day: 23 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks23}<br>
												Trip Issue: ${model.gpsTripIssue23Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor23 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;"  value="<bean:write name="model" property="gps23"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','23','241');">
											<span class="tooltiptext1">
												Day: 23 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks23}<br>
												Trip Issue: ${model.gpsTripIssue23Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor23 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps23"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','23','241');">
											<span class="tooltiptext1">
												Day: 23 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks23}<br>
												Trip Issue: ${model.gpsTripIssue23Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor23 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps23"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','23','241');">
											<span class="tooltiptext1">
												Day: 23 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks23}<br>
												Trip Issue: ${model.gpsTripIssue23Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;"  value="<bean:write name="model" property="gps23"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','23','241');">
											<span class="tooltiptext1">
												Day: 23 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks23}<br>
												Trip Issue: ${model.gpsTripIssue23Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor23 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance23"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','23','242');">
											<span class="tooltiptext1">
												Day: 23 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks23}<br>
												Category: ${model.maintenanceCategory23Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor23 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance23"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','23','242');">
											<span class="tooltiptext1">
												Day: 23 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks23}<br>
												Category: ${model.maintenanceCategory23Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor23 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance23"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','23','242');">
											<span class="tooltiptext1">
												Day: 23 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks23}<br>
												Category: ${model.maintenanceCategory23Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor23 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance23"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','23','242');">
											<span class="tooltiptext1">
												Day: 23 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks23}<br>
												Category: ${model.maintenanceCategory23Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor23 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance23"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','23','242');">
											<span class="tooltiptext1">
												Day: 23 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks23}<br>
												Category: ${model.maintenanceCategory23Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor23 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance23"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','23','242');">
											<span class="tooltiptext1">
												Day: 23 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks23}<br>
												Category: ${model.maintenanceCategory23Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance23"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','23','242');">
											<span class="tooltiptext1">
												Day: 23 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks23}<br>
												Category: ${model.maintenanceCategory23Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps23Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor24 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;"  value="<bean:write name="model" property="gps24"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','24','241');">
											<span class="tooltiptext1">
												Day: 24 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks24}<br>
												Trip Issue: ${model.gpsTripIssue24Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor24 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;"  value="<bean:write name="model" property="gps24"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','24','241');">
											<span class="tooltiptext1">
												Day: 24 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks24}<br>
												Trip Issue: ${model.gpsTripIssue24Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor24 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps24"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','24','241');">
											<span class="tooltiptext1">
												Day: 24 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks24}<br>
												Trip Issue: ${model.gpsTripIssue24Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor24 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps24"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','24','241');">
											<span class="tooltiptext1">
												Day: 24 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks24}<br>
												Trip Issue: ${model.gpsTripIssue24Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;"  value="<bean:write name="model" property="gps24"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','24','241');">
											<span class="tooltiptext1">
												Day: 24 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks24}<br>
												Trip Issue: ${model.gpsTripIssue24Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor24 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance24"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','24','242');">
											<span class="tooltiptext1">
												Day: 24 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks24}<br>
												Category: ${model.maintenanceCategory24Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor24 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance24"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','24','242');">
											<span class="tooltiptext1">
												Day: 24 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks24}<br>
												Category: ${model.maintenanceCategory24Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor24 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance24"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','24','242');">
											<span class="tooltiptext1">
												Day: 24 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks24}<br>
												Category: ${model.maintenanceCategory24Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor24 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance24"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','24','242');">
											<span class="tooltiptext1">
												Day: 24 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks24}<br>
												Category: ${model.maintenanceCategory24Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor24 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance24"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','24','242');">
											<span class="tooltiptext1">
												Day: 24 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks24}<br>
												Category: ${model.maintenanceCategory24Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor24 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance24"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','24','242');">
											<span class="tooltiptext1">
												Day: 24 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks24}<br>
												Category: ${model.maintenanceCategory24Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance24"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','24','242');">
											<span class="tooltiptext1">
												Day: 24 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks24}<br>
												Category: ${model.maintenanceCategory24Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps24Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor25 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;"  value="<bean:write name="model" property="gps25"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','25','241');">
											<span class="tooltiptext1">
												Day: 25 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks25}<br>
												Trip Issue: ${model.gpsTripIssue25Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor25 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;"  value="<bean:write name="model" property="gps25"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','25','241');">
											<span class="tooltiptext1">
												Day: 25 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks25}<br>
												Trip Issue: ${model.gpsTripIssue25Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor25 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps25"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','25','241');">
											<span class="tooltiptext1">
												Day: 25 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks25}<br>
												Trip Issue: ${model.gpsTripIssue25Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor25 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps25"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','25','241');">
											<span class="tooltiptext1">
												Day: 25 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks25}<br>
												Trip Issue: ${model.gpsTripIssue25Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;"  value="<bean:write name="model" property="gps25"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','25','241');">
											<span class="tooltiptext1">
												Day: 25 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks25}<br>
												Trip Issue: ${model.gpsTripIssue25Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor25 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance25"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','25','242');">
											<span class="tooltiptext1">
												Day: 25 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks25}<br>
												Category: ${model.maintenanceCategory25Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor25 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance25"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','25','242');">
											<span class="tooltiptext1">
												Day: 25 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks25}<br>
												Category: ${model.maintenanceCategory25Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor25 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance25"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','25','242');">
											<span class="tooltiptext1">
												Day: 25 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks25}<br>
												Category: ${model.maintenanceCategory25Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor25 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance25"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','25','242');">
											<span class="tooltiptext1">
												Day: 25 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks25}<br>
												Category: ${model.maintenanceCategory25Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor25 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance25"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','25','242');">
											<span class="tooltiptext1">
												Day: 25 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks25}<br>
												Category: ${model.maintenanceCategory25Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor25 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance25"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','25','242');">
											<span class="tooltiptext1">
												Day: 25 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks25}<br>
												Category: ${model.maintenanceCategory25Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance25"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','25','242');">
											<span class="tooltiptext1">
												Day: 25 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks25}<br>
												Category: ${model.maintenanceCategory25Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps25Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor26 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;"  value="<bean:write name="model" property="gps26"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','26','241');">
											<span class="tooltiptext1">
												Day: 26 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks26}<br>
												Trip Issue: ${model.gpsTripIssue26Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor26 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;"  value="<bean:write name="model" property="gps26"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','26','241');">
											<span class="tooltiptext1">
												Day: 26 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks26}<br>
												Trip Issue: ${model.gpsTripIssue26Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor26 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps26"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','26','241');">
											<span class="tooltiptext1">
												Day: 26 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks26}<br>
												Trip Issue: ${model.gpsTripIssue26Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor26 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps26"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','26','241');">
											<span class="tooltiptext1">
												Day: 26 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks26}<br>
												Trip Issue: ${model.gpsTripIssue26Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;"  value="<bean:write name="model" property="gps26"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','26','241');">
											<span class="tooltiptext1">
												Day: 26 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks26}<br>
												Trip Issue: ${model.gpsTripIssue26Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor26 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance26"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','26','242');">
											<span class="tooltiptext1">
												Day: 26 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks26}<br>
												Category: ${model.maintenanceCategory26Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor26 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance26"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','26','242');">
											<span class="tooltiptext1">
												Day: 26 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks26}<br>
												Category: ${model.maintenanceCategory26Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor26 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance26"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','26','242');">
											<span class="tooltiptext1">
												Day: 26 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks26}<br>
												Category: ${model.maintenanceCategory26Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor26 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance26"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','26','242');">
											<span class="tooltiptext1">
												Day: 26 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks26}<br>
												Category: ${model.maintenanceCategory26Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor26 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance26"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','26','242');">
											<span class="tooltiptext1">
												Day: 26 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks26}<br>
												Category: ${model.maintenanceCategory26Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor26 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance26"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','26','242');">
											<span class="tooltiptext1">
												Day: 26 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks26}<br>
												Category: ${model.maintenanceCategory26Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance26"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','26','242');">
											<span class="tooltiptext1">
												Day: 26 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks26}<br>
												Category: ${model.maintenanceCategory26Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps26Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor27 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;"  value="<bean:write name="model" property="gps27"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','27','241');">
											<span class="tooltiptext1">
												Day: 27 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks27}<br>
												Trip Issue: ${model.gpsTripIssue27Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor27 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;"  value="<bean:write name="model" property="gps27"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','27','241');">
											<span class="tooltiptext1">
												Day: 27 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks27}<br>
												Trip Issue: ${model.gpsTripIssue27Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor27 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps27"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','27','241');">
											<span class="tooltiptext1">
												Day: 27 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks27}<br>
												Trip Issue: ${model.gpsTripIssue27Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor27 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps27"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','27','241');">
											<span class="tooltiptext1">
												Day: 27 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks27}<br>
												Trip Issue: ${model.gpsTripIssue27Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;"  value="<bean:write name="model" property="gps27"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','27','241');">
											<span class="tooltiptext1">
												Day: 27 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks27}<br>
												Trip Issue: ${model.gpsTripIssue27Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor27 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance27"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','27','242');">
											<span class="tooltiptext1">
												Day: 27 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks27}<br>
												Category: ${model.maintenanceCategory27Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor27 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance27"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','27','242');">
											<span class="tooltiptext1">
												Day: 27 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks27}<br>
												Category: ${model.maintenanceCategory27Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor27 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance27"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','27','242');">
											<span class="tooltiptext1">
												Day: 27 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks27}<br>
												Category: ${model.maintenanceCategory27Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor27 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance27"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','27','242');">
											<span class="tooltiptext1">
												Day: 27 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks27}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor27 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance27"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','27','242');">
											<span class="tooltiptext1">
												Day: 27 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks27}<br>
												Category: ${model.maintenanceCategory27Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor27 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance27"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','27','242');">
											<span class="tooltiptext1">
												Day: 27 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks27}<br>
												Category: ${model.maintenanceCategory27Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance27"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','27','242');">
											<span class="tooltiptext1">
												Day: 27 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks27}<br>
												Category: ${model.maintenanceCategory27Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps27Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor28 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;"  value="<bean:write name="model" property="gps28"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','28','241');">
											<span class="tooltiptext1">
												Day: 28 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks28}<br>
												Trip Issue: ${model.gpsTripIssue28Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor28 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;"  value="<bean:write name="model" property="gps28"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','28','241');">
											<span class="tooltiptext1">
												Day: 28 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks28}<br>
												Trip Issue: ${model.gpsTripIssue28Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor28 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps28"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','28','241');">
											<span class="tooltiptext1">
												Day: 28 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks28}<br>
												Trip Issue: ${model.gpsTripIssue28Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor28 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps28"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','28','241');">
											<span class="tooltiptext1">
												Day: 28 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks28}<br>
												Trip Issue: ${model.gpsTripIssue28Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;"  value="<bean:write name="model" property="gps28"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','28','241');">
											<span class="tooltiptext1">
												Day: 28 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks28}<br>
												Trip Issue: ${model.gpsTripIssue28Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor28 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance28"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','28','242');">
											<span class="tooltiptext1">
												Day: 28 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks28}<br>
												Category: ${model.maintenanceCategory28Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor28 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance28"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','28','242');">
											<span class="tooltiptext1">
												Day: 28 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks28}<br>
												Category: ${model.maintenanceCategory28Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor28 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance28"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','28','242');">
											<span class="tooltiptext1">
												Day: 28 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks28}<br>
												Category: ${model.maintenanceCategory28Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor28 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance28"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','28','242');">
											<span class="tooltiptext1">
												Day: 28 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks28}<br>
												Category: ${model.maintenanceCategory28Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor28 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance28"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','28','242');">
											<span class="tooltiptext1">
												Day: 28 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks28}<br>
												Category: ${model.maintenanceCategory28Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor28 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance28"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','28','242');">
											<span class="tooltiptext1">
												Day: 28 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks28}<br>
												Category: ${model.maintenanceCategory28Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance28"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','28','242');">
											<span class="tooltiptext1">
												Day: 28 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks28}<br>
												Category: ${model.maintenanceCategory28Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps28Vol}" readonly="readonly"/></td>
							<td align="center" style="text-align: center; background-color: #FFA500;"><input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="totalTripsGPSWeek4"/>"></td>
							<td align="center"><input type="text" style="text-align: center; background-color: #FFFF00;" size="5px" value="${model.gpsWeek4Vol}" readonly="readonly"/></td>
							<td align="center" style="text-align: center; background-color: #FFA500;"><input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="totalAvailabilityWeek4"/>"></td>
							<td align="center" style="text-align: center; background-color: #FFA500;"><input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="percentageWeek4"/>"></td>
							<c:choose>
								<c:when test="${model.gpsColor29 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;"  value="<bean:write name="model" property="gps29"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','29','241');">
											<span class="tooltiptext1">
												Day: 29 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks29}<br>
												Trip Issue: ${model.gpsTripIssue29Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor29 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;"  value="<bean:write name="model" property="gps29"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','29','241');">
											<span class="tooltiptext1">
												Day: 29 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks29}<br>
												Trip Issue: ${model.gpsTripIssue29Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor29 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps29"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','29','241');">
											<span class="tooltiptext1">
												Day: 29 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks29}<br>
												Trip Issue: ${model.gpsTripIssue29Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor29 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps29"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','29','241');">
											<span class="tooltiptext1">
												Day: 29 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks29}<br>
												Trip Issue: ${model.gpsTripIssue29Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;"  value="<bean:write name="model" property="gps29"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','29','241');">
											<span class="tooltiptext1">
												Day: 29 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks29}<br>
												Trip Issue: ${model.gpsTripIssue29Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor29 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance29"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','29','242');">
											<span class="tooltiptext1">
												Day: 29 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks29}<br>
												Category: ${model.maintenanceCategory29Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor29 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance29"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','29','242');">
											<span class="tooltiptext1">
												Day: 29 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks29}<br>
												Category: ${model.maintenanceCategory29Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor29 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance29"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','29','242');">
											<span class="tooltiptext1">
												Day: 29 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks29}<br>
												Category: ${model.maintenanceCategory29Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor29 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance29"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','29','242');">
											<span class="tooltiptext1">
												Day: 29 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks29}<br>
												Category: ${model.maintenanceCategory29Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor29 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance29"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','29','242');">
											<span class="tooltiptext1">
												Day: 29 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks29}<br>
												Category: ${model.maintenanceCategory29Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor29 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance29"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','29','242');">
											<span class="tooltiptext1">
												Day: 29 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks29}<br>
												Category: ${model.maintenanceCategory29Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance29"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','29','242');">
											<span class="tooltiptext1">
												Day: 29 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks29}<br>
												Category: ${model.maintenanceCategory29Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps29Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor30 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;"  value="<bean:write name="model" property="gps30"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','30','241');">
											<span class="tooltiptext1">
												Day: 30 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks30}<br>
												Trip Issue: ${model.gpsTripIssue30Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor30 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;"  value="<bean:write name="model" property="gps30"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','30','241');">
											<span class="tooltiptext1">
												Day: 30 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks30}<br>
												Trip Issue: ${model.gpsTripIssue30Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor30 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps30"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','30','241');">
											<span class="tooltiptext1">
												Day: 30 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks30}<br>
												Trip Issue: ${model.gpsTripIssue30Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor30 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps30"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','30','241');">
											<span class="tooltiptext1">
												Day: 30 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks30}<br>
												Trip Issue: ${model.gpsTripIssue30Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;"  value="<bean:write name="model" property="gps30"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','30','241');">
											<span class="tooltiptext1">
												Day: 30 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks30}<br>
												Trip Issue: ${model.gpsTripIssue30Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor30 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance30"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','30','242');">
											<span class="tooltiptext1">
												Day: 30 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks30}<br>
												Category: ${model.maintenanceCategory30Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor30 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance30"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','30','242');">
											<span class="tooltiptext1">
												Day: 30 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks30}<br>
												Category: ${model.maintenanceCategory30Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor30 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance30"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','30','242');">
											<span class="tooltiptext1">
												Day: 30 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks30}<br>
												Category: ${model.maintenanceCategory30Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor30 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance30"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','30','242');">
											<span class="tooltiptext1">
												Day: 30 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks30}<br>
												Category: ${model.maintenanceCategory30Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor30 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance30"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','30','242');">
											<span class="tooltiptext1">
												Day: 30 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks30}<br>
												Category: ${model.maintenanceCategory30Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor30 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance30"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','30','242');">
											<span class="tooltiptext1">
												Day: 30 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks30}<br>
												Category: ${model.maintenanceCategory30Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance30"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','30','242');">
											<span class="tooltiptext1">
												Day: 30 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks30}<br>
												Category: ${model.maintenanceCategory30Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps30Vol}" readonly="readonly"/></td>
							<c:choose>
								<c:when test="${model.gpsColor31 == 1201}"><!-- orange -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #FFA500;"  value="<bean:write name="model" property="gps31"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','31','241');">
											<span class="tooltiptext1">
												Day: 31 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks31}<br>
												Trip Issue: ${model.gpsTripIssue31Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor31 == 1202}"><!-- green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #008000; color: white;"  value="<bean:write name="model" property="gps31"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','31','241');">
											<span class="tooltiptext1">
												Day: 31 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks31}<br>
												Trip Issue: ${model.gpsTripIssue31Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.gpsColor31 == 1203}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="<bean:write name="model" property="gps31"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','31','241');">
											<span class="tooltiptext1">
												Day: 31 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks31}<br>
												Trip Issue: ${model.gpsTripIssue31Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:when test="${model.gpsColor31 == 1204}"><!-- pale green -->
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: #98FB98;" value="<bean:write name="model" property="gps31"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','31','241');">
											<span class="tooltiptext1">
												Day: 31 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks31}<br>
												Trip Issue: ${model.gpsTripIssue31Desc}
											</span>
										</div>										
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input type="text" size="1px" style="text-align: center; background-color: white-space;"  value="<bean:write name="model" property="gps31"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','31','241');">
											<span class="tooltiptext1">
												Day: 31 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.gpsRemarks31}<br>
												Trip Issue: ${model.gpsTripIssue31Desc}
											</span>
										</div>
									</td>								
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${model.maintenanceColor31 == 1101}"><!-- red -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #FF0000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance31"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','31','242');">
											<span class="tooltiptext1">
												Day: 31 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks31}<br>
												Category: ${model.maintenanceCategory31Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor31 == 1102}"><!-- dark-green -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #006400; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance31"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','31','242');">
											<span class="tooltiptext1">
												Day: 31 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks31}<br>
												Category: ${model.maintenanceCategory31Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor31 == 1103}"><!-- black -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #000000; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance31"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','31','242');">
											<span class="tooltiptext1">
												Day: 31 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks31}<br>
												Category: ${model.maintenanceCategory31Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor31 == 1104}"><!-- violet -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #EE82EE;" type="text" size="1px" value="<bean:write name="model" property="maintenance31"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','31','242');">
											<span class="tooltiptext1">
												Day: 31 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks31}<br>
												Category: ${model.maintenanceCategory31Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor31 == 1105}"><!-- gray -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #808080; color: #FFFFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance31"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','31','242');">
											<span class="tooltiptext1">
												Day: 31 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks31}<br>
												Category: ${model.maintenanceCategory31Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:when test="${model.maintenanceColor31 == 1106}"><!-- cyan -->
									<td>
										<div class="tooltip1">
											<input style="text-align: center; background-color: #00FFFF;" type="text" size="1px" value="<bean:write name="model" property="maintenance31"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','31','242');">
											<span class="tooltiptext1">
												Day: 31 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks31}<br>
												Category: ${model.maintenanceCategory31Desc}
											</span>
										</div>
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<div class="tooltip1">
											<input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="maintenance31"/>" onclick="openUpdateWindow('${model.id}','${model.plateNo}','${model.trailerNo}','${model.lorryNo}','${model.capacity}','${model.year}','${model.month}','31','242');">
											<span class="tooltiptext1">
												Day: 31 <br>
												PlateNo: ${model.plateNo} <br>
												TrailerNo: ${model.trailerNo} <br>
												LorryNo: ${model.lorryNo} <br>
												Remarks: ${model.maintenanceRemarks31}<br>
												Category: ${model.maintenanceCategory31Desc}
											</span>
										</div>
									</td>
								</c:otherwise>
							</c:choose>
							<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="2px" value="${model.gps31Vol}" readonly="readonly"/></td>
							<td align="center" style="text-align: center; background-color: #FF8C00;"><input style="text-align: center;" type="text" size="1px" value="<bean:write name="model" property="totalTripsGPSWeek5"/>"></td>
							<td align="center"><input type="text" style="text-align: center; background-color: #FFFF00;" size="5px" value="${model.gpsWeek5Vol}" readonly="readonly"/></td>
							<td align="center"><input type="text" style="text-align: center; background-color: #FFFF00;" size="7px" value="${model.gpsMonthVol}" readonly="readonly"/></td>
							<td><input style="text-align: center; font-weight: bold;" type="text" size="1px" value="<bean:write name="model" property="totalMaintenance"/>"></td>	<!-- Total Maintenance of each lorry per month -->
							<td align="center" style="background-color: #FF0000;"><input readonly="readonly" style="text-align: center; font-weight: bold;" type="text" size="1px" value="<bean:write name="model" property="totalBreakdown"/>"></td>	<!-- color RED (total number of days breakdown) -->
							<td align="center" style="background-color: #00FFFF;"><input readonly="readonly" style="text-align: center; font-weight: bold;" type="text" size="1px" value="<bean:write name="model" property="totalPM"/>"></td>	<!-- color CYAN (total number of days PM) -->
							<td align="center" style="background-color: #808080;"><input readonly="readonly" style="text-align: center; font-weight: bold;" type="text" size="1px" value="<bean:write name="model" property="totalPending"/>"></td>	<!-- color GRAY (total number of days pending, for pullout, no driver) -->
							<td align="center" style="background-color: #006400;"><input readonly="readonly" style="text-align: center; font-weight: bold;" type="text" size="1px" value="<bean:write name="model" property="totalTargetDate"/>"></td>	<!-- color DARK GREEN (Target Date) -->
							<td align="center" style="background-color: #000000;"><input readonly="readonly" style="text-align: center; font-weight: bold;" type="text" size="1px" value="<bean:write name="model" property="totalExtended"/>"></td>	<!-- color BLACK (Extended) -->
							<td align="center" style="background-color: #EE82EE;"><input readonly="readonly" style="text-align: center; font-weight: bold;" type="text" size="1px" value="<bean:write name="model" property="totalEarlyDone"/>"></td>	<!-- color VIOLET (Early Done) -->
							<td align="center" style="background-color: #FF8C00;"><input readonly="readonly" style="text-align: center; font-weight: bold;" type="text" size="1px" value="<bean:write name="model" property="totalTripsGPS"/>"></td>	<!-- Orange Background BLACK GPS total trips per month -->
							<td align="center" style="background-color: #FF8C00;"><input readonly="readonly" style="text-align: center; font-weight: bold;" type="text" size="1px" value="<bean:write name="model" property="totalPercentage"/>"></td> <!-- Orange (Percentages) formulated in GPS total trips/month and total available in maintenance/month -->
							<td align="center" style="background-color: #FF8C00;">
								<div class="tooltip1">
									<input readonly="readonly" style="text-align: center; font-weight: bold;" type="text" size="1px" value="<bean:write name="model" property="totalGpsTripIssueTI"/>"><!-- GPS Trip Issue: Terminal Issue (TI) -->
									<span class="tooltiptext1">
										Terminal Issue (TI) <br>
										PlateNo: ${model.plateNo} <br>
										TrailerNo: ${model.trailerNo} <br>
										LorryNo: ${model.lorryNo} <br>
									</span>
								</div>
							</td>
							<td align="center" style="background-color: #FF8C00;">
								<div class="tooltip1">
									<input readonly="readonly" style="text-align: center; font-weight: bold;" type="text" size="1px" value="<bean:write name="model" property="totalGpsTripIssueMI"/>">	<!-- GPS Trip Issue: Maintenance Issue (MI) -->
									<span class="tooltiptext1">
										Maintenance Issue (MI) <br>
										PlateNo: ${model.plateNo} <br>
										TrailerNo: ${model.trailerNo} <br>
										LorryNo: ${model.lorryNo} <br>
									</span>
								</div>
							</td>
							<td align="center" style="background-color: #FF8C00;">
								<div class="tooltip1">
									<input readonly="readonly" style="text-align: center; font-weight: bold;" type="text" size="1px" value="<bean:write name="model" property="totalGpsTripIssueDI"/>">	<!-- GPS Trip Issue: Driver Issue (DI) -->
									<span class="tooltiptext1">
										Driver Issue (DI)<br>
										PlateNo: ${model.plateNo} <br>
										TrailerNo: ${model.trailerNo} <br>
										LorryNo: ${model.lorryNo} <br>
									</span>
								</div>
							</td>
							<td align="center" style="background-color: #FF8C00;">
								<div class="tooltip1">
									<input readonly="readonly" style="text-align: center; font-weight: bold;" type="text" size="1px" value="<bean:write name="model" property="totalGpsTripIssueCI"/>">	<!-- GPS Trip Issue: Customer Issue (CI) -->
									<span class="tooltiptext1">
										Customer Issue (CI)<br>
										PlateNo: ${model.plateNo} <br>
										TrailerNo: ${model.trailerNo} <br>
										LorryNo: ${model.lorryNo} <br>
									</span>
								</div>
							</td>
							<td align="center" style="background-color: #FF8C00;">
								<div class="tooltip1">
									<input readonly="readonly" style="text-align: center; font-weight: bold;" type="text" size="1px" value="<bean:write name="model" property="totalGpsTripIssueLV"/>">	<!-- GPS Trip Issue: Low Volume (LV) -->
									<span class="tooltiptext1">
										Low Volume (LV)<br>
										PlateNo: ${model.plateNo} <br>
										TrailerNo: ${model.trailerNo} <br>
										LorryNo: ${model.lorryNo} <br>
									</span>
								</div>
							</td>
							<td align="center" style="background-color: #FF8C00;">
								<div class="tooltip1">
									<input readonly="readonly" style="text-align: center; font-weight: bold;" type="text" size="1px" value="<bean:write name="model" property="totalGpsTripIssueLH"/>">	<!-- GPS Trip Issue: Long Haul (LH) -->
									<span class="tooltiptext1">
										Long Haul (LH)<br>
										PlateNo: ${model.plateNo} <br>
										TrailerNo: ${model.trailerNo} <br>
										LorryNo: ${model.lorryNo} <br>
									</span>
								</div>
							</td>
							<td align="center" style="background-color: #FF8C00;">
								<div class="tooltip1">
									<input readonly="readonly" style="text-align: center; font-weight: bold;" type="text" size="1px" value="<bean:write name="model" property="totalGpsTripIssueTBI"/>">	<!-- GPS Trip Issue: Truck Ban Issue (TBI) -->
									<span class="tooltiptext1">
										Truck Ban Issue (TBI)<br>
										PlateNo: ${model.plateNo} <br>
										TrailerNo: ${model.trailerNo} <br>
										LorryNo: ${model.lorryNo} <br>
									</span>
								</div>
							</td>
							<td align="center" style="background-color: #FF8C00;">
								<div class="tooltip1">
									<input readonly="readonly" style="text-align: center; font-weight: bold;" type="text" size="1px" value="<bean:write name="model" property="totalGpsTripIssueRI"/>">	<!-- GPS Trip Issue: Road Issue (RI) -->
									<span class="tooltiptext1">
										Road Issue (RI)<br>
										PlateNo: ${model.plateNo} <br>
										TrailerNo: ${model.trailerNo} <br>
										LorryNo: ${model.lorryNo} <br>
									</span>
								</div>
							</td>						
						</tr>
					</c:if>
				</logic:iterate>

				<!-- Last row for Total of Category of Caltex -->
				<c:if test="${category!=''}">
					<tr>
						<td colspan="4" align="center"><span style="font-weight: bold;">Total Available &nbsp; <c:out value="${category}"></c:out> &nbsp; in Maintenance</span></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip1}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance1}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol1}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip2}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance2}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol2}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip3}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance3}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol3}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip4}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance4}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol4}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip5}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance5}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol5}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip6}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance6}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol6}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip7}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance7}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol7}" ></td>
									<td></td>
									<td align="center"><input type="text" size="5px" style="text-align: center; font-weight: bold; background-color: #FFFF00; "value="${sumVolWeek1}" ></td>
									<td></td>
									<td></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip8}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance8}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol8}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip9}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance9}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol9}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip10}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance10}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol10}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip11}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance11}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol11}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip12}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance12}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol12}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip13}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance13}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol13}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip14}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance14}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol14}" ></td>
									<td></td>
									<td align="center"><input type="text" size="5px" style="text-align: center; font-weight: bold; background-color: #FFFF00; "value="${sumVolWeek2}" ></td>
									<td></td>
									<td></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip15}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance15}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol15}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip16}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance16}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol16}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip17}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance17}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol17}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip18}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance18}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol18}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip19}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance19}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol19}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip20}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance20}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol20}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip21}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance21}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol21}" ></td>
									<td></td>
									<td align="center"><input type="text" size="5px" style="text-align: center; font-weight: bold; background-color: #FFFF00; "value="${sumVolWeek3}" ></td>
									<td></td>
									<td></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip22}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance22}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol22}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip23}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance23}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol23}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip24}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance24}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol24}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip25}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance25}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol25}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip26}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance26}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol26}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip27}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance27}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol27}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip28}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance28}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol28}" ></td>
									<td></td>
									<td align="center"><input type="text" size="5px" style="text-align: center; font-weight: bold; background-color: #FFFF00; "value="${sumVolWeek4}" ></td>
									<td></td>
									<td></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip29}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance29}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol29}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip30}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance30}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol30}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumTrip31}" ></td>
									<td><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="${sumMaintenance31}" ></td>
									<td><input type="text" size="5px" style="text-align: center; font-weight: bold;"value="${sumVol31}" ></td>
									<td></td>
									<td align="center"><input type="text" size="5px" style="text-align: center; font-weight: bold; background-color: #FFFF00; "value="${sumVolWeek5}" ></td>
									<td align="center"><input type="text" size="8px" style="text-align: center; font-weight: bold; background-color: #FFFF00; "value="${sumVolWeek1+sumVolWeek2+sumVolWeek3+sumVolWeek4+sumVolWeek5}" ></td>
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
					<!-- Committed Volume -->
					<tr>
						<td colspan="2" style="color:red; background-color:lightgreen;">COMMITED VOLUME</td>
						<td style="color:red; background-color:lightgreen;">${committedVolume}</td>
						<!-- Batangas Black is Single Shift only -->
						<c:choose>
							<c:when test="${category=='BATANGAS BLACK'}">
								<td style="color:red; background-color:lightgreen;">${capacityOfTerminal*1000}</td>
							</c:when>
							<c:otherwise>
								<td style="color:red; background-color:lightgreen;">${capacityOfTerminal*1000*2}</td>
							</c:otherwise>
						</c:choose>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol1-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol2-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol3-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol4-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol5-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol6-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol7-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol8-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol9-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol10-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol11-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol12-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol13-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol14-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol15-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol16-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol17-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol18-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol19-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol20-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol21-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol22-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol23-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol24-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol25-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol26-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol27-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol28-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol29-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol30-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"><input type="text" size="8px" style="text-align: center; font-weight: bold;" readonly="readonly" value="${sumVol31-committedVolume}" ></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>	
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
						<td style="background-color:lightgreen;"></td>
					</tr>			
					
					<!-- Row for Daily Percentage Per category -->
					<tr>
						<td colspan="4" align="center"><span style="font-weight: bold;">Daily Percentages &nbsp; <c:out value="${category}"></c:out> &nbsp;</span></td>
						<td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance1/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance2/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance3/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance4/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance5/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance6/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance7/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td></td>
						<td></td>
						<td></td>
						<td></td>
						<td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance8/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance9/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance10/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance11/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance12/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance13/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance14/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td></td>
						<td></td>
						<td></td>
						<td></td>
						<td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance15/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance16/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance17/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance18/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance19/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance20/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance21/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td></td>
						<td></td>
						<td></td>
						<td></td>
						<td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance22/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance23/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance24/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance25/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance26/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance27/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance28/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td></td>
						<td></td>
						<td></td>
						<td></td>
						<td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance29/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance30/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td style="background-color: #32CD32;"></td>
        				<td style="background-color: #32CD32;"><input type="text" size="1px" style="text-align: center; font-weight: bold;"value="<fmt:formatNumber type = "percent" minFractionDigits = "0" value = "${sumMaintenance31/totalLorryCountPerCategory}" />" ></td> 
						<td style="background-color: #32CD32;"></td><td></td><td></td>
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
						<td></td>
					</tr>
				</c:if>
				
				<!-- Chevron Fleet Availability -->
				<logic:iterate name="maintenanceMonitoringForm" property="modelListCaltexFleet" type="com.transport.model.MaintenanceMonitoringFleet" id="model">
					<tr>
						<td colspan="4" align="center" style="font-weight: bold;">Chevron Daily Availability</td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG1" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM1" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG2" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM2" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG3" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM3" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG4" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM4" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG5" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM5" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG6" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM6" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG7" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM7" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="GPSTotalWeek1" />"/></td><td></td>
						<td></td>
						<td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG8" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM8" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG9" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM9" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG10" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM10" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG11" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM11" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG12" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM12" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG13" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM13" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG14" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM14" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="GPSTotalWeek2" />"/></td><td></td>
						<td></td>
						<td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG15" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM15" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG16" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM16" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG17" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM17" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG18" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM18" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG19" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM19" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG20" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM20" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG21" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM21" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="GPSTotalWeek3" />"/></td><td></td>
						<td></td>
						<td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG22" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM22" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG23" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM23" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG24" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM24" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG25" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM25" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG26" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM26" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG27" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM27" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG28" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM28" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="GPSTotalWeek4" />"/></td><td></td>
						<td></td>
						<td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG29" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM29" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG30" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM30" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalG31" />"/></td>
						<td><input type="text" style="text-align: center; background-color: #D2691E; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalM31" />"/></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="GPSTotalWeek5" />"/></td><td></td><td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td align="center" style="background-color: #FF8C00;"><input type="text" style="text-align: center; background-color: #000000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="GPSGrandTotal" />"/></td>
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
					<!-- Total Chevron Fleet -->
				<tr>
					<td colspan="4" align="center" style="font-weight: bold;">Total Chevron Fleet</td>
						<td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td><td></td>
						<td></td>
						<td></td>
						<td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td><td></td>
						<td></td>
						<td></td>
						<td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td><td></td>
						<td></td>
						<td></td>
						<td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td><td></td>
						<td></td>
						<td></td>
						<td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center;" size="1px" value="<bean:write name="model" property="totalLorry" />"/></td>
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
					<!-- Caltex Fleet Unavailable -->
					<tr>
						<td colspan="4" align="center" style="font-weight: bold;">Chevron Unavailable</td>
						<td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU1" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU2" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU3" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU4" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU5" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU6" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU7" />"/></td>
						<td></td><td></td><td></td>
						<td></td>
						<td></td>
						<td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU8" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU9" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU10" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU11" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU12" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU13" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU14" />"/></td>
						<td></td><td></td><td></td>
						<td></td>
						<td></td>
						<td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU15" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU16" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU17" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU18" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU19" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU20" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU21" />"/></td>
						<td></td><td></td><td></td>
						<td></td>
						<td></td>
						<td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU22" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU23" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU24" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU25" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU26" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU27" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU28" />"/></td>
						<td></td><td></td><td></td>
						<td></td>
						<td></td>
						<td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU29" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU30" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU31" />"/></td>
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

				<!-- Grand Total Fleet -->	
				<logic:iterate name="maintenanceMonitoringForm" property="modelListGrandTotalFleet" type="com.transport.model.MaintenanceMonitoringFleet" id="model">
					<tr>
						<td colspan="4" align="center" style="font-weight: bold;">Grand Total</td>
						<td colspan="129"></td>
					</tr>
					<tr>
						<td colspan="4" align="center" style="font-weight: bold;">Total for Shell and Chevron Availability</td>
						<td></td>
						<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="1px" value="<bean:write name="model" property="totalM1" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="1px" value="<bean:write name="model" property="totalM2" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="1px" value="<bean:write name="model" property="totalM3" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="1px" value="<bean:write name="model" property="totalM4" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="1px" value="<bean:write name="model" property="totalM5" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="1px" value="<bean:write name="model" property="totalM6" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="1px" value="<bean:write name="model" property="totalM7" />"/></td>
						<td></td><td></td><td></td>
						<td></td>
						<td></td>
						<td></td>
						<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="1px" value="<bean:write name="model" property="totalM8" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="1px" value="<bean:write name="model" property="totalM9" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="1px" value="<bean:write name="model" property="totalM10" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="1px" value="<bean:write name="model" property="totalM11" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="1px" value="<bean:write name="model" property="totalM12" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="1px" value="<bean:write name="model" property="totalM13" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="1px" value="<bean:write name="model" property="totalM14" />"/></td>
						<td></td><td></td><td></td>
						<td></td>
						<td></td>
						<td></td>
						<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="1px" value="<bean:write name="model" property="totalM15" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="1px" value="<bean:write name="model" property="totalM16" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="1px" value="<bean:write name="model" property="totalM17" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="1px" value="<bean:write name="model" property="totalM18" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="1px" value="<bean:write name="model" property="totalM19" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="1px" value="<bean:write name="model" property="totalM20" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="1px" value="<bean:write name="model" property="totalM21" />"/></td>
						<td></td><td></td><td></td>
						<td></td>
						<td></td>
						<td></td>
						<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="1px" value="<bean:write name="model" property="totalM22" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="1px" value="<bean:write name="model" property="totalM23" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="1px" value="<bean:write name="model" property="totalM24" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="1px" value="<bean:write name="model" property="totalM25" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="1px" value="<bean:write name="model" property="totalM26" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="1px" value="<bean:write name="model" property="totalM27" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="1px" value="<bean:write name="model" property="totalM28" />"/></td>
						<td></td><td></td><td></td>
						<td></td>
						<td></td>
						<td></td>
						<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="1px" value="<bean:write name="model" property="totalM29" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="1px" value="<bean:write name="model" property="totalM30" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FFFF00;" size="1px" value="<bean:write name="model" property="totalM31" />"/></td>
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
						<td colspan="4" align="center" style="font-weight: bold;">Total of Shell and Chevron Unavailable</td>
						<td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU1" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU2" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU3" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU4" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU5" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU6" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU7" />"/></td>
						<td></td><td></td><td></td>
						<td></td>
						<td></td>
						<td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU8" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU9" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU10" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU11" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU12" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU13" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU14" />"/></td>
						<td></td><td></td><td></td>
						<td></td>
						<td></td>
						<td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU15" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU16" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU17" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU18" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU19" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU20" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU21" />"/></td>
						<td></td><td></td><td></td>
						<td></td>
						<td></td>
						<td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU22" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU23" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU24" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU25" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU26" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU27" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU28" />"/></td>
						<td></td><td></td><td></td>
						<td></td>
						<td></td>
						<td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU29" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU30" />"/></td>
						<td></td><td></td>
						<td><input type="text" style="text-align: center; background-color: #FF0000; color: #FFFFFF;" size="1px" value="<bean:write name="model" property="totalU31" />"/></td>
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
								
				<!-- Preventive and Breakdown -->
				<jsp:include page="ajaxPreventiveBreakdown.jsp"></jsp:include>
				
				<!-- TOTAL -->
				<jsp:include page="ajaxTotalRow.jsp"></jsp:include>
				
				<!-- TOTAL PENDING - cannot put in separate JSP file because of global variable grandtotalpending -->
				<logic:iterate name="maintenanceMonitoringForm" property="modelListTotalPending" type="com.transport.model.MaintenanceMonitoringTotalPending" id="model">
					<tr>
						<td colspan="2" align="center" style="font-weight: bold;"></td>
						<td colspan="2" align="center" style="font-weight: bold;">Total Pending</td>
						<td></td> 
						<td>
							<div class="tooltip1">
								<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="${grandTotalPending1}" onclick="openUpdateTotalPendingWindow('${model.id}','${model.year}','${model.month}','1','2435')" />
								<span class="tooltiptext1">
									Total Pending - Day 1<br>
									Remarks: ${model.totalPendingComment1}
								</span>
							</div>
						</td>
						<td></td> <td></td>
						<td>
							<div class="tooltip1">
								<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="${grandTotalPending2}" onclick="openUpdateTotalPendingWindow('${model.id}','${model.year}','${model.month}','2','2435')"/>
								<span class="tooltiptext1">
									Total Pending - Day 2<br>
									Remarks: ${model.totalPendingComment2}
								</span>
							</div>
						</td>
						<td></td> <td></td>
						<td>
							<div class="tooltip1">
								<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="${grandTotalPending3}" onclick="openUpdateTotalPendingWindow('${model.id}','${model.year}','${model.month}','3','2435')"/>
								<span class="tooltiptext1">
									Total Pending - Day 3<br>
									Remarks: ${model.totalPendingComment3}
								</span>
							</div>
						</td>
						<td></td> <td></td>
						<td>
							<div class="tooltip1">
								<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="${grandTotalPending4}" onclick="openUpdateTotalPendingWindow('${model.id}','${model.year}','${model.month}','4','2435')"/>
								<span class="tooltiptext1">
									Total Pending - Day 4<br>
									Remarks: ${model.totalPendingComment4}
								</span>
							</div>
						</td>
						<td></td><td></td>
						<td>
							<div class="tooltip1">
								<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="${grandTotalPending5}" onclick="openUpdateTotalPendingWindow('${model.id}','${model.year}','${model.month}','5','2435')"/>
								<span class="tooltiptext1">
									Total Pending - Day 5<br>
									Remarks: ${model.totalPendingComment5}
								</span>
							</div>
						</td>
						<td></td> <td></td>
						<td>
							<div class="tooltip1">
								<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="${grandTotalPending6}" onclick="openUpdateTotalPendingWindow('${model.id}','${model.year}','${model.month}','6','2435')"/>
								<span class="tooltiptext1">
									Total Pending - Day 6<br>
									Remarks: ${model.totalPendingComment6}
								</span>
							</div>
						</td>
						<td></td> <td></td>
						<td>
							<div class="tooltip1">
								<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="${grandTotalPending7}" onclick="openUpdateTotalPendingWindow('${model.id}','${model.year}','${model.month}','7','2435')"/>
								<span class="tooltiptext1">
									Total Pending - Day 7<br>
									Remarks: ${model.totalPendingComment7}
								</span>
							</div>
						</td>
						<td></td> <td></td><td></td>
						<td></td> 
						<td></td> 
						<td></td> 
						<td>
							<div class="tooltip1">
								<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="${grandTotalPending8}" onclick="openUpdateTotalPendingWindow('${model.id}','${model.year}','${model.month}','8','2435')"/>
								<span class="tooltiptext1">
									Total Pending - Day 8<br>
									Remarks: ${model.totalPendingComment8}
								</span>
							</div>
						</td>
						<td></td> <td></td>
						<td>
							<div class="tooltip1">
								<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="${grandTotalPending9}" onclick="openUpdateTotalPendingWindow('${model.id}','${model.year}','${model.month}','9','2435')"/>
								<span class="tooltiptext1">
									Total Pending - Day 9<br>
									Remarks: ${model.totalPendingComment9}
								</span>
							</div>
						</td>
						<td></td> <td></td>
						<td>
							<div class="tooltip1">
								<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="${grandTotalPending10}" onclick="openUpdateTotalPendingWindow('${model.id}','${model.year}','${model.month}','10','2435')"/>
								<span class="tooltiptext1">
									Total Pending - Day 10<br>
									Remarks: ${model.totalPendingComment10}
								</span>
							</div>
						</td>
						<td></td> <td></td>
						<td>
							<div class="tooltip1">
								<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="${grandTotalPending11}" onclick="openUpdateTotalPendingWindow('${model.id}','${model.year}','${model.month}','11','2435')"/>
								<span class="tooltiptext1">
									Total Pending - Day 11<br>
									Remarks: ${model.totalPendingComment11}
								</span>
							</div>
						</td>
						<td></td> <td></td>
						<td>
							<div class="tooltip1">
								<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="${grandTotalPending12}" onclick="openUpdateTotalPendingWindow('${model.id}','${model.year}','${model.month}','12','2435')"/>
								<span class="tooltiptext1">
									Total Pending - Day 12<br>
									Remarks: ${model.totalPendingComment12}
								</span>
							</div>
						</td>
						<td></td> <td></td>
						<td>
							<div class="tooltip1">
								<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="${grandTotalPending13}" onclick="openUpdateTotalPendingWindow('${model.id}','${model.year}','${model.month}','13','2435')"/>
								<span class="tooltiptext1">
									Total Pending - Day 13<br>
									Remarks: ${model.totalPendingComment13}
								</span>
							</div>
						</td>
						<td></td> <td></td>
						<td>
							<div class="tooltip1">
								<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="${grandTotalPending14}" onclick="openUpdateTotalPendingWindow('${model.id}','${model.year}','${model.month}','14','2435')"/>
								<span class="tooltiptext1">
									Total Pending - Day 14<br>
									Remarks: ${model.totalPendingComment14}
								</span>
							</div>
						</td>
						<td></td> <td></td><td></td>
						<td></td> 
						<td></td> 
						<td></td> 
						<td>
							<div class="tooltip1">
								<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="${grandTotalPending15}" onclick="openUpdateTotalPendingWindow('${model.id}','${model.year}','${model.month}','15','2435')"/>
								<span class="tooltiptext1">
									Total Pending - Day 15<br>
									Remarks: ${model.totalPendingComment15}
								</span>
							</div>
						</td>
						<td></td> <td></td>
						<td>
							<div class="tooltip1">
								<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="${grandTotalPending16}" onclick="openUpdateTotalPendingWindow('${model.id}','${model.year}','${model.month}','16','2435')"/>
								<span class="tooltiptext1">
									Total Pending - Day 16<br>
									Remarks: ${model.totalPendingComment16}
								</span>
							</div>
						</td>
						<td></td> <td></td>
						<td>
							<div class="tooltip1">
								<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="${grandTotalPending17}" onclick="openUpdateTotalPendingWindow('${model.id}','${model.year}','${model.month}','17','2435')"/>
								<span class="tooltiptext1">
									Total Pending - Day 17<br>
									Remarks: ${model.totalPendingComment17}
								</span>
							</div>
						</td>
						<td></td> <td></td>
						<td>
							<div class="tooltip1">
								<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="${grandTotalPending18}" onclick="openUpdateTotalPendingWindow('${model.id}','${model.year}','${model.month}','18','2435')"/>
								<span class="tooltiptext1">
									Total Pending - Day 18<br>
									Remarks: ${model.totalPendingComment18}
								</span>
							</div>
						</td>
						<td></td> <td></td>
						<td>
							<div class="tooltip1">
								<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="${grandTotalPending19}" onclick="openUpdateTotalPendingWindow('${model.id}','${model.year}','${model.month}','19','2435')"/>
								<span class="tooltiptext1">
									Total Pending - Day 19<br>
									Remarks: ${model.totalPendingComment19}
								</span>
							</div>
						</td>
						<td></td> <td></td>
						<td>
							<div class="tooltip1">
								<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="${grandTotalPending20}" onclick="openUpdateTotalPendingWindow('${model.id}','${model.year}','${model.month}','20','2435')"/>
								<span class="tooltiptext1">
									Total Pending - Day 20<br>
									Remarks: ${model.totalPendingComment20}
								</span>
							</div>
						</td>
						<td></td> <td></td>
						<td>
							<div class="tooltip1">
								<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="${grandTotalPending21}" onclick="openUpdateTotalPendingWindow('${model.id}','${model.year}','${model.month}','21','2435')"/>
								<span class="tooltiptext1">
									Total Pending - Day 21<br>
									Remarks: ${model.totalPendingComment21}
								</span>
							</div>
						</td>
						<td></td> <td></td><td></td>
						<td></td> 
						<td></td>
						<td></td> 
						<td>
							<div class="tooltip1">
								<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="${grandTotalPending22}" onclick="openUpdateTotalPendingWindow('${model.id}','${model.year}','${model.month}','22','2435')"/>
								<span class="tooltiptext1">
									Total Pending - Day 22<br>
									Remarks: ${model.totalPendingComment22}
								</span>
							</div>
						</td>
						<td></td> <td></td>
						<td>
							<div class="tooltip1">
								<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="${grandTotalPending23}" onclick="openUpdateTotalPendingWindow('${model.id}','${model.year}','${model.month}','23','2435')"/>
								<span class="tooltiptext1">
									Total Pending - Day 23<br>
									Remarks: ${model.totalPendingComment23}
								</span>
							</div>
						</td>
						<td></td> <td></td>
						<td>
							<div class="tooltip1">
								<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="${grandTotalPending24}" onclick="openUpdateTotalPendingWindow('${model.id}','${model.year}','${model.month}','24','2435')"/>
								<span class="tooltiptext1">
									Total Pending - Day 24<br>
									Remarks: ${model.totalPendingComment24}
								</span>
							</div>
						</td>
						<td></td> <td></td>
						<td>
							<div class="tooltip1">
								<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="${grandTotalPending25}" onclick="openUpdateTotalPendingWindow('${model.id}','${model.year}','${model.month}','25','2435')"/>
								<span class="tooltiptext1">
									Total Pending - Day 25<br>
									Remarks: ${model.totalPendingComment25}
								</span>
							</div>
						</td>
						<td></td> <td></td>
						<td>
							<div class="tooltip1">
								<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="${grandTotalPending26}" onclick="openUpdateTotalPendingWindow('${model.id}','${model.year}','${model.month}','26','2435')"/>
								<span class="tooltiptext1">
									Total Pending - Day 26<br>
									Remarks: ${model.totalPendingComment26}
								</span>
							</div>
						</td>
						<td></td> <td></td>
						<td>
							<div class="tooltip1">
								<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="${grandTotalPending27}" onclick="openUpdateTotalPendingWindow('${model.id}','${model.year}','${model.month}','27','2435')"/>
								<span class="tooltiptext1">
									Total Pending - Day 27<br>
									Remarks: ${model.totalPendingComment27}
								</span>
							</div>
						</td>
						<td></td> <td></td>
						<td>
							<div class="tooltip1">
								<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="${grandTotalPending28}" onclick="openUpdateTotalPendingWindow('${model.id}','${model.year}','${model.month}','28','2435')"/>
								<span class="tooltiptext1">
									Total Pending - Day 28<br>
									Remarks: ${model.totalPendingComment28}
								</span>
							</div>
						</td>
						<td></td> <td></td><td></td>
						<td></td> 
						<td></td>
						<td></td> 
						<td>
							<div class="tooltip1">
								<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="${grandTotalPending29}" onclick="openUpdateTotalPendingWindow('${model.id}','${model.year}','${model.month}','29','2435')"/>
								<span class="tooltiptext1">
									Total Pending - Day 29<br>
									Remarks: ${model.totalPendingComment29}
								</span>
							</div>
						</td>
						<td></td> <td></td>
						<td>
							<div class="tooltip1">
								<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="${grandTotalPending30}" onclick="openUpdateTotalPendingWindow('${model.id}','${model.year}','${model.month}','30','2435')"/>
								<span class="tooltiptext1">
									Total Pending - Day 30<br>
									Remarks: ${model.totalPendingComment30}
								</span>
							</div>
						</td>
						<td></td> <td></td>
						<td>
							<div class="tooltip1">
								<input type="text" size="1px" style="text-align: center; background-color: #808080; color: white;" value="${grandTotalPending31}" onclick="openUpdateTotalPendingWindow('${model.id}','${model.year}','${model.month}','31','2435')"/>
								<span class="tooltiptext1">
									Total Pending - Day 31<br>
									Remarks: ${model.totalPendingComment31}
								</span>
							</div>
						</td>
						<td></td> <td></td><td></td><td></td>
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
											
			</table>
		  </c:when>
		  <c:otherwise>
			<c:if test="${maintenanceMonitoringForm.transactionMessage == ''}">
				<div style="color: blue;">No Record found!</div>
			</c:if>
		  </c:otherwise>
		</c:choose>
	</div>
