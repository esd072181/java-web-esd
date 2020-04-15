<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
$(function() {
	
	$('#btnAssignTireId').attr('disabled',true);
	$('#btnRemoveTireId').attr('disabled',true);
	
    $('#lorryNoId').focus();
  });
</script>
<style>
.legendBox {
		width: 30px; 
		height: 30px; 
		border: 1px solid black; 
	}
</style>
		
	<div style="padding-left: 10px;">
		<h3 style="font-weight: bolder; padding-bottom: 10px;">Tire Management</h3>
		<html:form action="/tireManagement.do" styleId="idForm">							
				<div>
					<html:errors/>
				</div>
				<div>
				
				<input type="hidden" name="wheelPosition" id="wheelPositionId"/>
				<input type="hidden" name="serialNo" id="serialNoId"/>
				
					<table>
						<tr>
							<td id="selectLorryLabelId" style="padding-left: 5px; font-weight: bold;">LORRY:</td>
  							<td colspan="5" style="padding-left: 5px;">
  								 <html:select  styleId="lorryNoId" style="width: 100px; height: 20px;"  name="tireManagementForm" property="lorryNo" onchange="getTireDetailsByLorryNo(this.value);" >
								 	<html:option value="">--Select--</html:option>
								 	<html:optionsCollection name="tireManagementForm" property="lorryList" label="lorryNo" value="lorryNo"/>				 		
								 </html:select>
							</td>
							<td width="10"></td>
							<td>
								<html:button property="command" styleId="btnRefreshId" onclick="getTireDetailsByLorryNo($('#lorryNoId').val());" value="Refresh" styleClass="btn btn-primary"></html:button>
							</td>
							<td width="50"></td>
							<td>Legend:</td>
							<td width="5"></td>
							<td class="legendBox" style="background-color: #2545F8;"></td>
							<td width="5"></td>
							<td class="legendBox" style="background-color: #44FA13;"></td>
							<td width="5"></td>
							<td class="legendBox" style="background-color: yellow;"></td>
							<td width="5"></td>
							<td class="legendBox" style="background-color: orange;"></td>
							<td width="5"></td>
							<td class="legendBox" style="background-color: red;"></td>
							<td width="5"></td>
							<td class="legendBox" style="background-color: gray;"></td>
							<td width="5"></td>
							<td class="legendBox" style="background-color: black;"></td>
							<td width="50"></td>
							<td class="legendBox" style="background-color: white;"></td>
						</tr>
					
					</table>
					<table>
						<tr>
							<td width="330"></td>
							<td>Good -------------------------------------- Bad</td>
							<td width="27"></td>
							<td>No Tire</td>
						</tr>
					</table>
				</div>			
		</html:form>
	</div>
	
  	<hr>

	<!-- results using logic iterate -->
	<!-- using bootstrap -->
	<div id="tablePresentationDIV">
		<!-- ajax part of table data -->
	</div>

	
