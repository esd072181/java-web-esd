<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>CRMS</title>
	<script>
		function goToSearchPatientForConsultation() {
			window.location.href = "./goToSearchPatientForConsultation";
		}
		function goToSearchPatientConsultation() {
			window.location.href = "./goToSearchPatientConsultation";
		}
		function goToSearchPatient() {
			window.location.href = "./goToSearchPatient";
		}
		function goToSearchProfessional() {
			window.location.href = "./goToSearchProfessional";
		}
		function goToSearchMed() {
			window.location.href = "./goToSearchMed";
		}
		function goToSearchLabExam() {
			window.location.href = "./goToSearchLabExam";
		}
		function goToSearchUserAccount() {
			window.location.href = "./goToSearchUserAccount";
		}
	</script>
</head>
<body>

	<div style="width: 100%" align="center">
	
		<jsp:include page="header.jsp"></jsp:include>
		
		<div>
			<h1>Clinical Records Management System</h1>
		</div>
	
		<table>
			<tr>
				<td colspan="3" align="center"><h4>Transaction</h4></td>
			</tr>
			<tr>
				<td align="center">
					<img onclick="goToSearchPatientForConsultation();" src="resources/img/consult01.png" alt="Consultation" height="100" width="100">	
				</td>
				<td width="40px"></td>
				<td align="center">
					<img onclick="goToSearchPatientConsultation();" src="resources/img/browse_consult01.jpg" alt="Browse Consultation" height="100" width="100">
				</td>
			</tr>
			<tr>
				<td align="center"><a href="./goToSearchPatientForConsultation">Consultation</a></td>
				<td width="30px"></td>
				<td align="center"><a href="./goToSearchPatientConsultation">Browse Patient Consultation</a></td>		
			</tr>
		</table> 
		<br>


		<table>
				<tr>
					<c:choose>
						<c:when test="${roleid == 601}">
							<td colspan="10" align="center"><h4>Master File</h4></td>					
						</c:when>
						<c:otherwise>
							<td colspan="8" align="center"><h4>Master File</h4></td>
						</c:otherwise>
					</c:choose>
				</tr>
				<tr>
					<td align="center">
						<img onclick="goToSearchPatient();" src="resources/img/patient_reg.png" alt="Patient Master File" height="100" width="100">	
					</td>
					<td width="50px"></td>
					<td align="center">
						<img onclick="goToSearchProfessional();" src="resources/img/prof03.jpg" alt="Professional Master File" height="100" width="100">	
					</td>	
					<td width="50px"></td>
					<td align="center">
						<img onclick="goToSearchMed();" src="resources/img/med05.png" alt="Medicine Master File" height="100" width="100">	
					</td>	
					<td width="50px"></td>
					<td align="center">
						<img onclick="goToSearchLabExam();" src="resources/img/lab01.png" alt="Lab Exam Master File" height="100" width="100">	
					</td>
					<!-- Below for Admin only -->
					<c:if test="${roleid == 601}">
						<td width="50px"></td>
						<td align="center">
							<img onclick="goToSearchUserAccount();" src="resources/img/login.jpg" alt="User Account Master File" height="100" width="100">	
						</td>						
					</c:if>
				</tr>
				<tr>
					<td align="center"><a href="./goToSearchPatient">Patient</a></td>
					<td width="30px"></td>
					<td align="center"><a href="./goToSearchProfessional">Professional</a></td>	
					<td width="30px"></td>
					<td align="center"><a href="./goToSearchMed">Medicine</a></td>	
					<td width="30px"></td>
					<td align="center"><a href="./goToSearchLabExam">Lab Exam</a></td>
					<c:if test="${roleid == 601}">
						<td width="30px"></td>
						<td align="center"><a href="./goToSearchUserAccount">User Account</a></td>						
					</c:if>	
				</tr>
		</table>
	</div>
	
</body>
</html>