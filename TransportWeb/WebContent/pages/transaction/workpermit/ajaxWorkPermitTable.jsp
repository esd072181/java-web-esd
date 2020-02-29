<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

	<div class="table-responsive" style="padding-left: 10px;">
		<c:choose>
		  <c:when test="${workPermitForm.modelList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%; font-size: xx-small;">  
				<tr>
					<th>Permit No</th>
					<th>Plate No</th>
					<th>Lorry No</th>
					<th>Item Repair</th>
					<th>Item Replace</th>
					<th>Gas Free</th>
					<th>Hot Work</th>
					<th>Mechanic</th>
					<th>Permit Issuer</th>
					<th>Date Started</th>
					<th>Time Started</th>
					<th>Date Ended</th>
					<th>Time Ended</th>
					<th>Rescue</th>
					<th>Odometer</th>
					<th>Hub</th>
					<th>Transport</th>
					<th></th>
					<c:if test="${sessionScope.user_role_session=='Admin'}">
						<th></th>
					</c:if>
				</tr>
				<logic:iterate name="workPermitForm" property="modelList" type="com.transport.model.WorkPermit" id="model">
					<tr>				 
						<%--<td><bean:write name="resultsId" property="id"/><bean:message key="Building.Id"/></td>--%>
						<td align="right"><bean:write name="model" property="permitNo"/></td>
						<td><bean:write name="model" property="plateNo"/></td>
						<td align="right"><bean:write name="model" property="lorryNo"/></td>
						<td><bean:write name="model" property="itemRepair"/></td>
						<td><bean:write name="model" property="itemReplace"/></td>	
						<td><bean:write name="model" property="gasFree"/></td>
						<td><bean:write name="model" property="hotWork"/></td>
						<td><bean:write name="model" property="mechanic"/></td>	
						<td><bean:write name="model" property="permitIssuer"/></td>	
						<td><bean:write name="model" property="dateStarted" format='MM/dd/yyyy'/></td>
						<td><bean:write name="model" property="timeStarted"/></td>	
						<td><bean:write name="model" property="dateEnded" format='MM/dd/yyyy'/></td>
						<td><bean:write name="model" property="timeEnded"/></td>
						<td><bean:write name="model" property="rescue"/></td>
						<td align="right"><bean:write name="model" property="odometer"/></td>
						<td align="right"><bean:write name="model" property="hub"/></td>
						<td><bean:write name="model" property="transport"/></td>
						<td align="center"><a href="#" onclick="javascript: editWorkPermit('<bean:write name="model" property="id"/>');">Edit</a></td>
						<c:if test="${sessionScope.user_role_session=='Admin'}">
							<td align="center"><a href="#" onclick="javascript: deleteWorkPermit('<bean:write name="model" property="id"/>', '${workPermitForm.category}',${workPermitForm.currentPage})">Delete</a></td>
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
				<c:if test="${workPermitForm.currentPage != 1 && workPermitForm.noOfPages > 0}">
					<li><a href="#" onclick="getWorkPermit(${workPermitForm.currentPage - 1},'${workPermitForm.category}');">Previous</a></li>
				</c:if>
				<c:if test="${workPermitForm.currentPage lt workPermitForm.noOfPages}">
				  	<li><a href="#" onclick="getWorkPermit(${workPermitForm.currentPage + 1},'${workPermitForm.category}');">Next</a></li>
				</c:if>
			</ul>
		</div>
		<div style="position: relative; top: -15px; float: right;" >
			<ul class="pagination">
			
				<c:if test="${workPermitForm.currentPage != 1 && workPermitForm.noOfPages > 0}">
					<li><a href="#" onclick="getWorkPermit(${workPermitForm.currentPage - 1},'${workPermitForm.category}');">&laquo;</a></li>
				</c:if>
					
				<c:forEach begin="1" end="${workPermitForm.noOfPages}" var="i">
	                <c:choose>
	                    <c:when test="${workPermitForm.currentPage eq i}">
	                        <li class="active"><a href="#">${i}</a></li>
	                    </c:when>
	                    <c:otherwise>
	                    	<!--<li><a href="#" onclick="getWorkPermit(${i},'${workPermitForm.category}');">${i}</a></li>-->
	                    	 <c:choose>
	                          <c:when test="${workPermitForm.currentPage < i && i < workPermitForm.currentPage+10}">
	                          		<li><a href="#" onclick="getWorkPermit(${i},'${workPermitForm.category}');">${i}</a></li>
	                          </c:when>
	                           <c:otherwise>
	                           		<!-- none -->
	                           </c:otherwise>
	                         </c:choose>
	                    </c:otherwise>
	                </c:choose>
	            </c:forEach>
	           	<c:if test="${workPermitForm.currentPage lt workPermitForm.noOfPages}">
	               	<li><a href="#" onclick="getWorkPermit(${workPermitForm.currentPage + 1},'${workPermitForm.category}');">&raquo;</a></li>
	            </c:if>

			</ul>
		</div>
	</div>

<!-- 
	<div id="msgDeletedId" align="center">
		<span style="color: blue;"><c:out value="${roomCategoryForm.transactionMessage}"></c:out></span>
	</div> 
	 -->