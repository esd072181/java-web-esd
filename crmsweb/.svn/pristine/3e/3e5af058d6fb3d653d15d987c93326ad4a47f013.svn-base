package com.crms.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.crms.constant.CRMSConstant;
import com.crms.model.UserAccount;
import com.crms.util.CRMSUtil;


@Controller
@SessionAttributes(value =  {"userid","roleid"})
public class MainController {
	
	private final static Logger logger = Logger.getLogger(MainController.class);
	
	@RequestMapping("/goToMain")
	public ModelAndView goToMain(ModelMap model) {
		
		if (!CRMSUtil.isUserSessionValid(model)) {
			logger.info(CRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		return new ModelAndView("main/home");
	}
	
}
