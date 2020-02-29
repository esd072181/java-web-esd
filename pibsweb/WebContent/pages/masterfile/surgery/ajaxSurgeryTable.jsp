<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

	<div class="table-responsive" align="left">
		<c:choose>
		<c:when test="${surgeryForm.modelList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%;">  
				<tr>
					<th>Description</th>
					<th>Remarks</th>
					<th>Type</th>
					<th>Fee</th>
					<th></th>
					<c:if test="${sessionScope.user_role_session=='Admin'}">
						<th></th>
					</c:if>
				</tr>
				<logic:iterate name="surgeryForm" property="modelList" type="com.pibs.model.Surgery" id="model">
					<tr>				 
						<%--<td><bean:write name="resultsId" property="id"/><bean:message key="Building.Id"/></td>--%>
						<td><bean:write name="model" property="description"/></td>
						<td><bean:write name="model" property="remarks"/></td>
						<td><bean:write name="model" property="surgeryTypeName"/></td>
						<logic:equal name="model" property="fee" value="0">
							<td></td>
						</logic:equal>
						<logic:notEqual name="model" property="fee" value="0">
							<td align="right"><bean:write name="model" property="fee" format="Php #,###.00"/></td>
						</logic:notEqual>
						<td align="center"><a href="#" onclick="javascript: editSurgery('<bean:write name="model" property="id"/>');">Edit</a></td>
						<c:if test="${sessionScope.user_role_session=='Admin'}">
							<td align="center"><a href="#" onclick="javascript: deleteSurgery('<bean:write name="model" property="id"/>', '${surgeryForm.category}',${surgeryForm.currentPage})">Delete</a></td>
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
				<c:if test="${surgeryForm.currentPage != 1 && surgeryForm.noOfPages > 0}">
					<li><a href="#" onclick="getSurgery(${surgeryForm.currentPage - 1},'${surgeryForm.category}');">Previous</a></li>
				</c:if>
				<c:if test="${surgeryForm.currentPage lt surgeryForm.noOfPages}">
				  	<li><a href="#" onclick="getSurgery(${surgeryForm.currentPage + 1},'${surgeryForm.category}');">Next</a></li>
				</c:if>
			</ul>
		</div>
		<div style="position: relative; top: -15px; float: right;" >
			<ul class="pagination">
			
				<c:if test="${surgeryForm.currentPage != 1 && surgeryForm.noOfPages > 0}">
					<li><a href="#" onclick="getSurgery(${surgeryForm.currentPage - 1},'${surgeryForm.category}');">&laquo;</a></li>
				</c:if>
					
				<c:forEach begin="1" end="${surgeryForm.noOfPages}" var="i">
	                <c:choose>
	                    <c:when test="${surgeryForm.currentPage eq i}">
	                        <li class="active"><a href="#">${i}</a></li>
	                    </c:when>
	                    <c:otherwise>
	                         <li><a href="#" onclick="getSurgery(${i},'${surgeryForm.category}');">${i}</a></li>
	                    </c:otherwise>
	                </c:choose>
	            </c:forEach>
	           	<c:if test="${surgeryForm.currentPage lt surgeryForm.noOfPages}">
	               	<li><a href="#" onclick="getSurgery(${surgeryForm.currentPage + 1},'${surgeryForm.category}');">&raquo;</a></li>
	            </c:if>

			</ul>
		</div>
	</div>

<!-- 
	<div id="msgDeletedId" align="center">
		<span style="color: blue;"><c:out value="${roomCategoryForm.transactionMessage}"></c:out></span>
	</div> 
	 -->