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
import com.pibs.constant.ActionConstant;
import com.pibs.constant.MapConstant;
import com.pibs.constant.MiscConstant;
import com.pibs.dao.PatientDao;
import com.pibs.model.Patient;
import com.pibs.model.User;
import com.pibs.util.DateUtils;
import com.pibs.util.PIBSUtils;

public class PatientDaoImpl implements PatientDao {
	
	private final static Logger logger = Logger.getLogger(PatientDaoImpl.class);

	@SuppressWarnings("resource")
	@Override
	public Map<String, Object> save(HashMap<String, Object> dataMap) throws Exception{
		
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SAVE);
		
		//DBCP JNDI
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean status = false;
		
		Patient model = (Patient) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setCreatedBy((int) user.getId());	
		}
		model.setCreatedOn(new Timestamp(new java.util.Date().getTime()));
		model.setDateRegistered(DateUtils.getStrDateFromSQLTimestamp(model.getCreatedOn()));
		
		StringBuffer qry =  new StringBuffer("insert into pibs.file_patient_info (");  		
				qry.append("patientid ");
		  		qry.append(",lastname ");
		  		qry.append(",firstname ");
		  		qry.append(",middlename ");
		  		qry.append(",gender ");
		  		qry.append(",birthday ");
		  		qry.append(",contactno ");
		  		qry.append(",address ");
		  		qry.append(",contactperson ");
		  		qry.append(",contactpersonno ");
		  		qry.append(",dateregistered ");
		  		qry.append(",patientstatusid ");
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
		  		qry.append(" ,1 ");
		  		qry.append(" ,true ");
		  		qry.append(" ) ");

		StringBuffer qryLog =  new StringBuffer("insert into pibs.file_patient_info (");
				qryLog.append("patientid ");
				qryLog.append(",lastname ");
				qryLog.append(",firstname ");
				qryLog.append(",middlename ");
				qryLog.append(",gender ");
				qryLog.append(",birthday ");
				qryLog.append(",contactno ");
				qryLog.append(",address ");
				qryLog.append(",contactperson ");
				qryLog.append(",contactpersonno ");
				qryLog.append(",dateregistered ");
				qryLog.append(",patientstatusid ");
				qryLog.append(",createdby ");
				qryLog.append(",createdon ");
				qryLog.append(",version ");
				qryLog.append(",active ");
				qryLog.append(" ) ");
				qryLog.append(" values ");
				qryLog.append(" ( ");
				qryLog.append(model.getPatientId());
				qryLog.append(" ,"+model.getLastName());
				qryLog.append(" ,"+model.getFirstName());
				qryLog.append(" ,"+model.getMiddleName());
				qryLog.append(" ,"+model.getGender());
				qryLog.append(" ,"+model.getBirthday());
				qryLog.append(" ,"+model.getContactNo());
				qryLog.append(" ,"+model.getAddress());
				qryLog.append(" ,"+model.getContactPerson());
				qryLog.append(" ,"+model.getContactPersonNo());
				qryLog.append(" ,"+model.getDateRegistered());
				qryLog.append(" ,"+model.getPatientStatusId());
				qryLog.append(" ,"+model.getCreatedBy());
				qryLog.append(" ,"+model.getCreatedOn());
				qryLog.append(" ,1 ");
				qryLog.append(" ,true ");
				qryLog.append(" ) ");
					
		PIBSUtils.writeLogDebug(logger, "SQL: "+qryLog.toString());
  		  		
		  try {
			  conn = ServerContext.getJDBCHandle();
			  conn.setAutoCommit(false);
			  pstmt = conn.prepareStatement(qry.toString());
			     
			  pstmt.setString(1, model.getPatientId());
			  pstmt.setString(2, model.getLastName());
			  pstmt.setString(3, model.getFirstName());
			  pstmt.setString(4, model.getMiddleName());
			  pstmt.setString(5, model.getGender());
			  pstmt.setDate(6, model.getBirthday());
			  pstmt.setString(7, model.getContactNo());
			  pstmt.setString(8, model.getAddress());
			  pstmt.setString(9, model.getContactPerson());
			  pstmt.setString(10, model.getContactPersonNo());
			  pstmt.setString(11, model.getDateRegistered());
			  pstmt.setInt(12, model.getPatientStatusId());
			  pstmt.setInt(13, model.getCreatedBy());
			  pstmt.setTimestamp(14, model.getCreatedOn());
			     
			  int statusInt = pstmt.executeUpdate();
			     
			  if (statusInt == 1) {
				  conn.commit();
				  System.out.println("Inserted into Patient table successfully..");
				  status = true;
				  
				  //update the model to set the id for the form bean
				  StringBuffer qrySelect =  new StringBuffer("select id from pibs.file_patient_info where patientid = ?");
				  PIBSUtils.writeLogDebug(logger, "SQL Select: "+qrySelect.toString());
				  try {
					  pstmt = conn.prepareStatement(qrySelect.toString());
					  pstmt.setString(1, model.getPatientId());
					  rs = pstmt.executeQuery(); 
					  if (rs.next()) {
							 model.setId(rs.getInt(1));
				      }
				  } catch (Exception e) {
					  e.printStackTrace();
				  }
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
		returnMap.put(MapConstant.CLASS_DATA, model);
		     
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
		
		Patient model = (Patient) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update pibs.file_patient_info set ");	
			qry.append(" patientid=? ");
			qry.append(" ,lastname=? ");
			qry.append(" ,firstname=? ");
			qry.append(" ,middlename=? ");
			qry.append(" ,gender=? ");
			qry.append(" ,birthday=? ");
			qry.append(" ,contactno=? ");
			qry.append(" ,address=? ");
			qry.append(" ,contactperson=? ");
			qry.append(" ,contactpersonno=? ");
			qry.append(" ,patientstatusid=? ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");

		StringBuffer qryLog =  new StringBuffer("update pibs.file_patient_info set ");		
			qryLog.append(" patientid="+model.getPatientId());
			qryLog.append(" ,lastname="+model.getLastName());
			qryLog.append(" ,firstname="+model.getFirstName());
			qryLog.append(" ,middlename="+model.getMiddleName());
			qryLog.append(" ,gender="+model.getGender());
			qryLog.append(" ,birthday="+model.getBirthday());
			qryLog.append(" ,contactno="+model.getContactNo());
			qryLog.append(" ,address="+model.getAddress());
			qryLog.append(" ,contactperson="+model.getContactPerson());
			qryLog.append(" ,contactpersonno="+model.getContactPersonNo());
			qryLog.append(" ,patientstatusid="+model.getPatientStatusId());
			qryLog.append(" ,modifiedby="+model.getModifiedBy());
			qryLog.append(" ,modifiedon="+model.getModifiedOn());
			qryLog.append(" ,version=(version+1) ");
			qryLog.append(" where ");
			qryLog.append(" id = "+model.getId());
			
		PIBSUtils.writeLogDebug(logger, "SQL: "+qryLog.toString());
	
		 try {
			conn = ServerContext.getJDBCHandle();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(qry.toString());
				     
			pstmt.setString(1, model.getPatientId());
			pstmt.setString(2, model.getLastName());
			pstmt.setString(3, model.getFirstName());
			pstmt.setString(4, model.getMiddleName());
			pstmt.setString(5, model.getGender());
			pstmt.setDate(6, model.getBirthday());
			pstmt.setString(7, model.getContactNo());
			pstmt.setString(8, model.getAddress());
			pstmt.setString(9, model.getContactPerson());
			pstmt.setString(10, model.getContactPersonNo());
			pstmt.setInt(11, model.getPatientStatusId());
			pstmt.setInt(12, model.getModifiedBy());
			pstmt.setTimestamp(13, model.getModifiedOn());
			pstmt.setLong(14, model.getId());
				     
			int statusInt = pstmt.executeUpdate();
				     
			if (statusInt == 1) {
				conn.commit();
				System.out.println("Patient record (id: " +model.getId()+") updated successfully..");
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
	public Map<String, Object> delete(HashMap<String, Object> dataMap) throws Exception{
		// TODO Auto-generated method stub
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_DELETE);

		
		//DBCP JNDI
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean status = false;
		
		Patient model = (Patient) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update pibs.file_patient_info set ");	
			qry.append(" active=false ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");

		StringBuffer qryLog =  new StringBuffer("update pibs.file_patient_info set ");	
			qryLog.append(" active=false ");
			qryLog.append(" ,modifiedby="+model.getModifiedBy());
			qryLog.append(" ,modifiedon="+model.getModifiedOn());
			qryLog.append(" ,version=(version+1) ");
			qryLog.append(" where ");
			qryLog.append(" id = "+model.getId());
			
		PIBSUtils.writeLogDebug(logger, "SQL: "+qryLog.toString());
	
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
				System.out.println("Patient record (id: " +model.getId()+") deleted successfully..");
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
			 
			  List<Patient> rsList = new ArrayList<Patient>();
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = null;
				 if (category.equals(ActionConstant.SEARCHALL)) {
					 sql = new StringBuffer("select a.id,a.patientid,a.lastname,a.firstname,a.middlename,a.gender,a.birthday,a.dateregistered,a.patientstatusid,b.listvalue,a.contactno,a.address,a.contactperson,a.contactpersonno,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
					 	sql.append(" from pibs.file_patient_info a, pibs.list_value b ");
					 	sql.append(" where a.patientstatusid = b.id ");
					 	sql.append(" and a.active = true ");
					 	sql.append(" order by a.lastname,a.firstname ");
					 	sql.append(" limit ? ");
					 	sql.append(" offset ?");		 
				 } else {
					 sql = new StringBuffer("select a.id,a.patientid,a.lastname,a.firstname,a.middlename,a.gender,a.birthday,a.dateregistered,a.patientstatusid,b.listvalue,a.contactno,a.address,a.contactperson,a.contactpersonno,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
					    sql.append(" from pibs.file_patient_info a, pibs.list_value b ");
					 	sql.append(" where a.patientstatusid = b.id ");  
					 	sql.append(" and (a.lastname ilike '%"+criteria+"%' or a.firstname ilike '%"+criteria+"%' or a.middlename ilike '%"+criteria+"%')" );
					 	sql.append(" and a.active = true ");
					 	sql.append(" order by a.lastname,a.firstname ");
					 	sql.append(" limit ? ");
					 	sql.append(" offset ?");	
				 }


				StringBuffer sqlLog = null;
						 
				if (category.equals(ActionConstant.SEARCHALL)) {
							 sqlLog = new StringBuffer("select a.id,a.patientid,a.lastname,a.firstname,a.middlename,a.gender,a.birthday,a.dateregistered,a.patientstatusid,b.listvalue,a.contactno,a.address,a.contactperson,a.contactpersonno,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
							 sqlLog.append(" from pibs.file_patient_info a, pibs.list_value b ");
							 sqlLog.append(" where a.patientstatusid = b.id ");
							 sqlLog.append(" and a.active = true ");
							 sqlLog.append(" order by a.lastname,a.firstname ");
							 sqlLog.append(" limit "+limit);
							 sqlLog.append(" offset "+offset);		 
				} else {
							 sqlLog = new StringBuffer("select a.id,a.patientid,a.lastname,a.firstname,a.middlename,a.gender,a.birthday,a.dateregistered,a.patientstatusid,b.listvalue,a.contactno,a.address,a.contactperson,a.contactpersonno,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
							 sqlLog.append(" from pibs.file_patient_info a, pibs.list_value b ");
							 sqlLog.append(" where a.patientstatusid = b.id ");
							 sqlLog.append(" and(a.lastname ilike '%"+criteria+"%' or a.firstname ilike '%"+criteria+"%' or a.middlename ilike '%"+criteria+"%')" );
							 sqlLog.append(" and a.active = true ");
							 sqlLog.append(" order by a.lastname,a.firstname ");
							 sqlLog.append(" limit "+limit);
							 sqlLog.append(" offset "+offset);	
				}
						 
				PIBSUtils.writeLogDebug(logger, "SQL: "+sqlLog.toString());
					
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, limit);
				 pstmt.setInt(2, offset);
				 
				 rs = pstmt.executeQuery();
				 
				 while(rs.next()) {
					 Patient model=new Patient();  
		    		 model.setId(rs.getInt(1));
		    		 model.setPatientId(rs.getString(2));
		    		 model.setLastName(rs.getString(3));
		    		 model.setFirstName(rs.getString(4));
		    		 model.setMiddleName(rs.getString(5));
		    		 model.setGender(rs.getString(6));
		    		 model.setBirthday(rs.getDate(7));
		    		 model.setDateRegistered(rs.getString(8));
		    		 model.setPatientStatusId(rs.getInt(9));
		    		 model.setStatus(rs.getString(10));
		    		 model.setContactNo(rs.getString(11));
		    		 model.setAddress(rs.getString(12));
		    		 model.setContactPerson(rs.getString(13));
		    		 model.setContactPersonNo(rs.getString(14));
		    		 if (model.getBirthday()!=null) {
		    			 model.setBirthdayStr(DateUtils.sqlDateToString(model.getBirthday()));		    			 
		    		 }
		    		 model.setFullName();
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
		    	 
			     if (category.equals(ActionConstant.SEARCHALL)) {
			    	 sqlCount = new StringBuffer("select count(*) from pibs.file_patient_info where active = true");	 
			     }else {
			    	 sqlCount = new StringBuffer("select count(*) from pibs.file_patient_info where  (lastname ilike '%"+criteria+"%' or firstname ilike '%"+criteria+"%' or middlename ilike '%"+criteria+"%') and active = true");	 
			     } 

				StringBuffer sqlCountLog = null;
				if (category.equals(ActionConstant.SEARCHALL)) {
					 sqlCountLog = new StringBuffer("select count(*) from pibs.file_patient_info where active = true");	 
				}else {
					 sqlCountLog = new StringBuffer("select count(*) from pibs.file_patient_info where  (lastname ilike '%"+criteria+"%' or firstname ilike '%"+criteria+"%' or middlename ilike '%"+criteria+"%') and active = true");	 
				} 
					
				PIBSUtils.writeLogDebug(logger, "SQL: "+sqlCountLog.toString());
				
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
	     
	    System.out.println("searchAll() - Exit");
		return returnMap;
	}

	@Override
	public Map<String, Object> getDataById(HashMap<String, Object> criteriaMap)
			throws Exception {
		// TODO Auto-generated method stub
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_GETDATA_BY_ID);
		 
		    //get the model criteria
		    Patient model = (Patient) criteriaMap.get(MapConstant.CLASS_DATA);

		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
		     Map<String, Object> returnMap = null;
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();				
				 	sql.append("select id,patientid,lastname,firstname,middlename,gender,birthday,dateregistered,patientstatusid,contactno,address,contactperson,contactpersonno,createdby,createdon,modifiedby,modifiedon,version,active ");
				 	sql.append("from pibs.file_patient_info ");
				 	sql.append("where id = ?");

				 StringBuffer sqlLog = new StringBuffer();				
				 	sqlLog.append("select id,patientid,lastname,firstname,middlename,gender,birthday,dateregistered,patientstatusid,contactno,address,contactperson,contactpersonno,createdby,createdon,modifiedby,modifiedon,version,active ");
				 	sqlLog.append("from pibs.file_patient_info ");
				 	sqlLog.append("where id = "+ model.getId());
			
				 PIBSUtils.writeLogDebug(logger, "SQL: "+sqlLog.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, model.getId());
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
		    		 model.setId(rs.getInt(1));
		    		 model.setPatientId(rs.getString(2));
		    		 model.setLastName(rs.getString(3));
		    		 model.setFirstName(rs.getString(4));
		    		 model.setMiddleName(rs.getString(5));
		    		 model.setGender(rs.getString(6));
		    		 model.setBirthday(rs.getDate(7));
		    		 model.setDateRegistered(rs.getString(8));
		    		 model.setPatientStatusId(rs.getInt(9));
		    		 model.setContactNo(rs.getString(10));
		    		 model.setAddress(rs.getString(11));
		    		 model.setContactPerson(rs.getString(12));
		    		 model.setContactPersonNo(rs.getString(13));
		    		 model.setFullName();
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
	public Map<String, Object> getActiveData() throws Exception {
		// TODO Auto-generated method stub
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_GET_ACTIVE_DATA);
		 
		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
		     Map<String, Object> returnMap = null;
			 List<Patient> rsList = new ArrayList<Patient>();
			  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer("select a.id,a.patientid,a.lastname,a.firstname,a.middlename,a.gender,a.birthday,a.dateregistered,a.patientstatusid,b.listvalue,a.contactno,a.address,a.contactperson,a.contactpersonno,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
				 	sql.append(" from pibs.file_patient_info a, pibs.list_value b ");
				 	sql.append(" where a.patientstatusid = b.id ");
				 	sql.append(" and a.active = true ");
				 	sql.append(" order by a.lastname,a.firstname");

				 StringBuffer sqlLog = new StringBuffer("select a.id,a.patientid,a.lastname,a.firstname,a.middlename,a.gender,a.birthday,a.dateregistered,a.patientstatusid,b.listvalue,a.contactno,a.address,a.contactperson,a.contactpersonno,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
					 sqlLog.append(" from pibs.file_patient_info a, pibs.list_value b ");
					 sqlLog.append(" where a.patientstatusid = b.id ");
					 sqlLog.append(" and a.active = true ");
				  	 sqlLog.append(" order by a.lastname,a.firstname ");
			
				 PIBSUtils.writeLogDebug(logger, "SQL: "+sqlLog.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
					 //get the model criteria
					 Patient model = new Patient();
		    		 model.setId(rs.getInt(1));
		    		 model.setPatientId(rs.getString(2));
		    		 model.setLastName(rs.getString(3));
		    		 model.setFirstName(rs.getString(4));
		    		 model.setMiddleName(rs.getString(5));
		    		 model.setGender(rs.getString(6));
		    		 model.setBirthday(rs.getDate(7));
		    		 model.setDateRegistered(rs.getString(8));
		    		 model.setPatientStatusId(rs.getInt(9));
		    		 model.setStatus(rs.getString(10));
		    		 model.setContactNo(rs.getString(11));
		    		 model.setAddress(rs.getString(12));
		    		 model.setContactPerson(rs.getString(13));
		    		 model.setContactPersonNo(rs.getString(14));
		    		 model.setFullName();
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
	     
		return returnMap;
	}

	public static int getPatientCount() throws Exception{
		 
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SEARCH);

			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
			 
			 int totalNoOfRecords = 0;
					  
			 try {
			 	 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer("select count(id) from pibs.file_patient_info");
		 			 
				 PIBSUtils.writeLogDebug(logger, "SQL: "+sql.toString());
					
				 pstmt = conn.prepareStatement(sql.toString());
				 
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
			 
	    System.out.println("getPatientCount() - Exit");
		return totalNoOfRecords;
	}
	
	@Override
	public Map<String, Object> searchPatientForAdmission(HashMap<String, Object> criteriaMap) throws Exception{
		 
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SEARCH);
		 
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
			 
			  List<Patient> rsList = new ArrayList<Patient>();
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = null;
				 if (category.equals(ActionConstant.SEARCHALL)) {
					 sql = new StringBuffer("select a.id,a.patientid,a.lastname,a.firstname,a.middlename,a.gender,a.birthday,a.dateregistered,a.patientstatusid,b.listvalue,a.contactno,a.address,a.contactperson,a.contactpersonno,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
					 	sql.append(" from pibs.file_patient_info a, pibs.list_value b ");
					 	sql.append(" where a.patientstatusid = b.id ");
					 	sql.append(" and a.active = true ");
					 	sql.append(" and a.patientstatusid = 501 ");
					 	sql.append(" order by a.lastname,a.firstname ");
					 	sql.append(" limit ? ");
					 	sql.append(" offset ?");		 
				 } else {
					 sql = new StringBuffer("select a.id,a.patientid,a.lastname,a.firstname,a.middlename,a.gender,a.birthday,a.dateregistered,a.patientstatusid,b.listvalue,a.contactno,a.address,a.contactperson,a.contactpersonno,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
					    sql.append(" from pibs.file_patient_info a, pibs.list_value b ");
					 	sql.append(" where a.patientstatusid = b.id ");  
					 	sql.append(" and (a.lastname ilike '%"+criteria+"%' or a.firstname ilike '%"+criteria+"%' or a.middlename ilike '%"+criteria+"%')" );
					 	sql.append(" and a.active = true ");
					 	sql.append(" and a.patientstatusid = 501 ");
					 	sql.append(" order by a.lastname,a.firstname ");
					 	sql.append(" limit ? ");
					 	sql.append(" offset ?");	
				 }


				StringBuffer sqlLog = null;
						 
				if (category.equals(ActionConstant.SEARCHALL)) {
							 sqlLog = new StringBuffer("select a.id,a.patientid,a.lastname,a.firstname,a.middlename,a.gender,a.birthday,a.dateregistered,a.patientstatusid,b.listvalue,a.contactno,a.address,a.contactperson,a.contactpersonno,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
							 sqlLog.append(" from pibs.file_patient_info a, pibs.list_value b ");
							 sqlLog.append(" where a.patientstatusid = b.id ");
							 sqlLog.append(" and a.active = true ");
							 sqlLog.append(" and a.patientstatusid = 501 ");
							 sqlLog.append(" order by a.lastname,a.firstname ");
							 sqlLog.append(" limit "+limit);
							 sqlLog.append(" offset "+offset);		 
				} else {
							 sqlLog = new StringBuffer("select a.id,a.patientid,a.lastname,a.firstname,a.middlename,a.gender,a.birthday,a.dateregistered,a.patientstatusid,b.listvalue,a.contactno,a.address,a.contactperson,a.contactpersonno,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
							 sqlLog.append(" from pibs.file_patient_info a, pibs.list_value b ");
							 sqlLog.append(" where a.patientstatusid = b.id ");
							 sqlLog.append(" and(a.lastname ilike '%"+criteria+"%' or a.firstname ilike '%"+criteria+"%' or a.middlename ilike '%"+criteria+"%')" );
							 sqlLog.append(" and a.active = true ");
							 sqlLog.append(" and a.patientstatusid = 501 ");
							 sqlLog.append(" order by a.lastname,a.firstname ");
							 sqlLog.append(" limit "+limit);
							 sqlLog.append(" offset "+offset);	
				}
						 
				PIBSUtils.writeLogDebug(logger, "SQL: "+sqlLog.toString());
					
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, limit);
				 pstmt.setInt(2, offset);
				 
				 rs = pstmt.executeQuery();
				 
				 while(rs.next()) {
					 Patient model=new Patient();  
		    		 model.setId(rs.getInt(1));
		    		 model.setPatientId(rs.getString(2));
		    		 model.setLastName(rs.getString(3));
		    		 model.setFirstName(rs.getString(4));
		    		 model.setMiddleName(rs.getString(5));
		    		 model.setGender(rs.getString(6));
		    		 model.setBirthday(rs.getDate(7));
		    		 model.setDateRegistered(rs.getString(8));
		    		 model.setPatientStatusId(rs.getInt(9));
		    		 model.setStatus(rs.getString(10));
		    		 model.setAddress(rs.getString(12));
		    		 model.setFullName();
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
		    	 
			     if (category.equals(ActionConstant.SEARCHALL)) {
			    	 sqlCount = new StringBuffer("select count(*) from pibs.file_patient_info where active = true and patientstatusid = 501");	 
			     }else {
			    	 sqlCount = new StringBuffer("select count(*) from pibs.file_patient_info where  (lastname ilike '%"+criteria+"%' or firstname ilike '%"+criteria+"%' or middlename ilike '%"+criteria+"%') and active = true and patientstatusid = 501");	 
			     } 

				StringBuffer sqlCountLog = null;
				if (category.equals(ActionConstant.SEARCHALL)) {
					 sqlCountLog = new StringBuffer("select count(*) from pibs.file_patient_info where active = true and patientstatusid = 501");	 
				}else {
					 sqlCountLog = new StringBuffer("select count(*) from pibs.file_patient_info where  (lastname ilike '%"+criteria+"%' or firstname ilike '%"+criteria+"%' or middlename ilike '%"+criteria+"%') and active = true and patientstatusid = 501");	 
				} 
					
				PIBSUtils.writeLogDebug(logger, "SQL: "+sqlCountLog.toString());
				
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
	     
	    System.out.println("searchPatientForAdmission() - Exit");
		return returnMap;
	}

	@Override
	public Map<String, Object> searchPatientAdmitted(HashMap<String, Object> criteriaMap) throws Exception{
		 
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SEARCH);
		 
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
			 
			  List<Patient> rsList = new ArrayList<Patient>();
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = null;
				 if (category.equals(ActionConstant.SEARCH_ALL_PATIENT_ADMITTED)) {
					 sql = new StringBuffer("select a.id,a.patientid,a.lastname,a.firstname,a.middlename,a.gender,a.birthday,a.address,b.dateofcase,b.caseno,b.id,c.roomno,d.lastname || ', ' || d.firstname || ' ' || d.middlename ");
					 	sql.append(" from pibs.file_patient_info a, pibs.tran_patient_case b, pibs.file_room c, pibs.file_professional d");
					 	sql.append(" where a.id = b.patientsystemid and b.patientcasestatusid=702");
					 	sql.append(" and b.roomid = c.id ");
					 	sql.append(" and b.professionalid = d.id ");
					 	sql.append(" and a.active = true ");
					 	sql.append(" and b.active = true ");
					 	sql.append(" and a.patientstatusid = 502 ");
					 	sql.append(" order by a.lastname,a.firstname ");
					 	sql.append(" limit ? ");
					 	sql.append(" offset ?");		 
				 } else {
					 sql = new StringBuffer("select a.id,a.patientid,a.lastname,a.firstname,a.middlename,a.gender,a.birthday,a.address,b.dateofcase,b.caseno,b.id,c.roomno,d.lastname || ', ' || d.firstname || ' ' || d.middlename ");
					 	sql.append(" from pibs.file_patient_info a, pibs.tran_patient_case b, pibs.file_room c, pibs.file_professional d");
					 	sql.append(" where a.id = b.patientsystemid and b.patientcasestatusid=702");
					 	sql.append(" and (a.lastname ilike '%"+criteria+"%' or a.firstname ilike '%"+criteria+"%' or a.middlename ilike '%"+criteria+"%')" );
					 	sql.append(" and b.roomid = c.id ");
					 	sql.append(" and b.professionalid = d.id ");
					 	sql.append(" and a.active = true ");
					 	sql.append(" and b.active = true ");
					 	sql.append(" and a.patientstatusid = 502 ");
					 	sql.append(" order by a.lastname,a.firstname ");
					 	sql.append(" limit ? ");
					 	sql.append(" offset ?");	
				 }
						 
				PIBSUtils.writeLogDebug(logger, "SQL: "+sql.toString());
					
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, limit);
				 pstmt.setInt(2, offset);
				 
				 rs = pstmt.executeQuery();
				 
				 while(rs.next()) {
					 Patient model=new Patient();  
		    		 model.setId(rs.getInt(1));
		    		 model.setPatientId(rs.getString(2));
		    		 model.setLastName(rs.getString(3));
		    		 model.setFirstName(rs.getString(4));
		    		 model.setMiddleName(rs.getString(5));
		    		 model.setGender(rs.getString(6));
		    		 model.setBirthday(rs.getDate(7));
		    		 model.setAddress(rs.getString(8));
		    		 model.setDateAdmitted(rs.getDate(9));
		    		 model.setCaseNo(rs.getString(10));
		    		 model.setPatientCaseSystemId(rs.getInt(11));
		    		 model.setRoomNo(rs.getString(12));
		    		 model.setDoctor(rs.getString(13));
		    		 model.setFullName();
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
		    	 
			     if (category.equals(ActionConstant.SEARCH_ALL_PATIENT_ADMITTED)) {
			    	 sqlCount = new StringBuffer("select count(*) from pibs.file_patient_info where active = true and patientstatusid = 502");	 
			     }else {
			    	 sqlCount = new StringBuffer("select count(*) from pibs.file_patient_info where  (lastname ilike '%"+criteria+"%' or firstname ilike '%"+criteria+"%' or middlename ilike '%"+criteria+"%') and active = true and patientstatusid = 502");	 
			     } 

				StringBuffer sqlCountLog = null;
				if (category.equals(ActionConstant.SEARCH_ALL_PATIENT_ADMITTED)) {
					 sqlCountLog = new StringBuffer("select count(*) from pibs.file_patient_info where active = true and patientstatusid = 502");	 
				}else {
					 sqlCountLog = new StringBuffer("select count(*) from pibs.file_patient_info where  (lastname ilike '%"+criteria+"%' or firstname ilike '%"+criteria+"%' or middlename ilike '%"+criteria+"%') and active = true and patientstatusid = 502");	 
				} 
					
				PIBSUtils.writeLogDebug(logger, "SQL: "+sqlCountLog.toString());
				
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
	     
	    System.out.println("searchPatientAdmitted() - Exit");
		return returnMap;
	}
	
	@Override
	public Map<String, Object> updateToAdmitted(HashMap<String, Object> dataMap) throws Exception{
		// TODO Auto-generated method stub
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_UPDATE);
		 
		//DBCP JNDI
		Connection conn = (Connection)dataMap.get(MapConstant.JDBC_CONNECTION);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean status = false;
		
		Patient model = (Patient) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update pibs.file_patient_info set ");	
			qry.append(" patientstatusid=? ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");
			
		PIBSUtils.writeLogDebug(logger, "SQL: "+qry.toString());
	
		 try {
			pstmt = conn.prepareStatement(qry.toString());
				     
			pstmt.setInt(1, model.getPatientStatusId());
			pstmt.setInt(2, model.getModifiedBy());
			pstmt.setTimestamp(3, model.getModifiedOn());
			pstmt.setLong(4, model.getId());
				     
			int statusInt = pstmt.executeUpdate();
				     
			if (statusInt == 1) {
				System.out.println("Patient record (id: " +model.getId()+") updated successfully..");
				status = true;	
			}
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			PIBSUtils.closeObjects(rs);
			PIBSUtils.closeObjects(pstmt);
//			PIBSUtils.closeObjects(conn);//do not close conn here
		}
			 		
		returnMap.put(MapConstant.TRANSACTION_STATUS, status);	
		
		return returnMap;
	}

	@Override
	public Map<String, Object> updateToActive(HashMap<String, Object> dataMap) throws Exception{
		// TODO Auto-generated method stub
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_UPDATE);
		 
		//DBCP JNDI
		Connection conn = (Connection) dataMap.get(MapConstant.JDBC_CONNECTION);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean status = false;
		
		Patient model = (Patient) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));

		StringBuffer  qry =  new StringBuffer("update pibs.file_patient_info set ");	
			qry.append(" patientstatusid=? ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");
			
		PIBSUtils.writeLogDebug(logger, "SQL: "+qry.toString());
	
		 try {
			pstmt = conn.prepareStatement(qry.toString());
				     
			pstmt.setInt(1, model.getPatientStatusId());
			pstmt.setInt(2, model.getModifiedBy());
			pstmt.setTimestamp(3, model.getModifiedOn());
			pstmt.setLong(4, model.getId());
				     
			int statusInt = pstmt.executeUpdate();
				     
			if (statusInt == 1) {
				//no commit here
				System.out.println("Patient record (id: " +model.getId()+") set to Active.");
				status = true;
			}
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			PIBSUtils.closeObjects(rs);
			PIBSUtils.closeObjects(pstmt);
//			PIBSUtils.closeObjects(conn);//do not close connection here
		}
			 		
		returnMap.put(MapConstant.TRANSACTION_STATUS, status);	
		
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
			 List<Patient> rsList = new ArrayList<Patient>();
			  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer("select a.id,a.patientid,a.lastname,a.firstname,a.middlename,a.gender,a.birthday,a.dateregistered,a.patientstatusid,b.listvalue,a.contactno,a.address,a.contactperson,a.contactpersonno,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
				 	sql.append(" from pibs.file_patient_info a, pibs.list_value b ");
				 	sql.append(" where a.patientstatusid = b.id ");
				 	sql.append(" and a.active = false ");
				 	sql.append(" order by a.lastname,a.firstname ");
				 	sql.append(" limit ? ");
				 	sql.append(" offset ? ");
			
				 PIBSUtils.writeLogDebug(logger, "SQL: "+sql.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 pstmt.setInt(1, limit);
				 pstmt.setInt(2, offset);
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
					 //get the model criteria
					 Patient model = new Patient();
		    		 model.setId(rs.getInt(1));
		    		 model.setPatientId(rs.getString(2));
		    		 model.setLastName(rs.getString(3));
		    		 model.setFirstName(rs.getString(4));
		    		 model.setMiddleName(rs.getString(5));
		    		 model.setGender(rs.getString(6));
		    		 model.setBirthday(rs.getDate(7));
		    		 model.setDateRegistered(rs.getString(8));
		    		 model.setPatientStatusId(rs.getInt(9));
		    		 model.setStatus(rs.getString(10));
		    		 model.setContactNo(rs.getString(11));
		    		 model.setAddress(rs.getString(12));
		    		 model.setContactPerson(rs.getString(13));
		    		 model.setContactPersonNo(rs.getString(14));
		    		 model.setFullName();
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
		    	 
			    sqlCount = new StringBuffer("select count(*) from pibs.file_patient_info where active = false");	 
	
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
		
		Patient model = (Patient) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update pibs.file_patient_info set ");	
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
				System.out.println("Patient record (id: " +model.getId()+") restored successfully..");
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
	public Map<String, Object> searchForInquiry(HashMap<String, Object> criteriaMap) throws Exception{
		 
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SEARCH);
		 
		 	Map<String, Object> returnMap = null;

		 	//Connection using JNDI DBCP
			 //get the pagination and offset
			 int offset = (int) criteriaMap.get(MapConstant.PAGINATION_OFFSET);
			 int limit = (int) criteriaMap.get(MapConstant.PAGINATION_LIMIT);
			 
			 String category = (String) criteriaMap.get(MapConstant.ACTION);
			 String criteria = (String) criteriaMap.get(MapConstant.SEARCH_CRITERIA);
			 
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
			 
			  List<Patient> rsList = new ArrayList<Patient>();
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = null;

				sql = new StringBuffer("select a.id,a.patientid,a.lastname,a.firstname,a.middlename,a.gender,a.birthday,a.dateregistered,b.listvalue as status,a.contactno,a.address,a.contactperson,a.contactpersonno ");
					sql.append(" ,c.caseno,c.chiefcomplaint,c.dateofcase,c.datedischarged,d.listvalue as admissionstatus,e.roomno, f.lastname || ', ' || f.firstname as dsoctor ");    
					sql.append(" from pibs.file_patient_info a ");
					sql.append(" left join pibs.list_value b on a.patientstatusid = b.id "); 
					sql.append(" left join pibs.tran_patient_case c on a.id = c.patientsystemid ");
					sql.append(" left join pibs.list_value d on c.patientcasestatusid = d.id ");
					sql.append(" left join pibs.file_room e on c.roomid = e.id ");
					sql.append(" left join pibs.file_professional f on c.professionalid = f.id ");
					sql.append(" where a.patientstatusid = b.id ");
					if (category.equals(ActionConstant.SEARCH_ALL_PATIENT_ADMITTED)) {
						sql.append(" and a.patientstatusid = 502 ");	
						sql.append(" and c.patientcasestatusid = 702 ");	
					} else {
						sql.append(" and (a.lastname ilike '%"+criteria+"%' or a.firstname ilike '%"+criteria+"%' or a.middlename ilike '%"+criteria+"%' or e.roomno ilike '%"+criteria+"%')" );
					}
					sql.append(" and a.active = true ");
					sql.append(" and c.active = true ");

					sql.append(" order by a.lastname,a.firstname,c.dateofcase desc ");
					sql.append(" limit ? ");
					sql.append(" offset ?");	

				PIBSUtils.writeLogDebug(logger, "SQL: "+sql.toString());
					
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, limit);
				 pstmt.setInt(2, offset);
				 
				 rs = pstmt.executeQuery();
				 
				 while(rs.next()) {
					 Patient model=new Patient();  
		    		 model.setId(rs.getInt(1));
		    		 model.setPatientId(rs.getString(2));
		    		 model.setLastName(rs.getString(3));
		    		 model.setFirstName(rs.getString(4));
		    		 model.setMiddleName(rs.getString(5));
		    		 model.setGender(rs.getString(6));
		    		 if (rs.getDate(7)!=null) {
			    		 model.setBirthday(rs.getDate(7));
		    		 }
		    		 model.setDateRegistered(rs.getString(8));
		    		 model.setStatus(rs.getString(9));
		    		 model.setContactNo(rs.getString(10));
		    		 model.setAddress(rs.getString(11));
		    		 model.setContactPerson(rs.getString(12));
		    		 model.setContactPersonNo(rs.getString(13));
		    		 model.setCaseNo(rs.getString(14));
		    		 model.setChiefComplaint(rs.getString(15));
		    		 if (rs.getTimestamp(16)!=null) {
			    		 model.setDateAdmitted(DateUtils.getSQLDateFromSQLTimestamp(rs.getTimestamp(16)));
		    		 }
		    		 if (rs.getTimestamp(17)!=null) {
			    		 model.setDateDischarged(DateUtils.getSQLDateFromSQLTimestamp(rs.getTimestamp(17)));		    			 
		    		 }
		    		 model.setAdmissionStatus(rs.getString(18));
		    		 model.setRoomNo(rs.getString(19));
		    		 model.setDoctor(rs.getString(20));
		    		 if (model.getBirthday()!=null) {
		    			 model.setBirthdayStr(DateUtils.sqlDateToString(model.getBirthday()));		    			 
		    		 }
		    		 model.setFullName();
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
		    	 
		    	 sqlCount = new StringBuffer("select count(a.id) ");
		    	 sqlCount.append(" from pibs.file_patient_info a ");
		    	 sqlCount.append(" left join pibs.list_value b on a.patientstatusid = b.id "); 
		    	 sqlCount.append(" left join pibs.tran_patient_case c on a.id = c.patientsystemid ");
		    	 sqlCount.append(" left join pibs.list_value d on c.patientcasestatusid = d.id ");
		    	 sqlCount.append(" left join pibs.file_room e on c.roomid = e.id ");
		    	 sqlCount.append(" left join pibs.file_professional f on c.professionalid = f.id ");
		    	 sqlCount.append(" where a.patientstatusid = b.id ");
				 if (category.equals(ActionConstant.SEARCH_ALL_PATIENT_ADMITTED)) {
					sqlCount.append(" and a.patientstatusid = 502 ");	
					sqlCount.append(" and c.patientcasestatusid = 702 ");	
				 }else {
					sqlCount.append(" and (a.lastname ilike '%"+criteria+"%' or a.firstname ilike '%"+criteria+"%' or a.middlename ilike '%"+criteria+"%' or e.roomno ilike '%"+criteria+"%')" );
				 }
		    	 sqlCount.append(" and a.active = true ");
		    	 sqlCount.append(" and c.active = true ");
		    	 
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
	     
	    System.out.println("searchForInquiry() - Exit");
		return returnMap;
	}
	
	@Override
	public Map<String, Object> getPatientHistory(HashMap<String, Object> criteriaMap) throws Exception{
		 
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SEARCH);
		 
		 	Map<String, Object> returnMap = null;

		    //get the model criteria
		    Patient modelCriteria = (Patient) criteriaMap.get(MapConstant.CLASS_DATA);

		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
			 
			  List<Patient> rsList = new ArrayList<Patient>();
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = null;

				sql = new StringBuffer("select a.caseno,a.chiefcomplaint,a.dateofcase,a.datedischarged,d.lastname || ', ' || d.firstname as doctor ");
					sql.append(" ,f.statementofdiagnosis,f.remarks as diagnosisremarks,f.dateofdiagnosis ");    
					sql.append(" ,g.medicationstatement,g.remarks as medicationstatementremarks,g.dateofstatement ");
					sql.append(" ,h.statementofprognosis,h.remarks as prognosisremarks,h.dateofprognosis "); 
					sql.append(" ,e.lastname,e.firstname,e.middlename, a.ageadmitted ");
					sql.append(" from pibs.tran_patient_case a ");
					sql.append(" left join pibs.file_professional d on a.professionalid=d.id ");
					sql.append(" left join pibs.file_patient_info e on a.patientsystemid = e.id ");
					sql.append(" left join pibs.tran_patient_diagnosis f on a.id = f.patientcasesystemid ");
					sql.append(" left join pibs.tran_patient_medication_statement g on a.id = g.patientcasesystemid " );
					sql.append(" left join pibs.tran_patient_prognosis h on a.id = h.patientcasesystemid ");
					sql.append(" where e.id = ? ");
					sql.append(" and a.active = true ");
					sql.append(" order by a.dateofcase ");

				PIBSUtils.writeLogDebug(logger, "SQL: "+sql.toString());
					
				 pstmt = conn.prepareStatement(sql.toString());

				 pstmt.setInt(1, modelCriteria.getId());
				 
				 rs = pstmt.executeQuery();
				 
				 while(rs.next()) {
					 Patient model=new Patient();  
		    		 model.setCaseNo(rs.getString(1));
		    		 model.setChiefComplaint(rs.getString(2));
		    		 if (rs.getTimestamp(3)!=null) {
			    		 model.setDateAdmitted(DateUtils.getSQLDateFromSQLTimestamp(rs.getTimestamp(3)));
		    		 }
		    		 if (rs.getTimestamp(4)!=null) {
			    		 model.setDateDischarged(DateUtils.getSQLDateFromSQLTimestamp(rs.getTimestamp(4)));		    			 
		    		 }
		    		 model.setDoctor(rs.getString(5));
		    		 model.setDiagnosis(rs.getString(6));
		    		 model.setDiagnosisRemarks(rs.getString(7));
		    		 if (rs.getDate(8)!=null) {
		    			 model.setDateOfDiagnosis(rs.getDate(8));
		    		 }
		    		 model.setMedicationStatement(rs.getString(9));
		    		 model.setMedicationStatementRemarks(rs.getString(10));
		    		 if (rs.getDate(11)!=null) {
			    		 model.setDateOfMedicationStatement(rs.getDate(11)); 
		    		 }
		    		 model.setPrognosis(rs.getString(12));
		    		 model.setPrognosisRemarks(rs.getString(13));
		    		 if (rs.getDate(14)!=null) {
			    		 model.setDateOfPrognosis(rs.getDate(14)); 
		    		 }
		    		 model.setLastName(rs.getString(15));
		    		 model.setFirstName(rs.getString(16));
		    		 model.setMiddleName(rs.getString(17));
		    		 model.setFullName();
		    		 model.setAgeAdmitted(rs.getInt(18));
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
	     
	    System.out.println("getPatientHistory() - Exit");
		return returnMap;
	}

	@Override
	public Map<String, Object> getPatientBillHistory(HashMap<String, Object> criteriaMap) throws Exception{
		 
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SEARCH);
		 
		 	Map<String, Object> returnMap = null;

			 //get the pagination and offset
			 int offset = (int) criteriaMap.get(MapConstant.PAGINATION_OFFSET);
			 int limit = (int) criteriaMap.get(MapConstant.PAGINATION_LIMIT);
			 
		    //get the model criteria
		    Patient modelCriteria = (Patient) criteriaMap.get(MapConstant.CLASS_DATA);

		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
			 
			  List<Patient> rsList = new ArrayList<Patient>();
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = null;

				sql = new StringBuffer("select a.id as patientcasesystemid,a.dateofcase,a.datedischarged ,b.patientid,b.lastname,b.firstname,b.middlename,a.caseno ");
					sql.append(" from pibs.tran_patient_case a ");    
					sql.append(" inner join pibs.file_patient_info b on a.patientsystemid = b.id ");
					sql.append(" where b.id = ? ");
					sql.append(" and a.patientcasestatusid = 703 ");//Discharged
					sql.append(" order by a.dateofcase desc ");
					sql.append(" limit ? ");
					sql.append(" offset ?");

				PIBSUtils.writeLogDebug(logger, "SQL: "+sql.toString());
					
				 pstmt = conn.prepareStatement(sql.toString());

				 pstmt.setInt(1, modelCriteria.getId());
				 pstmt.setInt(2, limit);
				 pstmt.setInt(3, offset);
				 
				 rs = pstmt.executeQuery();
				 
				 while(rs.next()) {
					 Patient model=new Patient();  
					 model.setPatientCaseSystemId(rs.getInt(1));
					 model.setDateAdmitted(rs.getDate(2));
					 model.setDateDischarged(rs.getDate(3));
					 model.setPatientId(rs.getString(4));
		    		 model.setLastName(rs.getString(5));
		    		 model.setFirstName(rs.getString(6));
		    		 model.setMiddleName(rs.getString(7));
		    		 model.setCaseNo(rs.getString(8));
		    		 model.setFullName();
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
		    	 
		    	 sqlCount = new StringBuffer("select count(*) ");
		    	 sqlCount.append(" from pibs.tran_patient_case a ");    
		    	 sqlCount.append(" inner join pibs.file_patient_info b on a.patientsystemid = b.id ");
		    	 sqlCount.append(" where b.id = ? ");
		    	 sqlCount.append(" and a.patientcasestatusid = 703 ");//Discharged
		    	 
				PIBSUtils.writeLogDebug(logger, "SQL: "+sqlCount.toString());
				
		    	 pstmt = conn.prepareStatement(sqlCount.toString());
		    	 
		    	 pstmt.setInt(1, modelCriteria.getId());
		    	 
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
	     
	    System.out.println("getPatientBillHistory() - Exit");
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
			 
			 List<Patient> rsList = new ArrayList<>();
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = null;
				 		
				 sql = new StringBuffer("select a.id,a.patientid,a.lastname,a.firstname,a.middleName,a.gender,a.birthday,a.contactno,a.address,a.contactperson,a.contactpersonno,a.dateregistered,b.listvalue as status,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
				 	sql.append(" from pibs.file_patient_info a, pibs.list_value b ");
				 	sql.append(" where a.patientstatusid = b.id ");
				 	sql.append(" and a.active = true ");
			    	if (MiscConstant.LOV_PATIENT_REPORT_SEARCH_CRITERIA_PATIENT_NO == searchCriteria) {
			    		sql.append(" and a.patientid ilike '%"+searchValue+"%' ");
			    	}
			    	if (MiscConstant.LOV_PATIENT_REPORT_SEARCH_CRITERIA_LAST_NAME == searchCriteria) {
			    		sql.append(" and a.lastname ilike '%"+searchValue+"%' ");
			    	}
			    	if (MiscConstant.LOV_PATIENT_REPORT_SEARCH_CRITERIA_FIRST_NAME == searchCriteria) {
			    		sql.append(" and a.firstname ilike '%"+searchValue+"%' ");
			    	}
			    	if (MiscConstant.LOV_PATIENT_REPORT_SEARCH_CRITERIA_ADDRESS == searchCriteria) {
			    		sql.append(" and a.address ilike '%"+searchValue+"%' ");
			    	}
			    	if (MiscConstant.LOV_PATIENT_REPORT_SEARCH_CRITERIA_STATUS == searchCriteria) {
			    		sql.append(" and b.listvalue ilike '%"+searchValue+"%'");
			    	}
			    	else if (MiscConstant.LOV_PATIENT_REPORT_SEARCH_CRITERIA_DATE_REGISTERED == searchCriteria) {
				 		sql.append(" and to_date(a.dateregistered,'MM/DD/YYYY') between '"+DateUtils.sqlDateToStringSQL(DateUtils.strToSQLDate(dateFromValue))+"' and '"+DateUtils.sqlDateToStringSQL(DateUtils.strToSQLDate(dateToValue))+"'");
				 	}
				 	sql.append(" order by a.lastname ");
						
						 
				PIBSUtils.writeLogDebug(logger, "SQL: "+sql.toString());
					
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 rs = pstmt.executeQuery();
				 
				 while(rs.next()) {
					 Patient model=new Patient();  
		    		 model.setId(rs.getInt(1));
		    		 model.setPatientId(rs.getString(2));
		    		 model.setLastName(rs.getString(3));
		    		 model.setFirstName(rs.getString(4));
		    		 model.setMiddleName(rs.getString(5));
		    		 model.setGender(rs.getString(6));
		    		 model.setBirthday(rs.getDate(7));
		    		 model.setContactNo(rs.getString(8));
		    		 model.setAddress(rs.getString(9));
		    		 model.setContactPerson(rs.getString(10));
		    		 model.setContactPersonNo(rs.getString(11));
		    		 model.setDateRegistered(rs.getString(12));
		    		 model.setStatus(rs.getString(13));
		    		 if (model.getBirthday()!=null) {
		    			 model.setBirthdayStr(DateUtils.sqlDateToString(model.getBirthday()));		    			 
		    		 }
		    		 model.setFullName();
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
