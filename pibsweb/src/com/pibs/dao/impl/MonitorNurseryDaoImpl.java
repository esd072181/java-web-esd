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
import com.pibs.dao.MonitorNurseryDao;
import com.pibs.model.MonitorNursery;
import com.pibs.model.User;
import com.pibs.util.DateUtils;
import com.pibs.util.PIBSUtils;

public class MonitorNurseryDaoImpl implements MonitorNurseryDao {
	
	private final static Logger logger = Logger.getLogger(MonitorNurseryDaoImpl.class);

	@Override
	public Map<String, Object> save(HashMap<String, Object> dataMap) throws Exception{
		
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SAVE);
		
		//DBCP JNDI
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean status = false;
		
		MonitorNursery model = (MonitorNursery) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setCreatedBy((int) user.getId());	
		}
		model.setCreatedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("insert into pibs.tran_patient_nursery (");  		
				qry.append("patientcasesystemid ");
				qry.append(",lastname ");
		  		qry.append(",firstname ");
		  		qry.append(",dateofbirth ");
		  		qry.append(",timeofbirth ");
		  		qry.append(",gender ");
		  		qry.append(",weight ");
		  		qry.append(",remarks ");
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
		  		qry.append(" ,1 ");
		  		qry.append(" ,true ");
		  		qry.append(" ) ");
					
		PIBSUtils.writeLogDebug(logger, "SQL: "+qry.toString());
  		  		
		  try {
			  conn = ServerContext.getJDBCHandle();
			  conn.setAutoCommit(false);
			  pstmt = conn.prepareStatement(qry.toString());
			     
			  pstmt.setInt(1, model.getPatientCaseSystemId());
			  pstmt.setString(2, model.getLastName());
			  pstmt.setString(3, model.getFirstName());
			  pstmt.setDate(4, model.getDateOfBirth());
			  pstmt.setString(5, model.getTimeOfBirth());
			  pstmt.setString(6, model.getGender());
			  pstmt.setString(7, model.getWeight());
			  pstmt.setString(8, model.getRemarks());
			  pstmt.setInt(9, model.getCreatedBy());
			  pstmt.setTimestamp(10, model.getCreatedOn());
			     
			  int statusInt = pstmt.executeUpdate();
			     
			  if (statusInt == 1) {
				  conn.commit();
				  System.out.println("Inserted into Monitor Nursery is table successfully..");
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
		
		MonitorNursery model = (MonitorNursery) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update pibs.tran_patient_nursery set ");	
			qry.append(" lastname=? ");
			qry.append(" ,firstname=? ");
			qry.append(" ,dateofbirth=? ");
			qry.append(" ,timeofbirth=? ");
			qry.append(" ,gender=? ");
			qry.append(" ,weight=? ");
			qry.append(" ,remarks=? ");
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
				     
			pstmt.setString(1, model.getLastName());
			pstmt.setString(2, model.getFirstName());
			pstmt.setDate(3, model.getDateOfBirth());
			pstmt.setString(4, model.getTimeOfBirth());
			pstmt.setString(5, model.getGender());
			pstmt.setString(6, model.getWeight());
			pstmt.setString(7, model.getRemarks());
			pstmt.setInt(8, model.getModifiedBy());
			pstmt.setTimestamp(9, model.getModifiedOn());
			pstmt.setLong(10, model.getId());
				     
			int statusInt = pstmt.executeUpdate();
				     
			if (statusInt == 1) {
				conn.commit();
				System.out.println("Monitor Nursery record (id: " +model.getId()+") updated successfully..");
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

		 	String criteria = (String) criteriaMap.get(MapConstant.SEARCH_CRITERIA);
		 	
		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
			 
			 List<MonitorNursery> rsList = new ArrayList<MonitorNursery>();
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();
				 		sql.append("select a.id,a.patientcasesystemid,a.lastname,a.firstname,a.dateofbirth,a.timeofbirth,a.gender,a.weight,a.remarks");
				 		sql.append(" from pibs.tran_patient_nursery a ");
				 		sql.append(" where (a.lastname ilike '%"+criteria+"%' or a.firstname ilike '%"+criteria+"%')" );
				 		sql.append(" and a.active = true ");
					 	sql.append(" order by a.lastname ");
				 						 
				PIBSUtils.writeLogDebug(logger, "SQL: "+sql.toString());
					
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 rs = pstmt.executeQuery();
				 
				 while(rs.next()) {
					 MonitorNursery model = new MonitorNursery();  
		    		 model.setId(rs.getInt(1));
		    		 model.setPatientCaseSystemId(rs.getInt(2));
		    		 model.setLastName(rs.getString(3));
		    		 model.setFirstName(rs.getString(4));
		    		 model.setDateOfBirth(rs.getDate(5));
		    		 model.setTimeOfBirth(rs.getString(6));
		    		 model.setGender(rs.getString(7));
		    		 model.setWeight(rs.getString(8));
		    		 model.setRemarks(rs.getString(9));
		    		 rsList.add(model);
				 }				 
			 } catch (SQLException e) {
				 throw e;
			 } finally {
				 PIBSUtils.closeObjects(rs);
				 PIBSUtils.closeObjects(pstmt);
				 PIBSUtils.closeObjects(conn);
			 }
			 
		     //get the total of records
		     int  totalNoOfRecords = 0;
		     StringBuffer sqlCount = null;
			 
		     try {
		    	 conn = ServerContext.getJDBCHandle();
		    	 
			     sqlCount = new StringBuffer("select count(*) from pibs.tran_patient_nursery where  (lastname ilike '%"+criteria+"%' or firstname ilike '%"+criteria+"%') and active = true");	 

				PIBSUtils.writeLogDebug(logger, "SQL: "+sqlCount.toString());
				
		    	 pstmt = conn.prepareStatement(sqlCount.toString());
		    	 
		    	 rs = pstmt.executeQuery();
		    	 if (rs.next()) {
		    		 totalNoOfRecords = rs.getInt(1);
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
		    	 returnMap.put(MapConstant.PAGINATION_TOTALRECORDS, totalNoOfRecords);
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
		    MonitorNursery model = (MonitorNursery) criteriaMap.get(MapConstant.CLASS_DATA);

		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
		     Map<String, Object> returnMap = null;
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();				
				 	sql.append("select a.id,a.patientcasesystemid,a.lastname,a.firstname,a.dateofbirth,a.timeofbirth,a.gender,a.weight,a.remarks ");
				 	sql.append(" from pibs.tran_patient_nursery a ");
				 	sql.append(" where a.id = ?");
			
				 PIBSUtils.writeLogDebug(logger, "SQL: "+sql.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, model.getId());
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
		    		 model.setId(rs.getInt(1));
		    		 model.setPatientCaseSystemId(rs.getInt(2));
		    		 model.setLastName(rs.getString(3));
		    		 model.setFirstName(rs.getString(4));
		    		 model.setDateOfBirth(rs.getDate(5));
		    		 model.setTimeOfBirth(rs.getString(6));
		    		 model.setGender(rs.getString(7));
		    		 model.setWeight(rs.getString(8));
		    		 model.setRemarks(rs.getString(9));
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
		
		MonitorNursery model = (MonitorNursery) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update pibs.tran_patient_nursery set ");	
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
				System.out.println("Monitor Nursery record (id: " +model.getId()+") deleted successfully..");
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
	public Map<String, Object> searchByPatientCaseSystemId(HashMap<String, Object> criteriaMap) throws Exception{
		 
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SEARCH);
		 
		 	Map<String, Object> returnMap = null;

		 	MonitorNursery modelCriteria = (MonitorNursery) criteriaMap.get(MapConstant.CLASS_DATA);
		 	
		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
			 
			 List<MonitorNursery> rsList = new ArrayList<MonitorNursery>();
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();
				 		sql.append("select a.id,a.patientcasesystemid,a.lastname,a.firstname,a.dateofbirth,a.timeofbirth,a.gender,a.weight,a.remarks");
				 		sql.append(" from pibs.tran_patient_nursery a ");
				 		sql.append(" where a.patientcasesystemid = ? ");
				 		sql.append(" and a.active = true ");
					 	sql.append(" order by a.lastname ");
				 						 
				PIBSUtils.writeLogDebug(logger, "SQL: "+sql.toString());
					
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, modelCriteria.getPatientCaseSystemId());
				 
				 rs = pstmt.executeQuery();
				 
				 while(rs.next()) {
					 MonitorNursery model = new MonitorNursery();  
		    		 model.setId(rs.getInt(1));
		    		 model.setPatientCaseSystemId(rs.getInt(2));
		    		 model.setLastName(rs.getString(3));
		    		 model.setFirstName(rs.getString(4));
		    		 model.setDateOfBirth(rs.getDate(5));
		    		 model.setTimeOfBirth(rs.getString(6));
		    		 model.setGender(rs.getString(7));
		    		 model.setWeight(rs.getString(8));
		    		 model.setRemarks(rs.getString(9));
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
	public Map<String, Object> getInActiveData(HashMap<String, Object> criteriaMap) throws Exception {
		// TODO Auto-generated method stub
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_GET_INACTIVE_DATA);
		
		 //get the pagination and offset
		 int offset = (int) criteriaMap.get(MapConstant.PAGINATION_OFFSET);
		 int limit = (int) criteriaMap.get(MapConstant.PAGINATION_LIMIT);
		 
		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
		     Map<String, Object> returnMap = null;
			 List<MonitorNursery> rsList = new ArrayList<>();
			  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();				
				 	sql.append("select a.id,a.patientcasesystemid,a.lastname,a.firstname,a.dateofbirth,a.timeofbirth,a.gender,a.weight,a.remarks ");
				 	sql.append(" from pibs.tran_patient_nursery a ");
				 	sql.append(" where a.active = false ");
				 	sql.append(" order by a.lastname ");
				 	sql.append(" limit ? ");
				 	sql.append(" offset ? ");
			
				 PIBSUtils.writeLogDebug(logger, "SQL: "+sql.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 pstmt.setInt(1, limit);
				 pstmt.setInt(2, offset);
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
					 //get the model criteria
					 MonitorNursery model = new MonitorNursery();
		    		 model.setId(rs.getInt(1));
		    		 model.setPatientCaseSystemId(rs.getInt(2));
		    		 model.setLastName(rs.getString(3));
		    		 model.setFirstName(rs.getString(4));
		    		 model.setDateOfBirth(rs.getDate(5));
		    		 model.setTimeOfBirth(rs.getString(6));
		    		 model.setGender(rs.getString(7));
		    		 model.setWeight(rs.getString(8));
		    		 model.setRemarks(rs.getString(9));
		    		 rsList.add(model);
				 }				 
			 } catch (SQLException e) {
				 throw e;
			 } finally {
				 PIBSUtils.closeObjects(rs);
				 PIBSUtils.closeObjects(pstmt);
				 PIBSUtils.closeObjects(conn);
			 }	 
			 
		     //get the total of records
		     int  totalNoOfRecords = 0;
		     StringBuffer sqlCount = null;
			 
		     try {
		    	 conn = ServerContext.getJDBCHandle();
		    	 
			    sqlCount = new StringBuffer("select count(*) from pibs.tran_patient_nursery where active = false");	 
	
				PIBSUtils.writeLogDebug(logger, "SQL: "+sqlCount.toString());
				
		    	 pstmt = conn.prepareStatement(sqlCount.toString());
		    	 
		    	 rs = pstmt.executeQuery();
		    	 if (rs.next()) {
		    		 totalNoOfRecords = rs.getInt(1);
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
		    	 returnMap.put(MapConstant.PAGINATION_TOTALRECORDS, totalNoOfRecords);
		     } 
	     
		return returnMap;
	}

	@Override
	public Map<String, Object> restore(HashMap<String, Object> dataMap) throws Exception{
		// TODO Auto-generated method stub
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_RESTORE);

		//DBCP JNDI
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean status = false;
		
		MonitorNursery model = (MonitorNursery) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update pibs.tran_patient_nursery set ");	
			qry.append(" active=true ");
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
				System.out.println("Nursery record (id: " +model.getId()+") restored successfully..");
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
	public Map<String, Object> searchForListReport(HashMap<String, Object> criteriaMap) throws Exception {
		 
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SEARCH);
		 
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
			 
			 List<MonitorNursery> rsList = new ArrayList<>();
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = null;
				 		
				 sql = new StringBuffer("select a.id,a.lastname,a.firstname,a.dateofbirth,a.timeofbirth,a.gender,a.weight,a.remarks,c.lastname || ', ' || c.firstname as mother");
			 		sql.append(" from pibs.tran_patient_nursery a, pibs.tran_patient_case b, pibs.file_patient_info c  ");
			 		sql.append(" where a.patientcasesystemid = b.id ");
			 		sql.append(" and b.patientsystemid = c.id ");
			 		sql.append(" and a.active = true ");
			    	if (MiscConstant.LOV_NURSERY_REPORT_SEARCH_CRITERIA_LAST_NAME == searchCriteria) {
			    		sql.append(" and a.lastname ilike '%"+searchValue+"%' ");
			    	}
			    	if (MiscConstant.LOV_NURSERY_REPORT_SEARCH_CRITERIA_FIRST_NAME == searchCriteria) {
			    		sql.append(" and a.firstname ilike '%"+searchValue+"%' ");
			    	}
			    	if (MiscConstant.LOV_NURSERY_REPORT_SEARCH_CRITERIA_DATE_OF_BIRTH == searchCriteria) {
			    		sql.append(" and a.dateofbirth between '"+DateUtils.sqlDateToStringSQL(DateUtils.strToSQLDate(dateFromValue))+"' and '"+DateUtils.sqlDateToStringSQL(DateUtils.strToSQLDate(dateToValue))+"'");

			    	}
				 	sql.append(" order by a.lastname ");
						
						 
				PIBSUtils.writeLogDebug(logger, "SQL: "+sql.toString());
					
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 rs = pstmt.executeQuery();
				 
				 while(rs.next()) {
					 MonitorNursery model = new MonitorNursery();  
		    		 model.setId(rs.getInt(1));
		    		 model.setLastName(rs.getString(2));
		    		 model.setFirstName(rs.getString(3));
		    		 model.setDateOfBirth(rs.getDate(4));
		    		 model.setTimeOfBirth(rs.getString(5));
		    		 model.setGender(rs.getString(6));
		    		 model.setWeight(rs.getString(7));
		    		 model.setRemarks(rs.getString(8));
		    		 model.setMother(rs.getString(9));
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
	     
	    System.out.println("searchForListReport() - Exit");
		return returnMap;
	}	
	
}
