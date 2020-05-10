<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
$(function() {
     

  });
</script>

<div style="padding-left: 10px;">
		
		<h3 style="font-style: bold;">Billing</h3>
			
		<html:form action="/billing.do" styleId="idForm">
				
				<hr>
				<!-- Patient Info -->
				<div>
							<html:hidden property="id" value="${billingForm.id}"/>
                            <table>
                            		<tr>
                            		    <td><label style="width: 112px; padding-left: 5px;">Name:</label></td>
                                    	<td><input type="text" style="width: 200px; color: blue;" value="${billingForm.admission.patientFullName}" readonly="readonly"/></td>
                                    	<td><label style="width: 112px; padding-left: 5px;">Age:</label></td>
                                    	<td><input type="text" style="width: 200px; color: blue;" value="${billingForm.admission.ageAdmitted}"></td>
                            		</tr>
                            		<tr style="height: 5px;" ></tr>
                                    <tr>
                                    	<td><label style="width: 112px; padding-left: 5px;">Room:</label></td>
                                    	<c:choose>
  	                                  		<c:when test="${billingForm.admission.roomNoTransfer != null}">
  	                                  			<td><input type="text" style="width: 200px; color: blue;" value="${billingForm.admission.roomNoTransfer}"></td>
                                    		</c:when>
                                    		<c:otherwise>
                                    			<td><input type="text" style="width: 200px; color: blue;" value="${billingForm.admission.roomNo}"></td>	
                                    		</c:otherwise>
                                    	</c:choose>
                                    	<td><label style="width: 112px; padding-left: 5px;">Doctor:</label></td>
                                    	<td colspan="3"><input type="text" style="width: 200px; color: blue; padding-left: 5px;" value="${billingForm.admission.doctor}"></td>	                 
                                    </tr>
                                    <tr style="height: 5px;" ></tr>
                                	<tr>
                                        <td><label style="width: 112px; padding-left: 5px;">Date Admitted:</label></td>
                                        <td><input type="text" style="width: 200px; color: blue;" value="${billingForm.dateAdmitted}"></td>
                                        <td><label style="width: 112px; padding-left: 5px;">Time Admitted:</label></td>
                                        <td><input type="text" style="width: 200px; color: blue; padding-left: 5px;" value="${billingForm.timeAdmitted}"></td>
                                        <td><label style="width: 73px; padding-left: 5px;">Case No:</label></td> 
                                        <td><input type="text" style="width: 200px; color: blue;" value="${billingForm.admission.caseNo}"></td>                                           
                                    </tr>
                             </table>                                
					</div>
						
					<hr>
				
					<!-- Buttons -->
					<div>
						<table>
							<tr>
								<td colspan="10">
									<html:button property="btnBillingSummary" styleClass="btn btn-primary btnMonitoringSmall" onclick="goToBilling('${billingForm.id}');" value="Summary"></html:button>
									<html:button property="btnBillingDiscount" styleClass="btn btn-primary btnMonitoringSmall" onclick="goToBillingDiscount('${billingForm.id}');" value="Discount"></html:button>
									<html:button property="btnBillingDetails" styleClass="btn btn-primary btnMonitoringMed" onclick="goToBillingDetails('${billingForm.id}','${billingForm.admission.caseNo}');" value="Generate Bill Details"></html:button>
									<html:button property="btnBillingPayments" styleClass="btn btn-primary btnMonitoringSmall" onclick="goToBillingPayment('${billingForm.id}','${billingForm.admission.caseNo}');" value="Payment"></html:button>
									 <html:button property="btnBack" styleClass="btn btn-primary btnBackToSearch" onclick="backToBillingSearch();" value="Back to Search"></html:button>
                                	<html:button property="btnGoTo" styleClass="btn btn-primary btnGoTo" onclick="goToMonitorPatient('${billingForm.id}');" value="Go To Monitor Patient"></html:button>                                     
    							</td>
							</tr>
						</table>
					</div>
			</html:form>
		</div>
		
		<hr>
		
		<!-- ajax part of child module data of monitor patient -->
		<div id="childDIV" style="padding-left: 10px;">
			<h3>Summary</h3>
			 
			  <div class="table-responsive" align="left" >
					<table>
						<tr>
							<td><label style="margin-left:10px;">Days Admitted:</label></td>
		                    <td><input style="text-align: right; width: 110px;" type="text" value="${billingForm.daysAdmitted}" readonly="readonly"></td>
							<td><label style="margin-left:20px;">Total Room Fee:</label></td>
		                    <td><input style="text-align: right; width: 110px;" type="text" value="${billingForm.totalAmtRoom}" readonly="readonly"></td>
					    	<td><label style="margin-left:20px;">Total Doctor Fee:</label></td>
		                    <td><input style="text-align: right; width: 110px;" type="text" value="${billingForm.totalAmtDoctor}" readonly="readonly"></td>
		                </tr>
		                <tr height="5px;"></tr>
						<tr>
							<td></td>
							<td></td>
					    	<td><label style="margin-left:20px;">Total Other Room Fee:</label></td>
		                    <td><input style="text-align: right; width: 110px;" type="text" value="${billingForm.totalAmtOtherRoom}" readonly="readonly"></td>							
					    	<td><label style="margin-left:20px;">Total Other Doctor Fee:</label></td>
		                    <td><input style="text-align: right; width: 110px;" type="text" value="${billingForm.totalAmtOtherDoctor}" readonly="readonly"></td>							

						</tr>
						<tr height="5px;"></tr>
						<tr>
							<td><label style="margin-left:10px;">Total Lab Fee:</label></td>
		                    <td><input style="text-align: right; width: 110px;" type="text" value="${billingForm.totalAmtLabExam}" readonly="readonly"></td>
					    	<td><label style="margin-left:20px;">Total Med Supply Fee:</label></td>
		                    <td><input style="text-align: right; width: 110px;" type="text" value="${billingForm.totalAmtMedSupply}" readonly="readonly"></td>
					    	<td><label style="margin-left:20px;">Total Radiology Fee:</label></td>
		                    <td><input style="text-align: right; width: 110px;" type="text" value="${billingForm.totalAmtRadiology}" readonly="readonly"></td>
					    </tr>
					    <tr height="5px;"></tr>
					    <tr>
					    	<td><label style="margin-left:10px;">Total Surgery Fee:</label></td>
		                    <td><input style="text-align: right; width: 110px;" type="text" value="${billingForm.totalAmtSurgery}" readonly="readonly"></td>
					    	<td><label style="margin-left:20px;">Total Add Services Fee:</label></td>
		                    <td><input style="text-align: right; width: 110px;" type="text" value="${billingForm.totalAmtAddServices}" readonly="readonly"></td>
					    	<td><label style="margin-left:20px;">Total Equipment Fee:</label></td>
		                    <td><input style="text-align: right; width: 110px;" type="text" value="${billingForm.totalAmtEquip}" readonly="readonly"></td>
						</tr>
						<tr height="15px;"></tr>
					    <tr>
					    	<td><label style="margin-left:10px;">Total Fee:</label></td>
		                    <td><input style="text-align: right; width: 110px;" type="text" value="${billingForm.totalAmtFee}" readonly="readonly"></td>
					    	<td><label style="margin-left:20px;">Total Discount:</label></td>
		                    <td><input style="text-align: right; width: 110px;" type="text" value="${billingForm.totalAmtDiscount}" readonly="readonly"></td>
					    	<td><label style="margin-left:20px;">Total Amount Due:</label></td>
		                    <td><input style="text-align: right; width: 110px;" type="text" value="${billingForm.totalAmtDue}" readonly="readonly"></td>
					    </tr>				
					</table>
			  </div>
			  <br>
			  
			  
		</div>

	