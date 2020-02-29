<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<script>
$(function() {
    $( "#menu" ).menu({
      items: "> :not(.ui-widget-header)"
    });
    
    $('#idSearchCriteria').focus();
  });
</script>

<div style="height: 30%; padding-left: 10px;">
		<div style="width: 50%;">
			<h3 style="font-weight: bolder;">Employee</h3>
		</div>
		<html:form action="/employee.do" styleId="idForm">
				<div>
					<html:errors/>
				</div>
				<div>
					<div>
						<label>Search:</label>
						<html:text property="criteria" styleId="idSearchCriteria" size="25"  onkeydown="executeSearch(event);"></html:text>
						<html:button styleId="btnSearchFilter" property="command" onclick="getEmployee(1,'filter');" value="Search" styleClass="btn btn-primary"></html:button>
						<html:button property="command" onclick="getEmployee(1,'showall');" value="Show All" styleClass="btn btn-primary"></html:button>
						&nbsp;&nbsp;&nbsp;&nbsp;<html:button property="command" onclick="goToAddEmployee();" value="Add New Record" styleClass="btn btn-primary"></html:button>
						<span id="msgDeletedId" style="color: blue; padding-left: 100px; display: none;"><bean:message key="msg.deleted"/></span>
					</div>
					<div style="padding-left: 85px; float: left;">
						<span id="validationMessageId" style="color: blue; display: none;">Enter search criteria.</span>
					</div>
				</div>			
		</html:form>
</div>
  
<br>

<!-- results using logic iterate -->
<!-- using bootstrap -->
<div id="tablePresentationDIV">
	<!-- ajax part of table data -->
</div>


