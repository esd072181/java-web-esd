package com.transport.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.transport.config.ServerContext;
import com.transport.constant.ActionConstant;
import com.transport.constant.MapConstant;
import com.transport.constant.MiscConstant;
import com.transport.dao.WorkPermitDao;
import com.transport.model.User;
import com.transport.model.WorkPermit;
import com.transport.util.DateUtils;
import com.transport.util.TransportUtils;

public class WorkPermitDaoImpl implements WorkPermitDao {
	
	private final static Logger logger = Logger.getLogger(WorkPermitDaoImpl.class);

	@Override
	public Map<String, Object> save(HashMap<String, Object> dataMap) throws Exception{
		
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SAVE);
		
		//DBCP JNDI
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean status = false;
		
		WorkPermit model = (WorkPermit) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setCreatedBy((int) user.getId());	
		}
		model.setCreatedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("insert into transport.file_work_permit (");
		  		qry.append("permitno ");
		  		qry.append(",plateno ");
		  		qry.append(",lorryno ");
		  		qry.append(",itemrepair ");
		  		qry.append(",gasfree ");
		  		qry.append(",hotwork ");
		  		qry.append(",mechanic ");
		  		qry.append(",permitissuer ");
		  		qry.append(",datestarted ");
		  		qry.append(",timestarted ");
		  		qry.append(",dateended ");
		  		qry.append(",timeended ");
		  		qry.append(",rescue ");
		  		qry.append(",odometer ");
		  		qry.append(",hub ");
		  		qry.append(",transportid ");
		  		qry.append(",createdby ");
		  		qry.append(",createdon ");
		  		qry.append(",version ");
		  		qry.append(",active ");
		  		qry.append(",itemreplace ");
		  		qry.append(" ) ");
		  		qry.append(" values ");
		  		qry.append(" ( ");
		  		qry.append(" ? ");
		  		qry.append(" ,? ");
		  		qry.append(" ,? ");
		  		qry.append(" ,? ");
		  		qry.append(" ,? ");
		  		qry.append(" ,? ");
		  		qry.append(" ,? ");
		  		qry.append(" ,? ");
		  		qry.append(" ,? ");
		  		qry.append(" ,? ");
		  		qry.append(" ,? ");
		  		qry.append(" ,? ");
		  		qry.append(" ,? ");
		  		qry.append(" ,? ");
		  		qry.append(" ,? ");
		  		qry.append(" ,? ");
		  		qry.append(" ,? ");
		  		qry.append(" ,? ");
		  		qry.append(" ,1 ");
		  		qry.append(" ,true ");
		  		qry.append(" ,? ");
		  		qry.append(" ) ");

		StringBuffer qryLog =  new StringBuffer("insert into transport.file_work_permit (");
				qryLog.append("permitno ");
				qryLog.append(",plateno ");
				qryLog.append(",lorryno ");
				qryLog.append(",itemrepair ");
				qryLog.append(",gasfree ");
				qryLog.append(",hotwork ");
				qryLog.append(",mechanic ");
				qryLog.append(",permitissuer ");
				qryLog.append(",datestarted ");
				qryLog.append(",timestarted ");
				qryLog.append(",dateended ");
				qryLog.append(",timeended ");
				qryLog.append(",rescue ");
				qryLog.append(",odometer ");
				qryLog.append(",hub ");
				qryLog.append(",transportid ");
				qryLog.append(",createdby ");
				qryLog.append(",createdon ");
				qryLog.append(",version ");
				qryLog.append(",active ");
				qryLog.append(",itemreplace ");
				qryLog.append(" ) ");
				qryLog.append(" values ");
				qryLog.append(" ( ");
				qryLog.append(" ,"+model.getPermitNo());
				qryLog.append(" ,"+model.getPlateNo());
				qryLog.append(" ,"+model.getLorryNo());
				qryLog.append(" ,"+model.getItemRepair());
				qryLog.append(" ,"+model.getGasFree());
				qryLog.append(" ,"+model.getHotWork());
				qryLog.append(" ,"+model.getMechanic());
				qryLog.append(" ,"+model.getPermitIssuer());
				qryLog.append(" ,"+model.getDateStarted());
				qryLog.append(" ,"+model.getTimeStarted());
				qryLog.append(" ,"+model.getDateEnded());
				qryLog.append(" ,"+model.getTimeEnded());
				qryLog.append(" ,"+model.getRescue());
				qryLog.append(" ,"+model.getOdometer());
				qryLog.append(" ,"+model.getHub());
				qryLog.append(" ,"+model.getTransportId());
				qryLog.append(" ,"+model.getCreatedBy());
				qryLog.append(" ,"+model.getCreatedOn());
				qryLog.append(" ,1 ");
				qryLog.append(" ,true ");
				qryLog.append(" ,"+model.getItemReplace());
				qryLog.append(" ) ");
					
		TransportUtils.writeLogDebug(logger, "SQL: "+qryLog.toString());
  		  		
		  try {
			  conn = ServerContext.getJDBCHandle();
			  conn.setAutoCommit(false);
			  pstmt = conn.prepareStatement(qry.toString());
			     
			  pstmt.setString(1, model.getPermitNo());
			  pstmt.setString(2, model.getPlateNo());
			  pstmt.setString(3, model.getLorryNo());
			  pstmt.setString(4, model.getItemRepair());
			  pstmt.setString(5, model.getGasFree());
			  pstmt.setString(6, model.getHotWork());
			  pstmt.setString(7, model.getMechanic());
			  pstmt.setString(8, model.getPermitIssuer());
			  pstmt.setDate(9, model.getDateStarted());
			  pstmt.setString(10, model.getTimeStarted());
			  pstmt.setDate(11, model.getDateEnded());
			  pstmt.setString(12, model.getTimeEnded());
			  pstmt.setString(13, model.getRescue());
			  pstmt.setString(14, model.getOdometer());
			  pstmt.setString(15, model.getHub());
			  pstmt.setInt(16, model.getTransportId());
			  pstmt.setInt(17, model.getCreatedBy());
			  pstmt.setTimestamp(18, model.getCreatedOn());
			  pstmt.setString(19, model.getItemReplace());
			     
			  int statusInt = pstmt.executeUpdate();
			     
			  if (statusInt == 1) {
				  conn.commit();
				  System.out.println("Inserted into Work Permit table successfully..");
				  status = true;
			  }
		  } catch (Exception e) {
			  conn.rollback();
		 	  e.printStackTrace();
		  } finally {
			  TransportUtils.closeObjects(rs);
			  TransportUtils.closeObjects(pstmt);
			  TransportUtils.closeObjects(conn);
		  }
		 		
		returnMap.put(MapConstant.TRANSACTION_STATUS, status);
		     
		return returnMap;
	}

	@Override
	public Map<String, Object> update(HashMap<String, Object> dataMap) throws Exception{
		// TODO Auto-generated method stub
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_UPDATE);
		 
		//DBCP JNDI
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean status = false;
		
		WorkPermit model = (WorkPermit) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update transport.file_work_permit set ");	
			qry.append(" permitno=? ");
			qry.append(" ,plateno=? ");
			qry.append(" ,lorryno=? ");
			qry.append(" ,itemrepair=? ");
			qry.append(" ,gasfree=? ");
			qry.append(" ,hotwork=? ");
			qry.append(" ,mechanic=? ");
			qry.append(" ,permitissuer=? ");
			qry.append(" ,datestarted=? ");
			qry.append(" ,timestarted=? ");
			qry.append(" ,dateended=? ");
			qry.append(" ,timeended=? ");
			qry.append(" ,rescue=? ");
			qry.append(" ,odometer=? ");
			qry.append(" ,hub=? ");
			qry.append(" ,transportid=? ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" ,itemreplace=? ");
			qry.append(" where ");
			qry.append(" id = ? ");

		StringBuffer qryLog =  new StringBuffer("update transport.file_work_permit set ");	
			qryLog.append(" permitno="+model.getPermitNo());
			qryLog.append(" ,plateno="+model.getPlateNo());
			qryLog.append(" ,lorryno="+model.getLorryNo());
			qryLog.append(" ,itemrepair="+model.getItemRepair());
			qryLog.append(" ,gasfree="+model.getGasFree());
			qryLog.append(" ,hotwork="+model.getHotWork());
			qryLog.append(" ,mechanic="+model.getMechanic());
			qryLog.append(" ,permitissuer="+model.getPermitIssuer());
			qryLog.append(" ,datestarted="+model.getDateStarted());
			qryLog.append(" ,timestarted="+model.getTimeStarted());
			qryLog.append(" ,dateended="+model.getDateEnded());
			qryLog.append(" ,timeended="+model.getTimeEnded());
			qryLog.append(" ,rescue="+model.getRescue());
			qryLog.append(" ,odometer="+model.getOdometer());
			qryLog.append(" ,hub="+model.getHub());
			qryLog.append(" ,transportid="+model.getTransportId());
			qryLog.append(" ,modifiedby="+model.getModifiedBy());
			qryLog.append(" ,modifiedon="+model.getModifiedOn());
			qryLog.append(" ,version=(version+1) ");
			qryLog.append(" ,itemreplace="+model.getItemReplace());
			qryLog.append(" where ");
			qryLog.append(" id = "+model.getId());
			
		TransportUtils.writeLogDebug(logger, "SQL: "+qryLog.toString());
	
		 try {
			conn = ServerContext.getJDBCHandle();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(qry.toString());
				     
			pstmt.setString(1, model.getPermitNo());
			pstmt.setString(2, model.getPlateNo());
			pstmt.setString(3, model.getLorryNo());
			pstmt.setString(4, model.getItemRepair());
			pstmt.setString(5, model.getGasFree());
			pstmt.setString(6, model.getHotWork());
			pstmt.setString(7, model.getMechanic());
			pstmt.setString(8, model.getPermitIssuer());
			pstmt.setDate(9, model.getDateStarted());
			pstmt.setString(10, model.getTimeStarted());
			pstmt.setDate(11, model.getDateEnded());
			pstmt.setString(12, model.getTimeEnded());
			pstmt.setString(13, model.getRescue());
			pstmt.setString(14, model.getOdometer());
			pstmt.setString(15, model.getHub());
			pstmt.setInt(16, model.getTransportId());
			pstmt.setInt(17, model.getModifiedBy());
			pstmt.setTimestamp(18, model.getModifiedOn());
			pstmt.setString(19, model.getItemReplace());
			pstmt.setLong(20, model.getId());
				     
			int statusInt = pstmt.executeUpdate();
				     
			if (statusInt == 1) {
				conn.commit();
				System.out.println("Work Permit record (id: " +model.getId()+") updated successfully..");
				status = true;
			}
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			TransportUtils.closeObjects(rs);
			TransportUtils.closeObjects(pstmt);
			TransportUtils.closeObjects(conn);
		}
			 		
		returnMap.put(MapConstant.TRANSACTION_STATUS, status);	
		
		return returnMap;
	}

	@Override
	public Map<String, Object> delete(HashMap<String, Object> dataMap) throws Exception{
		// TODO Auto-generated method stub
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_DELETE);

		
		//DBCP JNDI
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean status = false;
		
		WorkPermit model = (WorkPermit) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update transport.file_work_permit set ");	
			qry.append(" active=false ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");

		StringBuffer qryLog =  new StringBuffer("update transport.file_work_permit set ");	
			qryLog.append(" active=false ");
			qryLog.append(" ,modifiedby="+model.getModifiedBy());
			qryLog.append(" ,modifiedon="+model.getModifiedOn());
			qryLog.append(" ,version=(version+1) ");
			qryLog.append(" where ");
			qryLog.append(" id = "+model.getId());
			
		TransportUtils.writeLogDebug(logger, "SQL: "+qryLog.toString());
	
		 try {
			conn = ServerContext.getJDBCHandle();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(qry.toString());
				     
			pstmt.setInt(1, model.getModifiedBy());
			pstmt.setTimestamp(2, model.getModifiedOn());
			pstmt.setLong(3, model.getId());
				     
			int statusInt = pstmt.executeUpdate();
				     
			if (statusInt == 1) {
				conn.commit();
				System.out.println("Work Permit record (id: " +model.getId()+") deleted successfully..");
				status = true;
			}
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			TransportUtils.closeObjects(rs);
			TransportUtils.closeObjects(pstmt);
			TransportUtils.closeObjects(conn);
		}
			 		
		returnMap.put(MapConstant.TRANSACTION_STATUS, status);			
		
		return returnMap;
	}

	@Override
	public Map<String, Object> search(HashMap<String, Object> criteriaMap) throws Exception{
		 
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SEARCH);
		 
		 	Map<String, Object> returnMap = null;

		 	//Connection using JNDI DBCP
			 //get the pagination and offset
			 int offset = (int) criteriaMap.get(MapConstant.PAGINATION_OFFSET);
			 int limit = (int) criteriaMap.get(MapConstant.PAGINATION_LIMIT);
			 
			 //get the category
			 String category = (String) criteriaMap.get(MapConstant.ACTION);
			 int transportId = Integer.parseInt((String)criteriaMap.get(MapConstant.TRANSPORT_PROGRAM));
			 int searchCriteria = Integer.parseInt((String)criteriaMap.get(MapConstant.SEARCH_CRITERIA));
			 String searchValue = (String) criteriaMap.get(MapConstant.SEARCH_VALUE);
			 String dateFromValue = (String) criteriaMap.get(MapConstant.DATE_FROM_VALUE);
			 String dateToValue = (String) criteriaMap.get(MapConstant.DATE_TO_VALUE);
			 
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
			 
			  List<WorkPermit> rsList = new ArrayList<>();
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = null;
				 if (category.equals(ActionConstant.SEARCHALL)) {
					 sql = new StringBuffer("select a.id,a.permitno,a.plateno,a.lorryno,a.itemrepair,a.gasfree,a.hotwork,a.mechanic,a.permitissuer,a.datestarted,a.timestarted,a.dateended,a.timeended,a.rescue,a.odometer,a.hub,b.listvalue as transport,a.itemreplace,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
					 	sql.append(" from transport.file_work_permit a, transport.list_value b ");
					 	sql.append(" where a.transportid = b.id ");
					 	sql.append(" and a.active = true ");
					 	sql.append(" and a.transportid = " + transportId + " ");
					 	sql.append(" order by a.datestarted desc ");
					 	sql.append(" limit ? ");
					 	sql.append(" offset ?");		 
				 } else {
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
					 	sql.append(" limit ? ");
					 	sql.append(" offset ?");	
				 }
						 
				TransportUtils.writeLogDebug(logger, "SQL: "+sql.toString());
					
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, limit);
				 pstmt.setInt(2, offset);
				 
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
			 
		     //get the total of records
		     int  totalNoOfRecords = 0;
		     StringBuffer sqlCount = null;
			 
		     try {
		    	 conn = ServerContext.getJDBCHandle();
		    	 
			     if (category.equals(ActionConstant.SEARCHALL)) {
			    	 sqlCount = new StringBuffer("select count(*) from transport.file_work_permit a, transport.list_value b where a.transportid = b.id and a.active = true and b.active = true ");
			    	 sqlCount.append(" and a.transportid = " + transportId);
			     }else {
			    	 sqlCount = new StringBuffer("select count(*) from ");
			    	 sqlCount.append(" transport.file_work_permit a, transport.list_value b ");
			    	 sqlCount.append(" where a.transportid = b.id " );
				    	if (MiscConstant.LOV_WORK_PERMIT_CRITERIA_PERMIT_NO == searchCriteria) {
				    		sqlCount.append(" and a.permitno ilike '%"+searchValue+"%' ");
				    	}
				    	else if (MiscConstant.LOV_WORK_PERMIT_CRITERIA_PLATE_NO == searchCriteria) {
				    		sqlCount.append(" and a.plateno ilike '%"+searchValue+"%' ");
				    	}
				    	else if (MiscConstant.LOV_WORK_PERMIT_CRITERIA_LORRY_NO == searchCriteria) {
				    		sqlCount.append(" and a.lorryno ilike '%"+searchValue+"%' ");
				    	}
				    	else if (MiscConstant.LOV_WORK_PERMIT_CRITERIA_ITEM_REPAIR == searchCriteria) {
				    		sqlCount.append(" and a.itemrepair ilike '%"+searchValue+"%' ");
				    	}				    	
				    	else if (MiscConstant.LOV_WORK_PERMIT_CRITERIA_GAS_FREE == searchCriteria) {
				    		sqlCount.append(" and a.gasfree ilike '%"+searchValue+"%' ");
				    	}
				    	else if (MiscConstant.LOV_WORK_PERMIT_CRITERIA_HOT_WORK == searchCriteria) {
				    		sqlCount.append(" and a.hotwork ilike '%"+searchValue+"%' ");
				    	}
				    	else if (MiscConstant.LOV_WORK_PERMIT_CRITERIA_MECHANIC == searchCriteria) {
				    		sqlCount.append(" and a.mechanic ilike '%"+searchValue+"%' ");
				    	}
				    	else if (MiscConstant.LOV_WORK_PERMIT_CRITERIA_PERMIT_ISSUER == searchCriteria) {
				    		sqlCount.append(" and a.permitissuer ilike '%"+searchValue+"%' ");
				    	}
				    	else if (MiscConstant.LOV_WORK_PERMIT_CRITERIA_LORRY_NO == searchCriteria) {
				    		sqlCount.append(" and a.lorryno ilike '%"+searchValue+"%' ");
				    	}
				    	else if (MiscConstant.LOV_WORK_PERMIT_CRITERIA_DATE_STARTED == searchCriteria) {
				    		sqlCount.append(" and a.datestarted between '"+DateUtils.sqlDateToStringSQL(DateUtils.strToSQLDate(dateFromValue))+"' and '"+DateUtils.sqlDateToStringSQL(DateUtils.strToSQLDate(dateToValue))+"'");
					 	}
				    	else if (MiscConstant.LOV_WORK_PERMIT_CRITERIA_TIME_STARTED == searchCriteria) {
				    		sqlCount.append(" and a.timestarted ilike '%"+searchValue+"%' ");
				    	}
				    	else if (MiscConstant.LOV_WORK_PERMIT_CRITERIA_DATE_ENDED == searchCriteria) {
				    		sqlCount.append(" and a.dateended between '"+DateUtils.sqlDateToStringSQL(DateUtils.strToSQLDate(dateFromValue))+"' and '"+DateUtils.sqlDateToStringSQL(DateUtils.strToSQLDate(dateToValue))+"'");
					 	}
				    	else if (MiscConstant.LOV_WORK_PERMIT_CRITERIA_TIME_ENDED == searchCriteria) {
				    		sqlCount.append(" and a.timeended ilike '%"+searchValue+"%' ");
				    	}
				    	else if (MiscConstant.LOV_WORK_PERMIT_CRITERIA_RESCUE == searchCriteria) {
				    		sqlCount.append(" and a.rescue ilike '%"+searchValue+"%' ");
				    	}
				    	else if (MiscConstant.LOV_WORK_PERMIT_CRITERIA_ODOMETER == searchCriteria) {
				    		sqlCount.append(" and a.odometer ilike '%"+searchValue+"%' ");
				    	}
				    	else if (MiscConstant.LOV_WORK_PERMIT_CRITERIA_HUB == searchCriteria) {
				    		sqlCount.append(" and a.hub ilike '%"+searchValue+"%' ");
				    	}
				    	else if (MiscConstant.LOV_WORK_PERMIT_CRITERIA_ITEM_REPLACE == searchCriteria) {
				    		sqlCount.append(" and a.itemreplace ilike '%"+searchValue+"%' ");
				    	}
				    	sqlCount.append(" and a.transportid = " + transportId + " ");
				    	sqlCount.append(" and a.active = true ");	 
			     } 

				TransportUtils.writeLogDebug(logger, "SQL: "+sqlCount.toString());
				
		    	 pstmt = conn.prepareStatement(sqlCount.toString());
		    	 
		    	 rs = pstmt.executeQuery();
		    	 if (rs.next()) {
		    		 totalNoOfRecords = rs.getInt(1);
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
		    	 returnMap.put(MapConstant.PAGINATION_TOTALRECORDS, totalNoOfRecords);
		     } 
	     
	    System.out.println("search() - Exit");
		return returnMap;
	}

	@Override
	public Map<String, Object> getDataById(HashMap<String, Object> criteriaMap)
			throws Exception {
		// TODO Auto-generated method stub
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_GETDATA_BY_ID);
		 
		    //get the model criteria
		    WorkPermit model = (WorkPermit) criteriaMap.get(MapConstant.CLASS_DATA);

		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
		     Map<String, Object> returnMap = null;
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();				
				 sql = new StringBuffer("select a.id,a.permitno,a.plateno,a.lorryno,a.itemrepair,a.gasfree,a.hotwork,a.mechanic,a.permitissuer,a.datestarted,a.timestarted,a.dateended,a.timeended,a.rescue,a.odometer,a.hub,a.transportid,b.listvalue as transport,a.itemreplace,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
				 	sql.append("from transport.file_work_permit a, transport.list_value b ");
				 	sql.append("where a.transportid = b.id ");
				 	sql.append("and a.id = ?");

				 TransportUtils.writeLogDebug(logger, "SQL: "+sql.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, model.getId());
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
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
		    		 model.setTransportId(rs.getInt(17));
		    		 model.setTransport(rs.getString(18));
		    		 model.setItemReplace(rs.getString(19));
				 }				 
			 } catch (SQLException e) {
				 throw e;
			 } finally {
				 TransportUtils.closeObjects(rs);
				 TransportUtils.closeObjects(pstmt);
				 TransportUtils.closeObjects(conn);
			 }	 
		 		     
		     if (model!=null) {
		    	 returnMap = new HashMap<String, Object>();
		    	 returnMap.put(MapConstant.CLASS_DATA, model);
		     } 
	     
	    System.out.println("getDataById() - Exit");
		return returnMap;
	}
	
	@Override
	public Map<String, Object> getActiveData() throws Exception {
		// TODO Auto-generated method stub
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_GET_ACTIVE_DATA);
		 
		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
		     Map<String, Object> returnMap = null;
			 List<WorkPermit> rsList = new ArrayList<WorkPermit>();
			  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();				
				 sql = new StringBuffer("select a.id,a.permitno,a.plateno,a.lorryno,a.itemrepair,a.gasfree,a.hotwork,a.mechanic,a.permitissuer,a.datestarted,a.timestarted,a.dateended,a.timeended,a.rescue,a.odometer,a.hub,a.transportid,b.listvalue as transport,a.itemreplace,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
				 	sql.append("from transport.file_work_permit a, transport.list_value b ");
				 	sql.append("where a.transportid = b.id ");
				 	sql.append("where a.ctive = true ");
				 	sql.append("order by a.datestarted desc");
			
				 TransportUtils.writeLogDebug(logger, "SQL: "+sql.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
					 WorkPermit model = new WorkPermit();
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
		    		 model.setTransportId(rs.getInt(17));
		    		 model.setTransport(rs.getString(18));
		    		 model.setItemReplace(rs.getString(19));
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
	     
		return returnMap;
	}

	@Override
	public Map<String, Object> getInActiveData(HashMap<String, Object> criteriaMap) throws Exception {
		// TODO Auto-generated method stub
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_GET_INACTIVE_DATA);
		 
		 //get the pagination and offset
		 int offset = (int) criteriaMap.get(MapConstant.PAGINATION_OFFSET);
		 int limit = (int) criteriaMap.get(MapConstant.PAGINATION_LIMIT);
		 
		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
		     Map<String, Object> returnMap = null;
			 List<WorkPermit> rsList = new ArrayList<WorkPermit>();
			  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();				
				 sql = new StringBuffer("select a.id,a.permitno,a.plateno,a.lorryno,a.itemrepair,a.gasfree,a.hotwork,a.mechanic,a.permitissuer,a.datestarted,a.timestarted,a.dateended,a.timeended,a.rescue,a.odometer,a.hub,a.transportid,b.listvalue as transport,a.itemreplace,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
				 	sql.append("from transport.file_work_permit a, transport.list_value b ");
				 	sql.append("where a.transportid = b.id ");
				 	sql.append("and a.active = false ");
				 	sql.append("order by a.datestarted desc ");
				 	sql.append("limit ? ");
				 	sql.append("offset ? ");
				 	
				 TransportUtils.writeLogDebug(logger, "SQL: "+sql.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, limit);
				 pstmt.setInt(2, offset);
				 
				 rs = pstmt.executeQuery();
 
				 while(rs.next()) {
					 WorkPermit model = new WorkPermit();
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
		    		 model.setTransportId(rs.getInt(17));
		    		 model.setTransport(rs.getString(18));
		    		 model.setItemReplace(rs.getString(19));
		    		 rsList.add(model);
				 }				 
			 } catch (SQLException e) {
				 throw e;
			 } finally {
				 TransportUtils.closeObjects(rs);
				 TransportUtils.closeObjects(pstmt);
				 TransportUtils.closeObjects(conn);
			 }	 
		 		     
		     //get the total of records
		     int  totalNoOfRecords = 0;
		     StringBuffer sqlCount = null;
			 
		     try {
		    	 conn = ServerContext.getJDBCHandle();
		    	 
			    sqlCount = new StringBuffer("select count(*) from transport.file_work_permit a, transport.list_value b where a.transportid = b.id and a.active = false");	 
				
			    StringBuffer sqlCountLog = new StringBuffer("select count(*) from transport.file_work_permit a, transport.list_value b where a.transportid = b.id and a.active = false");	 
					
				TransportUtils.writeLogDebug(logger, "SQL: "+sqlCountLog.toString());
				
		    	 pstmt = conn.prepareStatement(sqlCount.toString());
		    	 
		    	 rs = pstmt.executeQuery();
		    	 if (rs.next()) {
		    		 totalNoOfRecords = rs.getInt(1);
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
		    	 returnMap.put(MapConstant.PAGINATION_TOTALRECORDS, totalNoOfRecords);
		     } 
	     
		return returnMap;
	}
	
	@Override
	public Map<String, Object> restore(HashMap<String, Object> dataMap) throws Exception{
		// TODO Auto-generated method stub
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_RESTORE);

		
		//DBCP JNDI
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean status = false;
		
		WorkPermit model = (WorkPermit) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update transport.file_work_permit set ");	
			qry.append(" active=true ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");

		StringBuffer qryLog =  new StringBuffer("update transport.file_work_permit set ");	
			qryLog.append(" active=true ");
			qryLog.append(" ,modifiedby="+model.getModifiedBy());
			qryLog.append(" ,modifiedon="+model.getModifiedOn());
			qryLog.append(" ,version=(version+1) ");
			qryLog.append(" where ");
			qryLog.append(" id = "+model.getId());
			
		TransportUtils.writeLogDebug(logger, "SQL: "+qryLog.toString());
	
		 try {
			conn = ServerContext.getJDBCHandle();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(qry.toString());
				     
			pstmt.setInt(1, model.getModifiedBy());
			pstmt.setTimestamp(2, model.getModifiedOn());
			pstmt.setLong(3, model.getId());
				     
			int statusInt = pstmt.executeUpdate();
				     
			if (statusInt == 1) {
				conn.commit();
				System.out.println("Work Permit record (id: " +model.getId()+") restored successfully..");
				status = true;
			}
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			TransportUtils.closeObjects(rs);
			TransportUtils.closeObjects(pstmt);
			TransportUtils.closeObjects(conn);
		}
			 		
		returnMap.put(MapConstant.TRANSACTION_STATUS, status);			
		
		return returnMap;
	}
	
		
}
