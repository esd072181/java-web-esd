<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

	<div class="table-responsive" style="padding-left: 10px;">	
		<c:if test="${sessionScope.user_session.role == 'Admin'}">
			<div>
				<html:button styleId="btnAddUserAccessId" property="command" onclick="goToAddUserAccess($('#userIdId').val());" value="Add User Access" styleClass="btn btn-primary"></html:button>
			</div>		
		</c:if>
		<c:choose>
		  <c:when test="${userAccessForm.modelList != null}">
		  	<br>
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%;">  
				<tr>
					<th>No</th>
					<th>Module</th>
					<th></th>
				</tr>
				<logic:iterate name="userAccessForm" property="modelList" type="com.transport.model.UserAccess" id="model" indexId="index">
					<tr>				 
						<td><c:out value="${index+1 + (userAccessForm.currentPage * 10 - 10)}"/></td>
						<td><bean:write name="model" property="moduleName"/></td>
						<c:choose>
							<c:when test="${sessionScope.user_session.role == 'Admin'}">
								<td align="center"><a href="#" onclick="javascript: deleteUserAccess('<bean:write name="model" property="id"/>','filter',${userAccessForm.currentPage})">Remove</a></td>
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
		  		<br>
		      <div style="color: blue;">No Record found!</div>
		  </c:otherwise>
		</c:choose>
	</div>
	
	<div style="height: 50px; width: 98%;">
		<div style="position: relative; top: -15px; float: left;">
			<ul class="pager">
				<c:if test="${userAccessForm.currentPage != 1 && userAccessForm.noOfPages > 0}">
					<li><a href="#" onclick="getUserAccess(${userAccessForm.currentPage - 1},'${userAccessForm.category}');">Previous</a></li>
				</c:if>
				<c:if test="${userAccessForm.currentPage lt userAccessForm.noOfPages}">
				  	<li><a href="#" onclick="getUserAccess(${userAccessForm.currentPage + 1},'${userAccessForm.category}');">Next</a></li>
				</c:if>
			</ul>
		</div>
		<div style="position: relative; top: -15px; float: right;" >
			<ul class="pagination">
			
				<c:if test="${userAccessForm.currentPage != 1 && userAccessForm.noOfPages > 0}">
					<li><a href="#" onclick="getUserAccess(${userAccessForm.currentPage - 1},'${userAccessForm.category}');">&laquo;</a></li>
				</c:if>
					
				<!-- pagination limit to 10 -->
				<c:choose>
					<c:when test="${userAccessForm.currentPage lt userAccessForm.noOfPages && userAccessForm.noOfPages > 10}">
						<c:forEach begin="${userAccessForm.currentPage}" end="${userAccessForm.currentPage+9}" var="i">
							<c:choose>
			                    <c:when test="${userAccessForm.currentPage eq i}">
			                        <li class="active"><a href="#">${i}</a></li>
			                    </c:when>
			                    <c:otherwise>
			                         <li><a href="#" onclick="getUserAccess(${i},'${userAccessForm.category}');">${i}</a></li>
			                    </c:otherwise>
			                </c:choose>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<c:forEach begin="1" end="${userAccessForm.noOfPages}" var="i">
			                <c:choose>
			                    <c:when test="${userAccessForm.currentPage eq i}">
			                        <li class="active"><a href="#">${i}</a></li>
			                    </c:when>
			                    <c:otherwise>
			                         <li><a href="#" onclick="getUserAccess(${i},'${userAccessForm.category}');">${i}</a></li>
			                    </c:otherwise>
			                </c:choose>
			            </c:forEach>
					</c:otherwise>
				</c:choose>
				
	           	<c:if test="${userAccessForm.currentPage lt userAccessForm.noOfPages}">
	               	<li><a href="#" onclick="getUserAccess(${userAccessForm.currentPage + 1},'${userAccessForm.category}');">&raquo;</a></li>
	            </c:if>

			</ul>
		</div>
	</div>
<!-- 
	<div id="msgDeletedId" align="center">
		<span style="color: blue;"><c:out value="${roomCategoryForm.transactionMessage}"></c:out></span>
	</div> 
	 -->