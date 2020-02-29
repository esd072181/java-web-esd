package com.crms.controller;

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

import com.crms.bo.LabExamBo;
import com.crms.bo.PatientBo;
import com.crms.bo.PatientConsultationBo;
import com.crms.bo.ProfessionalBo;
import com.crms.constant.CRMSConstant;
import com.crms.model.Patient;
import com.crms.model.PatientConsultation;
import com.crms.model.Professional;
import com.crms.model.UserAccount;
import com.crms.util.DateUtils;
import com.crms.util.CRMSUtil;

@Controller
@SessionAttributes("userid")
public class ConsultationController {
	
	private final static Logger logger = Logger.getLogger(ConsultationController.class);
	
	@Autowired
	private PatientBo patientBo;
	@Autowired
	private ProfessionalBo professionalBo;
	@Autowired
	private LabExamBo labExamBo;
	@Autowired
	private PatientConsultationBo patientConsultationBo;
	
	private List<Professional> physicians = new ArrayList<>();
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		        		
        binder.registerCustomEditor(Professional.class, new PropertyEditorSupport() {
        	@Override
			public void setAsText(String id) throws IllegalArgumentException {
			       this.setValue(new Professional(Integer.parseInt(id)));
			}
        });
        
	}
	
	@RequestMapping("/goToSearchPatientForConsultation")
	public ModelAndView goToSearchPatientForLabRequest(ModelMap model) {
		
		if (!CRMSUtil.isUserSessionValid(model)) {
			logger.info(CRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		physicians = professionalBo.getAllPhysician();
		model.addAttribute("searchFlag", false);
		
		return new ModelAndView("transaction/consultation/searchPatientForConsultation", "patient", new Patient());
	}
	
	@RequestMapping("/goToPatientRegistration")
	public ModelAndView goToAddPatient(ModelMap model) {
		
		if (!CRMSUtil.isUserSessionValid(model)) {
			logger.info(CRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		return new ModelAndView("transaction/consultation/patientRegistration", "patient", new Patient());
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/searchPatientForConsultation")
	public ModelAndView searchPatient(@RequestParam("page") String page, @ModelAttribute("patient") Patient patient, 
    			BindingResult result, ModelMap model) throws Exception {
		
		if (!CRMSUtil.isUserSessionValid(model)) {
			logger.info(CRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		//Note: can use modelattribute in a form in jsp
		//or can simply pass a parameter
		
		Map<Object,Object> mapCriteria = new HashMap<Object,Object>();
		
		mapCriteria.put("search_criteria", patient.getLastName()!=null ? patient.getLastName() : "");
		mapCriteria.put("record_start", CRMSUtil.getRecordStartIndex(page!=null ? Integer.parseInt(page) : 1));
		mapCriteria.put("max_result", CRMSConstant.RECORDS_PER_PAGE);
		
		Map<Object,Object> resultMap = patientBo.findByLastName(mapCriteria);
		
		List<Patient> resultList = (List<Patient>) resultMap.get("resultList");
		Integer noOfPages = (Integer) resultMap.get("noOfPages");
		
		boolean gotRecords = resultList!=null && resultList.size() > 0 ? true : false;
		
		model.addAttribute("resultList", resultList);
		model.addAttribute("searchFlag", true);
		model.addAttribute("gotRecords", gotRecords);
		model.addAttribute("currentPage", page);
		model.addAttribute("noOfPages", noOfPages);
		
		return new ModelAndView("transaction/consultation/searchPatientForConsultation", "patient", patient);
	}
			
	@RequestMapping(value = "/goToConsultation", method=RequestMethod.GET)
	public ModelAndView goToLabRequest(@RequestParam("patientId") int patientId, ModelMap model) throws Exception {
		
		if (!CRMSUtil.isUserSessionValid(model)) {
			logger.info(CRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		Patient patientEntity = patientBo.findById(patientId);
		
		PatientConsultation patientConsultation = new PatientConsultation();
		patientConsultation.setPatient(patientEntity);
		patientConsultation.setAge(patientEntity.getBirthday()!=null ? CRMSUtil.getAge(LocalDate.parse(DateUtils.sqlDateToStringSQL(patientEntity.getBirthday()))) : 0);
				
		model.addAttribute("physicians", physicians);
		
		return new ModelAndView("transaction/consultation/consultationForm", "patientConsultation", patientConsultation);
	}
	
	@RequestMapping(value = "/saveConsultation", method = RequestMethod.POST)
	public ModelAndView saveLabRequest(@ModelAttribute("patientConsultation") @Validated PatientConsultation patientConsultation, 
		      BindingResult result, ModelMap model) throws Exception {
		
		if (!CRMSUtil.isUserSessionValid(model)) {
			logger.info(CRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		model.addAttribute("physicians", physicians);
		
		if (result.hasErrors()) {
			return new ModelAndView("transaction/consultation/consultationForm", "patientConsultation", patientConsultation);
		}
		     
		patientConsultation.setConsultNo(generateConsultNo());
		patientConsultation.setCreatedBy(CRMSUtil.getUserIdFromSession(model));
		
		boolean isSuccess = patientConsultationBo.save(patientConsultation);
		
		model.addAttribute("isSuccess", isSuccess);
		
		patientConsultation = patientConsultationBo.getPatientConsultation(patientConsultation.getConsultNo());
		
		return new ModelAndView("transaction/consultation/consultationForm", "patientConsultation", patientConsultation);
	}
	
	//Not used
	@RequestMapping(value = "/editConsultation", method=RequestMethod.GET)
	public ModelAndView editLabRequest(@RequestParam("id") int patientiId, ModelMap model) throws Exception {
		
		if (!CRMSUtil.isUserSessionValid(model)) {
			logger.info(CRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		model.addAttribute("physicians", physicians);
		
		Patient resultEntity = patientBo.findById(patientiId);
		return new ModelAndView("masterfile/patient/editPatient", "patient", resultEntity);
	}
	
	//Not used
	@RequestMapping(value = "/updateConsultation", method = RequestMethod.POST)
	public ModelAndView updateLabRequest(@ModelAttribute("patient" ) @Validated Patient patient, 
		      BindingResult result, ModelMap model) throws Exception {
		
		if (!CRMSUtil.isUserSessionValid(model)) {
			logger.info(CRMSConstant.USER_INVALID_SESSION);
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
	@RequestMapping(value = "/deleteConsultation", method=RequestMethod.GET)
	public ModelAndView deleteLabRequest(@RequestParam("id") int id, ModelMap model) throws Exception {
		
		if (!CRMSUtil.isUserSessionValid(model)) {
			logger.info(CRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
//		boolean isSuccess =  patientConsultationuestBo.delete(id);
//		model.addAttribute("isDeleted", isSuccess);
		
		return new ModelAndView("masterfile/patient/searchPatient", "patient", new Patient());
	}
	
	public String generateConsultNo() throws Exception {
		StringBuilder sb = new StringBuilder(15);
		try {
			Calendar now = Calendar.getInstance();
			int currentMonth = now.get(Calendar.MONTH) + 1;//0-11
			int currentDayOfMonth = now.get(Calendar.DAY_OF_MONTH);
			sb.append("C");
			sb.append(now.get(Calendar.YEAR));
			sb.append(String.format("%02d", currentMonth));
			sb.append(String.format("%02d", currentDayOfMonth));
			sb.append(String.format("%06d", patientConsultationBo.getRecordCount()+1));//get the total record count
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return sb.toString();
	}
		
}
