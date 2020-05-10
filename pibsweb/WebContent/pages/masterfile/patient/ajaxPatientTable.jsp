<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

			<script>
			
		    /*$.contextMenu({
		        selector: '.context-menu-table', 
		        callback: function(key, options) {
		        	
		        	if ($('#selectedId').val()=='') {
		        		alert('select the row!');
		        		return;
		        	}
		        	
		            if (key == 'edit') {
		            	editPatient($('#selectedId').val());
		            } else if (key == 'delete'){
		            	deletePatient($('#selectedId').val(), $('#categoryId').val(), $('#currentPageId').val());
		            }
		        },
		        items: {
		            //"edit": {name: "Edit", icon: "edit"},
		            "edit": {name: "Edit"},//remove icon
		            "sep1": "---------",
		            "delete": {name: "Delete"}
		        }
		    });*/
		    
			$("#tableId tr").mouseover(function(){ 
				$('#selectedId').val( $(this).find(".classId").html());
			});
			
			$('#categoryId').val('${patientForm.category}');
			$('#currentPageId').val('${patientForm.currentPage}');
			</script>
						
						
	<div class="table-responsive" align="left" >
		<c:choose>
		<c:when test="${patientForm.modelList != null}">
			<table  id="tableId" class="table table-bordered table-striped table-condensed table-hover context-menu-table" style="width: 98%;">  
				<tr>
					<th>No</th>
					<th>Name</th>
					<th>Gender</th>
					<th>Birthday</th>
					<th>Contact No</th>
					<th>Address</th>
					<th>Contact Person</th>
					<th>Contact Person No</th>
					<th>Date Registered</th>
					<th>Status</th>
					<th>Patient Id</th>
					<th></th>
					<c:if test="${sessionScope.user_role_session=='Admin'}">
						<th></th>
					</c:if>
				</tr>
				<logic:iterate name="patientForm" property="modelList" type="com.pibs.model.Patient" id="model" indexId="index">
					<tr>				 
						<td><c:out value="${index+1 + (patientForm.currentPage * 10 - 10)}"/></td>
						<td><bean:write name="model" property="fullName"/></td>
						<td><bean:write name="model" property="gender"/></td>
						<td><bean:write name="model" property="birthdayStr"/></td>
						<td><bean:write name="model" property="contactNo"/></td>
						<td><bean:write name="model" property="address"/></td>
						<td><bean:write name="model" property="contactPerson"/></td>
						<td><bean:write name="model" property="contactPersonNo"/></td>
						<td><bean:write name="model" property="dateRegistered"/></td>
						<td><bean:write name="model" property="status"/></td>
						<td><bean:write name="model" property="patientId"/></td>
						<td align="center"><a href="#" onclick="javascript: editPatient('<bean:write name="model" property="id"/>');">Edit</a></td>
						<c:if test="${sessionScope.user_role_session=='Admin'}">
							<td align="center"><a href="#" onclick="javascript: deletePatient('<bean:write name="model" property="id"/>', '${patientForm.category}',${patientForm.currentPage})">Delete</a></td>
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
				<c:if test="${patientForm.currentPage != 1 && patientForm.noOfPages > 0}">
					<li><a href="#" onclick="getPatient(${patientForm.currentPage - 1},'${patientForm.category}');">Previous</a></li>
				</c:if>
				<c:if test="${patientForm.currentPage lt patientForm.noOfPages}">
				  	<li><a href="#" onclick="getPatient(${patientForm.currentPage + 1},'${patientForm.category}');">Next</a></li>
				</c:if>
			</ul>
		</div>
		<div style="position: relative; top: -15px; float: right;" >
			<ul class="pagination">
			
				<c:if test="${patientForm.currentPage != 1 && patientForm.noOfPages > 0}">
					<li><a href="#" onclick="getPatient(${patientForm.currentPage - 1},'${patientForm.category}');">&laquo;</a></li>
				</c:if>
				
				<!-- pagination limit to 10 -->
				<c:choose>
					<c:when test="${patientForm.currentPage lt patientForm.noOfPages && patientForm.noOfPages > 10}">
						<c:forEach begin="${patientForm.currentPage}" end="${patientForm.currentPage+9}" var="i">
							 <c:choose>
			                    <c:when test="${patientForm.currentPage eq i}">
			                        <li class="active"><a href="#">${i}</a></li>
			                    </c:when>
			                    <c:otherwise>
			                         <li><a href="#" onclick="getPatient(${i},'${patientForm.category}');">${i}</a></li>
			                    </c:otherwise>
			                </c:choose>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<c:forEach begin="1" end="${patientForm.noOfPages}" var="i">
			                <c:choose>
			                    <c:when test="${patientForm.currentPage eq i}">
			                        <li class="active"><a href="#">${i}</a></li>
			                    </c:when>
			                    <c:otherwise>
			                         <li><a href="#" onclick="getPatient(${i},'${patientForm.category}');">${i}</a></li>
			                    </c:otherwise>
			                </c:choose>
			            </c:forEach>
					</c:otherwise>
				</c:choose>	
					
	           	<c:if test="${patientForm.currentPage lt patientForm.noOfPages}">
	               	<li><a href="#" onclick="getPatient(${patientForm.currentPage + 1},'${patientForm.category}');">&raquo;</a></li>
	            </c:if>

			</ul>
		</div>
	</div>

<!-- 
	<div id="msgDeletedId" align="center">
		<span style="color: blue;"><c:out value="${roomCategoryForm.transactionMessage}"></c:out></span>
	</div> 
	 -->