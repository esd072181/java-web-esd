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
			
			$('#categoryId').val('${patientBillHistoryForm.category}');
			$('#currentPageId').val('${patientBillHistoryForm.currentPage}');
		</script>
						
						
	<div class="table-responsive" align="left" >
		<c:choose>
		<c:when test="${patientBillHistoryForm.modelList != null}">
			<table  id="tableId" class="table table-bordered table-striped table-condensed table-hover context-menu-table" style="width: 98%;">  
				<tr>
					<th></th>
					<th>CaseNo</th>
					<th>Name</th>
					<th>Date Admitted</th>
					<th>Date Discharged</th>
				</tr>
				<logic:iterate name="patientBillHistoryForm" property="modelList" type="com.pibs.model.Patient" id="model">
					<tr>				 
						<td align="center"><a id="<bean:write name="model" property="caseNo"/>" href="#" target="_blank" onclick="javascript: goToPatientBillHistoryDetails('<bean:write name="model" property="caseNo"/>');">View Details</a></td>
						<td><bean:write name="model" property="caseNo"/></td>
						<td><bean:write name="model" property="fullName"/></td>
						<td><bean:write name="model" property="dateAdmitted"/></td>
						<td><bean:write name="model" property="dateDischarged"/></td>
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
				<c:if test="${patientBillHistoryForm.currentPage != 1 && patientBillHistoryForm.noOfPages > 0}">
					<li><a href="#" onclick="getPatientForPatientBillHistory(${patientBillHistoryForm.currentPage - 1},'${patientBillHistoryForm.category}');">Previous</a></li>
				</c:if>
				<c:if test="${patientBillHistoryForm.currentPage lt patientBillHistoryForm.noOfPages}">
				  	<li><a href="#" onclick="getPatientForPatientBillHistory(${patientBillHistoryForm.currentPage + 1},'${patientBillHistoryForm.category}');">Next</a></li>
				</c:if>
			</ul>
		</div>
		<div style="position: relative; top: -15px; float: right;" >
			<ul class="pagination">
			
				<c:if test="${patientBillHistoryForm.currentPage != 1 && patientBillHistoryForm.noOfPages > 0}">
					<li><a href="#" onclick="getPatientForPatientBillHistory(${patientBillHistoryForm.currentPage - 1},'${patientBillHistoryForm.category}');">&laquo;</a></li>
				</c:if>
					
				<c:forEach begin="1" end="${patientBillHistoryForm.noOfPages}" var="i">
	                <c:choose>
	                    <c:when test="${patientBillHistoryForm.currentPage eq i}">
	                        <li class="active"><a href="#">${i}</a></li>
	                    </c:when>
	                    <c:otherwise>
	                         <li><a href="#" onclick="getPatientForPatientBillHistory(${i},'${patientBillHistoryForm.category}');">${i}</a></li>
	                    </c:otherwise>
	                </c:choose>
	            </c:forEach>
	           	<c:if test="${patientBillHistoryForm.currentPage lt patientBillHistoryForm.noOfPages}">
	               	<li><a href="#" onclick="getPatientForPatientBillHistory(${patientBillHistoryForm.currentPage + 1},'${patientBillHistoryForm.category}');">&raquo;</a></li>
	            </c:if>

			</ul>
		</div>
	</div>

<!-- 
	<div id="msgDeletedId" align="center">
		<span style="color: blue;"><c:out value="${roomCategoryForm.transactionMessage}"></c:out></span>
	</div> 
	 -->