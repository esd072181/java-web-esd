<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
$(function() {
    $( "#menu" ).menu({
      items: "> :not(.ui-widget-header)"
    });

    $("#feeId").keydown(function (e) {
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
    
    $("#entityNameId").focus();
    
  });
  


</script>

<div class="row">
	<div class="col-sm-2">
	
		<!-- Left Menu -->
		<div style="padding-top: 15px; padding-left: 12px;">
		  	<!-- jQuery ui -->
		  	<ul id="menu">
			  <li class="ui-widget-header">Menu</li>
			  <li onclick="goToAddEquipment();"><a href="#">Add New Record</a></li>
			  <li onclick="goToEquipment();"><a href="#">Search/Update Record</a></li>
		  	  <%@ include file="/template/menu_left_masterfile.jsp" %>
			</ul>
		</div>
	</div>
	
 	<div class="col-sm-10 divSpace">

		<div style="height: 30%; padding-top: 0px;" align="left">
			<h3>Equipment - Add New Record</h3>
			<html:form action="/equipment.do" styleId="idForm">
			
				<fieldset>
				
					<div>
						<html:errors/>
					</div>
					<div>
						<h4 style="color: blue;"><c:out value="${equipmentForm.transactionMessage}"></c:out></h4>
					</div> 
					
					<table>
						<tr>
							<td><label  class="control-label" for="entityName">Name</label></td>
							<td style="padding-left: 5px;">
								<html:text styleId="entityNameId" property="entityName" styleClass="input-xlarge"  size="20" maxlength="20" value="${equipmentForm.entityName}" disabled="${equipmentForm.transactionStatus}"></html:text><br>
							</td>
						</tr>
						<tr height="5px;"></tr>
						<tr>
							<td><label  class="control-label" for="description">Description</label></td>
							<td style="padding-left: 5px;">
								<html:textarea styleId="descriptionId" rows="3" property="description" cols="40" styleClass="input-xlarge"  value="${equipmentForm.description}" disabled="${equipmentForm.transactionStatus}"></html:textarea><br>
							</td>
						</tr>
						<tr height="5px;"></tr>
						<tr>
							<td><label  class="control-label" for="fee">Fee (Php)</label></td>
							<td style="padding-left: 5px;">
								<html:text style="text-align: right;" styleId="feeId" property="fee" styleClass="input-xlarge"  size="20" maxlength="20" value="${equipmentForm.fee}" disabled="${equipmentForm.transactionStatus}"></html:text><br>
							</td>
						</tr>
						<tr height="15px"></tr>
						<tr>
							<td></td>
							<td style="padding-left: 5px;">
								<div class="control-group">
									<div class="controls">
										<c:choose>
											<c:when test="${equipmentForm.transactionStatus == true}">
												<html:button property="btnAddNew" styleClass="btn btn-primary" onclick="goToAddEquipment();" value="Add New Record"></html:button>
												&nbsp;&nbsp;
												<html:button property="btnClose" styleClass="btn btn-primary" style="width: 100px;" onclick="goToEquipment();" value="Close"></html:button>
											</c:when>
											<c:otherwise>
												<html:button property="btnSave" styleClass="btn btn-primary" style="width: 100px;" onclick="saveEquipment();" value="Save"></html:button>
												&nbsp;&nbsp;
												<html:button property="btnCancel" styleClass="btn btn-primary" style="width: 100px;" onclick="goToEquipment();" value="Cancel"></html:button>
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
	