

	function computeRetailSellingPrice(){
			
			if (Number($('#retailOrigPriceId').val()) > 0) {
				//check if percent or price mark-up amount
				let markupAmt = 0;
				if (Number($('#retailMarkupPercentId').val()) > 0) {
					markupAmt = Number($('#retailOrigPriceId').val()) * (Number($('#retailMarkupPercentId').val())/100);
				} else if (Number($('#retailMarkupPriceId').val()) > 0) {
					markupAmt = Number($('#retailMarkupPriceId').val());
				}				
				$('#retailSellingPriceId').val(Number($('#retailOrigPriceId').val())+markupAmt);
			}
		}
		
		function computeRetailSellingPriceByMarkupPercent(){
			if (Number($('#retailMarkupPercentId').val()) > 0) {
				$('#retailMarkupPriceId').val('');
			}
			computeRetailSellingPrice();				
		}
		
		function computeRetailSellingPriceByMarkupPrice(){
			if (Number($('#retailMarkupPriceId').val()) > 0) {
				$('#retailMarkupPercentId').val('');
			}
			computeRetailSellingPrice();
		}
		
		function computeWholesaleSellingPrice(){
			
			if (Number($('#wholesaleOrigPriceId').val()) > 0) {
				//check if percent or price mark-up amount
				let markupAmt = 0;
				if (Number($('#wholesaleMarkupPercentId').val()) > 0) {
					markupAmt = Number($('#wholesaleOrigPriceId').val()) * (Number($('#wholesaleMarkupPercentId').val())/100);
				} else if (Number($('#wholesaleMarkupPriceId').val()) > 0) {
					markupAmt = Number($('#wholesaleMarkupPriceId').val());
				}				
				$('#wholesaleSellingPriceId').val(Number($('#wholesaleOrigPriceId').val())+markupAmt);
			}
		}
		
		function computeWholesaleSellingPriceByMarkupPercent(){
			if (Number($('#wholesaleMarkupPercentId').val()) > 0) {
				$('#wholesaleMarkupPriceId').val('');
			}
			computeWholesaleSellingPrice();				
		}
		
		function computeWholesaleSellingPriceByMarkupPrice(){
			if (Number($('#wholesaleMarkupPriceId').val()) > 0) {
				$('#wholesaleMarkupPercentId').val('');
			}
			computeWholesaleSellingPrice();
		}
		
		function computeDiscountAmtByPercent(){
			if (Number($('#discountPercentId').val()) > 0) {
				let discountAmt = Number($('#retailOrigPriceId').val()) * (Number($('#discountPercentId').val())/100);
				$('#discountAmountId').val(discountAmt);
			}			
		}
		
		function removeDiscountPercent() {
			$('#discountPercentId').val('');
		}
			
		function isNumberKey(evt) {
	         var charCode = (evt.which) ? evt.which : event.keyCode
	         if ((charCode > 47 && charCode < 58) || charCode == 46 || charCode == 127) {
	        	return true;
	         } else {
	        	 return false;
	         } 
	    }