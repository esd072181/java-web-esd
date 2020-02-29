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
import com.transport.dao.EmployeeDao;
import com.transport.model.Employee;
import com.transport.model.User;
import com.transport.util.TransportUtils;

public class EmployeeDaoImpl implements EmployeeDao {
	
	private final static Logger logger = Logger.getLogger(EmployeeDaoImpl.class);

	@Override
	public Map<String, Object> save(HashMap<String, Object> dataMap) throws Exception{
		
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SAVE);
		
		//DBCP JNDI
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean status = false;
		
		Employee model = (Employee) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setCreatedBy((int) user.getId());	
		}
		model.setCreatedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("insert into transport.file_employee (");
		  		qry.append("lastname ");
		  		qry.append(",firstname ");
		  		qry.append(",middlename ");
		  		qry.append(",empcategoryid ");
		  		qry.append(",createdby ");
		  		qry.append(",createdon ");
		  		qry.append(",version ");
		  		qry.append(",active ");
		  		qry.append(",permitissuer ");
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
		  		qry.append(" ,? ");
		  		qry.append(" ) ");

		StringBuffer qryLog =  new StringBuffer("insert into transport.file_employee (");
				qryLog.append("lastname ");
				qryLog.append(",firstname ");
				qryLog.append(",middlename ");
				qryLog.append(",empcategoryid ");
				qryLog.append(",createdby ");
				qryLog.append(",createdon ");
				qryLog.append(",version ");
				qryLog.append(",active ");
				qryLog.append(",permitissuer ");
				qryLog.append(" ) ");
				qryLog.append(" values ");
				qryLog.append(" ( ");
				qryLog.append(model.getLastName());
				qryLog.append(" ,"+model.getFirstName());
				qryLog.append(" ,"+model.getMiddleName());
				qryLog.append(" ,"+model.getEmpCategoryId());
				qryLog.append(" ,"+model.getCreatedBy());
				qryLog.append(" ,"+model.getCreatedOn());
				qryLog.append(" ,1 ");
				qryLog.append(" ,true ");
				qryLog.append(" ,"+model.isPermitIssuer());
				qryLog.append(" ) ");
					
		TransportUtils.writeLogDebug(logger, "SQL: "+qryLog.toString());
  		  		
		  try {
			  conn = ServerContext.getJDBCHandle();
			  conn.setAutoCommit(false);
			  pstmt = conn.prepareStatement(qry.toString());
			     
			  pstmt.setString(1, model.getLastName());
			  pstmt.setString(2, model.getFirstName());
			  pstmt.setString(3, model.getMiddleName());
			  pstmt.setInt(4, model.getEmpCategoryId());
			  pstmt.setInt(5, model.getCreatedBy());
			  pstmt.setTimestamp(6, model.getCreatedOn());
			  pstmt.setBoolean(7, model.isPermitIssuer());
			     
			  int statusInt = pstmt.executeUpdate();
			     
			  if (statusInt == 1) {
				  conn.commit();
				  System.out.println("Inserted into Employee table successfully..");
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
		
		Employee model = (Employee) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update transport.file_employee set ");	
			qry.append(" lastname=? ");
			qry.append(" ,firstname=? ");
			qry.append(" ,middlename=? ");
			qry.append(" ,empcategoryid=? ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" ,permitissuer=? ");
			qry.append(" where ");
			qry.append(" id = ? ");

		StringBuffer qryLog =  new StringBuffer("update transport.file_employee set ");	
			qryLog.append(" lastname="+model.getLastName());
			qryLog.append(" ,firstname="+model.getFirstName());
			qryLog.append(" ,middlename="+model.getMiddleName());
			qryLog.append(" ,empcategoryid="+model.getEmpCategoryId());
			qryLog.append(" ,modifiedby="+model.getModifiedBy());
			qryLog.append(" ,modifiedon="+model.getModifiedOn());
			qryLog.append(" ,version=(version+1) ");
			qryLog.append(" ,permitissuer="+model.isPermitIssuer());
			qryLog.append(" where ");
			qryLog.append(" id = "+model.getId());
			
		TransportUtils.writeLogDebug(logger, "SQL: "+qryLog.toString());
	
		 try {
			conn = ServerContext.getJDBCHandle();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(qry.toString());
				     
			pstmt.setString(1, model.getLastName());
			pstmt.setString(2, model.getFirstName());
			pstmt.setString(3, model.getMiddleName());
			pstmt.setInt(4, model.getEmpCategoryId());
			pstmt.setInt(5, model.getModifiedBy());
			pstmt.setTimestamp(6, model.getModifiedOn());
			pstmt.setBoolean(7, model.isPermitIssuer());
			pstmt.setLong(8, model.getId());
			
			int statusInt = pstmt.executeUpdate();
				     
			if (statusInt == 1) {
				conn.commit();
				System.out.println("Employee record (id: " +model.getId()+") updated successfully..");
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
		
		Employee model = (Employee) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update transport.file_employee set ");	
			qry.append(" active=false ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");

		StringBuffer qryLog =  new StringBuffer("update transport.file_employee set ");	
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
				System.out.println("Employee record (id: " +model.getId()+") deleted successfully..");
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
			 
			  List<Employee> rsList = new ArrayList<Employee>();
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = null;
				 if (category.equals(ActionConstant.SEARCHALL)) {
					 sql = new StringBuffer("select a.id,a.lastname,a.firstname,a.middlename,a.empcategoryid,b.listvalue as empcategory,a.permitissuer,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
					 	sql.append(" from transport.file_employee a, transport.list_value b ");
					 	sql.append(" where a.empcategoryid = b.id ");
					 	sql.append(" and a.active = true ");
					 	sql.append(" order by a.lastname ");
					 	sql.append(" limit ? ");
					 	sql.append(" offset ?");		 
				 } else {
					 sql = new StringBuffer("select a.id,a.lastname,a.firstname,a.middlename,a.empcategoryid,b.listvalue as empcategory,a.permitissuer,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
					 	sql.append(" from transport.file_employee a, transport.list_value b ");
					 	sql.append(" where a.empcategoryid = b.id ");
					 	sql.append(" and (a.lastname ilike '%"+criteria+"%' or a.firstname ilike '%"+criteria+"%'  or a.middlename ilike '%"+criteria+"%'  or b.listvalue ilike '%"+criteria+"%')" );
					 	sql.append(" and a.active = true ");
					 	sql.append(" order by a.lastname ");
					 	sql.append(" limit ? ");
					 	sql.append(" offset ?");	
				 }


				StringBuffer sqlLog = null;
						 
				if (category.equals(ActionConstant.SEARCHALL)) {
							 sqlLog = new StringBuffer("select a.id,a.lastname,a.firstname,a.middlename,a.empcategoryid,b.listvalue as empcategory,a.permitissuer,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
							 sqlLog.append(" from transport.file_employee a, transport.list_value b ");
							 sqlLog.append(" where a.empcategoryid = b.id ");
							 sqlLog.append(" and a.active = true ");
							 sqlLog.append(" order by a.lastname ");
							 sqlLog.append(" limit "+limit);
							 sqlLog.append(" offset "+offset);		 
				} else {
							 sqlLog = new StringBuffer("select a.id,a.lastname,a.firstname,a.middlename,a.empcategoryid,b.listvalue as empcategory,a.permitissuer,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
							 sqlLog.append(" from transport.file_employee a, transport.list_value b ");
							 sqlLog.append(" where a.empcategoryid = b.id ");
							 sqlLog.append(" and (a.lastname ilike '%"+criteria+"%' or a.firstname ilike '%"+criteria+"%'  or a.middlename ilike '%"+criteria+"%'  or b.listvalue ilike '%"+criteria+"%')" );
							 sqlLog.append(" and a.active = true ");
							 sqlLog.append(" order by a.lastname ");
							 sqlLog.append(" limit "+limit);
							 sqlLog.append(" offset "+offset);	
				}
						 
				TransportUtils.writeLogDebug(logger, "SQL: "+sqlLog.toString());
					
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, limit);
				 pstmt.setInt(2, offset);
				 
				 rs = pstmt.executeQuery();
				 
				 while(rs.next()) {
					 Employee model=new Employee();  
		    		 model.setId(rs.getInt(1));
		    		 model.setLastName(rs.getString(2));
		    		 model.setFirstName(rs.getString(3));
		    		 model.setMiddleName(rs.getString(4));
		    		 model.setEmpCategoryId(rs.getInt(5));
		    		 model.setEmpCategory(rs.getString(6));
		    		 model.setPermitIssuer(rs.getBoolean(7));
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
			    	 sqlCount = new StringBuffer("select count(*) from transport.file_employee where active = true");	 
			     }else {
			    	 sqlCount = new StringBuffer("select count(*) from transport.file_employee a, transport.list_value b where a.empcategoryid = b.id and (a.lastname ilike '%"+criteria+"%' or a.firstname ilike '%"+criteria+"%' or a.middlename ilike '%"+criteria+"%' or b.listvalue ilike '%"+criteria+"%') and a.active = true ");	 
			     } 

				StringBuffer sqlCountLog = null;
				if (category.equals(ActionConstant.SEARCHALL)) {
					 sqlCountLog = new StringBuffer("select count(*) from transport.file_employee where active = true");	 
				}else {
					 sqlCountLog = new StringBuffer("select count(*) from transport.file_employee a, transport.list_value b where a.empcategoryid = b.id and (a.lastname ilike '%"+criteria+"%' or a.firstname ilike '%"+criteria+"%' or a.middlename ilike '%"+criteria+"%' or b.listvalue ilike '%"+criteria+"%') and a.active = true");	 
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
		    Employee model = (Employee) criteriaMap.get(MapConstant.CLASS_DATA);

		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
		     Map<String, Object> returnMap = null;
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();				
				 	sql.append("select a.id,a.lastname,a.firstname,a.middlename,a.empcategoryid,b.listvalue as empcategory,a.permitissuer,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
				 	sql.append("from transport.file_employee a, transport.list_value b ");
				 	sql.append("where a.empcategoryid = b.id ");
				 	sql.append("and a.id = ?");

				 StringBuffer sqlLog = new StringBuffer();				
				 	sqlLog.append("select a.id,a.lastname,a.firstname,a.middlename,a.empcategoryid,b.listvalue as empcategory,a.permitissuer,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
				 	sqlLog.append("from transport.file_employee a, transport.list_value b ");
				 	sqlLog.append("where a.empcategoryid = b.id ");
				 	sqlLog.append("and a.id = "+ model.getId());
			
				 TransportUtils.writeLogDebug(logger, "SQL: "+sqlLog.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, model.getId());
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
		    		 model.setId(rs.getInt(1));
		    		 model.setLastName(rs.getString(2));
		    		 model.setFirstName(rs.getString(3));
		    		 model.setMiddleName(rs.getString(4));
		    		 model.setEmpCategoryId(rs.getInt(5));
		    		 model.setEmpCategory(rs.getString(6));
		    		 model.setPermitIssuer(rs.getBoolean(7));
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
			 List<Employee> rsList = new ArrayList<Employee>();
			  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();				
				 	sql.append("select a.id,a.lastname,a.firstname,a.middlename,a.empcategoryid,b.listvalue as empcategory,a.permitissuer,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
				 	sql.append("from transport.file_employee a, transport.list_value b ");
				 	sql.append("where a.empcategoryid = b.id ");
				 	sql.append("and a.active = true ");
				 	sql.append("order by a.lastname");

				 StringBuffer sqlLog = new StringBuffer();				
				 	sqlLog.append("select a.id,a.lastname,a.firstname,a.middlename,a.empcategoryid,b.listvalue as empcategory,a.permitissuer,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
				 	sqlLog.append("from transport.file_employee a, transport.list_value b ");
				 	sqlLog.append("where a.empcategoryid = b.id ");
				 	sqlLog.append("and a.active = true ");
				 	sqlLog.append("order by a.lastname");
			
				 TransportUtils.writeLogDebug(logger, "SQL: "+sqlLog.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 rs = pstmt.executeQuery();


				  
				 while(rs.next()) {
					 //get the model criteria
					 Employee model = new Employee();
		    		 model.setId(rs.getInt(1));
		    		 model.setLastName(rs.getString(2));
		    		 model.setFirstName(rs.getString(3));
		    		 model.setMiddleName(rs.getString(4));
		    		 model.setEmpCategoryId(rs.getInt(5));
		    		 model.setEmpCategory(rs.getString(6));
		    		 model.setPermitIssuer(rs.getBoolean(7));
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
	public Map<String, Object> getNoUserAccountData() throws Exception {
		// TODO Auto-generated method stub
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_GET_ACTIVE_DATA);
		 
		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
		     Map<String, Object> returnMap = null;
			 List<Employee> rsList = new ArrayList<Employee>();
			  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();				
				 	sql.append("select id,lastname,firstname,middlename,createdby,createdon,modifiedby,modifiedon,version,active ");
				 	sql.append("from transport.file_employee ");
				 	sql.append("where active = true ");
				 	sql.append("and id not in (select b.id from transport.file_user a, transport.file_employee b where a.employeeid = b.id) ");
				 	sql.append("order by lastname");

				 StringBuffer sqlLog = new StringBuffer();				
				 	sqlLog.append("select id,lastname,firstname,middlename,createdby,createdon,modifiedby,modifiedon,version,active ");
				 	sqlLog.append("from transport.file_employee ");
				 	sqlLog.append("where active = true ");
				 	sqlLog.append("and id not in (select b.id from transport.file_user a, transport.file_employee b where a.employeeid = b.id) ");
				 	sqlLog.append("order by lastname");
			
				 TransportUtils.writeLogDebug(logger, "SQL: "+sqlLog.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 rs = pstmt.executeQuery();


				  
				 while(rs.next()) {
					 //get the model criteria
					 Employee model = new Employee();
		    		 model.setId(rs.getInt(1));
		    		 model.setLastName(rs.getString(2));
		    		 model.setFirstName(rs.getString(3));
		    		 model.setMiddleName(rs.getString(4));
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
			 List<Employee> rsList = new ArrayList<Employee>();
			  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();				
				 	sql.append("select a.id,a.lastname,a.firstname,a.middlename,a.empcategoryid,b.listvalue as empcategory,a.permitissuer,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
				 	sql.append("from transport.file_employee a, transport.list_value b ");
				 	sql.append("where a.empcategoryid = b.id ");
				 	sql.append("and a.active = false ");
				 	sql.append("order by a.lastname ");
				 	sql.append("limit ? ");
				 	sql.append("offset ? ");

				 StringBuffer sqlLog = new StringBuffer();				
				 	sqlLog.append("select a.id,a.lastname,a.firstname,a.middlename,a.empcategoryid,b.listvalue as empcategory,a.permitissuer,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
				 	sqlLog.append("from transport.file_employee a, transport.list_value b ");
				 	sqlLog.append("where a.empcategoryid = b.id ");
				 	sqlLog.append("and a.active = false ");
				 	sqlLog.append("order by a.lastname ");
				 	sqlLog.append("limit " + limit);
				 	sqlLog.append("offset " + offset);
			
				 TransportUtils.writeLogDebug(logger, "SQL: "+sqlLog.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, limit);
				 pstmt.setInt(2, offset);
				 
				 rs = pstmt.executeQuery();
				 
				 while(rs.next()) {
					 //get the model criteria
					 Employee model = new Employee();
		    		 model.setId(rs.getInt(1));
		    		 model.setLastName(rs.getString(2));
		    		 model.setFirstName(rs.getString(3));
		    		 model.setMiddleName(rs.getString(4));
		    		 model.setEmpCategoryId(rs.getInt(5));
		    		 model.setEmpCategory(rs.getString(6));
		    		 model.setPermitIssuer(rs.getBoolean(7));
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
		    	 
			    sqlCount = new StringBuffer("select count(*) from transport.file_employee where active = false");	 


				StringBuffer sqlCountLog = null;
				sqlCountLog = new StringBuffer("select count(*) from transport.file_employee where active = false");	 
					
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
		
		Employee model = (Employee) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update transport.file_employee set ");	
			qry.append(" active=true ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");

		StringBuffer qryLog =  new StringBuffer("update transport.file_employee set ");	
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
				System.out.println("Employee record (id: " +model.getId()+") restored successfully..");
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
