<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

	<div class="table-responsive" style="padding-left: 10px;">
		<c:choose>
		  <c:when test="${driverTrainingForm.modelList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%; font-size: xx-small;">  
				<tr>
					<th>No</th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<c:if test="${sessionScope.user_role_session=='Admin'}">
						<th></th>
					</c:if>
					<th>Full Name</th>
					<th>Picture</th>
					<th>Date Hired</th>
					<th>License No</th>
					<th>Validity</th>
					<th>Birthday</th>
					<th>Age</th>
					<th>SSS No</th>
					<th>Philhealth No</th>
					<th>Pagibig No</th>
					<th>TIN</th>
					<th>FTW</th>
					<th>NBI</th>
					<th>Terminal</th>
					<th>Articulated</th>
				</tr>
				<logic:iterate name="driverTrainingForm" property="modelList" type="com.transport.model.DriverTraining" id="model" indexId="index">
					<tr>	
						<td><c:out value="${index+1 + (driverTrainingForm.currentPage * 10 - 10)}"/></td>
						<td align="center"><a href="#" onclick="goToDriverTrainingInfo('<bean:write name="model" property="id"/>','<bean:write name="model" property="fullName"/>');">Driver Training</a></td>
						<td align="center"><a href="#" onclick="goToDriverTrainingProfile('<bean:write name="model" property="id"/>','<bean:write name="model" property="fullName"/>');">Driver Profile</a></td>	
						<td align="center"><a href="#" onclick="viewDriverTrainingSummary('<bean:write name="model" property="id"/>','<bean:write name="model" property="fullName"/>');">View Summary</a></td>			 
						<td align="center"><a href="#" onclick="editDriverTraining('<bean:write name="model" property="id"/>');">Edit Driver Info</a></td>
						<c:if test="${sessionScope.user_role_session=='Admin'}">
							<td align="center"><a href="#" onclick="deleteDriverTraining('<bean:write name="model" property="id"/>', '${driverTrainingForm.category}',${driverTrainingForm.currentPage},'${driverTrainingForm.driverName}')">Delete</a></td>
						</c:if>
						<td><span style="font-weight: bold;"><bean:write name="model" property="fullName"/></span></td>
						<td align="center"><html:image src="data:image/jpeg;base64,${model.picStr}" alt="" style="width: 50px; height: 60px; pointer-events: none;"></html:image></td>
						<td align="right"><bean:write name="model" property="dateHired" format='MM/dd/yyyy'/></td>
						<td align="right"><bean:write name="model" property="licenseNo" /></td>
						<td align="right"><bean:write name="model" property="licenseValidity" format='MM/dd/yyyy'/></td>
						<td align="right"><bean:write name="model" property="birthday" format='MM/dd/yyyy'/></td>
						<c:choose>
							<c:when test="${model.age > 0}">
								<td align="right"><bean:write name="model" property="age"/></td>	
							</c:when>
							<c:otherwise>
							    <td></td>
							</c:otherwise>
						</c:choose>
						<td align="right"><bean:write name="model" property="sss" /></td>
						<td align="right"><bean:write name="model" property="philhealthNo" /></td>
						<td align="right"><bean:write name="model" property="pagibig" /></td>
						<td align="right"><bean:write name="model" property="tin" /></td>
						<td align="right"><bean:write name="model" property="ftw" format='MM/dd/yyyy'/></td>
						<td align="right"><bean:write name="model" property="nbi" format='MM/dd/yyyy'/></td>
						<td><bean:write name="model" property="terminalName"/></td>	
						<td><bean:write name="model" property="articulated"/></td>
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
				<c:if test="${driverTrainingForm.currentPage != 1 && driverTrainingForm.noOfPages > 0}">
					<li><a href="#" onclick="getDriverTraining(${driverTrainingForm.currentPage - 1},'${driverTrainingForm.category}');">Previous</a></li>
				</c:if>
				<c:if test="${driverTrainingForm.currentPage lt driverTrainingForm.noOfPages}">
				  	<li><a href="#" onclick="getDriverTraining(${driverTrainingForm.currentPage + 1},'${driverTrainingForm.category}');">Next</a></li>
				</c:if>
			</ul>
		</div>
		<div style="position: relative; top: -15px; float: right;" >
			<ul class="pagination">
			
				<c:if test="${driverTrainingForm.currentPage != 1 && driverTrainingForm.noOfPages > 0}">
					<li><a href="#" onclick="getDriverTraining(${driverTrainingForm.currentPage - 1},'${driverTrainingForm.category}');">&laquo;</a></li>
				</c:if>
					
				<!-- pagination limit to 10 -->
				<c:choose>
					<c:when test="${driverTrainingForm.currentPage lt driverTrainingForm.noOfPages && driverTrainingForm.noOfPages > 10}">
						<c:forEach begin="${driverTrainingForm.currentPage}" end="${driverTrainingForm.currentPage+9}" var="i">
							<c:choose>
			                    <c:when test="${driverTrainingForm.currentPage eq i}">
			                        <li class="active"><a href="#">${i}</a></li>
			                    </c:when>
			                    <c:otherwise>
			                          <li><a href="#" onclick="getDriverTraining(${i},'${driverTrainingForm.category}');">${i}</a></li>
			                    </c:otherwise>
			                </c:choose>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<c:forEach begin="1" end="${driverTrainingForm.noOfPages}" var="i">
			                <c:choose>
			                    <c:when test="${driverTrainingForm.currentPage eq i}">
			                        <li class="active"><a href="#">${i}</a></li>
			                    </c:when>
			                    <c:otherwise>
			                          <li><a href="#" onclick="getDriverTraining(${i},'${driverTrainingForm.category}');">${i}</a></li>
			                    </c:otherwise>
			                </c:choose>
			            </c:forEach>
					</c:otherwise>
				</c:choose>			
				
	           	<c:if test="${driverTrainingForm.currentPage lt driverTrainingForm.noOfPages}">
	               	<li><a href="#" onclick="getDriverTraining(${driverTrainingForm.currentPage + 1},'${driverTrainingForm.category}');">&raquo;</a></li>
	            </c:if>

			</ul>
		</div>
	</div>
	
	

