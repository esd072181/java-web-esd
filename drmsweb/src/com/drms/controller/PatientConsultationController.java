package com.drms.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.drms.bo.MedicineBo;
import com.drms.bo.PatientBillBo;
import com.drms.bo.PatientBillPaymentBo;
import com.drms.bo.PatientConsultationBo;
import com.drms.bo.PatientMedBo;
import com.drms.constant.DRMSConstant;
import com.drms.model.ListValue;
import com.drms.model.Medicine;
import com.drms.model.Patient;
import com.drms.model.PatientBill;
import com.drms.model.PatientBillPayment;
import com.drms.model.PatientConsultation;
import com.drms.model.PatientMed;
import com.drms.model.UserAccount;
import com.drms.propertyeditor.CustomSQLDateEditor;
import com.drms.util.DRMSUtil;
import com.drms.util.ReportUtils;

@Controller
@SessionAttributes(value =  {"userid","roleid"})
public class PatientConsultationController {
	
	private final static Logger logger = Logger.getLogger(PatientConsultationController.class);
	
	@Autowired
	private PatientConsultationBo patientConsultationBo;
	@Autowired
	private PatientBillBo patientBillBo;
	@Autowired
	private PatientBillPaymentBo patientBillPaymentBo;
	@Autowired
	private MedicineBo medBo;
	@Autowired
	private PatientMedBo patientMedBo;
	@Autowired
	private ServletContext context;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		
        CustomSQLDateEditor dateEditor = new CustomSQLDateEditor(null, true);
        binder.registerCustomEditor(Date.class, dateEditor);
	    		
	}
		
	@RequestMapping("/goToSearchPatientConsultation")
	public ModelAndView goToSearchPatientConsultation(ModelMap model) {
		
		if (!DRMSUtil.isUserSessionValid(model)) {
			logger.info(DRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		model.addAttribute("searchFlag", false);
		return new ModelAndView("transaction/patientconsultation/searchPatientConsultation", "patient", new Patient());
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/searchPatientConsultation")
	public ModelAndView searchPatientConsultation(@RequestParam("page") String page, @ModelAttribute("patient") Patient patient, 
    			BindingResult result, ModelMap model) throws Exception {
		
		if (!DRMSUtil.isUserSessionValid(model)) {
			logger.info(DRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		Map<Object,Object> mapCriteria = new HashMap<Object,Object>();
		
		mapCriteria.put("search_criteria", patient.getLastName()!=null ? patient.getLastName() : "");
		mapCriteria.put("record_start", DRMSUtil.getRecordStartIndex(page!=null ? Integer.parseInt(page) : 1));
		mapCriteria.put("max_result", DRMSConstant.RECORDS_PER_PAGE);
		
		Map<Object,Object> resultMap = patientConsultationBo.findByName(mapCriteria);
		
		List<PatientConsultation> resultList = (List<PatientConsultation>) resultMap.get("resultList");
		Integer noOfPages = (Integer) resultMap.get("noOfPages");
		
		boolean gotRecords = resultList!=null && resultList.size() > 0 ? true : false;
		
		model.addAttribute("resultList", resultList);
		model.addAttribute("searchFlag", true);
		model.addAttribute("gotRecords", gotRecords);
		model.addAttribute("currentPage", page);
		model.addAttribute("noOfPages", noOfPages);
		
		return new ModelAndView("transaction/patientconsultation/searchPatientConsultation", "patient", patient);
	}
	
	@RequestMapping("/goToViewPatientConsultation")
	public ModelAndView goToViewPatientConsultation(@RequestParam("consultId") String consultId, @ModelAttribute("patient") Patient patient,
    			BindingResult result, ModelMap model) throws Exception {
		
		if (!DRMSUtil.isUserSessionValid(model)) {
			logger.info(DRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		PatientConsultation patientConsultation = patientConsultationBo.findById(Integer.parseInt(consultId));
		
		//get lab exam list
		List<Medicine> medList = medBo.getAllEntity();
		model.addAttribute("medList", medList);
		
		PatientBill bill = patientBillBo.getPatientBill(Integer.parseInt(consultId));
		
		//consult fee and total Bill
		model.addAttribute("consultFee", bill.getConsultFee());
		model.addAttribute("totalBill", bill.getTotalBill());
		
		return new ModelAndView("transaction/patientconsultation/viewPatientConsultation", "patientConsultation", patientConsultation);
	}

	@RequestMapping(value = "/saveUpdateConsultation", method = RequestMethod.POST)
	public ModelAndView saveUpdateConsultation(@ModelAttribute("patientConsultation") PatientConsultation patientConsultation, 
			BindingResult result, ModelMap model) throws Exception {
		
		if (!DRMSUtil.isUserSessionValid(model)) {
			logger.info(DRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		boolean transactStatus = false;
		
		String diagnosis = patientConsultation.getDiagnosis();
		String consultProcedure = patientConsultation.getConsultationProcedure();
		String medStatement = patientConsultation.getMedicationStatement();
		Date nextConsultDate = patientConsultation.getNextConsultDate();
	
		patientConsultation = patientConsultationBo.findById(patientConsultation.getId());
		patientConsultation.setDiagnosis(diagnosis);
		patientConsultation.setConsultationProcedure(consultProcedure);
		patientConsultation.setMedicationStatement(medStatement);
		patientConsultation.setNextConsultDate(nextConsultDate);
		patientConsultation.setStatus(new ListValue(202));//Completed
		patientConsultation.setModifiedBy(DRMSUtil.getUserIdFromSession(model));
			 
		transactStatus = patientConsultationBo.update(patientConsultation);
		
		//get med list
		List<Medicine> medList = medBo.getAllEntity();
		model.addAttribute("medList", medList);
		
		model.addAttribute("isUpdated", transactStatus);

		PatientBill bill = patientBillBo.getPatientBill(patientConsultation.getId());
		
		//consult fee and total Bill
		model.addAttribute("consultFee", bill.getConsultFee());
		model.addAttribute("totalBill", bill.getTotalBill());
		
		patientConsultation = patientConsultationBo.findById(patientConsultation.getId());//get the latest updated status
		
		return new ModelAndView("transaction/patientconsultation/viewPatientConsultation", "patientConsultation", patientConsultation);
	}	

	@RequestMapping("/addNewMed")
	public ModelAndView addNewMed(@RequestParam("consultId") String consultId,@RequestParam("qty") String qty, @RequestParam("medId") String medId,
			@ModelAttribute("patientConsultation") PatientConsultation patientConsultation, BindingResult result, ModelMap model) throws Exception {
		
		if (!DRMSUtil.isUserSessionValid(model)) {
			logger.info(DRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		boolean transactStatus = false;
		
		Medicine med = medBo.findById(Integer.parseInt(medId));
		
		PatientMed modelMed = new PatientMed();
		modelMed.setPatientConsultation(patientConsultationBo.findById(Integer.parseInt(consultId)));
		modelMed.setMed(med);
		modelMed.setQty(Integer.parseInt(qty));
		modelMed.setPrice(med.getRetailSellingPrice());
		double amount = modelMed.getQty() * med.getRetailSellingPrice().doubleValue();
		modelMed.setAmount(new BigDecimal(amount));
		modelMed.setCreatedBy(DRMSUtil.getUserIdFromSession(model));
				
		//need to udpate the bill record
		if (patientMedBo.save(modelMed)) {
			
			//update to the latest model of consultation - to get the new added labexam
			patientConsultation = patientConsultationBo.findById(Integer.parseInt(consultId));
			
			//compute total fees
			PatientBill billModel = patientBillBo.getPatientBill(Integer.parseInt(consultId)); 
			billModel.setTotalMedFee(patientConsultation.getTotalMedAmount());
			double totalBill = billModel.getConsultFee().doubleValue() + billModel.getTotalMedFee().doubleValue();
			billModel.setTotalBill(new BigDecimal(totalBill));
			billModel.setDateProcessed(new java.sql.Timestamp(System.currentTimeMillis()));
			billModel.setModifiedBy(DRMSUtil.getUserIdFromSession(model)); 
			
			transactStatus = patientBillBo.update(billModel);
		}
		
		//get med list
		List<Medicine> medList = medBo.getAllEntity();
		model.addAttribute("medList", medList);
		
		model.addAttribute("isUpdated", transactStatus);

		PatientBill bill = patientBillBo.getPatientBill(Integer.parseInt(consultId));
		
		//consult fee and total Bill
		model.addAttribute("consultFee", bill.getConsultFee());
		model.addAttribute("totalBill", bill.getTotalBill());
		
		return new ModelAndView("transaction/patientconsultation/viewPatientConsultation", "patientConsultation", patientConsultation);
	}	
		
	@RequestMapping("/deletePatientMed")
	public ModelAndView deletePatientMed(@RequestParam("consultId") String consultId, @RequestParam("patientMedId") String patientMedId,
			@ModelAttribute("patientConsultation") PatientConsultation patientConsultation, BindingResult result, ModelMap model) throws Exception {
		
		if (!DRMSUtil.isUserSessionValid(model)) {
			logger.info(DRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		boolean transactStatus = false;
		
		PatientMed pMed = patientMedBo.findById(Integer.parseInt(patientMedId));
		pMed.setModifiedBy(DRMSUtil.getUserIdFromSession(model));
		
		if (patientMedBo.delete(pMed)) {

			//need to udpate the bill record
			//update to the latest model of lab request - to get the new added labexam
			patientConsultation = patientConsultationBo.findById(Integer.parseInt(consultId));
			
			//compute total fees
			PatientBill billModel = patientBillBo.getPatientBill(Integer.parseInt(consultId)); 
			billModel.setTotalMedFee(patientConsultation.getTotalMedAmount());
			double totalBill = billModel.getConsultFee().doubleValue() + billModel.getTotalMedFee().doubleValue();
			billModel.setTotalBill(new BigDecimal(totalBill));
			billModel.setDateProcessed(new java.sql.Timestamp(System.currentTimeMillis()));
			billModel.setModifiedBy(DRMSUtil.getUserIdFromSession(model));
			
			transactStatus = patientBillBo.update(billModel);
		}
		
		//get med list
		List<Medicine> medList = medBo.getAllEntity();
		model.addAttribute("medList", medList);
		
		model.addAttribute("isUpdated", transactStatus);
	
		PatientBill bill = patientBillBo.getPatientBill(Integer.parseInt(consultId));
		
		//consult fee and total Bill
		model.addAttribute("consultFee", bill.getConsultFee());
		model.addAttribute("totalBill", bill.getTotalBill());
		
		return new ModelAndView("transaction/patientconsultation/viewPatientConsultation", "patientConsultation", patientConsultation);
	}

	@RequestMapping("/goToPayNow")
	public ModelAndView goToPayNow(@RequestParam("consultId") String consultId, @RequestParam("tenderedAmt") Double tenderedAmt,
			@ModelAttribute("patientConsultation") PatientConsultation patientConsultation, BindingResult result, ModelMap model) throws Exception {
		
		if (!DRMSUtil.isUserSessionValid(model)) {
			logger.info(DRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		boolean transactStatus = false;
		boolean isPaymentDone = false;
		
		PatientBill billModel = patientBillBo.getPatientBill(Integer.parseInt(consultId));

		//check if existing already
		if (patientBillPaymentBo.getPatientBillPayment(billModel.getId()) == null) {
			
			//Create Payment record in PaymentBillPayment table
			PatientBillPayment payment = new PatientBillPayment();
			payment.setPatientBill(billModel);
			payment.setAmount(billModel.getTotalBill());//Default to TotalBill
			payment.setModeOfPayment(401);//Default to Cash
			payment.setCreatedBy(DRMSUtil.getUserIdFromSession(model));
			
			if (patientBillPaymentBo.save(payment)) {
				//update the Patient Bill cleared to true
				PatientBill bill = payment.getPatientBill();
				bill.setCleared(true);
				bill.setModifiedBy(DRMSUtil.getUserIdFromSession(model));
				if (patientBillBo.update(bill)) {
					//Update payment status in Patient Consultation table
					patientConsultation = patientConsultationBo.findById(Integer.parseInt(consultId));
					patientConsultation.setPaymentStatus(new ListValue(302));//Paid
					patientConsultation.setModifiedBy(DRMSUtil.getUserIdFromSession(model));
					transactStatus = patientConsultationBo.update(patientConsultation);
				}
			}
			
			//update to the latest model of consultation
			patientConsultation = patientConsultationBo.findById(Integer.parseInt(consultId));
					
			//get med list
			List<Medicine> medList = new ArrayList<>(); //pass blank list after payment
			model.addAttribute("medList", medList);
			
			model.addAttribute("isUpdated", transactStatus);
		
			PatientBill bill = patientBillBo.getPatientBill(Integer.parseInt(consultId));
			
			//consult fee and total Bill
			model.addAttribute("consultFee", bill.getConsultFee());
			model.addAttribute("totalBill", bill.getTotalBill());
			
			isPaymentDone = true;
		} 
		
		if (isPaymentDone) {
			model.addAttribute("tenderedAmt", tenderedAmt);
			model.addAttribute("changeAmt", new BigDecimal(tenderedAmt).subtract(billModel.getTotalBill()));
		}
				
		return new ModelAndView("transaction/patientconsultation/viewPatientConsultation", "patientConsultation", patientConsultation);
	}

	@RequestMapping("/updateFee")
	public ModelAndView updateFee(@RequestParam("consultId") String consultId, @RequestParam("fee") String fee, @ModelAttribute("patientConsultation") PatientConsultation patientConsultation,
    			BindingResult result, ModelMap model) throws Exception {
		
		if (!DRMSUtil.isUserSessionValid(model)) {
			logger.info(DRMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		boolean transactStatus = false;
		
		PatientBill bill = patientBillBo.getPatientBill(Integer.parseInt(consultId));
		bill.setConsultFee(new BigDecimal(fee));
		if (bill.getTotalMedFee()!=null) {
			bill.setTotalBill(new BigDecimal(bill.getConsultFee().doubleValue() + bill.getTotalMedFee().doubleValue()));
		}else {
			bill.setTotalBill(bill.getConsultFee());
		}
		bill.setModifiedBy(DRMSUtil.getUserIdFromSession(model));
		
		transactStatus = patientBillBo.update(bill);
		
		if (transactStatus) {
			logger.info("Patient Bill updated for consultid: " + consultId);
		}
		
		//update to the latest model of consultation
		patientConsultation = patientConsultationBo.findById(Integer.parseInt(consultId));
				
		//get med list
		List<Medicine> medList = medBo.getAllEntity();
		model.addAttribute("medList", medList);
		
		model.addAttribute("isUpdated", transactStatus);
	
		bill = patientBillBo.getPatientBill(Integer.parseInt(consultId));
		
		//consult fee and total Bill
		model.addAttribute("consultFee", bill.getConsultFee());
		model.addAttribute("totalBill", bill.getTotalBill());
		
		return new ModelAndView("transaction/patientconsultation/viewPatientConsultation", "patientConsultation", patientConsultation);
	}

	
	 @RequestMapping("/viewPrescriptionReport")
	 public void viewPrescriptionReport(@RequestParam("consultId") String consultId, HttpServletResponse response) throws Exception {
		
		PatientConsultation	patientConsultation = patientConsultationBo.findById(Integer.parseInt(consultId));//get the latest updated

		//generate the report
		String localPath = context.getRealPath("/") + File.separator + "reports";
		Path path = Paths.get(DRMSConstant.PDF_REPORT_ORIG_PATH);
		if (!Files.exists(path)) {
			Files.createDirectories(path);
		}
		String destFile = path + File.separator + DRMSConstant.PDF_PRESCRIPTION_REPORT + patientConsultation.getConsultNo() + ".pdf";
		File reportFile = new File(localPath + File.separator + DRMSConstant.RPT_PRESCRIPTION_JASPER);
				
		boolean isReportGenerated = ReportUtils.generatePrescriptionReport(DRMSConstant.RPT_PRESCRIPTION_TITLE, destFile, reportFile, patientConsultation);
		if (isReportGenerated) {
			System.out.println("Report generated..");
						
			File pdfFile = new File(destFile.toString());
			 
			try {
			     OutputStream os = response.getOutputStream();
			     byte[] buf = new byte[8192];
			     InputStream is = new FileInputStream(pdfFile);
			     int c = 0;
			     while ((c = is.read(buf, 0, buf.length)) > 0) {
			        os.write(buf, 0, c);
			        os.flush();
			     }
			     os.close();
			     is.close();
			 } catch (IOException e) {
			     e.printStackTrace();
			 }
			
		}
		 

	  }
	 
	 @RequestMapping("/showPatientHistory")
	 public ModelAndView showPatientHistory(@RequestParam("patientId") Integer patientId, @RequestParam("page") String page, 
			 @ModelAttribute("patientConsultation") PatientConsultation patientConsultation, BindingResult result, ModelMap model) throws Exception {
			
			if (!DRMSUtil.isUserSessionValid(model)) {
				logger.info(DRMSConstant.USER_INVALID_SESSION);
				return new ModelAndView("security/login", "userAccount", new UserAccount());	
			}
			
			Map<Object,Object> mapCriteria = new HashMap<Object,Object>();
			mapCriteria.put("record_start", DRMSUtil.getRecordStartIndex(page!=null ? Integer.parseInt(page) : 1));
			mapCriteria.put("max_result", DRMSConstant.RECORDS_PER_PAGE);
			mapCriteria.put("patient_system_id", patientId);
			
			//get the history
			Map<Object,Object>  resultMap = patientConsultationBo.findByPatientSystemId(mapCriteria);
			Integer noOfPages = (Integer) resultMap.get("noOfPages");
			
			@SuppressWarnings("unchecked")
			List<PatientConsultation> resultList = (List<PatientConsultation>) resultMap.get("resultList");
			
			boolean gotRecords = resultList!=null && resultList.size() > 0 ? true : false;

			model.addAttribute("resultList", resultList);
			model.addAttribute("searchFlag", true);
			model.addAttribute("gotRecords", gotRecords);
			model.addAttribute("currentPage", page);
			model.addAttribute("noOfPages", noOfPages);
			
			if (!resultList.isEmpty()) {
				patientConsultation = resultList.get(0);
			}
		
			return new ModelAndView("transaction/patientconsultation/viewPatientHistory", "patientConsultation", patientConsultation);
	}

}
