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
  
    $("#roomNoId").focus();
    
  });
  

</script>



<div class="row">
	<div class="col-sm-2">
	
		<!-- Left Menu -->
		<div style="padding-top: 15px; padding-left: 12px;">
		  	<!-- jQuery ui -->
		  	<ul id="menu">
			  <li class="ui-widget-header">Menu</li>
			  <li onclick="goToAddRoom();"><a href="#">Add New Record</a></li>
			  <li onclick="goToRoom();"><a href="#">Search/Update Record</a></li>
			  <%@ include file="/template/menu_left_masterfile.jsp" %>
			</ul>
		</div>
	</div>
	
 	<div class="col-sm-10 divSpace">

		<div style="height: 30%; padding-top: 0px;" align="left">
		<h3>Room - Edit Record</h3>
			<html:form action="/room.do" styleId="idForm" >
				<fieldset>
				
					<div>
						<html:errors/>
					</div>
					<div>
						<h4 style="color: blue;"><c:out value="${roomForm.transactionMessage}"></c:out></h4>
					</div>
					
					<html:hidden property="id" value="${roomForm.id}"/>
					<table>
						<tr>
							<td><label  class="control-label" for="roomNo">Room No</label></td>
							<td style="padding-left: 5px;">
								<html:text styleId="roomNoId" property="roomNo" styleClass="input-large"  size="5" maxlength="10" value="${roomForm.roomNo}" disabled="${roomForm.transactionStatus}"></html:text><br>
							</td>
						</tr>
						<tr height="5px"></tr>
						<tr>
							<td><label  class="control-label" for="roomCategoryId">Room Category</label></td>
							<td style="padding-left: 5px;">
								<html:select  name="roomForm" property="roomCategoryId" disabled="${roomForm.transactionStatus}">
									 <html:option value="0">--Select--</html:option>
									 <html:optionsCollection name="roomForm" property="roomCategoryList" label="description" value="id"/>					 		
								</html:select>	
							</td>
						</tr>
						<tr height="5px"></tr>
						<tr>
							<td><label  class="control-label" for="buildingId">Building</label></td>
							<td style="padding-left: 5px;">
								<html:select  name="roomForm" property="buildingId" disabled="${roomForm.transactionStatus}" onchange="populateNoOfFloorByBuildingId(this.value);">
									 <html:option value="0">--Select--</html:option>
									 <html:optionsCollection name="roomForm" property="buildingList" label="description" value="id"/>					 		
								</html:select>	
							</td>
						</tr>
						<tr height="5px"></tr>
						<tr>
							<td><label  class="control-label" for="floorNo">Floor No</label></td>
							<td style="padding-left: 5px;">
								<div id="noOfFloorDIVId">
									<html:select  name="roomForm"  property="floorNo" disabled="${roomForm.transactionStatus}">
									 	<html:optionsCollection name="roomForm" property="noOfFloorList" label="value" value="id"/>	
									 </html:select>
								</div>						
							</td>
						</tr>
						<tr height="5px"></tr>
						<tr>
							<td><label  class="control-label" for="noOfBeds">No of Beds</label></td>
							<td style="padding-left: 5px;">
								<html:text styleId="noOfBedsId" property="noOfBeds" style="text-align: right;" styleClass="input-xlarge" size="1" value="${roomForm.noOfBeds}" disabled="${roomForm.transactionStatus}"></html:text><br>
							</td>
						</tr>
						<tr height="5px"></tr>
						<tr>
							<td><label  class="control-label" for="availableBeds">Available Beds:</label></td>
							<td style="padding-left: 5px;">
								<html:text styleId="noOfBedsId" property="availableBeds" style="text-align: right;" styleClass="input-xlarge" size="1" value="${roomForm.availableBeds}" disabled="${roomForm.transactionStatus}"></html:text><br>
							</td>
						</tr>
						<tr height="5px"></tr>
						<tr>
							<td valign="top"><label  class="control-label" for="description">Description</label></td>
							<td style="padding-left: 5px;">
								<html:textarea styleId="descriptionId" rows="3" property="description" cols="40" styleClass="input-xlarge"  value="${roomForm.description}" disabled="${roomForm.transactionStatus}"></html:textarea><br>
							</td>
						</tr>
						<tr height="15px"></tr>
						<tr>
							<td></td>
							<td style="padding-left: 5px;">
								<div class="control-group">
									<div class="controls">
										<c:choose>
											<c:when test="${roomForm.transactionStatus == true}">
												<html:button property="btnClose" styleClass="btn btn-primary" style="width: 100px;" onclick="goToRoom();" value="Close"></html:button>
											</c:when>
											<c:otherwise>
												<html:button property="btnUpdate" styleClass="btn btn-primary" style="width: 100px;" onclick="updateRoom();" value="Update"></html:button>
												&nbsp;&nbsp;
												<html:button property="btnCancel" styleClass="btn btn-primary" style="width: 100px;" onclick="goToRoom();" value="Cancel"></html:button>
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
	