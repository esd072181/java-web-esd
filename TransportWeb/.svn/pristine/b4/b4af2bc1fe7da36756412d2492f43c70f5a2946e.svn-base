<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

				<!-- ajax part of table data -->
				<div class="table-responsive" style="padding-left: 10px;">
					<c:choose>
					  <c:when test="${driverTrainingForm.profileList != null}">
						<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%; font-size: xx-small;">  
							<tr>
								<th></th>
								<c:if test="${sessionScope.user_role_session=='Admin'}">
									<th></th>
								</c:if>
								<th>VNV</th>
								<th>Incab</th>
								<th>Spotcheck</th>
								<th>Incident</th>
								<th>Notes</th>
								<th>Profile Date</th>
								<th>Status</th>
							</tr>
							<logic:iterate name="driverTrainingForm" property="profileList" type="com.transport.model.DriverTrainingProfile" id="model">
								<tr>
									<td align="center"><a href="#" onclick="editDriverTrainingProfile('${model.id}','${driverTrainingForm.driverName}');">Edit</a></td>
									<c:if test="${sessionScope.user_role_session=='Admin'}">
										<td align="center"><a href="#" onclick="deleteDriverTrainingProfile('${model.id}', '${driverTrainingForm.category}',${driverTrainingForm.currentPage},'${driverTrainingForm.driverTrainingId}','${driverTrainingForm.driverName}')">Delete</a></td>
									</c:if>
									<td><a href="#" onclick="goToDriverTrainingProfileComments('${driverTrainingForm.driverTrainingId}','${model.id}','${model.vnv}','${driverTrainingForm.driverName}','253');"><bean:write name="model" property="vnv"/></a></td>
									<td><a href="#" onclick="goToDriverTrainingProfileComments('${driverTrainingForm.driverTrainingId}','${model.id}','${model.incab}','${driverTrainingForm.driverName}','254');"><bean:write name="model" property="incab"/></a></td>
									<td><a href="#" onclick="goToDriverTrainingProfileComments('${driverTrainingForm.driverTrainingId}','${model.id}','${model.spotcheck}','${driverTrainingForm.driverName}','255');"><bean:write name="model" property="spotcheck"/></a></td>
									<td><a href="#" onclick="goToDriverTrainingProfileComments('${driverTrainingForm.driverTrainingId}','${model.id}','${model.incident}','${driverTrainingForm.driverName}','256');"><bean:write name="model" property="incident"/></a></td>
									<td><bean:write name="model" property="notes"/></td>
									<td align="right"><bean:write name="model" property="profileDate" format='MM/dd/yyyy'/></td>
									<c:choose>
										<c:when test="${model.status == 'Closed'}">
											<td><span style="color: blue;"><bean:write name="model" property="status"/></span></td>	
										</c:when>
										<c:otherwise>
											<td><span style="color: red;"><bean:write name="model" property="status"/></span></td>
										</c:otherwise>
									</c:choose>
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
								<li><a href="#" onclick="getDriverTrainingProfile(${driverTrainingForm.currentPage - 1},'${driverTrainingForm.category}',false,'${driverTrainingForm.driverTrainingId}','${driverTrainingForm.driverName}');">Previous</a></li>
							</c:if>
							<c:if test="${driverTrainingForm.currentPage lt driverTrainingForm.noOfPages}">
							  	<li><a href="#" onclick="getDriverTrainingProfile(${driverTrainingForm.currentPage + 1},'${driverTrainingForm.category}',false,'${driverTrainingForm.driverTrainingId}','${driverTrainingForm.driverName}');">Next</a></li>
							</c:if>
						</ul>
					</div>
					<div style="position: relative; top: -15px; float: right;" >
						<ul class="pagination">
						
							<c:if test="${driverTrainingForm.currentPage != 1 && driverTrainingForm.noOfPages > 0}">
								<li><a href="#" onclick="getDriverTrainingProfile(${driverTrainingForm.currentPage - 1},'${driverTrainingForm.category}',false,'${driverTrainingForm.driverTrainingId}','${driverTrainingForm.driverName}');">&laquo;</a></li>
							</c:if>
								
							<c:forEach begin="1" end="${driverTrainingForm.noOfPages}" var="i">
				                <c:choose>
				                    <c:when test="${driverTrainingForm.currentPage eq i}">
				                        <li class="active"><a href="#">${i}</a></li>
				                    </c:when>
				                    <c:otherwise>
				                    	 <c:choose>
				                          <c:when test="${driverTrainingForm.currentPage < i && i < driverTrainingForm.currentPage+10}">
				                          		<li><a href="#" onclick="getDriverTrainingProfile(${i},'${driverTrainingForm.category}',false,'${driverTrainingForm.driverTrainingId}','${driverTrainingForm.driverName}');">${i}</a></li>
				                          </c:when>
				                           <c:otherwise>
				                           		<!-- none -->
				                           </c:otherwise>
				                         </c:choose>
				                    </c:otherwise>
				                </c:choose>
				            </c:forEach>
				           	<c:if test="${driverTrainingForm.currentPage lt driverTrainingForm.noOfPages}">
				               	<li><a href="#" onclick="getDriverTrainingProfile(${driverTrainingForm.currentPage + 1},'${driverTrainingForm.category}',false,'${driverTrainingForm.driverTrainingId}','${driverTrainingForm.driverName}');">&raquo;</a></li>
				            </c:if>
			
						</ul>
					</div>
				</div>					
					
	

