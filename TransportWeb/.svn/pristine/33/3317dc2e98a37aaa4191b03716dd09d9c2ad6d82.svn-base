<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<script>
$(function() {
    $( "#menu" ).menu({
      items: "> :not(.ui-widget-header)"
    });
    
    $('#dateFromDatePicker').datepicker({}); 
    $('#dateToDatePicker').datepicker({}); 
    
    $('#dateFromDatePicker').attr('placeholder','mm/dd/yyyy');
    $('#dateToDatePicker').attr('placeholder','mm/dd/yyyy');
    
	$('#dateFromDatePicker').attr("disabled","disabled");
	$('#dateToDatePicker').attr("disabled","disabled");
	
	$('#idSearchValue').focus();
	
	$('#dateDivId').hide();
    
  });


</script>


<div style="height: 30%; padding-left: 10px;">
		<h3 style="font-weight: bolder;">Verification and Validation Compliance Tracker</h3>
		<html:form action="/verificationAndValidation.do" styleId="idForm">
				<div>
					<html:errors/>
				</div>
				<div>
					<div>
						<!-- dropdown -->	
						<div class="controls">
							 <label  class="control-label top-spacing" for="searchCriteria">Search Criteria:</label>
							 <html:select  name="verificationAndValidationForm" property="searchCriteria" styleId="searchCriteriaId" onchange="showDateCriteria(this.value);" >
							 	<html:optionsCollection name="verificationAndValidationForm" property="verificationCriteriaLOV" label="listValue" value="id"/>				 		
							 </html:select>	
							 <!-- Search Value -->
							<label  class="control-label top-spacing" for="searchValue">Search Value:</label>
							<html:text property="searchValue" styleId="idSearchValue" size="10" onkeydown="executeSearch(event);"></html:text> 						 													 			
							<html:button styleId="btnSearchFilter" property="command" onclick="getVerificationAndValidation(1,'filter');" value="Search" styleClass="btn btn-primary"></html:button>
							<html:button property="command" onclick="getVerificationAndValidation(1,'showall');" value="Show All" styleClass="btn btn-primary"></html:button>
							&nbsp;&nbsp;&nbsp;&nbsp;<html:button property="command" onclick="goToAddVerificationAndValidationRefreshDropdownList();" value="Add New Record" styleClass="btn btn-primary"></html:button>
							<span id="msgDeletedId" style="color: blue; padding-left: 100px; display: none;"><bean:message key="msg.deleted"/></span>
							<span id="validationMessageId" style="color: blue; display: none;">Enter search value.</span>						
						</div>
						<div id="dateDivId">
							<!-- Date From and Date To -->
							<label class="control-label top-spacing" for="dateFrom">Date From:</label>								
							<html:text property="dateFrom" styleId="dateFromDatePicker" size="8"></html:text>
							<label class="control-label top-spacing" for="dateTo">Date To:</label>
							<html:text property="dateTo" styleId="dateToDatePicker" size="8"></html:text>						
						</div>		
					</div>
					<!--  
					<div style="padding-top: 10px;" >
						<html:button styleId="btnSearchFilter" property="command" onclick="getVerificationAndValidation(1,'filter');" value="Search" styleClass="btn btn-primary"></html:button>
						<html:button property="command" onclick="getVerificationAndValidation(1,'showall');" value="Show All" styleClass="btn btn-primary"></html:button>
						<span id="msgDeletedId" style="color: blue; padding-left: 100px; display: none;"><bean:message key="msg.deleted"/></span>
						<span id="validationMessageId" style="color: blue; display: none;">Enter search value.</span>
					</div>
					-->
				</div>			
		</html:form>
</div>
  
<br>

<!-- results using logic iterate -->
<!-- using bootstrap -->
<div id="tablePresentationDIV">
	<!-- ajax part of table data -->
</div>

