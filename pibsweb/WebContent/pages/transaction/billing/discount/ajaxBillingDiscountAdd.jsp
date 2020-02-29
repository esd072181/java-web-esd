<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
$(function() {
    
    $('#amountId').focus();
    
  });
</script>

<div>
	<h3 style="font-style: bold;">Discount Request</h3>
	<div>
		<html:errors/>
	</div>
	<div>
		<h5 style="color: blue;"><c:out value="${billingDiscountForm.transactionMessage}"></c:out></h5>
	</div> 
	<html:form action="/saveBillingDiscount.do" styleId="idFormChild">
		<table>
			<html:hidden property="patientCaseSystemId" value="${billingDiscountForm.patientCaseSystemId}"/>
			<html:hidden property="discountId" value="${billingDiscountForm.discountId}"/>
			<tr>
 				<td>Description</td>
        		<td class="padLeft5"><input type="text" name="discountDescription" value="${billingDiscountForm.discountDescription}" readonly="readonly"></td>
        	</tr>
			<tr class="hMargin5"></tr>
			<tr>
 				<td>Amount</td>
        		<td class="padLeft5"><input style="text-align: right;" id="amountId" type="text" name="amount" value="${billingDiscountForm.amount}" ></td>
			</tr>
			<tr class="hMargin10"></tr>
			<tr>
				<td colspan="2">
					<c:choose>
						<c:when test="${billingDiscountForm.transactionStatus == true}">
							<html:button property="btnClose" styleClass="btn btn-primary btnCancelClose" onclick="closeBillingDiscount();" value="Close"></html:button>		
						</c:when>
						<c:otherwise>
							<html:button property="btnSave" styleClass="btn btn-primary btnSaveUpdate" onclick="saveBillingDiscount();" value="Save"></html:button>
							<html:button property="btnCancel" styleClass="btn btn-primary btnCancelClose" onclick="cancelBillingDiscount('${billingDiscountForm.patientCaseSystemId}');" value="Cancel"></html:button>	
						</c:otherwise>
					</c:choose>	
				</td>			
			</tr>
		</table>	
	</html:form>

</div>

