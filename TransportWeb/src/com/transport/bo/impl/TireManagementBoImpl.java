package com.transport.bo.impl;

import java.util.HashMap;
import java.util.Map;

import com.transport.bo.TireManagementBo;
import com.transport.constant.MapConstant;
import com.transport.constant.MiscConstant;
import com.transport.constant.ParamConstant;
import com.transport.dao.TireDao;
import com.transport.dao.TireManagementDao;
import com.transport.model.Tire;
import com.transport.model.TireDetails;
import com.transport.model.User;

/**
 * 
 * @author edwarddavid
 * @since 12Apr2020
 * DateUpdated: 26Apr2020
 */
public class TireManagementBoImpl implements TireManagementBo {

	private TireManagementDao dao;
	private TireDao tireDao;
	
	public TireManagementDao getTireManagementDao() {
		return dao;
	}

	public void setTireManagementDao(TireManagementDao dao) {
		this.dao = dao;
	}
	
	public TireDao getTireDao() {
		return tireDao;
	}

	public void setTireDao(TireDao tireDao) {
		this.tireDao = tireDao;
	}

	@Override
	public Map<String, Object> assignTire(HashMap<String, Object> dataMap) throws Exception {
	
		TireDetails model = (TireDetails) dataMap.get(MapConstant.CLASS_DATA);
		HashMap<String, Object> criteriaMap = new HashMap<>();
		criteriaMap.put(MapConstant.SEARCH_CRITERIA, model.getSerialNo());
		
		int totalOdometer = 0;
		int previousOdometer = 0;
		Map<String, Object> resultMap = dao.searchLatestRecordBySerialNo(criteriaMap);
		if (resultMap!=null && resultMap.get(MapConstant.CLASS_DATA)!=null) {
			TireDetails resultModel = (TireDetails) resultMap.get(MapConstant.CLASS_DATA);
			previousOdometer = resultModel.getOdometerFitted();
		} else {
			previousOdometer = 0;
		}
		totalOdometer = model.getOdometerFitted() - previousOdometer;
		model.setDistanceTraveled(totalOdometer);//no need to put it inside the map again
		model.setActive(true);
		resultMap.clear();

		String command = (String)dataMap.get(MapConstant.SUB_ACTION);
		if (command.equalsIgnoreCase(ParamConstant.AJAX_SAVE_INNER)) {
			//update Active = false the previous record
			Map<String, Object> resultMapInner = dao.updateTireDetailsRemove(dataMap);
			boolean tranctionStatusInner = (boolean) resultMapInner.get(MapConstant.TRANSACTION_STATUS);
			if (tranctionStatusInner) {
				resultMap = dao.saveTireDetails(dataMap);
			} else {
				resultMap.put(MapConstant.TRANSACTION_STATUS, false);
			}
		} else {
			resultMap = dao.saveTireDetails(dataMap);
			boolean tranctionStatus = (boolean) resultMap.get(MapConstant.TRANSACTION_STATUS);
			if (tranctionStatus) {
				//update the lorryno in tire master file
				Tire tire = new Tire();
				tire.setSerialNo(model.getSerialNo());
				tire.setLorryNo(model.getLorryNo());
					
				User user = (User) dataMap.get(MiscConstant.USER_SESSION);
					
				HashMap<String, Object> dataMapInner = new HashMap<>();
				dataMapInner.put(MapConstant.CLASS_DATA, tire);
				dataMapInner.put(MiscConstant.USER_SESSION, user);
					
				if(!tireDao.updateLorryNoBySerialNo(dataMapInner)) {
					resultMap.put(MapConstant.TRANSACTION_STATUS, false);
				}		
				
			}
		}

		return resultMap;
	}
	
	
	@Override
	public Map<String, Object> getTireDetailsByLorryNo(HashMap<String, Object> dataMap) throws Exception {
		return dao.searchTireDetailsByLorryNo(dataMap);
	}

	@Override
	public Map<String, Object> getTireDetailsBySerialNo(HashMap<String, Object> dataMap) throws Exception {
		return dao.searchLatestRecordBySerialNo(dataMap);
	}

	@Override
	public Map<String, Object> removeTire(HashMap<String, Object> dataMap) throws Exception {
	
		TireDetails model = (TireDetails) dataMap.get(MapConstant.CLASS_DATA);
		HashMap<String, Object> criteriaMap = new HashMap<>();
		criteriaMap.put(MapConstant.SEARCH_CRITERIA, model.getSerialNo());
		
		int totalOdometer = 0;
		int previousOdometer = 0;
		Map<String, Object> resultMap = dao.searchLatestRecordBySerialNo(criteriaMap);
		if (resultMap!=null && resultMap.get(MapConstant.CLASS_DATA)!=null) {
			TireDetails resultModel = (TireDetails) resultMap.get(MapConstant.CLASS_DATA);
			previousOdometer = resultModel.getOdometerFitted();
		} else {
			previousOdometer = 0;
		}
		totalOdometer = model.getOdometerRemoved() - previousOdometer;
		model.setDistanceTraveled(totalOdometer);//no need to put it inside the map again
		model.setActive(false);
		resultMap.clear();
		resultMap = dao.saveTireDetails(dataMap);
		boolean tranctionStatus = (boolean) resultMap.get(MapConstant.TRANSACTION_STATUS);
		if (tranctionStatus) {
			//update the previous record to Active = false
			Map<String, Object> resultMapInner = dao.updateTireDetailsRemove(dataMap);
			boolean tranctionStatusInner = (boolean) resultMapInner.get(MapConstant.TRANSACTION_STATUS);
			if (tranctionStatusInner) {
				//remove the lorryno in tire master file
				Tire tire = new Tire();
				tire.setSerialNo(model.getSerialNo());
				tire.setLorryNo("");
				
				User user = (User) dataMap.get(MiscConstant.USER_SESSION);
				
				HashMap<String, Object> dataMapInner = new HashMap<>();
				dataMapInner.put(MapConstant.CLASS_DATA, tire);
				dataMapInner.put(MiscConstant.USER_SESSION, user);
				
				if(tireDao.updateLorryNoBySerialNo(dataMapInner)) {
					if (model.getRetired().trim().toUpperCase().equals("YES")) {
						tire.setRetired(model.getRetired());
						if(!tireDao.updateRetiredBySerialNo(dataMapInner)) {
							resultMap.put(MapConstant.TRANSACTION_STATUS, false);
						}
					}
				} else {
					resultMap.put(MapConstant.TRANSACTION_STATUS, false);
				}
			} else {
				resultMap.put(MapConstant.TRANSACTION_STATUS, false);
			}
		}
		
		return resultMap;
	}

	@Override
	public Map<String, Object> getLatestOdometerBySerialNo(HashMap<String, Object> dataMap) throws Exception {
		return dao.getLatestOdometerBySerialNo(dataMap);
	}

	@Override
	public Map<String, Object> getDataById(HashMap<String, Object> dataMap) throws Exception {
		return dao.getDataById(dataMap);
	}

	@Override
	public Map<String, Object> editTire(HashMap<String, Object> dataMap) throws Exception {
		return dao.updateTireDetails(dataMap);
	}

	@Override
	public Map<String, Object> getLorryHistory(HashMap<String, Object> dataMap) throws Exception {
		return dao.getLorryHistory(dataMap);
	}



}
