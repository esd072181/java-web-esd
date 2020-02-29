<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
$(function() {
    
    $('#dtDateOfBirth').datepicker({}); 
    $('#lastNameId').focus();
    
  });
</script>

<div style="padding-left: 20px;">
	<h3 style="font-style: bold;">Nursery - Edit Record</h3>
	<div>
		<html:errors/>
	</div>
	<div>
		<h5 style="color: blue;"><c:out value="${nurseryInquiryForm.transactionMessage}"></c:out></h5>
		<br>
	</div> 
	<html:form action="/saveMonitorNursery.do" styleId="idForm">
		<table>
			<html:hidden property="id" value="${nurseryInquiryForm.id}"/>
			<tr>
 				<td valign="top">Last Name</td>
        		<td style="padding-left: 5px;"><html:text  styleId="lastNameId" property="lastName" value="${nurseryInquiryForm.lastName}" disabled="${nurseryInquiryForm.transactionStatus}" ></html:text></td>
			</tr>
			<tr style="height: 10px;"></tr>
			<tr>
 				<td valign="top">First Name</td>
        		<td style="padding-left: 5px;"><html:text  property="firstName" value="${nurseryInquiryForm.firstName}" disabled="${nurseryInquiryForm.transactionStatus}" ></html:text></td>
        	</tr>
			<tr style="height: 10px;"></tr>
			<tr>
				<td valign="top">Date Of Birth</td>
				<td style="padding-left: 5px;">
					<c:choose>
						<c:when test="${nurseryInquiryForm.transactionStatus == true}">
							<input type="text"  name="dateOfBirth" id="dtDateOfBirth" value="${nurseryInquiryForm.dateOfBirth}" placeholder="mm/dd/yyyy" disabled="disabled"/>
						</c:when>
						<c:otherwise>
							<input type="text"  name="dateOfBirth" id="dtDateOfBirth" value="${nurseryInquiryForm.dateOfBirth}" placeholder="mm/dd/yyyy"/>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr style="height: 10px;"></tr>
			<tr>
				<td valign="top">Time Of Birth</td>
        		<td style="padding-left: 5px;"><html:text property="timeOfBirth" value="${nurseryInquiryForm.timeOfBirth}" disabled="${nurseryInquiryForm.transactionStatus}"></html:text></td>
			</tr>
			<tr style="height: 10px;"></tr>
			<tr>
 				<td valign="top">Gender</td>
        		<td style="padding-left: 5px;">
        			<html:select style="width: 180px;" styleClass="dropdownCol1" name="nurseryInquiryForm" property="gender" disabled="${nurseryInquiryForm.transactionStatus}" value="Male">
						<html:option value="0">--Select--</html:option>
						<html:optionsCollection name="nurseryInquiryForm" property="genderLOV" label="listValue" value="listValue"/>				 		
					</html:select>	
				</td>
        	</tr>
        	<tr style="height: 10px;"></tr>
        	<tr>
 				<td valign="top">Weight</td>
        		<td style="padding-left: 5px;"><html:text property="weight" value="${nurseryInquiryForm.weight}" disabled="${nurseryInquiryForm.transactionStatus}" ></html:text></td>
        	</tr>
        	<tr style="height: 10px;"></tr>
        	<tr>
 				<td valign="top">Remarks</td>
        		<td style="padding-left: 5px;"><html:text property="remarks" value="${nurseryInquiryForm.remarks}" disabled="${nurseryInquiryForm.transactionStatus}"></html:text></td>
        	</tr>
			<tr style="height: 20px;"></tr>
			<tr>
				<td colspan="2">
					<c:choose>
							<c:when test="${nurseryInquiryForm.transactionStatus == true}">
								<html:button property="btnClose" styleClass="btn btn-primary" onclick="goToNurseryInquirySearch();" value="Close"></html:button>
							</c:when>
							<c:otherwise>
								<html:button property="btnUpdate" styleClass="btn btn-primary" onclick="updateNurseryInquiry();" value="Update"></html:button>
								<html:button property="btnCancel" styleClass="btn btn-primary" onclick="goToNurseryInquirySearch();" value="Cancel"></html:button>
							</c:otherwise>
					</c:choose>	
				</td>			
			</tr>
		</table>	
	</html:form>

</div>

