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
import com.pibs.dao.MonitorRoomDao;
import com.pibs.model.MonitorRoom;
import com.pibs.model.User;
import com.pibs.util.PIBSUtils;

public class MonitorRoomDaoImpl implements MonitorRoomDao {
	
	private final static Logger logger = Logger.getLogger(MonitorRoomDaoImpl.class);

	@Override
	public Map<String, Object> save(HashMap<String, Object> dataMap) throws Exception{
		
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SAVE);
		
		//DBCP JNDI
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean status = false;
		
		MonitorRoom model = (MonitorRoom) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setCreatedBy((int) user.getId());	
		}
		model.setCreatedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("insert into pibs.tran_patient_room (");  		
				qry.append("patientcasesystemid ");
				qry.append(",roomid ");
				qry.append(",days ");
		  		qry.append(",fee ");
		  		qry.append(",amount ");
		  		qry.append(",dateused ");
		  		qry.append(",timeused ");
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
		  		qry.append(" ,1 ");
		  		qry.append(" ,true ");
		  		qry.append(" ) ");
					
		PIBSUtils.writeLogDebug(logger, "SQL: "+qry.toString());
  		  		
		  try {
			  conn = ServerContext.getJDBCHandle();
			  conn.setAutoCommit(false);
			  pstmt = conn.prepareStatement(qry.toString());
			     
			  pstmt.setInt(1, model.getPatientCaseSystemId());
			  pstmt.setInt(2, model.getRoomId());
			  pstmt.setInt(3, model.getDays());
			  pstmt.setBigDecimal(4, model.getFee());
			  pstmt.setBigDecimal(5, model.getAmount());
			  pstmt.setDate(6, model.getDateUsed());
			  pstmt.setString(7, model.getTimeUsed());
			  pstmt.setInt(8, model.getCreatedBy());
			  pstmt.setTimestamp(9, model.getCreatedOn());
			     
			  int statusInt = pstmt.executeUpdate();
			     
			  if (statusInt == 1) {
				  conn.commit();
				  System.out.println("Inserted into Monitor Room is table successfully..");
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
	public Map<String, Object> update(HashMap<String, Object> dataMap) throws Exception{
		// TODO Auto-generated method stub
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_UPDATE);
		 
		//DBCP JNDI
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean status = false;
		
		MonitorRoom model = (MonitorRoom) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update pibs.tran_patient_room set ");	
			qry.append(" roomid=? ");
			qry.append(" ,days=? ");
			qry.append(" ,fee=? ");
			qry.append(" ,amount=? ");
			qry.append(" ,dateused=? ");
			qry.append(" ,timeused=? ");
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
				     
			pstmt.setInt(1, model.getRoomId());
			pstmt.setInt(2, model.getDays());
			pstmt.setBigDecimal(3, model.getFee());
			pstmt.setBigDecimal(4, model.getAmount());
			pstmt.setDate(5, model.getDateUsed());
			pstmt.setString(6, model.getTimeUsed());
			pstmt.setInt(7, model.getModifiedBy());
			pstmt.setTimestamp(8, model.getModifiedOn());
			pstmt.setLong(9, model.getId());
				     
			int statusInt = pstmt.executeUpdate();
				     
			if (statusInt == 1) {
				conn.commit();
				System.out.println("Monitor Room record (id: " +model.getId()+") updated successfully..");
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
	public Map<String, Object> search(HashMap<String, Object> criteriaMap) throws Exception{
		 
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SEARCH);
		 
		 	Map<String, Object> returnMap = null;

		 	MonitorRoom modelCriteria = (MonitorRoom) criteriaMap.get(MapConstant.CLASS_DATA);
		 	
		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
			 
			 List<MonitorRoom> rsList = new ArrayList<MonitorRoom>();
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();
				 		sql.append("select a.id,a.patientcasesystemid,a.roomid,a.days,a.fee,a.amount,a.dateused,a.timeused,b.roomno as roomno,c.description as roomcategory,c.rate");
				 		sql.append(" from pibs.tran_patient_room a, pibs.file_room b, pibs.file_room_category c ");
					 	sql.append(" where a.roomid = b.id ");
					 	sql.append(" and b.roomcategoryid = c.id ");
				 		sql.append(" and a.patientcasesystemid = ? ");
				 		sql.append(" and a.active = true ");
					 	sql.append(" order by a.dateused ");
				 						 
				PIBSUtils.writeLogDebug(logger, "SQL: "+sql.toString());
					
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, modelCriteria.getPatientCaseSystemId());
				 
				 rs = pstmt.executeQuery();
				 
				 while(rs.next()) {
					 MonitorRoom model = new MonitorRoom();  
		    		 model.setId(rs.getInt(1));
		    		 model.setPatientCaseSystemId(rs.getInt(2));
		    		 model.setRoomId(rs.getInt(3));
		    		 model.setDays(rs.getInt(4));
		    		 model.setFee(rs.getBigDecimal(5));
		    		 model.setAmount(rs.getBigDecimal(6));
		    		 model.setDateUsed(rs.getDate(7));
		    		 model.setTimeUsed(rs.getString(8));
		    		 model.setRoomNo(rs.getString(9));
		    		 model.setRoomCategory(rs.getString(10));
		    		 model.setRate(rs.getBigDecimal(11));
		    		 
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
	     
	    System.out.println("search() - Exit");
		return returnMap;
	}

	
	@Override
	public Map<String, Object> getDataById(HashMap<String, Object> criteriaMap)
			throws Exception {
		// TODO Auto-generated method stub
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_GETDATA_BY_ID);
		 
		    //get the model criteria
		    MonitorRoom model = (MonitorRoom) criteriaMap.get(MapConstant.CLASS_DATA);

		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
		     Map<String, Object> returnMap = null;
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();				
			 		sql.append("select a.id,a.patientcasesystemid,a.roomid,a.days,a.fee,a.amount,a.dateused,a.timeused,b.roomno as roomno,c.description as roomcategory,c.rate");
			 		sql.append(" from pibs.tran_patient_room a, pibs.file_room b, pibs.file_room_category c ");
				 	sql.append(" where a.roomid = b.id ");
				 	sql.append(" and b.roomcategoryid = c.id ");
				 	sql.append(" and a.id = ?");
			
				 PIBSUtils.writeLogDebug(logger, "SQL: "+sql.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, model.getId());
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
		    		 model.setId(rs.getInt(1));
		    		 model.setPatientCaseSystemId(rs.getInt(2));
		    		 model.setRoomId(rs.getInt(3));
		    		 model.setDays(rs.getInt(4));
		    		 model.setFee(rs.getBigDecimal(5));
		    		 model.setAmount(rs.getBigDecimal(6));
		    		 model.setDateUsed(rs.getDate(7));
		    		 model.setTimeUsed(rs.getString(8));
		    		 model.setRoomNo(rs.getString(9));
		    		 model.setRoomCategory(rs.getString(10));
		    		 model.setRate(rs.getBigDecimal(11));
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
	     
	    System.out.println("getDataById() - Exit");
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
		
		MonitorRoom model = (MonitorRoom) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update pibs.tran_patient_room set ");	
			qry.append(" active=false ");
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
				System.out.println("Monitor Room record (id: " +model.getId()+") deleted successfully..");
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
