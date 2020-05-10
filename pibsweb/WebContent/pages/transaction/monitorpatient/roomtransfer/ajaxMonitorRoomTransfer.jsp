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

	  <div>
	  	<label style="font-weight: bold; font-size: 20px;">Room Transfer</label>	
	  	<html:button property="btnAdd" styleClass="btn btn-primary btnMonitoringSmallest" onclick="goToMonitorRoomTransferSearch('${monitorRoomTransferForm.patientCaseSystemId}');" value="Add New"></html:button>
	  	<span id="msgId" style="color: blue; padding-left: 100px; display: none;"><bean:message key="msg.updated"/></span>	  
	  </div>

	  <div class="table-responsive" style="padding-top: 10px; width: 700px;" >
		<c:choose>
			<c:when test="${monitorRoomTransferForm.entityList != null}">
				<table  id="tableId" class="table table-bordered table-striped table-condensed table-hover context-menu-table" style="width: 98%;">  
					<tr>
						<th>No</th>
						<th>Old RoomNo</th>
						<th>Date Admitted</th>
						<th>New RoomNo</th>
						<th>Date Transferred</th>
						<th></th>
					</tr>
					<logic:iterate name="monitorRoomTransferForm" property="entityList" type="com.pibs.model.MonitorRoomTransfer" id="model" indexId="counter">
						<tr>
							<td><c:out value="${counter+1}"></c:out></td>
							<td><bean:write name="model" property="roomNo"/></td>				 
							<td><bean:write name="model" property="dateAdmitted"/></td>
							<td><bean:write name="model" property="roomNoTransfer"/></td>				 
							<td><bean:write name="model" property="dateTransferred"/></td>
							<logic:lessThan name="counter" value="${monitorRoomTransferForm.entityList.size()-1}">
								<td></td>
							</logic:lessThan>
							<logic:equal name="counter" value="${monitorRoomTransferForm.entityList.size()-1}" >
								<td align="center"><a href="#" onclick="javascript: deleteMonitorRoomTransfer('<bean:write name="model" property="id"/>','${monitorRoomTransferForm.patientCaseSystemId}');">Remove</a></td>
							</logic:equal>
						</tr>
					</logic:iterate>
				</table>
			</c:when>
			<c:otherwise>
			 	<div style="color: blue;">No Record found!</div>
			</c:otherwise>
		</c:choose>
	  </div>
		


