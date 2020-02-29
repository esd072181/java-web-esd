<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>     
	 <script src="js/jquery-1.11.1.js" type="text/javascript"></script>
 	 <script src="js/bootstrap.min.js"></script>
 	 <script src="js/jquery-ui.min.js"></script>
	 <script src="js/transaction.js"></script>
</head>

<script>
$(function() {

	$('#lorryAndPlateNoId').focus();
	
  });

function selectLorryForAdd(isHide, value) {
	if (value==0) {
		return false;
	}
	
	if (isHide) {
		//$("#lorryAndPlateNoId").css("display","none"); or use hide() for jquery		
		var lorryArr = value.split("|");
		$("#plateNoId").val(lorryArr[0]);
		$("#lorryNoId").val(lorryArr[1]);		
	} 
}  

</script>

<html>
	<body>
	
		<form action="/saveMaintenanceMonitoring" name="maintenanceMonitoringForm" id="idPopupForm">
			
			<table>
					<tr>
						<td colspan="2"><h2>Add Lorry for Maintenance Monitoring</h2></td>
					</tr>

					<tr>
						<td><html:errors/></td>
					</tr>
				
                    <tr>
                        <td>Select Lorry</td>
  						<td>
  							<html:select style="width: 165px;" name="maintenanceMonitoringForm" property="lorryAndPlateNo" onchange="selectLorryForAdd(true, this.value);">
								<html:optionsCollection name="maintenanceMonitoringForm" property="lorryList" label="lorryAndPlateNo" value="lorryAndPlateNo"/>				 		
							</html:select>
						</td>	
					</tr>

					<tr>
						<td>Tractor Plate No</td>
						<td>
							<input id="plateNoId" style="width: 165px;" name="plateNo" type="text"  value="${maintenanceMonitoringForm.plateNo}" readonly="readonly">
						</td>
					</tr>
					
					<tr>
                        <td>Lorry No</td>
                        <td><input id="lorryNoId" style="width: 165px;" name="lorryNo" type="text" value="${maintenanceMonitoringForm.lorryNo}" readonly="readonly"></td>
                    </tr>
                                    	
					<tr>
						<td>Year</td>
						<td>
							<html:select style="width: 165px;" styleClass="" name="maintenanceMonitoringForm" property="year" styleId="yearId" value="2020"> 
								 <html:option value="2019">2019</html:option>
								 <html:option value="2020">2020</html:option>
								 <html:option value="2021">2021</html:option>
								 <html:option value="2022">2022</html:option>
								 <html:option value="2023">2023</html:option>
								 <html:option value="2024">2024</html:option>
								 <html:option value="2025">2025</html:option>
								 <html:option value="2026">2026</html:option>
								 <html:option value="2027">2027</html:option>
								 <html:option value="2028">2028</html:option>
								 <html:option value="2029">2029</html:option>
								 <html:option value="2030">2030</html:option>
								 <html:option value="2031">2031</html:option>
								 <html:option value="2032">2032</html:option>
								 <html:option value="2033">2033</html:option>
								 <html:option value="2034">2034</html:option>
								 <html:option value="2035">2035</html:option>
								 <html:option value="2036">2036</html:option>
								 <html:option value="2037">2037</html:option>
								 <html:option value="2038">2038</html:option>
								 <html:option value="2039">2039</html:option>
								 <html:option value="2040">2040</html:option>
								 <html:option value="2041">2041</html:option>
								 <html:option value="2042">2042</html:option>
								 <html:option value="2043">2043</html:option>
								 <html:option value="2044">2044</html:option>
								 <html:option value="2045">2045</html:option>				 		
							</html:select>
						</td>
					</tr>

					<tr>
						<td>Starting from Month</td>
						<td>
							<html:select style="width: 165px;" styleClass="" name="maintenanceMonitoringForm" property="month" styleId="monthId">
								<html:option value="1">January</html:option>
								<html:option value="2">February</html:option>
								<html:option value="3">March</html:option>
								<html:option value="4">April</html:option>
								<html:option value="5">May</html:option>
								<html:option value="6">June</html:option>
								<html:option value="7">July</html:option>
								<html:option value="8">August</html:option>
								<html:option value="9">September</html:option>
								<html:option value="10">October</html:option>
								<html:option value="11">November</html:option>
								<html:option value="12">December</html:option>			 		
							</html:select>
							&nbsp;&nbsp; To December
						</td>
					</tr>
					
					<tr height="10px"><td></td></tr>
					<tr>
						<td></td>
						<td><input type="button" style="margin-left: 120px;" name="saveBtn" value="Save" onclick="saveMaintenanceMonitoring();" /></td>
					</tr>
			</table>
				
		</form>
	
	</body>
</html>

