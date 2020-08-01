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
import com.transport.constant.MapConstant;
import com.transport.constant.MiscConstant;
import com.transport.dao.MaintenanceInspectionDetailsDao;
import com.transport.model.InspectionDetails;
import com.transport.model.InspectionHeader;
import com.transport.model.User;
import com.transport.util.TransportUtils;

/**
 * 
 * @author edwarddavid
 * @since 23Mar2020
 * DateUpdated: 01Aug2020
 */
public class MaintenanceInspectionDetailsDaoImpl implements MaintenanceInspectionDetailsDao {
	
	private final static Logger logger = Logger.getLogger(MaintenanceInspectionDetailsDaoImpl.class);

	@Override
	public Map<String, Object> save(HashMap<String, Object> dataMap) throws Exception{
		
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SAVE);
		
		//DBCP JNDI
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean status = false;
		
		@SuppressWarnings("unchecked")
		List<InspectionDetails> modelDetailsList = (List<InspectionDetails>) dataMap.get(MapConstant.CLASS_LIST);
		
		Integer headerId = (Integer) dataMap.get(MapConstant.FIELD_CRITERIA_ENTITY_ID);
		
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		int userId = 0;
		if (user!=null) {
			userId = user.getId();
		}
		
		StringBuffer qry =  new StringBuffer("insert into transport.tran_inspection_details (");
		  		qry.append("headerid ");
		  		qry.append(",inspectionid ");
		  		qry.append(",statusid ");
		  		qry.append(",remarks ");
		  		qry.append(",plandate ");
		  		qry.append(",actualdate ");
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
		  		qry.append(" ,1 ");
		  		qry.append(" ,true ");
		  		qry.append(" ) ");

		
		TransportUtils.writeLogDebug(logger, "SQL: "+qry.toString());
  		  		
		  try {
			  conn = ServerContext.getJDBCHandle();
			  conn.setAutoCommit(false);
			  pstmt = conn.prepareStatement(qry.toString());
			  
			  for (InspectionDetails item: modelDetailsList) {
				  pstmt.setInt(1, headerId);
				  pstmt.setInt(2, item.getInspectionId());
				  pstmt.setInt(3, item.getStatusId());
				  pstmt.setString(4, item.getRemarks());
				  pstmt.setDate(5, item.getPlanDate());
				  pstmt.setDate(6, item.getActualDate());
				  pstmt.setInt(7, userId);
				  pstmt.setTimestamp(8, new Timestamp(new java.util.Date().getTime()));
				     
				  int statusInt = pstmt.executeUpdate();
				     
				  if (statusInt == 1) {	
					  conn.commit();
					  status = true;
				  }				  
			  }
			     
			  if (status) {
				  System.out.println("Inserted into Inspection Details table successfully.");
				  logger.debug("Inserted into Inspection Details table successfully.");
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
		
		@SuppressWarnings("unchecked")
		List<InspectionDetails> modelDetailsList = (List<InspectionDetails>) dataMap.get(MapConstant.CLASS_LIST);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		int userId = 0;
		if (user!=null) {
			userId = user.getId();
		}
		
		StringBuffer qry =  new StringBuffer("update transport.tran_inspection_details set ");	
			qry.append(" statusid=? ");
			qry.append(" ,remarks=? ");
			qry.append(" ,plandate=? ");
			qry.append(" ,actualdate=? ");
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
				    
			for (InspectionDetails item: modelDetailsList) {
				  pstmt.setInt(1, item.getStatusId());
				  pstmt.setString(2, item.getRemarks());
				  pstmt.setDate(3, item.getPlanDate());
				  pstmt.setDate(4, item.getActualDate());
				  pstmt.setInt(5, userId);
				  pstmt.setTimestamp(6, new Timestamp(new java.util.Date().getTime()));
				  pstmt.setInt(7, item.getId());
				     
				  int statusInt = pstmt.executeUpdate();
				     
				  if (statusInt == 1) {	
					  conn.commit();
					  System.out.println("Inspection Details record (id: " +item.getId()+") updated successfully.");
					  status = true;
				  }				  
			  }
			     
		} catch (Exception e) {
			status = false;
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
		
		InspectionDetails model = (InspectionDetails) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update transport.tran_inspection_details set ");	
			qry.append(" active=false ");
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
				     
			pstmt.setInt(1, model.getModifiedBy());
			pstmt.setTimestamp(2, model.getModifiedOn());
			pstmt.setLong(3, model.getId());
				     
			int statusInt = pstmt.executeUpdate();
				     
			if (statusInt == 1) {
				conn.commit();
				System.out.println("Inspection Details record (id: " +model.getId()+") deleted successfully..");
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
	public Map<String, Object> getDataById(HashMap<String, Object> criteriaMap) throws Exception {
		// TODO Auto-generated method stub
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_GETDATA_BY_ID);
		 
		    //get the model criteria
		    InspectionHeader model = (InspectionHeader) criteriaMap.get(MapConstant.CLASS_DATA);

		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
		     Map<String, Object> returnMap = null;
		     
		     List<InspectionDetails> modelDetailsList = new ArrayList<>(); 
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer("select a.id,a.headerid,a.statusid,a.remarks, ");
				 	sql.append(" c.listvalue as maincategoryname,d.listvalue as categoryname, b.categoryno,b.itemno, ");
				 	sql.append(" b.subitemno,b.description,b.labelonly,b.sequenceorder,a.plandate,a.actualdate ");
				 	sql.append(" from transport.tran_inspection_details a, transport.file_inspection b, transport.list_value c, transport.list_value d ");
				 	sql.append(" where a.inspectionid = b.id ");
				 	sql.append(" and b.maincategoryid = c.id ");
				 	sql.append(" and b.categoryid = d.id ");
				 	sql.append(" and a.headerid = ? ");
				 	sql.append(" and a.active = true ");
				 	sql.append(" order by a.id ");

				 TransportUtils.writeLogDebug(logger, "SQL: "+sql.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, model.getId());
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
					 InspectionDetails modelDetail = new InspectionDetails();
					 modelDetail.setId(rs.getInt(1));
					 modelDetail.setHeaderId(rs.getInt(2));
					 modelDetail.setStatusId(rs.getInt(3));
		    		 modelDetail.setRemarks(rs.getString(4));
		    		 modelDetail.setMainCategoryName(rs.getString(5));
		    		 modelDetail.setCategoryName(rs.getString(6));
		    		 modelDetail.setCategoryNo(rs.getInt(7));
		    		 modelDetail.setItemNo(rs.getString(8));
		    		 modelDetail.setSubItemNo(rs.getString(9));
		    		 modelDetail.setDescription(rs.getString(10));
		    		 modelDetail.setLabelOnly(rs.getBoolean(11));
		    		 modelDetail.setSequenceOrder(rs.getInt(12));
		    		 modelDetail.setPlanDate(rs.getDate(13));
		    		 modelDetail.setActualDate(rs.getDate(14));
		    		 modelDetailsList.add(modelDetail);
				 }				 
				 
			 } catch (SQLException e) {
				 throw e;
			 } finally {
				 TransportUtils.closeObjects(rs);
				 TransportUtils.closeObjects(pstmt);
				 TransportUtils.closeObjects(conn);
			 }	 
		 		     
		     if (modelDetailsList!=null && modelDetailsList.size()>0) {
		    	 returnMap = new HashMap<String, Object>();
		    	 returnMap.put(MapConstant.CLASS_LIST, modelDetailsList);
		     } 
	     
	    System.out.println("getDataById() - Exit");
		return returnMap;
	}
	
}
