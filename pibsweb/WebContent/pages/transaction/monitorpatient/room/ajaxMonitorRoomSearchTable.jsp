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
			
			$('#categoryId').val('${monitorRoomForm.category}');
			$('#currentPageId').val('${monitorRoomForm.currentPage}');
			</script>
						
						
	<div class="table-responsive" align="left" >
		<c:choose>
		<c:when test="${monitorRoomForm.modelList != null}">
			<table  id="tableId" class="table table-bordered table-striped table-condensed table-hover context-menu-table" style="width: 98%;">  
				<tr>
					<th></th>
					<th>RoomNo</th>
					<th>Category</th>
					<th>Fee</th>
				</tr>
				<logic:iterate name="monitorRoomForm" property="modelList" type="com.pibs.model.Room" id="model">
					<tr>				 
						<td align="center"><a href="#" onclick="javascript: goToMonitorRoomAdd('<bean:write name="model" property="id"/>','${monitorRoomForm.patientCaseSystemId}');">Select</a></td>
						<td><bean:write name="model" property="roomNo"/></td>
						<td><bean:write name="model" property="roomCategory"/></td>
						<logic:equal name="model" property="rate" value="0">
							<td></td>
						</logic:equal>
						<logic:notEqual name="model" property="rate" value="0">
							<td align="right"><bean:write name="model" property="rate" format="Php #,###.00"/></td>
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