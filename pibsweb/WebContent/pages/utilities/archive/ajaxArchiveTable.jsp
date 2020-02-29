<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

	<div class="table-responsive" >
		
		<!-- Professional -->
		<c:if test="${archiveForm.profList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%;">  
				<tr>
					<th>Designation</th>
					<th>Last Name</th>
					<th>First Name</th>
					<th>Middle Name</th>
					<th>Type</th>
					<th>Specialization</th>
					<th>Gender</th>
					<th>Birthday </th>
					<th>Date Hired</th>
					<th>License No</th>
					<th></th>
				</tr>
				<logic:iterate name="archiveForm" property="profList" type="com.pibs.model.Professional" id="model">
					<tr>				 
						<td><bean:write name="model" property="designation"/></td>
						<td><bean:write name="model" property="lastName"/></td>
						<td><bean:write name="model" property="firstName"/></td>
						<td><bean:write name="model" property="middleName"/></td>
						<td><bean:write name="model" property="professionalType"/></td>
						<td><bean:write name="model" property="specialization"/></td>
						<td><bean:write name="model" property="gender"/></td>
						<td><bean:write name="model" property="birthday"/></td>
						<td><bean:write name="model" property="dateHired"/></td>
						<td><bean:write name="model" property="licenseNo"/></td>
						<td align="center"><a href="#" onclick="javascript: restoreEntity('<bean:write name="model" property="id"/>',${archiveForm.currentPage})">Restore</a></td>
					</tr>
				</logic:iterate>
			</table>
		  </c:if>
			<!-- Surgery  -->
		  <c:if test="${archiveForm.surgeryList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%;">  
				<tr>
					<th>Description</th>
					<th>Remarks</th>
					<th>Type</th>
					<th>Fee</th>
					<th></th>
				</tr>
				<logic:iterate name="archiveForm" property="surgeryList" type="com.pibs.model.Surgery" id="model">
					<tr>				 
						<td><bean:write name="model" property="description"/></td>
						<td><bean:write name="model" property="remarks"/></td>
						<td><bean:write name="model" property="surgeryTypeName"/></td>
						<td align="right"><bean:write name="model" property="fee" format="Php #,###.00"/></td>
						<td align="center"><a href="#" onclick="javascript: restoreEntity('<bean:write name="model" property="id"/>',${archiveForm.currentPage})">Restore</a></td>
					</tr>
				</logic:iterate>
			</table>
		</c:if>
		
		<!-- Room -->	
		<c:if test="${archiveForm.roomList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%;">  
				<tr>
					<th>Room No</th>
					<th>Room Category</th>
					<th>Building</th>
					<th>Floor No</th>
					<th>No of Beds</th>
					<th>Available Beds</th>
					<th>Description</th>
					<th>Rate</th>
					<th></th>
				</tr>
				<logic:iterate name="archiveForm" property="roomList" type="com.pibs.model.Room" id="model">
					<tr>				 
						<td><bean:write name="model" property="roomNo"/></td>
						<td><bean:write name="model" property="roomCategory"/></td>
						<td><bean:write name="model" property="building"/></td>
						<td><bean:write name="model" property="floorNo"/></td>
						<td><bean:write name="model" property="noOfBeds"/></td>
						<td><bean:write name="model" property="availableBeds"/></td>
						<td><bean:write name="model" property="description"/></td>
						<td align="right"><bean:write name="model" property="rate" format="Php #,###.00"/></td>
						<td align="center"><a href="#" onclick="javascript: restoreEntity('<bean:write name="model" property="id"/>',${archiveForm.currentPage})">Restore</a></td>					</tr>
				</logic:iterate>
			</table>
		</c:if>
		
		<!-- Room Category -->
		<c:if test="${archiveForm.roomCategList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%;">  
				<tr>
					<th>Description</th>
					<th>Remarks</th>
					<th>Rate</th>
					<th></th>
				</tr>
				<logic:iterate name="archiveForm" property="roomCategList" type="com.pibs.model.RoomCategory" id="model">
					<tr>				 
						<td><bean:write name="model" property="description"/></td>
						<td><bean:write name="model" property="remarks"/></td>
						<td align="right"><bean:write name="model" property="rate" format="Php #,###.00"/></td>
						<td align="center"><a href="#" onclick="javascript: restoreEntity('<bean:write name="model" property="id"/>',${archiveForm.currentPage})">Restore</a></td>					
					</tr>
				</logic:iterate>
			</table>
		</c:if>
		
		<!-- Equipment -->
		<c:if test="${archiveForm.equipList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%;">  
				<tr>
					<th>Name</th>
					<th>Description</th>
					<th>Fee</th>
					<th></th>
				</tr>
				<logic:iterate name="archiveForm" property="equipList" type="com.pibs.model.Equipment" id="model">
					<tr>				 
						<td><bean:write name="model" property="entityName"/></td>
						<td><bean:write name="model" property="description"/></td>
						<td align="right"><bean:write name="model" property="fee" format="Php #,###.00"/></td>
						<td align="center"><a href="#" onclick="javascript: restoreEntity('<bean:write name="model" property="id"/>',${archiveForm.currentPage})">Restore</a></td>					
					</tr>
				</logic:iterate>
			</table>
		</c:if>

		<!-- Discount -->
		<c:if test="${archiveForm.discountList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%;">  
				<tr>
					<th>Description</th>
					<th>Remarks</th>
					<th>Date Approved</th>
					<th>Standard Amount</th>
					<th>Standard Percentage (%)</th>
					<th></th>
				</tr>
				<logic:iterate name="archiveForm" property="discountList" type="com.pibs.model.Discount" id="model">
					<tr>				 
						<td><bean:write name="model" property="description"/></td>
						<td><bean:write name="model" property="remarks"/></td>
						<td><bean:write name="model" property="dateApproved"/></td>
						<td align="right"><bean:write name="model" property="standardAmount" format="Php #,###.00"/></td>
						<td align="right"><bean:write name="model" property="standardPercentage" format="#,###.00"/></td>
						<td align="center"><a href="#" onclick="javascript: restoreEntity('<bean:write name="model" property="id"/>',${archiveForm.currentPage})">Restore</a></td>
					</tr>
				</logic:iterate>
			</table>
		</c:if>

		<!-- Additional Services -->
		<c:if test="${archiveForm.addServList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%;">  
				<tr>
					<th>Description</th>
					<th>Remarks</th>
					<th>Category</th>
					<th>Fee</th>
					<th></th>
				</tr>
				<logic:iterate name="archiveForm" property="addServList" type="com.pibs.model.AdditionalServices" id="model">
					<tr>				 
						<td><bean:write name="model" property="description"/></td>
						<td><bean:write name="model" property="remarks"/></td>
						<td><bean:write name="model" property="additionalServicesCategory"/></td>
						<td align="right"><bean:write name="model" property="fee" format="Php #,###.00"/></td>
						<td align="center"><a href="#" onclick="javascript: restoreEntity('<bean:write name="model" property="id"/>',${archiveForm.currentPage})">Restore</a></td>
					</tr>
				</logic:iterate>
			</table>
		</c:if>

		<!-- Additional Services Category -->
		<c:if test="${archiveForm.addServCategList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%;">  
				<tr>
					<th>Description</th>
					<th>Remarks</th>
					<th></th>
				</tr>
				<logic:iterate name="archiveForm" property="addServCategList" type="com.pibs.model.AdditionalServicesCategory" id="model">
					<tr>				 
						<td><bean:write name="model" property="description"/></td>
						<td><bean:write name="model" property="remarks"/></td>
						<td align="center"><a href="#" onclick="javascript: restoreEntity('<bean:write name="model" property="id"/>',${archiveForm.currentPage})">Restore</a></td>
					</tr>
				</logic:iterate>
			</table>
		</c:if>

		<!-- Radiology -->
		<c:if test="${archiveForm.radList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%;">  
				<tr>
					<th>Description</th>
					<th>Remarks</th>
					<th>Type</th>
					<th>Fee</th>
					<th></th>
				</tr>
				<logic:iterate name="archiveForm" property="radList" type="com.pibs.model.Radiology" id="model">
					<tr>				 
						<td><bean:write name="model" property="description"/></td>
						<td><bean:write name="model" property="remarks"/></td>
						<td><bean:write name="model" property="radiologyTypeName"/></td>
						<td align="right"><bean:write name="model" property="fee" format="Php #,###.00"/></td>
						<td align="center"><a href="#" onclick="javascript: restoreEntity('<bean:write name="model" property="id"/>',${archiveForm.currentPage})">Restore</a></td>
					</tr>
				</logic:iterate>
			</table>
		</c:if>

		<!-- Medical Supply -->
		<c:if test="${archiveForm.medList != null}">
				<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%;">  
					<tr>
						<th>Item Code</th>
						<th>Description</th>
						<th>Generic Name</th>
						<th>Remarks</th>
						<th>Lot No</th>
						<th>Manufactured Date</th>
						<th>Expiration Date</th>
						<th>Type</th>
						<th>Retail Selling Price</th>
						<th></th>
					</tr>
					<logic:iterate name="archiveForm" property="medList" type="com.pibs.model.MedicalSupply" id="model">
						<tr>				 
							<td><bean:write name="model" property="itemCode"/></td>
							<td><bean:write name="model" property="description"/></td>
							<td><bean:write name="model" property="genericName"/></td>
							<td><bean:write name="model" property="remarks"/></td>
							<td><bean:write name="model" property="lotNo"/></td>
							<td><bean:write name="model" property="dateManufactured"/></td>
							<td><bean:write name="model" property="expirationDate"/></td>
							<td><bean:write name="model" property="medicalSupplyTypeName"/></td>
							<td align="right"><bean:write name="model" property="retailSellingPrice" format="Php #,###.00"/></td>
							<td align="center"><a href="#" onclick="javascript: restoreEntity('<bean:write name="model" property="id"/>',${archiveForm.currentPage})">Restore</a></td>
						</tr>
					</logic:iterate>
				</table>
		 </c:if>
		 
		 
		 <!-- Specialization -->
		<c:if test="${archiveForm.specList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%;">  
				<tr>
					<th>Name</th>
					<th>Description</th>
					<th></th>
				</tr>
				<logic:iterate name="archiveForm" property="specList" type="com.pibs.model.Specialization" id="model">
					<tr>				 
						<td><bean:write name="model" property="entityName"/></td>
						<td><bean:write name="model" property="description"/></td>
						<td align="center"><a href="#" onclick="javascript: restoreEntity('<bean:write name="model" property="id"/>',${archiveForm.currentPage})">Restore</a></td>
					</tr>
				</logic:iterate>
			</table>
		</c:if>
		
		<!-- Building -->
		<c:if test="${archiveForm.buildList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%;">  
				<tr>
					<th>Description</th>
					<th>No of Floor</th>
					<th>Remarks</th>
					<th></th>
				</tr>
				<logic:iterate name="archiveForm" property="buildList" type="com.pibs.model.Building" id="model">
					<tr>				 
						<td><bean:write name="model" property="description"/></td>
						<td><bean:write name="model" property="noOfFloor"/></td>
						<td><bean:write name="model" property="remarks"/></td>
						<td align="center"><a href="#" onclick="javascript: restoreEntity('<bean:write name="model" property="id"/>',${archiveForm.currentPage})">Restore</a></td>
					</tr>
				</logic:iterate>
			</table>
		</c:if>
	
		<!-- Laboratory Examination -->	
		<c:if test="${archiveForm.labList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%;">  
				<tr>
					<th>Description</th>
					<th>Remarks</th>
					<th>Fee</th>
					<th></th>
				</tr>
				<logic:iterate name="archiveForm" property="labList" type="com.pibs.model.LaboratoryExamination" id="model">
					<tr>				 
						<td><bean:write name="model" property="description"/></td>
						<td><bean:write name="model" property="remarks"/></td>
						<td align="right"><bean:write name="model" property="fee" format="Php #,###.00"/></td>
						<td align="center"><a href="#" onclick="javascript: restoreEntity('<bean:write name="model" property="id"/>',${archiveForm.currentPage})">Restore</a></td>
					</tr>
				</logic:iterate>
			</table>
		</c:if>
		
		<!-- Patient -->
		<c:if test="${archiveForm.patientList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%;">  
				<tr>
					<th>Patient Id</th>
					<th>Last Name</th>
					<th>First Name</th>
					<th>Middle Name</th>
					<th></th>
				</tr>
				<logic:iterate name="archiveForm" property="patientList" type="com.pibs.model.Patient" id="model">
					<tr>				 
						<%--<td><bean:write name="resultsId" property="id"/><bean:message key="Building.Id"/></td>--%>
						<td><bean:write name="model" property="patientId"/></td>
						<td><bean:write name="model" property="lastName"/></td>	
						<td><bean:write name="model" property="firstName"/></td>
						<td><bean:write name="model" property="middleName"/></td>
						<td align="center"><a href="#" onclick="javascript: restoreEntity('<bean:write name="model" property="id"/>',${archiveForm.currentPage})">Restore</a></td>	
					</tr>
				</logic:iterate>
			</table>
		</c:if>

		<!-- Nursery -->
		<c:if test="${archiveForm.nurseryList != null}">
			<table  id="tableId" class="table table-bordered table-striped table-condensed table-hover context-menu-table" style="width: 98%;">  
				<tr>
					<th>Last Name</th>
					<th>First Name</th>
					<th>Date Of Birth</th>
					<th>Time Of Birth</th>
					<th>Gender</th>
					<th>Weight</th>
					<th>Remarks</th>
					<th></th>
				</tr>
				<logic:iterate name="archiveForm" property="nurseryList" type="com.pibs.model.MonitorNursery" id="model">
					<tr>
						<td><bean:write name="model" property="lastName"/></td>				 
						<td><bean:write name="model" property="firstName"/></td>
						<td><bean:write name="model" property="dateOfBirth"/></td>
						<td><bean:write name="model" property="timeOfBirth"/></td>
						<td><bean:write name="model" property="gender"/></td>
						<td><bean:write name="model" property="weight"/></td>						
						<td><bean:write name="model" property="remarks"/></td>
						<td align="center"><a href="#" onclick="javascript: restoreEntity('<bean:write name="model" property="id"/>',${archiveForm.currentPage})">Restore</a></td>
					</tr>
				</logic:iterate>
			</table>
		</c:if>
		
		<!-- Employee -->
		<c:if test="${archiveForm.empList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%;">  
				<tr>
					<th>Name</th>
					<th>Category</th>
					<th>Position</th>
					<th></th>
				</tr>
				<logic:iterate name="archiveForm" property="empList" type="com.pibs.model.Employee" id="model">
					<tr>				
						<td><bean:write name="model" property="fullName"/></td>
						<td><bean:write name="model" property="empCategory"/></td>
						<td><bean:write name="model" property="empPosition"/></td>
						<td align="center"><a href="#" onclick="javascript: restoreEntity('<bean:write name="model" property="id"/>',${archiveForm.currentPage})">Restore</a></td>
					</tr>
				</logic:iterate>
			</table>
	 	  </c:if>
	 	  
	 	  
	 	  <!-- User -->
	 	  <c:if test="${archiveForm.userList != null}">
			<table  class="table table-bordered table-striped table-condensed table-hover" style="width: 98%;">  
				<tr>
					<th>Employee Name</th>
					<th>Role</th>
					<th>User Name</th>
					<th></th>
				</tr>
				<logic:iterate name="archiveForm" property="userList" type="com.pibs.model.User" id="model">
					<tr>				 
						<td><bean:write name="model" property="name"/></td>
						<td><bean:write name="model" property="role"/></td>
						<c:choose>
							<c:when test="${sessionScope.user_session.id == model.id}">
								<td><bean:write name="model" property="userName"/></td>
							</c:when>
							<c:otherwise>
								<td>-</td>
							</c:otherwise>
						</c:choose>
						<td align="center"><a href="#" onclick="javascript: restoreEntity('<bean:write name="model" property="id"/>',${archiveForm.currentPage})">Restore</a></td>
					</tr>
				</logic:iterate>
			</table>
		  </c:if>
		  
		  <!-- No record -->
	 	  <c:if test="${archiveForm.gotRecords == false}">
	 	  	<table>
	 	  		<tr><td><span style="color: blue;">No record found!</span></td></tr>
	 	  	</table>
	 	  </c:if>
	 	  
	</div>

