<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
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
		function goToConsultation(id) {
			window.location.href = 'goToConsultation?patientId=' + id;
		}
		
		function searchPatientForConsultation(page,lastName) {
			window.location.href = 'searchPatientForConsultation?page=' + page + '&lastName=' + lastName;
		}
	</script>
</head>
<body>

	<div style="width: 100%;">
	
		<form:form action="/crmsweb/searchPatientForConsultation" method="GET"  modelAttribute="patient" cssClass="form-horizontal" >
					
			<div style="overflow:hidden;">
				<div style="float:left; padding: 5px 0px 0px 10px;">
					<a href="./goToMain" >Back to Home</a><br>					
				</div>			
			</div>
			    
			<div align="center">
				<img src="resources/img/consult01.png" alt="PatientConsultation" height="50" width="50">
				<label style="font-size: 24px;">Search Patient For Consultation</label>		
			</div>
			
			<br>
						
			<input type="hidden" name="page" value="1">  <!-- page parameter -->
			<!-- Note: can also use textbox for patientno parameter as @RequestParam in controller -->
		
			<div align="center">
				<div>
					<form:label path="lastName">Name:</form:label>
		      		<form:input id="lastNameId" path="lastName"/>	    		
		      		<input class="btn btn-default " type="submit" value="Search">
		      		<input class="btn btn-default" type="button" id="closeButton" value="Add New Patient" onclick="window.location.href = '/crmsweb/goToPatientRegistration';">	
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
								<td>No</td>
								<td>Name</td>
								<td>Gender</td>
								<td>Birthday</td>
								<td>ContactNo</td>
								<td>AddressLine1</td>
								<td>AddressLine2</td>
								<td>Town</td>
								<td>Province</td>
								<td>ZipCode</td>
								<td>ContactPerson</td>
								<td>ContactNo</td>
								<td>DateRegistered</td>
								<td>PatientNo</td>
							</tr>
							<!-- loop here -->
							<c:forEach items="${resultList}" var="model" varStatus = "row">
							    <tr>
							    	<td>${row.count + ((currentPage - 1) * 10)}</td>
									<td><a href="#" onclick="goToConsultation(${model.id});" >${model.fullName}</a></td>
									<td>${model.gender}</td>	
									<td><fmt:formatDate pattern="MM/dd/yyyy" value="${model.birthday}"/></td>	
									<td>${model.contactNo}</td>	
									<td>${model.addressLine1}</td>	
									<td>${model.addressLine2}</td>	
									<td>${model.town}</td>		
									<td>${model.province}</td>
									<td>${model.zipCode}</td>
									<td>${model.contactPerson}</td>	
									<td>${model.contactPersonNo}</td>	
									<td><fmt:formatDate pattern="MM/dd/yyyy" value="${model.dateRegistered}"/></td>	
									<td><a href="#" onclick="goToConsultation(${model.id});" >${model.patientNo}</a></td>	
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
						<li><a href="#" onclick="searchPatientForConsultation(${currentPage - 1}, document.getElementById('lastNameId').value);">Previous</a></li>
					</c:if>
					<c:if test="${currentPage lt noOfPages}">
						<li><a href="#" onclick="searchPatientForConsultation(${currentPage + 1}, document.getElementById('lastNameId').value);">Next</a></li>
					</c:if>
				</ul>
			</div>
	
			<div style="position: relative; top: -15px; float: right;" >
				<ul class="pagination">
				
					<c:if test="${currentPage != 1 && noOfPages > 0}">
						<li><a href="#" onclick="searchPatientForConsultation(${currentPage - 1}, document.getElementById('lastNameId').value);">&laquo;</a></li>
					</c:if>
						
					<c:forEach begin="1" end="${noOfPages}" var="i">
		                <c:choose>
		                    <c:when test="${currentPage eq i}">
		                        <li class="active"><a href="#">${i}</a></li>
		                    </c:when>
		                    <c:otherwise>	                
		                      	 <c:choose>
		                          	<c:when test="${currentPage < i && i < currentPage+10}">
		                          		<li><a href="#" onclick="searchPatientForConsultation(${i}, document.getElementById('lastNameId').value);">${i}</a></li>
		                          	</c:when>
		                           	<c:otherwise>
		                           		<!-- none -->
		                           	</c:otherwise>
		                         </c:choose>
		                    </c:otherwise>
		                </c:choose>
		            </c:forEach>
		           	<c:if test="${currentPage lt noOfPages}">
		               	<li><a href="#" onclick="searchPatientForConsultation(${currentPage + 1}, document.getElementById('lastNameId').value);">&raquo;</a></li>
		            </c:if>
	
				</ul>
			</div>
		</div>
		<!-- End Pagination -->
									
	</div>
	

	
</body>
</html>