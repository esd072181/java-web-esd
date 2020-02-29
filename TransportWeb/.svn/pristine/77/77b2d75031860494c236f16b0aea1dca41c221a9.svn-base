<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

	<div class="table-responsive" style="padding-left: 10px;" >
		<c:choose>
		  <c:when test="${itemsForm.modelList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%;">  
				<tr>
					<th>Id</th>
					<th>Description</th>
					<th></th>
					<th></th>
				</tr>
				<logic:iterate name="itemsForm" property="modelList" type="com.transport.model.Items" id="model">
					<tr>				 
						<%--<td><bean:write name="resultsId" property="id"/><bean:message key="Building.Id"/></td>--%>
						<td><bean:write name="model" property="id"/></td>
						<td><bean:write name="model" property="description"/></td>
						<td align="center"><a href="#" onclick="javascript: editItems('<bean:write name="model" property="id"/>');">Edit</a></td>
						<td align="center"><a href="#" onclick="javascript: deleteItems('<bean:write name="model" property="id"/>', '${itemsForm.category}',${itemsForm.currentPage})">Delete</a></td>
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
				<c:if test="${itemsForm.currentPage != 1 && itemsForm.noOfPages > 0}">
					<li><a href="#" onclick="getItems(${itemsForm.currentPage - 1},'${itemsForm.category}');">Previous</a></li>
				</c:if>
				<c:if test="${itemsForm.currentPage lt itemsForm.noOfPages}">
				  	<li><a href="#" onclick="getItems(${itemsForm.currentPage + 1},'${itemsForm.category}');">Next</a></li>
				</c:if>
			</ul>
		</div>
		<div style="position: relative; top: -15px; float: right;" >
			<ul class="pagination">
			
				<c:if test="${itemsForm.currentPage != 1 && itemsForm.noOfPages > 0}">
					<li><a href="#" onclick="getItems(${itemsForm.currentPage - 1},'${itemsForm.category}');">&laquo;</a></li>
				</c:if>
					
				<c:forEach begin="1" end="${itemsForm.noOfPages}" var="i">
	                <c:choose>
	                    <c:when test="${itemsForm.currentPage eq i}">
	                        <li class="active"><a href="#">${i}</a></li>
	                    </c:when>
	                    <c:otherwise>
	                         <li><a href="#" onclick="getItems(${i},'${itemsForm.category}');">${i}</a></li>
	                    </c:otherwise>
	                </c:choose>
	            </c:forEach>
	           	<c:if test="${itemsForm.currentPage lt itemsForm.noOfPages}">
	               	<li><a href="#" onclick="getItems(${itemsForm.currentPage + 1},'${itemsForm.category}');">&raquo;</a></li>
	            </c:if>

			</ul>
		</div>
	</div>

<!-- 
	<div id="msgDeletedId" align="center">
		<span style="color: blue;"><c:out value="${roomCategoryForm.transactionMessage}"></c:out></span>
	</div> 
	 -->