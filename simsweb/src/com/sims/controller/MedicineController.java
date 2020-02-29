//package com.sims.controller;
//
//import java.sql.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.InitBinder;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.sims.bo.MedicineBo;
//import com.sims.constant.SIMSConstant;
//import com.sims.model.Category;
//import com.sims.model.UserAccount;
//import com.sims.propertyeditor.CustomSQLDateEditor;
//import com.sims.util.SIMSUtil;
//import com.sims.validator.MedicineValidator;
//
///**
// * 
// * @author dward
// *
// */
//@Controller
//@SessionAttributes("userid")
//public class MedicineController {
//	
//	private final static Logger logger = Logger.getLogger(MedicineController.class);
//	
//	@Autowired
//	private MedicineBo bo;
//	
//	@Autowired
//	private MedicineValidator medicineValidator;
//	
//	@InitBinder
//	protected void initBinder(WebDataBinder binder) {
//		
//        CustomSQLDateEditor dateEditor = new CustomSQLDateEditor(null, true);
//        binder.registerCustomEditor(Date.class, dateEditor);
//	    
//        if (binder.getObjectName().equals("medicine")) {
//    		binder.addValidators(medicineValidator);       	
//        }
// 
//	}
//	
//	@RequestMapping("/goToSearchMed")
//	public ModelAndView goToSearchMedicine(ModelMap model) {
//		
//		if (!SIMSUtil.isUserSessionValid(model)) {
//			logger.info(SIMSConstant.USER_INVALID_SESSION);
//			return new ModelAndView("security/login", "userAccount", new UserAccount());	
//		}
//		
//		model.addAttribute("searchFlag", false);
//		return new ModelAndView("masterfile/medicine/searchMed", "medicine", new Category());
//	}
//	
//	@RequestMapping("/goToAddMed")
//	public ModelAndView goToAddMedicine(ModelMap model) {
//
//		if (!SIMSUtil.isUserSessionValid(model)) {
//			logger.info(SIMSConstant.USER_INVALID_SESSION);
//			return new ModelAndView("security/login", "userAccount", new UserAccount());	
//		}
//		
//		return new ModelAndView("masterfile/medicine/addMed", "medicine", new Category());
//	}
//	
//	@SuppressWarnings("unchecked")
//	@RequestMapping("/searchMed")
//	public ModelAndView searchMedicine(@RequestParam("page") String page, @ModelAttribute("medicine") Category medicine, 
//    			BindingResult result, ModelMap model) throws Exception {
//		
//		if (!SIMSUtil.isUserSessionValid(model)) {
//			logger.info(SIMSConstant.USER_INVALID_SESSION);
//			return new ModelAndView("security/login", "userAccount", new UserAccount());	
//		}
//		
//		//Note: can use modelattribute in a form in jsp
//		//or can simply pass a parameter
//		
//		Map<Object,Object> mapCriteria = new HashMap<Object,Object>();
//		
//		mapCriteria.put("search_criteria", medicine.getDescription()!=null ? medicine.getDescription() : "");
//		mapCriteria.put("record_start", SIMSUtil.getRecordStartIndex(page!=null ? Integer.parseInt(page) : 1));
//		mapCriteria.put("max_result", SIMSConstant.RECORDS_PER_PAGE);
//		
//		Map<Object,Object> resultMap = bo.findByDescription(mapCriteria);
//		
//		List<Category> resultList = (List<Category>) resultMap.get("resultList");
//		Integer noOfPages = (Integer) resultMap.get("noOfPages");
//		
//		boolean gotRecords = resultList!=null && resultList.size() > 0 ? true : false;
//		
//		model.addAttribute("resultList", resultList);
//		model.addAttribute("searchFlag", true);
//		model.addAttribute("gotRecords", gotRecords);
//		model.addAttribute("currentPage", page);
//		model.addAttribute("noOfPages", noOfPages);
//		
//		return new ModelAndView("masterfile/medicine/searchMed", "Med", medicine);
//	}
//		
//	@RequestMapping(value = "/saveMed", method = RequestMethod.POST)
//	public ModelAndView saveMedicine(@ModelAttribute("medicine") @Validated Category medicine, 
//		      BindingResult result, ModelMap model) throws Exception {
//		
//		if (!SIMSUtil.isUserSessionValid(model)) {
//			logger.info(SIMSConstant.USER_INVALID_SESSION);
//			return new ModelAndView("security/login", "userAccount", new UserAccount());	
//		}
//		
//				
//		if (result.hasErrors()) {
//			return new ModelAndView("masterfile/medicine/addMed", "medicine", medicine);
//		}
//		     
//		boolean isSuccess = bo.save(medicine);
//		
//		model.addAttribute("isSuccess", isSuccess);
//		
//		return new ModelAndView("masterfile/medicine/addMed", "medicine", medicine);
//	}
//	
//	@RequestMapping(value = "/editMed", method=RequestMethod.GET)
//	public ModelAndView editMedicine(@RequestParam("id") int id, ModelMap model) throws Exception {
//		
//		if (!SIMSUtil.isUserSessionValid(model)) {
//			logger.info(SIMSConstant.USER_INVALID_SESSION);
//			return new ModelAndView("security/login", "userAccount", new UserAccount());	
//		}
//		
//		Category resultEntity = bo.findById(id);
//		return new ModelAndView("masterfile/medicine/editMed", "medicine", resultEntity);
//	}
//	
//	@RequestMapping(value = "/updateMed", method = RequestMethod.POST)
//	public ModelAndView updateMedicine(@ModelAttribute("medicine" ) @Validated Category medicine, 
//		      BindingResult result, ModelMap model) throws Exception {
//		
//		if (!SIMSUtil.isUserSessionValid(model)) {
//			logger.info(SIMSConstant.USER_INVALID_SESSION);
//			return new ModelAndView("security/login", "userAccount", new UserAccount());	
//		}
//		
//	    if (result.hasErrors()) {
//	    	return new ModelAndView("masterfile/medicine/editMed","medicine", medicine);
//	    }
//	          
//		boolean isSuccess = bo.update(medicine);
//		
//		model.addAttribute("isSuccess", isSuccess);
//		
//		return new ModelAndView("masterfile/medicine/editMed","medicine", medicine);
//	}
//	
//	@RequestMapping(value = "/deleteMed", method=RequestMethod.GET)
//	public ModelAndView deleteMedicine(@RequestParam("id") int id, ModelMap model) throws Exception {
//		
//		if (!SIMSUtil.isUserSessionValid(model)) {
//			logger.info(SIMSConstant.USER_INVALID_SESSION);
//			return new ModelAndView("security/login", "userAccount", new UserAccount());	
//		}
//		
//		boolean isSuccess =  bo.delete(id);
//		model.addAttribute("isDeleted", isSuccess);
//		
//		return new ModelAndView("masterfile/medicine/searchMed", "medicine", new Category());
//	}
//	
//
//}
