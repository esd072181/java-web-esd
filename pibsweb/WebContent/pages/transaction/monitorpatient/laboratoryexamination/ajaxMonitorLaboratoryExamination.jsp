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
	  			<td><h3>Laboratory Examination</h3></td>
	  			<td class="padLeft5">
	  				<html:button property="btnAdd" styleClass="btn btn-primary btnMonitoringSmall" onclick="goToMonitorLaboratoryExaminationSearch('${monitorLaboratoryExaminationForm.patientCaseSystemId}');" value="Add New"></html:button>
	  			</td>
	  			<td>
	  				<span id="msgId" style="color: blue; padding-left: 100px; display: none;"><bean:message key="msg.updated"/></span>
	  			</td>
	  		</tr>	
	  	</table>	  
	  </div>
	 
	  <div class="table-responsive" align="left" >
		<c:choose>
		<c:when test="${monitorLaboratoryExaminationForm.entityList != null}">
			<table  id="tableId" class="table table-bordered table-striped table-condensed table-hover context-menu-table" style="width: 98%;">  
				<tr>
					<th>Description</th>
					<th>Remarks</th>
					<th>Qty</th>
					<th>Fee</th>
					<th>Amount</th>
					<th>Date Taken</th>
					<th>Time Taken</th>
					<th></th>
					<th></th>
				</tr>
				<logic:iterate name="monitorLaboratoryExaminationForm" property="entityList" type="com.pibs.model.MonitorLaboratoryExamination" id="model">
					<tr>				 
						<td><bean:write name="model" property="itemDescription"/></td>				 
						<td><bean:write name="model" property="itemRemarks"/></td>
						<td align="right"><bean:write name="model" property="qty"/></td>
						<td align="right"><bean:write name="model" property="fee" format="Php #,###.00"/></td>
						<td align="right"><bean:write name="model" property="amount" format="Php #,###.00"/></td>
						<td><bean:write name="model" property="dateTaken"/></td>
						<td><bean:write name="model" property="timeTaken"/></td>
						<td align="center"><a href="#" onclick="javascript: editMonitorLaboratoryExamination('<bean:write name="model" property="id"/>')">Edit</a></td>						
						<td align="center"><a href="#" onclick="javascript: deleteMonitorLaboratoryExamination('<bean:write name="model" property="id"/>','${monitorLaboratoryExaminationForm.patientCaseSystemId}');">Remove</a></td>
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

