<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>CRMS</title>
	<script type="text/javascript" src="resources/js/jquery-1.11.1.js" ></script>
 	<script type="text/javascript" src="resources/js/jquery-ui.min.js" ></script>
 	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
 	<script type="text/javascript" src="resources/js/bootbox.js"></script>
	<link rel="stylesheet" href="resources/style/bootstrap.min.css">
	<script>
		$(function() {
		   // Handler for .ready() called.
		   var str = $('#descriptionId').val();
		   $('#descriptionId').focus().val("").val(str);
		});
		function goToEdit(id) {
			window.location.href = 'editLabExam?id=' + id;
		}
		
		function searchLabExam(page,description) {
			window.location.href = 'searchLabExam?page=' + page + '&description=' + description;
		}
		
		function deleteLabExam(id) {
			bootbox.confirm("Are you sure you want to delete this record?", function(ans) {
				  //Example.show("Confirm result: "+result);
				if (ans) {
					window.location.href = 'deleteLabExam?id=' + id;
				} 
			}); 
			
		}
	</script>
</head>
<body>

	<form:form action="/crmsweb/searchLabExam" method="GET"  modelAttribute="labExam" cssClass="form-horizontal" >
		
		<input type="hidden" name="page" value="1">  <!-- page parameter -->
		
		<div align="center" style="position: sticky; top: 0; background-color: white;">
			<div align="left" style="padding: 5px 0px 0px 10px;">
			   	<a href="./goToMain" >Back to Home</a>
			</div>
			<div align="center" style="padding-top: 10px;">
			  	<img src="resources/img/lab01.png" alt="LabExam" height="50" width="50">
		    	<label style="font-size: 24px;">Search Laboratory Examination</label>			
			</div>
			<div align="center" style="padding-top: 10px;">
				<form:label path="description">Description:</form:label>
	      		<form:input id="descriptionId" path="description" cssClass="input-sm"/>	    		
	    		<input class="btn btn-default " type="submit" value="Search">
	      		<input class="btn btn-default" type="button" id="closeButton" value="Add New" onclick="window.location.href = '/crmsweb/goToAddLabExam';">				
		    </div>		
			<hr>
		</div>	
		
		<div id="detailsDIV">
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
										<tr>
											<th>No</th>
											<th>Description</th>
											<th>Remarks</th>
											<th>Fee</th>
											<!-- Below for Admin only -->
											<c:if test="${roleid == 601}">	
												<th></th>
											</c:if>
										</tr>
										<!-- loop here -->
										<c:forEach items="${resultList}" var="model" varStatus = "row">
										    <tr>
										    	<td>${row.count + ((currentPage - 1) * 10)}</td>
												<td><a href="#" onclick="goToEdit(${model.id});" >${model.description}</a></td>
												<td>${model.remarks}</td>		
												<td>${model.fee}</td>
												<!-- Below for Admin only -->
												<c:if test="${roleid == 601}">
													<td align="center"><a href="#" onclick="deleteLabExam(${model.id});" >Delete</a></td>
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
									<li><a href="#" onclick="searchLabExam(${currentPage - 1}, document.getElementById('descriptionId').value);">Previous</a></li>
								</c:if>
								<c:if test="${currentPage lt noOfPages}">
								  	<li><a href="#" onclick="searchLabExam(${currentPage + 1}, document.getElementById('descriptionId').value);">Next</a></li>
								</c:if>
							</ul>
						</div>
						 
						<div style="position: relative; top: -15px; float: right;" >
							<ul class="pagination">
							
								<c:if test="${currentPage != 1 && noOfPages > 0}">
									<li><a href="#" onclick="searchLabExam(${currentPage - 1}, document.getElementById('descriptionId').value);">&laquo;</a></li>
								</c:if>
								
								<!-- pagination limit to 10 -->
								<c:choose>
									<c:when test="${currentPage lt noOfPages && noOfPages > 10}">
										<c:forEach begin="${currentPage}" end="${currentPage+9}" var="i">
											<c:choose>
							                    <c:when test="${currentPage eq i}">
							                        <li class="active"><a href="#">${i}</a></li>
							                    </c:when>
							                    <c:otherwise>
							                        <li><a href="#" onclick="searchLabExam(${i}, document.getElementById('descriptionId').value);">${i}</a></li>
							                    </c:otherwise>
							                </c:choose>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<c:forEach begin="1" end="${noOfPages}" var="i">
							                <c:choose>
							                    <c:when test="${currentPage eq i}">
							                        <li class="active"><a href="#">${i}</a></li>
							                    </c:when>
							                    <c:otherwise>
							                        <li><a href="#" onclick="searchLabExam(${i}, document.getElementById('descriptionId').value);">${i}</a></li>
							                    </c:otherwise>
							                </c:choose>
							            </c:forEach>
									</c:otherwise>
								</c:choose>	
								
					           	<c:if test="${currentPage lt noOfPages}">
					               	<li><a href="#" onclick="searchLabExam(${currentPage + 1}, document.getElementById('descriptionId').value);">&raquo;</a></li>
					            </c:if>
				
							</ul>
						</div>		
					</div>
					<!-- End Pagination -->
		
		</div>
							
	</form:form>
		
</body>
</html>