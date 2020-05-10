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
			
			$('#categoryId').val('${patientInquiryForm.category}');
			$('#currentPageId').val('${patientInquiryForm.currentPage}');
			</script>
						
						
	<div class="table-responsive" align="left" >
		<c:choose>
		<c:when test="${patientInquiryForm.modelList != null}">
			<table  id="tableId" class="table table-bordered table-striped table-condensed table-hover context-menu-table" style="width: 100%;">  
				<tr>
					<th>No</th>
					<th>Name</th>
					<th>Gender</th>
					<th>Address</th>
					<th>Patient Status</th>
					<th>Chief Complaint</th>
					<th>Date Admitted</th>
					<th>Date Discharged</th>
					<th>Admission Status</th>
					<th>Room</th>
					<th>Doctor</th>
					<th>Case No</th>
				</tr>
				<logic:iterate name="patientInquiryForm" property="modelList" type="com.pibs.model.Patient" id="model" indexId="index">
					<tr>				 
						<td><c:out value="${index+1 + (patientInquiryForm.currentPage * 10 - 10)}"/></td>
						<td><bean:write name="model" property="fullName"/></td>
						<td><bean:write name="model" property="gender"/></td>
						<td><bean:write name="model" property="address"/></td>
						<td><bean:write name="model" property="status"/></td>
						<td><bean:write name="model" property="chiefComplaint"/></td>
						<td><bean:write name="model" property="dateAdmitted"/></td>
						<td><bean:write name="model" property="dateDischarged"/></td>
						<td><bean:write name="model" property="admissionStatus"/></td>
						<td><bean:write name="model" property="roomNo"/></td>
						<td><bean:write name="model" property="doctor"/></td>
						<td><bean:write name="model" property="caseNo"/></td>
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
				<c:if test="${patientInquiryForm.currentPage != 1 && patientInquiryForm.noOfPages > 0}">
					<li><a href="#" onclick="getPatientForPatientInquiry(${patientInquiryForm.currentPage - 1},'${patientInquiryForm.category}');">Previous</a></li>
				</c:if>
				<c:if test="${patientInquiryForm.currentPage lt patientInquiryForm.noOfPages}">
				  	<li><a href="#" onclick="getPatientForPatientInquiry(${patientInquiryForm.currentPage + 1},'${patientInquiryForm.category}');">Next</a></li>
				</c:if>
			</ul>
		</div>
		<div style="position: relative; top: -15px; float: right;" >
			<ul class="pagination">
			
				<c:if test="${patientInquiryForm.currentPage != 1 && patientInquiryForm.noOfPages > 0}">
					<li><a href="#" onclick="getPatientForPatientInquiry(${patientInquiryForm.currentPage - 1},'${patientInquiryForm.category}');">&laquo;</a></li>
				</c:if>
				
				<!-- pagination limit to 10 -->
				<c:choose>
					<c:when test="${patientInquiryForm.currentPage lt patientInquiryForm.noOfPages && patientInquiryForm.noOfPages > 10}">
						<c:forEach begin="${patientInquiryForm.currentPage}" end="${patientInquiryForm.currentPage+9}" var="i">
							 <c:choose>
			                    <c:when test="${patientInquiryForm.currentPage eq i}">
			                        <li class="active"><a href="#">${i}</a></li>
			                    </c:when>
			                    <c:otherwise>
			                         <li><a href="#" onclick="getPatientForPatientInquiry(${i},'${patientInquiryForm.category}');">${i}</a></li>
			                    </c:otherwise>
			                </c:choose>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<c:forEach begin="1" end="${patientInquiryForm.noOfPages}" var="i">
			                <c:choose>
			                    <c:when test="${patientInquiryForm.currentPage eq i}">
			                        <li class="active"><a href="#">${i}</a></li>
			                    </c:when>
			                    <c:otherwise>
			                         <li><a href="#" onclick="getPatientForPatientInquiry(${i},'${patientInquiryForm.category}');">${i}</a></li>
			                    </c:otherwise>
			                </c:choose>
			            </c:forEach>
					</c:otherwise>
				</c:choose>	
					
	           	<c:if test="${patientInquiryForm.currentPage lt patientInquiryForm.noOfPages}">
	               	<li><a href="#" onclick="getPatientForPatientInquiry(${patientInquiryForm.currentPage + 1},'${patientInquiryForm.category}');">&raquo;</a></li>
	            </c:if>

			</ul>
		</div>
	</div>

<!-- 
	<div id="msgDeletedId" align="center">
		<span style="color: blue;"><c:out value="${roomCategoryForm.transactionMessage}"></c:out></span>
	</div> 
	 -->