<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<script>
$(function() {
	
	$('#idSearchValue').focus();
	
  });
  
</script>

<div style="height: 30%; padding-left: 10px;">
		<h3 style="font-weight: bolder;">Tire Status Summary</h3>
		
		<html:form action="/rptTireStatusSummary.do" styleId="idForm">

			<table>
				<tr height="5px"></tr>
				<tr>
					<td><label  class="control-label top-spacing" for="searchValue">Search:</label></td>
					<td style="padding-left: 5px;">
						<html:text property="searchValue" styleId="idSearchValue" size="20" onkeydown="executeSearch(event);"></html:text>		
					</td>
					<td style="padding-left: 10px;">
						<html:button styleId="btnSearchFilter"  property="command" onclick="getRptTireStatusSummary();" value="Generate Report" styleClass="btn btn-primary"></html:button>
					</td>
				</tr>
			</table>					
							
		</html:form>
</div>

