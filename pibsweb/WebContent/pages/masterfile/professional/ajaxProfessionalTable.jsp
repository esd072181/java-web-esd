<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

	<div class="table-responsive" align="left">
		<c:choose>
		  <c:when test="${professionalForm.modelList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%;">  
				<tr>
					<th>Name</th>
					<th>Type</th>
					<th>Specialization</th>
					<th>Gender</th>
					<th>Birthday </th>
					<th>Date Hired</th>
					<th>License No</th>
					<th>Status</th>
					<th>Consultation Fee</th>
					<th>Admission Fee</th>
					<th></th>
					<c:if test="${sessionScope.user_role_session=='Admin'}">
						<th></th>
					</c:if>
				</tr>
				<logic:iterate name="professionalForm" property="modelList" type="com.pibs.model.Professional" id="model">
					<tr>				 
						<td><bean:write name="model" property="fullName"/></td>
						<td><bean:write name="model" property="professionalType"/></td>
						<td><bean:write name="model" property="specialization"/></td>
						<td><bean:write name="model" property="gender"/></td>
						<td><bean:write name="model" property="birthday"/></td>
						<td><bean:write name="model" property="dateHired"/></td>
						<td><bean:write name="model" property="licenseNo"/></td>
						<td><bean:write name="model" property="status"/></td>
						<logic:equal name="model" property="standardConsultationFee" value="0">
							<td></td>
						</logic:equal>
						<logic:notEqual name="model" property="standardConsultationFee" value="0">
							<td align="right"><bean:write name="model" property="standardConsultationFee" format="Php #,###.00"/></td>
						</logic:notEqual>
						<logic:equal name="model" property="standardAdmissionFee" value="0">
							<td></td>
						</logic:equal>
						<logic:notEqual name="model" property="standardAdmissionFee" value="0">
							<td align="right"><bean:write name="model" property="standardAdmissionFee" format="Php #,###.00"/></td>
						</logic:notEqual>
						<td align="center"><a href="#" onclick="javascript: editProfessional('<bean:write name="model" property="id"/>');">Edit</a></td>
						<td align="center"><a href="#" onclick="javascript: deleteProfessional('<bean:write name="model" property="id"/>', '${professionalForm.category}',${professionalForm.currentPage})">Delete</a></td>
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
				<c:if test="${professionalForm.currentPage != 1 && professionalForm.noOfPages > 0}">
					<li><a href="#" onclick="getProfessional(${professionalForm.currentPage - 1},'${professionalForm.category}');">Previous</a></li>
				</c:if>
				<c:if test="${professionalForm.currentPage lt professionalForm.noOfPages}">
				  	<li><a href="#" onclick="getProfessional(${professionalForm.currentPage + 1},'${professionalForm.category}');">Next</a></li>
				</c:if>
			</ul>
		</div>
		<div style="position: relative; top: -15px; float: right;" >
			<ul class="pagination">
			
				<c:if test="${professionalForm.currentPage != 1 && professionalForm.noOfPages > 0}">
					<li><a href="#" onclick="getProfessional(${professionalForm.currentPage - 1},'${professionalForm.category}');">&laquo;</a></li>
				</c:if>
					
				<c:forEach begin="1" end="${professionalForm.noOfPages}" var="i">
	                <c:choose>
	                    <c:when test="${professionalForm.currentPage eq i}">
	                        <li class="active"><a href="#">${i}</a></li>
	                    </c:when>
	                    <c:otherwise>
	                         <li><a href="#" onclick="getProfessional(${i},'${professionalForm.category}');">${i}</a></li>
	                    </c:otherwise>
	                </c:choose>
	            </c:forEach>
	           	<c:if test="${professionalForm.currentPage lt professionalForm.noOfPages}">
	               	<li><a href="#" onclick="getProfessional(${professionalForm.currentPage + 1},'${professionalForm.category}');">&raquo;</a></li>
	            </c:if>

			</ul>
		</div>
	</div>

<!-- 
	<div id="msgDeletedId" align="center">
		<span style="color: blue;"><c:out value="${roomCategoryForm.transactionMessage}"></c:out></span>
	</div> 
	 -->