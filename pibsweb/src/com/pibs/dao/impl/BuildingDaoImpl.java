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

import javax.sql.DataSource;

//import org.springframework.dao.DataAccessException;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.ResultSetExtractor;
//import org.springframework.jdbc.core.RowMapper;


import org.apache.log4j.Logger;

import com.pibs.config.ServerContext;
//import com.pibs.config.SpringContext;
import com.pibs.constant.ActionConstant;
import com.pibs.constant.MapConstant;
import com.pibs.constant.MiscConstant;
import com.pibs.dao.BuildingDao;
import com.pibs.model.Building;
import com.pibs.model.User;
import com.pibs.util.PIBSUtils;

public class BuildingDaoImpl implements BuildingDao {
	
	private final static Logger logger = Logger.getLogger(BuildingDaoImpl.class);
	
	//sample code only for this datasource
	//not used anymore
	private DataSource dataSource;
	     
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public Map<String, Object> save(HashMap<String, Object> dataMap) throws Exception{
		
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SAVE);
		
		//DBCP JNDI
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean status = false;
		
		Building model = (Building) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setCreatedBy((int) user.getId());	
		}
		model.setCreatedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("insert into pibs.file_building (");
		  		qry.append("description ");
		  		qry.append(",nooffloor ");
		  		qry.append(",remarks ");
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
		  		
		StringBuffer qryLog =  new StringBuffer("insert into pibs.file_building (");
				qryLog.append("description ");
				qryLog.append(",nooffloor ");
				qryLog.append(",remarks ");
				qryLog.append(",createdby ");
				qryLog.append(",createdon ");
				qryLog.append(",version ");
				qryLog.append(",active ");
				qryLog.append(" ) ");
				qryLog.append(" values ");
				qryLog.append(" ( ");
				qryLog.append(model.getDescription());
				qryLog.append(" ,"+model.getNoOfFloor());
				qryLog.append(" ,"+model.getRemarks());
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
			     
			  pstmt.setString(1, model.getDescription());
			  pstmt.setInt(2, model.getNoOfFloor());
			  pstmt.setString(3, model.getRemarks());
			  pstmt.setInt(4, model.getCreatedBy());
			  pstmt.setTimestamp(5, model.getCreatedOn());
			     
			  int statusInt = pstmt.executeUpdate();
			     
			  if (statusInt == 1) {
				  conn.commit();
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
		     
//		Map<String, Object> returnMap = new HashMap<String, Object>();
//
//		//temp codes
//		java.util.Date date= new java.util.Date();
//		model.setCreatedBy(1);
//		model.setCreatedOn(new Timestamp(date.getTime()));
//		model.setVersion(1);
//		model.setActive(true);
//		
//		boolean status = false;
//		
//		try {
//			String qry = "insert into pibs.file_building (description,nooffloor,remarks,"
//					+ "createdby,createdon,version,active) values (?,?,?,?,?,?,?)";
//		        	     		    
//		    int resultInt = SpringContext.getJDBCHandle().update(qry, model.getDescription(),model.getNoOfFloor(), model.getRemarks(),
//			model.getCreatedBy(),model.getCreatedOn(),model.getVersion(),model.isActive());
//	    
//			
//		    if (resultInt==1) {
//		    	status = true;
//			    System.out.println("Inserted into Building table successfully..");
//		    }
//		    
//		    returnMap.put(MapConstant.TRANSACTION_STATUS, status);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			returnMap.put(MapConstant.TRANSACTION_STATUS, status);
//		} finally {
//			
//		}
		
		return returnMap;
	}

	@Override
	public Map<String, Object> update(HashMap<String, Object> dataMap) throws Exception{
		// TODO Auto-generated method stub
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_UPDATE);
		 
		//DBCP JNDI
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean status = false;
		
		Building model = (Building) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update pibs.file_building set ");	
			qry.append(" description=? ");
			qry.append(" ,nooffloor=? ");
			qry.append(" ,remarks=? ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");
		
			
		StringBuffer qryLog =  new StringBuffer("update pibs.file_building set ");	
				qryLog.append(" description="+model.getDescription());
				qryLog.append(" ,nooffloor="+model.getNoOfFloor());
				qryLog.append(" ,remarks="+model.getRemarks());
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
				     
			pstmt.setString(1, model.getDescription());
			pstmt.setInt(2, model.getNoOfFloor());
			pstmt.setString(3, model.getRemarks());
			pstmt.setInt(4, model.getModifiedBy());
			pstmt.setTimestamp(5, model.getModifiedOn());
			pstmt.setLong(6, model.getId());
				     
			int statusInt = pstmt.executeUpdate();
				     
			if (statusInt == 1) {
				conn.commit();
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
		
		return returnMap;
	}

	@Override
	public Map<String, Object> delete(HashMap<String, Object> dataMap) throws Exception{
		// TODO Auto-generated method stub
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_DELETE);

		//DBCP JNDI
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean status = false;
		
		Building model = (Building) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update pibs.file_building set ");	
			qry.append(" active=false ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");
	
		StringBuffer qryLog =  new StringBuffer("update pibs.file_building set ");	
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
		
		return returnMap;
	}

	@Override
	public Map<String, Object> search(HashMap<String, Object> criteriaMap) throws Exception{
		 
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SEARCH);
		 
		 	Map<String, Object> returnMap = null;

		 	//Connection using JNDI DBCP
			 //get the pagination and offset
			 int offset = (int) criteriaMap.get(MapConstant.PAGINATION_OFFSET);
			 int limit = (int) criteriaMap.get(MapConstant.PAGINATION_LIMIT);
			 
//			 //get the category
			 String category = (String) criteriaMap.get(MapConstant.ACTION);
			 String criteria = (String) criteriaMap.get(MapConstant.SEARCH_CRITERIA);
			 
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
			 
			  List<Building> rsList = new ArrayList<Building>();
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = null;
				 if (category.equals(ActionConstant.SEARCHALL)) {
					 sql = new StringBuffer("select id,description,nooffloor,remarks,createdby,createdon,modifiedby,modifiedon,version,active ");
					 	sql.append(" from pibs.file_building ");
					 	sql.append(" where active = true ");
					 	sql.append(" order by description ");
					 	sql.append(" limit ? ");
					 	sql.append(" offset ?");		 
				 } else {
					 sql = new StringBuffer("select id,description,nooffloor,remarks,createdby,createdon,modifiedby,modifiedon,version,active ");
					 	sql.append(" from pibs.file_building ");
					 	sql.append(" where ");
					 	sql.append(" (description ilike '%"+criteria+"%' or remarks ilike '%"+criteria+"%')" );
					 	sql.append(" and active = true ");
					 	sql.append(" order by description ");
					 	sql.append(" limit ? ");
					 	sql.append(" offset ?");	
				 }
	 
				PIBSUtils.writeLogDebug(logger, "SQL: "+sql.toString());
					
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, limit);
				 pstmt.setInt(2, offset);
				 
				 rs = pstmt.executeQuery();
				 
				 while(rs.next()) {
		    		 Building model=new Building();  
		    		 model.setId(rs.getInt(1));
		    		 model.setDescription(rs.getString(2));
		    		 model.setNoOfFloor(rs.getInt(3));
		    		 model.setRemarks(rs.getString(4));
		    		 rsList.add(model);
				 }				 
			 } catch (SQLException e) {
				 throw e;
			 } finally {
				 PIBSUtils.closeObjects(rs);
				 PIBSUtils.closeObjects(pstmt);
				 PIBSUtils.closeObjects(conn);
			 }
			 
		     //get the total of records
		     int  totalNoOfRecords = 0;
		     StringBuffer sqlCount = null;
			 
		     try {
		    	 conn = ServerContext.getJDBCHandle();
		    	 
			     if (category.equals(ActionConstant.SEARCHALL)) {
			    	 sqlCount = new StringBuffer("select count(*) from pibs.file_building where active = true");	 
			     }else {
			    	 sqlCount = new StringBuffer("select count(*) from pibs.file_building where  (description ilike '%"+criteria+"%' or remarks ilike '%"+criteria+"%') and active = true");	 
			     } 
					
				PIBSUtils.writeLogDebug(logger, "SQL: "+sqlCount.toString());

		    	 pstmt = conn.prepareStatement(sqlCount.toString());
		    	 
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
		     
		     if (rsList!=null && !rsList.isEmpty()) {
		    	 returnMap = new HashMap<String, Object>();
		    	 returnMap.put(MapConstant.CLASS_LIST, rsList);
		    	 returnMap.put(MapConstant.PAGINATION_TOTALRECORDS, totalNoOfRecords);
		     } 
		     
			 		 
//		 //Using Spring JDBC
//		 //get the pagination and offset
//		 int offset = (int) criteriaMap.get(MapConstant.PAGINATION_OFFSET);
//		 int limit = (int) criteriaMap.get(MapConstant.PAGINATION_LIMIT);
//		 
//		 //get the category
//		 String category = (String) criteriaMap.get(MapConstant.ACTION);
//		 String criteria = (String) criteriaMap.get(MapConstant.SEARCH_CRITERIA);
//		 
//		 String qry = null;
//		 if (category.equals(ActionConstant.SEARCHALL)) {
//			 qry = "select id,description,nooffloor,remarks,createdby,createdon,modifiedby,"
//			 		   + " modifiedon,version,active from pibs.file_building where active = true order by id limit " +limit+" offset "+offset; 			 
//		 } else {
//			 qry = "select id,description,nooffloor,remarks,createdby,createdon,modifiedby,"
//			 		   + " modifiedon,version,active from pibs.file_building where (description ilike '%"+criteria+"%' or remarks ilike '%"+criteria+"%') and active = true order by id limit " +limit+" offset "+offset;
//		 }
//
//	     JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//	 
//	     //List<Map<String,Object>> rsList = jdbcTemplate.queryForList(qry);
//	     
//	     List<Building> rsList = jdbcTemplate.query(qry, new RowMapper<Building>() {
//	    	 public Building mapRow(ResultSet rs, int rowNumber) throws SQLException{
//	    		  Building b=new Building();  
//		    	     b.setId(rs.getInt(1));
//		    	     b.setDescription(rs.getString(2));
//		    	     b.setNoOfFloor(rs.getInt(3));
//		    	     b.setRemarks(rs.getString(4));	    			  
//	    	      return b;  
//	    	 }
//	     });
//	     
//	     //get the total of records
//	     int  totalNoOfRecords = 0;
//	     if (category.equals(ActionConstant.SEARCHALL)) {
//	    	 totalNoOfRecords = jdbcTemplate.queryForInt("select count(*) from pibs.file_building where active = true");	 
//	     }else {
//	    	 totalNoOfRecords = jdbcTemplate.queryForInt("select count(*) from pibs.file_building where  (description ilike '%"+criteria+"%' or remarks ilike '%"+criteria+"%') and active = true");	 
//	     }
	     	     
//	     Map<String, Object> returnMap = null;
//	     
//	     if (rsList!=null && !rsList.isEmpty()) {
//	    	 returnMap = new HashMap<String, Object>();
//	    	 returnMap.put(MapConstant.CLASS_LIST, rsList);
//	    	 returnMap.put(MapConstant.PAGINATION_TOTALRECORDS, totalNoOfRecords);
//	     } 
	     
		return returnMap;
	}

	@Override
	public Map<String, Object> getDataById(HashMap<String, Object> criteriaMap)
			throws Exception {
		// TODO Auto-generated method stub
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_GETDATA_BY_ID);
		 
		    //get the model criteria
		    Building model = (Building) criteriaMap.get(MapConstant.CLASS_DATA);

		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
		     Map<String, Object> returnMap = null;
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();				
				 	sql.append("select id,description,nooffloor,remarks,createdby,createdon,modifiedby,modifiedon,version,active ");
				 	sql.append("from pibs.file_building ");
				 	sql.append("where id = ?");

				StringBuffer sqlLog = new StringBuffer();				
					 	sqlLog.append("select id,description,nooffloor,remarks,createdby,createdon,modifiedby,modifiedon,version,active ");
					 	sqlLog.append("from pibs.file_building ");
					 	sqlLog.append("where id = "+ model.getId());
				
				PIBSUtils.writeLogDebug(logger, "SQL: "+sqlLog.toString());
					
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, model.getId());
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
		    		 model.setId(rs.getInt(1));
		    		 model.setDescription(rs.getString(2));
		    		 model.setNoOfFloor(rs.getInt(3));
		    		 model.setRemarks(rs.getString(4));
				 }				 
			 } catch (SQLException e) {
				 throw e;
			 } finally {
				 PIBSUtils.closeObjects(rs);
				 PIBSUtils.closeObjects(pstmt);
				 PIBSUtils.closeObjects(conn);
			 }	 
		 		     
		     if (model!=null) {
		    	 returnMap = new HashMap<String, Object>();
		    	 returnMap.put(MapConstant.CLASS_DATA, model);
		     } 
			 
//		 //Using Spring JDBC
//		 //get the model criteria
//		 Building model = (Building) criteriaMap.get(MapConstant.CLASS_DATA);
//		
//		 StringBuffer qry = new StringBuffer();				
//			 qry.append("select id,description,nooffloor,remarks,createdby,createdon,modifiedby,modifiedon,version,active ");
//			 qry.append("from pibs.file_building ");
//			 qry.append("where id = ");
//			 qry.append(model.getId());
//
//
//	     JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//	 	     
//	     Building modelData = jdbcTemplate.query(qry.toString(), new ResultSetExtractor<Building>() {
//	    	public Building extractData(ResultSet rs) throws SQLException, DataAccessException {
//	    		Building b = new Building();  
//	    		  if(rs.next()) {
//	  	    		b.setId(rs.getInt(1));
//	    	        b.setDescription(rs.getString(2));
//	    	        b.setNoOfFloor(rs.getInt(3));
//	    	        b.setRemarks(rs.getString(4));	    			  
//	    		  }
//    	        return b;  
//	    	}
//	     });
	     
//	     Map<String, Object> returnMap = null;
//	     
//	     if (modelData!=null) {
//	    	 returnMap = new HashMap<String, Object>();
//	    	 returnMap.put(MapConstant.CLASS_DATA, modelData);
//	     } 
	     

		return returnMap;
	}

	@Override
	public Map<String, Object> getActiveData() throws Exception {
		// TODO Auto-generated method stub
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_GET_ACTIVE_DATA);
		 
		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
		     Map<String, Object> returnMap = null;
			 List<Building> rsList = new ArrayList<Building>();
			  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();				
				 	sql.append("select id,description,nooffloor,remarks,createdby,createdon,modifiedby,modifiedon,version,active ");
				 	sql.append("from pibs.file_building ");
				 	sql.append("where active = true ");
				 	sql.append("order by description");

				 StringBuffer sqlLog = new StringBuffer();				
				 	sqlLog.append("select id,description,nooffloor,remarks,createdby,createdon,modifiedby,modifiedon,version,active ");
				 	sqlLog.append("from pibs.file_building ");
				 	sqlLog.append("where active = true ");
				 	sqlLog.append("order by description");
			
				 PIBSUtils.writeLogDebug(logger, "SQL: "+sqlLog.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 rs = pstmt.executeQuery();


				  
				 while(rs.next()) {
					 //get the model criteria
					 Building model = new Building();
		    		 model.setId(rs.getInt(1));
		    		 model.setDescription(rs.getString(2));
		    		 model.setNoOfFloor(rs.getInt(3));
		    		 model.setRemarks(rs.getString(4));
		    		 rsList.add(model);
				 }				 
			 } catch (SQLException e) {
				 throw e;
			 } finally {
				 PIBSUtils.closeObjects(rs);
				 PIBSUtils.closeObjects(pstmt);
				 PIBSUtils.closeObjects(conn);
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
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_GET_INACTIVE_DATA);
		
		 //get the pagination and offset
		 int offset = (int) criteriaMap.get(MapConstant.PAGINATION_OFFSET);
		 int limit = (int) criteriaMap.get(MapConstant.PAGINATION_LIMIT);
		 
		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
		     Map<String, Object> returnMap = null;
			 List<Building> rsList = new ArrayList<>();
			  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();				
				 	sql.append("select id,description,nooffloor,remarks,createdby,createdon,modifiedby,modifiedon,version,active ");
				 	sql.append(" from pibs.file_building ");
				 	sql.append(" where active = false ");
				 	sql.append(" order by description ");
				 	sql.append(" limit ? ");
				 	sql.append(" offset ? ");
			
				 PIBSUtils.writeLogDebug(logger, "SQL: "+sql.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 pstmt.setInt(1, limit);
				 pstmt.setInt(2, offset);
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
					 //get the model criteria
					 Building model = new Building();
		    		 model.setId(rs.getInt(1));
		    		 model.setDescription(rs.getString(2));
		    		 model.setNoOfFloor(rs.getInt(3));
		    		 model.setRemarks(rs.getString(4));
		    		 rsList.add(model);
				 }				 
			 } catch (SQLException e) {
				 throw e;
			 } finally {
				 PIBSUtils.closeObjects(rs);
				 PIBSUtils.closeObjects(pstmt);
				 PIBSUtils.closeObjects(conn);
			 }	 
			 
		     //get the total of records
		     int  totalNoOfRecords = 0;
		     StringBuffer sqlCount = null;
			 
		     try {
		    	 conn = ServerContext.getJDBCHandle();
		    	 
			    sqlCount = new StringBuffer("select count(*) from pibs.file_building where active = false");	 
	
				PIBSUtils.writeLogDebug(logger, "SQL: "+sqlCount.toString());
				
		    	 pstmt = conn.prepareStatement(sqlCount.toString());
		    	 
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
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_RESTORE);

		//DBCP JNDI
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean status = false;
		
		Building model = (Building) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update pibs.file_building set ");	
			qry.append(" active=true ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");

			PIBSUtils.writeLogDebug(logger, "SQL: "+qry.toString());
	
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
				System.out.println("Room Category record (id: " +model.getId()+") restored successfully..");
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

	
}
