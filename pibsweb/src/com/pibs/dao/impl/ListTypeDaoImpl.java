package com.pibs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pibs.config.ServerContext;
import com.pibs.constant.MapConstant;
import com.pibs.constant.MiscConstant;
import com.pibs.dao.ListTypeDao;
import com.pibs.model.ListType;
import com.pibs.util.PIBSUtils;

public class ListTypeDaoImpl implements ListTypeDao {

	private final static Logger logger = Logger.getLogger(ListTypeDaoImpl.class);
	
	@Override
	public Map<String, Object> getAllListType() throws Exception {
		// TODO Auto-generated method stub
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_GET_ACTIVE_DATA);
		 
		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;
			 PreparedStatement pstmt = null;
			 Map<String, Object> returnMap = null;
		     
		     List<ListType> rsList = new ArrayList<ListType>();
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();				
					 sql.append("select a.id,a.listtype,a.description ");
					 sql.append("from pibs.list_type a ");
					 sql.append("where a.active  = true ");
					 sql.append("order by a.id ");
					 
				 StringBuffer sqlLog = new StringBuffer();				
				 	sqlLog.append("select a.id,a.listtype,a.description ");
				 	sqlLog.append("from pibs.list_type a ");
				 	sqlLog.append("where a.active  = true ");
				 	sqlLog.append("order by a.id ");
			
				 	PIBSUtils.writeLogDebug(logger, "SQL: "+sqlLog.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
					 ListType  rowModel = new ListType();
					 rowModel.setId(rs.getInt(1));
					 rowModel.setListType(rs.getString(2));
					 rowModel.setDescription(rs.getString(3));
		    		 rsList.add(rowModel);
				 }				 
			 } catch (SQLException e) {
				 throw e;
			 } finally {
				 PIBSUtils.closeObjects(rs);
				 PIBSUtils.closeObjects(pstmt);
				 PIBSUtils.closeObjects(conn);
			 }	 
		 		     	     
		     if (rsList!=null) {
		    	 returnMap = new HashMap<String, Object>();
		    	 returnMap.put(MapConstant.CLASS_LIST, rsList);
		     } 
		     
	    System.out.println("getAllListType() - Exit");
		return returnMap;
	}

}
