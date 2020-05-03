<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>LRMS</title>
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
		function viewLabRequest(labRequestId) {
			window.location.href = 'goToViewPatientLabRequest?labRequestId=' + labRequestId;
		}
		
		function searchPatientLabRequest(page,lastName) {
			window.location.href = 'searchPatientLabRequest?page=' + page + '&lastName=' + lastName;
		}
		
	</script>
</head>
<body>

	<form:form action="/lrmsweb/searchPatientLabRequest" method="GET"  modelAttribute="patient" cssClass="form-horizontal" >
			
		<input type="hidden" name="page" value="1">  <!-- page parameter -->
			
		<div align="center" style="position: sticky; top: 0; background-color: white;">
			<div align="left" style="padding: 5px 0px 0px 10px;">
			   	<a href="./goToMain" >Back to Home</a>
			</div>
			<div align="center" style="padding-top: 10px;">
			  	<img src="resources/img/browse_labreq.jpg" alt="PatientLabRequest" height="50" width="50">
				<label style="font-size: 24px;">Search Patient's Laboratory Examination Requests</label>				
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
								<tr>
									<th>No</th>
									<th>RequestDate</th>
									<th>Name</th>
									<th>LabExam</th>
									<th>Gender</th>
									<th>Age</th>
									<th>RequestingPhysician</th>
									<th>LabRequestNo</th>
									<th>PatientNo</th>
									<th>PaymentStatus</th>
									<th>RequestStatus</th>
								</tr>
								<!-- loop here -->
								<c:forEach items="${resultList}" var="model" varStatus = "row">
								    <tr>
								    	<td>${row.count + ((currentPage - 1) * 10)}</td>
								    	<td><fmt:formatDate pattern="MM/dd/yyyy" value="${model.requestDate}"/></td>	
										<td>
											<c:choose>
												<c:when test="${model.status.listValue == 'Released' && model.paymentStatus.listValue == 'Paid'}" >
													<a href="#" onclick="viewLabRequest(${model.id});" >${model.patient.fullName}</a>
												</c:when>
												<c:otherwise>
													<a href="#" onclick="viewLabRequest(${model.id});" ><span style="color:red;">${model.patient.fullName}</span></a>
												</c:otherwise>
											</c:choose>
										</td>
										<td>${model.labExamName}</td>	
										<td>${model.patient.gender}</td>	
										<td>${model.age}</td>
										<td>${model.professional.fullName}</td>
										<td>
											<c:choose>
												<c:when test="${model.status.listValue == 'Released' && model.paymentStatus.listValue == 'Paid'}" >
													<a href="#" onclick="viewLabRequest(${model.id});" >${model.labRequestNo}</a>
												</c:when>
												<c:otherwise>
													<a href="#" onclick="viewLabRequest(${model.id});" ><span style="color:red;">${model.labRequestNo}</span></a>
												</c:otherwise>
											</c:choose>
										</td>
										<td>${model.patient.patientNo}</td>
										<td>
									    	<c:choose>
									    		<c:when test="${model.paymentStatus.listValue == 'Paid'}">	    						
									    			<a href="#" onclick="viewLabRequest(${model.id});" >${model.paymentStatus.listValue}</a>			
									    		</c:when>
									    		<c:otherwise>
									    			<a href="#" onclick="viewLabRequest(${model.id});" ><span style="color:red;">${model.paymentStatus.listValue}</span></a>
									    		</c:otherwise>		    	
									    	</c:choose>										
										</td>
										<td>
											<c:choose>
									    		<c:when test="${model.status.listValue == 'Released'}">	    						
									    			<a href="#" onclick="viewLabRequest(${model.id});" >${model.status.listValue}</a>			
									    		</c:when>
									    		<c:otherwise>
									    			<a href="#" onclick="viewLabRequest(${model.id});" ><span style="color:red;">${model.status.listValue}</span></a>
									    		</c:otherwise>		    	
									    	</c:choose>
								    	</td>
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
							<li><a href="#" onclick="searchPatientLabRequest(${currentPage - 1}, document.getElementById('lastNameId').value);">Previous</a></li>
						</c:if>
						<c:if test="${currentPage lt noOfPages}">
							<li><a href="#" onclick="searchPatientLabRequest(${currentPage + 1}, document.getElementById('lastNameId').value);">Next</a></li>
						</c:if>
					</ul>
				</div>
		
				<div style="position: relative; top: -15px; float: right;" >
					<ul class="pagination">
					
						<c:if test="${currentPage != 1 && noOfPages > 0}">
							<li><a href="#" onclick="searchPatientLabRequest(${currentPage - 1}, document.getElementById('lastNameId').value);">&laquo;</a></li>
						</c:if>
							
						<c:forEach begin="1" end="${noOfPages}" var="i">
			                <c:choose>
			                    <c:when test="${currentPage eq i}">
			                        <li class="active"><a href="#">${i}</a></li>
			                    </c:when>
			                    <c:otherwise>	                
			                      	 <c:choose>
			                          	<c:when test="${currentPage < i && i < currentPage+10}">
			                          		<li><a href="#" onclick="searchPatientLabRequest(${i}, document.getElementById('lastNameId').value);">${i}</a></li>
			                          	</c:when>
			                           	<c:otherwise>
			                           		<!-- none -->
			                           	</c:otherwise>
			                         </c:choose>
			                    </c:otherwise>
			                </c:choose>
			            </c:forEach>
			           	<c:if test="${currentPage lt noOfPages}">
			               	<li><a href="#" onclick="searchPatientLabRequest(${currentPage + 1}, document.getElementById('lastNameId').value);">&raquo;</a></li>
			            </c:if>
		
					</ul>
				</div>
			</div>
			<!-- End Pagination -->
				
		</div>
				
	</form:form>
		
</body>
</html>