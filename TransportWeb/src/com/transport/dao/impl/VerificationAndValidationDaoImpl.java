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
import com.transport.dao.VerificationAndValidationDao;
import com.transport.model.User;
import com.transport.model.VerificationAndValidation;
import com.transport.util.DateUtils;
import com.transport.util.TransportUtils;

public class VerificationAndValidationDaoImpl implements
		VerificationAndValidationDao {
	
	private final static Logger logger = Logger.getLogger(VerificationAndValidationDaoImpl.class);

	@Override
	public Map<String, Object> save(HashMap<String, Object> dataMap) throws Exception{
		
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SAVE);
		
		//DBCP JNDI
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean status = false;
		
		VerificationAndValidation model = (VerificationAndValidation) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setCreatedBy((int) user.getId());	
		}
		model.setCreatedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("insert into transport.file_verification (");
		  		qry.append("itemid ");
		  		qry.append(",findingsid ");
		  		qry.append(",driverid ");
		  		qry.append(",terminalid ");
		  		qry.append(",lorryid ");
		  		qry.append(",verificationdate ");
		  		qry.append(",correctionsid ");
		  		qry.append(",verificationcheckedbyid ");
		  		qry.append(",followupid ");
		  		qry.append(",driveridvalidation ");
		  		qry.append(",terminalidvalidation ");
		  		qry.append(",lorryidvalidation ");
		  		qry.append(",validationdate ");
		  		qry.append(",validationcheckedbyid ");
		  		qry.append(",remarksid ");
		  		qry.append(",createdby ");
		  		qry.append(",createdon ");
		  		qry.append(",version ");
		  		qry.append(",active ");
		  		//qry.append(",rootcause ");
		  		qry.append(",rootcauseid ");
		  		qry.append(",closureid ");
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
		  		qry.append(" ,1 ");
		  		qry.append(" ,true ");
		  		qry.append(" ,? ");
		  		qry.append(" ,? ");
		  		qry.append(" ) ");

		StringBuffer qryLog =  new StringBuffer("insert into transport.file_verification (");
				qryLog.append("itemid ");
				qryLog.append(",findingsid ");
				qryLog.append(",driverid ");
				qryLog.append(",terminalid ");
				qryLog.append(",lorryid ");
				qryLog.append(",verificationdate ");
				qryLog.append(",correctionsid ");
				qryLog.append(",verificationcheckedbyid ");
				qryLog.append(",followupid ");
				qryLog.append(",driveridvalidation ");
				qryLog.append(",terminalidvalidation ");
				qryLog.append(",lorryidvalidation ");
				qryLog.append(",validationdate ");
				qryLog.append(",validationcheckedbyid ");
				qryLog.append(",remarksid ");
				qryLog.append(",createdby ");
				qryLog.append(",createdon ");
				qryLog.append(",version ");
				qryLog.append(",active ");
				//qryLog.append(",rootcause ");
				qryLog.append(",rootcauseid ");
				qryLog.append(",closureid ");
				qryLog.append(" ) ");
				qryLog.append(" values ");
				qryLog.append(" ( ");
				qryLog.append(model.getItemId());
				qryLog.append(model.getFindingsId());
				qryLog.append(model.getDriverId());
				qryLog.append(model.getTerminalId());
				qryLog.append(model.getLorryId());
				qryLog.append(model.getVerificationDate());	
				qryLog.append(model.getCorrectionsId());
				qryLog.append(model.getVerificationCheckedById());
				qryLog.append(model.getFollowUpId());
				qryLog.append(model.getDriverIdValidation());
				qryLog.append(model.getTerminalIdValidation());
				qryLog.append(model.getLorryIdValidation());
				qryLog.append(model.getValidationDate());
				qryLog.append(model.getValidationCheckedById());
				qryLog.append(model.getRemarksId());
				qryLog.append(" ,"+model.getCreatedBy());
				qryLog.append(" ,"+model.getCreatedOn());
				qryLog.append(" ,1 ");
				qryLog.append(" ,true ");
				//qryLog.append(model.getRootCause());
				qryLog.append(model.getRootCauseId());
				qryLog.append(model.getClosureId());
				qryLog.append(" ) ");
					
		TransportUtils.writeLogDebug(logger, "SQL: "+qryLog.toString());
  		  		
		  try {
			  conn = ServerContext.getJDBCHandle();
			  conn.setAutoCommit(false);
			  pstmt = conn.prepareStatement(qry.toString());
			     
			  pstmt.setInt(1, model.getItemId());
			  pstmt.setInt(2, model.getFindingsId());
			  pstmt.setInt(3, model.getDriverId());
			  pstmt.setInt(4, model.getTerminalId());
			  pstmt.setInt(5, model.getLorryId());
			  pstmt.setDate(6, model.getVerificationDate());
			  pstmt.setInt(7, model.getCorrectionsId());
			  pstmt.setInt(8, model.getVerificationCheckedById());
			  pstmt.setInt(9, model.getFollowUpId());
			  pstmt.setInt(10, model.getDriverIdValidation());
			  pstmt.setInt(11, model.getTerminalIdValidation());
			  pstmt.setInt(12, model.getLorryIdValidation());
			  pstmt.setDate(13, model.getValidationDate());
			  pstmt.setInt(14, model.getValidationCheckedById());
			  pstmt.setInt(15, model.getRemarksId());
			  pstmt.setInt(16, model.getCreatedBy());
			  pstmt.setTimestamp(17, model.getCreatedOn());
			  //pstmt.setString(18, model.getRootCause());
			  pstmt.setInt(18, model.getRootCauseId());
			  pstmt.setInt(19, model.getClosureId());
			     
			  int statusInt = pstmt.executeUpdate();
			     
			  if (statusInt == 1) {
				  conn.commit();
				  System.out.println("Inserted into Verification and Validation Compliance Tracker table successfully..");
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
		
		VerificationAndValidation model = (VerificationAndValidation) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update transport.file_verification set ");	
			qry.append(" itemid=? ");
			qry.append(" ,findingsid=? ");
			qry.append(" ,driverid=? ");
			qry.append(" ,terminalid=? ");
			qry.append(" ,lorryid=? ");
			qry.append(" ,verificationdate=? ");
			qry.append(" ,correctionsid=? ");
			qry.append(" ,verificationcheckedbyid=? ");
			qry.append(" ,followupid=? ");
			qry.append(" ,driveridvalidation=? ");
			qry.append(" ,terminalidvalidation=? ");
			qry.append(" ,lorryidvalidation=? ");
			qry.append(" ,validationdate=? ");
			qry.append(" ,validationcheckedbyid=? ");
			qry.append(" ,remarksid=? ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			//qry.append(" ,rootcause=? ");
			qry.append(" ,rootcauseid=? ");
			qry.append(" ,closureid=? ");
			qry.append(" where ");
			qry.append(" id = ? ");

		StringBuffer qryLog =  new StringBuffer("update transport.file_verification set ");	
			qryLog.append(" itemid="+model.getItemId());
			qryLog.append(" ,findingsid="+model.getFindingsId());
			qryLog.append(" ,driverid="+model.getDriverId());
			qryLog.append(" ,terminalid="+model.getTerminalId());
			qryLog.append(" ,lorryid="+model.getLorryId());
			qryLog.append(" ,verificationdate="+model.getVerificationDate());
			qryLog.append(" ,correctionsid="+model.getCorrectionsId());
			qryLog.append(" ,verificationcheckedbyid="+model.getVerificationCheckedById());
			qryLog.append(" ,followupid="+model.getFollowUpId());
			qryLog.append(" ,driveridvalidation="+model.getDriverIdValidation());
			qryLog.append(" ,terminalidvalidation="+model.getTerminalIdValidation());
			qryLog.append(" ,lorryidvalidation="+model.getLorryIdValidation());
			qryLog.append(" ,validationdate="+model.getValidationDate());
			qryLog.append(" ,validationcheckedbyid="+model.getValidationCheckedById());
			qryLog.append(" ,remarksid="+model.getRemarksId());
			qryLog.append(" ,modifiedby="+model.getModifiedBy());
			qryLog.append(" ,modifiedon="+model.getModifiedOn());
			qryLog.append(" ,version=(version+1) ");
			//qryLog.append(" ,rootcause="+model.getRootCause());
			qryLog.append(" ,rootcauseid="+model.getRootCauseId());
			qryLog.append(" ,closureid="+model.getClosureId());
			qryLog.append(" where ");
			qryLog.append(" id = "+model.getId());
			
		TransportUtils.writeLogDebug(logger, "SQL: "+qryLog.toString());
	
		 try {
			conn = ServerContext.getJDBCHandle();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(qry.toString());
				     
			pstmt.setInt(1, model.getItemId());
			pstmt.setInt(2, model.getFindingsId());
			pstmt.setInt(3, model.getDriverId());
			pstmt.setInt(4, model.getTerminalId());
			pstmt.setInt(5, model.getLorryId());
			pstmt.setDate(6, model.getVerificationDate());
			pstmt.setInt(7, model.getCorrectionsId());
			pstmt.setInt(8, model.getVerificationCheckedById());
			pstmt.setInt(9, model.getFollowUpId());
			pstmt.setInt(10, model.getDriverIdValidation());
			pstmt.setInt(11, model.getTerminalIdValidation());
			pstmt.setInt(12, model.getLorryIdValidation());
			pstmt.setDate(13, model.getValidationDate());
			pstmt.setInt(14, model.getValidationCheckedById());
			pstmt.setInt(15, model.getRemarksId());
			pstmt.setInt(16, model.getModifiedBy());
			pstmt.setTimestamp(17, model.getModifiedOn());
			//pstmt.setString(18, model.getRootCause());
			pstmt.setInt(18, model.getRootCauseId());
			pstmt.setInt(19, model.getClosureId());
			pstmt.setLong(20, model.getId());
				     
			int statusInt = pstmt.executeUpdate();
				     
			if (statusInt == 1) {
				conn.commit();
				System.out.println("Verification and Validation Compliance Tracker record (id: " +model.getId()+") updated successfully..");
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
		
		VerificationAndValidation model = (VerificationAndValidation) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update transport.file_verification set ");	
			qry.append(" active=false ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");

		StringBuffer qryLog =  new StringBuffer("update transport.file_verification set ");	
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
				System.out.println("Verification and Validation Compliance Tracker record (id: " +model.getId()+") deleted successfully..");
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
			 
			 //get the action category
			 String category = (String) criteriaMap.get(MapConstant.ACTION);
			 //get the criteria and value
			 int searchCriteria = Integer.parseInt((String)criteriaMap.get(MapConstant.SEARCH_CRITERIA));
			 String searchValue = (String) criteriaMap.get(MapConstant.SEARCH_VALUE);
			 String dateFromValue = (String) criteriaMap.get(MapConstant.DATE_FROM_VALUE);
			 String dateToValue = (String) criteriaMap.get(MapConstant.DATE_TO_VALUE);
			 
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
			 
			  List<VerificationAndValidation> rsList = new ArrayList<VerificationAndValidation>();
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = null;
				 if (category.equals(ActionConstant.SEARCHALL)) {
					 sql = new StringBuffer("select d.id,a.description as item, b.lastname||', '||b.firstname as drivername,j.name as terminal,c.lorryno,d.verificationdate,e.description as correction, ");
						 sql.append(" f.lastname||', '||f.firstname as checkedbyverification, g.description as followup, ");
						 sql.append(" d.validationdate, h.lastname||', '||h.firstname as checkedbyvalidation, i.description as remarks, ");
						 sql.append(" c.trailerno,k.description as findings,l.lastname||', '||l.firstname as drivernamevalidation,m.name as terminalnamevalidation, ");
						 sql.append(" n.lorryno as lorrynovalidation,n.trailerno as trailernovalidation, o.description as rootcause, p.description as closure, d.createdon ");
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
					 	 sql.append(" order by b.lastname, a.description ");
					 	 sql.append(" limit ? ");
					 	 sql.append(" offset ?");		 
				 } else {
					 sql = new StringBuffer("select d.id,a.description as item, b.lastname||', '||b.firstname as drivername,j.name as terminal,c.lorryno,d.verificationdate,e.description as correction, ");
						 sql.append(" f.lastname||', '||f.firstname as checkedbyverification, g.description as followup, ");
						 sql.append(" d.validationdate, h.lastname||', '||h.firstname as checkedbyvalidation, i.description as remarks, ");
						 sql.append(" c.trailerno,k.description as findings,l.lastname||', '||l.firstname as drivernamevalidation,m.name as terminalnamevalidation, ");
						 sql.append(" n.lorryno as lorrynovalidation,n.trailerno as trailernovalidation, o.description as rootcause, p.description as closure, d.createdon ");
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
						 sql.append(" order by b.lastname, a.description ");
						 sql.append(" limit ? ");
						 sql.append(" offset ?");	
				}


				StringBuffer sqlLog = null;
						 
				if (category.equals(ActionConstant.SEARCHALL)) {
					sqlLog = new StringBuffer("select d.id,a.description as item, b.lastname||', '||b.firstname as drivername,j.name as terminal,c.lorryno,d.verificationdate,e.description as correction, ");
						sqlLog.append(" f.lastname||', '||f.firstname as checkedbyverification, g.description as followup, ");
						sqlLog.append(" d.validationdate, h.lastname||', '||h.firstname as checkedbyvalidation, i.description as remarks, ");
						sqlLog.append(" c.trailerno,k.description as findings,l.lastname||', '||l.firstname as drivernamevalidation,m.name as terminalnamevalidation, ");
						sqlLog.append(" n.lorryno as lorrynovalidation,n.trailerno as trailernovalidation, o.description as rootcause, p.description as closure, d.createdon ");
						sqlLog.append(" from transport.file_verification d ");
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
						sqlLog.append(" order by b.lastname, a.description ");
						sqlLog.append(" limit ? ");
						sqlLog.append(" offset ?");			 	 
				} else {
					sqlLog = new StringBuffer("select d.id,a.description as item, b.lastname||', '||b.firstname as drivername,j.name as terminal,c.lorryno,d.verificationdate,e.description as correction, ");
						sqlLog.append(" f.lastname||', '||f.firstname as checkedbyverification, g.description as followup, ");
						sqlLog.append(" d.validationdate, h.lastname||', '||h.firstname as checkedbyvalidation, i.description as remarks, ");
						sqlLog.append(" c.trailerno,k.description as findings,l.lastname||', '||l.firstname as drivernamevalidation,m.name as terminalnamevalidation, ");
						sqlLog.append(" n.lorryno as lorrynovalidation,n.trailerno as trailernovalidation, o.description as rootcause, p.description as closure, d.createdon ");
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
						sqlLog.append(" order by b.lastname, a.description ");
						sqlLog.append(" limit ? ");
						sqlLog.append(" offset ?");	
				}
						 
				TransportUtils.writeLogDebug(logger, "SQL: "+sqlLog.toString());
					
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, limit);
				 pstmt.setInt(2, offset);
				 
				 rs = pstmt.executeQuery();
				 
				 while(rs.next()) {
					 VerificationAndValidation model=new VerificationAndValidation();  
		    		 model.setId(rs.getInt(1));
		    		 model.setItem(rs.getString(2));
		    		 model.setDriver(rs.getString(3));
		    		 model.setTerminal(rs.getString(4));
		    		 model.setLorry(rs.getString(5));
		    		 model.setVerificationDateStr(rs.getString(6));
		    		 if (rs.getString(7)!=null) {
		    			 model.setCorrections(rs.getString(7).length()>30 ? rs.getString(7).substring(0, 30).concat("..."): rs.getString(7));//limit to 30 characters only	 
		    		 }
		    		 model.setVerificationCheckedBy(rs.getString(8));		
		    		 if (rs.getString(9)!=null) {
			    		 model.setFollowUp(rs.getString(9).length()>30 ? rs.getString(9).substring(0, 30).concat("..."): rs.getString(9));//limit to 30 characters only		    			 
		    		 }
		    		 model.setValidationDateStr(rs.getString(10));
		    		 model.setValidationCheckedBy(rs.getString(11));
		    		 model.setRemarks(rs.getString(12));
		    		 model.setTrailer(rs.getString(13));
		    		 if (rs.getString(14)!=null) {
			    		 model.setFindings(rs.getString(14).length()>30 ? rs.getString(14).substring(0, 30).concat("..."): rs.getString(14));//limit to 30 characters only	 
		    		 }
		    		 model.setDriverValidation(rs.getString(15));
		    		 model.setTerminalValidation(rs.getString(16));
		    		 model.setLorryValidation(rs.getString(17));
		    		 model.setTrailerValidation(rs.getString(18));
		    		 if (rs.getString(19)!=null) { 
			    		 model.setRootCause(rs.getString(19).length()>30 ? rs.getString(19).substring(0, 30).concat("..."): rs.getString(19));//limit to 30 characters only	
		    		 }
		    		 if (rs.getString(20)!=null) { 
			    		 model.setClosure(rs.getString(20).length()>30 ? rs.getString(20).substring(0, 30).concat("..."): rs.getString(20));//limit to 30 characters only	
		    		 }
		    		 //START Added for 2016 Revision 2 - April 3, 2016
		    		 model.setCreatedOn(rs.getTimestamp(21));
		    		 model.setCreatedOnStr(DateUtils.sqlTimestampToStringDate(model.getCreatedOn()));
		    		 //END Added for 2016 Revision 2 - April 3, 2016
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
			    	 sqlCount = new StringBuffer("select count(*) from transport.file_verification d where d.active = true ");
				     
			     }else {
			    	 sqlCount = new StringBuffer("select count(*) from transport.file_verification d ");
				    	 sqlCount.append(" left join transport.file_items a on a.id = d.itemid ");
				    	 sqlCount.append(" left join transport.file_employee b on b.id = d.driverid ");
				    	 sqlCount.append(" left join transport.file_lorry c on c.id = d.lorryid ");
				    	 sqlCount.append(" left join transport.file_corrections e on e.id = d.correctionsid "); 
				    	 sqlCount.append(" left join transport.file_employee f on f.id = d.verificationcheckedbyid ");
				    	 sqlCount.append(" left join transport.file_followup g on g.id = d.followupid ");
				    	 sqlCount.append(" left join transport.file_employee h on h.id = d.validationcheckedbyid ");
				    	 sqlCount.append(" left join transport.file_remarks i on i.id = d.remarksid ");
				    	 sqlCount.append(" left join transport.file_terminal j on j.id = d.terminalid ");
				    	 sqlCount.append(" left join transport.file_findings k on k.id = d.findingsid ");
				    	 sqlCount.append(" left join transport.file_employee l on l.id = d.driveridvalidation ");
				    	 sqlCount.append(" left join transport.file_terminal m on m.id = d.terminalidvalidation ");
				    	 sqlCount.append(" left join transport.file_lorry n on n.id = d.lorryidvalidation ");
				    	 sqlCount.append(" left join transport.file_rootcause o on o.id = d.rootcauseid ");
				    	 sqlCount.append(" left join transport.file_closure p on p.id = d.closureid ");
				    	 sqlCount.append(" where d.active = true ");
						 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_ITEM == searchCriteria) {
						 		sqlCount.append(" and a.description ilike '%"+searchValue+"%'");
						 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_FINDINGS == searchCriteria) {
						 		sqlCount.append(" and k.description ilike '%"+searchValue+"%'");
						 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_DRIVER == searchCriteria) {
						 		sqlCount.append(" and (b.firstname ilike '%"+searchValue+"%' or b.lastname ilike '%"+searchValue+"%')");
						 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_TERMINAL == searchCriteria) {
						 		sqlCount.append(" and j.name ilike '%"+searchValue+"%'");
						 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_LORRY == searchCriteria) {
						 		sqlCount.append(" and (c.lorryno ilike '%"+searchValue+"%'  or c.trailerno ilike '%"+searchValue+"%')");
						 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_VERIFICATION_DATE == searchCriteria) {
						 		sqlCount.append(" and d.verificationdate between '"+DateUtils.sqlDateToStringSQL(DateUtils.strToSQLDate(dateFromValue))+"' and '"+DateUtils.sqlDateToStringSQL(DateUtils.strToSQLDate(dateToValue))+"'");
						 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_CORRECTIONS == searchCriteria) {
						 		sqlCount.append(" and e.description ilike '%"+searchValue+"%'");
						 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_CHECKEDBY_VERIFICATION == searchCriteria) {
						 		sqlCount.append(" and f.firstname ilike '%"+searchValue+"%' or f.lastname ilike '%"+searchValue+"%'");
						 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_FOLLOWUP == searchCriteria) {
						 		sqlCount.append(" and g.description ilike '%"+searchValue+"%'");
						 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_DRIVER_VALIDATION == searchCriteria) {
						 		sqlCount.append(" and (l.firstname ilike '%"+searchValue+"%' or l.lastname ilike '%"+searchValue+"%')");
						 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_TERMINAL_VALIDATION == searchCriteria) {
						 		sqlCount.append(" and m.name ilike '%"+searchValue+"%'");
						 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_LORRY_VALIDATION == searchCriteria) {
						 		sqlCount.append(" and (n.lorryno ilike '%"+searchValue+"%' or n.trailerno ilike '%"+searchValue+"%')");
						 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_VALIDATION_DATE == searchCriteria) {
						 		sqlCount.append(" and d.validationdate between '"+DateUtils.sqlDateToStringSQL(DateUtils.strToSQLDate(dateFromValue))+"' and '"+DateUtils.sqlDateToStringSQL(DateUtils.strToSQLDate(dateToValue))+"'");
						 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_CHECKEDBY_VALIDATION == searchCriteria) {
						 		sqlCount.append(" and h.firstname ilike '%"+searchValue+"%' or h.lastname ilike '%"+searchValue+"%'");
						 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_REMARKS == searchCriteria) {
						 		sqlCount.append(" and i.description ilike '%"+searchValue+"%'");
						 	} else if (MiscConstant.LOV_VERIFICATION_CRITERIA_ROOT_CAUSE == searchCriteria) {
						 		sqlCount.append(" and o.description ilike '%"+searchValue+"%'");
						 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_CLOSURE == searchCriteria) {
						 		sqlCount.append(" and p.description ilike '%"+searchValue+"%'");
						 	}
				   } 

				StringBuffer sqlCountLog = null;
				if (category.equals(ActionConstant.SEARCHALL)) {
					sqlCountLog = new StringBuffer("select count(*) from transport.file_verification d ");
						sqlCountLog.append(" where d.active = true ");	
				}else {
					sqlCountLog = new StringBuffer("select count(*) from transport.file_verification d ");
						sqlCountLog.append(" left join transport.file_items a on a.id = d.itemid ");
						sqlCountLog.append(" left join transport.file_employee b on b.id = d.driverid ");
						sqlCountLog.append(" left join transport.file_lorry c on c.id = d.lorryid ");
						sqlCountLog.append(" left join transport.file_corrections e on e.id = d.correctionsid "); 
						sqlCountLog.append(" left join transport.file_employee f on f.id = d.verificationcheckedbyid ");
						sqlCountLog.append(" left join transport.file_followup g on g.id = d.followupid ");
						sqlCountLog.append(" left join transport.file_employee h on h.id = d.validationcheckedbyid ");
						sqlCountLog.append(" left join transport.file_remarks i on i.id = d.remarksid ");
						sqlCountLog.append(" left join transport.file_terminal j on j.id = d.terminalid ");
						sqlCountLog.append(" left join transport.file_findings k on k.id = d.findingsid ");
						sqlCountLog.append(" left join transport.file_employee l on l.id = d.driveridvalidation ");
						sqlCountLog.append(" left join transport.file_terminal m on m.id = d.terminalidvalidation ");
						sqlCountLog.append(" left join transport.file_lorry n on n.id = d.lorryidvalidation ");
						sqlCountLog.append(" left join transport.file_rootcause o on o.id = d.rootcauseid ");
						sqlCountLog.append(" left join transport.file_closure p on p.id = d.closureid ");
						sqlCountLog.append(" where d.active = true ");
					 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_ITEM == searchCriteria) {
					 		sqlCountLog.append(" and a.description ilike '%"+searchValue+"%'");
					 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_FINDINGS == searchCriteria) {
					 		sqlCountLog.append(" and k.description ilike '%"+searchValue+"%'");
					 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_DRIVER == searchCriteria) {
					 		sqlCountLog.append(" and (b.firstname ilike '%"+searchValue+"%' or b.lastname ilike '%"+searchValue+"%')");
					 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_TERMINAL == searchCriteria) {
					 		sqlCountLog.append(" and j.name ilike '%"+searchValue+"%'");
					 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_LORRY == searchCriteria) {
					 		sqlCountLog.append(" and (c.lorryno ilike '%"+searchValue+"%' or c.trailerno ilike '%"+searchValue+"%')");
					 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_VERIFICATION_DATE == searchCriteria) {
					 		sqlCountLog.append(" and d.verificationdate between '"+DateUtils.sqlDateToStringSQL(DateUtils.strToSQLDate(dateFromValue))+"' and '"+DateUtils.sqlDateToStringSQL(DateUtils.strToSQLDate(dateToValue))+"'");
					 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_CORRECTIONS == searchCriteria) {
					 		sqlCountLog.append(" and e.description ilike '%"+searchValue+"%'");
					 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_CHECKEDBY_VERIFICATION == searchCriteria) {
					 		sqlCountLog.append(" and f.firstname ilike '%"+searchValue+"%' or f.lastname ilike '%"+searchValue+"%'");
					 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_FOLLOWUP == searchCriteria) {
					 		sqlCountLog.append(" and g.description ilike '%"+searchValue+"%'");
					 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_DRIVER_VALIDATION == searchCriteria) {
					 		sqlCountLog.append(" and (l.firstname ilike '%"+searchValue+"%' or l.lastname ilike '%"+searchValue+"%')");
					 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_TERMINAL_VALIDATION == searchCriteria) {
					 		sqlCountLog.append(" and m.name ilike '%"+searchValue+"%'");
					 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_LORRY_VALIDATION == searchCriteria) {
					 		sqlCountLog.append(" and (n.lorryno ilike '%"+searchValue+"%' or n.trailerno ilike '%"+searchValue+"%')");
					 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_VALIDATION_DATE == searchCriteria) {
					 		sqlCountLog.append(" and d.validationdate between '"+DateUtils.sqlDateToStringSQL(DateUtils.strToSQLDate(dateFromValue))+"' and '"+DateUtils.sqlDateToStringSQL(DateUtils.strToSQLDate(dateToValue))+"'");
					 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_CHECKEDBY_VALIDATION == searchCriteria) {
					 		sqlCountLog.append(" and h.firstname ilike '%"+searchValue+"%' or h.lastname ilike '%"+searchValue+"%'");
					 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_REMARKS == searchCriteria) {
					 		sqlCountLog.append(" and i.description ilike '%"+searchValue+"%'");
					 	} else if (MiscConstant.LOV_VERIFICATION_CRITERIA_ROOT_CAUSE == searchCriteria) {
					 		sqlCountLog.append(" and o.description ilike '%"+searchValue+"%'");
					 	} else 	if (MiscConstant.LOV_VERIFICATION_CRITERIA_CLOSURE == searchCriteria) {
					 		sqlCountLog.append(" and p.description ilike '%"+searchValue+"%'");
					 	}			
				} 
					
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
	     
	    System.out.println("search() - Exit");
		return returnMap;
	}

	@Override
	public Map<String, Object> getDataById(HashMap<String, Object> criteriaMap)
			throws Exception {
		// TODO Auto-generated method stub
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_GETDATA_BY_ID);
		 
		    //get the model criteria
		VerificationAndValidation model = (VerificationAndValidation) criteriaMap.get(MapConstant.CLASS_DATA);

		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
		     Map<String, Object> returnMap = null;
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer("select a.id, a.itemid,a.terminalid,a.driverid,a.lorryid,a.verificationdate,a.correctionsid,a.verificationcheckedbyid,a.followupid,a.validationdate,a.validationcheckedbyid,a.remarksid ");
						 sql.append(" ,a.findingsid,a.driveridvalidation,a.terminalidvalidation,a.lorryidvalidation, a.rootcauseid, a.closureid ");
					 	 sql.append(" from transport.file_verification a ");
					 	 sql.append(" where a.id = ? ");

				 StringBuffer sqlLog = new StringBuffer("select a.id, a.itemid,a.terminalid,a.driverid,a.lorryid,a.verificationdate,a.correctionsid,a.verificationcheckedbyid,a.followupid,a.validationdate,a.validationcheckedbyid,a.remarksid ");
				 	 sqlLog.append(" ,a.findingsid,a.driveridvalidation,a.terminalidvalidation,a.lorryidvalidation, a.rootcauseid, a.closureid "); 
				 	 sqlLog.append(" from transport.file_verification a ");
					 sqlLog.append(" where a.id = "+ model.getId());
			
				 TransportUtils.writeLogDebug(logger, "SQL: "+sqlLog.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, model.getId());
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
		    		 model.setId(rs.getInt(1));
		    		 model.setItemId(rs.getInt(2));
		    		 model.setTerminalId(rs.getInt(3));
		    		 model.setDriverId(rs.getInt(4));
		    		 model.setLorryId(rs.getInt(5));
		    		 model.setVerificationDate(rs.getDate(6));
		    		 model.setCorrectionsId(rs.getInt(7));
		    		 model.setVerificationCheckedById(rs.getInt(8));		    		 
		    		 model.setFollowUpId(rs.getInt(9));
		    		 model.setValidationDate(rs.getDate(10));
		    		 model.setValidationCheckedById(rs.getInt(11));
		    		 model.setRemarksId(rs.getInt(12));
		    		 model.setFindingsId(rs.getInt(13));
		    		 model.setDriverIdValidation(rs.getInt(14));
		    		 model.setTerminalIdValidation(rs.getInt(15));
		    		 model.setLorryIdValidation(rs.getInt(16));
		    		 //model.setRootCause(rs.getString(17));
		    		 model.setRootCauseId(rs.getInt(17));
		    		 model.setClosureId(rs.getInt(18));
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
			 List<VerificationAndValidation> rsList = new ArrayList<VerificationAndValidation>();
			  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer("select d.id,a.description as item,j.name as terminal, b.lastname||', '||b.firstname as drivername,c.lorryno,d.verificationdate,e.description as correction, ");
						 sql.append(" f.lastname||', '||f.firstname as checkedbyverification, g.description as followup, ");
						 sql.append(" d.validationdate, h.lastname||', '||h.firstname as checkedbyvalidation, i.description as remarks, ");
						 sql.append(" c.trailerno,k.description as findings,l.lastname||', '||l.firstname as drivernamevalidation,m.name as terminalnamevalidation, ");
						 sql.append(" n.lorryno as lorrynovalidation,n.trailerno as trailernovalidation, o.description as rootcause, p.description as closure, d.createdon ");
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
					 	 sql.append(" order by b.lastname, a.description ");	

				 StringBuffer sqlLog = new StringBuffer("select d.id,a.description as item,j.name as terminal, b.lastname||', '||b.firstname as drivername,c.lorryno,d.verificationdate,e.description as correction, ");
						 sqlLog.append(" f.lastname||', '||f.firstname as checkedbyverification, g.description as followup, ");
						 sqlLog.append(" d.validationdate, h.lastname||', '||h.firstname as checkedbyvalidation, i.description as remarks, ");
						 sqlLog.append(" c.trailerno,k.description as findings,l.lastname||', '||l.firstname as drivernamevalidation,m.name as terminalnamevalidation, ");
						 sqlLog.append(" n.lorryno as lorrynovalidation,n.trailerno as trailernovalidation, o.description as rootcause, p.description as closure, d.createdon ");
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
						 sqlLog.append(" order by b.lastname, a.description ");	
			
				 TransportUtils.writeLogDebug(logger, "SQL: "+sqlLog.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 rs = pstmt.executeQuery();


				  
				 while(rs.next()) {
					 //get the model criteria
					 VerificationAndValidation model=new VerificationAndValidation();  
		    		 model.setId(rs.getInt(1));
		    		 model.setItem(rs.getString(2));
		    		 model.setDriver(rs.getString(3));
		    		 model.setTerminal(rs.getString(4));
		    		 model.setLorry(rs.getString(5));
		    		 model.setVerificationDateStr(rs.getString(6));
		    		 if (rs.getString(7)!=null) {
		    			 model.setCorrections(rs.getString(7).length()>30 ? rs.getString(7).substring(0, 30).concat("..."): rs.getString(7));//limit to 30 characters only	 
		    		 }
		    		 model.setVerificationCheckedBy(rs.getString(8));		
		    		 if (rs.getString(9)!=null) {
			    		 model.setFollowUp(rs.getString(9).length()>30 ? rs.getString(9).substring(0, 30).concat("..."): rs.getString(9));//limit to 30 characters only		    			 
		    		 }
		    		 model.setValidationDateStr(rs.getString(10));
		    		 model.setValidationCheckedBy(rs.getString(11));
		    		 model.setRemarks(rs.getString(12));
		    		 model.setTrailer(rs.getString(13));
		    		 if (rs.getString(14)!=null) {
			    		 model.setFindings(rs.getString(14).length()>30 ? rs.getString(14).substring(0, 30).concat("..."): rs.getString(14));//limit to 30 characters only	 
		    		 }
		    		 model.setDriverValidation(rs.getString(15));
		    		 model.setTerminalValidation(rs.getString(16));
		    		 model.setLorryValidation(rs.getString(17));
		    		 model.setTrailerValidation(rs.getString(18));
		    		 if (rs.getString(19)!=null) { 
			    		 model.setRootCause(rs.getString(19).length()>30 ? rs.getString(19).substring(0, 30).concat("..."): rs.getString(19));//limit to 30 characters only	
		    		 }
		    		 if (rs.getString(20)!=null) { 
			    		 model.setClosure(rs.getString(20).length()>30 ? rs.getString(20).substring(0, 30).concat("..."): rs.getString(20));//limit to 30 characters only	
		    		 }
		    		 //START Added for 2016 Revision 2 - April 3, 2016
		    		 model.setCreatedOn(rs.getTimestamp(21));
		    		 model.setCreatedOnStr(DateUtils.sqlTimestampToStringDate(model.getCreatedOn()));
		    		 //END Added for 2016 Revision 2 - April 3, 2016
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
			 List<VerificationAndValidation> rsList = new ArrayList<VerificationAndValidation>();
			  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer("select d.id,a.description as item, b.lastname||', '||b.firstname as drivername,j.name as terminal,c.lorryno,d.verificationdate,e.description as correction, ");
						 sql.append(" f.lastname||', '||f.firstname as checkedbyverification, g.description as followup, ");
						 sql.append(" d.validationdate, h.lastname||', '||h.firstname as checkedbyvalidation, i.description as remarks, ");
						 sql.append(" c.trailerno,k.description as findings,l.lastname||', '||l.firstname as drivernamevalidation,m.name as terminalnamevalidation, ");
						 sql.append(" n.lorryno as lorrynovalidation,n.trailerno as trailernovalidation, o.description as rootcause, p.description as closure, d.createdon ");
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
					 	 sql.append(" where d.active = false ");
					 	 sql.append(" order by b.lastname, a.description ");
						 sql.append(" limit ? ");
						 sql.append(" offset ? ");

				 StringBuffer sqlLog = new StringBuffer("select d.id,a.description as item,j.name as terminal, b.lastname||', '||b.firstname as drivername,c.lorryno,d.verificationdate,e.description as correction, ");
						 sqlLog.append(" f.lastname||', '||f.firstname as checkedbyverification, g.description as followup, ");
						 sqlLog.append(" d.validationdate, h.lastname||', '||h.firstname as checkedbyvalidation, i.description as remarks, ");
						 sqlLog.append(" c.trailerno,k.description as findings,l.lastname||', '||l.firstname as drivernamevalidation,m.name as terminalnamevalidation, ");
						 sqlLog.append(" n.lorryno as lorrynovalidation,n.trailerno as trailernovalidation, o.description as rootcause, p.description as closure, d.createdon  ");
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
						 sqlLog.append(" where d.active = false ");
						 sqlLog.append(" order by b.lastname, a.description ");
						 sqlLog.append(" limit " + limit);
						 sqlLog.append(" offset " + offset);
			
				 TransportUtils.writeLogDebug(logger, "SQL: "+sqlLog.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, limit);
				 pstmt.setInt(2, offset);
				 
				 rs = pstmt.executeQuery();


				  
				 while(rs.next()) {
					 //get the model criteria
					 VerificationAndValidation model=new VerificationAndValidation();  
		    		 model.setId(rs.getInt(1));
		    		 model.setItem(rs.getString(2));
		    		 model.setDriver(rs.getString(3));
		    		 model.setTerminal(rs.getString(4));
		    		 model.setLorry(rs.getString(5));
		    		 model.setVerificationDateStr(rs.getString(6));
		    		 if (rs.getString(7)!=null) {
		    			 model.setCorrections(rs.getString(7).length()>30 ? rs.getString(7).substring(0, 30).concat("..."): rs.getString(7));//limit to 20 characters only	 
		    		 }
		    		 model.setVerificationCheckedBy(rs.getString(8));		
		    		 if (rs.getString(9)!=null) {
			    		 model.setFollowUp(rs.getString(9).length()>30 ? rs.getString(9).substring(0, 30).concat("..."): rs.getString(9));//limit to 20 characters only		    			 
		    		 }
		    		 model.setValidationDateStr(rs.getString(10));
		    		 model.setValidationCheckedBy(rs.getString(11));
		    		 model.setRemarks(rs.getString(12));
		    		 model.setTrailer(rs.getString(13));
		    		 if (rs.getString(14)!=null) {
			    		 model.setFindings(rs.getString(14).length()>30 ? rs.getString(14).substring(0, 30).concat("..."): rs.getString(14));//limit to 20 characters only	 
		    		 }
		    		 model.setDriverValidation(rs.getString(15));
		    		 model.setTerminalValidation(rs.getString(16));
		    		 model.setLorryValidation(rs.getString(17));
		    		 model.setTrailerValidation(rs.getString(18));
		    		 if (rs.getString(19)!=null) { 
			    		 model.setRootCause(rs.getString(19).length()>30 ? rs.getString(19).substring(0, 30).concat("..."): rs.getString(19));//limit to 30 characters only	
		    		 }
		    		 if (rs.getString(20)!=null) { 
			    		 model.setClosure(rs.getString(20).length()>30 ? rs.getString(20).substring(0, 30).concat("..."): rs.getString(20));//limit to 30 characters only	
		    		 }
		    		 //START Added for 2016 Revision 2 - April 3, 2016
		    		 model.setCreatedOn(rs.getTimestamp(21));
		    		 model.setCreatedOnStr(DateUtils.sqlTimestampToStringDate(model.getCreatedOn()));
		    		 //END Added for 2016 Revision 2 - April 3, 2016
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
		    	 
			    sqlCount = new StringBuffer("select count(*) from transport.file_verification d where d.active = false ");

				StringBuffer sqlCountLog = new StringBuffer("select count(*) from transport.file_verification d where d.active = false ");
					
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
		
		VerificationAndValidation model = (VerificationAndValidation) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update transport.file_verification set ");	
			qry.append(" active=true ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");

		StringBuffer qryLog =  new StringBuffer("update transport.file_verification set ");	
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
				System.out.println("Verification and Validation Compliance Tracker record (id: " +model.getId()+") restored successfully..");
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
	
	//Transport Revision 1 Dec2015
	@Override
	public Map<String, Object> getVerificationRemiders(HashMap<String, Object> criteriaMap) throws Exception {
		
			// TODO Auto-generated method stub
			TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_GET_ACTIVE_DATA);
		 
			 //get the pagination and offset
			 int offset = (int) criteriaMap.get(MapConstant.PAGINATION_OFFSET);
			 int limit = (int) criteriaMap.get(MapConstant.PAGINATION_LIMIT);
			 
		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
		     Map<String, Object> returnMap = null;
			 List<VerificationAndValidation> rsList = new ArrayList<VerificationAndValidation>();
			  
			 try {
				 conn = ServerContext.getJDBCHandle();

			 	StringBuffer sql = new StringBuffer("select x.* from ( ");
			 			sql.append(" select d.id,j.name as terminal, a.description as item,e.description as correction, b.lastname||', '||b.firstname as drivername,c.lorryno, ");
			 			sql.append(" d.validationdate as closuredate, i.description as remarks, DATE_PART('day', d.validationdate::timestamp -  CURRENT_DATE::timestamp) as daystoclosure, d.createdon ");
			 			sql.append(" from transport.file_verification d ");
			 			sql.append(" left join transport.file_items a on a.id = d.itemid ");
			 			sql.append(" left join transport.file_employee b on b.id = d.driverid ");
			 			sql.append(" left join transport.file_lorry c on c.id = d.lorryid ");
			 			sql.append(" left join transport.file_corrections e on e.id = d.correctionsid ");
			 			sql.append(" left join transport.file_remarks i on i.id = d.remarksid ");
			 			sql.append(" left join transport.file_terminal j on j.id = d.terminalid ");
			 			sql.append(" left join transport.file_rootcause o on o.id = d.rootcauseid ");
			 			sql.append(" left join transport.file_closure p on p.id = d.closureid ");
			 			sql.append(" where i.description <> 'Closed' and d.active = true) x ");
			 			sql.append(" where x.daystoclosure < 8 ");
			 			sql.append(" order by x.terminal, x.closuredate ");
						sql.append(" limit ? ");
						sql.append(" offset ?");	

				StringBuffer sqlLog = new StringBuffer("select x.* from ( ");
						sqlLog.append(" select d.id,j.name as terminal, a.description as item,e.description as correction, b.lastname||', '||b.firstname as drivername,c.lorryno, ");
						sqlLog.append(" d.validationdate as closuredate, i.description as remarks, DATE_PART('day', d.validationdate::timestamp -  CURRENT_DATE::timestamp) as daystoclosure, d.createdon ");
						sqlLog.append(" from transport.file_verification d ");
						sqlLog.append(" left join transport.file_items a on a.id = d.itemid ");
						sqlLog.append(" left join transport.file_employee b on b.id = d.driverid ");
						sqlLog.append(" left join transport.file_lorry c on c.id = d.lorryid ");
						sqlLog.append(" left join transport.file_corrections e on e.id = d.correctionsid ");
						sqlLog.append(" left join transport.file_remarks i on i.id = d.remarksid ");
						sqlLog.append(" left join transport.file_terminal j on j.id = d.terminalid ");
						sqlLog.append(" left join transport.file_rootcause o on o.id = d.rootcauseid ");
						sqlLog.append(" left join transport.file_closure p on p.id = d.closureid ");
						sqlLog.append(" where i.description <> 'Closed' and d.active = true) x ");
						sqlLog.append(" where x.daystoclosure < 8 ");
						sqlLog.append(" order by x.terminal, x.closuredate ");
						sqlLog.append(" limit " + limit);
						sqlLog.append(" offset " + offset);

				 TransportUtils.writeLogDebug(logger, "SQL: "+sqlLog.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, limit);
				 pstmt.setInt(2, offset);
				 
				 rs = pstmt.executeQuery();
				  
				 while(rs.next()) {
					 //get the model criteria
					 VerificationAndValidation model=new VerificationAndValidation();  
		    		 model.setId(rs.getInt(1));
		    		 model.setTerminal(rs.getString(2));
		    		 model.setItem(rs.getString(3));
		    		 model.setCorrections(rs.getString(4));
		    		 model.setDriver(rs.getString(5));
		    		 model.setLorry(rs.getString(6));
		    		 model.setValidationDateStr(rs.getString(7));
		    		 model.setRemarks(rs.getString(8));
		    		 model.setCreatedOn(rs.getTimestamp(10));
		    		 model.setCreatedOnStr(DateUtils.sqlTimestampToStringDate(model.getCreatedOn()));
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
	     
		     //get the total of records
		     int  totalNoOfRecords = 0;

		     try {
		    	 conn = ServerContext.getJDBCHandle();
		    	 
				 StringBuffer sqlCount = new StringBuffer("select count(x.*) from ( ");
				 	sqlCount.append(" select d.id,j.name as terminal, a.description as item,e.description as correction, b.lastname||', '||b.firstname as drivername,c.lorryno, ");
				 	sqlCount.append(" d.validationdate as closuredate, i.description as remarks, DATE_PART('day', d.validationdate::timestamp -  CURRENT_DATE::timestamp) as daystoclosure ");
				 	sqlCount.append(" from transport.file_verification d ");
				 	sqlCount.append(" left join transport.file_items a on a.id = d.itemid ");
				 	sqlCount.append(" left join transport.file_employee b on b.id = d.driverid ");
				 	sqlCount.append(" left join transport.file_lorry c on c.id = d.lorryid ");
				 	sqlCount.append(" left join transport.file_corrections e on e.id = d.correctionsid ");
				 	sqlCount.append(" left join transport.file_remarks i on i.id = d.remarksid ");
				 	sqlCount.append(" left join transport.file_terminal j on j.id = d.terminalid ");
				 	sqlCount.append(" left join transport.file_rootcause o on o.id = d.rootcauseid ");
				 	sqlCount.append(" left join transport.file_closure p on p.id = d.closureid ");
				 	sqlCount.append(" where i.description <> 'Closed' and d.active = true) x ");
				 	sqlCount.append(" where x.daystoclosure < 8 ");

				StringBuffer sqlCountLog = new StringBuffer("select count(x.*) from ( ");
					 sqlCountLog.append(" select d.id,j.name as terminal, a.description as item,e.description as correction, b.lastname||', '||b.firstname as drivername,c.lorryno, ");
					 sqlCountLog.append(" d.validationdate as closuredate, i.description as remarks, DATE_PART('day', d.validationdate::timestamp -  CURRENT_DATE::timestamp) as daystoclosure ");
					 sqlCountLog.append(" from transport.file_verification d ");
					 sqlCountLog.append(" left join transport.file_items a on a.id = d.itemid ");
					 sqlCountLog.append(" left join transport.file_employee b on b.id = d.driverid ");
					 sqlCountLog.append(" left join transport.file_lorry c on c.id = d.lorryid ");
					 sqlCountLog.append(" left join transport.file_corrections e on e.id = d.correctionsid ");
					 sqlCountLog.append(" left join transport.file_remarks i on i.id = d.remarksid ");
					 sqlCountLog.append(" left join transport.file_terminal j on j.id = d.terminalid ");
					 sqlCountLog.append(" left join transport.file_rootcause o on o.id = d.rootcauseid ");
					 sqlCountLog.append(" left join transport.file_closure p on p.id = d.closureid ");
					 sqlCountLog.append(" where i.description <> 'Closed' and d.active = true) x ");
					 sqlCountLog.append(" where x.daystoclosure < 8 ");
					
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
	
}
