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
import com.transport.dao.DriverTrainingInfoDao;
import com.transport.model.DriverTrainingInfo ;
import com.transport.model.User;
import com.transport.util.TransportUtils;

public class DriverTrainingInfoDaoImpl implements DriverTrainingInfoDao{
	
	private final static Logger logger = Logger.getLogger(DriverTrainingInfoDaoImpl.class);

	@Override
	public Map<String, Object> save(HashMap<String, Object> dataMap) throws Exception{
		
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SAVE);

		//DBCP JNDI
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean status = false;
		
		DriverTrainingInfo  model = (DriverTrainingInfo ) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setCreatedBy((int) user.getId());	
		}
		model.setCreatedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("insert into transport.tran_driver_training_info (");
				qry.append("drivertrainingid ");
		  		qry.append(",trainingid ");
		  		qry.append(",expirydate ");
		  		qry.append(",createdby ");
		  		qry.append(",createdon ");
		  		qry.append(",version ");
		  		qry.append(",active ");
		  		qry.append(" ) ");
		  		qry.append(" values ");
		  		qry.append(" ( ");
		  		qry.append(" ? ");
		  		qry.append(" ,? ");
		  		qry.append(" ,? ");
		  		qry.append(" ,? ");
		  		qry.append(" ,? ");
		  		qry.append(" ,1 ");
		  		qry.append(" ,true ");
		  		qry.append(" ) ");

		StringBuffer qryLog =  new StringBuffer("insert into transport.tran_driver_training_info (");
				qryLog.append("drivertrainingid ");
				qryLog.append(",trainingid ");
		  		qryLog.append(",expirydate ");
		  		qryLog.append(",createdby ");
		  		qryLog.append(",createdon ");
		  		qryLog.append(",version ");
		  		qryLog.append(",active ");
				qryLog.append(" ) ");
				qryLog.append(" values ");
				qryLog.append(" ( ");
				qryLog.append(model.getDriverTrainingId());
				qryLog.append(" ,"+model.getTrainingId());
				qryLog.append(" ,"+model.getExpiryDate());
				qryLog.append(" ,"+model.getCreatedBy());
				qryLog.append(" ,"+model.getCreatedOn());
				qryLog.append(" ,1 ");
				qryLog.append(" ,true ");
				qryLog.append(" ) ");
					
		TransportUtils.writeLogDebug(logger, "SQL: "+qryLog.toString());
  		  		
		  try {
			  conn = ServerContext.getJDBCHandle();
			  conn.setAutoCommit(false);
			  pstmt = conn.prepareStatement(qry.toString());
			     
			  pstmt.setInt(1, model.getDriverTrainingId());
			  pstmt.setInt(2, model.getTrainingId());
			  pstmt.setDate(3, model.getExpiryDate());
			  pstmt.setInt(4, model.getCreatedBy());
			  pstmt.setTimestamp(5, model.getCreatedOn());
			     
			  int statusInt = pstmt.executeUpdate();
			     
			  if (statusInt == 1) {
				  conn.commit();
				  System.out.println("Inserted into DriverTrainingInfo  table successfully..");
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
		
		DriverTrainingInfo  model = (DriverTrainingInfo ) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		  		
		StringBuffer qry =  new StringBuffer("update transport.tran_driver_training_info set ");	
			qry.append(" drivertrainingid=? ");
			qry.append(" ,trainingid=? ");
			qry.append(" ,expirydate=? ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");

		StringBuffer qryLog =  new StringBuffer("update transport.tran_driver_training_info set ");	
			qryLog.append(" driverinfoid="+model.getDriverTrainingId());
			qryLog.append(" ,trainingid="+model.getTrainingId());
			qryLog.append(" ,expirydate="+model.getExpiryDate());
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
				     
			pstmt.setInt(1, model.getDriverTrainingId());
			pstmt.setInt(2, model.getTrainingId());
			pstmt.setDate(3, model.getExpiryDate());
			pstmt.setInt(4, model.getModifiedBy());
			pstmt.setTimestamp(5, model.getModifiedOn());
			pstmt.setLong(6, model.getId());
			
			int statusInt = pstmt.executeUpdate();
				     
			if (statusInt == 1) {
				conn.commit();
				System.out.println("DriverTrainingInfo  record (id: " +model.getId()+") updated successfully..");
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
		
		DriverTrainingInfo  model = (DriverTrainingInfo ) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update transport.tran_driver_training_info set ");	
			qry.append(" active=false ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");

		StringBuffer qryLog =  new StringBuffer("update transport.tran_driver_training_info set ");	
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
				System.out.println("DriverTrainingInfo  record (id: " +model.getId()+") deleted successfully..");
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
			 String criteria = (String) criteriaMap.get(MapConstant.SEARCH_CRITERIA);
			 
			 DriverTrainingInfo  model = (DriverTrainingInfo ) criteriaMap.get(MapConstant.CLASS_DATA);
			 
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
			 
			  List<DriverTrainingInfo> rsList = new ArrayList<DriverTrainingInfo>();
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = null;
				 if (category.equals(ActionConstant.SEARCHALL)) {
					 sql = new StringBuffer("select a.id,a.drivertrainingid, d.listvalue as training,a.expirydate,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active  ");
					 	sql.append(" from transport.tran_driver_training_info a, transport.tran_driver_training b, transport.file_employee c, transport.list_value d ");
					 	sql.append(" where a.drivertrainingid = b.id ");
					 	sql.append(" and b.driverid = c.id  ");
					 	sql.append(" and a.trainingid = d.id ");
					 	sql.append(" and a.active = true ");
					 	sql.append(" and a.drivertrainingid = ? ");
					 	sql.append(" order by d.listvalue ");
					 	sql.append(" limit ? ");
					 	sql.append(" offset ?");
				 } else {
					 sql = new StringBuffer("select a.id,a.drivertrainingid, d.listvalue as training,a.expirydate,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active  ");
					 	sql.append(" from transport.tran_driver_training_info a, transport.tran_driver_training b, transport.file_employee c, transport.list_value d ");
					 	sql.append(" where a.drivertrainingid = b.id ");
					 	sql.append(" and b.driverid = c.id  ");
					 	sql.append(" and a.trainingid = d.id ");
					 	sql.append(" and a.drivertrainingid = ? ");
					 	sql.append(" and a.active = true ");
					 	sql.append(" and d.listvalue ilike '%"+criteria+"%'" );
					 	sql.append(" order by d.listvalue ");
					 	sql.append(" limit ? ");
					 	sql.append(" offset ?");
				 }
		 
				TransportUtils.writeLogDebug(logger, "SQL: "+sql.toString());
					
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, model.getDriverTrainingId());
				 pstmt.setInt(2, limit);
				 pstmt.setInt(3, offset);
				 
				 rs = pstmt.executeQuery();
				 
				 while(rs.next()) {
					 DriverTrainingInfo modelRs = new DriverTrainingInfo();  
					 modelRs.setId(rs.getInt(1));
					 modelRs.setDriverTrainingId(rs.getInt(2));
					 modelRs.setTraining(rs.getString(3));
					 modelRs.setExpiryDate(rs.getDate(4));
		    		 rsList.add(modelRs);
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
			    	 sqlCount = new StringBuffer("select count(*) from transport.tran_driver_training_info a where a.active = true");	 
			     }else {
			    	 sqlCount = new StringBuffer("select count(*) from transport.tran_driver_training_info a, transport.list_value b where a.trainingid = b.id and b.listvalue ilike '%"+criteria+"%' and a.active = true");	 
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
		    DriverTrainingInfo  model = (DriverTrainingInfo ) criteriaMap.get(MapConstant.CLASS_DATA);

		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
		     Map<String, Object> returnMap = null;
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer("select a.id,a.drivertrainingid,a.trainingid,a.expirydate ");
				 	sql.append(" from transport.tran_driver_training_info a ");
				 	sql.append(" where a.id = ?");
			
				 TransportUtils.writeLogDebug(logger, "SQL: "+sql.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, model.getId());
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
		    		 model.setId(rs.getInt(1));
		    		 model.setDriverTrainingId(rs.getInt(2));
		    		 model.setTrainingId(rs.getInt(3));
		    		 model.setExpiryDate(rs.getDate(4));
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
			 List<DriverTrainingInfo > rsList = new ArrayList<DriverTrainingInfo >();
			  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer("select a.id,a.drivertrainingid, d.listvalue as training,a.expirydate,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active  ");
				 	sql.append(" from transport.tran_driver_training_info a, transport.tran_driver_training b, transport.file_employee c, transport.list_value d ");
				 	sql.append(" where a.drivertrainingid = b.id ");
				 	sql.append(" and b.driverid = c.id  ");
				 	sql.append(" and a.trainingid = d.id ");
				 	sql.append(" and a.active = true ");
				 	sql.append(" order by d.listvalue ");

			
				 TransportUtils.writeLogDebug(logger, "SQL: "+sql.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
					 //get the model criteria
					 DriverTrainingInfo model = new DriverTrainingInfo();  
		    		 model.setId(rs.getInt(1));
		    		 model.setDriverTrainingId(rs.getInt(2));
		    		 model.setTraining(rs.getString(3));
		    		 model.setExpiryDate(rs.getDate(4));
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
			 List<DriverTrainingInfo > rsList = new ArrayList<DriverTrainingInfo >();
			  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer("select a.id,a.drivertrainingid, d.listvalue as training,a.expirydate,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active  ");
				 	sql.append(" from transport.tran_driver_training_info a, transport.tran_driver_training b, transport.file_employee c, transport.list_value d ");
				 	sql.append(" where a.drivertrainingid = b.id ");
				 	sql.append(" and b.driverid = c.id  ");
				 	sql.append(" and a.trainingid = d.id ");
				 	sql.append(" and a.active = false ");
				 	sql.append(" order by d.listvalue ");
				 	sql.append(" limit ? ");
				 	sql.append(" offset ? ");

				 TransportUtils.writeLogDebug(logger, "SQL: "+sql.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, limit);
				 pstmt.setInt(2, offset);
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
					 //get the model criteria
					 DriverTrainingInfo model = new DriverTrainingInfo();  
		    		 model.setId(rs.getInt(1));
		    		 model.setDriverTrainingId(rs.getInt(2));
		    		 model.setTraining(rs.getString(3));
		    		 model.setExpiryDate(rs.getDate(4));
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
		    	 
			    sqlCount = new StringBuffer("select count(*) from transport.tran_driver_training_info where active = false");	 

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
		
		DriverTrainingInfo  model = (DriverTrainingInfo ) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update transport.tran_driver_training_info set ");	
			qry.append(" active=true ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");

		StringBuffer qryLog =  new StringBuffer("update transport.tran_driver_training_info set ");	
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
				System.out.println("DriverTrainingInfo  record (id: " +model.getId()+") restored successfully..");
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
	public Map<String, Object> getDataByDriverTrainingId(HashMap<String, Object> criteriaMap) throws Exception {
		// TODO Auto-generated method stub
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_GETDATA_BY_DRIVER_TRAINING_ID);
		 
		    //get the model criteria
		    DriverTrainingInfo  model = (DriverTrainingInfo ) criteriaMap.get(MapConstant.CLASS_DATA);

		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
		     Map<String, Object> returnMap = null;
				
		     List<DriverTrainingInfo> rsList = new ArrayList<DriverTrainingInfo>();
		     
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer("select a.id,a.drivertrainingid,b.listvalue as training,a.expirydate ");
				 	sql.append(" from transport.tran_driver_training_info a, transport.list_value b ");
				 	sql.append(" where a.trainingid = b.id ");
				 	sql.append(" and a.drivertrainingid = ?");
				 	sql.append(" and a.active = true ");
			
				 TransportUtils.writeLogDebug(logger, "SQL: "+sql.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, model.getDriverTrainingId());
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
					 DriverTrainingInfo modelRs = new DriverTrainingInfo();  
					 modelRs.setId(rs.getInt(1));
					 modelRs.setDriverTrainingId(rs.getInt(2));
					 modelRs.setTraining(rs.getString(3));
					 modelRs.setExpiryDate(rs.getDate(4));
		    		 rsList.add(modelRs);
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
		    	 returnMap.put(MapConstant.CLASS_LIST, rsList);
		     } 
	     
	     
	    System.out.println("getDataByDriverTrainingId() - Exit");
		return returnMap;
	}


}
