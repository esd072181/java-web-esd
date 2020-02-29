<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>LRMS</title>
	<script>
		function goToNewLabRequest() {
			window.location.href = "./goToSearchPatientForLabRequest";
		}
		function goToSearchPatientLabRequest() {
			window.location.href = "./goToSearchPatientLabRequest";
		}
		function goToSearchPatient() {
			window.location.href = "./goToSearchPatient";
		}
		function goToSearchProfessional() {
			window.location.href = "./goToSearchProfessional";
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
			<h1>Laboratory Records Management System</h1>
		</div>
	
		<table>
			<tr>
				<td colspan="3" align="center"><h4>Transaction</h4></td>
			</tr>
			<tr>
				<td align="center">
					<img onclick="goToNewLabRequest();" src="resources/img/new_labreq.png" alt="New Lab Request" height="100" width="100">	
				</td>
				<td width="40px"></td>
				<td align="center">
					<img onclick="goToSearchPatientLabRequest();" src="resources/img/browse_labreq.jpg" alt="Browse Lab Request" height="100" width="100">
				</td>
			</tr>
			<tr>
				<td align="center"><a href="./goToSearchPatientForLabRequest">New Lab Request</a></td>
				<td width="30px"></td>
				<td align="center"><a href="./goToSearchPatientLabRequest">Browse Patient Lab Request</a></td>		
			</tr>
		</table> 
		<br>
		
		<table>
				<tr>
					<!-- Below for Admin only -->
					<c:choose>
						<c:when test="${roleid == 601}">
							<td colspan="8" align="center"><h4>Master File</h4></td>
						</c:when>
						<c:otherwise>
							<td colspan="6" align="center"><h4>Master File</h4></td>
						</c:otherwise>			
					</c:choose>
				</tr>
				<tr>
					<td align="center">
						<img onclick="goToSearchPatient();" src="resources/img/patient_reg.png" alt="Patient Master File" height="100" width="100">	
					</td>
					<td width="50px"></td>
					<td align="center">
						<img onclick="goToSearchProfessional();" src="resources/img/prof.png" alt="Professional Master File" height="100" width="100">	
					</td>	
					<td width="50px"></td>
					<td align="center">
						<img onclick="goToSearchLabExam();" src="resources/img/lab01.jpg" alt="Lab Exam Master File" height="100" width="100">	
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
					<td align="center"><a href="./goToSearchLabExam">Lab Exam</a></td>	
					<!-- Below for Admin only -->
					<c:if test="${roleid == 601}">
					<td width="30px"></td>
					<td align="center"><a href="./goToSearchUserAccount">User Account</a></td>
					</c:if>	
				</tr>
		</table>
	</div>
	
</body>
</html>