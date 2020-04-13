package com.transport.dao.impl;

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

import com.transport.config.ServerContext;
import com.transport.constant.ActionConstant;
import com.transport.constant.MapConstant;
import com.transport.constant.MiscConstant;
import com.transport.dao.TireDao;
import com.transport.model.Tire;
import com.transport.model.User;
import com.transport.util.TransportUtils;

/**
 * 
 * @author dward
 * @since 21Aug2016
 * DateUpdated: 09Apr2020
 */
public class TireDaoImpl implements TireDao {
	
	private final static Logger logger = Logger.getLogger(TireDaoImpl.class);

	@Override
	public Map<String, Object> save(HashMap<String, Object> dataMap) throws Exception{
		
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SAVE);
		
		//DBCP JNDI
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean status = false;
		
		Tire model = (Tire) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setCreatedBy((int) user.getId());	
		}
		model.setCreatedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("insert into transport.file_tire (");
				qry.append("brandid ");
		  		qry.append(",serialno ");
		  		qry.append(",recapno ");
		  		qry.append(",sizeandply ");
		  		qry.append(",price ");
		  		if (model.getRecapNo().equals("N/A")) {
					qry.append(" ,datepurchased ");
				} else if (model.getRecapNo().equals("1")) {
					qry.append(" ,datepurchasedforrecap1 ");
				} else if (model.getRecapNo().equals("2")) {
					qry.append(" ,datepurchasedforrecap2 ");
				}
		  		qry.append(",invoiceno ");
		  		qry.append(",analysis ");
		  		qry.append(",comments ");
		  		qry.append(",retired ");
		  		qry.append(",dateretired ");
		  		//qry.append(",lorryno ");//not required here
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
		  		qry.append(" ,1 ");
		  		qry.append(" ,true ");
		  		qry.append(" ) ");
					
		TransportUtils.writeLogDebug(logger, "SQL: "+qry.toString());
  		  		
		  try {
			  conn = ServerContext.getJDBCHandle();
			  conn.setAutoCommit(false);
			  pstmt = conn.prepareStatement(qry.toString());
			     
			  pstmt.setInt(1, model.getBrandId());
			  pstmt.setString(2, model.getSerialNo());
			  pstmt.setString(3, model.getRecapNo());
			  pstmt.setString(4, model.getSizeAndPly());
			  pstmt.setBigDecimal(5, model.getPrice());
			  if (model.getRecapNo().equals("N/A")) {
				    pstmt.setDate(6, model.getDatePurchased());
				} else if (model.getRecapNo().equals("1")) {
					pstmt.setDate(6, model.getDatePurchasedForRecap1());
				} else if (model.getRecapNo().equals("2")) {
					pstmt.setDate(6, model.getDatePurchasedForRecap2());
				}
			  pstmt.setString(7, model.getInvoiceNo());
			  pstmt.setString(8, model.getAnalysis());
			  pstmt.setString(9, model.getComments());
			  pstmt.setString(10, model.getRetired());
			  pstmt.setDate(11, model.getDateRetired());
			  pstmt.setInt(12, model.getCreatedBy());
			  pstmt.setTimestamp(13, model.getCreatedOn());
			     
			  int statusInt = pstmt.executeUpdate();
			     
			  if (statusInt == 1) {
				  conn.commit();
				  System.out.println("Inserted into Tire table successfully..");
				  status = true;
			  }
		  } catch (Exception e) {
			  conn.rollback();
		 	  e.printStackTrace();
		  } finally {
			  TransportUtils.closeObjects(rs);
			  TransportUtils.closeObjects(pstmt);
			  TransportUtils.closeObjects(conn);
		  }
		 		
		returnMap.put(MapConstant.TRANSACTION_STATUS, status);
		     
		return returnMap;
	}

	@Override
	public Map<String, Object> update(HashMap<String, Object> dataMap) throws Exception{
		// TODO Auto-generated method stub
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_UPDATE);
		 
		//DBCP JNDI
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean status = false;
		
		Tire model = (Tire) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update transport.file_tire set ");	
			qry.append(" brandid=? ");
			qry.append(" ,serialno=? ");
			qry.append(" ,recapno=? ");
			qry.append(" ,sizeandply=? ");
			qry.append(" ,price=? ");
			if (model.getRecapNo().equals("N/A")) {
				qry.append(" ,datepurchased=? ");
			} else if (model.getRecapNo().equals("1")) {
				qry.append(" ,datepurchasedforrecap1=? ");
			} else if (model.getRecapNo().equals("2")) {
				qry.append(" ,datepurchasedforrecap2=? ");
			}
			qry.append(" ,invoiceno=? ");
			qry.append(" ,analysis=? ");
			qry.append(" ,comments=? ");
			qry.append(" ,retired=? ");
			qry.append(" ,dateretired=? ");
			//qry.append(" ,lorryno=? "); // this is not required here
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");

				
		TransportUtils.writeLogDebug(logger, "SQL: "+qry.toString());
	
		 try {
			conn = ServerContext.getJDBCHandle();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(qry.toString());
				     
			pstmt.setInt(1, model.getBrandId());
			pstmt.setString(2, model.getSerialNo());
			pstmt.setString(3, model.getRecapNo());
			pstmt.setString(4, model.getSizeAndPly());
			pstmt.setBigDecimal(5, model.getPrice());
			if (model.getRecapNo().equals("N/A")) {
				pstmt.setDate(6, model.getDatePurchased());
			} else if (model.getRecapNo().equals("1")) {
				pstmt.setDate(6, model.getDatePurchasedForRecap1());
			} else if (model.getRecapNo().equals("2")) {
				pstmt.setDate(6, model.getDatePurchasedForRecap2());
			}
			pstmt.setString(7, model.getInvoiceNo());
			pstmt.setString(8, model.getAnalysis());
			pstmt.setString(9, model.getComments());
			pstmt.setString(10, model.getRetired());
			pstmt.setDate(11, model.getDateRetired());
			pstmt.setInt(12, model.getModifiedBy());
			pstmt.setTimestamp(13, model.getModifiedOn());
			pstmt.setLong(14, model.getId());
				     
			int statusInt = pstmt.executeUpdate();
				     
			if (statusInt == 1) {
				conn.commit();
				System.out.println("Tire record (id: " +model.getId()+") updated successfully..");
				status = true;
			}
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			TransportUtils.closeObjects(rs);
			TransportUtils.closeObjects(pstmt);
			TransportUtils.closeObjects(conn);
		}
			 		
		returnMap.put(MapConstant.TRANSACTION_STATUS, status);	
		
		return returnMap;
	}

	@Override
	public Map<String, Object> delete(HashMap<String, Object> dataMap) throws Exception{
		// TODO Auto-generated method stub
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_DELETE);

		
		//DBCP JNDI
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean status = false;
		
		Tire model = (Tire) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update transport.file_tire set ");	
			qry.append(" active=false ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");

		TransportUtils.writeLogDebug(logger, "SQL: "+qry.toString());
	
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
				System.out.println("Tire record (id: " +model.getId()+") deleted successfully..");
				status = true;
			}
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			TransportUtils.closeObjects(rs);
			TransportUtils.closeObjects(pstmt);
			TransportUtils.closeObjects(conn);
		}
			 		
		returnMap.put(MapConstant.TRANSACTION_STATUS, status);			
		
		return returnMap;
	}

	@Override
	public Map<String, Object> search(HashMap<String, Object> criteriaMap) throws Exception{
		 
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_SEARCH);
		 
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
			 
			  List<Tire> rsList = new ArrayList<Tire>();
					  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer  sql = new StringBuffer("select t.id,b.name as brand,t.serialno,t.recapno,t.sizeandply,t.price,t.datepurchased,");
				 		sql.append(" t.datepurchasedforrecap1,t.datepurchasedforrecap2,t.invoiceno,t.analysis,t.comments,t.retired,t.dateretired,");
				 		sql.append(" t.lorryno,t.createdby,t.createdon,t.modifiedby,t.modifiedon,t.version,t.active ");
					 	sql.append(" from transport.file_tire t");
					 	sql.append(" inner join transport.file_tire_brand b");
					 	sql.append(" on t.brandid = b.id ");
					 	sql.append(" where t.active = true ");
					 	 if (category.equals(ActionConstant.SEARCHBY)) {
					 		sql.append(" and (t.serialno ilike ? or b.name ilike ? )");
					 	 }
					 	sql.append(" order by b.name,t.serialno ");
					 	sql.append(" limit ? ");
					 	sql.append(" offset ?");		 
				  
						 
				TransportUtils.writeLogDebug(logger, "SQL: "+sql.toString());
					
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 if (category.equals(ActionConstant.SEARCHBY)) {
					 pstmt.setString(1, "%"+criteria+"%");
					 pstmt.setString(2, "%"+criteria+"%");
					 pstmt.setInt(3, limit);
					 pstmt.setInt(4, offset);
				 } else {
					 pstmt.setInt(1, limit);
					 pstmt.setInt(2, offset);
				 }

				 
				 rs = pstmt.executeQuery();
				 
				 while(rs.next()) {
					 Tire model=new Tire();  
		    		 model.setId(rs.getInt(1));
		    		 model.setBrandName(rs.getString(2));
		    		 model.setSerialNo(rs.getString(3));
		    		 model.setRecapNo(rs.getString(4));
		    		 model.setSizeAndPly(rs.getString(5));
		    		 model.setPrice(rs.getBigDecimal(6));
		    		 model.setDatePurchased(rs.getDate(7));
		    		 model.setDatePurchasedForRecap1(rs.getDate(8));
		    		 model.setDatePurchasedForRecap2(rs.getDate(9));
		    		 model.setInvoiceNo(rs.getString(10));
		    		 model.setAnalysis(rs.getString(11));
		    		 model.setComments(rs.getString(12));
		    		 model.setRetired(rs.getString(13));
		    		 model.setDateRetired(rs.getDate(14));
		    		 model.setLorryNo(rs.getString(15));
		    		 rsList.add(model);
				 }				 
			 } catch (SQLException e) {
				 throw e;
			 } finally {
				 TransportUtils.closeObjects(rs);
				 TransportUtils.closeObjects(pstmt);
				 TransportUtils.closeObjects(conn);
			 }
			 
		     //get the total of records
		     int  totalNoOfRecords = 0;
		     StringBuffer sqlCount = null;
			 
		     try {
		    	 conn = ServerContext.getJDBCHandle();
		    	 
			     if (category.equals(ActionConstant.SEARCHALL)) {
			    	 sqlCount = new StringBuffer("select count(*) from transport.file_tire where active = true");	 
			     }else {
			    	 sqlCount = new StringBuffer("select count(*) from transport.file_tire t inner join transport.file_tire_brand b on t.brandid = b.id where (b.name ilike '%"+criteria+"%' or t.serialno ilike '%"+criteria+"%') and t.active = true");	 
			     } 
					
				TransportUtils.writeLogDebug(logger, "SQL: "+sqlCount.toString());
				
		    	 pstmt = conn.prepareStatement(sqlCount.toString());
		    	 
		    	 rs = pstmt.executeQuery();
		    	 if (rs.next()) {
		    		 totalNoOfRecords = rs.getInt(1);
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
		    	 returnMap.put(MapConstant.PAGINATION_TOTALRECORDS, totalNoOfRecords);
		     } 
	     
	    System.out.println("search() - Exit");
		return returnMap;
	}

	@Override
	public Map<String, Object> getDataById(HashMap<String, Object> criteriaMap)
			throws Exception {
		// TODO Auto-generated method stub
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_GETDATA_BY_ID);
		 
		    //get the model criteria
		    Tire model = (Tire) criteriaMap.get(MapConstant.CLASS_DATA);

		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
		     Map<String, Object> returnMap = null;
					  
			 try {
				 conn = ServerContext.getJDBCHandle();
		
				 StringBuffer  sql = new StringBuffer("select t.id,b.name as brand,t.serialno,t.recapno,t.sizeandply,t.price,t.datepurchased,");
			 		sql.append(" t.datepurchasedforrecap1,t.datepurchasedforrecap2,t.invoiceno,t.analysis,t.comments,t.retired,t.dateretired,");
			 		sql.append(" t.lorryno,t.brandid ");			 	
				 	sql.append(" from transport.file_tire t inner join transport.file_tire_brand b on t.brandid = b.id ");
					sql.append(" where t.id = ?");		 
			
				 TransportUtils.writeLogDebug(logger, "SQL: "+sql.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, model.getId());
				 
				 rs = pstmt.executeQuery();

				 while(rs.next()) {
					 model.setId(rs.getInt(1));
		    		 model.setBrandName(rs.getString(2));
		    		 model.setSerialNo(rs.getString(3));
		    		 model.setRecapNo(rs.getString(4));
		    		 model.setSizeAndPly(rs.getString(5));
		    		 model.setPrice(rs.getBigDecimal(6));
		    		 model.setDatePurchased(rs.getDate(7));
		    		 model.setDatePurchasedForRecap1(rs.getDate(8));
		    		 model.setDatePurchasedForRecap2(rs.getDate(9));
		    		 model.setInvoiceNo(rs.getString(10));
		    		 model.setAnalysis(rs.getString(11));
		    		 model.setComments(rs.getString(12));
		    		 model.setRetired(rs.getString(13));
		    		 model.setDateRetired(rs.getDate(14));
		    		 model.setLorryNo(rs.getString(15));
		    		 model.setBrandId(rs.getInt(16));
				 }				 
			 } catch (SQLException e) {
				 throw e;
			 } finally {
				 TransportUtils.closeObjects(rs);
				 TransportUtils.closeObjects(pstmt);
				 TransportUtils.closeObjects(conn);
			 }	 
		 		     
		     if (model!=null) {
		    	 returnMap = new HashMap<String, Object>();
		    	 returnMap.put(MapConstant.CLASS_DATA, model);
		     } 
	     
	    System.out.println("getDataById() - Exit");
		return returnMap;
	}
	
	/**
	 * this method is used to get the available tires
	 */
	@Override
	public Map<String, Object> getActiveData() throws Exception {
		// TODO Auto-generated method stub
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_GET_ACTIVE_DATA);
		 
		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
		     Map<String, Object> returnMap = null;
			 List<Tire> rsList = new ArrayList<Tire>();
			  
			 try {
				 conn = ServerContext.getJDBCHandle();
		
				 StringBuffer  sql = new StringBuffer("select t.id,b.name as brand,t.serialno,t.recapno,t.sizeandply,t.price,t.datepurchased,");
			 		sql.append(" t.datepurchasedforrecap1,t.datepurchasedforrecap2,t.invoiceno,t.analysis,t.comments,t.retired,t.dateretired,");
			 		sql.append(" t.lorryno,t.createdby,t.createdon,t.modifiedby,t.modifiedon,t.version,t.active ");			 	
				 	sql.append(" from transport.file_tire t inner join transport.file_tire_brand b on t.brandid = b.id ");
				 	sql.append(" where t.active = true ");
				 	sql.append(" and (t.lorryno is null or t.lorryno = '') ");//available tires
				 	sql.append(" order by b.name,t.serialno ");

				 TransportUtils.writeLogDebug(logger, "SQL: "+sql.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 rs = pstmt.executeQuery();
				 
				 while(rs.next()) {
					 //get the model criteria
					 Tire model = new Tire();
					 model.setId(rs.getInt(1));
		    		 model.setBrandName(rs.getString(2));
		    		 model.setSerialNo(rs.getString(3));
		    		 model.setRecapNo(rs.getString(4));
		    		 model.setSizeAndPly(rs.getString(5));
		    		 model.setPrice(rs.getBigDecimal(6));
		    		 model.setDatePurchased(rs.getDate(7));
		    		 model.setDatePurchasedForRecap1(rs.getDate(8));
		    		 model.setDatePurchasedForRecap2(rs.getDate(9));
		    		 model.setInvoiceNo(rs.getString(10));
		    		 model.setAnalysis(rs.getString(11));
		    		 model.setComments(rs.getString(12));
		    		 model.setRetired(rs.getString(13));
		    		 model.setDateRetired(rs.getDate(14));
		    		 model.setLorryNo(rs.getString(15));
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

	@Override
	public Map<String, Object> getInActiveData(HashMap<String, Object> criteriaMap) throws Exception {
		// TODO Auto-generated method stub
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_GET_INACTIVE_DATA);
		
		 //get the pagination and offset
		 int offset = (int) criteriaMap.get(MapConstant.PAGINATION_OFFSET);
		 int limit = (int) criteriaMap.get(MapConstant.PAGINATION_LIMIT);
		 
		 	//Connection using JNDI DBCP
			 Connection conn = null;
			 ResultSet rs = null;;
			 PreparedStatement pstmt = null;
		     Map<String, Object> returnMap = null;
			 List<Tire> rsList = new ArrayList<Tire>();
			  
			 try {
				 conn = ServerContext.getJDBCHandle();

				 StringBuffer  sql = new StringBuffer("select t.id,b.name as brand,t.serialno,t.recapno,t.sizeandply,t.price,t.datepurchased,");
			 		sql.append(" t.datepurchasedforrecap1,t.datepurchasedforrecap2,t.invoiceno,t.analysis,t.comments,t.retired,t.dateretired,");
			 		sql.append(" t.lorryno,t.createdby,t.createdon,t.modifiedby,t.modifiedon,t.version,t.active ");			 	
				 	sql.append(" from transport.file_tire t inner join transport.file_tire_brand b on t.brandid = b.id ");
				 	sql.append(" where t.active = false ");
				 	sql.append(" order by b.name,t.serialno ");
				 	sql.append(" limit ? ");
				 	sql.append(" offset ? ");
			
				 TransportUtils.writeLogDebug(logger, "SQL: "+sql.toString());
			
				 pstmt = conn.prepareStatement(sql.toString());
				 
				 pstmt.setInt(1, limit);
				 pstmt.setInt(2, offset);
				 
				 rs = pstmt.executeQuery();
 
				 while(rs.next()) {
					 //get the model criteria
					 Tire model = new Tire();
					 model.setId(rs.getInt(1));
		    		 model.setBrandName(rs.getString(2));
		    		 model.setSerialNo(rs.getString(3));
		    		 model.setRecapNo(rs.getString(4));
		    		 model.setSizeAndPly(rs.getString(5));
		    		 model.setPrice(rs.getBigDecimal(6));
		    		 model.setDatePurchased(rs.getDate(7));
		    		 model.setDatePurchasedForRecap1(rs.getDate(8));
		    		 model.setDatePurchasedForRecap2(rs.getDate(9));
		    		 model.setInvoiceNo(rs.getString(10));
		    		 model.setAnalysis(rs.getString(11));
		    		 model.setComments(rs.getString(12));
		    		 model.setRetired(rs.getString(13));
		    		 model.setDateRetired(rs.getDate(14));
		    		 model.setLorryNo(rs.getString(15));
		    		 rsList.add(model);
				 }				 
			 } catch (SQLException e) {
				 throw e;
			 } finally {
				 TransportUtils.closeObjects(rs);
				 TransportUtils.closeObjects(pstmt);
				 TransportUtils.closeObjects(conn);
			 }	 
		 		     
		     //get the total of records
		     int  totalNoOfRecords = 0;
		     StringBuffer sqlCount = null;
			 
		     try {
		    	 conn = ServerContext.getJDBCHandle();
		    	 
			    sqlCount = new StringBuffer("select count(*) from transport.file_tire where active = false");	 
					
				TransportUtils.writeLogDebug(logger, "SQL: "+sqlCount.toString());
				
		    	 pstmt = conn.prepareStatement(sqlCount.toString());
		    	 
		    	 rs = pstmt.executeQuery();
		    	 if (rs.next()) {
		    		 totalNoOfRecords = rs.getInt(1);
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
		    	 returnMap.put(MapConstant.PAGINATION_TOTALRECORDS, totalNoOfRecords);
		     } 
	     
		return returnMap;
	}
	
	@Override
	public Map<String, Object> restore(HashMap<String, Object> dataMap) throws Exception{
		// TODO Auto-generated method stub
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_RESTORE);

		
		//DBCP JNDI
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean status = false;
		
		Tire model = (Tire) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update transport.file_tire set ");	
			qry.append(" active=true ");
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");

		TransportUtils.writeLogDebug(logger, "SQL: "+qry.toString());
	
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
				System.out.println("Tire record (id: " +model.getId()+") restored successfully..");
				status = true;
			}
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			TransportUtils.closeObjects(rs);
			TransportUtils.closeObjects(pstmt);
			TransportUtils.closeObjects(conn);
		}
			 		
		returnMap.put(MapConstant.TRANSACTION_STATUS, status);			
		
		return returnMap;
	}

	/**
	 * This method will be used in Tire Management for Lorry
	 */
	@Override
	public Boolean updateLorryNoBySerialNo(HashMap<String, Object> dataMap) throws Exception {
		// TODO Auto-generated method stub
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_UPDATE);
		 
		//DBCP JNDI
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean status = false;
		
		Tire model = (Tire) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update transport.file_tire set ");	
			qry.append(" lorryno=? "); 
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" serialno = ? ");

				
		TransportUtils.writeLogDebug(logger, "SQL: "+qry.toString());
	
		 try {
			conn = ServerContext.getJDBCHandle();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(qry.toString());
				     
			pstmt.setString(1, model.getLorryNo());
			pstmt.setInt(2, model.getModifiedBy());
			pstmt.setTimestamp(3, model.getModifiedOn());
			pstmt.setString(4, model.getSerialNo());
				     
			int statusInt = pstmt.executeUpdate();
				     
			if (statusInt == 1) {
				conn.commit();
				System.out.println("Tire record (id: " +model.getId()+") updated successfully..");
				status = true;
			}
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			TransportUtils.closeObjects(rs);
			TransportUtils.closeObjects(pstmt);
			TransportUtils.closeObjects(conn);
		}
		
		return status;
	}

	@Override
	public Map<String, Object> updateRecapNo(HashMap<String, Object> dataMap) throws Exception {
		// TODO Auto-generated method stub
		TransportUtils.writeLogInfo(logger, MiscConstant.LOGGING_MESSSAGE_UPDATE);
		 
		//DBCP JNDI
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean status = false;
		
		Tire model = (Tire) dataMap.get(MapConstant.CLASS_DATA);
		User user = (User) dataMap.get(MapConstant.USER_SESSION_DATA);
		
		if (user!=null) {
			model.setModifiedBy((int) user.getId());	
		}
		model.setModifiedOn(new Timestamp(new java.util.Date().getTime()));
		
		StringBuffer qry =  new StringBuffer("update transport.file_tire set ");	
			qry.append(" recapno=? ");
			if (model.getRecapNo().equals("N/A")) {
				qry.append(" ,datepurchased=? ");
			} else if (model.getRecapNo().equals("1")) {
				qry.append(" ,datepurchasedforrecap1=? ");
			} else if (model.getRecapNo().equals("2")) {
				qry.append(" ,datepurchasedforrecap2=? ");
			}
			qry.append(" ,modifiedby=? ");
			qry.append(" ,modifiedon=? ");
			qry.append(" ,version=(version+1) ");
			qry.append(" where ");
			qry.append(" id = ? ");

		TransportUtils.writeLogDebug(logger, "SQL: "+qry.toString());
	
		 try {
			conn = ServerContext.getJDBCHandle();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(qry.toString());
				     
			pstmt.setString(1, model.getRecapNo());
			if (model.getRecapNo().equals("N/A")) {
				pstmt.setDate(2, model.getDatePurchased());
			} else if (model.getRecapNo().equals("1")) {
				pstmt.setDate(2, model.getDatePurchasedForRecap1());
			} else if (model.getRecapNo().equals("2")) {
				pstmt.setDate(2, model.getDatePurchasedForRecap2());
			}
			pstmt.setInt(3, model.getModifiedBy());
			pstmt.setTimestamp(4, model.getModifiedOn());
			pstmt.setLong(5, model.getId());
				     
			int statusInt = pstmt.executeUpdate();
				     
			if (statusInt == 1) {
				conn.commit();
				System.out.println("Tire record (recap) (id: " +model.getId()+") updated successfully..");
				status = true;
			}
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			TransportUtils.closeObjects(rs);
			TransportUtils.closeObjects(pstmt);
			TransportUtils.closeObjects(conn);
		}
			 		
		returnMap.put(MapConstant.TRANSACTION_STATUS, status);	
		
		return returnMap;
	}
	
}
