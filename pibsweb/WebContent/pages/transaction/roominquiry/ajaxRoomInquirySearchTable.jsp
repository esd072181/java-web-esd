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
			
	$('#currentPageId').val('${roomInquiryForm.currentPage}');
</script>
						
						
	<div class="table-responsive" align="left" >
		<c:choose>
		<c:when test="${roomInquiryForm.modelList != null}">
			<table  id="tableId" class="table table-bordered table-striped table-condensed table-hover context-menu-table" style="width: 98%;">  
				<tr>
					<th>No</th>
					<th>Room No</th>
					<th>Category</th>
					<th>Rate</th>
					<th>No of Beds</th>
					<th>Available Beds</th>
					<th>Building</th>
					<th>Floor No</th>
				</tr>
				<logic:iterate name="roomInquiryForm" property="modelList" type="com.pibs.model.Room" id="model" indexId="index">
					<tr>				 
						<td><c:out value="${index+1 + (roomInquiryForm.currentPage * 10 - 10)}"/></td>
						<td><bean:write name="model" property="roomNo"/></td>
						<td><bean:write name="model" property="roomCategory"/></td>
						<td><bean:write name="model" property="rate"/></td>
						<td><bean:write name="model" property="noOfBeds"/></td>
						<td><bean:write name="model" property="availableBeds"/></td>
						<td><bean:write name="model" property="building"/></td>
						<td><bean:write name="model" property="floorNo"/></td>
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
				<c:if test="${roomInquiryForm.currentPage != 1 && roomInquiryForm.noOfPages > 0}">
					<li><a href="#" onclick="getRoomForRoomInquiry(${roomInquiryForm.currentPage - 1},'${roomInquiryForm.category}');">Previous</a></li>
				</c:if>
				<c:if test="${roomInquiryForm.currentPage lt roomInquiryForm.noOfPages}">
				  	<li><a href="#" onclick="getRoomForRoomInquiry(${roomInquiryForm.currentPage + 1},'${roomInquiryForm.category}');">Next</a></li>
				</c:if>
			</ul>
		</div>
		<div style="position: relative; top: -15px; float: right;" >
			<ul class="pagination">
			
				<c:if test="${roomInquiryForm.currentPage != 1 && roomInquiryForm.noOfPages > 0}">
					<li><a href="#" onclick="getRoomForRoomInquiry(${roomInquiryForm.currentPage - 1},'${roomInquiryForm.category}');">&laquo;</a></li>
				</c:if>
				
				<!-- pagination limit to 10 -->
				<c:choose>
					<c:when test="${roomInquiryForm.currentPage lt roomInquiryForm.noOfPages && roomInquiryForm.noOfPages > 10}">
						<c:forEach begin="${roomInquiryForm.currentPage}" end="${roomInquiryForm.currentPage+9}" var="i">
							 <c:choose>
			                    <c:when test="${roomInquiryForm.currentPage eq i}">
			                        <li class="active"><a href="#">${i}</a></li>
			                    </c:when>
			                    <c:otherwise>
			                         <li><a href="#" onclick="getRoomForRoomInquiry(${i},'${roomInquiryForm.category}');">${i}</a></li>
			                    </c:otherwise>
			                </c:choose>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<c:forEach begin="1" end="${roomInquiryForm.noOfPages}" var="i">
			                <c:choose>
			                    <c:when test="${roomInquiryForm.currentPage eq i}">
			                        <li class="active"><a href="#">${i}</a></li>
			                    </c:when>
			                    <c:otherwise>
			                         <li><a href="#" onclick="getRoomForRoomInquiry(${i},'${roomInquiryForm.category}');">${i}</a></li>
			                    </c:otherwise>
			                </c:choose>
			            </c:forEach>
					</c:otherwise>
				</c:choose>	
					
	           	<c:if test="${roomInquiryForm.currentPage lt roomInquiryForm.noOfPages}">
	               	<li><a href="#" onclick="getRoomForRoomInquiry(${roomInquiryForm.currentPage + 1},'${roomInquiryForm.category}');">&raquo;</a></li>
	            </c:if>

			</ul>
		</div>
	</div>

<!-- 
	<div id="msgDeletedId" align="center">
		<span style="color: blue;"><c:out value="${roomCategoryForm.transactionMessage}"></c:out></span>
	</div> 
	 -->