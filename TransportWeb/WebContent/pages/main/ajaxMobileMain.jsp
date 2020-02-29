<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	      <table style="padding-left: 50px;">
		      	<tr>
			      <c:forEach items="${sessionScope.user_access_list}" var="item">
			      	<c:if test="${item == 924}">
			      		<c:choose>
		    					<c:when test="${sessionScope.user_role_session=='Driver'}">
		  							<td align="center" width="300px">
						      			<img onclick="viewDriverTrainingSummaryForDriver('${sessionScope.user_emp_id_session}');" src="resources/driver.png" alt="Driver Training and Information" height="300" width="300">
						      		</td>    					
								</c:when>
		    					<c:otherwise> 
		    						<td align="center" width="170px">
		    							Mobile app is for driver users only as of TransportWebv1.5.7
		    							<!--  <img onclick="goToDriverTraining();" src="resources/driver.png" alt="Driver Training and Information" height="300" width="300">-->
		    						</td>
		    					</c:otherwise>
		    			</c:choose>
			      	</c:if>
			      </c:forEach>	
		      	</tr>
		      </table>
		      
		      <table>
		      	<tr>
			      <c:forEach items="${sessionScope.user_access_list}" var="item">
			      	<c:if test="${item == 924}">
			      		<c:choose>
		    					<c:when test="${sessionScope.user_role_session=='Driver'}">
						      		<td align="center" width="300px">
										<a style="font-size: 34px; font-family: Tahoma;" href="#" onclick="viewDriverTrainingSummaryForDriver('${sessionScope.user_emp_id_session}');">Driver Training and Information</a>
									</td>  					
								</c:when>
		    					<c:otherwise> 
		    						<td align="center" width="170px">
		    							<!--  <a style="font-size: 34px; font-family: Tahoma;" href="#" onclick="goToDriverTraining();">Driver Training and Information</a>-->
		    						</td>
		    					</c:otherwise>
		    			</c:choose>	
			      	</c:if>
			      </c:forEach>	
		      	</tr>
		      </table>