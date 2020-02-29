package com.transport.bo.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.transport.bo.DriverIncidentBo;
import com.transport.constant.MapConstant;
import com.transport.dao.DriverIncidentDao;
import com.transport.model.DriverIncident;
import com.transport.util.DateUtils;
import com.transport.util.ReportUtils;

public class DriverIncidentBoImpl implements DriverIncidentBo {

	private DriverIncidentDao dao;
	
	public DriverIncidentDao getDriverIncidentDao() {
		return dao;
	}

	public void setDriverIncidentDao(DriverIncidentDao dao) {
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
	public Map<String, Object> generateReport(HashMap<String, Object> criteriaMap) throws Exception {

		DriverIncident model = (DriverIncident) criteriaMap.get(MapConstant.CLASS_DATA);
		
		String localPath = (String)criteriaMap.get(MapConstant.REPORT_LOCALPATH);
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		//info
		parameters.put("AcknowStat", model.getAcknowStat());
		parameters.put("AcknowRemarks", model.getAcknowRemarks());
		parameters.put("ReportStat", model.getReportStat());
		parameters.put("ReportRemarks", model.getReportRemarks());
		parameters.put("CompanyStat", model.getCompanyStat());
		parameters.put("CompanyRemarks", model.getCompanyRemarks());
		parameters.put("IncabStat", model.getIncabStat());
		parameters.put("IncabRemarks", model.getIncabRemarks());
		parameters.put("DwhStat", model.getDwhStat());
		parameters.put("DwhRemarks", model.getDwhRemarks());
		parameters.put("GpsStat", model.getGpsStat());
		parameters.put("GpsRemarks", model.getGpsRemarks());
		parameters.put("EbStat", model.getEbStat());
		parameters.put("EbRemarks", model.getEbRemarks());
		parameters.put("AlcoholStat", model.getAlcoholStat());
		parameters.put("AlcoholRemarks", model.getAlcoholRemarks());
		parameters.put("DriversStat", model.getDriversStat());
		parameters.put("DriversRemarks", model.getDriversRemarks());
		parameters.put("PoliceStat", model.getPoliceStat());
		parameters.put("PoliceRemarks", model.getPoliceRemarks());
		parameters.put("PhotoStat", model.getPhotoStat());
		parameters.put("PhotoRemarks", model.getPhotoRemarks());
		parameters.put("PicDamageStat", model.getPicDamageStat());
		parameters.put("PicDamageRemarks", model.getPicDamageRemarks());
		parameters.put("PicPlateStat", model.getPicPlateStat());
		parameters.put("PicPlateRemarks", model.getPicPlateRemarks());
		parameters.put("StartStat", model.getStartStat());
		parameters.put("StartRemarks", model.getStartRemarks());
		parameters.put("WithInvestStat", model.getWithInvestStat());
		parameters.put("WithInvestRemarks", model.getWithInvestRemarks());
		parameters.put("PriorStat", model.getPriorStat());
		parameters.put("PriorRemarks", model.getPriorRemarks());
		parameters.put("NameOne", model.getNameOne());
		parameters.put("PositionOne", model.getPositionOne());
		parameters.put("NameTwo", model.getNameTwo());
		parameters.put("PositionTwo", model.getPositionTwo());
		parameters.put("IncidentDate", DateUtils.sqlDateToString(model.getIncidentDate()));

		//list is compulsary for the bean data source of the report
		List<Object> list = new ArrayList<>();
		list.add(model);
		
		//if profileList is not passed below, the report will not show the driver profile if training is empty, not yet sure why.....
		//maybe because the list in the report detail section datasource is parameter profileList...
		boolean isReportGenerated = ReportUtils.generateReport(list, criteriaMap, parameters, localPath);
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put(MapConstant.BOOLEAN_DATA, isReportGenerated);
		
		return returnMap;
	}


}
