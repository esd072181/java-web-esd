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
import com.transport.dao.CorrectionsDao;
import com.transport.model.Corrections;
import com.transport.model.User;
import com.transport.util.TransportUtils;

public class CorrectionsDaoImpl implements CorrectionsDao {
	
	private final static Logger logger = Logger.getLogger(CorrectionsDaoImpl.class);

	
	
	//sample code only for this datasource
	//not used anymore
//	private DataSource dataSource;
//	     
//	public DataSource getDataSource() {
//		return dataSource;
//	}
//
//	public void setDataSource(DataSource dataSource) {
//		this.dataSource = dataSource;
//	}
	
	@Override
	public Map<String, Object> save(HashMap<String, Object> dataMap) throws Exception{
		
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SAVE);
		
		//START sample code for springJDBCTemplate
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
		//END - Sample code for SpringJDBCTemplate
		
		
		//DBCP JNDI
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean status = false;
		
		Corrections model = (Corrections) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setCreatedBy((int) user.getId());	
		}
		model.setCreatedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("insert into transport.file_corrections (");
		  		qry.append("description ");
		  		qry.append(",createdby ");
		  		qry.append(",createdon ");
		  		qry.append(",version ");
		  		qry.append(",active ");
		  		qry.append(",rootcauseid ");
		  		qry.append(" ) ");
		  		qry.append(" values ");
		  		qry.append(" ( ");
		  		qry.append(" ? ");
		  		qry.append(" ,? ");
		  		qry.append(" ,? ");
		  		qry.append(" ,1 ");
		  		qry.append(" ,true ");
		  		qry.append(" ,? ");
		  		qry.append(" ) ");

		StringBuffer qryLog =  new StringBuffer("insert into transport.file_corrections (");
				qryLog.append("description ");
				qryLog.append(",createdby ");
				qryLog.append(",createdon ");
				qryLog.append(",version ");
				qryLog.append(",active ");
				qryLog.append(",rootcauseid ");
				qryLog.append(" ) ");
				qryLog.append(" values ");
				qryLog.append(" ( ");
				qryLog.append(model.getDescription());
				qryLog.append(" ,"+model.getCreatedBy());
				qryLog.append(" ,"+model.getCreatedOn());
				qryLog.append(" ,1 ");
				qryLog.append(" ,true ");
				qryLog.append(" ,"+model.getRootCauseId());
				qryLog.append(" ) ");
					
		TransportUtils.writeLogDebug(logger, "SQL: "+qryLog.toString());
  		  		
		  try {
			  conn = ServerContext.getJDBCHandle();
			  conn.setAutoCommit(false);
			  pstmt = conn.prepareStatement(qry.toString());
			     
			  pstmt.setString(1, model.getDescription());
			  pstmt.setInt(2, model.getCreatedBy());
			  pstmt.setTimestamp(3, model.getCreatedOn());
			  pstmt.setInt(4, model.getRootCauseId());
			     
			  int statusInt = pstmt.executeUpdate();
			     
			  if (statusInt == 1) {
				  conn.commit();
				  System.out.println("Inserted into Corrections table successfully..");
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
		
		Corrections model = (Corrections) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update transport.file_corrections set ");	
			qry.append(" description=? ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" ,rootcauseid=? ");
			qry.append(" where ");
			qry.append(" id = ? ");

		StringBuffer qryLog =  new StringBuffer("update transport.file_corrections set ");	
			qryLog.append(" description="+model.getDescription());
			qryLog.append(" ,modifiedby="+model.getModifiedBy());
			qryLog.append(" ,modifiedon="+model.getModifiedOn());
			qryLog.append(" ,version=(version+1) ");
			qryLog.append(" ,rootcauseid="+model.getRootCauseId());
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
			pstmt.setInt(4, model.getRootCauseId());
			pstmt.setLong(5, model.getId());
			
				     
			int statusInt = pstmt.executeUpdate();
				     
			if (statusInt == 1) {
				conn.commit();
				System.out.println("Corrections record (id: " +model.getId()+") updated successfully..");
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
		
		Corrections model = (Corrections) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update transport.file_corrections set ");	
			qry.append(" active=false ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");

		StringBuffer qryLog =  new StringBuffer("update transport.file_corrections set ");	
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
				System.out.println("Corrections record (id: " +model.getId()+") deleted successfully..");
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
			 
			  List<Corrections> rsList = new ArrayList<Corrections>();
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = null;
				 if (category.equals(ActionConstant.SEARCHALL)) {
					 sql = new StringBuffer("select a.id,a.description,b.id as rootcauseid, b.description as rootcause,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
					 	sql.append(" from transport.file_corrections a, transport.file_rootcause b ");
					 	sql.append(" where a.rootcauseid = b.id ");
					 	sql.append(" and a.active = true ");
					 	sql.append(" order by a.description ");
					 	sql.append(" limit ? ");
					 	sql.append(" offset ?");		 
				 } else {
					 sql = new StringBuffer("select a.id,a.description,b.id as rootcauseid, b.description as rootcause,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
					 	sql.append(" from transport.file_corrections a, transport.file_rootcause b ");
					 	sql.append(" where a.rootcauseid = b.id ");
					 	sql.append(" and ");
					 	sql.append(" (a.description ilike '%"+criteria+"%')" );
					 	sql.append(" and a.active = true ");
					 	sql.append(" order by a.description ");
					 	sql.append(" limit ? ");
					 	sql.append(" offset ?");	
				 }


				StringBuffer sqlLog = null;
						 
				if (category.equals(ActionConstant.SEARCHALL)) {
							 sqlLog = new StringBuffer("select a.id,a.description,b.id as rootcauseid, b.description as rootcause,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
							 sqlLog.append(" from transport.file_corrections a, transport.file_rootcause b ");
							 sqlLog.append(" where a.rootcauseid = b.id ");
							 sqlLog.append(" and a.active = true ");
							 sqlLog.append(" order by a.description ");
							 sqlLog.append(" limit "+limit);
							 sqlLog.append(" offset "+offset);		 
				} else {
							 sqlLog = new StringBuffer("select a.id,a.description,b.id as rootcauseid, b.description as rootcause,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
							 sqlLog.append(" from transport.file_corrections a, transport.file_rootcause b ");
							 sqlLog.append(" where a.rootcauseid = b.id ");
							 sqlLog.append(" and ");
							 sqlLog.append(" (a.description ilike '%"+criteria+"%')" );
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
					 Corrections model=new Corrections();  
		    		 model.setId(rs.getInt(1));
		    		 model.setDescription(rs.getString(2));
		    		 model.setRootCauseId(rs.getInt(3));
		    		 model.setRootCause(rs.getString(4));
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
			    	 sqlCount = new StringBuffer("select count(*) from transport.file_corrections where active = true");	 
			     }else {
			    	 sqlCount = new StringBuffer("select count(*) from transport.file_corrections where  (description ilike '%"+criteria+"%') and active = true");	 
			     } 

				StringBuffer sqlCountLog = null;
				if (category.equals(ActionConstant.SEARCHALL)) {
					 sqlCountLog = new StringBuffer("select count(*) from transport.file_corrections where active = true");	 
				}else {
					 sqlCountLog = new StringBuffer("select count(*) from transport.file_corrections where  (description ilike '%"+criteria+"%') and active = true");	 
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
	     
		//START Sample code for SpringJDBCTemplate
//			 //Using Spring JDBC
//			 //get the pagination and offset
//			 int offset = (int) criteriaMap.get(MapConstant.PAGINATION_OFFSET);
//			 int limit = (int) criteriaMap.get(MapConstant.PAGINATION_LIMIT);
//			 
//			 //get the category
//			 String category = (String) criteriaMap.get(MapConstant.ACTION);
//			 String criteria = (String) criteriaMap.get(MapConstant.SEARCH_CRITERIA);
//			 
//			 String qry = null;
//			 if (category.equals(ActionConstant.SEARCHALL)) {
//				 qry = "select id,description,nooffloor,remarks,createdby,createdon,modifiedby,"
//				 		   + " modifiedon,version,active from pibs.file_building where active = true order by id limit " +limit+" offset "+offset; 			 
//			 } else {
//				 qry = "select id,description,nooffloor,remarks,createdby,createdon,modifiedby,"
//				 		   + " modifiedon,version,active from pibs.file_building where (description ilike '%"+criteria+"%' or remarks ilike '%"+criteria+"%') and active = true order by id limit " +limit+" offset "+offset;
//			 }
	//
//		     JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//		 
//		     //List<Map<String,Object>> rsList = jdbcTemplate.queryForList(qry);
//		     
//		     List<Building> rsList = jdbcTemplate.query(qry, new RowMapper<Building>() {
//		    	 public Building mapRow(ResultSet rs, int rowNumber) throws SQLException{
//		    		  Building b=new Building();  
//			    	     b.setId(rs.getInt(1));
//			    	     b.setDescription(rs.getString(2));
//			    	     b.setNoOfFloor(rs.getInt(3));
//			    	     b.setRemarks(rs.getString(4));	    			  
//		    	      return b;  
//		    	 }
//		     });
//		     
//		     //get the total of records
//		     int  totalNoOfRecords = 0;
//		     if (category.equals(ActionConstant.SEARCHALL)) {
//		    	 totalNoOfRecords = jdbcTemplate.queryForInt("select count(*) from pibs.file_building where active = true");	 
//		     }else {
//		    	 totalNoOfRecords = jdbcTemplate.queryForInt("select count(*) from pibs.file_building where  (description ilike '%"+criteria+"%' or remarks ilike '%"+criteria+"%') and active = true");	 
//		     }
		     	     
//		     Map<String, Object> returnMap = null;
//		     
//		     if (rsList!=null && !rsList.isEmpty()) {
//		    	 returnMap = new HashMap<String, Object>();
//		    	 returnMap.put(MapConstant.CLASS_LIST, rsList);
//		    	 returnMap.put(MapConstant.PAGINATION_TOTALRECORDS, totalNoOfRecords);
//		     } 
		     //END Sample code for SpringJDBCTemplate
		     
	    System.out.println("search() - Exit");
		return returnMap;
	}

	@Override
	public Map<String, Object> getDataById(HashMap<String, Object> criteriaMap)
			throws Exception {
		// TODO Auto-generated method stub
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_GETDATA_BY_ID);
		 
		    //get the model criteria
		    Corrections model = (Corrections) criteriaMap.get(MapConstant.CLASS_DATA);

		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
		     Map<String, Object> returnMap = null;
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();				
				 	sql.append("select a.id,a.description,b.id as rootcauseid, b.description as rootcause,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
				 	sql.append("from transport.file_corrections a, transport.file_rootcause b ");
				 	sql.append("where a.rootcauseid = b.id ");
				 	sql.append("and a.id = ?");
				 	
				 StringBuffer sqlLog = new StringBuffer();				
				 	sqlLog.append("select a.id,a.description,b.id as rootcauseid, b.description as rootcause,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
				 	sqlLog.append("from transport.file_corrections a, transport.file_rootcause b ");
				 	sqlLog.append("where a.rootcauseid = b.id ");
				 	sqlLog.append("and a.id = "+ model.getId());
			
				 TransportUtils.writeLogDebug(logger, "SQL: "+sqlLog.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, model.getId());
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
		    		 model.setId(rs.getInt(1));
		    		 model.setDescription(rs.getString(2));
		    		 model.setRootCauseId(rs.getInt(3));
		    		 model.setRootCause(rs.getString(4));
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
	     
		     
//			 //START Sample code for SpringJDBCTemplate
//			 //get the model criteria
//			 Building model = (Building) criteriaMap.get(MapConstant.CLASS_DATA);
//			
//			 StringBuffer qry = new StringBuffer();				
//				 qry.append("select id,description,nooffloor,remarks,createdby,createdon,modifiedby,modifiedon,version,active ");
//				 qry.append("from pibs.file_building ");
//				 qry.append("where id = ");
//				 qry.append(model.getId());
	//
	//
//		     JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//		 	     
//		     Building modelData = jdbcTemplate.query(qry.toString(), new ResultSetExtractor<Building>() {
//		    	public Building extractData(ResultSet rs) throws SQLException, DataAccessException {
//		    		Building b = new Building();  
//		    		  if(rs.next()) {
//		  	    		b.setId(rs.getInt(1));
//		    	        b.setDescription(rs.getString(2));
//		    	        b.setNoOfFloor(rs.getInt(3));
//		    	        b.setRemarks(rs.getString(4));	    			  
//		    		  }
//	    	        return b;  
//		    	}
//		     });
		     
//		     Map<String, Object> returnMap = null;
//		     
//		     if (modelData!=null) {
//		    	 returnMap = new HashMap<String, Object>();
//		    	 returnMap.put(MapConstant.CLASS_DATA, modelData);
//		     } 
		     //END Sample code for SpringJDBCTemplate
		     
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
			 List<Corrections> rsList = new ArrayList<Corrections>();
			  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();				
				 	sql.append("select a.id,a.description,b.id as rootcauseid, b.description as rootcause,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
				 	sql.append("from transport.file_corrections a, transport.file_rootcause b ");
				 	sql.append("where a.rootcauseid = b.id ");
				 	sql.append("and a.active = true ");
				 	sql.append("order by a.description");

				 StringBuffer sqlLog = new StringBuffer();				
				 	sqlLog.append("select a.id,a.description,b.id as rootcauseid, b.description as rootcause,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
				 	sqlLog.append("from transport.file_corrections a, transport.file_rootcause b ");
				 	sqlLog.append("where a.rootcauseid = b.id ");
				 	sqlLog.append("and a.active = true ");
				 	sqlLog.append("order by a.description");
			
				 TransportUtils.writeLogDebug(logger, "SQL: "+sqlLog.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 rs = pstmt.executeQuery();


				  
				 while(rs.next()) {
					 //get the model criteria
					 Corrections model = new Corrections();
		    		 model.setId(rs.getInt(1));
		    		 model.setDescription(rs.getString(2));
		    		 model.setRootCauseId(rs.getInt(3));
		    		 model.setRootCause(rs.getString(4));
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
			 List<Corrections> rsList = new ArrayList<Corrections>();
			  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();				
				 	sql.append("select a.id,a.description,b.id as rootcauseid, b.description as rootcause,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
				 	sql.append("from transport.file_corrections a, transport.file_rootcause b ");
				 	sql.append("where a.rootcauseid = b.id ");
				 	sql.append("and a.active = false ");
				 	sql.append("order by a.description ");
				 	sql.append("limit ? ");
				 	sql.append("offset ? ");
				 	
				 StringBuffer sqlLog = new StringBuffer();				
				 	sqlLog.append("select a.id,a.description,b.id as rootcauseid, b.description as rootcause,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
				 	sqlLog.append("from transport.file_corrections a, trnsport.transport.file_rootcause b ");
				 	sqlLog.append("where a.rootcauseid = b.id ");
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
					 Corrections model = new Corrections();
		    		 model.setId(rs.getInt(1));
		    		 model.setDescription(rs.getString(2));
		    		 model.setRootCauseId(rs.getInt(3));
		    		 model.setRootCause(rs.getString(4));
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
		    	 
			    sqlCount = new StringBuffer("select count(*) from transport.file_corrections where active = false");	 

				StringBuffer sqlCountLog = null;
				sqlCountLog = new StringBuffer("select count(*) from transport.file_corrections where active = false");	 

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
		
		Corrections model = (Corrections) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update transport.file_corrections set ");	
			qry.append(" active=true ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");

		StringBuffer qryLog =  new StringBuffer("update transport.file_corrections set ");	
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
				System.out.println("Corrections record (id: " +model.getId()+") restored successfully..");
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
	public Map<String, Object> getNoClosureData() throws Exception {
		// TODO Auto-generated method stub
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_GET_ACTIVE_DATA);
		 
		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
		     Map<String, Object> returnMap = null;
			 List<Corrections> rsList = new ArrayList<Corrections>();
			  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();				
				 	sql.append("select id,description,createdby,createdon,modifiedby,modifiedon,version,active ");
				 	sql.append("from transport.file_corrections ");
				 	sql.append("where active = true ");
				 	sql.append("and id not in (select a.id from transport.file_corrections a, transport.file_closure b where a.id = b.correctionsid) ");
				 	sql.append("order by description");

				 StringBuffer sqlLog = new StringBuffer();				
				 	sqlLog.append("select id,description,createdby,createdon,modifiedby,modifiedon,version,active ");
				 	sqlLog.append("from transport.file_corrections ");
				 	sqlLog.append("where active = true ");
				 	sqlLog.append("and id not in (select a.id from transport.file_corrections a, transport.file_closure b where a.id = b.correctionsid) ");
				 	sqlLog.append("order by description");
			
				 TransportUtils.writeLogDebug(logger, "SQL: "+sqlLog.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 rs = pstmt.executeQuery();


				  
				 while(rs.next()) {
					 //get the model criteria
					 Corrections model = new Corrections();
		    		 model.setId(rs.getInt(1));
		    		 model.setDescription(rs.getString(2));
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
	
	//Transport Revision 1 Dec2015
	@Override
	public Map<String, Object> getCorrectionsByRootCause(HashMap<String, Object> criteriaMap) throws Exception {
		// TODO Auto-generated method stub
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_GET_ACTIVE_DATA);
		 
		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
		     Map<String, Object> returnMap = null;
			 List<Corrections> rsList = new ArrayList<Corrections>();
			  
			 int entityId = (int) criteriaMap.get(MapConstant.FIELD_CRITERIA_ENTITY_ID);
			 
			 try {
				 conn = ServerContext.getJDBCHandle();
				 
				 
				 StringBuffer sql = new StringBuffer();				
				 	sql.append("select a.id,a.description,b.id as rootcauseid, b.description as rootcause,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
				 	sql.append("from transport.file_corrections a, transport.file_rootcause b ");
				 	sql.append("where a.rootcauseid = b.id ");
				 	sql.append("and a.active = true ");
				 	sql.append("and a.rootcauseid = ? ");
				 	sql.append("order by a.description");

				 StringBuffer sqlLog = new StringBuffer();				
				 	sqlLog.append("select a.id,a.description,b.id as rootcauseid, b.description as rootcause,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
				 	sqlLog.append("from transport.file_corrections a, transport.file_rootcause b ");
				 	sqlLog.append("where a.rootcauseid = b.id ");
				 	sqlLog.append("and a.active = true ");
				 	sqlLog.append("and a.rootcauseid = " + entityId + " ");
				 	sqlLog.append("order by a.description");
				 
			
				 TransportUtils.writeLogDebug(logger, "SQL: "+sqlLog.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, entityId);
				 
				 rs = pstmt.executeQuery();
				 
				 while(rs.next()) {					
					 //get the model criteria
					 Corrections model = new Corrections();
		    		 model.setId(rs.getInt(1));
		    		 model.setDescription(rs.getString(2));
		    		 model.setRootCauseId(rs.getInt(3));
		    		 model.setRootCause(rs.getString(4));
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
