<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

	<div class="table-responsive" >
		<c:choose>
		  <c:when test="${tireForm.modelList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%;">  
				<tr>
					<th>Id</th>
					<th>Brand</th>
					<th>Serial No</th>
					<th>Recap No</th>
					<th>Size and Ply</th>
					<th>Date Purchased</th>
					<th>Retired</th>
					<th>Date Retired</th>
					<th>Body No</th>
					<th></th>
					<th></th>
				</tr>
				<logic:iterate name="tireForm" property="modelList" type="com.transport.model.Tire" id="model">
					<tr>				 
						<%--<td><bean:write name="resultsId" property="id"/><bean:message key="Building.Id"/></td>--%>
						<td><bean:write name="model" property="id"/></td>
						<td><bean:write name="model" property="brandName"/></td>
						<td><bean:write name="model" property="serialNo"/></td>
						<td><bean:write name="model" property="recapNo"/></td>
						<td><bean:write name="model" property="sizeAndPly"/></td>
						<td><bean:write name="model" property="datePurchased"/></td>
						<td><bean:write name="model" property="retired"/></td>
						<td><bean:write name="model" property="dateRetired"/></td>
						<td><bean:write name="model" property="bodyNo"/></td>
						<td align="center"><a href="#" onclick="javascript: editTire('<bean:write name="model" property="id"/>');">Edit</a></td>
						<td align="center"><a href="#" onclick="javascript: deleteTire('<bean:write name="model" property="id"/>', '${tireForm.category}',${tireForm.currentPage})">Delete</a></td>
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
				<c:if test="${tireForm.currentPage != 1 && tireForm.noOfPages > 0}">
					<li><a href="#" onclick="getTire(${tireForm.currentPage - 1},'${tireForm.category}');">Previous</a></li>
				</c:if>
				<c:if test="${tireForm.currentPage lt tireForm.noOfPages}">
				  	<li><a href="#" onclick="getTire(${tireForm.currentPage + 1},'${tireForm.category}');">Next</a></li>
				</c:if>
			</ul>
		</div>
		<div style="position: relative; top: -15px; float: right;" >
			<ul class="pagination">
			
				<c:if test="${tireForm.currentPage != 1 && tireForm.noOfPages > 0}">
					<li><a href="#" onclick="getTire(${tireForm.currentPage - 1},'${tireForm.category}');">&laquo;</a></li>
				</c:if>
					
				<c:forEach begin="1" end="${tireForm.noOfPages}" var="i">
	                <c:choose>
	                    <c:when test="${tireForm.currentPage eq i}">
	                        <li class="active"><a href="#">${i}</a></li>
	                    </c:when>
	                    <c:otherwise>
	                         <li><a href="#" onclick="getTire(${i},'${tireForm.category}');">${i}</a></li>
	                    </c:otherwise>
	                </c:choose>
	            </c:forEach>
	           	<c:if test="${tireForm.currentPage lt tireForm.noOfPages}">
	               	<li><a href="#" onclick="getTire(${tireForm.currentPage + 1},'${tireForm.category}');">&raquo;</a></li>
	            </c:if>

			</ul>
		</div>
	</div>

<!-- 
	<div id="msgDeletedId" align="center">
		<span style="color: blue;"><c:out value="${roomCategoryForm.transactionMessage}"></c:out></span>
	</div> 
	 -->