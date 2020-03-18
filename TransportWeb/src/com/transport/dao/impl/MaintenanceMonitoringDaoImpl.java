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
import com.transport.constant.ModuleConstant;
import com.transport.dao.MaintenanceMonitoringDao;
import com.transport.model.MaintenanceMonitoringFleet;
import com.transport.model.User;
import com.transport.model.MaintenanceMonitoring;
import com.transport.util.TransportUtils;

/**
 * 
 * @author dward
 * @since 25Mar2019
 * DateUpdated: 18Mar2020
 */
public class MaintenanceMonitoringDaoImpl implements MaintenanceMonitoringDao {
	
	private final static Logger logger = Logger.getLogger(MaintenanceMonitoringDaoImpl.class);

	@Override
	public Map<String, Object> save(HashMap<String, Object> dataMap) throws Exception{
		
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SAVE);
		
		//DBCP JNDI
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		PreparedStatement pstmt4 = null;
		PreparedStatement pstmt5 = null;
		PreparedStatement pstmt6 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		ResultSet rs4 = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean status = false;
		
		MaintenanceMonitoring model = (MaintenanceMonitoring) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setCreatedBy((int) user.getId());	
		}
		model.setCreatedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("insert into transport.tran_maintenance (");
		  		qry.append("plateno ");
		  		qry.append(",trailerno ");
		  		qry.append(",lorryno ");
		  		qry.append(",capacity ");
		  		qry.append(",year ");
		  		qry.append(",month ");
		  		qry.append(",category ");
		  		qry.append(",transportid ");
		  		qry.append(",createdby ");
		  		qry.append(",createdon ");
		  		qry.append(",version ");
		  		qry.append(",active ");
		  		qry.append(",committedvolume ");
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
		  		qry.append(" ,? ");
		  		qry.append(" ) ");

//		TransportUtils.writeLogDebug(logger, "SQL: "+qry.toString());
  		  		
		  try {
			  conn = ServerContext.getJDBCHandle();
			  conn.setAutoCommit(false);
			  pstmt = conn.prepareStatement(qry.toString());
			  
			  //Get the Commiited Volume of the Category(Terminal) in ListValue table, field is Description, listtypeid = 10
			  StringBuilder sbCv = new StringBuilder("select description from transport.list_value where listtypeid = 10 and listvalue = '" + model.getCategory() + "'");
			  PreparedStatement pstmtCV = conn.prepareStatement(sbCv.toString());
			  ResultSet rsCv = pstmtCV.executeQuery();
			  int committedVol = 0;
			  if (rsCv.next()) {
				  committedVol = Integer.parseInt(rsCv.getString(1));
			  }
			  rsCv.close();
			  pstmtCV.close();
			   
			  StringBuilder sb = new StringBuilder("select id from transport.tran_maintenance where plateno = ? and trailerno = ? and lorryno = ? and capacity = ? and year = ? and month = ?  and category = ? and transportid = ? ");
			  pstmt2 = conn.prepareStatement(sb.toString());
			  StringBuilder sb2 = new StringBuilder("select id from transport.tran_maintenance_preventive where year = ? and month = ? ");
			  pstmt3 = conn.prepareStatement(sb2.toString());
			  StringBuilder qry2 = new StringBuilder("insert into transport.tran_maintenance_preventive (");
						  qry2.append("year ");
						  qry2.append(",month ");
						  qry2.append(",createdby ");
						  qry2.append(",createdon ");
						  qry2.append(",version ");
						  qry2.append(",active ");
						  qry2.append(" ) ");
						  qry2.append(" values ");
						  qry2.append(" ( ");
						  qry2.append(" ? ");
						  qry2.append(" ,? ");
						  qry2.append(" ,? ");
						  qry2.append(" ,? ");
						  qry2.append(" ,1 ");
						  qry2.append(" ,true ");
						  qry2.append(" ) ");
			  pstmt4 = conn.prepareStatement(qry2.toString());
			  StringBuilder sb3 = new StringBuilder("select id from transport.tran_maintenance_total_pending where year = ? and month = ? ");
			  pstmt5 = conn.prepareStatement(sb3.toString());
			  StringBuilder qry3 = new StringBuilder("insert into transport.tran_maintenance_total_pending (");
			  		qry3.append("year ");
			  		qry3.append(",month ");
			  		qry3.append(",createdby ");
			  		qry3.append(",createdon ");
			  		qry3.append(",version ");
			  		qry3.append(",active ");
			  		qry3.append(" ) ");
			  		qry3.append(" values ");
			  		qry3.append(" ( ");
			  		qry3.append(" ? ");
			  		qry3.append(" ,? ");
			  		qry3.append(" ,? ");
			  		qry3.append(" ,? ");
			  		qry3.append(" ,1 ");
			  		qry3.append(" ,true ");
			  		qry3.append(" ) ");
			  pstmt6 = conn.prepareStatement(qry3.toString());
			  for (int i=model.getMonth();i<=12;i++) {  
				  //check first if data exists
				  pstmt2.setString(1, model.getPlateNo());
				  pstmt2.setString(2, model.getTrailerNo());
				  pstmt2.setString(3, model.getLorryNo());
				  pstmt2.setInt(4, model.getCapacity());
				  pstmt2.setInt(5, model.getYear());
				  pstmt2.setInt(6, i);
				  pstmt2.setString(7, model.getCategory());
				  pstmt2.setInt(8, model.getTransportId());
				  rs2 = pstmt2.executeQuery();
				  if(rs2.next()) {
					  //ignore if existing
					  rs2.close();
				  } else {
					  rs2.close();
					  pstmt.setString(1, model.getPlateNo());
					  pstmt.setString(2, model.getTrailerNo());
					  pstmt.setString(3, model.getLorryNo());
					  pstmt.setInt(4, model.getCapacity());
					  pstmt.setInt(5, model.getYear());
					  pstmt.setInt(6, i);
					  pstmt.setString(7, model.getCategory());
					  pstmt.setInt(8, model.getTransportId());
					  pstmt.setInt(9, model.getCreatedBy());
					  pstmt.setTimestamp(10, model.getCreatedOn());
					  pstmt.setInt(11, committedVol);
					     
					  int statusInt = pstmt.executeUpdate();
					  if (statusInt == 1) {
						  conn.commit();
						  System.out.println("Inserted into Maintenance Monitoring table successfully for month " + i);
						  status = true;
						  //insert new data for Preventive and Breakdown for the year and if not existing
						  pstmt3.setInt(1, model.getYear());
						  pstmt3.setInt(2, i);
						  rs3 = pstmt3.executeQuery();
						  if (rs3.next()) {
							  //ignore if existing
							  rs3.close();
						  } else {
							  rs3.close();
							  pstmt4.setInt(1, model.getYear());
							  pstmt4.setInt(2, i);
							  pstmt4.setInt(3, model.getCreatedBy());
							  pstmt4.setTimestamp(4, model.getCreatedOn());
							  
							  int status2Int = pstmt4.executeUpdate();
							  if (status2Int == 1) {
								  conn.commit();
								  System.out.println("Inserted into Maintenance Preventive table successfully for month " + i); 
								  //insert new data for Total Pending for the year and if not existing
								  pstmt5.setInt(1, model.getYear());
								  pstmt5.setInt(2, i);
								  rs4 = pstmt5.executeQuery();
								  if (rs4.next()) {
									  //ignore if existing
									  rs4.close();
								  } else {
									  rs4.close();
									  pstmt6.setInt(1, model.getYear());
									  pstmt6.setInt(2, i);
									  pstmt6.setInt(3, model.getCreatedBy());
									  pstmt6.setTimestamp(4, model.getCreatedOn());
									  
									  int status3Int = pstmt6.executeUpdate();
									  if (status3Int == 1) {
										  conn.commit();
										  System.out.println("Inserted into Maintenance Total Pending table successfully for month " + i); 
										  
									  }
									  
								  }
							  }
							  
						  }
					  }						  
				  }
			  
			  }
		  } catch (Exception e) {
			  conn.rollback();
		 	  e.printStackTrace();
		  } finally {
			  TransportUtils.closeObjects(rs);
			  TransportUtils.closeObjects(rs2);
			  TransportUtils.closeObjects(rs3);
			  TransportUtils.closeObjects(rs4);
			  TransportUtils.closeObjects(pstmt);
			  TransportUtils.closeObjects(pstmt2);
			  TransportUtils.closeObjects(pstmt3);
			  TransportUtils.closeObjects(pstmt4);
			  TransportUtils.closeObjects(pstmt5);
			  TransportUtils.closeObjects(pstmt6);
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
		
		MaintenanceMonitoring model = (MaintenanceMonitoring) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		int moduleInnerId = (int) dataMap.get(MapConstant.MODULE_INNER);
		
		StringBuffer qry = null;
		
		if (moduleInnerId == ModuleConstant.MAINTENANCE_MONITORING_GPS) {
			//GPS
			switch (model.getDay()) {
				case 1: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" gps1=? ");
					qry.append(" ,gpscolor1=? ");
					qry.append(" ,gpsremarks1=? ");
					qry.append(" ,gpstripissue1=? ");
					break;
				case 2: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" gps2=? ");
					qry.append(" ,gpscolor2=? ");
					qry.append(" ,gpsremarks2=? ");
					qry.append(" ,gpstripissue2=? ");
					break;
				case 3: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" gps3=? ");
					qry.append(" ,gpscolor3=? ");
					qry.append(" ,gpsremarks3=? ");	
					qry.append(" ,gpstripissue3=? ");
					break;
				case 4: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" gps4=? ");
					qry.append(" ,gpscolor4=? ");
					qry.append(" ,gpsremarks4=? ");
					qry.append(" ,gpstripissue4=? ");
					break;
				case 5: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" gps5=? ");
					qry.append(" ,gpscolor5=? ");
					qry.append(" ,gpsremarks5=? ");
					qry.append(" ,gpstripissue5=? ");
					break;
				case 6: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" gps6=? ");
					qry.append(" ,gpscolor6=? ");
					qry.append(" ,gpsremarks6=? ");
					qry.append(" ,gpstripissue6=? ");
					break;
				case 7: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" gps7=? ");
					qry.append(" ,gpscolor7=? ");
					qry.append(" ,gpsremarks7=? ");
					qry.append(" ,gpstripissue7=? ");
					break;
				case 8: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" gps8=? ");
					qry.append(" ,gpscolor8=? ");
					qry.append(" ,gpsremarks8=? ");
					qry.append(" ,gpstripissue8=? ");
					break;
				case 9: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" gps9=? ");
					qry.append(" ,gpscolor9=? ");
					qry.append(" ,gpsremarks9=? ");
					qry.append(" ,gpstripissue9=? ");
					break;
				case 10: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" gps10=? ");
					qry.append(" ,gpscolor10=? ");
					qry.append(" ,gpsremarks10=? ");	
					qry.append(" ,gpstripissue10=? ");
					break;
				case 11: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" gps11=? ");
					qry.append(" ,gpscolor11=? ");
					qry.append(" ,gpsremarks11=? ");
					qry.append(" ,gpstripissue11=? ");
					break;
				case 12: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" gps12=? ");
					qry.append(" ,gpscolor12=? ");
					qry.append(" ,gpsremarks12=? ");
					qry.append(" ,gpstripissue12=? ");
					break;
				case 13: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" gps13=? ");
					qry.append(" ,gpscolor13=? ");
					qry.append(" ,gpsremarks13=? ");
					qry.append(" ,gpstripissue13=? ");
					break;
				case 14: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" gps14=? ");
					qry.append(" ,gpscolor14=? ");
					qry.append(" ,gpsremarks14=? ");
					qry.append(" ,gpstripissue14=? ");
					break;
				case 15: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" gps15=? ");
					qry.append(" ,gpscolor15=? ");
					qry.append(" ,gpsremarks15=? ");
					qry.append(" ,gpstripissue15=? ");
					break;
				case 16: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" gps16=? ");
					qry.append(" ,gpscolor16=? ");
					qry.append(" ,gpsremarks16=? ");
					qry.append(" ,gpstripissue16=? ");
					break;
				case 17: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" gps17=? ");
					qry.append(" ,gpscolor17=? ");
					qry.append(" ,gpsremarks17=? ");
					qry.append(" ,gpstripissue17=? ");
					break;
				case 18: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" gps18=? ");
					qry.append(" ,gpscolor18=? ");
					qry.append(" ,gpsremarks18=? ");
					qry.append(" ,gpstripissue18=? ");
					break;
				case 19: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" gps19=? ");
					qry.append(" ,gpscolor19=? ");
					qry.append(" ,gpsremarks19=? ");
					qry.append(" ,gpstripissue19=? ");
					break;
				case 20: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" gps20=? ");
					qry.append(" ,gpscolor20=? ");
					qry.append(" ,gpsremarks20=? ");
					qry.append(" ,gpstripissue20=? ");
					break;
				case 21: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" gps21=? ");
					qry.append(" ,gpscolor21=? ");
					qry.append(" ,gpsremarks21=? ");				
					qry.append(" ,gpstripissue21=? ");
					break;
				case 22: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" gps22=? ");
					qry.append(" ,gpscolor22=? ");
					qry.append(" ,gpsremarks22=? ");			
					qry.append(" ,gpstripissue22=? ");
					break;
				case 23: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" gps23=? ");
					qry.append(" ,gpscolor23=? ");
					qry.append(" ,gpsremarks23=? ");
					qry.append(" ,gpstripissue23=? ");
					break;
				case 24: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" gps24=? ");
					qry.append(" ,gpscolor24=? ");
					qry.append(" ,gpsremarks24=? ");
					qry.append(" ,gpstripissue24=? ");
					break;
				case 25: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" gps25=? ");
					qry.append(" ,gpscolor25=? ");
					qry.append(" ,gpsremarks25=? ");
					qry.append(" ,gpstripissue25=? ");
					break;
				case 26: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" gps26=? ");
					qry.append(" ,gpscolor26=? ");
					qry.append(" ,gpsremarks26=? ");
					qry.append(" ,gpstripissue26=? ");
					break;
				case 27: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" gps27=? ");
					qry.append(" ,gpscolor27=? ");
					qry.append(" ,gpsremarks27=? ");
					qry.append(" ,gpstripissue27=? ");
					break;
				case 28: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" gps28=? ");
					qry.append(" ,gpscolor28=? ");
					qry.append(" ,gpsremarks28=? ");
					qry.append(" ,gpstripissue28=? ");
					break;
				case 29: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" gps29=? ");
					qry.append(" ,gpscolor29=? ");
					qry.append(" ,gpsremarks29=? ");
					qry.append(" ,gpstripissue29=? ");
					break;
				case 30: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" gps30=? ");
					qry.append(" ,gpscolor30=? ");
					qry.append(" ,gpsremarks30=? ");
					qry.append(" ,gpstripissue30=? ");
					break;
				case 31: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" gps31=? ");
					qry.append(" ,gpscolor31=? ");
					qry.append(" ,gpsremarks31=? ");
					qry.append(" ,gpstripissue31=? ");
					break;
			}
			
		} else {
			switch (model.getDay()) {
				//Maintenance
				case 1: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" maintenance1=? ");
					qry.append(" ,maintenancecolor1=? ");
					qry.append(" ,maintenancecategory1=? ");
					qry.append(" ,maintenanceremarks1=? ");
					qry.append(" ,availablevolume1=? ");
					
					break;
				case 2: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" maintenance2=? ");
					qry.append(" ,maintenancecolor2=? ");
					qry.append(" ,maintenancecategory2=? ");
					qry.append(" ,maintenanceremarks2=? ");
					qry.append(" ,availablevolume2=? ");
					
					break;
				case 3: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" maintenance3=? ");
					qry.append(" ,maintenancecolor3=? ");
					qry.append(" ,maintenancecategory3=? ");
					qry.append(" ,maintenanceremarks3=? ");
					qry.append(" ,availablevolume3=? ");
					
					break;
				case 4: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" maintenance4=? ");
					qry.append(" ,maintenancecolor4=? ");
					qry.append(" ,maintenancecategory4=? ");
					qry.append(" ,maintenanceremarks4=? ");
					qry.append(" ,availablevolume4=? ");
					
					break;
				case 5: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" maintenance5=? ");
					qry.append(" ,maintenancecolor5=? ");
					qry.append(" ,maintenancecategory5=? ");
					qry.append(" ,maintenanceremarks5=? ");
					qry.append(" ,availablevolume5=? ");
					
					break;
				case 6: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" maintenance6=? ");
					qry.append(" ,maintenancecolor6=? ");
					qry.append(" ,maintenancecategory6=? ");
					qry.append(" ,maintenanceremarks6=? ");
					qry.append(" ,availablevolume6=? ");
					
					break;
				case 7: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" maintenance7=? ");
					qry.append(" ,maintenancecolor7=? ");
					qry.append(" ,maintenancecategory7=? ");
					qry.append(" ,maintenanceremarks7=? ");
					qry.append(" ,availablevolume7=? ");
					
					break;
				case 8: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" maintenance8=? ");
					qry.append(" ,maintenancecolor8=? ");
					qry.append(" ,maintenancecategory8=? ");
					qry.append(" ,maintenanceremarks8=? ");
					qry.append(" ,availablevolume8=? ");
					
					break;
				case 9: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" maintenance9=? ");
					qry.append(" ,maintenancecolor9=? ");
					qry.append(" ,maintenancecategory9=? ");
					qry.append(" ,maintenanceremarks9=? ");
					qry.append(" ,availablevolume9=? ");
					
					break;
				case 10: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" maintenance10=? ");
					qry.append(" ,maintenancecolor10=? ");
					qry.append(" ,maintenancecategory10=? ");
					qry.append(" ,maintenanceremarks10=? ");
					qry.append(" ,availablevolume10=? ");
					
					break;
				case 11: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" maintenance11=? ");
					qry.append(" ,maintenancecolor11=? ");
					qry.append(" ,maintenancecategory11=? ");
					qry.append(" ,maintenanceremarks11=? ");
					qry.append(" ,availablevolume11=? ");
					
					break;
				case 12: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" maintenance12=? ");
					qry.append(" ,maintenancecolor12=? ");
					qry.append(" ,maintenancecategory12=? ");
					qry.append(" ,maintenanceremarks12=? ");
					qry.append(" ,availablevolume12=? ");
					
					break;
				case 13: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" maintenance13=? ");
					qry.append(" ,maintenancecolor13=? ");
					qry.append(" ,maintenancecategory13=? ");
					qry.append(" ,maintenanceremarks13=? ");
					qry.append(" ,availablevolume13=? ");
					
					break;
				case 14: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" maintenance14=? ");
					qry.append(" ,maintenancecolor14=? ");
					qry.append(" ,maintenancecategory14=? ");
					qry.append(" ,maintenanceremarks14=? ");
					qry.append(" ,availablevolume14=? ");
					
					break;
				case 15: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" maintenance15=? ");
					qry.append(" ,maintenancecolor15=? ");
					qry.append(" ,maintenancecategory15=? ");
					qry.append(" ,maintenanceremarks15=? ");
					qry.append(" ,availablevolume15=? ");
					
					break;
				case 16: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" maintenance16=? ");
					qry.append(" ,maintenancecolor16=? ");
					qry.append(" ,maintenancecategory16=? ");
					qry.append(" ,maintenanceremarks16=? ");
					qry.append(" ,availablevolume16=? ");
					
					break;
				case 17: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" maintenance17=? ");
					qry.append(" ,maintenancecolor17=? ");
					qry.append(" ,maintenancecategory17=? ");
					qry.append(" ,maintenanceremarks17=? ");
					qry.append(" ,availablevolume17=? ");
					
					break;
				case 18: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" maintenance18=? ");
					qry.append(" ,maintenancecolor18=? ");
					qry.append(" ,maintenancecategory18=? ");
					qry.append(" ,maintenanceremarks18=? ");
					qry.append(" ,availablevolume18=? ");
					
					break;
				case 19: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" maintenance19=? ");
					qry.append(" ,maintenancecolor19=? ");
					qry.append(" ,maintenancecategory19=? ");
					qry.append(" ,maintenanceremarks19=? ");
					qry.append(" ,availablevolume19=? ");
					
					break;
				case 20: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" maintenance20=? ");
					qry.append(" ,maintenancecolor20=? ");
					qry.append(" ,maintenancecategory20=? ");
					qry.append(" ,maintenanceremarks20=? ");
					qry.append(" ,availablevolume20=? ");
					
					break;
				case 21: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" maintenance21=? ");
					qry.append(" ,maintenancecolor21=? ");
					qry.append(" ,maintenancecategory21=? ");
					qry.append(" ,maintenanceremarks21=? ");
					qry.append(" ,availablevolume21=? ");
					
					break;
				case 22: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" maintenance22=? ");
					qry.append(" ,maintenancecolor22=? ");
					qry.append(" ,maintenancecategory22=? ");
					qry.append(" ,maintenanceremarks22=? ");
					qry.append(" ,availablevolume22=? ");
					
					break;
				case 23: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" maintenance23=? ");
					qry.append(" ,maintenancecolor23=? ");
					qry.append(" ,maintenancecategory23=? ");
					qry.append(" ,maintenanceremarks23=? ");
					qry.append(" ,availablevolume23=? ");
					
					break;
				case 24: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" maintenance24=? ");
					qry.append(" ,maintenancecolor24=? ");
					qry.append(" ,maintenancecategory24=? ");
					qry.append(" ,maintenanceremarks24=? ");
					qry.append(" ,availablevolume24=? ");
					
					break;
				case 25: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" maintenance25=? ");
					qry.append(" ,maintenancecolor25=? ");
					qry.append(" ,maintenancecategory25=? ");
					qry.append(" ,maintenanceremarks25=? ");
					qry.append(" ,availablevolume25=? ");
					
					break;
				case 26: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" maintenance26=? ");
					qry.append(" ,maintenancecolor26=? ");
					qry.append(" ,maintenancecategory26=? ");
					qry.append(" ,maintenanceremarks26=? ");
					qry.append(" ,availablevolume26=? ");
					
					break;
				case 27: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" maintenance27=? ");
					qry.append(" ,maintenancecolor27=? ");
					qry.append(" ,maintenancecategory27=? ");
					qry.append(" ,maintenanceremarks27=? ");
					qry.append(" ,availablevolume27=? ");
					
					break;
				case 28: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" maintenance28=? ");
					qry.append(" ,maintenancecolor28=? ");
					qry.append(" ,maintenancecategory28=? ");
					qry.append(" ,maintenanceremarks28=? ");
					qry.append(" ,availablevolume28=? ");	
					break;
				case 29: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" maintenance29=? ");
					qry.append(" ,maintenancecolor29=? ");
					qry.append(" ,maintenancecategory29=? ");
					qry.append(" ,maintenanceremarks29=? ");
					qry.append(" ,availablevolume29=? ");
					break;
				case 30: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" maintenance30=? ");
					qry.append(" ,maintenancecolor30=? ");
					qry.append(" ,maintenancecategory30=? ");
					qry.append(" ,maintenanceremarks30=? ");
					qry.append(" ,availablevolume30=? ");
					break;
				case 31: 
					qry =  new StringBuffer("update transport.tran_maintenance set ");	
					qry.append(" maintenance31=? ");
					qry.append(" ,maintenancecolor31=? ");
					qry.append(" ,maintenancecategory31=? ");
					qry.append(" ,maintenanceremarks31=? ");
					qry.append(" ,availablevolume31=? ");
					break;
			}
				
		}

		qry.append(" ,modifiedby=?,modifiedon=?,version=(version+1) where id = ?");
			
		TransportUtils.writeLogDebug(logger, "SQL: "+qry.toString());
	
		 try {
			conn = ServerContext.getJDBCHandle();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(qry.toString());
	
			if (moduleInnerId == ModuleConstant.MAINTENANCE_MONITORING_GPS) {
				//GPS
				switch (model.getDay()) {
					case 1: 
						pstmt.setString(1, model.getGps1());
						pstmt.setInt(2, model.getGpsColor1());
						pstmt.setString(3, model.getGpsRemarks1());
						pstmt.setInt(4, model.getGpsTripIssue1());
						break;
					case 2: 
						pstmt.setString(1, model.getGps2());
						pstmt.setInt(2, model.getGpsColor2());
						pstmt.setString(3, model.getGpsRemarks2());
						pstmt.setInt(4, model.getGpsTripIssue2());
						break;
					case 3: 
						pstmt.setString(1, model.getGps3());
						pstmt.setInt(2, model.getGpsColor3());
						pstmt.setString(3, model.getGpsRemarks3());
						pstmt.setInt(4, model.getGpsTripIssue3());
						break;
					case 4: 
						pstmt.setString(1, model.getGps4());
						pstmt.setInt(2, model.getGpsColor4());
						pstmt.setString(3, model.getGpsRemarks4());
						pstmt.setInt(4, model.getGpsTripIssue4());
						break;
					case 5: 
						pstmt.setString(1, model.getGps5());
						pstmt.setInt(2, model.getGpsColor5());
						pstmt.setString(3, model.getGpsRemarks5());
						pstmt.setInt(4, model.getGpsTripIssue5());
						break;
					case 6: 
						pstmt.setString(1, model.getGps6());
						pstmt.setInt(2, model.getGpsColor6());
						pstmt.setString(3, model.getGpsRemarks6());
						pstmt.setInt(4, model.getGpsTripIssue6());
						break;
					case 7: 
						pstmt.setString(1, model.getGps7());
						pstmt.setInt(2, model.getGpsColor7());
						pstmt.setString(3, model.getGpsRemarks7());
						pstmt.setInt(4, model.getGpsTripIssue7());
						break;
					case 8: 
						pstmt.setString(1, model.getGps8());
						pstmt.setInt(2, model.getGpsColor8());
						pstmt.setString(3, model.getGpsRemarks8());
						pstmt.setInt(4, model.getGpsTripIssue8());
						break;
					case 9: 
						pstmt.setString(1, model.getGps9());
						pstmt.setInt(2, model.getGpsColor9());
						pstmt.setString(3, model.getGpsRemarks9());
						pstmt.setInt(4, model.getGpsTripIssue9());
						break;
					case 10: 
						pstmt.setString(1, model.getGps10());
						pstmt.setInt(2, model.getGpsColor10());
						pstmt.setString(3, model.getGpsRemarks10());
						pstmt.setInt(4, model.getGpsTripIssue10());
						break;
					case 11: 
						pstmt.setString(1, model.getGps11());
						pstmt.setInt(2, model.getGpsColor11());
						pstmt.setString(3, model.getGpsRemarks11());
						pstmt.setInt(4, model.getGpsTripIssue11());
						break;
					case 12: 
						pstmt.setString(1, model.getGps12());
						pstmt.setInt(2, model.getGpsColor12());
						pstmt.setString(3, model.getGpsRemarks12());
						pstmt.setInt(4, model.getGpsTripIssue12());
						break;
					case 13: 
						pstmt.setString(1, model.getGps13());
						pstmt.setInt(2, model.getGpsColor13());
						pstmt.setString(3, model.getGpsRemarks13());
						pstmt.setInt(4, model.getGpsTripIssue13());
						break;
					case 14: 
						pstmt.setString(1, model.getGps14());
						pstmt.setInt(2, model.getGpsColor14());
						pstmt.setString(3, model.getGpsRemarks14());
						pstmt.setInt(4, model.getGpsTripIssue14());
						break;
					case 15: 
						pstmt.setString(1, model.getGps15());
						pstmt.setInt(2, model.getGpsColor15());
						pstmt.setString(3, model.getGpsRemarks15());
						pstmt.setInt(4, model.getGpsTripIssue15());
						break;
					case 16: 
						pstmt.setString(1, model.getGps16());
						pstmt.setInt(2, model.getGpsColor16());
						pstmt.setString(3, model.getGpsRemarks16());
						pstmt.setInt(4, model.getGpsTripIssue16());
						break;
					case 17: 
						pstmt.setString(1, model.getGps17());
						pstmt.setInt(2, model.getGpsColor17());
						pstmt.setString(3, model.getGpsRemarks17());
						pstmt.setInt(4, model.getGpsTripIssue17());
						break;
					case 18: 
						pstmt.setString(1, model.getGps18());
						pstmt.setInt(2, model.getGpsColor18());
						pstmt.setString(3, model.getGpsRemarks18());
						pstmt.setInt(4, model.getGpsTripIssue18());
						break;
					case 19: 
						pstmt.setString(1, model.getGps19());
						pstmt.setInt(2, model.getGpsColor19());
						pstmt.setString(3, model.getGpsRemarks19());
						pstmt.setInt(4, model.getGpsTripIssue19());
						break;
					case 20: 
						pstmt.setString(1, model.getGps20());
						pstmt.setInt(2, model.getGpsColor20());
						pstmt.setString(3, model.getGpsRemarks20());
						pstmt.setInt(4, model.getGpsTripIssue20());
						break;
					case 21: 
						pstmt.setString(1, model.getGps21());
						pstmt.setInt(2, model.getGpsColor21());
						pstmt.setString(3, model.getGpsRemarks21());
						pstmt.setInt(4, model.getGpsTripIssue21());
						break;
					case 22: 
						pstmt.setString(1, model.getGps22());
						pstmt.setInt(2, model.getGpsColor22());
						pstmt.setString(3, model.getGpsRemarks22());
						pstmt.setInt(4, model.getGpsTripIssue22());
						break;
					case 23: 
						pstmt.setString(1, model.getGps23());
						pstmt.setInt(2, model.getGpsColor23());
						pstmt.setString(3, model.getGpsRemarks23());
						pstmt.setInt(4, model.getGpsTripIssue23());
						break;
					case 24: 
						pstmt.setString(1, model.getGps24());
						pstmt.setInt(2, model.getGpsColor24());
						pstmt.setString(3, model.getGpsRemarks24());
						pstmt.setInt(4, model.getGpsTripIssue24());
						break;
					case 25: 
						pstmt.setString(1, model.getGps25());
						pstmt.setInt(2, model.getGpsColor25());
						pstmt.setString(3, model.getGpsRemarks25());
						pstmt.setInt(4, model.getGpsTripIssue25());
						break;
					case 26: 
						pstmt.setString(1, model.getGps26());
						pstmt.setInt(2, model.getGpsColor26());
						pstmt.setString(3, model.getGpsRemarks26());
						pstmt.setInt(4, model.getGpsTripIssue26());
						break;
					case 27: 
						pstmt.setString(1, model.getGps27());
						pstmt.setInt(2, model.getGpsColor27());
						pstmt.setString(3, model.getGpsRemarks27());
						pstmt.setInt(4, model.getGpsTripIssue27());
						break;
					case 28: 
						pstmt.setString(1, model.getGps28());
						pstmt.setInt(2, model.getGpsColor28());
						pstmt.setString(3, model.getGpsRemarks28());
						pstmt.setInt(4, model.getGpsTripIssue28());
						break;
					case 29: 
						pstmt.setString(1, model.getGps29());
						pstmt.setInt(2, model.getGpsColor29());
						pstmt.setString(3, model.getGpsRemarks29());
						pstmt.setInt(4, model.getGpsTripIssue29());
						break;
					case 30: 
						pstmt.setString(1, model.getGps30());
						pstmt.setInt(2, model.getGpsColor30());
						pstmt.setString(3, model.getGpsRemarks30());
						pstmt.setInt(4, model.getGpsTripIssue30());
						break;
					case 31: 
						pstmt.setString(1, model.getGps31());
						pstmt.setInt(2, model.getGpsColor31());
						pstmt.setString(3, model.getGpsRemarks31());
						pstmt.setInt(4, model.getGpsTripIssue31());
						break;
				}
			} else {
				//Maintenance
				switch (model.getDay()) {
					case 1: 
						pstmt.setString(1, model.getMaintenance1());
						pstmt.setInt(2, model.getMaintenanceColor1());
						pstmt.setInt(3, model.getMaintenanceCategory1());
						pstmt.setString(4, model.getMaintenanceRemarks1());
						pstmt.setInt(5, model.getAvailableVolume1());
						break;
					case 2: 
						pstmt.setString(1, model.getMaintenance2());
						pstmt.setInt(2, model.getMaintenanceColor2());
						pstmt.setInt(3, model.getMaintenanceCategory2());
						pstmt.setString(4, model.getMaintenanceRemarks2());
						pstmt.setInt(5, model.getAvailableVolume2());
						break;
					case 3: 
						pstmt.setString(1, model.getMaintenance3());
						pstmt.setInt(2, model.getMaintenanceColor3());
						pstmt.setInt(3, model.getMaintenanceCategory3());
						pstmt.setString(4, model.getMaintenanceRemarks3());
						pstmt.setInt(5, model.getAvailableVolume3());
						break;
					case 4: 
						pstmt.setString(1, model.getMaintenance4());
						pstmt.setInt(2, model.getMaintenanceColor4());
						pstmt.setInt(3, model.getMaintenanceCategory4());
						pstmt.setString(4, model.getMaintenanceRemarks4());
						pstmt.setInt(5, model.getAvailableVolume4());
						break;
					case 5: 
						pstmt.setString(1, model.getMaintenance5());
						pstmt.setInt(2, model.getMaintenanceColor5());
						pstmt.setInt(3, model.getMaintenanceCategory5());
						pstmt.setString(4, model.getMaintenanceRemarks5());
						pstmt.setInt(5, model.getAvailableVolume5());
						break;
					case 6: 
						pstmt.setString(1, model.getMaintenance6());
						pstmt.setInt(2, model.getMaintenanceColor6());
						pstmt.setString(3, model.getMaintenanceRemarks6());
						pstmt.setInt(4, model.getAvailableVolume6());
						break;
					case 7: 
						pstmt.setString(1, model.getMaintenance7());
						pstmt.setInt(2, model.getMaintenanceColor7());
						pstmt.setInt(3, model.getMaintenanceCategory7());
						pstmt.setString(4, model.getMaintenanceRemarks7());
						pstmt.setInt(5, model.getAvailableVolume7());
						break;
					case 8: 
						pstmt.setString(1, model.getMaintenance8());
						pstmt.setInt(2, model.getMaintenanceColor8());
						pstmt.setInt(3, model.getMaintenanceCategory8());
						pstmt.setString(4, model.getMaintenanceRemarks8());
						pstmt.setInt(5, model.getAvailableVolume8());
						break;
					case 9: 
						pstmt.setString(1, model.getMaintenance9());
						pstmt.setInt(2, model.getMaintenanceColor9());
						pstmt.setInt(3, model.getMaintenanceCategory9());
						pstmt.setString(4, model.getMaintenanceRemarks9());
						pstmt.setInt(5, model.getAvailableVolume9());
						break;
					case 10: 
						pstmt.setString(1, model.getMaintenance10());
						pstmt.setInt(2, model.getMaintenanceColor10());
						pstmt.setInt(3, model.getMaintenanceCategory10());
						pstmt.setString(4, model.getMaintenanceRemarks10());
						pstmt.setInt(5, model.getAvailableVolume10());
						break;
					case 11: 
						pstmt.setString(1, model.getMaintenance11());
						pstmt.setInt(2, model.getMaintenanceColor11());
						pstmt.setInt(3, model.getMaintenanceCategory11());
						pstmt.setString(4, model.getMaintenanceRemarks11());
						pstmt.setInt(5, model.getAvailableVolume11());
						break;
					case 12: 
						pstmt.setString(1, model.getMaintenance12());
						pstmt.setInt(2, model.getMaintenanceColor12());
						pstmt.setInt(3, model.getMaintenanceCategory12());
						pstmt.setString(4, model.getMaintenanceRemarks12());
						pstmt.setInt(5, model.getAvailableVolume12());
						break;
					case 13: 
						pstmt.setString(1, model.getMaintenance13());
						pstmt.setInt(2, model.getMaintenanceColor13());
						pstmt.setInt(3, model.getMaintenanceCategory13());
						pstmt.setString(4, model.getMaintenanceRemarks13());
						pstmt.setInt(5, model.getAvailableVolume13());
						break;
					case 14: 
						pstmt.setString(1, model.getMaintenance14());
						pstmt.setInt(2, model.getMaintenanceColor14());
						pstmt.setInt(3, model.getMaintenanceCategory14());
						pstmt.setString(4, model.getMaintenanceRemarks14());
						pstmt.setInt(5, model.getAvailableVolume14());
						break;
					case 15: 
						pstmt.setString(1, model.getMaintenance15());
						pstmt.setInt(2, model.getMaintenanceColor15());
						pstmt.setInt(3, model.getMaintenanceCategory15());
						pstmt.setString(4, model.getMaintenanceRemarks15());
						pstmt.setInt(5, model.getAvailableVolume15());
						break;
					case 16: 
						pstmt.setString(1, model.getMaintenance16());
						pstmt.setInt(2, model.getMaintenanceColor16());
						pstmt.setInt(3, model.getMaintenanceCategory16());
						pstmt.setString(4, model.getMaintenanceRemarks16());
						pstmt.setInt(5, model.getAvailableVolume16());
						break;
					case 17: 
						pstmt.setString(1, model.getMaintenance17());
						pstmt.setInt(2, model.getMaintenanceColor17());
						pstmt.setInt(3, model.getMaintenanceCategory17());
						pstmt.setString(4, model.getMaintenanceRemarks17());
						pstmt.setInt(5, model.getAvailableVolume17());
						break;
					case 18: 
						pstmt.setString(1, model.getMaintenance18());
						pstmt.setInt(2, model.getMaintenanceColor18());
						pstmt.setInt(3, model.getMaintenanceCategory18());
						pstmt.setString(4, model.getMaintenanceRemarks18());
						pstmt.setInt(5, model.getAvailableVolume18());
						break;
					case 19: 
						pstmt.setString(1, model.getMaintenance19());
						pstmt.setInt(2, model.getMaintenanceColor19());
						pstmt.setString(3, model.getMaintenanceRemarks19());
						pstmt.setInt(4, model.getAvailableVolume19());
						break;
					case 20: 
						pstmt.setString(1, model.getMaintenance20());
						pstmt.setInt(2, model.getMaintenanceColor20());
						pstmt.setInt(3, model.getMaintenanceCategory20());
						pstmt.setString(4, model.getMaintenanceRemarks20());
						pstmt.setInt(5, model.getAvailableVolume20());
						break;
					case 21: 
						pstmt.setString(1, model.getMaintenance21());
						pstmt.setInt(2, model.getMaintenanceColor21());
						pstmt.setInt(3, model.getMaintenanceCategory21());
						pstmt.setString(4, model.getMaintenanceRemarks21());
						pstmt.setInt(5, model.getAvailableVolume21());
						break;
					case 22: 
						pstmt.setString(1, model.getMaintenance22());
						pstmt.setInt(2, model.getMaintenanceColor22());
						pstmt.setInt(3, model.getMaintenanceCategory22());
						pstmt.setString(4, model.getMaintenanceRemarks22());
						pstmt.setInt(5, model.getAvailableVolume22());
						break;
					case 23: 
						pstmt.setString(1, model.getMaintenance23());
						pstmt.setInt(2, model.getMaintenanceColor23());
						pstmt.setInt(3, model.getMaintenanceCategory23());
						pstmt.setString(4, model.getMaintenanceRemarks23());
						pstmt.setInt(5, model.getAvailableVolume23());
						break;
					case 24: 
						pstmt.setString(1, model.getMaintenance24());
						pstmt.setInt(2, model.getMaintenanceColor24());
						pstmt.setString(3, model.getMaintenanceRemarks24());
						pstmt.setInt(4, model.getAvailableVolume24());
						break;
					case 25: 
						pstmt.setString(1, model.getMaintenance25());
						pstmt.setInt(2, model.getMaintenanceColor25());
						pstmt.setInt(3, model.getMaintenanceCategory25());
						pstmt.setString(4, model.getMaintenanceRemarks25());
						pstmt.setInt(5, model.getAvailableVolume25());
						break;
					case 26: 
						pstmt.setString(1, model.getMaintenance26());
						pstmt.setInt(2, model.getMaintenanceColor26());
						pstmt.setInt(3, model.getMaintenanceCategory26());
						pstmt.setString(4, model.getMaintenanceRemarks26());
						pstmt.setInt(5, model.getAvailableVolume26());
						break;
					case 27: 
						pstmt.setString(1, model.getMaintenance27());
						pstmt.setInt(2, model.getMaintenanceColor27());
						pstmt.setInt(3, model.getMaintenanceCategory27());
						pstmt.setString(4, model.getMaintenanceRemarks27());
						pstmt.setInt(5, model.getAvailableVolume27());
						break;
					case 28: 
						pstmt.setString(1, model.getMaintenance28());
						pstmt.setInt(2, model.getMaintenanceColor28());
						pstmt.setInt(3, model.getMaintenanceCategory28());
						pstmt.setString(4, model.getMaintenanceRemarks28());
						pstmt.setInt(5, model.getAvailableVolume28());
						break;
					case 29: 
						pstmt.setString(1, model.getMaintenance29());
						pstmt.setInt(2, model.getMaintenanceColor29());
						pstmt.setInt(3, model.getMaintenanceCategory29());
						pstmt.setString(4, model.getMaintenanceRemarks29());
						pstmt.setInt(5, model.getAvailableVolume29());
						break;
					case 30: 
						pstmt.setString(1, model.getMaintenance30());
						pstmt.setInt(2, model.getMaintenanceColor30());
						pstmt.setInt(3, model.getMaintenanceCategory30());
						pstmt.setString(4, model.getMaintenanceRemarks30());
						pstmt.setInt(5, model.getAvailableVolume30());
						break;
					case 31: 
						pstmt.setString(1, model.getMaintenance31());
						pstmt.setInt(2, model.getMaintenanceColor31());
						pstmt.setInt(3, model.getMaintenanceCategory31());
						pstmt.setString(4, model.getMaintenanceRemarks31());
						pstmt.setInt(5, model.getAvailableVolume31());
						break;
				}				
			}

			if (moduleInnerId == ModuleConstant.MAINTENANCE_MONITORING_GPS) {
				//GPS
				pstmt.setInt(5, model.getModifiedBy());
				pstmt.setTimestamp(6, model.getModifiedOn());
				pstmt.setLong(7, model.getId());
			} else {
				//Maintenance
				pstmt.setInt(6, model.getModifiedBy());
				pstmt.setTimestamp(7, model.getModifiedOn());
				pstmt.setLong(8, model.getId());
			}

				     
			int statusInt = pstmt.executeUpdate();
				     
			if (statusInt == 1) {
				conn.commit();
				System.out.println("Maintenance Monitoring record (id: " +model.getId()+") updated successfully..");
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
		
		MaintenanceMonitoring model = (MaintenanceMonitoring) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update transport.tran_maintenance set ");	
			qry.append(" active=false ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");

		StringBuffer qryLog =  new StringBuffer("update transport.tran_maintenance set ");	
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
				System.out.println("Maintenance Monitoring record (id: " +model.getId()+") deleted successfully..");
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
			 String lorryNo = (String)criteriaMap.get(MapConstant.SEARCH_CRITERIA);
			 
			 Connection conn = null;
			 ResultSet rs = null;;
			 ResultSet rs2 = null;
			 PreparedStatement pstmt = null; 
			 PreparedStatement pstmt2 = null;
			 
			 List<MaintenanceMonitoring> rsList = new ArrayList<>();
			 List<MaintenanceMonitoringFleet> rsListShellFleet = new ArrayList<>();
			 List<MaintenanceMonitoringFleet> rsListCaltexFleet = new ArrayList<>();
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuilder sql = new StringBuilder("select a.id, a.plateno, a.trailerno, a.lorryno, a.capacity, a.category, a.year, a.month, ");
				 		sql.append("a.gpscolor1, a.gpsremarks1, a.maintenance1, a.maintenancecolor1, a.maintenanceremarks1, a.availablevolume1, ");
				 		sql.append("a.gpscolor2, a.gpsremarks2, a.maintenance2, a.maintenancecolor2, a.maintenanceremarks2, a.availablevolume2, ");
				 		sql.append("a.gpscolor3, a.gpsremarks3, a.maintenance3, a.maintenancecolor3, a.maintenanceremarks3, a.availablevolume3, ");
				 		sql.append("a.gpscolor4, a.gpsremarks4, a.maintenance4, a.maintenancecolor4, a.maintenanceremarks4, a.availablevolume4, ");
				 		sql.append("a.gpscolor5, a.gpsremarks5, a.maintenance5, a.maintenancecolor5, a.maintenanceremarks5, a.availablevolume5, ");
				 		sql.append("a.gpscolor6, a.gpsremarks6, a.maintenance6, a.maintenancecolor6, a.maintenanceremarks6, a.availablevolume6, ");
				 		sql.append("a.gpscolor7, a.gpsremarks7, a.maintenance7, a.maintenancecolor7, a.maintenanceremarks7, a.availablevolume7, ");
				 		sql.append("a.gpscolor8, a.gpsremarks8, a.maintenance8, a.maintenancecolor8, a.maintenanceremarks8, a.availablevolume8, ");
				 		sql.append("a.gpscolor9, a.gpsremarks9, a.maintenance9, a.maintenancecolor9, a.maintenanceremarks9, a.availablevolume9, ");
				 		sql.append("a.gpscolor10, a.gpsremarks10, a.maintenance10, a.maintenancecolor10, a.maintenanceremarks10, a.availablevolume10, ");
				 		sql.append("a.gpscolor11, a.gpsremarks11, a.maintenance11, a.maintenancecolor11, a.maintenanceremarks11, a.availablevolume11, ");
				 		sql.append("a.gpscolor12, a.gpsremarks12, a.maintenance12, a.maintenancecolor12, a.maintenanceremarks12, a.availablevolume12, ");
				 		sql.append("a.gpscolor13, a.gpsremarks13, a.maintenance13, a.maintenancecolor13, a.maintenanceremarks13, a.availablevolume13, ");
				 		sql.append("a.gpscolor14, a.gpsremarks14, a.maintenance14, a.maintenancecolor14, a.maintenanceremarks14, a.availablevolume14, ");
				 		sql.append("a.gpscolor15, a.gpsremarks15, a.maintenance15, a.maintenancecolor15, a.maintenanceremarks15, a.availablevolume15, ");
				 		sql.append("a.gpscolor16, a.gpsremarks16, a.maintenance16, a.maintenancecolor16, a.maintenanceremarks16, a.availablevolume16, ");
				 		sql.append("a.gpscolor17, a.gpsremarks17, a.maintenance17, a.maintenancecolor17, a.maintenanceremarks17, a.availablevolume17, ");
				 		sql.append("a.gpscolor18, a.gpsremarks18, a.maintenance18, a.maintenancecolor18, a.maintenanceremarks18, a.availablevolume18, ");
				 		sql.append("a.gpscolor19, a.gpsremarks19, a.maintenance19, a.maintenancecolor19, a.maintenanceremarks19, a.availablevolume19, ");
				 		sql.append("a.gpscolor20, a.gpsremarks20, a.maintenance20, a.maintenancecolor20, a.maintenanceremarks20, a.availablevolume20, ");
				 		sql.append("a.gpscolor21, a.gpsremarks21, a.maintenance21, a.maintenancecolor21, a.maintenanceremarks21, a.availablevolume21, ");
				 		sql.append("a.gpscolor22, a.gpsremarks22, a.maintenance22, a.maintenancecolor22, a.maintenanceremarks22, a.availablevolume22, ");
				 		sql.append("a.gpscolor23, a.gpsremarks23, a.maintenance23, a.maintenancecolor23, a.maintenanceremarks23, a.availablevolume23, ");
				 		sql.append("a.gpscolor24, a.gpsremarks24, a.maintenance24, a.maintenancecolor24, a.maintenanceremarks24, a.availablevolume24, ");
				 		sql.append("a.gpscolor25, a.gpsremarks25, a.maintenance25, a.maintenancecolor25, a.maintenanceremarks25, a.availablevolume25, ");
				 		sql.append("a.gpscolor26, a.gpsremarks26, a.maintenance26, a.maintenancecolor26, a.maintenanceremarks26, a.availablevolume26, ");
				 		sql.append("a.gpscolor27, a.gpsremarks27, a.maintenance27, a.maintenancecolor27, a.maintenanceremarks27, a.availablevolume27, ");
				 		sql.append("a.gpscolor28, a.gpsremarks28, a.maintenance28, a.maintenancecolor28, a.maintenanceremarks28, a.availablevolume28, ");
				 		sql.append("a.gpscolor29, a.gpsremarks29, a.maintenance29, a.maintenancecolor29, a.maintenanceremarks29, a.availablevolume29, ");
				 		sql.append("a.gpscolor30, a.gpsremarks30, a.maintenance30, a.maintenancecolor30, a.maintenanceremarks30, a.availablevolume30, ");
				 		sql.append("a.gpscolor31, a.gpsremarks31, a.maintenance31, a.maintenancecolor31, a.maintenanceremarks31, a.availablevolume31, ");
				 		sql.append("a.createdby, a.createdon, a.modifiedby, a.modifiedon, a.version, a.active, a.transportid, a.gps1, a.gps2, a.gps3, ");
				 		sql.append("a.gps4, a.gps5, a.gps6, a.gps7, a.gps8, a.gps9, a.gps10, a.gps11, a.gps12, a.gps13, a.gps14, a.gps15, a.gps16, ");
				 		sql.append("a.gps17, a.gps18, a.gps19, a.gps20, a.gps21, a.gps22, a.gps23, a.gps24, a.gps25, a.gps26, a.gps27, a.gps28, a.gps29, ");
				 		sql.append("a.gps30, a.gps31, a.gpstripissue1, a.gpstripissue2, a.gpstripissue3, a.gpstripissue4, a.gpstripissue5, ");
				 		sql.append("a.gpstripissue6, a.gpstripissue7, a.gpstripissue8, a.gpstripissue9, a.gpstripissue10, a.gpstripissue11, ");
				 		sql.append("a.gpstripissue12, a.gpstripissue13, a.gpstripissue14, a.gpstripissue15, a.gpstripissue16, a.gpstripissue17, ");
				 		sql.append("a.gpstripissue18, a.gpstripissue19, a.gpstripissue20, a.gpstripissue21, a.gpstripissue22, a.gpstripissue23, ");
				 		sql.append("a.gpstripissue24, a.gpstripissue25, a.gpstripissue26, a.gpstripissue27, a.gpstripissue28, a.gpstripissue29, ");
				 		sql.append("a.gpstripissue30, a.gpstripissue31, ");
				 		sql.append(" coalesce(cast(a.maintenance1 as int),0) + coalesce(cast(a.maintenance2 as int),0) + coalesce(cast(a.maintenance3 as int),0) + coalesce(cast(a.maintenance4 as int),0) + ");
					 	sql.append(" coalesce(cast(a.maintenance5 as int),0) + coalesce(cast(a.maintenance6 as int),0) + coalesce(cast(a.maintenance7 as int),0) + coalesce(cast(a.maintenance8 as int),0) + ");
					 	sql.append(" coalesce(cast(a.maintenance9 as int),0) + coalesce(cast(a.maintenance10 as int),0) + coalesce(cast(a.maintenance11 as int),0) + coalesce(cast(a.maintenance12 as int),0) + ");
					 	sql.append(" coalesce(cast(a.maintenance13 as int),0) + coalesce(cast(a.maintenance14 as int),0) + coalesce(cast(a.maintenance15 as int),0) + coalesce(cast(a.maintenance16 as int),0) + ");
					 	sql.append(" coalesce(cast(a.maintenance17 as int),0) + coalesce(cast(a.maintenance18 as int),0) + coalesce(cast(a.maintenance19 as int),0) + coalesce(cast(a.maintenance20 as int),0) + ");
					 	sql.append(" coalesce(cast(a.maintenance21 as int),0) + coalesce(cast(a.maintenance22 as int),0) + coalesce(cast(a.maintenance23 as int),0) + coalesce(cast(a.maintenance24 as int),0) + ");
					 	sql.append(" coalesce(cast(a.maintenance25 as int),0) + coalesce(cast(a.maintenance26 as int),0) + coalesce(cast(a.maintenance27 as int),0) + coalesce(cast(a.maintenance28 as int),0) + ");
					 	sql.append(" coalesce(cast(a.maintenance29 as int),0) + coalesce(cast(a.maintenance30 as int),0) + coalesce(cast(a.maintenance31 as int),0) as totalmaintenance ");
					 	sql.append(", (SELECT " );
					 	sql.append("		CASE WHEN b.maintenancecolor1 = 1101 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor2 = 1101 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor3 = 1101 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor4 = 1101 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor5 = 1101 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor6 = 1101 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor7 = 1101 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor8 = 1101 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor9 = 1101 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor10 = 1101 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor11 = 1101 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor12 = 1101 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor13 = 1101 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor14 = 1101 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor15 = 1101 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor16 = 1101 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor17 = 1101 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor18 = 1101 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor19 = 1101 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor20 = 1101 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor21 = 1101 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor22 = 1101 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor23 = 1101 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor24 = 1101 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor25 = 1101 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor26 = 1101 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor27 = 1101 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor28 = 1101 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor29 = 1101 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor30 = 1101 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor31 = 1101 THEN 1 ELSE 0 END ");
					 	sql.append("   FROM transport.tran_maintenance b where a.month = ?  and a.year = ? and a.id = b.id) AS totalbreakdown ");		
					 	sql.append(", (SELECT " );
					 	sql.append("		CASE WHEN b.maintenancecolor1 = 1106 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor2 = 1106 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor3 = 1106 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor4 = 1106 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor5 = 1106 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor6 = 1106 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor7 = 1106 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor8 = 1106 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor9 = 1106 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor10 = 1106 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor11 = 1106 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor12 = 1106 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor13 = 1106 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor14 = 1106 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor15 = 1106 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor16 = 1106 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor17 = 1106 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor18 = 1106 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor19 = 1106 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor20 = 1106 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor21 = 1106 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor22 = 1106 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor23 = 1106 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor24 = 1106 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor25 = 1106 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor26 = 1106 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor27 = 1106 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor28 = 1106 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor29 = 1106 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor30 = 1106 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor31 = 1106 THEN 1 ELSE 0 END ");
					 	sql.append("   FROM transport.tran_maintenance b where a.month = ?  and a.year = ? and a.id = b.id) AS totalpm ");		
					 	sql.append(", (SELECT " );
					 	sql.append("		CASE WHEN b.maintenancecolor1 = 1105 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor2 = 1105 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor3 = 1105 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor4 = 1105 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor5 = 1105 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor6 = 1105 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor7 = 1105 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor8 = 1105 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor9 = 1105 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor10 = 1105 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor11 = 1105 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor12 = 1105 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor13 = 1105 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor14 = 1105 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor15 = 1105 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor16 = 1105 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor17 = 1105 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor18 = 1105 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor19 = 1105 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor20 = 1105 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor21 = 1105 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor22 = 1105 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor23 = 1105 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor24 = 1105 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor25 = 1105 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor26 = 1105 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor27 = 1105 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor28 = 1105 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor29 = 1105 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor30 = 1105 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor31 = 1105 THEN 1 ELSE 0 END ");
					 	sql.append("   FROM transport.tran_maintenance b where a.month = ?  and a.year = ? and a.id = b.id) AS totalpending ");
					 	sql.append(", (SELECT " );
					 	sql.append("		CASE WHEN b.maintenancecolor1 = 1102 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor2 = 1102 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor3 = 1102 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor4 = 1102 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor5 = 1102 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor6 = 1102 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor7 = 1102 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor8 = 1102 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor9 = 1102 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor10 = 1102 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor11 = 1102 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor12 = 1102 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor13 = 1102 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor14 = 1102 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor15 = 1102 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor16 = 1102 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor17 = 1102 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor18 = 1102 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor19 = 1102 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor20 = 1102 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor21 = 1102 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor22 = 1102 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor23 = 1102 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor24 = 1102 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor25 = 1102 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor26 = 1102 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor27 = 1102 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor28 = 1102 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor29 = 1102 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor30 = 1102 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor31 = 1102 THEN 1 ELSE 0 END ");
					 	sql.append("   FROM transport.tran_maintenance b where a.month = ?  and a.year = ? and a.id = b.id) AS totaltargetdate ");
					 	sql.append(", (SELECT " );
					 	sql.append("		CASE WHEN b.maintenancecolor1 = 1103 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor2 = 1103 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor3 = 1103 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor4 = 1103 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor5 = 1103 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor6 = 1103 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor7 = 1103 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor8 = 1103 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor9 = 1103 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor10 = 1103 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor11 = 1103 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor12 = 1103 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor13 = 1103 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor14 = 1103 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor15 = 1103 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor16 = 1103 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor17 = 1103 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor18 = 1103 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor19 = 1103 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor20 = 1103 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor21 = 1103 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor22 = 1103 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor23 = 1103 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor24 = 1103 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor25 = 1103 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor26 = 1103 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor27 = 1103 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor28 = 1103 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor29 = 1103 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor30 = 1103 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor31 = 1103 THEN 1 ELSE 0 END ");
					 	sql.append("   FROM transport.tran_maintenance b where a.month = ?  and a.year = ? and a.id = b.id) AS totalextended ");
					 	sql.append(", (SELECT " );
					 	sql.append("		CASE WHEN b.maintenancecolor1 = 1104 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor2 = 1104 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor3 = 1104 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor4 = 1104 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor5 = 1104 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor6 = 1104 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor7 = 1104 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor8 = 1104 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor9 = 1104 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor10 = 1104 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor11 = 1104 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor12 = 1104 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor13 = 1104 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor14 = 1104 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor15 = 1104 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor16 = 1104 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor17 = 1104 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor18 = 1104 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor19 = 1104 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor20 = 1104 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor21 = 1104 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor22 = 1104 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor23 = 1104 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor24 = 1104 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor25 = 1104 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor26 = 1104 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor27 = 1104 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor28 = 1104 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor29 = 1104 THEN 1 ELSE 0 END + CASE WHEN b.maintenancecolor30 = 1104 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.maintenancecolor31 = 1104 THEN 1 ELSE 0 END ");
					 	sql.append("   FROM transport.tran_maintenance b where a.month = ?  and a.year = ? and a.id = b.id) AS totalearlydone ");
					 	sql.append(", coalesce(cast(a.gps1 as int),0) + coalesce(cast(a.gps2 as int),0) + coalesce(cast(a.gps3 as int),0) + coalesce(cast(a.gps4 as int),0) + ");
					 	sql.append(" coalesce(cast(a.gps5 as int),0) + coalesce(cast(a.gps6 as int),0) + coalesce(cast(a.gps7 as int),0) + coalesce(cast(a.gps8 as int),0) + ");
					 	sql.append(" coalesce(cast(a.gps9 as int),0) + coalesce(cast(a.gps10 as int),0) + coalesce(cast(a.gps11 as int),0) + coalesce(cast(a.gps12 as int),0) + ");
					 	sql.append(" coalesce(cast(a.gps13 as int),0) + coalesce(cast(a.gps14 as int),0) + coalesce(cast(a.gps15 as int),0) + coalesce(cast(a.gps16 as int),0) + ");
					 	sql.append(" coalesce(cast(a.gps17 as int),0) + coalesce(cast(a.gps18 as int),0) + coalesce(cast(a.gps19 as int),0) + coalesce(cast(a.gps20 as int),0) + ");
					 	sql.append(" coalesce(cast(a.gps21 as int),0) + coalesce(cast(a.gps22 as int),0) + coalesce(cast(a.gps23 as int),0) + coalesce(cast(a.gps24 as int),0) + ");
					 	sql.append(" coalesce(cast(a.gps25 as int),0) + coalesce(cast(a.gps26 as int),0) + coalesce(cast(a.gps27 as int),0) + coalesce(cast(a.gps28 as int),0) + ");
					 	sql.append(" coalesce(cast(a.gps29 as int),0) + coalesce(cast(a.gps30 as int),0) + coalesce(cast(a.gps31 as int),0) AS totaltripsgps ");
					 	sql.append(", coalesce(cast(a.gps1 as int),0) + coalesce(cast(a.gps2 as int),0) + coalesce(cast(a.gps3 as int),0) + coalesce(cast(a.gps4 as int),0) +  ");
					 	sql.append(" coalesce(cast(a.gps5 as int),0) + coalesce(cast(a.gps6 as int),0) + coalesce(cast(a.gps7 as int),0) AS totaltripsgpsweek1 ");
					 	sql.append(", coalesce(cast(a.maintenance1 as int),0) + coalesce(cast(a.maintenance2 as int),0) + coalesce(cast(a.maintenance3 as int),0) + coalesce(cast(a.maintenance4 as int),0) +  ");
					 	sql.append(" coalesce(cast(a.maintenance5 as int),0) + coalesce(cast(a.maintenance6 as int),0) + coalesce(cast(a.maintenance7 as int),0) AS totalavailabilityweek1 ");
					 	sql.append(", coalesce(cast(a.gps8 as int),0) + coalesce(cast(a.gps9 as int),0) + coalesce(cast(a.gps10 as int),0) + coalesce(cast(a.gps11 as int),0) +  ");
					 	sql.append(" coalesce(cast(a.gps12 as int),0) + coalesce(cast(a.gps13 as int),0) + coalesce(cast(a.gps14 as int),0) AS totaltripsgpsweek2 ");
					 	sql.append(", coalesce(cast(a.maintenance8 as int),0) + coalesce(cast(a.maintenance9 as int),0) + coalesce(cast(a.maintenance10 as int),0) + coalesce(cast(a.maintenance11 as int),0) +  ");
					 	sql.append(" coalesce(cast(a.maintenance12 as int),0) + coalesce(cast(a.maintenance13 as int),0) + coalesce(cast(a.maintenance14 as int),0) AS totalavailabilityweek2 ");
					 	sql.append(", coalesce(cast(a.gps15 as int),0) + coalesce(cast(a.gps16 as int),0) + coalesce(cast(a.gps17 as int),0) + coalesce(cast(a.gps18 as int),0) +  ");
					 	sql.append(" coalesce(cast(a.gps19 as int),0) + coalesce(cast(a.gps20 as int),0) + coalesce(cast(a.gps21 as int),0) AS totaltripsgpsweek3 ");
					 	sql.append(", coalesce(cast(a.maintenance15 as int),0) + coalesce(cast(a.maintenance16 as int),0) + coalesce(cast(a.maintenance17 as int),0) + coalesce(cast(a.maintenance18 as int),0) +  ");
					 	sql.append(" coalesce(cast(a.maintenance19 as int),0) + coalesce(cast(a.maintenance20 as int),0) + coalesce(cast(a.maintenance21 as int),0) AS totalavailabilityweek3 ");
					 	sql.append(", coalesce(cast(a.gps22 as int),0) + coalesce(cast(a.gps23 as int),0) + coalesce(cast(a.gps24 as int),0) + coalesce(cast(a.gps25 as int),0) +  ");
					 	sql.append(" coalesce(cast(a.gps26 as int),0) + coalesce(cast(a.gps27 as int),0) + coalesce(cast(a.gps28 as int),0) AS totaltripsgpsweek4 ");
					 	sql.append(", coalesce(cast(a.maintenance22 as int),0) + coalesce(cast(a.maintenance23 as int),0) + coalesce(cast(a.maintenance24 as int),0) + coalesce(cast(a.maintenance25 as int),0) +  ");
					 	sql.append(" coalesce(cast(a.maintenance26 as int),0) + coalesce(cast(a.maintenance27 as int),0) + coalesce(cast(a.maintenance28 as int),0) AS totalavailabilityweek4 ");
					 	sql.append(", coalesce(cast(a.gps29 as int),0) + coalesce(cast(a.gps30 as int),0) + coalesce(cast(a.gps31 as int),0) AS totaltripsgpsweek4 ");
					 	sql.append(", (SELECT " );
					 	sql.append("		CASE WHEN b.gpstripissue1 = 1401 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue2 = 1401 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue3 = 1401 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue4 = 1401 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue5 = 1401 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue6 = 1401 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue7 = 1401 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue8 = 1401 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue9 = 1401 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue10 = 1401 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue11 = 1401 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue12 = 1401 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue13 = 1401 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue14 = 1401 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue15 = 1401 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue16 = 1401 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue17 = 1401 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue18 = 1401 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue19 = 1401 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue20 = 1401 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue21 = 1401 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue22 = 1401 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue23 = 1401 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue24 = 1401 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue25 = 1401 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue26 = 1401 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue27 = 1401 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue28 = 1401 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue29 = 1401 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue30 = 1401 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue31 = 1401 THEN 1 ELSE 0 END ");
					 	sql.append("   FROM transport.tran_maintenance b where a.month = ?  and a.year = ? and a.id = b.id) AS totaltripissueterminal ");		
					 	sql.append(", (SELECT " );
					 	sql.append("		CASE WHEN b.gpstripissue1 = 1402 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue2 = 1402 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue3 = 1402 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue4 = 1402 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue5 = 1402 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue6 = 1402 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue7 = 1402 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue8 = 1402 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue9 = 1402 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue10 = 1402 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue11 = 1402 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue12 = 1402 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue13 = 1402 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue14 = 1402 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue15 = 1402 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue16 = 1402 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue17 = 1402 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue18 = 1402 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue19 = 1402 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue20 = 1402 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue21 = 1402 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue22 = 1402 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue23 = 1402 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue24 = 1402 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue25 = 1402 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue26 = 1402 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue27 = 1402 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue28 = 1402 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue29 = 1402 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue30 = 1402 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue31 = 1402 THEN 1 ELSE 0 END ");
					 	sql.append("   FROM transport.tran_maintenance b where a.month = ?  and a.year = ? and a.id = b.id) AS totaltripissuemaintenance ");		
					 	sql.append(", (SELECT " );
					 	sql.append("		CASE WHEN b.gpstripissue1 = 1403 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue2 = 1403 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue3 = 1403 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue4 = 1403 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue5 = 1403 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue6 = 1403 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue7 = 1403 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue8 = 1403 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue9 = 1403 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue10 = 1403 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue11 = 1403 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue12 = 1403 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue13 = 1403 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue14 = 1403 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue15 = 1403 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue16 = 1403 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue17 = 1403 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue18 = 1403 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue19 = 1403 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue20 = 1403 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue21 = 1403 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue22 = 1403 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue23 = 1403 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue24 = 1403 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue25 = 1403 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue26 = 1403 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue27 = 1403 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue28 = 1403 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue29 = 1403 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue30 = 1403 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue31 = 1403 THEN 1 ELSE 0 END ");
					 	sql.append("   FROM transport.tran_maintenance b where a.month = ?  and a.year = ? and a.id = b.id) AS totaltripissuedriver ");		
					 	sql.append(", (SELECT " );
					 	sql.append("		CASE WHEN b.gpstripissue1 = 1404 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue2 = 1404 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue3 = 1404 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue4 = 1404 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue5 = 1404 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue6 = 1404 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue7 = 1404 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue8 = 1404 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue9 = 1404 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue10 = 1404 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue11 = 1404 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue12 = 1404 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue13 = 1404 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue14 = 1404 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue15 = 1404 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue16 = 1404 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue17 = 1404 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue18 = 1404 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue19 = 1404 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue20 = 1404 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue21 = 1404 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue22 = 1404 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue23 = 1404 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue24 = 1404 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue25 = 1404 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue26 = 1404 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue27 = 1404 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue28 = 1404 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue29 = 1404 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue30 = 1404 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue31 = 1404 THEN 1 ELSE 0 END ");
					 	sql.append("   FROM transport.tran_maintenance b where a.month = ?  and a.year = ? and a.id = b.id) AS totaltripissuecustomer ");		
					 	sql.append(", (SELECT " );
					 	sql.append("		CASE WHEN b.gpstripissue1 = 1405 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue2 = 1405 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue3 = 1405 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue4 = 1405 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue5 = 1405 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue6 = 1405 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue7 = 1405 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue8 = 1405 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue9 = 1405 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue10 = 1405 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue11 = 1405 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue12 = 1405 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue13 = 1405 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue14 = 1405 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue15 = 1405 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue16 = 1405 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue17 = 1405 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue18 = 1405 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue19 = 1405 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue20 = 1405 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue21 = 1405 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue22 = 1405 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue23 = 1405 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue24 = 1405 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue25 = 1405 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue26 = 1405 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue27 = 1405 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue28 = 1405 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue29 = 1405 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue30 = 1405 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue31 = 1405 THEN 1 ELSE 0 END ");
					 	sql.append("   FROM transport.tran_maintenance b where a.month = ?  and a.year = ? and a.id = b.id) AS totaltripissuelowvolume ");		
					 	sql.append(", (SELECT " );
					 	sql.append("		CASE WHEN b.gpstripissue1 = 1406 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue2 = 1406 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue3 = 1406 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue4 = 1406 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue5 = 1406 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue6 = 1406 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue7 = 1406 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue8 = 1406 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue9 = 1406 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue10 = 1406 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue11 = 1406 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue12 = 1406 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue13 = 1406 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue14 = 1406 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue15 = 1406 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue16 = 1406 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue17 = 1406 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue18 = 1406 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue19 = 1406 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue20 = 1406 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue21 = 1406 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue22 = 1406 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue23 = 1406 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue24 = 1406 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue25 = 1406 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue26 = 1406 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue27 = 1406 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue28 = 1406 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue29 = 1406 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue30 = 1406 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue31 = 1406 THEN 1 ELSE 0 END ");
					 	sql.append("   FROM transport.tran_maintenance b where a.month = ?  and a.year = ? and a.id = b.id) AS totaltripissuelonghaul ");		
					 	sql.append(", (SELECT " );
					 	sql.append("		CASE WHEN b.gpstripissue1 = 1407 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue2 = 1407 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue3 = 1407 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue4 = 1407 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue5 = 1407 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue6 = 1407 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue7 = 1407 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue8 = 1407 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue9 = 1407 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue10 = 1407 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue11 = 1407 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue12 = 1407 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue13 = 1407 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue14 = 1407 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue15 = 1407 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue16 = 1407 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue17 = 1407 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue18 = 1407 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue19 = 1407 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue20 = 1407 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue21 = 1407 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue22 = 1407 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue23 = 1407 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue24 = 1407 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue25 = 1407 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue26 = 1407 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue27 = 1407 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue28 = 1407 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue29 = 1407 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue30 = 1407 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue31 = 1407 THEN 1 ELSE 0 END ");
					 	sql.append("   FROM transport.tran_maintenance b where a.month = ?  and a.year = ? and a.id = b.id) AS totaltripissuetruckban ");		
					 	sql.append(", (SELECT " );
					 	sql.append("		CASE WHEN b.gpstripissue1 = 1408 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue2 = 1408 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue3 = 1408 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue4 = 1408 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue5 = 1408 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue6 = 1408 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue7 = 1408 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue8 = 1408 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue9 = 1408 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue10 = 1408 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue11 = 1408 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue12 = 1408 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue13 = 1408 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue14 = 1408 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue15 = 1408 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue16 = 1408 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue17 = 1408 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue18 = 1408 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue19 = 1408 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue20 = 1408 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue21 = 1408 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue22 = 1408 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue23 = 1408 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue24 = 1408 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue25 = 1408 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue26 = 1408 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue27 = 1408 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue28 = 1408 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue29 = 1408 THEN 1 ELSE 0 END + CASE WHEN b.gpstripissue30 = 1408 THEN 1 ELSE 0 END + ");
					 	sql.append("		CASE WHEN b.gpstripissue31 = 1408 THEN 1 ELSE 0 END ");
					 	sql.append("   FROM transport.tran_maintenance b where a.month = ?  and a.year = ? and a.id = b.id) AS totaltripissueroad ");
					 	sql.append(", (CAST(gps1 AS INTEGER)*1000*capacity) as gps1vol  ");
					 	sql.append(", (CAST(gps2 AS INTEGER)*1000*capacity) as gps2vol  ");
					 	sql.append(", (CAST(gps3 AS INTEGER)*1000*capacity) as gps3vol  ");
					 	sql.append(", (CAST(gps4 AS INTEGER)*1000*capacity) as gps4vol  ");
					 	sql.append(", (CAST(gps5 AS INTEGER)*1000*capacity) as gps5vol  ");
					 	sql.append(", (CAST(gps6 AS INTEGER)*1000*capacity) as gps6vol  ");
					 	sql.append(", (CAST(gps7 AS INTEGER)*1000*capacity) as gps7vol  ");
					 	sql.append(", (CAST(gps8 AS INTEGER)*1000*capacity) as gps8vol  ");
					 	sql.append(", (CAST(gps9 AS INTEGER)*1000*capacity) as gps9vol  ");
					 	sql.append(", (CAST(gps10 AS INTEGER)*1000*capacity) as gps10vol  ");
					 	sql.append(", (CAST(gps11 AS INTEGER)*1000*capacity) as gps11vol  ");
					 	sql.append(", (CAST(gps12 AS INTEGER)*1000*capacity) as gps12vol  ");
					 	sql.append(", (CAST(gps13 AS INTEGER)*1000*capacity) as gps13vol  ");
					 	sql.append(", (CAST(gps14 AS INTEGER)*1000*capacity) as gps14vol  ");
					 	sql.append(", (CAST(gps15 AS INTEGER)*1000*capacity) as gps15vol  ");
					 	sql.append(", (CAST(gps16 AS INTEGER)*1000*capacity) as gps16vol  ");
					 	sql.append(", (CAST(gps17 AS INTEGER)*1000*capacity) as gps17vol  ");
					 	sql.append(", (CAST(gps18 AS INTEGER)*1000*capacity) as gps18vol  ");
					 	sql.append(", (CAST(gps19 AS INTEGER)*1000*capacity) as gps19vol  ");
					 	sql.append(", (CAST(gps20 AS INTEGER)*1000*capacity) as gps20vol  ");
					 	sql.append(", (CAST(gps21 AS INTEGER)*1000*capacity) as gps21vol  ");
					 	sql.append(", (CAST(gps22 AS INTEGER)*1000*capacity) as gps22vol  ");
					 	sql.append(", (CAST(gps23 AS INTEGER)*1000*capacity) as gps23vol  ");
					 	sql.append(", (CAST(gps24 AS INTEGER)*1000*capacity) as gps24vol  ");
					 	sql.append(", (CAST(gps25 AS INTEGER)*1000*capacity) as gps25vol  ");
					 	sql.append(", (CAST(gps26 AS INTEGER)*1000*capacity) as gps26vol  ");
					 	sql.append(", (CAST(gps27 AS INTEGER)*1000*capacity) as gps27vol  ");
					 	sql.append(", (CAST(gps28 AS INTEGER)*1000*capacity) as gps28vol  ");
					 	sql.append(", (CAST(gps29 AS INTEGER)*1000*capacity) as gps29vol  ");
					 	sql.append(", (CAST(gps30 AS INTEGER)*1000*capacity) as gps30vol  ");
					 	sql.append(", (CAST(gps31 AS INTEGER)*1000*capacity) as gps31vol  ");
					 	sql.append(", committedvolume ");
					 	sql.append(", maintenancecategory1 ");
					 	sql.append(", maintenancecategory2 ");
					 	sql.append(", maintenancecategory3 ");
					 	sql.append(", maintenancecategory4 ");
					 	sql.append(", maintenancecategory5 ");
					 	sql.append(", maintenancecategory6 ");
					 	sql.append(", maintenancecategory7 ");
					 	sql.append(", maintenancecategory8 ");
					 	sql.append(", maintenancecategory9 ");
					 	sql.append(", maintenancecategory10 ");
					 	sql.append(", maintenancecategory11 ");
					 	sql.append(", maintenancecategory12 ");
					 	sql.append(", maintenancecategory13 ");
					 	sql.append(", maintenancecategory14 ");
					 	sql.append(", maintenancecategory15 ");
					 	sql.append(", maintenancecategory16 ");
					 	sql.append(", maintenancecategory17 ");
					 	sql.append(", maintenancecategory18 ");
					 	sql.append(", maintenancecategory19 ");
					 	sql.append(", maintenancecategory20 ");
					 	sql.append(", maintenancecategory21 ");
					 	sql.append(", maintenancecategory22 ");
					 	sql.append(", maintenancecategory23 ");
					 	sql.append(", maintenancecategory24 ");
					 	sql.append(", maintenancecategory25 ");
					 	sql.append(", maintenancecategory26 ");
					 	sql.append(", maintenancecategory27 ");
					 	sql.append(", maintenancecategory28 ");
					 	sql.append(", maintenancecategory29 ");
					 	sql.append(", maintenancecategory30 ");
					 	sql.append(", maintenancecategory31 ");
					 	sql.append(" from transport.tran_maintenance a");
					 	sql.append(" where a.month = ? ");
					 	sql.append(" and a.year = ? ");
					 	if (lorryNo!=null && !lorryNo.trim().equals("")) {
					 		sql.append(" and a.lorryno = ? ");	
					 	}
					 	sql.append(" and a.active = true ");
					 	sql.append(" order by a.transportid,a.category,a.plateno");

						 
				TransportUtils.writeLogDebug(logger, "SQL: "+sql.toString());
					
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, month);
				 pstmt.setInt(2, year);
				 pstmt.setInt(3, month);
				 pstmt.setInt(4, year);
				 pstmt.setInt(5, month);
				 pstmt.setInt(6, year);
				 pstmt.setInt(7, month);
				 pstmt.setInt(8, year);
				 pstmt.setInt(9, month);
				 pstmt.setInt(10, year);
				 pstmt.setInt(11, month);
				 pstmt.setInt(12, year);
				 pstmt.setInt(13, month);
				 pstmt.setInt(14, year);
				 pstmt.setInt(15, month);
				 pstmt.setInt(16, year);
				 pstmt.setInt(17, month);
				 pstmt.setInt(18, year);
				 pstmt.setInt(19, month);
				 pstmt.setInt(20, year);
				 pstmt.setInt(21, month);
				 pstmt.setInt(22, year);
				 pstmt.setInt(23, month);
				 pstmt.setInt(24, year);
				 pstmt.setInt(25, month);
				 pstmt.setInt(26, year);
				 pstmt.setInt(27, month);
				 pstmt.setInt(28, year);
				 pstmt.setInt(29, month);
				 pstmt.setInt(30, year);
				 if (lorryNo!=null && !lorryNo.trim().equals("")) { 
					 pstmt.setString(31, lorryNo.trim());
				 } 

				 rs = pstmt.executeQuery();
				 
				 while(rs.next()) {
					 MaintenanceMonitoring model=new MaintenanceMonitoring();  
		    		 model.setId(rs.getInt(1));
		    		 model.setPlateNo(rs.getString(2));
		    		 model.setTrailerNo(rs.getString(3));
		    		 model.setLorryNo(rs.getString(4));
		    		 model.setCapacity(rs.getInt(5));
		    		 model.setCategory(rs.getString(6));
		    		 model.setYear(rs.getInt(7));
		    		 model.setMonth(rs.getInt(8));
		    		 model.setGpsColor1(rs.getInt(9));
		    		 model.setGpsRemarks1(rs.getString(10));
		    		 model.setMaintenance1(rs.getString(11));
		    		 model.setMaintenanceColor1(rs.getInt(12));
		    		 model.setMaintenanceRemarks1(rs.getString(13));
		    		 model.setAvailableVolume1(rs.getInt(14));
		    		 model.setGpsColor2(rs.getInt(15));
		    		 model.setGpsRemarks2(rs.getString(16));
		    		 model.setMaintenance2(rs.getString(17));
		    		 model.setMaintenanceColor2(rs.getInt(18));
		    		 model.setMaintenanceRemarks2(rs.getString(19));
		    		 model.setAvailableVolume2(rs.getInt(20));
		    		 model.setGpsColor3(rs.getInt(21));
		    		 model.setGpsRemarks3(rs.getString(22));
		    		 model.setMaintenance3(rs.getString(23));
		    		 model.setMaintenanceColor3(rs.getInt(24));
		    		 model.setMaintenanceRemarks3(rs.getString(25));
		    		 model.setAvailableVolume3(rs.getInt(26));
		    		 model.setGpsColor4(rs.getInt(27));
		    		 model.setGpsRemarks4(rs.getString(28));
		    		 model.setMaintenance4(rs.getString(29));
		    		 model.setMaintenanceColor4(rs.getInt(30));
		    		 model.setMaintenanceRemarks4(rs.getString(31));
		    		 model.setAvailableVolume4(rs.getInt(32));		    		 
		    		 model.setGpsColor5(rs.getInt(33));
		    		 model.setGpsRemarks5(rs.getString(34));
		    		 model.setMaintenance5(rs.getString(35));
		    		 model.setMaintenanceColor5(rs.getInt(36));
		    		 model.setMaintenanceRemarks5(rs.getString(37));
		    		 model.setAvailableVolume5(rs.getInt(38));
		    		 model.setGpsColor6(rs.getInt(39));
		    		 model.setGpsRemarks6(rs.getString(40));
		    		 model.setMaintenance6(rs.getString(41));
		    		 model.setMaintenanceColor6(rs.getInt(42));
		    		 model.setMaintenanceRemarks6(rs.getString(43));
		    		 model.setAvailableVolume6(rs.getInt(44));		    		 
		    		 model.setGpsColor7(rs.getInt(45));
		    		 model.setGpsRemarks7(rs.getString(46));
		    		 model.setMaintenance7(rs.getString(47));
		    		 model.setMaintenanceColor7(rs.getInt(48));
		    		 model.setMaintenanceRemarks7(rs.getString(49));
		    		 model.setAvailableVolume7(rs.getInt(50));		    		 
		    		 model.setGpsColor8(rs.getInt(51));
		    		 model.setGpsRemarks8(rs.getString(52));
		    		 model.setMaintenance8(rs.getString(53));
		    		 model.setMaintenanceColor8(rs.getInt(54));
		    		 model.setMaintenanceRemarks8(rs.getString(55));
		    		 model.setAvailableVolume8(rs.getInt(56));
		    		 model.setGpsColor9(rs.getInt(57));
		    		 model.setGpsRemarks9(rs.getString(58));
		    		 model.setMaintenance9(rs.getString(59));
		    		 model.setMaintenanceColor9(rs.getInt(60));
		    		 model.setMaintenanceRemarks9(rs.getString(61));
		    		 model.setAvailableVolume9(rs.getInt(62));
		    		 model.setGpsColor10(rs.getInt(63));
		    		 model.setGpsRemarks10(rs.getString(64));
		    		 model.setMaintenance10(rs.getString(65));
		    		 model.setMaintenanceColor10(rs.getInt(66));
		    		 model.setMaintenanceRemarks10(rs.getString(67));
		    		 model.setAvailableVolume10(rs.getInt(68));
		    		 model.setGpsColor11(rs.getInt(69));
		    		 model.setGpsRemarks11(rs.getString(70));
		    		 model.setMaintenance11(rs.getString(71));
		    		 model.setMaintenanceColor11(rs.getInt(72));
		    		 model.setMaintenanceRemarks11(rs.getString(73));
		    		 model.setAvailableVolume11(rs.getInt(74));
		    		 model.setGpsColor12(rs.getInt(75));
		    		 model.setGpsRemarks12(rs.getString(76));
		    		 model.setMaintenance12(rs.getString(77));
		    		 model.setMaintenanceColor12(rs.getInt(78));
		    		 model.setMaintenanceRemarks12(rs.getString(79));
		    		 model.setAvailableVolume12(rs.getInt(80));
		    		 model.setGpsColor13(rs.getInt(81));
		    		 model.setGpsRemarks13(rs.getString(82));
		    		 model.setMaintenance13(rs.getString(83));
		    		 model.setMaintenanceColor13(rs.getInt(84));
		    		 model.setMaintenanceRemarks13(rs.getString(85));
		    		 model.setAvailableVolume13(rs.getInt(86));
		    		 model.setGpsColor14(rs.getInt(87));
		    		 model.setGpsRemarks14(rs.getString(88));
		    		 model.setMaintenance14(rs.getString(89));
		    		 model.setMaintenanceColor14(rs.getInt(90));
		    		 model.setMaintenanceRemarks14(rs.getString(91));
		    		 model.setAvailableVolume14(rs.getInt(92));
		    		 model.setGpsColor15(rs.getInt(93));
		    		 model.setGpsRemarks15(rs.getString(94));
		    		 model.setMaintenance15(rs.getString(95));
		    		 model.setMaintenanceColor15(rs.getInt(96));
		    		 model.setMaintenanceRemarks15(rs.getString(97));
		    		 model.setAvailableVolume15(rs.getInt(98));
		    		 model.setGpsColor16(rs.getInt(99));
		    		 model.setGpsRemarks16(rs.getString(100));
		    		 model.setMaintenance16(rs.getString(101));
		    		 model.setMaintenanceColor16(rs.getInt(102));
		    		 model.setMaintenanceRemarks16(rs.getString(103));
		    		 model.setAvailableVolume16(rs.getInt(104));
		    		 model.setGpsColor17(rs.getInt(105));
		    		 model.setGpsRemarks17(rs.getString(106));
		    		 model.setMaintenance17(rs.getString(107));
		    		 model.setMaintenanceColor17(rs.getInt(108));
		    		 model.setMaintenanceRemarks17(rs.getString(109));
		    		 model.setAvailableVolume17(rs.getInt(110));
		    		 model.setGpsColor18(rs.getInt(111));
		    		 model.setGpsRemarks18(rs.getString(112));
		    		 model.setMaintenance18(rs.getString(113));
		    		 model.setMaintenanceColor18(rs.getInt(114));
		    		 model.setMaintenanceRemarks18(rs.getString(115));
		    		 model.setAvailableVolume18(rs.getInt(116));
		    		 model.setGpsColor19(rs.getInt(117));
		    		 model.setGpsRemarks19(rs.getString(118));
		    		 model.setMaintenance19(rs.getString(119));
		    		 model.setMaintenanceColor19(rs.getInt(120));
		    		 model.setMaintenanceRemarks19(rs.getString(121));
		    		 model.setAvailableVolume19(rs.getInt(122));
		    		 model.setGpsColor20(rs.getInt(123));
		    		 model.setGpsRemarks20(rs.getString(124));
		    		 model.setMaintenance20(rs.getString(125));
		    		 model.setMaintenanceColor20(rs.getInt(126));
		    		 model.setMaintenanceRemarks20(rs.getString(127));
		    		 model.setAvailableVolume20(rs.getInt(128));
		    		 model.setGpsColor21(rs.getInt(129));
		    		 model.setGpsRemarks21(rs.getString(130));
		    		 model.setMaintenance21(rs.getString(131));
		    		 model.setMaintenanceColor21(rs.getInt(132));
		    		 model.setMaintenanceRemarks21(rs.getString(133));
		    		 model.setAvailableVolume21(rs.getInt(134));
		    		 model.setGpsColor22(rs.getInt(135));
		    		 model.setGpsRemarks22(rs.getString(136));
		    		 model.setMaintenance22(rs.getString(137));
		    		 model.setMaintenanceColor22(rs.getInt(138));
		    		 model.setMaintenanceRemarks22(rs.getString(139));
		    		 model.setAvailableVolume22(rs.getInt(140));
		    		 model.setGpsColor23(rs.getInt(141));
		    		 model.setGpsRemarks23(rs.getString(142));
		    		 model.setMaintenance23(rs.getString(143));
		    		 model.setMaintenanceColor23(rs.getInt(144));
		    		 model.setMaintenanceRemarks23(rs.getString(145));
		    		 model.setAvailableVolume23(rs.getInt(146));
		    		 model.setGpsColor24(rs.getInt(147));
		    		 model.setGpsRemarks24(rs.getString(148));
		    		 model.setMaintenance24(rs.getString(149));
		    		 model.setMaintenanceColor24(rs.getInt(150));
		    		 model.setMaintenanceRemarks24(rs.getString(151));
		    		 model.setAvailableVolume24(rs.getInt(152));
		    		 model.setGpsColor25(rs.getInt(153));
		    		 model.setGpsRemarks25(rs.getString(154));
		    		 model.setMaintenance25(rs.getString(155));
		    		 model.setMaintenanceColor25(rs.getInt(156));
		    		 model.setMaintenanceRemarks25(rs.getString(157));
		    		 model.setAvailableVolume25(rs.getInt(158));
		    		 model.setGpsColor26(rs.getInt(159));
		    		 model.setGpsRemarks26(rs.getString(160));
		    		 model.setMaintenance26(rs.getString(161));
		    		 model.setMaintenanceColor26(rs.getInt(162));
		    		 model.setMaintenanceRemarks26(rs.getString(163));
		    		 model.setAvailableVolume26(rs.getInt(164));
		    		 model.setGpsColor27(rs.getInt(165));
		    		 model.setGpsRemarks27(rs.getString(166));
		    		 model.setMaintenance27(rs.getString(167));
		    		 model.setMaintenanceColor27(rs.getInt(168));
		    		 model.setMaintenanceRemarks27(rs.getString(169));
		    		 model.setAvailableVolume27(rs.getInt(170));
		    		 model.setGpsColor28(rs.getInt(171));
		    		 model.setGpsRemarks28(rs.getString(172));
		    		 model.setMaintenance28(rs.getString(173));
		    		 model.setMaintenanceColor28(rs.getInt(174));
		    		 model.setMaintenanceRemarks28(rs.getString(175));
		    		 model.setAvailableVolume28(rs.getInt(176));
		    		 model.setGpsColor29(rs.getInt(177));
		    		 model.setGpsRemarks29(rs.getString(178));
		    		 model.setMaintenance29(rs.getString(179));
		    		 model.setMaintenanceColor29(rs.getInt(180));
		    		 model.setMaintenanceRemarks29(rs.getString(181));
		    		 model.setAvailableVolume29(rs.getInt(182));
		    		 model.setGpsColor30(rs.getInt(183));
		    		 model.setGpsRemarks30(rs.getString(184));
		    		 model.setMaintenance30(rs.getString(185));
		    		 model.setMaintenanceColor30(rs.getInt(186));
		    		 model.setMaintenanceRemarks30(rs.getString(187));
		    		 model.setAvailableVolume30(rs.getInt(188));
		    		 model.setGpsColor31(rs.getInt(189));
		    		 model.setGpsRemarks31(rs.getString(190));
		    		 model.setMaintenance31(rs.getString(191));
		    		 model.setMaintenanceColor31(rs.getInt(192));
		    		 model.setMaintenanceRemarks31(rs.getString(193));
		    		 model.setAvailableVolume31(rs.getInt(194));
		    		 model.setTransportId(rs.getInt(201));
		    		 model.setGps1(rs.getString(202));
		    		 model.setGps2(rs.getString(203));
		    		 model.setGps3(rs.getString(204));
		    		 model.setGps4(rs.getString(205));
		    		 model.setGps5(rs.getString(206));
		    		 model.setGps6(rs.getString(207));
		    		 model.setGps7(rs.getString(208));
		    		 model.setGps8(rs.getString(209));
		    		 model.setGps9(rs.getString(210));
		    		 model.setGps10(rs.getString(211));
		    		 model.setGps11(rs.getString(212));
		    		 model.setGps12(rs.getString(213));
		    		 model.setGps13(rs.getString(214));
		    		 model.setGps14(rs.getString(215));
		    		 model.setGps15(rs.getString(216));
		    		 model.setGps16(rs.getString(217));
		    		 model.setGps17(rs.getString(218));
		    		 model.setGps18(rs.getString(219));
		    		 model.setGps19(rs.getString(220));
		    		 model.setGps20(rs.getString(221));
		    		 model.setGps21(rs.getString(222));
		    		 model.setGps22(rs.getString(223));
		    		 model.setGps23(rs.getString(224));
		    		 model.setGps24(rs.getString(225));
		    		 model.setGps25(rs.getString(226));
		    		 model.setGps26(rs.getString(227));
		    		 model.setGps27(rs.getString(228));
		    		 model.setGps28(rs.getString(229));
		    		 model.setGps29(rs.getString(230));
		    		 model.setGps30(rs.getString(231));
		    		 model.setGps31(rs.getString(232));
		    		 model.setGpsTripIssue1(rs.getInt(233));
		    		 model.setGpsTripIssue2(rs.getInt(234));
		    		 model.setGpsTripIssue3(rs.getInt(235));
		    		 model.setGpsTripIssue4(rs.getInt(236));
		    		 model.setGpsTripIssue5(rs.getInt(237));
		    		 model.setGpsTripIssue6(rs.getInt(238));
		    		 model.setGpsTripIssue7(rs.getInt(239));
		    		 model.setGpsTripIssue8(rs.getInt(240));
		    		 model.setGpsTripIssue9(rs.getInt(241));
		    		 model.setGpsTripIssue10(rs.getInt(242));
		    		 model.setGpsTripIssue11(rs.getInt(243));
		    		 model.setGpsTripIssue12(rs.getInt(244));
		    		 model.setGpsTripIssue13(rs.getInt(245));
		    		 model.setGpsTripIssue14(rs.getInt(246));
		    		 model.setGpsTripIssue15(rs.getInt(247));
		    		 model.setGpsTripIssue16(rs.getInt(248));
		    		 model.setGpsTripIssue17(rs.getInt(249));
		    		 model.setGpsTripIssue18(rs.getInt(250));
		    		 model.setGpsTripIssue19(rs.getInt(251));
		    		 model.setGpsTripIssue20(rs.getInt(252));
		    		 model.setGpsTripIssue21(rs.getInt(253));
		    		 model.setGpsTripIssue22(rs.getInt(254));
		    		 model.setGpsTripIssue23(rs.getInt(255));
		    		 model.setGpsTripIssue24(rs.getInt(256));
		    		 model.setGpsTripIssue25(rs.getInt(257));
		    		 model.setGpsTripIssue26(rs.getInt(258));
		    		 model.setGpsTripIssue27(rs.getInt(259));
		    		 model.setGpsTripIssue28(rs.getInt(260));
		    		 model.setGpsTripIssue29(rs.getInt(261));
		    		 model.setGpsTripIssue30(rs.getInt(262));
		    		 model.setGpsTripIssue31(rs.getInt(263));
		    		 model.setTotalMaintenance(rs.getInt(264));//totalmaintenance
		    		 model.setTotalBreakdown(rs.getInt(265));//totalbreakdown
		    		 model.setTotalPM(rs.getInt(266));//totalpm
		    		 model.setTotalPending(rs.getInt(267));//totalpending
		    		 model.setTotalTargetDate(rs.getInt(268));//totaltargetdate
		    		 model.setTotalExtended(rs.getInt(269));//totalextended
		    		 model.setTotalEarlyDone(rs.getInt(270));//totalearlydone
		    		 model.setTotalTripsGPS(rs.getInt(271));//totaltripsgps
		    		 model.setTotalTripsGPSWeek1(rs.getInt(272));
		    		 model.setTotalAvailabilityWeek1(rs.getInt(273));
		    		 model.setTotalTripsGPSWeek2(rs.getInt(274));
		    		 model.setTotalAvailabilityWeek2(rs.getInt(275));
		    		 model.setTotalTripsGPSWeek3(rs.getInt(276));
		    		 model.setTotalAvailabilityWeek3(rs.getInt(277));
		    		 model.setTotalTripsGPSWeek4(rs.getInt(278));
		    		 model.setTotalAvailabilityWeek4(rs.getInt(279));
		    		 model.setTotalTripsGPSWeek5(rs.getInt(280));
		    		 model.setTotalGpsTripIssueTI(rs.getInt(281));//GPS Trip Terminal Issue (TI)
		    		 model.setTotalGpsTripIssueMI(rs.getInt(282));//GPS Trip Maintenance Issue (MI)
		    		 model.setTotalGpsTripIssueDI(rs.getInt(283));//GPS Trip Driver Issue (DI)
		    		 model.setTotalGpsTripIssueCI(rs.getInt(284));//GPS Trip Customer Issue (CI)
		    		 model.setTotalGpsTripIssueLV(rs.getInt(285));//GPS Trip Low Volume (LV)
		    		 model.setTotalGpsTripIssueLH(rs.getInt(286));//GPS Trip Long Haul (LH)
		    		 model.setTotalGpsTripIssueTBI(rs.getInt(287));//GPS Trip Truck Ban Issue (TBI)
		    		 model.setTotalGpsTripIssueRI(rs.getInt(288));//GPS Trip Road Issue (RI)
		    		 model.setGps1Vol(rs.getInt(289));
		    		 model.setGps2Vol(rs.getInt(290));
		    		 model.setGps3Vol(rs.getInt(291));
		    		 model.setGps4Vol(rs.getInt(292));
		    		 model.setGps5Vol(rs.getInt(293));
		    		 model.setGps6Vol(rs.getInt(294));
		    		 model.setGps7Vol(rs.getInt(295));
		    		 model.setGps8Vol(rs.getInt(296));
		    		 model.setGps9Vol(rs.getInt(297));
		    		 model.setGps10Vol(rs.getInt(298));
		    		 model.setGps11Vol(rs.getInt(299));
		    		 model.setGps12Vol(rs.getInt(300));
		    		 model.setGps13Vol(rs.getInt(301));
		    		 model.setGps14Vol(rs.getInt(302));
		    		 model.setGps15Vol(rs.getInt(303));
		    		 model.setGps16Vol(rs.getInt(304));
		    		 model.setGps17Vol(rs.getInt(305));
		    		 model.setGps18Vol(rs.getInt(306));
		    		 model.setGps19Vol(rs.getInt(307));
		    		 model.setGps20Vol(rs.getInt(308));
		    		 model.setGps21Vol(rs.getInt(309));
		    		 model.setGps22Vol(rs.getInt(310));
		    		 model.setGps23Vol(rs.getInt(311));
		    		 model.setGps24Vol(rs.getInt(312));
		    		 model.setGps25Vol(rs.getInt(313));
		    		 model.setGps26Vol(rs.getInt(314));
		    		 model.setGps27Vol(rs.getInt(315));
		    		 model.setGps28Vol(rs.getInt(316));
		    		 model.setGps29Vol(rs.getInt(317));
		    		 model.setGps30Vol(rs.getInt(318));
		    		 model.setGps31Vol(rs.getInt(319));
		    		 model.setCommittedVolume(rs.getInt(320));
		    		 model.setMaintenanceCategory1(rs.getInt(321));		    		 
		    		 model.setMaintenanceCategory2(rs.getInt(322));
		    		 model.setMaintenanceCategory3(rs.getInt(323));
		    		 model.setMaintenanceCategory4(rs.getInt(324));
		    		 model.setMaintenanceCategory5(rs.getInt(325));
		    		 model.setMaintenanceCategory6(rs.getInt(326));
		    		 model.setMaintenanceCategory7(rs.getInt(327));
		    		 model.setMaintenanceCategory8(rs.getInt(328));
		    		 model.setMaintenanceCategory9(rs.getInt(329));
		    		 model.setMaintenanceCategory10(rs.getInt(330));
		    		 model.setMaintenanceCategory11(rs.getInt(331));
		    		 model.setMaintenanceCategory12(rs.getInt(332));
		    		 model.setMaintenanceCategory13(rs.getInt(333));
		    		 model.setMaintenanceCategory14(rs.getInt(334));
		    		 model.setMaintenanceCategory15(rs.getInt(335));
		    		 model.setMaintenanceCategory16(rs.getInt(336));
		    		 model.setMaintenanceCategory17(rs.getInt(337));
		    		 model.setMaintenanceCategory18(rs.getInt(338));
		    		 model.setMaintenanceCategory19(rs.getInt(339));
		    		 model.setMaintenanceCategory20(rs.getInt(340));
		    		 model.setMaintenanceCategory21(rs.getInt(341));
		    		 model.setMaintenanceCategory22(rs.getInt(342));
		    		 model.setMaintenanceCategory23(rs.getInt(343));
		    		 model.setMaintenanceCategory24(rs.getInt(344));
		    		 model.setMaintenanceCategory25(rs.getInt(345));
		    		 model.setMaintenanceCategory26(rs.getInt(346));
		    		 model.setMaintenanceCategory27(rs.getInt(347));
		    		 model.setMaintenanceCategory28(rs.getInt(348));
		    		 model.setMaintenanceCategory29(rs.getInt(349));
		    		 model.setMaintenanceCategory30(rs.getInt(350));
		    		 model.setMaintenanceCategory31(rs.getInt(351));
		    		 model.setGpsWeek1Vol(model.getGps1Vol()+model.getGps2Vol()+model.getGps3Vol()+model.getGps4Vol()+model.getGps5Vol()+model.getGps6Vol()+model.getGps7Vol());
		    		 model.setGpsWeek2Vol(model.getGps8Vol()+model.getGps9Vol()+model.getGps10Vol()+model.getGps11Vol()+model.getGps12Vol()+model.getGps13Vol()+model.getGps14Vol());
		    		 model.setGpsWeek3Vol(model.getGps15Vol()+model.getGps16Vol()+model.getGps17Vol()+model.getGps18Vol()+model.getGps19Vol()+model.getGps20Vol()+model.getGps21Vol());
		    		 model.setGpsWeek4Vol(model.getGps22Vol()+model.getGps23Vol()+model.getGps24Vol()+model.getGps25Vol()+model.getGps26Vol()+model.getGps27Vol()+model.getGps28Vol());
		    		 model.setGpsWeek5Vol(model.getGps29Vol()+model.getGps30Vol()+model.getGps31Vol());
		    		 model.setGpsMonthVol(model.getGpsWeek1Vol()+model.getGpsWeek2Vol()+model.getGpsWeek3Vol()+model.getGpsWeek4Vol()+model.getGpsWeek5Vol());
		    		 rsList.add(model);
				 }				
				 
				 if (lorryNo==null || lorryNo.trim().equals("")) {
					 //Shell Fleet Data
					 StringBuilder sqlInner = new StringBuilder("select count(a.lorryno) as totallorry, sum(coalesce(cast(a.maintenance1 as int),0)) as totalm1, count(a.lorryno) - sum(coalesce(cast(a.maintenance1 as int),0)) as totalu1 ");
					 	 sqlInner.append(" ,sum(coalesce(cast(a.maintenance2 as int),0)) as totalm2, count(a.lorryno) - sum(coalesce(cast(a.maintenance2 as int),0)) as totalu2 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance3 as int),0)) as totalm3, count(a.lorryno) - sum(coalesce(cast(a.maintenance3 as int),0)) as totalu3 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance4 as int),0)) as totalm4, count(a.lorryno) - sum(coalesce(cast(a.maintenance4 as int),0)) as totalu4 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance5 as int),0)) as totalm5, count(a.lorryno) - sum(coalesce(cast(a.maintenance5 as int),0)) as totalu5 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance6 as int),0)) as totalm6, count(a.lorryno) - sum(coalesce(cast(a.maintenance6 as int),0)) as totalu6 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance7 as int),0)) as totalm7, count(a.lorryno) - sum(coalesce(cast(a.maintenance7 as int),0)) as totalu7 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance8 as int),0)) as totalm8, count(a.lorryno) - sum(coalesce(cast(a.maintenance8 as int),0)) as totalu8 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance9 as int),0)) as totalm9, count(a.lorryno) - sum(coalesce(cast(a.maintenance9 as int),0)) as totalu9 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance10 as int),0)) as totalm10, count(a.lorryno) - sum(coalesce(cast(a.maintenance10 as int),0)) as totalu10 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance11 as int),0)) as totalm11, count(a.lorryno) - sum(coalesce(cast(a.maintenance11 as int),0)) as totalu11 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance12 as int),0)) as totalm12, count(a.lorryno) - sum(coalesce(cast(a.maintenance12 as int),0)) as totalu12 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance13 as int),0)) as totalm13, count(a.lorryno) - sum(coalesce(cast(a.maintenance13 as int),0)) as totalu13 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance14 as int),0)) as totalm14, count(a.lorryno) - sum(coalesce(cast(a.maintenance14 as int),0)) as totalu14 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance15 as int),0)) as totalm15, count(a.lorryno) - sum(coalesce(cast(a.maintenance15 as int),0)) as totalu15 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance16 as int),0)) as totalm16, count(a.lorryno) - sum(coalesce(cast(a.maintenance16 as int),0)) as totalu16 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance17 as int),0)) as totalm17, count(a.lorryno) - sum(coalesce(cast(a.maintenance17 as int),0)) as totalu17 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance18 as int),0)) as totalm18, count(a.lorryno) - sum(coalesce(cast(a.maintenance18 as int),0)) as totalu18 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance19 as int),0)) as totalm19, count(a.lorryno) - sum(coalesce(cast(a.maintenance19 as int),0)) as totalu19 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance20 as int),0)) as totalm20, count(a.lorryno) - sum(coalesce(cast(a.maintenance20 as int),0)) as totalu20 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance21 as int),0)) as totalm21, count(a.lorryno) - sum(coalesce(cast(a.maintenance21 as int),0)) as totalu21 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance22 as int),0)) as totalm22, count(a.lorryno) - sum(coalesce(cast(a.maintenance22 as int),0)) as totalu22 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance23 as int),0)) as totalm23, count(a.lorryno) - sum(coalesce(cast(a.maintenance23 as int),0)) as totalu23 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance24 as int),0)) as totalm24, count(a.lorryno) - sum(coalesce(cast(a.maintenance24 as int),0)) as totalu24 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance25 as int),0)) as totalm25, count(a.lorryno) - sum(coalesce(cast(a.maintenance25 as int),0)) as totalu25 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance26 as int),0)) as totalm26, count(a.lorryno) - sum(coalesce(cast(a.maintenance26 as int),0)) as totalu26 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance27 as int),0)) as totalm27, count(a.lorryno) - sum(coalesce(cast(a.maintenance27 as int),0)) as totalu27 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance28 as int),0)) as totalm28, count(a.lorryno) - sum(coalesce(cast(a.maintenance28 as int),0)) as totalu28 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance29 as int),0)) as totalm29, count(a.lorryno) - sum(coalesce(cast(a.maintenance29 as int),0)) as totalu29 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance30 as int),0)) as totalm30, count(a.lorryno) - sum(coalesce(cast(a.maintenance30 as int),0)) as totalu30 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance31 as int),0)) as totalm31, count(a.lorryno) - sum(coalesce(cast(a.maintenance31 as int),0)) as totalu31 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.gps1 as int),0)) as totalg1, sum(coalesce(cast(a.gps2 as int),0)) as totalg2, sum(coalesce(cast(a.gps3 as int),0)) as totalg3 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.gps4 as int),0)) as totalg4, sum(coalesce(cast(a.gps5 as int),0)) as totalg5, sum(coalesce(cast(a.gps6 as int),0)) as totalg6 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.gps7 as int),0)) as totalg7, sum(coalesce(cast(a.gps8 as int),0)) as totalg8, sum(coalesce(cast(a.gps9 as int),0)) as totalg9 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.gps10 as int),0)) as totalg10, sum(coalesce(cast(a.gps11 as int),0)) as totalg11, sum(coalesce(cast(a.gps12 as int),0)) as totalg12 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.gps13 as int),0)) as totalg13, sum(coalesce(cast(a.gps14 as int),0)) as totalg14, sum(coalesce(cast(a.gps15 as int),0)) as totalg15 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.gps16 as int),0)) as totalg16, sum(coalesce(cast(a.gps17 as int),0)) as totalg17, sum(coalesce(cast(a.gps18 as int),0)) as totalg18 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.gps19 as int),0)) as totalg19, sum(coalesce(cast(a.gps20 as int),0)) as totalg20, sum(coalesce(cast(a.gps21 as int),0)) as totalg21 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.gps22 as int),0)) as totalg22, sum(coalesce(cast(a.gps23 as int),0)) as totalg23, sum(coalesce(cast(a.gps24 as int),0)) as totalg24 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.gps25 as int),0)) as totalg25, sum(coalesce(cast(a.gps26 as int),0)) as totalg26, sum(coalesce(cast(a.gps27 as int),0)) as totalg27 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.gps28 as int),0)) as totalg28, sum(coalesce(cast(a.gps29 as int),0)) as totalg29, sum(coalesce(cast(a.gps30 as int),0)) as totalg30 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.gps31 as int),0)) as totalg31 ");  
						 sqlInner.append(" from transport.tran_maintenance a ");
						 sqlInner.append(" where a.year = ? ");
						 sqlInner.append(" and a.month = ? ");
						 sqlInner.append(" and a.transportid = 601 ");
						 sqlInner.append(" and a.active = true ");
					 
					 pstmt2 = conn.prepareStatement(sqlInner.toString());
					 
					 pstmt2.setInt(1, year);
					 pstmt2.setInt(2, month);					 
					 
					 rs2 = pstmt2.executeQuery();
					 			 
					 while(rs2.next()) {
						 MaintenanceMonitoringFleet model = new MaintenanceMonitoringFleet();
						 model.setTotalLorry(rs2.getInt(1));
						 model.setTotalM1(rs2.getInt(2));
						 model.setTotalU1(rs2.getInt(3));
						 model.setTotalM2(rs2.getInt(4));
						 model.setTotalU2(rs2.getInt(5));
						 model.setTotalM3(rs2.getInt(6));
						 model.setTotalU3(rs2.getInt(7));
						 model.setTotalM4(rs2.getInt(8));
						 model.setTotalU4(rs2.getInt(9));
						 model.setTotalM5(rs2.getInt(10));
						 model.setTotalU5(rs2.getInt(11));
						 model.setTotalM6(rs2.getInt(12));
						 model.setTotalU6(rs2.getInt(13));
						 model.setTotalM7(rs2.getInt(14));
						 model.setTotalU7(rs2.getInt(15));
						 model.setTotalM8(rs2.getInt(16));
						 model.setTotalU8(rs2.getInt(17));
						 model.setTotalM9(rs2.getInt(18));
						 model.setTotalU9(rs2.getInt(19));
						 model.setTotalM10(rs2.getInt(20));
						 model.setTotalU10(rs2.getInt(21));
						 model.setTotalM11(rs2.getInt(22));
						 model.setTotalU11(rs2.getInt(23));
						 model.setTotalM12(rs2.getInt(24));
						 model.setTotalU12(rs2.getInt(25));
						 model.setTotalM13(rs2.getInt(26));
						 model.setTotalU13(rs2.getInt(27));
						 model.setTotalM14(rs2.getInt(28));
						 model.setTotalU14(rs2.getInt(29));
						 model.setTotalM15(rs2.getInt(30));
						 model.setTotalU15(rs2.getInt(31));
						 model.setTotalM16(rs2.getInt(32));
						 model.setTotalU16(rs2.getInt(33));
						 model.setTotalM17(rs2.getInt(34));
						 model.setTotalU17(rs2.getInt(35));
						 model.setTotalM18(rs2.getInt(36));
						 model.setTotalU18(rs2.getInt(37));
						 model.setTotalM19(rs2.getInt(38));
						 model.setTotalU19(rs2.getInt(39));
						 model.setTotalM20(rs2.getInt(40));
						 model.setTotalU20(rs2.getInt(41));
						 model.setTotalM21(rs2.getInt(42));
						 model.setTotalU21(rs2.getInt(43));
						 model.setTotalM22(rs2.getInt(44));
						 model.setTotalU22(rs2.getInt(45));
						 model.setTotalM23(rs2.getInt(46));
						 model.setTotalU23(rs2.getInt(47));
						 model.setTotalM24(rs2.getInt(48));
						 model.setTotalU24(rs2.getInt(49));
						 model.setTotalM25(rs2.getInt(50));
						 model.setTotalU25(rs2.getInt(51));
						 model.setTotalM26(rs2.getInt(52));
						 model.setTotalU26(rs2.getInt(53));
						 model.setTotalM27(rs2.getInt(54));
						 model.setTotalU27(rs2.getInt(55));
						 model.setTotalM28(rs2.getInt(56));
						 model.setTotalU28(rs2.getInt(57));
						 model.setTotalM29(rs2.getInt(58));
						 model.setTotalU29(rs2.getInt(59));
						 model.setTotalM30(rs2.getInt(60));
						 model.setTotalU30(rs2.getInt(61));
						 model.setTotalM31(rs2.getInt(62));
						 model.setTotalU31(rs2.getInt(63));
						 model.setTotalG1(rs2.getInt(64));
						 model.setTotalG2(rs2.getInt(65));
						 model.setTotalG3(rs2.getInt(66));
						 model.setTotalG4(rs2.getInt(67));
						 model.setTotalG5(rs2.getInt(68));
						 model.setTotalG6(rs2.getInt(69));
						 model.setTotalG7(rs2.getInt(70));
						 model.setTotalG8(rs2.getInt(71));
						 model.setTotalG9(rs2.getInt(72));
						 model.setTotalG10(rs2.getInt(73));
						 model.setTotalG11(rs2.getInt(74));
						 model.setTotalG12(rs2.getInt(75));
						 model.setTotalG13(rs2.getInt(76));
						 model.setTotalG14(rs2.getInt(77));
						 model.setTotalG15(rs2.getInt(78));
						 model.setTotalG16(rs2.getInt(79));
						 model.setTotalG17(rs2.getInt(80));
						 model.setTotalG18(rs2.getInt(81));
						 model.setTotalG19(rs2.getInt(82));
						 model.setTotalG20(rs2.getInt(83));
						 model.setTotalG21(rs2.getInt(84));
						 model.setTotalG22(rs2.getInt(85));
						 model.setTotalG23(rs2.getInt(86));
						 model.setTotalG24(rs2.getInt(87));
						 model.setTotalG25(rs2.getInt(88));
						 model.setTotalG26(rs2.getInt(89));
						 model.setTotalG27(rs2.getInt(90));
						 model.setTotalG28(rs2.getInt(91));
						 model.setTotalG29(rs2.getInt(92));
						 model.setTotalG30(rs2.getInt(93));
						 model.setTotalG31(rs2.getInt(94));
						 rsListShellFleet.add(model);
					 }
					 
					 //Caltex Fleet Data
					 rs2.close();
					 pstmt2.close();
					 sqlInner = null;
					 
					 sqlInner = new StringBuilder("select count(a.lorryno) as totallorry, sum(coalesce(cast(a.maintenance1 as int),0)) as totalm1, count(a.lorryno) - sum(coalesce(cast(a.maintenance1 as int),0)) as totalu1 ");
					 	 sqlInner.append(" ,sum(coalesce(cast(a.maintenance2 as int),0)) as totalm2, count(a.lorryno) - sum(coalesce(cast(a.maintenance2 as int),0)) as totalu2 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance3 as int),0)) as totalm3, count(a.lorryno) - sum(coalesce(cast(a.maintenance3 as int),0)) as totalu3 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance4 as int),0)) as totalm4, count(a.lorryno) - sum(coalesce(cast(a.maintenance4 as int),0)) as totalu4 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance5 as int),0)) as totalm5, count(a.lorryno) - sum(coalesce(cast(a.maintenance5 as int),0)) as totalu5 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance6 as int),0)) as totalm6, count(a.lorryno) - sum(coalesce(cast(a.maintenance6 as int),0)) as totalu6 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance7 as int),0)) as totalm7, count(a.lorryno) - sum(coalesce(cast(a.maintenance7 as int),0)) as totalu7 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance8 as int),0)) as totalm8, count(a.lorryno) - sum(coalesce(cast(a.maintenance8 as int),0)) as totalu8 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance9 as int),0)) as totalm9, count(a.lorryno) - sum(coalesce(cast(a.maintenance9 as int),0)) as totalu9 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance10 as int),0)) as totalm10, count(a.lorryno) - sum(coalesce(cast(a.maintenance10 as int),0)) as totalu10 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance11 as int),0)) as totalm11, count(a.lorryno) - sum(coalesce(cast(a.maintenance11 as int),0)) as totalu11 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance12 as int),0)) as totalm12, count(a.lorryno) - sum(coalesce(cast(a.maintenance12 as int),0)) as totalu12 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance13 as int),0)) as totalm13, count(a.lorryno) - sum(coalesce(cast(a.maintenance13 as int),0)) as totalu13 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance14 as int),0)) as totalm14, count(a.lorryno) - sum(coalesce(cast(a.maintenance14 as int),0)) as totalu14 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance15 as int),0)) as totalm15, count(a.lorryno) - sum(coalesce(cast(a.maintenance15 as int),0)) as totalu15 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance16 as int),0)) as totalm16, count(a.lorryno) - sum(coalesce(cast(a.maintenance16 as int),0)) as totalu16 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance17 as int),0)) as totalm17, count(a.lorryno) - sum(coalesce(cast(a.maintenance17 as int),0)) as totalu17 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance18 as int),0)) as totalm18, count(a.lorryno) - sum(coalesce(cast(a.maintenance18 as int),0)) as totalu18 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance19 as int),0)) as totalm19, count(a.lorryno) - sum(coalesce(cast(a.maintenance19 as int),0)) as totalu19 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance20 as int),0)) as totalm20, count(a.lorryno) - sum(coalesce(cast(a.maintenance20 as int),0)) as totalu20 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance21 as int),0)) as totalm21, count(a.lorryno) - sum(coalesce(cast(a.maintenance21 as int),0)) as totalu21 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance22 as int),0)) as totalm22, count(a.lorryno) - sum(coalesce(cast(a.maintenance22 as int),0)) as totalu22 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance23 as int),0)) as totalm23, count(a.lorryno) - sum(coalesce(cast(a.maintenance23 as int),0)) as totalu23 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance24 as int),0)) as totalm24, count(a.lorryno) - sum(coalesce(cast(a.maintenance24 as int),0)) as totalu24 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance25 as int),0)) as totalm25, count(a.lorryno) - sum(coalesce(cast(a.maintenance25 as int),0)) as totalu25 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance26 as int),0)) as totalm26, count(a.lorryno) - sum(coalesce(cast(a.maintenance26 as int),0)) as totalu26 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance27 as int),0)) as totalm27, count(a.lorryno) - sum(coalesce(cast(a.maintenance27 as int),0)) as totalu27 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance28 as int),0)) as totalm28, count(a.lorryno) - sum(coalesce(cast(a.maintenance28 as int),0)) as totalu28 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance29 as int),0)) as totalm29, count(a.lorryno) - sum(coalesce(cast(a.maintenance29 as int),0)) as totalu29 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance30 as int),0)) as totalm30, count(a.lorryno) - sum(coalesce(cast(a.maintenance30 as int),0)) as totalu30 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.maintenance31 as int),0)) as totalm31, count(a.lorryno) - sum(coalesce(cast(a.maintenance31 as int),0)) as totalu31 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.gps1 as int),0)) as totalg1, sum(coalesce(cast(a.gps2 as int),0)) as totalg2, sum(coalesce(cast(a.gps3 as int),0)) as totalg3 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.gps4 as int),0)) as totalg4, sum(coalesce(cast(a.gps5 as int),0)) as totalg5, sum(coalesce(cast(a.gps6 as int),0)) as totalg6 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.gps7 as int),0)) as totalg7, sum(coalesce(cast(a.gps8 as int),0)) as totalg8, sum(coalesce(cast(a.gps9 as int),0)) as totalg9 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.gps10 as int),0)) as totalg10, sum(coalesce(cast(a.gps11 as int),0)) as totalg11, sum(coalesce(cast(a.gps12 as int),0)) as totalg12 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.gps13 as int),0)) as totalg13, sum(coalesce(cast(a.gps14 as int),0)) as totalg14, sum(coalesce(cast(a.gps15 as int),0)) as totalg15 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.gps16 as int),0)) as totalg16, sum(coalesce(cast(a.gps17 as int),0)) as totalg17, sum(coalesce(cast(a.gps18 as int),0)) as totalg18 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.gps19 as int),0)) as totalg19, sum(coalesce(cast(a.gps20 as int),0)) as totalg20, sum(coalesce(cast(a.gps21 as int),0)) as totalg21 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.gps22 as int),0)) as totalg22, sum(coalesce(cast(a.gps23 as int),0)) as totalg23, sum(coalesce(cast(a.gps24 as int),0)) as totalg24 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.gps25 as int),0)) as totalg25, sum(coalesce(cast(a.gps26 as int),0)) as totalg26, sum(coalesce(cast(a.gps27 as int),0)) as totalg27 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.gps28 as int),0)) as totalg28, sum(coalesce(cast(a.gps29 as int),0)) as totalg29, sum(coalesce(cast(a.gps30 as int),0)) as totalg30 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.gps31 as int),0)) as totalg31 ");  
						 sqlInner.append(" from transport.tran_maintenance a ");
						 sqlInner.append(" where a.year = ? ");
						 sqlInner.append(" and a.month = ? ");
						 sqlInner.append(" and a.transportid = 602 ");//caltex
						 sqlInner.append(" and a.active = true ");
					 
					 pstmt2 = conn.prepareStatement(sqlInner.toString());
					 
					 pstmt2.setInt(1, year);
					 pstmt2.setInt(2, month);					 
					 
					 rs2 = pstmt2.executeQuery();
					 			 
					 while(rs2.next()) {
						 MaintenanceMonitoringFleet model = new MaintenanceMonitoringFleet();
						 model.setTotalLorry(rs2.getInt(1));
						 model.setTotalM1(rs2.getInt(2));
						 model.setTotalU1(rs2.getInt(3));
						 model.setTotalM2(rs2.getInt(4));
						 model.setTotalU2(rs2.getInt(5));
						 model.setTotalM3(rs2.getInt(6));
						 model.setTotalU3(rs2.getInt(7));
						 model.setTotalM4(rs2.getInt(8));
						 model.setTotalU4(rs2.getInt(9));
						 model.setTotalM5(rs2.getInt(10));
						 model.setTotalU5(rs2.getInt(11));
						 model.setTotalM6(rs2.getInt(12));
						 model.setTotalU6(rs2.getInt(13));
						 model.setTotalM7(rs2.getInt(14));
						 model.setTotalU7(rs2.getInt(15));
						 model.setTotalM8(rs2.getInt(16));
						 model.setTotalU8(rs2.getInt(17));
						 model.setTotalM9(rs2.getInt(18));
						 model.setTotalU9(rs2.getInt(19));
						 model.setTotalM10(rs2.getInt(20));
						 model.setTotalU10(rs2.getInt(21));
						 model.setTotalM11(rs2.getInt(22));
						 model.setTotalU11(rs2.getInt(23));
						 model.setTotalM12(rs2.getInt(24));
						 model.setTotalU12(rs2.getInt(25));
						 model.setTotalM13(rs2.getInt(26));
						 model.setTotalU13(rs2.getInt(27));
						 model.setTotalM14(rs2.getInt(28));
						 model.setTotalU14(rs2.getInt(29));
						 model.setTotalM15(rs2.getInt(30));
						 model.setTotalU15(rs2.getInt(31));
						 model.setTotalM16(rs2.getInt(32));
						 model.setTotalU16(rs2.getInt(33));
						 model.setTotalM17(rs2.getInt(34));
						 model.setTotalU17(rs2.getInt(35));
						 model.setTotalM18(rs2.getInt(36));
						 model.setTotalU18(rs2.getInt(37));
						 model.setTotalM19(rs2.getInt(38));
						 model.setTotalU19(rs2.getInt(39));
						 model.setTotalM20(rs2.getInt(40));
						 model.setTotalU20(rs2.getInt(41));
						 model.setTotalM21(rs2.getInt(42));
						 model.setTotalU21(rs2.getInt(43));
						 model.setTotalM22(rs2.getInt(44));
						 model.setTotalU22(rs2.getInt(45));
						 model.setTotalM23(rs2.getInt(46));
						 model.setTotalU23(rs2.getInt(47));
						 model.setTotalM24(rs2.getInt(48));
						 model.setTotalU24(rs2.getInt(49));
						 model.setTotalM25(rs2.getInt(50));
						 model.setTotalU25(rs2.getInt(51));
						 model.setTotalM26(rs2.getInt(52));
						 model.setTotalU26(rs2.getInt(53));
						 model.setTotalM27(rs2.getInt(54));
						 model.setTotalU27(rs2.getInt(55));
						 model.setTotalM28(rs2.getInt(56));
						 model.setTotalU28(rs2.getInt(57));
						 model.setTotalM29(rs2.getInt(58));
						 model.setTotalU29(rs2.getInt(59));
						 model.setTotalM30(rs2.getInt(60));
						 model.setTotalU30(rs2.getInt(61));
						 model.setTotalM31(rs2.getInt(62));
						 model.setTotalU31(rs2.getInt(63));
						 model.setTotalG1(rs2.getInt(64));
						 model.setTotalG2(rs2.getInt(65));
						 model.setTotalG3(rs2.getInt(66));
						 model.setTotalG4(rs2.getInt(67));
						 model.setTotalG5(rs2.getInt(68));
						 model.setTotalG6(rs2.getInt(69));
						 model.setTotalG7(rs2.getInt(70));
						 model.setTotalG8(rs2.getInt(71));
						 model.setTotalG9(rs2.getInt(72));
						 model.setTotalG10(rs2.getInt(73));
						 model.setTotalG11(rs2.getInt(74));
						 model.setTotalG12(rs2.getInt(75));
						 model.setTotalG13(rs2.getInt(76));
						 model.setTotalG14(rs2.getInt(77));
						 model.setTotalG15(rs2.getInt(78));
						 model.setTotalG16(rs2.getInt(79));
						 model.setTotalG17(rs2.getInt(80));
						 model.setTotalG18(rs2.getInt(81));
						 model.setTotalG19(rs2.getInt(82));
						 model.setTotalG20(rs2.getInt(83));
						 model.setTotalG21(rs2.getInt(84));
						 model.setTotalG22(rs2.getInt(85));
						 model.setTotalG23(rs2.getInt(86));
						 model.setTotalG24(rs2.getInt(87));
						 model.setTotalG25(rs2.getInt(88));
						 model.setTotalG26(rs2.getInt(89));
						 model.setTotalG27(rs2.getInt(90));
						 model.setTotalG28(rs2.getInt(91));
						 model.setTotalG29(rs2.getInt(92));
						 model.setTotalG30(rs2.getInt(93));
						 model.setTotalG31(rs2.getInt(94));
						 rsListCaltexFleet.add(model);
					 }
					 
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
			 		     
			 //create the list for the GRAND TOTAL of FLEET
			 List<MaintenanceMonitoringFleet> grandTotalFleet = new ArrayList<>();
			 for (MaintenanceMonitoringFleet itemShell : rsListShellFleet) {
				 for (MaintenanceMonitoringFleet itemChevron : rsListCaltexFleet) {
					 MaintenanceMonitoringFleet model = new MaintenanceMonitoringFleet();
					 model.setTotalM1(itemShell.getTotalM1() + itemChevron.getTotalM1());
					 model.setTotalU1(itemShell.getTotalU1() + itemChevron.getTotalU1());
					 model.setTotalM2(itemShell.getTotalM2() + itemChevron.getTotalM2());
					 model.setTotalU2(itemShell.getTotalU2() + itemChevron.getTotalU2());
					 model.setTotalM3(itemShell.getTotalM3() + itemChevron.getTotalM3());
					 model.setTotalU3(itemShell.getTotalU3() + itemChevron.getTotalU3());
					 model.setTotalM4(itemShell.getTotalM4() + itemChevron.getTotalM4());
					 model.setTotalU4(itemShell.getTotalU4() + itemChevron.getTotalU4());
					 model.setTotalM5(itemShell.getTotalM5() + itemChevron.getTotalM5());
					 model.setTotalU5(itemShell.getTotalU5() + itemChevron.getTotalU5());
					 model.setTotalM6(itemShell.getTotalM6() + itemChevron.getTotalM6());
					 model.setTotalU6(itemShell.getTotalU6() + itemChevron.getTotalU6());
					 model.setTotalM7(itemShell.getTotalM7() + itemChevron.getTotalM7());
					 model.setTotalU7(itemShell.getTotalU7() + itemChevron.getTotalU7());
					 model.setTotalM8(itemShell.getTotalM8() + itemChevron.getTotalM8());
					 model.setTotalU8(itemShell.getTotalU8() + itemChevron.getTotalU8());
					 model.setTotalM9(itemShell.getTotalM9() + itemChevron.getTotalM9());
					 model.setTotalU9(itemShell.getTotalU9() + itemChevron.getTotalU9());
					 model.setTotalM10(itemShell.getTotalM10() + itemChevron.getTotalM10());
					 model.setTotalU10(itemShell.getTotalU10() + itemChevron.getTotalU10());
					 model.setTotalM11(itemShell.getTotalM11() + itemChevron.getTotalM11());
					 model.setTotalU11(itemShell.getTotalU11() + itemChevron.getTotalU11());
					 model.setTotalM12(itemShell.getTotalM12() + itemChevron.getTotalM12());
					 model.setTotalU12(itemShell.getTotalU12() + itemChevron.getTotalU12());
					 model.setTotalM13(itemShell.getTotalM13() + itemChevron.getTotalM13());
					 model.setTotalU13(itemShell.getTotalU13() + itemChevron.getTotalU13());
					 model.setTotalM14(itemShell.getTotalM14() + itemChevron.getTotalM14());
					 model.setTotalU14(itemShell.getTotalU14() + itemChevron.getTotalU14());
					 model.setTotalM15(itemShell.getTotalM15() + itemChevron.getTotalM15());
					 model.setTotalU15(itemShell.getTotalU15() + itemChevron.getTotalU15());
					 model.setTotalM16(itemShell.getTotalM16() + itemChevron.getTotalM16());
					 model.setTotalU16(itemShell.getTotalU16() + itemChevron.getTotalU16());
					 model.setTotalM17(itemShell.getTotalM17() + itemChevron.getTotalM17());
					 model.setTotalU17(itemShell.getTotalU17() + itemChevron.getTotalU17());
					 model.setTotalM18(itemShell.getTotalM18() + itemChevron.getTotalM18());
					 model.setTotalU18(itemShell.getTotalU18() + itemChevron.getTotalU18());
					 model.setTotalM19(itemShell.getTotalM19() + itemChevron.getTotalM19());
					 model.setTotalU19(itemShell.getTotalU19() + itemChevron.getTotalU19());
					 model.setTotalM20(itemShell.getTotalM20() + itemChevron.getTotalM20());
					 model.setTotalU20(itemShell.getTotalU20() + itemChevron.getTotalU20());
					 model.setTotalM21(itemShell.getTotalM21() + itemChevron.getTotalM21());
					 model.setTotalU21(itemShell.getTotalU21() + itemChevron.getTotalU21());
					 model.setTotalM22(itemShell.getTotalM22() + itemChevron.getTotalM22());
					 model.setTotalU22(itemShell.getTotalU22() + itemChevron.getTotalU22());
					 model.setTotalM23(itemShell.getTotalM23() + itemChevron.getTotalM23());
					 model.setTotalU23(itemShell.getTotalU23() + itemChevron.getTotalU23());
					 model.setTotalM24(itemShell.getTotalM24() + itemChevron.getTotalM24());
					 model.setTotalU24(itemShell.getTotalU24() + itemChevron.getTotalU24());
					 model.setTotalM25(itemShell.getTotalM25() + itemChevron.getTotalM25());
					 model.setTotalU25(itemShell.getTotalU25() + itemChevron.getTotalU25());
					 model.setTotalM26(itemShell.getTotalM26() + itemChevron.getTotalM26());
					 model.setTotalU26(itemShell.getTotalU26() + itemChevron.getTotalU26());
					 model.setTotalM27(itemShell.getTotalM27() + itemChevron.getTotalM27());
					 model.setTotalU27(itemShell.getTotalU27() + itemChevron.getTotalU27());
					 model.setTotalM28(itemShell.getTotalM28() + itemChevron.getTotalM28());
					 model.setTotalU28(itemShell.getTotalU28() + itemChevron.getTotalU28());
					 model.setTotalM29(itemShell.getTotalM29() + itemChevron.getTotalM29());
					 model.setTotalU29(itemShell.getTotalU29() + itemChevron.getTotalU29());
					 model.setTotalM30(itemShell.getTotalM30() + itemChevron.getTotalM30());
					 model.setTotalU30(itemShell.getTotalU30() + itemChevron.getTotalU30());
					 model.setTotalM31(itemShell.getTotalM31() + itemChevron.getTotalM31());
					 model.setTotalU31(itemShell.getTotalU31() + itemChevron.getTotalU31());
					 grandTotalFleet.add(model);
				 }
			 }
			 
		     if (rsList!=null && !rsList.isEmpty()) {
		    	 returnMap = new HashMap<String, Object>();
		    	 returnMap.put(MapConstant.CLASS_LIST, rsList);
		    	 returnMap.put(MapConstant.CLASS_LIST_2, rsListShellFleet);
		    	 returnMap.put(MapConstant.CLASS_LIST_3, rsListCaltexFleet);
		    	 returnMap.put(MapConstant.CLASS_LIST_4, grandTotalFleet);
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
		    MaintenanceMonitoring model = (MaintenanceMonitoring) criteriaMap.get(MapConstant.CLASS_DATA);

		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
		     Map<String, Object> returnMap = null;
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();				
				 sql = new StringBuffer("select * ");
				 	sql.append("from transport.tran_maintenance ");
				 	sql.append("where id = ? ");

				 TransportUtils.writeLogDebug(logger, "SQL: "+sql.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, model.getId());
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
					model.setId(rs.getInt(1));
					model.setGpsColor1(rs.getInt(9));
					model.setGpsRemarks1(rs.getString(10));
					model.setMaintenance1(rs.getString(11));
					model.setMaintenanceColor1(rs.getInt(12));
					model.setMaintenanceRemarks1(rs.getString(13));
					model.setAvailableVolume1(rs.getInt(14));
					model.setGpsColor2(rs.getInt(15));
					model.setGpsRemarks2(rs.getString(16));
					model.setMaintenance2(rs.getString(17));
					model.setMaintenanceColor2(rs.getInt(18));
					model.setMaintenanceRemarks2(rs.getString(19));
					model.setAvailableVolume2(rs.getInt(20));					 
					model.setGpsColor3(rs.getInt(21));
					model.setGpsRemarks3(rs.getString(22));
					model.setMaintenance3(rs.getString(23));
					model.setMaintenanceColor3(rs.getInt(24));
					model.setMaintenanceRemarks3(rs.getString(25));
					model.setAvailableVolume3(rs.getInt(26));
					model.setGpsColor4(rs.getInt(27));
					model.setGpsRemarks4(rs.getString(28));
					model.setMaintenance4(rs.getString(29));
					model.setMaintenanceColor4(rs.getInt(30));
					model.setMaintenanceRemarks4(rs.getString(31));
					model.setAvailableVolume4(rs.getInt(32));
					model.setGpsColor5(rs.getInt(33));
					model.setGpsRemarks5(rs.getString(34));
					model.setMaintenance5(rs.getString(35));
					model.setMaintenanceColor5(rs.getInt(36));
					model.setMaintenanceRemarks5(rs.getString(37));
					model.setAvailableVolume5(rs.getInt(38));
					model.setGpsColor6(rs.getInt(39));
					model.setGpsRemarks6(rs.getString(40));
					model.setMaintenance6(rs.getString(41));
					model.setMaintenanceColor6(rs.getInt(42));
					model.setMaintenanceRemarks6(rs.getString(43));
					model.setAvailableVolume6(rs.getInt(44));
					model.setGpsColor7(rs.getInt(45));
					model.setGpsRemarks7(rs.getString(46));
					model.setMaintenance7(rs.getString(47));
					model.setMaintenanceColor7(rs.getInt(48));
					model.setMaintenanceRemarks7(rs.getString(49));
					model.setAvailableVolume7(rs.getInt(50));
					model.setGpsColor8(rs.getInt(51));
					model.setGpsRemarks8(rs.getString(52));
					model.setMaintenance8(rs.getString(53));
					model.setMaintenanceColor8(rs.getInt(54));
					model.setMaintenanceRemarks8(rs.getString(55));
					model.setAvailableVolume8(rs.getInt(56));	
					model.setGpsColor9(rs.getInt(57));
					model.setGpsRemarks9(rs.getString(58));
					model.setMaintenance9(rs.getString(59));
					model.setMaintenanceColor9(rs.getInt(60));
					model.setMaintenanceRemarks9(rs.getString(61));
					model.setAvailableVolume9(rs.getInt(62));
					model.setGpsColor10(rs.getInt(63));
					model.setGpsRemarks10(rs.getString(64));
					model.setMaintenance10(rs.getString(65));
					model.setMaintenanceColor10(rs.getInt(66));
					model.setMaintenanceRemarks10(rs.getString(67));
					model.setAvailableVolume10(rs.getInt(68));	
					model.setGpsColor11(rs.getInt(69));
					model.setGpsRemarks11(rs.getString(70));
					model.setMaintenance11(rs.getString(71));
					model.setMaintenanceColor11(rs.getInt(72));
					model.setMaintenanceRemarks11(rs.getString(73));
					model.setAvailableVolume11(rs.getInt(74));	
					model.setGpsColor12(rs.getInt(75));
					model.setGpsRemarks12(rs.getString(76));
					model.setMaintenance12(rs.getString(77));
					model.setMaintenanceColor12(rs.getInt(78));
					model.setMaintenanceRemarks12(rs.getString(79));
					model.setAvailableVolume12(rs.getInt(80));	
					model.setGpsColor13(rs.getInt(81));
					model.setGpsRemarks13(rs.getString(82));
					model.setMaintenance13(rs.getString(83));
					model.setMaintenanceColor13(rs.getInt(84));
					model.setMaintenanceRemarks13(rs.getString(85));
					model.setAvailableVolume13(rs.getInt(86));
					model.setGpsColor14(rs.getInt(87));
					model.setGpsRemarks14(rs.getString(88));
					model.setMaintenance14(rs.getString(89));
					model.setMaintenanceColor14(rs.getInt(90));
					model.setMaintenanceRemarks14(rs.getString(91));
					model.setAvailableVolume14(rs.getInt(92));
					model.setGpsColor15(rs.getInt(93));
					model.setGpsRemarks15(rs.getString(94));
					model.setMaintenance15(rs.getString(95));
					model.setMaintenanceColor15(rs.getInt(96));
					model.setMaintenanceRemarks15(rs.getString(97));
					model.setAvailableVolume15(rs.getInt(98));
					model.setGpsColor16(rs.getInt(99));
					model.setGpsRemarks16(rs.getString(100));
					model.setMaintenance16(rs.getString(101));
					model.setMaintenanceColor16(rs.getInt(102));
					model.setMaintenanceRemarks16(rs.getString(103));
					model.setAvailableVolume16(rs.getInt(104));
					model.setGpsColor17(rs.getInt(105));
					model.setGpsRemarks17(rs.getString(106));
					model.setMaintenance17(rs.getString(107));
					model.setMaintenanceColor17(rs.getInt(108));
					model.setMaintenanceRemarks17(rs.getString(109));
					model.setAvailableVolume17(rs.getInt(110));	
					model.setGpsColor18(rs.getInt(111));
					model.setGpsRemarks18(rs.getString(112));
					model.setMaintenance18(rs.getString(113));
					model.setMaintenanceColor18(rs.getInt(114));
					model.setMaintenanceRemarks18(rs.getString(115));
					model.setAvailableVolume18(rs.getInt(116));
					model.setGpsColor19(rs.getInt(117));
					model.setGpsRemarks19(rs.getString(118));
					model.setMaintenance19(rs.getString(119));
					model.setMaintenanceColor19(rs.getInt(120));
					model.setMaintenanceRemarks19(rs.getString(121));
					model.setAvailableVolume19(rs.getInt(122));	
					model.setGpsColor20(rs.getInt(123));
					model.setGpsRemarks20(rs.getString(124));
					model.setMaintenance20(rs.getString(125));
					model.setMaintenanceColor20(rs.getInt(126));
					model.setMaintenanceRemarks20(rs.getString(127));
					model.setAvailableVolume20(rs.getInt(128));	
					model.setGpsColor21(rs.getInt(129));
					model.setGpsRemarks21(rs.getString(130));
					model.setMaintenance21(rs.getString(131));
					model.setMaintenanceColor21(rs.getInt(132));
					model.setMaintenanceRemarks21(rs.getString(133));
					model.setAvailableVolume21(rs.getInt(134));	
					model.setGpsColor22(rs.getInt(135));
					model.setGpsRemarks22(rs.getString(136));
					model.setMaintenance22(rs.getString(137));
					model.setMaintenanceColor22(rs.getInt(138));
					model.setMaintenanceRemarks22(rs.getString(139));
					model.setAvailableVolume22(rs.getInt(140));
					model.setGpsColor23(rs.getInt(141));
					model.setGpsRemarks23(rs.getString(142));
					model.setMaintenance23(rs.getString(143));
					model.setMaintenanceColor23(rs.getInt(144));
					model.setMaintenanceRemarks23(rs.getString(145));
					model.setAvailableVolume23(rs.getInt(146));	
					model.setGpsColor24(rs.getInt(147));
					model.setGpsRemarks24(rs.getString(148));
					model.setMaintenance24(rs.getString(149));
					model.setMaintenanceColor24(rs.getInt(150));
					model.setMaintenanceRemarks24(rs.getString(151));
					model.setAvailableVolume24(rs.getInt(152));
					model.setGpsColor25(rs.getInt(153));
					model.setGpsRemarks25(rs.getString(154));
					model.setMaintenance25(rs.getString(155));
					model.setMaintenanceColor25(rs.getInt(156));
					model.setMaintenanceRemarks25(rs.getString(157));
					model.setAvailableVolume25(rs.getInt(158));	
					model.setGpsColor26(rs.getInt(159));
					model.setGpsRemarks26(rs.getString(160));
					model.setMaintenance26(rs.getString(161));
					model.setMaintenanceColor26(rs.getInt(162));
					model.setMaintenanceRemarks26(rs.getString(163));
					model.setAvailableVolume26(rs.getInt(164));	
					model.setGpsColor27(rs.getInt(165));
					model.setGpsRemarks27(rs.getString(166));
					model.setMaintenance27(rs.getString(167));
					model.setMaintenanceColor27(rs.getInt(168));
					model.setMaintenanceRemarks27(rs.getString(169));
					model.setAvailableVolume27(rs.getInt(170));	
					model.setGpsColor28(rs.getInt(171));
					model.setGpsRemarks28(rs.getString(172));
					model.setMaintenance28(rs.getString(173));
					model.setMaintenanceColor28(rs.getInt(174));
					model.setMaintenanceRemarks28(rs.getString(175));
					model.setAvailableVolume28(rs.getInt(176));	
					model.setGpsColor29(rs.getInt(177));
					model.setGpsRemarks29(rs.getString(178));
					model.setMaintenance29(rs.getString(179));
					model.setMaintenanceColor29(rs.getInt(180));
					model.setMaintenanceRemarks29(rs.getString(181));
					model.setAvailableVolume29(rs.getInt(182));	
					model.setGpsColor30(rs.getInt(183));
					model.setGpsRemarks30(rs.getString(184));
					model.setMaintenance30(rs.getString(185));
					model.setMaintenanceColor30(rs.getInt(186));
					model.setMaintenanceRemarks30(rs.getString(187));
					model.setAvailableVolume30(rs.getInt(188));	
					model.setGpsColor31(rs.getInt(189));
					model.setGpsRemarks31(rs.getString(190));
					model.setMaintenance31(rs.getString(191));
					model.setMaintenanceColor31(rs.getInt(192));
					model.setMaintenanceRemarks31(rs.getString(193));
					model.setAvailableVolume31(rs.getInt(194));	
					model.setTransportId(rs.getInt(201));
		    		model.setGps1(rs.getString(202));
		    		model.setGps2(rs.getString(203));
		    		model.setGps3(rs.getString(204));
		    		model.setGps4(rs.getString(205));
		    		model.setGps5(rs.getString(206));
		    		model.setGps6(rs.getString(207));
		    		model.setGps7(rs.getString(208));
		    		model.setGps8(rs.getString(209));
		    		model.setGps9(rs.getString(210));
		    		model.setGps10(rs.getString(211));
		    		model.setGps11(rs.getString(212));
		    		model.setGps12(rs.getString(213));
		    		model.setGps13(rs.getString(214));
		    		model.setGps14(rs.getString(215));
		    		model.setGps15(rs.getString(216));
		    		model.setGps16(rs.getString(217));
		    		model.setGps17(rs.getString(218));
		    		model.setGps18(rs.getString(219));
		    		model.setGps19(rs.getString(220));
		    		model.setGps20(rs.getString(221));
		    		model.setGps21(rs.getString(222));
		    		model.setGps22(rs.getString(223));
		    		model.setGps23(rs.getString(224));
		    		model.setGps24(rs.getString(225));
		    		model.setGps25(rs.getString(226));
		    		model.setGps26(rs.getString(227));
		    		model.setGps27(rs.getString(228));
		    		model.setGps28(rs.getString(229));
		    		model.setGps29(rs.getString(230));
		    		model.setGps30(rs.getString(231));
		    		model.setGps31(rs.getString(232));	
		    		model.setGpsTripIssue1(rs.getInt(233));
		    		 model.setGpsTripIssue2(rs.getInt(234));
		    		 model.setGpsTripIssue3(rs.getInt(235));
		    		 model.setGpsTripIssue4(rs.getInt(236));
		    		 model.setGpsTripIssue5(rs.getInt(237));
		    		 model.setGpsTripIssue6(rs.getInt(238));
		    		 model.setGpsTripIssue7(rs.getInt(239));
		    		 model.setGpsTripIssue8(rs.getInt(240));
		    		 model.setGpsTripIssue9(rs.getInt(241));
		    		 model.setGpsTripIssue10(rs.getInt(242));
		    		 model.setGpsTripIssue11(rs.getInt(243));
		    		 model.setGpsTripIssue12(rs.getInt(244));
		    		 model.setGpsTripIssue13(rs.getInt(245));
		    		 model.setGpsTripIssue14(rs.getInt(246));
		    		 model.setGpsTripIssue15(rs.getInt(247));
		    		 model.setGpsTripIssue16(rs.getInt(248));
		    		 model.setGpsTripIssue17(rs.getInt(249));
		    		 model.setGpsTripIssue18(rs.getInt(250));
		    		 model.setGpsTripIssue19(rs.getInt(251));
		    		 model.setGpsTripIssue20(rs.getInt(252));
		    		 model.setGpsTripIssue21(rs.getInt(253));
		    		 model.setGpsTripIssue22(rs.getInt(254));
		    		 model.setGpsTripIssue23(rs.getInt(255));
		    		 model.setGpsTripIssue24(rs.getInt(256));
		    		 model.setGpsTripIssue25(rs.getInt(257));
		    		 model.setGpsTripIssue26(rs.getInt(258));
		    		 model.setGpsTripIssue27(rs.getInt(259));
		    		 model.setGpsTripIssue28(rs.getInt(260));
		    		 model.setGpsTripIssue29(rs.getInt(261));
		    		 model.setGpsTripIssue30(rs.getInt(262));
		    		 model.setGpsTripIssue31(rs.getInt(263));
		    		 model.setCommittedVolume(rs.getInt(264));
		    		 model.setMaintenanceCategory1(rs.getInt(265));
		    		 model.setMaintenanceCategory2(rs.getInt(266));
		    		 model.setMaintenanceCategory3(rs.getInt(267));
		    		 model.setMaintenanceCategory4(rs.getInt(268));
		    		 model.setMaintenanceCategory5(rs.getInt(269));
		    		 model.setMaintenanceCategory6(rs.getInt(270));
		    		 model.setMaintenanceCategory7(rs.getInt(271));
		    		 model.setMaintenanceCategory8(rs.getInt(272));
		    		 model.setMaintenanceCategory9(rs.getInt(273));
		    		 model.setMaintenanceCategory10(rs.getInt(274));
		    		 model.setMaintenanceCategory11(rs.getInt(275));
		    		 model.setMaintenanceCategory12(rs.getInt(276));
		    		 model.setMaintenanceCategory13(rs.getInt(277));
		    		 model.setMaintenanceCategory14(rs.getInt(278));
		    		 model.setMaintenanceCategory15(rs.getInt(279));
		    		 model.setMaintenanceCategory16(rs.getInt(280));
		    		 model.setMaintenanceCategory17(rs.getInt(281));
		    		 model.setMaintenanceCategory18(rs.getInt(282));
		    		 model.setMaintenanceCategory19(rs.getInt(283));
		    		 model.setMaintenanceCategory20(rs.getInt(284));
		    		 model.setMaintenanceCategory21(rs.getInt(285));
		    		 model.setMaintenanceCategory22(rs.getInt(286));
		    		 model.setMaintenanceCategory23(rs.getInt(287));
		    		 model.setMaintenanceCategory24(rs.getInt(288));
		    		 model.setMaintenanceCategory25(rs.getInt(289));
		    		 model.setMaintenanceCategory26(rs.getInt(290));
		    		 model.setMaintenanceCategory27(rs.getInt(291));
		    		 model.setMaintenanceCategory28(rs.getInt(292));
		    		 model.setMaintenanceCategory29(rs.getInt(293));
		    		 model.setMaintenanceCategory30(rs.getInt(294));
		    		 model.setMaintenanceCategory31(rs.getInt(295));
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
	public List<Integer> getMaintenanceCategoryData(HashMap<String, Object> criteriaMap) throws Exception {
		// TODO Auto-generated method stub
		TransportUtils.writeLogInfo(logger, "getMaintenanceCategoryData");

	 	//Connection using JNDI DBCP
		 //get the year and month criteria
	 	Integer year = Integer.parseInt((String)criteriaMap.get(MapConstant.YEAR_CRITERIA));
		Integer month = Integer.parseInt((String)criteriaMap.get(MapConstant.MONTH_CRITERIA));
		 
		 Connection conn = null;
		 ResultSet rs = null;
		 PreparedStatement pstmt = null; 
		 
		 List<Integer> categoryList = new ArrayList<>();
  
		 try {
			 conn = ServerContext.getJDBCHandle();

			 StringBuilder sql = new StringBuilder("select maintenancecategory1,maintenancecategory2,maintenancecategory3, ");
			 		sql.append("maintenancecategory4,maintenancecategory5,maintenancecategory6,maintenancecategory7, ");
			 		sql.append("maintenancecategory8,maintenancecategory9,maintenancecategory10,maintenancecategory11, ");
			 		sql.append("maintenancecategory12,maintenancecategory13,maintenancecategory14,maintenancecategory15, ");
			 		sql.append("maintenancecategory16,maintenancecategory17,maintenancecategory18,maintenancecategory19, ");
			 		sql.append("maintenancecategory20,maintenancecategory21,maintenancecategory22,maintenancecategory23, ");
			 		sql.append("maintenancecategory24,maintenancecategory25,maintenancecategory26,maintenancecategory27, ");
			 		sql.append("maintenancecategory28,maintenancecategory29,maintenancecategory30,maintenancecategory31 ");
			 		sql.append("from transport.tran_maintenance where year = ? ");
			 		if (month!=null && month > 0) {
			 			sql.append("and month = ? ");
			 		}
			 		sql.append("and active = true ");
			 		
			 pstmt = conn.prepareStatement(sql.toString());
					 
			 pstmt.setInt(1, year);
			 if (month!=null && month > 0) {
				 pstmt.setInt(2, month);	
			 }
			 						 
			rs = pstmt.executeQuery();
					 			 
			while(rs.next()) {
				for(int i=1;i<=31;i++) {
					if (rs.getInt(i)>0) {
						categoryList.add(rs.getInt(i));
					}
				}
			}
			 		
		 } catch (SQLException e) {
			 throw e;
		 } finally {
			 TransportUtils.closeObjects(rs);
			 TransportUtils.closeObjects(pstmt);
			 TransportUtils.closeObjects(conn);
		 }	 
		
		return categoryList;
	}
		
}
