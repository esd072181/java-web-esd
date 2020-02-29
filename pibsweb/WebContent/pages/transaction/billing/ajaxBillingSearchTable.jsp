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
			
			$('#categoryId').val('${billingForm.category}');
			$('#currentPageId').val('${billingForm.currentPage}');
			</script>
						
						
	<div class="table-responsive" align="left" >
		<c:choose>
		<c:when test="${billingForm.modelList != null}">
			<table  id="tableId" class="table table-bordered table-striped table-condensed table-hover context-menu-table" style="width: 98%;">  
				<tr>
					<th></th>
					<th>Name</th>
					<th>Gender</th>
					<th>Birthday</th>
					<th>Date Admitted</th>
					<th>Case No</th>
					<th>Patient Id</th>
					<th>Room No</th>
					<th>Doctor</th>
				</tr>
				<logic:iterate name="billingForm" property="modelList" type="com.pibs.model.Patient" id="model">
					<tr>				 
						<%--<td><bean:write name="resultsId" property="id"/><bean:message key="Building.Id"/></td>--%>
						<td align="center"><a href="#" onclick="javascript: goToBilling('<bean:write name="model" property="patientCaseSystemId"/>');">Select</a></td>
						<!--<td class="classId"><bean:write name="model" property="id"/></td>-->
						<td><bean:write name="model" property="fullName"/></td>
						<td><bean:write name="model" property="gender"/></td>
						<td><bean:write name="model" property="birthday"/></td>
						<td><bean:write name="model" property="dateAdmitted"/></td>
						<td><bean:write name="model" property="caseNo"/></td>
						<td><bean:write name="model" property="patientId"/></td>
						<td><bean:write name="model" property="roomNo"/></td>
						<td><bean:write name="model" property="doctor"/></td>
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
				<c:if test="${billingForm.currentPage != 1 && billingForm.noOfPages > 0}">
					<li><a href="#" onclick="getPatientForMonitorPatient(${billingForm.currentPage - 1},'${billingForm.category}');">Previous</a></li>
				</c:if>
				<c:if test="${billingForm.currentPage lt billingForm.noOfPages}">
				  	<li><a href="#" onclick="getPatientForMonitorPatient(${billingForm.currentPage + 1},'${billingForm.category}');">Next</a></li>
				</c:if>
			</ul>
		</div>
		<div style="position: relative; top: -15px; float: right;" >
			<ul class="pagination">
			
				<c:if test="${billingForm.currentPage != 1 && billingForm.noOfPages > 0}">
					<li><a href="#" onclick="getPatientForMonitorPatient(${billingForm.currentPage - 1},'${billingForm.category}');">&laquo;</a></li>
				</c:if>
					
				<c:forEach begin="1" end="${billingForm.noOfPages}" var="i">
	                <c:choose>
	                    <c:when test="${billingForm.currentPage eq i}">
	                        <li class="active"><a href="#">${i}</a></li>
	                    </c:when>
	                    <c:otherwise>
	                         <li><a href="#" onclick="getPatientForMonitorPatient(${i},'${billingForm.category}');">${i}</a></li>
	                    </c:otherwise>
	                </c:choose>
	            </c:forEach>
	           	<c:if test="${billingForm.currentPage lt billingForm.noOfPages}">
	               	<li><a href="#" onclick="getPatientForMonitorPatient(${billingForm.currentPage + 1},'${billingForm.category}');">&raquo;</a></li>
	            </c:if>

			</ul>
		</div>
	</div>

<!-- 
	<div id="msgDeletedId" align="center">
		<span style="color: blue;"><c:out value="${roomCategoryForm.transactionMessage}"></c:out></span>
	</div> 
	 -->