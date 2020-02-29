<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="contentDIVLogin" style="width: 100%; height: 100%;" align="center">

	<html:form action="/loginValidate.do" >
	
		<table>
			<tr height="25px"></tr>
			<tr>
				<td colspan="2" align="center">
					<img src="resources/login_05.jpg" alt="Login" height="100" width="100">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<c:if test="${loginForm.userAccountValidated == 'invalid'}">
						<label id="validationMessageId" style="color: red; font-size: 12px; font-family: cursive;">Invalid User Name and Password!</label>
					</c:if>	
				</td>
			</tr>
			<tr height="5px"></tr>
			<tr>
				<td><label style="font-family:sans-serif; font: italic; font-size: small;">User Name</label></td>
				<td><input type="text" name="userName" size="24px"></td>
			</tr>
			<tr height="5px"></tr>
			<tr>
				<td><label style="font-family:sans-serif; font: italic; font-size: small;">Password</label></td>
				<td><input type="password" name="password"  size="24px"/></td>
			</tr>
			<tr height="15px"></tr>
			<tr>
				<td colspan="4" align="right">
				 	<html:submit value="Login" styleClass="btnLogin" ></html:submit>
				</td>
			</tr>

		</table>

</html:form>

</div>