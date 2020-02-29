package com.pibs.form;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import com.pibs.constant.ActionConstant;
import com.pibs.constant.MapConstant;
import com.pibs.constant.ModuleConstant;
import com.pibs.constant.ParamConstant;
import com.pibs.model.MonitorRoomTransfer;
import com.pibs.model.Room;
import com.pibs.service.ServiceManager;
import com.pibs.service.ServiceManagerImpl;
import com.pibs.util.DateUtils;

public class MonitorRoomTransferFormBean extends PIBSFormBean {

	private static final long serialVersionUID = 1L;
	private int id;
	private int patientCaseSystemId;
	private int roomIdTransfer;
	private String dateTransferred;
	
	//name fields
	private String roomNoTransfer;
	
	private List<Room> modelList;
	private List<MonitorRoomTransfer> entityList;
	
	private String criteria;
	private String category;
	private int noOfPages;
	private int currentPage;
	
	private boolean transactionStatus;
	private String transactionMessage;
	
	public MonitorRoomTransferFormBean() {}




	public String getCriteria() {
		return criteria;
	}

	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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
	

	public int getPatientCaseSystemId() {
		return patientCaseSystemId;
	}

	public void setPatientCaseSystemId(int patientCaseSystemId) {
		this.patientCaseSystemId = patientCaseSystemId;
	}









	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}



	public List<Room> getModelList() {
		return modelList;
	}




	public void setModelList(List<Room> modelList) {
		this.modelList = modelList;
	}




	public String getDateTransferred() {
		return dateTransferred;
	}




	public void setDateTransferred(String dateTransferred) {
		this.dateTransferred = dateTransferred;
	}




	public String getRoomNoTransfer() {
		return roomNoTransfer;
	}




	public void setRoomNoTransfer(String roomNoTransfer) {
		this.roomNoTransfer = roomNoTransfer;
	}


	public List<MonitorRoomTransfer> getEntityList() {
		return entityList;
	}




	public void setEntityList(List<MonitorRoomTransfer> entityList) {
		this.entityList = entityList;
	}


	public int getRoomIdTransfer() {
		return roomIdTransfer;
	}


	public void setRoomIdTransfer(int roomIdTransfer) {
		this.roomIdTransfer = roomIdTransfer;
	}



	public void populateFormBean(MonitorRoomTransfer model) throws Exception {
		setPatientCaseSystemId(model.getPatientCaseSystemId());
		setRoomIdTransfer(model.getRoomIdTransfer());
		if (model.getDateTransferred()!=null) {
			setDateTransferred(DateUtils.sqlDateToString(model.getDateTransferred()));
		}
	}
	
	public void populateEntityList(List<MonitorRoomTransfer> rsList) throws Exception {
		setEntityList(rsList);
	}
	
	public MonitorRoomTransfer populateModel (MonitorRoomTransferFormBean formbean) throws Exception {
		MonitorRoomTransfer model = new MonitorRoomTransfer();
		model.setPatientCaseSystemId(formbean.getPatientCaseSystemId());
		model.setRoomIdTransfer(formbean.getRoomIdTransfer());
		if (formbean.getDateTransferred()!=null && formbean.getDateTransferred().trim().length() > 0) {
			model.setDateTransferred(DateUtils.strToSQLDate(formbean.getDateTransferred()));;	
		}
		return model;
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		ActionErrors errors = new ActionErrors();
		
		String command = (String) request.getParameter("command"); 
		
		if (command!=null && (command.equalsIgnoreCase(ParamConstant.AJAX_SAVE) || command.equalsIgnoreCase(ParamConstant.AJAX_UPDATE))) {

		} 

		return errors;
	}


	public void getRoomDetails(HttpServletRequest request) throws Exception {
		//fetch the room details
		int id = Integer.parseInt(request.getParameter("roomTransferId"));
		
		Room model = new Room();
		model.setId(id);
		
		HashMap<String,Object> dataMap = new HashMap<String, Object>();
        dataMap.put(MapConstant.MODULE, ModuleConstant.ROOM);
        dataMap.put(MapConstant.CLASS_DATA, model);
        dataMap.put(MapConstant.ACTION, ActionConstant.GET_DATA);
        
        ServiceManager service = new ServiceManagerImpl();
        Map<String, Object> resultMap = service.executeRequest(dataMap);
		
        if (resultMap!=null && !resultMap.isEmpty()) {
	        model = (Room) resultMap.get(MapConstant.CLASS_DATA);
        	setRoomIdTransfer(model.getId());
        	setRoomNoTransfer(model.getRoomNo());        		
        }
	}	
	
}
