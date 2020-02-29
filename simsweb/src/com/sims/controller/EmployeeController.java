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
import com.sims.constant.SIMSConstant;
import com.sims.model.ListValue;
import com.sims.model.Employee;
import com.sims.model.UserAccount;
import com.sims.util.SIMSUtil;
import com.sims.validator.EmployeeValidator;

@Controller
@SessionAttributes("userid")
public class EmployeeController {
	
	private final static Logger logger = Logger.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeBo employeeBo;
	@Autowired
	private ListValueBo listValueBo;
	
	@Autowired
	private EmployeeValidator employeeValidator;
	
	private List<ListValue> empTypeList = new ArrayList<>();
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
				
        binder.registerCustomEditor(ListValue.class, new PropertyEditorSupport() {
        	@Override
			public void setAsText(String id) throws IllegalArgumentException {
			        this.setValue(new ListValue(Integer.parseInt(id)));
			}
        });
 
        if (binder.getObjectName().equals("employee")) {
        	binder.addValidators(employeeValidator);	
        }
		
	}
	
	@RequestMapping("/goToSearchEmployee")
	public ModelAndView goToSearchEmployee(ModelMap model) {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		empTypeList = getEmployeeTypeList();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("searchFlag", false);
		mv.addObject("employee", new Employee());
		mv.setViewName("masterfile/employee/searchEmployee");
		return mv;
//		return new ModelAndView("masterfile/employee/searchEmployee", "employee", new Employee());
	}
	
	@RequestMapping("/goToAddEmployee")
	public ModelAndView goToAddEmployee(ModelMap model) {
				
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		model.addAttribute("empTypeList", empTypeList);
		
		return new ModelAndView("masterfile/employee/addEmployee", "employee", new Employee());
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/searchEmployee")
	public ModelAndView searchEmployee(@RequestParam("page") String page, @ModelAttribute("employee") Employee professional, 
    			BindingResult result, ModelMap model) throws Exception {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		//Note: can use modelattribute in a form in jsp
		//or can simply pass a parameter
		
		Map<Object,Object> mapCriteria = new HashMap<Object,Object>();
		
		mapCriteria.put("search_criteria", professional.getLastName()!=null ? professional.getLastName() : "");
		mapCriteria.put("record_start", SIMSUtil.getRecordStartIndex(page!=null ? Integer.parseInt(page) : 1));
		mapCriteria.put("max_result", SIMSConstant.RECORDS_PER_PAGE);
		
		Map<Object,Object> resultMap = employeeBo.findByLastName(mapCriteria);
		
		List<Employee> resultList = (List<Employee>) resultMap.get("resultList");
		Integer noOfPages = (Integer) resultMap.get("noOfPages");
		
		boolean gotRecords = resultList!=null && resultList.size() > 0 ? true : false;
		
		model.addAttribute("resultList", resultList);
		model.addAttribute("searchFlag", true);
		model.addAttribute("gotRecords", gotRecords);
		model.addAttribute("currentPage", page);
		model.addAttribute("noOfPages", noOfPages);
		
		return new ModelAndView("masterfile/employee/searchEmployee", "employee", professional);
	}
		
	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("employee") @Validated Employee professional, 
		      BindingResult result, ModelMap model) throws Exception {
				
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		model.addAttribute("empTypeList", empTypeList);
		
		if (result.hasErrors()) {
			return new ModelAndView("masterfile/employee/addEmployee", "employee", professional);
		}
		
		professional.setCreatedBy(SIMSUtil.getUserIdFromSession(model));
		     
		boolean isSuccess = employeeBo.save(professional);
		model.addAttribute("isSuccess", isSuccess);
		
		return new ModelAndView("masterfile/employee/addEmployee", "employee", professional);
	}
	
		
	@RequestMapping(value = "/editEmployee", method=RequestMethod.GET)
	public ModelAndView editEmployee(@RequestParam("id") int patientiId, ModelMap model) throws Exception {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		model.addAttribute("empTypeList", empTypeList);
		
		Employee resultEntity = employeeBo.findById(patientiId);
		return new ModelAndView("masterfile/employee/editEmployee", "employee", resultEntity);
	}
		
	@RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
	public ModelAndView updateEmployee(@ModelAttribute("employee" ) @Validated Employee professional, 
		      BindingResult result, ModelMap model) throws Exception {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		model.addAttribute("empTypeList", empTypeList);
		
	    if (result.hasErrors()) {
	    	return new ModelAndView("masterfile/employee/editEmployee");
	    }
	     
	    professional.setModifiedBy(SIMSUtil.getUserIdFromSession(model));
	    
		boolean isSuccess = employeeBo.update(professional);
		
		model.addAttribute("isSuccess", isSuccess);
		
		return new ModelAndView("masterfile/employee/editEmployee");
	}
	
	@RequestMapping(value = "/deleteEmployee", method=RequestMethod.GET)
	public ModelAndView deleteEmployee(@RequestParam("id") int id, ModelMap model) throws Exception {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		Employee professional = employeeBo.findById(id);
		professional.setModifiedBy(SIMSUtil.getUserIdFromSession(model));
		
		boolean isSuccess =  employeeBo.delete(professional);
		model.addAttribute("isDeleted", isSuccess);
		
		return new ModelAndView("masterfile/employee/searchEmployee", "employee", new Employee());
	}
		
	private List<ListValue> getEmployeeTypeList() {
		
		List<ListValue> empTypeList = new ArrayList<>();
		
		List<ListValue> lovList = listValueBo.getAllLOV();
		for (ListValue item : lovList) {
			//Filter for Employee Type ListTypeId = 4
			if (item.getListTypeId() == 4) {
				empTypeList.add(item);
			}
		}
		
		return empTypeList;
	}
	
}
