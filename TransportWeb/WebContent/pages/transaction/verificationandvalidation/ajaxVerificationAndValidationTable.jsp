<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

	<div class="table-responsive" style="padding-left: 10px;">
		<c:choose>
		  <c:when test="${verificationAndValidationForm.modelList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%; font-size: xx-small;">  
				<tr>
					<th colspan="11" ><div align="center">VERIFICATION</div></th>
					<th colspan="5" ><div align="center">VALIDATION</div></th>
					<th></th>
					<c:if test="${sessionScope.user_role_session=='Admin'}">
						<th></th>
					</c:if>
				</tr>
				<tr>
					<th>Id</th>
					<th>Item</th>
					<th>Findings</th>
					<th>Driver</th>
					<th>Terminal</th>
					<th>LorryNo</th>
					<th>TrailerNo</th>
					<th>VerificationDate</th>
					<th>RootCause</th>
					<th>CorrectiveAction</th>
					<th>VerifiedBy</th>
					<!--  
					<th>FollowUp</th>
					<th>Driver</th>
					<th>Terminal</th>
					<th>LorryNo</th>
					<th>TrailerNo</th>
					-->
					<th>Closure</th>
					<th>ClosureDate</th>
					<th>CheckedBy</th>
					<th>Status</th>
					<th>DateEncoded</th>
					<th></th>
					<c:if test="${sessionScope.user_role_session=='Admin'}">
						<th></th>
					</c:if>
				</tr>
				<logic:iterate name="verificationAndValidationForm" property="modelList" type="com.transport.model.VerificationAndValidation" id="model">
					<tr>				 
						<%--<td><bean:write name="resultsId" property="id"/><bean:message key="Building.Id"/></td>--%>
						<td><bean:write name="model" property="id"/></td>
						<td><bean:write name="model" property="item"/></td>
						<td><bean:write name="model" property="findings"/></td>
						<td><bean:write name="model" property="driver"/></td>	
						<td><bean:write name="model" property="terminal"/></td>
						<td><bean:write name="model" property="lorry"/></td>
						<td><bean:write name="model" property="trailer"/></td>	
						<td><bean:write name="model" property="verificationDateStr"/></td>	
						<td><bean:write name="model" property="rootCause"/></td>
						<td><bean:write name="model" property="corrections"/></td>	
						<td><bean:write name="model" property="verificationCheckedBy"/></td>
						<!--  	
						<td><bean:write name="model" property="followUp"/></td>
						<td><bean:write name="model" property="driverValidation"/></td>	
						<td><bean:write name="model" property="terminalValidation"/></td>
						<td><bean:write name="model" property="lorryValidation"/></td>
						<td><bean:write name="model" property="trailerValidation"/></td>
						-->
						<td><bean:write name="model" property="closure"/></td>
						<td><bean:write name="model" property="validationDateStr"/></td>
						<td><bean:write name="model" property="validationCheckedBy"/></td>
						<td><bean:write name="model" property="remarks"/></td>
						<td><bean:write name="model" property="createdOnStr"/></td>
						<td align="center"><a href="#" onclick="javascript: editVerificationAndValidation('<bean:write name="model" property="id"/>');">Edit</a></td>
						<c:if test="${sessionScope.user_role_session=='Admin'}">
							<td align="center"><a href="#" onclick="javascript: deleteVerificationAndValidation('<bean:write name="model" property="id"/>', '${verificationAndValidationForm.category}',${verificationAndValidationForm.currentPage})">Delete</a></td>
						</c:if>		
					</tr>
				</logic:iterate>
			</table>
		  </c:when>
		  <c:otherwise>
		  	<div style="color: blue;">No Record found!</div>
		  </c:otherwise>
		</c:choose>
	</div>
	
	<div style="height: 50px; width: 98%;">
		<div style="position: relative; top: -15px; float: left;">
			<ul class="pager">
				<c:if test="${verificationAndValidationForm.currentPage != 1 && verificationAndValidationForm.noOfPages > 0}">
					<li><a href="#" onclick="getVerificationAndValidation(${verificationAndValidationForm.currentPage - 1},'${verificationAndValidationForm.category}');">Previous</a></li>
				</c:if>
				<c:if test="${verificationAndValidationForm.currentPage lt verificationAndValidationForm.noOfPages}">
				  	<li><a href="#" onclick="getVerificationAndValidation(${verificationAndValidationForm.currentPage + 1},'${verificationAndValidationForm.category}');">Next</a></li>
				</c:if>
			</ul>
		</div>
		<div style="position: relative; top: -15px; float: right;" >
			<ul class="pagination">
			
				<c:if test="${verificationAndValidationForm.currentPage != 1 && verificationAndValidationForm.noOfPages > 0}">
					<li><a href="#" onclick="getVerificationAndValidation(${verificationAndValidationForm.currentPage - 1},'${verificationAndValidationForm.category}');">&laquo;</a></li>
				</c:if>
					
				<c:forEach begin="1" end="${verificationAndValidationForm.noOfPages}" var="i">
	                <c:choose>
	                    <c:when test="${verificationAndValidationForm.currentPage eq i}">
	                        <li class="active"><a href="#">${i}</a></li>
	                    </c:when>
	                    <c:otherwise>
	                    	<!--<li><a href="#" onclick="getVerificationAndValidation(${i},'${verificationAndValidationForm.category}');">${i}</a></li>-->
	                    	 <c:choose>
	                          <c:when test="${verificationAndValidationForm.currentPage < i && i < verificationAndValidationForm.currentPage+10}">
	                          		<li><a href="#" onclick="getVerificationAndValidation(${i},'${verificationAndValidationForm.category}');">${i}</a></li>
	                          </c:when>
	                           <c:otherwise>
	                           		<!-- none -->
	                           </c:otherwise>
	                         </c:choose>
	                    </c:otherwise>
	                </c:choose>
	            </c:forEach>
	           	<c:if test="${verificationAndValidationForm.currentPage lt verificationAndValidationForm.noOfPages}">
	               	<li><a href="#" onclick="getVerificationAndValidation(${verificationAndValidationForm.currentPage + 1},'${verificationAndValidationForm.category}');">&raquo;</a></li>
	            </c:if>

			</ul>
		</div>
	</div>

<!-- 
	<div id="msgDeletedId" align="center">
		<span style="color: blue;"><c:out value="${roomCategoryForm.transactionMessage}"></c:out></span>
	</div> 
	 -->