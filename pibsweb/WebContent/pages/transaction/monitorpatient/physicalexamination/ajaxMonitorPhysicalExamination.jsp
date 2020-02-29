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

  <div class="col-sm-10" >

	<div style="height: 30%; padding-top: 0px;" align="left">

	  <div>
	  	<table>
	  		<tr class="hMargin10"></tr>
	  		<tr>
	  			<td><h3>Physical Examination</h3></td>
	  			<td class="padLeft5">
	  				<html:button property="btnAdd" styleClass="btn btn-primary btnMonitoringSmall" onclick="goToMonitorPhysicalExaminationAdd('${monitorPhysicalExaminationForm.patientCaseSystemId}');" value="Add New"></html:button>
	  			</td>
	  			<td>
	  				<span id="msgId" style="color: blue; padding-left: 100px; display: none;"><bean:message key="msg.updated"/></span>
	  			</td>
	  		</tr>	
	  	</table>	  
	  </div>
	  	
	  <div class="table-responsive" align="left" >
		<c:choose>
		<c:when test="${monitorPhysicalExaminationForm.entityList != null}">
			<table  id="tableId" class="table table-bordered table-striped table-condensed table-hover context-menu-table" style="width: 100%;">  
				<tr>
					<th>BP</th>
					<th>Temp</th>
					<th>CR</th>
					<th>RR</th>
					<th>Weight</th>
					<th>HEENT</th>
					<th>Chest</th>
					<th>Heart</th>
					<th>Abdomen</th>
					<th>Extrimities</th>
					<th>Skin</th>
					<th>remarks</th>
					<th>Date Recorded</th>
					<th>Time Recorded</th>
					<th></th>
					<th></th>
				</tr>
				<logic:iterate name="monitorPhysicalExaminationForm" property="entityList" type="com.pibs.model.MonitorPhysicalExamination" id="model">
					<tr>
						<td><bean:write name="model" property="bp"/></td>				 
						<td><bean:write name="model" property="temp"/></td>
						<td><bean:write name="model" property="cr"/></td>
						<td><bean:write name="model" property="rr"/></td>
						<td><bean:write name="model" property="weight"/></td>
						<td><bean:write name="model" property="heent"/></td>
						<td><bean:write name="model" property="chest"/></td>
						<td><bean:write name="model" property="heart"/></td>
						<td><bean:write name="model" property="abdomen"/></td>
						<td><bean:write name="model" property="extrimities"/></td>
						<td><bean:write name="model" property="skin"/></td>
						<td><bean:write name="model" property="remarks"/></td>
						<td><bean:write name="model" property="dateRecorded"/></td>
						<td><bean:write name="model" property="timeRecorded"/></td>
						<td align="center"><a href="#" onclick="javascript: editMonitorPhysicalExamination('<bean:write name="model" property="id"/>')">Edit</a></td>
						<td align="center"><a href="#" onclick="javascript: deleteMonitorPhysicalExamination('<bean:write name="model" property="id"/>','${monitorPhysicalExaminationForm.patientCaseSystemId}');">Remove</a></td>
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

