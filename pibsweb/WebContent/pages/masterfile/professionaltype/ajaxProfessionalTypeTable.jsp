<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

	<div class="table-responsive" align="left">
		<c:choose>
		<c:when test="${professionalTypeForm.modelList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%;">  
				<tr>
					<th>No</th>
					<th>Description</th>
					<th>Remarks</th>
					<th></th>
					<c:if test="${sessionScope.user_role_session=='Admin'}">
						<th></th>
					</c:if>
				</tr>
				<logic:iterate name="professionalTypeForm" property="modelList" type="com.pibs.model.ProfessionalType" id="model" indexId="index">
					<tr>				 
						<td><c:out value="${index+1 + (professionalTypeForm.currentPage * 10 - 10)}"/></td>
						<td><bean:write name="model" property="description"/></td>
						<td><bean:write name="model" property="remarks"/></td>
						<td align="center"><a href="#" onclick="javascript: editProfessionalType('<bean:write name="model" property="id"/>');">Edit</a></td>
						<c:if test="${sessionScope.user_role_session=='Admin'}">
							<td align="center"><a href="#" onclick="javascript: deleteProfessionalType('<bean:write name="model" property="id"/>', '${professionalTypeForm.category}',${professionalTypeForm.currentPage})">Delete</a></td>
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
				<c:if test="${professionalTypeForm.currentPage != 1 && professionalTypeForm.noOfPages > 0}">
					<li><a href="#" onclick="getProfessionalType(${professionalTypeForm.currentPage - 1},'${professionalTypeForm.category}');">Previous</a></li>
				</c:if>
				<c:if test="${professionalTypeForm.currentPage lt professionalTypeForm.noOfPages}">
				  	<li><a href="#" onclick="getProfessionalType(${professionalTypeForm.currentPage + 1},'${professionalTypeForm.category}');">Next</a></li>
				</c:if>
			</ul>
		</div>
		<div style="position: relative; top: -15px; float: right;" >
			<ul class="pagination">
			
				<c:if test="${professionalTypeForm.currentPage != 1 && professionalTypeForm.noOfPages > 0}">
					<li><a href="#" onclick="getProfessionalType(${professionalTypeForm.currentPage - 1},'${professionalTypeForm.category}');">&laquo;</a></li>
				</c:if>
				
				<!-- pagination limit to 10 -->
				<c:choose>
					<c:when test="${professionalTypeForm.currentPage lt professionalTypeForm.noOfPages && professionalTypeForm.noOfPages > 10}">
						<c:forEach begin="${professionalTypeForm.currentPage}" end="${professionalTypeForm.currentPage+9}" var="i">
							 <c:choose>
			                    <c:when test="${professionalTypeForm.currentPage eq i}">
			                        <li class="active"><a href="#">${i}</a></li>
			                    </c:when>
			                    <c:otherwise>
			                         <li><a href="#" onclick="getProfessionalType(${i},'${professionalTypeForm.category}');">${i}</a></li>
			                    </c:otherwise>
			                </c:choose>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<c:forEach begin="1" end="${professionalTypeForm.noOfPages}" var="i">
			                <c:choose>
			                    <c:when test="${professionalTypeForm.currentPage eq i}">
			                        <li class="active"><a href="#">${i}</a></li>
			                    </c:when>
			                    <c:otherwise>
			                         <li><a href="#" onclick="getProfessionalType(${i},'${professionalTypeForm.category}');">${i}</a></li>
			                    </c:otherwise>
			                </c:choose>
			            </c:forEach>
					</c:otherwise>
				</c:choose>	
				
	           	<c:if test="${professionalTypeForm.currentPage lt professionalTypeForm.noOfPages}">
	               	<li><a href="#" onclick="getProfessionalType(${professionalTypeForm.currentPage + 1},'${professionalTypeForm.category}');">&raquo;</a></li>
	            </c:if>

			</ul>
		</div>
	</div>

<!-- 
	<div id="msgDeletedId" align="center">
		<span style="color: blue;"><c:out value="${roomCategoryForm.transactionMessage}"></c:out></span>
	</div> 
	 -->