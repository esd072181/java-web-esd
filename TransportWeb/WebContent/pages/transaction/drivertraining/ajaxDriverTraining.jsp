<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<script>
$(function() {

	$('#idSearchValue').focus();
	    
  });
</script>
  
<div style="height: 30%; padding-left: 10px;">
		<h3 style="font-weight: bolder;">Driver Training and Information</h3>
		<html:form action="/driverTraining.do" styleId="idForm">
				<div>
					<html:errors/>
				</div>
				<br>
				<div>
					<div>	
						<div class="controls">
							<html:button styleClass="btn btn-primary" property="" value="Add New Driver Info" onclick="goToAddDriverTraining();"></html:button>
							 <!-- Search Value -->
							<label  class="control-label top-spacing" for="searchValue">Search Driver:</label>
							<html:text property="searchValue" styleId="idSearchValue" size="10" onkeydown="executeSearch(event);"></html:text> 						 													 			
							<html:button styleId="btnSearchFilter" property="command" onclick="getDriverTraining(1,'filter');" value="Search" styleClass="btn btn-primary"></html:button>
							<html:button property="command" onclick="getDriverTraining(1,'showall');" value="Show All" styleClass="btn btn-primary"></html:button>
							<span id="msgDeletedId" style="color: blue; padding-left: 100px; display: none;"><bean:message key="msg.deleted"/></span>
							<span id="validationMessageId" style="color: blue; display: none;">Enter search value.</span>						
						</div>
					</div>
				</div>			
		</html:form>
</div>
  
	
<br>

<!-- using bootstrap -->
<div id="tablePresentationDIV">
	<!-- ajax part of table data -->
</div>




