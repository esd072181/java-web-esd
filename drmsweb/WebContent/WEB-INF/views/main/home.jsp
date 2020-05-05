<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>DRMS</title>
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
		function goToSearchUserAccount() {
			window.location.href = "./goToSearchUserAccount";
		}
	</script>
</head>
<body>

	<div style="width: 100%" align="center">
	
		<jsp:include page="header.jsp"></jsp:include>
		
		<div>
			<h1>Dental Records Management System</h1>
		</div>
	
		<table>
			<tr>
				<td colspan="3" align="center"><h4>Transaction</h4></td>
			</tr>
			<tr>
				<td align="center">
					<img onclick="goToSearchPatientForConsultation();" src="resources/img/consult01.png" style="cursor: pointer;" alt="Consultation" height="100" width="100">	
				</td>
				<td width="40px"></td>
				<td align="center">
					<img onclick="goToSearchPatientConsultation();" src="resources/img/browse_consult01.jpg" style="cursor: pointer;" alt="Browse Consultation" height="100" width="100">
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
						<c:when test="${roleid == 501}">
							<td colspan="8" align="center"><h4>Master File</h4></td>					
						</c:when>
						<c:otherwise>
							<td colspan="6" align="center"><h4>Master File</h4></td>
						</c:otherwise>
					</c:choose>
				</tr>
				<tr>
					<td align="center">
						<img onclick="goToSearchPatient();" src="resources/img/patient_reg.png" style="cursor: pointer;" alt="Patient Master File" height="100" width="100">	
					</td>
					<!-- Below for Admin only -->
					<c:if test="${roleid == 501}">
						<td width="50px"></td>
						<td align="center">
							<img onclick="goToSearchProfessional();" src="resources/img/prof03.jpg" style="cursor: pointer;" alt="Professional Master File" height="100" width="100">	
						</td>
					</c:if>
					<td width="50px"></td>
					<td align="center">
						<img onclick="goToSearchMed();" src="resources/img/med05.png" style="cursor: pointer;" alt="Medicine Master File" height="100" width="100">	
					</td>	
					<!-- Below for Admin only -->
					<c:if test="${roleid == 501}">
						<td width="50px"></td>
						<td align="center">
							<img onclick="goToSearchUserAccount();" src="resources/img/login.jpg" style="cursor: pointer;" alt="User Account Master File" height="100" width="100">	
						</td>						
					</c:if>
				</tr>
				<tr>
					<td align="center"><a href="./goToSearchPatient">Patient</a></td>
					<td width="30px"></td>
					<c:if test="${roleid == 501}">
						<td align="center"><a href="./goToSearchProfessional">Professional</a></td>	
						<td width="30px"></td>					
					</c:if>
					<td align="center"><a href="./goToSearchMed">Medicine</a></td>	
					<c:if test="${roleid == 501}">
						<td width="30px"></td>
						<td align="center"><a href="./goToSearchUserAccount">User Account</a></td>						
					</c:if>	
				</tr>
		</table>
	</div>
	
</body>
</html>