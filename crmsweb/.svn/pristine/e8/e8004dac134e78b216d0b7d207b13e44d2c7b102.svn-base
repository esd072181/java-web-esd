package com.crms.controller;

import java.sql.Date;
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

import com.crms.bo.MedicineBo;
import com.crms.constant.CRMSConstant;
import com.crms.model.Medicine;
import com.crms.model.UserAccount;
import com.crms.propertyeditor.CustomSQLDateEditor;
import com.crms.util.CRMSUtil;
import com.crms.validator.MedicineValidator;

/**
 * 
 * @author dward
 *
 */
@Controller
@SessionAttributes("userid")
public class MedicineController {
	
	private final static Logger logger = Logger.getLogger(MedicineController.class);
	
	@Autowired
	private MedicineBo bo;
	
	@Autowired
	private MedicineValidator medicineValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		
        CustomSQLDateEditor dateEditor = new CustomSQLDateEditor(null, true);
        binder.registerCustomEditor(Date.class, dateEditor);
	    
        if (binder.getObjectName().equals("medicine")) {
    		binder.addValidators(medicineValidator);       	
        }
 
	}
	
	@RequestMapping("/goToSearchMed")
	public ModelAndView goToSearchMedicine(ModelMap model) {
		
		if (!CRMSUtil.isUserSessionValid(model)) {
			logger.info(CRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		model.addAttribute("searchFlag", false);
		return new ModelAndView("masterfile/medicine/searchMed", "medicine", new Medicine());
	}
	
	@RequestMapping("/goToAddMed")
	public ModelAndView goToAddMedicine(ModelMap model) {

		if (!CRMSUtil.isUserSessionValid(model)) {
			logger.info(CRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		return new ModelAndView("masterfile/medicine/addMed", "medicine", new Medicine());
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/searchMed")
	public ModelAndView searchMedicine(@RequestParam("page") String page, @ModelAttribute("medicine") Medicine medicine, 
    			BindingResult result, ModelMap model) throws Exception {
		
		if (!CRMSUtil.isUserSessionValid(model)) {
			logger.info(CRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		//Note: can use modelattribute in a form in jsp
		//or can simply pass a parameter
		
		Map<Object,Object> mapCriteria = new HashMap<Object,Object>();
		
		mapCriteria.put("search_criteria", medicine.getDescription()!=null ? medicine.getDescription() : "");
		mapCriteria.put("record_start", CRMSUtil.getRecordStartIndex(page!=null ? Integer.parseInt(page) : 1));
		mapCriteria.put("max_result", CRMSConstant.RECORDS_PER_PAGE);
		
		Map<Object,Object> resultMap = bo.findByDescription(mapCriteria);
		
		List<Medicine> resultList = (List<Medicine>) resultMap.get("resultList");
		Integer noOfPages = (Integer) resultMap.get("noOfPages");
		
		boolean gotRecords = resultList!=null && resultList.size() > 0 ? true : false;
		
		model.addAttribute("resultList", resultList);
		model.addAttribute("searchFlag", true);
		model.addAttribute("gotRecords", gotRecords);
		model.addAttribute("currentPage", page);
		model.addAttribute("noOfPages", noOfPages);
		
		return new ModelAndView("masterfile/medicine/searchMed", "Med", medicine);
	}
		
	@RequestMapping(value = "/saveMed", method = RequestMethod.POST)
	public ModelAndView saveMedicine(@ModelAttribute("medicine") @Validated Medicine medicine, 
		      BindingResult result, ModelMap model) throws Exception {
		
		if (!CRMSUtil.isUserSessionValid(model)) {
			logger.info(CRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
				
		if (result.hasErrors()) {
			return new ModelAndView("masterfile/medicine/addMed", "medicine", medicine);
		}
		     
		boolean isSuccess = bo.save(medicine);
		
		model.addAttribute("isSuccess", isSuccess);
		
		return new ModelAndView("masterfile/medicine/addMed", "medicine", medicine);
	}
	
	@RequestMapping(value = "/editMed", method=RequestMethod.GET)
	public ModelAndView editMedicine(@RequestParam("id") int id, ModelMap model) throws Exception {
		
		if (!CRMSUtil.isUserSessionValid(model)) {
			logger.info(CRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		Medicine resultEntity = bo.findById(id);
		return new ModelAndView("masterfile/medicine/editMed", "medicine", resultEntity);
	}
	
	@RequestMapping(value = "/updateMed", method = RequestMethod.POST)
	public ModelAndView updateMedicine(@ModelAttribute("medicine" ) @Validated Medicine medicine, 
		      BindingResult result, ModelMap model) throws Exception {
		
		if (!CRMSUtil.isUserSessionValid(model)) {
			logger.info(CRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
	    if (result.hasErrors()) {
	    	return new ModelAndView("masterfile/medicine/editMed","medicine", medicine);
	    }
	          
		boolean isSuccess = bo.update(medicine);
		
		model.addAttribute("isSuccess", isSuccess);
		
		return new ModelAndView("masterfile/medicine/editMed","medicine", medicine);
	}
	
	@RequestMapping(value = "/deleteMed", method=RequestMethod.GET)
	public ModelAndView deleteMedicine(@RequestParam("id") int id, ModelMap model) throws Exception {
		
		if (!CRMSUtil.isUserSessionValid(model)) {
			logger.info(CRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		boolean isSuccess =  bo.delete(id);
		model.addAttribute("isDeleted", isSuccess);
		
		return new ModelAndView("masterfile/medicine/searchMed", "medicine", new Medicine());
	}
	

}
