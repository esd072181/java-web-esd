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
import com.pibs.dao.RoomDao;
import com.pibs.model.Room;
import com.pibs.model.User;
import com.pibs.util.PIBSUtils;

public class RoomDaoImpl implements RoomDao {

	private final static Logger logger = Logger.getLogger(RoomCategoryDaoImpl.class);

	@Override
	public Map<String, Object> save(HashMap<String, Object> dataMap) throws Exception{
		
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SAVE);
		
		//DBCP JNDI
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean status = false;
		
		Room model = (Room) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setCreatedBy((int) user.getId());	
		}
		model.setCreatedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("insert into pibs.file_room (");
				qry.append("roomno ");
				qry.append(",roomcategoryid ");
				qry.append(",buildingid ");
				qry.append(",floorno ");
				qry.append(",noofbeds ");
				qry.append(",availablebeds ");
		  		qry.append(",description ");
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
		  		qry.append(" ,1 ");
		  		qry.append(" ,true ");
		  		qry.append(" ) ");

		StringBuffer qryLog =  new StringBuffer("insert into pibs.file_room (");
				qryLog.append("roomno ");
				qryLog.append(",roomcategoryid ");
				qryLog.append(",buildingid ");
				qryLog.append(",floorno ");
				qryLog.append(",noofbeds ");
				qryLog.append(",availablebeds ");
				qryLog.append(",description ");
				qryLog.append(",createdby ");
				qryLog.append(",createdon ");
				qryLog.append(",version ");
				qryLog.append(",active ");
				qryLog.append(" ) ");
				qryLog.append(" values ");
				qryLog.append(" ( ");
				qryLog.append(model.getRoomNo());
				qryLog.append(" ,"+model.getRoomCategoryId());
				qryLog.append(" ,"+model.getBuildingId());
				qryLog.append(" ,"+model.getFloorNo());
				qryLog.append(" ,"+model.getNoOfBeds());
				qryLog.append(" ,"+model.getNoOfBeds());//available beds same as no of beds
				qryLog.append(" ,"+model.getDescription());
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
			     
			  pstmt.setString(1, model.getRoomNo());
			  pstmt.setInt(2, model.getRoomCategoryId());
			  pstmt.setInt(3, model.getBuildingId());
			  pstmt.setInt(4, model.getFloorNo());
			  pstmt.setInt(5, model.getNoOfBeds());
			  pstmt.setInt(6, model.getNoOfBeds());//available beds same as no of beds
			  pstmt.setString(7, model.getDescription());
			  pstmt.setInt(8, model.getCreatedBy());
			  pstmt.setTimestamp(9, model.getCreatedOn());
			     
			  int statusInt = pstmt.executeUpdate();
			     
			  if (statusInt == 1) {
				  conn.commit();
				  System.out.println("Inserted into Room table successfully..");
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
		
		Room model = (Room) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update pibs.file_room set ");	
			qry.append(" roomno=? ");
			qry.append(" ,roomcategoryid=? ");
			qry.append(" ,buildingid=? ");
			qry.append(" ,floorno=? ");
			qry.append(" ,noofbeds=? ");
			qry.append(" ,availablebeds=? ");
			qry.append(" ,description=? ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");

		StringBuffer qryLog =  new StringBuffer("update pibs.file_room set ");	
			qryLog.append(" roomno=? ");
			qryLog.append(" ,roomcategoryid=? ");
			qryLog.append(" ,buildingid=? ");
			qryLog.append(" ,floorno=? ");
			qryLog.append(" ,noofbeds=? ");
			qryLog.append(" ,availablebeds=? ");
			qryLog.append(" ,description=? ");
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
				     
			pstmt.setString(1, model.getRoomNo());
			pstmt.setInt(2, model.getRoomCategoryId());
			pstmt.setInt(3, model.getBuildingId());
			pstmt.setInt(4, model.getFloorNo());
			pstmt.setInt(5, model.getNoOfBeds());
			pstmt.setInt(6, model.getAvailableBeds());
			pstmt.setString(7, model.getDescription());
			pstmt.setInt(8, model.getModifiedBy());
			pstmt.setTimestamp(9, model.getModifiedOn());
			pstmt.setLong(10, model.getId());
				     
			int statusInt = pstmt.executeUpdate();
				     
			if (statusInt == 1) {
				conn.commit();
				System.out.println("Room record (id: " +model.getId()+") updated successfully..");
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
		
		Room model = (Room) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update pibs.file_room set ");	
			qry.append(" active=false ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");

		StringBuffer qryLog =  new StringBuffer("update pibs.file_room set ");	
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
				System.out.println("Room record (id: " +model.getId()+") deleted successfully..");
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
			 
			  List<Room> rsList = new ArrayList<Room>();
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = null;
				 if (category.equals(ActionConstant.SEARCHALL)) {
					 sql = new StringBuffer("select a.id,a.roomno,a.roomcategoryid,a.buildingid,a.floorno,a.noofbeds,a.description,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
					 	sql.append(" ,b.description,c.description,b.rate,a.availablebeds ");//for RoomCategory and Building Description
					 	sql.append(" from pibs.file_room a");
					 	sql.append(" inner join pibs.file_room_category b on a.roomcategoryid = b.id ");
					 	sql.append(" inner join pibs.file_building c on a.buildingid = c.id ");
					 	sql.append(" where a.active = true ");
					 	sql.append(" order by a.roomno ");
					 	sql.append(" limit ? ");
					 	sql.append(" offset ?");		 
				 } else {
					 sql = new StringBuffer("select a.id,a.roomno,a.roomcategoryid,a.buildingid,a.floorno,a.noofbeds,a.description,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
					 	sql.append(" ,b.description,c.description,b.rate,a.availablebeds ");//for RoomCategory and Building Description
					 	sql.append(" from pibs.file_room a");
					 	sql.append(" inner join pibs.file_room_category b on a.roomcategoryid = b.id ");
					 	sql.append(" inner join pibs.file_building c on a.buildingid = c.id ");
					 	sql.append(" where ");
					 	sql.append(" (a.roomno ilike '%"+criteria+"%' or a.description ilike '%"+criteria+"%')" );
					 	sql.append(" and a.active = true ");
					 	sql.append(" order by a.roomno ");
					 	sql.append(" limit ? ");
					 	sql.append(" offset ?");	
				 }
	 
				PIBSUtils.writeLogDebug(logger, "SQL: "+sql.toString());
					
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, limit);
				 pstmt.setInt(2, offset);
				 
				 rs = pstmt.executeQuery();
				 
				 while(rs.next()) {
					 Room model=new Room();  
		    		 model.setId(rs.getInt(1));
		    		 model.setRoomNo(rs.getString(2));
		    		 model.setRoomCategoryId(rs.getInt(3));
		    		 model.setBuildingId(rs.getInt(4));
		    		 model.setFloorNo(rs.getInt(5));
		    		 model.setNoOfBeds(rs.getInt(6));
		    		 model.setDescription(rs.getString(7));
		    		 model.setRoomCategory(rs.getString(14));
		    		 model.setBuilding(rs.getString(15));
		    		 model.setRate(rs.getBigDecimal(16));
		    		 model.setAvailableBeds(rs.getInt(17));
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
			    	 sqlCount = new StringBuffer("select count(*) from pibs.file_room where active = true");	 
			     }else {
			    	 sqlCount = new StringBuffer("select count(*) from pibs.file_room where  (roomno ilike '%"+criteria+"%' or description ilike '%"+criteria+"%') and active = true");	 
			     } 
					
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
	     
	    System.out.println("searchAll() - Exit");
		return returnMap;
	}

	@Override
	public Map<String, Object> getDataById(HashMap<String, Object> criteriaMap)
			throws Exception {
		// TODO Auto-generated method stub
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_GETDATA_BY_ID);
		 
		    //get the model criteria
		    Room model = (Room) criteriaMap.get(MapConstant.CLASS_DATA);

		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
		     Map<String, Object> returnMap = null;
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();				
				 	sql.append("select a.id,a.roomno,a.roomcategoryid,a.buildingid,a.floorno,a.noofbeds,a.availablebeds,a.description,b.description as roomcategory,b.rate,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
				 	sql.append("from pibs.file_room a, pibs.file_room_category b ");
				 	sql.append("where a.roomcategoryid = b.id ");
				 	sql.append("and a.id = ?");

				 StringBuffer sqlLog = new StringBuffer();				
				 	sqlLog.append("select a.id,a.roomno,a.roomcategoryid,a.buildingid,a.floorno,a.noofbeds,a.availablebeds,a.description,b.description as roomcategory,b.rate,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
				 	sqlLog.append("from pibs.file_room a, pibs.file_room_category b ");
				 	sqlLog.append("where a.roomcategoryid = b.id ");
				 	sqlLog.append("where a.id = "+ model.getId());
			
				 PIBSUtils.writeLogDebug(logger, "SQL: "+sqlLog.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, model.getId());
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
		    		 model.setRoomNo(rs.getString(2));
		    		 model.setRoomCategoryId(rs.getInt(3));
		    		 model.setBuildingId(rs.getInt(4));
		    		 model.setFloorNo(rs.getInt(5));
		    		 model.setNoOfBeds(rs.getInt(6));
		    		 model.setAvailableBeds(rs.getInt(7));
		    		 model.setDescription(rs.getString(8));
		    		 model.setRoomCategory(rs.getString(9));
		    		 model.setRate(rs.getBigDecimal(10));
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
			 List<Room> rsList = new ArrayList<Room>();
			  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();				
				 sql = new StringBuffer("select a.id,a.roomno,a.roomcategoryid,a.buildingid,a.floorno,a.noofbeds,a.description,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
				 	sql.append(" ,b.description,c.description,b.rate,a.availablebeds ");//for RoomCategory and Building Description
				 	sql.append(" from pibs.file_room a");
				 	sql.append(" inner join pibs.file_room_category b on a.roomcategoryid = b.id ");
				 	sql.append(" inner join pibs.file_building c on a.buildingid = c.id ");
				 	sql.append(" where a.active = true ");
				 	sql.append(" order by a.roomno,a.roomcategoryid ");

				 PIBSUtils.writeLogDebug(logger, "SQL: "+sql.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
						 Room model=new Room();  
			    		 model.setId(rs.getInt(1));
			    		 model.setRoomNo(rs.getString(2));
			    		 model.setRoomCategoryId(rs.getInt(3));
			    		 model.setBuildingId(rs.getInt(4));
			    		 model.setFloorNo(rs.getInt(5));
			    		 model.setNoOfBeds(rs.getInt(6));
			    		 model.setDescription(rs.getString(7));
			    		 model.setRoomCategory(rs.getString(14));
			    		 model.setBuilding(rs.getString(15));
			    		 model.setRate(rs.getBigDecimal(16));
			    		 model.setAvailableBeds(rs.getInt(17));
			    		 model.setRoomFullName();
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

	@Override
	public Map<String, Object> getAvailableRooms() throws Exception {
		// TODO Auto-generated method stub
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_GET_ACTIVE_DATA);
		 
		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
		     Map<String, Object> returnMap = null;
			 List<Room> rsList = new ArrayList<Room>();
			  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();				
				 sql = new StringBuffer("select a.id,a.roomno,a.roomcategoryid,a.buildingid,a.floorno,a.noofbeds,a.description,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
				 	sql.append(" ,b.description,c.description,b.rate,a.availablebeds ");
				 	sql.append(" from pibs.file_room a");
				 	sql.append(" inner join pibs.file_room_category b on a.roomcategoryid = b.id ");
				 	sql.append(" inner join pibs.file_building c on a.buildingid = c.id ");
				 	sql.append(" where a.active = true ");
				 	sql.append(" and a.availablebeds > 0 ");
				 	sql.append(" order by a.roomno,a.roomcategoryid ");

				 PIBSUtils.writeLogDebug(logger, "SQL: "+sql.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
						 Room model=new Room();  
			    		 model.setId(rs.getInt(1));
			    		 model.setRoomNo(rs.getString(2));
			    		 model.setRoomCategoryId(rs.getInt(3));
			    		 model.setBuildingId(rs.getInt(4));
			    		 model.setFloorNo(rs.getInt(5));
			    		 model.setNoOfBeds(rs.getInt(6));
			    		 model.setDescription(rs.getString(7));
			    		 model.setRoomCategory(rs.getString(14));
			    		 model.setBuilding(rs.getString(15));
			    		 model.setRate(rs.getBigDecimal(16));
			    		 model.setAvailableBeds(rs.getInt(17));
			    		 model.setRoomFullName();
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

	@Override
	public Map<String, Object> updateAvailableBeds(HashMap<String, Object> dataMap) throws Exception{
		// TODO Auto-generated method stub
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_UPDATE);
		 
		//DBCP JNDI
		Connection conn = (Connection) dataMap.get(MapConstant.JDBC_CONNECTION);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean status = false;
		
		Room model = (Room) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update pibs.file_room set ");	
			qry.append(" availablebeds = availablebeds-1 ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");

		PIBSUtils.writeLogDebug(logger, "SQL: "+qry.toString());
	
		 try {
			pstmt = conn.prepareStatement(qry.toString());
				     
			pstmt.setInt(1, model.getModifiedBy());
			pstmt.setTimestamp(2, model.getModifiedOn());
			pstmt.setLong(3, model.getId());
				     
			int statusInt = pstmt.executeUpdate();
				     
			if (statusInt == 1) {
				System.out.println("Room available beds for (id: " +model.getId()+") updated successfully..");
				status = true;
			}
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			PIBSUtils.closeObjects(rs);
			PIBSUtils.closeObjects(pstmt);
//			PIBSUtils.closeObjects(conn); do not close connection here
		}
			 		
		returnMap.put(MapConstant.TRANSACTION_STATUS, status);	
		
		return returnMap;
	}

	@Override
	public Map<String, Object> updateAvailableBedsAfterPaymentOrRoomTransfer(HashMap<String, Object> dataMap) throws Exception{
		// TODO Auto-generated method stub
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_UPDATE);
		 
		//DBCP JNDI
		Connection conn = (Connection) dataMap.get(MapConstant.JDBC_CONNECTION);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean status = false;
		
		Room model = (Room) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update pibs.file_room set ");	
			qry.append(" availablebeds = availablebeds+1 ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");

		PIBSUtils.writeLogDebug(logger, "SQL: "+qry.toString());
	
		 try {
			pstmt = conn.prepareStatement(qry.toString());
				     
			pstmt.setInt(1, model.getModifiedBy());
			pstmt.setTimestamp(2, model.getModifiedOn());
			pstmt.setLong(3, model.getId());
				     
			int statusInt = pstmt.executeUpdate();
				     
			if (statusInt == 1) {
//				conn.commit(); //no commit here
				System.out.println("Room available beds for (id: " +model.getId()+") updated successfully..");
				status = true;
			}
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			PIBSUtils.closeObjects(rs);
			PIBSUtils.closeObjects(pstmt);
//			PIBSUtils.closeObjects(conn); //do not close here
		}
			 		
		returnMap.put(MapConstant.TRANSACTION_STATUS, status);	
		
		return returnMap;
	}

	@Override
	public Map<String, Object> searchAvailableRooms(HashMap<String, Object> criteriaMap) throws Exception{
		 
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SEARCH);
		 
		 	Map<String, Object> returnMap = null;

		 	//Connection using JNDI DBCP
			 //get the pagination and offset
//			 int offset = (int) criteriaMap.get(MapConstant.PAGINATION_OFFSET);
//			 int limit = (int) criteriaMap.get(MapConstant.PAGINATION_LIMIT);
			 
			 String criteria = (String) criteriaMap.get(MapConstant.SEARCH_CRITERIA);
			 
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
			 
			  List<Room> rsList = new ArrayList<Room>();
					  
			 try {
				  conn = ServerContext.getJDBCHandle();

				  StringBuffer sql = new StringBuffer("select a.id,a.roomno,a.roomcategoryid,a.buildingid,a.floorno,a.noofbeds,a.description,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
					 	sql.append(" ,b.description,c.description,b.rate,a.availablebeds ");//for RoomCategory and Building Description
					 	sql.append(" from pibs.file_room a");
					 	sql.append(" inner join pibs.file_room_category b on a.roomcategoryid = b.id ");
					 	sql.append(" inner join pibs.file_building c on a.buildingid = c.id ");
					 	sql.append(" where a.active = true ");
					 	sql.append(" and (a.roomno ilike '%"+criteria+"%' or a.description ilike '%"+criteria+"%')" );
					 	sql.append(" and a.availablebeds > 0 ");
					 	sql.append(" order by a.id ");		 

				 PIBSUtils.writeLogDebug(logger, "SQL: "+sql.toString());
					
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 rs = pstmt.executeQuery();
				 
				 while(rs.next()) {
					 Room model=new Room();  
		    		 model.setId(rs.getInt(1));
		    		 model.setRoomNo(rs.getString(2));
		    		 model.setRoomCategoryId(rs.getInt(3));
		    		 model.setBuildingId(rs.getInt(4));
		    		 model.setFloorNo(rs.getInt(5));
		    		 model.setNoOfBeds(rs.getInt(6));
		    		 model.setDescription(rs.getString(7));
		    		 model.setRoomCategory(rs.getString(14));
		    		 model.setBuilding(rs.getString(15));
		    		 model.setRate(rs.getBigDecimal(16));
		    		 model.setAvailableBeds(rs.getInt(17));
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
			 
		     try {
		    	 conn = ServerContext.getJDBCHandle();
		    	 
		    	 StringBuffer	sqlCount = new StringBuffer("select count(*) from pibs.file_room where active = true and roomno ilike '%"+criteria+"%' or description ilike '%"+criteria+"%' and availablebeds > 0 ");	 

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
	     
	    System.out.println("searchAvailableRooms() - Exit");
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
			 List<Room> rsList = new ArrayList<>();
			  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();				
				 sql = new StringBuffer("select a.id,a.roomno,a.roomcategoryid,a.buildingid,a.floorno,a.noofbeds,a.description,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
				 	sql.append(" ,b.description,c.description,b.rate,a.availablebeds ");//for RoomCategory and Building Description
				 	sql.append(" from pibs.file_room a");
				 	sql.append(" inner join pibs.file_room_category b on a.roomcategoryid = b.id ");
				 	sql.append(" inner join pibs.file_building c on a.buildingid = c.id ");
				 	sql.append(" where a.active = false ");
				 	sql.append(" order by a.roomno,a.roomcategoryid ");
				 	sql.append(" limit ? ");
				 	sql.append(" offset ? ");
			
				 PIBSUtils.writeLogDebug(logger, "SQL: "+sql.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 pstmt.setInt(1, limit);
				 pstmt.setInt(2, offset);
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
					 //get the model criteria
					 Room model=new Room();  
		    		 model.setId(rs.getInt(1));
		    		 model.setRoomNo(rs.getString(2));
		    		 model.setRoomCategoryId(rs.getInt(3));
		    		 model.setBuildingId(rs.getInt(4));
		    		 model.setFloorNo(rs.getInt(5));
		    		 model.setNoOfBeds(rs.getInt(6));
		    		 model.setDescription(rs.getString(7));
		    		 model.setRoomCategory(rs.getString(14));
		    		 model.setBuilding(rs.getString(15));
		    		 model.setRate(rs.getBigDecimal(16));
		    		 model.setAvailableBeds(rs.getInt(17));
		    		 model.setRoomFullName();
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
		    	 
			    sqlCount = new StringBuffer("select count(*) from pibs.file_room where active = false");	 
	
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
		
		Room model = (Room) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update pibs.file_room set ");	
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
				System.out.println("Room record (id: " +model.getId()+") restored successfully..");
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
			 
			 String criteria = (String) criteriaMap.get(MapConstant.SEARCH_CRITERIA);
			 
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
			 
			  List<Room> rsList = new ArrayList<Room>();
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = null;
					 sql = new StringBuffer("select a.id,a.roomno,b.description as category,b.rate,a.noofbeds,a.availablebeds,c.description as building,a.floorno ");
					 	sql.append(" from pibs.file_room a ");//for RoomCategory and Building Description
					 	sql.append(" inner join pibs.file_room_category b on a.roomcategoryid = b.id  ");
					 	sql.append(" inner join pibs.file_building c on a.buildingid = c.id  ");
					 	sql.append(" where ");
					 	sql.append(" (a.roomno ilike '%"+criteria+"%' or a.description ilike '%"+criteria+"%' or b.description ilike '%"+criteria+"%' or c.description ilike '%"+criteria+"%')" );
					 	sql.append(" and a.active = true ");
					 	sql.append(" order by a.roomno ");
					 	sql.append(" limit ? ");
					 	sql.append(" offset ?");	
						 
				PIBSUtils.writeLogDebug(logger, "SQL: "+sql.toString());
					
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, limit);
				 pstmt.setInt(2, offset);
				 
				 rs = pstmt.executeQuery();
				 
				 while(rs.next()) {
					 Room model=new Room();  
		    		 model.setId(rs.getInt(1));
		    		 model.setRoomNo(rs.getString(2));
		    		 model.setRoomCategory(rs.getString(3));
		    		 model.setRate(rs.getBigDecimal(4));
		    		 model.setNoOfBeds(rs.getInt(5));
		    		 model.setAvailableBeds(rs.getInt(6));
		    		 model.setBuilding(rs.getString(7));
		    		 model.setFloorNo(rs.getInt(8));
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
		    	 	sqlCount.append(" from pibs.file_room a ");
		    	 	sqlCount.append(" inner join pibs.file_room_category b on a.roomcategoryid = b.id  ");
		    	 	sqlCount.append(" inner join pibs.file_building c on a.buildingid = c.id  ");
		    	 	sqlCount.append(" where ");
		    	 	sqlCount.append(" (a.roomno ilike '%"+criteria+"%' or a.description ilike '%"+criteria+"%' or b.description ilike '%"+criteria+"%' or c.description ilike '%"+criteria+"%')" );
		    	 	sqlCount.append(" and a.active = true ");
		    	 	
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
	public Map<String, Object> getAvailableRoomsForRoomInquiry(HashMap<String, Object> criteriaMap) throws Exception {
		// TODO Auto-generated method stub
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_GET_ACTIVE_DATA);
		 
		 //get the pagination and offset
		 int offset = (int) criteriaMap.get(MapConstant.PAGINATION_OFFSET);
		 int limit = (int) criteriaMap.get(MapConstant.PAGINATION_LIMIT);

		 //Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
		     Map<String, Object> returnMap = null;
			 List<Room> rsList = new ArrayList<Room>();
			  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();				
				 sql = new StringBuffer("select a.id,a.roomno,a.roomcategoryid,a.buildingid,a.floorno,a.noofbeds,a.description,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
				 	sql.append(" ,b.description,c.description,b.rate,a.availablebeds ");
				 	sql.append(" from pibs.file_room a");
				 	sql.append(" inner join pibs.file_room_category b on a.roomcategoryid = b.id ");
				 	sql.append(" inner join pibs.file_building c on a.buildingid = c.id ");
				 	sql.append(" where a.active = true ");
				 	sql.append(" and a.availablebeds > 0 ");
				 	sql.append(" order by a.roomno,a.roomcategoryid ");
				 	sql.append(" limit ? ");
				 	sql.append(" offset ?");

				 PIBSUtils.writeLogDebug(logger, "SQL: "+sql.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, limit);
				 pstmt.setInt(2, offset);
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
						 Room model=new Room();  
			    		 model.setId(rs.getInt(1));
			    		 model.setRoomNo(rs.getString(2));
			    		 model.setRoomCategoryId(rs.getInt(3));
			    		 model.setBuildingId(rs.getInt(4));
			    		 model.setFloorNo(rs.getInt(5));
			    		 model.setNoOfBeds(rs.getInt(6));
			    		 model.setDescription(rs.getString(7));
			    		 model.setRoomCategory(rs.getString(14));
			    		 model.setBuilding(rs.getString(15));
			    		 model.setRate(rs.getBigDecimal(16));
			    		 model.setAvailableBeds(rs.getInt(17));
			    		 model.setRoomFullName();
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
		    	 
		    	 sqlCount = new StringBuffer("select count(*) from pibs.file_room where active = true and availablebeds > 0 ");

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
	public Map<String, Object> getOccupiedRoomsForRoomInquiry(HashMap<String, Object> criteriaMap) throws Exception {
		// TODO Auto-generated method stub
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_GET_ACTIVE_DATA);
		 
		 //get the pagination and offset
		 int offset = (int) criteriaMap.get(MapConstant.PAGINATION_OFFSET);
		 int limit = (int) criteriaMap.get(MapConstant.PAGINATION_LIMIT);

		 //Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
		     Map<String, Object> returnMap = null;
			 List<Room> rsList = new ArrayList<Room>();
			  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();				
				 sql = new StringBuffer("select a.id,a.roomno,a.roomcategoryid,a.buildingid,a.floorno,a.noofbeds,a.description,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
				 	sql.append(" ,b.description,c.description,b.rate,a.availablebeds ");
				 	sql.append(" from pibs.file_room a");
				 	sql.append(" inner join pibs.file_room_category b on a.roomcategoryid = b.id ");
				 	sql.append(" inner join pibs.file_building c on a.buildingid = c.id ");
				 	sql.append(" where a.active = true ");
				 	sql.append(" and a.availablebeds = 0 ");
				 	sql.append(" order by a.roomno,a.roomcategoryid ");
				 	sql.append(" limit ? ");
				 	sql.append(" offset ?");

				 PIBSUtils.writeLogDebug(logger, "SQL: "+sql.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, limit);
				 pstmt.setInt(2, offset);
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
						 Room model=new Room();  
			    		 model.setId(rs.getInt(1));
			    		 model.setRoomNo(rs.getString(2));
			    		 model.setRoomCategoryId(rs.getInt(3));
			    		 model.setBuildingId(rs.getInt(4));
			    		 model.setFloorNo(rs.getInt(5));
			    		 model.setNoOfBeds(rs.getInt(6));
			    		 model.setDescription(rs.getString(7));
			    		 model.setRoomCategory(rs.getString(14));
			    		 model.setBuilding(rs.getString(15));
			    		 model.setRate(rs.getBigDecimal(16));
			    		 model.setAvailableBeds(rs.getInt(17));
			    		 model.setRoomFullName();
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
		    	 
		    	 sqlCount = new StringBuffer("select count(*) from pibs.file_room where active = true and availablebeds = 0 ");

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
	public Map<String, Object> searchForListReport(HashMap<String, Object> criteriaMap) throws Exception {
		 
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SEARCH);
		 
		 	Map<String, Object> returnMap = null;

		 	 //Connection using JNDI DBCP
			 //get the criteria and value
		 	 int searchCriteria = Integer.parseInt((String)criteriaMap.get(MapConstant.SEARCH_CRITERIA));
			 String searchValue = (String) criteriaMap.get(MapConstant.SEARCH_VALUE);
			 
			 Connection conn = null;
			 ResultSet rs = null;
			 PreparedStatement pstmt = null;
			 
			 List<Room> rsList = new ArrayList<>();
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = null;
				 		
				 sql = new StringBuffer("select a.id,a.roomno,a.floorno,a.noofbeds,a.availablebeds,a.description,b.description as category,c.description as building, b.rate, a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
				 	sql.append(" from pibs.file_room a, pibs.file_room_category b, pibs.file_building c ");
				 	sql.append(" where a.roomcategoryid = b.id ");
				 	sql.append(" and a.buildingid = c.id ");
				 	sql.append(" and a.active = true ");
			    	if (MiscConstant.LOV_ROOM_REPORT_SEARCH_CRITERIA_ROOM_NO == searchCriteria) {
			    		sql.append(" and a.roomno ilike '%"+searchValue+"%' ");
			    	}
			    	if (MiscConstant.LOV_ROOM_REPORT_SEARCH_CRITERIA_CATEGORY == searchCriteria) {
			    		sql.append(" and b.description ilike '%"+searchValue+"%' ");
			    	}
			    	if (MiscConstant.LOV_ROOM_REPORT_SEARCH_CRITERIA_BUILDING == searchCriteria) {
			    		sql.append(" and c.description ilike '%"+searchValue+"%' ");
			    	}
				 	sql.append(" order by a.roomno ");
						
						 
				PIBSUtils.writeLogDebug(logger, "SQL: "+sql.toString());
					
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 rs = pstmt.executeQuery();
				 
				 while(rs.next()) {
					 Room model=new Room();  
		    		 model.setId(rs.getInt(1));
		    		 model.setRoomNo(rs.getString(2));
		    		 model.setFloorNo(rs.getInt(3));
		    		 model.setNoOfBeds(rs.getInt(4));
		    		 model.setAvailableBeds(rs.getInt(5));
		    		 model.setDescription(rs.getString(6));
		    		 model.setRoomCategory(rs.getString(7));
		    		 model.setBuilding(rs.getString(8));
		    		 model.setRate(rs.getBigDecimal(9));
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
