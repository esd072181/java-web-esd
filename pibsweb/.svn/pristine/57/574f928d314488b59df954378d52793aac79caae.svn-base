<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
 <script src="js/jquery-1.11.1.js" type="text/javascript"></script>
<script src="js/masterfile.js"></script>
<script>
function testValidationXMLAjax() {
	
						$.ajax({
							  type: "POST",
							  url: "testValidatorXML.do?",
							  data: $("#idForm").serialize() 
							})
							  .done(function( result ) {
								  //alert(result);
								$("#contentDIV").html(result);
						});

		}
</script>
</head>
<body>
 
 <div id="contentDIV">
 
<h2>Struts - Validator Example</h2>

<b>User Registeration Form</b>
<br/><br/>
 
<font color="red">
<html:errors/>
</font>
 
<html:form action="/testValidatorXML" styleId="idForm">
 


<br/>
Name : 
<html:text property="name" size="10"/>
<br/>
<html:submit>
Submit
</html:submit>
 
 <html:button property="btnTest" value="TestAjax" onclick="testValidationXMLAjax();"></html:button>
 
</html:form>
 
 </div>
 
</body>
</html>