<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

	<div class="table-responsive" style="padding-left: 10px;">
		<c:choose>
		  <c:when test="${correctionsForm.modelList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%;">  
				<tr>
					<th>Id</th>
					<th>Description</th>
					<th>RootCause</th>
					<th></th>
					<th></th>
				</tr>
				<logic:iterate name="correctionsForm" property="modelList" type="com.transport.model.Corrections" id="model">
					<tr>				 
						<%--<td><bean:write name="resultsId" property="id"/><bean:message key="Building.Id"/></td>--%>
						<td><bean:write name="model" property="id"/></td>
						<td><bean:write name="model" property="description"/></td>
						<td><bean:write name="model" property="rootCause"/></td>
						<td align="center"><a href="#" onclick="javascript: editCorrections('<bean:write name="model" property="id"/>');">Edit</a></td>
						<td align="center"><a href="#" onclick="javascript: deleteCorrections('<bean:write name="model" property="id"/>', '${correctionsForm.category}',${correctionsForm.currentPage})">Delete</a></td>
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
				<c:if test="${correctionsForm.currentPage != 1 && correctionsForm.noOfPages > 0}">
					<li><a href="#" onclick="getCorrections(${correctionsForm.currentPage - 1},'${correctionsForm.category}');">Previous</a></li>
				</c:if>
				<c:if test="${correctionsForm.currentPage lt correctionsForm.noOfPages}">
				  	<li><a href="#" onclick="getCorrections(${correctionsForm.currentPage + 1},'${correctionsForm.category}');">Next</a></li>
				</c:if>
			</ul>
		</div>
		<div style="position: relative; top: -15px; float: right;" >
			<ul class="pagination">
			
				<c:if test="${correctionsForm.currentPage != 1 && correctionsForm.noOfPages > 0}">
					<li><a href="#" onclick="getCorrections(${correctionsForm.currentPage - 1},'${correctionsForm.category}');">&laquo;</a></li>
				</c:if>
					
				<c:forEach begin="1" end="${correctionsForm.noOfPages}" var="i">
	                <c:choose>
	                    <c:when test="${correctionsForm.currentPage eq i}">
	                        <li class="active"><a href="#">${i}</a></li>
	                    </c:when>
	                    <c:otherwise>
	                         <li><a href="#" onclick="getCorrections(${i},'${correctionsForm.category}');">${i}</a></li>
	                    </c:otherwise>
	                </c:choose>
	            </c:forEach>
	           	<c:if test="${correctionsForm.currentPage lt correctionsForm.noOfPages}">
	               	<li><a href="#" onclick="getCorrections(${correctionsForm.currentPage + 1},'${correctionsForm.category}');">&raquo;</a></li>
	            </c:if>

			</ul>
		</div>
	</div>

<!-- 
	<div id="msgDeletedId" align="center">
		<span style="color: blue;"><c:out value="${roomCategoryForm.transactionMessage}"></c:out></span>
	</div> 
	 -->