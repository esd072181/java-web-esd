<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript">

if (navigator.userAgent.match(/Android/i)
		 || navigator.userAgent.match(/webOS/i)
		 || navigator.userAgent.match(/iPhone/i)
		 || navigator.userAgent.match(/iPad/i)
		 || navigator.userAgent.match(/iPod/i)
		 || navigator.userAgent.match(/BlackBerry/i)
		 || navigator.userAgent.match(/Windows Phone/i)) {
	
	$.get('config/domain.txt', function(data){

	   var lines = data.split('\n');
	   var url = '';
	   
		if (window.location.hostname == 'localhost') {
			url = lines[0];
		} else {
			url = lines[1];
		}
		
		location.replace(url);
		
	});
} 
</script>

<div id="contentDIVLogin">

<html:form action="/loginValidate.do" >

	<div style="width: 100%; padding-top: 50px;" align="center">

		<table>
			<tr>
				<td colspan="2" align="center">
					<img src="resources/login.jpg" alt="Login" height="100" width="100">
				</td>
			</tr>
			<c:if test="${loginForm.userAccountValidated == 'invalid'}">
				<tr>
					<td align="center" colspan="2"><label style="color: red; font-style: italic;">Invalid user name and password!</label></td>
				</tr>
			</c:if>
			<tr height="10px"></tr>
			<tr>
				<td><label>User Name:</label></td>
				<td style="padding-left: 5px;"><html:text property="userName"></html:text></td>
			</tr>
			<tr>
				<td><label>Password:</label> </td>
				<td style="padding-left: 5px;"><html:password property="password"></html:password></td>
			</tr>
			<tr height="10px"></tr>
			<tr>
				<td></td>
				<td align="right"><input type="submit" value="Submit"></td>
			</tr>	
		</table>
	
	</div>
	
</html:form>

</div>