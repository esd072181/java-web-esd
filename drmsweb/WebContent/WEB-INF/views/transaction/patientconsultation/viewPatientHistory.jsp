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
</head>
<body>

	<div style="width: 100%;">
	
		<h3 style="padding-left: 10px;">Patient History</h3>
		
		<div style="padding-left: 10px;">
			<label>Name:</label>
			<label style="color: blue;">${patientConsultation.patient.fullName}</label>
		</div>
		
		<hr>
		
		<!-- Patient History -->		
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
								<td>ConsultationDate</td>
								<td>ChiefComplaint/Request</td>
								<td>Diagnosis</td>
								<td>ConsultationProcedure</td>
								<td>MedicationStatement</td>
								<td>Remarks</td>
								<td>Dentist</td>
								<td>Age</td>
								<td>Height</td>
								<td>Weight</td>
							</tr>
							<!-- loop here -->
							<c:forEach items="${resultList}" var="model" varStatus = "row">
							    <tr>
							    	<td>${row.count + ((currentPage - 1) * 10)}</td>
							    	<td><fmt:formatDate pattern="MM/dd/yyyy" value="${model.consultDate}"/></td>
									<td>${model.chiefComplaint}</td>
									<td>${model.diagnosis}</td>
									<td>${model.consultationProcedure}</td>	
									<td>${model.medicationStatement}</td>	
									<td>${model.remarks}</td>		
									<td>${model.professional.fullName}</td>		
									<td>${model.age}</td>
									<td>${model.height}</td>
									<td>${model.weight}</td>				
							    </tr>
							</c:forEach>
							
						</table>
					</div>
				</c:otherwise>
			</c:choose>
	


									
	</div>
	

	
</body>
</html>