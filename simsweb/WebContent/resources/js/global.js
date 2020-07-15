

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
				//check if item is VATable
				if ($('#vatId').prop('checked') == true) {
					let vatAmt = Number($('#retailSellingPriceId').val()) * (12/100);
					$('#retailSellingPriceId').val(Number($('#retailSellingPriceId').val())+vatAmt);
				}
				$('#retailSellingPriceId').val(Math.round((Number($('#retailSellingPriceId').val()) + Number.EPSILON) * 100) / 100);
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
		
		function computeSellingPrice() {
			computeRetailSellingPrice();
			computeWholesaleSellingPrice();
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
				//check if item is VATable
				if ($('#vatId').prop('checked') == true) {
					let vatAmt = Number($('#wholesaleSellingPriceId').val()) * (12/100);
					$('#wholesaleSellingPriceId').val(Number($('#wholesaleSellingPriceId').val())+vatAmt);
				}
				$('#wholesaleSellingPriceId').val(Math.round((Number($('#wholesaleSellingPriceId').val()) + Number.EPSILON) * 100) / 100);
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
		
		function filterSubCategory(category) {
			
			$.ajax({
					type: "GET",
					url: "/simsweb/filterSubCategoryList?categoryId=" + category.value,
					cache: false
				})
			  .done(function( result ) {
				$("#subCategoryDIVId").html(result);
			});
			
		}