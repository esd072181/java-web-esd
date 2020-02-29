<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<div id="contentDIV">

<div class="row">

	<div class="col-sm-2">
		<!-- Left Menu -->
		<div style="padding-top: 15px; padding-left: 12px;">
		  	<!-- jQuery ui -->
		  	<ul id="menu">
			  <li class="ui-widget-header">Options</li>
			  <li><a href="building.do?">Search/Update Record</a></li>
			  <li><a href="building.do?command=Add">Add New Record</a></li>
			  <li class="ui-widget-header">Master File</li>
			  <li><a href="#">Patient</a></li>
			  <li><a href="#">Room</a></li>
			  <li><a href="#">Room Category</a></li>
			  <li><a href="#">Medical Supply</a></li>
			  <li><a href="#">Equipment</a></li>
			  <li><a href="#">Professional/Doctor</a></li>
			  <li><a href="#">Surgery</a></li>
			  <li><a href="#">X-ray</a></li>
			  <li><a href="#">Laboratory Exams</a></li>
			  <li><a href="#">Additional Service</a></li>
			  <li class="ui-widget-header">Utilities</li>
			  <li><a href="#">Archive</a></li>
			  <li><a href="#">Audit Trail</a></li>
			</ul>
		</div>
	</div>
	
 	<div class="col-sm-10">

		<div style="height: 30%; padding-top: 0px;" align="left">
		<h3 style="text-decoration: underline;">Building - Add New Record</h3>
			<html:form action="/building.do" >
				<div>
					<br>
					<label>Description:</label>
					<html:text property="description" size="40"></html:text><br>
					<label>No of Floor:</label>
					<html:text property="nooffloor" size="2"></html:text><br>
					<label>Remarks:</label>
					<html:text property="remarks" size="50"></html:text><br>
					<br>
					<html:submit property="command" value="Save"></html:submit>
					<html:button property="btnCancel" onclick="goToMain();" value="Cancel"></html:button>
				</div>
			</html:form>
		</div>
	
	</div>
	
</div>	
	
</div>