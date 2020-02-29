<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
	
	
<table>
	<tr>
		<td>			
			<input type="hidden" id="salesHeaderIdId" name="salesHeaderId" value="${salesHeaderId}">			
			<div class="table-responsive" style="width: 100%; padding: 10px 0px 10px 10px;">
				<table class="table table-striped table-hover table-bordered table-responsive" style="font-size: 9px;">
					<tr style="font-weight: bold;">
						<td width="40px">No</td>
						<td width="1500px">Item</td>
						<td width="50px">Qty</td>
						<td width="150px">Price</td>
						<td width="50px">Discount</td>
						<td width="50px">TotalSales</td>
						<td width="50px">TotalDiscount</td>
						<td width="150px">AmountDue</td>
						<c:if test="${tenderedAmount == null}">
							<td width="50px"></td>
						</c:if>
					</tr>
					<!-- loop here -->
					<c:forEach items="${salesDetails}" var="model" varStatus = "row">
						<tr height="30px">
							<td align="right">${row.count}</td>
							<td>${model.item}</td>
							<td align="right">${model.qty}</td>
							<td align="right"><fmt:formatNumber type="currency" currencySymbol="" value="${model.price}"  maxFractionDigits="2"></fmt:formatNumber></td>
							<td align="right"><fmt:formatNumber type="currency" currencySymbol="" value="${model.discount}" maxFractionDigits="2"></fmt:formatNumber></td>
							<td align="right"><fmt:formatNumber type="currency" currencySymbol="" value="${model.totalSales}" maxFractionDigits="2"></fmt:formatNumber></td>
							<td align="right"><fmt:formatNumber type="currency" currencySymbol="" value="${model.totalDiscount}" maxFractionDigits="2"></fmt:formatNumber></td>
							<td align="right"><fmt:formatNumber type="currency" currencySymbol="" value="${model.amountDue}" maxFractionDigits="2"></fmt:formatNumber></td>	
							<c:if test="${tenderedAmount == null}">
								<td align="center"><input type="button" value="Delete" onclick="deleteItem(${model.id},document.getElementById('salesHeaderIdId').value);"></td>
							</c:if>
						</tr>
					</c:forEach>
					<!-- extra rows for design -->
					<c:forEach var = "i" begin = "${salesDetailsSize}" end = "10">
						<c:if test="${i < 10}">
							<tr height="30px">
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<c:if test="${tenderedAmount == null}">
									<td></td>
								</c:if>
							</tr>
						</c:if>
					</c:forEach>					
								
				</table>						
			</div>
		</td>
		<td style="padding-left: 10px; vertical-align: top; padding-top: 10px;">
			<table>
				<tr>
					<td width="600px"><label style="font-size: 15px;">Total Sales:</label></td>
					<td><input type="text" readonly="readonly" id="totalSalesId" name="totalSales" style="height: 35px; width: 150px; font-size: 25px; text-align: right; color: blue;" value="<fmt:formatNumber type="currency" currencySymbol="" value="${totalSales}"  maxFractionDigits="2"></fmt:formatNumber>" ></td>
				</tr>
				<tr height="10px;"></tr>
				<tr>
					<td><label style="font-size: 15px;">Total Discount:</label></td>
					<td><input type="text" readonly="readonly" id="totalDiscountId" name="totalDiscount" style="height: 35px; width: 150px; font-size: 25px; text-align: right; color: blue;" value="<fmt:formatNumber type="currency" currencySymbol="" value="${totalDiscount}"  maxFractionDigits="2"></fmt:formatNumber>" ></td>
				</tr>
				<tr height="10px;"></tr>
				<tr>
					<td><label style="font-size: 15px;">Total Amount Due:</label></td>
					<td><input type="text" readonly="readonly" id="totalAmountDueId" name="totalAmountDue" style="height: 35px; width: 150px; font-size: 25px; text-align: right; color: blue;" value="<fmt:formatNumber type="currency" currencySymbol="" value="${totalAmountDue}"  maxFractionDigits="2"></fmt:formatNumber>" ></td>
				</tr>		
			</table>												
			<table id="paymentDIV" hidden="true">
				<tr height="10px"></tr>
				<tr>
					<td width="600px"><label style="font-size: 15px;">Tendered:</label></td>
					<td><input type="text" id="tenderedAmountId" style="height: 35px; width: 150px; font-size: 25px; text-align: right; color: blue;" onkeypress="payNow(event, document.getElementById('salesHeaderIdId').value, document.getElementById('totalSalesId').value, document.getElementById('totalDiscountId').value, document.getElementById('totalAmountDueId').value, this.value);" name="tenderedAmount" value="<fmt:formatNumber type="currency" currencySymbol="" value="${tenderedAmount}"  maxFractionDigits="2"></fmt:formatNumber>" ></td>
				</tr>
				<tr height="10px"></tr>
				<tr>
					<td><label style="font-size: 15px;">Change:</label></td>
					<td><input type="text" id="changeAmountId" readonly="readonly" name="changeAmount" style="height: 35px; width: 150px; font-size: 25px; text-align: right; color: blue;" value="<fmt:formatNumber type="currency" currencySymbol="" value="${changeAmount}"  maxFractionDigits="2"></fmt:formatNumber>" ></td>
				</tr>
			</table>
		</td>
	</tr>
</table>
