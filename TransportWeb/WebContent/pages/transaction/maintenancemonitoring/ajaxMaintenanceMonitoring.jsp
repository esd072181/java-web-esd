<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
$(function() {
    $( "#menu" ).menu({
      items: "> :not(.ui-widget-header)"
    });
    
    $('#idYearCriteria').keyup(function(event){
       	 if (!$('#idYearCriteria').val() == '' && !$.isNumeric($('#idYearCriteria').val())) {
    		 alert("Only numbers are allowed!");
    		 var today = new Date();
    		 $('#idYearCriteria').val(today.getFullYear());
    		 return false;
    	 } else {
    		 return true;
    	 }	
    });

    $('#idYearCriteria').keydown(function(event) {
        if (event.which == 121) {
        	getMaintenanceMonitoring('0');
            return false;
        }  else {
        	return true;
        }
    });
    
    $('#idMonthCriteria').keydown(function(event) {
        if (event.which == 121) {
        	getMaintenanceMonitoring('0');
            return false;
        }  else {
        	return true;
        }
    });
    
    $('#idLorryNoCriteria').keydown(function(event) {
        if (event.which == 121) {
        	getMaintenanceMonitoring('0');
            return false;
        }  else {
        	return true;
        }
    });
    
    var today = new Date();
    var mm = today.getMonth() + 1; //January is 0!
    var yyyy = today.getFullYear();
    	
	$('#idYearCriteria').val(yyyy);
	$('#idMonthCriteria').val(mm);
	
	$("#idLorryNoCriteria").attr("placeholder", "ALL");
	$('#idLorryNoCriteria').focus();
	
	
  });

function openAddWindow(month) {
	window.open('/TransportWeb/maintenanceMonitoring.do?command=add&month=' + month,'popUpWindow','height=220,width=550,left=100,top=100,resizable=yes,scrollbars=yes,toolbar=yes,menubar=no,location=no,directories=no, status=yes');
}

function openUpdateWindow(id,plateNo,trailerNo,lorryNo,capacity,year,month,day,moduleInner) {
	window.open('/TransportWeb/maintenanceMonitoring.do?command=ajaxEdit&id='+id+'&plateNo='+plateNo+'&trailerNo='+trailerNo+'&lorryNo='+lorryNo+'&capacity='+capacity+'&year='+year+'&month='+month+'&day='+day+'&moduleInner='+moduleInner+'','popUpWindow','height=470,width=500,left=100,top=100,resizable=yes,scrollbars=yes,toolbar=yes,menubar=no,location=no,directories=no, status=yes');
}

function openUpdatePreventiveWindow(idPreventive,year,month,day,moduleInner) {
	window.open('/TransportWeb/maintenanceMonitoring.do?command=ajaxEdit&idPreventive='+idPreventive+'&year='+year+'&month='+month+'&day='+day+'&moduleInner='+moduleInner+'','popUpWindow','height=360,width=500,left=100,top=100,resizable=yes,scrollbars=yes,toolbar=yes,menubar=no,location=no,directories=no, status=yes');
}

function openUpdateTotalPendingWindow(idTotalPending,year,month,day,moduleInner) {
	window.open('/TransportWeb/maintenanceMonitoring.do?command=ajaxEdit&idTotalPending='+idTotalPending+'&year='+year+'&month='+month+'&day='+day+'&moduleInner='+moduleInner+'','popUpWindow','height=360,width=500,left=100,top=100,resizable=yes,scrollbars=yes,toolbar=yes,menubar=no,location=no,directories=no, status=yes');
}

function lockMaintenanceMonitoringByYearMonth () {
	bootbox.confirm("Are you sure you want to lock this record?", function(ans) {
		 if (ans) {
				$.ajax({
					  type: "POST",
					  url: "lockMaintenanceMonitoringByYearMonth.do?command=ajaxLock",
					  data: $("#idForm").serialize()
					})
					  .done(function( result ) {
						$("#tablePresentationDIV").html(result);
				});
		 } 
	}); 
}

function generateMaintenanceCategoryReport(year, month) {
	
	if ($('#idYearCriteria').val().trim() == '') {
		alert('Enter the year.');
		$('#idYearCriteria').focus();
		return false;
	}
	
	//create the pdf first
	$.ajax({
			type: "POST",
			url: "maintenanceMonitoring.do?command=ajaxReport&year="+year+"&month="+month,
			data: $("#idForm").serialize()
		})
		.done(function(result) {
			//then show the pdf report
			window.open('reports/MaintenanceCategory.pdf','popUpWindow','height=1200,width=1000,left=100,top=100,resizable=yes,scrollbars=yes,toolbar=yes,menubar=no,location=no,directories=no, status=yes');
		});
	return false;
}

</script>
						
	<div style="padding-left: 10px; position: sticky; top: 145px; background-color: white; z-index: 2" >
	
		<h3 style="font-weight: bolder; padding-top: 10px;">Maintenance Monitoring</h3>
		
		<html:form action="/maintenanceMonitoring.do" styleId="idForm">							
				<div>
					<html:errors/>
				</div>
				<div>
					<div>
						<div class="controls">
							<c:forEach items="${sessionScope.user_access_list}" var="item">
	        					<c:if test="${item == 925}">
	        						<html:button styleId="btnAddLorry" property="command" onclick="openAddWindow($('#idMonthCriteria').val());" value="Add New Lorry" styleClass="btn btn-primary"></html:button>
									&nbsp;		
	        					</c:if>
	        				</c:forEach>
							<label  class="control-label top-spacing" for="yearCriteria">Search Criteria: Year&nbsp;</label>
							<html:text property="yearCriteria" styleId="idYearCriteria" size="2"></html:text>
							<label  class="control-label top-spacing" for="monthCriteria">&nbsp;Month&nbsp;</label>
							<html:select  name="maintenanceMonitoringForm" property="monthCriteria" styleId="idMonthCriteria">
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
							<label  class="control-label top-spacing" for="lorryNoCriteria">&nbsp;&nbsp;LorryNo&nbsp;</label>
							<html:text property="lorryNoCriteria" styleId="idLorryNoCriteria" size="2"></html:text>&nbsp;
							<html:button styleId="btnSearchFilter" property="command" onclick="getMaintenanceMonitoring('0');" value="Search/Refresh Data" styleClass="btn btn-primary"></html:button>
							&nbsp;
			        		<html:button styleId="btnGenerateExcel" property="command" onclick="getMaintenanceMonitoring('1');" value="Download Excel File" styleClass="btn btn-primary"></html:button>
						</div>
					</div>
					<div style="padding-top: 5px;">
						<label  class="control-label top-spacing" for="yearCriteria">Report Type: </label>
						<html:select  name="maintenanceMonitoringForm" property="reportType" styleId="idReportType" value="1">
								<html:option value="1">Monthly</html:option>
								<html:option value="2">Annually</html:option> 			 		
							</html:select>
						<html:button styleId="btnGenerateCategory" property="command" onclick="generateMaintenanceCategoryReport($('#idYearCriteria').val(),$('#idMonthCriteria').val());" value="Generate Category Report" styleClass="btn btn-primary"></html:button>
					</div>
				</div>			
		</html:form>
		<hr>
	</div>
  	

	<!-- results using logic iterate -->
	<!-- using bootstrap -->
	<div id="tablePresentationDIV">
		<!-- ajax part of table data -->
	</div>

	<div style="padding-left: 20px;">
		<table>
			<tr>
				<td>LEGEND</td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td>Maintenance: </td>
				<td style="width: 200px; background-color: #FF0000;">BREAKDOWN</td><!-- red -->
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td style="width: 200px; background-color: #006400; color: WHITE;">TARGET DATE</td> <!-- dark green -->
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td style="width: 200px; background-color: #000000; color: WHITE;">EXTEND</td><!-- black -->
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td style="width: 200px; background-color: #EE82EE;">EARLY DONE</td><!-- violet -->
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td style="width: 200px; background-color: #808080;">PENDING</td><!-- gray -->
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td style="width: 200px; background-color: #00FFFF;">Preventive Maintenance</td><!-- cyan -->
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td style="width: 200px; background-color: #32CD32;">Repaired with Trip</td><!-- lime green -->
			</tr>
			<tr>
				<td></td>
				<td align="right">Gps: </td>
				<td style="width: 200px; background-color: #FFA500;">IDLE</td><!-- orange -->
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td style="width: 200px; background-color: #008000;  color: WHITE;">NON-REPORTING</td><!-- green -->
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td style="width: 200px; background-color: #808080; ">For Inspection(LIJEN)/PENDING</td><!-- gray -->
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td style="width: 200px; background-color: #000000;  color: WHITE;">TOTAL</td><!-- black -->
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td style="width: 200px; background-color: #98FB98;">Number of Trips</td><!-- pale green -->
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td style="width: 200px; background-color: #FF8C00;">Total Per Week</td> <!-- Dark Orange -->
			</tr>
		</table>
	</div>

