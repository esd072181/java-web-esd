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
			
			$('#categoryId').val('${monitorDoctorForm.category}');
			$('#currentPageId').val('${monitorDoctorForm.currentPage}');
			</script>
						
						
	<div class="table-responsive" align="left" >
		<c:choose>
		<c:when test="${monitorDoctorForm.modelList != null}">
			<table  id="tableId" class="table table-bordered table-striped table-condensed table-hover context-menu-table" style="width: 98%;">  
				<tr>
					<th></th>
					<th>Name</th>
					<th>Specialization</th>
					<th>Fee</th>
				</tr>
				<logic:iterate name="monitorDoctorForm" property="modelList" type="com.pibs.model.Professional" id="model">
					<tr>				 
						<td align="center"><a href="#" onclick="javascript: goToMonitorDoctorAdd('<bean:write name="model" property="id"/>','${monitorDoctorForm.patientCaseSystemId}');">Select</a></td>
						<td><bean:write name="model" property="fullName"/></td>
						<td><bean:write name="model" property="specialization"/></td>
						<logic:equal name="model" property="standardAdmissionFee" value="0">
							<td></td>
						</logic:equal>
						<logic:notEqual name="model" property="standardAdmissionFee" value="0">
							<td align="right"><bean:write name="model" property="standardAdmissionFee" format="Php #,###.00"/></td>
						</logic:notEqual>
					</tr>
				</logic:iterate>
			</table>
		</c:when>
		<c:otherwise>
		 	<div style="color: blue;">No Record found!</div>
		</c:otherwise>
		</c:choose>
	</div>
	
<!-- 
	<div id="msgDeletedId" align="center">
		<span style="color: blue;"><c:out value="${roomCategoryForm.transactionMessage}"></c:out></span>
	</div> 
	 -->