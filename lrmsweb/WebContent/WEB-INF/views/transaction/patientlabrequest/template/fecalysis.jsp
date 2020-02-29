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
			window.location.href = 'showLabExamReport?templateId=503&labReqNo=' + labReqNo + "&patientLabExamIdParam=" + patientLabExamIdParam;		
		}
	</script>
</head>
<body>

	<div>
		<h4>FECALYSIS</h4>
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
	
		<form:form action="/lrmsweb/savePatientFecalysis" method="post" modelAttribute="patientFecalysis" cssClass="form-horizontal">
		
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

	
			<table border="1">
				<tr style="background-color: yellow; color: blue;">
					<th colspan="6">PHYSICAL EXAMINATION</th>
				</tr>
				<tr>
					<td>Color</td>
					<td><form:input disabled="${isReleased}" path="color" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td>OCCULT BLOOD</td>
					<td><form:input disabled="${isReleased}" path="occultBlood" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/>/hpf</td>
					<td colspan="2"></td>
				</tr>
				<tr>
					<td>Consistency</td>
					<td><form:input disabled="${isReleased}" path="consistency" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td>Others</td>
					<td><form:input disabled="${isReleased}" path="others1" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/>/hpf</td>
					<td colspan="2"></td>
				</tr>
				<tr>
					<th colspan="6" style="background-color: yellow;"><label style="color:blue;font-weight: bold;">MICROSCOPIC EXAMINATION</label></th>
				</tr>		
				<tr>
					<td>Pus Cells</td>
					<td><form:input disabled="${isReleased}" path="pusCells" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/>/hpf</td>
					<td colspan="4" align="center">PARASITES/OVA</td>
				</tr>					
				<tr>
					<td>Red Blood Cells</td>
					<td><form:input disabled="${isReleased}" path="rbc" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/>/hpf</td>
					<td>Ascaris L</td>
					<td><form:input disabled="${isReleased}" path="ascarisl" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td colspan="2">Flagellates</td>
				</tr>
				<tr>
					<td>Fat Globules</td>
					<td><form:input disabled="${isReleased}" path="fatGlobules" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/>/hpf</td>
					<td>Trichiuris T</td>
					<td><form:input disabled="${isReleased}" path="trichiurist" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/>/hpf</td>
					<td>G. Lamblia</td>
					<td><form:input disabled="${isReleased}" path="glamblia" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/>/hpf</td>
				</tr>
				<tr>
					<td>Macrophage</td>
					<td><form:input disabled="${isReleased}" path="macrophage" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td>Enterobius V.</td>
					<td><form:input disabled="${isReleased}" path="enterobiusv" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/>/hpf</td>
					<td>T. Hominis</td>
					<td><form:input disabled="${isReleased}" path="thominis" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/>/hpf</td>
				</tr>
				<tr>
					<td>Yeast Cells</td>
					<td><form:input disabled="${isReleased}" path="yeastCells" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/>/hpf</td>
					<td>Hookworm</td>
					<td><form:input disabled="${isReleased}" path="hookWorm" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/>/hpf</td>
					<td>Strongyloides</td>
					<td><form:input disabled="${isReleased}" path="strongyloides" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/>/hpf</td>
				</tr>				
				<tr>
					<td>Others</td>
					<td><form:input disabled="${isReleased}" path="others2" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td colspan="2">Amoeba</td>
					<td>Others</td>
					<td><form:input disabled="${isReleased}" path="others3" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
				</tr>	
				<tr>
					<td colspan="2"></td>
					<td>E. Coli</td>
					<td><form:input disabled="${isReleased}" path="ecoli" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/>/hpf</td>
					<td colspan="2" align="center"></td>
				</tr>				
				<tr>
					<td colspan="2"></td>
					<td>E. Hystolyitica</td>
					<td><form:input disabled="${isReleased}" path="ehistolytica" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/>/hpf</td>
					<td colspan="2"></td>
				</tr>	
				<tr height="40px;">
					<td>Remarks</td>
					<td colspan="6">
						<form:textarea disabled="${isReleased}" path="remarks" rows="2" cols="115" cssStyle="text-align: left; color: blue; font-weight: bold;"/>
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