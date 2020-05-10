<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<script>
		    
	$("#tableId tr").mouseover(function(){ 
		$('#selectedId').val( $(this).find(".classId").html());
	});
			
	$('#categoryId').val('${nurseryInquiryForm.category}');
	$('#currentPageId').val('${nurseryInquiryForm.currentPage}');
</script>
						
						
	<div class="table-responsive" align="left" >
		<c:choose>
			<c:when test="${nurseryInquiryForm.modelList != null}">
			<table  id="tableId" class="table table-bordered table-striped table-condensed table-hover context-menu-table" style="width: 98%;">  
				<tr>
					<th></th>
					<th>Last Name</th>
					<th>First Name</th>
					<th>Date Of Birth</th>
					<th>Time Of Birth</th>
					<th>Gender</th>
					<th>Weight</th>
					<th>Remarks</th>
					<th></th>
					<c:if test="${sessionScope.user_role_session=='Admin'}">
						<th></th>
					</c:if>
				</tr>
				<logic:iterate name="nurseryInquiryForm" property="modelList" type="com.pibs.model.MonitorNursery" id="model" indexId="index">
					<tr>
						<td><c:out value="${index+1 + (nurseryInquiryForm.currentPage * 10 - 10)}"/></td>
						<td><bean:write name="model" property="lastName"/></td>				 
						<td><bean:write name="model" property="firstName"/></td>
						<td><bean:write name="model" property="dateOfBirth"/></td>
						<td><bean:write name="model" property="timeOfBirth"/></td>
						<td><bean:write name="model" property="gender"/></td>
						<td><bean:write name="model" property="weight"/></td>						
						<td><bean:write name="model" property="remarks"/></td>
						<td align="center"><a href="#" onclick="editNurseryInquiry('<bean:write name="model" property="id"/>');">Edit</a></td>
						<c:if test="${sessionScope.user_role_session=='Admin'}">
							<td align="center"><a href="#" onclick="javascript: deleteNurseryInquiry('<bean:write name="model" property="id"/>', '${nurseryInquiryForm.category}',${nurseryInquiryForm.currentPage})">Delete</a></td>
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
				<c:if test="${nurseryInquiryForm.currentPage != 1 && nurseryInquiryForm.noOfPages > 0}">
					<li><a href="#" onclick="getBabyForNurseryInquiry(${nurseryInquiryForm.currentPage - 1},'${nurseryInquiryForm.category}');">Previous</a></li>
				</c:if>
				<c:if test="${nurseryInquiryForm.currentPage lt nurseryInquiryForm.noOfPages}">
				  	<li><a href="#" onclick="getBabyForNurseryInquiry(${nurseryInquiryForm.currentPage + 1},'${nurseryInquiryForm.category}');">Next</a></li>
				</c:if>
			</ul>
		</div>
		<div style="position: relative; top: -15px; float: right;" >
			<ul class="pagination">
			
				<c:if test="${nurseryInquiryForm.currentPage != 1 && nurseryInquiryForm.noOfPages > 0}">
					<li><a href="#" onclick="getBabyForNurseryInquiry(${nurseryInquiryForm.currentPage - 1},'${nurseryInquiryForm.category}');">&laquo;</a></li>
				</c:if>
					
				<!-- pagination limit to 10 -->
				<c:choose>
					<c:when test="${nurseryInquiryForm.currentPage lt nurseryInquiryForm.noOfPages && nurseryInquiryForm.noOfPages > 10}">
						<c:forEach begin="${nurseryInquiryForm.currentPage}" end="${nurseryInquiryForm.currentPage+9}" var="i">
							   <c:choose>
			                    <c:when test="${nurseryInquiryForm.currentPage eq i}">
			                        <li class="active"><a href="#">${i}</a></li>
			                    </c:when>
			                    <c:otherwise>
			                         <li><a href="#" onclick="getBabyForNurseryInquiry(${i},'${nurseryInquiryForm.category}');">${i}</a></li>
			                    </c:otherwise>
			                </c:choose>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<c:forEach begin="1" end="${nurseryInquiryForm.noOfPages}" var="i">
			                <c:choose>
			                    <c:when test="${nurseryInquiryForm.currentPage eq i}">
			                        <li class="active"><a href="#">${i}</a></li>
			                    </c:when>
			                    <c:otherwise>
			                         <li><a href="#" onclick="getBabyForNurseryInquiry(${i},'${nurseryInquiryForm.category}');">${i}</a></li>
			                    </c:otherwise>
			                </c:choose>
			            </c:forEach>
					</c:otherwise>
				</c:choose>	
				
	           	<c:if test="${nurseryInquiryForm.currentPage lt nurseryInquiryForm.noOfPages}">
	               	<li><a href="#" onclick="getBabyForNurseryInquiry(${nurseryInquiryForm.currentPage + 1},'${nurseryInquiryForm.category}');">&raquo;</a></li>
	            </c:if>

			</ul>
		</div>
	</div>

<!-- 
	<div id="msgDeletedId" align="center">
		<span style="color: blue;"><c:out value="${roomCategoryForm.transactionMessage}"></c:out></span>
	</div> 
	 -->