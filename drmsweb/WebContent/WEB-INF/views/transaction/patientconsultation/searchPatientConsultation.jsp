<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>DRMS</title>
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
		function viewConsultation(consultId) {
			window.location.href = 'goToViewPatientConsultation?consultId=' + consultId;
		}
		
		function searchPatientConsultation(page,lastName) {
			window.location.href = 'searchPatientConsultation?page=' + page + '&lastName=' + lastName;
		}
		
	</script>
</head>
<body>

	<form:form action="/drmsweb/searchPatientConsultation" method="GET"  modelAttribute="patient" cssClass="form-horizontal" >

		<input type="hidden" name="page" value="1">  <!-- page parameter -->
		<!-- Note: can also use textbox for patientno parameter as @RequestParam in controller -->

		<div align="center" style="position: sticky; top: 0; background-color: white;">
			<div align="left" style="padding: 5px 0px 0px 10px;">
			   	<a href="./goToMain" >Back to Home</a>
			</div>
			<div align="center" style="padding-top: 10px;">
			  	<img src="resources/img/browse_consult01.jpg" alt="PatientConsultation" height="50" width="50">
				<label style="font-size: 24px;">Search Patient's Consultation Details</label>			
			</div>
			<div align="center" style="padding-top: 10px;">
				<form:label path="lastName">Name:</form:label>
		      		<form:input id="lastNameId" path="lastName"/>	    		
		    		<input class="btn btn-default " type="submit" value="Search">	
		    </div>		
			<hr>
		</div>	

		<div id="detailsDIV">

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
									<td>ConsultationNo</td>
									<td>ConsultationDate</td>
									<td>PatientName</td>
									<td>ChiefComplaint/Request</td>
									<td>Gender</td>
									<td>Age</td>
									<td>Dentist</td>
									<td>ConsultationStatus</td>
									<td>PaymentStatus</td>
								</tr>
								<!-- loop here -->
								<c:forEach items="${resultList}" var="model" varStatus = "row">
								    <tr>
								    	<td>${row.count + ((currentPage - 1) * 10)}</td>
								    	<td>
								    		<c:choose>
												<c:when test="${model.status.listValue == 'Completed' && model.paymentStatus.listValue == 'Paid'}" >
													<a href="#" onclick="viewConsultation(${model.id});" >${model.consultNo}</a>
												</c:when>
												<c:otherwise>
													<a href="#" onclick="viewConsultation(${model.id});" ><span style="color:red;">${model.consultNo}</span></a>
												</c:otherwise>
											</c:choose>
								    	</td>
								    	<td><fmt:formatDate pattern="MM/dd/yyyy" value="${model.consultDate}"/></td>
								    	<td>	
											<c:choose>
												<c:when test="${model.status.listValue == 'Completed' && model.paymentStatus.listValue == 'Paid'}" >
													<a href="#" onclick="viewConsultation(${model.id});" >${model.patient.fullName}</a>
												</c:when>
												<c:otherwise>
													<a href="#" onclick="viewConsultation(${model.id});" ><span style="color:red;">${model.patient.fullName}</span></a>
												</c:otherwise>
											</c:choose>
										</td>
										<td>${model.chiefComplaint}</td>			
										<td>${model.patient.gender}</td>	
										<td>${model.age}</td>
										<td>${model.professional.fullName}</td>							
										<c:choose>
								    		<c:when test="${model.status.listValue == 'Completed'}">	    						
								    			<td style="color: blue;">${model.status.listValue}</td>			
								    		</c:when>
								    		<c:otherwise>
								    			<td style="color: red;">${model.status.listValue}</td>
								    		</c:otherwise>		    	
								    	</c:choose>
								    	<c:choose>
								    		<c:when test="${model.paymentStatus.listValue == 'Paid'}">	    						
								    			<td style="color: blue;">${model.paymentStatus.listValue}</td>			
								    		</c:when>
								    		<c:otherwise>
								    			<td style="color: red;">${model.paymentStatus.listValue}</td>
								    		</c:otherwise>		    	
								    	</c:choose>		
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
							<li><a href="#" onclick="searchPatientConsultation(${currentPage - 1}, document.getElementById('lastNameId').value);">Previous</a></li>
						</c:if>
						<c:if test="${currentPage lt noOfPages}">
							<li><a href="#" onclick="searchPatientConsultation(${currentPage + 1}, document.getElementById('lastNameId').value);">Next</a></li>
						</c:if>
					</ul>
				</div>
		
				<div style="position: relative; top: -15px; float: right;" >
					<ul class="pagination">
					
						<c:if test="${currentPage != 1 && noOfPages > 0}">
							<li><a href="#" onclick="searchPatientConsultation(${currentPage - 1}, document.getElementById('lastNameId').value);">&laquo;</a></li>
						</c:if>
							
						<c:forEach begin="1" end="${noOfPages}" var="i">
			                <c:choose>
			                    <c:when test="${currentPage eq i}">
			                        <li class="active"><a href="#">${i}</a></li>
			                    </c:when>
			                    <c:otherwise>	                
			                      	 <c:choose>
			                          	<c:when test="${currentPage < i && i < currentPage+10}">
			                          		<li><a href="#" onclick="searchPatientConsultation(${i}, document.getElementById('lastNameId').value);">${i}</a></li>
			                          	</c:when>
			                           	<c:otherwise>
			                           		<!-- none -->
			                           	</c:otherwise>
			                         </c:choose>
			                    </c:otherwise>
			                </c:choose>
			            </c:forEach>
			           	<c:if test="${currentPage lt noOfPages}">
			               	<li><a href="#" onclick="searchPatientConsultation(${currentPage + 1}, document.getElementById('lastNameId').value);">&raquo;</a></li>
			            </c:if>
		
					</ul>
				</div>
			</div>
			<!-- End Pagination -->		
		
		</div>
	
	</form:form>
	
</body>
</html>