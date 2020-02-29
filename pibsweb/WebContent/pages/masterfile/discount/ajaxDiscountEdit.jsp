<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
$(function() {
    $( "#menu" ).menu({
      items: "> :not(.ui-widget-header)"
    });
  
  //limit the characters in textarea Remarks field
    $("#remarksId").keyup(function(){
        if($(this).val().length > remarksLength){
            $(this).val($(this).val().substr(0, remarksLength));
    	}
    });
  
    $('#dtDateApproved').datepicker({}); 
    
    $("#standardAmountId").keydown(function (e) {
        // Allow: backspace, delete, tab, escape, enter and .
        if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110, 190]) !== -1 ||
             // Allow: Ctrl/cmd+A
            (e.keyCode == 65 && (e.ctrlKey === true || e.metaKey === true)) ||
             // Allow: Ctrl/cmd+C
            (e.keyCode == 67 && (e.ctrlKey === true || e.metaKey === true)) ||
             // Allow: Ctrl/cmd+X
            (e.keyCode == 88 && (e.ctrlKey === true || e.metaKey === true)) ||
             // Allow: home, end, left, right
            (e.keyCode >= 35 && e.keyCode <= 39)) {
                 // let it happen, don't do anything
                 return;
        }
        // Ensure that it is a number and stop the keypress
        if ( (e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || (e.keyCode > 105)) ) {
            e.preventDefault();
        }   
    });
    
    $("#standardPercentageId").keydown(function (e) {
        // Allow: backspace, delete, tab, escape, enter and .
        if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110, 190]) !== -1 ||
             // Allow: Ctrl/cmd+A
            (e.keyCode == 65 && (e.ctrlKey === true || e.metaKey === true)) ||
             // Allow: Ctrl/cmd+C
            (e.keyCode == 67 && (e.ctrlKey === true || e.metaKey === true)) ||
             // Allow: Ctrl/cmd+X
            (e.keyCode == 88 && (e.ctrlKey === true || e.metaKey === true)) ||
             // Allow: home, end, left, right
            (e.keyCode >= 35 && e.keyCode <= 39)) {
                 // let it happen, don't do anything
                 return;
        }
        // Ensure that it is a number and stop the keypress
        if ( (e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || (e.keyCode > 105)) ) {
            e.preventDefault();
        }   
    });
    
    $('#descriptionId').focus();
    
  });
  
</script>



<div class="row">
	<div class="col-sm-2">
	
		<!-- Left Menu -->
		<div style="padding-top: 15px; padding-left: 12px;">
		  	<!-- jQuery ui -->
		  	<ul id="menu">
			  <li class="ui-widget-header">Menu</li>
			  <li onclick="goToDiscount();"><a href="#">Search/Update Record</a></li>
			  <li onclick="goToAddDiscount();"><a href="#">Add New Record</a></li>
			  <%@ include file="/template/menu_left_masterfile.jsp" %>
			</ul>
		</div>
	</div>
	
 	<div class="col-sm-10 divSpace">

		<div style="height: 30%; padding-top: 0px;" align="left">
		<h3>Discount - Edit Record</h3>
			<html:form action="/discount.do" styleId="idForm" >
				<fieldset>
				
					<div>
						<html:errors/>
					</div>
					<div>
						<h4 style="color: blue;"><c:out value="${discountForm.transactionMessage}"></c:out></h4>
					</div> 
					
					<html:hidden property="id" value="${discountForm.id}"/>
					<table>
						<tr>
							<td valign="top"><label  class="control-label" for="description">Description</label></td>
							<td style="padding-left: 5px;">
								<html:textarea styleId="descriptionId" rows="3" property="description" cols="40" styleClass="input-xlarge"  value="${discountForm.description}" disabled="${discountForm.transactionStatus}"></html:textarea><br>
							</td>
						</tr>
						<tr height="5px;"></tr>
						<tr>
							<td valign="top"><label  class="control-label" for="remarks">Remarks</label></td>
							<td style="padding-left: 5px;">
								<html:textarea styleId="remarksId" rows="3" property="remarks" cols="40" styleClass="input-xlarge"  value="${discountForm.remarks}" disabled="${discountForm.transactionStatus}"></html:textarea><br>
							</td>
						</tr>
						<tr height="5px;"></tr>
						<tr>
							<td><label class="control-label top-spacing" for="dateApproved">Date Approved</label></td>
							<td style="padding-left: 5px;">
								<c:choose>
									<c:when test="${discountForm.transactionStatus == true}">
										<input style="text-align: right;" type="text" name="dateApproved" id="dtDateApproved" value="${discountForm.dateApproved}" placeholder="mm/dd/yyyy" disabled="disabled" />	
									</c:when>
									<c:otherwise>
										<input style="text-align: right;" type="text" name="dateApproved" id="dtDateApproved" value="${discountForm.dateApproved}" placeholder="mm/dd/yyyy" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>	
						<tr height="5px;"></tr>
						<tr>
							<td><label  class="control-label" for="standardAmount">Standard Amount (Php)</label></td>
							<td style="padding-left: 5px;">
								<html:text style="text-align: right;" styleId="standardAmountId" property="standardAmount" styleClass="input-xlarge"  size="20" maxlength="20" value="${discountForm.standardAmount}" disabled="${discountForm.transactionStatus}"></html:text><br>
							</td>
						</tr>	
						<tr height="5px;"></tr>
						<tr>
							<td><label  class="control-label" for="standardPercentage">Standard Percentage (%)</label></td>
							<td style="padding-left: 5px;">
								<html:text style="text-align: right;" styleId="standardPercentageId" property="standardPercentage" styleClass="input-xlarge"  size="20" maxlength="20" value="${discountForm.standardPercentage}" disabled="${discountForm.transactionStatus}"></html:text><br>
							</td>
						</tr>	
						<tr height="15px"></tr>
						<tr>
							<td></td>
							<td style="padding-left: 5px;">
								<div class="control-group">
									<div class="controls">
										<c:choose>
											<c:when test="${discountForm.transactionStatus == true}">
												<html:button property="btnClose" styleClass="btn btn-primary" style="width: 100px;" onclick="goToDiscount();" value="Close"></html:button>
											</c:when>
											<c:otherwise>
												<html:button property="btnUpdate" styleClass="btn btn-primary" style="width: 100px;" onclick="updateDiscount();" value="Update"></html:button>
												&nbsp;&nbsp;
												<html:button property="btnCancel" styleClass="btn btn-primary" style="width: 100px;" onclick="goToDiscount();" value="Cancel"></html:button>
											</c:otherwise>
										</c:choose>						
									</div>							
								</div>
							</td>
						</tr>				
					</table>

				</fieldset>				

			</html:form>
		</div>
	
	</div>
	
</div>	
	