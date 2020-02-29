<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>						
							
<div id="findingsDIVId" class="controls">
	<html:select  styleId="findingsID" name="verificationAndValidationForm" property="findingsId" disabled="${verificationAndValidationForm.transactionStatus}" onchange="isPositiveFindings(this.value);">
		<html:option value="0">--Select--</html:option>
		<html:optionsCollection name="verificationAndValidationForm" property="findingsList" label="description" value="id"/>				 		
	</html:select>									 			
</div>					
