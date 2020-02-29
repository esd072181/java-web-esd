<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

				<!-- ajax part of table data -->
				<div class="table-responsive" style="padding-left: 10px;">
					<c:choose>
					  <c:when test="${driverTrainingForm.trainingList != null}">
						<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%; font-size: xx-small;">  
							<tr>
								<th></th>
								<c:if test="${sessionScope.user_role_session=='Admin'}">
									<th></th>
								</c:if>
								<th>Training</th>
								<th>Expiry Date</th>
							</tr>
							<logic:iterate name="driverTrainingForm" property="trainingList" type="com.transport.model.DriverTrainingInfo" id="model">
								<tr>				 
									<td align="center"><a href="#" onclick="editDriverTrainingInfo('${model.id}','${driverTrainingForm.driverName}');">Edit</a></td>
									<c:if test="${sessionScope.user_role_session=='Admin'}">
										<td align="center"><a href="#" onclick="deleteDriverTrainingInfo('<bean:write name="model" property="id"/>', '${driverTrainingForm.category}',${driverTrainingForm.currentPage},'${driverTrainingForm.driverName}')">Delete</a></td>
									</c:if>
									<td><bean:write name="model" property="training"/></td>
									<td align="right"><bean:write name="model" property="expiryDate" format='MM/dd/yyyy'/></td>
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
								<li><a href="#" onclick="getDriverTrainingInfo(${driverTrainingForm.currentPage - 1},'${driverTrainingForm.category}');">Previous</a></li>
							</c:if>
							<c:if test="${driverTrainingForm.currentPage lt driverTrainingForm.noOfPages}">
							  	<li><a href="#" onclick="getDriverTrainingInfo(${driverTrainingForm.currentPage + 1},'${driverTrainingForm.category}');">Next</a></li>
							</c:if>
						</ul>
					</div>
					<div style="position: relative; top: -15px; float: right;" >
						<ul class="pagination">
						
							<c:if test="${driverTrainingForm.currentPage != 1 && driverTrainingForm.noOfPages > 0}">
								<li><a href="#" onclick="getDriverTrainingInfo(${driverTrainingForm.currentPage - 1},'${driverTrainingForm.category}');">&laquo;</a></li>
							</c:if>
								
							<c:forEach begin="1" end="${driverTrainingForm.noOfPages}" var="i">
				                <c:choose>
				                    <c:when test="${driverTrainingForm.currentPage eq i}">
				                        <li class="active"><a href="#">${i}</a></li>
				                    </c:when>
				                    <c:otherwise>
				                    	 <c:choose>
				                          <c:when test="${driverTrainingForm.currentPage < i && i < driverTrainingForm.currentPage+10}">
				                          		<li><a href="#" onclick="getDriverTrainingInfo(${i},'${driverTrainingForm.category}');">${i}</a></li>
				                          </c:when>
				                           <c:otherwise>
				                           		<!-- none -->
				                           </c:otherwise>
				                         </c:choose>
				                    </c:otherwise>
				                </c:choose>
				            </c:forEach>
				           	<c:if test="${driverTrainingForm.currentPage lt driverTrainingForm.noOfPages}">
				               	<li><a href="#" onclick="getDriverTrainingInfo(${driverTrainingForm.currentPage + 1},'${driverTrainingForm.category}');">&raquo;</a></li>
				            </c:if>
			
						</ul>
					</div>
				</div>				
					
	

