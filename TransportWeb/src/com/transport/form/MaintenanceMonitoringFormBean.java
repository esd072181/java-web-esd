package com.transport.form;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import com.transport.constant.ActionConstant;
import com.transport.constant.MapConstant;
import com.transport.constant.MiscConstant;
import com.transport.constant.ModuleConstant;
import com.transport.constant.ParamConstant;
import com.transport.model.ListValue;
import com.transport.model.Lorry;
import com.transport.model.MaintenanceMonitoring;
import com.transport.model.MaintenanceMonitoringFleet;
import com.transport.model.MaintenanceMonitoringPreventive;
import com.transport.model.MaintenanceMonitoringPreventiveTotal;
import com.transport.model.MaintenanceMonitoringTotalPending;
import com.transport.service.ServiceManager;
import com.transport.service.ServiceManagerImpl;

/**
 * 
 * @author dward
 * @since 26Mar2019
 * DateUpdated: 18Mar2020
 */
public class MaintenanceMonitoringFormBean extends TransportFormBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String plateNo;
	private String trailerNo;
	private String lorryNo;
	private String capacity;
	private String gps;//trips
	private String gpsColor;
	private String gpsRemarks;
	private String gpsTripIssue;
	private String maintenance;
	private String maintenanceColor;
	private String maintenanceCategory;
	private String maintenanceRemarks;
	private String availableVolume;
	private String year;
	private String month;
	private String day;
	private List<MaintenanceMonitoring> modelList;
	private List<MaintenanceMonitoringFleet> modelListShellFleet;
	private List<MaintenanceMonitoringFleet> modelListCaltexFleet;
	private List<MaintenanceMonitoringFleet> modelListGrandTotalFleet;
	private List<MaintenanceMonitoringPreventive> modelListPreventive;
	private List<MaintenanceMonitoringPreventiveTotal> modelListPreventiveTotal;
	private List<MaintenanceMonitoringTotalPending> modelListTotalPending;
	private List<ListValue> maintenancePersonnelOptionsLOV;
	private List<ListValue> gpsPersonnelOptionsLOV;
	private List<ListValue> gpsTripIssueCategoryLOV;
	private List<ListValue> maintenanceCategoryLOV;
	private List<Lorry> lorryList;
	
	private boolean transactionStatus;
	private String transactionMessage;
	private String isEditStatusLocked;
	private String monthStr;
	
	private String yearCriteria;
	private String monthCriteria;
	private String lorryNoCriteria;
	private int moduleInner;
	
	//for Preventive/Breakdown
	private int idPreventive;
	private String preventive;
	private String preventiveRemarks;
	
	private String lorryAndPlateNo;

	//for Total Pending Row
	private int idTotalPending;
	private String remarks;	
	
	//for Report
	private int reportType;//1 for Monthly - 2 for Annually
		
	public MaintenanceMonitoringFormBean() {}

	
	public String getLorryAndPlateNo() {
		return lorryAndPlateNo;
	}



	public void setLorryAndPlateNo(String lorryAndPlateNo) {
		this.lorryAndPlateNo = lorryAndPlateNo;
	}



	public List<MaintenanceMonitoringFleet> getModelListGrandTotalFleet() {
		return modelListGrandTotalFleet;
	}


	public void setModelListGrandTotalFleet(
			List<MaintenanceMonitoringFleet> modelListGrandTotalFleet) {
		this.modelListGrandTotalFleet = modelListGrandTotalFleet;
	}


	public List<MaintenanceMonitoringFleet> getModelListCaltexFleet() {
		return modelListCaltexFleet;
	}


	public void setModelListCaltexFleet(
			List<MaintenanceMonitoringFleet> modelListCaltexFleet) {
		this.modelListCaltexFleet = modelListCaltexFleet;
	}


	public List<MaintenanceMonitoringFleet> getModelListShellFleet() {
		return modelListShellFleet;
	}


	public void setModelListShellFleet(
			List<MaintenanceMonitoringFleet> modelListShellFleet) {
		this.modelListShellFleet = modelListShellFleet;
	}

	
	public int getModuleInner() {
		return moduleInner;
	}


	public void setModuleInner(int moduleInner) {
		this.moduleInner = moduleInner;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public void populateFormBeanGPS(MaintenanceMonitoring model) throws Exception {
		setId(model.getId());
		switch (getDay()) {
			case "1":
				setGps(model.getGps1());
				setGpsColor(model.getGpsColor1()>0 ? String.valueOf(model.getGpsColor1()) : "");
				setGpsRemarks(model.getGpsRemarks1());
				setGpsTripIssue(model.getGpsTripIssue1()>0 ? String.valueOf(model.getGpsTripIssue1()) : "");
				break;
			case "2":
				setGps(model.getGps2());
				setGpsColor(model.getGpsColor2()>0 ? String.valueOf(model.getGpsColor2()) : "");
				setGpsRemarks(model.getGpsRemarks2());
				setGpsTripIssue(model.getGpsTripIssue2()>0 ? String.valueOf(model.getGpsTripIssue2()) : "");
				break;
			case "3":
				setGps(model.getGps3());
				setGpsColor(model.getGpsColor3()>0 ? String.valueOf(model.getGpsColor3()) : "");
				setGpsRemarks(model.getGpsRemarks3());
				setGpsTripIssue(model.getGpsTripIssue3()>0 ? String.valueOf(model.getGpsTripIssue3()) : "");
				break;
			case "4":
				setGps(model.getGps4());
				setGpsColor(model.getGpsColor4()>0 ? String.valueOf(model.getGpsColor4()) : "");
				setGpsRemarks(model.getGpsRemarks4());
				setGpsTripIssue(model.getGpsTripIssue4()>0 ? String.valueOf(model.getGpsTripIssue4()) : "");
				break;
			case "5":
				setGps(model.getGps5());
				setGpsColor(model.getGpsColor5()>0 ? String.valueOf(model.getGpsColor5()) : "");
				setGpsRemarks(model.getGpsRemarks5());
				setGpsTripIssue(model.getGpsTripIssue5()>0 ? String.valueOf(model.getGpsTripIssue5()) : "");
				break;
			case "6":
				setGps(model.getGps6());
				setGpsColor(model.getGpsColor6()>0 ? String.valueOf(model.getGpsColor6()) : "");
				setGpsRemarks(model.getGpsRemarks6());
				setGpsTripIssue(model.getGpsTripIssue6()>0 ? String.valueOf(model.getGpsTripIssue6()) : "");
				break;
			case "7":
				setGps(model.getGps7());
				setGpsColor(model.getGpsColor7()>0 ? String.valueOf(model.getGpsColor7()) : "");
				setGpsRemarks(model.getGpsRemarks7());
				setGpsTripIssue(model.getGpsTripIssue7()>0 ? String.valueOf(model.getGpsTripIssue7()) : "");
				break;
			case "8":
				setGps(model.getGps8());
				setGpsColor(model.getGpsColor8()>0 ? String.valueOf(model.getGpsColor8()) : "");
				setGpsRemarks(model.getGpsRemarks8());
				setGpsTripIssue(model.getGpsTripIssue8()>0 ? String.valueOf(model.getGpsTripIssue8()) : "");
				break;
			case "9":
				setGps(model.getGps9());
				setGpsColor(model.getGpsColor9()>0 ? String.valueOf(model.getGpsColor9()) : "");
				setGpsRemarks(model.getGpsRemarks9());
				setGpsTripIssue(model.getGpsTripIssue9()>0 ? String.valueOf(model.getGpsTripIssue9()) : "");
				break;
			case "10":
				setGps(model.getGps10());
				setGpsColor(model.getGpsColor10()>0 ? String.valueOf(model.getGpsColor10()) : "");
				setGpsRemarks(model.getGpsRemarks10());
				setGpsTripIssue(model.getGpsTripIssue10()>0 ? String.valueOf(model.getGpsTripIssue10()) : "");
				break;
			case "11":
				setGps(model.getGps11());
				setGpsColor(model.getGpsColor11()>0 ? String.valueOf(model.getGpsColor11()) : "");
				setGpsRemarks(model.getGpsRemarks11());
				setGpsTripIssue(model.getGpsTripIssue11()>0 ? String.valueOf(model.getGpsTripIssue11()) : "");
				break;
			case "12":
				setGps(model.getGps12());
				setGpsColor(model.getGpsColor12()>0 ? String.valueOf(model.getGpsColor12()) : "");
				setGpsRemarks(model.getGpsRemarks12());
				setGpsTripIssue(model.getGpsTripIssue12()>0 ? String.valueOf(model.getGpsTripIssue12()) : "");
				break;
			case "13":
				setGps(model.getGps13());
				setGpsColor(model.getGpsColor13()>0 ? String.valueOf(model.getGpsColor13()) : "");
				setGpsRemarks(model.getGpsRemarks13());
				setGpsTripIssue(model.getGpsTripIssue13()>0 ? String.valueOf(model.getGpsTripIssue13()) : "");
				break;
			case "14":
				setGps(model.getGps14());
				setGpsColor(model.getGpsColor14()>0 ? String.valueOf(model.getGpsColor14()) : "");
				setGpsRemarks(model.getGpsRemarks14());
				setGpsTripIssue(model.getGpsTripIssue14()>0 ? String.valueOf(model.getGpsTripIssue14()) : "");
				break;
			case "15":
				setGps(model.getGps15());
				setGpsColor(model.getGpsColor15()>0 ? String.valueOf(model.getGpsColor15()) : "");
				setGpsRemarks(model.getGpsRemarks15());
				setGpsTripIssue(model.getGpsTripIssue15()>0 ? String.valueOf(model.getGpsTripIssue15()) : "");
				break;
			case "16":
				setGps(model.getGps16());
				setGpsColor(model.getGpsColor16()>0 ? String.valueOf(model.getGpsColor16()) : "");
				setGpsRemarks(model.getGpsRemarks16());
				setGpsTripIssue(model.getGpsTripIssue16()>0 ? String.valueOf(model.getGpsTripIssue16()) : "");
				break;
			case "17":
				setGps(model.getGps17());
				setGpsColor(model.getGpsColor17()>0 ? String.valueOf(model.getGpsColor17()) : "");
				setGpsRemarks(model.getGpsRemarks17());
				setGpsTripIssue(model.getGpsTripIssue17()>0 ? String.valueOf(model.getGpsTripIssue17()) : "");
				break;
			case "18":
				setGps(model.getGps18());
				setGpsColor(model.getGpsColor18()>0 ? String.valueOf(model.getGpsColor18()) : "");
				setGpsRemarks(model.getGpsRemarks18());
				setGpsTripIssue(model.getGpsTripIssue18()>0 ? String.valueOf(model.getGpsTripIssue18()) : "");
				break;
			case "19":
				setGps(model.getGps19());
				setGpsColor(model.getGpsColor19()>0 ? String.valueOf(model.getGpsColor19()) : "");
				setGpsRemarks(model.getGpsRemarks19());
				setGpsTripIssue(model.getGpsTripIssue19()>0 ? String.valueOf(model.getGpsTripIssue19()) : "");
				break;
			case "20":
				setGps(model.getGps20());
				setGpsColor(model.getGpsColor20()>0 ? String.valueOf(model.getGpsColor20()) : "");
				setGpsRemarks(model.getGpsRemarks20());
				setGpsTripIssue(model.getGpsTripIssue20()>0 ? String.valueOf(model.getGpsTripIssue20()) : "");
				break;
			case "21":
				setGps(model.getGps21());
				setGpsColor(model.getGpsColor20()>0 ? String.valueOf(model.getGpsColor21()) : "");
				setGpsRemarks(model.getGpsRemarks21());
				setGpsTripIssue(model.getGpsTripIssue21()>0 ? String.valueOf(model.getGpsTripIssue21()) : "");
				break;
			case "22":
				setGps(model.getGps22());
				setGpsColor(model.getGpsColor20()>0 ? String.valueOf(model.getGpsColor22()) : "");
				setGpsRemarks(model.getGpsRemarks22());
				setGpsTripIssue(model.getGpsTripIssue22()>0 ? String.valueOf(model.getGpsTripIssue22()) : "");
				break;
			case "23":
				setGps(model.getGps23());
				setGpsColor(model.getGpsColor23()>0 ? String.valueOf(model.getGpsColor23()) : "");
				setGpsRemarks(model.getGpsRemarks23());
				setGpsTripIssue(model.getGpsTripIssue23()>0 ? String.valueOf(model.getGpsTripIssue23()) : "");
				break;
			case "24":
				setGps(model.getGps24());
				setGpsColor(model.getGpsColor24()>0 ? String.valueOf(model.getGpsColor24()) : "");
				setGpsRemarks(model.getGpsRemarks24());
				setGpsTripIssue(model.getGpsTripIssue24()>0 ? String.valueOf(model.getGpsTripIssue24()) : "");
				break;
			case "25":
				setGps(model.getGps25());
				setGpsColor(model.getGpsColor25()>0 ? String.valueOf(model.getGpsColor25()) : "");
				setGpsRemarks(model.getGpsRemarks25());
				setGpsTripIssue(model.getGpsTripIssue25()>0 ? String.valueOf(model.getGpsTripIssue25()) : "");
				break;
			case "26":
				setGps(model.getGps26());
				setGpsColor(model.getGpsColor26()>0 ? String.valueOf(model.getGpsColor26()) : "");
				setGpsRemarks(model.getGpsRemarks26());
				setGpsTripIssue(model.getGpsTripIssue26()>0 ? String.valueOf(model.getGpsTripIssue26()) : "");
				break;
			case "27":
				setGps(model.getGps27());
				setGpsColor(model.getGpsColor27()>0 ? String.valueOf(model.getGpsColor27()) : "");
				setGpsRemarks(model.getGpsRemarks27());
				setGpsTripIssue(model.getGpsTripIssue27()>0 ? String.valueOf(model.getGpsTripIssue27()) : "");
				break;
			case "28":
				setGps(model.getGps28());
				setGpsColor(model.getGpsColor28()>0 ? String.valueOf(model.getGpsColor28()) : "");
				setGpsRemarks(model.getGpsRemarks28());
				setGpsTripIssue(model.getGpsTripIssue28()>0 ? String.valueOf(model.getGpsTripIssue28()) : "");
				break;
			case "29":
				setGps(model.getGps29());
				setGpsColor(model.getGpsColor29()>0 ? String.valueOf(model.getGpsColor29()) : "");
				setGpsRemarks(model.getGpsRemarks29());
				setGpsTripIssue(model.getGpsTripIssue29()>0 ? String.valueOf(model.getGpsTripIssue29()) : "");
				break;
			case "30":
				setGps(model.getGps30());
				setGpsColor(model.getGpsColor30()>0 ? String.valueOf(model.getGpsColor30()) : "");
				setGpsRemarks(model.getGpsRemarks30());
				setGpsTripIssue(model.getGpsTripIssue30()>0 ? String.valueOf(model.getGpsTripIssue30()) : "");
				break;
			case "31":
				setGps(model.getGps31());
				setGpsColor(model.getGpsColor31()>0 ? String.valueOf(model.getGpsColor31()) : "");
				setGpsRemarks(model.getGpsRemarks31());
				setGpsTripIssue(model.getGpsTripIssue31()>0 ? String.valueOf(model.getGpsTripIssue31()) : "");
			break;
		}

	}
	
	public void populateFormBeanMaintenance(MaintenanceMonitoring model) throws Exception {
		setId(model.getId());
		switch (getDay()) {
			case "1":
				setMaintenance(model.getMaintenance1());
				setMaintenanceColor(model.getMaintenanceColor1()>0 ? String.valueOf(model.getMaintenanceColor1()): "");
				setMaintenanceCategory(model.getMaintenanceCategory1()>0 ? String.valueOf(model.getMaintenanceCategory1()) : "");
				setMaintenanceRemarks(model.getMaintenanceRemarks1());
				setAvailableVolume(String.valueOf(model.getAvailableVolume1()));
				break;
			case "2":
				setMaintenance(model.getMaintenance2());
				setMaintenanceColor(model.getMaintenanceColor2()>0 ? String.valueOf(model.getMaintenanceColor2()): "");
				setMaintenanceCategory(model.getMaintenanceCategory2()>0 ? String.valueOf(model.getMaintenanceCategory2()) : "");
				setMaintenanceRemarks(model.getMaintenanceRemarks2());
				setAvailableVolume(String.valueOf(model.getAvailableVolume2()));
				break;
			case "3":
				setMaintenance(model.getMaintenance3());
				setMaintenanceColor(model.getMaintenanceColor3()>0 ? String.valueOf(model.getMaintenanceColor3()): "");
				setMaintenanceCategory(model.getMaintenanceCategory3()>0 ? String.valueOf(model.getMaintenanceCategory3()) : "");
				setMaintenanceRemarks(model.getMaintenanceRemarks3());
				setAvailableVolume(String.valueOf(model.getAvailableVolume3()));
				break;
			case "4":
				setMaintenance(model.getMaintenance4());
				setMaintenanceColor(model.getMaintenanceColor4()>0 ? String.valueOf(model.getMaintenanceColor4()): "");
				setMaintenanceCategory(model.getMaintenanceCategory4()>0 ? String.valueOf(model.getMaintenanceCategory4()) : "");
				setMaintenanceRemarks(model.getMaintenanceRemarks4());
				setAvailableVolume(String.valueOf(model.getAvailableVolume4()));
				break;
			case "5":
				setMaintenance(model.getMaintenance5());
				setMaintenanceColor(model.getMaintenanceColor5()>0 ? String.valueOf(model.getMaintenanceColor5()): "");
				setMaintenanceCategory(model.getMaintenanceCategory5()>0 ? String.valueOf(model.getMaintenanceCategory5()) : "");
				setMaintenanceRemarks(model.getMaintenanceRemarks5());
				setAvailableVolume(String.valueOf(model.getAvailableVolume5()));
				break;
			case "6":
				setMaintenance(model.getMaintenance6());
				setMaintenanceColor(model.getMaintenanceColor6()>0 ? String.valueOf(model.getMaintenanceColor6()): "");
				setMaintenanceCategory(model.getMaintenanceCategory6()>0 ? String.valueOf(model.getMaintenanceCategory6()) : "");
				setMaintenanceRemarks(model.getMaintenanceRemarks6());
				setAvailableVolume(String.valueOf(model.getAvailableVolume6()));
				break;
			case "7":
				setMaintenance(model.getMaintenance7());
				setMaintenanceColor(model.getMaintenanceColor7()>0 ? String.valueOf(model.getMaintenanceColor7()): "");
				setMaintenanceCategory(model.getMaintenanceCategory7()>0 ? String.valueOf(model.getMaintenanceCategory7()) : "");
				setMaintenanceRemarks(model.getMaintenanceRemarks7());
				setAvailableVolume(String.valueOf(model.getAvailableVolume7()));
				break;
			case "8":
				setMaintenance(model.getMaintenance8());
				setMaintenanceColor(model.getMaintenanceColor8()>0 ? String.valueOf(model.getMaintenanceColor8()): "");
				setMaintenanceCategory(model.getMaintenanceCategory8()>0 ? String.valueOf(model.getMaintenanceCategory8()) : "");
				setMaintenanceRemarks(model.getMaintenanceRemarks8());
				setAvailableVolume(String.valueOf(model.getAvailableVolume8()));
				break;
			case "9":
				setMaintenance(model.getMaintenance9());
				setMaintenanceColor(model.getMaintenanceColor9()>0 ? String.valueOf(model.getMaintenanceColor9()): "");
				setMaintenanceCategory(model.getMaintenanceCategory9()>0 ? String.valueOf(model.getMaintenanceCategory9()) : "");
				setMaintenanceRemarks(model.getMaintenanceRemarks9());
				setAvailableVolume(String.valueOf(model.getAvailableVolume9()));
				break;
			case "10":
				setMaintenance(model.getMaintenance10());
				setMaintenanceColor(model.getMaintenanceColor10()>0 ? String.valueOf(model.getMaintenanceColor10()): "");
				setMaintenanceCategory(model.getMaintenanceCategory10()>0 ? String.valueOf(model.getMaintenanceCategory10()) : "");
				setMaintenanceRemarks(model.getMaintenanceRemarks10());
				setAvailableVolume(String.valueOf(model.getAvailableVolume10()));
				break;
			case "11":
				setMaintenance(model.getMaintenance11());
				setMaintenanceColor(model.getMaintenanceColor11()>0 ? String.valueOf(model.getMaintenanceColor11()): "");
				setMaintenanceCategory(model.getMaintenanceCategory11()>0 ? String.valueOf(model.getMaintenanceCategory11()) : "");
				setMaintenanceRemarks(model.getMaintenanceRemarks11());
				setAvailableVolume(String.valueOf(model.getAvailableVolume11()));
				break;
			case "12":
				setMaintenance(model.getMaintenance12());
				setMaintenanceColor(model.getMaintenanceColor12()>0 ? String.valueOf(model.getMaintenanceColor12()): "");
				setMaintenanceCategory(model.getMaintenanceCategory12()>0 ? String.valueOf(model.getMaintenanceCategory12()) : "");
				setMaintenanceRemarks(model.getMaintenanceRemarks12());
				setAvailableVolume(String.valueOf(model.getAvailableVolume12()));
				break;
			case "13":
				setMaintenance(model.getMaintenance13());
				setMaintenanceColor(model.getMaintenanceColor13()>0 ? String.valueOf(model.getMaintenanceColor13()): "");
				setMaintenanceCategory(model.getMaintenanceCategory13()>0 ? String.valueOf(model.getMaintenanceCategory13()) : "");
				setMaintenanceRemarks(model.getMaintenanceRemarks13());
				setAvailableVolume(String.valueOf(model.getAvailableVolume13()));
				break;
			case "14":
				setMaintenance(model.getMaintenance14());
				setMaintenanceColor(model.getMaintenanceColor14()>0 ? String.valueOf(model.getMaintenanceColor14()): "");
				setMaintenanceCategory(model.getMaintenanceCategory14()>0 ? String.valueOf(model.getMaintenanceCategory14()) : "");
				setMaintenanceRemarks(model.getMaintenanceRemarks14());
				setAvailableVolume(String.valueOf(model.getAvailableVolume14()));
				break;
			case "15":
				setMaintenance(model.getMaintenance15());
				setMaintenanceColor(model.getMaintenanceColor15()>0 ? String.valueOf(model.getMaintenanceColor15()): "");
				setMaintenanceCategory(model.getMaintenanceCategory15()>0 ? String.valueOf(model.getMaintenanceCategory15()) : "");
				setMaintenanceRemarks(model.getMaintenanceRemarks15());
				setAvailableVolume(String.valueOf(model.getAvailableVolume15()));
				break;
			case "16":
				setMaintenance(model.getMaintenance16());
				setMaintenanceColor(model.getMaintenanceColor16()>0 ? String.valueOf(model.getMaintenanceColor16()): "");
				setMaintenanceCategory(model.getMaintenanceCategory16()>0 ? String.valueOf(model.getMaintenanceCategory16()) : "");
				setMaintenanceRemarks(model.getMaintenanceRemarks16());
				setAvailableVolume(String.valueOf(model.getAvailableVolume16()));
				break;
			case "17":
				setMaintenance(model.getMaintenance17());
				setMaintenanceColor(model.getMaintenanceColor17()>0 ? String.valueOf(model.getMaintenanceColor17()): "");
				setMaintenanceCategory(model.getMaintenanceCategory17()>0 ? String.valueOf(model.getMaintenanceCategory17()) : "");
				setMaintenanceRemarks(model.getMaintenanceRemarks17());
				setAvailableVolume(String.valueOf(model.getAvailableVolume17()));
				break;
			case "18":
				setMaintenance(model.getMaintenance18());
				setMaintenanceColor(model.getMaintenanceColor18()>0 ? String.valueOf(model.getMaintenanceColor18()): "");
				setMaintenanceCategory(model.getMaintenanceCategory18()>0 ? String.valueOf(model.getMaintenanceCategory18()) : "");
				setMaintenanceRemarks(model.getMaintenanceRemarks18());
				setAvailableVolume(String.valueOf(model.getAvailableVolume18()));
				break;
			case "19":
				setMaintenance(model.getMaintenance19());
				setMaintenanceColor(model.getMaintenanceColor19()>0 ? String.valueOf(model.getMaintenanceColor19()): "");
				setMaintenanceCategory(model.getMaintenanceCategory19()>0 ? String.valueOf(model.getMaintenanceCategory19()) : "");
				setMaintenanceRemarks(model.getMaintenanceRemarks19());
				setAvailableVolume(String.valueOf(model.getAvailableVolume19()));
				break;
			case "20":
				setMaintenance(model.getMaintenance20());
				setMaintenanceColor(model.getMaintenanceColor20()>0 ? String.valueOf(model.getMaintenanceColor20()): "");
				setMaintenanceCategory(model.getMaintenanceCategory20()>0 ? String.valueOf(model.getMaintenanceCategory20()) : "");
				setMaintenanceRemarks(model.getMaintenanceRemarks20());
				setAvailableVolume(String.valueOf(model.getAvailableVolume20()));
				break;
			case "21":
				setMaintenance(model.getMaintenance21());
				setMaintenanceColor(model.getMaintenanceColor21()>0 ? String.valueOf(model.getMaintenanceColor21()): "");
				setMaintenanceCategory(model.getMaintenanceCategory21()>0 ? String.valueOf(model.getMaintenanceCategory21()) : "");
				setMaintenanceRemarks(model.getMaintenanceRemarks21());
				setAvailableVolume(String.valueOf(model.getAvailableVolume21()));
				break;
			case "22":
				setMaintenance(model.getMaintenance22());
				setMaintenanceColor(model.getMaintenanceColor22()>0 ? String.valueOf(model.getMaintenanceColor22()): "");
				setMaintenanceCategory(model.getMaintenanceCategory22()>0 ? String.valueOf(model.getMaintenanceCategory22()) : "");
				setMaintenanceRemarks(model.getMaintenanceRemarks22());
				setAvailableVolume(String.valueOf(model.getAvailableVolume22()));
				break;
			case "23":
				setMaintenance(model.getMaintenance23());
				setMaintenanceColor(model.getMaintenanceColor23()>0 ? String.valueOf(model.getMaintenanceColor23()): "");
				setMaintenanceCategory(model.getMaintenanceCategory23()>0 ? String.valueOf(model.getMaintenanceCategory23()) : "");
				setMaintenanceRemarks(model.getMaintenanceRemarks23());
				setAvailableVolume(String.valueOf(model.getAvailableVolume23()));
				break;
			case "24":
				setMaintenance(model.getMaintenance24());
				setMaintenanceColor(model.getMaintenanceColor24()>0 ? String.valueOf(model.getMaintenanceColor24()): "");
				setMaintenanceCategory(model.getMaintenanceCategory24()>0 ? String.valueOf(model.getMaintenanceCategory24()) : "");
				setMaintenanceRemarks(model.getMaintenanceRemarks24());
				setAvailableVolume(String.valueOf(model.getAvailableVolume24()));
				break;
			case "25":
				setMaintenance(model.getMaintenance25());
				setMaintenanceColor(model.getMaintenanceColor25()>0 ? String.valueOf(model.getMaintenanceColor25()): "");
				setMaintenanceCategory(model.getMaintenanceCategory25()>0 ? String.valueOf(model.getMaintenanceCategory25()) : "");
				setMaintenanceRemarks(model.getMaintenanceRemarks25());
				setAvailableVolume(String.valueOf(model.getAvailableVolume25()));
				break;
			case "26":
				setMaintenance(model.getMaintenance26());
				setMaintenanceColor(model.getMaintenanceColor26()>0 ? String.valueOf(model.getMaintenanceColor26()): "");
				setMaintenanceCategory(model.getMaintenanceCategory26()>0 ? String.valueOf(model.getMaintenanceCategory26()) : "");
				setMaintenanceRemarks(model.getMaintenanceRemarks26());
				setAvailableVolume(String.valueOf(model.getAvailableVolume26()));
				break;
			case "27":
				setMaintenance(model.getMaintenance27());
				setMaintenanceColor(model.getMaintenanceColor27()>0 ? String.valueOf(model.getMaintenanceColor27()): "");
				setMaintenanceCategory(model.getMaintenanceCategory27()>0 ? String.valueOf(model.getMaintenanceCategory27()) : "");
				setMaintenanceRemarks(model.getMaintenanceRemarks27());
				setAvailableVolume(String.valueOf(model.getAvailableVolume27()));
				break;
			case "28":
				setMaintenance(model.getMaintenance28());
				setMaintenanceColor(model.getMaintenanceColor28()>0 ? String.valueOf(model.getMaintenanceColor28()): "");
				setMaintenanceCategory(model.getMaintenanceCategory28()>0 ? String.valueOf(model.getMaintenanceCategory28()) : "");
				setMaintenanceRemarks(model.getMaintenanceRemarks28());
				setAvailableVolume(String.valueOf(model.getAvailableVolume28()));
				break;
			case "29":
				setMaintenance(model.getMaintenance29());
				setMaintenanceColor(model.getMaintenanceColor29()>0 ? String.valueOf(model.getMaintenanceColor29()): "");
				setMaintenanceCategory(model.getMaintenanceCategory29()>0 ? String.valueOf(model.getMaintenanceCategory29()) : "");
				setMaintenanceRemarks(model.getMaintenanceRemarks29());
				setAvailableVolume(String.valueOf(model.getAvailableVolume29()));
				break;
			case "30":
				setMaintenance(model.getMaintenance30());
				setMaintenanceColor(model.getMaintenanceColor30()>0 ? String.valueOf(model.getMaintenanceColor30()): "");
				setMaintenanceCategory(model.getMaintenanceCategory30()>0 ? String.valueOf(model.getMaintenanceCategory30()) : "");
				setMaintenanceRemarks(model.getMaintenanceRemarks30());
				setAvailableVolume(String.valueOf(model.getAvailableVolume30()));
				break;
			case "31":
				setMaintenance(model.getMaintenance31());
				setMaintenanceColor(model.getMaintenanceColor31()>0 ? String.valueOf(model.getMaintenanceColor31()): "");
				setMaintenanceCategory(model.getMaintenanceCategory31()>0 ? String.valueOf(model.getMaintenanceCategory31()) : "");
				setMaintenanceRemarks(model.getMaintenanceRemarks31());
				setAvailableVolume(String.valueOf(model.getAvailableVolume31()));
				break;
		}

	}
	
	//used for Add Lorry for Maintenance
	public MaintenanceMonitoring populateModel() throws Exception {
		MaintenanceMonitoring model = new MaintenanceMonitoring();
		model.setPlateNo(getPlateNo());
		model.setLorryNo(getLorryNo());
		model.setYear(Integer.parseInt(getYear()));
		model.setMonth(Integer.parseInt(getMonth()));
		return model;
	}
	
	public MaintenanceMonitoring populateModelGPS() throws Exception {
		MaintenanceMonitoring model = new MaintenanceMonitoring();
		model.setId(getId());
		model.setDay(Integer.parseInt(getDay()));
		model.setCapacity(Integer.parseInt(getCapacity()));
		switch (getDay()) {
		case "1":
			model.setGps1(!getGps().trim().equals("") ? getGps().trim() : null);
			model.setGpsColor1(!getGpsColor().equals("") ? Integer.parseInt(getGpsColor()) : 0);
			model.setGpsRemarks1(getGpsRemarks());
			model.setGpsTripIssue1(!getGpsTripIssue().equals("") ? Integer.parseInt(getGpsTripIssue()) : 0);
			break;
		case "2":
			model.setGps2(!getGps().trim().equals("") ? getGps().trim() : null);
			model.setGpsColor2(!getGpsColor().equals("") ? Integer.parseInt(getGpsColor()) : 0);
			model.setGpsRemarks2(getGpsRemarks());
			model.setGpsTripIssue2(!getGpsTripIssue().equals("") ? Integer.parseInt(getGpsTripIssue()) : 0);
			break;
		case "3":
			model.setGps3(!getGps().trim().equals("") ? getGps().trim() : null);
			model.setGpsColor3(!getGpsColor().equals("") ? Integer.parseInt(getGpsColor()) : 0);
			model.setGpsRemarks3(getGpsRemarks());
			model.setGpsTripIssue3(!getGpsTripIssue().equals("") ? Integer.parseInt(getGpsTripIssue()) : 0);
			break;
		case "4":
			model.setGps4(!getGps().trim().equals("") ? getGps().trim() : null);
			model.setGpsColor4(!getGpsColor().equals("") ? Integer.parseInt(getGpsColor()) : 0);
			model.setGpsRemarks4(getGpsRemarks());
			model.setGpsTripIssue4(!getGpsTripIssue().equals("") ? Integer.parseInt(getGpsTripIssue()) : 0);
			break;
		case "5":
			model.setGps5(!getGps().trim().equals("") ? getGps().trim() : null);
			model.setGpsColor5(!getGpsColor().equals("") ? Integer.parseInt(getGpsColor()) : 0);
			model.setGpsRemarks5(getGpsRemarks());
			model.setGpsTripIssue5(!getGpsTripIssue().equals("") ? Integer.parseInt(getGpsTripIssue()) : 0);
			break;
		case "6":
			model.setGps6(!getGps().trim().equals("") ? getGps().trim() : null);
			model.setGpsColor6(!getGpsColor().equals("") ? Integer.parseInt(getGpsColor()) : 0);
			model.setGpsRemarks6(getGpsRemarks());
			model.setGpsTripIssue6(!getGpsTripIssue().equals("") ? Integer.parseInt(getGpsTripIssue()) : 0);
			break;
		case "7":
			model.setGps7(!getGps().trim().equals("") ? getGps().trim() : null);
			model.setGpsColor7(!getGpsColor().equals("") ? Integer.parseInt(getGpsColor()) : 0);
			model.setGpsRemarks7(getGpsRemarks());
			model.setGpsTripIssue7(!getGpsTripIssue().equals("") ? Integer.parseInt(getGpsTripIssue()) : 0);
			break;
		case "8":
			model.setGps8(!getGps().trim().equals("") ? getGps().trim() : null);
			model.setGpsColor8(!getGpsColor().equals("") ? Integer.parseInt(getGpsColor()) : 0);
			model.setGpsRemarks8(getGpsRemarks());
			model.setGpsTripIssue8(!getGpsTripIssue().equals("") ? Integer.parseInt(getGpsTripIssue()) : 0);
			break;
		case "9":
			model.setGps9(!getGps().trim().equals("") ? getGps().trim() : null);
			model.setGpsColor9(!getGpsColor().equals("") ? Integer.parseInt(getGpsColor()) : 0);
			model.setGpsRemarks9(getGpsRemarks());
			model.setGpsTripIssue9(!getGpsTripIssue().equals("") ? Integer.parseInt(getGpsTripIssue()) : 0);
			break;
		case "10":
			model.setGps10(!getGps().trim().equals("") ? getGps().trim() : null);
			model.setGpsColor10(!getGpsColor().equals("") ? Integer.parseInt(getGpsColor()) : 0);
			model.setGpsRemarks10(getGpsRemarks());
			model.setGpsTripIssue10(!getGpsTripIssue().equals("") ? Integer.parseInt(getGpsTripIssue()) : 0);
			break;
		case "11":
			model.setGps11(!getGps().trim().equals("") ? getGps().trim() : null);
			model.setGpsColor11(!getGpsColor().equals("") ? Integer.parseInt(getGpsColor()) : 0);
			model.setGpsRemarks11(getGpsRemarks());
			model.setGpsTripIssue11(!getGpsTripIssue().equals("") ? Integer.parseInt(getGpsTripIssue()) : 0);
			break;
		case "12":
			model.setGps12(!getGps().trim().equals("") ? getGps().trim() : null);
			model.setGpsColor12(!getGpsColor().equals("") ? Integer.parseInt(getGpsColor()) : 0);
			model.setGpsRemarks12(getGpsRemarks());
			model.setGpsTripIssue12(!getGpsTripIssue().equals("") ? Integer.parseInt(getGpsTripIssue()) : 0);
			break;
		case "13":
			model.setGps13(!getGps().trim().equals("") ? getGps().trim() : null);
			model.setGpsColor13(!getGpsColor().equals("") ? Integer.parseInt(getGpsColor()) : 0);
			model.setGpsRemarks13(getGpsRemarks());
			model.setGpsTripIssue13(!getGpsTripIssue().equals("") ? Integer.parseInt(getGpsTripIssue()) : 0);
			break;
		case "14":
			model.setGps14(!getGps().trim().equals("") ? getGps().trim() : null);
			model.setGpsColor14(!getGpsColor().equals("") ? Integer.parseInt(getGpsColor()) : 0);
			model.setGpsRemarks14(getGpsRemarks());
			model.setGpsTripIssue14(!getGpsTripIssue().equals("") ? Integer.parseInt(getGpsTripIssue()) : 0);
			break;
		case "15":
			model.setGps15(!getGps().trim().equals("") ? getGps().trim() : null);
			model.setGpsColor15(!getGpsColor().equals("") ? Integer.parseInt(getGpsColor()) : 0);
			model.setGpsRemarks15(getGpsRemarks());
			model.setGpsTripIssue15(!getGpsTripIssue().equals("") ? Integer.parseInt(getGpsTripIssue()) : 0);
			break;
		case "16":
			model.setGps16(!getGps().trim().equals("") ? getGps().trim() : null);
			model.setGpsColor16(!getGpsColor().equals("") ? Integer.parseInt(getGpsColor()) : 0);
			model.setGpsRemarks16(getGpsRemarks());
			model.setGpsTripIssue16(!getGpsTripIssue().equals("") ? Integer.parseInt(getGpsTripIssue()) : 0);
			break;
		case "17":
			model.setGps17(!getGps().trim().equals("") ? getGps().trim() : null);
			model.setGpsColor17(!getGpsColor().equals("") ? Integer.parseInt(getGpsColor()) : 0);
			model.setGpsRemarks17(getGpsRemarks());
			model.setGpsTripIssue17(!getGpsTripIssue().equals("") ? Integer.parseInt(getGpsTripIssue()) : 0);
			break;
		case "18":
			model.setGps18(!getGps().trim().equals("") ? getGps().trim() : null);
			model.setGpsColor18(!getGpsColor().equals("") ? Integer.parseInt(getGpsColor()) : 0);
			model.setGpsRemarks18(getGpsRemarks());
			model.setGpsTripIssue18(!getGpsTripIssue().equals("") ? Integer.parseInt(getGpsTripIssue()) : 0);
			break;
		case "19":
			model.setGps19(!getGps().trim().equals("") ? getGps().trim() : null);
			model.setGpsColor19(!getGpsColor().equals("") ? Integer.parseInt(getGpsColor()) : 0);
			model.setGpsRemarks19(getGpsRemarks());
			model.setGpsTripIssue19(!getGpsTripIssue().equals("") ? Integer.parseInt(getGpsTripIssue()) : 0);
			break;
		case "20":
			model.setGps20(!getGps().trim().equals("") ? getGps().trim() : null);
			model.setGpsColor20(!getGpsColor().equals("") ? Integer.parseInt(getGpsColor()) : 0);
			model.setGpsRemarks20(getGpsRemarks());
			model.setGpsTripIssue20(!getGpsTripIssue().equals("") ? Integer.parseInt(getGpsTripIssue()) : 0);
			break;
		case "21":
			model.setGps21(!getGps().trim().equals("") ? getGps().trim() : null);
			model.setGpsColor21(!getGpsColor().equals("") ? Integer.parseInt(getGpsColor()) : 0);
			model.setGpsRemarks21(getGpsRemarks());
			model.setGpsTripIssue21(!getGpsTripIssue().equals("") ? Integer.parseInt(getGpsTripIssue()) : 0);
			break;
		case "22":
			model.setGps22(!getGps().trim().equals("") ? getGps().trim() : null);
			model.setGpsColor22(!getGpsColor().equals("") ? Integer.parseInt(getGpsColor()) : 0);
			model.setGpsRemarks22(getGpsRemarks());
			model.setGpsTripIssue22(!getGpsTripIssue().equals("") ? Integer.parseInt(getGpsTripIssue()) : 0);
			break;
		case "23":
			model.setGps23(!getGps().trim().equals("") ? getGps().trim() : null);
			model.setGpsColor23(!getGpsColor().equals("") ? Integer.parseInt(getGpsColor()) : 0);
			model.setGpsRemarks23(getGpsRemarks());
			model.setGpsTripIssue23(!getGpsTripIssue().equals("") ? Integer.parseInt(getGpsTripIssue()) : 0);
			break;
		case "24":
			model.setGps24(!getGps().trim().equals("") ? getGps().trim() : null);
			model.setGpsColor24(!getGpsColor().equals("") ? Integer.parseInt(getGpsColor()) : 0);
			model.setGpsRemarks24(getGpsRemarks());
			model.setGpsTripIssue24(!getGpsTripIssue().equals("") ? Integer.parseInt(getGpsTripIssue()) : 0);
			break;
		case "25":
			model.setGps25(!getGps().trim().equals("") ? getGps().trim() : null);
			model.setGpsColor25(!getGpsColor().equals("") ? Integer.parseInt(getGpsColor()) : 0);
			model.setGpsRemarks25(getGpsRemarks());
			model.setGpsTripIssue25(!getGpsTripIssue().equals("") ? Integer.parseInt(getGpsTripIssue()) : 0);
			break;
		case "26":
			model.setGps26(!getGps().trim().equals("") ? getGps().trim() : null);
			model.setGpsColor26(!getGpsColor().equals("") ? Integer.parseInt(getGpsColor()) : 0);
			model.setGpsRemarks26(getGpsRemarks());
			model.setGpsTripIssue26(!getGpsTripIssue().equals("") ? Integer.parseInt(getGpsTripIssue()) : 0);
			break;
		case "27":
			model.setGps27(!getGps().trim().equals("") ? getGps().trim() : null);
			model.setGpsColor27(!getGpsColor().equals("") ? Integer.parseInt(getGpsColor()) : 0);
			model.setGpsRemarks27(getGpsRemarks());
			model.setGpsTripIssue27(!getGpsTripIssue().equals("") ? Integer.parseInt(getGpsTripIssue()) : 0);
			break;
		case "28":
			model.setGps28(!getGps().trim().equals("") ? getGps().trim() : null);
			model.setGpsColor28(!getGpsColor().equals("") ? Integer.parseInt(getGpsColor()) : 0);
			model.setGpsRemarks28(getGpsRemarks());
			model.setGpsTripIssue28(!getGpsTripIssue().equals("") ? Integer.parseInt(getGpsTripIssue()) : 0);
			break;
		case "29":
			model.setGps29(!getGps().trim().equals("") ? getGps().trim() : null);
			model.setGpsColor29(!getGpsColor().equals("") ? Integer.parseInt(getGpsColor()) : 0);
			model.setGpsRemarks29(getGpsRemarks());
			model.setGpsTripIssue29(!getGpsTripIssue().equals("") ? Integer.parseInt(getGpsTripIssue()) : 0);
			break;
		case "30":
			model.setGps30(!getGps().trim().equals("") ? getGps().trim() : null);
			model.setGpsColor30(!getGpsColor().equals("") ? Integer.parseInt(getGpsColor()) : 0);
			model.setGpsRemarks30(getGpsRemarks());
			model.setGpsTripIssue30(!getGpsTripIssue().equals("") ? Integer.parseInt(getGpsTripIssue()) : 0);
			break;
		case "31":
			model.setGps31(!getGps().trim().equals("") ? getGps().trim() : null);
			model.setGpsColor31(!getGpsColor().equals("") ? Integer.parseInt(getGpsColor()) : 0);
			model.setGpsRemarks31(getGpsRemarks());
			model.setGpsTripIssue31(!getGpsTripIssue().equals("") ? Integer.parseInt(getGpsTripIssue()) : 0);
			break;
		}
		return model;
	}

	public MaintenanceMonitoring populateModelMaintenance() throws Exception {
		MaintenanceMonitoring model = new MaintenanceMonitoring();
		model.setId(getId());
		model.setDay(Integer.parseInt(getDay()));
		model.setCapacity(Integer.parseInt(getCapacity()));
		switch (getDay()) {
		case "1":
			model.setMaintenance1(getMaintenance().trim().equals("1") ? getMaintenance().trim() : null);
			model.setMaintenanceColor1(!getMaintenanceColor().equals("") ? Integer.parseInt(getMaintenanceColor()): 0);
			model.setMaintenanceCategory1(!getMaintenanceCategory().equals("") ? Integer.parseInt(getMaintenanceCategory()): 0);
			model.setMaintenanceRemarks1(getMaintenanceRemarks());
			model.setAvailableVolume1(getMaintenance()!=null && getMaintenance().trim().equals("1") ? Integer.parseInt(getCapacity()) * Integer.parseInt(getMaintenance()) : 0);
			break;
		case "2":
			model.setMaintenance2(getMaintenance().trim().equals("1") ? getMaintenance().trim() : null);
			model.setMaintenanceColor2(!getMaintenanceColor().equals("") ? Integer.parseInt(getMaintenanceColor()): 0);
			model.setMaintenanceCategory2(!getMaintenanceCategory().equals("") ? Integer.parseInt(getMaintenanceCategory()): 0);
			model.setMaintenanceRemarks2(getMaintenanceRemarks());
			model.setAvailableVolume2(getMaintenance()!=null && getMaintenance().trim().equals("1") ? Integer.parseInt(getCapacity()) * Integer.parseInt(getMaintenance()) : 0);			
			break;
		case "3":
			model.setMaintenance3(getMaintenance().trim().equals("1") ? getMaintenance().trim() : null);
			model.setMaintenanceColor3(!getMaintenanceColor().equals("") ? Integer.parseInt(getMaintenanceColor()): 0);
			model.setMaintenanceCategory3(!getMaintenanceCategory().equals("") ? Integer.parseInt(getMaintenanceCategory()): 0);
			model.setMaintenanceRemarks3(getMaintenanceRemarks());
			model.setAvailableVolume3(getMaintenance()!=null && getMaintenance().trim().equals("1") ? Integer.parseInt(getCapacity()) * Integer.parseInt(getMaintenance()) : 0);
			break;
		case "4":
			model.setMaintenance4(getMaintenance().trim().equals("1") ? getMaintenance().trim() : null);
			model.setMaintenanceColor4(!getMaintenanceColor().equals("") ? Integer.parseInt(getMaintenanceColor()): 0);
			model.setMaintenanceCategory4(!getMaintenanceCategory().equals("") ? Integer.parseInt(getMaintenanceCategory()): 0);
			model.setMaintenanceRemarks4(getMaintenanceRemarks());
			model.setAvailableVolume4(getMaintenance()!=null && getMaintenance().trim().equals("1") ? Integer.parseInt(getCapacity()) * Integer.parseInt(getMaintenance()) : 0);
			break;
		case "5":
			model.setMaintenance5(getMaintenance().trim().equals("1") ? getMaintenance().trim() : null);
			model.setMaintenanceColor5(!getMaintenanceColor().equals("") ? Integer.parseInt(getMaintenanceColor()): 0);
			model.setMaintenanceCategory5(!getMaintenanceCategory().equals("") ? Integer.parseInt(getMaintenanceCategory()): 0);
			model.setMaintenanceRemarks5(getMaintenanceRemarks());
			model.setAvailableVolume5(getMaintenance()!=null && getMaintenance().trim().equals("1") ? Integer.parseInt(getCapacity()) * Integer.parseInt(getMaintenance()) : 0);
			break;
		case "6":
			model.setMaintenance6(getMaintenance().trim().equals("1") ? getMaintenance().trim() : null);
			model.setMaintenanceColor6(!getMaintenanceColor().equals("") ? Integer.parseInt(getMaintenanceColor()): 0);
			model.setMaintenanceCategory6(!getMaintenanceCategory().equals("") ? Integer.parseInt(getMaintenanceCategory()): 0);
			model.setMaintenanceRemarks6(getMaintenanceRemarks());
			model.setAvailableVolume6(getMaintenance()!=null && getMaintenance().trim().equals("1") ? Integer.parseInt(getCapacity()) * Integer.parseInt(getMaintenance()) : 0);
			break;
		case "7":
			model.setMaintenance7(getMaintenance().trim().equals("1") ? getMaintenance().trim() : null);
			model.setMaintenanceColor7(!getMaintenanceColor().equals("") ? Integer.parseInt(getMaintenanceColor()): 0);
			model.setMaintenanceCategory7(!getMaintenanceCategory().equals("") ? Integer.parseInt(getMaintenanceCategory()): 0);
			model.setMaintenanceRemarks7(getMaintenanceRemarks());
			model.setAvailableVolume7(getMaintenance()!=null && getMaintenance().trim().equals("1") ? Integer.parseInt(getCapacity()) * Integer.parseInt(getMaintenance()) : 0);
			break;
		case "8":
			model.setMaintenance8(getMaintenance().trim().equals("1") ? getMaintenance().trim() : null);
			model.setMaintenanceColor8(!getMaintenanceColor().equals("") ? Integer.parseInt(getMaintenanceColor()): 0);
			model.setMaintenanceCategory8(!getMaintenanceCategory().equals("") ? Integer.parseInt(getMaintenanceCategory()): 0);
			model.setMaintenanceRemarks8(getMaintenanceRemarks());
			model.setAvailableVolume8(getMaintenance()!=null && getMaintenance().trim().equals("1") ? Integer.parseInt(getCapacity()) * Integer.parseInt(getMaintenance()) : 0);
			break;
		case "9":
			model.setMaintenance9(getMaintenance().trim().equals("1") ? getMaintenance().trim() : null);
			model.setMaintenanceColor9(!getMaintenanceColor().equals("") ? Integer.parseInt(getMaintenanceColor()): 0);
			model.setMaintenanceCategory9(!getMaintenanceCategory().equals("") ? Integer.parseInt(getMaintenanceCategory()): 0);
			model.setMaintenanceRemarks9(getMaintenanceRemarks());
			model.setAvailableVolume9(getMaintenance()!=null && getMaintenance().trim().equals("1") ? Integer.parseInt(getCapacity()) * Integer.parseInt(getMaintenance()) : 0);
			break;
		case "10":
			model.setMaintenance10(getMaintenance().trim().equals("1") ? getMaintenance().trim() : null);
			model.setMaintenanceColor10(!getMaintenanceColor().equals("") ? Integer.parseInt(getMaintenanceColor()): 0);
			model.setMaintenanceCategory10(!getMaintenanceCategory().equals("") ? Integer.parseInt(getMaintenanceCategory()): 0);
			model.setMaintenanceRemarks10(getMaintenanceRemarks());
			model.setAvailableVolume10(getMaintenance()!=null && getMaintenance().trim().equals("1") ? Integer.parseInt(getCapacity()) * Integer.parseInt(getMaintenance()) : 0);
			break;
		case "11":
			model.setMaintenance11(getMaintenance().trim().equals("1") ? getMaintenance().trim() : null);
			model.setMaintenanceColor11(!getMaintenanceColor().equals("") ? Integer.parseInt(getMaintenanceColor()): 0);
			model.setMaintenanceCategory11(!getMaintenanceCategory().equals("") ? Integer.parseInt(getMaintenanceCategory()): 0);
			model.setMaintenanceRemarks11(getMaintenanceRemarks());
			model.setAvailableVolume11(getMaintenance()!=null && getMaintenance().trim().equals("1") ? Integer.parseInt(getCapacity()) * Integer.parseInt(getMaintenance()) : 0);
			break;
		case "12":
			model.setMaintenance12(getMaintenance().trim().equals("1") ? getMaintenance().trim() : null);
			model.setMaintenanceColor12(!getMaintenanceColor().equals("") ? Integer.parseInt(getMaintenanceColor()): 0);
			model.setMaintenanceCategory12(!getMaintenanceCategory().equals("") ? Integer.parseInt(getMaintenanceCategory()): 0);
			model.setMaintenanceRemarks12(getMaintenanceRemarks());
			model.setAvailableVolume12(getMaintenance()!=null && getMaintenance().trim().equals("1") ? Integer.parseInt(getCapacity()) * Integer.parseInt(getMaintenance()) : 0);
			break;
		case "13":
			model.setMaintenance13(getMaintenance().trim().equals("1") ? getMaintenance().trim() : null);
			model.setMaintenanceColor13(!getMaintenanceColor().equals("") ? Integer.parseInt(getMaintenanceColor()): 0);
			model.setMaintenanceCategory13(!getMaintenanceCategory().equals("") ? Integer.parseInt(getMaintenanceCategory()): 0);
			model.setMaintenanceRemarks13(getMaintenanceRemarks());
			model.setAvailableVolume13(getMaintenance()!=null && getMaintenance().trim().equals("1") ? Integer.parseInt(getCapacity()) * Integer.parseInt(getMaintenance()) : 0);
			break;
		case "14":
			model.setMaintenance14(getMaintenance().trim().equals("1") ? getMaintenance().trim() : null);
			model.setMaintenanceColor14(!getMaintenanceColor().equals("") ? Integer.parseInt(getMaintenanceColor()): 0);
			model.setMaintenanceCategory14(!getMaintenanceCategory().equals("") ? Integer.parseInt(getMaintenanceCategory()): 0);
			model.setMaintenanceRemarks14(getMaintenanceRemarks());
			model.setAvailableVolume14(getMaintenance()!=null && getMaintenance().trim().equals("1") ? Integer.parseInt(getCapacity()) * Integer.parseInt(getMaintenance()) : 0);
			break;
		case "15":
			model.setMaintenance15(getMaintenance().trim().equals("1") ? getMaintenance().trim() : null);
			model.setMaintenanceColor15(!getMaintenanceColor().equals("") ? Integer.parseInt(getMaintenanceColor()): 0);
			model.setMaintenanceCategory15(!getMaintenanceCategory().equals("") ? Integer.parseInt(getMaintenanceCategory()): 0);
			model.setMaintenanceRemarks15(getMaintenanceRemarks());
			model.setAvailableVolume15(getMaintenance()!=null && getMaintenance().trim().equals("1") ? Integer.parseInt(getCapacity()) * Integer.parseInt(getMaintenance()) : 0);
			break;
		case "16":
			model.setMaintenance16(getMaintenance().trim().equals("1") ? getMaintenance().trim() : null);
			model.setMaintenanceColor16(!getMaintenanceColor().equals("") ? Integer.parseInt(getMaintenanceColor()): 0);
			model.setMaintenanceCategory16(!getMaintenanceCategory().equals("") ? Integer.parseInt(getMaintenanceCategory()): 0);
			model.setMaintenanceRemarks16(getMaintenanceRemarks());
			model.setAvailableVolume16(getMaintenance()!=null && getMaintenance().trim().equals("1") ? Integer.parseInt(getCapacity()) * Integer.parseInt(getMaintenance()) : 0);
			break;
		case "17":
			model.setMaintenance17(getMaintenance().trim().equals("1") ? getMaintenance().trim() : null);
			model.setMaintenanceColor17(!getMaintenanceColor().equals("") ? Integer.parseInt(getMaintenanceColor()): 0);
			model.setMaintenanceCategory17(!getMaintenanceCategory().equals("") ? Integer.parseInt(getMaintenanceCategory()): 0);
			model.setMaintenanceRemarks17(getMaintenanceRemarks());
			model.setAvailableVolume17(getMaintenance()!=null && getMaintenance().trim().equals("1") ? Integer.parseInt(getCapacity()) * Integer.parseInt(getMaintenance()) : 0);
			break;
		case "18":
			model.setMaintenance18(getMaintenance().trim().equals("1") ? getMaintenance().trim() : null);
			model.setMaintenanceColor18(!getMaintenanceColor().equals("") ? Integer.parseInt(getMaintenanceColor()): 0);
			model.setMaintenanceCategory18(!getMaintenanceCategory().equals("") ? Integer.parseInt(getMaintenanceCategory()): 0);
			model.setMaintenanceRemarks18(getMaintenanceRemarks());
			model.setAvailableVolume18(getMaintenance()!=null && getMaintenance().trim().equals("1") ? Integer.parseInt(getCapacity()) * Integer.parseInt(getMaintenance()) : 0);
			break;
		case "19":
			model.setMaintenance19(getMaintenance().trim().equals("1") ? getMaintenance().trim() : null);
			model.setMaintenanceColor19(!getMaintenanceColor().equals("") ? Integer.parseInt(getMaintenanceColor()): 0);
			model.setMaintenanceCategory19(!getMaintenanceCategory().equals("") ? Integer.parseInt(getMaintenanceCategory()): 0);
			model.setMaintenanceRemarks19(getMaintenanceRemarks());
			model.setAvailableVolume19(getMaintenance()!=null && getMaintenance().trim().equals("1") ? Integer.parseInt(getCapacity()) * Integer.parseInt(getMaintenance()) : 0);
			break;
		case "20":
			model.setMaintenance20(getMaintenance().trim().equals("1") ? getMaintenance().trim() : null);
			model.setMaintenanceColor20(!getMaintenanceColor().equals("") ? Integer.parseInt(getMaintenanceColor()): 0);
			model.setMaintenanceCategory20(!getMaintenanceCategory().equals("") ? Integer.parseInt(getMaintenanceCategory()): 0);
			model.setMaintenanceRemarks20(getMaintenanceRemarks());
			model.setAvailableVolume20(getMaintenance()!=null && getMaintenance().trim().equals("1") ? Integer.parseInt(getCapacity()) * Integer.parseInt(getMaintenance()) : 0);
			break;
		case "21":
			model.setMaintenance21(getMaintenance().trim().equals("1") ? getMaintenance().trim() : null);
			model.setMaintenanceColor21(!getMaintenanceColor().equals("") ? Integer.parseInt(getMaintenanceColor()): 0);
			model.setMaintenanceCategory21(!getMaintenanceCategory().equals("") ? Integer.parseInt(getMaintenanceCategory()): 0);
			model.setMaintenanceRemarks21(getMaintenanceRemarks());
			model.setAvailableVolume21(getMaintenance()!=null && getMaintenance().trim().equals("1") ? Integer.parseInt(getCapacity()) * Integer.parseInt(getMaintenance()) : 0);
			break;
		case "22":
			model.setMaintenance22(getMaintenance().trim().equals("1") ? getMaintenance().trim() : null);
			model.setMaintenanceColor22(!getMaintenanceColor().equals("") ? Integer.parseInt(getMaintenanceColor()): 0);
			model.setMaintenanceCategory22(!getMaintenanceCategory().equals("") ? Integer.parseInt(getMaintenanceCategory()): 0);
			model.setMaintenanceRemarks22(getMaintenanceRemarks());
			model.setAvailableVolume22(getMaintenance()!=null && getMaintenance().trim().equals("1") ? Integer.parseInt(getCapacity()) * Integer.parseInt(getMaintenance()) : 0);
			break;
		case "23":
			model.setMaintenance23(getMaintenance().trim().equals("1") ? getMaintenance().trim() : null);
			model.setMaintenanceColor23(!getMaintenanceColor().equals("") ? Integer.parseInt(getMaintenanceColor()): 0);
			model.setMaintenanceCategory23(!getMaintenanceCategory().equals("") ? Integer.parseInt(getMaintenanceCategory()): 0);
			model.setMaintenanceRemarks23(getMaintenanceRemarks());
			model.setAvailableVolume23(getMaintenance()!=null && getMaintenance().trim().equals("1") ? Integer.parseInt(getCapacity()) * Integer.parseInt(getMaintenance()) : 0);
			break;
		case "24":
			model.setMaintenance24(getMaintenance().trim().equals("1") ? getMaintenance().trim() : null);
			model.setMaintenanceColor24(!getMaintenanceColor().equals("") ? Integer.parseInt(getMaintenanceColor()): 0);
			model.setMaintenanceCategory24(!getMaintenanceCategory().equals("") ? Integer.parseInt(getMaintenanceCategory()): 0);
			model.setMaintenanceRemarks24(getMaintenanceRemarks());
			model.setAvailableVolume24(getMaintenance()!=null && getMaintenance().trim().equals("1") ? Integer.parseInt(getCapacity()) * Integer.parseInt(getMaintenance()) : 0);
			break;
		case "25":
			model.setMaintenance25(getMaintenance().trim().equals("1") ? getMaintenance().trim() : null);
			model.setMaintenanceColor25(!getMaintenanceColor().equals("") ? Integer.parseInt(getMaintenanceColor()): 0);
			model.setMaintenanceCategory25(!getMaintenanceCategory().equals("") ? Integer.parseInt(getMaintenanceCategory()): 0);
			model.setMaintenanceRemarks25(getMaintenanceRemarks());
			model.setAvailableVolume25(getMaintenance()!=null && getMaintenance().trim().equals("1") ? Integer.parseInt(getCapacity()) * Integer.parseInt(getMaintenance()) : 0);
			break;
		case "26":
			model.setMaintenance26(getMaintenance().trim().equals("1") ? getMaintenance().trim() : null);
			model.setMaintenanceColor26(!getMaintenanceColor().equals("") ? Integer.parseInt(getMaintenanceColor()): 0);
			model.setMaintenanceCategory26(!getMaintenanceCategory().equals("") ? Integer.parseInt(getMaintenanceCategory()): 0);
			model.setMaintenanceRemarks26(getMaintenanceRemarks());
			model.setAvailableVolume26(getMaintenance()!=null && getMaintenance().trim().equals("1") ? Integer.parseInt(getCapacity()) * Integer.parseInt(getMaintenance()) : 0);
			break;
		case "27":
			model.setMaintenance27(getMaintenance().trim().equals("1") ? getMaintenance().trim() : null);
			model.setMaintenanceColor27(!getMaintenanceColor().equals("") ? Integer.parseInt(getMaintenanceColor()): 0);
			model.setMaintenanceCategory27(!getMaintenanceCategory().equals("") ? Integer.parseInt(getMaintenanceCategory()): 0);
			model.setMaintenanceRemarks27(getMaintenanceRemarks());
			model.setAvailableVolume27(getMaintenance()!=null && getMaintenance().trim().equals("1") ? Integer.parseInt(getCapacity()) * Integer.parseInt(getMaintenance()) : 0);
			break;
		case "28":
			model.setMaintenance28(getMaintenance().trim().equals("1") ? getMaintenance().trim() : null);
			model.setMaintenanceColor28(!getMaintenanceColor().equals("") ? Integer.parseInt(getMaintenanceColor()): 0);
			model.setMaintenanceCategory28(!getMaintenanceCategory().equals("") ? Integer.parseInt(getMaintenanceCategory()): 0);
			model.setMaintenanceRemarks28(getMaintenanceRemarks());
			model.setAvailableVolume28(getMaintenance()!=null && getMaintenance().trim().equals("1") ? Integer.parseInt(getCapacity()) * Integer.parseInt(getMaintenance()) : 0);
			break;
		case "29":
			model.setMaintenance29(getMaintenance().trim().equals("1") ? getMaintenance().trim() : null);
			model.setMaintenanceColor29(!getMaintenanceColor().equals("") ? Integer.parseInt(getMaintenanceColor()): 0);
			model.setMaintenanceCategory29(!getMaintenanceCategory().equals("") ? Integer.parseInt(getMaintenanceCategory()): 0);
			model.setMaintenanceRemarks29(getMaintenanceRemarks());
			model.setAvailableVolume29(getMaintenance()!=null && getMaintenance().trim().equals("1") ? Integer.parseInt(getCapacity()) * Integer.parseInt(getMaintenance()) : 0);
			break;
		case "30":
			model.setMaintenance30(getMaintenance().trim().equals("1") ? getMaintenance().trim() : null);
			model.setMaintenanceColor30(!getMaintenanceColor().equals("") ? Integer.parseInt(getMaintenanceColor()): 0);
			model.setMaintenanceCategory30(!getMaintenanceCategory().equals("") ? Integer.parseInt(getMaintenanceCategory()): 0);
			model.setMaintenanceRemarks30(getMaintenanceRemarks());
			model.setAvailableVolume30(getMaintenance()!=null && getMaintenance().trim().equals("1") ? Integer.parseInt(getCapacity()) * Integer.parseInt(getMaintenance()) : 0);
			break;
		case "31":
			model.setMaintenance31(getMaintenance().trim().equals("1") ? getMaintenance().trim() : null);
			model.setMaintenanceColor31(!getMaintenanceColor().equals("") ? Integer.parseInt(getMaintenanceColor()): 0);
			model.setMaintenanceCategory31(!getMaintenanceCategory().equals("") ? Integer.parseInt(getMaintenanceCategory()): 0);
			model.setMaintenanceRemarks31(getMaintenanceRemarks());
			model.setAvailableVolume31(getMaintenance()!=null && getMaintenance().trim().equals("1") ? Integer.parseInt(getCapacity()) * Integer.parseInt(getMaintenance()) : 0);
			break;
		}
		return model;
	}

	
	public void populateDropdownList(HttpServletRequest request) throws Exception{
		populateLorryList(request);
		populateMaintenancePersonnelOptionsDropdownList(request);
		populateGPSPersonnelDropdownList(request);
		populateTripIssueCategoryDropdownList(request);
		populateMaintenanceCategoryDropdownList(request);
	}
	
	public void populateMaintenancePersonnelOptionsDropdownList(HttpServletRequest request) throws Exception{
        @SuppressWarnings("unchecked")
		List<ListValue> lovList = (ArrayList<ListValue>) request.getSession().getAttribute(MiscConstant.LOV_MAINTENANCE_PERSONNEL_SESSION);
    	if (lovList!=null) {
    		setMaintenancePersonnelOptionsLOV(lovList);
    	}
	}

	public void populateGPSPersonnelDropdownList(HttpServletRequest request) throws Exception{
        @SuppressWarnings("unchecked")
		List<ListValue> lovList = (ArrayList<ListValue>) request.getSession().getAttribute(MiscConstant.LOV_GPS_PERSONNEL_SESSION);
    	if (lovList!=null) {
    		setGpsPersonnelOptionsLOV(lovList);
    	}
	}

	public void populateTripIssueCategoryDropdownList(HttpServletRequest request) throws Exception{
        @SuppressWarnings("unchecked")
		List<ListValue> lovList = (ArrayList<ListValue>) request.getSession().getAttribute(MiscConstant.LOV_TRIP_ISSUE_CATEGORY_SESSION);
    	if (lovList!=null) {
    		setGpsTripIssueCategoryLOV(lovList);
    	}
	}

	public void populateMaintenanceCategoryDropdownList(HttpServletRequest request) throws Exception{
        @SuppressWarnings("unchecked")
		List<ListValue> lovList = (ArrayList<ListValue>) request.getSession().getAttribute(MiscConstant.LOV_MAINTENANCE_CATEGORY_SESSION);
    	if (lovList!=null) {
    		setMaintenanceCategoryLOV(lovList);
    	}
	}
	
	public void populateDropdownListFromSession(HttpServletRequest request, boolean isEdit) throws Exception{
    	populateDropdownList(request);
	}	
	
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		ActionErrors errors = new ActionErrors();
		
		String command = (String) request.getParameter("command"); 
		
		if (command!=null && (command.equalsIgnoreCase(ParamConstant.AJAX_SAVE) || command.equalsIgnoreCase(ParamConstant.AJAX_UPDATE))) {
			boolean flag = false;
			boolean isEdit = (command.equalsIgnoreCase(ParamConstant.AJAX_UPDATE)? true: false);

			if (flag) {
				try {
					//get list from session
					populateDropdownListFromSession(request, isEdit);		
							
				} catch(Exception e) {}				
			}

	
		} 
	
		return errors;
	}


	public String getPlateNo() {
		return plateNo;
	}


	public void setPlateNo(String plateNo) {
		this.plateNo = plateNo;
	}


	public String getTrailerNo() {
		return trailerNo;
	}


	public void setTrailerNo(String trailerNo) {
		this.trailerNo = trailerNo;
	}


	public String getLorryNo() {
		return lorryNo;
	}


	public void setLorryNo(String lorryNo) {
		this.lorryNo = lorryNo;
	}


	public String getCapacity() {
		return capacity;
	}


	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}


	public String getGpsColor() {
		return gpsColor;
	}


	public void setGpsColor(String gpsColor) {
		this.gpsColor = gpsColor;
	}


	public String getGpsRemarks() {
		return gpsRemarks;
	}


	public void setGpsRemarks(String gpsRemarks) {
		this.gpsRemarks = gpsRemarks;
	}


	public String getMaintenance() {
		return maintenance;
	}


	public void setMaintenance(String maintenance) {
		this.maintenance = maintenance;
	}


	public String getMaintenanceColor() {
		return maintenanceColor;
	}


	public void setMaintenanceColor(String maintenanceColor) {
		this.maintenanceColor = maintenanceColor;
	}


	public String getMaintenanceRemarks() {
		return maintenanceRemarks;
	}


	public void setMaintenanceRemarks(String maintenanceRemarks) {
		this.maintenanceRemarks = maintenanceRemarks;
	}


	public String getAvailableVolume() {
		return availableVolume;
	}


	public void setAvailableVolume(String availableVolume) {
		this.availableVolume = availableVolume;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public String getMonth() {
		return month;
	}


	public void setMonth(String month) {
		this.month = month;
	}


	public String getDay() {
		return day;
	}


	public void setDay(String day) {
		this.day = day;
	}


	public List<MaintenanceMonitoring> getModelList() {
		return modelList;
	}


	public void setModelList(List<MaintenanceMonitoring> modelList) {
		this.modelList = modelList;
	}


	public List<ListValue> getMaintenancePersonnelOptionsLOV() {
		return maintenancePersonnelOptionsLOV;
	}


	public void setMaintenancePersonnelOptionsLOV(
			List<ListValue> maintenancePersonnelOptionsLOV) {
		this.maintenancePersonnelOptionsLOV = maintenancePersonnelOptionsLOV;
	}


	public String getYearCriteria() {
		return yearCriteria;
	}


	public void setYearCriteria(String yearCriteria) {
		this.yearCriteria = yearCriteria;
	}


	public String getMonthCriteria() {
		return monthCriteria;
	}


	public void setMonthCriteria(String monthCriteria) {
		this.monthCriteria = monthCriteria;
	}


	public String getLorryNoCriteria() {
		return lorryNoCriteria;
	}


	public void setLorryNoCriteria(String lorryNoCriteria) {
		this.lorryNoCriteria = lorryNoCriteria;
	}


	public List<ListValue> getGpsPersonnelOptionsLOV() {
		return gpsPersonnelOptionsLOV;
	}


	public void setGpsPersonnelOptionsLOV(List<ListValue> gpsPersonnelOptionsLOV) {
		this.gpsPersonnelOptionsLOV = gpsPersonnelOptionsLOV;
	}


	public List<Lorry> getLorryList() {
		return lorryList;
	}


	public void setLorryList(List<Lorry> lorryList) {
		this.lorryList = lorryList;
	}

	public void populateLorryList(HttpServletRequest request) throws Exception{        
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
		
        dataMap = null;
        service = null;
        resultMap = null;
        
	}


	public List<MaintenanceMonitoringPreventive> getModelListPreventive() {
		return modelListPreventive;
	}


	public void setModelListPreventive(
			List<MaintenanceMonitoringPreventive> modelListPreventive) {
		this.modelListPreventive = modelListPreventive;
	}


	public List<MaintenanceMonitoringPreventiveTotal> getModelListPreventiveTotal() {
		return modelListPreventiveTotal;
	}


	public void setModelListPreventiveTotal(
			List<MaintenanceMonitoringPreventiveTotal> modelListPreventiveTotal) {
		this.modelListPreventiveTotal = modelListPreventiveTotal;
	}


	public int getIdPreventive() {
		return idPreventive;
	}


	public void setIdPreventive(int idPreventive) {
		this.idPreventive = idPreventive;
	}

	
	public String getPreventive() {
		return preventive;
	}


	public void setPreventive(String preventive) {
		this.preventive = preventive;
	}


	public String getPreventiveRemarks() {
		return preventiveRemarks;
	}


	public void setPreventiveRemarks(String preventiveRemarks) {
		this.preventiveRemarks = preventiveRemarks;
	}

	
	public String getGps() {
		return gps;
	}

	public void setGps(String gps) {
		this.gps = gps;
	}

	public void populateFormBeanPGarage(MaintenanceMonitoringPreventive model) throws Exception {
		setIdPreventive(model.getId());
		switch (getDay()) {
			case "1":
				setPreventive(model.getPgarage1());
				setPreventiveRemarks(model.getPgarageremarks1());
				break;
			case "2":
				setPreventive(model.getPgarage2());
				setPreventiveRemarks(model.getPgarageremarks2());
				break;
			case "3":
				setPreventive(model.getPgarage3());
				setPreventiveRemarks(model.getPgarageremarks3());
				break;
			case "4":
				setPreventive(model.getPgarage4());
				setPreventiveRemarks(model.getPgarageremarks4());
				break;
			case "5":
				setPreventive(model.getPgarage5());
				setPreventiveRemarks(model.getPgarageremarks5());
				break;
			case "6":
				setPreventive(model.getPgarage6());
				setPreventiveRemarks(model.getPgarageremarks6());
				break;
			case "7":
				setPreventive(model.getPgarage7());
				setPreventiveRemarks(model.getPgarageremarks7());
				break;
			case "8":
				setPreventive(model.getPgarage8());
				setPreventiveRemarks(model.getPgarageremarks8());
				break;
			case "9":
				setPreventive(model.getPgarage9());
				setPreventiveRemarks(model.getPgarageremarks9());
				break;
			case "10":
				setPreventive(model.getPgarage10());
				setPreventiveRemarks(model.getPgarageremarks10());
				break;
			case "11":
				setPreventive(model.getPgarage11());
				setPreventiveRemarks(model.getPgarageremarks11());
				break;
			case "12":
				setPreventive(model.getPgarage12());
				setPreventiveRemarks(model.getPgarageremarks12());
				break;
			case "13":
				setPreventive(model.getPgarage13());
				setPreventiveRemarks(model.getPgarageremarks13());
				break;
			case "14":
				setPreventive(model.getPgarage14());
				setPreventiveRemarks(model.getPgarageremarks14());
				break;
			case "15":
				setPreventive(model.getPgarage15());
				setPreventiveRemarks(model.getPgarageremarks15());
				break;
			case "16":
				setPreventive(model.getPgarage16());
				setPreventiveRemarks(model.getPgarageremarks16());
				break;
			case "17":
				setPreventive(model.getPgarage17());
				setPreventiveRemarks(model.getPgarageremarks17());
				break;
			case "18":
				setPreventive(model.getPgarage18());
				setPreventiveRemarks(model.getPgarageremarks18());
				break;
			case "19":
				setPreventive(model.getPgarage19());
				setPreventiveRemarks(model.getPgarageremarks19());
				break;
			case "20":
				setPreventive(model.getPgarage20());
				setPreventiveRemarks(model.getPgarageremarks20());
				break;
			case "21":
				setPreventive(model.getPgarage21());
				setPreventiveRemarks(model.getPgarageremarks21());
				break;
			case "22":
				setPreventive(model.getPgarage22());
				setPreventiveRemarks(model.getPgarageremarks22());
				break;
			case "23":
				setPreventive(model.getPgarage23());
				setPreventiveRemarks(model.getPgarageremarks23());
				break;
			case "24":
				setPreventive(model.getPgarage24());
				setPreventiveRemarks(model.getPgarageremarks24());
				break;
			case "25":
				setPreventive(model.getPgarage25());
				setPreventiveRemarks(model.getPgarageremarks25());
				break;
			case "26":
				setPreventive(model.getPgarage26());
				setPreventiveRemarks(model.getPgarageremarks26());
				break;
			case "27":
				setPreventive(model.getPgarage27());
				setPreventiveRemarks(model.getPgarageremarks27());
				break;
			case "28":
				setPreventive(model.getPgarage28());
				setPreventiveRemarks(model.getPgarageremarks28());
				break;
			case "29":
				setPreventive(model.getPgarage29());
				setPreventiveRemarks(model.getPgarageremarks29());
				break;
			case "30":
				setPreventive(model.getPgarage30());
				setPreventiveRemarks(model.getPgarageremarks30());
				break;
			case "31":
				setPreventive(model.getPgarage31());
				setPreventiveRemarks(model.getPgarageremarks31());
				break;
		}
	}

	public MaintenanceMonitoringPreventive populateModelPGarage() throws Exception {
		MaintenanceMonitoringPreventive model = new MaintenanceMonitoringPreventive();
		model.setId(getIdPreventive());
		model.setDay(Integer.parseInt(getDay()));
		switch (getDay()) {
		case "1":
			model.setPgarage1(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
			model.setPgarageremarks1(getPreventiveRemarks());
			break;
		case "2":
			model.setPgarage2(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
			model.setPgarageremarks2(getPreventiveRemarks());
			break;
		case "3":
			model.setPgarage3(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
			model.setPgarageremarks3(getPreventiveRemarks());
			break;
		case "4":
			model.setPgarage4(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
			model.setPgarageremarks4(getPreventiveRemarks());
			break;
		case "5":
			model.setPgarage5(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
			model.setPgarageremarks5(getPreventiveRemarks());
			break;
		case "6":
			model.setPgarage6(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
			model.setPgarageremarks6(getPreventiveRemarks());
			break;
		case "7":
			model.setPgarage7(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
			model.setPgarageremarks7(getPreventiveRemarks());
			break;
		case "8":
			model.setPgarage8(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
			model.setPgarageremarks8(getPreventiveRemarks());
			break;
		case "9":
			model.setPgarage9(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
			model.setPgarageremarks9(getPreventiveRemarks());
			break;
		case "10":
			model.setPgarage10(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
			model.setPgarageremarks10(getPreventiveRemarks());
			break;
		case "11":
			model.setPgarage11(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
			model.setPgarageremarks11(getPreventiveRemarks());
			break;
		case "12":
			model.setPgarage12(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
			model.setPgarageremarks12(getPreventiveRemarks());
			break;
		case "13":
			model.setPgarage13(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
			model.setPgarageremarks13(getPreventiveRemarks());
			break;
		case "14":
			model.setPgarage14(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
			model.setPgarageremarks14(getPreventiveRemarks());
			break;
		case "15":
			model.setPgarage15(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
			model.setPgarageremarks15(getPreventiveRemarks());
			break;
		case "16":
			model.setPgarage16(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
			model.setPgarageremarks16(getPreventiveRemarks());
			break;
		case "17":
			model.setPgarage17(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
			model.setPgarageremarks17(getPreventiveRemarks());
			break;
		case "18":
			model.setPgarage18(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
			model.setPgarageremarks18(getPreventiveRemarks());
			break;
		case "19":
			model.setPgarage19(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
			model.setPgarageremarks19(getPreventiveRemarks());
			break;
		case "20":
			model.setPgarage20(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
			model.setPgarageremarks20(getPreventiveRemarks());
			break;
		case "21":
			model.setPgarage21(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
			model.setPgarageremarks21(getPreventiveRemarks());
			break;
		case "22":
			model.setPgarage22(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
			model.setPgarageremarks22(getPreventiveRemarks());
			break;
		case "23":
			model.setPgarage23(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
			model.setPgarageremarks23(getPreventiveRemarks());
			break;
		case "24":
			model.setPgarage24(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
			model.setPgarageremarks24(getPreventiveRemarks());
			break;
		case "25":
			model.setPgarage25(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
			model.setPgarageremarks25(getPreventiveRemarks());
			break;
		case "26":
			model.setPgarage26(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
			model.setPgarageremarks26(getPreventiveRemarks());
			break;
		case "27":
			model.setPgarage27(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
			model.setPgarageremarks27(getPreventiveRemarks());
			break;
		case "28":
			model.setPgarage28(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
			model.setPgarageremarks28(getPreventiveRemarks());
			break;
		case "29":
			model.setPgarage29(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
			model.setPgarageremarks29(getPreventiveRemarks());
			break;
		case "30":
			model.setPgarage30(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
			model.setPgarageremarks30(getPreventiveRemarks());
			break;
		case "31":
			model.setPgarage31(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
			model.setPgarageremarks31(getPreventiveRemarks());
			break;
		}
		return model;
	}

	//PFbase
	public void populateFormBeanPFbase(MaintenanceMonitoringPreventive model) throws Exception {
		setIdPreventive(model.getId());
		switch (getDay()) {
			case "1":
				setPreventive(model.getPfbase1());
				setPreventiveRemarks(model.getPfbaseremarks1());
				break;
			case "2":
				setPreventive(model.getPfbase2());
				setPreventiveRemarks(model.getPfbaseremarks2());
				break;
			case "3":
				setPreventive(model.getPfbase3());
				setPreventiveRemarks(model.getPfbaseremarks3());
				break;
			case "4":
				setPreventive(model.getPfbase4());
				setPreventiveRemarks(model.getPfbaseremarks4());
				break;
			case "5":
				setPreventive(model.getPfbase5());
				setPreventiveRemarks(model.getPfbaseremarks5());
				break;
			case "6":
				setPreventive(model.getPfbase6());
				setPreventiveRemarks(model.getPfbaseremarks6());
				break;
			case "7":
				setPreventive(model.getPfbase7());
				setPreventiveRemarks(model.getPfbaseremarks7());
				break;
			case "8":
				setPreventive(model.getPfbase8());
				setPreventiveRemarks(model.getPfbaseremarks8());
				break;
			case "9":
				setPreventive(model.getPfbase9());
				setPreventiveRemarks(model.getPfbaseremarks9());
				break;
			case "10":
				setPreventive(model.getPfbase10());
				setPreventiveRemarks(model.getPfbaseremarks10());
				break;
			case "11":
				setPreventive(model.getPfbase11());
				setPreventiveRemarks(model.getPfbaseremarks11());
				break;
			case "12":
				setPreventive(model.getPfbase12());
				setPreventiveRemarks(model.getPfbaseremarks12());
				break;
			case "13":
				setPreventive(model.getPfbase13());
				setPreventiveRemarks(model.getPfbaseremarks13());
				break;
			case "14":
				setPreventive(model.getPfbase14());
				setPreventiveRemarks(model.getPfbaseremarks14());
				break;
			case "15":
				setPreventive(model.getPfbase15());
				setPreventiveRemarks(model.getPfbaseremarks15());
				break;
			case "16":
				setPreventive(model.getPfbase16());
				setPreventiveRemarks(model.getPfbaseremarks16());
				break;
			case "17":
				setPreventive(model.getPfbase17());
				setPreventiveRemarks(model.getPfbaseremarks17());
				break;
			case "18":
				setPreventive(model.getPfbase18());
				setPreventiveRemarks(model.getPfbaseremarks18());
				break;
			case "19":
				setPreventive(model.getPfbase19());
				setPreventiveRemarks(model.getPfbaseremarks19());
				break;
			case "20":
				setPreventive(model.getPfbase20());
				setPreventiveRemarks(model.getPfbaseremarks20());
				break;
			case "21":
				setPreventive(model.getPfbase21());
				setPreventiveRemarks(model.getPfbaseremarks21());
				break;
			case "22":
				setPreventive(model.getPfbase22());
				setPreventiveRemarks(model.getPfbaseremarks22());
				break;
			case "23":
				setPreventive(model.getPfbase23());
				setPreventiveRemarks(model.getPfbaseremarks23());
				break;
			case "24":
				setPreventive(model.getPfbase24());
				setPreventiveRemarks(model.getPfbaseremarks24());
				break;
			case "25":
				setPreventive(model.getPfbase25());
				setPreventiveRemarks(model.getPfbaseremarks25());
				break;
			case "26":
				setPreventive(model.getPfbase26());
				setPreventiveRemarks(model.getPfbaseremarks26());
				break;
			case "27":
				setPreventive(model.getPfbase27());
				setPreventiveRemarks(model.getPfbaseremarks27());
				break;
			case "28":
				setPreventive(model.getPfbase28());
				setPreventiveRemarks(model.getPfbaseremarks28());
				break;
			case "29":
				setPreventive(model.getPfbase29());
				setPreventiveRemarks(model.getPfbaseremarks29());
				break;
			case "30":
				setPreventive(model.getPfbase30());
				setPreventiveRemarks(model.getPfbaseremarks30());
				break;
			case "31":
				setPreventive(model.getPfbase31());
				setPreventiveRemarks(model.getPfbaseremarks31());
				break;
		}
	}

	public MaintenanceMonitoringPreventive populateModelPFbase() throws Exception {
		MaintenanceMonitoringPreventive model = new MaintenanceMonitoringPreventive();
		model.setId(getIdPreventive());
		model.setDay(Integer.parseInt(getDay()));
		switch (getDay()) {
			case "1":
				model.setPfbase1(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setPfbaseremarks1(getPreventiveRemarks());
				break;
			case "2":
				model.setPfbase2(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setPfbaseremarks3(getPreventiveRemarks());
				break;
			case "3":
				model.setPfbase3(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setPfbaseremarks3(getPreventiveRemarks());
				break;
			case "4":
				model.setPfbase4(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setPfbaseremarks4(getPreventiveRemarks());
				break;
			case "5":
				model.setPfbase5(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setPfbaseremarks5(getPreventiveRemarks());
				break;
			case "6":
				model.setPfbase6(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setPfbaseremarks6(getPreventiveRemarks());
				break;
			case "7":
				model.setPfbase7(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setPfbaseremarks7(getPreventiveRemarks());
				break;
			case "8":
				model.setPfbase8(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setPfbaseremarks8(getPreventiveRemarks());
				break;
			case "9":
				model.setPfbase9(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setPfbaseremarks9(getPreventiveRemarks());
				break;
			case "10":
				model.setPfbase10(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setPfbaseremarks10(getPreventiveRemarks());
				break;
			case "11":
				model.setPfbase11(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setPfbaseremarks11(getPreventiveRemarks());
				break;
			case "12":
				model.setPfbase12(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setPfbaseremarks12(getPreventiveRemarks());
				break;
			case "13":
				model.setPfbase13(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setPfbaseremarks13(getPreventiveRemarks());
				break;
			case "14":
				model.setPfbase14(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setPfbaseremarks14(getPreventiveRemarks());
				break;
			case "15":
				model.setPfbase15(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setPfbaseremarks15(getPreventiveRemarks());
				break;
			case "16":
				model.setPfbase16(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setPfbaseremarks16(getPreventiveRemarks());
				break;
			case "17":
				model.setPfbase17(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setPfbaseremarks17(getPreventiveRemarks());
				break;
			case "18":
				model.setPfbase18(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setPfbaseremarks18(getPreventiveRemarks());
				break;
			case "19":
				model.setPfbase19(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setPfbaseremarks19(getPreventiveRemarks());
				break;
			case "20":
				model.setPfbase20(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setPfbaseremarks20(getPreventiveRemarks());
				break;
			case "21":
				model.setPfbase21(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setPfbaseremarks21(getPreventiveRemarks());
				break;
			case "22":
				model.setPfbase22(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setPfbaseremarks22(getPreventiveRemarks());
				break;
			case "23":
				model.setPfbase23(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setPfbaseremarks23(getPreventiveRemarks());
				break;
			case "24":
				model.setPfbase24(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setPfbaseremarks24(getPreventiveRemarks());
				break;
			case "25":
				model.setPfbase25(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setPfbaseremarks25(getPreventiveRemarks());
				break;
			case "26":
				model.setPfbase26(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setPfbaseremarks26(getPreventiveRemarks());
				break;
			case "27":
				model.setPfbase27(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setPfbaseremarks27(getPreventiveRemarks());
				break;
			case "28":
				model.setPfbase28(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setPfbaseremarks28(getPreventiveRemarks());
				break;
			case "29":
				model.setPfbase29(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setPfbaseremarks29(getPreventiveRemarks());
				break;
			case "30":
				model.setPfbase30(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setPfbaseremarks30(getPreventiveRemarks());
				break;
			case "31":
				model.setPfbase31(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setPfbaseremarks31(getPreventiveRemarks());
				break;
		}
		return model;
	}

	//BGarage
	public void populateFormBeanBGarage(MaintenanceMonitoringPreventive model) throws Exception {
		setIdPreventive(model.getId());
		switch (getDay()) {
			case "1":
				setPreventive(model.getBgarage1());
				setPreventiveRemarks(model.getBgarageremarks1());
				break;
			case "2":
				setPreventive(model.getBgarage2());
				setPreventiveRemarks(model.getBgarageremarks2());
				break;
			case "3":
				setPreventive(model.getBgarage3());
				setPreventiveRemarks(model.getBgarageremarks3());
				break;
			case "4":
				setPreventive(model.getBgarage4());
				setPreventiveRemarks(model.getBgarageremarks4());
				break;
			case "5":
				setPreventive(model.getBgarage5());
				setPreventiveRemarks(model.getBgarageremarks5());
				break;
			case "6":
				setPreventive(model.getBgarage6());
				setPreventiveRemarks(model.getBgarageremarks6());
				break;
			case "7":
				setPreventive(model.getBgarage7());
				setPreventiveRemarks(model.getBgarageremarks7());
				break;
			case "8":
				setPreventive(model.getBgarage8());
				setPreventiveRemarks(model.getBgarageremarks8());
				break;
			case "9":
				setPreventive(model.getBgarage9());
				setPreventiveRemarks(model.getBgarageremarks9());
				break;
			case "10":
				setPreventive(model.getBgarage10());
				setPreventiveRemarks(model.getBgarageremarks10());
				break;
			case "11":
				setPreventive(model.getBgarage11());
				setPreventiveRemarks(model.getBgarageremarks11());
				break;
			case "12":
				setPreventive(model.getBgarage12());
				setPreventiveRemarks(model.getBgarageremarks12());
				break;
			case "13":
				setPreventive(model.getBgarage13());
				setPreventiveRemarks(model.getBgarageremarks13());
				break;
			case "14":
				setPreventive(model.getBgarage14());
				setPreventiveRemarks(model.getBgarageremarks14());
				break;
			case "15":
				setPreventive(model.getBgarage15());
				setPreventiveRemarks(model.getBgarageremarks15());
				break;
			case "16":
				setPreventive(model.getBgarage16());
				setPreventiveRemarks(model.getBgarageremarks16());
				break;
			case "17":
				setPreventive(model.getBgarage17());
				setPreventiveRemarks(model.getBgarageremarks17());
				break;
			case "18":
				setPreventive(model.getBgarage18());
				setPreventiveRemarks(model.getBgarageremarks18());
				break;
			case "19":
				setPreventive(model.getBgarage19());
				setPreventiveRemarks(model.getBgarageremarks19());
				break;
			case "20":
				setPreventive(model.getBgarage20());
				setPreventiveRemarks(model.getBgarageremarks20());
				break;
			case "21":
				setPreventive(model.getBgarage21());
				setPreventiveRemarks(model.getBgarageremarks21());
				break;
			case "22":
				setPreventive(model.getBgarage22());
				setPreventiveRemarks(model.getBgarageremarks22());
				break;
			case "23":
				setPreventive(model.getBgarage23());
				setPreventiveRemarks(model.getBgarageremarks23());
				break;
			case "24":
				setPreventive(model.getBgarage24());
				setPreventiveRemarks(model.getBgarageremarks24());
				break;
			case "25":
				setPreventive(model.getBgarage25());
				setPreventiveRemarks(model.getBgarageremarks25());
				break;
			case "26":
				setPreventive(model.getBgarage26());
				setPreventiveRemarks(model.getBgarageremarks26());
				break;
			case "27":
				setPreventive(model.getBgarage27());
				setPreventiveRemarks(model.getBgarageremarks27());
				break;
			case "28":
				setPreventive(model.getBgarage28());
				setPreventiveRemarks(model.getBgarageremarks28());
				break;
			case "29":
				setPreventive(model.getBgarage29());
				setPreventiveRemarks(model.getBgarageremarks29());
				break;
			case "30":
				setPreventive(model.getBgarage30());
				setPreventiveRemarks(model.getBgarageremarks30());
				break;
			case "31":
				setPreventive(model.getBgarage31());
				setPreventiveRemarks(model.getBgarageremarks31());
				break;
		}
	}

	public MaintenanceMonitoringPreventive populateModelBGarage() throws Exception {
		MaintenanceMonitoringPreventive model = new MaintenanceMonitoringPreventive();
		model.setId(getIdPreventive());
		model.setDay(Integer.parseInt(getDay()));
		switch (getDay()) {
			case "1":
				model.setBgarage1(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBgarageremarks1(getPreventiveRemarks());
				break;
			case "2":
				model.setBgarage2(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBgarageremarks2(getPreventiveRemarks());
				break;
			case "3":
				model.setBgarage3(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBgarageremarks3(getPreventiveRemarks());
				break;
			case "4":
				model.setBgarage4(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBgarageremarks4(getPreventiveRemarks());
				break;
			case "5":
				model.setBgarage5(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBgarageremarks5(getPreventiveRemarks());
				break;
			case "6":
				model.setBgarage6(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBgarageremarks6(getPreventiveRemarks());
				break;
			case "7":
				model.setBgarage7(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBgarageremarks7(getPreventiveRemarks());
				break;
			case "8":
				model.setBgarage8(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBgarageremarks8(getPreventiveRemarks());
				break;
			case "9":
				model.setBgarage9(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBgarageremarks9(getPreventiveRemarks());
				break;
			case "10":
				model.setBgarage10(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBgarageremarks10(getPreventiveRemarks());
				break;
			case "11":
				model.setBgarage11(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBgarageremarks11(getPreventiveRemarks());
				break;
			case "12":
				model.setBgarage12(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBgarageremarks12(getPreventiveRemarks());
				break;
			case "13":
				model.setBgarage13(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBgarageremarks13(getPreventiveRemarks());
				break;
			case "14":
				model.setBgarage14(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBgarageremarks14(getPreventiveRemarks());
				break;
			case "15":
				model.setBgarage15(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBgarageremarks15(getPreventiveRemarks());
				break;
			case "16":
				model.setBgarage16(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBgarageremarks16(getPreventiveRemarks());
				break;
			case "17":
				model.setBgarage17(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBgarageremarks17(getPreventiveRemarks());
				break;
			case "18":
				model.setBgarage18(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBgarageremarks18(getPreventiveRemarks());
				break;
			case "19":
				model.setBgarage19(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBgarageremarks19(getPreventiveRemarks());
				break;
			case "20":
				model.setBgarage20(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBgarageremarks20(getPreventiveRemarks());
				break;
			case "21":
				model.setBgarage21(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBgarageremarks21(getPreventiveRemarks());
				break;
			case "22":
				model.setBgarage22(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBgarageremarks22(getPreventiveRemarks());
				break;
			case "23":
				model.setBgarage23(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBgarageremarks23(getPreventiveRemarks());
				break;
			case "24":
				model.setBgarage24(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBgarageremarks24(getPreventiveRemarks());
				break;
			case "25":
				model.setBgarage25(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBgarageremarks25(getPreventiveRemarks());
				break;
			case "26":
				model.setBgarage26(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBgarageremarks26(getPreventiveRemarks());
				break;
			case "27":
				model.setBgarage27(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBgarageremarks27(getPreventiveRemarks());
				break;
			case "28":
				model.setBgarage28(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBgarageremarks28(getPreventiveRemarks());
				break;
			case "29":
				model.setBgarage29(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBgarageremarks29(getPreventiveRemarks());
				break;
			case "30":
				model.setBgarage30(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBgarageremarks30(getPreventiveRemarks());
				break;
			case "31":
				model.setBgarage31(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBgarageremarks31(getPreventiveRemarks());
				break;
		}
		return model;
	}

	//BFbase
	public void populateFormBeanBFbase(MaintenanceMonitoringPreventive model) throws Exception {
		setIdPreventive(model.getId());
		switch (getDay()) {
			case "1":
				setPreventive(model.getBfbase1());
				setPreventiveRemarks(model.getBfbaseremarks1());
				break;
			case "2":
				setPreventive(model.getBfbase2());
				setPreventiveRemarks(model.getBfbaseremarks2());
				break;
			case "3":
				setPreventive(model.getBfbase3());
				setPreventiveRemarks(model.getBfbaseremarks3());
				break;
			case "4":
				setPreventive(model.getBfbase4());
				setPreventiveRemarks(model.getBfbaseremarks4());
				break;
			case "5":
				setPreventive(model.getBfbase5());
				setPreventiveRemarks(model.getBfbaseremarks5());
				break;
			case "6":
				setPreventive(model.getBfbase6());
				setPreventiveRemarks(model.getBfbaseremarks6());
				break;
			case "7":
				setPreventive(model.getBfbase7());
				setPreventiveRemarks(model.getBfbaseremarks7());
				break;
			case "8":
				setPreventive(model.getBfbase8());
				setPreventiveRemarks(model.getBfbaseremarks8());
				break;
			case "9":
				setPreventive(model.getBfbase9());
				setPreventiveRemarks(model.getBfbaseremarks9());
				break;
			case "10":
				setPreventive(model.getBfbase10());
				setPreventiveRemarks(model.getBfbaseremarks10());
				break;
			case "11":
				setPreventive(model.getBfbase11());
				setPreventiveRemarks(model.getBfbaseremarks11());
				break;
			case "12":
				setPreventive(model.getBfbase12());
				setPreventiveRemarks(model.getBfbaseremarks12());
				break;
			case "13":
				setPreventive(model.getBfbase13());
				setPreventiveRemarks(model.getBfbaseremarks13());
				break;
			case "14":
				setPreventive(model.getBfbase14());
				setPreventiveRemarks(model.getBfbaseremarks14());
				break;
			case "15":
				setPreventive(model.getBfbase15());
				setPreventiveRemarks(model.getBfbaseremarks15());
				break;
			case "16":
				setPreventive(model.getBfbase16());
				setPreventiveRemarks(model.getBfbaseremarks16());
				break;
			case "17":
				setPreventive(model.getBfbase17());
				setPreventiveRemarks(model.getBfbaseremarks17());
				break;
			case "18":
				setPreventive(model.getBfbase18());
				setPreventiveRemarks(model.getBfbaseremarks18());
				break;
			case "19":
				setPreventive(model.getBfbase19());
				setPreventiveRemarks(model.getBfbaseremarks19());
				break;
			case "20":
				setPreventive(model.getBfbase20());
				setPreventiveRemarks(model.getBfbaseremarks20());
				break;
			case "21":
				setPreventive(model.getBfbase21());
				setPreventiveRemarks(model.getBfbaseremarks21());
				break;
			case "22":
				setPreventive(model.getBfbase22());
				setPreventiveRemarks(model.getBfbaseremarks22());
				break;
			case "23":
				setPreventive(model.getBfbase23());
				setPreventiveRemarks(model.getBfbaseremarks23());
				break;
			case "24":
				setPreventive(model.getBfbase24());
				setPreventiveRemarks(model.getBfbaseremarks24());
				break;
			case "25":
				setPreventive(model.getBfbase25());
				setPreventiveRemarks(model.getBfbaseremarks25());
				break;
			case "26":
				setPreventive(model.getBfbase26());
				setPreventiveRemarks(model.getBfbaseremarks26());
				break;
			case "27":
				setPreventive(model.getBfbase27());
				setPreventiveRemarks(model.getBfbaseremarks27());
				break;
			case "28":
				setPreventive(model.getBfbase28());
				setPreventiveRemarks(model.getBfbaseremarks28());
				break;
			case "29":
				setPreventive(model.getBfbase29());
				setPreventiveRemarks(model.getBfbaseremarks29());
				break;
			case "30":
				setPreventive(model.getBfbase30());
				setPreventiveRemarks(model.getBfbaseremarks30());
				break;
			case "31":
				setPreventive(model.getBfbase31());
				setPreventiveRemarks(model.getBfbaseremarks31());
				break;
		}
	}

	public void populateFormBeanTotalPending(MaintenanceMonitoringTotalPending model) throws Exception {
		setIdTotalPending(model.getId());
		switch (getDay()) {
			case "1":
				setRemarks(model.getTotalPendingComment1());
				break;
			case "2":
				setRemarks(model.getTotalPendingComment2());
				break;
			case "3":
				setRemarks(model.getTotalPendingComment3());
				break;
			case "4":
				setRemarks(model.getTotalPendingComment4());
				break;
			case "5":
				setRemarks(model.getTotalPendingComment5());
				break;
			case "6":
				setRemarks(model.getTotalPendingComment6());
				break;
			case "7":
				setRemarks(model.getTotalPendingComment7());
				break;
			case "8":
				setRemarks(model.getTotalPendingComment8());
				break;
			case "9":
				setRemarks(model.getTotalPendingComment9());
				break;
			case "10":
				setRemarks(model.getTotalPendingComment10());
				break;
			case "11":
				setRemarks(model.getTotalPendingComment11());
				break;
			case "12":
				setRemarks(model.getTotalPendingComment12());
				break;
			case "13":
				setRemarks(model.getTotalPendingComment13());
				break;
			case "14":
				setRemarks(model.getTotalPendingComment14());
				break;
			case "15":
				setRemarks(model.getTotalPendingComment15());
				break;
			case "16":
				setRemarks(model.getTotalPendingComment16());
				break;
			case "17":
				setRemarks(model.getTotalPendingComment17());
				break;
			case "18":
				setRemarks(model.getTotalPendingComment18());
				break;
			case "19":
				setRemarks(model.getTotalPendingComment19());
				break;
			case "20":
				setRemarks(model.getTotalPendingComment20());
				break;
			case "21":
				setRemarks(model.getTotalPendingComment21());
				break;
			case "22":
				setRemarks(model.getTotalPendingComment22());
				break;
			case "23":
				setRemarks(model.getTotalPendingComment23());
				break;
			case "24":
				setRemarks(model.getTotalPendingComment24());
				break;
			case "25":
				setRemarks(model.getTotalPendingComment25());
				break;
			case "26":
				setRemarks(model.getTotalPendingComment26());
				break;
			case "27":
				setRemarks(model.getTotalPendingComment27());
				break;
			case "28":
				setRemarks(model.getTotalPendingComment28());
				break;
			case "29":
				setRemarks(model.getTotalPendingComment29());
				break;
			case "30":
				setRemarks(model.getTotalPendingComment30());
				break;
			case "31":
				setRemarks(model.getTotalPendingComment31());
				break;
		}
	}
	
	public MaintenanceMonitoringPreventive populateModelBFbase() throws Exception {
		MaintenanceMonitoringPreventive model = new MaintenanceMonitoringPreventive();
		model.setId(getIdPreventive());
		model.setDay(Integer.parseInt(getDay()));
		switch (getDay()) {
			case "1":
				model.setBfbase1(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBfbaseremarks1(getPreventiveRemarks());
				break;
			case "2":
				model.setBfbase2(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBfbaseremarks2(getPreventiveRemarks());
				break;
			case "3":
				model.setBfbase3(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBfbaseremarks3(getPreventiveRemarks());
				break;
			case "4":
				model.setBfbase4(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBfbaseremarks4(getPreventiveRemarks());
				break;
			case "5":
				model.setBfbase5(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBfbaseremarks5(getPreventiveRemarks());
				break;
			case "6":
				model.setBfbase6(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBfbaseremarks6(getPreventiveRemarks());
				break;
			case "7":
				model.setBfbase7(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBfbaseremarks7(getPreventiveRemarks());
				break;
			case "8":
				model.setBfbase8(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBfbaseremarks8(getPreventiveRemarks());
				break;
			case "9":
				model.setBfbase9(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBfbaseremarks9(getPreventiveRemarks());
				break;
			case "10":
				model.setBfbase10(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBfbaseremarks10(getPreventiveRemarks());
				break;
			case "11":
				model.setBfbase11(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBfbaseremarks11(getPreventiveRemarks());
				break;
			case "12":
				model.setBfbase12(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBfbaseremarks12(getPreventiveRemarks());
				break;
			case "13":
				model.setBfbase13(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBfbaseremarks13(getPreventiveRemarks());
				break;
			case "14":
				model.setBfbase14(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBfbaseremarks14(getPreventiveRemarks());
				break;
			case "15":
				model.setBfbase15(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBfbaseremarks15(getPreventiveRemarks());
				break;
			case "16":
				model.setBfbase16(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBfbaseremarks16(getPreventiveRemarks());
				break;
			case "17":
				model.setBfbase17(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBfbaseremarks17(getPreventiveRemarks());
				break;
			case "18":
				model.setBfbase18(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBfbaseremarks18(getPreventiveRemarks());
				break;
			case "19":
				model.setBfbase19(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBfbaseremarks19(getPreventiveRemarks());
				break;
			case "20":
				model.setBfbase20(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBfbaseremarks20(getPreventiveRemarks());
				break;
			case "21":
				model.setBfbase21(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBfbaseremarks21(getPreventiveRemarks());
				break;
			case "22":
				model.setBfbase22(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBfbaseremarks22(getPreventiveRemarks());
				break;
			case "23":
				model.setBfbase23(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBfbaseremarks23(getPreventiveRemarks());
				break;
			case "24":
				model.setBfbase24(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBfbaseremarks24(getPreventiveRemarks());
				break;
			case "25":
				model.setBfbase25(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBfbaseremarks25(getPreventiveRemarks());
				break;
			case "26":
				model.setBfbase26(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBfbaseremarks26(getPreventiveRemarks());
				break;
			case "27":
				model.setBfbase27(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBfbaseremarks27(getPreventiveRemarks());
				break;
			case "28":
				model.setBfbase28(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBfbaseremarks28(getPreventiveRemarks());
				break;
			case "29":
				model.setBfbase29(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBfbaseremarks29(getPreventiveRemarks());
				break;
			case "30":
				model.setBfbase30(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBfbaseremarks30(getPreventiveRemarks());
				break;
			case "31":
				model.setBfbase31(getPreventive()!=null && getPreventive().trim().length()>0 ? getPreventive() : null);
				model.setBfbaseremarks31(getPreventiveRemarks());
				break;
		}
		return model;
	}

	public MaintenanceMonitoringTotalPending populateModelTotalPending() throws Exception {
		MaintenanceMonitoringTotalPending model = new MaintenanceMonitoringTotalPending();
		model.setId(getIdTotalPending());
		model.setDay(Integer.parseInt(getDay()));
		switch (getDay()) {
			case "1":
				model.setTotalPendingComment1(getRemarks());
				break;
			case "2":
				model.setTotalPendingComment2(getRemarks());
				break;
			case "3":
				model.setTotalPendingComment3(getRemarks());
				break;
			case "4":
				model.setTotalPendingComment4(getRemarks());
				break;
			case "5":
				model.setTotalPendingComment5(getRemarks());
				break;
			case "6":
				model.setTotalPendingComment6(getRemarks());
				break;
			case "7":
				model.setTotalPendingComment7(getRemarks());
				break;
			case "8":
				model.setTotalPendingComment8(getRemarks());
				break;
			case "9":
				model.setTotalPendingComment9(getRemarks());
				break;
			case "10":
				model.setTotalPendingComment10(getRemarks());
				break;
			case "11":
				model.setTotalPendingComment11(getRemarks());
				break;
			case "12":
				model.setTotalPendingComment12(getRemarks());
				break;
			case "13":
				model.setTotalPendingComment13(getRemarks());
				break;
			case "14":
				model.setTotalPendingComment14(getRemarks());
				break;
			case "15":

				model.setTotalPendingComment15(getRemarks());
				break;
			case "16":
				model.setTotalPendingComment16(getRemarks());
				break;
			case "17":
				model.setTotalPendingComment17(getRemarks());
				break;
			case "18":
				model.setTotalPendingComment18(getRemarks());
				break;
			case "19":
				model.setTotalPendingComment19(getRemarks());
				break;
			case "20":
				model.setTotalPendingComment20(getRemarks());
				break;
			case "21":
				model.setTotalPendingComment21(getRemarks());
				break;
			case "22":
				model.setTotalPendingComment22(getRemarks());
				break;
			case "23":
				model.setTotalPendingComment23(getRemarks());
				break;
			case "24":
				model.setTotalPendingComment24(getRemarks());
				break;
			case "25":
				model.setTotalPendingComment25(getRemarks());
				break;
			case "26":
				model.setTotalPendingComment26(getRemarks());
				break;
			case "27":
				model.setTotalPendingComment27(getRemarks());
				break;
			case "28":
				model.setTotalPendingComment28(getRemarks());
				break;
			case "29":
				model.setTotalPendingComment29(getRemarks());
				break;
			case "30":
				model.setTotalPendingComment30(getRemarks());
				break;
			case "31":
				model.setTotalPendingComment31(getRemarks());
				break;
		}
		return model;
	}

	public List<MaintenanceMonitoringTotalPending> getModelListTotalPending() {
		return modelListTotalPending;
	}


	public void setModelListTotalPending(
			List<MaintenanceMonitoringTotalPending> modelListTotalPending) {
		this.modelListTotalPending = modelListTotalPending;
	}


	public int getIdTotalPending() {
		return idTotalPending;
	}


	public void setIdTotalPending(int idTotalPending) {
		this.idTotalPending = idTotalPending;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	public String getGpsTripIssue() {
		return gpsTripIssue;
	}


	public void setGpsTripIssue(String gpsTripIssue) {
		this.gpsTripIssue = gpsTripIssue;
	}


	public List<ListValue> getGpsTripIssueCategoryLOV() {
		return gpsTripIssueCategoryLOV;
	}


	public void setGpsTripIssueCategoryLOV(List<ListValue> gpsTripIssueCategoryLOV) {
		this.gpsTripIssueCategoryLOV = gpsTripIssueCategoryLOV;
	}


	public String getIsEditStatusLocked() {
		return isEditStatusLocked;
	}


	public void setIsEditStatusLocked(String isEditStatusLocked) {
		this.isEditStatusLocked = isEditStatusLocked;
	}


	public String getMonthStr() {
		return monthStr;
	}


	public void setMonthStr(String monthStr) {
		this.monthStr = monthStr;
	}


	public List<ListValue> getMaintenanceCategoryLOV() {
		return maintenanceCategoryLOV;
	}


	public void setMaintenanceCategoryLOV(List<ListValue> maintenanceCategoryLOV) {
		this.maintenanceCategoryLOV = maintenanceCategoryLOV;
	}


	public String getMaintenanceCategory() {
		return maintenanceCategory;
	}


	public void setMaintenanceCategory(String maintenanceCategory) {
		this.maintenanceCategory = maintenanceCategory;
	}


	public int getReportType() {
		return reportType;
	}


	public void setReportType(int reportType) {
		this.reportType = reportType;
	}



	
}
