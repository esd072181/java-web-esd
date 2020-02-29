package com.sims.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.sims.bo.SubCategoryBo;
import com.sims.constant.SIMSConstant;
import com.sims.model.Category;
import com.sims.model.SubCategory;
import com.sims.model.UserAccount;
import com.sims.util.SIMSUtil;
import com.sims.validator.SubCategoryValidator;

/**
 * 
 * @author dward
 *
 */
@Controller
@SessionAttributes("userid")
public class SubCategoryController {
	
	private final static Logger logger = Logger.getLogger(SubCategoryController.class);
	
	@Autowired
	private SubCategoryBo subCategoryBo;
	@Autowired
	private CategoryBo categoryBo;
	@Autowired
	private SubCategoryValidator subCategoryValidator;
	
	private List<Category> categoryList = new ArrayList<>();
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        dateFormat.setLenient(false);
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		
	    if (binder.getObjectName().equals("subCategory")) {
			binder.addValidators(subCategoryValidator);			
		}

	}
	
	@RequestMapping("/goToSearchSubCategory")
	public ModelAndView goToSearchSubCategory(ModelMap model) {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		categoryList = getCategoryList();
		
		model.addAttribute("searchFlag", false);
		return new ModelAndView("masterfile/subcategory/searchSubCategory", "subCategory", new SubCategory());
	}
	
	@RequestMapping("/goToAddSubCategory")
	public ModelAndView goToAddSubCategory(ModelMap model) {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		model.addAttribute("categoryList", categoryList);
		
		return new ModelAndView("masterfile/subcategory/addSubCategory", "subCategory", new SubCategory());
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/searchSubCategory")
	public ModelAndView searchSubCategory(@RequestParam("page") String page, @ModelAttribute("subCategory") SubCategory subCategory, 
    			BindingResult result, ModelMap model) throws Exception {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		//Note: can use modelattribute in a form in jsp
		//or can simply pass a parameter
		
		Map<Object,Object> mapCriteria = new HashMap<Object,Object>();
		
		mapCriteria.put("search_criteria", subCategory.getName()!=null ? subCategory.getName() : "");
		mapCriteria.put("record_start", SIMSUtil.getRecordStartIndex(page!=null ? Integer.parseInt(page) : 1));
		mapCriteria.put("max_result", SIMSConstant.RECORDS_PER_PAGE);
		
		Map<Object,Object> resultMap = subCategoryBo.findByDescription(mapCriteria);
		
		List<SubCategory> resultList = (List<SubCategory>) resultMap.get("resultList");
		Integer noOfPages = (Integer) resultMap.get("noOfPages");
		
		boolean gotRecords = resultList!=null && resultList.size() > 0 ? true : false;
		
		model.addAttribute("resultList", resultList);
		model.addAttribute("searchFlag", true);
		model.addAttribute("gotRecords", gotRecords);
		model.addAttribute("currentPage", page);
		model.addAttribute("noOfPages", noOfPages);
		
		return new ModelAndView("masterfile/subcategory/searchSubCategory", "subCategory", subCategory);
	}
		
	@RequestMapping(value = "/saveSubCategory", method = RequestMethod.POST)
	public ModelAndView saveSubCategory(@ModelAttribute("subCategory") @Validated SubCategory subCategory, 
		      BindingResult result, ModelMap model) throws Exception {
				
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		model.addAttribute("categoryList", categoryList);
		
		if (result.hasErrors()) {
			return new ModelAndView("masterfile/subcategory/addSubCategory");
		}
		     
		subCategory.setCreatedBy(SIMSUtil.getUserIdFromSession(model));
		
		boolean isSuccess = subCategoryBo.save(subCategory);
		
		model.addAttribute("isSuccess", isSuccess);
		
		return new ModelAndView("masterfile/subcategory/addSubCategory");
	}
	
	@RequestMapping(value = "/editSubCategory", method=RequestMethod.GET)
	public ModelAndView editSubCategory(@RequestParam("id") int id, ModelMap model) throws Exception {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		model.addAttribute("categoryList", categoryList);
		
		SubCategory resultEntity = subCategoryBo.findById(id);
		return new ModelAndView("masterfile/subcategory/editSubCategory", "subCategory", resultEntity);
	}
	
	@RequestMapping(value = "/updateSubCategory", method = RequestMethod.POST)
	public ModelAndView updateSubCategory(@ModelAttribute("subCategory" ) @Validated SubCategory subCategory, 
		      BindingResult result, ModelMap model) throws Exception {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		model.addAttribute("categoryList", categoryList);
		
	    if (result.hasErrors()) {
	    	return new ModelAndView("masterfile/subcategory/editSubCategory");
	    }
	    
	    subCategory.setModifiedBy(SIMSUtil.getUserIdFromSession(model));
	          
		boolean isSuccess = subCategoryBo.update(subCategory);
		
		model.addAttribute("isSuccess", isSuccess);
		
		return new ModelAndView("masterfile/subcategory/editSubCategory");
	}
	
	@RequestMapping(value = "/deleteSubCategory", method=RequestMethod.GET)
	public ModelAndView deleteSubCategory(@RequestParam("id") int id, ModelMap model) throws Exception {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		model.addAttribute("categoryList", categoryList);
		
		SubCategory subCategory = subCategoryBo.findById(id);
		subCategory.setModifiedBy(SIMSUtil.getUserIdFromSession(model));
		
		boolean isSuccess =  subCategoryBo.delete(subCategory);
		model.addAttribute("isDeleted", isSuccess);
		
		return new ModelAndView("masterfile/subcategory/searchSubCategory", "subCategory", new SubCategory());
	}
	
	private List<Category> getCategoryList() {
		
		List<Category> list = categoryBo.getAllEntity();
		
		return list;
	}
	
}
