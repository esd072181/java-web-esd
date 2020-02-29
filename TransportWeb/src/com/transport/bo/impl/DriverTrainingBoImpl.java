package com.transport.bo.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import com.transport.bo.DriverTrainingBo;
import com.transport.constant.MapConstant;
import com.transport.dao.DriverTrainingDao;
import com.transport.model.DriverTraining;
import com.transport.util.DateUtils;
import com.transport.util.ReportUtils;

public class DriverTrainingBoImpl implements DriverTrainingBo {

	private DriverTrainingDao dao;
	
	public DriverTrainingDao getDriverTrainingDao() {
		return dao;
	}

	public void setDriverTrainingDao(DriverTrainingDao dao) {
		this.dao = dao;
	}

	@Override
	//@transactional --> for SpringJDBCTemplate
	public Map<String, Object> addNewRecord(HashMap<String, Object> dataMap) throws Exception{
		// TODO Auto-generated method stub
		return dao.save(dataMap);
	}

	@Override
	public Map<String, Object> updateRecord(HashMap<String, Object> dataMap) throws Exception{
		// TODO Auto-generated method stub
		return dao.update(dataMap);
	}

	@Override
	public Map<String, Object> deleteRecord(HashMap<String, Object> dataMap) throws Exception {
		// TODO Auto-generated method stub
		return dao.delete(dataMap);
	}

	@Override
	public Map<String, Object> getRecords(HashMap<String, Object> criteriaMap) throws Exception{
		// TODO Auto-generated method stub
		return dao.search(criteriaMap);
	}

	@Override
	public Map<String, Object> getDataById(HashMap<String, Object> criteriaMap)
			throws Exception {
		// TODO Auto-generated method stub
		return dao.getDataById(criteriaMap);
	}
	
	@Override
	public Map<String, Object> getActiveData()
			throws Exception {
		// TODO Auto-generated method stub
		return dao.getActiveData();
	}	
	@Override
	public Map<String, Object> getInActiveData(HashMap<String, Object> criteriaMap)
			throws Exception {
		// TODO Auto-generated method stub
		return dao.getInActiveData(criteriaMap);
	}	
	@Override
	public Map<String, Object> restoreRecord(HashMap<String, Object> dataMap) throws Exception {
		// TODO Auto-generated method stub
		return dao.restore(dataMap);
	}

	@Override
	public Map<String, Object> getDataByDriverId(HashMap<String, Object> criteriaMap) throws Exception {
		// TODO Auto-generated method stub
		return dao.getDataByDriverId(criteriaMap);
	}

	@Override
	public Map<String, Object> generateReport(HashMap<String, Object> criteriaMap) throws Exception {
		
		DriverTraining model = (DriverTraining) criteriaMap.get(MapConstant.CLASS_DATA);
		
		@SuppressWarnings("unchecked")
		List<Object> trainingList = (ArrayList<Object>)criteriaMap.get(MapConstant.CLASS_LIST);
		@SuppressWarnings("unchecked")
		List<Object> profileList = (ArrayList<Object>)criteriaMap.get(MapConstant.CLASS_LIST_2);
		@SuppressWarnings("unchecked")
		Map<String, Object> parameters = (HashMap<String, Object>)criteriaMap.get(MapConstant.REPORT_PARAM_MAP);
		String localPath = (String)criteriaMap.get(MapConstant.REPORT_LOCALPATH);
		
		//header info
		parameters.put("DateHired", model.getDateHired()!=null ? DateUtils.sqlDateToString(model.getDateHired()) : "");
		parameters.put("LicenseNo", model.getLicenseNo());
		parameters.put("LicenseValidity", model.getLicenseValidity()!=null ? DateUtils.sqlDateToString(model.getLicenseValidity()) : "");
		parameters.put("Birthday", model.getBirthday()!=null ? DateUtils.sqlDateToString(model.getBirthday()): "");
		parameters.put("ContactNo", model.getContactNo());
		parameters.put("Religion", model.getReligion());
		parameters.put("Gender", model.getGender());
		parameters.put("CivilStatus", model.getCivilStatus());
		parameters.put("SSSNo", model.getSss());
		parameters.put("Age", String.valueOf(model.getAge()));
		parameters.put("Spouse", model.getSpouse());
		parameters.put("PhilhealthNo", model.getPhilhealthNo());
		parameters.put("Height", model.getHeight());
		parameters.put("MothersName", model.getMothersName());
		parameters.put("PagibigNo", model.getPagibig());
		parameters.put("Weight", model.getWeight());
		parameters.put("FathersName", model.getFathersName());
		parameters.put("TIN", model.getTin());
		parameters.put("Address", model.getAddress());
		parameters.put("Elementary", model.getElementary());
		parameters.put("ElementaryDate", model.getElementaryDate());
		parameters.put("Secondary", model.getSecondary());
		parameters.put("SecondaryDate", model.getSecondaryDate());
		parameters.put("Tertiary", model.getTertiary());
		parameters.put("TertiaryDate", model.getTertiaryDate());
		parameters.put("EmploymentDateFrom1", model.getEmploymentDateFrom1());
		parameters.put("EmploymentDateTo1", model.getEmploymentDateTo1());
		parameters.put("EmploymentPosition1", model.getEmploymentPosition1());
		parameters.put("EmploymentCompany1", model.getEmploymentCompany1());
		parameters.put("EmploymentDateFrom2", model.getEmploymentDateFrom2());
		parameters.put("EmploymentDateTo2", model.getEmploymentDateTo2());
		parameters.put("EmploymentPosition2", model.getEmploymentPosition2());
		parameters.put("EmploymentCompany2", model.getEmploymentCompany2());
		parameters.put("EmploymentDateFrom3", model.getEmploymentDateFrom3());
		parameters.put("EmploymentDateTo3", model.getEmploymentDateTo3());
		parameters.put("EmploymentPosition3", model.getEmploymentPosition3());
		parameters.put("EmploymentCompany3", model.getEmploymentCompany3());
		parameters.put("FTW", model.getFtw()!=null ? DateUtils.sqlDateToString(model.getFtw()) : "");
		parameters.put("NBI", model.getNbi()!=null ? DateUtils.sqlDateToString(model.getNbi()) : "");
		parameters.put("Terminal", model.getTerminalName());
		parameters.put("Articulated", model.getArticulated());

		parameters.put("Image", model.getPicStr());//Driver Picture
		parameters.put("ImageLogo", criteriaMap.get(MapConstant.RPT_LOGO)); //GDC Logo
		
		//dataset for Driver Training and Profile
		JRBeanCollectionDataSource dsTrainingList = new JRBeanCollectionDataSource(trainingList);
		parameters.put("trainingList", dsTrainingList);
		JRBeanCollectionDataSource dsProfileList = new JRBeanCollectionDataSource(profileList);
		parameters.put("profileList", dsProfileList);
		
		//if profileList is not passed below, the report will not show the driver profile if training is empty, not yet sure why.....
		//maybe because the list in the report detail section datasource is parameter profileList...
		boolean isReportGenerated = ReportUtils.generateReport(profileList, criteriaMap, parameters, localPath);
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put(MapConstant.BOOLEAN_DATA, isReportGenerated);
		
		return returnMap;
	}


}
