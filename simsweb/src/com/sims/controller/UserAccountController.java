package com.sims.controller;

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

import com.sims.bo.ListValueBo;
import com.sims.bo.EmployeeBo;
import com.sims.bo.UserAccountBo;
import com.sims.constant.SIMSConstant;
import com.sims.model.ListValue;
import com.sims.model.Employee;
import com.sims.model.UserAccount;
import com.sims.util.SIMSUtil;
import com.sims.validator.UserAccountValidator;

@Controller
@SessionAttributes("userid")
public class UserAccountController {
	
	private final static Logger logger = Logger.getLogger(UserAccountController.class);
	
	@Autowired
	private UserAccountBo userAccountBo;
	@Autowired
	private EmployeeBo employeeBo;
	@Autowired
	private ListValueBo listValueBo;
	
	@Autowired
	private UserAccountValidator userAccountValidator;
	
	private List<ListValue> roleTypeList = new ArrayList<>();
	private List<Employee> empList = new ArrayList<>();
	
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
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
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
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		empList = getEmpList();
				
		model.addAttribute("roleTypeList", roleTypeList);
		model.addAttribute("empList", empList);
		
		return new ModelAndView("masterfile/useraccount/addUserAccount", "userAccount", new UserAccount());
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/searchUserAccount")
	public ModelAndView searchUserAccount(@RequestParam("page") String page, @ModelAttribute("userAccount") UserAccount userAccount, 
    			BindingResult result, ModelMap model) throws Exception {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		//Note: can use modelattribute in a form in jsp
		//or can simply pass a parameter
		
		Map<Object,Object> mapCriteria = new HashMap<Object,Object>();
		
		mapCriteria.put("search_criteria", userAccount.getEmp().getLastName()!=null ? userAccount.getEmp().getLastName() : "");
		mapCriteria.put("record_start", SIMSUtil.getRecordStartIndex(page!=null ? Integer.parseInt(page) : 1));
		mapCriteria.put("max_result", SIMSConstant.RECORDS_PER_PAGE);
		
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
				
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		model.addAttribute("roleTypeList", roleTypeList);
		model.addAttribute("empList", empList);
		
		if (result.hasErrors()) {
			return new ModelAndView("masterfile/useraccount/addUserAccount", "userAccount", userAccount);
		}
		     
		userAccount.setCreatedBy(SIMSUtil.getUserIdFromSession(model));
		
		boolean isSuccess = userAccountBo.save(userAccount);
		
		model.addAttribute("isSuccess", isSuccess);
		
		return new ModelAndView("masterfile/useraccount/addUserAccount", "userAccount", userAccount);
	}
	
		
	@RequestMapping(value = "/editUserAccount", method=RequestMethod.GET)
	public ModelAndView editUserAccount(@RequestParam("id") int patientiId, ModelMap model) throws Exception {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		model.addAttribute("roleTypeList", roleTypeList);
		
		UserAccount resultEntity = userAccountBo.findById(patientiId);
		return new ModelAndView("masterfile/useraccount/editUserAccount", "userAccount", resultEntity);
	}
		
	@RequestMapping(value = "/updateUserAccount", method = RequestMethod.POST)
	public ModelAndView updateUserAccount(@ModelAttribute("userAccount" ) @Validated UserAccount userAccount, 
		      BindingResult result, ModelMap model) throws Exception {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		model.addAttribute("roleTypeList", roleTypeList);
		
	    if (result.hasErrors()) {
	    	return new ModelAndView("masterfile/useraccount/editUserAccount", "userAccount", userAccount);
	    }
	          
	    userAccount.setModifiedBy(SIMSUtil.getUserIdFromSession(model));
	    
		boolean isSuccess = userAccountBo.update(userAccount);
		
		model.addAttribute("isSuccess", isSuccess);
		
		return new ModelAndView("masterfile/useraccount/editUserAccount", "userAccount", userAccount);
	}
	
	@RequestMapping(value = "/deleteUserAccount", method=RequestMethod.GET)
	public ModelAndView deleteUserAccount(@RequestParam("id") int id, ModelMap model) throws Exception {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		model.addAttribute("roleTypeList", roleTypeList);
		
		UserAccount user = userAccountBo.findById(id);
		
		user.setModifiedBy(SIMSUtil.getUserIdFromSession(model));
		
		boolean isSuccess =  userAccountBo.delete(user);
		model.addAttribute("isDeleted", isSuccess);
		
		return new ModelAndView("masterfile/useraccount/searchUserAccount", "userAccount", new UserAccount());
	}
		
	private List<ListValue> getRoleTypeList() {
		
		List<ListValue> list = new ArrayList<>();
		
		List<ListValue> lovList = listValueBo.getAllLOV();
		for (ListValue item : lovList) {
			//Filter for UserAccount Type ListTypeId = 5
			if (item.getListTypeId() == 5) {
				list.add(item);
			}
		}
		
		return list;
	}

	private List<Employee> getEmpList() {
		
		List<Employee> list = employeeBo.getAllWithNoUserAccount();
		
		return list;
	}
	
}
