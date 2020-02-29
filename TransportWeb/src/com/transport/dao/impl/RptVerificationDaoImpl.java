package com.transport.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.transport.config.ServerContext;
import com.transport.constant.MapConstant;
import com.transport.constant.MiscConstant;
import com.transport.dao.RptVerificationDao;
import com.transport.model.VerificationAndValidation;
import com.transport.util.DateUtils;
import com.transport.util.TransportUtils;

public class RptVerificationDaoImpl implements RptVerificationDao {
	
	private final static Logger logger = Logger.getLogger(RptVerificationDaoImpl.class);

	@Override
	public Map<String, Object> search(HashMap<String, Object> criteriaMap)
			throws Exception {
		 
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SEARCH);
		 
		 	Map<String, Object> returnMap = null;

		 	 //Connection using JNDI DBCP
			 //get the criteria and value
			 int searchCriteria = Integer.parseInt((String)criteriaMap.get(MapConstant.SEARCH_CRITERIA));
			 String searchValue = (String) criteriaMap.get(MapConstant.SEARCH_VALUE);
			 String dateFromValue = (String) criteriaMap.get(MapConstant.DATE_FROM_VALUE);
			 String dateToValue = (String) criteriaMap.get(MapConstant.DATE_TO_VALUE);
			 
			 Connection conn = null;
			 ResultSet rs = null;
			 PreparedStatement pstmt = null;
			 
			 List<VerificationAndValidation> rsList = new ArrayList<VerificationAndValidation>();
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = null;
				 		
				 		sql = new StringBuffer("select d.id, a.description as item, b.lastname||', '||b.firstname as drivername,j.name as terminal,c.lorryno,d.verificationdate,e.description as correction, ");
					 	sql.append(" f.lastname||', '||f.firstname as checkedbyverification, g.description as followup, ");
					 	sql.append(" d.validationdate,h.lastname||', '||h.firstname as checkedbyvalidation, i.description as remarks, ");
						sql.append(" c.trailerno,k.description as findings,l.lastname||', '||l.firstname as drivernamevalidation,m.name as terminalnamevalidation, ");
						sql.append(" n.lorryno as lorrynovalidation,n.trailerno as trailernovalidation, o.description as rootcause, p.description as closure ");					 	
					 	sql.append(" from transport.file_verification d ");		 
					 	sql.append(" left join transport.file_items a on a.id = d.itemid ");
					 	sql.append(" left join transport.file_employee b on b.id = d.driverid ");
					 	sql.append(" left join transport.file_lorry c on c.id = d.lorryid ");
					 	sql.append(" left join transport.file_corrections e on e.id = d.correctionsid ");
					 	sql.append(" left join transport.file_employee f on f.id = d.verificationcheckedbyid ");
					 	sql.append(" left join transport.file_followup g on g.id = d.followupid ");
					 	sql.append(" left join transport.file_employee h on h.id = d.validationcheckedbyid ");
					 	sql.append(" left join transport.file_remarks i on i.id = d.remarksid ");
					 	sql.append(" left join transport.file_terminal j on j.id = d.terminalid ");
					 	sql.append(" left join transport.file_findings k on k.id = d.findingsid ");
					  	sql.append(" left join transport.file_employee l on l.id = d.driveridvalidation ");
					 	sql.append(" left join transport.file_terminal m on m.id = d.terminalidvalidation ");
					 	sql.append(" left join transport.file_lorry n on n.id = d.lorryidvalidation ");
					 	sql.append(" left join transport.file_rootcause o on o.id = d.rootcauseid ");
					 	sql.append(" left join transport.file_closure p on p.id = d.closureid ");
					 	sql.append(" where d.active = true ");
					 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_ITEM == searchCriteria) {
					 		sql.append(" and a.description ilike '%"+searchValue+"%'");
					 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_FINDINGS == searchCriteria) {
					 		sql.append(" and k.description ilike '%"+searchValue+"%'");
					 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_DRIVER == searchCriteria) {
					 		sql.append(" and (b.firstname ilike '%"+searchValue+"%' or b.lastname ilike '%"+searchValue+"%')");
					 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_TERMINAL == searchCriteria) {
					 		sql.append(" and j.name ilike '%"+searchValue+"%'");
					 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_LORRY == searchCriteria) {
					 		sql.append(" and (c.lorryno ilike '%"+searchValue+"%' or c.trailerno ilike '%"+searchValue+"%')");
					 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_VERIFICATION_DATE == searchCriteria) {
					 		sql.append(" and d.verificationdate between '"+DateUtils.sqlDateToStringSQL(DateUtils.strToSQLDate(dateFromValue))+"' and '"+DateUtils.sqlDateToStringSQL(DateUtils.strToSQLDate(dateToValue))+"'");
					 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_CORRECTIONS == searchCriteria) {
					 		sql.append(" and e.description ilike '%"+searchValue+"%'");
					 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_CHECKEDBY_VERIFICATION == searchCriteria) {
					 		sql.append(" and f.firstname ilike '%"+searchValue+"%' or f.lastname ilike '%"+searchValue+"%'");
					 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_FOLLOWUP == searchCriteria) {
					 		sql.append(" and g.description ilike '%"+searchValue+"%'");
					 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_DRIVER_VALIDATION == searchCriteria) {
					 		sql.append(" and (l.firstname ilike '%"+searchValue+"%' or l.lastname ilike '%"+searchValue+"%')");
					 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_TERMINAL_VALIDATION == searchCriteria) {
					 		sql.append(" and m.name ilike '%"+searchValue+"%'");
					 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_LORRY_VALIDATION == searchCriteria) {
					 		sql.append(" and (n.lorryno ilike '%"+searchValue+"%' or n.trailerno ilike '%"+searchValue+"%')");
					 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_VALIDATION_DATE == searchCriteria) {
					 		sql.append(" and d.validationdate between '"+DateUtils.sqlDateToStringSQL(DateUtils.strToSQLDate(dateFromValue))+"' and '"+DateUtils.sqlDateToStringSQL(DateUtils.strToSQLDate(dateToValue))+"'");
					 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_CHECKEDBY_VALIDATION == searchCriteria) {
					 		sql.append(" and (h.firstname ilike '%"+searchValue+"%' or h.lastname ilike '%"+searchValue+"%')");
					 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_REMARKS == searchCriteria) {
					 		sql.append(" and i.description ilike '%"+searchValue+"%'");
					 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_ROOT_CAUSE == searchCriteria) {
					 		sql.append(" and o.description ilike '%"+searchValue+"%'");
					 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_CLOSURE == searchCriteria) {
					 		sql.append(" and p.description ilike '%"+searchValue+"%'");
					 	}
					 	sql.append(" order by d.verificationdate desc, b.lastname, a.description ");

				
				StringBuffer sqlLog = new StringBuffer("select d.id,a.description as item, b.lastname||', '||b.firstname as drivername,j.name as terminal,c.lorryno,d.verificationdate,e.description as correction, ");
					sqlLog.append(" f.lastname||', '||f.firstname as checkedbyverification, g.description as followup, ");
					sqlLog.append(" d.validationdate, h.lastname||', '||h.firstname as checkedbyvalidation, i.description as remarks, ");
					sqlLog.append(" c.trailerno,k.description as findings,l.lastname||', '||l.firstname as drivernamevalidation,m.name as terminalnamevalidation, ");
					sqlLog.append(" n.lorryno as lorrynovalidation,n.trailerno as trailernovalidation, o.description as rootcause, p.description as closure ");
					sqlLog.append(" from transport.file_verification d ");
					sqlLog.append(" left join transport.file_items a on a.id = d.itemid ");
					sqlLog.append(" left join transport.file_employee b on b.id = d.driverid ");
					sqlLog.append(" left join transport.file_lorry c on c.id = d.lorryid ");
					sqlLog.append(" left join transport.file_corrections e on e.id = d.correctionsid "); 
					sqlLog.append(" left join transport.file_employee f on f.id = d.verificationcheckedbyid ");
					sqlLog.append(" left join transport.file_followup g on g.id = d.followupid ");
					sqlLog.append(" left join transport.file_employee h on h.id = d.validationcheckedbyid ");
					sqlLog.append(" left join transport.file_remarks i on i.id = d.remarksid ");
					sqlLog.append(" left join transport.file_terminal j on j.id = d.terminalid ");
					sqlLog.append(" left join transport.file_findings k on k.id = d.findingsid ");
					sqlLog.append(" left join transport.file_employee l on l.id = d.driveridvalidation ");
					sqlLog.append(" left join transport.file_terminal m on m.id = d.terminalidvalidation ");
					sqlLog.append(" left join transport.file_lorry n on n.id = d.lorryidvalidation ");
					sqlLog.append(" left join transport.file_rootcause o on o.id = d.rootcauseid ");
					sqlLog.append(" left join transport.file_closure p on p.id = d.closureid ");
					sqlLog.append(" where d.active = true ");
				 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_ITEM == searchCriteria) {
				 		sqlLog.append(" and a.description ilike '%"+searchValue+"%'");
				 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_FINDINGS == searchCriteria) {
				 		sqlLog.append(" and k.description ilike '%"+searchValue+"%'");
				 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_DRIVER == searchCriteria) {
				 		sqlLog.append(" and (b.firstname ilike '%"+searchValue+"%' or b.lastname ilike '%"+searchValue+"%')");
				 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_TERMINAL == searchCriteria) {
				 		sqlLog.append(" and j.name ilike '%"+searchValue+"%'");
				 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_LORRY == searchCriteria) {
				 		sqlLog.append(" and (c.lorryno ilike '%"+searchValue+"%' or c.trailerno ilike '%"+searchValue+"%')");
				 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_VERIFICATION_DATE == searchCriteria) {
				 		sqlLog.append(" and d.verificationdate between '"+DateUtils.sqlDateToStringSQL(DateUtils.strToSQLDate(dateFromValue))+"' and '"+DateUtils.sqlDateToStringSQL(DateUtils.strToSQLDate(dateToValue))+"'");
				 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_CORRECTIONS == searchCriteria) {
				 		sqlLog.append(" and e.description ilike '%"+searchValue+"%'");
				 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_CHECKEDBY_VERIFICATION == searchCriteria) {
				 		sqlLog.append(" and f.firstname ilike '%"+searchValue+"%' or f.lastname ilike '%"+searchValue+"%'");
				 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_FOLLOWUP == searchCriteria) {
				 		sqlLog.append(" and g.description ilike '%"+searchValue+"%'");
				 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_DRIVER_VALIDATION == searchCriteria) {
				 		sqlLog.append(" and (l.firstname ilike '%"+searchValue+"%' or l.lastname ilike '%"+searchValue+"%')");
				 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_TERMINAL_VALIDATION == searchCriteria) {
				 		sqlLog.append(" and m.name ilike '%"+searchValue+"%'");
				 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_LORRY_VALIDATION == searchCriteria) {
				 		sqlLog.append(" and (n.lorryno ilike '%"+searchValue+"%' or n.trailerno ilike '%"+searchValue+"%')");
				 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_VALIDATION_DATE == searchCriteria) {
				 		sqlLog.append(" and d.validationdate between '"+DateUtils.sqlDateToStringSQL(DateUtils.strToSQLDate(dateFromValue))+"' and '"+DateUtils.sqlDateToStringSQL(DateUtils.strToSQLDate(dateToValue))+"'");
				 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_CHECKEDBY_VALIDATION == searchCriteria) {
				 		sqlLog.append(" and h.firstname ilike '%"+searchValue+"%' or h.lastname ilike '%"+searchValue+"%'");
				 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_REMARKS == searchCriteria) {
				 		sqlLog.append(" and i.description ilike '%"+searchValue+"%'");
				 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_ROOT_CAUSE == searchCriteria) {
				 		sqlLog.append(" and o.description ilike '%"+searchValue+"%'");
				 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_CLOSURE == searchCriteria) {
				 		sqlLog.append(" and p.description ilike '%"+searchValue+"%'");
				 	}
					sqlLog.append(" order by d.verificationdate desc, b.lastname, a.description "); 
						
						 
				TransportUtils.writeLogDebug(logger, "SQL: "+sqlLog.toString());
					
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 rs = pstmt.executeQuery();
				 
				 while(rs.next()) {
					VerificationAndValidation model=new VerificationAndValidation();  
		    		 model.setId(rs.getInt(1));
		    		 model.setItem(rs.getString(2));
		    		 model.setDriver(rs.getString(3));
		    		 model.setTerminal(rs.getString(4));
		    		 model.setLorry(rs.getString(5));
		    		 if (rs.getDate(6)!=null) {
			    		 model.setVerificationDateStr(DateUtils.sqlDateToString(rs.getDate(6))); 
		    		 }
		    		 model.setCorrections(rs.getString(7));	 
		    		 model.setVerificationCheckedBy(rs.getString(8));		
			    	 model.setFollowUp(rs.getString(9));    
			    	 if (rs.getDate(10)!=null) {
			    		 model.setValidationDateStr(DateUtils.sqlDateToString(rs.getDate(10))); 
			    	 }
		    		 model.setValidationCheckedBy(rs.getString(11));
		    		 model.setRemarks(rs.getString(12));
		    		 model.setTrailer(rs.getString(13));
			    	 model.setFindings(rs.getString(14)); 
		    		 model.setDriverValidation(rs.getString(15));
		    		 model.setTerminalValidation(rs.getString(16));
		    		 model.setLorryValidation(rs.getString(17));
		    		 model.setTrailerValidation(rs.getString(18));
		    		 model.setRootCause(rs.getString(19));
		    		 model.setClosure(rs.getString(20));

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
	     
	    System.out.println("search() - Exit");
		return returnMap;
	}

}
