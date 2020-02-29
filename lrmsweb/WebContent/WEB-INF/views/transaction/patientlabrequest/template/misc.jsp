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
	<script>
	  $('#reportId').click(function(){
		    window.open(this.href);
		    return false;
		  });
		function viewReport(labReqNo, patientLabExamIdParam) {
			window.location.href = 'showLabExamReport?templateId=505&labReqNo=' + labReqNo  + "&patientLabExamIdParam=" + patientLabExamIdParam;		
		}
	</script>
</head>
<body>

	<div>
		<h4>MISCELLANEOUS</h4>
	</div>

	<c:if test="${isUpdated == true}">
		<div>
			<h4 style="color: blue;">Record successfully updated!</h4>
		</div>
	</c:if>
					
	<!-- Lab Request Details details -->
	<table>
		<tr>
			<td>Name:</td>
			<td colspan="1"><input type="text" value="${patientLabRequest.patient.fullName}" readonly="readonly"></td>
			<td>Date:</td>
			<td colspan="1"><input type="text" value='<fmt:formatDate pattern="MM/dd/yyyy" value="${patientLabRequest.requestDate}"/>' readonly="readonly"></td>
			<td>LabRequestNo:</td>
			<td colspan="1"><input type="text" value="${patientLabRequest.labRequestNo}" readonly="readonly"></td>
		</tr>
		<tr>
			<td>Age:</td>
			<td colspan="1"><input type="text" value="${patientLabRequest.age}" readonly="readonly"></td>
			<td>Sex:</td>
			<td colspan="1"><input type="text" value="${patientLabRequest.patient.gender}" readonly="readonly"></td>
			<td>Requested By:</td>
			<td colspan="1"><input type="text" value="${patientLabRequest.professional.fullName}" readonly="readonly"></td>
		</tr>
	</table>
	
	<br>
	
		<form:form action="/lrmsweb/savePatientMisc" method="post" modelAttribute="patientMisc" cssClass="form-horizontal">
		
			<input type="hidden" name="labRequestId" value="${patientLabRequest.id}">
			<input type="hidden" name="patientLabExamIdParam" value="${patientLabExamId}">
			
			<form:hidden path="id" />
			<form:hidden path="patientLabExam.id" />
			<form:hidden path="createdBy" />
			<form:hidden path="createdOn" />
			<form:hidden path="modifiedBy" />
			<form:hidden path="modifiedOn" />
			<form:hidden path="version" />
			<form:hidden path="active" />

	
			<table>		
				<tr>
					<td>Lab Exam:</td>
					<td><label style="font-weight: bold;">${labExamName}</label> </td>
				</tr>
				<tr height="10px;">									
				<tr>
					<td valign="top">Result:</td>
					<td colspan="6">
						<form:textarea disabled="${isReleased}" path="result" rows="5" cols="83" cssStyle="text-align: left; color: blue; font-weight: bold;"/>
					</td>
				</tr>
				<tr height="40px;">
					<td valign="top">Remarks:</td>
					<td colspan="6">
						<form:textarea disabled="${isReleased}" path="remarks" rows="5" cols="83" cssStyle="text-align: left; color: blue; font-weight: bold;"/>
					</td>
				</tr>
			</table>
			<br>
			<table>
				<tr>
					<td>Person-in-charge:</td>
					<td>
						<form:select disabled="${isReleased}" path="pic.id"  items="${professionalList}"  itemValue="id"   itemLabel="fullName" cssClass="form-control input-sm">
						</form:select>
					</td>
					<td width="20px"></td>
					<c:choose>
						<c:when test="${isReleased}">
							<td align="right"><input disabled="disabled" class="btn btn-default" type="submit" value="Save/Update Data"></td>
						</c:when>
						<c:otherwise>
							<td align="right"><input  class="btn btn-default" type="submit" value="Save/Update Data"></td>
						</c:otherwise>
					</c:choose>
					<td width="20px"></td>
					<td><a id="reportId" href="#" onclick="viewReport('${patientLabRequest.labRequestNo}','${patientLabExamId}');" >Print Preview</a></td>
				</tr>
			
			</table>
									
		</form:form>


</body>
</html>