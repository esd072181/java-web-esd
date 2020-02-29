<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

	<div class="table-responsive" style="padding-left: 10px;">
		<c:choose>
		  <c:when test="${employeeForm.modelList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%;">  
				<tr>
					<th>Id</th>
					<th>Last Name</th>
					<th>First Name</th>
					<th>Middle Name</th>
					<th>Category</th>
					<th>Permit Issuer</th>
					<th></th>
					<th></th>
				</tr>
				<logic:iterate name="employeeForm" property="modelList" type="com.transport.model.Employee" id="model">
					<tr>				 
						<%--<td><bean:write name="resultsId" property="id"/><bean:message key="Building.Id"/></td>--%>
						<td><bean:write name="model" property="id"/></td>
						<td><bean:write name="model" property="lastName"/></td>
						<td><bean:write name="model" property="firstName"/></td>
						<td><bean:write name="model" property="middleName"/></td>
						<td><bean:write name="model" property="empCategory"/></td>
						<td><bean:write name="model" property="permitIssuerStr"/></td>
						<td align="center"><a href="#" onclick="javascript: editEmployee('<bean:write name="model" property="id"/>');">Edit</a></td>
						<td align="center"><a href="#" onclick="javascript: deleteEmployee('<bean:write name="model" property="id"/>', '${employeeForm.category}',${employeeForm.currentPage})">Delete</a></td>
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
				<c:if test="${employeeForm.currentPage != 1 && employeeForm.noOfPages > 0}">
					<li><a href="#" onclick="getEmployee(${employeeForm.currentPage - 1},'${employeeForm.category}');">Previous</a></li>
				</c:if>
				<c:if test="${employeeForm.currentPage lt employeeForm.noOfPages}">
				  	<li><a href="#" onclick="getEmployee(${employeeForm.currentPage + 1},'${employeeForm.category}');">Next</a></li>
				</c:if>
			</ul>
		</div>
		<div style="position: relative; top: -15px; float: right;" >
			<ul class="pagination">
			
				<c:if test="${employeeForm.currentPage != 1 && employeeForm.noOfPages > 0}">
					<li><a href="#" onclick="getEmployee(${employeeForm.currentPage - 1},'${employeeForm.category}');">&laquo;</a></li>
				</c:if>
					
				<c:forEach begin="1" end="${employeeForm.noOfPages}" var="i">
	                <c:choose>
	                    <c:when test="${employeeForm.currentPage eq i}">
	                        <li class="active"><a href="#">${i}</a></li>
	                    </c:when>
	                    <c:otherwise>
	                         <li><a href="#" onclick="getEmployee(${i},'${employeeForm.category}');">${i}</a></li>
	                    </c:otherwise>
	                </c:choose>
	            </c:forEach>
	           	<c:if test="${employeeForm.currentPage lt employeeForm.noOfPages}">
	               	<li><a href="#" onclick="getEmployee(${employeeForm.currentPage + 1},'${employeeForm.category}');">&raquo;</a></li>
	            </c:if>

			</ul>
		</div>
	</div>

<!-- 
	<div id="msgDeletedId" align="center">
		<span style="color: blue;"><c:out value="${roomCategoryForm.transactionMessage}"></c:out></span>
	</div> 
	 -->