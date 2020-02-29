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
	
  });
</script>

<div style="height: 30%; padding-left: 10px;">
		<h3 style="font-weight: bolder;">Verification and Validation Report</h3>
		
		<!-- show message if report is generated or if record not found -->
		<div id="tablePresentationDIV">
			<!-- ajax part of table data -->
		</div>

	
		<html:form action="/rptVerification.do" styleId="idForm">
				<div>
					<html:errors/>
				</div>
				<div>
					<div>
					
						<div class="control-group">
							<label  class="control-label top-spacing" for="searchCriteria">Search Criteria:</label>
							<div class="controls">
								 <html:select  name="rptVerificationForm" property="searchCriteria" styleId="searchCriteriaId" onchange="showDateCriteria(this.value);" >
								 	<html:optionsCollection name="rptVerificationForm" property="verificationCriteriaLOV" label="listValue" value="id"/>				 		
								 </html:select>							 													 			
							</div>
							<label  class="control-label top-spacing" for="searchValue">Search Value:</label>
							<div class="controls">
								 <html:text property="searchValue" styleId="idSearchValue" size="30" onkeydown="executeSearch(event);"></html:text>
							</div>
							
							<!-- Date From and Date To -->
							<label  class="top-spacing"><span style="font-size:x-small;">(Note: Date From and Date To are used only for Verification and Closure Date search criteria.)</span></label>
							<br>
							<label class="control-label top-spacing" for="dateFrom">Date From:</label>								
							<div class="controls">
								<html:text property="dateFrom" styleId="dateFromDatePicker"></html:text>
							</div>
							<label class="control-label top-spacing" for="dateTo">Date To:</label>
							<div class="controls">
								<html:text property="dateTo" styleId="dateToDatePicker"></html:text>
							</div>
							<label class="control-label top-spacing" for="command"></label>
							<div class="controls">
								<html:button styleId="btnSearchFilter"  property="command" onclick="getRptVerification();" value="Search and Generate Report" styleClass="btn btn-primary"></html:button>
							</div>
						</div>						
					</div>
				</div>			
		</html:form>
</div>
  
