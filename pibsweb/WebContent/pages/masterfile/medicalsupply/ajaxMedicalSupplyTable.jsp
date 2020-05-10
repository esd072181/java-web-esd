<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

	<div class="table-responsive" align="left">
		<c:choose>
			<c:when test="${medicalSupplyForm.modelList != null}">
				<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%;">  
					<tr>
						<th>No</th>
						<th>Description</th>
						<th>Generic Name</th>
						<th>Item Code</th>
						<th>Remarks</th>
						<th>Lot No</th>
						<th>Manufactured Date</th>
						<th>Expiration Date</th>
						<th>Type</th>
						<th>Retail Selling Price</th>
						<th></th>
						<c:if test="${sessionScope.user_role_session=='Admin'}">
							<th></th>
						</c:if>
					</tr>
					<logic:iterate name="medicalSupplyForm" property="modelList" type="com.pibs.model.MedicalSupply" id="model" indexId="index">
						<tr>				 
							<td><c:out value="${index+1 + (medicalSupplyForm.currentPage * 10 - 10)}"/></td>
							<td><bean:write name="model" property="description"/></td>
							<td><bean:write name="model" property="genericName"/></td>
							<td><bean:write name="model" property="itemCode"/></td>
							<td><bean:write name="model" property="remarks"/></td>
							<td><bean:write name="model" property="lotNo"/></td>
							<td><bean:write name="model" property="dateManufactured"/></td>
							<td><bean:write name="model" property="expirationDate"/></td>
							<td><bean:write name="model" property="medicalSupplyTypeName"/></td>
							<logic:equal name="model" property="retailSellingPrice" value="0">
								<td></td>	
							</logic:equal>
							<logic:notEqual name="model" property="retailSellingPrice" value="0">
								<td align="right"><bean:write name="model" property="retailSellingPrice" format="Php #,###.00"/></td>
							</logic:notEqual>							
							<td align="center"><a href="#" onclick="javascript: editMedicalSupply('<bean:write name="model" property="id"/>');">Edit</a></td>
							<td align="center"><a href="#" onclick="javascript: deleteMedicalSupply('<bean:write name="model" property="id"/>', '${medicalSupplyForm.category}',${medicalSupplyForm.currentPage})">Delete</a></td>
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
				<c:if test="${medicalSupplyForm.currentPage != 1 && medicalSupplyForm.noOfPages > 0}">
					<li><a href="#" onclick="getMedicalSupply(${medicalSupplyForm.currentPage - 1},'${medicalSupplyForm.category}');">Previous</a></li>
				</c:if>
				<c:if test="${medicalSupplyForm.currentPage lt medicalSupplyForm.noOfPages}">
				  	<li><a href="#" onclick="getMedicalSupply(${medicalSupplyForm.currentPage + 1},'${medicalSupplyForm.category}');">Next</a></li>
				</c:if>
			</ul>
		</div>
		<div style="position: relative; top: -15px; float: right;" >
			<ul class="pagination">
			
				<c:if test="${medicalSupplyForm.currentPage != 1 && medicalSupplyForm.noOfPages > 0}">
					<li><a href="#" onclick="getMedicalSupply(${medicalSupplyForm.currentPage - 1},'${medicalSupplyForm.category}');">&laquo;</a></li>
				</c:if>
				
				<!-- pagination limit to 10 -->
				<c:choose>
					<c:when test="${medicalSupplyForm.currentPage lt medicalSupplyForm.noOfPages && medicalSupplyForm.noOfPages > 10}">
						<c:forEach begin="${medicalSupplyForm.currentPage}" end="${medicalSupplyForm.currentPage+9}" var="i">
							 <c:choose>
			                    <c:when test="${medicalSupplyForm.currentPage eq i}">
			                        <li class="active"><a href="#">${i}</a></li>
			                    </c:when>
			                    <c:otherwise>
			                         <li><a href="#" onclick="getMedicalSupply(${i},'${medicalSupplyForm.category}');">${i}</a></li>
			                    </c:otherwise>
			                </c:choose>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<c:forEach begin="1" end="${medicalSupplyForm.noOfPages}" var="i">
			                <c:choose>
			                    <c:when test="${medicalSupplyForm.currentPage eq i}">
			                        <li class="active"><a href="#">${i}</a></li>
			                    </c:when>
			                    <c:otherwise>
			                         <li><a href="#" onclick="getMedicalSupply(${i},'${medicalSupplyForm.category}');">${i}</a></li>
			                    </c:otherwise>
			                </c:choose>
			            </c:forEach>
					</c:otherwise>
				</c:choose>	
					
	           	<c:if test="${medicalSupplyForm.currentPage lt medicalSupplyForm.noOfPages}">
	               	<li><a href="#" onclick="getMedicalSupply(${medicalSupplyForm.currentPage + 1},'${medicalSupplyForm.category}');">&raquo;</a></li>
	            </c:if>

			</ul>
		</div>
	</div>

<!-- 
	<div id="msgDeletedId" align="center">
		<span style="color: blue;"><c:out value="${roomCategoryForm.transactionMessage}"></c:out></span>
	</div> 
	 -->