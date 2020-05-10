<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

	<div class="table-responsive" >
		<c:choose>
		  <c:when test="${userForm.modelList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%;">  
				<tr>
					<th>No</th>
					<th>Employee Name</th>
					<th>Role</th>
					<th>User Name</th>
					<th></th>
					<c:if test="${sessionScope.user_role_session=='Admin'}">
						<th></th>
					</c:if>
				</tr>
				<logic:iterate name="userForm" property="modelList" type="com.pibs.model.User" id="model" indexId="index">
					<tr>				 
						<td><c:out value="${index+1 + (userForm.currentPage * 10 - 10)}"/></td>
						<td><bean:write name="model" property="name"/></td>
						<td><bean:write name="model" property="role"/></td>
						<c:choose>
							<c:when test="${sessionScope.user_session.id == model.id}">
								<td><bean:write name="model" property="userName"/></td>
							</c:when>
							<c:otherwise>
								<td>-</td>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${sessionScope.user_role_session=='Admin'}">
								<td align="center"><a href="#" onclick="javascript: editUser('<bean:write name="model" property="id"/>');">Edit</a></td>
							</c:when>
							<c:otherwise>
								<td></td>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${sessionScope.user_role_session=='Admin'}">
								<td align="center"><a href="#" onclick="javascript: deleteUser('<bean:write name="model" property="id"/>', '${userForm.category}',${userForm.currentPage})">Delete</a></td>
							</c:when>
							<c:otherwise>
								<td></td>
							</c:otherwise>							
						</c:choose>
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
				<c:if test="${userForm.currentPage != 1 && userForm.noOfPages > 0}">
					<li><a href="#" onclick="getUser(${userForm.currentPage - 1},'${userForm.category}');">Previous</a></li>
				</c:if>
				<c:if test="${userForm.currentPage lt userForm.noOfPages}">
				  	<li><a href="#" onclick="getUser(${userForm.currentPage + 1},'${userForm.category}');">Next</a></li>
				</c:if>
			</ul>
		</div>
		<div style="position: relative; top: -15px; float: right;" >
			<ul class="pagination">
			
				<c:if test="${userForm.currentPage != 1 && userForm.noOfPages > 0}">
					<li><a href="#" onclick="getUser(${userForm.currentPage - 1},'${userForm.category}');">&laquo;</a></li>
				</c:if>
				
				<!-- pagination limit to 10 -->
				<c:choose>
					<c:when test="${userForm.currentPage lt userForm.noOfPages && userForm.noOfPages > 10}">
						<c:forEach begin="${userForm.currentPage}" end="${userForm.currentPage+9}" var="i">
							 <c:choose>
			                    <c:when test="${userForm.currentPage eq i}">
			                        <li class="active"><a href="#">${i}</a></li>
			                    </c:when>
			                    <c:otherwise>
			                         <li><a href="#" onclick="getUser(${i},'${userForm.category}');">${i}</a></li>
			                    </c:otherwise>
			                </c:choose>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<c:forEach begin="1" end="${userForm.noOfPages}" var="i">
			                <c:choose>
			                    <c:when test="${userForm.currentPage eq i}">
			                        <li class="active"><a href="#">${i}</a></li>
			                    </c:when>
			                    <c:otherwise>
			                         <li><a href="#" onclick="getUser(${i},'${userForm.category}');">${i}</a></li>
			                    </c:otherwise>
			                </c:choose>
			            </c:forEach>
					</c:otherwise>
				</c:choose>	
					
	           	<c:if test="${userForm.currentPage lt userForm.noOfPages}">
	               	<li><a href="#" onclick="getUser(${userForm.currentPage + 1},'${userForm.category}');">&raquo;</a></li>
	            </c:if>

			</ul>
		</div>
	</div>

<!-- 
	<div id="msgDeletedId" align="center">
		<span style="color: blue;"><c:out value="${roomCategoryForm.transactionMessage}"></c:out></span>
	</div> 
	 -->