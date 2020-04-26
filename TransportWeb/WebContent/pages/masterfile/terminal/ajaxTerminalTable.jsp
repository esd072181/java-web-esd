<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

	<div class="table-responsive" style="padding-left: 10px;">
		<c:choose>
		  <c:when test="${terminalForm.modelList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%;">  
				<tr>
					<th>No</th>
					<th>Name</th>
					<th></th>
					<th></th>
				</tr>
				<logic:iterate name="terminalForm" property="modelList" type="com.transport.model.Terminal" id="model" indexId="index">
					<tr>				 
						<td><c:out value="${index+1 + (terminalForm.currentPage * 10 - 10)}"/></td>
						<td><bean:write name="model" property="name"/></td>
						<td align="center"><a href="#" onclick="javascript: editTerminal('<bean:write name="model" property="id"/>');">Edit</a></td>
						<td align="center"><a href="#" onclick="javascript: deleteTerminal('<bean:write name="model" property="id"/>', '${terminalForm.category}',${terminalForm.currentPage})">Delete</a></td>
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
				<c:if test="${terminalForm.currentPage != 1 && terminalForm.noOfPages > 0}">
					<li><a href="#" onclick="getTerminal(${terminalForm.currentPage - 1},'${terminalForm.category}');">Previous</a></li>
				</c:if>
				<c:if test="${terminalForm.currentPage lt terminalForm.noOfPages}">
				  	<li><a href="#" onclick="getTerminal(${terminalForm.currentPage + 1},'${terminalForm.category}');">Next</a></li>
				</c:if>
			</ul>
		</div>
		<div style="position: relative; top: -15px; float: right;" >
			<ul class="pagination">
			
				<c:if test="${terminalForm.currentPage != 1 && terminalForm.noOfPages > 0}">
					<li><a href="#" onclick="getTerminal(${terminalForm.currentPage - 1},'${terminalForm.category}');">&laquo;</a></li>
				</c:if>
					
				<c:forEach begin="1" end="${terminalForm.noOfPages}" var="i">
	                <c:choose>
	                    <c:when test="${terminalForm.currentPage eq i}">
	                        <li class="active"><a href="#">${i}</a></li>
	                    </c:when>
	                    <c:otherwise>
	                         <li><a href="#" onclick="getTerminal(${i},'${terminalForm.category}');">${i}</a></li>
	                    </c:otherwise>
	                </c:choose>
	            </c:forEach>
	           	<c:if test="${terminalForm.currentPage lt terminalForm.noOfPages}">
	               	<li><a href="#" onclick="getTerminal(${terminalForm.currentPage + 1},'${terminalForm.category}');">&raquo;</a></li>
	            </c:if>

			</ul>
		</div>
	</div>

<!-- 
	<div id="msgDeletedId" align="center">
		<span style="color: blue;"><c:out value="${roomCategoryForm.transactionMessage}"></c:out></span>
	</div> 
	 -->