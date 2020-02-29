<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<script>
$(function() {
    $( "#menu" ).menu({
      items: "> :not(.ui-widget-header)"
    });
  });
</script>

<div style="height: 30%; padding-left: 10px;">
		<h3 style="font-weight: bolder;">Archive</h3>
		<html:form action="/archive.do" styleId="idForm">
				<div>
					<html:errors/>
				</div>
				<div>
					<div>
					
						<div class="control-group">
							<div class="controls">
								<label  class="control-label top-spacing" for="entity">Select Entity:</label> &nbsp;
								 <html:select  name="archiveForm" property="entity" >
								 	<html:optionsCollection name="archiveForm" property="entityTypeLOV" label="listValue" value="id"/>				 		
								 </html:select>	&nbsp;
								 <html:button property="command" onclick="getArchive(1,false);" value="Search Deleted Data" styleClass="btn btn-primary"></html:button>						
								 <span id="msgId" style="color: blue; padding-left: 100px; display: none;"><bean:message key="msg.restored"/></span>							 			
							</div>
						</div>						
					</div>
				</div>			
		</html:form>
</div>
  
	
	<br>

	<!-- results using logic iterate -->
	<!-- using bootstrap -->
	<div id="tablePresentationDIV" style="margin-left: 20px;">
		<!-- ajax part of table data -->
	</div>



