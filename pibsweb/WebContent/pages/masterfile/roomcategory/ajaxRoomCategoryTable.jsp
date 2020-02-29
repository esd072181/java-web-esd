<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

	<div class="table-responsive" align="left">
		<c:choose>
		<c:when test="${roomCategoryForm.modelList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%;">  
				<tr>
					<th>Description</th>
					<th>Remarks</th>
					<th>Rate</th>
					<th></th>
					<c:if test="${sessionScope.user_role_session=='Admin'}">
						<th></th>
					</c:if>
				</tr>
				<logic:iterate name="roomCategoryForm" property="modelList" type="com.pibs.model.RoomCategory" id="model">
					<tr>				 
						<%--<td><bean:write name="resultsId" property="id"/><bean:message key="Building.Id"/></td>--%>
						<td><bean:write name="model" property="description"/></td>
						<td><bean:write name="model" property="remarks"/></td>
						<logic:equal name="model" property="rate" value="0">
							<td></td>
						</logic:equal>
						<logic:notEqual name="model" property="rate" value="0">
							<td align="right"><bean:write name="model" property="rate" format="Php #,###.00"/></td>
						</logic:notEqual>
						<td align="center"><a href="#" onclick="javascript: editRoomCategory('<bean:write name="model" property="id"/>');">Edit</a></td>
						<c:if test="${sessionScope.user_role_session=='Admin'}">
							<td align="center"><a href="#" onclick="javascript: deleteRoomCategory('<bean:write name="model" property="id"/>', '${roomCategoryForm.category}',${roomCategoryForm.currentPage})">Delete</a></td>
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
				<c:if test="${roomCategoryForm.currentPage != 1 && roomCategoryForm.noOfPages > 0}">
					<li><a href="#" onclick="getRoomCategory(${roomCategoryForm.currentPage - 1},'${roomCategoryForm.category}');">Previous</a></li>
				</c:if>
				<c:if test="${roomCategoryForm.currentPage lt roomCategoryForm.noOfPages}">
				  	<li><a href="#" onclick="getRoomCategory(${roomCategoryForm.currentPage + 1},'${roomCategoryForm.category}');">Next</a></li>
				</c:if>
			</ul>
		</div>
		<div style="position: relative; top: -15px; float: right;" >
			<ul class="pagination">
			
				<c:if test="${roomCategoryForm.currentPage != 1 && roomCategoryForm.noOfPages > 0}">
					<li><a href="#" onclick="getRoomCategory(${roomCategoryForm.currentPage - 1},'${roomCategoryForm.category}');">&laquo;</a></li>
				</c:if>
					
				<c:forEach begin="1" end="${roomCategoryForm.noOfPages}" var="i">
	                <c:choose>
	                    <c:when test="${roomCategoryForm.currentPage eq i}">
	                        <li class="active"><a href="#">${i}</a></li>
	                    </c:when>
	                    <c:otherwise>
	                         <li><a href="#" onclick="getRoomCategory(${i},'${roomCategoryForm.category}');">${i}</a></li>
	                    </c:otherwise>
	                </c:choose>
	            </c:forEach>
	           	<c:if test="${roomCategoryForm.currentPage lt roomCategoryForm.noOfPages}">
	               	<li><a href="#" onclick="getRoomCategory(${roomCategoryForm.currentPage + 1},'${roomCategoryForm.category}');">&raquo;</a></li>
	            </c:if>

			</ul>
		</div>
	</div>

<!-- 
	<div id="msgDeletedId" align="center">
		<span style="color: blue;"><c:out value="${roomCategoryForm.transactionMessage}"></c:out></span>
	</div> 
	 -->