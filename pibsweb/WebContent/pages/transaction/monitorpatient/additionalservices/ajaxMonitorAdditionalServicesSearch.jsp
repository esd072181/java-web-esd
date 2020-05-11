<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<script>
$(function() {
    
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

	<label style="font-weight: bold; font-size: 20px;">Search for Additional Services</label>	
		
		<html:form action="/monitorAdditionalServices.do" styleId="idForm">
				<div>
					<html:errors/>
				</div>
				<html:hidden property="patientCaseSystemId" value="${monitorAdditionalServicesForm.patientCaseSystemId}"/>
				<div>
					<div>
						<label>Search:</label>
						<html:text property="criteria" styleId="idSearchCriteria" size="25" ></html:text>
						<html:button property="command" onclick="getAdditionalServicesForMonitorPatient(1,'filter','${monitorAdditionalServicesForm.patientCaseSystemId}');" value="Search" styleClass="btn btn-primary" styleId="btnSearchId"></html:button>
						<span id="msgDeletedId" style="color: blue; padding-left: 100px; display: none;"><bean:message key="msg.deleted"/></span>
					</div>
					<div style="padding-left: 85px; float: left;">
						<span id="validationMessageId" style="color: blue; display: none;">Enter search criteria.</span>
					</div>
				</div>			
				<html:hidden property="id" styleId="selectedId"/>	
		</html:form>
	
	<br>

	<!-- results using logic iterate -->
	<!-- using bootstrap -->
	<div id="tablePresentationDIV">
		<!-- ajax part of table data -->
	</div>


