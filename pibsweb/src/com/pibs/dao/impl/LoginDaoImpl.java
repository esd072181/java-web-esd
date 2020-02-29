package com.pibs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import javax.sql.DataSource;

//import org.springframework.jdbc.core.JdbcTemplate;


import com.pibs.config.ServerContext;
import com.pibs.constant.MapConstant;
import com.pibs.dao.LoginDao;
import com.pibs.model.User;
import com.pibs.util.PIBSUtils;

public class LoginDaoImpl implements LoginDao{
	
//	 private DataSource dataSource;
//	 
//	    public void setDataSource(DataSource dataSource) {
//	        this.dataSource = dataSource;
//	    }

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
	     		qry.append(",a.password ");
	     		qry.append(",a.createdby ");
	     		qry.append(",a.createdon ");
	     		qry.append(",a.modifiedby ");
	     		qry.append(",a.modifiedon ");
	     		qry.append(",a.version ");
	     		qry.append(",a.active ");
	     		qry.append(" from pibs.file_user a, pibs.file_employee b, pibs.list_value c ");
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
			     pstmt.setString(2, user.getPassword());//update for Password Encryption
			     
			     rs = pstmt.executeQuery();
			     
			     if(rs.next()) {
			    	 User dto = new User();
			    	 dto.setId(rs.getInt(1));
			    	 dto.setName(rs.getString(2));
			    	 dto.setRoleId(rs.getInt(3));
			    	 dto.setRole(rs.getString(4));
			    	 dto.setUserName(rs.getString(5));
			    	 dto.setPassword(rs.getString(6));
			    	 rsList.add(dto);
			     } else {
			    	 rsList = null;
			     }
		     } catch (Exception e) {
		    	 e.printStackTrace();
		     } finally {
				PIBSUtils.closeObjects(rs);
				PIBSUtils.closeObjects(pstmt);
				PIBSUtils.closeObjects(conn);
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
