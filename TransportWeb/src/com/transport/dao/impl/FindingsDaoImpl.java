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
import com.transport.dao.FindingsDao;
import com.transport.model.Findings;
import com.transport.model.User;
import com.transport.util.TransportUtils;

public class FindingsDaoImpl implements FindingsDao {
	
	private final static Logger logger = Logger.getLogger(FindingsDaoImpl.class);
	
	@Override
	public Map<String, Object> save(HashMap<String, Object> dataMap) throws Exception{
		
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SAVE);
		
		//DBCP JNDI
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean status = false;
		
		Findings model = (Findings) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setCreatedBy((int) user.getId());	
		}
		model.setCreatedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("insert into transport.file_findings (");
		  		qry.append("description ");
		  		qry.append(",createdby ");
		  		qry.append(",createdon ");
		  		qry.append(",version ");
		  		qry.append(",active ");
		  		qry.append(",typeid ");
		  		qry.append(",itemid ");
		  		qry.append(" ) ");
		  		qry.append(" values ");
		  		qry.append(" ( ");
		  		qry.append(" ? ");
		  		qry.append(" ,? ");
		  		qry.append(" ,? ");
		  		qry.append(" ,1 ");
		  		qry.append(" ,true ");
		  		qry.append(" ,? ");
		  		qry.append(" ,? ");
		  		qry.append(" ) ");

		StringBuffer qryLog =  new StringBuffer("insert into transport.file_findings (");
				qryLog.append("description ");
				qryLog.append(",createdby ");
				qryLog.append(",createdon ");
				qryLog.append(",version ");
				qryLog.append(",active ");
				qryLog.append(",typeid ");
				qryLog.append(",itemid ");
				qryLog.append(" ) ");
				qryLog.append(" values ");
				qryLog.append(" ( ");
				qryLog.append(model.getDescription());
				qryLog.append(" ,"+model.getCreatedBy());
				qryLog.append(" ,"+model.getCreatedOn());
				qryLog.append(" ,1 ");
				qryLog.append(" ,true ");
				qryLog.append(" ,"+model.getTypeId());
				qryLog.append(" ,"+model.getItemId());
				qryLog.append(" ) ");
					
		TransportUtils.writeLogDebug(logger, "SQL: "+qryLog.toString());
  		  		
		  try {
			  conn = ServerContext.getJDBCHandle();
			  conn.setAutoCommit(false);
			  pstmt = conn.prepareStatement(qry.toString());
			     
			  pstmt.setString(1, model.getDescription());
			  pstmt.setInt(2, model.getCreatedBy());
			  pstmt.setTimestamp(3, model.getCreatedOn());
			  pstmt.setInt(4, model.getTypeId());
			  pstmt.setInt(5, model.getItemId());
			     
			  int statusInt = pstmt.executeUpdate();
			     
			  if (statusInt == 1) {
				  conn.commit();
				  System.out.println("Inserted into Findings table successfully..");
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
		
		Findings model = (Findings) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update transport.file_findings set ");	
			qry.append(" description=? ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" ,typeid=? ");
			qry.append(" ,itemid=? ");
			qry.append(" where ");
			qry.append(" id = ? ");

		StringBuffer qryLog =  new StringBuffer("update transport.file_findings set ");	
			qryLog.append(" description="+model.getDescription());
			qryLog.append(" ,modifiedby="+model.getModifiedBy());
			qryLog.append(" ,modifiedon="+model.getModifiedOn());
			qryLog.append(" ,version=(version+1) ");
			qryLog.append(" ,typeid="+model.getTypeId());
			qryLog.append(" ,itemid="+model.getItemId());
			qryLog.append(" where ");
			qryLog.append(" id = "+model.getId());
			
		TransportUtils.writeLogDebug(logger, "SQL: "+qryLog.toString());
	
		 try {
			conn = ServerContext.getJDBCHandle();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(qry.toString());
				     
			pstmt.setString(1, model.getDescription());
			pstmt.setInt(2, model.getModifiedBy());
			pstmt.setTimestamp(3, model.getModifiedOn());
			pstmt.setInt(4, model.getTypeId());
			pstmt.setInt(5, model.getItemId());
			pstmt.setLong(6, model.getId());
				     
			int statusInt = pstmt.executeUpdate();
				     
			if (statusInt == 1) {
				conn.commit();
				System.out.println("Findings record (id: " +model.getId()+") updated successfully..");
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
		
		//START Sample code for SpringJDCTemplate
//		//temp codes
//		java.util.Date date= new java.util.Date();
//		model.setModifiedBy(1);
//		model.setModifiedOn(new Timestamp(date.getTime()));
//		
//		boolean status = false;
//		
//		try {
//			String qry = "update pibs.file_building set description=?,nooffloor=?,remarks=?,"
//					+ "modifiedby=?,modifiedon=?,version=(version+1) where id = ?";
//		        	 
//		    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//		 
////		    jdbcTemplate.update(qry, new Object[] { model.getDescription(),model.getNoOfFloor(), model.getRemarks(),
////		    				model.getModifiedBy(),model.getModifiedOn(),model.getId()});
//		    
//	       int resultInt = jdbcTemplate.update(qry, model.getDescription(),model.getNoOfFloor(), model.getRemarks(),
//   									model.getModifiedBy(),model.getModifiedOn(),model.getId());
//		    
//	        if (resultInt == 1) {
//	        	status = true;
//			    System.out.println("Updated Building (id: " +model.getId()+") successfully..");
//	        } 
//	        
//		    returnMap.put(MapConstant.TRANSACTION_STATUS, status);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			returnMap.put(MapConstant.TRANSACTION_STATUS, status);
//		} finally {
//			
//		}
		//END Sample code for SpringJDCTemplate
		
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
		
		Findings model = (Findings) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update transport.file_findings set ");	
			qry.append(" active=false ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");

		StringBuffer qryLog =  new StringBuffer("update transport.file_findings set ");	
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
				System.out.println("Findings record (id: " +model.getId()+") deleted successfully..");
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
		
		//START Sample code SpringJDBCTemplate
//		Map<String, Object> returnMap = new HashMap<String, Object>();
//
//		//temp codes
//		java.util.Date date= new java.util.Date();
//		model.setModifiedBy(1);
//		model.setModifiedOn(new Timestamp(date.getTime()));
//		
//		boolean status = false;
//		
//		try {
//			String qry = "update pibs.file_building set active=false,modifiedby=?,modifiedon=?,version=(version+1) where id = ?";
//		        	 
//		    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//
//	       int resultInt = jdbcTemplate.update(qry, model.getModifiedBy(),model.getModifiedOn(),model.getId());
//		    
//	        if (resultInt == 1) {
//	        	status = true;
//			    System.out.println("Deleted Building (id: " +model.getId()+") successfully..");
//	        } 
//	        
//		    returnMap.put(MapConstant.TRANSACTION_STATUS, status);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			returnMap.put(MapConstant.TRANSACTION_STATUS, status);
//		} finally {
//			
//		}
		//END Sample code for SPringJDBCTemplate
		
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
			 
			  List<Findings> rsList = new ArrayList<Findings>();
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = null;
				 if (category.equals(ActionConstant.SEARCHALL)) {
					 sql = new StringBuffer("select a.id,a.description,b.description as item,c.listvalue as type,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
					 	sql.append(" from transport.file_findings a, transport.file_items b, transport.list_value c ");
					 	sql.append(" where a.itemid = b.id and a.typeid = c.id ");
					 	sql.append(" and a.active = true ");
					 	sql.append(" order by a.description ");
					 	sql.append(" limit ? ");
					 	sql.append(" offset ?");		 
				 } else {
					 sql = new StringBuffer("select a.id,a.description,b.description as item,c.listvalue as type,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
					 	sql.append(" from transport.file_findings a, transport.file_items b, transport.list_value c ");
					 	sql.append(" where a.itemid = b.id and a.typeid = c.id ");
					 	sql.append(" and (a.description ilike '%"+criteria+"%')" );
					 	sql.append(" and a.active = true ");
					 	sql.append(" order by a.description ");
					 	sql.append(" limit ? ");
					 	sql.append(" offset ?");	
				 }


				StringBuffer sqlLog = null;
						 
				if (category.equals(ActionConstant.SEARCHALL)) {
							 sqlLog = new StringBuffer("select a.id,a.description,b.description as item,c.listvalue as type,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
							 sqlLog.append(" from transport.file_findings a, transport.file_items b, transport.list_value c ");
							 sqlLog.append(" where a.itemid = b.id and a.typeid = c.id ");
							 sqlLog.append(" and a.active = true ");
							 sqlLog.append(" order by a.description ");
							 sqlLog.append(" limit "+limit);
							 sqlLog.append(" offset "+offset);	 
				} else {
							 sqlLog = new StringBuffer("select a.id,a.description,b.description as item,c.listvalue as type,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
							 sqlLog.append(" from transport.file_findings a, transport.file_items b, transport.list_value c ");
							 sqlLog.append(" where a.itemid = b.id and a.typeid = c.id ");
							 sqlLog.append(" and (a.description ilike '%"+criteria+"%')" );
							 sqlLog.append(" and a.active = true ");
							 sqlLog.append(" order by a.description ");
							 sqlLog.append(" limit "+limit);
							 sqlLog.append(" offset "+offset);	
				}
						 
				TransportUtils.writeLogDebug(logger, "SQL: "+sqlLog.toString());
					
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, limit);
				 pstmt.setInt(2, offset);
				 
				 rs = pstmt.executeQuery();
				 
				 while(rs.next()) {
					 Findings model=new Findings();  
		    		 model.setId(rs.getInt(1));
		    		 model.setDescription(rs.getString(2));
		    		 model.setItem(rs.getString(3));
		    		 model.setType(rs.getString(4));
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
			    	 sqlCount = new StringBuffer("select count(*) from transport.file_findings where active = true");	 
			     }else {
			    	 sqlCount = new StringBuffer("select count(*) from transport.file_findings where  (description ilike '%"+criteria+"%') and active = true");	 
			     } 

				StringBuffer sqlCountLog = null;
				if (category.equals(ActionConstant.SEARCHALL)) {
					 sqlCountLog = new StringBuffer("select count(*) from transport.file_findings where active = true");	 
				}else {
					 sqlCountLog = new StringBuffer("select count(*) from transport.file_findings where  (description ilike '%"+criteria+"%') and active = true");	 
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
		    Findings model = (Findings) criteriaMap.get(MapConstant.CLASS_DATA);

		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
		     Map<String, Object> returnMap = null;
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();				
				 	sql.append("select a.id,a.description,b.description as item,c.listvalue as type,b.id as itemid,c.id as typeid,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
				 	sql.append("from transport.file_findings a, transport.file_items b, transport.list_value c ");
				 	sql.append("where a.itemid = b.id and a.typeid = c.id ");
				 	sql.append("and a.id = ?");

				 StringBuffer sqlLog = new StringBuffer();				
				 	sqlLog.append("a.id,a.description,b.description as item,c.listvalue as type,a.createdby,c.id as typeid,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
				 	sqlLog.append("from transport.file_findings a, transport.file_items b, transport.list_value c ");
				 	sqlLog.append("where a.itemid = b.id and a.typeid = c.id ");
				 	sqlLog.append("and id = "+ model.getId());
			
				 TransportUtils.writeLogDebug(logger, "SQL: "+sqlLog.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, model.getId());
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
		    		 model.setId(rs.getInt(1));
		    		 model.setDescription(rs.getString(2));
		    		 model.setItem(rs.getString(3));
		    		 model.setType(rs.getString(4));
		    		 model.setItemId(rs.getInt(5));
		    		 model.setTypeId(rs.getInt(6));
		    		
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
			 List<Findings> rsList = new ArrayList<Findings>();
			  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();				
				 	sql.append("select a.id,a.description,b.description as item,c.listvalue as type,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
				 	sql.append("from transport.file_findings a, transport.file_items b, transport.list_value c ");
				 	sql.append("where a.itemid = b.id and a.typeid = c.id ");
				 	sql.append("and a.active = true ");
				 	sql.append("order by a.description");

				 StringBuffer sqlLog = new StringBuffer();				
				 	sqlLog.append("select a.id,a.description,b.description as item,c.listvalue as type,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
				 	sqlLog.append("from transport.file_findings a, transport.file_items b, transport.list_value c ");
				 	sqlLog.append("where a.itemid = b.id and a.typeid = c.id ");
				 	sqlLog.append("and a.active = true ");
				 	sqlLog.append("order by a.description");
			
				 TransportUtils.writeLogDebug(logger, "SQL: "+sqlLog.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 rs = pstmt.executeQuery();


				  
				 while(rs.next()) {
					 //get the model criteria
					 Findings model = new Findings();
		    		 model.setId(rs.getInt(1));
		    		 model.setDescription(rs.getString(2));
		    		 model.setItem(rs.getString(3));
		    		 model.setType(rs.getString(4));
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
			 List<Findings> rsList = new ArrayList<Findings>();
			  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();				
				 	sql.append("select a.id,a.description,b.description as item,c.listvalue as type,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
				 	sql.append("from transport.file_findings a, transport.file_items b, transport.list_value c ");
				 	sql.append("where a.itemid = b.id and a.typeid = c.id ");
				 	sql.append("and a.active = false ");
				 	sql.append("order by a.description ");
				 	sql.append("limit ? ");
				 	sql.append("offset ? ");

				 StringBuffer sqlLog = new StringBuffer();				
				 	sqlLog.append("select a.id,a.description,b.description as item,c.listvalue as type,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
				 	sqlLog.append("from transport.file_findings a, transport.file_items b, transport.list_value c ");
				 	sqlLog.append("where a.itemid = b.id and a.typeid = c.id ");
				 	sqlLog.append("and a.active = false ");
				 	sqlLog.append("order by a.description ");
				 	sqlLog.append("limit " + limit);
				 	sqlLog.append("offset " + offset);
			
				 TransportUtils.writeLogDebug(logger, "SQL: "+sqlLog.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, limit);
				 pstmt.setInt(2, offset);
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
					 //get the model criteria
					 Findings model = new Findings();
		    		 model.setId(rs.getInt(1));
		    		 model.setDescription(rs.getString(2));
		    		 model.setItem(rs.getString(3));
		    		 model.setType(rs.getString(4));
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
		    	 
			    sqlCount = new StringBuffer("select count(*) from transport.file_findings where active = false");	 

				StringBuffer sqlCountLog = null;
				sqlCountLog = new StringBuffer("select count(*) from transport.file_findings where active = false");	 

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
		
		Findings model = (Findings) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update transport.file_findings set ");	
			qry.append(" active=true ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");

		StringBuffer qryLog =  new StringBuffer("update transport.file_findings set ");	
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
				System.out.println("Findings record (id: " +model.getId()+") restored successfully..");
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
	
	//Transport Revision 1 Dec2015
	@Override
	public Map<String, Object> getFindingsByItem(HashMap<String, Object> criteriaMap) throws Exception {
		// TODO Auto-generated method stub
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_GET_ACTIVE_DATA);
		 
		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
		     Map<String, Object> returnMap = null;
			 List<Findings> rsList = new ArrayList<Findings>();
			  
			 int entityId = (int) criteriaMap.get(MapConstant.FIELD_CRITERIA_ENTITY_ID);

			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();				
				 	sql.append("select a.id,a.description,b.description as item,c.listvalue as type,c.id as typeid,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
				 	sql.append("from transport.file_findings a, transport.file_items b, transport.list_value c ");
				 	sql.append("where a.itemid = b.id and a.typeid = c.id ");
				 	sql.append("and a.active = true ");
				 	sql.append("and a.itemid = ? ");
				 	sql.append("order by c.listvalue desc,a.description");

				 StringBuffer sqlLog = new StringBuffer();				
				 	sqlLog.append("select a.id,a.description,b.description as item,c.listvalue as type,c.id as typeid,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
				 	sqlLog.append("from transport.file_findings a, transport.file_items b, transport.list_value c ");
				 	sqlLog.append("where a.itemid = b.id and a.typeid = c.id ");
				 	sqlLog.append("and a.active = true ");
				 	sqlLog.append("and a.itemid = " + entityId + " ");
				 	sqlLog.append("order by c.listvalue desc,a.description");
			
				 TransportUtils.writeLogDebug(logger, "SQL: "+sqlLog.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, entityId);
				 
				 rs = pstmt.executeQuery();
				 
				 while(rs.next()) {					
					 //get the model criteria
					 Findings model = new Findings();
		    		 model.setId(rs.getInt(1));
		    		 model.setDescription(rs.getString(2));
		    		 model.setItem(rs.getString(3));
		    		 model.setType(rs.getString(4));
		    		 model.setTypeId(rs.getInt(5));
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

}
