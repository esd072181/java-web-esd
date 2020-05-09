package com.lrms.controller;

import java.math.BigDecimal;
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

import com.lrms.bo.LabExamBo;
import com.lrms.bo.ListValueBo;
import com.lrms.constant.LRMSConstant;
import com.lrms.model.LabExam;
import com.lrms.model.ListValue;
import com.lrms.model.UserAccount;
import com.lrms.propertyeditor.NumericDoubleEditor;
import com.lrms.util.LRMSUtil;
import com.lrms.validator.LabExamValidator;

/**
 * 
 * @author dward
 * @since Dec2018
 * DateUpdated: 09May2020
 */
@Controller
@SessionAttributes("userid")
public class LabExamController {
	
	private final static Logger logger = Logger.getLogger(LabExamController.class);
	
	@Autowired
	private LabExamBo labExamBo;
	@Autowired
	private ListValueBo listValueBo;
	
	@Autowired
	private LabExamValidator labExamValidator;
	
	private List<ListValue> reportTemplateList = new ArrayList<>();
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        dateFormat.setLenient(false);
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	        binder.registerCustomEditor(BigDecimal.class, new NumericDoubleEditor());
		
	    if (binder.getObjectName().equals("labExam")) {
			binder.addValidators(labExamValidator);			
		}

	}
	
	@RequestMapping("/goToSearchLabExam")
	public ModelAndView goToSearchLabExam(ModelMap model) {
		
		if (!LRMSUtil.isUserSessionValid(model)) {
			logger.info(LRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		reportTemplateList = getReportTemplateList();
		
		model.addAttribute("searchFlag", false);
		return new ModelAndView("masterfile/labexam/searchLabExam", "labExam", new LabExam());
	}
	
	@RequestMapping("/goToAddLabExam")
	public ModelAndView goToAddLabExam(ModelMap model) {
		
		if (!LRMSUtil.isUserSessionValid(model)) {
			logger.info(LRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		model.addAttribute("reportTemplateList", reportTemplateList);
		
		return new ModelAndView("masterfile/labexam/addLabExam", "labExam", new LabExam());
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/searchLabExam")
	public ModelAndView searchLabExam(@RequestParam("page") String page, @ModelAttribute("labExam") LabExam labExam, 
    			BindingResult result, ModelMap model) throws Exception {
		
		if (!LRMSUtil.isUserSessionValid(model)) {
			logger.info(LRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		//Note: can use modelattribute in a form in jsp
		//or can simply pass a parameter
		
		Map<Object,Object> mapCriteria = new HashMap<Object,Object>();
		
		mapCriteria.put("search_criteria", labExam.getDescription()!=null ? labExam.getDescription() : "");
		mapCriteria.put("record_start", LRMSUtil.getRecordStartIndex(page!=null ? Integer.parseInt(page) : 1));
		mapCriteria.put("max_result", LRMSConstant.RECORDS_PER_PAGE);
		
		Map<Object,Object> resultMap = labExamBo.findByDescription(mapCriteria);
		
		List<LabExam> resultList = (List<LabExam>) resultMap.get("resultList");
		Integer noOfPages = (Integer) resultMap.get("noOfPages");
		
		boolean gotRecords = resultList!=null && resultList.size() > 0 ? true : false;
		
		model.addAttribute("resultList", resultList);
		model.addAttribute("searchFlag", true);
		model.addAttribute("gotRecords", gotRecords);
		model.addAttribute("currentPage", page);
		model.addAttribute("noOfPages", noOfPages);
		
		return new ModelAndView("masterfile/labexam/searchLabExam", "labExam", labExam);
	}
		
	@RequestMapping(value = "/saveLabExam", method = RequestMethod.POST)
	public ModelAndView saveLabExam(@ModelAttribute("labExam") @Validated LabExam labExam, 
		      BindingResult result, ModelMap model) throws Exception {
				
		if (!LRMSUtil.isUserSessionValid(model)) {
			logger.info(LRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		model.addAttribute("reportTemplateList", reportTemplateList);
		
		if (result.hasErrors()) {
			return new ModelAndView("masterfile/labexam/addLabExam");
		}
		     
		labExam.setCreatedBy(LRMSUtil.getUserIdFromSession(model));
		
		boolean isSuccess = labExamBo.save(labExam);
		
		model.addAttribute("isSuccess", isSuccess);
		
		return new ModelAndView("masterfile/labexam/addLabExam");
	}
	
	@RequestMapping(value = "/editLabExam", method=RequestMethod.GET)
	public ModelAndView editLabExam(@RequestParam("id") int id, ModelMap model) throws Exception {
		
		if (!LRMSUtil.isUserSessionValid(model)) {
			logger.info(LRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		model.addAttribute("reportTemplateList", reportTemplateList);
		
		LabExam resultEntity = labExamBo.findById(id);
		return new ModelAndView("masterfile/labexam/editLabExam", "labExam", resultEntity);
	}
	
	@RequestMapping(value = "/updateLabExam", method = RequestMethod.POST)
	public ModelAndView updateLabExam(@ModelAttribute("labExam" ) @Validated LabExam labExam, 
		      BindingResult result, ModelMap model) throws Exception {
		
		if (!LRMSUtil.isUserSessionValid(model)) {
			logger.info(LRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		model.addAttribute("reportTemplateList", reportTemplateList);
		
	    if (result.hasErrors()) {
	    	return new ModelAndView("masterfile/labexam/editLabExam");
	    }
	    
	    labExam.setModifiedBy(LRMSUtil.getUserIdFromSession(model));
	          
		boolean isSuccess = labExamBo.update(labExam);
		
		model.addAttribute("isSuccess", isSuccess);
		
		return new ModelAndView("masterfile/labexam/editLabExam");
	}
	
	@RequestMapping(value = "/deleteLabExam", method=RequestMethod.GET)
	public ModelAndView deleteLabExam(@RequestParam("id") int id, ModelMap model) throws Exception {
		
		if (!LRMSUtil.isUserSessionValid(model)) {
			logger.info(LRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		LabExam exam = labExamBo.findById(id);
		exam.setModifiedBy(LRMSUtil.getUserIdFromSession(model));
		
		boolean isSuccess =  labExamBo.delete(exam);
		model.addAttribute("isDeleted", isSuccess);
		
		return new ModelAndView("masterfile/labexam/searchLabExam", "labExam", new LabExam());
	}
	
	private List<ListValue> getReportTemplateList() {
		
		List<ListValue> reportTemplateList = new ArrayList<>();
		
		List<ListValue> lovList = listValueBo.getAllLOV();
		for (ListValue item : lovList) {
			//Filter for Professional Type ListTypeId = 1
			if (item.getListTypeId() == 5) {
				reportTemplateList.add(item);
			}
		}
		
		return reportTemplateList;
	}

}
