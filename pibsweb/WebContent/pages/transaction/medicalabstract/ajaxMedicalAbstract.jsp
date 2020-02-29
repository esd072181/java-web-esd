<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<div class="row">
	 
	
 	<div class="col-sm-10" style="padding-left: 40px;">

		<div style="height: 30%; padding-top: 0px;" align="left">
			<h3 style="font-style: bold;">Medical Abstract</h3>
			<html:form action="/medicalAbstract.do" styleId="idForm">
			<div>
				<html:errors/>
			</div>
			
			<div>
				<html:hidden property="patientId" value="${medicalAbstractForm.patientId}"/>
			 	<html:hidden property="fullName" value="${medicalAbstractForm.fullName}"/>
			 	<html:hidden property="address" value="${medicalAbstractForm.address}"/>
			 	<html:hidden property="birthday" value="${medicalAbstractForm.birthday}"/>
				<div>
	                 <table>
	                     <tr>
	                         <td>Name:</td>
	                         <td><span style="color: blue;">${medicalAbstractForm.fullName}</span></td>
	                     </tr>
	   				</table>
	   			</div>
			</div>	
			 <!-- Medical Abstract report -->
			 <c:choose>
			 	<c:when test="${medicalAbstractForm.transactionStatus == true}">
			 		<br>
			 		<div>
						<a id="reportId" href="#" target="_blank" onclick="viewMedicalAbstractReport('${medicalAbstractForm.patientId}');" >Click here to view the Medical Abstract</a>
					</div>
	   				<br>		
	   				<div>		
	   					<table>
	                        <tr>
	                           <td colspan="3">
									<html:button property="btnClose" styleClass="btn btn-primary btnCancelClose" onclick="closeMedicalAbstract();" value="Close"></html:button>	
									<html:button property="btnBack" styleClass="btn btn-primary btnBackToSearch" onclick="backToMedicalAbstractSearch();" value="Back to Search"></html:button>	  				                    
			                    </td>
	                        </tr>
	                        <tr style="height: 15px;"></tr>
	                    </table>     
					</div>
			 	</c:when>
			 	<c:otherwise>
			 		
	   				<br>			
	   				<div>
	 					<table>
	    	                <tr>
	        	                <td>Attending Physician: </td>
	        	                <td><html:text property="doctor" styleId="doctorId" value="${medicalAbstractForm.doctor}"></html:text></td>
	   						</tr>
	   						<tr style="height: 5px;"></tr>
	   						<tr>
	        	               <td>Date of Admission: </td>
	        	               <td><html:text property="dateOfAdmission" value="${medicalAbstractForm.dateOfAdmission}"></html:text></td>
	   						</tr>
	   					</table>
	   				</div>	
	   						
	   				<br>		
	   				<div>		
	   					<table>
	                        <tr>
	                           <td colspan="3">
									<html:button property="btnClose" styleClass="btn btn-primary btnCancelClose" onclick="closeMedicalAbstract();" value="Close"></html:button>	
									<html:button property="btnBack" styleClass="btn btn-primary btnBackToSearch" onclick="backToMedicalAbstractSearch();" value="Back to Search"></html:button>	  				                    
			                   		<html:button property="btnGenerate" styleClass="btn btn-primary btnBackToSearch" onclick="generateMedicalAbstract();" value="Generate"></html:button> 
			                    </td>
	                        </tr>
	                        <tr style="height: 15px;"></tr>
	                    </table>     
					</div>
				 </c:otherwise>
			 </c:choose>

			</html:form>
		</div>
	
	</div>
	
</div>	
	