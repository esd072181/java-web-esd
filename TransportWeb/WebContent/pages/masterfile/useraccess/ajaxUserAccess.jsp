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
			<h3 style="font-weight: bolder;">User Access</h3>
		</div>
		<html:form action="/userAccess.do" styleId="idForm">
				<div>
					<html:errors/>
				</div>
				<div>
					<div>
						<label>Select User:</label>
						<html:select  name="userAccessForm" property="userId" styleId="userIdId">
							<html:optionsCollection name="userAccessForm" property="userList" label="name" value="id"/>				 		
						</html:select>	
						<html:button styleId="btnSearchFilter" property="command" onclick="getUserAccess(1,'filter');" value="Get User Access" styleClass="btn btn-primary"></html:button>
						<span id="msgDeletedId" style="color: blue; padding-left: 100px; display: none;"><bean:message key="msg.deleted"/></span>
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

