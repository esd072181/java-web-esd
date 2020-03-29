package com.transport.bo.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.transport.bo.MaintenaceInspectionHeaderBo;
import com.transport.constant.MapConstant;
import com.transport.dao.MaintenanceInspectionDetailsDao;
import com.transport.dao.MaintenanceInspectionHeaderDao;
import com.transport.model.InspectionDetails;
import com.transport.model.InspectionDetailsReport;
import com.transport.model.InspectionHeader;
import com.transport.util.DateUtils;
import com.transport.util.ReportUtils;

/**
 * 
 * @author edwarddavid
 * @since 23Mar2020
 * DateUpdated: 28Mar2020
 */
public class MaintenanceInspectionHeaderBoImpl implements MaintenaceInspectionHeaderBo {

	private  MaintenanceInspectionHeaderDao dao;
	private  MaintenanceInspectionDetailsDao detailsDao;
	
	public MaintenanceInspectionHeaderDao getMaintenanceInspectionHeaderDao() {
		return dao;
	}

	public void setMaintenanceInspectionHeaderDao(MaintenanceInspectionHeaderDao dao) {
		this.dao = dao;
	}
	
	public MaintenanceInspectionDetailsDao getMaintenanceInspectionDetailsDao() {
		return detailsDao;
	}

	public void setMaintenanceInspectionDetailsDao(MaintenanceInspectionDetailsDao detailsDao) {
		this.detailsDao = detailsDao;
	}

	@Override
	public Map<String, Object> addNewRecord(HashMap<String, Object> dataMap) throws Exception{
		Map<String, Object> returnMap = dao.save(dataMap);//Header
		boolean tranctionStatus = (boolean) returnMap.get(MapConstant.TRANSACTION_STATUS);
		if (tranctionStatus) {
			//Save the details
			dataMap.put(MapConstant.FIELD_CRITERIA_ENTITY_ID, returnMap.get(MapConstant.FIELD_CRITERIA_ENTITY_ID));
			returnMap.clear();
			Map<String, Object> detailsMap = detailsDao.save(dataMap);
			returnMap.put(MapConstant.TRANSACTION_STATUS, detailsMap.get(MapConstant.TRANSACTION_STATUS));
			//get the latest details to show after saved
			InspectionHeader model = new InspectionHeader();
			model.setId((Integer)dataMap.get(MapConstant.FIELD_CRITERIA_ENTITY_ID));
			dataMap.put(MapConstant.CLASS_DATA, model);
			detailsMap = detailsDao.getDataById(dataMap);
			returnMap.put(MapConstant.CLASS_LIST, detailsMap.get(MapConstant.CLASS_LIST));
		}
		return returnMap;
	}

	@Override
	public Map<String, Object> updateRecord(HashMap<String, Object> dataMap) throws Exception{
		
		Map<String, Object> returnMap = dao.update(dataMap);//Header
		boolean tranctionStatus = (boolean) returnMap.get(MapConstant.TRANSACTION_STATUS);
		if (tranctionStatus) {
			//Update the details
			returnMap.clear();
			Map<String, Object> detailsMap = detailsDao.update(dataMap);
			returnMap.put(MapConstant.TRANSACTION_STATUS, detailsMap.get(MapConstant.TRANSACTION_STATUS));
			detailsMap.clear();
			detailsMap = detailsDao.getDataById(dataMap);
			returnMap.put(MapConstant.CLASS_LIST, detailsMap.get(MapConstant.CLASS_LIST));
		}
		return returnMap;
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
		
		Map<String, Object> returnMap = dao.getDataById(criteriaMap);
		Map<String, Object> detailsMap = detailsDao.getDataById(criteriaMap);
		
		returnMap.put(MapConstant.TRANSACTION_STATUS, detailsMap.get(MapConstant.TRANSACTION_STATUS));
		returnMap.put(MapConstant.CLASS_LIST, detailsMap.get(MapConstant.CLASS_LIST));
		return returnMap;
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
	public Map<String, Object> generateReport(HashMap<String, Object> criteriaMap) throws Exception {

		InspectionHeader model = (InspectionHeader) criteriaMap.get(MapConstant.CLASS_DATA);
		//get the details
		Map<String, Object> detailsMap = detailsDao.getDataById(criteriaMap);		
		@SuppressWarnings("unchecked")
		List<InspectionDetails> modelList = (ArrayList<InspectionDetails>) detailsMap.get(MapConstant.CLASS_LIST);
		
		//get the main category first
		List<String> mainCategList = new ArrayList<>();
		String mainCateg = null;
		for (InspectionDetails item: modelList) {
			if (item.getMainCategoryName()!=null && !item.getMainCategoryName().trim().equals(mainCateg)) {
				mainCategList.add(item.getMainCategoryName());
				mainCateg = item.getMainCategoryName().trim();
			}
		}
		
		//then, get the category 
		ArrayList<InspectionDetails> categList = new ArrayList<>();
		int categNo = 0;
		for (InspectionDetails item: modelList) {
			if (categNo != item.getCategoryNo()) {
				InspectionDetails d = new InspectionDetails();
				d.setCategoryNo(item.getCategoryNo());
				d.setCategoryName(item.getCategoryName());
				d.setMainCategoryName(item.getMainCategoryName());
				categList.add(d);
				categNo = item.getCategoryNo();
			}
		}
		
		//put it in a list of InspectionDetailsReport for each category under 2 main categories
		List<Object> detailsList = new ArrayList<>();
		for (String mainCategory : mainCategList) {
			InspectionDetailsReport c = new InspectionDetailsReport();
			c.setMainCategory(mainCategory);
			detailsList.add(c);
			for (InspectionDetails itemCateg : categList) {
				if (itemCateg.getMainCategoryName().equals(mainCategory)) {
					InspectionDetailsReport a = new InspectionDetailsReport();
					a.setCategory(itemCateg.getCategoryNo() + "  " + itemCateg.getCategoryName());
					detailsList.add(a);					
				}
				for (InspectionDetails item: modelList) {
					if (itemCateg.getCategoryNo() == item.getCategoryNo() && item.getMainCategoryName().trim().equals(mainCategory)) {
						InspectionDetailsReport b = new InspectionDetailsReport();
						if (item.getSubItemNo()!=null && item.getSubItemNo().trim().length()>0) {
							b.setSubItemNo(item.getSubItemNo());
							b.setSubItemDescription(item.getDescription());
							b.setRemarksForSubItem(item.getRemarks());
							b.setImgGoodForSubItem(item.getStatusId() == 1601 ? (String) criteriaMap.get("ChkYes") : (String) criteriaMap.get("ChkNo"));
							b.setImgRepairForSubItem(item.getStatusId() == 1602 ? (String) criteriaMap.get("ChkYes") : (String) criteriaMap.get("ChkNo"));
							b.setImgReplaceForSubItem(item.getStatusId() == 1603 ? (String) criteriaMap.get("ChkYes") : (String) criteriaMap.get("ChkNo"));
							b.setImgNAForSubItem(item.getStatusId() == 1604 ? (String) criteriaMap.get("ChkYes") : (String) criteriaMap.get("ChkNo"));
						} else {
							b.setItemNo(item.getItemNo());
							b.setItemDescription(item.getDescription());
							b.setRemarksForItem(item.getRemarks());
							b.setImgGoodForItem(item.getStatusId() == 1601 ? (String) criteriaMap.get("ChkYes") : (String) criteriaMap.get("ChkNo"));
							b.setImgRepairForItem(item.getStatusId() == 1602 ? (String) criteriaMap.get("ChkYes") : (String) criteriaMap.get("ChkNo"));
							b.setImgReplaceForItem(item.getStatusId() == 1603 ? (String) criteriaMap.get("ChkYes") : (String) criteriaMap.get("ChkNo"));
							b.setImgNAForItem(item.getStatusId() == 1604 ? (String) criteriaMap.get("ChkYes") : (String) criteriaMap.get("ChkNo"));
						}
						b.setLabelOnly(item.getLabelOnly());
						detailsList.add(b);
					}

				}	
			}
			
		}
		
		
		

		
		String localPath = (String)criteriaMap.get(MapConstant.REPORT_LOCALPATH);
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		//info
		parameters.put("LorryNo", model.getLorryNo()!=null ?  model.getLorryNo() : "");
		parameters.put("PlateNo", model.getPlateNo()!=null ? model.getPlateNo() : "");
		parameters.put("Odometer", model.getOdometer()!=null ? model.getOdometer() : "");
		parameters.put("HubOdometer", model.getHubOdometer()!=null ? model.getHubOdometer() : "");
		parameters.put("Inspectors", model.getInspectors()!=null ? model.getInspectors() : "");
		parameters.put("InspectionDate", model.getInspectionDate()!=null ? DateUtils.sqlDateToString(model.getInspectionDate()): "");
		parameters.put("Remarks", model.getRemarks()!=null ? model.getRemarks() : "");
		if (model.getForAnnual()!=null && model.getForAnnual().trim().toUpperCase().equals("YES")) {
			parameters.put("ChkImgForAnnual", criteriaMap.get("ChkYes"));
		} else {
			parameters.put("ChkImgForAnnual", criteriaMap.get("ChkNo"));
		}
		if (model.getForPm()!=null && model.getForPm().trim().toUpperCase().equals("YES")) {
			parameters.put("ChkImgForPm", criteriaMap.get("ChkYes"));
		} else {
			parameters.put("ChkImgForPm", criteriaMap.get("ChkNo"));
		}
		
		//Note: list is compulsary for the bean data source of the report

		//if profileList is not passed below, the report will not show the driver profile if training is empty, not yet sure why.....
		//maybe because the list in the report detail section datasource is parameter profileList...
		boolean isReportGenerated = ReportUtils.generateReport(detailsList, criteriaMap, parameters, localPath);
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put(MapConstant.BOOLEAN_DATA, isReportGenerated);
		
		return returnMap;
	}
	

}
