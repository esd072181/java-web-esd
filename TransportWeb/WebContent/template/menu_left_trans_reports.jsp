 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	 <li class="ui-widget-header">Transactions</li> 
 	 <c:forEach items="${sessionScope.user_access_list}" var="item">
    	<c:if test="${item == 901}">
    		<li onclick="javascript:goToVerificationAndValidation();"><a href="#">Verification and Validation Compliance of Tracker</a></li>
    	</c:if>
    	<c:if test="${item == 902}">
    		<li onclick="javascript:goToWorkPermit();"><a href="#">Work Permit</a></li>
    	</c:if>	        		
     </c:forEach>
     <li class="ui-widget-header">Reports</li>
     <c:forEach items="${sessionScope.user_access_list}" var="item">
        <c:if test="${item == 914}">
        	 <li onclick="javascript:goToRptVerification();"><a href="#" >Verification and Validation Report</a></li>	
        </c:if>
        <c:if test="${item == 915}">
        	 <li onclick="javascript:goToRptWorkPermit();"><a href="#" >Work Permit Report</a></li>
        </c:if>
     </c:forEach>
 		 
		 
		  
		  
		  
		  
		  
		  
		  
		  
		  
		
  
 