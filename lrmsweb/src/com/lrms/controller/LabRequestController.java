package com.lrms.controller;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
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

import com.lrms.bo.LabExamBo;
import com.lrms.bo.PatientBo;
import com.lrms.bo.PatientLabRequestBo;
import com.lrms.bo.ProfessionalBo;
import com.lrms.constant.LRMSConstant;
import com.lrms.model.LabExam;
import com.lrms.model.Patient;
import com.lrms.model.PatientLabRequest;
import com.lrms.model.Professional;
import com.lrms.model.UserAccount;
import com.lrms.util.DateUtils;
import com.lrms.util.LRMSUtil;

@Controller
@SessionAttributes("userid")
public class LabRequestController {
	
	private final static Logger logger = Logger.getLogger(LabRequestController.class);
	
	@Autowired
	private PatientBo patientBo;
	@Autowired
	private ProfessionalBo professionalBo;
	@Autowired
	private LabExamBo labExamBo;
	@Autowired
	private PatientLabRequestBo patientLabRequestBo;
	
	private List<Professional> physicians = new ArrayList<>();
	private List<LabExam> labExamList = new ArrayList<>();
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		        		
        binder.registerCustomEditor(Professional.class, new PropertyEditorSupport() {
        	@Override
			public void setAsText(String id) throws IllegalArgumentException {
			       this.setValue(new Professional(Integer.parseInt(id)));
			}
        });
        
	}
	
	@RequestMapping("/goToSearchPatientForLabRequest")
	public ModelAndView goToSearchPatientForLabRequest(ModelMap model) {
		
		if (!LRMSUtil.isUserSessionValid(model)) {
			logger.info(LRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		physicians = professionalBo.getAllPhysician();
		labExamList = labExamBo.getAllEntity();
		model.addAttribute("searchFlag", false);
		
		return new ModelAndView("transaction/labrequest/searchPatientForLabRequest", "patient", new Patient());
	}
	
	@RequestMapping("/goToPatientRegistration")
	public ModelAndView goToAddPatient(ModelMap model) {
		
		if (!LRMSUtil.isUserSessionValid(model)) {
			logger.info(LRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		return new ModelAndView("transaction/labrequest/patientRegistration", "patient", new Patient());
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/searchPatientForLabRequest")
	public ModelAndView searchPatient(@RequestParam("page") String page, @ModelAttribute("patient") Patient patient, 
    			BindingResult result, ModelMap model) throws Exception {
		
		if (!LRMSUtil.isUserSessionValid(model)) {
			logger.info(LRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		//Note: can use modelattribute in a form in jsp
		//or can simply pass a parameter
		
		Map<Object,Object> mapCriteria = new HashMap<Object,Object>();
		
		mapCriteria.put("search_criteria", patient.getLastName()!=null ? patient.getLastName() : "");
		mapCriteria.put("record_start", LRMSUtil.getRecordStartIndex(page!=null ? Integer.parseInt(page) : 1));
		mapCriteria.put("max_result", LRMSConstant.RECORDS_PER_PAGE);
		
		Map<Object,Object> resultMap = patientBo.findByLastName(mapCriteria);
		
		List<Patient> resultList = (List<Patient>) resultMap.get("resultList");
		Integer noOfPages = (Integer) resultMap.get("noOfPages");
		
		boolean gotRecords = resultList!=null && resultList.size() > 0 ? true : false;
		
		model.addAttribute("resultList", resultList);
		model.addAttribute("searchFlag", true);
		model.addAttribute("gotRecords", gotRecords);
		model.addAttribute("currentPage", page);
		model.addAttribute("noOfPages", noOfPages);
		
		return new ModelAndView("transaction/labrequest/searchPatientForLabRequest", "patient", patient);
	}
			
	@RequestMapping(value = "/goToLabRequest", method=RequestMethod.GET)
	public ModelAndView goToLabRequest(@RequestParam("patientId") int patientId, ModelMap model) throws Exception {
		
		if (!LRMSUtil.isUserSessionValid(model)) {
			logger.info(LRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		Patient patientEntity = patientBo.findById(patientId);
		
		PatientLabRequest patientLabReq = new PatientLabRequest();
		patientLabReq.setPatient(patientEntity);
		patientLabReq.setAge(patientEntity.getBirthday()!=null ? LRMSUtil.getAge(LocalDate.parse(DateUtils.sqlDateToStringSQL(patientEntity.getBirthday()))) : 0);
				
		model.addAttribute("physicians", physicians);
		model.addAttribute("labExamList", labExamList);
		
		return new ModelAndView("transaction/labrequest/labRequestForm", "patientLabReq", patientLabReq);
	}
	
	@RequestMapping(value = "/saveLabRequest", method = RequestMethod.POST)
	public ModelAndView saveLabRequest(@ModelAttribute("patientLabReq") @Validated PatientLabRequest patientLabReq, 
		      BindingResult result, ModelMap model) throws Exception {
		
		if (!LRMSUtil.isUserSessionValid(model)) {
			logger.info(LRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		model.addAttribute("physicians", physicians);
		model.addAttribute("labExamList", labExamList);
		
		if (result.hasErrors()) {
			return new ModelAndView("transaction/labrequest/labRequestForm", "patientLabReq", patientLabReq);
		}
		     
		patientLabReq.setLabRequestNo(generateLabRequestNo());
		patientLabReq.setCreatedBy(LRMSUtil.getUserIdFromSession(model));
		
		boolean isSuccess = patientLabRequestBo.save(patientLabReq);
		
		model.addAttribute("isSuccess", isSuccess);
		
		patientLabReq = patientLabRequestBo.getPatientLabRequest(patientLabReq.getLabRequestNo());
		
		return new ModelAndView("transaction/labrequest/labRequestForm", "patientLabReq", patientLabReq);
	}
	
	//Not used
	@RequestMapping(value = "/editLabRequest", method=RequestMethod.GET)
	public ModelAndView editLabRequest(@RequestParam("id") int patientiId, ModelMap model) throws Exception {
		
		if (!LRMSUtil.isUserSessionValid(model)) {
			logger.info(LRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		model.addAttribute("physicians", physicians);
		
		Patient resultEntity = patientBo.findById(patientiId);
		return new ModelAndView("masterfile/patient/editPatient", "patient", resultEntity);
	}
	
	//Not used
	@RequestMapping(value = "/updateLabRequest", method = RequestMethod.POST)
	public ModelAndView updateLabRequest(@ModelAttribute("patient" ) @Validated Patient patient, 
		      BindingResult result, ModelMap model) throws Exception {
		
		if (!LRMSUtil.isUserSessionValid(model)) {
			logger.info(LRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		model.addAttribute("physicians", physicians);
		
	    if (result.hasErrors()) {
	    	return new ModelAndView("masterfile/patient/editPatient");
	    }
	          
		boolean isSuccess = patientBo.update(patient);
		
		model.addAttribute("isSuccess", isSuccess);
		
		return new ModelAndView("masterfile/patient/editPatient");
	}
	
	//Not used
	@RequestMapping(value = "/deleteLabRequest", method=RequestMethod.GET)
	public ModelAndView deleteLabRequest(@RequestParam("id") int id, ModelMap model) throws Exception {
		
		if (!LRMSUtil.isUserSessionValid(model)) {
			logger.info(LRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
//		boolean isSuccess =  patientLabRequestBo.delete(id);
//		model.addAttribute("isDeleted", isSuccess);
		
		return new ModelAndView("masterfile/patient/searchPatient", "patient", new Patient());
	}
	
	public String generateLabRequestNo() throws Exception {
		StringBuilder sb = new StringBuilder(15);
		try {
			Calendar now = Calendar.getInstance();
			int currentMonth = now.get(Calendar.MONTH) + 1;//0-11
			int currentDayOfMonth = now.get(Calendar.DAY_OF_MONTH);
			sb.append("R");
			sb.append(now.get(Calendar.YEAR));
			sb.append(String.format("%02d", currentMonth));
			sb.append(String.format("%02d", currentDayOfMonth));
			sb.append(String.format("%06d", patientLabRequestBo.getRecordCount()+1));//get the total record count
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return sb.toString();
	}
		
}
