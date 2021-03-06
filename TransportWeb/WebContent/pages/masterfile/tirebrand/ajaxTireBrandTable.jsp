<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

	<div class="table-responsive" >
		<c:choose>
		  <c:when test="${tireBrandForm.modelList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%;  font-size: x-small;">  
				<tr>
					<th>No</th>
					<th>Name</th>
					<c:if test="${sessionScope.user_role_session=='Admin'}">
						<th></th>
						<th></th>
					</c:if>
				</tr>
				<logic:iterate name="tireBrandForm" property="modelList" type="com.transport.model.TireBrand" id="model" indexId="index">
					<tr>				 
						<td><c:out value="${index+1 + (tireBrandForm.currentPage * 10 - 10)}"/></td>
						<td><bean:write name="model" property="name"/></td>
						<c:if test="${sessionScope.user_role_session=='Admin'}">
							<td align="center"><a href="#" onclick="javascript: editTireBrand('<bean:write name="model" property="id"/>');">Edit</a></td>
							<td align="center"><a href="#" onclick="javascript: deleteTireBrand('<bean:write name="model" property="id"/>', '${tireBrandForm.category}',${tireBrandForm.currentPage})">Delete</a></td>
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
				<c:if test="${tireBrandForm.currentPage != 1 && tireBrandForm.noOfPages > 0}">
					<li><a href="#" onclick="getTireBrand(${tireBrandForm.currentPage - 1},'${tireBrandForm.category}');">Previous</a></li>
				</c:if>
				<c:if test="${tireBrandForm.currentPage lt tireBrandForm.noOfPages}">
				  	<li><a href="#" onclick="getTireBrand(${tireBrandForm.currentPage + 1},'${tireBrandForm.category}');">Next</a></li>
				</c:if>
			</ul>
		</div>
		<div style="position: relative; top: -15px; float: right;" >
			<ul class="pagination">
			
				<c:if test="${tireBrandForm.currentPage != 1 && tireBrandForm.noOfPages > 0}">
					<li><a href="#" onclick="getTireBrand(${tireBrandForm.currentPage - 1},'${tireBrandForm.category}');">&laquo;</a></li>
				</c:if>
					
				<!-- pagination limit to 10 -->
				<c:choose>
					<c:when test="${tireBrandForm.currentPage lt tireBrandForm.noOfPages && tireBrandForm.noOfPages > 10}">
						<c:forEach begin="${tireBrandForm.currentPage}" end="${tireBrandForm.currentPage+9}" var="i">
							<c:choose>
			                    <c:when test="${tireBrandForm.currentPage eq i}">
			                        <li class="active"><a href="#">${i}</a></li>
			                    </c:when>
			                    <c:otherwise>
			                         <li><a href="#" onclick="getTireBrand(${i},'${tireBrandForm.category}');">${i}</a></li>
			                    </c:otherwise>
			                </c:choose>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<c:forEach begin="1" end="${tireBrandForm.noOfPages}" var="i">
			                <c:choose>
			                    <c:when test="${tireBrandForm.currentPage eq i}">
			                        <li class="active"><a href="#">${i}</a></li>
			                    </c:when>
			                    <c:otherwise>
			                         <li><a href="#" onclick="getTireBrand(${i},'${tireBrandForm.category}');">${i}</a></li>
			                    </c:otherwise>
			                </c:choose>
			            </c:forEach>					
					</c:otherwise>
				</c:choose>

	           	<c:if test="${remarksForm.currentPage lt remarksForm.noOfPages}">
	               	<li><a href="#" onclick="getTireBrand(${remarksForm.currentPage + 1},'${remarksForm.category}');">&raquo;</a></li>
	            </c:if>

			</ul>
		</div>
	</div>

<!-- 
	<div id="msgDeletedId" align="center">
		<span style="color: blue;"><c:out value="${roomCategoryForm.transactionMessage}"></c:out></span>
	</div> 
	 -->