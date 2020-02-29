<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div>
		
	<div align="left">
		<html:button property="command" onclick="goBackToMobileMain();" value="Back To Main" styleClass="btn btn-primary" style="font-size: 34px;"></html:button>
	</div>
	<br>
	<div align="left">
		<h4 style="font-family: Tahoma; font-size: 60px; font-weight: bolder;">
			Change Username/Password
		</h4>
	</div>
	
	<hr>
	
	<div style="font-size: 34px; color: red;">
		<html:errors />
	</div>
	<div>
		<h4 style="color: blue; font-size: 30px;">
			<c:out value="${changeUsernameForm.transactionMessage}"></c:out>
		</h4>
	</div>
	
	<br>
		
	<div>
		<html:form action="/changeUsernameMobile.do" styleId="idForm" >
			<table>
				<tr>
					<td width="180px" style="padding-left: 5px;">
						<label style="font-family: Tahoma; font-size: 34px;">User name:</label>
					</td>
					<td>
						<html:text styleId="userNameId" property="userName" styleClass="input-xlarge"  style="font-size: 34px; font: Tahoma;" size="30" maxlength="30" value="${changeUsernameForm.userName}" disabled="${changeUsernameForm.transactionStatus}"></html:text><br>
					</td>			
				</tr>
				<tr height="10px"></tr>
				<tr>
					<td width="180px" style="padding-left: 5px;">
						<label style="font-family: Tahoma; font-size: 34px;">Password:</label>
					</td>
					<td>
						<html:password styleId="passwordId" property="password" styleClass="input-xlarge"  style="font-size: 34px; font: Tahoma;" size="30" maxlength="30" value="${changeUsernameForm.password}" disabled="${changeUsernameForm.transactionStatus}"></html:password><br>
					</td>
				</tr>
				<tr height="10px"></tr>
				<tr>
					<td width="180px" style="padding-left: 5px;">
						<label style="font-family: Tahoma; font-size: 34px;">Re-Enter Password:</label>
					</td>
					<td>
						<html:password styleId="reEnterPasswordId" property="reEnterPassword" styleClass="input-xlarge"  style="font-size: 34px; font: Tahoma;" size="30" maxlength="30" value="${changeUsernameForm.reEnterPassword}" disabled="${changeUsernameForm.transactionStatus}"></html:password><br>
					</td>
				</tr>
			</table>
		</html:form>
	</div>
	
	<!-- buttons -->
	<br>
	<br>
	<div class="control-group" align="center" >
		<div class="controls">
			<c:choose>
				<c:when test="${changeUsernameForm.transactionStatus == true}">
					<html:button property="btnClose" styleClass="btn btn-primary" style="font-size: 34px;" onclick="goBackToMobileMain();" value="Close"></html:button>
				</c:when>
				<c:otherwise>
					<html:button property="btnUpdate" styleClass="btn btn-primary" style="font-size: 34px;" onclick="updateChangeUsernameMobile();" value="Update"></html:button>&nbsp;&nbsp;&nbsp;&nbsp;
					<html:button property="btnCancel" styleClass="btn btn-primary" style="font-size: 34px;" onclick="goBackToMobileMain();" value="Cancel"></html:button>
				</c:otherwise>
			</c:choose>	
		</div>
	</div>
	
	
</div>


