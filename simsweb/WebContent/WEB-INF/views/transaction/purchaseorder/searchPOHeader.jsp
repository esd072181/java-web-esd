<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>SIMS</title>
	<script type="text/javascript" src="resources/js/jquery-1.11.1.js" ></script>
 	<script type="text/javascript" src="resources/js/jquery-ui.min.js" ></script>
 	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
 	<script type="text/javascript" src="resources/js/bootbox.js"></script>
	<link rel="stylesheet" href="resources/style/bootstrap.min.css">
	<script>
		$(function() {
		  // Handler for .ready() called.
		  var str = $('#supplierNameId').val();
			$('#supplierNameId').focus().val("").val(str);
		});
		function viewPOHeader(poId) {
			window.location.href = 'viewPOHeader?poId=' + poId;
		}
		
		function searchPOHeader(page,supplierName) {
			window.location.href = 'searchPOHeader?page=' + page + '&supplierName=' + supplierName;
		}
		
	</script>
</head>
<body>

	<div style="width: 100%;">
	
		<form:form action="/simsweb/searchPOHeader" method="GET"  modelAttribute="poHeader" cssClass="form-horizontal" >
			
			<div align="left" style="padding: 10px 10px 0px 30px;">
			   	<a href="./goToMain" >Back to Home</a>
			</div>

			<div align="center">
				<img src="resources/img/browse_consult01.jpg" alt="POHeader" height="50" width="50">
				<label style="font-size: 24px;">Search Purchase Order</label>		
			</div>
			
			<br>
			
			<input type="hidden" name="page" value="1">  <!-- page parameter -->
			<!-- Note: can also use textbox for patientno parameter as @RequestParam in controller -->
		
			<div align="center">
				<div>
					<form:label path="supplier.name">Supplier:</form:label>
		      		<form:input id="supplierNameId" path="supplier.name"/>	    		
		    		<input class="btn btn-default " type="submit" value="Search">	
		    		<input class="btn btn-default" type="button" id="closeButton" value="Add New" onclick="window.location.href = '/simsweb/goToAddPOHeader';">	
		    	</div>		
			</div>
				
		</form:form>
		
		<br>
					
		<c:if test="${searchFlag == true}">
			<c:choose>
				<c:when test="${gotRecords == false}">
					<div align="center">
						<h4>No record found!</h4>
					</div>
				</c:when>
				<c:otherwise>
					<div  class="table-responsive" style="width: 99%; padding-left: 10px;">
						<table class="table table-striped table-hover table-bordered table-responsive" style="font-size: 11px;">
							<tr style="font-weight: bold;">
								<td></td>
								<td>Supplier</td>
								<td>PONo</td>								
								<td>TransactionDate</td>
								<td align="right">TotalAmount</td>
								<td>Status</td>
								<td>RequestedBy</td>
							</tr>
							<!-- loop here -->
							<c:forEach items="${resultList}" var="model" varStatus = "row">
							    <tr>
							    	<td align="center"><a href="#" onclick="viewPOHeader(${model.id});" >View</a></td>
							    	<td>${model.supplier.name}</td>
							    	<td>${model.poNo}</td>
							    	<td><fmt:formatDate pattern="MM/dd/yyyy" value="${model.transDate}"/></td>	
									<td align="right"><fmt:formatNumber type="currency" currencySymbol="" value="${model.totalAmount}"  maxFractionDigits="2"></fmt:formatNumber></td>	
									<td>${model.status.listValue}</td>			
									<td>${model.requestedBy}</td>	
							    </tr>
							</c:forEach>
							
						</table>
					</div>
				</c:otherwise>
			</c:choose>
		</c:if>
	
		<!-- Pagination -->
		<div style="width: 99%; padding-left: 10px;">
			<div style="position: relative; top: -15px; float: left; padding-left: 10px;">
				<ul class="pager">
					<c:if test="${currentPage != 1 && noOfPages > 0}">
						<li><a href="#" onclick="searchPOHeader(${currentPage - 1}, document.getElementById('supplierNameId').value);">Previous</a></li>
					</c:if>
					<c:if test="${currentPage lt noOfPages}">
						<li><a href="#" onclick="searchPOHeader(${currentPage + 1}, document.getElementById('supplierNameId').value);">Next</a></li>
					</c:if>
				</ul>
			</div>
	
			<div style="position: relative; top: -15px; float: right;" >
				<ul class="pagination">
				
					<c:if test="${currentPage != 1 && noOfPages > 0}">
						<li><a href="#" onclick="searchPOHeader(${currentPage - 1}, document.getElementById('supplierNameId').value);">&laquo;</a></li>
					</c:if>
						
					<c:forEach begin="1" end="${noOfPages}" var="i">
		                <c:choose>
		                    <c:when test="${currentPage eq i}">
		                        <li class="active"><a href="#">${i}</a></li>
		                    </c:when>
		                    <c:otherwise>	                
		                      	 <c:choose>
		                          	<c:when test="${currentPage < i && i < currentPage+10}">
		                          		<li><a href="#" onclick="searchPOHeader(${i}, document.getElementById('supplierNameId').value);">${i}</a></li>
		                          	</c:when>
		                           	<c:otherwise>
		                           		<!-- none -->
		                           	</c:otherwise>
		                         </c:choose>
		                    </c:otherwise>
		                </c:choose>
		            </c:forEach>
		           	<c:if test="${currentPage lt noOfPages}">
		               	<li><a href="#" onclick="searchPOHeader(${currentPage + 1}, document.getElementById('supplierNameId').value);">&raquo;</a></li>
		            </c:if>
	
				</ul>
			</div>
		</div>
		<!-- End Pagination -->
									
	</div>
	

	
</body>
</html>