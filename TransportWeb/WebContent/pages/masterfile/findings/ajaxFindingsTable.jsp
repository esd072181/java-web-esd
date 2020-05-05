<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

	<div class="table-responsive" style="padding-left: 10px;">
		<c:choose>
		  <c:when test="${findingsForm.modelList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%;">  
				<tr>
					<th>No</th>
					<th>Item</th>
					<th>Findings</th>
					<th>Type</th>
					<th></th>
					<th></th>
				</tr>
				<logic:iterate name="findingsForm" property="modelList" type="com.transport.model.Findings" id="model" indexId="index">
					<tr>				 
						<td><c:out value="${index+1 + (findingsForm.currentPage * 10 - 10)}"/></td>
						<td><bean:write name="model" property="item"/></td>
						<td><bean:write name="model" property="description"/></td>
						<td><bean:write name="model" property="type"/></td>
						<td align="center"><a href="#" onclick="javascript: editFindings('<bean:write name="model" property="id"/>');">Edit</a></td>
						<td align="center"><a href="#" onclick="javascript: deleteFindings('<bean:write name="model" property="id"/>', '${findingsForm.category}',${findingsForm.currentPage})">Delete</a></td>
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
				<c:if test="${findingsForm.currentPage != 1 && findingsForm.noOfPages > 0}">
					<li><a href="#" onclick="getFindings(${findingsForm.currentPage - 1},'${findingsForm.category}');">Previous</a></li>
				</c:if>
				<c:if test="${findingsForm.currentPage lt findingsForm.noOfPages}">
				  	<li><a href="#" onclick="getFindings(${findingsForm.currentPage + 1},'${findingsForm.category}');">Next</a></li>
				</c:if>
			</ul>
		</div>
		<div style="position: relative; top: -15px; float: right;" >
			<ul class="pagination">
			
				<c:if test="${findingsForm.currentPage != 1 && findingsForm.noOfPages > 0}">
					<li><a href="#" onclick="getFindings(${findingsForm.currentPage - 1},'${findingsForm.category}');">&laquo;</a></li>
				</c:if>
				
				<!-- pagination limit to 10 -->
				<c:choose>
					<c:when test="${findingsForm.currentPage lt findingsForm.noOfPages && findingsForm.noOfPages > 10}">
						<c:forEach begin="${findingsForm.currentPage}" end="${findingsForm.currentPage+9}" var="i">
							 <c:choose>
			                    <c:when test="${findingsForm.currentPage eq i}">
			                        <li class="active"><a href="#">${i}</a></li>
			                    </c:when>
			                    <c:otherwise>
			                         <li><a href="#" onclick="getFindings(${i},'${findingsForm.category}');">${i}</a></li>
			                    </c:otherwise>
			                </c:choose>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<c:forEach begin="1" end="${findingsForm.noOfPages}" var="i">
			                <c:choose>
			                    <c:when test="${findingsForm.currentPage eq i}">
			                        <li class="active"><a href="#">${i}</a></li>
			                    </c:when>
			                    <c:otherwise>
			                         <li><a href="#" onclick="getFindings(${i},'${findingsForm.category}');">${i}</a></li>
			                    </c:otherwise>
			                </c:choose>
			            </c:forEach>
					</c:otherwise>
				</c:choose>
					
	           	<c:if test="${findingsForm.currentPage lt findingsForm.noOfPages}">
	               	<li><a href="#" onclick="getFindings(${findingsForm.currentPage + 1},'${findingsForm.category}');">&raquo;</a></li>
	            </c:if>

			</ul>
		</div>
	</div>

<!-- 
	<div id="msgDeletedId" align="center">
		<span style="color: blue;"><c:out value="${roomCategoryForm.transactionMessage}"></c:out></span>
	</div> 
	 -->