<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

	<div>
		<c:choose>
			<c:when test="${rptDiscountForm.modelList != null}">
				<p><span style="color: blue;">Report successfully generated!</span></p>
				<div>
					<a href="reports/discountlist.pdf" target="_blank">Click here to view the generated PDF report</a>
				</div>
			</c:when>
			<c:otherwise>
				<p><span style="color: blue;">No record found!</span></p>
			</c:otherwise>		
		</c:choose>
		<br>
	</div>
	
	

