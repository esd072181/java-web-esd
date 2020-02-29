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
			window.location.href = 'showLabExamReport?templateId=502&labReqNo=' + labReqNo + "&patientLabExamIdParam=" + patientLabExamIdParam;	
		}
	</script>
</head>
<body>

	<div>
		<h4>URINALYSIS</h4>
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
	
		<form:form action="/lrmsweb/savePatientUrinalysis" method="post" modelAttribute="patientUrinalysis" cssClass="form-horizontal">
		
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
					<th colspan="2">PHYSICAL EXAMINATION</th>
					<th colspan="2">MICROSCOPIC EXAMINATION</th>
					<th colspan="2" ></th>
				</tr>
				<tr>
					<td>Color</td>
					<td><form:input disabled="${isReleased}" path="color" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td>CELLS</td>
					<td><form:input disabled="${isReleased}" path="cells" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/>/hpf</td>
					<td colspan="2" align="center" style="background-color: yellow; color: blue;"><label style="font-weight: bold;">CRYSTALS</label></td>
				</tr>
				<tr>
					<td>Transparency</td>
					<td><form:input disabled="${isReleased}" path="transparency" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td>Red Blood Cells</td>
					<td><form:input disabled="${isReleased}" path="rbc" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/>/hpf</td>
					<td>Amorphous Urate</td>
					<td><form:input disabled="${isReleased}" path="amorphurate" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
				</tr>
				<tr>
					<td>Reaction</td>
					<td><form:input disabled="${isReleased}" path="reaction" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td>Pus Cells</td>
					<td><form:input disabled="${isReleased}" path="pusCells" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td>Uric Acid</td>
					<td><form:input disabled="${isReleased}" path="uricAcid" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
				</tr>		
				<tr>
					<td>pH</td>
					<td><form:input disabled="${isReleased}" path="ph" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td>Epithelial Cells</td>
					<td><form:input disabled="${isReleased}" path="epiCells" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td>Calcium Oxalates</td>
					<td><form:input disabled="${isReleased}" path="calcium" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
				</tr>					
				<tr>
					<td>Specific Gravity</td>
					<td><form:input disabled="${isReleased}" path="specificGravity" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td>Mucous Threads</td>
					<td><form:input disabled="${isReleased}" path="mucThreads" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td>Amorphous Phosphates</td>
					<td><form:input disabled="${isReleased}" path="amorPhphosphates" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
				</tr>
				<tr>
					<td>Chemical Test</td>
					<td><form:input disabled="${isReleased}" path="chemicalTest" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td>Yeast Cells</td>
					<td><form:input disabled="${isReleased}" path="yeastCells" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/>/hpf</td>
					<td>Triple Phosphates</td>
					<td><form:input disabled="${isReleased}" path="triple" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
				</tr>
				<tr>
					<td>GLUCOSE</td>
					<td><form:input disabled="${isReleased}" path="glucose" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td>Renal Cells</td>
					<td><form:input disabled="${isReleased}" path="renalCells" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td>Others</td>
					<td><form:input disabled="${isReleased}" path="others2" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
				</tr>
				<tr>
					<td>PROTEIN</td>
					<td><form:input disabled="${isReleased}" path="protein" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td>Bacteria</td>
					<td><form:input disabled="${isReleased}" path="bacteria" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td colspan="2"></td>
				</tr>				
				<tr>
					<td>Urobilinogen</td>
					<td><form:input disabled="${isReleased}" path="urobili" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td>Others</td>
					<td><form:input disabled="${isReleased}" path="others1" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td colspan="2"></td>
				</tr>	
				<tr>
					<td>Bilirubin</td>
					<td><form:input disabled="${isReleased}" path="bili" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td colspan="2" align="center">CASTS</td>
					<td colspan="2">OTHERS:</td>
				</tr>				
				<tr>
					<td>Ketone</td>
					<td><form:input disabled="${isReleased}" path="ketone" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td>Hyaline</td>
					<td><form:input disabled="${isReleased}" path="hyaline" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td>Pregnancy Test</td>
					<td><form:input disabled="${isReleased}" path="pregtest" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
				</tr>	
				<tr>
					<td>Nitrite</td>
					<td><form:input disabled="${isReleased}" path="nitrite" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td>Granular</td>
					<td><form:input disabled="${isReleased}" path="granular" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
					<td colspan="2"></td>
				</tr>
				<tr>
					<td colspan="2"></td>
					<td>Waxy</td>
					<td><form:input disabled="${isReleased}" path="waxy" cssClass="form-control input-sm" cssStyle="text-align: center; color: blue; font-weight: bold;"/></td>
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