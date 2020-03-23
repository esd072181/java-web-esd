<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

						
	<div style="padding-left: 10px;">
		<h3 style="font-weight: bolder; padding-bottom: 10px;">Maintenance Inspection Checklist</h3>
		<html:form action="/maintenanceInspection.do" styleId="idForm">							
				<div>
					<html:errors/>
				</div>
				<div>
					<div>
						<div class="controls">
							 <!-- Search Value -->
							<label  class="control-label top-spacing" for="searchValue">Search Value:</label>
							<html:text property="searchValue" styleId="idSearchValue" size="10" onkeydown="executeSearch(event);"></html:text> 						 													 			
							<html:button styleId="btnSearchFilter" property="command" onclick="getMaintenanceInspection(1,'filter');" value="Search" styleClass="btn btn-primary"></html:button>
							<html:button property="command" onclick="getMaintenanceInspection(1,'showall');" value="Show All" styleClass="btn btn-primary"></html:button>
							&nbsp;&nbsp;&nbsp;&nbsp;<html:button property="command" onclick="goToAddMaintenanceInspection();" value="Add New Record" styleClass="btn btn-primary"></html:button>
							<span id="msgDeletedId" style="color: blue; padding-left: 100px; display: none;"><bean:message key="msg.deleted"/></span>
							<span id="validationMessageId" style="color: blue; display: none;">Enter search value.</span>
						</div>
					</div>
					
				</div>			
		</html:form>
	</div>
  	<hr>

	<!-- results using logic iterate -->
	<!-- using bootstrap -->
	<div id="tablePresentationDIV">
		<!-- ajax part of table data -->
	</div>

	
