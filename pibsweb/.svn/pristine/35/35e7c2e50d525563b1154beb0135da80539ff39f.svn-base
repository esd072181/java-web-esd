package com.pibs.form;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import com.pibs.constant.MiscConstant;
import com.pibs.model.AdditionalServices;
import com.pibs.model.AdditionalServicesCategory;
import com.pibs.model.Building;
import com.pibs.model.Discount;
import com.pibs.model.Employee;
import com.pibs.model.Equipment;
import com.pibs.model.LaboratoryExamination;
import com.pibs.model.ListValue;
import com.pibs.model.MedicalSupply;
import com.pibs.model.MonitorNursery;
import com.pibs.model.Patient;
import com.pibs.model.Professional;
import com.pibs.model.Radiology;
import com.pibs.model.Room;
import com.pibs.model.RoomCategory;
import com.pibs.model.Specialization;
import com.pibs.model.Surgery;
import com.pibs.model.User;

/**
 * 
 * @author dward
 * @since 16Apr2018
 */
public class ArchiveFormBean extends PIBSFormBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int entityId;
	private String entity;
	private List<Professional> profList;
	private List<Surgery> surgeryList;
	private List<Room> roomList;
	private List<RoomCategory> roomCategList;
	private List<Equipment> equipList;
	private List<Discount> discountList;
	private List<AdditionalServices> addServList;
	private List<AdditionalServicesCategory> addServCategList;
	private List<Radiology> radList;
	private List<MedicalSupply> medList;
	private List<Specialization> specList;
	private List<Building> buildList;
	private List<LaboratoryExamination> labList;
	private List<Patient> patientList;
	private List<MonitorNursery> nurseryList;
	private List<Employee> empList;
	private List<User> userList;
	
	
	private int noOfPages;
	private int currentPage;
	
	private boolean transactionStatus;
	private String transactionMessage;
	
	private List<ListValue> entityTypeLOV;
	
	private boolean gotRecords;
	
	public ArchiveFormBean(){}
	

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
	
	
	
	public List<Professional> getProfList() {
		return profList;
	}


	public void setProfList(List<Professional> profList) {
		this.profList = profList;
	}


	public List<Surgery> getSurgeryList() {
		return surgeryList;
	}


	public void setSurgeryList(List<Surgery> surgeryList) {
		this.surgeryList = surgeryList;
	}


	public List<Room> getRoomList() {
		return roomList;
	}


	public void setRoomList(List<Room> roomList) {
		this.roomList = roomList;
	}


	public List<RoomCategory> getRoomCategList() {
		return roomCategList;
	}


	public void setRoomCategList(List<RoomCategory> roomCategList) {
		this.roomCategList = roomCategList;
	}


	public List<Equipment> getEquipList() {
		return equipList;
	}


	public void setEquipList(List<Equipment> equipList) {
		this.equipList = equipList;
	}


	public List<Discount> getDiscountList() {
		return discountList;
	}


	public void setDiscountList(List<Discount> discountList) {
		this.discountList = discountList;
	}


	public List<AdditionalServices> getAddServList() {
		return addServList;
	}


	public void setAddServList(List<AdditionalServices> addServList) {
		this.addServList = addServList;
	}


	public List<AdditionalServicesCategory> getAddServCategList() {
		return addServCategList;
	}


	public void setAddServCategList(
			List<AdditionalServicesCategory> addServCategList) {
		this.addServCategList = addServCategList;
	}


	public List<Radiology> getRadList() {
		return radList;
	}


	public void setRadList(List<Radiology> radList) {
		this.radList = radList;
	}


	public List<MedicalSupply> getMedList() {
		return medList;
	}


	public void setMedList(List<MedicalSupply> medList) {
		this.medList = medList;
	}


	public List<Specialization> getSpecList() {
		return specList;
	}


	public void setSpecList(List<Specialization> specList) {
		this.specList = specList;
	}


	public List<Building> getBuildList() {
		return buildList;
	}


	public void setBuildList(List<Building> buildList) {
		this.buildList = buildList;
	}


	public List<LaboratoryExamination> getLabList() {
		return labList;
	}


	public void setLabList(List<LaboratoryExamination> labList) {
		this.labList = labList;
	}


	public List<Patient> getPatientList() {
		return patientList;
	}


	public void setPatientList(List<Patient> patientList) {
		this.patientList = patientList;
	}


	public List<MonitorNursery> getNurseryList() {
		return nurseryList;
	}


	public void setNurseryList(List<MonitorNursery> nurseryList) {
		this.nurseryList = nurseryList;
	}


	public List<Employee> getEmpList() {
		return empList;
	}


	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}


	public List<User> getUserList() {
		return userList;
	}


	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public boolean isGotRecords() {
		if ((profList!=null && !profList.isEmpty()) 
		  || (surgeryList!=null && !surgeryList.isEmpty()) 
		  || (roomList!=null && !roomList.isEmpty()) 
		  || (roomCategList!=null && !roomCategList.isEmpty()) 
		  || (equipList!=null && !equipList.isEmpty()) 
		  || (discountList!=null && !discountList.isEmpty()) 
		  || (addServList!=null && !addServList.isEmpty()) 
		  || (addServCategList!=null && !addServCategList.isEmpty()) 
		  || (radList!=null && !radList.isEmpty()) 
		  || (medList!=null && !medList.isEmpty()) 
		  || (specList!=null && !specList.isEmpty()) 
		  || (buildList!=null && !buildList.isEmpty()) 
		  || (labList!=null && !labList.isEmpty()) 
		  || (patientList!=null && !patientList.isEmpty()) 
		  || (nurseryList!=null && !nurseryList.isEmpty()) 
		  || (empList!=null && !empList.isEmpty()) 
		  || (userList!=null && !userList.isEmpty()) 
		   )
		{
			gotRecords = true;
		}
		return gotRecords;
	}



	public void setGotRecords(boolean gotRecords) {
		this.gotRecords = gotRecords;
	}


	public void populateEntityTypeDropdownList(HttpServletRequest request) throws Exception{
        @SuppressWarnings("unchecked")
		List<ListValue> lovList = (ArrayList<ListValue>) request.getSession().getAttribute(MiscConstant.LOVTYPE_ENTITY_TYPE_SESSION);
    	if (lovList!=null) {
    		setEntityTypeLOV(lovList);
    	}
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		ActionErrors errors = new ActionErrors();
		
		return errors;
	}		
	
	

}
