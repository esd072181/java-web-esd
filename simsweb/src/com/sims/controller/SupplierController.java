package com.sims.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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

import com.sims.bo.SupplierBo;
import com.sims.constant.SIMSConstant;
import com.sims.model.Supplier;
import com.sims.model.UserAccount;
import com.sims.util.SIMSUtil;
import com.sims.validator.SupplierValidator;

/**
 * 
 * @author dward
 *
 */
@Controller
@SessionAttributes("userid")
public class SupplierController {
	
	private final static Logger logger = Logger.getLogger(SupplierController.class);
	
	@Autowired
	private SupplierBo supplierBo;
	
	@Autowired
	private SupplierValidator supplierValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        dateFormat.setLenient(false);
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		
	    if (binder.getObjectName().equals("supplier")) {
			binder.addValidators(supplierValidator);			
		}

	}
	
	@RequestMapping("/goToSearchSupplier")
	public ModelAndView goToSearchSupplier(ModelMap model) {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		model.addAttribute("searchFlag", false);
		return new ModelAndView("masterfile/supplier/searchSupplier", "supplier", new Supplier());
	}
	
	@RequestMapping("/goToAddSupplier")
	public ModelAndView goToAddSupplier(ModelMap model) {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		return new ModelAndView("masterfile/supplier/addSupplier", "supplier", new Supplier());
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/searchSupplier")
	public ModelAndView searchSupplier(@RequestParam("page") String page, @ModelAttribute("supplier") Supplier supplier, 
    			BindingResult result, ModelMap model) throws Exception {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		//Note: can use modelattribute in a form in jsp
		//or can simply pass a parameter
		
		Map<Object,Object> mapCriteria = new HashMap<Object,Object>();
		
		mapCriteria.put("search_criteria", supplier.getName()!=null ? supplier.getName() : "");
		mapCriteria.put("record_start", SIMSUtil.getRecordStartIndex(page!=null ? Integer.parseInt(page) : 1));
		mapCriteria.put("max_result", SIMSConstant.RECORDS_PER_PAGE);
		
		Map<Object,Object> resultMap = supplierBo.findByName(mapCriteria);
		
		List<Supplier> resultList = (List<Supplier>) resultMap.get("resultList");
		Integer noOfPages = (Integer) resultMap.get("noOfPages");
		
		boolean gotRecords = resultList!=null && resultList.size() > 0 ? true : false;
		
		model.addAttribute("resultList", resultList);
		model.addAttribute("searchFlag", true);
		model.addAttribute("gotRecords", gotRecords);
		model.addAttribute("currentPage", page);
		model.addAttribute("noOfPages", noOfPages);
		
		return new ModelAndView("masterfile/supplier/searchSupplier", "supplier", supplier);
	}
		
	@RequestMapping(value = "/saveSupplier", method = RequestMethod.POST)
	public ModelAndView saveSupplier(@ModelAttribute("supplier") @Validated Supplier supplier, 
		      BindingResult result, ModelMap model) throws Exception {
				
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		if (result.hasErrors()) {
			return new ModelAndView("masterfile/supplier/addSupplier");
		}
		     
		supplier.setCreatedBy(SIMSUtil.getUserIdFromSession(model));
		
		boolean isSuccess = supplierBo.save(supplier);
		
		model.addAttribute("isSuccess", isSuccess);
		
		return new ModelAndView("masterfile/supplier/addSupplier");
	}
	
	@RequestMapping(value = "/editSupplier", method=RequestMethod.GET)
	public ModelAndView editSupplier(@RequestParam("id") int id, ModelMap model) throws Exception {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		
		Supplier resultEntity = supplierBo.findById(id);
		return new ModelAndView("masterfile/supplier/editSupplier", "supplier", resultEntity);
	}
	
	@RequestMapping(value = "/updateSupplier", method = RequestMethod.POST)
	public ModelAndView updateSupplier(@ModelAttribute("supplier" ) @Validated Supplier supplier, 
		      BindingResult result, ModelMap model) throws Exception {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
	    if (result.hasErrors()) {
	    	return new ModelAndView("masterfile/supplier/editSupplier");
	    }
	    
	    supplier.setModifiedBy(SIMSUtil.getUserIdFromSession(model));
	          
		boolean isSuccess = supplierBo.update(supplier);
		
		model.addAttribute("isSuccess", isSuccess);
		
		return new ModelAndView("masterfile/supplier/editSupplier");
	}
	
	@RequestMapping(value = "/deleteSupplier", method=RequestMethod.GET)
	public ModelAndView deleteSupplier(@RequestParam("id") int id, ModelMap model) throws Exception {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		Supplier supplier = supplierBo.findById(id);
		supplier.setModifiedBy(SIMSUtil.getUserIdFromSession(model));
		
		boolean isSuccess =  supplierBo.delete(supplier);
		model.addAttribute("isDeleted", isSuccess);
		
		return new ModelAndView("masterfile/supplier/searchSupplier", "supplier", new Supplier());
	}
	
}
