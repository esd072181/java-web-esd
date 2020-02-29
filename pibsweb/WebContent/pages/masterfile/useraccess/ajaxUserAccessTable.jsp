<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

	<div class="table-responsive" >	
		<c:choose>
		  <c:when test="${userAccessForm.modelList != null}">
		  	<br>
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%;">  
				<tr>
					<th>Module</th>
					<c:if test="${sessionScope.user_role_session=='Admin'}">
						<th></th>
					</c:if>
				</tr>
				<logic:iterate name="userAccessForm" property="modelList" type="com.pibs.model.UserAccess" id="model">
					<tr>				 
						<%--<td><bean:write name="resultsId" property="id"/><bean:message key="Building.Id"/></td>--%>
						<td><bean:write name="model" property="moduleName"/></td>
						<c:if test="${sessionScope.user_role_session=='Admin'}">
							<td align="center"><a href="#" onclick="javascript: deleteUserAccess('<bean:write name="model" property="id"/>','filter',${userAccessForm.currentPage})">Remove</a></td>
						</c:if>						
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