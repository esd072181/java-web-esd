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
import com.transport.constant.MapConstant;
import com.transport.constant.MiscConstant;
import com.transport.dao.TireManagementDao;
import com.transport.model.TireDetails;
import com.transport.model.User;
import com.transport.util.TransportUtils;

/**
 * 
 * @author edwarddavid
 * @since 12Apr2020
 * DateUpdated: 26Apr2020
 */
public class TireManagementDaoImpl implements TireManagementDao {

	private final static Logger logger = Logger.getLogger(TireManagementDaoImpl.class);
	
	@Override
	public Map<String, Object> saveTireDetails(HashMap<String, Object> dataMap) throws Exception {
		
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SAVE);
		
		//DBCP JNDI
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean status = false;
		
		TireDetails model = (TireDetails) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setCreatedBy((int) user.getId());	
		}
		model.setCreatedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("insert into transport.tran_tire_details (");
				qry.append("serialno ");
				qry.append(",recapno ");
				qry.append(",lorryno ");
				qry.append(",plateno ");
				qry.append(",threaddepth1 ");
				qry.append(",threaddepth2 ");
				qry.append(",threaddepth3 ");
				qry.append(",wheelposition ");
				qry.append(",odometerfitted ");
				qry.append(",distancetraveled ");
				qry.append(",datefitted ");
		  		qry.append(",createdby ");
		  		qry.append(",createdon ");
		  		qry.append(",version ");
		  		qry.append(",active ");
		  		qry.append(",dateupdated ");
		  		qry.append(",odometerremoved ");
		  		qry.append(",dateremoved ");
		  		qry.append(",reasonforremoval ");
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
		  		qry.append(" ,1 ");
		  		qry.append(" ,? ");
		  		qry.append(" ,? ");
		  		qry.append(" ,? ");
		  		qry.append(" ,? ");
		  		qry.append(" ,? ");
		  		qry.append(" ) ");
					
		TransportUtils.writeLogDebug(logger, "SQL: "+qry.toString());
  		  		
		  try {
			  conn = ServerContext.getJDBCHandle();
			  conn.setAutoCommit(false);
			  pstmt = conn.prepareStatement(qry.toString());
			     
			  pstmt.setString(1, model.getSerialNo());
			  pstmt.setString(2, model.getRecapNo());
			  pstmt.setString(3, model.getLorryNo());
			  pstmt.setString(4, model.getPlateNo());
			  pstmt.setInt(5, model.getThreadDepth1());
			  pstmt.setInt(6, model.getThreadDepth2());
			  pstmt.setInt(7, model.getThreadDepth3());
			  pstmt.setString(8, model.getWheelPosition());
			  pstmt.setInt(9, model.getOdometerFitted());
			  pstmt.setInt(10, model.getDistanceTraveled());
			  pstmt.setDate(11, model.getDateFitted());
			  pstmt.setInt(12, model.getCreatedBy());
			  pstmt.setTimestamp(13, model.getCreatedOn());
			  pstmt.setBoolean(14, model.isActive());
			  pstmt.setDate(15, model.getDateUpdated());
			  pstmt.setInt(16, model.getOdometerRemoved());
			  pstmt.setDate(17, model.getDateRemoved());
			  pstmt.setString(18, model.getReasonForRemoval());
			     
			  int statusInt = pstmt.executeUpdate();
			     
			  if (statusInt == 1) {
				  conn.commit();
				  System.out.println("Inserted into Tire Details table successfully..");
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
	public Map<String, Object> searchTireDetailsByLorryNo(HashMap<String, Object> criteriaMap) throws Exception {
		 
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SEARCH);
		 
		 	Map<String, Object> returnMap = null;
			
			 String criteria = (String) criteriaMap.get(MapConstant.SEARCH_CRITERIA);
			 
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
			 
			  List<TireDetails> rsList = new ArrayList<>();
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer  sql = new StringBuffer("select t.id,t.serialno,t.recapno,t.lorryno,t.plateno,t.threaddepth1,threaddepth2,threaddepth3,");
				 		sql.append(" t.wheelposition,t.odometerfitted,t.odometerremoved,t.distancetraveled,t.datefitted,t.dateremoved,t.reasonforremoval,t.dateupdated ");
					 	sql.append(" from transport.tran_tire_details t ");
					 	sql.append(" where t.active = true ");
					 	sql.append(" and t.lorryno = ? ");
					 	sql.append(" order by t.id ");		 
						 
				TransportUtils.writeLogDebug(logger, "SQL: "+sql.toString());
					
				pstmt = conn.prepareStatement(sql.toString());
				 
				pstmt.setString(1, criteria);
				 
				rs = pstmt.executeQuery();
				 
				 while(rs.next()) {
					 TireDetails model=new TireDetails();  
		    		 model.setId(rs.getInt(1));
		    		 model.setSerialNo(rs.getString(2));
		    		 model.setRecapNo(rs.getString(3));
		    		 model.setLorryNo(rs.getString(4));
		    		 model.setPlateNo(rs.getString(5));
		    		 model.setThreadDepth1(rs.getInt(6));
		    		 model.setThreadDepth2(rs.getInt(7));
		    		 model.setThreadDepth3(rs.getInt(8));
		    		 model.setWheelPosition(rs.getString(9));
		    		 model.setOdometerFitted(rs.getInt(10));
		    		 model.setOdometerRemoved(rs.getInt(11));
		    		 model.setDistanceTraveled(rs.getInt(12));
		    		 model.setDateFitted(rs.getDate(13));
		    		 model.setDateRemoved(rs.getDate(14));
		    		 model.setReasonForRemoval(rs.getString(15));
		    		 model.setDateUpdated(rs.getDate(16));
		    		 rsList.add(model);
				 }				 
			 } catch (SQLException e) {
				 e.printStackTrace();
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
	     
	    System.out.println("searchTireDetailsByLorryNo() - Exit");
		return returnMap;
	}


	@Override
	public Map<String, Object> searchLatestRecordBySerialNo(HashMap<String, Object> criteriaMap) throws Exception {
		 
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SEARCH);
		 
		 	Map<String, Object> returnMap = null;
			
			 String criteria = (String) criteriaMap.get(MapConstant.SEARCH_CRITERIA);
			 
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
			 List<TireDetails> rsList = new ArrayList<>();
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer  sql = new StringBuffer("select t.id,t.serialno,t.recapno,t.lorryno,t.plateno,t.threaddepth1,t.threaddepth2,t.threaddepth3,");
				 		sql.append(" t.wheelposition,t.odometerfitted,t.odometerremoved,t.distancetraveled,t.datefitted,t.dateremoved,t.reasonforremoval,");
				 		sql.append(" t.dateupdated,t.active,b.name as brandname ");
					 	sql.append(" from transport.tran_tire_details t, transport.file_tire c, transport.file_tire_brand b ");
					 	sql.append(" where t.serialno = c.serialno and c.brandid = b.id ");
						sql.append(" and t.serialno = ? ");
					 	sql.append(" order by t.id desc ");
						 
				TransportUtils.writeLogDebug(logger, "SQL: "+sql.toString());
					
				pstmt = conn.prepareStatement(sql.toString());
				 
				pstmt.setString(1, criteria);
				 
				rs = pstmt.executeQuery();
				 
				 while (rs.next()) {
					TireDetails  model=new TireDetails();  
		    		 model.setId(rs.getInt(1));
		    		 model.setSerialNo(rs.getString(2));
		    		 model.setRecapNo(rs.getString(3));
		    		 model.setLorryNo(rs.getString(4));
		    		 model.setPlateNo(rs.getString(5));
		    		 model.setThreadDepth1(rs.getInt(6));
		    		 model.setThreadDepth2(rs.getInt(7));
		    		 model.setThreadDepth3(rs.getInt(8));
		    		 model.setWheelPosition(rs.getString(9));
		    		 model.setOdometerFitted(rs.getInt(10));
		    		 model.setOdometerRemoved(rs.getInt(11));
		    		 model.setDistanceTraveled(rs.getInt(12));
		    		 model.setDateFitted(rs.getDate(13));
		    		 model.setDateRemoved(rs.getDate(14));
		    		 model.setReasonForRemoval(rs.getString(15));
		    		 model.setDateUpdated(rs.getDate(16));
		    		 model.setActive(rs.getBoolean(17));
		    		 model.setBrandName(rs.getString(18));
		    		 rsList.add(model);
				 }				 
			 } catch (SQLException e) {
				 throw e;
			 } finally {
				 TransportUtils.closeObjects(rs);
				 TransportUtils.closeObjects(pstmt);
				 TransportUtils.closeObjects(conn);
			 }
			 
			 
		returnMap = new HashMap<String, Object>();
		returnMap.put(MapConstant.CLASS_LIST, rsList);
		     
	    System.out.println("searchLatestRecordBySerialNo() - Exit");
		return returnMap;
	}


	@Override
	public Map<String, Object> updateTireDetails(HashMap<String, Object> dataMap) throws Exception {
		
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_UPDATE);
		
		//DBCP JNDI
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean status = false;
		
		TireDetails model = (TireDetails) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update transport.tran_tire_details set ");
				qry.append("odometerFitted = ? ");
				qry.append(",threaddepth1 = ? ");
				qry.append(",threaddepth2 = ? ");
				qry.append(",threaddepth3 = ? ");
				qry.append(",dateUpdated = ? ");
				qry.append(",modifiedby = ? ");
		  		qry.append(",modifiedon = ? ");
		  		qry.append(",version = (version+1) ");
		  		qry.append(" where id = ? ");
		  			
		TransportUtils.writeLogDebug(logger, "SQL: "+qry.toString());
  		  		
		  try {
			  conn = ServerContext.getJDBCHandle();
			  conn.setAutoCommit(false);
			  pstmt = conn.prepareStatement(qry.toString());
			  
			  pstmt.setInt(1, model.getOdometerFitted());
			  pstmt.setInt(2, model.getThreadDepth1());
			  pstmt.setInt(3, model.getThreadDepth2() );
			  pstmt.setInt(4, model.getThreadDepth3());
			  pstmt.setDate(5, model.getDateUpdated());
			  pstmt.setInt(6, model.getModifiedBy());
			  pstmt.setTimestamp(7, model.getModifiedOn());
			  pstmt.setInt(8, model.getId());
			
			  int statusInt = pstmt.executeUpdate();
			     
			  if (statusInt == 1) {
				  conn.commit();
				  System.out.println("Updated Tire Details (Edit) table successfully..");
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


	/**
	 * This method is used for tire removal process
	 */
	@Override
	public Map<String, Object> updateTireDetailsRemove(HashMap<String, Object> dataMap) throws Exception {
		
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_UPDATE);
		
		//DBCP JNDI
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean status = false;
		
		TireDetails model = (TireDetails) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update transport.tran_tire_details set ");
				qry.append("active = false ");
		  		qry.append(",modifiedby = ? ");
		  		qry.append(",modifiedon = ? ");
		  		qry.append(",version = (version+1) ");
		  		qry.append(" where serialno = ? ");
		  		qry.append(" and active = true ");
		  			
		TransportUtils.writeLogDebug(logger, "SQL: "+qry.toString());
  		  		
		  try {
			  conn = ServerContext.getJDBCHandle();
			  conn.setAutoCommit(false);
			  pstmt = conn.prepareStatement(qry.toString());
			  
			  pstmt.setInt(1, model.getModifiedBy());
			  pstmt.setTimestamp(2, model.getModifiedOn());
			  pstmt.setString(3, model.getSerialNo());
			
			  int statusInt = pstmt.executeUpdate();
			     
			  if (statusInt == 1) {
				  conn.commit();
				  System.out.println("Updated Tire Details (Remove) table successfully..");
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
	public Map<String, Object> getLatestOdometerBySerialNo(HashMap<String, Object> criteriaMap) throws Exception {
		 
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SEARCH);
		 
		 	Map<String, Object> returnMap = null;
			
			 String criteria = (String) criteriaMap.get(MapConstant.SEARCH_CRITERIA);
			 
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
			 TireDetails model = new TireDetails();
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer  sql = new StringBuffer("select t.odometerfitted from transport.tran_tire_details t");
						sql.append(" where t.serialno = ? ");
					 	sql.append(" order by t.id desc ");
					 	sql.append(" limit 1 ");
						 
				TransportUtils.writeLogDebug(logger, "SQL: "+sql.toString());
					
				pstmt = conn.prepareStatement(sql.toString());
				 
				pstmt.setString(1, criteria);
				 
				rs = pstmt.executeQuery();
				 
				 if (rs.next()) {
		    		 model.setOdometerFitted(rs.getInt(1));
				 }				 
			 } catch (SQLException e) {
				 throw e;
			 } finally {
				 TransportUtils.closeObjects(rs);
				 TransportUtils.closeObjects(pstmt);
				 TransportUtils.closeObjects(conn);
			 }
			 
			 
		returnMap = new HashMap<String, Object>();
		returnMap.put(MapConstant.CLASS_DATA, model);
		     
	    System.out.println("getLatestOdometerBySerialNo() - Exit");
		return returnMap;
	}


	@Override
	public Map<String, Object> getDataById(HashMap<String, Object> criteriaMap) throws Exception {
		 
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SEARCH);
		 
		 	Map<String, Object> returnMap = null;
			
		 	Integer criteria = Integer.valueOf(String.valueOf(criteriaMap.get(MapConstant.SEARCH_CRITERIA)));
			 
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
			 TireDetails model = new TireDetails();
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer  sql = new StringBuffer("select t.id,t.serialno,t.recapno,t.lorryno,t.plateno,t.threaddepth1,t.threaddepth2,t.threaddepth3, ");
			 		sql.append(" t.wheelposition,t.odometerfitted,t.odometerremoved,t.distancetraveled,t.datefitted,t.dateremoved,t.reasonforremoval,t.dateupdated ");
				 	sql.append(" from transport.tran_tire_details t ");
				 	sql.append(" where t.id = ? ");
					 
				TransportUtils.writeLogDebug(logger, "SQL: "+sql.toString());
					
				pstmt = conn.prepareStatement(sql.toString());
				 
				pstmt.setInt(1, criteria);
				 
				rs = pstmt.executeQuery();
				 
				 if (rs.next()) {
		    		 model.setId(rs.getInt(1));
		    		 model.setSerialNo(rs.getString(2));
		    		 model.setRecapNo(rs.getString(3));
		    		 model.setLorryNo(rs.getString(4));
		    		 model.setPlateNo(rs.getString(5));
		    		 model.setThreadDepth1(rs.getInt(6));
		    		 model.setThreadDepth2(rs.getInt(7));
		    		 model.setThreadDepth3(rs.getInt(8));
		    		 model.setWheelPosition(rs.getString(9));
		    		 model.setOdometerFitted(rs.getInt(10));
		    		 model.setOdometerRemoved(rs.getInt(11));
		    		 model.setDistanceTraveled(rs.getInt(12));
		    		 model.setDateFitted(rs.getDate(13));
		    		 model.setDateRemoved(rs.getDate(14));
		    		 model.setReasonForRemoval(rs.getString(15));
		    		 model.setDateUpdated(rs.getDate(16));
				 }				 			 
			 } catch (SQLException e) {
				 throw e;
			 } finally {
				 TransportUtils.closeObjects(rs);
				 TransportUtils.closeObjects(pstmt);
				 TransportUtils.closeObjects(conn);
			 }
			 
			 
		returnMap = new HashMap<String, Object>();
		returnMap.put(MapConstant.CLASS_DATA, model);
		     
	    System.out.println("getDataById() - Exit");
		return returnMap;
	}


	@Override
	public Map<String, Object> getLorryHistory(HashMap<String, Object> dataMap) throws Exception {
		 
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SEARCH);
		 
		 	Map<String, Object> returnMap = new HashMap<String, Object>();
			
		 	String criteria = String.valueOf(dataMap.get(MapConstant.SEARCH_CRITERIA));
			 
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
			 List<TireDetails> qryList = new ArrayList<>();
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer  sql = new StringBuffer("select distinct(serialno),active ");
			 		sql.append(" from transport.tran_tire_details ");
				 	sql.append(" where lorryno = ? ");
				 	sql.append(" order by active desc,serialno ");
				 	
				TransportUtils.writeLogDebug(logger, "SQL: "+sql.toString());
					
				pstmt = conn.prepareStatement(sql.toString());
				 
				pstmt.setString(1, criteria);
				 
				rs = pstmt.executeQuery();
				 
				int i = 0;
				while (rs.next()) {
					TireDetails model = new TireDetails();
		    		 model.setSerialNo(rs.getString(1));
		    		 model.setActive(rs.getBoolean(2));
		    		 model.setRowNo(++i);
		    		 qryList.add(model);
				}				 			 
			 } catch (SQLException e) {
				 throw e;
			 } finally {
				 TransportUtils.closeObjects(rs);
				 TransportUtils.closeObjects(pstmt);
				 TransportUtils.closeObjects(conn);
			 }
			 
		returnMap.put(MapConstant.CLASS_LIST, qryList);
		     
	    System.out.println("getLorryHistory() - Exit");
		return returnMap;
	}


	@Override
	public Map<String, Object> searchTireDetailsBySerialNo(HashMap<String, Object> dataMap) throws Exception {
		 
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SEARCH);
		 
		 	Map<String, Object> returnMap = new HashMap<String, Object>();
			
		 	String criteria = String.valueOf(dataMap.get(MapConstant.SEARCH_CRITERIA));
			 
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
			 List<TireDetails> qryList = new ArrayList<>();
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer  sql = new StringBuffer("select serialno,recapno,lorryno,plateno,threaddepth1,threaddepth2,threaddepth3, ");
				 	sql.append(" wheelposition,odometerfitted,odometerremoved,distancetraveled,datefitted,dateremoved,reasonforremoval, ");
				 	sql.append(" dateupdated,active, ROW_NUMBER() OVER (ORDER BY id desc) ");
				 	sql.append(" from transport.tran_tire_details ");
				 	sql.append(" where serialno = ? ");
				 	
				TransportUtils.writeLogDebug(logger, "SQL: "+sql.toString());
					
				pstmt = conn.prepareStatement(sql.toString());
				 
				pstmt.setString(1, criteria);
				 
				rs = pstmt.executeQuery();
				 
				while (rs.next()) {
					TireDetails model = new TireDetails();
		    		 model.setSerialNo(rs.getString(1));
		    		 model.setRecapNo(rs.getString(2));
		    		 model.setLorryNo(rs.getString(3));
		    		 model.setPlateNo(rs.getString(4));
		    		 model.setThreadDepth1(rs.getInt(5));
		    		 model.setThreadDepth2(rs.getInt(6));
		    		 model.setThreadDepth3(rs.getInt(7));
		    		 model.setWheelPosition(rs.getString(8));
		    		 model.setOdometerFitted(rs.getInt(9));
		    		 model.setOdometerRemoved(rs.getInt(10));
		    		 model.setDistanceTraveled(rs.getInt(11));
		    		 model.setDateFitted(rs.getDate(12));
		    		 model.setDateRemoved(rs.getDate(13));
		    		 model.setReasonForRemoval(rs.getString(14));
		    		 model.setDateUpdated(rs.getDate(15));
		    		 model.setActive(rs.getBoolean(16));
		    		 model.setRowNo(rs.getInt(17));
		    		 qryList.add(model);
				}				 			 
			 } catch (SQLException e) {
				 throw e;
			 } finally {
				 TransportUtils.closeObjects(rs);
				 TransportUtils.closeObjects(pstmt);
				 TransportUtils.closeObjects(conn);
			 }
			 
		returnMap.put(MapConstant.CLASS_LIST, qryList);
		     
	    System.out.println("searchTireDetailsBySerialNo() - Exit");
		return returnMap;
	}

}
