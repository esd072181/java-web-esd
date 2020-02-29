<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

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
		<div style="width: 50%;">
			<h3>Search Admitted Patient for Monitoring</h3>
		</div>
		<html:form action="/monitorPatient.do" styleId="idForm">
				<div>
					<html:errors/>
				</div>
				<div>
					<div>
						<label>Search:</label>
						<html:text property="criteria" styleId="idSearchCriteria" size="25" ></html:text>
						<html:button property="command" onclick="getPatientForMonitorPatient(1,'filter');" value="Search" styleClass="btn btn-primary" styleId="btnSearchId"></html:button>
						<html:button property="command" onclick="getPatientForMonitorPatient(1,'showall');" value="Show All" styleClass="btn btn-primary"></html:button>
						<span id="msgDeletedId" style="color: blue; padding-left: 100px; display: none;"><bean:message key="msg.deleted"/></span>
					</div>
					<div style="padding-left: 85px; float: left;">
						<span id="validationMessageId" style="color: blue; display: none;">Enter search criteria.</span>
					</div>
				</div>			
				<html:hidden property="id" styleId="selectedId"/>
				<html:hidden property="category" styleId="categoryId"/>
				<html:hidden property="currentPage" styleId="currentPageId"/>	
		</html:form>
	</div>
  
	
	<br>

	<!-- results using logic iterate -->
	<!-- using bootstrap -->
	<div id="tablePresentationDIV">
		<!-- ajax part of table data -->
	</div>

  </div>

</div>

