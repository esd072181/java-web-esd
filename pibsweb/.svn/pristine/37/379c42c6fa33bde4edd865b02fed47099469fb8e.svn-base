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
			
			$('#categoryId').val('${medicalAbstractForm.category}');
			$('#currentPageId').val('${medicalAbstractForm.currentPage}');
			</script>
						
						
	<div class="table-responsive" align="left" >
		<c:choose>
		<c:when test="${medicalAbstractForm.modelList != null}">
			<table  id="tableId" class="table table-bordered table-striped table-condensed table-hover context-menu-table" style="width: 98%;">  
				<tr>
					<th></th>
					<th>Name</th>
					<th>Gender</th>
					<th>Birthday</th>
					<th>Address</th>
					<th>Date Registered</th>
					<th>Patient Id</th>
				</tr>
				<logic:iterate name="medicalAbstractForm" property="modelList" type="com.pibs.model.Patient" id="model">
					<tr>				 
						<td align="center"><a href="#" onclick="javascript: goToMedicalAbstract('<bean:write name="model" property="id"/>');">Select</a></td>
						<td><bean:write name="model" property="fullName"/></td>
						<td><bean:write name="model" property="gender"/></td>
						<td><bean:write name="model" property="birthday"/></td>
						<td><bean:write name="model" property="address"/></td>
						<td><bean:write name="model" property="dateRegistered"/></td>
						<td><bean:write name="model" property="patientId"/></td>
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
				<c:if test="${medicalAbstractForm.currentPage != 1 && medicalAbstractForm.noOfPages > 0}">
					<li><a href="#" onclick="getPatientForMedicalAbstract(${medicalAbstractForm.currentPage - 1},'${medicalAbstractForm.category}');">Previous</a></li>
				</c:if>
				<c:if test="${medicalAbstractForm.currentPage lt medicalAbstractForm.noOfPages}">
				  	<li><a href="#" onclick="getPatientForMedicalAbstract(${medicalAbstractForm.currentPage + 1},'${medicalAbstractForm.category}');">Next</a></li>
				</c:if>
			</ul>
		</div>
		<div style="position: relative; top: -15px; float: right;" >
			<ul class="pagination">
			
				<c:if test="${medicalAbstractForm.currentPage != 1 && medicalAbstractForm.noOfPages > 0}">
					<li><a href="#" onclick="getPatientForMedicalAbstract(${medicalAbstractForm.currentPage - 1},'${medicalAbstractForm.category}');">&laquo;</a></li>
				</c:if>
					
				<c:forEach begin="1" end="${medicalAbstractForm.noOfPages}" var="i">
	                <c:choose>
	                    <c:when test="${medicalAbstractForm.currentPage eq i}">
	                        <li class="active"><a href="#">${i}</a></li>
	                    </c:when>
	                    <c:otherwise>
	                         <li><a href="#" onclick="getPatientForMedicalAbstract(${i},'${medicalAbstractForm.category}');">${i}</a></li>
	                    </c:otherwise>
	                </c:choose>
	            </c:forEach>
	           	<c:if test="${medicalAbstractForm.currentPage lt medicalAbstractForm.noOfPages}">
	               	<li><a href="#" onclick="getPatientForMedicalAbstract(${medicalAbstractForm.currentPage + 1},'${medicalAbstractForm.category}');">&raquo;</a></li>
	            </c:if>

			</ul>
		</div>
	</div>

<!-- 
	<div id="msgDeletedId" align="center">
		<span style="color: blue;"><c:out value="${roomCategoryForm.transactionMessage}"></c:out></span>
	</div> 
	 -->