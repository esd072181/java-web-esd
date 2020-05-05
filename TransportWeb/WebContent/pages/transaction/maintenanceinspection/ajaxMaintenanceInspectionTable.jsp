<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

	<div class="table-responsive" style="padding-left: 10px;">
		<c:choose>
		  <c:when test="${maintenanceInspectionForm.modelList != null}">
		  
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%; font-size: xx-small;">  
				<tr>
					<th></th>
					<th></th>
					<c:if test="${sessionScope.user_role_session=='Admin'}">
						<th></th>
					</c:if>
					<th>No</th>
					<th>InspectionDate</th>
					<th>LorryNo</th>
					<th>PlateNo</th>
					<th>Odometer</th>
					<th>HubOdometer</th>
					<th>Inspectors</th>
					<th>ForAnnual</th>
					<th>ForPM</th>
					<th>Remarks</th>
				</tr>
				<logic:iterate name="maintenanceInspectionForm" property="modelList" type="com.transport.model.InspectionHeader" id="model" indexId="index">
					<tr>
						<td align="center"><a href="#" onclick="viewMaintenanceInspectionReport('<bean:write name="model" property="id"/>');">View</a></td>				 
						<td align="center"><a href="#" onclick="editMaintenanceInspection('<bean:write name="model" property="id"/>');">Edit</a></td>
						<c:if test="${sessionScope.user_role_session=='Admin'}">
							<td align="center"><a href="#" onclick="deleteMaintenanceInspection('<bean:write name="model" property="id"/>', '${maintenanceInspectionForm.category}',${maintenanceInspectionForm.currentPage})">Delete</a></td>
						</c:if>	
						<td><c:out value="${index+1 + (maintenanceInspectionForm.currentPage * 10 - 10)}"/></td>
						<td><bean:write name="model" property="inspectionDate" format='MM/dd/yyyy'/></td>
						<td><bean:write name="model" property="lorryNo"/></td>
						<td><bean:write name="model" property="plateNo"/></td>
						<td><bean:write name="model" property="odometer"/></td>
						<td><bean:write name="model" property="hubOdometer"/></td>	
						<td><bean:write name="model" property="inspectors"/></td>
						<td><bean:write name="model" property="forAnnual"/></td>
						<td><bean:write name="model" property="forPm"/></td>	
						<td><bean:write name="model" property="remarks"/></td>
					</tr>
				</logic:iterate>
			</table>
		  </c:when>
		  <c:otherwise>
		  	<div style="color: blue;">No Record found!</div>
		  </c:otherwise>
		</c:choose>
	</div>
	
	<div style="height: 50px; width: 98%; padding-left: 10px;">
		<div style="position: relative; top: -15px; float: left;">
			<ul class="pager">
				<c:if test="${maintenanceInspectionForm.currentPage != 1 && maintenanceInspectionForm.noOfPages > 0}">
					<li><a href="#" onclick="getMaintenanceInspection(${maintenanceInspectionForm.currentPage - 1},'${maintenanceInspectionForm.category}');">Previous</a></li>
				</c:if>
				<c:if test="${maintenanceInspectionForm.currentPage lt maintenanceInspectionForm.noOfPages}">
				  	<li><a href="#" onclick="getMaintenanceInspection(${maintenanceInspectionForm.currentPage + 1},'${maintenanceInspectionForm.category}');">Next</a></li>
				</c:if>
			</ul>
		</div>
		<div style="position: relative; top: -15px; float: right;" >
			<ul class="pagination">
			
				<c:if test="${maintenanceInspectionForm.currentPage != 1 && maintenanceInspectionForm.noOfPages > 0}">
					<li><a href="#" onclick="getMaintenanceInspection(${maintenanceInspectionForm.currentPage - 1},'${maintenanceInspectionForm.category}');">&laquo;</a></li>
				</c:if>
				
				<!-- pagination limit to 10 -->
				<c:choose>
					<c:when test="${maintenanceInspectionForm.currentPage lt maintenanceInspectionForm.noOfPages && maintenanceInspectionForm.noOfPages > 10}">
						<c:forEach begin="${maintenanceInspectionForm.currentPage}" end="${maintenanceInspectionForm.currentPage+9}" var="i">
							<c:choose>
			                    <c:when test="${maintenanceInspectionForm.currentPage eq i}">
			                        <li class="active"><a href="#">${i}</a></li>
			                    </c:when>
			                    <c:otherwise>
			                        <li><a href="#" onclick="getMaintenanceInspection(${i},'${maintenanceInspectionForm.category}');">${i}</a></li>
			                    </c:otherwise>
			                </c:choose>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<c:forEach begin="1" end="${maintenanceInspectionForm.noOfPages}" var="i">
			                <c:choose>
			                    <c:when test="${maintenanceInspectionForm.currentPage eq i}">
			                        <li class="active"><a href="#">${i}</a></li>
			                    </c:when>
			                    <c:otherwise>
			                        <li><a href="#" onclick="getMaintenanceInspection(${i},'${maintenanceInspectionForm.category}');">${i}</a></li>
			                    </c:otherwise>
			                </c:choose>
			            </c:forEach>
					</c:otherwise>
				</c:choose>	
				
	           	<c:if test="${maintenanceInspectionForm.currentPage lt maintenanceInspectionForm.noOfPages}">
	               	<li><a href="#" onclick="getMaintenanceInspection(${maintenanceInspectionForm.currentPage + 1},'${maintenanceInspectionForm.category}');">&raquo;</a></li>
	            </c:if>

			</ul>
		</div>
	</div>

