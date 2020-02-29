package com.transport.dao.impl;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.transport.config.ServerContext;
import com.transport.constant.ActionConstant;
import com.transport.constant.MapConstant;
import com.transport.constant.MiscConstant;
import com.transport.dao.DriverTrainingDao;
import com.transport.model.DriverTraining ;
import com.transport.model.User;
import com.transport.util.TransportUtils;

public class DriverTrainingDaoImpl implements DriverTrainingDao {
	
	private final static Logger logger = Logger.getLogger(DriverTrainingDaoImpl.class);

	@Override
	public Map<String, Object> save(HashMap<String, Object> dataMap) throws Exception{
		
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SAVE);

		//DBCP JNDI
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean status = false;
		
		DriverTraining  model = (DriverTraining ) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setCreatedBy((int) user.getId());	
		}
		model.setCreatedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("insert into transport.tran_driver_training (");
				qry.append("driverid ");
		  		qry.append(",sss ");
		  		qry.append(",pagibig ");
		  		qry.append(",tin ");
		  		qry.append(",picname ");
		  		qry.append(",pic ");
		  		qry.append(",terminalid ");
		  		qry.append(",articulated ");
		  		qry.append(",birthday ");
		  		qry.append(",createdby ");
		  		qry.append(",createdon ");
		  		qry.append(",version ");
		  		qry.append(",active ");
		  		qry.append(",datehired ");
		  		qry.append(",licenseno ");
		  		qry.append(",licensevalidity ");
		  		qry.append(",contactno ");
		  		qry.append(",religion ");
		  		qry.append(",gender ");
		  		qry.append(",civilstatus ");
		  		qry.append(",spouse ");
		  		qry.append(",philhealthno ");
		  		qry.append(",height ");
		  		qry.append(",weight ");
		  		qry.append(",mothersname ");
		  		qry.append(",fathersname ");
		  		qry.append(",address ");
		  		qry.append(",elementary ");
		  		qry.append(",elementarydate ");
		  		qry.append(",secondary ");
		  		qry.append(",secondarydate ");
		  		qry.append(",tertiary ");
		  		qry.append(",tertiarydate ");
		  		qry.append(",employmentdatefrom1 ");
		  		qry.append(",employmentdateto1 ");
		  		qry.append(",employmentposition1 ");
		  		qry.append(",employmentcompany1 ");
		  		qry.append(",employmentdatefrom2 ");
		  		qry.append(",employmentdateto2 ");
		  		qry.append(",employmentposition2 ");
		  		qry.append(",employmentcompany2 ");
		  		qry.append(",employmentdatefrom3 ");
		  		qry.append(",employmentdateto3 ");
		  		qry.append(",employmentposition3 ");
		  		qry.append(",employmentcompany3 ");
		  		qry.append(",ftw ");
		  		qry.append(",nbi ");
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
		  		qry.append(" ) ");

		StringBuffer qryLog =  new StringBuffer("insert into transport.tran_driver_training (");
				qryLog.append("driverid ");
				qryLog.append(",sss ");
		  		qryLog.append(",pagibig ");
		  		qryLog.append(",tin ");
		  		qryLog.append(",picname ");
		  		qryLog.append(",pic ");
		  		qryLog.append(",terminalid ");
		  		qryLog.append(",articulated ");
		  		qryLog.append(",birthday ");
		  		qryLog.append(",createdby ");
		  		qryLog.append(",createdon ");
		  		qryLog.append(",version ");
		  		qryLog.append(",active ");
		  		qryLog.append(",datehired ");
		  		qryLog.append(",licenseno ");
		  		qryLog.append(",licensevalidity ");
		  		qryLog.append(",contactno ");
		  		qryLog.append(",religion ");
		  		qryLog.append(",gender ");
		  		qryLog.append(",civilstatus ");
		  		qryLog.append(",spouse ");
		  		qryLog.append(",philhealthno ");
		  		qryLog.append(",height ");
		  		qryLog.append(",weight ");
		  		qryLog.append(",mothersname ");
		  		qryLog.append(",fathersname ");
		  		qryLog.append(",address ");
		  		qryLog.append(",elementary ");
		  		qryLog.append(",elementarydate ");
		  		qryLog.append(",secondary ");
		  		qryLog.append(",secondarydate ");
		  		qryLog.append(",tertiary ");
		  		qryLog.append(",tertiarydate ");
		  		qryLog.append(",employmentdatefrom1 ");
		  		qryLog.append(",employmentdateto1 ");
		  		qryLog.append(",employmentposition1 ");
		  		qryLog.append(",employmentcompany1 ");
		  		qryLog.append(",employmentdatefrom2 ");
		  		qryLog.append(",employmentdateto2 ");
		  		qryLog.append(",employmentposition2 ");
		  		qryLog.append(",employmentcompany2 ");
		  		qryLog.append(",employmentdatefrom3 ");
		  		qryLog.append(",employmentdateto3 ");
		  		qryLog.append(",employmentposition3 ");
		  		qryLog.append(",employmentcompany3 ");
		  		qryLog.append(",ftw ");
		  		qryLog.append(",nbi ");
				qryLog.append(" ) ");
				qryLog.append(" values ");
				qryLog.append(" ( ");
				qryLog.append(model.getDriverId());
				qryLog.append(" ,"+model.getSss());
				qryLog.append(" ,"+model.getPagibig());
				qryLog.append(" ,"+model.getTin());
				qryLog.append(" ,"+model.getPicName());
				qryLog.append(" ,");
				qryLog.append(" ,"+model.getTerminalId());
				qryLog.append(" ,"+model.getArticulated());
				qryLog.append(" ,"+model.getBirthday());
				qryLog.append(" ,"+model.getCreatedBy());
				qryLog.append(" ,"+model.getCreatedOn());
				qryLog.append(" ,1 ");
				qryLog.append(" ,true ");
				qryLog.append(" ,"+model.getDateHired());
				qryLog.append(" ,"+model.getLicenseNo());
				qryLog.append(" ,"+model.getLicenseValidity());
				qryLog.append(" ,"+model.getContactNo());
				qryLog.append(" ,"+model.getReligion());
				qryLog.append(" ,"+model.getGender());
				qryLog.append(" ,"+model.getCivilStatus());
				qryLog.append(" ,"+model.getSpouse());
				qryLog.append(" ,"+model.getPhilhealthNo());
				qryLog.append(" ,"+model.getHeight());
				qryLog.append(" ,"+model.getWeight());
				qryLog.append(" ,"+model.getMothersName());
				qryLog.append(" ,"+model.getFathersName());
				qryLog.append(" ,"+model.getAddress());
				qryLog.append(" ,"+model.getElementary());
				qryLog.append(" ,"+model.getElementaryDate());
				qryLog.append(" ,"+model.getSecondary());
				qryLog.append(" ,"+model.getSecondaryDate());
				qryLog.append(" ,"+model.getTertiary());
				qryLog.append(" ,"+model.getTertiaryDate());
				qryLog.append(" ,"+model.getEmploymentDateFrom1());
				qryLog.append(" ,"+model.getEmploymentDateTo1());
				qryLog.append(" ,"+model.getEmploymentPosition1());
				qryLog.append(" ,"+model.getEmploymentCompany1());
				qryLog.append(" ,"+model.getEmploymentDateFrom2());
				qryLog.append(" ,"+model.getEmploymentDateTo2());
				qryLog.append(" ,"+model.getEmploymentPosition2());
				qryLog.append(" ,"+model.getEmploymentCompany2());
				qryLog.append(" ,"+model.getEmploymentDateFrom3());
				qryLog.append(" ,"+model.getEmploymentDateTo3());
				qryLog.append(" ,"+model.getEmploymentPosition3());
				qryLog.append(" ,"+model.getEmploymentCompany3());
				qryLog.append(" ,"+model.getFtw());
				qryLog.append(" ,"+model.getNbi());
				qryLog.append(" ) ");
					
		TransportUtils.writeLogDebug(logger, "SQL: "+qryLog.toString());
  		  		
		  try {
			  conn = ServerContext.getJDBCHandle();
			  conn.setAutoCommit(false);
			  pstmt = conn.prepareStatement(qry.toString());
			     

			  
			  pstmt.setInt(1, model.getDriverId());
			  pstmt.setString(2, model.getSss());
			  pstmt.setString(3, model.getPagibig());
			  pstmt.setString(4, model.getTin());
			  pstmt.setString(5, model.getPicName());
			  if (model.getPic()!=null && model.getPic().length()>0) {
				  FileInputStream fis = new FileInputStream(model.getPic());
				  pstmt.setBinaryStream(6, fis, model.getPic().length());
			  } else {
				  pstmt.setNull(6, Types.NULL);
			  }
			  pstmt.setInt(7, model.getTerminalId());
			  pstmt.setString(8, model.getArticulated());
			  pstmt.setDate(9, model.getBirthday());
			  pstmt.setInt(10, model.getCreatedBy());
			  pstmt.setTimestamp(11, model.getCreatedOn());
			  
			  pstmt.setDate(12, model.getDateHired());
			  pstmt.setString(13, model.getLicenseNo());
			  pstmt.setDate(14, model.getLicenseValidity());
			  pstmt.setString(15, model.getContactNo());
			  pstmt.setString(16, model.getReligion());
			  pstmt.setString(17, model.getGender());
			  pstmt.setString(18, model.getCivilStatus());
			  pstmt.setString(19, model.getSpouse());
			  pstmt.setString(20, model.getPhilhealthNo());
			  pstmt.setString(21, model.getHeight());
			  pstmt.setString(22, model.getWeight());
			  pstmt.setString(23, model.getMothersName());
			  pstmt.setString(24, model.getFathersName());
			  pstmt.setString(25, model.getAddress());
			  pstmt.setString(26, model.getElementary());
			  pstmt.setString(27, model.getElementaryDate());
			  pstmt.setString(28, model.getSecondary());
			  pstmt.setString(29, model.getSecondaryDate());
			  pstmt.setString(30, model.getTertiary());
			  pstmt.setString(31, model.getTertiaryDate());
			  pstmt.setString(32, model.getEmploymentDateFrom1());
			  pstmt.setString(33, model.getEmploymentDateTo1());
			  pstmt.setString(34, model.getEmploymentPosition1());
			  pstmt.setString(35, model.getEmploymentCompany1());
			  pstmt.setString(36, model.getEmploymentDateFrom2());
			  pstmt.setString(37, model.getEmploymentDateTo2());
			  pstmt.setString(38, model.getEmploymentPosition2());
			  pstmt.setString(39, model.getEmploymentCompany2());
			  pstmt.setString(40, model.getEmploymentDateFrom3());
			  pstmt.setString(41, model.getEmploymentDateTo3());
			  pstmt.setString(42, model.getEmploymentPosition3());
			  pstmt.setString(43, model.getEmploymentCompany3());
			  pstmt.setDate(44, model.getFtw());
			  pstmt.setDate(45, model.getNbi());
			     
			  int statusInt = pstmt.executeUpdate();
			     
			  if (statusInt == 1) {
				  conn.commit();
				  System.out.println("Inserted into DriverInfo  table successfully..");
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
		 		
		 if (status == true) {
			 //get the max id for the details
			 int id = 0;
			 try {
				 conn = ServerContext.getJDBCHandle();
				 conn.setAutoCommit(false);
				  
				 StringBuffer sql = new StringBuffer("select max(id) from transport.tran_driver_training");
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 rs = pstmt.executeQuery();
	
				 while(rs.next()) {
		    		 id = rs.getInt(1);
				 }				 
			 } catch (SQLException e) {
				 throw e;
			 } finally {
				 TransportUtils.closeObjects(rs);
				 TransportUtils.closeObjects(pstmt);
				 TransportUtils.closeObjects(conn);
			 }	
		    
			 returnMap.put(MapConstant.FIELD_CRITERIA_ENTITY_ID, id);
			 
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
		
		DriverTraining  model = (DriverTraining ) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		  		
		StringBuffer qry =  new StringBuffer("update transport.tran_driver_training set ");	
			qry.append(" driverid=? ");
			qry.append(" ,sss=? ");
			qry.append(" ,pagibig=? ");
			qry.append(" ,tin=? ");
			if (model.getPic()!=null && model.getPic().length()>0 ) {
				qry.append(" ,picname=? ");
				qry.append(" ,pic=? ");				
			}
			qry.append(" ,terminalid=? ");
			qry.append(" ,articulated=? ");
			qry.append(" ,birthday=? ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,datehired=? ");
			qry.append(" ,licenseno=? ");
			qry.append(" ,licensevalidity=? ");
			qry.append(" ,contactno=? ");
			qry.append(" ,religion=? ");
			qry.append(" ,gender=? ");
			qry.append(" ,civilstatus=? ");
			qry.append(" ,spouse=? ");
			qry.append(" ,philhealthno=? ");
			qry.append(" ,height=? ");
			qry.append(" ,weight=? ");
			qry.append(" ,mothersname=? ");
			qry.append(" ,fathersname=? ");
			qry.append(" ,address=? ");
			qry.append(" ,elementary=? ");
			qry.append(" ,elementarydate=? ");
			qry.append(" ,secondary=? ");
			qry.append(" ,secondarydate=? ");
			qry.append(" ,tertiary=? ");
			qry.append(" ,tertiarydate=? ");
			qry.append(" ,employmentdatefrom1=? ");
			qry.append(" ,employmentdateto1=? ");
			qry.append(" ,employmentposition1=? ");
			qry.append(" ,employmentcompany1=? ");
			qry.append(" ,employmentdatefrom2=? ");
			qry.append(" ,employmentdateto2=? ");
			qry.append(" ,employmentposition2=? ");
			qry.append(" ,employmentcompany2=? ");
			qry.append(" ,employmentdatefrom3=? ");
			qry.append(" ,employmentdateto3=? ");
			qry.append(" ,employmentposition3=? ");
			qry.append(" ,employmentcompany3=? ");
			qry.append(" ,ftw=? ");
			qry.append(" ,nbi=? ");			
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");

		StringBuffer qryLog =  new StringBuffer("update transport.tran_driver_training set ");	
			qryLog.append(" driverid="+model.getDriverId());
			qryLog.append(" ,sss="+model.getSss());
			qryLog.append(" ,pagibig="+model.getPagibig());
			qryLog.append(" ,tin="+model.getTin());			
			if (model.getPic()!=null && model.getPic().length()>0 ) {
				qryLog.append(" ,picname="+model.getPicName());
				qryLog.append(" ,pic=");	
			}
			qryLog.append(" ,terminalid="+model.getTerminalId());
			qryLog.append(" ,articulated="+model.getArticulated());
			qryLog.append(" ,birthday="+model.getBirthday());
			qryLog.append(" ,modifiedby="+model.getModifiedBy());
			qryLog.append(" ,modifiedon="+model.getModifiedOn());
			qryLog.append(" ,datehired="+model.getDateHired());
			qryLog.append(" ,licenseno="+model.getLicenseNo());
			qryLog.append(" ,licensevalidity="+model.getLicenseValidity());
			qryLog.append(" ,contactno="+model.getContactNo());
			qryLog.append(" ,religion="+model.getReligion());
			qryLog.append(" ,gender="+model.getGender());
			qryLog.append(" ,civilstatus="+model.getCivilStatus());
			qryLog.append(" ,spouse="+model.getSpouse());
			qryLog.append(" ,philhealthno="+model.getPhilhealthNo());
			qryLog.append(" ,height="+model.getHeight());
			qryLog.append(" ,weight="+model.getWeight());
			qryLog.append(" ,mothersname="+model.getMothersName());
			qryLog.append(" ,fathersname="+model.getFathersName());
			qryLog.append(" ,address="+model.getAddress());
			qryLog.append(" ,elementary="+model.getElementary());
			qryLog.append(" ,elementarydate="+model.getElementaryDate());
			qryLog.append(" ,secondary="+model.getSecondary());
			qryLog.append(" ,secondarydate="+model.getSecondaryDate());
			qryLog.append(" ,tertiary="+model.getTertiary());
			qryLog.append(" ,tertiarydate="+model.getTertiaryDate());
			qryLog.append(" ,employmentdatefrom1="+model.getEmploymentDateFrom1());
			qryLog.append(" ,employmentdateto1="+model.getEmploymentDateTo1());
			qryLog.append(" ,employmentposition1="+model.getEmploymentPosition1());
			qryLog.append(" ,employmentcompany1="+model.getEmploymentCompany1());
			qryLog.append(" ,employmentdatefrom2="+model.getEmploymentDateFrom2());
			qryLog.append(" ,employmentdateto2="+model.getEmploymentDateTo2());
			qryLog.append(" ,employmentposition2="+model.getEmploymentPosition2());
			qryLog.append(" ,employmentcompany2="+model.getEmploymentCompany2());
			qryLog.append(" ,employmentdatefrom3="+model.getEmploymentDateFrom3());
			qryLog.append(" ,employmentdateto3="+model.getEmploymentDateTo3());
			qryLog.append(" ,employmentposition3="+model.getEmploymentPosition3());
			qryLog.append(" ,employmentcompany3="+model.getEmploymentCompany3());
			qryLog.append(" ,ftw="+model.getFtw());
			qryLog.append(" ,nbi="+model.getNbi());
			qryLog.append(" ,version=(version+1) ");
			qryLog.append(" where ");
			qryLog.append(" id = "+model.getId());
			
		TransportUtils.writeLogDebug(logger, "SQL: "+qryLog.toString());
	
		 try {
			conn = ServerContext.getJDBCHandle();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(qry.toString());
				     
			pstmt.setInt(1, model.getDriverId());
			pstmt.setString(2, model.getSss());
			pstmt.setString(3, model.getPagibig());
			pstmt.setString(4, model.getTin());
			if (model.getPic()!=null && model.getPic().length()>0 ) {
				FileInputStream fis = new FileInputStream(model.getPic());
				pstmt.setString(5, model.getPicName());
				pstmt.setBinaryStream(6, fis, model.getPic().length());
				pstmt.setInt(7, model.getTerminalId());
				pstmt.setString(8, model.getArticulated());
				pstmt.setDate(9, model.getBirthday());
				pstmt.setInt(10, model.getModifiedBy());
				pstmt.setTimestamp(11, model.getModifiedOn());
				pstmt.setDate(12, model.getDateHired());
				pstmt.setString(13, model.getLicenseNo());
				pstmt.setDate(14, model.getLicenseValidity());
				pstmt.setString(15, model.getContactNo());
				pstmt.setString(16, model.getReligion());
				pstmt.setString(17, model.getGender());
				pstmt.setString(18, model.getCivilStatus());
				pstmt.setString(19, model.getSpouse());
				pstmt.setString(20, model.getPhilhealthNo());
				pstmt.setString(21, model.getHeight());
				pstmt.setString(22, model.getWeight());
				pstmt.setString(23, model.getMothersName());
				pstmt.setString(24, model.getFathersName());
				pstmt.setString(25, model.getAddress());
				pstmt.setString(26, model.getElementary());
				pstmt.setString(27, model.getElementaryDate());
				pstmt.setString(28, model.getSecondary());
				pstmt.setString(29, model.getSecondaryDate());
				pstmt.setString(30, model.getTertiary());
				pstmt.setString(31, model.getTertiaryDate());
				pstmt.setString(32, model.getEmploymentDateFrom1());
				pstmt.setString(33, model.getEmploymentDateTo1());
				pstmt.setString(34, model.getEmploymentPosition1());
				pstmt.setString(35, model.getEmploymentCompany1());
				pstmt.setString(36, model.getEmploymentDateFrom2());
				pstmt.setString(37, model.getEmploymentDateTo2());
				pstmt.setString(38, model.getEmploymentPosition2());
				pstmt.setString(39, model.getEmploymentCompany2());
				pstmt.setString(40, model.getEmploymentDateFrom3());
				pstmt.setString(41, model.getEmploymentDateTo3());
				pstmt.setString(42, model.getEmploymentPosition3());
				pstmt.setString(43, model.getEmploymentCompany3());
				pstmt.setDate(44, model.getFtw());
				pstmt.setDate(45, model.getNbi());
				pstmt.setLong(46, model.getId());
			} else {
				pstmt.setInt(5, model.getTerminalId());
				pstmt.setString(6, model.getArticulated());
				pstmt.setDate(7, model.getBirthday());
				pstmt.setInt(8, model.getModifiedBy());
				pstmt.setTimestamp(9, model.getModifiedOn());
				pstmt.setDate(10, model.getDateHired());
				pstmt.setString(11, model.getLicenseNo());
				pstmt.setDate(12, model.getLicenseValidity());
				pstmt.setString(13, model.getContactNo());
				pstmt.setString(14, model.getReligion());
				pstmt.setString(15, model.getGender());
				pstmt.setString(16, model.getCivilStatus());
				pstmt.setString(17, model.getSpouse());
				pstmt.setString(18, model.getPhilhealthNo());
				pstmt.setString(19, model.getHeight());
				pstmt.setString(20, model.getWeight());
				pstmt.setString(21, model.getMothersName());
				pstmt.setString(22, model.getFathersName());
				pstmt.setString(23, model.getAddress());
				pstmt.setString(24, model.getElementary());
				pstmt.setString(25, model.getElementaryDate());
				pstmt.setString(26, model.getSecondary());
				pstmt.setString(27, model.getSecondaryDate());
				pstmt.setString(28, model.getTertiary());
				pstmt.setString(29, model.getTertiaryDate());
				pstmt.setString(30, model.getEmploymentDateFrom1());
				pstmt.setString(31, model.getEmploymentDateTo1());
				pstmt.setString(32, model.getEmploymentPosition1());
				pstmt.setString(33, model.getEmploymentCompany1());
				pstmt.setString(34, model.getEmploymentDateFrom2());
				pstmt.setString(35, model.getEmploymentDateTo2());
				pstmt.setString(36, model.getEmploymentPosition2());
				pstmt.setString(37, model.getEmploymentCompany2());
				pstmt.setString(38, model.getEmploymentDateFrom3());
				pstmt.setString(39, model.getEmploymentDateTo3());
				pstmt.setString(40, model.getEmploymentPosition3());
				pstmt.setString(41, model.getEmploymentCompany3());
				pstmt.setDate(42, model.getFtw());
				pstmt.setDate(43, model.getNbi());
				pstmt.setLong(44, model.getId());
			}

			int statusInt = pstmt.executeUpdate();
				     
			if (statusInt == 1) {
				conn.commit();
				System.out.println("DriverInfo  record (id: " +model.getId()+") updated successfully..");
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
		
		DriverTraining  model = (DriverTraining ) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update transport.tran_driver_training set ");	
			qry.append(" active=false ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");

		StringBuffer qryLog =  new StringBuffer("update transport.tran_driver_training set ");	
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
				System.out.println("DriverInfo  record (id: " +model.getId()+") deleted successfully..");
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
			 
			  List<DriverTraining> rsList = new ArrayList<DriverTraining>();
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer("select a.id,a.driverid,a.sss,a.pagibig,a.tin,a.picname,a.pic,a.terminalid,a.articulated ");
					 	sql.append(" ,a.birthday,b.lastname,b.firstname,c.name as terminalname,extract(year from age(birthday)) as age ");
					 	sql.append(" ,a.datehired,a.licenseno,a.licensevalidity,a.birthday,a.philhealthno,a.ftw,a.nbi ");
					 	sql.append(" ,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
					 	sql.append(" from transport.tran_driver_training a, transport.file_employee b, transport.file_terminal c ");
					 	sql.append(" where a.driverid = b.id ");
					 	sql.append(" and a.terminalid = c.id ");
					 	sql.append(" and a.active = true ");
					 	 if (!category.equals(ActionConstant.SEARCHALL)) {
					 		sql.append(" and (b.lastname ilike '%"+criteria+"%' or b.firstname ilike '%"+criteria+"%') " );	 
					 	 }
					 	sql.append(" order by b.lastname ");
					 	sql.append(" limit ? ");
					 	sql.append(" offset ?");	
				  
				TransportUtils.writeLogDebug(logger, "SQL: "+sql.toString());
					
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, limit);
				 pstmt.setInt(2, offset);
				 
				 rs = pstmt.executeQuery();
				 
				 while(rs.next()) {
					 DriverTraining model = new DriverTraining();  
		    		 model.setId(rs.getInt(1));
		    		 model.setDriverId(rs.getInt(2));
		    		 model.setSss(rs.getString(3));
		    		 model.setPagibig(rs.getString(4));
		    		 model.setTin(rs.getString(5));
		    		 model.setPicName(rs.getString(6));
		    		 if (rs.getBytes(7)!=null){
		    			 model.setPicStr(TransportUtils.getPicBase64String(rs.getBytes(7)));
		    		 }
		    		 model.setTerminalId(rs.getInt(8));
		    		 model.setArticulated(rs.getString(9));
		    		 model.setBirthday(rs.getDate(10));
		    		 model.setLastName(rs.getString(11));
		    		 model.setFirstName(rs.getString(12));
		    		 model.setTerminalName(rs.getString(13));
		    		 model.setAge(rs.getInt(14));
		    		 model.setDateHired(rs.getDate(15));
		    		 model.setLicenseNo(rs.getString(16));
		    		 model.setLicenseValidity(rs.getDate(17));
		    		 model.setBirthday(rs.getDate(18));
		    		 model.setPhilhealthNo(rs.getString(19));
		    		 model.setFtw(rs.getDate(20));
		    		 model.setNbi(rs.getDate(21));
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
			    	 sqlCount = new StringBuffer("select count(*) from transport.tran_driver_training a where a.active = true");	 
			     }else {
			    	 sqlCount = new StringBuffer("select count(*) from transport.tran_driver_training a, transport.file_employee b where a.driverid = b.id and  (b.lastname ilike '%"+criteria+"%' or b.lastname ilike '%"+criteria+"%') and a.active = true");	 
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

	@Override
	public Map<String, Object> getDataById(HashMap<String, Object> criteriaMap)
			throws Exception {
		// TODO Auto-generated method stub
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_GETDATA_BY_ID);
		 
		    //get the model criteria
		    DriverTraining  model = (DriverTraining ) criteriaMap.get(MapConstant.CLASS_DATA);

		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
		     Map<String, Object> returnMap = null;
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer("select a.id,a.driverid,a.sss,a.pagibig,a.tin,a.picname,a.pic ");
				 	sql.append(" ,a.terminalid,a.articulated,a.birthday,extract(year from age(a.birthday)) as age ");
				 	sql.append(" ,a.datehired,a.licenseno,a.licensevalidity,a.contactno,a.religion,a.gender,a.civilstatus ");
				 	sql.append(" ,a.spouse,a.philhealthno,a.height,a.weight,a.mothersname,a.fathersname,a.address ");
				 	sql.append(" ,a.elementary,a.elementarydate,a.secondary,a.secondarydate,a.tertiary,a.tertiarydate ");
				 	sql.append(" ,a.employmentdatefrom1,a.employmentdateto1,a.employmentposition1,a.employmentcompany1 ");
				 	sql.append(" ,a.employmentdatefrom2,a.employmentdateto2,a.employmentposition2,a.employmentcompany2 ");
				 	sql.append(" ,a.employmentdatefrom3,a.employmentdateto3,a.employmentposition3,a.employmentcompany3 ");
				 	sql.append(" ,a.ftw,a.nbi ");
				 	sql.append(" from transport.tran_driver_training a ");
				 	sql.append(" where a.id = ?");
			
				 TransportUtils.writeLogDebug(logger, "SQL: "+sql.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, model.getId());
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
		    		 model.setId(rs.getInt(1));
		    		 model.setDriverId(rs.getInt(2));
		    		 model.setSss(rs.getString(3));
		    		 model.setPagibig(rs.getString(4));
		    		 model.setTin(rs.getString(5));
		    		 model.setPicName(rs.getString(6));
		    		 if (rs.getBytes(7)!=null){
		    			 model.setPicStr(TransportUtils.getPicBase64String(rs.getBytes(7)));
		    		 }
		    		 model.setTerminalId(rs.getInt(8));
		    		 model.setArticulated(rs.getString(9));
		    		 model.setBirthday(rs.getDate(10));
		    		 model.setAge(rs.getInt(11));
		    		 model.setDateHired(rs.getDate(12));
		    		 model.setLicenseNo(rs.getString(13));
		    		 model.setLicenseValidity(rs.getDate(14));
		    		 model.setContactNo(rs.getString(15));
		    		 model.setReligion(rs.getString(16));
		    		 model.setGender(rs.getString(17));
		    		 model.setCivilStatus(rs.getString(18));
		    		 model.setSpouse(rs.getString(19));
		    		 model.setPhilhealthNo(rs.getString(20));
		    		 model.setHeight(rs.getString(21));
		    		 model.setWeight(rs.getString(22));
		    		 model.setMothersName(rs.getString(23));
		    		 model.setFathersName(rs.getString(24));
		    		 model.setAddress(rs.getString(25));
		    		 model.setElementary(rs.getString(26));
		    		 model.setElementaryDate(rs.getString(27));
		    		 model.setSecondary(rs.getString(28));
		    		 model.setSecondaryDate(rs.getString(29));
		    		 model.setTertiary(rs.getString(30));
		    		 model.setTertiaryDate(rs.getString(31));
		    		 model.setEmploymentDateFrom1(rs.getString(32));
		    		 model.setEmploymentDateTo1(rs.getString(33));
		    		 model.setEmploymentPosition1(rs.getString(34));
		    		 model.setEmploymentCompany1(rs.getString(35));
		    		 model.setEmploymentDateFrom2(rs.getString(36));
		    		 model.setEmploymentDateTo2(rs.getString(37));
		    		 model.setEmploymentPosition2(rs.getString(38));
		    		 model.setEmploymentCompany2(rs.getString(39));
		    		 model.setEmploymentDateFrom3(rs.getString(40));
		    		 model.setEmploymentDateTo3(rs.getString(41));
		    		 model.setEmploymentPosition3(rs.getString(42));
		    		 model.setEmploymentCompany3(rs.getString(43));
		    		 model.setFtw(rs.getDate(44));
		    		 model.setNbi(rs.getDate(45));
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
			 List<DriverTraining > rsList = new ArrayList<DriverTraining >();
			  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer("select a.id,a.driverid,a.sss,a.pagibig,a.tin,a.picname,a.pic,a.terminalid,a.articulated ");
				 	sql.append(" ,a.birthday,b.lastname,b.firstname,c.name as terminalname,extract(year from age(birthday)) as age,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
				 	sql.append(" from transport.tran_driver_training a, transport.file_employee b, transport.file_terminal c ");
				 	sql.append(" where a.driverid = b.id ");
				 	sql.append(" and a.terminalid = c.id ");
				 	sql.append(" and a.active = true ");
				 	sql.append(" order by b.lastname ");

			
				 TransportUtils.writeLogDebug(logger, "SQL: "+sql.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
					 //get the model criteria
					 DriverTraining model = new DriverTraining();  
		    		 model.setId(rs.getInt(1));
		    		 model.setDriverId(rs.getInt(2));
		    		 model.setSss(rs.getString(3));
		    		 model.setPagibig(rs.getString(4));
		    		 model.setTin(rs.getString(5));
		    		 model.setPicName(rs.getString(6));
		    		 if (rs.getBytes(7)!=null){
		    			 model.setPicStr(TransportUtils.getPicBase64String(rs.getBytes(7)));
		    		 }
		    		 model.setTerminalId(rs.getInt(8));
		    		 model.setArticulated(rs.getString(9));
		    		 model.setBirthday(rs.getDate(10));
		    		 model.setLastName(rs.getString(11));
		    		 model.setFirstName(rs.getString(12));
		    		 model.setTerminalName(rs.getString(13));
		    		 model.setAge(rs.getInt(14));
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
			 List<DriverTraining > rsList = new ArrayList<DriverTraining >();
			  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer("select a.id,a.driverid,a.sss,a.pagibig,a.tin,a.picname,a.pic,a.terminalid,a.articulated ");
				 	sql.append(" ,a.birthday,b.lastname,b.firstname,c.name as terminalname,extract(year from age(birthday)) as age,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
				 	sql.append(" from transport.tran_driver_training a, transport.file_employee b, transport.file_terminal c ");
				 	sql.append(" where a.driverid = b.id ");
				 	sql.append(" and a.terminalid = c.id ");
				 	sql.append(" and a.active = false ");
				 	sql.append(" order by b.lastname ");
				 	sql.append(" limit ? ");
				 	sql.append(" offset ? ");

				 TransportUtils.writeLogDebug(logger, "SQL: "+sql.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, limit);
				 pstmt.setInt(2, offset);
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
					 //get the model criteria
					 DriverTraining model = new DriverTraining();  
		    		 model.setId(rs.getInt(1));
		    		 model.setDriverId(rs.getInt(2));
		    		 model.setSss(rs.getString(3));
		    		 model.setPagibig(rs.getString(4));
		    		 model.setTin(rs.getString(5));
		    		 model.setPicName(rs.getString(6));
		    		 if (rs.getBytes(7)!=null){
		    			 model.setPicStr(TransportUtils.getPicBase64String(rs.getBytes(7)));
		    		 }
		    		 model.setTerminalId(rs.getInt(8));
		    		 model.setArticulated(rs.getString(9));
		    		 model.setBirthday(rs.getDate(10));
		    		 model.setLastName(rs.getString(11));
		    		 model.setFirstName(rs.getString(12));
		    		 model.setTerminalName(rs.getString(13));
		    		 model.setAge(rs.getInt(14));
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
		    	 
			    sqlCount = new StringBuffer("select count(*) from transport.tran_driver_training where active = false");	 

				StringBuffer sqlCountLog = null;
				sqlCountLog = new StringBuffer("select count(*) from transport.tran_driver_training where active = false");	 

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
		
		DriverTraining  model = (DriverTraining ) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update transport.tran_driver_training set ");	
			qry.append(" active=true ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");

		StringBuffer qryLog =  new StringBuffer("update transport.tran_driver_training set ");	
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
				System.out.println("DriverInfo  record (id: " +model.getId()+") restored successfully..");
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
	public Map<String, Object> getDataByDriverId(HashMap<String, Object> criteriaMap) throws Exception {
		// TODO Auto-generated method stub
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_GETDATA_BY_DRIVER_ID);
		 
		    //get the model criteria
		    DriverTraining  model = (DriverTraining ) criteriaMap.get(MapConstant.CLASS_DATA);

		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
		     Map<String, Object> returnMap = null;
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();				
				 	sql = new StringBuffer("select a.id,a.driverid,a.sss,a.pagibig,a.tin,a.picname,a.pic ");
				 	sql.append(" ,a.terminalid,a.articulated,a.birthday,extract(year from age(birthday)) as age,b.lastname,b.firstname ");
				 	sql.append(" ,a.datehired,a.licenseno,a.licensevalidity,a.contactno,a.religion,a.gender,a.civilstatus ");
				 	sql.append(" ,a.spouse,a.philhealthno,a.height,a.weight,a.mothersname,a.fathersname,a.address ");
				 	sql.append(" ,a.elementary,a.elementarydate,a.secondary,a.secondarydate,a.tertiary,a.tertiarydate ");
				 	sql.append(" ,a.employmentdatefrom1,a.employmentdateto1,a.employmentposition1,a.employmentcompany1 ");
				 	sql.append(" ,a.employmentdatefrom2,a.employmentdateto2,a.employmentposition2,a.employmentcompany2 ");
				 	sql.append(" ,a.employmentdatefrom3,a.employmentdateto3,a.employmentposition3,a.employmentcompany3 ");
				 	sql.append(" ,a.ftw,a.nbi ");
				 	sql.append(" from transport.tran_driver_training a, transport.file_employee b ");
				 	sql.append(" where a.driverid = b.id ");
				 	sql.append(" and a.driverid = ?");
				 	sql.append(" and a.active = true");
			
				 TransportUtils.writeLogDebug(logger, "SQL: "+sql.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, model.getDriverId());
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
		    		 model.setId(rs.getInt(1));
		    		 model.setDriverId(rs.getInt(2));
		    		 model.setSss(rs.getString(3));
		    		 model.setPagibig(rs.getString(4));
		    		 model.setTin(rs.getString(5));
		    		 model.setPicName(rs.getString(6));
		    		 if (rs.getBytes(7)!=null){
		    			 model.setPicStr(TransportUtils.getPicBase64String(rs.getBytes(7)));
		    		 }
		    		 model.setTerminalId(rs.getInt(8));
		    		 model.setArticulated(rs.getString(9));
		    		 model.setBirthday(rs.getDate(10));
		    		 model.setAge(rs.getInt(11));
		    		 model.setLastName(rs.getString(12));
		    		 model.setFirstName(rs.getString(13));
		    		 model.setDateHired(rs.getDate(14));
		    		 model.setLicenseNo(rs.getString(15));
		    		 model.setLicenseValidity(rs.getDate(16));
		    		 model.setContactNo(rs.getString(17));
		    		 model.setReligion(rs.getString(18));
		    		 model.setGender(rs.getString(19));
		    		 model.setCivilStatus(rs.getString(20));
		    		 model.setSpouse(rs.getString(21));
		    		 model.setPhilhealthNo(rs.getString(22));
		    		 model.setHeight(rs.getString(23));
		    		 model.setWeight(rs.getString(24));
		    		 model.setMothersName(rs.getString(25));
		    		 model.setFathersName(rs.getString(26));
		    		 model.setAddress(rs.getString(27));
		    		 model.setElementary(rs.getString(28));
		    		 model.setElementaryDate(rs.getString(29));
		    		 model.setSecondary(rs.getString(30));
		    		 model.setSecondaryDate(rs.getString(31));
		    		 model.setTertiary(rs.getString(32));
		    		 model.setTertiaryDate(rs.getString(33));
		    		 model.setEmploymentDateFrom1(rs.getString(34));
		    		 model.setEmploymentDateTo1(rs.getString(35));
		    		 model.setEmploymentPosition1(rs.getString(36));
		    		 model.setEmploymentCompany1(rs.getString(37));
		    		 model.setEmploymentDateFrom2(rs.getString(38));
		    		 model.setEmploymentDateTo2(rs.getString(39));
		    		 model.setEmploymentPosition2(rs.getString(40));
		    		 model.setEmploymentCompany2(rs.getString(41));
		    		 model.setEmploymentDateFrom3(rs.getString(42));
		    		 model.setEmploymentDateTo3(rs.getString(43));
		    		 model.setEmploymentPosition3(rs.getString(44));
		    		 model.setEmploymentCompany3(rs.getString(45));
		    		 model.setFtw(rs.getDate(46));
		    		 model.setNbi(rs.getDate(47));
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
	     
	     
	    System.out.println("getDataByDriverId() - Exit");
		return returnMap;
	}


}
