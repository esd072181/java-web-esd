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
import com.transport.dao.UserDao;
import com.transport.model.User;
import com.transport.util.EncryptUtil;
import com.transport.util.TransportUtils;

public class UserDaoImpl implements UserDao {
	
	private final static Logger logger = Logger.getLogger(UserDaoImpl.class);

	@Override
	public Map<String, Object> save(HashMap<String, Object> dataMap) throws Exception{
		
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SAVE);
		
		//DBCP JNDI
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean status = false;
		
		User model = (User) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setCreatedBy((int) user.getId());	
		}
		model.setCreatedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("insert into transport.file_user (");
		  		qry.append("employeeid ");
		  		qry.append(",roleid ");
		  		qry.append(",username ");
		  		qry.append(",password ");
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
		  		qry.append(" ,1 ");
		  		qry.append(" ,true ");
		  		qry.append(" ) ");
					
		TransportUtils.writeLogDebug(logger, "SQL: "+qry.toString());
  		  		
		  try {
			  conn = ServerContext.getJDBCHandle();
			  conn.setAutoCommit(false);
			  pstmt = conn.prepareStatement(qry.toString());
			     
			  pstmt.setInt(1, model.getEmployeeId());
			  pstmt.setInt(2, model.getRoleId());
			  pstmt.setString(3, model.getUserName());
			  pstmt.setString(4, EncryptUtil.encrypt(model.getPassword()));
			  pstmt.setInt(5, model.getCreatedBy());
			  pstmt.setTimestamp(6, model.getCreatedOn());
			     
			  int statusInt = pstmt.executeUpdate();
			     
			  if (statusInt == 1) {
				  conn.commit();
				  System.out.println("Inserted into User table successfully..");
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
		
		User model = (User) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update transport.file_user set ");	
			qry.append(" employeeid=? ");
			qry.append(" ,roleid=? ");
			qry.append(" ,username=? ");
			qry.append(" ,password=? ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");

		TransportUtils.writeLogDebug(logger, "SQL: "+qry.toString());
	
		 try {
			conn = ServerContext.getJDBCHandle();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(qry.toString());
				     
			pstmt.setInt(1, model.getEmployeeId());
			pstmt.setInt(2, model.getRoleId());
			pstmt.setString(3, model.getUserName());
			pstmt.setString(4, EncryptUtil.encrypt(model.getPassword()));
			pstmt.setInt(5, model.getModifiedBy());
			pstmt.setTimestamp(6, model.getModifiedOn());
			pstmt.setLong(7, model.getId());
				     
			int statusInt = pstmt.executeUpdate();
				     
			if (statusInt == 1) {
				conn.commit();
				System.out.println("User record (id: " +model.getId()+") updated successfully..");
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
		
		User model = (User) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update transport.file_user set ");	
			qry.append(" active=false ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");

		StringBuffer qryLog =  new StringBuffer("update transport.file_user set ");	
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
				System.out.println("User record (id: " +model.getId()+") deleted successfully..");
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
			 
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
			 
			  List<User> rsList = new ArrayList<User>();
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = null;
				 if (category.equals(ActionConstant.SEARCHALL)) {
					 sql = new StringBuffer("select a.id,a.employeeid,b.lastname||', '||b.firstname||' '||b.middlename as name,c.id as roleid,c.listvalue as role,a.username,a.password,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
					 	sql.append(" from transport.file_user a, transport.file_employee b, transport.list_value c ");
					 	sql.append(" where a.employeeid = b.id ");
					 	sql.append(" and a.roleid = c.id ");
					 	sql.append(" and a.active = true ");
					 	sql.append(" and b.active = true ");
					 	sql.append(" order by b.lastname ");
					 	sql.append(" limit ? ");
					 	sql.append(" offset ?");		 
				 } else {
					 sql = new StringBuffer("select a.id,a.employeeid,b.lastname||', '||b.firstname||' '||b.middlename as name,c.id as roleid,c.listvalue as role,a.username,a.password,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
					 	sql.append(" from transport.file_user a, transport.file_employee b, transport.list_value c ");
					 	sql.append(" where a.employeeid = b.id ");
					 	sql.append(" and a.roleid = c.id ");
					 	sql.append(" and (b.lastname ilike '%"+criteria+"%' or b.firstname ilike '%"+criteria+"%' or b.middlename ilike '%"+criteria+"%' or a.username ilike '%"+criteria+"%' or c.listvalue ilike '%"+criteria+"%')" );
					 	sql.append(" and a.active = true ");
					 	sql.append(" and b.active = true ");
					 	sql.append(" order by b.lastname ");
					 	sql.append(" limit ? ");
					 	sql.append(" offset ?");	
				 }


				StringBuffer sqlLog = null;
						 
				if (category.equals(ActionConstant.SEARCHALL)) {
							 sqlLog = new StringBuffer("select a.id,a.employeeid,b.lastname||', '||b.firstname||' '||b.middlename as name,c.id as roleid,c.listvalue as role,a.username,a.password,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
							 sqlLog.append(" from transport.file_user a, transport.file_employee b, transport.list_value c ");
							 sqlLog.append(" where a.employeeid = b.id ");
							 sqlLog.append(" and a.roleid = c.id ");
							 sqlLog.append(" and a.active = true ");
							 sqlLog.append(" and b.active = true ");
							 sqlLog.append(" order by b.lastname ");
							 sqlLog.append(" limit ? ");
							 sqlLog.append(" offset ?");		 	 
				} else {
							 sqlLog = new StringBuffer("select a.id,a.employeeid,b.lastname||', '||b.firstname||' '||b.middlename as name,c.id as roleid,c.listvalue as role,a.username,a.password,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
							 sqlLog.append(" from transport.file_user a, transport.file_employee b, transport.list_value c ");
							 sqlLog.append(" where a.employeeid = b.id ");
							 sqlLog.append(" and a.roleid = c.id ");
							 sqlLog.append(" and (b.lastname ilike '%"+criteria+"%' or b.firstname ilike '%"+criteria+"%' or b.middlename ilike '%"+criteria+"%' or a.username ilike '%"+criteria+"%' or c.listvalue ilike '%"+criteria+"%')" );
							 sqlLog.append(" and a.active = true ");
							 sqlLog.append(" and b.active = true ");
							 sqlLog.append(" order by b.lastname ");
							 sqlLog.append(" limit ? ");
							 sqlLog.append(" offset ?");
				}
						 
				TransportUtils.writeLogDebug(logger, "SQL: "+sqlLog.toString());
					
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, limit);
				 pstmt.setInt(2, offset);
				 
				 rs = pstmt.executeQuery();
				 
				 while(rs.next()) {
					 User model=new User();  
		    		 model.setId(rs.getInt(1));
		    		 model.setEmployeeId(rs.getInt(2));
		    		 model.setName(rs.getString(3));
		    		 model.setRoleId(rs.getInt(4));
		    		 model.setRole(rs.getString(5));
		    		 model.setUserName(rs.getString(6));
//		    		 model.setPassword(rs.getString(7));
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
			    	 sqlCount = new StringBuffer("select count(*) from transport.file_user a, transport.file_employee b, transport.list_value c where a.employeeid = b.id and a.roleid = c.id and a.active = true and b.active = true");	 
			     }else {
			    	 sqlCount = new StringBuffer("select count(*) from transport.file_user a, transport.file_employee b, transport.list_value c where a.employeeid = b.id and a.roleid = c.id and (b.lastname ilike '%"+criteria+"%' or b.firstname ilike '%"+criteria+"%' or b.middlename ilike '%"+criteria+"%' or a.username ilike '%"+criteria+"%' or c.listvalue ilike '%"+criteria+"%') and a.active = true and b.active = true");	 
			     } 

				StringBuffer sqlCountLog = null;
				if (category.equals(ActionConstant.SEARCHALL)) {
					 sqlCountLog = new StringBuffer("select count(*) from transport.file_user a, transport.file_employee b, transport.list_value c where a.employeeid = b.id and a.roleid = c.id and a.active = true and b.active = true");	 
				}else {
					 sqlCountLog = new StringBuffer("select count(*) from transport.file_user a, transport.file_employee b, transport.list_value c where a.employeeid = b.id and a.roleid = c.id and (b.lastname ilike '%"+criteria+"%' or b.firstname ilike '%"+criteria+"%' or b.middlename ilike '%"+criteria+"%' or a.username ilike '%"+criteria+"%' or c.listvalue ilike '%"+criteria+"%') and a.active = true and b.active = true");	 
				} 
					
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
	     
	    System.out.println("search() - Exit");
		return returnMap;
	}

	@Override
	public Map<String, Object> getDataById(HashMap<String, Object> criteriaMap)
			throws Exception {
		// TODO Auto-generated method stub
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_GETDATA_BY_ID);
		 
		    //get the model criteria
		    User model = (User) criteriaMap.get(MapConstant.CLASS_DATA);

		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
		     Map<String, Object> returnMap = null;
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();				
				 	sql.append("select a.id,a.employeeid,b.lastname||', '||b.firstname||' '||b.middlename as name,c.id as roleid,c.listvalue as role,a.username,a.password,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
				 	sql.append("from transport.file_user a, transport.file_employee b, transport.list_value c ");
				 	sql.append("where a.employeeid = b.id ");
				 	sql.append("and a.roleid = c.id ");
				 	sql.append("and a.id = ?");

				 StringBuffer sqlLog = new StringBuffer();				
				 	sqlLog.append("select a.id,a.employeeid,b.lastname||', '||b.firstname||' '||b.middlename as name,c.id as roleid,c.listvalue as role,a.username,a.password,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.activee ");
				 	sqlLog.append("from transport.file_user a, transport.file_employee b, transport.list_value c ");
				 	sqlLog.append("where a.employeeid = b.id ");
				 	sqlLog.append("and a.roleid = c.id ");
				 	sqlLog.append("where a.id = "+ model.getId());
			
				 TransportUtils.writeLogDebug(logger, "SQL: "+sqlLog.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, model.getId());
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
					 model.setId(rs.getInt(1));
		    		 model.setEmployeeId(rs.getInt(2));
		    		 model.setName(rs.getString(3));
		    		 model.setRoleId(rs.getInt(4));
		    		 model.setRole(rs.getString(5));
		    		 model.setUserName(rs.getString(6));
//		    		 model.setPassword(rs.getString(7));
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
			 List<User> rsList = new ArrayList<User>();
			  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();				
				 	sql.append("select a.id,a.employeeid,b.lastname||', '||b.firstname||' '||b.middlename as name,c.id as roleid,c.listvalue as role,a.username,a.password,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
				 	sql.append("from transport.file_user a, transport.file_employee b, transport.list_value c ");
				 	sql.append("where a.employeeid = b.id ");
				 	sql.append("and a.roleid = c.id ");
				 	sql.append("and a.active = true ");
				 	sql.append("order by b.lastname");

				 StringBuffer sqlLog = new StringBuffer();				
					 sqlLog.append("select a.id,a.employeeid,b.lastname||', '||b.firstname||' '||b.middlename as name,c.id as roleid,c.listvalue as role,a.username,a.password,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
					 sqlLog.append("from transport.file_user a, transport.file_employee b, transport.list_value c ");
					 sqlLog.append("where a.employeeid = b.id ");
					 sqlLog.append("and a.roleid = c.id ");
					 sqlLog.append("and a.active = true ");
					 sqlLog.append("order by b.lastname");
			
				 TransportUtils.writeLogDebug(logger, "SQL: "+sqlLog.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 rs = pstmt.executeQuery();


				  
				 while(rs.next()) {
					 //get the model criteria
					 User model = new User();
					 model.setId(rs.getInt(1));
		    		 model.setEmployeeId(rs.getInt(2));
		    		 model.setName(rs.getString(3));
		    		 model.setRoleId(rs.getInt(4));
		    		 model.setRole(rs.getString(5));
		    		 model.setUserName(rs.getString(6));
		    		 model.setPassword(rs.getString(7));
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
			 List<User> rsList = new ArrayList<User>();
			  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();				
				 	sql.append("select a.id,a.employeeid,b.lastname||', '||b.firstname||' '||b.middlename as name,c.id as roleid,c.listvalue as role,a.username,a.password,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
				 	sql.append("from transport.file_user a, transport.file_employee b, transport.list_value c ");
				 	sql.append("where a.employeeid = b.id ");
				 	sql.append("and a.roleid = c.id ");
				 	sql.append("and a.active = false ");
				 	sql.append("order by b.lastname ");
				 	sql.append("limit ? ");
				 	sql.append("offset ? ");

				 StringBuffer sqlLog = new StringBuffer();				
					 sqlLog.append("select a.id,a.employeeid,b.lastname||', '||b.firstname||' '||b.middlename as name,c.id as roleid,c.listvalue as role,a.username,a.password,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
					 sqlLog.append("from transport.file_user a, transport.file_employee b, transport.list_value c ");
					 sqlLog.append("where a.employeeid = b.id ");
					 sqlLog.append("and a.roleid = c.id ");
					 sqlLog.append("and a.active = false ");
					 sqlLog.append("order by b.lastname ");
					 sqlLog.append("limit " + limit);
					 sqlLog.append("offset " + offset);
			
				 TransportUtils.writeLogDebug(logger, "SQL: "+sqlLog.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, limit);
				 pstmt.setInt(2, offset);
				 
				 rs = pstmt.executeQuery();
 
				 while(rs.next()) {
					 //get the model criteria
					 User model = new User();
					 model.setId(rs.getInt(1));
		    		 model.setEmployeeId(rs.getInt(2));
		    		 model.setName(rs.getString(3));
		    		 model.setRoleId(rs.getInt(4));
		    		 model.setRole(rs.getString(5));
		    		 model.setUserName(rs.getString(6));
		    		 model.setPassword(rs.getString(7));
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
		    	 
			    sqlCount = new StringBuffer("select count(*) from transport.file_user a, transport.file_employee b, transport.list_value c where a.employeeid = b.id and a.roleid = c.id and a.active = false");	 
				
			    StringBuffer sqlCountLog = new StringBuffer("select count(*) from transport.file_user a, transport.file_employee b, transport.list_value c where a.employeeid = b.id and a.roleid = c.id and a.active = false");	 
					
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
		
		User model = (User) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update transport.file_user set ");	
			qry.append(" active=true ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");

		StringBuffer qryLog =  new StringBuffer("update transport.file_user set ");	
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
				System.out.println("User record (id: " +model.getId()+") restored successfully..");
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
	public Map<String, Object> updateUsernamePassword(HashMap<String, Object> dataMap) throws Exception{
		// TODO Auto-generated method stub
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_UPDATE_USERNAME_PASSWORD);
		 
		//DBCP JNDI
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean status = false;
		
		User model = (User) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update transport.file_user set ");	
			qry.append(" username=? ");
			qry.append(" ,password=? ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");
	
		TransportUtils.writeLogDebug(logger, "SQL: "+qry.toString());
	
		 try {
			conn = ServerContext.getJDBCHandle();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(qry.toString());
				     
			pstmt.setString(1, model.getUserName());
			pstmt.setString(2, EncryptUtil.encrypt(model.getPassword()));
			pstmt.setInt(3, model.getModifiedBy());
			pstmt.setTimestamp(4, model.getModifiedOn());
			pstmt.setLong(5, model.getId());
				     
			int statusInt = pstmt.executeUpdate();
				     
			if (statusInt == 1) {
				conn.commit();
				System.out.println("User record (id: " +model.getId()+") updated successfully..");
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
	public Map<String, Object> getDataByUsernamePassword(HashMap<String, Object> criteriaMap)
			throws Exception {
		// TODO Auto-generated method stub
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_GETDATA_BY_CRITERIA);
		 
		    //get the model criteria
		    User model = (User) criteriaMap.get(MapConstant.CLASS_DATA);

		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
		     Map<String, Object> returnMap = null;
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();				
				 	sql.append("select id,username,password,employeeid from transport.file_user ");
				 	sql.append("where id = ? ");
				 	sql.append("and username = ? ");
				 	sql.append("and password = ?");
			
				 TransportUtils.writeLogDebug(logger, "SQL: "+sql.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, model.getId());
				 pstmt.setString(2, model.getUserName());
				 pstmt.setString(3, EncryptUtil.encrypt(model.getPassword()));
				 
				 model = null;
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
					 model = new User();
					 model.setId(rs.getInt(1));
		    		 model.setUserName(rs.getString(2));
		    		 model.setPassword(rs.getString(3));
		    		 model.setEmployeeId(rs.getInt(4));
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
	     
	    System.out.println("getDataByUsernamePassword() - Exit");
		return returnMap;
	}

	
}
