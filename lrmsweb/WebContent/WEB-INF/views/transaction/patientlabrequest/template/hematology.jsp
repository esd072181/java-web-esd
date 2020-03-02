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
			window.location.href = 'showLabExamReport?templateId=504&labReqNo=' + labReqNo + "&patientLabExamIdParam=" + patientLabExamIdParam;	
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
		<h3>HEMATOLOGY
			<c:if test="${isUpdated == true}">
				&nbsp;&nbsp;&nbsp;
				<label style="color:blue; font-size:14px;">Record successfully updated!</label>
			</c:if>		
		</h3>
	</div>
	
	<form:form action="/lrmsweb/savePatientHematology" method="post" modelAttribute="patientHematology" cssClass="form-horizontal">
	
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
	
			<table border="1">
				<tr style="background-color: yellow; color: blue;">
					<th colspan="1">TEST</th>
					<th colspan="1">NORMAL</th>
					<th colspan="1">RESULT</th>
					<th colspan="3" align="center">DIFFERENTIAL</th>
				</tr>
				<tr>
					<td>WBC X 10 9/1</td>
					<td align="center">5 - 10</td>
					<td><form:input disabled="${isReleased}" path="wbc" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td>POLYS/SECS</td>
					<td align="center">0.66 - 0.70</td>
					<td><form:input disabled="${isReleased}" path="polys" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
				</tr>
				<tr>
					<td>RBC X 10 12/1</td>
					<td align="center">M 4.5-6.5 / F 3.8-5.8</td>
					<td><form:input disabled="${isReleased}" path="rbc" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td>LYMPHOCYTES</td>
					<td align="center">0.22 - 0.40</td>
					<td><form:input disabled="${isReleased}" path="lympho" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
				</tr>		
				<tr>
					<td>HEMOGLOBIN G/1</td>
					<td align="center">M 140-180 / F 120-165</td>
					<td><form:input disabled="${isReleased}" path="hemo" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td>MONOCYTES</td>
					<td align="center">0 - 0.06</td>
					<td><form:input disabled="${isReleased}" path="mono" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
				</tr>				
				<tr>
					<td>HEMATOCRIT</td>
					<td align="center">M 0.42-0.54 / F 0.36-0.46</td>
					<td><form:input disabled="${isReleased}" path="hema" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td>EOSINOPHILS</td>
					<td align="center">0.01 - 0.04</td>
					<td><form:input disabled="${isReleased}" path="eosino" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
				</tr>	
				<tr>
					<td>PLATELET CT X 10 9/1</td>
					<td align="center">150 - 350</td>
					<td><form:input disabled="${isReleased}" path="plate" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td>BASOPHILS</td>
					<td align="center">0 - 0.01</td>
					<td><form:input disabled="${isReleased}" path="baso" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
				</tr>
				<tr>
					<td>BLOOD TYPE R/H</td>
					<td align="center"></td>
					<td><form:input disabled="${isReleased}" path="blood" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td>ATYPICALLYMPHOCYTES</td>
					<td align="center">0</td>
					<td><form:input disabled="${isReleased}" path="atyp" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
				</tr>
				<tr>
					<td>RETIC COUNT</td>
					<td align="center">0.5 - 1.5%</td>
					<td><form:input disabled="${isReleased}" path="retic" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td>() ESR</td>
					<td align="center">M 0-10 mm/hr</td>
					<td><form:input disabled="${isReleased}" path="esr" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
				</tr>				
				<tr>
					<td colspan="4"></td>
					<td align="center">F 0-20 mm/hr</td>
					<td></td>
				</tr>	
				<tr>
					<td colspan="3"></td>
					<td>() CT</td>
					<td align="center">DALE 2-4 min</td>
					<td><form:input disabled="${isReleased}" path="ct" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
				</tr>				
				<tr>
					<td colspan="3"></td>
					<td>() BT</td>
					<td align="center">IVY 1-3 min</td>
					<td><form:input disabled="${isReleased}" path="bt" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
				</tr>
				<tr>
					<td colspan="3"></td>
					<td>() LE PREP</td>
					<td colspan="2"></td>
				</tr>					
				<tr>
					<td colspan="3"></td>
					<td>() PROTIME ACTIVITY</td>
					<td colspan="2"></td>
				</tr>				
				<tr>
					<td colspan="4"></td>
					<td>PATIENT (SEC)</td>
					<td><form:input disabled="${isReleased}" path="patient" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
				</tr>				
				<tr>
					<td colspan="4"></td>
					<td>CONTROL (SEC)</td>
					<td><form:input disabled="${isReleased}" path="control" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
				</tr>
				<tr>
					<td colspan="3"></td>
					<td>NORMAL VALUE</td>
					<td align="center">10 - 14 sec</td>
					<td><form:input disabled="${isReleased}" path="normal" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
				</tr>	
				<tr>
					<td colspan="3"></td>
					<td>() PARTIAL</td>
					<td colspan="2"></td>
				</tr>	
					<tr>
					<td colspan="3"></td>
					<td>THROMBOPLASTINETIME</td>
					<td align="center">20 - 40 sec</td>
					<td><form:input disabled="${isReleased}" path="thromb" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
				</tr>															
				<tr height="40px;">
					<td>Remarks</td>
					<td colspan="6">
						<form:textarea disabled="${isReleased}" path="remarks" rows="2" cols="100" cssStyle="text-align: left; color: blue; font-weight: bold;"/>
					</td>
				</tr>
			</table>						
		</form:form>
</body>
</html>