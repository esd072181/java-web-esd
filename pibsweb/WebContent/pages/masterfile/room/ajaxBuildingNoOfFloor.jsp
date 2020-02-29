<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id=noOfFloorDIVId>
	<html:select  name="roomForm"  property="floorNo" disabled="${roomForm.transactionStatus}">
		<html:optionsCollection name="roomForm" property="noOfFloorList" label="value" value="id"/>					 		
	</html:select>
</div>