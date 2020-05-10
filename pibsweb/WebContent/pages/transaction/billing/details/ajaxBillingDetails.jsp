<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
$(function() {

    
    
  });
</script>

	<h3>Bill Details</h3>

	 <!-- Billing report -->
	<div>
		<div>
			<a id="billReportId" href="#" target="_blank" onclick="viewBillingDetailsReport('${billingDetailsForm.caseNo}');" >Click here to view the Billing Details report</a>
		</div>
	</div>
	
	<html:hidden styleId="caseNoId" property="caseNo" value="${billingDetailsForm.caseNo}"/>
	  <div>
	    <h4 class="labelBlue">Total Summary</h4>
	  	<table>
			<tr>
				<td><span style="margin-left:10px;">Total Fee:</span></td>
		        <td><input style="text-align: right; width: 110px;" type="text" value="${billingDetailsForm.totalAmtFee}" readonly="readonly"></td>
				<td><span style="margin-left:20px;">Total Discount:</span></td>
		        <td><input style="text-align: right; width: 110px;" type="text" value="${billingDetailsForm.totalAmtDiscount}" readonly="readonly"></td>
				<td><span style="margin-left:20px;">Total Due:</span></td>
		        <td><input style="text-align: right; width: 110px;" type="text" value="${billingDetailsForm.totalAmtDue}" readonly="readonly"></td>
			</tr>				
		</table>	
	  </div>
	  
	  <br>			  
	  <!-- Room Fee -->
	  <div class="table-responsive" align="left" >
	  	<h4 class="labelBlue">Room</h4>
			<table>
				<tr>
					<td><span style="margin-left:10px;">Days Admitted:</span></td>
                    <td><input style="text-align: right; width: 30px;" type="text" value="${billingDetailsForm.daysAdmitted}" readonly="readonly"></td>
					<td><span style="margin-left:20px;">Rate/Day:</span></td>
                    <td><input style="text-align: right;" type="text" value="${billingDetailsForm.roomRate}" readonly="readonly"></td>
					<td><span style="margin-left:20px;">Total Room Fee:</span></td>
                    <td><input style="text-align: right;" type="text" value="${billingDetailsForm.totalAmtRoom}" readonly="readonly"></td>
				</tr>
			</table>
	  </div>
	  <br>
	  <!-- Doctor Fee -->
	  <div class="table-responsive" align="left" >
	  	<h4 class="labelBlue">Doctor</h4>
			<table>
				<tr>
					<td><span style="margin-left:10px;">Days Admitted:</span></td>
                    <td><input style="text-align: right; width: 30px;" type="text" value="${billingDetailsForm.daysAdmitted}" readonly="readonly"></td>
					<td><span style="margin-left:20px;">Rate/Day:</span></td>
                    <td><input style="text-align: right;" type="text" value="${billingDetailsForm.doctorFee}" readonly="readonly"></td>
				    <td><span style="margin-left:20px;">Total Doctor Fee:</span></td>
                    <td><input style="text-align: right;" type="text" value="${billingDetailsForm.totalAmtDoctor}" readonly="readonly"></td>
				</tr>
			</table>
	  </div>
	  <!-- Other Room -->
	  <div class="table-responsive" align="left" >
		<c:if test="${billingDetailsForm.otherRoomList != null}">
			<br>
			<h4 class="labelBlue">Other Room</h4>
			<table  id="tableId" class="table table-bordered table-striped table-condensed table-hover context-menu-table" style="width: 98%;">  
				<tr>
					<th>RoomNo</th>
					<th>Category</th>
					<th>Days</th>
					<th>Fee</th>
					<th>Amount</th>
					<th>Date Used</th>
					<th>Time Used</th>
				</tr>
				<logic:iterate name="billingDetailsForm" property="otherRoomList" type="com.pibs.model.MonitorRoom" id="model">
					<tr>
						<td><bean:write name="model" property="roomNo"/></td>				 
						<td><bean:write name="model" property="roomCategory"/></td>
						<td align="right"><bean:write name="model" property="days"/></td>
						<td align="right"><bean:write name="model" property="fee" format="Php #,###.00"/></td>
						<td align="right"><bean:write name="model" property="amount" format="Php #,###.00"/></td>
						<td><bean:write name="model" property="dateUsed"/></td>
						<td><bean:write name="model" property="timeUsed"/></td>
					</tr>
				</logic:iterate>
			</table>
				<tr>
				    <td>Total Amount for Other Room:</td>
                    <td><input style="text-align: right;" type="text" value="${billingDetailsForm.totalAmtOtherRoom}" readonly="readonly"></td>
				</tr>
			</table>
		</c:if>
	  </div>
	  	  
	  <!-- Other Doctor -->
	  <div class="table-responsive" align="left" >
		<c:if test="${billingDetailsForm.otherDoctorList != null}">
			<br>
			<h4 class="labelBlue">Other Doctor/Professional</h4>
			<table  id="tableId" class="table table-bordered table-striped table-condensed table-hover context-menu-table" style="width: 98%;">  
				<tr>
					<th>Name</th>
					<th>Specialization</th>
					<th>Days</th>
					<th>Fee</th>
					<th>Amount</th>
					<th>Date Attended</th>
					<th>Time Attended</th>
				</tr>
				<logic:iterate name="billingDetailsForm" property="otherDoctorList" type="com.pibs.model.MonitorDoctor" id="model">
					<tr>
						<td><bean:write name="model" property="name"/></td>				 
						<td><bean:write name="model" property="specialization"/></td>
						<td align="right"><bean:write name="model" property="days"/></td>
						<td align="right"><bean:write name="model" property="fee" format="Php #,###.00"/></td>
						<td align="right"><bean:write name="model" property="amount" format="Php #,###.00"/></td>
						<td><bean:write name="model" property="dateAttended"/></td>
						<td><bean:write name="model" property="timeAttended"/></td>
					</tr>
				</logic:iterate>
			</table>
			<table>
				<tr>
				    <td>Total Amount for Other Doctor/Professional:</td>
                    <td><input style="text-align: right;" type="text" value="${billingDetailsForm.totalAmtOtherDoctor}" readonly="readonly"></td>
				</tr>
			</table>
		</c:if>
	  </div>
	  
	  <!-- Laboratory Examinations -->
	  <div class="table-responsive" align="left" >
		<c:if test="${billingDetailsForm.labExamList != null}">
			<br>
			<h4 class="labelBlue">Laboratory Examinations</h4>
			<table  id="tableId" class="table table-bordered table-striped table-condensed table-hover context-menu-table" style="width: 98%;">  
				<tr>
					<th>Description</th>
					<th>Qty</th>
					<th>Fee</th>
					<th>Amount</th>
				</tr>
				<logic:iterate name="billingDetailsForm" property="labExamList" type="com.pibs.model.MonitorLaboratoryExamination" id="model">
					<tr>				 
						<td><bean:write name="model" property="itemDescription"/></td>				 
						<td align="right"><bean:write name="model" property="qty"/></td>
						<td align="right"><bean:write name="model" property="fee" format="Php #,###.00"/></td>
						<td align="right"><bean:write name="model" property="amount" format="Php #,###.00"/></td>					
					</tr>
				</logic:iterate>
			</table>
			<table>
				<tr>
				    <td>Total Amount for Lab Exam:</td>
                    <td><input style="text-align: right;" type="text" value="${billingDetailsForm.totalAmtLabExam}" readonly="readonly"></td>
				</tr>
			</table>
		</c:if>
	  </div>
	  <!-- Medical Supply -->
	  <div class="table-responsive" align="left" >
		<c:if test="${billingDetailsForm.medSupplyList != null}">
			<br>
			<h4 class="labelBlue">Medical Supply Used</h4>
			<table  id="tableId" class="table table-bordered table-striped table-condensed table-hover context-menu-table" style="width: 98%;">  
				<tr>
					<th>Description</th>
					<th>Type</th>
					<th>Qty</th>
					<th>Price</th>
					<th>Amount</th>
				</tr>
				<logic:iterate name="billingDetailsForm" property="medSupplyList" type="com.pibs.model.MonitorMedicalSupply" id="model">
					<tr>
						<td><bean:write name="model" property="itemDescription"/></td>
						<td><bean:write name="model" property="itemType"/></td>						
						<td align="right"><bean:write name="model" property="qty"/></td>
						<td align="right"><bean:write name="model" property="price" format="Php #,###.00"/></td>
						<td align="right"><bean:write name="model" property="amount" format="Php #,###.00"/></td>
					</tr>
				</logic:iterate>
			</table>
			<table>
				<tr>
				    <td>Total Amount for Medical Supply:</td>
                    <td><input style="text-align: right;" type="text" value="${billingDetailsForm.totalAmtMedSupply}" readonly="readonly"></td>
				</tr>
			</table>
		</c:if>
	  </div>
	  <!-- Radiology -->
	  <div class="table-responsive" align="left" >
		<c:if test="${billingDetailsForm.radiologyList != null}">
			<br>
			<h4 class="labelBlue">Radiology</h4>
			<table  id="tableId" class="table table-bordered table-striped table-condensed table-hover context-menu-table" style="width: 98%;">  
				<tr>
					<th>Description</th>
					<th>Type</th>
					<th>Qty</th>
					<th>Fee</th>
					<th>Amount</th>
				</tr>
				<logic:iterate name="billingDetailsForm" property="radiologyList" type="com.pibs.model.MonitorRadiology" id="model">
					<tr>			 
						<td><bean:write name="model" property="itemDescription"/></td>
						<td><bean:write name="model" property="itemType"/></td>
						<td align="right"><bean:write name="model" property="qty"/></td>
						<td align="right"><bean:write name="model" property="fee" format="Php #,###.00"/></td>
						<td align="right"><bean:write name="model" property="amount" format="Php #,###.00"/></td>
					</tr>
				</logic:iterate>
			</table>
			<table>
				<tr>
				    <td>Total Amount for Radiology:</td>
                    <td><input style="text-align: right;" type="text" value="${billingDetailsForm.totalAmtRadiology}" readonly="readonly"></td>
				</tr>
			</table>
		</c:if>
	   </div>
	    <!-- Surgery -->
	   <div class="table-responsive" align="left" >
		<c:if test="${billingDetailsForm.surgeryList != null}">
			<br>
			<h4 class="labelBlue">Surgery</h4>
			<table  id="tableId" class="table table-bordered table-striped table-condensed table-hover context-menu-table" style="width: 98%;">  
				<tr>
					<th>Description</th>
					<th>Qty</th>
					<th>Fee</th>
					<th>Amount</th>
				</tr>
				<logic:iterate name="billingDetailsForm" property="surgeryList" type="com.pibs.model.MonitorSurgery" id="model">
					<tr>			 
						<td><bean:write name="model" property="itemDescription"/></td>
						<td align="right"><bean:write name="model" property="qty"/></td>
						<td align="right"><bean:write name="model" property="fee" format="Php #,###.00"/></td>
						<td align="right"><bean:write name="model" property="amount" format="Php #,###.00"/></td>				
					</tr>
				</logic:iterate>
			</table>
			<table>
				<tr>
				    <td>Total Amount for Surgery:</td>
                    <td><input style="text-align: right;" type="text" value="${billingDetailsForm.totalAmtSurgery}" readonly="readonly"></td>
				</tr>
			</table>
		</c:if>
	   </div>
		 <!-- Additional Services -->
	   <div class="table-responsive" align="left" >
		<c:if test="${billingDetailsForm.additionalServicesList != null}">
			<br>
			<h4 class="labelBlue">Additional Services</h4>
			<table  id="tableId" class="table table-bordered table-striped table-condensed table-hover context-menu-table" style="width: 98%;">  
				<tr>
					<th>Description</th>
					<th>Category</th>
					<th>Qty</th>
					<th>Fee</th>
					<th>Amount</th>
				</tr>
				<logic:iterate name="billingDetailsForm" property="additionalServicesList" type="com.pibs.model.MonitorAdditionalServices" id="model">
					<tr>			 
						<td><bean:write name="model" property="itemDescription"/></td>
						<td><bean:write name="model" property="itemType"/></td>	
						<td align="right"><bean:write name="model" property="qty"/></td>
						<td align="right"><bean:write name="model" property="fee" format="Php #,###.00"/></td>
						<td align="right"><bean:write name="model" property="amount" format="Php #,###.00"/></td>
					</tr>
				</logic:iterate>
			</table>
			<table>
				<tr>
				    <td>Total Amount for Additional Services:</td>
                    <td><input style="text-align: right;" type="text" value="${billingDetailsForm.totalAmtAddServices}" readonly="readonly"></td>
				</tr>
			</table>
		</c:if>
	   </div>
		<!-- Equipment -->
	   <div class="table-responsive" align="left" >
		<c:if test="${billingDetailsForm.equipmentList != null}">
			<br>
			<h4 class="labelBlue">Equipment Used</h4>
			<table  id="tableId" class="table table-bordered table-striped table-condensed table-hover context-menu-table" style="width: 98%;">  
				<tr>
					<th>Name</th>
					<th>Qty</th>
					<th>Fee</th>
					<th>Amount</th>
				</tr>
				<logic:iterate name="billingDetailsForm" property="equipmentList" type="com.pibs.model.MonitorEquipment" id="model">
					<tr>
						<td><bean:write name="model" property="itemName"/></td>				 
						<td align="right"><bean:write name="model" property="qty"/></td>
						<td align="right"><bean:write name="model" property="fee" format="Php #,###.00"/></td>
						<td align="right"><bean:write name="model" property="amount" format="Php #,###.00"/></td>
					</tr>
				</logic:iterate>
			</table>
			<table>
				<tr>
				    <td>Total Amount for Equipment:</td>
                    <td><input style="text-align: right;" type="text" value="${billingDetailsForm.totalAmtEquip}" readonly="readonly"></td>
				</tr>
			</table>
		</c:if>
	   </div>
		<!-- Discount  -->
	   <div class="table-responsive" align="left" > 
		<c:if test="${billingDetailsForm.discountList != null}">
			<br>
			<h4 class="labelBlue">Discount</h4>
			<table  id="tableId" class="table table-bordered table-striped table-condensed table-hover context-menu-table" style="width: 98%;">  
				<tr>
					<th>Description</th>
					<th>Amount</th>
				</tr>
				<logic:iterate name="billingDetailsForm" property="discountList" type="com.pibs.model.BillingDiscount" id="model">
					<tr>		 
						<td><bean:write name="model" property="discountDescription"/></td>
						<td align="right"><bean:write name="model" property="amount" format="Php #,###.00"/></td>
					</tr>
				</logic:iterate>
			</table>
			<table>
				<tr>
				    <td>Total Amount for Discount:</td>
                    <td><input style="text-align: right;" type="text" value="${billingDetailsForm.totalAmtDiscount}" readonly="readonly"></td>
				</tr>
			</table>
		</c:if>
	   </div>
	 

