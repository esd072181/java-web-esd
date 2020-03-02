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
			window.location.href = 'showLabExamReport?templateId=501&labReqNo=' + labReqNo + "&patientLabExamIdParam=" + patientLabExamIdParam;		
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
		<h3>BLOOD CHEMISTRY
			<c:if test="${isUpdated == true}">
				&nbsp;&nbsp;&nbsp;
				<label style="color:blue; font-size:14px;">Record successfully updated!</label>
			</c:if>	
		</h3>
	</div>

	<form:form action="/lrmsweb/savePatientBloodChem" method="post" modelAttribute="patientBloodChem" cssClass="form-horizontal">
		
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
					<th>Test</th>
					<th>Result</th>
					<th>Normal Values</th>
					<th>Test</th>
					<th>Result</th>
					<th>Normal Values</th>
				</tr>
				<tr>
					<td>Glucose FBS</td>
					<td><form:input disabled="${isReleased}" path="fbs" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td align="center">76-110 mg/dl</td>
					<td>T3</td>
					<td><form:input disabled="${isReleased}" path="t3" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td align="center">70-184 ug/dl</td>
				</tr>
				<tr>
					<td align="right">RBS</td>
					<td><form:input disabled="${isReleased}" path="rbs" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td align="center">86-126 mg/dl</td>
					<td>T4</td>
					<td><form:input disabled="${isReleased}" path="t4" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td align="center">4-12 ug/dl</td>
				</tr>
				<tr>
					<td>Time Last</td>
					<td><form:input disabled="${isReleased}" path="timeLast" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td>Extraction:<form:input disabled="${isReleased}" path="extraction" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td>TSH</td>
					<td><form:input disabled="${isReleased}" path="tsh" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td></td>
				</tr>
				<tr>
					<td>HBAIC</td>
					<td><form:input disabled="${isReleased}" path="hbaic" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td align="center"></td>
					<td>Serum Na</td>
					<td><form:input disabled="${isReleased}" path="na" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td align="center">135-148 mmol/L</td>
				</tr>
				<tr>
					<td>Cholesterol</td>
					<td><form:input disabled="${isReleased}" path="chole" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td align="center">> - 200 mg/dl</td>
					<td>Serum K</td>
					<td><form:input disabled="${isReleased}" path="k" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td align="center">3.5-5.3 mmol/L</td>
				</tr>
				<tr>
					<td>Triglycerides</td>
					<td><form:input disabled="${isReleased}" path="trig" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td align="center">40-165 mg/dl</td>
					<td>Serum Ca</td>
					<td><form:input disabled="${isReleased}" path="ca" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td align="center">8.5-10.5 mg/dl</td>
				</tr>
				<tr>
					<td>HDL</td>
					<td><form:input disabled="${isReleased}" path="hdl" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td align="center">0.78-1.95 mmol/L</td>
					<td>Serum Cl</td>
					<td><form:input disabled="${isReleased}" path="cl" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td align="center"></td>
				</tr>
				<tr>
					<td>LDL</td>
					<td><form:input disabled="${isReleased}" path="ldl" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td align="center">1.56-4.55 mmol/L</td>
					<td>Amvlase</td>
					<td><form:input disabled="${isReleased}" path="amv" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td align="center"></td>
				</tr>
				<tr>
					<td>VLDL</td>
					<td><form:input disabled="${isReleased}" path="vldl" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td align="center">0-1.04 mmol/L</td>
					<td>Lipase</td>
					<td><form:input disabled="${isReleased}" path="lipase" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td align="center"></td>
				</tr>
				<tr>
					<td>Ratio</td>
					<td><form:input disabled="${isReleased}" path="ratio" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td align="center">Below 4.0</td>
					<td>Alkaline Phos</td>
					<td><form:input disabled="${isReleased}" path="alkaline" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td align="center"></td>
				</tr>
				<tr>
					<td>Uric Acid</td>
					<td><form:input disabled="${isReleased}" path="uricAcid" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td align="center">2.4-7.0 mg/dl</td>
					<td>Acid Phosoia</td>
					<td><form:input disabled="${isReleased}" path="acid" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td align="center"></td>
				</tr>
				<tr>
					<td>BUN</td>
					<td><form:input disabled="${isReleased}" path="bun" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td align="center">5-23 mg/dl</td>
					<td>Total Protein</td>
					<td><form:input disabled="${isReleased}" path="total" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td align="center">6.2-8.5 g/dl</td>
				</tr>
				<tr>
					<td>Creatinine</td>
					<td><form:input disabled="${isReleased}" path="creat" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td align="center">0.5-1.1 mg/dl</td>
					<td>Albumin</td>
					<td><form:input disabled="${isReleased}" path="albumin" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td align="center">3.5-5.0 g/dl</td>
				</tr>
				<tr>
					<td>SGOT</td>
					<td><form:input disabled="${isReleased}" path="sgot" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td align="center">0-42 IU/L</td>
					<td>Globulin</td>
					<td><form:input disabled="${isReleased}" path="globulin" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td align="center">2.4-3.0 g/dl</td>
				</tr>				
				<tr>
					<td>SGPT</td>
					<td><form:input disabled="${isReleased}" path="sgpt" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td align="center">0-41 IU/L</td>
					<td>A/G Ratio</td>
					<td><form:input disabled="${isReleased}"  path="agratio" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td align="center">1.4-2.1 g/dl</td>
				</tr>
				<tr height="40px;">
					<td>Remarks</td>
					<td colspan="6">
						<form:textarea disabled="${isReleased}" path="remarks" rows="2" cols="110" cssStyle="text-align: left; color: blue; font-weight: bold;"/>
					</td>
				</tr>
			</table>				
		</form:form>
</body>
</html>