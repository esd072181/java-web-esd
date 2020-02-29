package com.pibs.form;

import org.apache.struts.action.ActionForm;

/**
 * 
 * @author dward
 * Last Date Updated: 16Apr2017
 */
public class LoginFormBean extends ActionForm{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String password;
	
	private String userAccountValidated;
	
	
	public String getUserAccountValidated() {
		return userAccountValidated;
	}
	public void setUserAccountValidated(String userAccountValidated) {
		this.userAccountValidated = userAccountValidated;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
