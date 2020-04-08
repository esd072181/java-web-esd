<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

	<div class="table-responsive" >
		<c:choose>
		  <c:when test="${tireForm.modelList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%; font-size: x-small;">  
				<tr>
					<th>No</th>
					<th>Brand</th>
					<th>Serial No</th>
					<th>Recap No</th>
					<th>Size and Ply</th>
					<th>Price(Php)</th>
					<th>Date Purchased</th>
					<th>Date Purchased For Recap 1</th>
					<th>Date Purchased For Recap 2</th>
					<th>Invoice No</th>
					<th>Analysis</th>
					<th>Comments</th>
					<th>Retired</th>
					<th>Date Retired</th>
					<th>Lorry No</th>
					<th></th>
					<c:if test="${sessionScope.user_role_session=='Admin'}">
						<th></th>
					</c:if>
				</tr>
				<logic:iterate name="tireForm" property="modelList" type="com.transport.model.Tire" id="model" indexId="index">
					<tr>				 
						<td><c:out value="${index+1}"/></td>
						<td><bean:write name="model" property="brandName"/></td>
						<td><a href="#" onclick="editTire('<bean:write name="model" property="id"/>');"><bean:write name="model" property="serialNo"/></a></td>
						<td><bean:write name="model" property="recapNo"/></td>
						<td><bean:write name="model" property="sizeAndPly"/></td>
						<td><bean:write name="model" property="price"/></td>
						<td><bean:write name="model" property="datePurchased"/></td>
						<td><bean:write name="model" property="datePurchasedForRecap1"/></td>
						<td><bean:write name="model" property="datePurchasedForRecap2"/></td>
						<td><bean:write name="model" property="invoiceNo"/></td>
						<td><bean:write name="model" property="analysis"/></td>
						<td><bean:write name="model" property="comments"/></td>
						<td><bean:write name="model" property="retired"/></td>
						<td><bean:write name="model" property="dateRetired"/></td>
						<td><bean:write name="model" property="lorryNo"/></td>
						<td align="center"><a href="#" onclick="editTire('<bean:write name="model" property="id"/>');">Edit</a></td>
						<c:if test="${sessionScope.user_role_session=='Admin'}">
							<td align="center"><a href="#" onclick="deleteTire('<bean:write name="model" property="id"/>', '${tireForm.category}',${tireForm.currentPage})">Delete</a></td>
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
				<c:if test="${tireForm.currentPage != 1 && tireForm.noOfPages > 0}">
					<li><a href="#" onclick="getTire(${tireForm.currentPage - 1},'${tireForm.category}');">Previous</a></li>
				</c:if>
				<c:if test="${tireForm.currentPage lt tireForm.noOfPages}">
				  	<li><a href="#" onclick="getTire(${tireForm.currentPage + 1},'${tireForm.category}');">Next</a></li>
				</c:if>
			</ul>
		</div>
		<div style="position: relative; top: -15px; float: right;" >
			<ul class="pagination">
			
				<c:if test="${tireForm.currentPage != 1 && tireForm.noOfPages > 0}">
					<li><a href="#" onclick="getTire(${tireForm.currentPage - 1},'${tireForm.category}');">&laquo;</a></li>
				</c:if>
					
				<c:forEach begin="1" end="${tireForm.noOfPages}" var="i">
	                <c:choose>
	                    <c:when test="${tireForm.currentPage eq i}">
	                        <li class="active"><a href="#">${i}</a></li>
	                    </c:when>
	                    <c:otherwise>
	                         <li><a href="#" onclick="getTire(${i},'${tireForm.category}');">${i}</a></li>
	                    </c:otherwise>
	                </c:choose>
	            </c:forEach>
	           	<c:if test="${tireForm.currentPage lt tireForm.noOfPages}">
	               	<li><a href="#" onclick="getTire(${tireForm.currentPage + 1},'${tireForm.category}');">&raquo;</a></li>
	            </c:if>

			</ul>
		</div>
	</div>

<!-- 
	<div id="msgDeletedId" align="center">
		<span style="color: blue;"><c:out value="${roomCategoryForm.transactionMessage}"></c:out></span>
	</div> 
	 -->