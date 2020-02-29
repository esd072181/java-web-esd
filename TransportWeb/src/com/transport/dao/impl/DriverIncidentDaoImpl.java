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
import com.transport.dao.DriverIncidentDao;
import com.transport.model.DriverIncident;
import com.transport.model.User;
import com.transport.util.TransportUtils;

/**
 * 
 * @author dward
 * @since 09-Dec-2019
 */
public class DriverIncidentDaoImpl implements DriverIncidentDao {
	
	private final static Logger logger = Logger.getLogger(DriverIncidentDaoImpl.class);

	@Override
	public Map<String, Object> save(HashMap<String, Object> dataMap) throws Exception{
		
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SAVE);

		//DBCP JNDI
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean status = false;
		
		DriverIncident model = (DriverIncident) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setCreatedBy((int) user.getId());	
		}
		model.setCreatedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("insert into transport.tran_incident (");
				qry.append("acknowstat ");
		  		qry.append(",acknowremarks ");
		  		qry.append(",reportstat ");
		  		qry.append(",reportremarks ");
		  		qry.append(",companystat ");
		  		qry.append(",companyremarks ");
		  		qry.append(",incabstat ");
		  		qry.append(",incabremarks ");
		  		qry.append(",dwhstat ");
		  		qry.append(",dwhremarks ");
		  		qry.append(",gpsstat ");
		  		qry.append(",gpsremarks ");
		  		qry.append(",ebstat ");
		  		qry.append(",ebremarks ");
		  		qry.append(",alcoholstat ");
		  		qry.append(",alcoholremarks ");
		  		qry.append(",driversstat ");
		  		qry.append(",driversremarks ");
		  		qry.append(",policestat ");
		  		qry.append(",policeremarks ");
		  		qry.append(",photostat ");
		  		qry.append(",photoremarks ");
		  		qry.append(",picdamagestat ");
		  		qry.append(",picdamageremarks ");
		  		qry.append(",picplatestat ");
		  		qry.append(",picplateremarks ");
		  		qry.append(",startstat ");
		  		qry.append(",startremarks ");
		  		qry.append(",withinveststat ");
		  		qry.append(",withinvestremarks ");
		  		qry.append(",priorstat ");
		  		qry.append(",priorremarks ");
		  		qry.append(",nameone ");
		  		qry.append(",positionone ");
		  		qry.append(",nametwo ");
		  		qry.append(",positiontwo ");
		  		qry.append(",incidentdate ");
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
		  		qry.append(" ,1 ");
		  		qry.append(" ,true ");
		  		qry.append(" ) ");

		StringBuffer qryLog =  new StringBuffer("insert into transport.tran_incident (");
				qryLog.append("acknowstat ");
				qryLog.append(",acknowremarks ");
				qryLog.append(",reportstat ");
				qryLog.append(",reportremarks ");
				qryLog.append(",companystat ");
		  		qryLog.append(",companyremarks ");
		  		qryLog.append(",incabstat ");
		  		qryLog.append(",incabremarks ");
		  		qryLog.append(",dwhstat ");
		  		qryLog.append(",dwhremarks ");
		  		qryLog.append(",gpsstat ");
		  		qryLog.append(",gpsremarks ");
		  		qryLog.append(",ebstat ");
		  		qryLog.append(",ebremarks ");
		  		qryLog.append(",alcoholstat ");
		  		qryLog.append(",alcoholremarks ");
		  		qryLog.append(",driversstat ");
		  		qryLog.append(",driversremarks ");
		  		qryLog.append(",policestat ");
		  		qryLog.append(",policeremarks ");
		  		qryLog.append(",photostat ");
		  		qryLog.append(",photoremarks ");
		  		qryLog.append(",picdamagestat ");
		  		qryLog.append(",picdamageremarks ");
		  		qryLog.append(",picplatestat ");
		  		qryLog.append(",picplateremarks ");
		  		qryLog.append(",startstat ");
		  		qryLog.append(",startremarks ");
		  		qryLog.append(",withinveststat ");
		  		qryLog.append(",withinvestremarks ");
		  		qryLog.append(",priorstat ");
		  		qryLog.append(",priorremarks ");
		  		qryLog.append(",nameone ");
		  		qryLog.append(",positionone ");
		  		qryLog.append(",nametwo ");
		  		qryLog.append(",positiontwo ");
		  		qryLog.append(",incidentdate ");
				qryLog.append(",createdby ");
				qryLog.append(",createdon ");
				qryLog.append(",version ");
				qryLog.append(",active ");
				qryLog.append(" ) ");
				qryLog.append(" values ");
				qryLog.append(" ( ");
				qryLog.append(model.getAcknowStat());
				qryLog.append(" ,"+model.getAcknowRemarks());
				qryLog.append(model.getReportStat());
				qryLog.append(" ,"+model.getReportRemarks());
				qryLog.append(model.getCompanyStat());
				qryLog.append(" ,"+model.getCompanyRemarks());
				qryLog.append(model.getIncabStat());
				qryLog.append(" ,"+model.getIncabRemarks());
				qryLog.append(model.getDwhStat());
				qryLog.append(" ,"+model.getDwhRemarks());
				qryLog.append(model.getGpsStat());
				qryLog.append(" ,"+model.getGpsRemarks());
				qryLog.append(model.getEbStat());
				qryLog.append(" ,"+model.getEbRemarks());
				qryLog.append(model.getAlcoholStat());
				qryLog.append(" ,"+model.getAlcoholRemarks());
				qryLog.append(model.getDriversStat());
				qryLog.append(" ,"+model.getDriversRemarks());
				qryLog.append(model.getPoliceStat());
				qryLog.append(" ,"+model.getPoliceRemarks());
				qryLog.append(model.getPhotoStat());
				qryLog.append(" ,"+model.getPhotoRemarks());
				qryLog.append(model.getPicDamageStat());
				qryLog.append(" ,"+model.getPicDamageRemarks());
				qryLog.append(model.getPicPlateStat());
				qryLog.append(" ,"+model.getPicPlateRemarks());
				qryLog.append(model.getStartStat());
				qryLog.append(" ,"+model.getStartRemarks());
				qryLog.append(model.getWithInvestStat());
				qryLog.append(" ,"+model.getWithInvestRemarks());
				qryLog.append(model.getPriorStat());
				qryLog.append(" ,"+model.getPriorRemarks());
				qryLog.append(" ,"+model.getNameOne());
				qryLog.append(" ,"+model.getPositionOne());
				qryLog.append(" ,"+model.getNameTwo());
				qryLog.append(" ,"+model.getPositionTwo());
				qryLog.append(" ,"+model.getIncidentDate());
				qryLog.append(" ,"+model.getCreatedBy());
				qryLog.append(" ,"+model.getCreatedOn());
				qryLog.append(" ,1 ");
				qryLog.append(" ,true ");
				qryLog.append(" ) ");
					
		TransportUtils.writeLogDebug(logger, "SQL: "+qryLog.toString());
  		  		
		  try {
			  conn = ServerContext.getJDBCHandle();
			  conn.setAutoCommit(false);
			  pstmt = conn.prepareStatement(qry.toString());
			     
			  pstmt.setString(1, model.getAcknowStat());
			  pstmt.setString(2, model.getAcknowRemarks());
			  pstmt.setString(3, model.getReportStat());
			  pstmt.setString(4, model.getReportRemarks());
			  pstmt.setString(5, model.getCompanyStat());
			  pstmt.setString(6, model.getCompanyRemarks());
			  pstmt.setString(7, model.getIncabStat());
			  pstmt.setString(8, model.getIncabRemarks());
			  pstmt.setString(9, model.getDwhStat());
			  pstmt.setString(10, model.getDwhRemarks());
			  pstmt.setString(11, model.getGpsStat());
			  pstmt.setString(12, model.getGpsRemarks());
			  pstmt.setString(13, model.getEbStat());
			  pstmt.setString(14, model.getEbRemarks());
			  pstmt.setString(15, model.getAlcoholStat());
			  pstmt.setString(16, model.getAlcoholRemarks());
			  pstmt.setString(17, model.getDriversStat());
			  pstmt.setString(18, model.getDriversRemarks());
			  pstmt.setString(19, model.getPoliceStat());
			  pstmt.setString(20, model.getPoliceRemarks());
			  pstmt.setString(21, model.getPhotoStat());
			  pstmt.setString(22, model.getPhotoRemarks());
			  pstmt.setString(23, model.getPicDamageStat());
			  pstmt.setString(24, model.getPicDamageRemarks());
			  pstmt.setString(25, model.getPicPlateStat());
			  pstmt.setString(26, model.getPicPlateRemarks());
			  pstmt.setString(27, model.getStartStat());
			  pstmt.setString(28, model.getStartRemarks());
			  pstmt.setString(29, model.getWithInvestStat());
			  pstmt.setString(30, model.getWithInvestRemarks());
			  pstmt.setString(31, model.getPriorStat());
			  pstmt.setString(32, model.getPriorRemarks());
			  pstmt.setString(33, model.getNameOne());
			  pstmt.setString(34, model.getPositionOne());
			  pstmt.setString(35, model.getNameTwo());
			  pstmt.setString(36, model.getPositionTwo());
			  pstmt.setDate(37, model.getIncidentDate());
			  pstmt.setInt(38, model.getCreatedBy());
			  pstmt.setTimestamp(39, model.getCreatedOn());
			     
			  int statusInt = pstmt.executeUpdate();
			     
			  if (statusInt == 1) {
				  conn.commit();
				  System.out.println("Inserted into DriverIncident table successfully..");
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
		
		DriverIncident model = (DriverIncident) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update transport.tran_incident set ");	
			qry.append(" acknowstat=? ");
			qry.append(" ,acknowremarks=? ");
			qry.append(" ,reportstat=? ");
			qry.append(" ,reportremarks=? ");
			qry.append(" ,companystat=? ");
			qry.append(" ,companyremarks=? ");
			qry.append(" ,incabstat=? ");
			qry.append(" ,incabremarks=? ");
			qry.append(" ,dwhstat=? ");
			qry.append(" ,dwhremarks=? ");
			qry.append(" ,gpsstat=? ");
			qry.append(" ,gpsremarks=? ");
			qry.append(" ,ebstat=? ");
			qry.append(" ,ebremarks=? ");
			qry.append(" ,alcoholstat=? ");
			qry.append(" ,alcoholremarks=? ");
			qry.append(" ,driversstat=? ");
			qry.append(" ,driversremarks=? ");
			qry.append(" ,policestat=? ");
			qry.append(" ,policeremarks=? ");
			qry.append(" ,photostat=? ");
			qry.append(" ,photoremarks=? ");
			qry.append(" ,picdamagestat=? ");
			qry.append(" ,picdamageremarks=? ");
			qry.append(" ,picplatestat=? ");
			qry.append(" ,picplateremarks=? ");
			qry.append(" ,startstat=? ");
			qry.append(" ,startremarks=? ");
			qry.append(" ,withinveststat=? ");
			qry.append(" ,withinvestremarks=? ");
			qry.append(" ,priorstat=? ");
			qry.append(" ,priorremarks=? ");
			qry.append(" ,nameone=? ");
			qry.append(" ,positionone=? ");
			qry.append(" ,nametwo=? ");
			qry.append(" ,positiontwo=? ");
			qry.append(" ,incidentdate=? ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");

		StringBuffer qryLog =  new StringBuffer("update transport.tran_incident set ");	
			qryLog.append(" acknowstat="+model.getAcknowStat());
			qryLog.append(" ,acknowremarks="+model.getAcknowRemarks());
			qryLog.append(" ,reportstat="+model.getReportStat());
			qryLog.append(" ,reportremarks="+model.getReportRemarks());
			qryLog.append(" ,companystat="+model.getCompanyStat());
			qryLog.append(" ,companyremarks="+model.getCompanyRemarks());
			qryLog.append(" ,incabstat="+model.getIncabStat());
			qryLog.append(" ,incabremarks="+model.getIncabRemarks());
			qryLog.append(" ,dwhstat="+model.getDwhStat());
			qryLog.append(" ,dwhremarks="+model.getDwhRemarks());
			qryLog.append(" ,gpsstat="+model.getGpsStat());
			qryLog.append(" ,gpsremarks="+model.getGpsRemarks());
			qryLog.append(" ,ebstat="+model.getEbStat());
			qryLog.append(" ,ebremarks="+model.getEbRemarks());
			qryLog.append(" ,alcoholstat="+model.getAlcoholStat());
			qryLog.append(" ,alcoholremarks="+model.getAlcoholRemarks());
			qryLog.append(" ,driversstat="+model.getDriversStat());
			qryLog.append(" ,driversremarks="+model.getDriversRemarks());
			qryLog.append(" ,policestat="+model.getPoliceStat());
			qryLog.append(" ,policeremarks="+model.getPoliceRemarks());
			qryLog.append(" ,photostat="+model.getPhotoStat());
			qryLog.append(" ,photoremarks="+model.getPhotoRemarks());
			qryLog.append(" ,picdamagestat="+model.getPicDamageStat());
			qryLog.append(" ,picdamageremarks="+model.getPicDamageRemarks());
			qryLog.append(" ,picplatestat="+model.getPicPlateStat());
			qryLog.append(" ,picplateremarks="+model.getPicPlateRemarks());
			qryLog.append(" ,startstat="+model.getStartStat());
			qryLog.append(" ,startremarks="+model.getStartRemarks());
			qryLog.append(" ,withinveststat="+model.getWithInvestStat());
			qryLog.append(" ,withinvestremarks="+model.getWithInvestRemarks());
			qryLog.append(" ,priorstat="+model.getPriorStat());
			qryLog.append(" ,priorremarks="+model.getPriorRemarks());
			qryLog.append(" ,nameone="+model.getNameOne());
			qryLog.append(" ,positionone="+model.getPositionOne());
			qryLog.append(" ,nametwo="+model.getNameTwo());
			qryLog.append(" ,positiontwo="+model.getPositionTwo());
			qryLog.append(" ,incidentdate="+model.getIncidentDate());
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
				     
			pstmt.setString(1, model.getAcknowStat());
			pstmt.setString(2, model.getAcknowRemarks());
			pstmt.setString(3, model.getReportStat());
			pstmt.setString(4, model.getReportRemarks());
			pstmt.setString(5, model.getCompanyStat());
			pstmt.setString(6, model.getCompanyRemarks());
			pstmt.setString(7, model.getIncabStat());
			pstmt.setString(8, model.getIncabRemarks());
			pstmt.setString(9, model.getDwhStat());
			pstmt.setString(10, model.getDwhRemarks());
			pstmt.setString(11, model.getGpsStat());
			pstmt.setString(12, model.getGpsRemarks());
			pstmt.setString(13, model.getEbStat());
			pstmt.setString(14, model.getEbRemarks());
			pstmt.setString(15, model.getAlcoholStat());
			pstmt.setString(16, model.getAlcoholRemarks());
			pstmt.setString(17, model.getDriversStat());
			pstmt.setString(18, model.getDriversRemarks());
			pstmt.setString(19, model.getPoliceStat());
			pstmt.setString(20, model.getPoliceRemarks());
			pstmt.setString(21, model.getPhotoStat());
			pstmt.setString(22, model.getPhotoRemarks());
			pstmt.setString(23, model.getPicDamageStat());
			pstmt.setString(24, model.getPicDamageRemarks());
			pstmt.setString(25, model.getPicPlateStat());
			pstmt.setString(26, model.getPicPlateRemarks());
			pstmt.setString(27, model.getStartStat());
			pstmt.setString(28, model.getStartRemarks());
			pstmt.setString(29, model.getWithInvestStat());
			pstmt.setString(30, model.getWithInvestRemarks());
			pstmt.setString(31, model.getPriorStat());
			pstmt.setString(32, model.getPriorRemarks());
			pstmt.setString(33, model.getNameOne());
			pstmt.setString(34, model.getPositionOne());
			pstmt.setString(35, model.getNameTwo());
			pstmt.setString(36, model.getPositionTwo());
			pstmt.setDate(37, model.getIncidentDate());
			pstmt.setInt(38, model.getModifiedBy());
			pstmt.setTimestamp(39, model.getModifiedOn());
			pstmt.setLong(40, model.getId());
				     
			int statusInt = pstmt.executeUpdate();
				     
			if (statusInt == 1) {
				conn.commit();
				System.out.println("DriverIncident record (id: " +model.getId()+") updated successfully..");
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
		
		DriverIncident model = (DriverIncident) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update transport.tran_incident set ");	
			qry.append(" active=false ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");

		StringBuffer qryLog =  new StringBuffer("update transport.tran_incident set ");	
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
				System.out.println("DriverIncident record (id: " +model.getId()+") deleted successfully..");
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
			 
			  List<DriverIncident> rsList = new ArrayList<DriverIncident>();
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = null;
				 if (category.equals(ActionConstant.SEARCHALL)) {
					 sql = new StringBuffer("select a.id,a.acknowstat,a.acknowremarks,a.reportstat,a.reportremarks,a.companystat,a.companyremarks,a.incabstat,a.incabremarks,");
					    sql.append(" a.dwhstat,a.dwhremarks,a.gpsstat,a.gpsremarks,a.ebstat,a.ebremarks,a.alcoholstat,a.alcoholremarks,a.driversstat,a.driversremarks, ");
					    sql.append(" a.policestat,a.policeremarks,a.photostat,a.photoremarks,a.picdamagestat,a.picdamageremarks,a.picplatestat,a.picplateremarks, ");
					    sql.append(" a.startstat,a.startremarks,a.withinveststat,a.withinvestremarks, ");
					    sql.append(" a.priorstat,a.priorremarks,a.nameone,a.positionone,a.nametwo,a.positiontwo,a.incidentdate, ");
					 	sql.append(" a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
					 	sql.append(" from transport.tran_incident a ");
					 	sql.append(" where a.active = true ");
					 	sql.append(" order by a.incidentdate desc ");
					 	sql.append(" limit ? ");
					 	sql.append(" offset ?");		 
				 } else {
					 sql = new StringBuffer("select a.id,a.acknowstat,a.acknowremarks,a.reportstat,a.reportremarks,a.companystat,a.companyremarks,a.incabstat,a.incabremarks,");
					    sql.append(" a.dwhstat,a.dwhremarks,a.gpsstat,a.gpsremarks,a.ebstat,a.ebremarks,a.alcoholstat,a.alcoholremarks,a.driversstat,a.driversremarks, ");
					    sql.append(" a.policestat,a.policeremarks,a.photostat,a.photoremarks,a.picdamagestat,a.picdamageremarks,a.picplatestat,a.picplateremarks, ");
					    sql.append(" a.startstat,a.startremarks,a.withinveststat,a.withinvestremarks, ");
					    sql.append(" a.priorstat,a.priorremarks,a.nameone,a.positionone,a.nametwo,a.positiontwo,a.incidentdate, ");
					 	sql.append(" a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
					 	sql.append(" from transport.tran_incident a ");
					 	sql.append(" where (a.nameone ilike '%"+criteria+"%' or a.nametwo ilike '%"+criteria+"%')" );
					 	sql.append(" and a.active = true ");
					 	sql.append(" order by a.incidentdate desc ");
					 	sql.append(" limit ? ");
					 	sql.append(" offset ?");	
				 }


						 
				TransportUtils.writeLogDebug(logger, "SQL: "+sql.toString());
					
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, limit);
				 pstmt.setInt(2, offset);
				 
				 rs = pstmt.executeQuery();
				 
				 while(rs.next()) {
					 DriverIncident model=new DriverIncident();  
		    		 model.setId(rs.getInt(1));
		    		 model.setAcknowStat(rs.getString(2));
		    		 model.setAcknowRemarks(rs.getString(3));
		    		 model.setReportStat(rs.getString(4));
		    		 model.setReportRemarks(rs.getString(5));
		    		 model.setCompanyStat(rs.getString(6));
		    		 model.setCompanyRemarks(rs.getString(7));
		    		 model.setIncabStat(rs.getString(8));
		    		 model.setIncabRemarks(rs.getString(9));
		    		 model.setDwhStat(rs.getString(10));
		    		 model.setDwhRemarks(rs.getString(11));
		    		 model.setGpsStat(rs.getString(12));
		    		 model.setGpsRemarks(rs.getString(13));
		    		 model.setEbStat(rs.getString(14));
		    		 model.setEbRemarks(rs.getString(15));
		    		 model.setAlcoholStat(rs.getString(16));
		    		 model.setAlcoholRemarks(rs.getString(17));
		    		 model.setDriversStat(rs.getString(18));
		    		 model.setDriversRemarks(rs.getString(19));
		    		 model.setPoliceStat(rs.getString(20));
		    		 model.setPoliceRemarks(rs.getString(21));
		    		 model.setPhotoStat(rs.getString(22));
		    		 model.setPhotoRemarks(rs.getString(23));
		    		 model.setPicDamageStat(rs.getString(24));
		    		 model.setPicDamageRemarks(rs.getString(25));
		    		 model.setPicPlateStat(rs.getString(26));
		    		 model.setPicPlateRemarks(rs.getString(27));
		    		 model.setStartStat(rs.getString(28));
		    		 model.setStartRemarks(rs.getString(29));
		    		 model.setWithInvestStat(rs.getString(30));
		    		 model.setWithInvestRemarks(rs.getString(31));
		    		 model.setPriorStat(rs.getString(32));
		    		 model.setPriorRemarks(rs.getString(33));
		    		 model.setNameOne(rs.getString(34));
		    		 model.setPositionOne(rs.getString(35));
		    		 model.setNameTwo(rs.getString(36));
		    		 model.setPositionTwo(rs.getString(37));
		    		 model.setIncidentDate(rs.getDate(38));
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
			    	 sqlCount = new StringBuffer("select count(*) from transport.tran_incident where active = true");	 
			     }else {
			    	 sqlCount = new StringBuffer("select count(*) from transport.tran_incident where  (nameone ilike '%"+criteria+"%' or nametwo ilike '%"+criteria+"%') and active = true");	 
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
		    DriverIncident model = (DriverIncident) criteriaMap.get(MapConstant.CLASS_DATA);

		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
		     Map<String, Object> returnMap = null;
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer("select a.id,a.acknowstat,a.acknowremarks,a.reportstat,a.reportremarks,a.companystat,a.companyremarks,a.incabstat,a.incabremarks,");
				    sql.append(" a.dwhstat,a.dwhremarks,a.gpsstat,a.gpsremarks,a.ebstat,a.ebremarks,a.alcoholstat,a.alcoholremarks,a.driversstat,a.driversremarks, ");
				    sql.append(" a.policestat,a.policeremarks,a.photostat,a.photoremarks,a.picdamagestat,a.picdamageremarks,a.picplatestat,a.picplateremarks, ");
				    sql.append(" a.startstat,a.startremarks,a.withinveststat,a.withinvestremarks, ");				   
				    sql.append(" a.priorstat,a.priorremarks,a.nameone,a.positionone,a.nametwo,a.positiontwo,a.incidentdate, ");
				 	sql.append(" a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
				 	sql.append(" from transport.tran_incident a ");
				 	sql.append(" where a.id = ?");

				 StringBuffer sqlLog = new StringBuffer("select a.id,a.acknowstat,a.acknowremarks,a.reportstat,a.reportremarks,a.companystat,a.companyremarks,a.incabstat,a.incabremarks,");
				 	sqlLog.append(" a.dwhstat,a.dwhremarks,a.gpsstat,a.gpsremarks,a.ebstat,a.ebremarks,a.alcoholstat,a.alcoholremarks,a.driversstat,a.driversremarks, ");
				 	sqlLog.append(" a.policestat,a.policeremarks,a.photostat,a.photoremarks,a.picdamagestat,a.picdamageremarks,a.picplatestat,a.picplateremarks, ");
				 	sqlLog.append(" a.startstat,a.startremarks,a.withinveststat,a.withinvestremarks, ");
					sqlLog.append(" a.priorstat,a.priorremarks,a.nameone,a.positionone,a.nametwo,a.positiontwo,a.incidentdate, ");
					sqlLog.append(" a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
					sqlLog.append(" from transport.tran_incident a ");
				 	sqlLog.append(" where a.id = "+ model.getId());
			
				 TransportUtils.writeLogDebug(logger, "SQL: "+sqlLog.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, model.getId());
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
					 model.setId(rs.getInt(1));
		    		 model.setAcknowStat(rs.getString(2));
		    		 model.setAcknowRemarks(rs.getString(3));
		    		 model.setReportStat(rs.getString(4));
		    		 model.setReportRemarks(rs.getString(5));
		    		 model.setCompanyStat(rs.getString(6));
		    		 model.setCompanyRemarks(rs.getString(7));
		    		 model.setIncabStat(rs.getString(8));
		    		 model.setIncabRemarks(rs.getString(9));
		    		 model.setDwhStat(rs.getString(10));
		    		 model.setDwhRemarks(rs.getString(11));
		    		 model.setGpsStat(rs.getString(12));
		    		 model.setGpsRemarks(rs.getString(13));
		    		 model.setEbStat(rs.getString(14));
		    		 model.setEbRemarks(rs.getString(15));
		    		 model.setAlcoholStat(rs.getString(16));
		    		 model.setAlcoholRemarks(rs.getString(17));
		    		 model.setDriversStat(rs.getString(18));
		    		 model.setDriversRemarks(rs.getString(19));
		    		 model.setPoliceStat(rs.getString(20));
		    		 model.setPoliceRemarks(rs.getString(21));
		    		 model.setPhotoStat(rs.getString(22));
		    		 model.setPhotoRemarks(rs.getString(23));
		    		 model.setPicDamageStat(rs.getString(24));
		    		 model.setPicDamageRemarks(rs.getString(25));
		    		 model.setPicPlateStat(rs.getString(26));
		    		 model.setPicPlateRemarks(rs.getString(27));
		    		 model.setStartStat(rs.getString(28));
		    		 model.setStartRemarks(rs.getString(29));
		    		 model.setWithInvestStat(rs.getString(30));
		    		 model.setWithInvestRemarks(rs.getString(31));
		    		 model.setPriorStat(rs.getString(32));
		    		 model.setPriorRemarks(rs.getString(33));
		    		 model.setNameOne(rs.getString(34));
		    		 model.setPositionOne(rs.getString(35));
		    		 model.setNameTwo(rs.getString(36));
		    		 model.setPositionTwo(rs.getString(37));
		    		 model.setIncidentDate(rs.getDate(38));				 }				 
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
			 List<DriverIncident> rsList = new ArrayList<DriverIncident>();
			  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer("select a.id,a.acknowstat,a.acknowremarks,a.reportstat,a.reportremarks,a.companystat,a.companyremarks,a.incabstat,a.incabremarks,");
				    sql.append(" a.dwhstat,a.dwhremarks,a.gpsstat,a.gpsremarks,a.ebstat,a.ebremarks,a.alcoholstat,a.alcoholremarks,a.driversstat,a.driversremarks, ");
				    sql.append(" a.policestat,a.policeremarks,a.photostat,a.photoremarks,a.picdamagestat,a.picdamageremarks,a.picplatestat,a.picplateremarks, ");
				    sql.append(" a.startstat,a.startremarks,a.withinveststat,a.withinvestremarks, ");
				    sql.append(" a.priorstat,a.priorremarks,a.nameone,a.positionone,a.nametwo,a.positiontwo,a.incidentdate, ");
				 	sql.append(" a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
				 	sql.append(" from transport.tran_incident a ");
				 	sql.append(" where a.active = false ");
				 	sql.append(" order by a.incidentdate desc ");
				 	sql.append(" limit ? ");
				 	sql.append(" offset ? ");

			
				 TransportUtils.writeLogDebug(logger, "SQL: "+sql.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, limit);
				 pstmt.setInt(2, offset);
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
					 //get the model criteria
					 DriverIncident model = new DriverIncident();
					 model.setId(rs.getInt(1));
		    		 model.setAcknowStat(rs.getString(2));
		    		 model.setAcknowRemarks(rs.getString(3));
		    		 model.setReportStat(rs.getString(4));
		    		 model.setReportRemarks(rs.getString(5));
		    		 model.setCompanyStat(rs.getString(6));
		    		 model.setCompanyRemarks(rs.getString(7));
		    		 model.setIncabStat(rs.getString(8));
		    		 model.setIncabRemarks(rs.getString(9));
		    		 model.setDwhStat(rs.getString(10));
		    		 model.setDwhRemarks(rs.getString(11));
		    		 model.setGpsStat(rs.getString(12));
		    		 model.setGpsRemarks(rs.getString(13));
		    		 model.setEbStat(rs.getString(14));
		    		 model.setEbRemarks(rs.getString(15));
		    		 model.setAlcoholStat(rs.getString(16));
		    		 model.setAlcoholRemarks(rs.getString(17));
		    		 model.setDriversStat(rs.getString(18));
		    		 model.setDriversRemarks(rs.getString(19));
		    		 model.setPoliceStat(rs.getString(20));
		    		 model.setPoliceRemarks(rs.getString(21));
		    		 model.setPhotoStat(rs.getString(22));
		    		 model.setPhotoRemarks(rs.getString(23));
		    		 model.setPicDamageStat(rs.getString(24));
		    		 model.setPicDamageRemarks(rs.getString(25));
		    		 model.setPicPlateStat(rs.getString(26));
		    		 model.setPicPlateRemarks(rs.getString(27));
		    		 model.setStartStat(rs.getString(28));
		    		 model.setStartRemarks(rs.getString(29));
		    		 model.setWithInvestStat(rs.getString(30));
		    		 model.setWithInvestRemarks(rs.getString(31));
		    		 model.setPriorStat(rs.getString(32));
		    		 model.setPriorRemarks(rs.getString(33));
		    		 model.setNameOne(rs.getString(34));
		    		 model.setPositionOne(rs.getString(35));
		    		 model.setNameTwo(rs.getString(36));
		    		 model.setPositionTwo(rs.getString(37));
		    		 model.setIncidentDate(rs.getDate(38));		    		 
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
		    	 
			    sqlCount = new StringBuffer("select count(*) from transport.tran_incident where active = false");	 

				StringBuffer sqlCountLog = null;
				sqlCountLog = new StringBuffer("select count(*) from transport.tran_incident where active = false");	 

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
		
		DriverIncident model = (DriverIncident) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update transport.tran_incident set ");	
			qry.append(" active=true ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");

		StringBuffer qryLog =  new StringBuffer("update transport.tran_incident set ");	
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
				System.out.println("DriverIncident record (id: " +model.getId()+") restored successfully..");
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
