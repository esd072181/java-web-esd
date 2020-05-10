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
			
			$('#categoryId').val('${admissionForm.category}');
			$('#currentPageId').val('${admissionForm.currentPage}');
			</script>
						
						
	<div class="table-responsive" align="left" >
		<c:choose>
		<c:when test="${admissionForm.modelList != null}">
			<table  id="tableId" class="table table-bordered table-striped table-condensed table-hover context-menu-table" style="width: 98%;">  
				<tr>
					<th></th>
					<th>Name</th>
					<th>Patient Id</th>
					<th>Gender</th>
					<th>Birthday</th>
					<th>Address</th>
					<th>Date Registered</th>
				</tr>
				<logic:iterate name="admissionForm" property="modelList" type="com.pibs.model.Patient" id="model">
					<tr>				 
						<%--<td><bean:write name="resultsId" property="id"/><bean:message key="Building.Id"/></td>--%>
						<td align="center"><a href="#" onclick="javascript: goToAdmission('<bean:write name="model" property="id"/>');">Select</a></td>
						<!--<td class="classId"><bean:write name="model" property="id"/></td>-->
						<td><bean:write name="model" property="fullName"/></td>
						<td><bean:write name="model" property="patientId"/></td>
						<td><bean:write name="model" property="gender"/></td>
						<td><bean:write name="model" property="birthday"/></td>
						<td><bean:write name="model" property="address"/></td>
						<td><bean:write name="model" property="dateRegistered"/></td>
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
				<c:if test="${admissionForm.currentPage != 1 && admissionForm.noOfPages > 0}">
					<li><a href="#" onclick="getPatient(${admissionForm.currentPage - 1},'${admissionForm.category}');">Previous</a></li>
				</c:if>
				<c:if test="${admissionForm.currentPage lt admissionForm.noOfPages}">
				  	<li><a href="#" onclick="getPatient(${admissionForm.currentPage + 1},'${admissionForm.category}');">Next</a></li>
				</c:if>
			</ul>
		</div>
		<div style="position: relative; top: -15px; float: right;" >
			<ul class="pagination">
			
				<c:if test="${admissionForm.currentPage != 1 && admissionForm.noOfPages > 0}">
					<li><a href="#" onclick="getPatient(${admissionForm.currentPage - 1},'${admissionForm.category}');">&laquo;</a></li>
				</c:if>
				
				<!-- pagination limit to 10 -->
				<c:choose>
					<c:when test="${admissionForm.currentPage lt admissionForm.noOfPages && admissionForm.noOfPages > 10}">
						<c:forEach begin="${admissionForm.currentPage}" end="${admissionForm.currentPage+9}" var="i">
							 <c:choose>
			                    <c:when test="${admissionForm.currentPage eq i}">
			                        <li class="active"><a href="#">${i}</a></li>
			                    </c:when>
			                    <c:otherwise>
			                         <li><a href="#" onclick="getPatient(${i},'${admissionForm.category}');">${i}</a></li>
			                    </c:otherwise>
			                </c:choose>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<c:forEach begin="1" end="${admissionForm.noOfPages}" var="i">
			                <c:choose>
			                    <c:when test="${admissionForm.currentPage eq i}">
			                        <li class="active"><a href="#">${i}</a></li>
			                    </c:when>
			                    <c:otherwise>
			                         <li><a href="#" onclick="getPatient(${i},'${admissionForm.category}');">${i}</a></li>
			                    </c:otherwise>
			                </c:choose>
			            </c:forEach>
					</c:otherwise>
				</c:choose>	
					
	           	<c:if test="${admissionForm.currentPage lt admissionForm.noOfPages}">
	               	<li><a href="#" onclick="getPatient(${admissionForm.currentPage + 1},'${admissionForm.category}');">&raquo;</a></li>
	            </c:if>

			</ul>
		</div>
	</div>

<!-- 
	<div id="msgDeletedId" align="center">
		<span style="color: blue;"><c:out value="${roomCategoryForm.transactionMessage}"></c:out></span>
	</div> 
	 -->