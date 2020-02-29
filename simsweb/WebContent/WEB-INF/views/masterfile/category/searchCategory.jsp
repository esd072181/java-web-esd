<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
		   var str = $('#nameId').val();
		   $('#nameId').focus().val("").val(str);
		});
		function goToEdit(id) {
			window.location.href = 'editCategory?id=' + id;
		}
		
		function searchCategory(page,name) {
			window.location.href = 'searchCategory?page=' + page + '&name=' + name;
		}
		
		function deleteCategory(id) {
			bootbox.confirm("Are you sure you want to delete this record?", function(ans) {
				  //Example.show("Confirm result: "+result);
				if (ans) {
					window.location.href = 'deleteCategory?id=' + id;
				} 
			}); 
			
		}
	</script>
</head>
<body>

	<div>
	
		<form:form action="/simsweb/searchCategory" method="GET"  modelAttribute="category" cssClass="form-horizontal" >
		
			<div align="left" style="padding: 10px 10px 0px 30px;">
		    	<a href="./goToMain" >Back to Home</a>
		    </div>
		    
		    <div align="center">
		    	<img src="resources/img/lab01.png" alt="Category" height="50" width="50">
		    	<label style="font-size: 24px;">Search Category</label>		
		    </div>
		
			<br>
					
			<input type="hidden" name="page" value="1">  <!-- page parameter -->
		
			<div align="center">
				<div>
					<form:label path="name">Name:</form:label>
	      			<form:input id="nameId" path="name" cssClass="input-sm"/>	    		
	    			<input class="btn btn-default " type="submit" value="Search">
	      			<input class="btn btn-default" type="button" id="closeButton" value="Add New" onclick="window.location.href = '/simsweb/goToAddCategory';">				
				</div>
			</div>
							
		</form:form>
		
		<br>
		
		<c:if test="${isDeleted == true}">
			<div align="center">
				<h4 style="color: blue;">Record deleted!</h4>
			</div>
		</c:if>
					
		<c:if test="${searchFlag == true}">
			<c:choose>
				<c:when test="${gotRecords == false}">
					<div align="center">
						<h4>No record found!</h4>
					</div>
				</c:when>
				<c:otherwise>
					<div style="width: 99%; padding-left: 10px;">
						<table class="table table-striped table-hover table-bordered table-responsive" style="font-size: 11px;">
							<tr  style="font-weight: bold;">
								<td>No</td>
								<td>Name</td>
								<td>Description</td>
								<td></td>
								<!-- Below for Admin only -->
								<c:if test="${roleid == 501}">	
									<td></td>
								</c:if>
							</tr>
							<!-- loop here -->
							<c:forEach items="${resultList}" var="model" varStatus = "row">
							    <tr>
							    	<td>${row.count + ((currentPage - 1) * 10)}</td>
									<td>${model.name}</td>
									<td>${model.description}</td>		
									<td align="center"><a href="#" onclick="goToEdit(${model.id});" >Edit</a></td>
									<!-- Below for Admin only -->
									<c:if test="${roleid == 501}">
										<td align="center"><a href="#" onclick="deleteCategory(${model.id});" >Delete</a></td>
									</c:if>
							    </tr>
							</c:forEach>
						</table>
					</div>
				</c:otherwise>
			</c:choose>
		</c:if>
		
		<!-- Pagination -->
		<div style="width: 99%; padding-left: 10px;">
			<div style="position: relative; top: -15px; float: left;">
				<ul class="pager">
					<c:if test="${currentPage != 1 && noOfPages > 0}">
						<li><a href="#" onclick="searchCategory(${currentPage - 1}, document.getElementById('nameId').value);">Previous</a></li>
					</c:if>
					<c:if test="${currentPage lt noOfPages}">
					  	<li><a href="#" onclick="searchCategory(${currentPage + 1}, document.getElementById('nameId').value);">Next</a></li>
					</c:if>
				</ul>
			</div>
			 
			<div style="position: relative; top: -15px; float: right;" >
				<ul class="pagination">
				
					<c:if test="${currentPage != 1 && noOfPages > 0}">
						<li><a href="#" onclick="searchCategory(${currentPage - 1}, document.getElementById('nameId').value);">&laquo;</a></li>
					</c:if>
						
					<c:forEach begin="1" end="${noOfPages}" var="i">
		                <c:choose>
		                    <c:when test="${currentPage eq i}">
		                        <li class="active"><a href="#">${i}</a></li>
		                    </c:when>
		                    <c:otherwise>
		                      	 <c:choose>
		                          	<c:when test="${currentPage < i && i < currentPage+10}">
		                          		<li><a href="#" onclick="searchCategory(${i}, document.getElementById('nameId').value);">${i}</a></li>
		                          	</c:when>
		                           	<c:otherwise>
		                           		<!-- none -->
		                           	</c:otherwise>
		                         </c:choose>
		                    </c:otherwise>
		                </c:choose>
		            </c:forEach>
		           	<c:if test="${currentPage lt noOfPages}">
		               	<li><a href="#" onclick="searchCategory(${currentPage + 1}, document.getElementById('nameId').value);">&raquo;</a></li>
		            </c:if>
	
				</ul>
			</div>		
		</div>
		<!-- End Pagination -->
							
	</div>
	
	
</body>
</html>