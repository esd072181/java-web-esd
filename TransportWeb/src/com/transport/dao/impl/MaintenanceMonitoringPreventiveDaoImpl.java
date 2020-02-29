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
import com.transport.dao.MaintenanceMonitoringPreventiveDao;
import com.transport.model.MaintenanceMonitoringPreventive;
import com.transport.model.MaintenanceMonitoringPreventiveTotal;
import com.transport.model.User;
import com.transport.util.TransportUtils;

/**
 * 
 * @author dward
 * @since 25April2019
 * Date Updated: 25April2019
 */
public class MaintenanceMonitoringPreventiveDaoImpl implements MaintenanceMonitoringPreventiveDao {
	
	private final static Logger logger = Logger.getLogger(MaintenanceMonitoringPreventiveDaoImpl.class);

	
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
		
		MaintenanceMonitoringPreventive model = (MaintenanceMonitoringPreventive) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		int moduleInnerId = (int) dataMap.get(MapConstant.MODULE_INNER);
		
		StringBuffer qry = null;
		
		if (moduleInnerId == ModuleConstant.MAINTENANCE_MONITORING_PREVENTIVE_GARAGE) {
			//PGarage
			switch (model.getDay()) {
				case 1: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pgarage1=? ");
					qry.append(" ,pgarageremarks1=? ");
					break;
				case 2: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pgarage2=? ");
					qry.append(" ,pgarageremarks2=? ");
					break;
				case 3: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pgarage3=? ");
					qry.append(" ,pgarageremarks3=? ");					
					break;
				case 4: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pgarage4=? ");
					qry.append(" ,pgarageremarks4=? ");
					break;
				case 5: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pgarage5=? ");
					qry.append(" ,pgarageremarks5=? ");
					break;
				case 6: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pgarage6=? ");
					qry.append(" ,pgarageremarks6=? ");
					break;
				case 7: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pgarage7=? ");
					qry.append(" ,pgarageremarks7=? ");
					break;
				case 8: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pgarage8=? ");
					qry.append(" ,pgarageremarks8=? ");
					break;
				case 9: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pgarage9=? ");
					qry.append(" ,pgarageremarks9=? ");
					
					break;
				case 10: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pgarage10=? ");
					qry.append(" ,pgarageremarks10=? ");				
					break;
				case 11: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pgarage11=? ");
					qry.append(" ,pgarageremarks11=? ");					
					break;
				case 12: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pgarage12=? ");
					qry.append(" ,pgarageremarks12=? ");			
					break;
				case 13: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pgarage13=? ");
					qry.append(" ,pgarageremarks13=? ");	
					break;
				case 14: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pgarage14=? ");
					qry.append(" ,pgarageremarks14=? ");	
					break;
				case 15: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pgarage15=? ");
					qry.append(" ,pgarageremarks15=? ");
					break;
				case 16: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pgarage16=? ");
					qry.append(" ,pgarageremarks16=? ");				
					break;
				case 17: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pgarage17=? ");
					qry.append(" ,pgarageremarks17=? ");		
					break;
				case 18: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pgarage18=? ");
					qry.append(" ,pgarageremarks18=? ");	
					break;
				case 19: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pgarage19=? ");
					qry.append(" ,pgarageremarks19=? ");		
					break;
				case 20: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pgarage20=? ");
					qry.append(" ,pgarageremarks20=? ");		
					break;
				case 21: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pgarage21=? ");
					qry.append(" ,pgarageremarks21=? ");				
					break;
				case 22: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pgarage22=? ");
					qry.append(" ,pgarageremarks22=? ");			
					break;
				case 23: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pgarage23=? ");
					qry.append(" ,pgarageremarks23=? ");		
					break;
				case 24: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pgarage24=? ");
					qry.append(" ,pgarageremarks24=? ");
					break;
				case 25: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pgarage25=? ");
					qry.append(" ,pgarageremarks25=? ");
					break;
				case 26: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pgarage26=? ");
					qry.append(" ,pgarageremarks26=? ");
					break;
				case 27: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pgarage27=? ");
					qry.append(" ,pgarageremarks27=? ");
					break;
				case 28: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pgarage28=? ");
					qry.append(" ,pgarageremarks28=? ");
					break;
				case 29: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pgarage29=? ");
					qry.append(" ,pgarageremarks29=? ");
					break;
				case 30: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pgarage30=? ");
					qry.append(" ,pgarageremarks30=? ");
					break;
				case 31: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pgarage31=? ");
					qry.append(" ,pgarageremarks31=? ");
					break;
			}
			
		} else if (moduleInnerId == ModuleConstant.MAINTENANCE_MONITORING_PREVENTIVE_FBASE){
			switch (model.getDay()) {
			//PFbase
				case 1: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pfbase1=? ");
					qry.append(" ,pfbaseremarks1=? ");
					break;
				case 2: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pfbase2=? ");
					qry.append(" ,pfbaseremarks2=? ");
					break;
				case 3: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pfbase3=? ");
					qry.append(" ,pfbaseremarks3=? ");
					break;
				case 4: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pfbase4=? ");
					qry.append(" ,pfbaseremarks4=? ");
					break;
				case 5: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pfbase5=? ");
					qry.append(" ,pfbaseremarks5=? ");
					break;
				case 6: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pfbase6=? ");
					qry.append(" ,pfbaseremarks6=? ");
					break;
				case 7: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pfbase7=? ");
					qry.append(" ,pfbaseremarks7=? ");
					break;
				case 8: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pfbase8=? ");
					qry.append(" ,pfbaseremarks8=? ");
					break;
				case 9: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pfbase9=? ");
					qry.append(" ,pfbaseremarks9=? ");
					break;
				case 10: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pfbase10=? ");
					qry.append(" ,pfbaseremarks10=? ");
					break;
				case 11: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pfbase11=? ");
					qry.append(" ,pfbaseremarks11=? ");
					break;
				case 12: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pfbase12=? ");
					qry.append(" ,pfbaseremarks12=? ");
					break;
				case 13: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pfbase13=? ");
					qry.append(" ,pfbaseremarks13=? ");
					break;
				case 14: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pfbase14=? ");
					qry.append(" ,pfbaseremarks14=? ");
					break;
				case 15: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pfbase15=? ");
					qry.append(" ,pfbaseremarks15=? ");
					break;
				case 16: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pfbase16=? ");
					qry.append(" ,pfbaseremarks16=? ");
					break;
				case 17: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pfbase17=? ");
					qry.append(" ,pfbaseremarks17=? ");
					break;
				case 18: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pfbase18=? ");
					qry.append(" ,pfbaseremarks18=? ");
					break;
				case 19: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pfbase19=? ");
					qry.append(" ,pfbaseremarks19=? ");
					break;
				case 20: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pfbase20=? ");
					qry.append(" ,pfbaseremarks20=? ");
					break;
				case 21: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pfbase21=? ");
					qry.append(" ,pfbaseremarks21=? ");
					break;
				case 22: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pfbase22=? ");
					qry.append(" ,pfbaseremarks22=? ");
					break;
				case 23: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pfbase23=? ");
					qry.append(" ,pfbaseremarks23=? ");
					break;
				case 24: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pfbase24=? ");
					qry.append(" ,pfbaseremarks24=? ");
					break;
				case 25: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pfbase25=? ");
					qry.append(" ,pfbaseremarks25=? ");
					break;
				case 26: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pfbase26=? ");
					qry.append(" ,pfbaseremarks26=? ");
					break;
				case 27: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pfbase27=? ");
					qry.append(" ,pfbaseremarks27=? ");
					break;
				case 28: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pfbase28=? ");
					qry.append(" ,pfbaseremarks28=? ");
					break;
				case 29: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pfbase29=? ");
					qry.append(" ,pfbaseremarks29=? ");
					break;
				case 30: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pfbase30=? ");
					qry.append(" ,pfbaseremarks30=? ");
					break;
				case 31: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" pfbase31=? ");
					qry.append(" ,pfbaseremarks31=? ");
					break;
			}
				
		} else if (moduleInnerId == ModuleConstant.MAINTENANCE_MONITORING_BREAKDOWN_GARAGE){
			switch (model.getDay()) {
				//BGarage
				case 1: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bgarage1=? ");
					qry.append(" ,bgarageremarks1=? ");
					break;
				case 2: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bgarage2=? ");
					qry.append(" ,bgarageremarks2=? ");
					break;
				case 3: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bgarage3=? ");
					qry.append(" ,bgarageremarks3=? ");
					break;
				case 4: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bgarage4=? ");
					qry.append(" ,bgarageremarks4=? ");
					break;
				case 5: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bgarage5=? ");
					qry.append(" ,bgarageremarks5=? ");
					break;
				case 6: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bgarage6=? ");
					qry.append(" ,bgarageremarks6=? ");
					break;
				case 7: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bgarage7=? ");
					qry.append(" ,bgarageremarks7=? ");
					break;
				case 8: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bgarage8=? ");
					qry.append(" ,bgarageremarks8=? ");
					break;
				case 9: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bgarage9=? ");
					qry.append(" ,bgarageremarks9=? ");
					break;
				case 10: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bgarage10=? ");
					qry.append(" ,bgarageremarks10=? ");
					break;
				case 11: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bgarage11=? ");
					qry.append(" ,bgarageremarks11=? ");
					break;
				case 12: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bgarage12=? ");
					qry.append(" ,bgarageremarks12=? ");
					break;
				case 13: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bgarage13=? ");
					qry.append(" ,bgarageremarks13=? ");
					break;
				case 14: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bgarage14=? ");
					qry.append(" ,bgarageremarks14=? ");
					break;
				case 15: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bgarage15=? ");
					qry.append(" ,bgarageremarks15=? ");
					break;
				case 16: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bgarage16=? ");
					qry.append(" ,bgarageremarks16=? ");
					break;
				case 17: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bgarage17=? ");
					qry.append(" ,bgarageremarks17=? ");
					break;
				case 18: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bgarage18=? ");
					qry.append(" ,bgarageremarks18=? ");
					break;
				case 19: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bgarage19=? ");
					qry.append(" ,bgarageremarks19=? ");
					break;
				case 20: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bgarage20=? ");
					qry.append(" ,bgarageremarks20=? ");
					break;
				case 21: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bgarage21=? ");
					qry.append(" ,bgarageremarks21=? ");
					break;
				case 22: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bgarage22=? ");
					qry.append(" ,bgarageremarks22=? ");
					break;
				case 23: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bgarage23=? ");
					qry.append(" ,bgarageremarks23=? ");
					break;
				case 24: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bgarage24=? ");
					qry.append(" ,bgarageremarks24=? ");
					break;
				case 25: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bgarage25=? ");
					qry.append(" ,bgarageremarks25=? ");
					break;
				case 26: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bgarage26=? ");
					qry.append(" ,bgarageremarks26=? ");
					break;
				case 27: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bgarage27=? ");
					qry.append(" ,bgarageremarks27=? ");
					break;
				case 28: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bgarage28=? ");
					qry.append(" ,bgarageremarks28=? ");
					break;
				case 29: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bgarage29=? ");
					qry.append(" ,bgarageremarks29=? ");
					break;
				case 30: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bgarage30=? ");
					qry.append(" ,bgarageremarks30=? ");
					break;
				case 31: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bgarage31=? ");
					qry.append(" ,bgarageremarks31=? ");
					break;
			}
				
		} else if (moduleInnerId == ModuleConstant.MAINTENANCE_MONITORING_BREAKDOWN_FBASE){
			switch (model.getDay()) {
				//BFbase
				case 1: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bfbase1=? ");
					qry.append(" ,bfbaseremarks1=? ");
					break;
				case 2: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bfbase2=? ");
					qry.append(" ,bfbaseremarks2=? ");
					break;
				case 3: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bfbase3=? ");
					qry.append(" ,bfbaseremarks3=? ");
					break;
				case 4: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bfbase4=? ");
					qry.append(" ,bfbaseremarks4=? ");
					break;
				case 5: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bfbase5=? ");
					qry.append(" ,bfbaseremarks5=? ");
					break;
				case 6: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bfbase6=? ");
					qry.append(" ,bfbaseremarks6=? ");
					break;
				case 7: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bfbase7=? ");
					qry.append(" ,bfbaseremarks7=? ");
					break;
				case 8: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bfbase8=? ");
					qry.append(" ,bfbaseremarks8=? ");
					break;
				case 9: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bfbase9=? ");
					qry.append(" ,bfbaseremarks9=? ");
					break;
				case 10: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bfbase10=? ");
					qry.append(" ,bfbaseremarks10=? ");
					break;
				case 11: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bfbase11=? ");
					qry.append(" ,bfbaseremarks11=? ");
					break;
				case 12: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bfbase12=? ");
					qry.append(" ,bfbaseremarks12=? ");
					break;
				case 13: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bfbase13=? ");
					qry.append(" ,bfbaseremarks13=? ");
					break;
				case 14: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bfbase14=? ");
					qry.append(" ,bfbaseremarks14=? ");
					break;
				case 15: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bfbase15=? ");
					qry.append(" ,bfbaseremarks15=? ");
					break;
				case 16: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bfbase16=? ");
					qry.append(" ,bfbaseremarks16=? ");
					break;
				case 17: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bfbase17=? ");
					qry.append(" ,bfbaseremarks17=? ");
					break;
				case 18: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bfbase18=? ");
					qry.append(" ,bfbaseremarks18=? ");
					break;
				case 19: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bfbase19=? ");
					qry.append(" ,bfbaseremarks19=? ");
					break;
				case 20: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bfbase20=? ");
					qry.append(" ,bfbaseremarks20=? ");
					break;
				case 21: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bfbase21=? ");
					qry.append(" ,bfbaseremarks21=? ");
					break;
				case 22: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bfbase22=? ");
					qry.append(" ,bfbaseremarks22=? ");
					break;
				case 23: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bfbase23=? ");
					qry.append(" ,bfbaseremarks23=? ");
					break;
				case 24: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bfbase24=? ");
					qry.append(" ,bfbaseremarks24=? ");
					break;
				case 25: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bfbase25=? ");
					qry.append(" ,bfbaseremarks25=? ");
					break;
				case 26: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bfbase26=? ");
					qry.append(" ,bfbaseremarks26=? ");
					break;
				case 27: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bfbase27=? ");
					qry.append(" ,bfbaseremarks27=? ");
					break;
				case 28: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bfbase28=? ");
					qry.append(" ,bfbaseremarks28=? ");
					break;
				case 29: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bfbase29=? ");
					qry.append(" ,bfbaseremarks29=? ");
					break;
				case 30: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bfbase30=? ");
					qry.append(" ,bfbaseremarks30=? ");
					break;
				case 31: 
					qry =  new StringBuffer("update transport.tran_maintenance_preventive set ");	
					qry.append(" bfbase31=? ");
					qry.append(" ,bfbaseremarks31=? ");
					break;
			}
				
		}



		qry.append(" ,modifiedby=?,modifiedon=?,version=(version+1) where id = ?");
			
		TransportUtils.writeLogDebug(logger, "SQL: "+qry.toString());
	
		 try {
			conn = ServerContext.getJDBCHandle();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(qry.toString());
	
			if (moduleInnerId == ModuleConstant.MAINTENANCE_MONITORING_PREVENTIVE_GARAGE) {
				//PGarage
				switch (model.getDay()) {
					case 1: 
						pstmt.setString(1, model.getPgarage1());
						pstmt.setString(2, model.getPgarageremarks1());
						break;
					case 2: 
						pstmt.setString(1, model.getPgarage2());
						pstmt.setString(2, model.getPgarageremarks2());
						break;
					case 3: 
						pstmt.setString(1, model.getPgarage3());
						pstmt.setString(2, model.getPgarageremarks3());
						break;
					case 4: 
						pstmt.setString(1, model.getPgarage4());
						pstmt.setString(2, model.getPgarageremarks4());
						break;
					case 5: 
						pstmt.setString(1, model.getPgarage5());
						pstmt.setString(2, model.getPgarageremarks5());
						break;
					case 6: 
						pstmt.setString(1, model.getPgarage6());
						pstmt.setString(2, model.getPgarageremarks6());
						break;
					case 7: 
						pstmt.setString(1, model.getPgarage7());
						pstmt.setString(2, model.getPgarageremarks7());
						break;
					case 8: 
						pstmt.setString(1, model.getPgarage8());
						pstmt.setString(2, model.getPgarageremarks8());
						break;
					case 9: 
						pstmt.setString(1, model.getPgarage9());
						pstmt.setString(2, model.getPgarageremarks9());
						break;
					case 10: 
						pstmt.setString(1, model.getPgarage10());
						pstmt.setString(2, model.getPgarageremarks10());
						break;
					case 11: 
						pstmt.setString(1, model.getPgarage11());
						pstmt.setString(2, model.getPgarageremarks11());
						break;
					case 12: 
						pstmt.setString(1, model.getPgarage12());
						pstmt.setString(2, model.getPgarageremarks12());
						break;
					case 13: 
						pstmt.setString(1, model.getPgarage13());
						pstmt.setString(2, model.getPgarageremarks13());
						break;
					case 14: 
						pstmt.setString(1, model.getPgarage14());
						pstmt.setString(2, model.getPgarageremarks14());
						break;
					case 15: 
						pstmt.setString(1, model.getPgarage15());
						pstmt.setString(2, model.getPgarageremarks15());
						break;
					case 16: 
						pstmt.setString(1, model.getPgarage16());
						pstmt.setString(2, model.getPgarageremarks16());
						break;
					case 17: 
						pstmt.setString(1, model.getPgarage17());
						pstmt.setString(2, model.getPgarageremarks17());
						break;
					case 18: 
						pstmt.setString(1, model.getPgarage18());
						pstmt.setString(2, model.getPgarageremarks18());
						break;
					case 19: 
						pstmt.setString(1, model.getPgarage19());
						pstmt.setString(2, model.getPgarageremarks19());
						break;
					case 20: 
						pstmt.setString(1, model.getPgarage20());
						pstmt.setString(2, model.getPgarageremarks20());
						break;
					case 21: 
						pstmt.setString(1, model.getPgarage21());
						pstmt.setString(2, model.getPgarageremarks21());
						break;
					case 22: 
						pstmt.setString(1, model.getPgarage22());
						pstmt.setString(2, model.getPgarageremarks22());
						break;
					case 23: 
						pstmt.setString(1, model.getPgarage23());
						pstmt.setString(2, model.getPgarageremarks23());
						break;
					case 24: 
						pstmt.setString(1, model.getPgarage24());
						pstmt.setString(2, model.getPgarageremarks24());
						break;
					case 25: 
						pstmt.setString(1, model.getPgarage25());
						pstmt.setString(2, model.getPgarageremarks25());
						break;
					case 26: 
						pstmt.setString(1, model.getPgarage26());
						pstmt.setString(2, model.getPgarageremarks26());
						break;
					case 27: 
						pstmt.setString(1, model.getPgarage27());
						pstmt.setString(2, model.getPgarageremarks27());
						break;
					case 28: 
						pstmt.setString(1, model.getPgarage28());
						pstmt.setString(2, model.getPgarageremarks28());
						break;
					case 29: 
						pstmt.setString(1, model.getPgarage29());
						pstmt.setString(2, model.getPgarageremarks29());
						break;
					case 30: 
						pstmt.setString(1, model.getPgarage30());
						pstmt.setString(2, model.getPgarageremarks30());
						break;
					case 31: 
						pstmt.setString(1, model.getPgarage31());
						pstmt.setString(2, model.getPgarageremarks31());
						break;
				}
			} else if (moduleInnerId == ModuleConstant.MAINTENANCE_MONITORING_PREVENTIVE_FBASE) {
				//PFbase
				switch (model.getDay()) {
					case 1: 
						pstmt.setString(1, model.getPfbase1());
						pstmt.setString(2, model.getPfbaseremarks1());
						break;
					case 2: 
						pstmt.setString(1, model.getPfbase2());
						pstmt.setString(2, model.getPfbaseremarks2());
						break;
					case 3: 
						pstmt.setString(1, model.getPfbase3());
						pstmt.setString(2, model.getPfbaseremarks3());
						break;
					case 4: 
						pstmt.setString(1, model.getPfbase4());
						pstmt.setString(2, model.getPfbaseremarks4());
						break;
					case 5: 
						pstmt.setString(1, model.getPfbase5());
						pstmt.setString(2, model.getPfbaseremarks5());
						break;
					case 6: 
						pstmt.setString(1, model.getPfbase6());
						pstmt.setString(2, model.getPfbaseremarks6());
						break;
					case 7: 
						pstmt.setString(1, model.getPfbase7());
						pstmt.setString(2, model.getPfbaseremarks7());
						break;
					case 8: 
						pstmt.setString(1, model.getPfbase8());
						pstmt.setString(2, model.getPfbaseremarks8());
						break;
					case 9: 
						pstmt.setString(1, model.getPfbase9());
						pstmt.setString(2, model.getPfbaseremarks9());
						break;
					case 10: 
						pstmt.setString(1, model.getPfbase10());
						pstmt.setString(2, model.getPfbaseremarks10());
						break;
					case 11: 
						pstmt.setString(1, model.getPfbase11());
						pstmt.setString(2, model.getPfbaseremarks11());
						break;
					case 12: 
						pstmt.setString(1, model.getPfbase12());
						pstmt.setString(2, model.getPfbaseremarks12());
						break;
					case 13: 
						pstmt.setString(1, model.getPfbase13());
						pstmt.setString(2, model.getPfbaseremarks13());
						break;
					case 14: 
						pstmt.setString(1, model.getPfbase14());
						pstmt.setString(2, model.getPfbaseremarks14());
						break;
					case 15: 
						pstmt.setString(1, model.getPfbase15());
						pstmt.setString(2, model.getPfbaseremarks15());
						break;
					case 16: 
						pstmt.setString(1, model.getPfbase16());
						pstmt.setString(2, model.getPfbaseremarks16());
						break;
					case 17: 
						pstmt.setString(1, model.getPfbase17());
						pstmt.setString(2, model.getPfbaseremarks17());
						break;
					case 18: 
						pstmt.setString(1, model.getPfbase18());
						pstmt.setString(2, model.getPfbaseremarks18());
						break;
					case 19: 
						pstmt.setString(1, model.getPfbase19());
						pstmt.setString(2, model.getPfbaseremarks19());
						break;
					case 20: 
						pstmt.setString(1, model.getPfbase20());
						pstmt.setString(2, model.getPfbaseremarks20());
						break;
					case 21: 
						pstmt.setString(1, model.getPfbase21());
						pstmt.setString(2, model.getPfbaseremarks21());
						break;
					case 22: 
						pstmt.setString(1, model.getPfbase22());
						pstmt.setString(2, model.getPfbaseremarks22());
						break;
					case 23: 
						pstmt.setString(1, model.getPfbase23());
						pstmt.setString(2, model.getPfbaseremarks23());
						break;
					case 24: 
						pstmt.setString(1, model.getPfbase24());
						pstmt.setString(2, model.getPfbaseremarks24());
						break;
					case 25: 
						pstmt.setString(1, model.getPfbase25());
						pstmt.setString(2, model.getPfbaseremarks25());
						break;
					case 26: 
						pstmt.setString(1, model.getPfbase26());
						pstmt.setString(2, model.getPfbaseremarks26());
						break;
					case 27: 
						pstmt.setString(1, model.getPfbase27());
						pstmt.setString(2, model.getPfbaseremarks27());
						break;
					case 28: 
						pstmt.setString(1, model.getPfbase28());
						pstmt.setString(2, model.getPfbaseremarks28());
						break;
					case 29: 
						pstmt.setString(1, model.getPfbase29());
						pstmt.setString(2, model.getPfbaseremarks29());
						break;
					case 30: 
						pstmt.setString(1, model.getPfbase30());
						pstmt.setString(2, model.getPfbaseremarks30());
						break;
					case 31: 
						pstmt.setString(1, model.getPfbase31());
						pstmt.setString(2, model.getPfbaseremarks31());
						break;
				}				
			} else if (moduleInnerId == ModuleConstant.MAINTENANCE_MONITORING_BREAKDOWN_GARAGE) {
				//BGarage
				switch (model.getDay()) {
					case 1: 
						pstmt.setString(1, model.getBgarage1());
						pstmt.setString(2, model.getBgarageremarks1());
						break;
					case 2: 
						pstmt.setString(1, model.getBgarage2());
						pstmt.setString(2, model.getBgarageremarks2());
						break;
					case 3: 
						pstmt.setString(1, model.getBgarage3());
						pstmt.setString(2, model.getBgarageremarks3());
						break;
					case 4: 
						pstmt.setString(1, model.getBgarage4());
						pstmt.setString(2, model.getBgarageremarks4());
						break;
					case 5: 
						pstmt.setString(1, model.getBgarage5());
						pstmt.setString(2, model.getBgarageremarks5());
						break;
					case 6: 
						pstmt.setString(1, model.getBgarage6());
						pstmt.setString(2, model.getBgarageremarks6());
						break;
					case 7: 
						pstmt.setString(1, model.getBgarage7());
						pstmt.setString(2, model.getBgarageremarks7());
						break;
					case 8: 
						pstmt.setString(1, model.getBgarage8());
						pstmt.setString(2, model.getBgarageremarks8());
						break;
					case 9: 
						pstmt.setString(1, model.getBgarage9());
						pstmt.setString(2, model.getBgarageremarks9());
						break;
					case 10: 
						pstmt.setString(1, model.getBgarage10());
						pstmt.setString(2, model.getBgarageremarks10());
						break;
					case 11: 
						pstmt.setString(1, model.getBgarage11());
						pstmt.setString(2, model.getBgarageremarks11());
						break;
					case 12: 
						pstmt.setString(1, model.getBgarage12());
						pstmt.setString(2, model.getBgarageremarks12());
						break;
					case 13: 
						pstmt.setString(1, model.getBgarage13());
						pstmt.setString(2, model.getBgarageremarks13());
						break;
					case 14: 
						pstmt.setString(1, model.getBgarage14());
						pstmt.setString(2, model.getBgarageremarks14());
						break;
					case 15: 
						pstmt.setString(1, model.getBgarage15());
						pstmt.setString(2, model.getBgarageremarks15());
						break;
					case 16: 
						pstmt.setString(1, model.getBgarage16());
						pstmt.setString(2, model.getBgarageremarks16());
						break;
					case 17: 
						pstmt.setString(1, model.getBgarage17());
						pstmt.setString(2, model.getBgarageremarks17());
						break;
					case 18: 
						pstmt.setString(1, model.getBgarage18());
						pstmt.setString(2, model.getBgarageremarks18());
						break;
					case 19: 
						pstmt.setString(1, model.getBgarage19());
						pstmt.setString(2, model.getBgarageremarks19());
						break;
					case 20: 
						pstmt.setString(1, model.getBgarage20());
						pstmt.setString(2, model.getBgarageremarks20());
						break;
					case 21: 
						pstmt.setString(1, model.getBgarage21());
						pstmt.setString(2, model.getBgarageremarks21());
						break;
					case 22: 
						pstmt.setString(1, model.getBgarage22());
						pstmt.setString(2, model.getBgarageremarks22());
						break;
					case 23: 
						pstmt.setString(1, model.getBgarage23());
						pstmt.setString(2, model.getBgarageremarks23());
						break;
					case 24: 
						pstmt.setString(1, model.getBgarage24());
						pstmt.setString(2, model.getBgarageremarks24());
						break;
					case 25: 
						pstmt.setString(1, model.getBgarage25());
						pstmt.setString(2, model.getBgarageremarks25());
						break;
					case 26: 
						pstmt.setString(1, model.getBgarage26());
						pstmt.setString(2, model.getBgarageremarks26());
						break;
					case 27: 
						pstmt.setString(1, model.getBgarage27());
						pstmt.setString(2, model.getBgarageremarks27());
						break;
					case 28: 
						pstmt.setString(1, model.getBgarage28());
						pstmt.setString(2, model.getBgarageremarks28());
						break;
					case 29: 
						pstmt.setString(1, model.getBgarage29());
						pstmt.setString(2, model.getBgarageremarks29());
						break;
					case 30: 
						pstmt.setString(1, model.getBgarage30());
						pstmt.setString(2, model.getBgarageremarks30());
						break;
					case 31: 
						pstmt.setString(1, model.getBgarage31());
						pstmt.setString(2, model.getBgarageremarks31());
						break;
				}				
			} else if (moduleInnerId == ModuleConstant.MAINTENANCE_MONITORING_BREAKDOWN_FBASE) {
				//BFbase
				switch (model.getDay()) {
					case 1: 
						pstmt.setString(1, model.getBfbase1());
						pstmt.setString(2, model.getBfbaseremarks1());
						break;
					case 2: 
						pstmt.setString(1, model.getBfbase2());
						pstmt.setString(2, model.getBfbaseremarks2());
						break;
					case 3: 
						pstmt.setString(1, model.getBfbase3());
						pstmt.setString(2, model.getBfbaseremarks3());
						break;
					case 4: 
						pstmt.setString(1, model.getBfbase4());
						pstmt.setString(2, model.getBfbaseremarks4());
						break;
					case 5: 
						pstmt.setString(1, model.getBfbase5());
						pstmt.setString(2, model.getBfbaseremarks5());
						break;
					case 6: 
						pstmt.setString(1, model.getBfbase6());
						pstmt.setString(2, model.getBfbaseremarks6());
						break;
					case 7: 
						pstmt.setString(1, model.getBfbase7());
						pstmt.setString(2, model.getBfbaseremarks7());
						break;
					case 8: 
						pstmt.setString(1, model.getBfbase8());
						pstmt.setString(2, model.getBfbaseremarks8());
						break;
					case 9: 
						pstmt.setString(1, model.getBfbase9());
						pstmt.setString(2, model.getBfbaseremarks9());
						break;
					case 10: 
						pstmt.setString(1, model.getBfbase10());
						pstmt.setString(2, model.getBfbaseremarks10());
						break;
					case 11: 
						pstmt.setString(1, model.getBfbase11());
						pstmt.setString(2, model.getBfbaseremarks11());
						break;
					case 12: 
						pstmt.setString(1, model.getBfbase12());
						pstmt.setString(2, model.getBfbaseremarks12());
						break;
					case 13: 
						pstmt.setString(1, model.getBfbase13());
						pstmt.setString(2, model.getBfbaseremarks13());
						break;
					case 14: 
						pstmt.setString(1, model.getBfbase14());
						pstmt.setString(2, model.getBfbaseremarks14());
						break;
					case 15: 
						pstmt.setString(1, model.getBfbase15());
						pstmt.setString(2, model.getBfbaseremarks15());
						break;
					case 16: 
						pstmt.setString(1, model.getBfbase16());
						pstmt.setString(2, model.getBfbaseremarks16());
						break;
					case 17: 
						pstmt.setString(1, model.getBfbase17());
						pstmt.setString(2, model.getBfbaseremarks17());
						break;
					case 18: 
						pstmt.setString(1, model.getBfbase18());
						pstmt.setString(2, model.getBfbaseremarks18());
						break;
					case 19: 
						pstmt.setString(1, model.getBfbase19());
						pstmt.setString(2, model.getBfbaseremarks19());
						break;
					case 20: 
						pstmt.setString(1, model.getBfbase20());
						pstmt.setString(2, model.getBfbaseremarks20());
						break;
					case 21: 
						pstmt.setString(1, model.getBfbase21());
						pstmt.setString(2, model.getBfbaseremarks21());
						break;
					case 22: 
						pstmt.setString(1, model.getBfbase22());
						pstmt.setString(2, model.getBfbaseremarks22());
						break;
					case 23: 
						pstmt.setString(1, model.getBfbase23());
						pstmt.setString(2, model.getBfbaseremarks23());
						break;
					case 24: 
						pstmt.setString(1, model.getBfbase24());
						pstmt.setString(2, model.getBfbaseremarks24());
						break;
					case 25: 
						pstmt.setString(1, model.getBfbase25());
						pstmt.setString(2, model.getBfbaseremarks25());
						break;
					case 26: 
						pstmt.setString(1, model.getBfbase26());
						pstmt.setString(2, model.getBfbaseremarks26());
						break;
					case 27: 
						pstmt.setString(1, model.getBfbase27());
						pstmt.setString(2, model.getBfbaseremarks27());
						break;
					case 28: 
						pstmt.setString(1, model.getBfbase28());
						pstmt.setString(2, model.getBfbaseremarks28());
						break;
					case 29: 
						pstmt.setString(1, model.getBfbase29());
						pstmt.setString(2, model.getBfbaseremarks29());
						break;
					case 30: 
						pstmt.setString(1, model.getBfbase30());
						pstmt.setString(2, model.getBfbaseremarks30());
						break;
					case 31: 
						pstmt.setString(1, model.getBfbase31());
						pstmt.setString(2, model.getBfbaseremarks31());
						break;
				}				
			}

			pstmt.setInt(3, model.getModifiedBy());
			pstmt.setTimestamp(4, model.getModifiedOn());
			pstmt.setLong(5, model.getId());

				     
			int statusInt = pstmt.executeUpdate();
				     
			if (statusInt == 1) {
				conn.commit();
				System.out.println("Maintenance Monitoring Preventive record (id: " +model.getId()+") updated successfully..");
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
			 
			 List<MaintenanceMonitoringPreventive> rsList = new ArrayList<>();
			 List<MaintenanceMonitoringPreventiveTotal> rsTotal = new ArrayList<>();
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuilder sql = new StringBuilder("select a.* ");
					 	sql.append(" from transport.tran_maintenance_preventive a");
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
					 MaintenanceMonitoringPreventive model = new MaintenanceMonitoringPreventive();  
		    		 model.setId(rs.getInt(1));
		    		 model.setYear(rs.getInt(2));
		    		 model.setMonth(rs.getInt(3));
		    		 model.setPgarage1(rs.getString(4));
		    		 model.setPgarageremarks1(rs.getString(5));
		    		 model.setPfbase1(rs.getString(6));
		    		 model.setPfbaseremarks1(rs.getString(7));
		    		 model.setBgarage1(rs.getString(8));
		    		 model.setBgarageremarks1(rs.getString(9));
		    		 model.setBfbase1(rs.getString(10));
		    		 model.setBfbaseremarks1(rs.getString(11));
		    		 model.setPgarage2(rs.getString(12));
		    		 model.setPgarageremarks2(rs.getString(13));
		    		 model.setPfbase2(rs.getString(14));
		    		 model.setPfbaseremarks2(rs.getString(15));
		    		 model.setBgarage2(rs.getString(16));
		    		 model.setBgarageremarks2(rs.getString(17));
		    		 model.setBfbase2(rs.getString(18));
		    		 model.setBfbaseremarks2(rs.getString(19));
		    		 model.setPgarage3(rs.getString(20));
		    		 model.setPgarageremarks3(rs.getString(21));
		    		 model.setPfbase3(rs.getString(22));
		    		 model.setPfbaseremarks3(rs.getString(23));
		    		 model.setBgarage3(rs.getString(24));
		    		 model.setBgarageremarks3(rs.getString(25));
		    		 model.setBfbase3(rs.getString(26));
		    		 model.setBfbaseremarks3(rs.getString(27));
		    		 model.setPgarage4(rs.getString(28));
		    		 model.setPgarageremarks4(rs.getString(29));
		    		 model.setPfbase4(rs.getString(30));
		    		 model.setPfbaseremarks4(rs.getString(31));
		    		 model.setBgarage4(rs.getString(32));
		    		 model.setBgarageremarks4(rs.getString(33));
		    		 model.setBfbase4(rs.getString(34));
		    		 model.setBfbaseremarks4(rs.getString(35));
		    		 model.setPgarage5(rs.getString(36));
		    		 model.setPgarageremarks5(rs.getString(37));
		    		 model.setPfbase5(rs.getString(38));
		    		 model.setPfbaseremarks5(rs.getString(39));
		    		 model.setBgarage5(rs.getString(40));
		    		 model.setBgarageremarks5(rs.getString(41));
		    		 model.setBfbase5(rs.getString(42));
		    		 model.setBfbaseremarks5(rs.getString(43));
		    		 model.setPgarage6(rs.getString(44));
		    		 model.setPgarageremarks6(rs.getString(45));
		    		 model.setPfbase6(rs.getString(46));
		    		 model.setPfbaseremarks6(rs.getString(47));
		    		 model.setBgarage6(rs.getString(48));
		    		 model.setBgarageremarks6(rs.getString(49));
		    		 model.setBfbase6(rs.getString(50));
		    		 model.setBfbaseremarks6(rs.getString(51));
		    		 model.setPgarage7(rs.getString(52));
		    		 model.setPgarageremarks7(rs.getString(53));
		    		 model.setPfbase7(rs.getString(54));
		    		 model.setPfbaseremarks7(rs.getString(55));
		    		 model.setBgarage7(rs.getString(56));
		    		 model.setBgarageremarks7(rs.getString(57));
		    		 model.setBfbase7(rs.getString(58));
		    		 model.setBfbaseremarks7(rs.getString(59));
		    		 model.setPgarage8(rs.getString(60));
		    		 model.setPgarageremarks8(rs.getString(61));
		    		 model.setPfbase8(rs.getString(62));
		    		 model.setPfbaseremarks8(rs.getString(63));
		    		 model.setBgarage8(rs.getString(64));
		    		 model.setBgarageremarks8(rs.getString(65));
		    		 model.setBfbase8(rs.getString(66));
		    		 model.setBfbaseremarks8(rs.getString(67));
		    		 model.setPgarage9(rs.getString(68));
		    		 model.setPgarageremarks9(rs.getString(69));
		    		 model.setPfbase9(rs.getString(70));
		    		 model.setPfbaseremarks9(rs.getString(71));
		    		 model.setBgarage9(rs.getString(72));
		    		 model.setBgarageremarks9(rs.getString(73));
		    		 model.setBfbase9(rs.getString(74));
		    		 model.setBfbaseremarks9(rs.getString(75));
		    		 model.setPgarage10(rs.getString(76));
		    		 model.setPgarageremarks10(rs.getString(77));
		    		 model.setPfbase10(rs.getString(78));
		    		 model.setPfbaseremarks10(rs.getString(79));
		    		 model.setBgarage10(rs.getString(80));
		    		 model.setBgarageremarks10(rs.getString(81));
		    		 model.setBfbase10(rs.getString(82));
		    		 model.setBfbaseremarks10(rs.getString(83));
		    		 model.setPgarage11(rs.getString(84));
		    		 model.setPgarageremarks11(rs.getString(85));
		    		 model.setPfbase11(rs.getString(86));
		    		 model.setPfbaseremarks11(rs.getString(87));
		    		 model.setBgarage11(rs.getString(88));
		    		 model.setBgarageremarks11(rs.getString(89));
		    		 model.setBfbase11(rs.getString(90));
		    		 model.setBfbaseremarks11(rs.getString(91));
		    		 model.setPgarage12(rs.getString(92));
		    		 model.setPgarageremarks12(rs.getString(93));
		    		 model.setPfbase12(rs.getString(94));
		    		 model.setPfbaseremarks12(rs.getString(95));
		    		 model.setBgarage12(rs.getString(96));
		    		 model.setBgarageremarks12(rs.getString(97));
		    		 model.setBfbase12(rs.getString(98));
		    		 model.setBfbaseremarks12(rs.getString(99));
		    		 model.setPgarage13(rs.getString(100));
		    		 model.setPgarageremarks13(rs.getString(101));
		    		 model.setPfbase13(rs.getString(102));
		    		 model.setPfbaseremarks13(rs.getString(103));
		    		 model.setBgarage13(rs.getString(104));
		    		 model.setBgarageremarks13(rs.getString(105));
		    		 model.setBfbase13(rs.getString(106));
		    		 model.setBfbaseremarks13(rs.getString(107));
		    		 model.setPgarage14(rs.getString(108));
		    		 model.setPgarageremarks14(rs.getString(109));
		    		 model.setPfbase14(rs.getString(110));
		    		 model.setPfbaseremarks14(rs.getString(111));
		    		 model.setBgarage14(rs.getString(112));
		    		 model.setBgarageremarks14(rs.getString(113));
		    		 model.setBfbase14(rs.getString(114));
		    		 model.setBfbaseremarks14(rs.getString(115));
		    		 model.setPgarage15(rs.getString(116));
		    		 model.setPgarageremarks15(rs.getString(117));
		    		 model.setPfbase15(rs.getString(118));
		    		 model.setPfbaseremarks15(rs.getString(119));
		    		 model.setBgarage15(rs.getString(120));
		    		 model.setBgarageremarks15(rs.getString(121));
		    		 model.setBfbase15(rs.getString(122));
		    		 model.setBfbaseremarks15(rs.getString(123));
		    		 model.setPgarage16(rs.getString(124));
		    		 model.setPgarageremarks16(rs.getString(125));
		    		 model.setPfbase16(rs.getString(126));
		    		 model.setPfbaseremarks16(rs.getString(127));
		    		 model.setBgarage16(rs.getString(128));
		    		 model.setBgarageremarks16(rs.getString(129));
		    		 model.setBfbase16(rs.getString(130));
		    		 model.setBfbaseremarks16(rs.getString(131));
		    		 model.setPgarage17(rs.getString(132));
		    		 model.setPgarageremarks17(rs.getString(133));
		    		 model.setPfbase17(rs.getString(134));
		    		 model.setPfbaseremarks17(rs.getString(135));
		    		 model.setBgarage17(rs.getString(136));
		    		 model.setBgarageremarks17(rs.getString(137));
		    		 model.setBfbase17(rs.getString(138));
		    		 model.setBfbaseremarks17(rs.getString(139));
		    		 model.setPgarage18(rs.getString(140));
		    		 model.setPgarageremarks18(rs.getString(141));
		    		 model.setPfbase18(rs.getString(142));
		    		 model.setPfbaseremarks18(rs.getString(143));
		    		 model.setBgarage18(rs.getString(144));
		    		 model.setBgarageremarks18(rs.getString(145));
		    		 model.setBfbase18(rs.getString(146));
		    		 model.setBfbaseremarks18(rs.getString(147));
		    		 model.setPgarage19(rs.getString(148));
		    		 model.setPgarageremarks19(rs.getString(149));
		    		 model.setPfbase19(rs.getString(150));
		    		 model.setPfbaseremarks19(rs.getString(151));
		    		 model.setBgarage19(rs.getString(152));
		    		 model.setBgarageremarks19(rs.getString(153));
		    		 model.setBfbase19(rs.getString(154));
		    		 model.setBfbaseremarks19(rs.getString(155));
		    		 model.setPgarage20(rs.getString(156));
		    		 model.setPgarageremarks20(rs.getString(157));
		    		 model.setPfbase20(rs.getString(158));
		    		 model.setPfbaseremarks20(rs.getString(159));
		    		 model.setBgarage20(rs.getString(160));
		    		 model.setBgarageremarks20(rs.getString(161));
		    		 model.setBfbase20(rs.getString(162));
		    		 model.setBfbaseremarks20(rs.getString(163));
		    		 model.setPgarage21(rs.getString(164));
		    		 model.setPgarageremarks21(rs.getString(165));
		    		 model.setPfbase21(rs.getString(166));
		    		 model.setPfbaseremarks21(rs.getString(167));
		    		 model.setBgarage21(rs.getString(168));
		    		 model.setBgarageremarks21(rs.getString(169));
		    		 model.setBfbase21(rs.getString(170));
		    		 model.setBfbaseremarks21(rs.getString(171));
		    		 model.setPgarage22(rs.getString(172));
		    		 model.setPgarageremarks22(rs.getString(173));
		    		 model.setPfbase22(rs.getString(174));
		    		 model.setPfbaseremarks22(rs.getString(175));
		    		 model.setBgarage22(rs.getString(176));
		    		 model.setBgarageremarks22(rs.getString(177));
		    		 model.setBfbase22(rs.getString(178));
		    		 model.setBfbaseremarks22(rs.getString(179));
		    		 model.setPgarage23(rs.getString(180));
		    		 model.setPgarageremarks23(rs.getString(181));
		    		 model.setPfbase23(rs.getString(182));
		    		 model.setPfbaseremarks23(rs.getString(183));
		    		 model.setBgarage23(rs.getString(184));
		    		 model.setBgarageremarks23(rs.getString(185));
		    		 model.setBfbase23(rs.getString(186));
		    		 model.setBfbaseremarks23(rs.getString(187));
		    		 model.setPgarage24(rs.getString(188));
		    		 model.setPgarageremarks24(rs.getString(189));
		    		 model.setPfbase24(rs.getString(190));
		    		 model.setPfbaseremarks24(rs.getString(191));
		    		 model.setBgarage24(rs.getString(192));
		    		 model.setBgarageremarks24(rs.getString(193));
		    		 model.setBfbase24(rs.getString(194));
		    		 model.setBfbaseremarks24(rs.getString(195));
		    		 model.setPgarage25(rs.getString(196));
		    		 model.setPgarageremarks25(rs.getString(197));
		    		 model.setPfbase25(rs.getString(198));
		    		 model.setPfbaseremarks25(rs.getString(199));
		    		 model.setBgarage25(rs.getString(200));
		    		 model.setBgarageremarks25(rs.getString(201));
		    		 model.setBfbase25(rs.getString(202));
		    		 model.setBfbaseremarks25(rs.getString(203));
		    		 model.setPgarage26(rs.getString(204));
		    		 model.setPgarageremarks26(rs.getString(205));
		    		 model.setPfbase26(rs.getString(206));
		    		 model.setPfbaseremarks26(rs.getString(207));
		    		 model.setBgarage26(rs.getString(208));
		    		 model.setBgarageremarks26(rs.getString(209));
		    		 model.setBfbase26(rs.getString(210));
		    		 model.setBfbaseremarks26(rs.getString(211));
		    		 model.setPgarage27(rs.getString(212));
		    		 model.setPgarageremarks27(rs.getString(213));
		    		 model.setPfbase27(rs.getString(214));
		    		 model.setPfbaseremarks27(rs.getString(215));
		    		 model.setBgarage27(rs.getString(216));
		    		 model.setBgarageremarks27(rs.getString(217));
		    		 model.setBfbase27(rs.getString(218));
		    		 model.setBfbaseremarks27(rs.getString(219));
		    		 model.setPgarage28(rs.getString(220));
		    		 model.setPgarageremarks28(rs.getString(221));
		    		 model.setPfbase28(rs.getString(222));
		    		 model.setPfbaseremarks28(rs.getString(223));
		    		 model.setBgarage28(rs.getString(224));
		    		 model.setBgarageremarks28(rs.getString(225));
		    		 model.setBfbase28(rs.getString(226));
		    		 model.setBfbaseremarks28(rs.getString(227));
		    		 model.setPgarage29(rs.getString(228));
		    		 model.setPgarageremarks29(rs.getString(229));
		    		 model.setPfbase29(rs.getString(230));
		    		 model.setPfbaseremarks29(rs.getString(231));
		    		 model.setBgarage29(rs.getString(232));
		    		 model.setBgarageremarks29(rs.getString(233));
		    		 model.setBfbase29(rs.getString(234));
		    		 model.setBfbaseremarks29(rs.getString(235));
		    		 model.setPgarage30(rs.getString(236));
		    		 model.setPgarageremarks30(rs.getString(237));
		    		 model.setPfbase30(rs.getString(238));
		    		 model.setPfbaseremarks30(rs.getString(239));
		    		 model.setBgarage30(rs.getString(240));
		    		 model.setBgarageremarks30(rs.getString(241));
		    		 model.setBfbase30(rs.getString(242));
		    		 model.setBfbaseremarks30(rs.getString(243));
		    		 model.setPgarage31(rs.getString(244));
		    		 model.setPgarageremarks31(rs.getString(245));
		    		 model.setPfbase31(rs.getString(246));
		    		 model.setPfbaseremarks31(rs.getString(247));
		    		 model.setBgarage31(rs.getString(248));
		    		 model.setBgarageremarks31(rs.getString(249));
		    		 model.setBfbase31(rs.getString(250));
		    		 model.setBfbaseremarks31(rs.getString(251));		    		 
		    		 rsList.add(model);
				 }				
			
					 //Preventive Total
					 StringBuilder sqlInner = new StringBuilder("select sum(coalesce(cast(a.pgarage1 as int),0)) + sum(coalesce(cast(a.pfbase1 as int),0)) + sum(coalesce(cast(a.bgarage1 as int),0)) + sum(coalesce(cast(a.bfbase1 as int),0)) as total1 ");
					 	 sqlInner.append(" ,sum(coalesce(cast(a.pgarage2 as int),0)) + sum(coalesce(cast(a.pfbase2 as int),0)) + sum(coalesce(cast(a.bgarage2 as int),0)) + sum(coalesce(cast(a.bfbase2 as int),0)) as total2 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.pgarage3 as int),0)) + sum(coalesce(cast(a.pfbase3 as int),0)) + sum(coalesce(cast(a.bgarage3 as int),0)) + sum(coalesce(cast(a.bfbase3 as int),0)) as total3 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.pgarage4 as int),0)) + sum(coalesce(cast(a.pfbase4 as int),0)) + sum(coalesce(cast(a.bgarage4 as int),0)) + sum(coalesce(cast(a.bfbase4 as int),0)) as total4 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.pgarage5 as int),0)) + sum(coalesce(cast(a.pfbase5 as int),0)) + sum(coalesce(cast(a.bgarage5 as int),0)) + sum(coalesce(cast(a.bfbase5 as int),0)) as total5 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.pgarage6 as int),0)) + sum(coalesce(cast(a.pfbase6 as int),0)) + sum(coalesce(cast(a.bgarage6 as int),0)) + sum(coalesce(cast(a.bfbase6 as int),0)) as total6 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.pgarage7 as int),0)) + sum(coalesce(cast(a.pfbase7 as int),0)) + sum(coalesce(cast(a.bgarage7 as int),0)) + sum(coalesce(cast(a.bfbase7 as int),0)) as total7 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.pgarage8 as int),0)) + sum(coalesce(cast(a.pfbase8 as int),0)) + sum(coalesce(cast(a.bgarage8 as int),0)) + sum(coalesce(cast(a.bfbase8 as int),0)) as total8 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.pgarage9 as int),0)) + sum(coalesce(cast(a.pfbase9 as int),0)) + sum(coalesce(cast(a.bgarage9 as int),0)) + sum(coalesce(cast(a.bfbase9 as int),0)) as total9 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.pgarage10 as int),0)) + sum(coalesce(cast(a.pfbase10 as int),0)) + sum(coalesce(cast(a.bgarage10 as int),0)) + sum(coalesce(cast(a.bfbase10 as int),0)) as total10 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.pgarage11 as int),0)) + sum(coalesce(cast(a.pfbase11 as int),0)) + sum(coalesce(cast(a.bgarage11 as int),0)) + sum(coalesce(cast(a.bfbase11 as int),0)) as total11 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.pgarage12 as int),0)) + sum(coalesce(cast(a.pfbase12 as int),0)) + sum(coalesce(cast(a.bgarage12 as int),0)) + sum(coalesce(cast(a.bfbase12 as int),0)) as total12 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.pgarage13 as int),0)) + sum(coalesce(cast(a.pfbase13 as int),0)) + sum(coalesce(cast(a.bgarage13 as int),0)) + sum(coalesce(cast(a.bfbase13 as int),0)) as total13 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.pgarage14 as int),0)) + sum(coalesce(cast(a.pfbase14 as int),0)) + sum(coalesce(cast(a.bgarage14 as int),0)) + sum(coalesce(cast(a.bfbase14 as int),0)) as total14 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.pgarage15 as int),0)) + sum(coalesce(cast(a.pfbase15 as int),0)) + sum(coalesce(cast(a.bgarage15 as int),0)) + sum(coalesce(cast(a.bfbase15 as int),0)) as total15 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.pgarage16 as int),0)) + sum(coalesce(cast(a.pfbase16 as int),0)) + sum(coalesce(cast(a.bgarage16 as int),0)) + sum(coalesce(cast(a.bfbase16 as int),0)) as total16 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.pgarage17 as int),0)) + sum(coalesce(cast(a.pfbase17 as int),0)) + sum(coalesce(cast(a.bgarage17 as int),0)) + sum(coalesce(cast(a.bfbase17 as int),0)) as total17 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.pgarage18 as int),0)) + sum(coalesce(cast(a.pfbase18 as int),0)) + sum(coalesce(cast(a.bgarage18 as int),0)) + sum(coalesce(cast(a.bfbase18 as int),0)) as total18 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.pgarage19 as int),0)) + sum(coalesce(cast(a.pfbase19 as int),0)) + sum(coalesce(cast(a.bgarage19 as int),0)) + sum(coalesce(cast(a.bfbase19 as int),0)) as total19 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.pgarage20 as int),0)) + sum(coalesce(cast(a.pfbase20 as int),0)) + sum(coalesce(cast(a.bgarage20 as int),0)) + sum(coalesce(cast(a.bfbase20 as int),0)) as total20 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.pgarage21 as int),0)) + sum(coalesce(cast(a.pfbase21 as int),0)) + sum(coalesce(cast(a.bgarage21 as int),0)) + sum(coalesce(cast(a.bfbase21 as int),0)) as total21 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.pgarage22 as int),0)) + sum(coalesce(cast(a.pfbase22 as int),0)) + sum(coalesce(cast(a.bgarage22 as int),0)) + sum(coalesce(cast(a.bfbase22 as int),0)) as total22 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.pgarage23 as int),0)) + sum(coalesce(cast(a.pfbase23 as int),0)) + sum(coalesce(cast(a.bgarage23 as int),0)) + sum(coalesce(cast(a.bfbase23 as int),0)) as total23 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.pgarage24 as int),0)) + sum(coalesce(cast(a.pfbase24 as int),0)) + sum(coalesce(cast(a.bgarage24 as int),0)) + sum(coalesce(cast(a.bfbase24 as int),0)) as total24 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.pgarage25 as int),0)) + sum(coalesce(cast(a.pfbase25 as int),0)) + sum(coalesce(cast(a.bgarage25 as int),0)) + sum(coalesce(cast(a.bfbase25 as int),0)) as total25 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.pgarage26 as int),0)) + sum(coalesce(cast(a.pfbase26 as int),0)) + sum(coalesce(cast(a.bgarage26 as int),0)) + sum(coalesce(cast(a.bfbase26 as int),0)) as total26 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.pgarage27 as int),0)) + sum(coalesce(cast(a.pfbase27 as int),0)) + sum(coalesce(cast(a.bgarage27 as int),0)) + sum(coalesce(cast(a.bfbase27 as int),0)) as total27 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.pgarage28 as int),0)) + sum(coalesce(cast(a.pfbase28 as int),0)) + sum(coalesce(cast(a.bgarage28 as int),0)) + sum(coalesce(cast(a.bfbase28 as int),0)) as total28 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.pgarage29 as int),0)) + sum(coalesce(cast(a.pfbase29 as int),0)) + sum(coalesce(cast(a.bgarage29 as int),0)) + sum(coalesce(cast(a.bfbase29 as int),0)) as total29 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.pgarage30 as int),0)) + sum(coalesce(cast(a.pfbase30 as int),0)) + sum(coalesce(cast(a.bgarage30 as int),0)) + sum(coalesce(cast(a.bfbase30 as int),0)) as total30 ");
						 sqlInner.append(" ,sum(coalesce(cast(a.pgarage31 as int),0)) + sum(coalesce(cast(a.pfbase31 as int),0)) + sum(coalesce(cast(a.bgarage31 as int),0)) + sum(coalesce(cast(a.bfbase31 as int),0)) as total31 ");
						 sqlInner.append(" from transport.tran_maintenance_preventive a ");
						 sqlInner.append(" where a.year = ? ");
						 sqlInner.append(" and a.month = ? ");
						
					 
					 pstmt2 = conn.prepareStatement(sqlInner.toString());
					 
					 pstmt2.setInt(1, year);
					 pstmt2.setInt(2, month);					 
					 
					 rs2 = pstmt2.executeQuery();
					 			 
					 while(rs2.next()) {
						 MaintenanceMonitoringPreventiveTotal model = new MaintenanceMonitoringPreventiveTotal();
						 model.setPreventiveTotal1(rs2.getInt(1));
						 model.setPreventiveTotal2(rs2.getInt(2));
						 model.setPreventiveTotal3(rs2.getInt(3));
						 model.setPreventiveTotal4(rs2.getInt(4));
						 model.setPreventiveTotal5(rs2.getInt(5));
						 model.setPreventiveTotal6(rs2.getInt(6));
						 model.setPreventiveTotal7(rs2.getInt(7));
						 model.setPreventiveTotal8(rs2.getInt(8));
						 model.setPreventiveTotal9(rs2.getInt(9));
						 model.setPreventiveTotal10(rs2.getInt(10));
						 model.setPreventiveTotal11(rs2.getInt(11));
						 model.setPreventiveTotal12(rs2.getInt(12));
						 model.setPreventiveTotal13(rs2.getInt(13));
						 model.setPreventiveTotal14(rs2.getInt(14));
						 model.setPreventiveTotal15(rs2.getInt(15));
						 model.setPreventiveTotal16(rs2.getInt(16));
						 model.setPreventiveTotal17(rs2.getInt(17));
						 model.setPreventiveTotal18(rs2.getInt(18));
						 model.setPreventiveTotal19(rs2.getInt(19));
						 model.setPreventiveTotal20(rs2.getInt(20));
						 model.setPreventiveTotal21(rs2.getInt(21));
						 model.setPreventiveTotal22(rs2.getInt(22));
						 model.setPreventiveTotal23(rs2.getInt(23));
						 model.setPreventiveTotal24(rs2.getInt(24));
						 model.setPreventiveTotal25(rs2.getInt(25));
						 model.setPreventiveTotal26(rs2.getInt(26));
						 model.setPreventiveTotal27(rs2.getInt(27));
						 model.setPreventiveTotal28(rs2.getInt(28));
						 model.setPreventiveTotal29(rs2.getInt(29));
						 model.setPreventiveTotal30(rs2.getInt(30));
						 model.setPreventiveTotal31(rs2.getInt(31));
						 rsTotal.add(model);
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
		    	 returnMap.put(MapConstant.CLASS_LIST_2, rsTotal);
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
		    MaintenanceMonitoringPreventive model = (MaintenanceMonitoringPreventive) criteriaMap.get(MapConstant.CLASS_DATA);

		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
		     Map<String, Object> returnMap = null;
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();				
				 sql = new StringBuffer("select * ");
				 	sql.append("from transport.tran_maintenance_preventive ");
				 	sql.append("where id = ? ");

				 TransportUtils.writeLogDebug(logger, "SQL: "+sql.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, model.getId());
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
		    		 model.setId(rs.getInt(1));
		    		 model.setYear(rs.getInt(2));
		    		 model.setMonth(rs.getInt(3));
		    		 model.setPgarage1(rs.getString(4));
		    		 model.setPgarageremarks1(rs.getString(5));
		    		 model.setPfbase1(rs.getString(6));
		    		 model.setPfbaseremarks1(rs.getString(7));
		    		 model.setBgarage1(rs.getString(8));
		    		 model.setBgarageremarks1(rs.getString(9));
		    		 model.setBfbase1(rs.getString(10));
		    		 model.setBfbaseremarks1(rs.getString(11));
		    		 model.setPgarage2(rs.getString(12));
		    		 model.setPgarageremarks2(rs.getString(13));
		    		 model.setPfbase2(rs.getString(14));
		    		 model.setPfbaseremarks2(rs.getString(15));
		    		 model.setBgarage2(rs.getString(16));
		    		 model.setBgarageremarks2(rs.getString(17));
		    		 model.setBfbase2(rs.getString(18));
		    		 model.setBfbaseremarks2(rs.getString(19));
		    		 model.setPgarage3(rs.getString(20));
		    		 model.setPgarageremarks3(rs.getString(21));
		    		 model.setPfbase3(rs.getString(22));
		    		 model.setPfbaseremarks3(rs.getString(23));
		    		 model.setBgarage3(rs.getString(24));
		    		 model.setBgarageremarks3(rs.getString(25));
		    		 model.setBfbase3(rs.getString(26));
		    		 model.setBfbaseremarks3(rs.getString(27));
		    		 model.setPgarage4(rs.getString(28));
		    		 model.setPgarageremarks4(rs.getString(29));
		    		 model.setPfbase4(rs.getString(30));
		    		 model.setPfbaseremarks4(rs.getString(31));
		    		 model.setBgarage4(rs.getString(32));
		    		 model.setBgarageremarks4(rs.getString(33));
		    		 model.setBfbase4(rs.getString(34));
		    		 model.setBfbaseremarks4(rs.getString(35));
		    		 model.setPgarage5(rs.getString(36));
		    		 model.setPgarageremarks5(rs.getString(37));
		    		 model.setPfbase5(rs.getString(38));
		    		 model.setPfbaseremarks5(rs.getString(39));
		    		 model.setBgarage5(rs.getString(40));
		    		 model.setBgarageremarks5(rs.getString(41));
		    		 model.setBfbase5(rs.getString(42));
		    		 model.setBfbaseremarks5(rs.getString(43));
		    		 model.setPgarage6(rs.getString(44));
		    		 model.setPgarageremarks6(rs.getString(45));
		    		 model.setPfbase6(rs.getString(46));
		    		 model.setPfbaseremarks6(rs.getString(47));
		    		 model.setBgarage6(rs.getString(48));
		    		 model.setBgarageremarks6(rs.getString(49));
		    		 model.setBfbase6(rs.getString(50));
		    		 model.setBfbaseremarks6(rs.getString(51));
		    		 model.setPgarage7(rs.getString(52));
		    		 model.setPgarageremarks7(rs.getString(53));
		    		 model.setPfbase7(rs.getString(54));
		    		 model.setPfbaseremarks7(rs.getString(55));
		    		 model.setBgarage7(rs.getString(56));
		    		 model.setBgarageremarks7(rs.getString(57));
		    		 model.setBfbase7(rs.getString(58));
		    		 model.setBfbaseremarks7(rs.getString(59));
		    		 model.setPgarage8(rs.getString(60));
		    		 model.setPgarageremarks8(rs.getString(61));
		    		 model.setPfbase8(rs.getString(62));
		    		 model.setPfbaseremarks8(rs.getString(63));
		    		 model.setBgarage8(rs.getString(64));
		    		 model.setBgarageremarks8(rs.getString(65));
		    		 model.setBfbase8(rs.getString(66));
		    		 model.setBfbaseremarks8(rs.getString(67));
		    		 model.setPgarage9(rs.getString(68));
		    		 model.setPgarageremarks9(rs.getString(69));
		    		 model.setPfbase9(rs.getString(70));
		    		 model.setPfbaseremarks9(rs.getString(71));
		    		 model.setBgarage9(rs.getString(72));
		    		 model.setBgarageremarks9(rs.getString(73));
		    		 model.setBfbase9(rs.getString(74));
		    		 model.setBfbaseremarks9(rs.getString(75));
		    		 model.setPgarage10(rs.getString(76));
		    		 model.setPgarageremarks10(rs.getString(77));
		    		 model.setPfbase10(rs.getString(78));
		    		 model.setPfbaseremarks10(rs.getString(79));
		    		 model.setBgarage10(rs.getString(80));
		    		 model.setBgarageremarks10(rs.getString(81));
		    		 model.setBfbase10(rs.getString(82));
		    		 model.setBfbaseremarks10(rs.getString(83));
		    		 model.setPgarage11(rs.getString(84));
		    		 model.setPgarageremarks11(rs.getString(85));
		    		 model.setPfbase11(rs.getString(86));
		    		 model.setPfbaseremarks11(rs.getString(87));
		    		 model.setBgarage11(rs.getString(88));
		    		 model.setBgarageremarks11(rs.getString(89));
		    		 model.setBfbase11(rs.getString(90));
		    		 model.setBfbaseremarks11(rs.getString(91));
		    		 model.setPgarage12(rs.getString(92));
		    		 model.setPgarageremarks12(rs.getString(93));
		    		 model.setPfbase12(rs.getString(94));
		    		 model.setPfbaseremarks12(rs.getString(95));
		    		 model.setBgarage12(rs.getString(96));
		    		 model.setBgarageremarks12(rs.getString(97));
		    		 model.setBfbase12(rs.getString(98));
		    		 model.setBfbaseremarks12(rs.getString(99));
		    		 model.setPgarage13(rs.getString(100));
		    		 model.setPgarageremarks13(rs.getString(101));
		    		 model.setPfbase13(rs.getString(102));
		    		 model.setPfbaseremarks13(rs.getString(103));
		    		 model.setBgarage13(rs.getString(104));
		    		 model.setBgarageremarks13(rs.getString(105));
		    		 model.setBfbase13(rs.getString(106));
		    		 model.setBfbaseremarks13(rs.getString(107));
		    		 model.setPgarage14(rs.getString(108));
		    		 model.setPgarageremarks14(rs.getString(109));
		    		 model.setPfbase14(rs.getString(110));
		    		 model.setPfbaseremarks14(rs.getString(111));
		    		 model.setBgarage14(rs.getString(112));
		    		 model.setBgarageremarks14(rs.getString(113));
		    		 model.setBfbase14(rs.getString(114));
		    		 model.setBfbaseremarks14(rs.getString(115));
		    		 model.setPgarage15(rs.getString(116));
		    		 model.setPgarageremarks15(rs.getString(117));
		    		 model.setPfbase15(rs.getString(118));
		    		 model.setPfbaseremarks15(rs.getString(119));
		    		 model.setBgarage15(rs.getString(120));
		    		 model.setBgarageremarks15(rs.getString(121));
		    		 model.setBfbase15(rs.getString(122));
		    		 model.setBfbaseremarks15(rs.getString(123));
		    		 model.setPgarage16(rs.getString(124));
		    		 model.setPgarageremarks16(rs.getString(125));
		    		 model.setPfbase16(rs.getString(126));
		    		 model.setPfbaseremarks16(rs.getString(127));
		    		 model.setBgarage16(rs.getString(128));
		    		 model.setBgarageremarks16(rs.getString(129));
		    		 model.setBfbase16(rs.getString(130));
		    		 model.setBfbaseremarks16(rs.getString(131));
		    		 model.setPgarage17(rs.getString(132));
		    		 model.setPgarageremarks17(rs.getString(133));
		    		 model.setPfbase17(rs.getString(134));
		    		 model.setPfbaseremarks17(rs.getString(135));
		    		 model.setBgarage17(rs.getString(136));
		    		 model.setBgarageremarks17(rs.getString(137));
		    		 model.setBfbase17(rs.getString(138));
		    		 model.setBfbaseremarks17(rs.getString(139));
		    		 model.setPgarage18(rs.getString(140));
		    		 model.setPgarageremarks18(rs.getString(141));
		    		 model.setPfbase18(rs.getString(142));
		    		 model.setPfbaseremarks18(rs.getString(143));
		    		 model.setBgarage18(rs.getString(144));
		    		 model.setBgarageremarks18(rs.getString(145));
		    		 model.setBfbase18(rs.getString(146));
		    		 model.setBfbaseremarks18(rs.getString(147));
		    		 model.setPgarage19(rs.getString(148));
		    		 model.setPgarageremarks19(rs.getString(149));
		    		 model.setPfbase19(rs.getString(150));
		    		 model.setPfbaseremarks19(rs.getString(151));
		    		 model.setBgarage19(rs.getString(152));
		    		 model.setBgarageremarks19(rs.getString(153));
		    		 model.setBfbase19(rs.getString(154));
		    		 model.setBfbaseremarks19(rs.getString(155));
		    		 model.setPgarage20(rs.getString(156));
		    		 model.setPgarageremarks20(rs.getString(157));
		    		 model.setPfbase20(rs.getString(158));
		    		 model.setPfbaseremarks20(rs.getString(159));
		    		 model.setBgarage20(rs.getString(160));
		    		 model.setBgarageremarks20(rs.getString(161));
		    		 model.setBfbase20(rs.getString(162));
		    		 model.setBfbaseremarks20(rs.getString(163));
		    		 model.setPgarage21(rs.getString(164));
		    		 model.setPgarageremarks21(rs.getString(165));
		    		 model.setPfbase21(rs.getString(166));
		    		 model.setPfbaseremarks21(rs.getString(167));
		    		 model.setBgarage21(rs.getString(168));
		    		 model.setBgarageremarks21(rs.getString(169));
		    		 model.setBfbase21(rs.getString(170));
		    		 model.setBfbaseremarks21(rs.getString(171));
		    		 model.setPgarage22(rs.getString(172));
		    		 model.setPgarageremarks22(rs.getString(173));
		    		 model.setPfbase22(rs.getString(174));
		    		 model.setPfbaseremarks22(rs.getString(175));
		    		 model.setBgarage22(rs.getString(176));
		    		 model.setBgarageremarks22(rs.getString(177));
		    		 model.setBfbase22(rs.getString(178));
		    		 model.setBfbaseremarks22(rs.getString(179));
		    		 model.setPgarage23(rs.getString(180));
		    		 model.setPgarageremarks23(rs.getString(181));
		    		 model.setPfbase23(rs.getString(182));
		    		 model.setPfbaseremarks23(rs.getString(183));
		    		 model.setBgarage23(rs.getString(184));
		    		 model.setBgarageremarks23(rs.getString(185));
		    		 model.setBfbase23(rs.getString(186));
		    		 model.setBfbaseremarks23(rs.getString(187));
		    		 model.setPgarage24(rs.getString(188));
		    		 model.setPgarageremarks24(rs.getString(189));
		    		 model.setPfbase24(rs.getString(190));
		    		 model.setPfbaseremarks24(rs.getString(191));
		    		 model.setBgarage24(rs.getString(192));
		    		 model.setBgarageremarks24(rs.getString(193));
		    		 model.setBfbase24(rs.getString(194));
		    		 model.setBfbaseremarks24(rs.getString(195));
		    		 model.setPgarage25(rs.getString(196));
		    		 model.setPgarageremarks25(rs.getString(197));
		    		 model.setPfbase25(rs.getString(198));
		    		 model.setPfbaseremarks25(rs.getString(199));
		    		 model.setBgarage25(rs.getString(200));
		    		 model.setBgarageremarks25(rs.getString(201));
		    		 model.setBfbase25(rs.getString(202));
		    		 model.setBfbaseremarks25(rs.getString(203));
		    		 model.setPgarage26(rs.getString(204));
		    		 model.setPgarageremarks26(rs.getString(205));
		    		 model.setPfbase26(rs.getString(206));
		    		 model.setPfbaseremarks26(rs.getString(207));
		    		 model.setBgarage26(rs.getString(208));
		    		 model.setBgarageremarks26(rs.getString(209));
		    		 model.setBfbase26(rs.getString(210));
		    		 model.setBfbaseremarks26(rs.getString(211));
		    		 model.setPgarage27(rs.getString(212));
		    		 model.setPgarageremarks27(rs.getString(213));
		    		 model.setPfbase27(rs.getString(214));
		    		 model.setPfbaseremarks27(rs.getString(215));
		    		 model.setBgarage27(rs.getString(216));
		    		 model.setBgarageremarks27(rs.getString(217));
		    		 model.setBfbase27(rs.getString(218));
		    		 model.setBfbaseremarks27(rs.getString(219));
		    		 model.setPgarage28(rs.getString(220));
		    		 model.setPgarageremarks28(rs.getString(221));
		    		 model.setPfbase28(rs.getString(222));
		    		 model.setPfbaseremarks28(rs.getString(223));
		    		 model.setBgarage28(rs.getString(224));
		    		 model.setBgarageremarks28(rs.getString(225));
		    		 model.setBfbase28(rs.getString(226));
		    		 model.setBfbaseremarks28(rs.getString(227));
		    		 model.setPgarage29(rs.getString(228));
		    		 model.setPgarageremarks29(rs.getString(229));
		    		 model.setPfbase29(rs.getString(230));
		    		 model.setPfbaseremarks29(rs.getString(231));
		    		 model.setBgarage29(rs.getString(232));
		    		 model.setBgarageremarks29(rs.getString(233));
		    		 model.setBfbase29(rs.getString(234));
		    		 model.setBfbaseremarks29(rs.getString(235));
		    		 model.setPgarage30(rs.getString(236));
		    		 model.setPgarageremarks30(rs.getString(237));
		    		 model.setPfbase30(rs.getString(238));
		    		 model.setPfbaseremarks30(rs.getString(239));
		    		 model.setBgarage30(rs.getString(240));
		    		 model.setBgarageremarks30(rs.getString(241));
		    		 model.setBfbase30(rs.getString(242));
		    		 model.setBfbaseremarks30(rs.getString(243));
		    		 model.setPgarage31(rs.getString(244));
		    		 model.setPgarageremarks31(rs.getString(245));
		    		 model.setPfbase31(rs.getString(246));
		    		 model.setPfbaseremarks31(rs.getString(247));
		    		 model.setBgarage31(rs.getString(248));
		    		 model.setBgarageremarks31(rs.getString(249));
		    		 model.setBfbase31(rs.getString(250));
		    		 model.setBfbaseremarks31(rs.getString(251));		    		  
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
