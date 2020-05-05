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
		  	var str = $('#lastNameId').val();
			$('#lastNameId').focus().val("").val(str);
		});
		function goToEdit(id) {
			window.location.href = 'editUserAccount?id=' + id;
		}
		
		function searchUserAccount(page,lastName) {
			window.location.href = 'searchUserAccount?page=' + page + '&lastName=' + lastName;
		}
		
		function deleteUserAccount(id) {
			bootbox.confirm("Are you sure you want to delete this record?", function(ans) {
				  //Example.show("Confirm result: "+result);
				if (ans) {
					window.location.href = 'deleteUserAccount?id=' + id;
				} 
			}); 
			
		}
	</script>
</head>
<body>

	<form:form action="/crmsweb/searchUserAccount" method="GET"  modelAttribute="userAccount" cssClass="form-horizontal" >
					
		<input type="hidden" name="page" value="1">  <!-- page parameter -->
		<!-- Note: can also use textbox for patientno parameter as @RequestParam in controller -->
	
		<div align="center" style="position: sticky; top: 0; background-color: white;">
			<div align="left" style="padding: 5px 0px 0px 10px;">
			   	<a href="./goToMain" >Back to Home</a>
			</div>
			<div align="center" style="padding-top: 10px;">
			  	<img src="resources/img/login.jpg" alt="UserAccount" height="50" width="50">
		    <label style="font-size: 24px;">Search User Account</label>			
			</div>
			<div align="center" style="padding-top: 10px;">
				<form:label path="prof.lastName" >Name:</form:label>
		      	<form:input id="lastNameId" path="prof.lastName"/>	    		
		    	<input class="btn btn-default " type="submit" value="Search">
		      	<input class="btn btn-default" type="button" id="closeButton" value="Add New" onclick="window.location.href = '/crmsweb/goToAddUserAccount';">
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
							<div  class="table-responsive" style="width: 99%; padding-left: 10px;">
								<table class="table table-striped table-hover table-bordered table-responsive" style="font-size: 11px;">
									<tr>
										<th>No</th>
										<th>Name</th>
										<th>UserName</th>
										<th>Password</th>
										<th>Role</th>
										<th></th>
									</tr>
									<!-- loop here -->
									<c:forEach items="${resultList}" var="model" varStatus = "row">
									    <tr>
									    	<td>${row.count + ((currentPage - 1) * 10)}</td>
											<td><a href="#" onclick="goToEdit(${model.id});" >${model.prof.fullName}</a></td>
											<td>${model.userName}</td>
											<td>*********</td>	
											<td>${model.role.listValue}</td>
											<td align="center"><a href="#" onclick="deleteUserAccount(${model.id});" >Delete</a></td>
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
								<li><a href="#" onclick="searchUserAccount(${currentPage - 1}, document.getElementById('lastNameId').value);">Previous</a></li>
							</c:if>
							<c:if test="${currentPage lt noOfPages}">
								<li><a href="#" onclick="searchUserAccount(${currentPage + 1}, document.getElementById('lastNameId').value);">Next</a></li>
							</c:if>
						</ul>
					</div>
			
					<div style="position: relative; top: -15px; float: right;" >
						<ul class="pagination">
						
							<c:if test="${currentPage != 1 && noOfPages > 0}">
								<li><a href="#" onclick="searchUserAccount(${currentPage - 1}, document.getElementById('lastNameId').value);">&laquo;</a></li>
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
						                        <li><a href="#" onclick="searchUserAccount(${i}, document.getElementById('lastNameId').value);">${i}</a></li>
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
						                        <li><a href="#" onclick="searchUserAccount(${i}, document.getElementById('lastNameId').value);">${i}</a></li>
						                    </c:otherwise>
						                </c:choose>
						            </c:forEach>
								</c:otherwise>
							</c:choose>	
							
				           	<c:if test="${currentPage lt noOfPages}">
				               	<li><a href="#" onclick="searchUserAccount(${currentPage + 1}, document.getElementById('lastNameId').value);">&raquo;</a></li>
				            </c:if>
			
						</ul>
					</div>
				</div>
				<!-- End Pagination -->
											
											
		</div>

				
	</form:form>
					
</body>
</html>