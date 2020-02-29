package com.sims.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sims.constant.SIMSConstant;
import com.sims.model.UserAccount;
import com.sims.util.SIMSUtil;


@Controller
@SessionAttributes(value =  {"userid","roleid"})
public class MainController {
	
	private final static Logger logger = Logger.getLogger(MainController.class);
	
	@RequestMapping("/goToMain")
	public ModelAndView goToMain(ModelMap model) {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		return new ModelAndView("main/home");
	}
	
}
