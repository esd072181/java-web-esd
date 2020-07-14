package com.sims.controller;

import java.sql.Date;
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

import com.sims.bo.BrandBo;
import com.sims.bo.CategoryBo;
import com.sims.bo.ItemBo;
import com.sims.bo.ListValueBo;
import com.sims.bo.SubCategoryBo;
import com.sims.constant.SIMSConstant;
import com.sims.model.Brand;
import com.sims.model.Category;
import com.sims.model.Item;
import com.sims.model.ListValue;
import com.sims.model.SubCategory;
import com.sims.model.UserAccount;
import com.sims.propertyeditor.CustomSQLDateEditor;
import com.sims.util.SIMSUtil;
import com.sims.validator.ItemValidator;

@Controller
@SessionAttributes("userid")
public class ItemController {
	
	private final static Logger logger = Logger.getLogger(ItemController.class);
	
	@Autowired
	private ItemBo itemBo;
	@Autowired
	private BrandBo brandBo;
	@Autowired
	private CategoryBo categoryBo;
	@Autowired
	private SubCategoryBo subCategoryBo;
	@Autowired
	private ListValueBo listValueBo;
	
	@Autowired
	private ItemValidator itemValidator;
	
	private List<ListValue> typeList = new ArrayList<>();
	private List<ListValue> uomList = new ArrayList<>();
	private List<Brand> brandList = new ArrayList<>();
	private List<Category> categoryList = new ArrayList<>();
	private List<SubCategory> subCategoryList = new ArrayList<>();
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		
//		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); //not used because it is a private variable in CustomDateEditor class
//        dateFormat.setLenient(false);
        CustomSQLDateEditor dateEditor = new CustomSQLDateEditor(null, true); //dateFormat not used.  DateUtil class is used instead
        binder.registerCustomEditor(Date.class, dateEditor);
	    
        if (binder.getObjectName().equals("item")) {
        	binder.addValidators(itemValidator);	
	    }
		
	}
	
	@RequestMapping("/goToSearchItem")
	public ModelAndView goToSearchItem(ModelMap model) {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}

		getLOVList();
		brandList = getBrandList();
		categoryList = getCategoryList();
		subCategoryList = getSubCategoryList();
		
		model.addAttribute("searchFlag", false);
		return new ModelAndView("masterfile/item/searchItem", "item", new Item());
	}
	
	@RequestMapping("/goToAddItem")
	public ModelAndView goToAddItem(ModelMap model) {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		model.addAttribute("typeList",typeList);
		model.addAttribute("uomList",uomList);
		model.addAttribute("brandList",brandList);
		model.addAttribute("categoryList",categoryList);
		model.addAttribute("subCategoryList",getFilteredSubCategoryList(categoryList.get(0).getId()));

		return new ModelAndView("masterfile/item/addItem", "item", new Item());
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/searchItem")
	public ModelAndView searchItem(@RequestParam("page") String page, @ModelAttribute("item") Item item, 
    			BindingResult result, ModelMap model) throws Exception {

		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}

		//Note: can use modelattribute in a form in jsp
		//or can simply pass a parameter
		
		Map<Object,Object> mapCriteria = new HashMap<Object,Object>();
		
		mapCriteria.put("search_criteria", item.getDescription()!=null ? item.getDescription() : "");
		mapCriteria.put("record_start", SIMSUtil.getRecordStartIndex(page!=null ? Integer.parseInt(page) : 1));
		mapCriteria.put("max_result", SIMSConstant.RECORDS_PER_PAGE);
		
		Map<Object,Object> resultMap = itemBo.findByDescription(mapCriteria);
		
		List<Item> resultList = (List<Item>) resultMap.get("resultList");
		Integer noOfPages = (Integer) resultMap.get("noOfPages");
		
		boolean gotRecords = resultList!=null && resultList.size() > 0 ? true : false;
		
		model.addAttribute("resultList", resultList);
		model.addAttribute("searchFlag", true);
		model.addAttribute("gotRecords", gotRecords);
		model.addAttribute("currentPage", page);
		model.addAttribute("noOfPages", noOfPages);
		
		return new ModelAndView("masterfile/item/searchItem", "item", item);
	}
		
	@RequestMapping(value = "/saveItem", method = RequestMethod.POST)
	public ModelAndView saveItem(@ModelAttribute("item") @Validated Item item, 
		      BindingResult result, ModelMap model) throws Exception {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		if (result.hasErrors()) {
			return new ModelAndView("masterfile/item/addItem", "item", item);
		}
		     
		item.setCreatedBy(SIMSUtil.getUserIdFromSession(model));
		
		boolean isSuccess = itemBo.save(item);
		
		model.addAttribute("isSuccess", isSuccess);
		
		model.addAttribute("typeList",typeList);
		model.addAttribute("uomList",uomList);
		model.addAttribute("brandList",brandList);
		model.addAttribute("categoryList",categoryList);
		model.addAttribute("subCategoryList",getFilteredSubCategoryList(item.getCategory().getId()));
		
		return new ModelAndView("masterfile/item/addItem", "item", item);
	}
	
	@RequestMapping(value = "/editItem", method=RequestMethod.GET)
	public ModelAndView editItem(@RequestParam("id") int itemiId, ModelMap model) throws Exception {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		model.addAttribute("typeList",typeList);
		model.addAttribute("uomList",uomList);
		model.addAttribute("brandList",brandList);
		model.addAttribute("categoryList",categoryList);
				
		Item resultEntity = itemBo.findById(itemiId);
		
		model.addAttribute("subCategoryList",getFilteredSubCategoryList(resultEntity.getCategory().getId()));

		return new ModelAndView("masterfile/item/editItem", "item", resultEntity);
	}
	
//	@RequestMapping(value = "/editItem/{id}", method=RequestMethod.GET) //This is used for RESTFUl
//	public ModelAndView editItem(@PathVariable("id")int id, Model model) throws Exception {
//		
//		ItemEntity resultEntity = itemBo.findById(id);
//		return new ModelAndView("masterfile/item/editItem", "item", resultEntity);
//	}
	
	@RequestMapping(value = "/updateItem", method = RequestMethod.POST)
	public ModelAndView updateItem(@ModelAttribute("item" ) @Validated Item item, 
		      BindingResult result, ModelMap model) throws Exception {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		model.addAttribute("typeList",typeList);
		model.addAttribute("uomList",uomList);
		model.addAttribute("brandList",brandList);
		model.addAttribute("categoryList",categoryList);
		model.addAttribute("subCategoryList",subCategoryList);
		
	    if (result.hasErrors()) {
	    	return new ModelAndView("masterfile/item/editItem");
	    }
	     
	    item.setModifiedBy(SIMSUtil.getUserIdFromSession(model));
	    
		boolean isSuccess = itemBo.update(item);
		
		model.addAttribute("isSuccess", isSuccess);
		
		return new ModelAndView("masterfile/item/editItem");
	}
	
	@RequestMapping(value = "/deleteItem", method=RequestMethod.GET)
	public ModelAndView deleteItem(@RequestParam("id") int id, ModelMap model) throws Exception {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		Item item = itemBo.findById(id);
		item.setModifiedBy(SIMSUtil.getUserIdFromSession(model));
		
		boolean isSuccess =  itemBo.delete(item);
		model.addAttribute("isDeleted", isSuccess);
		
		return new ModelAndView("masterfile/item/searchItem", "item", new Item());
	}
	
	@RequestMapping("/filterSubCategoryList")
	public ModelAndView filterSubCategoryList(@RequestParam("categoryId") int categoryId, ModelMap model) {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		model.addAttribute("subCategoryList",getFilteredSubCategoryList(categoryId));

		return new ModelAndView("masterfile/item/filteredSubCategory", "item", new Item());
	}
	
	private void getLOVList() {
		
		List<ListValue> typelist = new ArrayList<>();
		List<ListValue> uomlist = new ArrayList<>();
		
		List<ListValue> lovList = listValueBo.getAllLOV();
		for (ListValue item : lovList) {
			//Filter for Item Type ListTypeId = 1
			if (item.getListTypeId() == 1) {
				typelist.add(item);
			}
		}
		
		typeList = typelist;
		
		for (ListValue item : lovList) {
			//Filter for UOM Type ListTypeId = 2
			if (item.getListTypeId() == 2) {
				uomlist.add(item);
			}
		}
		
		uomList = uomlist;
	}

	private List<Brand> getBrandList() {
		List<Brand> list = brandBo.getAllEntity();
		return list;
	}
	
	private List<Category> getCategoryList() {
		List<Category> list = categoryBo.getAllEntity();
		return list;
	}
	
	private List<SubCategory> getSubCategoryList() {
		List<SubCategory> list = subCategoryBo.getAllEntity();
		return list;
	}
	
	private List<SubCategory> getFilteredSubCategoryList(Integer categoryId) {
		List<SubCategory> filteredSubCategList = new ArrayList<>();
		for (SubCategory item: subCategoryList) {
			if (item.getCategory().getId() == categoryId) {
				filteredSubCategList.add(item);
			}
		}
		return filteredSubCategList;
	}
	
}
