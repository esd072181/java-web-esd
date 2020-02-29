<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>


<div class="row">
	 
	
 	<div class="col-sm-10" style="padding-left: 40px;">

		<div style="height: 30%; padding-top: 0px;" align="left">
			<h3 style="font-style: bold;">Patient History Report</h3>
		
				<div>
                     <table>
                         <tr>
                             <td>Name:</td>
                             <td><span style="color: blue;">${rptPatientHistoryForm.fullName}</span></td>
   						 </tr>
   					 </table>
   				</div>
				<br>	
				
				<div>
					<c:choose>
						<c:when test="${rptPatientHistoryForm.modelList != null}">
							<p><span style="color: blue;">Report successfully generated!</span></p>
							<div>
								<a href="reports/patienthistory.pdf" target="_blank">Click here to view the generated PDF report</a>
							</div>
						</c:when>
						<c:otherwise>
							<p><span style="color: blue;">No record found!</span></p>
						</c:otherwise>		
					</c:choose>
				</div>
	   						
   				<br>		
   				<div>		
   					<table>
                        <tr>
                           <td colspan="2">
								<html:button property="btnBack" styleClass="btn btn-primary btnBackToSearch" onclick="backToRptPatientHistorySearch();" value="Back to Search"></html:button>	
		                    </td>
                        </tr>
                    </table>     
				</div>

		</div>
	
	</div>
	
</div>	
	