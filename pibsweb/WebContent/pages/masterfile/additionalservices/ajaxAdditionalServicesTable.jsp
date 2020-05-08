<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

	<div class="table-responsive" align="left">
		<c:choose>
		<c:when test="${additionalServicesForm.modelList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%;">  
				<tr>
					<th>No</th>
					<th>Description</th>
					<th>Remarks</th>
					<th>Category</th>
					<th>Fee</th>
					<c:if test="${sessionScope.user_role_session=='Admin'}">
						<th></th>
					</c:if>
				</tr>
				<logic:iterate name="additionalServicesForm" property="modelList" type="com.pibs.model.AdditionalServices" id="model" indexId="index">
					<tr>				 
						<td><c:out value="${index+1 + (additionalServicesForm.currentPage * 10 - 10)}"/></td>
						<td><a href="#" onclick="javascript: editAdditionalServices('<bean:write name="model" property="id"/>');">${model.description}</a></td>
						<td><bean:write name="model" property="remarks"/></td>
						<td><bean:write name="model" property="additionalServicesCategory"/></td>
						<logic:equal name="model" property="fee" value="0">
							<td></td>
						</logic:equal>
						<logic:notEqual name="model" property="fee" value="0">
							<td align="right"><bean:write name="model" property="fee" format="Php #,###.00"/></td>
						</logic:notEqual>
						<c:if test="${sessionScope.user_role_session=='Admin'}">
							<td align="center"><a href="#" onclick="javascript: deleteAdditionalServices('<bean:write name="model" property="id"/>', '${additionalServicesForm.category}',${additionalServicesForm.currentPage})">Delete</a></td>
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
				<c:if test="${additionalServicesForm.currentPage != 1 && additionalServicesForm.noOfPages > 0}">
					<li><a href="#" onclick="getAdditionalServices(${additionalServicesForm.currentPage - 1},'${additionalServicesForm.category}');">Previous</a></li>
				</c:if>
				<c:if test="${additionalServicesForm.currentPage lt additionalServicesForm.noOfPages}">
				  	<li><a href="#" onclick="getAdditionalServices(${additionalServicesForm.currentPage + 1},'${additionalServicesForm.category}');">Next</a></li>
				</c:if>
			</ul>
		</div>
		<div style="position: relative; top: -15px; float: right;" >
			<ul class="pagination">
			
				<c:if test="${additionalServicesForm.currentPage != 1 && additionalServicesForm.noOfPages > 0}">
					<li><a href="#" onclick="getAdditionalServices(${additionalServicesForm.currentPage - 1},'${additionalServicesForm.category}');">&laquo;</a></li>
				</c:if>
				
				<!-- pagination limit to 10 -->
				<c:choose>
					<c:when test="${additionalServicesForm.currentPage lt additionalServicesForm.noOfPages && additionalServicesForm.noOfPages > 10}">
						<c:forEach begin="${additionalServicesForm.currentPage}" end="${additionalServicesForm.currentPage+9}" var="i">
							<c:choose>
			                    <c:when test="${additionalServicesForm.currentPage eq i}">
			                        <li class="active"><a href="#">${i}</a></li>
			                    </c:when>
			                    <c:otherwise>
			                         <li><a href="#" onclick="getAdditionalServices(${i},'${additionalServicesForm.category}');">${i}</a></li>
			                    </c:otherwise>
			                </c:choose>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<c:forEach begin="1" end="${additionalServicesForm.noOfPages}" var="i">
			                <c:choose>
			                    <c:when test="${additionalServicesForm.currentPage eq i}">
			                        <li class="active"><a href="#">${i}</a></li>
			                    </c:when>
			                    <c:otherwise>
			                         <li><a href="#" onclick="getAdditionalServices(${i},'${additionalServicesForm.category}');">${i}</a></li>
			                    </c:otherwise>
			                </c:choose>
			            </c:forEach>
					</c:otherwise>
				</c:choose>	
				
	           	<c:if test="${additionalServicesForm.currentPage lt additionalServicesForm.noOfPages}">
	               	<li><a href="#" onclick="getAdditionalServices(${additionalServicesForm.currentPage + 1},'${additionalServicesForm.category}');">&raquo;</a></li>
	            </c:if>

			</ul>
		</div>
	</div>

<!-- 
	<div id="msgDeletedId" align="center">
		<span style="color: blue;"><c:out value="${roomCategoryForm.transactionMessage}"></c:out></span>
	</div> 
	 -->