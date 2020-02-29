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
import com.transport.dao.DriverTrainingProfileDao;
import com.transport.model.DriverTrainingProfile ;
import com.transport.model.User;
import com.transport.util.TransportUtils;

public class DriverTrainingProfileDaoImpl implements DriverTrainingProfileDao {
	
	private final static Logger logger = Logger.getLogger(DriverTrainingProfileDaoImpl.class);

	@Override
	public Map<String, Object> save(HashMap<String, Object> dataMap) throws Exception{
		
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SAVE);

		//DBCP JNDI
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean status = false;
		
		DriverTrainingProfile  model = (DriverTrainingProfile ) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setCreatedBy((int) user.getId());	
		}
		model.setCreatedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("insert into transport.tran_driver_training_profile (");
				qry.append("drivertrainingid ");
		  		qry.append(",vnv ");
		  		qry.append(",incab ");
		  		qry.append(",spotcheck ");
		  		qry.append(",incident ");
		  		qry.append(",notes ");
		  		qry.append(",profiledate ");
		  		qry.append(",statusid ");
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
		  		qry.append(" ,? ");
		  		qry.append(" ,? ");
		  		qry.append(" ,? ");
		  		qry.append(" ,? ");
		  		qry.append(" ,? ");
		  		qry.append(" ,1 ");
		  		qry.append(" ,true ");
		  		qry.append(" ) ");

		StringBuffer qryLog =  new StringBuffer("insert into transport.tran_driver_training_profile (");
				qryLog.append("drivertrainingid ");
				qryLog.append(",vnv ");
				qryLog.append(",incab ");
				qryLog.append(",spotcheck ");
				qryLog.append(",incident ");
		  		qryLog.append(",notes ");
		  		qryLog.append(",profiledate ");
		  		qryLog.append(",statusid ");
		  		qryLog.append(",createdby ");
		  		qryLog.append(",createdon ");
		  		qryLog.append(",version ");
		  		qryLog.append(",active ");
				qryLog.append(" ) ");
				qryLog.append(" values ");
				qryLog.append(" ( ");
				qryLog.append(model.getDriverTrainingId());
				qryLog.append(" ,"+model.getVnv());
				qryLog.append(" ,"+model.getIncab());
				qryLog.append(" ,"+model.getSpotcheck());
				qryLog.append(" ,"+model.getIncident());
				qryLog.append(" ,"+model.getNotes());
				qryLog.append(" ,"+model.getProfileDate());
				qryLog.append(" ,"+model.getStatusId());
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
			  pstmt.setString(2, model.getVnv());
			  pstmt.setString(3, model.getIncab());
			  pstmt.setString(4, model.getSpotcheck());
			  pstmt.setString(5, model.getIncident());
			  pstmt.setString(6, model.getNotes());
			  pstmt.setDate(7, model.getProfileDate());
			  pstmt.setInt(8, model.getStatusId());
			  pstmt.setInt(9, model.getCreatedBy());
			  pstmt.setTimestamp(10, model.getCreatedOn());
			     
			  int statusInt = pstmt.executeUpdate();
			     
			  if (statusInt == 1) {
				  conn.commit();
				  System.out.println("Inserted into DriverTrainingProfile  table successfully..");
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
		
		DriverTrainingProfile  model = (DriverTrainingProfile ) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		  		
		StringBuffer qry =  new StringBuffer("update transport.tran_driver_training_profile set ");	
			qry.append(" drivertrainingid=? ");
			qry.append(" ,vnv=? ");
			qry.append(" ,incab=? ");
			qry.append(" ,spotcheck=? ");
			qry.append(" ,incident=? ");
			qry.append(" ,notes=? ");
			qry.append(" ,profiledate=? ");
			qry.append(" ,statusid=? ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");

		StringBuffer qryLog =  new StringBuffer("update transport.tran_driver_training_profile set ");	
			qryLog.append(" drivertrainingid="+model.getDriverTrainingId());
			qryLog.append(" ,vnv="+model.getVnv());
			qryLog.append(" ,incab="+model.getIncab());
			qryLog.append(" ,spotcheck="+model.getSpotcheck());
			qryLog.append(" ,incident="+model.getIncident());
			qryLog.append(" ,notes="+model.getNotes());
			qryLog.append(" ,profiledate="+model.getProfileDate());
			qryLog.append(" ,statusid="+model.getStatusId());
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
			pstmt.setString(2, model.getVnv());
			pstmt.setString(3, model.getIncab());
			pstmt.setString(4, model.getSpotcheck());
			pstmt.setString(5, model.getIncident());
			pstmt.setString(6, model.getNotes());
			pstmt.setDate(7, model.getProfileDate());
			pstmt.setInt(8, model.getStatusId());
			pstmt.setInt(9, model.getModifiedBy());
			pstmt.setTimestamp(10, model.getModifiedOn());
			pstmt.setLong(11, model.getId());
			

			int statusInt = pstmt.executeUpdate();
				     
			if (statusInt == 1) {
				conn.commit();
				System.out.println("DriverTrainingProfile  record (id: " +model.getId()+") updated successfully..");
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
		
		DriverTrainingProfile  model = (DriverTrainingProfile ) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update transport.tran_driver_training_profile set ");	
			qry.append(" active=false ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");

		StringBuffer qryLog =  new StringBuffer("update transport.tran_driver_training_profile set ");	
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
				System.out.println("DriverTrainingProfile  record (id: " +model.getId()+") deleted successfully..");
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
			 
			 DriverTrainingProfile  model = (DriverTrainingProfile) criteriaMap.get(MapConstant.CLASS_DATA);
			 
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
			 
			  List<DriverTrainingProfile> rsList = new ArrayList<DriverTrainingProfile>();
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = null;
				 if (category.equals(ActionConstant.SEARCHALL)) {
					 sql = new StringBuffer("select a.id,a.drivertrainingid,a.vnv,a.incab,a.spotcheck,a.incident,a.notes,a.profiledate,b.description as status ");
					 	sql.append(" from transport.tran_driver_training_profile a, transport.file_remarks b ");
					 	sql.append(" where a.statusid = b.id ");
					 	sql.append(" and a.drivertrainingid = ? ");
					 	sql.append(" and a.active = true ");
					 	sql.append(" order by a.profiledate desc ");
					 	sql.append(" limit ? ");
					 	sql.append(" offset ?");		 
				 } else {
					 sql = new StringBuffer("select a.id,a.drivertrainingid,a.vnv,a.incab,a.spotcheck,a.incident,a.notes,a.profiledate,b.description as status ");
					 	sql.append(" from transport.tran_driver_training_profile a, transport.file_remarks b ");
					 	sql.append(" where a.statusid = b.id ");
					 	sql.append(" and a.drivertrainingid = ? ");
					 	sql.append(" and a.active = true ");
					 	sql.append(" and (b.description ilike '%"+criteria+"%' or a.vnv ilike '%"+criteria+"%' or a.incab ilike '%"+criteria+"%' or a.spotcheck ilike '%"+criteria+"%' or a.incident ilike '%"+criteria+"%' or a.notes ilike '%"+criteria+"%' or cast(a.profiledate as text) ilike '%"+criteria+"%') " );
					 	sql.append(" order by a.profiledate desc ");
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
					 DriverTrainingProfile modelRs = new DriverTrainingProfile();  
					 modelRs.setId(rs.getInt(1));
					 modelRs.setDriverTrainingId(rs.getInt(2));
					 modelRs.setVnv(rs.getString(3));
					 modelRs.setIncab(rs.getString(4));
					 modelRs.setSpotcheck(rs.getString(5));
					 modelRs.setIncident(rs.getString(6));
					 modelRs.setNotes(rs.getString(7));
					 modelRs.setProfileDate(rs.getDate(8));
					 modelRs.setStatus(rs.getString(9));
		    		 rsList.add(modelRs);
				 }				 
			 } catch (SQLException e) {
				 e.printStackTrace();
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
			    	 sqlCount = new StringBuffer("select count(*) from transport.tran_driver_training_profile a where a.drivertrainingid = ? and a.active = true");	 
			     }else {
			    	 sqlCount = new StringBuffer("select count(*) from transport.tran_driver_training_profile a, transport.file_remarks b where a.statusid = b.id and  (b.description ilike '%"+criteria+"%' or a.vnv ilike '%"+criteria+"%' or a.incab ilike '%"+criteria+"%' or a.spotcheck ilike '%"+criteria+"%' or a.incident ilike '%"+criteria+"%' or a.notes ilike '%"+criteria+"%' or cast(a.profiledate as text) ilike '%"+criteria+"%') and a.drivertrainingid = ? and a.active = true");	 
			     } 
					
				TransportUtils.writeLogDebug(logger, "SQL: "+sqlCount.toString());
				
		    	 pstmt = conn.prepareStatement(sqlCount.toString());
		    	 
		    	 pstmt.setInt(1, model.getDriverTrainingId());
		    	 
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
		    DriverTrainingProfile  model = (DriverTrainingProfile ) criteriaMap.get(MapConstant.CLASS_DATA);

		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
		     Map<String, Object> returnMap = null;
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();				
				 	sql = new StringBuffer("select a.id,a.drivertrainingid,a.vnv,a.incab,a.spotcheck,a.incident,a.notes,a.profiledate,a.statusid ");
				 	sql.append(" from transport.tran_driver_training_profile a ");
				 	sql.append(" where a.id = ?");
			
				 TransportUtils.writeLogDebug(logger, "SQL: "+sql.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, model.getId());
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
		    		 model.setId(rs.getInt(1));
		    		 model.setDriverTrainingId(rs.getInt(2));
		    		 model.setVnv(rs.getString(3));
		    		 model.setIncab(rs.getString(4));
		    		 model.setSpotcheck(rs.getString(5));
		    		 model.setIncident(rs.getString(6));
		    		 model.setNotes(rs.getString(7));
		    		 model.setProfileDate(rs.getDate(8));
		    		 model.setStatusId(rs.getInt(9));				 }				 
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
			 List<DriverTrainingProfile > rsList = new ArrayList<DriverTrainingProfile >();
			  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer("select a.id,a.drivertrainingid,a.vnv,a.incab,a.spotcheck,a.incident,a.notes,a.profiledate,b.description as status ");
				 	sql.append(" from transport.tran_driver_training_profile a, transport.file_remarks b ");
				 	sql.append(" where a.statusid = b.id ");
				 	sql.append(" and a.active = true ");
				 	sql.append(" order by a.profiledate desc ");

				 TransportUtils.writeLogDebug(logger, "SQL: "+sql.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
					 //get the model criteria
					 DriverTrainingProfile model = new DriverTrainingProfile();  
		    		 model.setId(rs.getInt(1));
		    		 model.setDriverTrainingId(rs.getInt(2));
		    		 model.setVnv(rs.getString(3));
		    		 model.setIncab(rs.getString(4));
		    		 model.setSpotcheck(rs.getString(5));
		    		 model.setIncident(rs.getString(6));
		    		 model.setNotes(rs.getString(7));
		    		 model.setProfileDate(rs.getDate(8));
		    		 model.setStatus(rs.getString(9));
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
			 List<DriverTrainingProfile > rsList = new ArrayList<DriverTrainingProfile >();
			  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer("select a.id,a.drivertrainingid,a.vnv,a.incab,a.spotcheck,a.incident,a.notes,a.profiledate,b.description as status ");
				 	sql.append(" from transport.tran_driver_training_profile a, transport.file_remarks b ");
				 	sql.append(" where a.statusid = b.id ");
				 	sql.append(" and a.active = false ");
				 	sql.append(" order by a.profiledate desc ");
				 	sql.append(" limit ? ");
				 	sql.append(" offset ? ");

				 TransportUtils.writeLogDebug(logger, "SQL: "+sql.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, limit);
				 pstmt.setInt(2, offset);
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
					 //get the model criteria
					 DriverTrainingProfile model = new DriverTrainingProfile();  
		    		 model.setId(rs.getInt(1));
		    		 model.setDriverTrainingId(rs.getInt(2));
		    		 model.setVnv(rs.getString(3));
		    		 model.setIncab(rs.getString(4));
		    		 model.setSpotcheck(rs.getString(5));
		    		 model.setIncident(rs.getString(6));
		    		 model.setNotes(rs.getString(7));
		    		 model.setProfileDate(rs.getDate(8));
		    		 model.setStatus(rs.getString(9));
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
		    	 
			    sqlCount = new StringBuffer("select count(*) from transport.tran_driver_training_profile where active = false");	 

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
		
		DriverTrainingProfile  model = (DriverTrainingProfile ) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update transport.tran_driver_training_profile set ");	
			qry.append(" active=true ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");

		StringBuffer qryLog =  new StringBuffer("update transport.tran_driver_training_profile set ");	
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
				System.out.println("DriverTrainingProfile  record (id: " +model.getId()+") restored successfully..");
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
	public Map<String, Object> getDataByDriverTrainingId(
			HashMap<String, Object> criteriaMap) throws Exception {
		// TODO Auto-generated method stub
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_GETDATA_BY_DRIVER_TRAINING_ID);
		 
		    //get the model criteria
			DriverTrainingProfile model = (DriverTrainingProfile) criteriaMap.get(MapConstant.CLASS_DATA);

		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
		     Map<String, Object> returnMap = null;
				
		     List<DriverTrainingProfile> rsList = new ArrayList<DriverTrainingProfile>();
		     
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer("select a.id,a.drivertrainingid,a.vnv,a.incab,a.spotcheck,a.incident,a.notes,a.profiledate,b.description as status ");
				 	sql.append(" from transport.tran_driver_training_profile a, transport.file_remarks b ");
				 	sql.append(" where a.statusid = b.id ");
				 	sql.append(" and a.drivertrainingid = ? ");
				 	sql.append(" and a.active = true ");
				 	sql.append(" order by a.profiledate desc");
			
				 TransportUtils.writeLogDebug(logger, "SQL: "+sql.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, model.getDriverTrainingId());
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
					 DriverTrainingProfile modelRs = new DriverTrainingProfile();  
					 modelRs.setId(rs.getInt(1));
					 modelRs.setDriverTrainingId(rs.getInt(2));
					 modelRs.setVnv(rs.getString(3));
					 modelRs.setIncab(rs.getString(4));
					 modelRs.setSpotcheck(rs.getString(5));
					 modelRs.setIncident(rs.getString(6));
					 modelRs.setNotes(rs.getString(7));
					 modelRs.setProfileDate(rs.getDate(8));
					 modelRs.setStatus(rs.getString(9));
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
