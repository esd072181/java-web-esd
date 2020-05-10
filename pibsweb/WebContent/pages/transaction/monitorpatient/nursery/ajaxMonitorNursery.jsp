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
	  	<label style="font-weight: bold; font-size: 20px;">Nursery</label>	
	  	<html:button property="btnAdd" styleClass="btn btn-primary btnMonitoringSmallest" onclick="goToMonitorNurseryAdd('${monitorNurseryForm.patientCaseSystemId}');" value="Add New"></html:button>
	  	<span id="msgId" style="color: blue; padding-left: 100px; display: none;"><bean:message key="msg.updated"/></span>	  
	  </div>
	  
	  <div class="table-responsive"  style="padding-top: 10px;" >
		<c:choose>
			<c:when test="${monitorNurseryForm.entityList != null}">
				<table  id="tableId" class="table table-bordered table-striped table-condensed table-hover context-menu-table" style="width: 98%;">  
					<tr>
						<th>No</th>
						<th>Last Name</th>
						<th>First Name</th>
						<th>Date Of Birth</th>
						<th>Time Of Birth</th>
						<th>Gender</th>
						<th>Weight</th>
						<th>Remarks</th>
						<th></th>
						<th></th>
					</tr>
					<logic:iterate name="monitorNurseryForm" property="entityList" type="com.pibs.model.MonitorNursery" id="model" indexId="index">
						<tr>
							<td><c:out value="${index+1}"></c:out></td>
							<td><bean:write name="model" property="lastName"/></td>				 
							<td><bean:write name="model" property="firstName"/></td>
							<td><bean:write name="model" property="dateOfBirth"/></td>
							<td><bean:write name="model" property="timeOfBirth"/></td>
							<td><bean:write name="model" property="gender"/></td>
							<td><bean:write name="model" property="weight"/></td>						
							<td><bean:write name="model" property="remarks"/></td>
							<td align="center"><a href="#" onclick="javascript: editMonitorNursery('<bean:write name="model" property="id"/>');">Edit</a></td>
							<td align="center"><a href="#" onclick="javascript: deleteMonitorNursery('<bean:write name="model" property="id"/>','${monitorNurseryForm.patientCaseSystemId}');">Remove</a></td>
						</tr>
					</logic:iterate>
				</table>
			</c:when>
			<c:otherwise>
			 	<div style="color: blue;">No Record found!</div>
			</c:otherwise>
		</c:choose>
	  </div>


