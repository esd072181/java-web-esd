<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

				<!-- ajax part of table data -->
				<div class="table-responsive" style="padding-left: 10px;">
					<c:choose>
					  <c:when test="${driverTrainingForm.commentList != null}">
						<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%; font-size: xx-small;">  
							<tr>
								<th></th>
								<c:if test="${sessionScope.user_role_session=='Admin'}">
									<th></th>
								</c:if>
								<th>Comment</th>
								<th>By</th>
							</tr>
							<logic:iterate name="driverTrainingForm" property="commentList" type="com.transport.model.DriverTrainingProfileComment" id="model">
								<tr>
									<c:choose>
										<c:when test="${user_session.name==model.empName}">
											<td align="center"><a href="#" onclick="editDriverTrainingProfileComments('${model.id}','${driverTrainingForm.driverTrainingId}','${driverTrainingForm.driverTrainingProfileId}','${driverTrainingForm.remarks}','${driverTrainingForm.driverName}','${driverTrainingForm.innerModule}');">Edit</a></td>
										</c:when>
										<c:otherwise>
											<td align="center">Edit</td>
										</c:otherwise>
									</c:choose>
									<c:if test="${sessionScope.user_role_session=='Admin'}">
										<td align="center"><a href="#" onclick="deleteDriverTrainingProfileComments('${model.id}', '${driverTrainingForm.category}',${driverTrainingForm.currentPage},'${driverTrainingForm.driverTrainingId}','${driverTrainingForm.driverTrainingProfileId}','${driverTrainingForm.remarks}','${driverTrainingForm.driverName}','${driverTrainingForm.innerModule}')">Delete</a></td>
									</c:if>
									<td>${model.remarks}</td>
									<td>${model.empName}</td>
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
								<li><a href="#" onclick="getDriverTrainingProfileComments(${driverTrainingForm.currentPage - 1},'${driverTrainingForm.category}',false,'${driverTrainingForm.driverTrainingId}','${driverTrainingForm.driverTrainingProfileId}','${driverTrainingForm.remarks}','${driverTrainingForm.driverName}','${driverTrainingForm.innerModule}');">Previous</a></li>
							</c:if>
							<c:if test="${driverTrainingForm.currentPage lt driverTrainingForm.noOfPages}">
							  	<li><a href="#" onclick="getDriverTrainingProfileComments(${driverTrainingForm.currentPage + 1},'${driverTrainingForm.category}',false,'${driverTrainingForm.driverTrainingId}','${driverTrainingForm.driverTrainingProfileId}','${driverTrainingForm.remarks}','${driverTrainingForm.driverName}','${driverTrainingForm.innerModule}');">Next</a></li>
							</c:if>
						</ul>
					</div>
					<div style="position: relative; top: -15px; float: right;" >
						<ul class="pagination">
						
							<c:if test="${driverTrainingForm.currentPage != 1 && driverTrainingForm.noOfPages > 0}">
								<li><a href="#" onclick="getDriverTrainingProfileComments(${driverTrainingForm.currentPage - 1},'${driverTrainingForm.category}',false,'${driverTrainingForm.driverTrainingId}','${driverTrainingForm.driverTrainingProfileId}','${driverTrainingForm.remarks}','${driverTrainingForm.driverName}','${driverTrainingForm.innerModule}');">&laquo;</a></li>
							</c:if>
								
							<c:forEach begin="1" end="${driverTrainingForm.noOfPages}" var="i">
				                <c:choose>
				                    <c:when test="${driverTrainingForm.currentPage eq i}">
				                        <li class="active"><a href="#">${i}</a></li>
				                    </c:when>
				                    <c:otherwise>
				                    	 <c:choose>
				                          <c:when test="${driverTrainingForm.currentPage < i && i < driverTrainingForm.currentPage+10}">
				                          		<li><a href="#" onclick="getDriverTrainingProfileComments(${i},'${driverTrainingForm.category}',false,'${driverTrainingForm.driverTrainingId}','${driverTrainingForm.driverTrainingProfileId}','${driverTrainingForm.remarks}','${driverTrainingForm.driverName}','${driverTrainingForm.innerModule}');">${i}</a></li>
				                          </c:when>
				                           <c:otherwise>
				                           		<!-- none -->
				                           </c:otherwise>
				                         </c:choose>
				                    </c:otherwise>
				                </c:choose>
				            </c:forEach>
				           	<c:if test="${driverTrainingForm.currentPage lt driverTrainingForm.noOfPages}">
				               	<li><a href="#" onclick="getDriverTrainingProfileComments(${driverTrainingForm.currentPage + 1},'${driverTrainingForm.category}',false,'${driverTrainingForm.driverTrainingId}','${driverTrainingForm.driverTrainingProfileId}','${driverTrainingForm.remarks}','${driverTrainingForm.driverName}','${driverTrainingForm.innerModule}');">&raquo;</a></li>
				            </c:if>
			
						</ul>
					</div>
				</div>		
					
	

