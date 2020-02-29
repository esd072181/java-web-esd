<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div  align="left" style=" height: 20px;">
	<!-- space only -->
</div>
	
<c:forEach items="${sessionScope.user_access_list}" var="item">
  <c:if test="${item == 901}">
   <div   height: 2%;">   			
	<div class="table-responsive" >
		<c:choose>
		  <c:when test="${verificationAndValidationForm.modelList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%; font-size: xx-small;">  
				<tr>
					<th colspan="8" ><div align="center"><span style="font-weight:bold; font-size: small;">Verification and Validation Compliance Tracker Reminders</span></div></th>
				</tr>
				<tr>
					<th>Terminal</th>
					<th>Items</th>
					<th>Corrective Actions</th>
					<th>Driver</th>
					<th>Lorry</th>
					<th>Closure Date</th>
					<th>Status</th>
					<th>DateEncoded</th>
				</tr>
				<logic:iterate name="verificationAndValidationForm" property="modelList" type="com.transport.model.VerificationAndValidation" id="model">
					<tr>				 
						<%--<td><bean:write name="resultsId" property="id"/><bean:message key="Building.Id"/></td>--%>
						<td><bean:write name="model" property="terminal"/></td>
						<td><bean:write name="model" property="item"/></td>
						<td><bean:write name="model" property="corrections"/></td>
						<td><bean:write name="model" property="driver"/></td>	
						<td><bean:write name="model" property="lorry"/></td>
						<td><bean:write name="model" property="validationDateStr"/></td>
						<td><bean:write name="model" property="remarks"/></td>
						<td><bean:write name="model" property="createdOnStr"/></td>		
					</tr>
				</logic:iterate>
			</table>
		  </c:when>
		  <c:otherwise>
		  	<div style="color: blue;">No Reminders for V and V!</div>
		  </c:otherwise>
		</c:choose>
	</div>
	
	<div style="height: 50px; width: 98%;">
		<div style="position: relative; top: -15px; float: right;" >
			<ul class="pagination">
			
				<c:if test="${verificationAndValidationForm.currentPage != 1 && verificationAndValidationForm.noOfPages > 0}">
					<li><a href="#" onclick="getReminders(${verificationAndValidationForm.currentPage - 1});">&laquo;</a></li>
				</c:if>
					
				<c:forEach begin="1" end="${verificationAndValidationForm.noOfPages}" var="i">
	                <c:choose>
	                    <c:when test="${verificationAndValidationForm.currentPage eq i}">
	                        <li class="active"><a href="#">${i}</a></li>
	                    </c:when>
	                    <c:otherwise>
	                         <!--  <li><a href="#" onclick="getReminders(${i});">${i}</a></li>-->
	                        <c:choose>
	                          <c:when test="${verificationAndValidationForm.currentPage < i && i < verificationAndValidationForm.currentPage+10}">
	                          		<li><a href="#" onclick="getReminders(${i},'${verificationAndValidationForm.category}');">${i}</a></li>
	                          </c:when>
	                           <c:otherwise>
	                           		<!-- none -->
	                           </c:otherwise>
	                         </c:choose>
	                    </c:otherwise>
	                </c:choose>
	            </c:forEach>
	           	<c:if test="${verificationAndValidationForm.currentPage lt verificationAndValidationForm.noOfPages}">
	               	<li><a href="#" onclick="getReminders(${verificationAndValidationForm.currentPage + 1});">&raquo;</a></li>
	            </c:if>

			</ul>
		</div>
	</div>
  </c:if>
  
   <c:if test="${item == 902}">
   		<br>
   		<!-- No reminders for Work Permit / Not used as of now -->
   		<!--  
   		<div style="color: blue;">No Reminders for Work Permit!</div>-->
   </c:if>
  
</c:forEach>

