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
					<th>SerialNo</th>
					<th>RecapNo</th>
					<th>SizeAndPly</th>
					<th>Price(Php)</th>
					<th>DatePurchased</th>
					<th>DatePurchasedRecap1</th>
					<th>DatePurchasedRecap2</th>
					<th>InvoiceNo</th>
					<th>Analysis</th>
					<th>Comments</th>
					<th>Retired</th>
					<th>DateRetired</th>
					<th>Lorry No</th>
					<c:if test="${sessionScope.user_role_session=='Admin'}">
						<th></th>
						<th></th>
					</c:if>
				</tr>
				<logic:iterate name="tireForm" property="modelList" type="com.transport.model.Tire" id="model" indexId="index">
					<tr>			
						<td><c:out value="${index+1 + (tireForm.currentPage * 10 - 10)}"/></td>
						<td><bean:write name="model" property="brandName"/></td>
						<c:choose>
							<c:when test="${model.retired == 'Yes'}">
								<td><a href="#" style="color: red;" onclick="getTireDetails('<bean:write name="model" property="serialNo"/>','<bean:write name="model" property="brandName"/>');"><bean:write name="model" property="serialNo"/></a></td>
								<td><a href="#" style="color: red;" onclick="recapTire('<bean:write name="model" property="id"/>');"><bean:write name="model" property="recapNo"/></a></td>
							</c:when>
							<c:otherwise>
								<td><a href="#" onclick="getTireDetails('<bean:write name="model" property="serialNo"/>','<bean:write name="model" property="brandName"/>');"><bean:write name="model" property="serialNo"/></a></td>
								<td><a href="#" onclick="recapTire('<bean:write name="model" property="id"/>');"><bean:write name="model" property="recapNo"/></a></td>
							</c:otherwise>	
						</c:choose>		
						<td><bean:write name="model" property="sizeAndPly"/></td>
						<c:choose>
							<c:when test="${model.price > 0}">
								<td><bean:write name="model" property="price" format="Php #,###.00"/></td>
							</c:when>
							<c:otherwise>
								<td></td>
							</c:otherwise>
						</c:choose>
						
						<td><bean:write name="model" property="datePurchased" format='MM/dd/yyyy'/></td>
						<td><bean:write name="model" property="datePurchasedForRecap1" format='MM/dd/yyyy'/></td>
						<td><bean:write name="model" property="datePurchasedForRecap2" format='MM/dd/yyyy'/></td>
						<td><bean:write name="model" property="invoiceNo"/></td>
						<c:choose>
							<c:when test="${model.analysis == null || model.analysis == ''}">
								<td><a href="#" style="color: blue;" onclick="editTireAnalysisComments('<bean:write name="model" property="id"/>');">[Add Analysis]</a></td>
							</c:when>
							<c:otherwise>
								<td><a href="#" onclick="editTireAnalysisComments('<bean:write name="model" property="id"/>');"><bean:write name="model" property="analysis"/></a></td>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${model.comments == null || model.comments == ''}">
								<td><a href="#"  style="color: blue;" onclick="editTireAnalysisComments('<bean:write name="model" property="id"/>');">[Add Comments]</a></td>
							</c:when>
							<c:otherwise>
								<td><a href="#" onclick="editTireAnalysisComments('<bean:write name="model" property="id"/>');"><bean:write name="model" property="comments"/></a></td>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${model.retired == 'Yes'}">
								<td style="color: red;"><bean:write name="model" property="retired"/></td>
							</c:when>
							<c:otherwise>
								<td><bean:write name="model" property="retired"/></td>
							</c:otherwise>
						</c:choose>		
						<td><bean:write name="model" property="dateRetired" format='MM/dd/yyyy'/></td>
						<td><bean:write name="model" property="lorryNo"/></td>
						<c:if test="${sessionScope.user_role_session=='Admin'}">
							<td align="center"><a href="#" onclick="editTire('<bean:write name="model" property="id"/>');">Edit</a></td>
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
				
				<!-- pagination limit to 10 -->
				<c:choose>
					<c:when test="${tireForm.currentPage lt tireForm.noOfPages && tireForm.noOfPages > 10}">
						<c:forEach begin="${tireForm.currentPage}" end="${tireForm.currentPage+9}" var="i">
			                <c:choose>
			                    <c:when test="${tireForm.currentPage eq i}">
			                        <li class="active"><a href="#">${i}</a></li>
			                    </c:when>
			                    <c:otherwise>
			                         <li><a href="#" onclick="getTire(${i},'${tireForm.category}');">${i}</a></li>
			                    </c:otherwise>
			                </c:choose>
			            </c:forEach>					
					</c:when>
					<c:otherwise>
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
					</c:otherwise>
				</c:choose>
					

	           	<c:if test="${tireForm.currentPage lt tireForm.noOfPages}">
	               	<li><a href="#" onclick="getTire(${tireForm.currentPage + 1},'${tireForm.category}');">&raquo;</a></li>
	            </c:if>

			</ul>
		</div>
	</div>
