<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

	<div class="table-responsive" >
		<c:choose>
		  <c:when test="${closureForm.modelList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%;">  
				<tr>
					<th>No</th>
					<th>Closure Description</th>
					<th>Corrective Actions</th>
					<th></th>
					<th></th>
				</tr>
				<logic:iterate name="closureForm" property="modelList" type="com.transport.model.Closure" id="model" indexId="index">
					<tr>				 
						<td><c:out value="${index+1 + (closureForm.currentPage * 10 - 10)}"/></td>
						<td><bean:write name="model" property="description"/></td>
						<td><bean:write name="model" property="corrections"/></td>
						<td align="center"><a href="#" onclick="javascript: editClosure('<bean:write name="model" property="id"/>');">Edit</a></td>
						<td align="center"><a href="#" onclick="javascript: deleteClosure('<bean:write name="model" property="id"/>', '${closureForm.category}',${closureForm.currentPage})">Delete</a></td>
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
				<c:if test="${closureForm.currentPage != 1 && closureForm.noOfPages > 0}">
					<li><a href="#" onclick="getClosure(${closureForm.currentPage - 1},'${closureForm.category}');">Previous</a></li>
				</c:if>
				<c:if test="${closureForm.currentPage lt closureForm.noOfPages}">
				  	<li><a href="#" onclick="getClosure(${closureForm.currentPage + 1},'${closureForm.category}');">Next</a></li>
				</c:if>
			</ul>
		</div>
		<div style="position: relative; top: -15px; float: right;" >
			<ul class="pagination">
			
				<c:if test="${closureForm.currentPage != 1 && closureForm.noOfPages > 0}">
					<li><a href="#" onclick="getClosure(${closureForm.currentPage - 1},'${closureForm.category}');">&laquo;</a></li>
				</c:if>
					
				<c:forEach begin="1" end="${closureForm.noOfPages}" var="i">
	                <c:choose>
	                    <c:when test="${closureForm.currentPage eq i}">
	                        <li class="active"><a href="#">${i}</a></li>
	                    </c:when>
	                    <c:otherwise>
	                         <li><a href="#" onclick="getClosure(${i},'${closureForm.category}');">${i}</a></li>
	                    </c:otherwise>
	                </c:choose>
	            </c:forEach>
	           	<c:if test="${closureForm.currentPage lt closureForm.noOfPages}">
	               	<li><a href="#" onclick="getClosure(${closureForm.currentPage + 1},'${closureForm.category}');">&raquo;</a></li>
	            </c:if>

			</ul>
		</div>
	</div>

<!-- 
	<div id="msgDeletedId" align="center">
		<span style="color: blue;"><c:out value="${roomCategoryForm.transactionMessage}"></c:out></span>
	</div> 
	 -->