<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

	<div class="table-responsive" align="left">
		<c:choose>
		<c:when test="${roomForm.modelList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%;">  
				<tr>
					<th>No</th>
					<th>Room No</th>
					<th>Room Category</th>
					<th>Building</th>
					<th>Floor No</th>
					<th>No of Beds</th>
					<th>Available Beds</th>
					<th>Description</th>
					<th>Rate</th>
					<th></th>
					<c:if test="${sessionScope.user_role_session=='Admin'}">
						<th></th>
					</c:if>
				</tr>
				<logic:iterate name="roomForm" property="modelList" type="com.pibs.model.Room" id="model" indexId="index">
					<tr>				 
						<td><c:out value="${index+1 + (roomForm.currentPage * 10 - 10)}"/></td>
						<td><bean:write name="model" property="roomNo"/></td>
						<td><bean:write name="model" property="roomCategory"/></td>
						<td><bean:write name="model" property="building"/></td>
						<td><bean:write name="model" property="floorNo"/></td>
						<td><bean:write name="model" property="noOfBeds"/></td>
						<td><bean:write name="model" property="availableBeds"/></td>
						<td><bean:write name="model" property="description"/></td>
						<td align="right"><bean:write name="model" property="rate" format="Php #,###.00"/></td>
						<td align="center"><a href="#" onclick="javascript: editRoom('<bean:write name="model" property="id"/>','<bean:write name="model" property="buildingId"/>');">Edit</a></td>
						<c:if test="${sessionScope.user_role_session=='Admin'}">
							<td align="center"><a href="#" onclick="javascript: deleteRoom('<bean:write name="model" property="id"/>', '${roomForm.category}',${roomForm.currentPage})">Delete</a></td>
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
				<c:if test="${roomForm.currentPage != 1 && roomForm.noOfPages > 0}">
					<li><a href="#" onclick="getRoomCategory(${roomForm.currentPage - 1},'${roomForm.category}');">Previous</a></li>
				</c:if>
				<c:if test="${roomForm.currentPage lt roomForm.noOfPages}">
				  	<li><a href="#" onclick="getRoomCategory(${roomForm.currentPage + 1},'${roomForm.category}');">Next</a></li>
				</c:if>
			</ul>
		</div>
		<div style="position: relative; top: -15px; float: right;" >
			<ul class="pagination">
			
				<c:if test="${roomForm.currentPage != 1 && roomForm.noOfPages > 0}">
					<li><a href="#" onclick="getRoom(${roomForm.currentPage - 1},'${roomForm.category}');">&laquo;</a></li>
				</c:if>
				
				<!-- pagination limit to 10 -->
				<c:choose>
					<c:when test="${roomForm.currentPage lt roomForm.noOfPages && roomForm.noOfPages > 10}">
						<c:forEach begin="${roomForm.currentPage}" end="${roomForm.currentPage+9}" var="i">
							  <c:choose>
			                    <c:when test="${roomForm.currentPage eq i}">
			                        <li class="active"><a href="#">${i}</a></li>
			                    </c:when>
			                    <c:otherwise>
			                         <li><a href="#" onclick="getRoom(${i},'${roomForm.category}');">${i}</a></li>
			                    </c:otherwise>
			                </c:choose>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<c:forEach begin="1" end="${roomForm.noOfPages}" var="i">
			                <c:choose>
			                    <c:when test="${roomForm.currentPage eq i}">
			                        <li class="active"><a href="#">${i}</a></li>
			                    </c:when>
			                    <c:otherwise>
			                         <li><a href="#" onclick="getRoom(${i},'${roomForm.category}');">${i}</a></li>
			                    </c:otherwise>
			                </c:choose>
			            </c:forEach>
					</c:otherwise>
				</c:choose>	
					
	           	<c:if test="${roomForm.currentPage lt roomForm.noOfPages}">
	               	<li><a href="#" onclick="getRoom(${roomForm.currentPage + 1},'${roomForm.category}');">&raquo;</a></li>
	            </c:if>

			</ul>
		</div>
	</div>
