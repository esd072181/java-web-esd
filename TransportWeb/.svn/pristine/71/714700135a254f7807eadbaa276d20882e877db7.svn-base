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
import com.transport.dao.ListValueDao;
import com.transport.model.ListValue;
import com.transport.util.TransportUtils;

public class ListValueDaoImpl implements ListValueDao {
	
	private final static Logger logger = Logger.getLogger(ListValueDaoImpl.class);

	@Override
	public Map<String, Object> getDataByListType(
			HashMap<String, Object> criteriaMap) throws Exception {
		// TODO Auto-generated method stub
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_GET_DATA_BY_LIST_TYPE);
		 
		    //get the model criteria
			ListValue model = (ListValue) criteriaMap.get(MapConstant.CLASS_DATA);

		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
		     Map<String, Object> returnMap = null;
		     
		     List<ListValue> rsList = new ArrayList<ListValue>();
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();				
					 sql.append("select a.id,a.listvalue, a.description ");
					 sql.append("from transport.list_value a, transport.list_type b ");
					 sql.append("where a.listtypeid = b.id ");
					 sql.append("and b.id = ? ");
					 sql.append("and a.active  = true ");
					 sql.append("order by a.sequenceorder ");
					 
				 StringBuffer sqlLog = new StringBuffer();				
					 sqlLog.append("select a.id,a.listvalue, a.description ");
					 sqlLog.append("from transport.list_value a, transport.list_type b ");
				 	 sqlLog.append("where a.listtypeid = b.id ");
				     sqlLog.append("and b.id = ? ");
				 	 sqlLog.append("and a.active  = true ");
				 	 sqlLog.append("order by a.sequenceorder ");
			
				 TransportUtils.writeLogDebug(logger, "SQL: "+sqlLog.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, model.getListTypeId());
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
					 ListValue  rowModel = new ListValue();
					 rowModel.setId(rs.getInt(1));
					 rowModel.setListValue(rs.getString(2));
					 rowModel.setDescription(rs.getString(3));
		    		 rsList.add(rowModel);
				 }				 
			 } catch (SQLException e) {
				 throw e;
			 } finally {
				 TransportUtils.closeObjects(rs);
				 TransportUtils.closeObjects(pstmt);
				 TransportUtils.closeObjects(conn);
			 }	 
		 		     
		     if (rsList!=null) {
		    	 returnMap = new HashMap<String, Object>();
		    	 returnMap.put(MapConstant.CLASS_DATA, rsList);
		     } 
	     
	    System.out.println("getDataByListType() - Exit");
		return returnMap;
	}

}
