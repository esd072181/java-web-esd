package com.lrms.controller;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.lrms.bo.ListValueBo;
import com.lrms.bo.ProfessionalBo;
import com.lrms.bo.UserAccountBo;
import com.lrms.constant.LRMSConstant;
import com.lrms.model.ListValue;
import com.lrms.model.Professional;
import com.lrms.model.UserAccount;
import com.lrms.util.LRMSUtil;
import com.lrms.validator.UserAccountValidator;

@Controller
@SessionAttributes("userid")
public class UserAccountController {
	
	private final static Logger logger = Logger.getLogger(UserAccountController.class);
	
	@Autowired
	private UserAccountBo userAccountBo;
	@Autowired
	private ProfessionalBo professionalBo;
	@Autowired
	private ListValueBo listValueBo;
	
	@Autowired
	private UserAccountValidator userAccountValidator;
	
	private List<ListValue> roleTypeList = new ArrayList<>();
	private List<Professional> profList = new ArrayList<>();
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
				
        binder.registerCustomEditor(ListValue.class, new PropertyEditorSupport() {
        	@Override
			public void setAsText(String id) throws IllegalArgumentException {
			        this.setValue(new ListValue(Integer.parseInt(id)));
			}
        });
 
        if (binder.getObjectName().equals("userAccount")) {
        	binder.addValidators(userAccountValidator);	
        }
		
	}
	
	@RequestMapping("/goToSearchUserAccount")
	public ModelAndView goToSearchUserAccount(ModelMap model) {
		
		if (!LRMSUtil.isUserSessionValid(model)) {
			logger.info(LRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		roleTypeList = getRoleTypeList();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("searchFlag", false);
		mv.addObject("userAccount", new UserAccount());
		mv.setViewName("masterfile/useraccount/searchUserAccount");
		return mv;
	}
	
	@RequestMapping("/goToAddUserAccount")
	public ModelAndView goToAddUserAccount(ModelMap model) {
		
		if (!LRMSUtil.isUserSessionValid(model)) {
			logger.info(LRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		profList = getProfList();
				
		model.addAttribute("roleTypeList", roleTypeList);
		model.addAttribute("profList", profList);
		
		return new ModelAndView("masterfile/useraccount/addUserAccount", "userAccount", new UserAccount());
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/searchUserAccount")
	public ModelAndView searchUserAccount(@RequestParam("page") String page, @ModelAttribute("userAccount") UserAccount userAccount, 
    			BindingResult result, ModelMap model) throws Exception {
		
		if (!LRMSUtil.isUserSessionValid(model)) {
			logger.info(LRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		//Note: can use modelattribute in a form in jsp
		//or can simply pass a parameter
		
		Map<Object,Object> mapCriteria = new HashMap<Object,Object>();
		
		mapCriteria.put("search_criteria", userAccount.getProf().getLastName()!=null ? userAccount.getProf().getLastName() : "");
		mapCriteria.put("record_start", LRMSUtil.getRecordStartIndex(page!=null ? Integer.parseInt(page) : 1));
		mapCriteria.put("max_result", LRMSConstant.RECORDS_PER_PAGE);
		
		Map<Object,Object> resultMap = userAccountBo.findBy(mapCriteria);
		
		List<UserAccount> resultList = (List<UserAccount>) resultMap.get("resultList");
		Integer noOfPages = (Integer) resultMap.get("noOfPages");
		
		boolean gotRecords = resultList!=null && resultList.size() > 0 ? true : false;
		
		model.addAttribute("resultList", resultList);
		model.addAttribute("searchFlag", true);
		model.addAttribute("gotRecords", gotRecords);
		model.addAttribute("currentPage", page);
		model.addAttribute("noOfPages", noOfPages);
		
		return new ModelAndView("masterfile/useraccount/searchUserAccount", "userAccount", userAccount);
	}
		
	@RequestMapping(value = "/saveUserAccount", method = RequestMethod.POST)
	public ModelAndView saveUserAccount(@ModelAttribute("userAccount") @Validated UserAccount userAccount, 
		      BindingResult result, ModelMap model) throws Exception {
				
		if (!LRMSUtil.isUserSessionValid(model)) {
			logger.info(LRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		model.addAttribute("roleTypeList", roleTypeList);
		model.addAttribute("profList", profList);
		
		if (result.hasErrors()) {
			return new ModelAndView("masterfile/useraccount/addUserAccount", "userAccount", userAccount);
		}
		     
		userAccount.setCreatedBy(LRMSUtil.getUserIdFromSession(model));
		
		boolean isSuccess = userAccountBo.save(userAccount);
		
		model.addAttribute("isSuccess", isSuccess);
		
		return new ModelAndView("masterfile/useraccount/addUserAccount", "userAccount", userAccount);
	}
	
		
	@RequestMapping(value = "/editUserAccount", method=RequestMethod.GET)
	public ModelAndView editUserAccount(@RequestParam("id") int patientiId, ModelMap model) throws Exception {
		
		if (!LRMSUtil.isUserSessionValid(model)) {
			logger.info(LRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		model.addAttribute("roleTypeList", roleTypeList);
		
		UserAccount resultEntity = userAccountBo.findById(patientiId);
		return new ModelAndView("masterfile/useraccount/editUserAccount", "userAccount", resultEntity);
	}
		
	@RequestMapping(value = "/updateUserAccount", method = RequestMethod.POST)
	public ModelAndView updateUserAccount(@ModelAttribute("userAccount" ) @Validated UserAccount userAccount, 
		      BindingResult result, ModelMap model) throws Exception {
		
		if (!LRMSUtil.isUserSessionValid(model)) {
			logger.info(LRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		model.addAttribute("roleTypeList", roleTypeList);
		
	    if (result.hasErrors()) {
	    	return new ModelAndView("masterfile/useraccount/editUserAccount", "userAccount", userAccount);
	    }
	          
	    userAccount.setModifiedBy(LRMSUtil.getUserIdFromSession(model));
	    
		boolean isSuccess = userAccountBo.update(userAccount);
		
		model.addAttribute("isSuccess", isSuccess);
		
		return new ModelAndView("masterfile/useraccount/editUserAccount", "userAccount", userAccount);
	}
	
	@RequestMapping(value = "/deleteUserAccount", method=RequestMethod.GET)
	public ModelAndView deleteUserAccount(@RequestParam("id") int id, ModelMap model) throws Exception {
		
		if (!LRMSUtil.isUserSessionValid(model)) {
			logger.info(LRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		model.addAttribute("roleTypeList", roleTypeList);
		
		UserAccount user = userAccountBo.findById(id);
		
		user.setModifiedBy(LRMSUtil.getUserIdFromSession(model));
		
		boolean isSuccess =  userAccountBo.delete(user);
		model.addAttribute("isDeleted", isSuccess);
		
		return new ModelAndView("masterfile/useraccount/searchUserAccount", "userAccount", new UserAccount());
	}
		
	private List<ListValue> getRoleTypeList() {
		
		List<ListValue> list = new ArrayList<>();
		
		List<ListValue> lovList = listValueBo.getAllLOV();
		for (ListValue item : lovList) {
			//Filter for UserAccount Type ListTypeId = 6
			if (item.getListTypeId() == 6) {
				list.add(item);
			}
		}
		
		return list;
	}

	private List<Professional> getProfList() {
		
		List<Professional> list = professionalBo.getAllWithNoUserAccount();
		
		return list;
	}
	
}
