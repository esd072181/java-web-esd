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
import com.pibs.dao.PrognosisDao;
import com.pibs.model.Prognosis;
import com.pibs.model.User;
import com.pibs.util.PIBSUtils;

public class PrognosisDaoImpl implements PrognosisDao {
	
	private final static Logger logger = Logger.getLogger(PrognosisDaoImpl.class);

	@Override
	public Map<String, Object> save(HashMap<String, Object> dataMap) throws Exception{
		
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SAVE);
		
		//DBCP JNDI
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean status = false;
		
		Prognosis model = (Prognosis) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setCreatedBy((int) user.getId());	
		}
		model.setCreatedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("insert into pibs.tran_patient_prognosis (");  		
				qry.append("patientcasesystemid ");
				qry.append(",statementofprognosis ");
		  		qry.append(",remarks ");
		  		qry.append(",dateofprognosis ");
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
		  		qry.append(" ,1 ");
		  		qry.append(" ,true ");
		  		qry.append(" ) ");
					
		PIBSUtils.writeLogDebug(logger, "SQL: "+qry.toString());
  		  		
		  try {
			  conn = ServerContext.getJDBCHandle();
			  conn.setAutoCommit(false);
			  pstmt = conn.prepareStatement(qry.toString());
			     
			  pstmt.setInt(1, model.getPatientCaseSystemId());
			  pstmt.setString(2, model.getStatementOfPrognosis());
			  pstmt.setString(3, model.getRemarks());
			  pstmt.setDate(4, model.getDateOfPrognosis());
			  pstmt.setInt(5, model.getCreatedBy());
			  pstmt.setTimestamp(6, model.getCreatedOn());
			     
			  int statusInt = pstmt.executeUpdate();
			     
			  if (statusInt == 1) {
				  conn.commit();
				  System.out.println("Inserted into Prognosis table successfully..");
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
		
		Prognosis model = (Prognosis) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update pibs.tran_patient_prognosis set ");	
			qry.append(" statementofprognosis=? ");
			qry.append(" ,remarks=? ");
			qry.append(" ,dateofprognosis=? ");
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
				     
			pstmt.setString(1, model.getStatementOfPrognosis());
			pstmt.setString(2, model.getRemarks());
			pstmt.setDate(3, model.getDateOfPrognosis());
			pstmt.setInt(4, model.getModifiedBy());
			pstmt.setTimestamp(5, model.getModifiedOn());
			pstmt.setLong(6, model.getId());
				     
			int statusInt = pstmt.executeUpdate();
				     
			if (statusInt == 1) {
				conn.commit();
				System.out.println("Prognosis record (id: " +model.getId()+") updated successfully..");
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
	public Map<String, Object> getDataById(HashMap<String, Object> criteriaMap)
			throws Exception {
		// TODO Auto-generated method stub
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_GETDATA_BY_ID);
		 
		    //get the model criteria
		    Prognosis model = (Prognosis) criteriaMap.get(MapConstant.CLASS_DATA);

		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
		     Map<String, Object> returnMap = null;
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();				
				 	sql.append("select id,statementofprognosis,remarks,dateofprognosis,createdby,createdon,modifiedby,modifiedon,version,active ");
				 	sql.append("from pibs.tran_patient_prognosis ");
				 	sql.append("where patientcasesystemid = ?");
			
				 PIBSUtils.writeLogDebug(logger, "SQL: "+sql.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, model.getPatientCaseSystemId());
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
		    		 model.setId(rs.getInt(1));
		    		 model.setStatementOfPrognosis(rs.getString(2));
		    		 model.setRemarks(rs.getString(3));
		    		 model.setDateOfPrognosis(rs.getDate(4));
				 }				 
			 } catch (SQLException e) {
				 throw e;
			 } finally {
				 PIBSUtils.closeObjects(rs);
				 PIBSUtils.closeObjects(pstmt);
				 PIBSUtils.closeObjects(conn);
			 }	 
		 		     
		     if (model!=null && model.getId() > 0) {
		    	 returnMap = new HashMap<String, Object>();
		    	 returnMap.put(MapConstant.CLASS_DATA, model);
		     } 
	     
	    System.out.println("getDataById() - Exit");
		return returnMap;
	}
	


}
