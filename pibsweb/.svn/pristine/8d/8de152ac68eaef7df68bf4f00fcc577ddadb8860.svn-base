<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
$(function() {
     

  });
</script>

<div class="row">
	   
 	<div class="col-sm-10" style="padding-left: 40px;">

		<div style="height: 30%; padding-top: 0px;" align="left">
			<h3 style="font-style: bold;">Billing</h3>
			<html:form action="/billing.do" styleId="idForm">
			
				<fieldset>
					<!--<legend>Billing</legend>--><!-- leave this as blank to show the line separator -->
				
						<div>
								<html:hidden property="id" value="${billingForm.id}"/>
                            	<table>
                            	    <tr>
                                    	<td><label style="width: 75px; font-weight: normal;">Patient:</label></td>
                                    	<td><label style="width: 200px; color: blue;">${billingForm.admission.patientFullName}</label></td>
                                    	<td><label style="width: 75px; font-weight: normal;">Age:</label></td>
                                    	<td><label style="width: 75px; color: blue;">${billingForm.admission.ageAdmitted}</label></td>
                                    </tr>
                                	<tr>
                                        <td><label style="width: 75px; font-weight: normal;">Case No:</label></td> 
                                        <td><label style="width: 200px; color: blue;">${billingForm.admission.caseNo}</label></td>
                                        <td><label style="width: 100px; font-weight: normal;">Date Admitted:</label></td>
                                        <td><label style="width: 120px; color: blue;">${billingForm.dateAdmitted}</label></td>
                                        <td><label style="width: 100px; font-weight: normal;">Time Admitted:</label></td>
                                        <td><label style="width: 95px; color: blue;">${billingForm.timeAdmitted}</label></td>          
                                        <td><html:button property="btnBack" styleClass="btn btn-primary btnBackToSearch" onclick="backToBillingSearch();" value="Back to Search"></html:button>	</td>
                                    	<td><html:button property="btnGoTo" styleClass="btn btn-primary btnGoTo" onclick="goToMonitorPatient('${billingForm.id}');" value="Go To Monitor Patient"></html:button>	</td>                                     
                                    </tr>
                                    <tr style="height: 5px;"></tr>
                                    <tr>
                                        <td><label style="width: 75px; font-weight: normal;">Room No:</label></td>
                                        <c:choose>
  	                                  		<c:when test="${billingForm.admission.roomNoTransfer != null}">
  	                                  			<td><label style="width: 200px; color: blue;">${billingForm.admission.roomNoTransfer}</label></td>
                                    		</c:when>
                                    		<c:otherwise>
                                    			<td><label style="width: 200px; color: blue;">${billingForm.admission.roomNo}</label></td>
                                    		</c:otherwise>
                                    	</c:choose>
                                    	<td><label style="width: 75px; font-weight: normal;">Doctor:</label></td>
                                    	<td colspan="3"><label style="width: 250px; color: blue;">${billingForm.admission.doctor}</label></td>                                                                 	                                   
                                     </tr>
                                </table>
						</div>
						<br>
						<div>
							<table>
								<tr>
									<td><html:button property="btnBillingSummary" styleClass="btn btn-primary btnMonitoringSmall" onclick="goToBilling('${billingForm.id}');" value="Summary"></html:button></td>
									<td><html:button property="btnBillingDiscount" styleClass="btn btn-primary btnMonitoringSmall" onclick="goToBillingDiscount('${billingForm.id}');" value="Discount"></html:button></td>
									<td><html:button property="btnBillingDetails" styleClass="btn btn-primary btnMonitoringMed" onclick="goToBillingDetails('${billingForm.id}','${billingForm.admission.caseNo}');" value="Generate Bill Details"></html:button></td>
									<td><html:button property="btnBillingPayments" styleClass="btn btn-primary btnMonitoringSmall" onclick="goToBillingPayment('${billingForm.id}','${billingForm.admission.caseNo}');" value="Payment"></html:button></td>
								</tr>
							</table>
						</div>
				</fieldset>	
			</html:form>
		</div>
		
		<!-- ajax part of child module data of monitor patient -->
		<div id="childDIV">
			<br>
			<fieldset>
				<legend>Summary</legend>
			</fieldset>
			  <!-- Room Fee -->
			  <div class="table-responsive" align="left" >
					<table>
						<tr>
							<td><span style="margin-left:10px;">Days Admitted:</span></td>
		                    <td><input style="text-align: right; width: 110px;" type="text" value="${billingForm.daysAdmitted}" readonly="readonly"></td>
							<td><span style="margin-left:20px;">Total Room Fee:</span></td>
		                    <td><input style="text-align: right; width: 110px;" type="text" value="${billingForm.totalAmtRoom}" readonly="readonly"></td>
					    	<td><span style="margin-left:20px;">Total Doctor Fee:</span></td>
		                    <td><input style="text-align: right; width: 110px;" type="text" value="${billingForm.totalAmtDoctor}" readonly="readonly"></td>
		                </tr>
		                <tr height="5px;"></tr>
						<tr>
							<td></td>
							<td></td>
					    	<td><span style="margin-left:20px;">Total Other Room Fee:</span></td>
		                    <td><input style="text-align: right; width: 110px;" type="text" value="${billingForm.totalAmtOtherRoom}" readonly="readonly"></td>							
					    	<td><span style="margin-left:20px;">Total Other Doctor Fee:</span></td>
		                    <td><input style="text-align: right; width: 110px;" type="text" value="${billingForm.totalAmtOtherDoctor}" readonly="readonly"></td>							

						</tr>
						<tr height="5px;"></tr>
						<tr>
							<td><span style="margin-left:10px;">Total Lab Fee:</span></td>
		                    <td><input style="text-align: right; width: 110px;" type="text" value="${billingForm.totalAmtLabExam}" readonly="readonly"></td>
					    	<td><span style="margin-left:20px;">Total Med Supply Fee:</span></td>
		                    <td><input style="text-align: right; width: 110px;" type="text" value="${billingForm.totalAmtMedSupply}" readonly="readonly"></td>
					    	<td><span style="margin-left:20px;">Total Radiology Fee:</span></td>
		                    <td><input style="text-align: right; width: 110px;" type="text" value="${billingForm.totalAmtRadiology}" readonly="readonly"></td>
					    </tr>
					    <tr height="5px;"></tr>
					    <tr>
					    	<td><span style="margin-left:10px;">Total Surgery Fee:</span></td>
		                    <td><input style="text-align: right; width: 110px;" type="text" value="${billingForm.totalAmtSurgery}" readonly="readonly"></td>
					    	<td><span style="margin-left:20px;">Total Add Services Fee:</span></td>
		                    <td><input style="text-align: right; width: 110px;" type="text" value="${billingForm.totalAmtAddServices}" readonly="readonly"></td>
					    	<td><span style="margin-left:20px;">Total Equipment Fee:</span></td>
		                    <td><input style="text-align: right; width: 110px;" type="text" value="${billingForm.totalAmtEquip}" readonly="readonly"></td>
						</tr>
						<tr height="15px;"></tr>
					    <tr>
					    	<td><span style="margin-left:10px;">Total Fee:</span></td>
		                    <td><input style="text-align: right; width: 110px;" type="text" value="${billingForm.totalAmtFee}" readonly="readonly"></td>
					    	<td><span style="margin-left:20px;">Total Discount:</span></td>
		                    <td><input style="text-align: right; width: 110px;" type="text" value="${billingForm.totalAmtDiscount}" readonly="readonly"></td>
					    	<td><span style="margin-left:20px;">Total Amount Due:</span></td>
		                    <td><input style="text-align: right; width: 110px;" type="text" value="${billingForm.totalAmtDue}" readonly="readonly"></td>
					    </tr>				
					</table>
			  </div>
			  <br>
			  
			  
		</div>
	
	
	</div>
	
</div>	
	