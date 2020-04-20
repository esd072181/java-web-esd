package com.transport.form;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.transport.constant.ActionConstant;
import com.transport.constant.MapConstant;
import com.transport.constant.MiscConstant;
import com.transport.constant.ModuleConstant;
import com.transport.constant.ParamConstant;
import com.transport.model.Lorry;
import com.transport.model.Tire;
import com.transport.model.TireDetails;
import com.transport.model.TireDetailsView;
import com.transport.service.ServiceManager;
import com.transport.service.ServiceManagerImpl;
import com.transport.util.DateUtils;
import com.transport.util.TransportUtils;

/**
 * 
 * @author edwarddavid
 * @since 10Apr2020
 * DateUpdated: 18Apr2020
 */
public class TireManagementFormBean extends TransportFormBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String lorryNo;
	private String serialNo;
	private String tractorPlateNo;
	private String trailerPlateNo;
	private String wheelPosition;
	private String recapNo;
	private String odometer;
	private String odometer2;
	private String odometerStart;
	private String odometerEnd;
	private String thread1;
	private String thread2;
	private String thread3;
	private String reasonForRemoval;
	private String dateFitted;
	private String dateRemoved;
	private String dateUpdated;
	
	private List<Tire> tireList;
	private List<TireDetails> tireDetailsList;
	private List<Lorry> lorryList;
	private TireDetailsView modelView;
	
	private boolean transactionStatus;
	private String transactionMessage;
	private boolean tractor;
	private String brandName;
	private String color;
	private String retired;
	private String dateRetired;
	
	public TireManagementFormBean() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Lorry> getLorryList() {
		return lorryList;
	}

	public void setLorryList(List<Lorry> lorryList) {
		this.lorryList = lorryList;
	}
	
	public void populateFormBean(TireDetails model) throws Exception {
		setId(model.getId());
		setLorryNo(model.getLorryNo());
		setSerialNo(model.getSerialNo());
		setRecapNo(model.getRecapNo());
		setWheelPosition(model.getWheelPosition());
		setTractor(isLorryTractor(model.getWheelPosition()));
		if (isTractor()) { 
			setTractorPlateNo(model.getPlateNo());
		} else {
			setTrailerPlateNo(model.getPlateNo());
		}
		setWheelPosition(model.getWheelPosition());
		setOdometer(String.valueOf(model.getOdometerFitted()));
		setThread1(model.getThreadDepth1() > 0 ? String.valueOf(model.getThreadDepth1()) : "");
		setThread2(model.getThreadDepth2() > 0 ? String.valueOf(model.getThreadDepth2()) : "");
		setThread3(model.getThreadDepth3() > 0 ? String.valueOf(model.getThreadDepth3()) : "");
		if (model.getDateUpdated()!=null) {
			setDateUpdated(DateUtils.sqlDateToString(model.getDateUpdated()));
		}
	}
	
	public TireDetails populateModel (TireManagementFormBean formbean, String method) throws Exception{
		TireDetails model = new TireDetails();
		model.setId(formbean.getId());
		model.setLorryNo(formbean.getLorryNo());
		model.setSerialNo(formbean.getSerialNo()!=null ? formbean.getSerialNo().toUpperCase() : "");
		model.setRecapNo(formbean.getRecapNo());
		model.setWheelPosition(formbean.getWheelPosition());
		formbean.setTractor(formbean.isLorryTractor(formbean.getWheelPosition()));
		if (formbean.isTractor()) { 
			model.setPlateNo(formbean.getTractorPlateNo());
		} else {
			model.setPlateNo(formbean.getTrailerPlateNo());
		}
		
		if (method.equals(ParamConstant.AJAX_SAVE) || method.equals(ParamConstant.AJAX_SAVE_INNER)) {//assign tire or add details
			if (formbean.getOdometer()!=null && formbean.getOdometer().trim().length() > 0) {
				model.setOdometerFitted(computeTotalOdometer(formbean));
				if (formbean.getDateFitted()!=null && formbean.getDateFitted().trim().length()>0) {
					model.setDateFitted(DateUtils.strToSQLDate(formbean.getDateFitted()));
				}
				if (formbean.getDateUpdated()!=null) {
					model.setDateUpdated(DateUtils.strToSQLDate(formbean.getDateUpdated()));
				}
			}
		} else if (method.equals(ParamConstant.AJAX_UPDATE)) {//remove tire
			if (formbean.getOdometer()!=null && formbean.getOdometer().trim().length() > 0) {
				model.setOdometerRemoved(computeTotalOdometer(formbean));
			}
			if (formbean.getDateRemoved()!=null) {
				model.setDateRemoved(DateUtils.strToSQLDate(formbean.getDateRemoved()));
			}
			model.setReasonForRemoval(formbean.getReasonForRemoval());
			model.setRetired(formbean.getRetired());
		} else if (method.equals(ParamConstant.AJAX_UPDATE_INNER)) {//edit tire
			model.setOdometerFitted(Integer.valueOf(formbean.getOdometer()));
			if (formbean.getDateUpdated()!=null) {
				model.setDateUpdated(DateUtils.strToSQLDate(formbean.getDateUpdated()));
			}
		}
			
		model.setThreadDepth1(formbean.getThread1()!=null && formbean.getThread1().trim().length()>0 ? Integer.parseInt(formbean.getThread1()) : 0);
		model.setThreadDepth2(formbean.getThread2()!=null && formbean.getThread2().trim().length()>0 ? Integer.parseInt(formbean.getThread2()) : 0);
		model.setThreadDepth3(formbean.getThread3()!=null && formbean.getThread3().trim().length()>0 ? Integer.parseInt(formbean.getThread3()) : 0);
		//distance traveled, compute in TireManagementBoImpl
		
		return model;
	}
	
	/**
	 * 
	 * @param formbean
	 * @return
	 */
	private Integer computeTotalOdometer(TireManagementFormBean formbean) {
		int hubOdometer = Integer.parseInt(formbean.getOdometer());
		int totalOdometer = 0;
		if (formbean.getOdometer2()!=null && (formbean.getOdometer2().trim().equals("YES"))) {
			//compute
			BigDecimal odoStart = BigDecimal.valueOf((formbean.getOdometerStart()!=null && formbean.getOdometerStart().trim().length()>0 ? Integer.parseInt(formbean.getOdometerStart()): 0));
			BigDecimal odoEnd = BigDecimal.valueOf((formbean.getOdometerEnd()!=null && formbean.getOdometerEnd().trim().length()>0 ? Integer.parseInt(formbean.getOdometerEnd()): 0));
			int odometerValue = odoEnd.subtract(odoStart).intValue();
			totalOdometer = hubOdometer + odometerValue;
		} else {
			totalOdometer = hubOdometer;
		}
		return totalOdometer;
	}
	
	public void populateDropdownList(HttpServletRequest request, boolean isEdit) throws Exception{
		populateLorryList(request); 
		populateTireList(request);
	}
	
	private void populateLorryList(HttpServletRequest request) throws Exception{        
		//get the lorry list
        HashMap<String,Object> dataMap = new HashMap<String, Object>();
		dataMap.put(MapConstant.MODULE, ModuleConstant.LORRY);
		dataMap.put(MapConstant.ACTION, ActionConstant.GET_ACTIVE_DATA);
		ServiceManager service = new ServiceManagerImpl();
		Map<String, Object> resultMap = service.executeRequest(dataMap);
        
        if (resultMap!=null && !resultMap.isEmpty()) {
			@SuppressWarnings("unchecked")
			List<Lorry> qryList =  (ArrayList<Lorry>) resultMap.get(MapConstant.CLASS_LIST);		        		
			setLorryList(qryList);
        	if (request.getSession().getAttribute(MiscConstant.TRANS_LORRY_LIST)!=null) {
        		request.getSession().removeAttribute(MiscConstant.TRANS_LORRY_LIST);
        	}
        	//save to session
        	request.getSession().setAttribute(MiscConstant.TRANS_LORRY_LIST, qryList);
        }        
	}
	
	private void populateTireList(HttpServletRequest request) throws Exception{        
		//get the tire list
        HashMap<String,Object> dataMap = new HashMap<String, Object>();
		dataMap.put(MapConstant.MODULE, ModuleConstant.TIRE);
		dataMap.put(MapConstant.ACTION, ActionConstant.GET_ACTIVE_DATA);
		ServiceManager service = new ServiceManagerImpl();
		Map<String, Object> resultMap = service.executeRequest(dataMap);
        
        if (resultMap!=null && !resultMap.isEmpty()) {
			@SuppressWarnings("unchecked")
			List<Tire> qryList =  (ArrayList<Tire>) resultMap.get(MapConstant.CLASS_LIST);		        		
			setTireList(qryList);
        	if (request.getSession().getAttribute(MiscConstant.TRANS_TIRE_LIST)!=null) {
        		request.getSession().removeAttribute(MiscConstant.TRANS_TIRE_LIST);
        	}
        	//save to session
        	request.getSession().setAttribute(MiscConstant.TRANS_TIRE_LIST, qryList);
        }  else {
        	List<Tire> emptyList = new ArrayList<>();
        	setTireList(emptyList);
        	//save to session
        	request.getSession().setAttribute(MiscConstant.TRANS_TIRE_LIST, emptyList);
        }
	}
	
	@SuppressWarnings("unchecked")
	public void populateDropdownListFromSession(HttpServletRequest request, boolean isEdit) throws Exception{
		if (request.getSession().getAttribute(MiscConstant.TRANS_LORRY_LIST)!=null) {
			setLorryList((List<Lorry>)request.getSession().getAttribute(MiscConstant.TRANS_LORRY_LIST));
		}
		if (request.getSession().getAttribute(MiscConstant.TRANS_TIRE_LIST)!=null) {
			setTireList((List<Tire>)request.getSession().getAttribute(MiscConstant.TRANS_TIRE_LIST));
		}
	}
	
	public void getPlateNoByLorryNo(String lorryNo) {
		for (Lorry item: getLorryList()) {
			if (item.getLorryNo().equals(getLorryNo())) {
				this.tractorPlateNo = item.getPlateNo();
				this.trailerPlateNo = item.getTrailerNo();
				break;
			}
		}
	}

	public String getLorryNo() {
		return lorryNo;
	}

	public void setLorryNo(String lorryNo) {
		this.lorryNo = lorryNo;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {

		// TODO Auto-generated method stub
		ActionErrors errors = new ActionErrors();
		
		String command = (String) request.getParameter("command"); 
		boolean flag = false;
		
		if (command!=null && (command.equalsIgnoreCase(ParamConstant.AJAX_SAVE) 
				|| command.equalsIgnoreCase(ParamConstant.AJAX_SAVE_INNER)
				|| command.equalsIgnoreCase(ParamConstant.AJAX_UPDATE)
				|| command.equalsIgnoreCase(ParamConstant.AJAX_UPDATE_INNER))) {
			
			boolean isEdit = command.equalsIgnoreCase(ParamConstant.AJAX_UPDATE) || command.equalsIgnoreCase(ParamConstant.AJAX_UPDATE_INNER) ? true: false;
			if (this.getSerialNo()==null || this.getSerialNo().trim().length() < 1) {		
				flag = true;
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("mf.serialno.req"));
			}
			if (this.getOdometer()==null || this.getOdometer().trim().length() < 1) {		
				flag = true;
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("tran.hubodometer.req"));
			}
			
			if (flag) {
				try {
					//get list from session
					populateDropdownListFromSession(request, isEdit);	
					getPlateNoByLorryNo(getLorryNo());
							
				} catch(Exception e) {}				
			}
			
		} 
		
		return errors;
	
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

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getTractorPlateNo() {
		return tractorPlateNo;
	}

	public void setTractorPlateNo(String tractorPlateNo) {
		this.tractorPlateNo = tractorPlateNo;
	}

	public String getTrailerPlateNo() {
		return trailerPlateNo;
	}

	public void setTrailerPlateNo(String trailerPlateNo) {
		this.trailerPlateNo = trailerPlateNo;
	}

	public String getWheelPosition() {
		return wheelPosition;
	}

	public void setWheelPosition(String wheelPosition) {
		this.wheelPosition = wheelPosition;
	}

	public String getRecapNo() {
		return recapNo;
	}

	public void setRecapNo(String recapNo) {
		this.recapNo = recapNo;
	}

	public String getOdometer() {
		return odometer;
	}

	public void setOdometer(String odometer) {
		this.odometer = odometer;
	}

	public List<Tire> getTireList() {
		return tireList;
	}

	public void setTireList(List<Tire> tireList) {
		this.tireList = tireList;
	}

	public List<TireDetails> getTireDetailsList() {
		return tireDetailsList;
	}

	public void setTireDetailsList(List<TireDetails> tireDetailsList) {
		this.tireDetailsList = tireDetailsList;
	}

	public String getOdometer2() {
		return odometer2;
	}

	public void setOdometer2(String odometer2) {
		this.odometer2 = odometer2;
	}

	public String getOdometerStart() {
		return odometerStart;
	}

	public void setOdometerStart(String odometerStart) {
		this.odometerStart = odometerStart;
	}

	public String getOdometerEnd() {
		return odometerEnd;
	}

	public void setOdometerEnd(String odometerEnd) {
		this.odometerEnd = odometerEnd;
	}

	public String getThread1() {
		return thread1;
	}

	public void setThread1(String thread1) {
		this.thread1 = thread1;
	}

	public String getThread2() {
		return thread2;
	}

	public void setThread2(String thread2) {
		this.thread2 = thread2;
	}

	public String getThread3() {
		return thread3;
	}

	public void setThread3(String thread3) {
		this.thread3 = thread3;
	}

	public String getDateFitted() {
		return dateFitted;
	}

	public void setDateFitted(String dateFitted) {
		this.dateFitted = dateFitted;
	}

	public String getDateRemoved() {
		return dateRemoved;
	}

	public void setDateRemoved(String dateRemoved) {
		this.dateRemoved = dateRemoved;
	}

	public String getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(String dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public String getReasonForRemoval() {
		return reasonForRemoval;
	}

	public void setReasonForRemoval(String reasonForRemoval) {
		this.reasonForRemoval = reasonForRemoval;
	}

	public boolean isTractor() {
		return tractor;
	}

	public void setTractor(boolean tractor) {
		this.tractor = tractor;
	}

	/**
	 * 
	 * @param wheelPosition
	 * @return
	 */
	public Boolean isLorryTractor(String wheelPosition) {
		boolean ans = false;
		if (wheelPosition.equals("FL") || wheelPosition.equals("FR") || wheelPosition.equals("DLO") || wheelPosition.equals("DLI") 
				|| wheelPosition.equals("R2") || wheelPosition.equals("DRI") || wheelPosition.equals("DRO") || wheelPosition.equals("RLO")
				|| wheelPosition.equals("RLI") || wheelPosition.equals("RRI") || wheelPosition.equals("RRO")) {
			ans = true;
		}
		
		return ans;
	}
	
	/**
	 * 
	 * @param tireDetails
	 */
	public void setTireDetailsView(List<TireDetails> tireDetails) {
		this.modelView = new TireDetailsView();
		for (TireDetails item: tireDetails) {
			switch(item.getWheelPosition()) {
				case "FL":
					this.modelView.setThread1FL(String.valueOf(item.getThreadDepth1()));
					this.modelView.setThread2FL(String.valueOf(item.getThreadDepth2()));
					this.modelView.setThread3FL(String.valueOf(item.getThreadDepth3()));
					this.modelView.setColorFL(getTireColor(item));
					this.modelView.setSerialNoFL(item.getSerialNo());
					break;
				case "FR":
					this.modelView.setThread1FR(String.valueOf(item.getThreadDepth1()));
					this.modelView.setThread2FR(String.valueOf(item.getThreadDepth2()));
					this.modelView.setThread3FR(String.valueOf(item.getThreadDepth3()));
					this.modelView.setColorFR(getTireColor(item));
					this.modelView.setSerialNoFR(item.getSerialNo());
					break;
				case "DLO":
					this.modelView.setThread1DLO(String.valueOf(item.getThreadDepth1()));
					this.modelView.setThread2DLO(String.valueOf(item.getThreadDepth2()));
					this.modelView.setThread3DLO(String.valueOf(item.getThreadDepth3()));
					this.modelView.setColorDLO(getTireColor(item));
					this.modelView.setSerialNoDLO(item.getSerialNo());
					break;
				case "DLI":
					this.modelView.setThread1DLI(String.valueOf(item.getThreadDepth1()));
					this.modelView.setThread2DLI(String.valueOf(item.getThreadDepth2()));
					this.modelView.setThread3DLI(String.valueOf(item.getThreadDepth3()));
					this.modelView.setColorDLI(getTireColor(item));
					this.modelView.setSerialNoDLI(item.getSerialNo());
					break;
				case "R2":
					this.modelView.setThread1R2(String.valueOf(item.getThreadDepth1()));
					this.modelView.setThread2R2(String.valueOf(item.getThreadDepth2()));
					this.modelView.setThread3R2(String.valueOf(item.getThreadDepth3()));
					this.modelView.setColorR2(getTireColor(item));
					this.modelView.setSerialNoR2(item.getSerialNo());
					break;
				case "DRI":
					this.modelView.setThread1DRI(String.valueOf(item.getThreadDepth1()));
					this.modelView.setThread2DRI(String.valueOf(item.getThreadDepth2()));
					this.modelView.setThread3DRI(String.valueOf(item.getThreadDepth3()));
					this.modelView.setColorDRI(getTireColor(item));
					this.modelView.setSerialNoDRI(item.getSerialNo());
					break;
				case "DRO":
					this.modelView.setThread1DRO(String.valueOf(item.getThreadDepth1()));
					this.modelView.setThread2DRO(String.valueOf(item.getThreadDepth2()));
					this.modelView.setThread3DRO(String.valueOf(item.getThreadDepth3()));
					this.modelView.setColorDRO(getTireColor(item));
					this.modelView.setSerialNoDRO(item.getSerialNo());
					break;
				case "RLO":
					this.modelView.setThread1RLO(String.valueOf(item.getThreadDepth1()));
					this.modelView.setThread2RLO(String.valueOf(item.getThreadDepth2()));
					this.modelView.setThread3RLO(String.valueOf(item.getThreadDepth3()));
					this.modelView.setColorRLO(getTireColor(item));
					this.modelView.setSerialNoRLO(item.getSerialNo());
					break;
				case "RLI":
					this.modelView.setThread1RLI(String.valueOf(item.getThreadDepth1()));
					this.modelView.setThread2RLI(String.valueOf(item.getThreadDepth2()));
					this.modelView.setThread3RLI(String.valueOf(item.getThreadDepth3()));
					this.modelView.setColorRLI(getTireColor(item));
					this.modelView.setSerialNoRLI(item.getSerialNo());
					break;
				case "RRI":
					this.modelView.setThread1RRI(String.valueOf(item.getThreadDepth1()));
					this.modelView.setThread2RRI(String.valueOf(item.getThreadDepth2()));
					this.modelView.setThread3RRI(String.valueOf(item.getThreadDepth3()));
					this.modelView.setColorRRI(getTireColor(item));
					this.modelView.setSerialNoRRI(item.getSerialNo());
					break;
				case "RRO":
					this.modelView.setThread1RRO(String.valueOf(item.getThreadDepth1()));
					this.modelView.setThread2RRO(String.valueOf(item.getThreadDepth2()));
					this.modelView.setThread3RRO(String.valueOf(item.getThreadDepth3()));
					this.modelView.setColorRRO(getTireColor(item));
					this.modelView.setSerialNoRRO(item.getSerialNo());
					break;
				case "FLO":
					this.modelView.setThread1FLO(String.valueOf(item.getThreadDepth1()));
					this.modelView.setThread2FLO(String.valueOf(item.getThreadDepth2()));
					this.modelView.setThread3FLO(String.valueOf(item.getThreadDepth3()));
					this.modelView.setColorFLO(getTireColor(item));
					this.modelView.setSerialNoFLO(item.getSerialNo());
					break;
				case "FLI":
					this.modelView.setThread1FLI(String.valueOf(item.getThreadDepth1()));
					this.modelView.setThread2FLI(String.valueOf(item.getThreadDepth2()));
					this.modelView.setThread3FLI(String.valueOf(item.getThreadDepth3()));
					this.modelView.setColorFLI(getTireColor(item));
					this.modelView.setSerialNoFLI(item.getSerialNo());
					break;
				case "FRI":
					this.modelView.setThread1FRI(String.valueOf(item.getThreadDepth1()));
					this.modelView.setThread2FRI(String.valueOf(item.getThreadDepth2()));
					this.modelView.setThread3FRI(String.valueOf(item.getThreadDepth3()));
					this.modelView.setColorFRI(getTireColor(item));
					this.modelView.setSerialNoFRI(item.getSerialNo());
					break;
				case "FRO":
					this.modelView.setThread1FRO(String.valueOf(item.getThreadDepth1()));
					this.modelView.setThread2FRO(String.valueOf(item.getThreadDepth2()));
					this.modelView.setThread3FRO(String.valueOf(item.getThreadDepth3()));
					this.modelView.setColorFRO(getTireColor(item));
					this.modelView.setSerialNoFRO(item.getSerialNo());
					break;
				case "SLO":
					this.modelView.setThread1SLO(String.valueOf(item.getThreadDepth1()));
					this.modelView.setThread2SLO(String.valueOf(item.getThreadDepth2()));
					this.modelView.setThread3SLO(String.valueOf(item.getThreadDepth3()));
					this.modelView.setColorSLO(getTireColor(item));
					this.modelView.setSerialNoSLO(item.getSerialNo());
					break;
				case "SLI":
					this.modelView.setThread1SLI(String.valueOf(item.getThreadDepth1()));
					this.modelView.setThread2SLI(String.valueOf(item.getThreadDepth2()));
					this.modelView.setThread3SLI(String.valueOf(item.getThreadDepth3()));
					this.modelView.setColorSLI(getTireColor(item));
					this.modelView.setSerialNoSLI(item.getSerialNo());
					break;
				case "SRI":
					this.modelView.setThread1SRI(String.valueOf(item.getThreadDepth1()));
					this.modelView.setThread2SRI(String.valueOf(item.getThreadDepth2()));
					this.modelView.setThread3SRI(String.valueOf(item.getThreadDepth3()));
					this.modelView.setColorSRI(getTireColor(item));
					this.modelView.setSerialNoSRI(item.getSerialNo());
					break;
				case "SRO":
					this.modelView.setThread1SRO(String.valueOf(item.getThreadDepth1()));
					this.modelView.setThread2SRO(String.valueOf(item.getThreadDepth2()));
					this.modelView.setThread3SRO(String.valueOf(item.getThreadDepth3()));
					this.modelView.setColorSRO(getTireColor(item));
					this.modelView.setSerialNoSRO(item.getSerialNo());
					break;
				case "TLO":
					this.modelView.setThread1TLO(String.valueOf(item.getThreadDepth1()));
					this.modelView.setThread2TLO(String.valueOf(item.getThreadDepth2()));
					this.modelView.setThread3TLO(String.valueOf(item.getThreadDepth3()));
					this.modelView.setColorTLO(getTireColor(item));
					this.modelView.setSerialNoTLO(item.getSerialNo());
					break;
				case "TLI":
					this.modelView.setThread1TLI(String.valueOf(item.getThreadDepth1()));
					this.modelView.setThread2TLI(String.valueOf(item.getThreadDepth2()));
					this.modelView.setThread3TLI(String.valueOf(item.getThreadDepth3()));
					this.modelView.setColorTLI(getTireColor(item));
					this.modelView.setSerialNoTLI(item.getSerialNo());
					break;
				case "R":
					this.modelView.setThread1R(String.valueOf(item.getThreadDepth1()));
					this.modelView.setThread2R(String.valueOf(item.getThreadDepth2()));
					this.modelView.setThread3R(String.valueOf(item.getThreadDepth3()));
					this.modelView.setColorR(getTireColor(item));
					this.modelView.setSerialNoR(item.getSerialNo());
					break;
				case "TRI":
					this.modelView.setThread1TRI(String.valueOf(item.getThreadDepth1()));
					this.modelView.setThread2TRI(String.valueOf(item.getThreadDepth2()));
					this.modelView.setThread3TRI(String.valueOf(item.getThreadDepth3()));
					this.modelView.setColorTRI(getTireColor(item));
					this.modelView.setSerialNoTRI(item.getSerialNo());
					break;
				case "TRO":
					this.modelView.setThread1TRO(String.valueOf(item.getThreadDepth1()));
					this.modelView.setThread2TRO(String.valueOf(item.getThreadDepth2()));
					this.modelView.setThread3TRO(String.valueOf(item.getThreadDepth3()));
					this.modelView.setColorTRO(getTireColor(item));
					this.modelView.setSerialNoTRO(item.getSerialNo());
					break;
			default: break;
			}
		}
	}
	/**
	 * 
	 * @param details
	 * @return
	 */
	private String getTireColor(TireDetails details){
		String color = null;
		int[] arrThread = new int[3];
		arrThread[0] = details.getThreadDepth1();
		arrThread[1] = details.getThreadDepth2();
		arrThread[2] = details.getThreadDepth3();
		int lowestThread = TransportUtils.getLowestNum(arrThread, 3);
		if (lowestThread <= 2) {
			color = "BLACK";
		} else if (lowestThread>= 3 && lowestThread <= 4) {
			color = "GRAY";
		} else if (lowestThread>= 5 && lowestThread <= 6) {
			color = "RED";
		} else if (lowestThread>= 7 && lowestThread <= 9) {
			color = "ORANGE";
		} else if (lowestThread>= 10 && lowestThread <= 12) {
			color = "YELLOW";
		} else if (lowestThread>= 13 && lowestThread <= 14) {
			color = "LIME";
		} else {
			color = "BLUE";
		}
		
		return color;
	}

	/**
	 * 
	 * @param tireDetails
	 */
	public void setTireDetailsLatestInfo(List<TireDetails> tireDetails) {
		//get the Active record (latest info)
		for (TireDetails item: tireDetails) {
			if (item.isActive()) {
				this.setBrandName(item.getBrandName());
				this.setSerialNo(item.getSerialNo());
				this.setRecapNo(item.getRecapNo());
				this.setWheelPosition(item.getWheelPosition());
				this.setThread1(String.valueOf(item.getThreadDepth1()));
				this.setThread2(String.valueOf(item.getThreadDepth2()));
				this.setThread3(String.valueOf(item.getThreadDepth3()));
				this.setColor(getTireColor(item));
				break;				
			}
		}
	}
	
	public TireDetailsView getModelView() {
		return modelView;
	}

	public void setModelView(TireDetailsView modelView) {
		this.modelView = modelView;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getRetired() {
		return retired;
	}

	public void setRetired(String retired) {
		this.retired = retired;
	}

	public String getDateRetired() {
		return dateRetired;
	}

	public void setDateRetired(String dateRetired) {
		this.dateRetired = dateRetired;
	}

	
	

}
