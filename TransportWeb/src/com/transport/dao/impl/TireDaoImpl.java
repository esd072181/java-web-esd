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
import com.transport.dao.TireDao;
import com.transport.model.Tire;
import com.transport.model.User;
import com.transport.util.TransportUtils;

/**
 * 
 * @author dward
 * @since 21Aug2016
 */
public class TireDaoImpl implements TireDao {
	
	private final static Logger logger = Logger.getLogger(TireDaoImpl.class);

	@Override
	public Map<String, Object> save(HashMap<String, Object> dataMap) throws Exception{
		
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SAVE);
		
		//DBCP JNDI
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean status = false;
		
		Tire model = (Tire) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setCreatedBy((int) user.getId());	
		}
		model.setCreatedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("insert into transport.file_tire (");
				qry.append("brandid ");
		  		qry.append(",serialno ");
		  		qry.append(",recapno ");
		  		qry.append(",sizeandply ");
		  		qry.append(",datepurchased ");
		  		qry.append(",retired ");
		  		qry.append(",dateretired ");
		  		qry.append(",bodyno ");
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

		StringBuffer qryLog =  new StringBuffer("insert into transport.file_tire (");
				qryLog.append("brandid ");		
				qryLog.append(",serialno ");
				qryLog.append(",recapno ");
				qryLog.append(",sizeandply ");
				qryLog.append(",datepurchased ");
				qryLog.append(",retired ");
				qryLog.append(",dateretired ");
				qryLog.append(",bodyno ");
				qryLog.append(",createdby ");
				qryLog.append(",createdon ");
				qryLog.append(",version ");
				qryLog.append(",active ");
				qryLog.append(") ");
				qryLog.append(" values ");
				qryLog.append("( ");
				qryLog.append(model.getBrandId());
				qryLog.append(",");
				qryLog.append(model.getSerialNo());
				qryLog.append(",");
				qryLog.append(model.getRecapNo());
				qryLog.append(",");
				qryLog.append(model.getSizeAndPly());
				qryLog.append(",");
				qryLog.append(model.getDatePurchased());
				qryLog.append(",");
				qryLog.append(model.getRetired());
				qryLog.append(",");
				qryLog.append(model.getDateRetired());
				qryLog.append(",");
				qryLog.append(model.getBodyNo());
				qryLog.append(",");
				qryLog.append(model.getCreatedBy());
				qryLog.append(",");
				qryLog.append(model.getCreatedOn());
				qryLog.append(",1 ");
				qryLog.append(",true ");
				qryLog.append(") ");
					
		TransportUtils.writeLogDebug(logger, "SQL: "+qryLog.toString());
  		  		
		  try {
			  conn = ServerContext.getJDBCHandle();
			  conn.setAutoCommit(false);
			  pstmt = conn.prepareStatement(qry.toString());
			     
			  pstmt.setInt(1, model.getBrandId());
			  pstmt.setString(2, model.getSerialNo());
			  pstmt.setString(3, model.getRecapNo());
			  pstmt.setString(4, model.getSizeAndPly());
			  pstmt.setDate(5, model.getDatePurchased());
			  pstmt.setString(6, model.getRetired());
			  pstmt.setDate(7, model.getDateRetired());
			  pstmt.setString(8, model.getBodyNo());
			  pstmt.setInt(9, model.getCreatedBy());
			  pstmt.setTimestamp(10, model.getCreatedOn());
			     
			  int statusInt = pstmt.executeUpdate();
			     
			  if (statusInt == 1) {
				  conn.commit();
				  System.out.println("Inserted into Tire table successfully..");
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
		
		Tire model = (Tire) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update transport.file_tire set ");	
			qry.append(" brandid=? ");
			qry.append(" ,serialno=? ");
			qry.append(" ,recapno=? ");
			qry.append(" ,sizeandply=? ");
			qry.append(" ,datepurchased=? ");
			qry.append(" ,retired=? ");
			qry.append(" ,dateretired=? ");
			qry.append(" ,bodyno=? ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");

		StringBuffer qryLog =  new StringBuffer("update transport.file_tire set ");	
			qryLog.append(" brandid=");
			qryLog.append(model.getBrandId());
			qryLog.append(" ,serialno=");
			qryLog.append(model.getSerialNo());
			qryLog.append(" ,recapno=");
			qryLog.append(model.getRecapNo());
			qryLog.append(" ,sizeandply=");
			qryLog.append(model.getSizeAndPly());
			qryLog.append(" ,datepurchased=");
			qryLog.append(model.getDatePurchased());
			qryLog.append(" ,retired=");
			qryLog.append(model.getRetired());
			qryLog.append(" ,dateretired=");
			qryLog.append(model.getDateRetired());
			qryLog.append(" ,bodyno=");
			qryLog.append(model.getBodyNo());
			qryLog.append(" ,modifiedby=");
			qryLog.append(model.getModifiedBy());
			qryLog.append(" ,modifiedon=");
			qryLog.append(model.getModifiedOn());
			qryLog.append(" ,version=(version+1) ");
			qryLog.append(" where ");
			qryLog.append(" id = ");
			qryLog.append(model.getId());
			
		TransportUtils.writeLogDebug(logger, "SQL: "+qryLog.toString());
	
		 try {
			conn = ServerContext.getJDBCHandle();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(qry.toString());
				     
			pstmt.setInt(1, model.getBrandId());
			pstmt.setString(2, model.getSerialNo());
			pstmt.setString(3, model.getRecapNo());
			pstmt.setString(4, model.getSizeAndPly());
			pstmt.setDate(5, model.getDatePurchased());
			pstmt.setString(6, model.getRetired());
			pstmt.setDate(7, model.getDateRetired());
			pstmt.setString(8, model.getBodyNo());
			pstmt.setInt(9, model.getModifiedBy());
			pstmt.setTimestamp(10, model.getModifiedOn());
			pstmt.setLong(11, model.getId());
				     
			int statusInt = pstmt.executeUpdate();
				     
			if (statusInt == 1) {
				conn.commit();
				System.out.println("Tire record (id: " +model.getId()+") updated successfully..");
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
		
		Tire model = (Tire) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update transport.file_tire set ");	
			qry.append(" active=false ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");

		StringBuffer qryLog =  new StringBuffer("update transport.file_tire set ");	
			qryLog.append(" active=false ");
			qryLog.append(" ,modifiedby=");
			qryLog.append(model.getModifiedBy());
			qryLog.append(" ,modifiedon=");
			qryLog.append(model.getModifiedOn());
			qryLog.append(" ,version=(version+1) ");
			qryLog.append(" where ");
			qryLog.append(" id = ");
			qryLog.append(model.getId());
			
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
				System.out.println("Tire record (id: " +model.getId()+") deleted successfully..");
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
			 
			  List<Tire> rsList = new ArrayList<Tire>();
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = null;
				 if (category.equals(ActionConstant.SEARCHALL)) {
					 sql = new StringBuffer("select t.id,b.name as brand,t.serialno,t.recapno,t.sizeandply,t.datepurchased,t.retired,t.dateretired,t.bodyno,t.createdby,t.createdon,t.modifiedby,t.modifiedon,t.version,t.active ");
					 	sql.append(" from transport.file_tire t");
					 	sql.append(" inner join transport.file_tirebrand b");
					 	sql.append(" on t.brandid = b.id ");
					 	sql.append(" where t.active = true ");
					 	sql.append(" order by b.name,t.serialno ");
					 	sql.append(" limit ? ");
					 	sql.append(" offset ?");		 
				 } else {
					 sql = new StringBuffer("select t.id,b.name as brand,t.serialno,t.recapno,t.sizeandply,t.datepurchased,t.retired,t.dateretired,t.bodyno,t.createdby,t.createdon,t.modifiedby,t.modifiedon,t.version,t.active ");
					 	sql.append(" from transport.file_tire t");
					 	sql.append(" inner join transport.file_tirebrand b");
					 	sql.append(" on t.brandid = b.id ");
					 	sql.append(" where ");
					 	sql.append(" (t.serialno ilike ? or b.name ilike ? )");
					 	sql.append(" and t.active = true ");
					 	sql.append(" order by b.name,t.serialno ");
					 	sql.append(" limit ? ");
					 	sql.append(" offset ?");	
				 }


				StringBuffer sqlLog = null;
						 
				if (category.equals(ActionConstant.SEARCHALL)) {
					sqlLog = new StringBuffer("select t.id,b.name as brand,t.serialno,t.recapno,t.sizeandply,t.datepurchased,t.retired,t.dateretired,t.bodyno,t.createdby,t.createdon,t.modifiedby,t.modifiedon,t.version,t.active ");
							 sqlLog.append(" from transport.file_tire t");
							 sqlLog.append(" inner join transport.file_tirebrand b");
							 sqlLog.append(" on t.brandid = b.id ");
							 sqlLog.append(" where t.active = true ");
							 sqlLog.append(" order by b.name,t.serialno ");
							 sqlLog.append(" limit ");
							 sqlLog.append(limit);
							 sqlLog.append(" offset ");	
							 sqlLog.append(offset);		 
				} else {
					sqlLog = new StringBuffer("select t.id,b.name as brand,t.serialno,t.recapno,t.sizeandply,t.datepurchased,t.retired,t.dateretired,t.bodyno,t.createdby,t.createdon,t.modifiedby,t.modifiedon,t.version,t.active ");
						sqlLog.append(" from transport.file_tire t");
						sqlLog.append(" inner join transport.file_tirebrand b");
						sqlLog.append(" on t.brandid = b.id ");
						sqlLog.append(" where ");
						sqlLog.append(" (t.serialno ilike '%");
						sqlLog.append(criteria);
						sqlLog.append("%' or b.name ilike '%");
						sqlLog.append(criteria);
						sqlLog.append("%'" );
						sqlLog.append(" and t.active = true ");
						sqlLog.append(" order by b.name,t.serialno ");
						sqlLog.append(" limit ");
						sqlLog.append(limit);
						sqlLog.append(" offset ");	
						sqlLog.append(offset);		
				}
						 
				TransportUtils.writeLogDebug(logger, "SQL: "+sqlLog.toString());
					
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 if (category.equals(ActionConstant.SEARCHALL)) {
					 pstmt.setInt(1, limit);
					 pstmt.setInt(2, offset);
				 } else {
					 pstmt.setString(1, "%"+criteria+"%");
					 pstmt.setString(2, "%"+criteria+"%");
					 pstmt.setInt(3, limit);
					 pstmt.setInt(4, offset);
				 }

				 
				 rs = pstmt.executeQuery();
				 
				 while(rs.next()) {
					 Tire model=new Tire();  
		    		 model.setId(rs.getInt(1));
		    		 model.setBrandName(rs.getString(2));
		    		 model.setSerialNo(rs.getString(3));
		    		 model.setRecapNo(rs.getString(4));
		    		 model.setSizeAndPly(rs.getString(5));
		    		 model.setDatePurchased(rs.getDate(6));
		    		 model.setRetired(rs.getString(7));
		    		 model.setDateRetired(rs.getDate(8));
		    		 model.setBodyNo(rs.getString(9));
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
			    	 sqlCount = new StringBuffer("select count(*) from transport.file_tire where active = true");	 
			     }else {
			    	 sqlCount = new StringBuffer("select count(*) from transport.file_tire t inner join transport.file_tirebrand b on t.brandid = b.id where (b.name ilike '%"+criteria+"%' or t.serialno ilike '%"+criteria+"%') and t.active = true");	 
			     } 

				StringBuffer sqlCountLog = null;
				if (category.equals(ActionConstant.SEARCHALL)) {
					 sqlCountLog = new StringBuffer("select count(*) from transport.file_tire where active = true");	 
				}else {
					 sqlCountLog = new StringBuffer("select count(*) from transport.file_tire t inner join transport.file_tirebrand b on t.brandid = b.id where (b.name ilike '%"+criteria+"%' or t.serialno ilike '%"+criteria+"%') and t.active = true");	 
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
		    Tire model = (Tire) criteriaMap.get(MapConstant.CLASS_DATA);

		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
		     Map<String, Object> returnMap = null;
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();				
				 	 	sql.append("select t.id,t.brandid,t.serialno,t.recapno,t.sizeandply,t.datepurchased,t.retired,t.dateretired,t.bodyno,t.createdby,t.createdon,t.modifiedby,t.modifiedon,t.version,t.active ");
					 	sql.append(" from transport.file_tire t");
					 	sql.append(" where t.id = ?");		 

				 StringBuffer sqlLog = new StringBuffer();	
				 	sqlLog.append("select t.id,t.brandid,t.serialno,t.recapno,t.sizeandply,t.datepurchased,t.retired,t.dateretired,t.bodyno,t.createdby,t.createdon,t.modifiedby,t.modifiedon,t.version,t.active ");
				 	sqlLog.append(" from transport.file_tire t");
				 	sqlLog.append("where t.id = ");
				 	sqlLog.append(model.getId());
			
				 TransportUtils.writeLogDebug(logger, "SQL: "+sqlLog.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, model.getId());
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
		    		 model.setId(rs.getInt(1));
		    		 model.setBrandId(rs.getInt(2));
		    		 model.setSerialNo(rs.getString(3));
		    		 model.setRecapNo(rs.getString(4));
		    		 model.setSizeAndPly(rs.getString(5));
		    		 model.setDatePurchased(rs.getDate(6));
		    		 model.setRetired(rs.getString(7));
		    		 model.setDateRetired(rs.getDate(8));
		    		 model.setBodyNo(rs.getString(9));
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
			 List<Tire> rsList = new ArrayList<Tire>();
			  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();				
				 	sql.append("select t.id,b.name as brand,t.serialno,t.recapno,t.sizeandply,t.datepurchased,t.retired,t.dateretired,t.bodyno,t.createdby,t.createdon,t.modifiedby,t.modifiedon,t.version,t.active ");
				 	sql.append(" from transport.file_tire t");
				 	sql.append(" inner join transport.file_tirebrand b");
				 	sql.append(" on t.brandid = b.id ");
				 	sql.append(" where t.active = true ");
				 	sql.append(" order by b.name,t.serialno ");

				 StringBuffer sqlLog = new StringBuffer();				
				 	sqlLog.append("select t.id,b.name as brand,t.serialno,t.recapno,t.sizeandply,t.datepurchased,t.retired,t.dateretired,t.bodyno,t.createdby,t.createdon,t.modifiedby,t.modifiedon,t.version,t.active ");
				 	sqlLog.append(" from transport.file_tire t");
				 	sqlLog.append(" inner join transport.file_tirebrand b");
				 	sqlLog.append(" on t.brandid = b.id ");
				 	sqlLog.append(" where t.active = true ");
				 	sqlLog.append(" order by b.name,t.serialno ");
			
				 TransportUtils.writeLogDebug(logger, "SQL: "+sqlLog.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 rs = pstmt.executeQuery();
				 
				 while(rs.next()) {
					 //get the model criteria
					 Tire model = new Tire();
					 model.setId(rs.getInt(1));
		    		 model.setBrandName(rs.getString(2));
		    		 model.setSerialNo(rs.getString(3));
		    		 model.setRecapNo(rs.getString(4));
		    		 model.setSizeAndPly(rs.getString(5));
		    		 model.setDatePurchased(rs.getDate(6));
		    		 model.setRetired(rs.getString(7));
		    		 model.setDateRetired(rs.getDate(8));
		    		 model.setBodyNo(rs.getString(9));
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
			 List<Tire> rsList = new ArrayList<Tire>();
			  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();				
				 	sql.append("select t.id,b.name as brand,t.serialno,t.recapno,t.sizeandply,t.datepurchased,t.retired,t.dateretired,t.bodyno,t.createdby,t.createdon,t.modifiedby,t.modifiedon,t.version,t.active ");
				 	sql.append(" from transport.file_tire t");
				 	sql.append(" inner join transport.file_tirebrand b");
				 	sql.append(" on t.brandid = b.id ");
				 	sql.append(" where t.active = false ");
				 	sql.append(" order by b.name,t.serialno ");
				 	sql.append(" limit ? ");
				 	sql.append(" offset ? ");

				 StringBuffer sqlLog = new StringBuffer();				
				 	sqlLog.append("select t.id,b.name as brand,t.serialno,t.recapno,t.sizeandply,t.datepurchased,t.retired,t.dateretired,t.bodyno,t.createdby,t.createdon,t.modifiedby,t.modifiedon,t.version,t.active ");
				 	sqlLog.append(" from transport.file_tire t");
				 	sqlLog.append(" inner join transport.file_tirebrand b");
				 	sqlLog.append(" on t.brandid = b.id ");
				 	sqlLog.append(" where t.active = false ");
				 	sqlLog.append(" order by b.name,t.serialno ");
				 	sqlLog.append(" limit ");
				 	sqlLog.append(limit);
				 	sqlLog.append(" offset ");
				 	sqlLog.append(offset);
			
				 TransportUtils.writeLogDebug(logger, "SQL: "+sqlLog.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, limit);
				 pstmt.setInt(2, offset);
				 
				 rs = pstmt.executeQuery();
 
				 while(rs.next()) {
					 //get the model criteria
					 Tire model = new Tire();
					 model.setId(rs.getInt(1));
		    		 model.setBrandName(rs.getString(2));
		    		 model.setSerialNo(rs.getString(3));
		    		 model.setRecapNo(rs.getString(4));
		    		 model.setSizeAndPly(rs.getString(5));
		    		 model.setDatePurchased(rs.getDate(6));
		    		 model.setRetired(rs.getString(7));
		    		 model.setDateRetired(rs.getDate(8));
		    		 model.setBodyNo(rs.getString(9));
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
		    	 
			    sqlCount = new StringBuffer("select count(*) from transport.file_tire where active = false");	 
				
			    StringBuffer sqlCountLog = new StringBuffer("select count(*) from transport.file_tire where active = false");	 
					
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
		
		Tire model = (Tire) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update transport.file_tire set ");	
			qry.append(" active=true ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");

		StringBuffer qryLog =  new StringBuffer("update transport.file_tire set ");	
			qryLog.append(" active=true ");
			qryLog.append(" ,modifiedby="+model.getModifiedBy());
			qryLog.append(" ,modifiedon="+model.getModifiedOn());
			qryLog.append(" ,version=(version+1) ");
			qryLog.append(" where ");
			qryLog.append(" id = ");
			qryLog.append(model.getId());
			
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
				System.out.println("Tire record (id: " +model.getId()+") restored successfully..");
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
