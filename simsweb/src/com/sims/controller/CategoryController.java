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

import com.sims.bo.CategoryBo;
import com.sims.constant.SIMSConstant;
import com.sims.model.Category;
import com.sims.model.UserAccount;
import com.sims.util.SIMSUtil;
import com.sims.validator.CategoryValidator;

/**
 * 
 * @author dward
 *
 */
@Controller
@SessionAttributes("userid")
public class CategoryController {
	
	private final static Logger logger = Logger.getLogger(CategoryController.class);
	
	@Autowired
	private CategoryBo categoryBo;
	
	@Autowired
	private CategoryValidator categoryValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        dateFormat.setLenient(false);
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		
	    if (binder.getObjectName().equals("category")) {
			binder.addValidators(categoryValidator);			
		}

	}
	
	@RequestMapping("/goToSearchCategory")
	public ModelAndView goToSearchCategory(ModelMap model) {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		model.addAttribute("searchFlag", false);
		return new ModelAndView("masterfile/category/searchCategory", "category", new Category());
	}
	
	@RequestMapping("/goToAddCategory")
	public ModelAndView goToAddCategory(ModelMap model) {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		return new ModelAndView("masterfile/category/addCategory", "category", new Category());
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/searchCategory")
	public ModelAndView searchCategory(@RequestParam("page") String page, @ModelAttribute("category") Category category, 
    			BindingResult result, ModelMap model) throws Exception {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		//Note: can use modelattribute in a form in jsp
		//or can simply pass a parameter
		
		Map<Object,Object> mapCriteria = new HashMap<Object,Object>();
		
		mapCriteria.put("search_criteria", category.getName()!=null ? category.getName() : "");
		mapCriteria.put("record_start", SIMSUtil.getRecordStartIndex(page!=null ? Integer.parseInt(page) : 1));
		mapCriteria.put("max_result", SIMSConstant.RECORDS_PER_PAGE);
		
		Map<Object,Object> resultMap = categoryBo.findByDescription(mapCriteria);
		
		List<Category> resultList = (List<Category>) resultMap.get("resultList");
		Integer noOfPages = (Integer) resultMap.get("noOfPages");
		
		boolean gotRecords = resultList!=null && resultList.size() > 0 ? true : false;
		
		model.addAttribute("resultList", resultList);
		model.addAttribute("searchFlag", true);
		model.addAttribute("gotRecords", gotRecords);
		model.addAttribute("currentPage", page);
		model.addAttribute("noOfPages", noOfPages);
		
		return new ModelAndView("masterfile/category/searchCategory", "category", category);
	}
		
	@RequestMapping(value = "/saveCategory", method = RequestMethod.POST)
	public ModelAndView saveCategory(@ModelAttribute("category") @Validated Category category, 
		      BindingResult result, ModelMap model) throws Exception {
				
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		if (result.hasErrors()) {
			return new ModelAndView("masterfile/category/addCategory");
		}
		     
		category.setCreatedBy(SIMSUtil.getUserIdFromSession(model));
		
		boolean isSuccess = categoryBo.save(category);
		
		model.addAttribute("isSuccess", isSuccess);
		
		return new ModelAndView("masterfile/category/addCategory");
	}
	
	@RequestMapping(value = "/editCategory", method=RequestMethod.GET)
	public ModelAndView editCategory(@RequestParam("id") int id, ModelMap model) throws Exception {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		
		Category resultEntity = categoryBo.findById(id);
		return new ModelAndView("masterfile/category/editCategory", "category", resultEntity);
	}
	
	@RequestMapping(value = "/updateCategory", method = RequestMethod.POST)
	public ModelAndView updateCategory(@ModelAttribute("category" ) @Validated Category category, 
		      BindingResult result, ModelMap model) throws Exception {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
	    if (result.hasErrors()) {
	    	return new ModelAndView("masterfile/category/editCategory");
	    }
	    
	    category.setModifiedBy(SIMSUtil.getUserIdFromSession(model));
	          
		boolean isSuccess = categoryBo.update(category);
		
		model.addAttribute("isSuccess", isSuccess);
		
		return new ModelAndView("masterfile/category/editCategory");
	}
	
	@RequestMapping(value = "/deleteCategory", method=RequestMethod.GET)
	public ModelAndView deleteCategory(@RequestParam("id") int id, ModelMap model) throws Exception {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		Category category = categoryBo.findById(id);
		category.setModifiedBy(SIMSUtil.getUserIdFromSession(model));
		
		boolean isSuccess =  categoryBo.delete(category);
		model.addAttribute("isDeleted", isSuccess);
		
		return new ModelAndView("masterfile/category/searchCategory", "category", new Category());
	}
	
}
