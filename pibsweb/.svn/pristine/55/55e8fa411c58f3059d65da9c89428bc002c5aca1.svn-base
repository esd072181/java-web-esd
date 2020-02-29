<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


  
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
	<h3 style="text-decoration: underline;">Building</h3>
	<html:form action="/building.do" >
			<label>Search:</label>
			<html:text property="criteria" size="25"></html:text>
			<html:button property="command"  value="Search" styleClass="btn btn-primary"></html:button>
			<html:button property="command"  onclick="getBuilding(1);" value="Show All" styleClass="btn btn-primary"></html:button>
	</html:form>
	</div>
  
	
	<br>

	<!-- results using logic iterate -->
	<!-- using bootstrap -->
	<div id="tablePresentationDIV">
		<!-- ajax part of table data -->
	</div>


  
  </div>
</div>
	


	<!-- results using jstl -->
	<!--  
	<div>
		<c:if test="${results != null}">
			<table border="1" >
				<tr>
					<td width="50px">Id</td>
					<td width="200px">Description</td>
					<td width="100px">No Of Floor</td>
					<td width="400px">Remarks</td>
				</tr>
				<c:forEach items="${results}" var="item">
					<tr>
						<td><c:out value="${item.id}" /></td>
						<td><c:out value="${item.description}" /></td>
						<td><c:out value="${item.noOfFloor}" /></td>
						<td><c:out value="${item.remarks}" /></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
	-->
</div>