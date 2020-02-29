package com.transport.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.transport.config.ServerContext;
import com.transport.constant.MapConstant;
import com.transport.constant.MiscConstant;
import com.transport.dao.MaintenanceMonitoringSecurityDao;
import com.transport.model.MaintenanceMonitoringSecurity;
import com.transport.model.User;
import com.transport.util.TransportUtils;

/**
 * 
 * @author dward
 *
 */
public class MaintenanceMonitoringSecurityDaoImpl implements MaintenanceMonitoringSecurityDao{
	
	private final static Logger logger = Logger.getLogger(MaintenanceMonitoringSecurityDaoImpl.class);

	@Override
	public Map<String, Object> save(HashMap<String, Object> dataMap)
			throws Exception {
		
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SAVE);
		
		//DBCP JNDI
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean status = false;
		
		MaintenanceMonitoringSecurity model = (MaintenanceMonitoringSecurity) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setCreatedBy((int) user.getId());	
		}
		model.setCreatedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("insert into transport.tran_maintenance_security (");
		  		qry.append("year ");
		  		qry.append(",month ");
		  		qry.append(",createdby ");
		  		qry.append(",createdon ");
		  		qry.append(" ) ");
		  		qry.append(" values ");
		  		qry.append(" ( ");
		  		qry.append(" ? ");
		  		qry.append(" ,? ");
		  		qry.append(" ,? ");
		  		qry.append(" ,? ");
		  		qry.append(" ) ");

		StringBuffer qryLog =  new StringBuffer("insert into transport.tran_maintenance_security (");
				qryLog.append("year ");
				qryLog.append(",month ");
				qryLog.append(",createdby ");
				qryLog.append(",createdon ");
				qryLog.append(" ) ");
				qryLog.append(" values ");
				qryLog.append(" ( ");
				qryLog.append(model.getYear());
				qryLog.append(" ,"+model.getMonth());
				qryLog.append(" ,"+model.getCreatedBy());
				qryLog.append(" ,"+model.getCreatedOn());
				qryLog.append(" ) ");
					
		TransportUtils.writeLogDebug(logger, "SQL: "+qryLog.toString());
  		  		
		  try {
			  conn = ServerContext.getJDBCHandle();
			  conn.setAutoCommit(false);
			  pstmt = conn.prepareStatement(qry.toString());
			     
			  pstmt.setInt(1, model.getYear());
			  pstmt.setInt(2, model.getMonth());
			  pstmt.setInt(3, model.getCreatedBy());
			  pstmt.setTimestamp(4, model.getCreatedOn());
			     
			  int statusInt = pstmt.executeUpdate();
			     
			  if (statusInt == 1) {
				  conn.commit();
				  System.out.println("Inserted into Maintenance Monitoring Security table successfully..");
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
	public Map<String, Object> searchDataByCriteria(
			HashMap<String, Object> criteriaMap) throws Exception {
		// TODO Auto-generated method stub
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_GETDATA_BY_CRITERIA);
		 
		    //get the model criteria
		    MaintenanceMonitoringSecurity model = (MaintenanceMonitoringSecurity) criteriaMap.get(MapConstant.CLASS_DATA);

		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
		     Map<String, Object> returnMap = null;
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();				
				 	sql.append("select id,year,month,createdby,createdon ");
				 	sql.append("from transport.tran_maintenance_security ");
				 	sql.append("where year = ? and month = ? ");
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, model.getYear());
				 pstmt.setInt(2, model.getMonth());
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
		    		 model.setId(rs.getInt(1));
		    		 model.setYear(rs.getInt(2));
		    		 model.setMonth(rs.getInt(3));
				 }				 
			 } catch (SQLException e) {
				 throw e;
			 } finally {
				 TransportUtils.closeObjects(rs);
				 TransportUtils.closeObjects(pstmt);
				 TransportUtils.closeObjects(conn);
			 }	 
		 		     
		     if (model.getId() > 0) {
		    	 returnMap = new HashMap<String, Object>();
		    	 returnMap.put(MapConstant.CLASS_DATA, model);
		     } 
	     
	    System.out.println("searchDataByCriteria() - Exit");
		return returnMap;
	}



}
