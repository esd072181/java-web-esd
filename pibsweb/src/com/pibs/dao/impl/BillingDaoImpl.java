package com.pibs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pibs.config.ServerContext;
import com.pibs.constant.MapConstant;
import com.pibs.constant.MiscConstant;
import com.pibs.dao.BillingDao;
import com.pibs.model.Billing;
import com.pibs.model.User;
import com.pibs.util.PIBSUtils;

public class BillingDaoImpl implements BillingDao {

	private final static Logger logger = Logger.getLogger(BillingDaoImpl.class);
	
	@Override
	public Map<String, Object> save(HashMap<String, Object> dataMap) throws Exception{
		
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SAVE);
		
		//DBCP JNDI
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean status = false;
		
		Billing model = (Billing) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setCreatedBy((int) user.getId());	
		}
		model.setCreatedOn(new Timestamp(new java.util.Date().getTime()));
		model.setDateProcessed(model.getCreatedOn());
		
		StringBuffer qry =  new StringBuffer("insert into pibs.tran_patient_billing (");
		  		qry.append("patientcasesystemid ");
		  		qry.append(",totallaboratoryexamfee ");
		  		qry.append(",totalmedsupplyfee ");
		  		qry.append(",totalradiologyfee ");
		  		qry.append(",totalsurgeryfee ");
		  		qry.append(",totaladditionalservicesfee ");
		  		qry.append(",totalequipmentfee ");
		  		qry.append(",totalroomfee ");
		  		qry.append(",totaldoctorfee ");
		  		qry.append(",totalfee ");
		  		qry.append(",totaldiscountamt ");
		  		qry.append(",totaltaxamt ");
		  		qry.append(",totalbill ");
		  		qry.append(",dateprocessed ");
		  		qry.append(",remarks ");
		  		qry.append(",cleared ");
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
			     
			  pstmt.setInt(1, model.getPatientCaseSystemid());
			  pstmt.setBigDecimal(2, model.getTotalLaboratoryExamFee());
			  pstmt.setBigDecimal(3, model.getTotalMedsupplyFee());
			  pstmt.setBigDecimal(4, model.getTotalRadiologyFee());
			  pstmt.setBigDecimal(5, model.getTotalSurgeryFee());
			  pstmt.setBigDecimal(6, model.getTotalAdditionalServicesFee());
			  pstmt.setBigDecimal(7, model.getTotalEquipmentFee());
			  pstmt.setBigDecimal(8, model.getTotalRoomFee());			  
			  pstmt.setBigDecimal(9, model.getTotalDoctorFee());
			  pstmt.setBigDecimal(10, model.getTotalFee());
			  pstmt.setBigDecimal(11, model.getTotalDiscountAmt());
			  pstmt.setBigDecimal(12, model.getTotalTaxAmt());
			  pstmt.setBigDecimal(13, model.getTotalBill());
			  pstmt.setTimestamp(14, model.getDateProcessed());
			  pstmt.setString(15, model.getRemarks());
			  pstmt.setBoolean(16, false);
			  pstmt.setInt(17, model.getCreatedBy());
			  pstmt.setTimestamp(18, model.getCreatedOn());
			     
			  int statusInt = pstmt.executeUpdate();
			     
			  if (statusInt == 1) {
				  conn.commit();
				  System.out.println("Inserted into Billing table successfully..");
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
		
		Billing model = (Billing) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		model.setDateProcessed(model.getModifiedOn());
		
		StringBuffer qry =  new StringBuffer("update pibs.tran_patient_billing set ");	
	  		qry.append(" patientcasesystemid = ? ");
	  		qry.append(" ,totallaboratoryexamfee = ? ");
	  		qry.append(" ,totalmedsupplyfee = ? ");
	  		qry.append(" ,totalradiologyfee = ? ");
	  		qry.append(" ,totalsurgeryfee = ? ");
	  		qry.append(" ,totaladditionalservicesfee = ? ");
	  		qry.append(" ,totalequipmentfee = ? ");
	  		qry.append(" ,totalroomfee = ? ");
	  		qry.append(" ,totaldoctorfee = ? ");
	  		qry.append(" ,totalfee = ? ");
	  		qry.append(" ,totaldiscountamt = ? ");
	  		qry.append(" ,totaltaxamt = ? ");
	  		qry.append(" ,totalbill = ? ");
	  		qry.append(" ,dateprocessed = ? ");
	  		qry.append(" ,remarks = ? ");
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
				     
			pstmt.setInt(1, model.getPatientCaseSystemid());
			pstmt.setBigDecimal(2, model.getTotalLaboratoryExamFee());
			pstmt.setBigDecimal(3, model.getTotalMedsupplyFee());
			pstmt.setBigDecimal(4, model.getTotalRadiologyFee());
			pstmt.setBigDecimal(5, model.getTotalSurgeryFee());
			pstmt.setBigDecimal(6, model.getTotalAdditionalServicesFee());
			pstmt.setBigDecimal(7, model.getTotalEquipmentFee());
			pstmt.setBigDecimal(8, model.getTotalRoomFee());			  
			pstmt.setBigDecimal(9, model.getTotalDoctorFee());
			pstmt.setBigDecimal(10, model.getTotalFee());
			pstmt.setBigDecimal(11, model.getTotalDiscountAmt());
			pstmt.setBigDecimal(12, model.getTotalTaxAmt());
			pstmt.setBigDecimal(13, model.getTotalBill());
			pstmt.setTimestamp(14, model.getDateProcessed());
			pstmt.setString(15, model.getRemarks());
			pstmt.setInt(16, model.getModifiedBy());
			pstmt.setTimestamp(17, model.getModifiedOn());
			pstmt.setLong(18, model.getId());
				     
			int statusInt = pstmt.executeUpdate();
				     
			if (statusInt == 1) {
				conn.commit();
				System.out.println("Billing record (id: " +model.getId()+") updated successfully..");
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
	
	public static int getBillingCount() throws Exception{
		 
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SEARCH);

			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
			 
			 int totalNoOfRecords = 0;
					  
			 try {
			 	 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer("select id from pibs.tran_patient_billing order by id desc limit 1");
		 			 
				 PIBSUtils.writeLogDebug(logger, "SQL: "+sql.toString());
					
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 rs = pstmt.executeQuery();
				 
				 if (rs.next()) {
					 totalNoOfRecords = rs.getInt(1);
				 } else {
					 totalNoOfRecords = 0;
				 }
			 } catch (SQLException e) {
				 throw e;
			 } finally {
				 PIBSUtils.closeObjects(rs);
				 PIBSUtils.closeObjects(pstmt);
				 PIBSUtils.closeObjects(conn);
			 }
			 
	    System.out.println("getBillingCount() - Exit");
		return totalNoOfRecords;
	}
	

	@Override
	public Map<String, Object> getDataByPatientCaseSystemId(HashMap<String, Object> criteriaMap) throws Exception{
		 
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SEARCH);
		 
		 	Map<String, Object> returnMap = null;

		    //get the model criteria
		    Billing model = (Billing) criteriaMap.get(MapConstant.CLASS_DATA);
			 
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = null;
					sql = new StringBuffer(" select a.id,a.patientcasesystemid,a.totallaboratoryexamfee,a.totalmedsupplyfee,a.totalradiologyfee,a.totalsurgeryfee ");
						sql.append(" ,a.totaladditionalservicesfee,a.totalequipmentfee,a.totalroomfee,a.totaldoctorfee,a.totalfee,a.totaldiscountamt,a.totaltaxamt ");  
						sql.append(" ,a.totalbill,a.dateprocessed,a.remarks,a.cleared,b.caseno ");	
						sql.append(" from pibs.tran_patient_billing a, pibs.tran_patient_case b ");  
						sql.append(" where a.patientcasesystemid = b.id ");
					 	sql.append(" and a.patientcasesystemid = ?");

				PIBSUtils.writeLogDebug(logger, "SQL: "+sql.toString());
					
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, model.getPatientCaseSystemid());
				 
				 rs = pstmt.executeQuery();
				 
				 while(rs.next()) {
					 model.setId(rs.getInt(1));
					 model.setPatientCaseSystemid(rs.getInt(2));
					 model.setTotalLaboratoryExamFee(rs.getBigDecimal(3));	 
					 model.setTotalMedsupplyFee(rs.getBigDecimal(4));
					 model.setTotalRadiologyFee(rs.getBigDecimal(5));
					 model.setTotalSurgeryFee(rs.getBigDecimal(6));
					 model.setTotalAdditionalServicesFee(rs.getBigDecimal(7));
					 model.setTotalEquipmentFee(rs.getBigDecimal(8));
					 model.setTotalRoomFee(rs.getBigDecimal(9));
					 model.setTotalDoctorFee(rs.getBigDecimal(10));
					 model.setTotalFee(rs.getBigDecimal(11));
					 model.setTotalDiscountAmt(rs.getBigDecimal(12));
					 model.setTotalTaxAmt(rs.getBigDecimal(13));
					 model.setTotalBill(rs.getBigDecimal(14));
					 model.setDateProcessed(rs.getTimestamp(15));
					 model.setRemarks(rs.getString(16));
					 model.setCleared(rs.getBoolean(17));
					 model.setCaseNo(rs.getString(18));
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
	public Map<String, Object> updateToCleared(HashMap<String, Object> dataMap) throws Exception{
		// TODO Auto-generated method stub
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_UPDATE);
		 
		//DBCP JNDI
		Connection conn = (Connection) dataMap.get(MapConstant.JDBC_CONNECTION);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean status = false;
		
		Billing model = (Billing) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update pibs.tran_patient_billing set ");	
	  		qry.append(" cleared = true ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");

			
		PIBSUtils.writeLogDebug(logger, "SQL: "+qry.toString());
	
		 try {
			pstmt = conn.prepareStatement(qry.toString());
				     
			pstmt.setInt(1, model.getModifiedBy());
			pstmt.setTimestamp(2, model.getModifiedOn());
			pstmt.setLong(3, model.getId());
				     
			int statusInt = pstmt.executeUpdate();
				     
			if (statusInt == 1) {
//				conn.commit(); //no commit here
				System.out.println("Billing record (id: " +model.getId()+") updated successfully..");
				status = true;
			}
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			PIBSUtils.closeObjects(rs);
			PIBSUtils.closeObjects(pstmt);
//			PIBSUtils.closeObjects(conn); //do not close here
		}
			 		
		returnMap.put(MapConstant.TRANSACTION_STATUS, status);	
		
		return returnMap;
	}
	
}
