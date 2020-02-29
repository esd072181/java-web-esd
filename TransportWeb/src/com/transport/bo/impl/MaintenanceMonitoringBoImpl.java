package com.transport.bo.impl;

import java.util.HashMap;
import java.util.Map;

import com.transport.bo.MaintenanceMonitoringBo;
import com.transport.constant.ActionConstant;
import com.transport.constant.MapConstant;
import com.transport.constant.ModuleConstant;
import com.transport.dao.MaintenanceMonitoringDao;
import com.transport.model.Lorry;
import com.transport.model.MaintenanceMonitoring;
import com.transport.service.ServiceManager;
import com.transport.service.ServiceManagerImpl;
import com.transport.util.ReportUtils;

/**
 * 
 * @author dward
 * @since 25Mar2019
 * Date Updated: 11May2019
 */
public class MaintenanceMonitoringBoImpl implements MaintenanceMonitoringBo {

	private MaintenanceMonitoringDao dao;
	
	public MaintenanceMonitoringDao getMaintenanceMonitoringDao() {
		return dao;
	}

	public void setMaintenanceMonitoringDao(MaintenanceMonitoringDao dao) {
		this.dao = dao;
	}

	@Override
	public Map<String, Object> add(HashMap<String, Object> dataMap) throws Exception{
		// TODO Auto-generated method stub
		
		MaintenanceMonitoring model = (MaintenanceMonitoring) dataMap.get(MapConstant.CLASS_DATA);
		
		//Get the lorry details here
        HashMap<String,Object> criteriaMap = new HashMap<String, Object>();
        criteriaMap.put("plateNo", model.getPlateNo());
        criteriaMap.put("lorryNo", model.getLorryNo());
        criteriaMap.put(MapConstant.MODULE, ModuleConstant.LORRY);
        criteriaMap.put(MapConstant.ACTION, ActionConstant.GET_DATA_BY_CRITERIA);
		ServiceManager service = new ServiceManagerImpl();
		Map<String, Object> resultMap = service.executeRequest(criteriaMap);
        
		Lorry lorry = null;
        if (resultMap!=null && !resultMap.isEmpty()) {
        	lorry = (Lorry) resultMap.get(MapConstant.CLASS_DATA);		        		
        }
        criteriaMap = null;
        service = null;
        resultMap = null;
		
        model.setTrailerNo(lorry.getTrailerNo());
        model.setCapacity(lorry.getCapacity());
        model.setCategory(lorry.getCategory());
        model.setTransportId(lorry.getTransportId());
        
		return dao.save(dataMap);
	}

	@Override
	public Map<String, Object> update(HashMap<String, Object> dataMap) throws Exception{
		// TODO Auto-generated method stub
		return dao.update(dataMap);
	}

	@Override
	public Map<String, Object> delete(HashMap<String, Object> dataMap) throws Exception {
		// TODO Auto-generated method stub
		return dao.delete(dataMap);
	}

	@Override
	public Map<String, Object> getActiveData(HashMap<String, Object> criteriaMap) throws Exception{
		// TODO Auto-generated method stub
		return dao.getActiveData(criteriaMap);
	}

	@Override
	public Map<String, Object> getDataById(HashMap<String, Object> criteriaMap)
			throws Exception {
		// TODO Auto-generated method stub
		return dao.getDataById(criteriaMap);
	}

	@Override
	public Map<String, Object> generateExcelFile(HashMap<String, Object> criteriaMap) throws Exception {
		
		@SuppressWarnings("unchecked")
		HashMap<String, Object> dataMap = (HashMap<String, Object>)criteriaMap.get(MapConstant.REPORT_DATA_MAP);
		String localPath = (String)criteriaMap.get(MapConstant.REPORT_LOCALPATH);
		
		boolean isReportGenerated = ReportUtils.generateMaintenanceMonitoringExcelFile(dataMap, localPath);
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put(MapConstant.BOOLEAN_DATA, isReportGenerated);
		
		return returnMap;
		
	}

	

}
