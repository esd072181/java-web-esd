<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>						
							
<div id="correctionsDIVId" class="controls">
	<html:select  name="verificationAndValidationForm" property="correctionsId" disabled="${verificationAndValidationForm.transactionStatus}"  onchange="getClosureByCorrections(this.value);">
		<html:option value="0">--Select--</html:option>
		<html:optionsCollection name="verificationAndValidationForm" property="correctionsList" label="description" value="id"/>				 		
	</html:select>										 			
</div>						
