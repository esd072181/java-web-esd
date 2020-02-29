package com.pibs.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.pibs.constant.ParamConstant;
import com.pibs.model.User;

public class ChangeUsernameFormBean extends PIBSFormBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String userName;
	private String password;
	private String reEnterPassword;
		
	private boolean transactionStatus;
	private String transactionMessage;
	
	public ChangeUsernameFormBean() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public boolean isTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(boolean transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public String getTransactionMessage() {
		return transactionMessage;
	}

	public void setTransactionMessage(String transactionMessage) {
		this.transactionMessage = transactionMessage;
	}
	
	public void populateFormBean(User model) {
		setId(model.getId());
		setUserName(model.getUserName());
		setPassword(model.getPassword());
	}
	
	public User populateModel (ChangeUsernameFormBean formbean) {
		User model = new User();
		model.setId(formbean.getId());
		model.setUserName(formbean.getUserName());
		model.setPassword(formbean.getPassword());
		return model;
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		ActionErrors errors = new ActionErrors();
		
		String command = (String) request.getParameter("command"); 
		
		if (command!=null && command.equalsIgnoreCase(ParamConstant.AJAX_UPDATE)) {
			if (this.getUserName()==null || this.getUserName().trim().length() < 1) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("mf.username.req"));
			}
			if (this.getPassword()==null || this.getPassword().trim().length() < 1) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("mf.password.req"));
			}
			if (!this.getPassword().trim().equals(this.getReEnterPassword().trim())) {
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("mf.passwordnotmatch.req"));
			}
		} 
	
		return errors;
	}

	public String getReEnterPassword() {
		return reEnterPassword;
	}

	public void setReEnterPassword(String reEnterPassword) {
		this.reEnterPassword = reEnterPassword;
	}			
	
	
	
}
