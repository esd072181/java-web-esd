package com.transport.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import javax.sql.DataSource;

//import org.springframework.jdbc.core.JdbcTemplate;


import com.transport.config.ServerContext;
import com.transport.constant.MapConstant;
import com.transport.dao.LoginDao;
import com.transport.model.User;
import com.transport.util.EncryptUtil;
import com.transport.util.TransportUtils;

public class LoginDaoImpl implements LoginDao {
	
//	 private DataSource dataSource;
//	 
//	    public void setDataSource(DataSource dataSource) {
//	        this.dataSource = dataSource;
//	    }
		@Override
		public void init() {
			 System.out.println("init(): Initialization part here for LoginDaoImpl....");
		}
		
		@Override
		public void destroy() {
			System.out.println("destroy(): After calling the context.close() code here for LoginDaoImpl....");
		}

		@Override
		public Map<String, Object> validateUserAccount(User user) throws Exception{
			// TODO Auto-generated method stub
			 System.out.println("LoginDaoImpl validateUserAccount() - Entry");
			 		     
		     //use DBCP JNDI
		     Connection conn = null;
		     PreparedStatement pstmt = null;
		     ResultSet rs = null;
		     Map<String, Object> returnMap = null;
		     List<User> rsList = new ArrayList<User>();
		     
		     StringBuffer qry =  new StringBuffer("select a.id");
		     		qry.append(",b.firstname||' '||b.lastname as name ");
		     		qry.append(",c.id as roleid ");
		     		qry.append(",c.listvalue as role ");
		     		qry.append(",a.username ");
		     		qry.append(",b.id ");
		     		qry.append(",a.password ");
		     		qry.append(",a.createdby ");
		     		qry.append(",a.createdon ");
		     		qry.append(",a.modifiedby ");
		     		qry.append(",a.modifiedon ");
		     		qry.append(",a.version ");
		     		qry.append(",a.active ");
		     		qry.append(" from transport.file_user a, transport.file_employee b, transport.list_value c ");
		     		qry.append(" where a.employeeid = b.id ");
		     		qry.append(" and a.roleid = c.id ");
		     		qry.append(" and a.active = true ");//both user account and employee is active
		     		qry.append(" and b.active = true ");
		     		qry.append(" and username = ? ");
		     		qry.append(" and password = ? ");
		     
		     try {
			     conn = ServerContext.getJDBCHandle();
			     pstmt = conn.prepareStatement(qry.toString());
			     
			     pstmt.setString(1, user.getUserName());
			     pstmt.setString(2, EncryptUtil.encrypt(user.getPassword()));
			     
			     rs = pstmt.executeQuery();
			     
			     if(rs.next()) {
			    	 User dto = new User();
			    	 dto.setId(rs.getInt(1));
			    	 dto.setName(rs.getString(2));
			    	 dto.setRoleId(rs.getInt(3));
			    	 dto.setRole(rs.getString(4));
			    	 dto.setUserName(rs.getString(5));
			    	 dto.setEmployeeId(rs.getInt(6));
			    	 rsList.add(dto);
			     } else {
			    	 rsList = null;
			     }
		     } catch (Exception e) {
		    	 e.printStackTrace();
		     } finally {
				TransportUtils.closeObjects(rs);
				TransportUtils.closeObjects(pstmt);
				TransportUtils.closeObjects(conn);
		     }
		     
		     if (rsList!=null && !rsList.isEmpty()) {
		    	 returnMap = new HashMap<String, Object>();
		    	 returnMap.put(MapConstant.CLASS_DATA, rsList.get(0));
		     }
		     
			 //uses Spring JDBC
//			 String qry = "select * from pibs.file_user where username = ?  and password = ? ";
//		        	 
//		     JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//		 
//		     List<Map<String, Object>> rsList = jdbcTemplate.queryForList(qry, new Object[] { user.getUserName(), user.getPassword()});
//
//		     Map<String, Object> returnMap = null;
//		     
//		     if (rsList!=null && !rsList.isEmpty()) {
//		    	 returnMap = new HashMap<String, Object>();
//		    	 returnMap.put(MapConstant.CLASS_DATA, rsList.get(0));
//		     }		     
		     
		    System.out.println("LoginDaoImpl validateUserAccount() - Exit");
			return returnMap;
		}
    
}
