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
import com.transport.dao.MaintenanceMonitoringTotalPendingDao;
import com.transport.model.MaintenanceMonitoringTotalPending;
import com.transport.model.User;
import com.transport.util.TransportUtils;

/**
 * 
 * @author dward
 * @since 03Sep2019
 */
public class MaintenanceMonitoringTotalPendingDaoImpl implements MaintenanceMonitoringTotalPendingDao {
	
	private final static Logger logger = Logger.getLogger(MaintenanceMonitoringTotalPendingDaoImpl.class);

	
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
		
		MaintenanceMonitoringTotalPending model = (MaintenanceMonitoringTotalPending) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry = null;
		
			switch (model.getDay()) {
				case 1: 
					qry =  new StringBuffer("update transport.tran_maintenance_total_pending set ");	
					qry.append(" totalpendingcomment1=? ");
					break;
				case 2: 
					qry =  new StringBuffer("update transport.tran_maintenance_total_pending set ");	
					qry.append(" totalpendingcomment2=? ");
					break;
				case 3: 
					qry =  new StringBuffer("update transport.tran_maintenance_total_pending set ");	
					qry.append(" totalpendingcomment3=? ");					
					break;
				case 4: 
					qry =  new StringBuffer("update transport.tran_maintenance_total_pending set ");	
					qry.append(" totalpendingcomment4=? ");
					break;
				case 5: 
					qry =  new StringBuffer("update transport.tran_maintenance_total_pending set ");	
					qry.append(" totalpendingcomment5=? ");
					break;
				case 6: 
					qry =  new StringBuffer("update transport.tran_maintenance_total_pending set ");	
					qry.append(" totalpendingcomment6=? ");
					break;
				case 7: 
					qry =  new StringBuffer("update transport.tran_maintenance_total_pending set ");	
					qry.append(" totalpendingcomment7=? ");
					break;
				case 8: 
					qry =  new StringBuffer("update transport.tran_maintenance_total_pending set ");	
					qry.append(" totalpendingcomment8=? ");
					break;
				case 9: 
					qry =  new StringBuffer("update transport.tran_maintenance_total_pending set ");	
					qry.append(" totalpendingcomment9=? ");
					break;
				case 10: 
					qry =  new StringBuffer("update transport.tran_maintenance_total_pending set ");	
					qry.append(" pgarage10=? ");
					qry.append(" ,pgarageremarks10=? ");				
					break;
				case 11: 
					qry =  new StringBuffer("update transport.tran_maintenance_total_pending set ");	
					qry.append(" totalpendingcomment11=? ");				
					break;
				case 12: 
					qry =  new StringBuffer("update transport.tran_maintenance_total_pending set ");	
					qry.append(" totalpendingcomment12=? ");			
					break;
				case 13: 
					qry =  new StringBuffer("update transport.tran_maintenance_total_pending set ");	
					qry.append(" totalpendingcomment13=? ");	
					break;
				case 14: 
					qry =  new StringBuffer("update transport.tran_maintenance_total_pending set ");	
					qry.append(" totalpendingcomment14=? ");	
					break;
				case 15: 
					qry =  new StringBuffer("update transport.tran_maintenance_total_pending set ");	
					qry.append(" totalpendingcomment15=? ");
					break;
				case 16: 
					qry =  new StringBuffer("update transport.tran_maintenance_total_pending set ");	
					qry.append(" totalpendingcomment16=? ");			
					break;
				case 17: 
					qry =  new StringBuffer("update transport.tran_maintenance_total_pending set ");	
					qry.append(" totalpendingcomment17=? ");		
					break;
				case 18: 
					qry =  new StringBuffer("update transport.tran_maintenance_total_pending set ");	
					qry.append(" totalpendingcomment18=? ");
					break;
				case 19: 
					qry =  new StringBuffer("update transport.tran_maintenance_total_pending set ");	
					qry.append(" totalpendingcomment19=? ");		
					break;
				case 20: 
					qry =  new StringBuffer("update transport.tran_maintenance_total_pending set ");	
					qry.append(" totalpendingcomment20=? ");	
					break;
				case 21: 
					qry =  new StringBuffer("update transport.tran_maintenance_total_pending set ");	
					qry.append(" totalpendingcomment21=? ");				
					break;
				case 22: 
					qry =  new StringBuffer("update transport.tran_maintenance_total_pending set ");	
					qry.append(" totalpendingcomment22=? ");		
					break;
				case 23: 
					qry =  new StringBuffer("update transport.tran_maintenance_total_pending set ");	
					qry.append(" totalpendingcomment23=? ");		
					break;
				case 24: 
					qry =  new StringBuffer("update transport.tran_maintenance_total_pending set ");	
					qry.append(" totalpendingcomment24=? ");
					break;
				case 25: 
					qry =  new StringBuffer("update transport.tran_maintenance_total_pending set ");	
					qry.append(" totalpendingcomment25=? ");
					break;
				case 26: 
					qry =  new StringBuffer("update transport.tran_maintenance_total_pending set ");	
					qry.append(" totalpendingcomment26=? ");
					break;
				case 27: 
					qry =  new StringBuffer("update transport.tran_maintenance_total_pending set ");	
					qry.append(" totalpendingcomment27=? ");
					break;
				case 28: 
					qry =  new StringBuffer("update transport.tran_maintenance_total_pending set ");	
					qry.append(" totalpendingcomment28=? ");
					break;
				case 29: 
					qry =  new StringBuffer("update transport.tran_maintenance_total_pending set ");	
					qry.append(" totalpendingcomment29=? ");
					break;
				case 30: 
					qry =  new StringBuffer("update transport.tran_maintenance_total_pending set ");	
					qry.append(" totalpendingcomment30=? ");
					break;
				case 31: 
					qry =  new StringBuffer("update transport.tran_maintenance_total_pending set ");	
					qry.append(" totalpendingcomment31=? ");
					break;
			}
			
		
		qry.append(" ,modifiedby=?,modifiedon=?,version=(version+1) where id = ?");
			
		TransportUtils.writeLogDebug(logger, "SQL: "+qry.toString());
	
		 try {
			conn = ServerContext.getJDBCHandle();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(qry.toString());
	
				switch (model.getDay()) {
					case 1: 
						pstmt.setString(1, model.getTotalPendingComment1());
						break;
					case 2: 
						pstmt.setString(1, model.getTotalPendingComment2());
						break;
					case 3: 
						pstmt.setString(1, model.getTotalPendingComment3());
						break;
					case 4: 
						pstmt.setString(1, model.getTotalPendingComment4());
						break;
					case 5: 
						pstmt.setString(1, model.getTotalPendingComment5());
						break;
					case 6: 
						pstmt.setString(1, model.getTotalPendingComment6());
						break;
					case 7: 
						pstmt.setString(1, model.getTotalPendingComment7());
						break;
					case 8: 
						pstmt.setString(1, model.getTotalPendingComment8());
						break;
					case 9: 
						pstmt.setString(1, model.getTotalPendingComment9());
						break;
					case 10: 
						pstmt.setString(1, model.getTotalPendingComment10());
						break;
					case 11: 
						pstmt.setString(1, model.getTotalPendingComment11());
						break;
					case 12: 
						pstmt.setString(1, model.getTotalPendingComment12());
						break;
					case 13: 
						pstmt.setString(1, model.getTotalPendingComment13());
						break;
					case 14: 
						pstmt.setString(1, model.getTotalPendingComment14());
						break;
					case 15: 
						pstmt.setString(1, model.getTotalPendingComment15());
						break;
					case 16: 
						pstmt.setString(1, model.getTotalPendingComment16());
						break;
					case 17: 
						pstmt.setString(1, model.getTotalPendingComment17());
						break;
					case 18: 
						pstmt.setString(1, model.getTotalPendingComment18());
						break;
					case 19: 
						pstmt.setString(1, model.getTotalPendingComment19());
						break;
					case 20: 
						pstmt.setString(1, model.getTotalPendingComment20());
						break;
					case 21: 
						pstmt.setString(1, model.getTotalPendingComment21());
						break;
					case 22: 
						pstmt.setString(1, model.getTotalPendingComment22());
						break;
					case 23: 
						pstmt.setString(1, model.getTotalPendingComment23());
						break;
					case 24: 
						pstmt.setString(1, model.getTotalPendingComment24());
						break;
					case 25: 
						pstmt.setString(1, model.getTotalPendingComment25());
						break;
					case 26: 
						pstmt.setString(1, model.getTotalPendingComment26());
						break;
					case 27: 
						pstmt.setString(1, model.getTotalPendingComment27());
						break;
					case 28: 
						pstmt.setString(1, model.getTotalPendingComment28());
						break;
					case 29: 
						pstmt.setString(1, model.getTotalPendingComment29());
						break;
					case 30: 
						pstmt.setString(1, model.getTotalPendingComment30());
						break;
					case 31: 
						pstmt.setString(1, model.getTotalPendingComment31());
						break;
				}
	
			pstmt.setInt(2, model.getModifiedBy());
			pstmt.setTimestamp(3, model.getModifiedOn());
			pstmt.setLong(4, model.getId());

				     
			int statusInt = pstmt.executeUpdate();
				     
			if (statusInt == 1) {
				conn.commit();
				System.out.println("Maintenance Monitoring Total Pending record (id: " +model.getId()+") updated successfully..");
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
	public Map<String, Object> getActiveData(HashMap<String, Object> criteriaMap) throws Exception{
		 
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_GET_ACTIVE_DATA);
		 
		 	Map<String, Object> returnMap = null;

		 	//Connection using JNDI DBCP
			 //get the year and month criteria
			 int year = Integer.parseInt((String)criteriaMap.get(MapConstant.YEAR_CRITERIA));
			 int month = Integer.parseInt((String)criteriaMap.get(MapConstant.MONTH_CRITERIA));
			 
			 Connection conn = null;
			 ResultSet rs = null;;
			 ResultSet rs2 = null;
			 PreparedStatement pstmt = null; 
			 PreparedStatement pstmt2 = null;
			 
			 List<MaintenanceMonitoringTotalPending> rsList = new ArrayList<>();
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuilder sql = new StringBuilder("select a.* ");
					 	sql.append(" from transport.tran_maintenance_total_pending a");
					 	sql.append(" where a.year = ? ");
					 	sql.append(" and a.month = ? ");
					 	sql.append(" and a.active = true ");
					 	sql.append(" order by a.month ");					 
				
				TransportUtils.writeLogDebug(logger, "SQL: "+sql.toString());
					
				pstmt = conn.prepareStatement(sql.toString());
				 
				pstmt.setInt(1, year);
				pstmt.setInt(2, month);					 
				 
				 rs = pstmt.executeQuery();
				 
				 while(rs.next()) {
					 MaintenanceMonitoringTotalPending model = new MaintenanceMonitoringTotalPending();  
		    		 model.setId(rs.getInt(1));
		    		 model.setMonth(rs.getInt(2));
		    		 model.setYear(rs.getInt(3));
		    		 model.setTotalPendingComment1(rs.getString(4));
		    		 model.setTotalPendingComment2(rs.getString(5));
		    		 model.setTotalPendingComment3(rs.getString(6));
		    		 model.setTotalPendingComment4(rs.getString(7));
		    		 model.setTotalPendingComment5(rs.getString(8));
		    		 model.setTotalPendingComment6(rs.getString(9));
		    		 model.setTotalPendingComment7(rs.getString(10));
		    		 model.setTotalPendingComment8(rs.getString(11));
		    		 model.setTotalPendingComment9(rs.getString(12));
		    		 model.setTotalPendingComment10(rs.getString(13));
		    		 model.setTotalPendingComment11(rs.getString(14));
		    		 model.setTotalPendingComment12(rs.getString(15));
		    		 model.setTotalPendingComment13(rs.getString(16));
		    		 model.setTotalPendingComment14(rs.getString(17));
		    		 model.setTotalPendingComment15(rs.getString(18));
		    		 model.setTotalPendingComment16(rs.getString(19));
		    		 model.setTotalPendingComment17(rs.getString(20));
		    		 model.setTotalPendingComment18(rs.getString(21));
		    		 model.setTotalPendingComment19(rs.getString(22));
		    		 model.setTotalPendingComment20(rs.getString(23));
		    		 model.setTotalPendingComment21(rs.getString(24));
		    		 model.setTotalPendingComment22(rs.getString(25));
		    		 model.setTotalPendingComment23(rs.getString(26));
		    		 model.setTotalPendingComment24(rs.getString(27));
		    		 model.setTotalPendingComment25(rs.getString(28));
		    		 model.setTotalPendingComment26(rs.getString(29));
		    		 model.setTotalPendingComment27(rs.getString(30));
		    		 model.setTotalPendingComment28(rs.getString(31));
		    		 model.setTotalPendingComment29(rs.getString(32));
		    		 model.setTotalPendingComment30(rs.getString(33));
		    		 model.setTotalPendingComment31(rs.getString(34));		    		 
		    		 rsList.add(model);
				 }				
			

			 } catch (SQLException e) {
				 throw e;
			 } finally {
				 TransportUtils.closeObjects(rs);
				 TransportUtils.closeObjects(pstmt);
				 TransportUtils.closeObjects(rs2);
				 TransportUtils.closeObjects(pstmt2);
				 TransportUtils.closeObjects(conn);
			 }
				 
		     if (rsList!=null && !rsList.isEmpty()) {
		    	 returnMap = new HashMap<String, Object>();
		    	 returnMap.put(MapConstant.CLASS_LIST, rsList);
		     } 
	     
	    System.out.println("getActiveData() - Exit");
		return returnMap;
	}

	@Override
	public Map<String, Object> getDataById(HashMap<String, Object> criteriaMap)
			throws Exception {
		// TODO Auto-generated method stub
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_GETDATA_BY_ID);
		 
		    //get the model criteria
		    MaintenanceMonitoringTotalPending model = (MaintenanceMonitoringTotalPending) criteriaMap.get(MapConstant.CLASS_DATA);

		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
		     Map<String, Object> returnMap = null;
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();				
				 sql = new StringBuffer("select * ");
				 	sql.append("from transport.tran_maintenance_total_pending ");
				 	sql.append("where id = ? ");

				 TransportUtils.writeLogDebug(logger, "SQL: "+sql.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, model.getId());
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
		    		 model.setId(rs.getInt(1));
		    		 model.setMonth(rs.getInt(2));
		    		 model.setYear(rs.getInt(3));
		    		 model.setTotalPendingComment1(rs.getString(4));
		    		 model.setTotalPendingComment2(rs.getString(5));
		    		 model.setTotalPendingComment3(rs.getString(6));
		    		 model.setTotalPendingComment4(rs.getString(7));
		    		 model.setTotalPendingComment5(rs.getString(8));
		    		 model.setTotalPendingComment6(rs.getString(9));
		    		 model.setTotalPendingComment7(rs.getString(10));
		    		 model.setTotalPendingComment8(rs.getString(11));
		    		 model.setTotalPendingComment9(rs.getString(12));
		    		 model.setTotalPendingComment10(rs.getString(13));
		    		 model.setTotalPendingComment11(rs.getString(14));
		    		 model.setTotalPendingComment12(rs.getString(15));
		    		 model.setTotalPendingComment13(rs.getString(16));
		    		 model.setTotalPendingComment14(rs.getString(17));
		    		 model.setTotalPendingComment15(rs.getString(18));
		    		 model.setTotalPendingComment16(rs.getString(19));
		    		 model.setTotalPendingComment17(rs.getString(20));
		    		 model.setTotalPendingComment18(rs.getString(21));
		    		 model.setTotalPendingComment19(rs.getString(22));
		    		 model.setTotalPendingComment20(rs.getString(23));
		    		 model.setTotalPendingComment21(rs.getString(24));
		    		 model.setTotalPendingComment22(rs.getString(25));
		    		 model.setTotalPendingComment23(rs.getString(26));
		    		 model.setTotalPendingComment24(rs.getString(27));
		    		 model.setTotalPendingComment25(rs.getString(28));
		    		 model.setTotalPendingComment26(rs.getString(29));
		    		 model.setTotalPendingComment27(rs.getString(30));
		    		 model.setTotalPendingComment28(rs.getString(31));
		    		 model.setTotalPendingComment29(rs.getString(32));
		    		 model.setTotalPendingComment30(rs.getString(33));
		    		 model.setTotalPendingComment31(rs.getString(34));		    		 	    		  
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
		
}
