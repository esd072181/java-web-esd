package com.transport.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.transport.config.ServerContext;
import com.transport.constant.MapConstant;
import com.transport.constant.MiscConstant;
import com.transport.dao.RptWorkPermitDao;
import com.transport.model.WorkPermit;
import com.transport.util.DateUtils;
import com.transport.util.TransportUtils;

public class RptWorkPermitDaoImpl implements RptWorkPermitDao {
	
	private final static Logger logger = Logger.getLogger(RptWorkPermitDaoImpl.class);

	@Override
	public Map<String, Object> search(HashMap<String, Object> criteriaMap)
			throws Exception {
		 
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SEARCH);
		 
		 	Map<String, Object> returnMap = null;

		 	 //Connection using JNDI DBCP
			 //get the criteria and value
		 	 int transportId = Integer.parseInt((String)criteriaMap.get(MapConstant.TRANSPORT_PROGRAM));
		 	 int searchCriteria = Integer.parseInt((String)criteriaMap.get(MapConstant.SEARCH_CRITERIA));
			 String searchValue = (String) criteriaMap.get(MapConstant.SEARCH_VALUE);
			 String dateFromValue = (String) criteriaMap.get(MapConstant.DATE_FROM_VALUE);
			 String dateToValue = (String) criteriaMap.get(MapConstant.DATE_TO_VALUE);
			 
			 Connection conn = null;
			 ResultSet rs = null;
			 PreparedStatement pstmt = null;
			 
			 List<WorkPermit> rsList = new ArrayList<WorkPermit>();
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = null;
				 		
				 sql = new StringBuffer("select a.id,a.permitno,a.plateno,a.lorryno,a.itemrepair,a.gasfree,a.hotwork,a.mechanic,a.permitissuer,a.datestarted,a.timestarted,a.dateended,a.timeended,a.rescue,a.odometer,a.hub,b.listvalue as transport,a.itemreplace,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
				 	sql.append(" from transport.file_work_permit a, transport.list_value b ");
				 	sql.append(" where a.transportid = b.id ");
				 	sql.append(" and a.active = true ");
			    	if (MiscConstant.LOV_WORK_PERMIT_CRITERIA_PERMIT_NO == searchCriteria) {
			    		sql.append(" and a.permitno ilike '%"+searchValue+"%' ");
			    	}
			    	else if (MiscConstant.LOV_WORK_PERMIT_CRITERIA_PLATE_NO == searchCriteria) {
			    		sql.append(" and a.plateno ilike '%"+searchValue+"%' ");
			    	}
			    	else if (MiscConstant.LOV_WORK_PERMIT_CRITERIA_LORRY_NO == searchCriteria) {
			    		sql.append(" and a.lorryno ilike '%"+searchValue+"%' ");
			    	}
			    	else if (MiscConstant.LOV_WORK_PERMIT_CRITERIA_ITEM_REPAIR == searchCriteria) {
			    		sql.append(" and a.itemrepair ilike '%"+searchValue+"%' ");
			    	}				    	
			    	else if (MiscConstant.LOV_WORK_PERMIT_CRITERIA_GAS_FREE == searchCriteria) {
			    		sql.append(" and a.gasfree ilike '%"+searchValue+"%' ");
			    	}
			    	else if (MiscConstant.LOV_WORK_PERMIT_CRITERIA_HOT_WORK == searchCriteria) {
			    		sql.append(" and a.hotwork ilike '%"+searchValue+"%' ");
			    	}
			    	else if (MiscConstant.LOV_WORK_PERMIT_CRITERIA_MECHANIC == searchCriteria) {
			    		sql.append(" and a.mechanic ilike '%"+searchValue+"%' ");
			    	}
			    	else if (MiscConstant.LOV_WORK_PERMIT_CRITERIA_PERMIT_ISSUER == searchCriteria) {
			    		sql.append(" and a.permitissuer ilike '%"+searchValue+"%' ");
			    	}
			    	else if (MiscConstant.LOV_WORK_PERMIT_CRITERIA_LORRY_NO == searchCriteria) {
			    		sql.append(" and a.lorryno ilike '%"+searchValue+"%' ");
			    	}
			    	else if (MiscConstant.LOV_WORK_PERMIT_CRITERIA_DATE_STARTED == searchCriteria) {
				 		sql.append(" and a.datestarted between '"+DateUtils.sqlDateToStringSQL(DateUtils.strToSQLDate(dateFromValue))+"' and '"+DateUtils.sqlDateToStringSQL(DateUtils.strToSQLDate(dateToValue))+"'");
				 	}
			    	else if (MiscConstant.LOV_WORK_PERMIT_CRITERIA_TIME_STARTED == searchCriteria) {
			    		sql.append(" and a.timestarted ilike '%"+searchValue+"%' ");
			    	}
			    	else if (MiscConstant.LOV_WORK_PERMIT_CRITERIA_DATE_ENDED == searchCriteria) {
				 		sql.append(" and a.dateended between '"+DateUtils.sqlDateToStringSQL(DateUtils.strToSQLDate(dateFromValue))+"' and '"+DateUtils.sqlDateToStringSQL(DateUtils.strToSQLDate(dateToValue))+"'");
				 	}
			    	else if (MiscConstant.LOV_WORK_PERMIT_CRITERIA_TIME_ENDED == searchCriteria) {
			    		sql.append(" and a.timeended ilike '%"+searchValue+"%' ");
			    	}
			    	else if (MiscConstant.LOV_WORK_PERMIT_CRITERIA_RESCUE == searchCriteria) {
			    		sql.append(" and a.rescue ilike '%"+searchValue+"%' ");
			    	}
			    	else if (MiscConstant.LOV_WORK_PERMIT_CRITERIA_ODOMETER == searchCriteria) {
			    		sql.append(" and a.odometer ilike '%"+searchValue+"%' ");
			    	}
			    	else if (MiscConstant.LOV_WORK_PERMIT_CRITERIA_HUB == searchCriteria) {
			    		sql.append(" and a.hub ilike '%"+searchValue+"%' ");
			    	}
			    	else if (MiscConstant.LOV_WORK_PERMIT_CRITERIA_ITEM_REPLACE == searchCriteria) {
			    		sql.append(" and a.itemreplace ilike '%"+searchValue+"%' ");
			    	}
			    	sql.append(" and a.transportid = " + transportId + " ");
				 	sql.append(" order by a.datestarted desc");
						
						 
				TransportUtils.writeLogDebug(logger, "SQL: "+sql.toString());
					
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 rs = pstmt.executeQuery();
				 
				 while(rs.next()) {
					 WorkPermit model=new WorkPermit();  
		    		 model.setId(rs.getInt(1));
		    		 model.setPermitNo(rs.getString(2));
		    		 model.setPlateNo(rs.getString(3));
		    		 model.setLorryNo(rs.getString(4));
		    		 model.setItemRepair(rs.getString(5));
		    		 model.setGasFree(rs.getString(6));
		    		 model.setHotWork(rs.getString(7));
		    		 model.setMechanic(rs.getString(8));
		    		 model.setPermitIssuer(rs.getString(9));
		    		 model.setDateStarted(rs.getDate(10));
		    		 model.setTimeStarted(rs.getString(11));
		    		 model.setDateEnded(rs.getDate(12));
		    		 model.setTimeEnded(rs.getString(13));
		    		 model.setRescue(rs.getString(14));
		    		 model.setOdometer(rs.getString(15));
		    		 model.setHub(rs.getString(16));
		    		 model.setTransport(rs.getString(17));
		    		 model.setItemReplace(rs.getString(18));
			    	 rsList.add(model);
				 }				 
			 } catch (SQLException e) {
				 throw e;
			 } finally {
				 TransportUtils.closeObjects(rs);
				 TransportUtils.closeObjects(pstmt);
				 TransportUtils.closeObjects(conn);
			 }
			 
		     
		     if (rsList!=null && !rsList.isEmpty()) {
		    	 returnMap = new HashMap<String, Object>();
		    	 returnMap.put(MapConstant.CLASS_LIST, rsList);
		     } 
	     
	    System.out.println("search() - Exit");
		return returnMap;
	}

}
