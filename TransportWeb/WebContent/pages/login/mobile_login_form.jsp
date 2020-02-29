<!DOCTYPE html>

<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="style/page_layout.css">
	<title>TransportWeb</title>
	<script src="js/jquery-1.11.1.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/jquery.mobile-1.4.5.min.js"></script>
	<script src="js/transaction.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/global.js"></script>
	<script src="js/bootbox.js"></script>
	<link rel="stylesheet" type="text/css" href="style/jquery.mobile-1.4.5.min.css">
	<link rel="stylesheet" href="style/bootstrap.min.css">
	<style type="text/css">
	.ui-btn {
		height: 90px;
		font-size: 40px;
		padding-top: 16px;
		color: blue;
		background-color: yellow;
	}
	</style>
<script type="text/javascript">
$(document).on({
    ajaxStart: function() { 
    	$("#ajaxSpinnerId").show(); 
     },
     ajaxStop: function() { 
    	 $("#ajaxSpinnerId").hide();
     }    
});
</script>
</head>

<body>

	<!-- Dont use jQuery mobile here... logout will not function correctly.. -->
			<br>
			<br>
			
		       <div align="center">
		       		<label style="font-family: Tahoma; font-size: 60px; font-weight: bolder; color: blue;">GDC Transport Web</label>
		       </div>
		       
		       <html:form action="/loginValidate.do" styleId="frmLogin">		
			        <c:if test="${loginForm.userAccountValidated == 'invalid'}">
						<div align="center">
							<span id="validationMessageId" style="color: red; font-size: 34px; font-family: Tahoma;">Invalid User Name and Password!</span>
						</div>				
					</c:if>
					<div style="padding-left: 30px; padding-right: 30px;">
						<input type="hidden" name="isMobile" value="true">
				        <label for="username" style="font-size: 34px;">User Name:</label> 
				        <input type="text" style="font-size: 34px;" name="userName" > 
				        <label for="password" style="font-size: 34px;">Password:</label>
				        <input type="password" style="font-size: 34px;" name="password"  > 
					</div>
			        <br>
			        <div align="right" style="padding-left: 30px; padding-right: 30px;">
			        	<html:submit styleClass="btn btn-primary btn-block" style="font-size: 40px; height: 100px;" value="Submit"></html:submit>
			        </div>
			        
		        </html:form>	
</body>
</html>