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
import com.pibs.dao.BillingDetailsDao;
import com.pibs.dao.BillingDetailsDao;
import com.pibs.model.BillingDetails;
import com.pibs.model.User;
import com.pibs.util.PIBSUtils;

public class BillingDetailsDaoImpl implements BillingDetailsDao {
	
	private final static Logger logger = Logger.getLogger(BillingDetailsDaoImpl.class);

	
	@Override
	public Map<String, Object> search(HashMap<String, Object> criteriaMap) throws Exception{
		 
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SEARCH);
		 
		 	Map<String, Object> returnMap = null;

		 	BillingDetails modelCriteria = (BillingDetails) criteriaMap.get(MapConstant.CLASS_DATA);
		 	
		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
			 
			 List<BillingDetails> rsList = new ArrayList<BillingDetails>();
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();
				 		sql.append("select a.id,a.patientcasesystemid,a.discountid,a.amount,b.description ");
				 		sql.append(" from pibs.tran_patient_discount a, pibs.file_discount b ");
					 	sql.append(" where a.discountid = b.id ");
				 		sql.append(" and a.patientcasesystemid = ? ");
				 		sql.append(" and a.active = true ");
					 	sql.append(" order by b.description ");
				 						 
				PIBSUtils.writeLogDebug(logger, "SQL: "+sql.toString());
					
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, modelCriteria.getPatientCaseSystemId());
				 
				 rs = pstmt.executeQuery();
				 
				 while(rs.next()) {
					 BillingDetails model = new BillingDetails();  
		    		 model.setId(rs.getInt(1));
		    		 model.setPatientCaseSystemId(rs.getInt(2));
//		    		 model.setDetailsId(rs.getInt(3));
//		    		 model.setAmount(rs.getBigDecimal(4));
//		    		 model.setDetailsDescription(rs.getString(5));
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


	

}
