<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>SIMS - Retail POS</title>
	<script type="text/javascript" src="resources/js/jquery-1.11.1.js" ></script>
 	<script type="text/javascript" src="resources/js/jquery-ui.min.js" ></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/bootbox.js"></script>
	<link rel="stylesheet" href="resources/style/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="resources/style/jquery-ui.css">
	<style type="text/css">
		.error {
			color: red;
		}
	</style>
	<script>
		$(function() {
		  // Handler for .ready() called.
		    $('#itemCodeId').prop('disabled', true);
		    $('#itemDescriptionId').prop('disabled', true);
		    $('#qtyId').prop('disabled', true);
		    $('#paymentId').hide();
		    $('#paymentDIV').hide();
		    $('#cancelTransactionId').hide();
			$('#newTransactionId').focus();
		});
		
		
		document.onkeydown = function (e) {
			  if (e.keyCode === 116) { //Disable the F5 Refresh
			     return false;
			  } else if (e.keyCode === 113) { //F2 for New Transaction
				  newTransaction();
			  	return false;
			  } else if (e.keyCode === 115) { //F4 for Cancel Transaction
				  cancelTransaction(document.getElementById('salesHeaderIdId').value);
			  	return false;
			  } else if (e.keyCode === 121) { //F10 for Payment Transaction
				  showPaymentDIV();
				  return false;
			  }
			};
		
		function newTransaction() {
			//ajaxCall
			$.ajax({
			  type: "GET",
			  url: "newTransaction",
			  cache: false
			})
			  .done(function( result ) {
				$("#salesDetailDIV").html(result);
				$('#itemCodeId').prop('disabled', false);
				$('#itemDescriptionId').prop('disabled', false);
				$('#qtyId').prop('disabled', false);
				$('#qtyId').val('1');	
				$('#paymentId').show();
				$('#cancelTransactionId').show();
				$('#newTransactionId').hide();
				$('#itemCodeId').focus();
			  });
		}

		//search by ItemCode
		function searchItem(e, itemCode, qty, salesHeaderId) {
			var code = e.keyCode ? e.keyCode : e.which;
			if (code == 13) {
				//ajaxCall
				$.ajax({
				  type: "GET",
				  url: "saveSalesDetail",
				  cache: false,
				  data: { itemCode:itemCode, qty:qty, salesHeaderId:salesHeaderId }
				})
				  .done(function( result ) {
					$("#salesDetailDIV").html(result);
					$('#qtyId').val('1');	
					$('#itemCodeId').val('').focus();
				  });
				
				//window.location.href = 'saveSalesDetail?itemCode=' + itemCode + '&isNewTransaction=' + $('#isNewTransactionId').val() ;
				//$('#qtyId').val(1);	
			}
		}
		
		function searchItemByDescription(e, itemDescription) {
			var code = e.keyCode ? e.keyCode : e.which;
			if (code == 13) {
				//ajaxCall
				$.ajax({
				  type: "GET",
				  url: "searchItemByDescription",
				  cache: false,
				  data: { itemDescription:itemDescription }
				})
				  .done(function( result ) {
					$("#resultListDIV").html(result);
				  });
				
			}
		}
		
		//search by ItemCode
		function saveSalesDetail(itemCode, qty, salesHeaderId) {
				//ajaxCall
				$.ajax({
				  type: "GET",
				  url: "saveSalesDetail",
				  cache: false,
				  data: { itemCode:itemCode, qty:qty, salesHeaderId:salesHeaderId }
				})
				  .done(function( result ) {
					$("#resultListDIV").html('');
					$("#salesDetailDIV").html(result);
					$('#qtyId').val('1');
					$('#itemDescriptionId').val('');
					$('#itemCodeId').val('').focus();
				  });
		}
		
		function deleteItem(salesDetailsId,salesHeaderId) {

			$.ajax({
				  type: "GET",
				  url: "deleteSalesDetails",
				  cache: false,
				  data: { salesDetailsId:salesDetailsId, salesHeaderId:salesHeaderId }
				})
				  .done(function( result ) {
					$("#salesDetailDIV").html(result);
					$('#qtyId').val('1');	
					$('#itemCodeId').val('').focus();
				  });
			
		}
		
		function showPaymentDIV() {
			 $('#paymentDIV').show();
			 $('#tenderedAmountId').focus();
		}
		
		function payNow(e, salesHeaderId, totalSales, totalDiscount, totalAmountDue, tenderedAmount) {
						
			var code = e.keyCode ? e.keyCode : e.which;
			if (code == 13) {
	
				//validation for payment
				if (Number(totalAmountDue) > Number(tenderedAmount)) {
					alert("Invalid Tendered Amount!");
					$('#tenderedAmountId').focus();
					return false;			
				} else {
					$.ajax({
						  type: "GET",
						  url: "payNow",
						  cache: false,
						  data: { salesHeaderId: salesHeaderId, 
							      totalSales: totalSales.trim(),
							      totalDiscount: totalDiscount.trim(),
							      totalAmountDue: totalAmountDue.trim(),
							      tenderedAmount: tenderedAmount.trim() }
						})
						  .done(function( result ) {
							$("#salesDetailDIV").html(result);
							$('#paymentDIV').show();
							$('#itemCodeId').prop('disabled', true);
							$('#qtyId').prop('disabled', true);
							$('#qtyId').val('');
							$('#tenderedAmountId').prop('disabled', true);
							$('#qtyId').prop('disabled', true);
							$('#paymentId').hide();
							$('#cancelTransactionId').hide();
							$('#newTransactionId').show();
							$('#newTransactionId').focus();
						  });
					
				}
				
			}

		}
		
		function cancelTransaction(salesHeaderId) {
			var ans = confirm("Are you sure you want to cancel this transaction?");
			if (ans == true) {
				$.ajax({
					  type: "GET",
					  url: "cancelTransaction",
					  cache: false,
					  data: { salesHeaderId: salesHeaderId }
					})
					  .done(function( result ) {
						$("#salesDetailDIV").html(result);
						$('#paymentDIV').hide();
						$('#itemCodeId').prop('disabled', true);
						$('#itemDescriptionId').prop('disabled', false);
						$('#qtyId').prop('disabled', true);
						$('#qtyId').val('');
						$('#paymentId').hide();
						$('#cancelTransactionId').hide();
						$('#newTransactionId').show();
						$('#newTransactionId').focus();
					  });
			}
		}
		
		function focusQty(e) {
			var code = e.keyCode ? e.keyCode : e.which;
			if (code == 120) { //F9
				//focus to qty
				$('#qtyId').val('');	
				$('#qtyId').focus();
				return false;
			}
		}
		
		function focusItemCode(e) {
			var code = e.keyCode ? e.keyCode : e.which;
			if (code == 119) { //F8
				$('#itemCodeId').focus();
				return false;
			} 
		}
		
	</script>
</head>
<body>

	<div style="width: 100%;">
	
		<div align="left" style="padding: 10px 10px 0px 10px;">
			<a href="./goToMain" >Back to Home</a>
		</div>
		
		<br>
		 
		<div align="left">
			<span style="padding-left: 10px;">
				<input style="height: 40px; width: 180px; font-weight: bold;" type="button" id="newTransactionId" name="newTransaction" value="F2 - New Transaction" onclick="newTransaction();">
			</span>
			<span style="padding-left: 20px;">
				<input style="height: 40px; width: 180px; font-weight: bold;" type="button" id="paymentId" name="payment" value="F10 - Payment" onclick="showPaymentDIV()">
			</span>
			<span style="padding-left: 20px;">
				<input style="height: 40px; width: 180px; font-weight: bold;" type="button" id="cancelTransactionId" name="cancel" value="F4 - Cancel Transaction" onclick="cancelTransaction(document.getElementById('salesHeaderIdId').value);">
			</span>
		</div>
		
		<br>
	
		<div align="left" style="padding-left: 10px;">
			<div>	
				&nbsp;&nbsp;
				<label>Qty:</label>
		      	<input type="text" id="qtyId" name="qty" style="width: 35px; text-align: right;" onkeydown="focusItemCode(event);"/>	
		      	&nbsp;&nbsp;
				<label>Item Code:</label>
		      	<input type="text" id="itemCodeId" name="itemCode" onkeydown="focusQty(event);" onkeypress="searchItem(event, this.value, document.getElementById('qtyId').value, document.getElementById('salesHeaderIdId').value);"/>	
				&nbsp;&nbsp;
				<label>Item Description:</label>
		      	<input type="text" id="itemDescriptionId" name="itemDescription" onkeydown="focusQty(event);" onkeypress="searchItemByDescription(event, this.value);"/>	

	    	</div>
		</div>
		
		<br>
		<div id="resultListDIV"></div>
		<br>
	
		<div id="salesDetailDIV"  style="width: 90%;">
		
			<table>
				<tr>
					<td>
						
						<input type="hidden" id="salesHeaderIdId" name="salesHeaderId">
						<div class="table-responsive" style="width: 100%; padding: 10px 0px 10px 10px;">
							<table class="table table-striped table-hover table-bordered table-responsive" style="font-size: 14px;">
								<tr style="font-weight: bold;">
									<td width="40px">Item</td>
									<td width="1500px">Description</td>
									<td width="50px">Qty</td>
									<td width="150px">Price</td>
									<td width="50px">Discount</td>
									<td width="50px">TotalAmount</td>
									<td width="50px">TotalDiscount</td>
									<td width="150px">AmountDue</td>
								</tr>
								<c:forEach var="i" begin="1" end="10"> 
									<tr height="30px">
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
									</tr>				
								</c:forEach>
							</table>						
						</div>
						
					</td>
					
				</tr>
			
			</table>
			
		</div>


	</div>

</body>
</html>