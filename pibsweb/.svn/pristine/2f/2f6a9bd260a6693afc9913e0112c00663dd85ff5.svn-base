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
  
    $("#descriptionId").focus();
  
  });
  

</script>



<div class="row">
	<div class="col-sm-2">
	
		<!-- Left Menu -->
		<div style="padding-top: 15px; padding-left: 12px;">
		  	<!-- jQuery ui -->
		  	<ul id="menu">
			  <li class="ui-widget-header">Options</li>
			  <li onclick="goToAddBuilding();"><a href="#">Add New Record</a></li>
			  <li onclick="goToBuilding();"><a href="#">Search/Update Record</a></li>
			  <%@ include file="/template/menu_left_masterfile.jsp" %>
			</ul>
		</div>
	</div>
	
 	<div class="col-sm-10 divSpace">

		<div style="height: 30%; padding-top: 0px;" align="left">
		<h3>Building - Edit Record</h3>
			<html:form action="/updateBuilding.do" styleId="idForm" >
				<fieldset>
				
					<div>
						<html:errors/>
					</div>
					<div>
						<h4 style="color: blue;"><c:out value="${buildingForm.transactionMessage}"></c:out></h4>
					</div> 
					
					<html:hidden property="id" value="${buildingForm.id}"/>
					<table>
						<tr>
							<td><label  class="control-label" for="description">Description</label></td>
							<td style="padding-left: 5px;">
								<html:text styleId="descriptionId" property="description" styleClass="input-xlarge"  size="20" maxlength="20" value="${buildingForm.description}" disabled="${buildingForm.transactionStatus}"></html:text><br>
							</td>
						</tr>
						<tr height="5px"></tr>
						<tr>
							<td><label  class="control-label" for="nooffloor">No of Floor</label></td>
							<td style="padding-left: 5px;">
								<html:text property="nooffloor" styleClass="input-xlarge" style="text-align: right;" size="2" maxlength="2" value="${buildingForm.nooffloor}" disabled="${buildingForm.transactionStatus}"></html:text><br>
							</td>
						</tr>
						<tr height="5px"></tr>
						<tr>
							<td valign="top"><label  class="control-label" for="remarks">Remarks</label></td>
							<td style="padding-left: 5px;">
								<html:textarea styleId="remarksId" rows="3" property="remarks" cols="40" styleClass="input-xlarge"  value="${buildingForm.remarks}" disabled="${buildingForm.transactionStatus}"></html:textarea><br>
							</td>
						</tr>
						<tr height="15px"></tr>
							<tr>
								<td></td>
								<td style="padding-left: 5px;">
									<div class="control-group">
										<div class="controls">
											<c:choose>
												<c:when test="${buildingForm.transactionStatus == true}">
													<html:button property="btnClose" styleClass="btn btn-primary" style="width: 100px;" onclick="goToBuilding();" value="Close"></html:button>
												</c:when>
												<c:otherwise>
													<html:button property="btnUpdate" styleClass="btn btn-primary" style="width: 100px;" onclick="updateBuilding();" value="Update"></html:button>
													&nbsp;&nbsp;
													<html:button property="btnCancel" styleClass="btn btn-primary" style="width: 100px;" onclick="goToBuilding();" value="Cancel"></html:button>
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
	