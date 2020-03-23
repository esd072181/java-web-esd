<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<ul class="nav nav-tabs" style=" background-color: white;">
 	<li><a href="#" onclick="javascript: goToMainByAjax();">Home</a></li>
 	<c:forEach items="${sessionScope.user_access_list}" var="item">
 	  <c:if test="${item == 918}">
	    <li class="dropdown">
	        <a href="#" data-toggle="dropdown" class="dropdown-toggle">Master File <b class="caret"></b></a>
	        <ul class="dropdown-menu">
	        	<c:forEach items="${sessionScope.user_access_list}" var="item">
        			<c:if test="${item == 903}">
        				<li><a href="#" onclick="javascript:goToEmployee();">Employee</a></li>
        			</c:if>
        			<c:if test="${item == 904}">
        				<li><a href="#" onclick="javascript:goToTerminal();">Terminal</a></li>	
        			</c:if>
        			<c:if test="${item == 905}">
        				<li><a href="#" onclick="javascript:goToLorry();">Lorry</a></li>
        			</c:if>
        			<c:if test="${item == 906}">
        				<li><a href="#" onclick="javascript:goToItems();">Items</a></li>
        			</c:if>	
        			<c:if test="${item == 907}">
        				 <li><a href="#" onclick="javascript:goToCorrections();">Corrective Actions</a></li>	
        			</c:if>
        			<c:if test="${item == 908}">
        				<li><a href="#" onclick="javascript:goToFollowUp();">Follow Up</a></li>
        			</c:if>
        			<c:if test="${item == 909}">
        				<li><a href="#" onclick="javascript:goToRemarks();">Remarks/Status</a></li>
        			</c:if>	       		
        			<c:if test="${item == 917}">
        				<li><a href="#" onclick="javascript:goToFindings();">Findings</a></li>
        			</c:if>	 	       		 
        			<c:if test="${item == 910}">
        				<li><a href="#" onclick="javascript:goToRootCause();">Root Cause</a></li>
        			</c:if>	 
        			<c:if test="${item == 911}">
        				<li><a href="#" onclick="javascript:goToClosure();">Closure on Corrective Actions</a></li>
        			</c:if>	 	       		 
	       		 <!--<li><a href="#" onclick="javascript:goToTireBrand();">Tire Brand</a></li>-->
	       		 <!--<li><a href="#" onclick="javascript:goToTire();">Tire</a></li>-->
	       		    <c:if test="${item == 912}">
        				<li class="divider"></li>
	             		<li><a href="#" onclick="javascript:goToUser();">User</a></li>
        			</c:if>	 
        			<c:if test="${item == 913}">
	             		<li><a href="#" onclick="javascript:goToUserAccess();">User Access</a></li>
        			</c:if>	 
	             </c:forEach>
	        </ul>
	    </li>
	 </c:if>
	 <c:if test="${item == 919}">
      <li  class="dropdown">
   	 	<a href="#" data-toggle="dropdown" class="dropdown-toggle">Transactions <b class="caret"></b></a>
        <ul class="dropdown-menu">
        	<c:forEach items="${sessionScope.user_access_list}" var="item">
    			<c:if test="${item == 901}">
    				<li><a href="#"  onclick="javascript:goToVerificationAndValidation();">Verification and Validation Compliance of Tracker</a></li>
    			</c:if>
    			<c:if test="${item == 902}">
    				<li><a href="#"  onclick="javascript:goToWorkPermit();">Work Permit</a></li>
    			</c:if>
    			<c:if test="${item == 922}">
    				<li><a href="#"  onclick="javascript:goToMaintenanceMonitoring();">Maintenance Monitoring</a></li>
    			</c:if>
    			<c:if test="${item == 924}">
    				<c:choose>
    					<c:when test="${sessionScope.user_role_session=='Driver'}">
  							<li><a href="#" onclick="viewDriverTrainingSummaryForDriver('${sessionScope.user_emp_id_session}');">Driver Training and Information</a></li> 					
    					</c:when>
    					<c:otherwise>
    						<li><a href="#"  onclick="goToDriverTraining();">Driver Training and Information</a></li>	
    					</c:otherwise>
    				</c:choose>
    			</c:if>
    			<c:if test="${item == 927}">
    				<li><a href="#"  onclick="javascript:goToDriverIncident();">Driver Incident</a></li>
    			</c:if>
    			<c:if test="${item == 928}">
    				<li><a href="#"  onclick="javascript:goToMaintenanceInspection();">Maintenance Inspection Checklist</a></li>
    			</c:if>
			</c:forEach>
        </ul>
      </li>
     </c:if>
     <c:if test="${item == 920}">
       <li  class="dropdown">
   	 	<a href="#" data-toggle="dropdown" class="dropdown-toggle">Reports <b class="caret"></b></a>
        <ul class="dropdown-menu">
        	<c:forEach items="${sessionScope.user_access_list}" var="item">
        		<c:if test="${item == 914}">
        	 		<li><a href="#"  onclick="javascript:goToRptVerification();">Verification and Validation Report</a></li>	
        		</c:if>
        		<c:if test="${item == 915}">
        		    <li><a href="#"  onclick="javascript:goToRptWorkPermit();">Work Permit Report</a></li>
        		</c:if>
        	</c:forEach>
        </ul>
       </li>
     </c:if>
	 <c:if test="${item == 921}">
     	  <li class="dropdown">
	     	<a href="#" data-toggle="dropdown" class="dropdown-toggle">Utilities <b class="caret"></b></a>
	        <ul class="dropdown-menu">
	            <c:forEach items="${sessionScope.user_access_list}" var="item">
        			<c:if test="${item == 916}">
        		  		<li><a href="#"  onclick="javascript:goToArchive();">Archive</a></li>
        			</c:if>
        		</c:forEach>
	        </ul>
	     </li>
	 </c:if>
    </c:forEach>
    <li class="pull-right"><a href="logout.do">Log-out</a></li>
	 <li class="dropdown pull-right">
	      <a href="#" data-toggle="dropdown" class="dropdown-toggle"><c:out value="${user_session.name}"></c:out><b class="caret"></b></a>
	      <ul class="dropdown-menu">
	           <li><a href="#" onclick="javascript:goToChangeUsername();">Change Username and Password</a></li>
	      </ul>
	 </li>
</ul>