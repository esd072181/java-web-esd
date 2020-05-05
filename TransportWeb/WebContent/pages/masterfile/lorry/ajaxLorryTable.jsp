<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

	<div class="table-responsive" style="padding-left: 10px;">
		<c:choose>
		  <c:when test="${lorryForm.modelList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%;">  
				<tr>
					<th>No</th>
					<th>Plate No</th>
					<th>Lorry No</th>
					<th>Trailer No</th>
					<th>Capacity</th>
					<th>Category</th>
					<th>Transport</th>
					<th></th>
					<th></th>
				</tr>
				<logic:iterate name="lorryForm" property="modelList" type="com.transport.model.Lorry" id="model" indexId="index">
					<tr>				 
						<td><c:out value="${index+1 + (lorryForm.currentPage * 10 - 10)}"/></td>
						<td><bean:write name="model" property="plateNo"/></td>
						<td><bean:write name="model" property="lorryNo"/></td>
						<td><bean:write name="model" property="trailerNo"/></td>
						<td><bean:write name="model" property="capacity"/></td>
						<td><bean:write name="model" property="category"/></td>
						<td><bean:write name="model" property="transport"/></td>
						<td align="center"><a href="#" onclick="javascript: editLorry('<bean:write name="model" property="id"/>');">Edit</a></td>
						<td align="center"><a href="#" onclick="javascript: deleteLorry('<bean:write name="model" property="id"/>', '${lorryForm.category}',${lorryForm.currentPage})">Delete</a></td>
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
				<c:if test="${lorryForm.currentPage != 1 && lorryForm.noOfPages > 0}">
					<li><a href="#" onclick="getLorry(${lorryForm.currentPage - 1},'${lorryForm.category}');">Previous</a></li>
				</c:if>
				<c:if test="${lorryForm.currentPage lt lorryForm.noOfPages}">
				  	<li><a href="#" onclick="getLorry(${lorryForm.currentPage + 1},'${lorryForm.category}');">Next</a></li>
				</c:if>
			</ul>
		</div>
		<div style="position: relative; top: -15px; float: right;" >
			<ul class="pagination">
			
				<c:if test="${lorryForm.currentPage != 1 && lorryForm.noOfPages > 0}">
					<li><a href="#" onclick="getLorry(${lorryForm.currentPage - 1},'${lorryForm.category}');">&laquo;</a></li>
				</c:if>
				
				<!-- pagination limit to 10 -->
				<c:choose>
					<c:when test="${lorryForm.currentPage lt lorryForm.noOfPages && lorryForm.noOfPages > 10}">
						<c:forEach begin="${lorryForm.currentPage}" end="${lorryForm.currentPage+9}" var="i">
			                <c:choose>
			                    <c:when test="${lorryForm.currentPage eq i}">
			                        <li class="active"><a href="#">${i}</a></li>
			                    </c:when>
			                    <c:otherwise>
			                         <li><a href="#" onclick="getLorry(${i},'${lorryForm.category}');">${i}</a></li>
			                    </c:otherwise>
			                </c:choose>
			            </c:forEach>					
					</c:when>
					<c:otherwise>
						<c:forEach begin="1" end="${lorryForm.noOfPages}" var="i">
			                <c:choose>
			                    <c:when test="${lorryForm.currentPage eq i}">
			                        <li class="active"><a href="#">${i}</a></li>
			                    </c:when>
			                    <c:otherwise>
			                         <li><a href="#" onclick="getLorry(${i},'${lorryForm.category}');">${i}</a></li>
			                    </c:otherwise>
			                </c:choose>
			            </c:forEach>				
					</c:otherwise>
				</c:choose>

	           	<c:if test="${lorryForm.currentPage lt lorryForm.noOfPages}">
	               	<li><a href="#" onclick="getLorry(${lorryForm.currentPage + 1},'${lorryForm.category}');">&raquo;</a></li>
	            </c:if>

			</ul>
		</div>
	</div>

<!-- 
	<div id="msgDeletedId" align="center">
		<span style="color: blue;"><c:out value="${roomCategoryForm.transactionMessage}"></c:out></span>
	</div> 
	 -->