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

import com.sims.bo.BrandBo;
import com.sims.constant.SIMSConstant;
import com.sims.model.Brand;
import com.sims.model.UserAccount;
import com.sims.util.SIMSUtil;
import com.sims.validator.BrandValidator;

/**
 * 
 * @author dward
 *
 */
@Controller
@SessionAttributes("userid")
public class BrandController {
	
	private final static Logger logger = Logger.getLogger(BrandController.class);
	
	@Autowired
	private BrandBo brandBo;
	
	@Autowired
	private BrandValidator brandValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        dateFormat.setLenient(false);
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		
	    if (binder.getObjectName().equals("brand")) {
			binder.addValidators(brandValidator);			
		}

	}
	
	@RequestMapping("/goToSearchBrand")
	public ModelAndView goToSearchBrand(ModelMap model) {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		model.addAttribute("searchFlag", false);
		return new ModelAndView("masterfile/brand/searchBrand", "brand", new Brand());
	}
	
	@RequestMapping("/goToAddBrand")
	public ModelAndView goToAddBrand(ModelMap model) {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		return new ModelAndView("masterfile/brand/addBrand", "brand", new Brand());
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/searchBrand")
	public ModelAndView searchBrand(@RequestParam("page") String page, @ModelAttribute("brand") Brand brand, 
    			BindingResult result, ModelMap model) throws Exception {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		//Note: can use modelattribute in a form in jsp
		//or can simply pass a parameter
		
		Map<Object,Object> mapCriteria = new HashMap<Object,Object>();
		
		mapCriteria.put("search_criteria", brand.getName()!=null ? brand.getName() : "");
		mapCriteria.put("record_start", SIMSUtil.getRecordStartIndex(page!=null ? Integer.parseInt(page) : 1));
		mapCriteria.put("max_result", SIMSConstant.RECORDS_PER_PAGE);
		
		Map<Object,Object> resultMap = brandBo.findByDescription(mapCriteria);
		
		List<Brand> resultList = (List<Brand>) resultMap.get("resultList");
		Integer noOfPages = (Integer) resultMap.get("noOfPages");
		
		boolean gotRecords = resultList!=null && resultList.size() > 0 ? true : false;
		
		model.addAttribute("resultList", resultList);
		model.addAttribute("searchFlag", true);
		model.addAttribute("gotRecords", gotRecords);
		model.addAttribute("currentPage", page);
		model.addAttribute("noOfPages", noOfPages);
		
		return new ModelAndView("masterfile/brand/searchBrand", "brand", brand);
	}
		
	@RequestMapping(value = "/saveBrand", method = RequestMethod.POST)
	public ModelAndView saveBrand(@ModelAttribute("brand") @Validated Brand brand, 
		      BindingResult result, ModelMap model) throws Exception {
				
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		if (result.hasErrors()) {
			return new ModelAndView("masterfile/brand/addBrand");
		}
		     
		brand.setCreatedBy(SIMSUtil.getUserIdFromSession(model));
		
		boolean isSuccess = brandBo.save(brand);
		
		model.addAttribute("isSuccess", isSuccess);
		
		return new ModelAndView("masterfile/brand/addBrand");
	}
	
	@RequestMapping(value = "/editBrand", method=RequestMethod.GET)
	public ModelAndView editBrand(@RequestParam("id") int id, ModelMap model) throws Exception {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		
		Brand resultEntity = brandBo.findById(id);
		return new ModelAndView("masterfile/brand/editBrand", "brand", resultEntity);
	}
	
	@RequestMapping(value = "/updateBrand", method = RequestMethod.POST)
	public ModelAndView updateBrand(@ModelAttribute("brand" ) @Validated Brand brand, 
		      BindingResult result, ModelMap model) throws Exception {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
	    if (result.hasErrors()) {
	    	return new ModelAndView("masterfile/brand/editBrand");
	    }
	    
	    brand.setModifiedBy(SIMSUtil.getUserIdFromSession(model));
	          
		boolean isSuccess = brandBo.update(brand);
		
		model.addAttribute("isSuccess", isSuccess);
		
		return new ModelAndView("masterfile/brand/editBrand");
	}
	
	@RequestMapping(value = "/deleteBrand", method=RequestMethod.GET)
	public ModelAndView deleteBrand(@RequestParam("id") int id, ModelMap model) throws Exception {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		Brand brand = brandBo.findById(id);
		brand.setModifiedBy(SIMSUtil.getUserIdFromSession(model));
		
		boolean isSuccess =  brandBo.delete(brand);
		model.addAttribute("isDeleted", isSuccess);
		
		return new ModelAndView("masterfile/brand/searchBrand", "brand", new Brand());
	}
	
}
