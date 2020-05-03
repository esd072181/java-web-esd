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
			window.open('showLabExamReport?templateId=505&labReqNo=' + labReqNo + "&patientLabExamIdParam=" + patientLabExamIdParam,'popUpWindow','height=700,width=900,left=100,top=100,resizable=yes,scrollbars=yes,toolbar=yes,menubar=no,location=no,directories=no, status=yes');
		}
	</script>
	<style>
	 .labelName{
	 	font-size: 14px;
	 }
	 .textValue{
	 	font-size: 14px;
	 	font-weight: bold;
	 }		
	</style>
</head>
<body>

	<div>
		<h3>MISCELLANEOUS
			<c:if test="${isUpdated == true}">
				&nbsp;&nbsp;&nbsp;
				<label style="color:blue; font-size:14px;">Record successfully updated!</label>
			</c:if>	
		</h3>
	</div>

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
								
		<!-- Lab Request Details details -->
		<table>
			<tr>
				<td class="labelName">Name:</td>
				<td colspan="1"><input type="text" class="textValue" value="${patientLabRequest.patient.fullName}" readonly="readonly"></td>
				<td class="labelName">Date:</td>
				<td colspan="1"><input type="text" class="textValue" value='<fmt:formatDate pattern="MM/dd/yyyy" value="${patientLabRequest.requestDate}"/>' readonly="readonly"></td>
				<td class="labelName">LabRequestNo:</td>
				<td colspan="1"><input type="text" class="textValue" value="${patientLabRequest.labRequestNo}" readonly="readonly"></td>
				<td class="labelName">Person-in-charge:</td>
				<td>
					<form:select disabled="${isReleased}" path="pic.id"  items="${professionalList}"  itemValue="id"   itemLabel="fullName" cssClass="form-control input-sm textValue">
					</form:select>
				</td>
			</tr>
			<tr>
				<td class="labelName">Age:</td>
				<td colspan="1"><input type="text" class="textValue" value="${patientLabRequest.age}" readonly="readonly"></td>
				<td class="labelName">Sex:</td>
				<td colspan="1"><input type="text" class="textValue" value="${patientLabRequest.patient.gender}" readonly="readonly"></td>
				<td class="labelName">Requested By:</td>
				<td colspan="1"><input type="text" class="textValue" value="${patientLabRequest.professional.fullName}" readonly="readonly"></td>
				<c:if test="${isReleased == false}">
					<td align="right"><input type="submit"  style="font-size:20px; color:blue;" value="Save Data"></td>
				</c:if>
				<td><input type="button" style="font-size:20px; color:blue;" onclick="viewReport('${patientLabRequest.labRequestNo}','${patientLabExamId}');" value="Print Preview"></td>
			</tr>
		</table>
		
		<br>
	
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
		</form:form>
</body>
</html>