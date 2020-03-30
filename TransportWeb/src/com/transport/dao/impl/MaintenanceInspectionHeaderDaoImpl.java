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
import com.transport.dao.MaintenanceInspectionHeaderDao;
import com.transport.model.InspectionHeader;
import com.transport.model.User;
import com.transport.util.TransportUtils;

/**
 * 
 * @author edwarddavid
 * @since 25Mar2020
 * DateUpdated: 30Mar2020
 */
public class MaintenanceInspectionHeaderDaoImpl implements MaintenanceInspectionHeaderDao {
	
	private final static Logger logger = Logger.getLogger(MaintenanceInspectionHeaderDaoImpl.class);

	@Override
	public Map<String, Object> save(HashMap<String, Object> dataMap) throws Exception{
		
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SAVE);
		
		//DBCP JNDI
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean status = false;
		
		InspectionHeader model = (InspectionHeader) dataMap.get(MapConstant.CLASS_DATA);
		
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setCreatedBy((int) user.getId());	
		}
		model.setCreatedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("insert into transport.tran_inspection_header (");
		  		qry.append("lorryno ");
		  		qry.append(",plateno ");
		  		qry.append(",odometer ");
		  		qry.append(",hubodometer ");
		  		qry.append(",inspectors ");
		  		qry.append(",forannual ");
		  		qry.append(",forpm ");
		  		qry.append(",inspectiondate ");
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
		  		qry.append(" ,? ");
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
			     
			  pstmt.setString(1, model.getLorryNo());
			  pstmt.setString(2, model.getPlateNo());
			  pstmt.setString(3, model.getOdometer());
			  pstmt.setString(4, model.getHubOdometer());
			  pstmt.setString(5, model.getInspectors());
			  pstmt.setString(6, model.getForAnnual());
			  pstmt.setString(7, model.getForPm());
			  pstmt.setDate(8, model.getInspectionDate());
			  pstmt.setString(9, model.getRemarks()); 
			  pstmt.setInt(10, model.getCreatedBy());
			  pstmt.setTimestamp(11, model.getCreatedOn());
			     
			  int statusInt = pstmt.executeUpdate();
			     
			  if (statusInt == 1) {	
				  conn.commit();
				  System.out.println("Inserted into Inspection Header table successfully.");
				  logger.debug("Inserted into Inspection Header table successfully.");
				  //get the latest header id and put in Map
				  int headerId = 0;
				  qry = null;
				  pstmt.close();
				  qry = new StringBuffer("select id from transport.tran_inspection_header order by id desc limit 1");
				  pstmt = conn.prepareStatement(qry.toString());
				  rs = pstmt.executeQuery();
				  if (rs.next()) {
					  headerId = rs.getInt(1);
				  }
				  returnMap.put(MapConstant.FIELD_CRITERIA_ENTITY_ID, headerId);
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
		
		InspectionHeader model = (InspectionHeader) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update transport.tran_inspection_header set ");	
			qry.append(" lorryno=? ");
			qry.append(" ,plateno=? ");
			qry.append(" ,odometer=? ");
			qry.append(" ,hubodometer=? ");
			qry.append(" ,inspectors=? ");
			qry.append(" ,forannual=? ");
			qry.append(" ,forpm=? ");
			qry.append(" ,inspectiondate=? ");
			qry.append(" ,remarks=? ");
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
				     
			pstmt.setString(1, model.getLorryNo());
			pstmt.setString(2, model.getPlateNo());
			pstmt.setString(3, model.getOdometer());
			pstmt.setString(4, model.getHubOdometer());
			pstmt.setString(5, model.getInspectors());
			pstmt.setString(6, model.getForAnnual());
			pstmt.setString(7, model.getForPm());
			pstmt.setDate(8, model.getInspectionDate());
			pstmt.setString(9, model.getRemarks());		
			pstmt.setInt(10, model.getModifiedBy());
			pstmt.setTimestamp(11, model.getModifiedOn());
			pstmt.setLong(12, model.getId());
				     
			int statusInt = pstmt.executeUpdate();
				     
			if (statusInt == 1) {
				conn.commit();
				System.out.println("Inspection Header record (id: " +model.getId()+") updated successfully..");
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
		
		InspectionHeader model = (InspectionHeader) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update transport.tran_inspection_header set ");	
			qry.append(" active=false ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");

		StringBuffer qryLog =  new StringBuffer("update transport.tran_inspection_header set ");	
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
				System.out.println("Inspection Header record (id: " +model.getId()+") deleted successfully..");
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
	public Map<String, Object> getDataById(HashMap<String, Object> criteriaMap)
			throws Exception {
		// TODO Auto-generated method stub
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_GETDATA_BY_ID);
		 
		    //get the model criteria
		    InspectionHeader model = (InspectionHeader) criteriaMap.get(MapConstant.CLASS_DATA);

		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
		     Map<String, Object> returnMap = null;
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer("select a.id,a.lorryno,a.plateno,a.odometer,a.hubodometer,a.inspectors,a.forannual,a.forpm,a.inspectiondate,a.remarks ");
				 	sql.append(" from transport.tran_inspection_header a ");
				 	sql.append(" where a.id = ?");

				 TransportUtils.writeLogDebug(logger, "SQL: "+sql.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, model.getId());
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
		    		 model.setId(rs.getInt(1));
		    		 model.setLorryNo(rs.getString(2));
		    		 model.setPlateNo(rs.getString(3));
		    		 model.setOdometer(rs.getString(4));
		    		 model.setHubOdometer(rs.getString(5));
		    		 model.setInspectors(rs.getString(6));
		    		 model.setForAnnual(rs.getString(7));
		    		 model.setForPm(rs.getString(8));
		    		 model.setInspectionDate(rs.getDate(9));
		    		 model.setRemarks(rs.getString(10));
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
		return null;
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
			 List<InspectionHeader> rsList = new ArrayList<InspectionHeader>();
			  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer("select a.id,a.lorryno,a.plateno,a.odometer,a.hubodometer,a.inspectors,a.forannual,a.forpm,a.inspectiondate,a.remarks ");
				 	sql.append(" from transport.tran_inspection_header a ");
				 	sql.append(" where a.active = false ");
				 	sql.append(" order by a.inspectiondate desc ");
				 	sql.append(" limit ? ");
				 	sql.append(" offset ? ");

			
				 TransportUtils.writeLogDebug(logger, "SQL: "+sql.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, limit);
				 pstmt.setInt(2, offset);
				 
				 rs = pstmt.executeQuery();
				 
				 while(rs.next()) {
					 InspectionHeader model=new InspectionHeader();  
		    		 model.setId(rs.getInt(1));
		    		 model.setLorryNo(rs.getString(2));
		    		 model.setPlateNo(rs.getString(3));
		    		 model.setOdometer(rs.getString(4));
		    		 model.setHubOdometer(rs.getString(5));
		    		 model.setInspectors(rs.getString(6));
		    		 model.setForAnnual(rs.getString(7));
		    		 model.setForPm(rs.getString(8));
		    		 model.setInspectionDate(rs.getDate(9));
		    		 model.setRemarks(rs.getString(10));
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
			 
		     try {
		    	 conn = ServerContext.getJDBCHandle();
		    	 
		    	 StringBuffer sqlCount = new StringBuffer("select count(*) from transport.tran_inspection_header where active = false");	 

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
		
		InspectionHeader model = (InspectionHeader) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update transport.tran_inspection_header set ");	
			qry.append(" active=true ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");

		StringBuffer qryLog =  new StringBuffer("update transport.tran_inspection_header set ");	
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
				System.out.println("Inspection Header record (id: " +model.getId()+") restored successfully..");
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
	public Map<String, Object> search(HashMap<String, Object> criteriaMap) throws Exception {
		 
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SEARCH);
		 
		 	Map<String, Object> returnMap = null;

		 	//Connection using JNDI DBCP
			 //get the pagination and offset
			 int offset = (int) criteriaMap.get(MapConstant.PAGINATION_OFFSET);
			 int limit = (int) criteriaMap.get(MapConstant.PAGINATION_LIMIT);
			 
			 //get the category
			 String category = (String) criteriaMap.get(MapConstant.ACTION);
			 String searchValue = (String) criteriaMap.get(MapConstant.SEARCH_VALUE);
			 
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
			 
			  List<InspectionHeader> rsList = new ArrayList<>();
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer("select a.id,a.lorryno,a.plateno,a.odometer,a.hubodometer,a.inspectors,a.forannual,a.forpm,a.inspectiondate,a.remarks ");
					 	sql.append(" from transport.tran_inspection_header a ");
					 	sql.append(" where a.active = true ");
					 	 if (category.equals(ActionConstant.SEARCHBY)) {
					 		sql.append(" and (a.lorryno ilike '%" + searchValue + "%' ");
					 		sql.append(" or a.plateno ilike '%" + searchValue + "%' ");
					 		sql.append(" or a.inspectors ilike '%" + searchValue + "%' ");
					 		sql.append(" or a.remarks ilike '%" + searchValue + "%') ");
					 	 }
					 	sql.append(" order by a.inspectiondate desc,a.lorryno ");
					 	sql.append(" limit ? ");
					 	sql.append(" offset ?");		 
				  
						 
				TransportUtils.writeLogDebug(logger, "SQL: "+sql.toString());
					
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, limit);
				 pstmt.setInt(2, offset);
				 
				 rs = pstmt.executeQuery();
				 
				 while(rs.next()) {
					 InspectionHeader model=new InspectionHeader();  
		    		 model.setId(rs.getInt(1));
		    		 model.setLorryNo(rs.getString(2));
		    		 model.setPlateNo(rs.getString(3));
		    		 model.setOdometer(rs.getString(4));
		    		 model.setHubOdometer(rs.getString(5));
		    		 model.setInspectors(rs.getString(6));
		    		 model.setForAnnual(rs.getString(7));
		    		 model.setForPm(rs.getString(8));
		    		 model.setInspectionDate(rs.getDate(9));
		    		 model.setRemarks(rs.getString(10));
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
		     
			 
		     try {
		    	 conn = ServerContext.getJDBCHandle();
		    	 
		    	 StringBuffer sqlCount = new StringBuffer("select count(*) from transport.tran_inspection_header a ");
		    	 	sqlCount.append(" where a.active = true ");
		    	 	if (category.equals(ActionConstant.SEARCHBY)) {
		    	 		sqlCount.append(" and (a.lorryno like '%" + searchValue + "%' ");
		    	 		sqlCount.append(" or a.plateno like '%" + searchValue + "%' ");
		    	 		sqlCount.append(" or a.inspectors like '%" + searchValue + "%' ");
		    	 		sqlCount.append(" or a.remarks like '%" + searchValue + "%') ");
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
	
		
}
