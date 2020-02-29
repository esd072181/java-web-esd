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
import com.pibs.dao.MonitorPhysicalExaminationDao;
import com.pibs.model.MonitorPhysicalExamination;
import com.pibs.model.User;
import com.pibs.util.PIBSUtils;

public class MonitorPhysicalExaminationDaoImpl implements MonitorPhysicalExaminationDao {
	
	private final static Logger logger = Logger.getLogger(MonitorPhysicalExaminationDaoImpl.class);

	@Override
	public Map<String, Object> save(HashMap<String, Object> dataMap) throws Exception{
		
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SAVE);
		
		//DBCP JNDI
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean status = false;
		
		MonitorPhysicalExamination model = (MonitorPhysicalExamination) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setCreatedBy((int) user.getId());	
		}
		model.setCreatedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("insert into pibs.tran_patient_physical_examination (");  		
				qry.append("patientcasesystemid ");
				qry.append(",bp ");
				qry.append(",temp ");
		  		qry.append(",cr ");
		  		qry.append(",rr ");
		  		qry.append(",weight ");
		  		qry.append(",heent ");
		  		qry.append(",chest ");
		  		qry.append(",heart ");
		  		qry.append(",abdomen ");
		  		qry.append(",extrimities ");
		  		qry.append(",skin ");
		  		qry.append(",remarks ");
		  		qry.append(",daterecorded ");
		  		qry.append(",timerecorded ");
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
		  		qry.append(" ,1 ");
		  		qry.append(" ,true ");
		  		qry.append(" ) ");
					
		PIBSUtils.writeLogDebug(logger, "SQL: "+qry.toString());
  		  		
		  try {
			  conn = ServerContext.getJDBCHandle();
			  conn.setAutoCommit(false);
			  pstmt = conn.prepareStatement(qry.toString());
			     
			  pstmt.setInt(1, model.getPatientCaseSystemId());
			  pstmt.setString(2, model.getBp());
			  pstmt.setString(3, model.getTemp());
			  pstmt.setString(4, model.getCr());
			  pstmt.setString(5, model.getRr());			  
			  pstmt.setString(6, model.getWeight());
			  pstmt.setString(7, model.getHeent());
			  pstmt.setString(8, model.getChest());
			  pstmt.setString(9, model.getHeart());
			  pstmt.setString(10, model.getAbdomen());
			  pstmt.setString(11, model.getExtrimities());
			  pstmt.setString(12, model.getSkin());
			  pstmt.setString(13, model.getRemarks());
			  pstmt.setDate(14, model.getDateRecorded());
			  pstmt.setString(15, model.getTimeRecorded());
			  pstmt.setInt(16, model.getCreatedBy());
			  pstmt.setTimestamp(17, model.getCreatedOn());
			     
			  int statusInt = pstmt.executeUpdate();
			     
			  if (statusInt == 1) {
				  conn.commit();
				  System.out.println("Inserted into Monitor PhysicalExamination is table successfully..");
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
		
		MonitorPhysicalExamination model = (MonitorPhysicalExamination) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update pibs.tran_patient_physical_examination set ");	
			qry.append(" bp=? ");
			qry.append(" ,temp=? ");
			qry.append(" ,cr=? ");
			qry.append(" ,rr=? ");
			qry.append(" ,weight=? ");
			qry.append(" ,heent=? ");
			qry.append(" ,chest=? ");
			qry.append(" ,heart=? ");
			qry.append(" ,abdomen=? ");
			qry.append(" ,extrimities=? ");
			qry.append(" ,skin=? ");
			qry.append(" ,remarks=? ");
			qry.append(" ,daterecorded=? ");
			qry.append(" ,timerecorded=? ");
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
			
			pstmt.setString(1, model.getBp());
			pstmt.setString(2, model.getTemp());
			pstmt.setString(3, model.getCr());
			pstmt.setString(4, model.getRr());
			pstmt.setString(5, model.getWeight());
			pstmt.setString(6, model.getHeent());
			pstmt.setString(7, model.getChest());
			pstmt.setString(8, model.getHeart());
			pstmt.setString(9, model.getAbdomen());
			pstmt.setString(10, model.getExtrimities());
			pstmt.setString(11, model.getSkin());
			pstmt.setString(12, model.getRemarks());	
			pstmt.setDate(13, model.getDateRecorded());
			pstmt.setString(14, model.getTimeRecorded());
			pstmt.setInt(15, model.getModifiedBy());
			pstmt.setTimestamp(16, model.getModifiedOn());
			pstmt.setLong(17, model.getId());
				     
			int statusInt = pstmt.executeUpdate();
				     
			if (statusInt == 1) {
				conn.commit();
				System.out.println("Monitor PhysicalExamination record (id: " +model.getId()+") updated successfully..");
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

		 	MonitorPhysicalExamination modelCriteria = (MonitorPhysicalExamination) criteriaMap.get(MapConstant.CLASS_DATA);
		 	
		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
			 
			 List<MonitorPhysicalExamination> rsList = new ArrayList<MonitorPhysicalExamination>();
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();
				 		sql.append("select id,patientcasesystemid,bp,temp,cr,rr,weight,heent,chest,heart,abdomen,extrimities,skin,remarks,daterecorded,timerecorded ");
				 		sql.append(" from pibs.tran_patient_physical_examination  ");
				 		sql.append(" where patientcasesystemid = ? ");
				 		sql.append(" and active = true ");
					 	sql.append(" order by daterecorded ");
				 						 
				PIBSUtils.writeLogDebug(logger, "SQL: "+sql.toString());
					
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, modelCriteria.getPatientCaseSystemId());
				 
				 rs = pstmt.executeQuery();
				 
				 while(rs.next()) {
					 MonitorPhysicalExamination model = new MonitorPhysicalExamination();  
		    		 model.setId(rs.getInt(1));
		    		 model.setPatientCaseSystemId(rs.getInt(2));
		    		 model.setBp(rs.getString(3));
		    		 model.setTemp(rs.getString(4));
		    		 model.setCr(rs.getString(5));
		    		 model.setRr(rs.getString(6));
		    		 model.setWeight(rs.getString(7));
		    		 model.setHeent(rs.getString(8));
		    		 model.setChest(rs.getString(9));
		    		 model.setHeart(rs.getString(10));
		    		 model.setAbdomen(rs.getString(11));
		    		 model.setExtrimities(rs.getString(12));
		    		 model.setSkin(rs.getString(13));
		    		 model.setRemarks(rs.getString(14));
		    		 model.setDateRecorded(rs.getDate(15));
		    		 model.setTimeRecorded(rs.getString(16));
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
	public Map<String, Object> getDataById(HashMap<String, Object> criteriaMap)
			throws Exception {
		// TODO Auto-generated method stub
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_GETDATA_BY_ID);
		 
		    //get the model criteria
		    MonitorPhysicalExamination model = (MonitorPhysicalExamination) criteriaMap.get(MapConstant.CLASS_DATA);

		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
		     Map<String, Object> returnMap = null;
					  
			 try {
				 conn = ServerContext.getJDBCHandle();
			
				 StringBuffer sql = new StringBuffer();
			 		sql.append("select id,patientcasesystemid,bp,temp,cr,rr,weight,heent,chest,heart,abdomen,extrimities,skin,remarks,daterecorded,timerecorded ");
			 		sql.append(" from pibs.tran_patient_physical_examination  ");
				 	sql.append("where id = ?");
			
				 PIBSUtils.writeLogDebug(logger, "SQL: "+sql.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, model.getId());
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
		    		 model.setId(rs.getInt(1));
		    		 model.setPatientCaseSystemId(rs.getInt(2));
		    		 model.setBp(rs.getString(3));
		    		 model.setTemp(rs.getString(4));
		    		 model.setCr(rs.getString(5));
		    		 model.setRr(rs.getString(6));
		    		 model.setWeight(rs.getString(7));
		    		 model.setHeent(rs.getString(8));
		    		 model.setChest(rs.getString(9));
		    		 model.setHeart(rs.getString(10));
		    		 model.setAbdomen(rs.getString(11));
		    		 model.setExtrimities(rs.getString(12));
		    		 model.setSkin(rs.getString(13));
		    		 model.setRemarks(rs.getString(14));
		    		 model.setDateRecorded(rs.getDate(15));
		    		 model.setTimeRecorded(rs.getString(16));
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
		
		MonitorPhysicalExamination model = (MonitorPhysicalExamination) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update pibs.tran_patient_physical_examination set ");	
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
				System.out.println("Monitor PhysicalExamination record (id: " +model.getId()+") deleted successfully..");
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
	
	

}
