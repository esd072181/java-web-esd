<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
$(function() {
    $( "#menu" ).menu({
      items: "> :not(.ui-widget-header)"
    });
    
    //Press Enter for Search button or can use onkeypres event in html object
    $("#idSearchCriteria").keypress(function(event){
        if(event.keyCode == 13){
        	event.preventDefault();
            $("#btnSearchId").click();           
        }
    });
    
    $("#idSearchCriteria").focus();
    
  });
</script>
<div class="row">

  <div class="col-sm-10 divSpace" >

	<div style="height: 30%; padding-top: 0px;" align="left">
	
	  <div>
	  	<table>
	  		<tr class="hMargin10"></tr>
	  		<tr>
	  			<td><h3>Other Room</h3></td>
	  			<td class="padLeft5">
	  				<html:button property="btnAdd" styleClass="btn btn-primary btnMonitoringSmall" onclick="goToMonitorRoomSearch('${monitorRoomForm.patientCaseSystemId}');" value="Add New"></html:button>
	  			</td>
	  			<td>
	  				<span id="msgId" style="color: blue; padding-left: 100px; display: none;"><bean:message key="msg.updated"/></span>
	  			</td>
	  		</tr>	
	  	</table>	  
	  </div>
	  
	  <div class="table-responsive" align="left" >
		<c:choose>
		<c:when test="${monitorRoomForm.entityList != null}">
			<table  id="tableId" class="table table-bordered table-striped table-condensed table-hover context-menu-table" style="width: 98%;">  
				<tr>
					<th>RoomNo</th>
					<th>Category</th>
					<th>Days</th>
					<th>Fee</th>
					<th>Amount</th>
					<th>Date Used</th>
					<th>Time Used</th>
					<th></th>
					<th></th>
				</tr>
				<logic:iterate name="monitorRoomForm" property="entityList" type="com.pibs.model.MonitorRoom" id="model">
					<tr>
						<td><bean:write name="model" property="roomNo"/></td>				 
						<td><bean:write name="model" property="roomCategory"/></td>
						<td align="right"><bean:write name="model" property="days"/></td>
						<td align="right"><bean:write name="model" property="fee" format="Php #,###.00"/></td>
						<td align="right"><bean:write name="model" property="amount" format="Php #,###.00"/></td>
						<td><bean:write name="model" property="dateUsed"/></td>
						<td><bean:write name="model" property="timeUsed"/></td>
						<td align="center"><a href="#" onclick="javascript: editMonitorRoom('<bean:write name="model" property="id"/>');">Edit</a></td>
						<td align="center"><a href="#" onclick="javascript: deleteMonitorRoom('<bean:write name="model" property="id"/>','${monitorRoomForm.patientCaseSystemId}');">Remove</a></td>
					</tr>
				</logic:iterate>
			</table>
		</c:when>
		<c:otherwise>
		 	<div style="color: blue;">No Record found!</div>
		</c:otherwise>
		</c:choose>
	  </div>
	</div>
	
  </div>

</div>

