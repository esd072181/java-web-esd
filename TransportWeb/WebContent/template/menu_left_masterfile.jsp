 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
 	 <li class="ui-widget-header">Master File</li>
 	 <c:forEach items="${sessionScope.user_access_list}" var="item">
     	<c:if test="${item == 903}">
        	 <li onclick="goToEmployee();"><a href="#">Employee</a></li>
        </c:if>
        <c:if test="${item == 904}">
        	 <li onclick="goToTerminal();"><a href="#">Terminal</a></li>
        </c:if>
        <c:if test="${item == 905}">
       		<li onclick="goToLorry();"><a href="#">Lorry</a></li>
        </c:if>
        <c:if test="${item == 906}">
        	<li onclick="goToItems();"><a href="#">Items</a></li>
        </c:if>	
        <c:if test="${item == 907}">
        	<li onclick="goToCorrections();"><a href="#">Corrective Actions</a></li>	
        </c:if>
        <c:if test="${item == 908}">
        	<li onclick="goToFollowUp();"><a href="#">Follow Up</a></li>
        </c:if>
        <c:if test="${item == 909}">
        	<li onclick="goToRemarks();"><a href="#">Remarks/Status</a></li>
        </c:if>	       		
        <c:if test="${item == 917}">
        	<li onclick="goToFindings();"><a href="#">Findings</a></li>
        </c:if>	 	       		 
        <c:if test="${item == 910}">
        	<li onclick="goToRootCause();"><a href="#">Root Cause</a></li>
        </c:if>	 
        <c:if test="${item == 911}">
        	<li onclick="goToClosure();"><a href="#">Closure on Corrective Actions</a></li>
        </c:if>	 	       		 
	    <c:if test="${item == 912}">
        	<li class="divider"></li>
	        <li onclick="goToUser();"><a href="#">User</a></li>
       	</c:if>	 
        <c:if test="${item == 913}">
        	<li onclick="goToUserAccess();"><a href="#">User Access</a></li>
        </c:if>	 	        		
     </c:forEach>
 
 		 
		 
		  
		  
		  
		  
		  
		  
		  
		  
		  
		
  
 