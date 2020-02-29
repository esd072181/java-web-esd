<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>						
							
<div id="closureDIVId" class="controls">
	<html:select  name="verificationAndValidationForm" property="closureId" disabled="${verificationAndValidationForm.transactionStatus}">
		<html:option value="0">--Select--</html:option>
		<html:optionsCollection name="verificationAndValidationForm" property="closureList" label="description" value="id"/>				 		
	</html:select>									 			
</div>						
