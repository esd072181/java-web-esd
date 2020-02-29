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
import com.pibs.dao.MedicalSupplyDao;
import com.pibs.model.MedicalSupply;
import com.pibs.model.User;
import com.pibs.util.DateUtils;
import com.pibs.util.PIBSUtils;

public class MedicalSupplyDaoImpl implements MedicalSupplyDao {
	
	private final static Logger logger = Logger.getLogger(MedicalSupplyDaoImpl.class);

	@Override
	public Map<String, Object> save(HashMap<String, Object> dataMap) throws Exception{
		
		PIBSUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SAVE);
		
		//DBCP JNDI
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean status = false;
		
		MedicalSupply model = (MedicalSupply) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setCreatedBy((int) user.getId());	
		}
		model.setCreatedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("insert into pibs.file_medical_supply (");
				qry.append("medicalsupplytypeid ");
				qry.append(",itemcode ");
		  		qry.append(",description ");
		  		qry.append(",genericname ");
		  		qry.append(",remarks ");
		  		qry.append(",lotno ");
		  		qry.append(",datemanufactured ");
		  		qry.append(",expirationdate ");
		  		qry.append(",retailsellingprice ");
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
		  		qry.append(" ,1 ");
		  		qry.append(" ,true ");
		  		qry.append(" ) ");

		StringBuffer qryLog =  new StringBuffer("insert into pibs.file_medical_supply (");
				qryLog.append("medicalsupplytypeid ");
				qryLog.append(",itemcode ");
				qryLog.append(",description ");
				qryLog.append(",genericname ");
				qryLog.append(",remarks ");
				qryLog.append(",lotno ");
				qryLog.append(",datemanufactured ");
				qryLog.append(",expirationdate ");
				qryLog.append(",retailsellingprice ");
				qryLog.append(",createdby ");
				qryLog.append(",createdon ");
				qryLog.append(",version ");
				qryLog.append(",active ");
				qryLog.append(" ) ");
				qryLog.append(" values ");
				qryLog.append(" ( ");
				qryLog.append(model.getMedicalSupplyTypeId());
				qryLog.append(" ,"+model.getItemCode());
				qryLog.append(" ,"+model.getDescription());
				qryLog.append(" ,"+model.getGenericName());
				qryLog.append(" ,"+model.getRemarks());
				qryLog.append(" ,"+model.getLotNo());
				qryLog.append(" ,"+model.getDateManufactured());
				qryLog.append(" ,"+model.getExpirationDate());
				qryLog.append(" ,"+model.getRetailSellingPrice());
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
			     
			  pstmt.setInt(1, model.getMedicalSupplyTypeId());
			  pstmt.setString(2, model.getItemCode());
			  pstmt.setString(3, model.getDescription());
			  pstmt.setString(4, model.getGenericName());
			  pstmt.setString(5, model.getRemarks());
			  pstmt.setString(6, model.getLotNo());
			  pstmt.setDate(7, model.getDateManufactured());
			  pstmt.setDate(8, model.getExpirationDate());
			  pstmt.setBigDecimal(9, model.getRetailSellingPrice());
			  pstmt.setInt(10, model.getCreatedBy());
			  pstmt.setTimestamp(11, model.getCreatedOn());
			     
			  int statusInt = pstmt.executeUpdate();
			     
			  if (statusInt == 1) {
				  conn.commit();
				  System.out.println("Inserted into Medical Supply table successfully..");
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
		
		MedicalSupply model = (MedicalSupply) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update pibs.file_medical_supply set ");	
			qry.append(" medicalsupplytypeid=? ");
			qry.append(" ,itemcode=? ");
			qry.append(" ,description=? ");
			qry.append(" ,genericname=? ");
			qry.append(" ,remarks=? ");
			qry.append(" ,lotno=? ");
			qry.append(" ,datemanufactured=? ");
			qry.append(" ,expirationdate=? ");
			qry.append(" ,retailsellingprice=? ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");

		StringBuffer qryLog =  new StringBuffer("update pibs.file_medical_supply set ");	
			qryLog.append(" medicalsupplytypeid="+model.getMedicalSupplyTypeId());
			qryLog.append(" ,itemcode="+model.getItemCode());
			qryLog.append(" ,description="+model.getDescription());
			qryLog.append(" ,genericname="+model.getGenericName());
			qryLog.append(" ,remarks="+model.getRemarks());
			qryLog.append(" ,lotno="+model.getLotNo());
			qryLog.append(" ,datemanufactured="+model.getDateManufactured());
			qryLog.append(" ,expirationdate="+model.getExpirationDate());
			qryLog.append(" ,retailsellingprice="+model.getRetailSellingPrice());
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
				     
			pstmt.setInt(1, model.getMedicalSupplyTypeId());
			pstmt.setString(2, model.getItemCode());
			pstmt.setString(3, model.getDescription());
			pstmt.setString(4, model.getGenericName());
			pstmt.setString(5, model.getRemarks());
			pstmt.setString(6, model.getLotNo());
			pstmt.setDate(7, model.getDateManufactured());
			pstmt.setDate(8, model.getExpirationDate());
			pstmt.setBigDecimal(9, model.getRetailSellingPrice());
			pstmt.setInt(10, model.getModifiedBy());
			pstmt.setTimestamp(11, model.getModifiedOn());
			pstmt.setLong(12, model.getId());
				     
			int statusInt = pstmt.executeUpdate();
				     
			if (statusInt == 1) {
				conn.commit();
				System.out.println("Medical Supply record (id: " +model.getId()+") updated successfully..");
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
		
		MedicalSupply model = (MedicalSupply) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update pibs.file_medical_supply set ");	
			qry.append(" active=false ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");

		StringBuffer qryLog =  new StringBuffer("update pibs.file_medical_supply set ");	
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
				System.out.println("Medical Supply record (id: " +model.getId()+") deleted successfully..");
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
			 
			  List<MedicalSupply> rsList = new ArrayList<MedicalSupply>();
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = null;
				 if (category.equals(ActionConstant.SEARCHALL)) {
					 sql = new StringBuffer("select a.id,a.medicalsupplytypeid,a.itemcode,a.description,a.genericname,a.remarks,a.lotno,a.datemanufactured,a.expirationdate,b.listvalue as type,a.retailsellingprice,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
					 	sql.append(" from pibs.file_medical_supply a, pibs.list_value b");
					 	sql.append(" where a.medicalSupplyTypeId = b.id ");
					 	sql.append(" and a.active = true ");
					 	sql.append(" order by a.description ");
					 	sql.append(" limit ? ");
					 	sql.append(" offset ?");		 
				 } else {
					 sql = new StringBuffer("select a.id,a.medicalsupplytypeid,a.itemcode,a.description,a.genericname,a.remarks,a.lotno,a.datemanufactured,a.expirationdate,b.listvalue as type,a.retailsellingprice,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
					 	sql.append(" from pibs.file_medical_supply a, pibs.list_value b");
					 	sql.append(" where a.medicalsupplytypeid = b.id ");
					 	sql.append(" and (a.description ilike '%"+criteria+"%' or a.genericname ilike '%"+criteria+"%')" );
					 	sql.append(" and a.active = true ");
					 	sql.append(" order by a.description ");
					 	sql.append(" limit ? ");
					 	sql.append(" offset ?");	
				 }
						 
				PIBSUtils.writeLogDebug(logger, "SQL: "+sql.toString());
					
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, limit);
				 pstmt.setInt(2, offset);
				 
				 rs = pstmt.executeQuery();
				 
				 while(rs.next()) {
					 MedicalSupply model=new MedicalSupply();  
		    		 model.setId(rs.getInt(1));
		    		 model.setMedicalSupplyTypeId(rs.getInt(2));
		    		 model.setItemCode(rs.getString(3));
		    		 model.setDescription(rs.getString(4));
		    		 model.setGenericName(rs.getString(5));
		    		 model.setRemarks(rs.getString(6));
		    		 model.setLotNo(rs.getString(7));
		    		 model.setDateManufactured(rs.getDate(8));
		    		 model.setExpirationDate(rs.getDate(9));
		    		 model.setMedicalSupplyTypeName(rs.getString(10));
		    		 model.setRetailSellingPrice(rs.getBigDecimal(11));	 
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
			    	 sqlCount = new StringBuffer("select count(*) from pibs.file_medical_supply where active = true");	 
			     }else {
			    	 sqlCount = new StringBuffer("select count(*) from pibs.file_medical_supply where  (description ilike '%"+criteria+"%' or genericname ilike '%"+criteria+"%') and active = true");	 
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
		    MedicalSupply model = (MedicalSupply) criteriaMap.get(MapConstant.CLASS_DATA);

		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
		     Map<String, Object> returnMap = null;
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();				
				 	sql.append("select a.id,a.medicalsupplytypeid,a.itemcode,a.description,a.genericname,a.remarks,a.lotno,a.datemanufactured,a.expirationdate,a.retailsellingprice,b.listvalue as type,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
				 	sql.append(" from pibs.file_medical_supply a, pibs.list_value b");
				 	sql.append(" where a.medicalSupplyTypeId = b.id ");
				 	sql.append(" and a.id = ?");

				 StringBuffer sqlLog = new StringBuffer();				
				 	sqlLog.append("select a.id,a.medicalsupplytypeid,a.itemcode,a.description,a.genericname,a.remarks,a.lotno,a.datemanufactured,a.expirationdate,a.retailsellingprice,b.listvalue as type,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
				 	sqlLog.append(" from pibs.file_medical_supply a, pibs.list_value b");
				 	sqlLog.append(" where a.medicalSupplyTypeId = b.id ");
				 	sqlLog.append(" and id = "+ model.getId());
			
				 PIBSUtils.writeLogDebug(logger, "SQL: "+sqlLog.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, model.getId());
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
		    		 model.setId(rs.getInt(1));
		    		 model.setMedicalSupplyTypeId(rs.getInt(2));
		    		 model.setItemCode(rs.getString(3));
		    		 model.setDescription(rs.getString(4));
		    		 model.setGenericName(rs.getString(5));
		    		 model.setRemarks(rs.getString(6));
		    		 model.setLotNo(rs.getString(7));
		    		 model.setDateManufactured(rs.getDate(8));
		    		 model.setExpirationDate(rs.getDate(9));
		    		 model.setRetailSellingPrice(rs.getBigDecimal(10));
		    		 model.setMedicalSupplyTypeName(rs.getString(11)); 
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
			 List<MedicalSupply> rsList = new ArrayList<MedicalSupply>();
			  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();				
				 	sql.append("select id,medicalsupplytypeid,itemcode,description,remarks,genericname,lotno,datemanufactured,expirationdate,retailsellingprice,createdby,createdon,modifiedby,modifiedon,version,active  ");
				 	sql.append("from pibs.file_medical_supply ");
				 	sql.append("where active = true ");
				 	sql.append("order by description");

				 StringBuffer sqlLog = new StringBuffer();				
				 	sqlLog.append("select id,medicalsupplytypeid,itemcode,description,remarks,genericname,lotno,datemanufactured,expirationdate,retailsellingprice,createdby,createdon,modifiedby,modifiedon,version,active  ");
				 	sqlLog.append("from pibs.file_medical_supply ");
				 	sqlLog.append("where active = true ");
				 	sqlLog.append("order by description");
			
				 PIBSUtils.writeLogDebug(logger, "SQL: "+sqlLog.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
					 //get the model criteria
					 MedicalSupply model = new MedicalSupply();
		    		 model.setId(rs.getInt(1));
		    		 model.setMedicalSupplyTypeId(rs.getInt(2));
		    		 model.setItemCode(rs.getString(3));
		    		 model.setDescription(rs.getString(4));
		    		 model.setGenericName(rs.getString(5));
		    		 model.setRemarks(rs.getString(6));
		    		 model.setLotNo(rs.getString(7));
		    		 model.setDateManufactured(rs.getDate(8));
		    		 model.setExpirationDate(rs.getDate(9));
		    		 model.setRetailSellingPrice(rs.getBigDecimal(10));
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
			 List<MedicalSupply> rsList = new ArrayList<>();
			  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = new StringBuffer();				
				 	sql.append("select id,medicalsupplytypeid,itemcode,description,remarks,genericname,lotno,datemanufactured,expirationdate,retailsellingprice,createdby,createdon,modifiedby,modifiedon,version,active  ");
				 	sql.append(" from pibs.file_medical_supply ");
				 	sql.append(" where active = false ");
				 	sql.append("order by description ");
				 	sql.append(" limit ? ");
				 	sql.append(" offset ? ");
			
				 PIBSUtils.writeLogDebug(logger, "SQL: "+sql.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 pstmt.setInt(1, limit);
				 pstmt.setInt(2, offset);
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
					 //get the model criteria
					 MedicalSupply model = new MedicalSupply();
		    		 model.setId(rs.getInt(1));
		    		 model.setMedicalSupplyTypeId(rs.getInt(2));
		    		 model.setItemCode(rs.getString(3));
		    		 model.setDescription(rs.getString(4));
		    		 model.setGenericName(rs.getString(5));
		    		 model.setRemarks(rs.getString(6));
		    		 model.setLotNo(rs.getString(7));
		    		 model.setDateManufactured(rs.getDate(8));
		    		 model.setExpirationDate(rs.getDate(9));
		    		 model.setRetailSellingPrice(rs.getBigDecimal(10));
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
		    	 
			    sqlCount = new StringBuffer("select count(*) from pibs.file_medical_supply where active = false");	 
	
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
		
		MedicalSupply model = (MedicalSupply) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update pibs.file_medical_supply set ");	
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
				System.out.println("Room Category record (id: " +model.getId()+") restored successfully..");
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
			 
			 List<MedicalSupply> rsList = new ArrayList<>();
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer sql = null;
				 		
				 sql = new StringBuffer("select a.id,a.itemcode,a.description,a.genericname,a.remarks,a.lotno,a.datemanufactured,a.expirationdate,a.retailsellingprice,b.listvalue as type,a.createdby,a.createdon,a.modifiedby,a.modifiedon,a.version,a.active ");
				 	sql.append(" from pibs.file_medical_supply a, pibs.list_value b ");
				 	sql.append(" where a.medicalsupplytypeid = b.id ");
				 	sql.append(" and a.active = true ");
			    	if (MiscConstant.LOV_MEDICAL_SUPPLY_REPORT_SEARCH_CRITERIA_TYPE == searchCriteria) {
			    		sql.append(" and b.listvalue ilike '%"+searchValue+"%' ");
			    	}
			    	if (MiscConstant.LOV_MEDICAL_SUPPLY_REPORT_SEARCH_CRITERIA_ITEM_CODE == searchCriteria) {
			    		sql.append(" and a.itemcode ilike '%"+searchValue+"%' ");
			    	}
			    	if (MiscConstant.LOV_MEDICAL_SUPPLY_REPORT_SEARCH_CRITERIA_DESCRIPTION == searchCriteria) {
			    		sql.append(" and a.description ilike '%"+searchValue+"%' ");
			    	}
			    	if (MiscConstant.LOV_MEDICAL_SUPPLY_REPORT_SEARCH_CRITERIA_GENERIC_NAME == searchCriteria) {
			    		sql.append(" and a.genericname ilike '%"+searchValue+"%' ");
			    	}
			    	if (MiscConstant.LOV_MEDICAL_SUPPLY_REPORT_SEARCH_CRITERIA_DATE_MANUFACTURED == searchCriteria) {
			    		sql.append(" and a.datemanufactured between '"+DateUtils.sqlDateToStringSQL(DateUtils.strToSQLDate(dateFromValue))+"' and '"+DateUtils.sqlDateToStringSQL(DateUtils.strToSQLDate(dateToValue))+"'");

			    	}
			    	else if (MiscConstant.LOV_MEDICAL_SUPPLY_REPORT_SEARCH_CRITERIA_EXPIRATION_DATE == searchCriteria) {
				 		sql.append(" and a.expirationdate between '"+DateUtils.sqlDateToStringSQL(DateUtils.strToSQLDate(dateFromValue))+"' and '"+DateUtils.sqlDateToStringSQL(DateUtils.strToSQLDate(dateToValue))+"'");
				 	}
				 	sql.append(" order by a.description ");
						
						 
				PIBSUtils.writeLogDebug(logger, "SQL: "+sql.toString());
					
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 rs = pstmt.executeQuery();
				 
				 while(rs.next()) {
					 MedicalSupply model = new MedicalSupply();
		    		 model.setId(rs.getInt(1));
		    		 model.setItemCode(rs.getString(2));
		    		 model.setDescription(rs.getString(3));
		    		 model.setGenericName(rs.getString(4));
		    		 model.setRemarks(rs.getString(5));
		    		 model.setLotNo(rs.getString(6));
		    		 model.setDateManufactured(rs.getDate(7));
		    		 model.setExpirationDate(rs.getDate(8));
		    		 model.setRetailSellingPrice(rs.getBigDecimal(9));	 
		    		 model.setMedicalSupplyTypeName(rs.getString(10));
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
