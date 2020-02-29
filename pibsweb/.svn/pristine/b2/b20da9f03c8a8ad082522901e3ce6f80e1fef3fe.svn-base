package com.pibs.dao.impl;

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

import com.pibs.config.ServerContext;
import com.pibs.constant.MapConstant;
import com.pibs.constant.MiscConstant;
import com.pibs.dao.UserAccessDao;
import com.pibs.model.User;
import com.pibs.model.UserAccess;
import com.pibs.util.PIBSUtils;

public class UserAccessDaoImpl implements UserAccessDao {
	
	private final static Logger logger = Logger.getLogger(UserAccessDaoImpl.class);

	@Override
	public Map<String, Object> save(HashMap<String, Object> dataMap) throws Exception{
		
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SAVE);
		
		//DBCP JNDI
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean status = false;
		
		UserAccess model = (UserAccess) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setCreatedBy((int) user.getId());	
		}
		model.setCreatedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("insert into pibs.file_user_access (");
		  		qry.append("userid ");
		  		qry.append(",accessid ");
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
		  		qry.append(" ,1 ");
		  		qry.append(" ,true ");
		  		qry.append(" ) ");

		StringBuffer qryLog =  new StringBuffer("insert into pibs.file_user_access (");
				qryLog.append("userid ");
				qryLog.append(",accessid ");
				qryLog.append(",createdby ");
				qryLog.append(",createdon ");
				qryLog.append(",version ");
				qryLog.append(",active ");
				qryLog.append(" ) ");
				qryLog.append(" values ");
				qryLog.append(" ( ");
				qryLog.append(model.getUserId());
				qryLog.append(model.getAccessId());
				qryLog.append(" ,"+model.getCreatedBy());
				qryLog.append(" ,"+model.getCreatedOn());
				qryLog.append(" ,1 ");
				qryLog.append(" ,true ");
				qryLog.append(" ) ");
					
		PIBSUtils.writeLogDebug(logger, "SQL: "+qryLog.toString());
  		  		
		  try {
			  conn = ServerContext.getJDBCHandle();
			  conn.setAutoCommit(false);
			  pstmt = conn.prepareStatement(qry.toString());
			     
			  pstmt.setInt(1, model.getUserId());
			  pstmt.setInt(2, model.getAccessId());
			  pstmt.setInt(3, model.getCreatedBy());
			  pstmt.setTimestamp(4, model.getCreatedOn());
			     
			  int statusInt = pstmt.executeUpdate();
			     
			  if (statusInt == 1) {
				  conn.commit();
				  System.out.println("Inserted into User Access table successfully..");
				  status = true;
			  }
		  } catch (Exception e) {
			  conn.rollback();
		 	  e.printStackTrace();
		  } finally {
			  PIBSUtils.closeObjects(rs);
			  PIBSUtils.closeObjects(pstmt);
			  PIBSUtils.closeObjects(conn);
		  }
		 		
		returnMap.put(MapConstant.TRANSACTION_STATUS, status);
		     
		return returnMap;
	}

	@Override
	public Map<String, Object> delete(HashMap<String, Object> dataMap) throws Exception{
		// TODO Auto-generated method stub
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_UPDATE);
		
		//DBCP JNDI
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean status = false;
		
		UserAccess model = (UserAccess) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update pibs.file_user_access set ");	
			qry.append(" active=false ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");

		StringBuffer qryLog =  new StringBuffer("update pibs.file_user_access set ");	
			qryLog.append(" active=false ");
			qryLog.append(" ,modifiedby="+model.getModifiedBy());
			qryLog.append(" ,modifiedon="+model.getModifiedOn());
			qryLog.append(" ,version=(version+1) ");
			qryLog.append(" where ");
			qryLog.append(" id = "+model.getId());
			
		PIBSUtils.writeLogDebug(logger, "SQL: "+qryLog.toString());
	
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
				System.out.println("User Access record (id: " +model.getId()+") deleted successfully..");
				status = true;
			}
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			PIBSUtils.closeObjects(rs);
			PIBSUtils.closeObjects(pstmt);
			PIBSUtils.closeObjects(conn);
		}
			 		
		returnMap.put(MapConstant.TRANSACTION_STATUS, status);	
		
		return returnMap;
	}

	@Override
	public Map<String, Object> search(HashMap<String, Object> criteriaMap)
			throws Exception {
		// TODO Auto-generated method stub
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_GETDATA_BY_USER_ID);
		 
		    //get the model criteria
		    int userId = (Integer) criteriaMap.get(MapConstant.SEARCH_CRITERIA);
		    List<UserAccess> modelList = new ArrayList<>();
		    
			 //get the pagination and offset
			 int offset = (int) criteriaMap.get(MapConstant.PAGINATION_OFFSET);
			 int limit = (int) criteriaMap.get(MapConstant.PAGINATION_LIMIT);

		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
		     Map<String, Object> returnMap = null;
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();				
				 	sql.append("select a.id,a.userid,a.accessid,b.listvalue as modulename ");
				 	sql.append(" from pibs.file_user_access a, pibs.list_value b ");
				 	sql.append(" where a.accessid = b.id ");
				 	sql.append(" and a.userid = ? ");
				 	sql.append(" and a.active = true ");
				 	sql.append(" order by b.listvalue ");
				 	sql.append(" limit ? ");
				 	sql.append(" offset ?");	

				 StringBuffer sqlLog = new StringBuffer();				
				 	sqlLog.append("select a.id,a.userid,b.listvalue as modulename ");
				 	sqlLog.append(" from pibs.file_user_access a, pibs.list_value b ");
				 	sqlLog.append(" where a.accessid = b.id ");
				 	sqlLog.append(" and a.userid = " + userId);
				 	sqlLog.append(" and a.active = true ");
				 	sqlLog.append(" order by b.listvalue ");
				 	sqlLog.append(" limit ? ");
				 	sqlLog.append(" offset ?");	
			
				 PIBSUtils.writeLogDebug(logger, "SQL: "+sqlLog.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, userId);
				 pstmt.setInt(2, limit);
				 pstmt.setInt(3, offset);
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
					 UserAccess model = new UserAccess();
					 model.setId(rs.getInt(1));
		    		 model.setUserId(rs.getInt(2));
		    		 model.setAccessId(rs.getInt(3));
		    		 model.setModuleName(rs.getString(4));
		    		 modelList.add(model);
				 }				 
			 } catch (SQLException e) {
				 throw e;
			 } finally {
				 PIBSUtils.closeObjects(rs);
				 PIBSUtils.closeObjects(pstmt);
				 PIBSUtils.closeObjects(conn);
			 }	 
		 		     
		     //get the total of records for pagination
		     int  totalNoOfRecords = 0;
		     StringBuilder sqlCount = null;
			 
		     try {
		    	 conn = ServerContext.getJDBCHandle();
		    	 
		    	 sqlCount = new StringBuilder();
		    	 sqlCount.append("select count(*) ");
		    	 sqlCount.append(" from pibs.file_user_access a, pibs.list_value b ");
		    	 sqlCount.append(" where a.accessid = b.id ");
		    	 sqlCount.append(" and a.userid = ? ");
		    	 sqlCount.append(" and a.active = true ");

				PIBSUtils.writeLogDebug(logger, "SQL: "+sqlCount.toString());
				
		    	 pstmt = conn.prepareStatement(sqlCount.toString());
		    	 
		    	 pstmt.setInt(1, userId);
		    	 
		    	 rs = pstmt.executeQuery();
		    	 if (rs.next()) {
		    		 totalNoOfRecords = rs.getInt(1);
		    	 }
		    			
		     } catch (SQLException e) {
		    	 throw e;
		     } finally {
				 PIBSUtils.closeObjects(rs);
				 PIBSUtils.closeObjects(pstmt);
				 PIBSUtils.closeObjects(conn);
		     }
		     
		     if (!modelList.isEmpty()) {
		    	 returnMap = new HashMap<String, Object>();
		    	 returnMap.put(MapConstant.CLASS_LIST, modelList);
		    	 returnMap.put(MapConstant.PAGINATION_TOTALRECORDS, totalNoOfRecords);
		     } 
	     
	    System.out.println("getDataByUserId() - Exit");
		return returnMap;
	}
	
	@Override
	public Map<String, Object> getDataByUserId(HashMap<String, Object> criteriaMap)
			throws Exception {
		// TODO Auto-generated method stub
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_GETDATA_BY_USER_ID);
		 
		    //get the model criteria
		    int userId = (Integer) criteriaMap.get(MapConstant.SEARCH_CRITERIA);
		    List<UserAccess> modelList = new ArrayList<>();
		    
		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
		     Map<String, Object> returnMap = null;
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();				
				 	sql.append("select a.id,a.userid,a.accessid,b.listvalue as modulename ");
				 	sql.append(" from pibs.file_user_access a, pibs.list_value b ");
				 	sql.append(" where a.accessid = b.id ");
				 	sql.append(" and a.userid = ? ");
				 	sql.append(" and a.active = true ");
				 	sql.append(" order by b.sequenceorder ");

				 StringBuffer sqlLog = new StringBuffer();				
				 	sqlLog.append("select a.id,a.userid,b.listvalue as modulename ");
				 	sqlLog.append(" from pibs.file_user_access a, pibs.list_value b ");
				 	sqlLog.append(" where a.accessid = b.id ");
				 	sqlLog.append(" and a.userid = " + userId);
				 	sqlLog.append(" and a.active = true ");
				 	sqlLog.append(" order by b.sequenceorder ");

			
				 PIBSUtils.writeLogDebug(logger, "SQL: "+sqlLog.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, userId);
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
					 UserAccess model = new UserAccess();
					 model.setId(rs.getInt(1));
		    		 model.setUserId(rs.getInt(2));
		    		 model.setAccessId(rs.getInt(3));
		    		 model.setModuleName(rs.getString(4));
		    		 modelList.add(model);
				 }				 
			 } catch (SQLException e) {
				 throw e;
			 } finally {
				 PIBSUtils.closeObjects(rs);
				 PIBSUtils.closeObjects(pstmt);
				 PIBSUtils.closeObjects(conn);
			 }	 
		 		     
		     if (!modelList.isEmpty()) {
		    	 returnMap = new HashMap<String, Object>();
		    	 returnMap.put(MapConstant.CLASS_LIST, modelList);
		     } 
	     
	    System.out.println("getDataByUserId() - Exit");
		return returnMap;
	}
	
	/**
	 *  Used for validation
	 * @return
	 * @throws Exception 
	 */
	public  Map<String, Object> isAccessExistsForUser(HashMap<String, Object> criteriaMap) throws Exception {
	
	 	//Connection using JNDI DBCP
		 Connection conn = null;
		 ResultSet rs = null;;
		 PreparedStatement pstmt = null;
		
		 Map<String, Object> returnMap = new HashMap<String, Object>();;
		 boolean ans = false;
		 
		 UserAccess model = (UserAccess) criteriaMap.get(MapConstant.CLASS_DATA);
				  
		 try {
			 conn = ServerContext.getJDBCHandle();

			 StringBuffer sql = new StringBuffer();				
			 	sql.append("select a.* from pibs.file_user_access a");
			 	sql.append(" where a.accessid = ? ");
			 	sql.append(" and a.userid = ? ");
			 	sql.append(" and a.active = true ");

			 PIBSUtils.writeLogDebug(logger, "SQL: "+sql.toString());
		
			 pstmt = conn.prepareStatement(sql.toString());
			 
			 pstmt.setInt(1, model.getAccessId());
			 pstmt.setInt(2, model.getUserId());
			 
			 rs = pstmt.executeQuery();

			 if(rs.next()) {
				 ans = true;
			 }				 
		 } catch (SQLException e) {
			 throw e;
		 } finally {
			 PIBSUtils.closeObjects(rs);
			 PIBSUtils.closeObjects(pstmt);
			 PIBSUtils.closeObjects(conn);
		 }	 
		
		 returnMap.put(MapConstant.BOOLEAN_DATA, ans);

		return returnMap;
	}

}
