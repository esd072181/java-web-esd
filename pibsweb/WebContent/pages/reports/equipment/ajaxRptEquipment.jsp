<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<script>
$(function() {
    
	$('#idSearchValue').keypress(function(e) {
		var keycode = (e.keycode ? e.keycode : e.which);
		if (keycode == 13) {
			$('#btnSearchFilter').click();
			return false;
		}
	});
	
	$('#idSearchValue').focus();
	
  });
</script>


<div class="row">

  <div class="col-sm-10" style="margin-left: 10px;">
	
	<div style="height: 30%;">
		<h3 style="font-weight: bolder;">Equipment List Report</h3>
		
		<!-- show message if report is generated or if record not found -->
		<div id="tablePresentationDIV">
			<!-- ajax part of table data -->
		</div>

	
		<html:form action="/rptEquipment.do" styleId="idForm">
				<div>
					<html:errors/>
				</div>
				<div>
					<div>
						<table>
							<tr>
								<td><label  class="control-label top-spacing" for="searchCriteria">Search Criteria:</label></td>
								<td>
									<html:select  name="rptEquipmentForm" property="searchCriteria" styleId="searchCriteriaId" >
										<html:optionsCollection name="rptEquipmentForm" property="equipmentCriteriaLOV" label="listValue" value="id"/>				 		
									</html:select>									
								</td>
							</tr>
							<tr>
								<td><label  class="control-label top-spacing" for="searchValue">Search Value:</label></td>
								<td>
									<html:text property="searchValue" styleId="idSearchValue" size="20" ></html:text>	
								</td>
							</tr>
						</table>
						<div class="control-group">
							<label class="control-label top-spacing" for="command"></label>
							<div class="controls">
								<html:button styleId="btnSearchFilter"  property="command" onclick="getRptEquipment();" value="Search and Generate Report" styleClass="btn btn-primary"></html:button>
							</div>
						</div>						
					</div>
				</div>			
		</html:form>
	</div>
  
	
	<br>



  
  </div>

</div>

