<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
$(function() {
	
    $("#totalAmtCashId").focus();
    
  });
</script>


	<h3>Payment</h3>

	  <div>
		<html:errors/>
	  </div>
	  <div>
		<h5 style="color: blue;"><c:out value="${billingPaymentForm.transactionMessage}"></c:out></h5>
	  </div>
	  <div>
	 <html:form action="/saveBillingPayment.do" styleId="idForm">
	  	<table>
			<tr>
				<html:hidden property="billingId" value="${billingPaymentForm.billingId}"/>
				<td><span style="margin-left:10px;">Amount Due:</span></td>
		        <td style="padding-left: 5px;"><input style="text-align: right; width: 110px;" type="text"  name="totalAmtDue" value="${billingPaymentForm.totalAmtDue}" readonly="readonly"></td>
			</tr>
			<tr height="5px;">
			<tr>	
				<td><span style="margin-left:10px;">Cash Payment:</span></td>
				<c:choose>
					<c:when test="${billingPaymentForm.transactionStatus == false}">
						<td style="padding-left: 5px;"><input style="text-align: right; width: 110px;" type="text" name="totalAmtCash" value="${billingPaymentForm.totalAmtCash}" id="totalAmtCashId"></td>
					</c:when>
					<c:otherwise>
						<td style="padding-left: 5px;"><input style="text-align: right; width: 110px;" type="text" name="totalAmtCash" value="${billingPaymentForm.totalAmtCash}" id="totalAmtCashId" readonly="readonly"></td>
					</c:otherwise>
				</c:choose>
			</tr>
			<c:if test="${billingPaymentForm.transactionStatus == true}">
				<tr height="5px;">
				<tr>
					<td><span style="margin-left:10px;">Change:</span></td>
		        	<td style="padding-left: 5px;"><input style="text-align: right; width: 110px;" type="text" name="totalAmtChange" value="${billingPaymentForm.totalAmtChange}" readonly="readonly"></td>
				</tr>	
			</c:if>
		</table>
	  </html:form>	
	  </div>
	  <br>
	  <div>
						
		<table>
			<tr>
				<c:choose>		
					<c:when test="${billingPaymentForm.transactionStatus == false}">	
						<td><html:button property="btnBillingPaymentSubmit" styleClass="btn btn-primary btnMonitoringMed" onclick="saveBillingPayment();" value="Submit Payment"></html:button></td>
					</c:when>
					<c:otherwise>
						<td><html:button property="btnBillingPaymentClose" styleClass="btn btn-primary btnMonitoringMed" onclick="closeBillingPayment();" value="Close Payment"></html:button></td>
					</c:otherwise>
				</c:choose>
			</tr>
		</table>
	</div> 
	 
	<!-- ajax part of child module data of monitor patient -->
	<div id="childDIV">
		
	</div>


