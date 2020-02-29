<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<script>
$(function() {
    $( "#menu" ).menu({
      items: "> :not(.ui-widget-header)"
    });
    
  //Press Enter for Search button or can use onkeypres event in html object
    $("#idSearchCriteria").keypress(function(event){
        if(event.keyCode == 13){
        	event.preventDefault();
            $("#btnSearchId").click();           
        }
    });
    
    $("#idSearchCriteria").focus();
    
  });
</script>
<div class="row">
  <div class="col-sm-2">

	<!-- Left Menu -->
	<div style="padding-top: 15px; padding-left: 12px;">
	  	<!-- jQuery ui -->
	  	<ul id="menu">
		  <li class="ui-widget-header">Options</li>
		  <li onclick="goToAddBuilding();"><a href="#">Add New Record</a></li>
		  <li onclick="goToBuilding();"><a href="#">Search/Update Record</a></li>
		  <%@ include file="/template/menu_left_masterfile.jsp" %>
		</ul>
	</div>
  </div>
  
  <div class="col-sm-10 divSpace">
	
	<div style="height: 30%; padding-top: 0px;" align="left">
		<div style="width: 50%;">
			<h3>Building</h3>
		</div>
		<html:form action="/building.do" styleId="idForm">
				<div>
					<html:errors/>
				</div>
				<div>
					<div>
						<label>Search:</label>
						<html:text property="criteria" styleId="idSearchCriteria" size="25"></html:text>
						<html:button styleId="btnSearchId" property="command" onclick="getBuilding(1,'filter');" value="Search" styleClass="btn btn-primary"></html:button>
						<html:button property="command" onclick="getBuilding(1,'showall');" value="Show All" styleClass="btn btn-primary"></html:button>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<html:button property="command" onclick="goToAddBuilding();" value="Add New Record" styleClass="btn btn-primary"></html:button>
						<span id="msgDeletedId" style="color: blue; padding-left: 100px; display: none;"><bean:message key="msg.deleted"/></span>
					</div>
					<div style="padding-left: 85px; float: left;">
						<span id="validationMessageId" style="color: blue; display: none;">Enter search criteria.</span>
					</div>
				</div>			
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

