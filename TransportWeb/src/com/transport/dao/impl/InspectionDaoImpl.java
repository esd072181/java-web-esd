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
import com.transport.dao.InspectionDao;
import com.transport.model.Inspection;
import com.transport.util.TransportUtils;

/**
 * 
 * @author edwarddavid
 * @since 21Mar2020
 */
public class InspectionDaoImpl implements InspectionDao {
	
	private final static Logger logger = Logger.getLogger(InspectionDaoImpl.class);

	@Override
	public Map<String, Object> getActiveData() throws Exception {
		// TODO Auto-generated method stub
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_GET_ACTIVE_DATA);
		 
		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
		     Map<String, Object> returnMap = null;
			 List<Inspection> rsList = new ArrayList<>();
			  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();				
				 	sql.append("select a.id,b.listvalue as maincategoryname,c.listvalue as categoryname,a.categoryno, ");
				 	sql.append("a.itemno,a.subitemno,a.description,a.labelonly,a.sequenceorder ");
				 	sql.append("from transport.file_inspection a, transport.list_value b, transport.list_value c ");
				 	sql.append("where a.maincategoryid = b.id ");
				 	sql.append("and a.categoryid = c.id ");
				 	sql.append("and a.active = true ");
				 	sql.append("order by a.categoryno, a.sequenceorder ");
			
				 TransportUtils.writeLogDebug(logger, "SQL: "+sql.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 rs = pstmt.executeQuery();
				  
				 while(rs.next()) {
					 //get the model and to the list
					 Inspection model = new Inspection();
		    		 model.setId(rs.getInt(1));
		    		 model.setMainCategoryName(rs.getString(2));
		    		 model.setCategoryName(rs.getString(3));
		    		 model.setCategoryNo(rs.getInt(4));
		    		 model.setItemNo(rs.getString(5));
		    		 model.setSubItemNo(rs.getString(6));
		    		 model.setDescription(rs.getString(7));
		    		 model.setLabelOnly(rs.getBoolean(8));
		    		 model.setSequenceOrder(rs.getInt(9));
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

}
