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
import com.lrms.constant.LRMSConstant;
import com.lrms.model.ListValue;
import com.lrms.model.Professional;
import com.lrms.model.UserAccount;
import com.lrms.util.LRMSUtil;
import com.lrms.validator.ProfessionalValidator;

@Controller
@SessionAttributes("userid")
public class ProfessionalController {
	
	private final static Logger logger = Logger.getLogger(ProfessionalController.class);
	
	@Autowired
	private ProfessionalBo professionalBo;
	@Autowired
	private ListValueBo listValueBo;
	
	@Autowired
	private ProfessionalValidator professionalValidator;
	
	private List<ListValue> professionalTypeList = new ArrayList<>();
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
				
        binder.registerCustomEditor(ListValue.class, new PropertyEditorSupport() {
        	@Override
			public void setAsText(String id) throws IllegalArgumentException {
			        this.setValue(new ListValue(Integer.parseInt(id)));
			}
        });
 
        if (binder.getObjectName().equals("professional")) {
        	binder.addValidators(professionalValidator);	
        }
		
	}
	
	@RequestMapping("/goToSearchProfessional")
	public ModelAndView goToSearchProfessional(ModelMap model) {
		
		if (!LRMSUtil.isUserSessionValid(model)) {
			logger.info(LRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		professionalTypeList = getProfessionalTypeList();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("searchFlag", false);
		mv.addObject("professional", new Professional());
		mv.setViewName("masterfile/professional/searchProfessional");
		return mv;
//		return new ModelAndView("masterfile/professional/searchProfessional", "professional", new Professional());
	}
	
	@RequestMapping("/goToAddProfessional")
	public ModelAndView goToAddProfessional(ModelMap model) {
				
		if (!LRMSUtil.isUserSessionValid(model)) {
			logger.info(LRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		model.addAttribute("professionalTypeList", professionalTypeList);
		
		return new ModelAndView("masterfile/professional/addProfessional", "professional", new Professional());
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/searchProfessional")
	public ModelAndView searchProfessional(@RequestParam("page") String page, @ModelAttribute("professional") Professional professional, 
    			BindingResult result, ModelMap model) throws Exception {
		
		if (!LRMSUtil.isUserSessionValid(model)) {
			logger.info(LRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		//Note: can use modelattribute in a form in jsp
		//or can simply pass a parameter
		
		Map<Object,Object> mapCriteria = new HashMap<Object,Object>();
		
		mapCriteria.put("search_criteria", professional.getLastName()!=null ? professional.getLastName() : "");
		mapCriteria.put("record_start", LRMSUtil.getRecordStartIndex(page!=null ? Integer.parseInt(page) : 1));
		mapCriteria.put("max_result", LRMSConstant.RECORDS_PER_PAGE);
		
		Map<Object,Object> resultMap = professionalBo.findByLastName(mapCriteria);
		
		List<Professional> resultList = (List<Professional>) resultMap.get("resultList");
		Integer noOfPages = (Integer) resultMap.get("noOfPages");
		
		boolean gotRecords = resultList!=null && resultList.size() > 0 ? true : false;
		
		model.addAttribute("resultList", resultList);
		model.addAttribute("searchFlag", true);
		model.addAttribute("gotRecords", gotRecords);
		model.addAttribute("currentPage", page);
		model.addAttribute("noOfPages", noOfPages);
		
		return new ModelAndView("masterfile/professional/searchProfessional", "professional", professional);
	}
		
	@RequestMapping(value = "/saveProfessional", method = RequestMethod.POST)
	public ModelAndView saveProfessional(@ModelAttribute("professional") @Validated Professional professional, 
		      BindingResult result, ModelMap model) throws Exception {
				
		if (!LRMSUtil.isUserSessionValid(model)) {
			logger.info(LRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		model.addAttribute("professionalTypeList", professionalTypeList);
		
		if (result.hasErrors()) {
			return new ModelAndView("masterfile/professional/addProfessional", "professional", professional);
		}
		
		professional.setCreatedBy(LRMSUtil.getUserIdFromSession(model));
		     
		boolean isSuccess = professionalBo.save(professional);
		model.addAttribute("isSuccess", isSuccess);
		
		return new ModelAndView("masterfile/professional/addProfessional", "professional", professional);
	}
	
		
	@RequestMapping(value = "/editProfessional", method=RequestMethod.GET)
	public ModelAndView editProfessional(@RequestParam("id") int patientiId, ModelMap model) throws Exception {
		
		if (!LRMSUtil.isUserSessionValid(model)) {
			logger.info(LRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		model.addAttribute("professionalTypeList", professionalTypeList);
		
		Professional resultEntity = professionalBo.findById(patientiId);
		return new ModelAndView("masterfile/professional/editProfessional", "professional", resultEntity);
	}
		
	@RequestMapping(value = "/updateProfessional", method = RequestMethod.POST)
	public ModelAndView updateProfessional(@ModelAttribute("professional" ) @Validated Professional professional, 
		      BindingResult result, ModelMap model) throws Exception {
		
		if (!LRMSUtil.isUserSessionValid(model)) {
			logger.info(LRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		model.addAttribute("professionalTypeList", professionalTypeList);
		
	    if (result.hasErrors()) {
	    	return new ModelAndView("masterfile/professional/editProfessional");
	    }
	     
	    professional.setModifiedBy(LRMSUtil.getUserIdFromSession(model));
	    
		boolean isSuccess = professionalBo.update(professional);
		
		model.addAttribute("isSuccess", isSuccess);
		
		return new ModelAndView("masterfile/professional/editProfessional");
	}
	
	@RequestMapping(value = "/deleteProfessional", method=RequestMethod.GET)
	public ModelAndView deleteProfessional(@RequestParam("id") int id, ModelMap model) throws Exception {
		
		if (!LRMSUtil.isUserSessionValid(model)) {
			logger.info(LRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		Professional professional = professionalBo.findById(id);
		professional.setModifiedBy(LRMSUtil.getUserIdFromSession(model));
		
		boolean isSuccess =  professionalBo.delete(professional);
		model.addAttribute("isDeleted", isSuccess);
		
		return new ModelAndView("masterfile/professional/searchProfessional", "professional", new Professional());
	}
		
	private List<ListValue> getProfessionalTypeList() {
		
		List<ListValue> professionalTypeList = new ArrayList<>();
		
		List<ListValue> lovList = listValueBo.getAllLOV();
		for (ListValue item : lovList) {
			//Filter for Professional Type ListTypeId = 1
			if (item.getListTypeId() == 1) {
				professionalTypeList.add(item);
			}
		}
		
		return professionalTypeList;
	}
	
}
