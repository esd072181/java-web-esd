<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

	<div class="table-responsive" align="left">
		<c:choose>
		<c:when test="${equipmentForm.modelList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%;">  
				<tr>
					<th>No</th>
					<th>Name</th>
					<th>Description</th>
					<th>Fee</th>
					<th></th>
					<c:if test="${sessionScope.user_role_session=='Admin'}">
						<th></th>
					</c:if>
				</tr>
				<logic:iterate name="equipmentForm" property="modelList" type="com.pibs.model.Equipment" id="model" indexId="index">
					<tr>				 
						<td><c:out value="${index+1 + (equipmentForm.currentPage * 10 - 10)}"/></td>
						<td><bean:write name="model" property="entityName"/></td>
						<td><bean:write name="model" property="description"/></td>
						<logic:equal name="model" property="fee" value="0">
							<td></td>
						</logic:equal>
						<logic:notEqual name="model" property="fee" value="0">
							<td align="right"><bean:write name="model" property="fee" format="Php #,###.00"/></td>
						</logic:notEqual>
						<td align="center"><a href="#" onclick="javascript: editEquipment('<bean:write name="model" property="id"/>');">Edit</a></td>
						<c:if test="${sessionScope.user_role_session=='Admin'}">
							<td align="center"><a href="#" onclick="javascript: deleteEquipment('<bean:write name="model" property="id"/>', '${equipmentForm.category}',${equipmentForm.currentPage})">Delete</a></td>
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
				<c:if test="${equipmentForm.currentPage != 1 && equipmentForm.noOfPages > 0}">
					<li><a href="#" onclick="getEquipment(${equipmentForm.currentPage - 1},'${equipmentForm.category}');">Previous</a></li>
				</c:if>
				<c:if test="${equipmentForm.currentPage lt equipmentForm.noOfPages}">
				  	<li><a href="#" onclick="getEquipment(${equipmentForm.currentPage + 1},'${equipmentForm.category}');">Next</a></li>
				</c:if>
			</ul>
		</div>
		<div style="position: relative; top: -15px; float: right;" >
			<ul class="pagination">
			
				<c:if test="${equipmentForm.currentPage != 1 && equipmentForm.noOfPages > 0}">
					<li><a href="#" onclick="getEquipment(${equipmentForm.currentPage - 1},'${equipmentForm.category}');">&laquo;</a></li>
				</c:if>
				
				<!-- pagination limit to 10 -->
				<c:choose>
					<c:when test="${equipmentForm.currentPage lt equipmentForm.noOfPages && equipmentForm.noOfPages > 10}">
						<c:forEach begin="${equipmentForm.currentPage}" end="${equipmentForm.currentPage+9}" var="i">
							<c:choose>
			                    <c:when test="${equipmentForm.currentPage eq i}">
			                        <li class="active"><a href="#">${i}</a></li>
			                    </c:when>
			                    <c:otherwise>
			                         <li><a href="#" onclick="getEquipment(${i},'${equipmentForm.category}');">${i}</a></li>
			                    </c:otherwise>
			                </c:choose>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<c:forEach begin="1" end="${equipmentForm.noOfPages}" var="i">
			                <c:choose>
			                    <c:when test="${equipmentForm.currentPage eq i}">
			                        <li class="active"><a href="#">${i}</a></li>
			                    </c:when>
			                    <c:otherwise>
			                         <li><a href="#" onclick="getEquipment(${i},'${equipmentForm.category}');">${i}</a></li>
			                    </c:otherwise>
			                </c:choose>
			            </c:forEach>
					</c:otherwise>
				</c:choose>	
					
	           	<c:if test="${equipmentForm.currentPage lt equipmentForm.noOfPages}">
	               	<li><a href="#" onclick="getEquipment(${equipmentForm.currentPage + 1},'${equipmentForm.category}');">&raquo;</a></li>
	            </c:if>

			</ul>
		</div>
	</div>

<!-- 
	<div id="msgDeletedId" align="center">
		<span style="color: blue;"><c:out value="${roomCategoryForm.transactionMessage}"></c:out></span>
	</div> 
	 -->