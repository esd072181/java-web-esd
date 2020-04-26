package com.transport.form;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import com.transport.comparator.ListValueComparator;
import com.transport.constant.MiscConstant;
import com.transport.model.Closure;
import com.transport.model.DriverIncident;
import com.transport.model.DriverTraining;
import com.transport.model.Employee;
import com.transport.model.Findings;
import com.transport.model.ListValue;
import com.transport.model.Lorry;
import com.transport.model.Items;
import com.transport.model.Corrections;
import com.transport.model.FollowUp;
import com.transport.model.InspectionHeader;
import com.transport.model.Remarks;
import com.transport.model.RootCause;
import com.transport.model.Terminal;
import com.transport.model.Tire;
import com.transport.model.TireBrand;
import com.transport.model.User;
import com.transport.model.VerificationAndValidation;
import com.transport.model.WorkPermit;


/**
 * 
 * @author edwarddavid
 * @since July2015
 * DateUpdated: 26Apr2020
 */
public class ArchiveFormBean extends TransportFormBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int entityId;
	private String entity;
	private List<Lorry> lorryList;
	private List<Employee> employeeList;
	private List<Items> itemsList;
	private List<Corrections> correctionsList;
	private List<FollowUp> followUpList;
	private List<Remarks> remarksList;
	private List<User> userList;
	private List<VerificationAndValidation> verificationList;
	private List<Terminal> terminalList;
	private List<Findings> findingsList;
	private List<RootCause> rootCauseList;
	private List<Closure> closureList;
	private List<WorkPermit> workPermitList;
	private List<DriverTraining> driverTrainingList;
	private List<DriverIncident> driverIncidentList;
	private List<InspectionHeader> inspectionHeaderList;
	private List<TireBrand> tireBrandList;
	private List<Tire> tireList;
	
	private int noOfPages;
	private int currentPage;
	
	private boolean transactionStatus;
	private String transactionMessage;
	
	private List<ListValue> entityTypeLOV;
	
	public ArchiveFormBean(){}
	

	public List<Findings> getFindingsList() {
		return findingsList;
	}


	public void setFindingsList(List<Findings> findingsList) {
		this.findingsList = findingsList;
	}


	public List<Terminal> getTerminalList() {
		return terminalList;
	}


	public void setTerminalList(List<Terminal> terminalList) {
		this.terminalList = terminalList;
	}


	public List<VerificationAndValidation> getVerificationList() {
		return verificationList;
	}


	public void setVerificationList(List<VerificationAndValidation> verificationList) {
		this.verificationList = verificationList;
	}


	public List<User> getUserList() {
		return userList;
	}


	public void setUserList(List<User> userList) {
		this.userList = userList;
	}


	public List<Remarks> getRemarksList() {
		return remarksList;
	}


	public void setRemarksList(List<Remarks> remarksList) {
		this.remarksList = remarksList;
	}


	public List<FollowUp> getFollowUpList() {
		return followUpList;
	}


	public void setFollowUpList(List<FollowUp> followUpList) {
		this.followUpList = followUpList;
	}


	public List<Corrections> getCorrectionsList() {
		return correctionsList;
	}


	public void setCorrectionsList(List<Corrections> correctionsList) {
		this.correctionsList = correctionsList;
	}


	public List<Items> getItemsList() {
		return itemsList;
	}


	public void setItemsList(List<Items> itemsList) {
		this.itemsList = itemsList;
	}


	public List<Employee> getEmployeeList() {
		return employeeList;
	}


	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}


	public List<ListValue> getEntityTypeLOV() {
		return entityTypeLOV;
	}


	public void setEntityTypeLOV(List<ListValue> entityTypeLOV) {
		this.entityTypeLOV = entityTypeLOV;
	}


	public int getNoOfPages() {
		return noOfPages;
	}


	public void setNoOfPages(int noOfPages) {
		this.noOfPages = noOfPages;
	}


	public int getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	public boolean isTransactionStatus() {
		return transactionStatus;
	}


	public void setTransactionStatus(boolean transactionStatus) {
		this.transactionStatus = transactionStatus;
	}


	public String getTransactionMessage() {
		return transactionMessage;
	}


	public void setTransactionMessage(String transactionMessage) {
		this.transactionMessage = transactionMessage;
	}


	public int getEntityId() {
		return entityId;
	}


	public void setEntityId(int entityId) {
		this.entityId = entityId;
	}


	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public List<Lorry> getLorryList() {
		return lorryList;
	}

	public void setLorryList(List<Lorry> lorryList) {
		this.lorryList = lorryList;
	}
	
		
	public List<Closure> getClosureList() {
		return closureList;
	}


	public void setClosureList(List<Closure> closureList) {
		this.closureList = closureList;
	}


	public List<WorkPermit> getWorkPermitList() {
		return workPermitList;
	}


	public void setWorkPermitList(List<WorkPermit> workPermitList) {
		this.workPermitList = workPermitList;
	}


	public List<RootCause> getRootCauseList() {
		return rootCauseList;
	}


	public void setRootCauseList(List<RootCause> rootCauseList) {
		this.rootCauseList = rootCauseList;
	}


	public void populateEntityTypeDropdownList(HttpServletRequest request, ArchiveFormBean formBean) throws Exception{
        @SuppressWarnings("unchecked")
		List<ListValue> lovList = (ArrayList<ListValue>) request.getSession().getAttribute(MiscConstant.LOV_ENTITY_TYPE_SESSION);
        lovList.sort(new ListValueComparator());
    	if (lovList!=null) {
    		formBean.setEntityTypeLOV(lovList);
    	}
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		ActionErrors errors = new ActionErrors();
		
		return errors;
	}


	public List<DriverTraining> getDriverTrainingList() {
		return driverTrainingList;
	}


	public void setDriverTrainingList(List<DriverTraining> driverTrainingList) {
		this.driverTrainingList = driverTrainingList;
	}


	public List<DriverIncident> getDriverIncidentList() {
		return driverIncidentList;
	}


	public void setDriverIncidentList(List<DriverIncident> driverIncidentList) {
		this.driverIncidentList = driverIncidentList;
	}


	public List<InspectionHeader> getInspectionHeaderList() {
		return inspectionHeaderList;
	}


	public void setInspectionHeaderList(List<InspectionHeader> inspectionHeaderList) {
		this.inspectionHeaderList = inspectionHeaderList;
	}


	public List<TireBrand> getTireBrandList() {
		return tireBrandList;
	}


	public void setTireBrandList(List<TireBrand> tireBrandList) {
		this.tireBrandList = tireBrandList;
	}


	public List<Tire> getTireList() {
		return tireList;
	}


	public void setTireList(List<Tire> tireList) {
		this.tireList = tireList;
	}


}
