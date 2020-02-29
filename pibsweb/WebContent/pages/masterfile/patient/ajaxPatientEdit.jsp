<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
$(function() {
    $( "#menu" ).menu({
      items: "> :not(.ui-widget-header)"
    });
    
    $('#dtBirthdayPicker').datepicker({}); 
    $('#dtDateRegisteredPicker').datepicker({});
    
    $('#lastNameId').focus();
    
  });
  
 
//limit the characters in textarea Remarks field
$("#remarksId").keyup(function(){
    if($(this).val().length > remarksLength){
        $(this).val($(this).val().substr(0, remarksLength));
	}
});
</script>



<div class="row">
  
  <!-- Left Menu for Master File  -->
  <div class="col-sm-2">
	<div style="padding-top: 15px; padding-left: 12px;">
	  	<!-- jQuery ui -->
	  	<ul id="menu">
		  	<li class="ui-widget-header">Menu</li>
		  	<li onclick="goToPatient();"><a href="#">Search/Update Record</a></li>
		  	<%@ include file="/template/menu_left_masterfile.jsp" %>		  
		</ul>
	</div>
  </div>
   	
 	<div class="col-sm-10" style="padding-left: 40px;">

		<div style="height: 30%; padding-top: 0px;" align="left">
		<h3 style="font-style: bold;">Patient - Edit Record</h3>
			<html:form action="/patient.do" styleId="idForm" >
				<fieldset>
				
					<div>
						<html:errors/>
					</div>
					<div>
						<h5 style="color: blue;"><c:out value="${patientForm.transactionMessage}"></c:out></h5>
					</div> 
					
					
					<html:hidden property="id" value="${patientForm.id}"/>
					<table>
						<tr>
							<td><label>Patient Id</label></td>
							<td style="padding-left: 5px;">
								<input type="text" id="patientIdId" name="patientId" class="input-xlarge textboxCol1"  size="30" maxlength="30" value="${patientForm.patientId}" readonly="readonly" placeholder="auto-generated"/>
							</td>
						</tr>
						<tr height="15px;"></tr>
						<tr>
							<td><label class="control-label labelCol1" for="lastName">Last Name</label></td>
							<td style="padding-left: 5px;">
								<html:text styleId="lastNameId" property="lastName" styleClass="input-xlarge textboxCol1"  size="30" maxlength="30" value="${patientForm.lastName}" disabled="${patientForm.transactionStatus}"></html:text>
							</td>
							<td style="padding-left: 5px;"><label class="control-label labelCol1" for="firstName">First Name</label></td>
							<td style="padding-left: 5px;">
								<html:text styleId="firstNameId" property="firstName" styleClass="input-xlarge textboxCol1"  size="30" maxlength="30" value="${patientForm.firstName}" disabled="${patientForm.transactionStatus}"></html:text>
							</td>
							<td width="100px;" align="right"><label>Middle Name</label></td>
							<td style="padding-left: 5px;">
								<html:text  styleId="middleNameId" property="middleName" styleClass="input-xlarge textboxCol1"  size="30" maxlength="30" value="${patientForm.middleName}" disabled="${patientForm.transactionStatus}"></html:text>
							</td>
						</tr>
						<tr height="5px;"></tr>
						<tr>
							<td><label  class="control-label labelCol1" for="gender">Gender</label></td>
							<td style="padding-left: 5px;">
							    <html:select styleClass="dropdownCol1" name="patientForm" property="gender" disabled="${patientForm.transactionStatus}" value="Male">
									 <html:option value="0">--Select--</html:option>
									 <html:optionsCollection name="patientForm" property="genderLOV" label="listValue" value="listValue"/>				 		
								</html:select>							
							</td>
						</tr>
						<tr height="5px;"></tr>
						<tr>
							<td><label class="control-label labelCol1" for="birthday">Birthday</label></td>
							<td style="padding-left: 5px;" colspan="2">
								<c:choose>
									<c:when test="${patientForm.transactionStatus}">
										<input style="text-align: right;" type="text" class="textboxCol1" name="birthday" id="dtBirthdayPicker" value="${patientForm.birthday}" placeholder="mm/dd/yyyy" disabled="disabled"/>
									</c:when>
									<c:otherwise>
										<input style="text-align: right;" type="text" class="textboxCol1" name="birthday" id="dtBirthdayPicker" value="${patientForm.birthday}" placeholder="mm/dd/yyyy" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr height="5px;"></tr>
						<tr>
							<td><label class="control-label labelCol1" for="contactNo">Contact No</label></td>
							<td style="padding-left: 5px;">
								<html:text styleId="contactNoId" property="contactNo" styleClass="input-xlarge textboxCol1"  size="30" maxlength="30" value="${patientForm.contactNo}" disabled="${patientForm.transactionStatus}"></html:text>
							</td>
						</tr>
						<tr height="5px;"></tr>
						<tr>
							<td valign="top"><label class="control-label labelCol1" for="address">Address</label></td>
							<td  style="padding-left: 5px;" colspan="3">
								<html:textarea styleId="addressId" rows="3" property="address" cols="40" styleClass="input-xlarge"  value="${patientForm.address}" disabled="${patientForm.transactionStatus}"></html:textarea>
							</td>
						</tr>
						<tr height="5px;"></tr>
						<tr>
							<td colspan="2"><label>Contact Person details below:</label></td>
						</tr>
						<tr>
							<td><label class="control-label labelCol2" for="contactPerson">Name</label></td>
							<td style="padding-left: 5px;">
								<html:text styleId="contactPersonId" property="contactPerson" styleClass="input-xlarge textboxCol2"  size="30" maxlength="30" value="${patientForm.contactPerson}" disabled="${patientForm.transactionStatus}"></html:text>
							</td>
						</tr>
						<tr height="5px;"></tr>
						<tr>
							<td><label class="control-label labelCol2" for="contactPersonNo">Contact No</label></td>
							<td style="padding-left: 5px;">
								<html:text styleId="contactPersonNoId" property="contactPersonNo" styleClass="input-xlarge textboxCol2"  size="30" maxlength="30" value="${patientForm.contactPersonNo}" disabled="${patientForm.transactionStatus}"></html:text>
							</td>
						</tr>
						<tr height="5px;"></tr>
						<tr>
							<td><label  class="control-label labelCol2" for="patientStatusId">Patient Status:</label></td>
							<td style="padding-left: 5px;">
								<html:select  styleClass="dropdownCol1" name="patientForm" property="patientStatusId"  value="${patientForm.patientStatusId}" disabled="${patientForm.transactionStatus}">
									<html:option value="0">--Select--</html:option>
									<html:optionsCollection name="patientForm" property="patientStatusLOV" label="listValue" value="id"/>				 		
								</html:select>
							</td>
						</tr>
						<tr height="15px"></tr>				
						<tr>
							<td></td>
							<td style="padding-left: 5px;" colspan="2">
								<div class="control-group">
									<div class="controls">
										<c:choose>
											<c:when test="${patientForm.transactionStatus == true}">
												<html:button property="btnClose" styleClass="btn btn-primary" style="width: 100px;" onclick="goToPatient();" value="Close"></html:button>
											</c:when>
											<c:otherwise>
												<html:button property="btnUpdate" styleClass="btn btn-primary" style="width: 100px;" onclick="updatePatient();" value="Update"></html:button>
												&nbsp;&nbsp;
												<html:button property="btnCancel" styleClass="btn btn-primary" style="width: 100px;" onclick="cancelPatientEdit();" value="Cancel"></html:button>
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
	