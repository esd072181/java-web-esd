<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

	<div class="table-responsive" style="padding-left: 10px;">
		<c:choose>
		  <c:when test="${remarksForm.modelList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%;">  
				<tr>
					<th>No</th>
					<th>Description</th>
					<th></th>
					<th></th>
				</tr>
				<logic:iterate name="remarksForm" property="modelList" type="com.transport.model.Remarks" id="model" indexId="index">
					<tr>				 
						<td><c:out value="${index+1 + (remarksForm.currentPage * 10 - 10)}"/></td>
						<td><bean:write name="model" property="description"/></td>
						<td align="center"><a href="#" onclick="javascript: editRemarks('<bean:write name="model" property="id"/>');">Edit</a></td>
						<td align="center"><a href="#" onclick="javascript: deleteRemarks('<bean:write name="model" property="id"/>', '${remarksForm.category}',${remarksForm.currentPage})">Delete</a></td>
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
				<c:if test="${remarksForm.currentPage != 1 && remarksForm.noOfPages > 0}">
					<li><a href="#" onclick="getRemarks(${remarksForm.currentPage - 1},'${remarksForm.category}');">Previous</a></li>
				</c:if>
				<c:if test="${remarksForm.currentPage lt remarksForm.noOfPages}">
				  	<li><a href="#" onclick="getRemarks(${remarksForm.currentPage + 1},'${remarksForm.category}');">Next</a></li>
				</c:if>
			</ul>
		</div>
		<div style="position: relative; top: -15px; float: right;" >
			<ul class="pagination">
			
				<c:if test="${remarksForm.currentPage != 1 && remarksForm.noOfPages > 0}">
					<li><a href="#" onclick="getRemarks(${remarksForm.currentPage - 1},'${remarksForm.category}');">&laquo;</a></li>
				</c:if>
					
				<c:forEach begin="1" end="${remarksForm.noOfPages}" var="i">
	                <c:choose>
	                    <c:when test="${remarksForm.currentPage eq i}">
	                        <li class="active"><a href="#">${i}</a></li>
	                    </c:when>
	                    <c:otherwise>
	                         <li><a href="#" onclick="getRemarks(${i},'${remarksForm.category}');">${i}</a></li>
	                    </c:otherwise>
	                </c:choose>
	            </c:forEach>
	           	<c:if test="${remarksForm.currentPage lt remarksForm.noOfPages}">
	               	<li><a href="#" onclick="getRemarks(${remarksForm.currentPage + 1},'${remarksForm.category}');">&raquo;</a></li>
	            </c:if>

			</ul>
		</div>
	</div>

<!-- 
	<div id="msgDeletedId" align="center">
		<span style="color: blue;"><c:out value="${roomCategoryForm.transactionMessage}"></c:out></span>
	</div> 
	 -->