//package com.sims.controller;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.math.BigDecimal;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.sql.Date;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.ServletContext;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.InitBinder;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.sims.bo.BrandBo;
//import com.sims.bo.MedicineBo;
//import com.sims.bo.PatientBillBo;
//import com.sims.bo.PatientBillPaymentBo;
//import com.sims.bo.PatientConsultationBo;
//import com.sims.bo.PatientLabExamBo;
//import com.sims.bo.PatientMedBo;
//import com.sims.bo.EmployeeBo;
//import com.sims.constant.SIMSConstant;
//import com.sims.model.Brand;
//import com.sims.model.ListValue;
//import com.sims.model.Category;
//import com.sims.model.Item;
//import com.sims.model.PatientBill;
//import com.sims.model.PatientBillPayment;
//import com.sims.model.PatientConsultation;
//import com.sims.model.PatientLabExam;
//import com.sims.model.PatientMed;
//import com.sims.model.UserAccount;
//import com.sims.propertyeditor.CustomSQLDateEditor;
//import com.sims.util.SIMSUtil;
//import com.sims.util.ReportUtils;
//
//@Controller
//@SessionAttributes(value =  {"userid","roleid"})
//public class PatientConsultationController {
//	
//	private final static Logger logger = Logger.getLogger(PatientConsultationController.class);
//	
//	@Autowired
//	private PatientConsultationBo patientConsultationBo;
//	@Autowired
//	private PatientBillBo patientBillBo;
//	@Autowired
//	private PatientBillPaymentBo patientBillPaymentBo;
//	@Autowired
//	private BrandBo labExamBo;
//	@Autowired
//	private MedicineBo medBo;
//	@Autowired
//	private PatientLabExamBo patientLabExamBo;
//	@Autowired
//	private PatientMedBo patientMedBo;
//	@Autowired
//	private EmployeeBo professionalBo;
//	@Autowired
//	private ServletContext context;
//	
//	@InitBinder
//	protected void initBinder(WebDataBinder binder) {
//		
//        CustomSQLDateEditor dateEditor = new CustomSQLDateEditor(null, true);
//        binder.registerCustomEditor(Date.class, dateEditor);
//	    		
//	}
//		
//	@RequestMapping("/goToSearchPatientConsultation")
//	public ModelAndView goToSearchPatientConsultation(ModelMap model) {
//		
//		if (!SIMSUtil.isUserSessionValid(model)) {
//			logger.info(SIMSConstant.USER_INVALID_SESSION);
//			return new ModelAndView("security/login", "userAccount", new UserAccount());	
//		}
//		
//		model.addAttribute("searchFlag", false);
//		return new ModelAndView("transaction/patientconsultation/searchPatientConsultation", "patient", new Item());
//	}
//	
//	@SuppressWarnings("unchecked")
//	@RequestMapping("/searchPatientConsultation")
//	public ModelAndView searchPatientConsultation(@RequestParam("page") String page, @ModelAttribute("patient") Item patient, 
//    			BindingResult result, ModelMap model) throws Exception {
//		
//		if (!SIMSUtil.isUserSessionValid(model)) {
//			logger.info(SIMSConstant.USER_INVALID_SESSION);
//			return new ModelAndView("security/login", "userAccount", new UserAccount());	
//		}
//		
//		Map<Object,Object> mapCriteria = new HashMap<Object,Object>();
//		
//		mapCriteria.put("search_criteria", patient.getLastName()!=null ? patient.getLastName() : "");
//		mapCriteria.put("record_start", SIMSUtil.getRecordStartIndex(page!=null ? Integer.parseInt(page) : 1));
//		mapCriteria.put("max_result", SIMSConstant.RECORDS_PER_PAGE);
//		
//		Map<Object,Object> resultMap = patientConsultationBo.findByName(mapCriteria);
//		
//		List<PatientConsultation> resultList = (List<PatientConsultation>) resultMap.get("resultList");
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
//		return new ModelAndView("transaction/patientconsultation/searchPatientConsultation", "patient", patient);
//	}
//	
//	@RequestMapping("/goToViewPatientConsultation")
//	public ModelAndView goToViewPatientConsultation(@RequestParam("consultId") String consultId, @ModelAttribute("patient") Item patient,
//    			BindingResult result, ModelMap model) throws Exception {
//		
//		if (!SIMSUtil.isUserSessionValid(model)) {
//			logger.info(SIMSConstant.USER_INVALID_SESSION);
//			return new ModelAndView("security/login", "userAccount", new UserAccount());	
//		}
//		
//		PatientConsultation patientConsultation = patientConsultationBo.findById(Integer.parseInt(consultId));
//		
//		//get lab exam list
//		List<Brand> labExamList = labExamBo.getAllEntity();
//		model.addAttribute("labExamList", labExamList);
//		
//		//get lab exam list
//		List<Category> medList = medBo.getAllEntity();
//		model.addAttribute("medList", medList);
//		
//		PatientBill bill = patientBillBo.getPatientBill(Integer.parseInt(consultId));
//		
//		//consult fee and total Bill
//		model.addAttribute("consultFee", bill.getConsultFee());
//		model.addAttribute("totalBill", bill.getTotalBill());
//		
//		return new ModelAndView("transaction/patientconsultation/viewPatientConsultation", "patientConsultation", patientConsultation);
//	}
//
//	@RequestMapping(value = "/saveUpdateConsultation", method = RequestMethod.POST)
//	public ModelAndView saveUpdateConsultation(@ModelAttribute("patientConsultation") PatientConsultation patientConsultation, 
//			BindingResult result, ModelMap model) throws Exception {
//		
//		if (!SIMSUtil.isUserSessionValid(model)) {
//			logger.info(SIMSConstant.USER_INVALID_SESSION);
//			return new ModelAndView("security/login", "userAccount", new UserAccount());	
//		}
//		
//		boolean transactStatus = false;
//		
//		String diagnosis = patientConsultation.getDiagnosis();
//		String medStatement = patientConsultation.getMedicationStatement();
//		String prognosis = patientConsultation.getPrognosis();
//		Date nextConsultDate = patientConsultation.getNextConsultDate();
//		
//		patientConsultation = patientConsultationBo.findById(patientConsultation.getId());
//		patientConsultation.setDiagnosis(diagnosis);
//		patientConsultation.setMedicationStatement(medStatement);
//		patientConsultation.setPrognosis(prognosis);
//		patientConsultation.setNextConsultDate(nextConsultDate);
//		patientConsultation.setStatus(new ListValue(202));//Completed
//		patientConsultation.setModifiedBy(SIMSUtil.getUserIdFromSession(model));
//			 
//		transactStatus = patientConsultationBo.update(patientConsultation);
//		
//		//get lab exam list
//		List<Brand> labExamList = labExamBo.getAllEntity();
//		model.addAttribute("labExamList", labExamList);
//		
//		//get med list
//		List<Category> medList = medBo.getAllEntity();
//		model.addAttribute("medList", medList);
//		
//		model.addAttribute("isUpdated", transactStatus);
//
//		PatientBill bill = patientBillBo.getPatientBill(patientConsultation.getId());
//		
//		//consult fee and total Bill
//		model.addAttribute("consultFee", bill.getConsultFee());
//		model.addAttribute("totalBill", bill.getTotalBill());
//		
//		patientConsultation = patientConsultationBo.findById(patientConsultation.getId());//get the latest updated status
//		
//		return new ModelAndView("transaction/patientconsultation/viewPatientConsultation", "patientConsultation", patientConsultation);
//	}	
//
//	@RequestMapping(value = "/endConsultation", method = RequestMethod.GET)
//	public ModelAndView endConsultation(@RequestParam("consultId") String consultId, @ModelAttribute("patientConsultation") PatientConsultation patientConsultation, 
//			BindingResult result, ModelMap model) throws Exception {
//		
//		if (!SIMSUtil.isUserSessionValid(model)) {
//			logger.info(SIMSConstant.USER_INVALID_SESSION);
//			return new ModelAndView("security/login", "userAccount", new UserAccount());	
//		}
//		
//		boolean transactStatus = false;
//		
//		patientConsultation = patientConsultationBo.findById(Integer.parseInt(consultId));
//		
//		if (patientConsultation.getMedicationStatement() !=null && patientConsultation.getMedicationStatement().trim().length() > 0) {
//			patientConsultation.setStatus(new ListValue(202));//Completed
//			patientConsultation.setModifiedBy(SIMSUtil.getUserIdFromSession(model));
//				 
//			transactStatus = patientConsultationBo.update(patientConsultation);
//			
//			//get lab exam list
//			List<Brand> labExamList = new ArrayList<>();
//			model.addAttribute("labExamList", labExamList);
//			
//			//get med list
//			List<Category> medList = new ArrayList<>();
//			model.addAttribute("medList", medList);
//		} 
//		
//		model.addAttribute("isUpdated", transactStatus);
//
//		PatientBill bill = patientBillBo.getPatientBill(patientConsultation.getId());
//		
//		//consult fee and total Bill
//		model.addAttribute("consultFee", bill.getConsultFee());
//		model.addAttribute("totalBill", bill.getTotalBill());
//		
//		patientConsultation = patientConsultationBo.findById(patientConsultation.getId());//get the latest updated status
//		
//		return new ModelAndView("transaction/patientconsultation/viewPatientConsultation", "patientConsultation", patientConsultation);
//	}	
//
//	@RequestMapping("/addNewMed")
//	public ModelAndView addNewMed(@RequestParam("consultId") String consultId,@RequestParam("qty") String qty, @RequestParam("medId") String medId,
//			@ModelAttribute("patientConsultation") PatientConsultation patientConsultation, BindingResult result, ModelMap model) throws Exception {
//		
//		if (!SIMSUtil.isUserSessionValid(model)) {
//			logger.info(SIMSConstant.USER_INVALID_SESSION);
//			return new ModelAndView("security/login", "userAccount", new UserAccount());	
//		}
//		
//		boolean transactStatus = false;
//		
//		Category med = medBo.findById(Integer.parseInt(medId));
//		
//		PatientMed modelMed = new PatientMed();
//		modelMed.setPatientConsultation(patientConsultationBo.findById(Integer.parseInt(consultId)));
//		modelMed.setMed(med);
//		modelMed.setQty(Integer.parseInt(qty));
//		modelMed.setPrice(med.getRetailSellingPrice());
//		double amount = modelMed.getQty() * med.getRetailSellingPrice().doubleValue();
//		modelMed.setAmount(new BigDecimal(amount));
//		modelMed.setCreatedBy(SIMSUtil.getUserIdFromSession(model));
//				
//		//need to udpate the bill record
//		if (patientMedBo.save(modelMed)) {
//			
//			//update to the latest model of consultation - to get the new added labexam
//			patientConsultation = patientConsultationBo.findById(Integer.parseInt(consultId));
//			
//			//compute total fees
//			PatientBill billModel = patientBillBo.getPatientBill(Integer.parseInt(consultId)); 
//			billModel.setTotalMedFee(patientConsultation.getTotalMedAmount());
//			double totalBill = billModel.getConsultFee().doubleValue() + billModel.getTotalMedFee().doubleValue() + patientConsultation.getTotalLabExamAmount().doubleValue();
//			billModel.setTotalBill(new BigDecimal(totalBill));
//			billModel.setDateProcessed(new java.sql.Timestamp(System.currentTimeMillis()));
//			billModel.setModifiedBy(SIMSUtil.getUserIdFromSession(model)); 
//			
//			transactStatus = patientBillBo.update(billModel);
//		}
//		
//		//get lab exam list
//		List<Brand> labExamList = new ArrayList<>();
//		model.addAttribute("labExamList", labExamList);
//		
//		//get med list
//		List<Category> medList = medBo.getAllEntity();
//		model.addAttribute("medList", medList);
//		
//		model.addAttribute("isUpdated", transactStatus);
//
//		PatientBill bill = patientBillBo.getPatientBill(Integer.parseInt(consultId));
//		
//		//consult fee and total Bill
//		model.addAttribute("consultFee", bill.getConsultFee());
//		model.addAttribute("totalBill", bill.getTotalBill());
//		
//		return new ModelAndView("transaction/patientconsultation/viewPatientConsultation", "patientConsultation", patientConsultation);
//	}	
//	
//	
//	@RequestMapping("/addNewLabExam")
//	public ModelAndView addNewLabExam(@RequestParam("consultId") String consultId, @RequestParam("labExamId") String labExamId,
//			@ModelAttribute("patientConsultation") PatientConsultation patientConsultation, BindingResult result, ModelMap model) throws Exception {
//		
//		if (!SIMSUtil.isUserSessionValid(model)) {
//			logger.info(SIMSConstant.USER_INVALID_SESSION);
//			return new ModelAndView("security/login", "userAccount", new UserAccount());	
//		}
//		
//		boolean transactStatus = false;
//		
//		Brand exam = labExamBo.findById(Integer.parseInt(labExamId));
//		
//		PatientLabExam modelLabExam = new PatientLabExam();
//		modelLabExam.setPatientConsultation(patientConsultationBo.findById(Integer.parseInt(consultId)));
//		modelLabExam.setLabExam(exam);
//		modelLabExam.setQty(1);//default to 1
//		modelLabExam.setFee(exam.getFee()!=null && exam.getFee().doubleValue() > 0 ? exam.getFee() : new BigDecimal(0));
//		double amount = exam.getFee()!=null && exam.getFee().doubleValue() > 0 ? modelLabExam.getQty() * exam.getFee().doubleValue() : 0.00D;
//		modelLabExam.setAmount(new BigDecimal(amount));
//		modelLabExam.setCreatedBy(SIMSUtil.getUserIdFromSession(model));
//				
//		//need to udpate the bill record
//		if (patientLabExamBo.save(modelLabExam)) {
//			
//			//update to the latest model of consultation - to get the new added labexam
//			patientConsultation = patientConsultationBo.findById(Integer.parseInt(consultId));
//			
//			//compute total fees
//			PatientBill billModel = patientBillBo.getPatientBill(Integer.parseInt(consultId)); 
//			billModel.setTotalLabExamFee(patientConsultation.getTotalLabExamAmount());
//			double totalBill = billModel.getConsultFee().doubleValue() + billModel.getTotalLabExamFee().doubleValue() + patientConsultation.getTotalMedAmount().doubleValue();
//			billModel.setTotalBill(new BigDecimal(totalBill));
//			billModel.setDateProcessed(new java.sql.Timestamp(System.currentTimeMillis()));
//			billModel.setModifiedBy(SIMSUtil.getUserIdFromSession(model)); 
//			
//			transactStatus = patientBillBo.update(billModel);
//		}
//		
//		//get lab exam list
//		List<Brand> labExamList = labExamBo.getAllEntity();
//		model.addAttribute("labExamList", labExamList);
//		
//		//get med list
//		List<Category> medList = medBo.getAllEntity();
//		model.addAttribute("medList", medList);
//		
//		model.addAttribute("isUpdated", transactStatus);
//	
//		PatientBill bill = patientBillBo.getPatientBill(Integer.parseInt(consultId));
//		
//		//consult fee and total Bill
//		model.addAttribute("consultFee", bill.getConsultFee());
//		model.addAttribute("totalBill", bill.getTotalBill());
//		
//		return new ModelAndView("transaction/patientconsultation/viewPatientConsultation", "patientConsultation", patientConsultation);
//	}	
//	
//	@RequestMapping("/deletePatientMed")
//	public ModelAndView deletePatientMed(@RequestParam("consultId") String consultId, @RequestParam("patientMedId") String patientMedId,
//			@ModelAttribute("patientConsultation") PatientConsultation patientConsultation, BindingResult result, ModelMap model) throws Exception {
//		
//		if (!SIMSUtil.isUserSessionValid(model)) {
//			logger.info(SIMSConstant.USER_INVALID_SESSION);
//			return new ModelAndView("security/login", "userAccount", new UserAccount());	
//		}
//		
//		boolean transactStatus = false;
//		
//		PatientMed pMed = patientMedBo.findById(Integer.parseInt(patientMedId));
//		pMed.setModifiedBy(SIMSUtil.getUserIdFromSession(model));
//		
//		if (patientMedBo.delete(pMed)) {
//
//			//need to udpate the bill record
//			//update to the latest model of lab request - to get the new added labexam
//			patientConsultation = patientConsultationBo.findById(Integer.parseInt(consultId));
//			
//			//compute total fees
//			PatientBill billModel = patientBillBo.getPatientBill(Integer.parseInt(consultId)); 
//			billModel.setTotalMedFee(patientConsultation.getTotalMedAmount());
//			double totalBill = billModel.getConsultFee().doubleValue() + billModel.getTotalMedFee().doubleValue() + patientConsultation.getTotalLabExamAmount().doubleValue();
//			billModel.setTotalBill(new BigDecimal(totalBill));
//			billModel.setDateProcessed(new java.sql.Timestamp(System.currentTimeMillis()));
//			billModel.setModifiedBy(SIMSUtil.getUserIdFromSession(model));
//			
//			transactStatus = patientBillBo.update(billModel);
//		}
//		
//		//get lab exam list - no need
//		List<Brand> labExamList = new ArrayList<>();
//		model.addAttribute("labExamList", labExamList);
//		
//		//get med list
//		List<Category> medList = medBo.getAllEntity();
//		model.addAttribute("medList", medList);
//		
//		model.addAttribute("isUpdated", transactStatus);
//	
//		PatientBill bill = patientBillBo.getPatientBill(Integer.parseInt(consultId));
//		
//		//consult fee and total Bill
//		model.addAttribute("consultFee", bill.getConsultFee());
//		model.addAttribute("totalBill", bill.getTotalBill());
//		
//		return new ModelAndView("transaction/patientconsultation/viewPatientConsultation", "patientConsultation", patientConsultation);
//	}
//
//	@RequestMapping("/deletePatientLabExam")
//	public ModelAndView deletePatientLabExam(@RequestParam("consultId") String consultId, @RequestParam("patientLabExamId") String patientLabExamId,
//			@ModelAttribute("patientConsultation") PatientConsultation patientConsultation, BindingResult result, ModelMap model) throws Exception {
//		
//		if (!SIMSUtil.isUserSessionValid(model)) {
//			logger.info(SIMSConstant.USER_INVALID_SESSION);
//			return new ModelAndView("security/login", "userAccount", new UserAccount());	
//		}
//		
//		boolean transactStatus = false;
//		
//		PatientLabExam pLabExam = patientLabExamBo.findById(Integer.parseInt(patientLabExamId));
//		pLabExam.setModifiedBy(SIMSUtil.getUserIdFromSession(model));
//		
//		if (patientLabExamBo.delete(pLabExam)) {
//
//			//need to udpate the bill record
//			//update to the latest model of lab request - to get the new added labexam
//			patientConsultation = patientConsultationBo.findById(Integer.parseInt(consultId));
//			
//			//compute total fees
//			PatientBill billModel = patientBillBo.getPatientBill(Integer.parseInt(consultId)); 
//			billModel.setTotalLabExamFee(patientConsultation.getTotalLabExamAmount());
//			double totalBill = billModel.getConsultFee().doubleValue() + billModel.getTotalLabExamFee().doubleValue() + patientConsultation.getTotalMedAmount().doubleValue();
//			billModel.setTotalBill(new BigDecimal(totalBill));
//			billModel.setDateProcessed(new java.sql.Timestamp(System.currentTimeMillis()));
//			billModel.setModifiedBy(SIMSUtil.getUserIdFromSession(model));
//			
//			transactStatus = patientBillBo.update(billModel);
//		}
//		
//		//get lab exam list
//		List<Brand> labExamList = labExamBo.getAllEntity();
//		model.addAttribute("labExamList", labExamList);
//		
//		//get med list
//		List<Category> medList = medBo.getAllEntity();
//		model.addAttribute("medList", medList);
//		
//		model.addAttribute("isUpdated", transactStatus);
//	
//		PatientBill bill = patientBillBo.getPatientBill(Integer.parseInt(consultId));
//		
//		//consult fee and total Bill
//		model.addAttribute("consultFee", bill.getConsultFee());
//		model.addAttribute("totalBill", bill.getTotalBill());
//		
//		return new ModelAndView("transaction/patientconsultation/viewPatientConsultation", "patientConsultation", patientConsultation);
//	}
//
//	@RequestMapping("/goToPayNow")
//	public ModelAndView goToPayNow(@RequestParam("consultId") String consultId, @ModelAttribute("patientConsultation") PatientConsultation patientConsultation,
//    			BindingResult result, ModelMap model) throws Exception {
//		
//		if (!SIMSUtil.isUserSessionValid(model)) {
//			logger.info(SIMSConstant.USER_INVALID_SESSION);
//			return new ModelAndView("security/login", "userAccount", new UserAccount());	
//		}
//		
//		boolean transactStatus = false;
//		
//		//Create Payment record in PaymentBillPayment table
//		PatientBill billModel = patientBillBo.getPatientBill(Integer.parseInt(consultId)); 
//		PatientBillPayment payment = new PatientBillPayment();
//		payment.setPatientBill(billModel);
//		payment.setAmount(billModel.getTotalBill());//Default to TotalBill
//		payment.setModeOfPayment(401);//Default to Cash
//		payment.setCreatedBy(SIMSUtil.getUserIdFromSession(model));
//			
//		if (patientBillPaymentBo.save(payment)) {
//			//update the Patient Bill cleared to true
//			PatientBill bill = payment.getPatientBill();
//			bill.setCleared(true);
//			bill.setModifiedBy(SIMSUtil.getUserIdFromSession(model));
//			if (patientBillBo.update(bill)) {
//				//Update payment status in Patient Consultation table
//				patientConsultation = patientConsultationBo.findById(Integer.parseInt(consultId));
//				patientConsultation.setPaymentStatus(new ListValue(302));//Paid
//				patientConsultation.setModifiedBy(SIMSUtil.getUserIdFromSession(model));
//				transactStatus = patientConsultationBo.update(patientConsultation);
//			}
//		}
//		
//		//update to the latest model of consultation
//		patientConsultation = patientConsultationBo.findById(Integer.parseInt(consultId));
//		
//		List<Brand> labExamList = new ArrayList<>(); //pass blank list after payment
//		model.addAttribute("labExamList", labExamList);
//		
//		//get med list
//		List<Category> medList = new ArrayList<>(); //pass blank list after payment
//		model.addAttribute("medList", medList);
//		
//		model.addAttribute("isUpdated", transactStatus);
//	
//		PatientBill bill = patientBillBo.getPatientBill(Integer.parseInt(consultId));
//		
//		//consult fee and total Bill
//		model.addAttribute("consultFee", bill.getConsultFee());
//		model.addAttribute("totalBill", bill.getTotalBill());
//		
//		return new ModelAndView("transaction/patientconsultation/viewPatientConsultation", "patientConsultation", patientConsultation);
//	}
//
//	
//	 @RequestMapping("/viewPrescriptionReport")
//	 public void viewPrescriptionReport(@RequestParam("consultId") String consultId, HttpServletResponse response) throws Exception {
//		
//		PatientConsultation	patientConsultation = patientConsultationBo.findById(Integer.parseInt(consultId));//get the latest updated
//
//		//generate the report
//		String localPath = context.getRealPath("/") + File.separator + "reports";
//		Path path = Paths.get(SIMSConstant.PDF_REPORT_ORIG_PATH);
//		if (!Files.exists(path)) {
//			Files.createDirectories(path);
//		}
//		String destFile = path + File.separator + SIMSConstant.PDF_PRESCRIPTION_REPORT + patientConsultation.getConsultNo() + ".pdf";
//		File reportFile = new File(localPath + File.separator + SIMSConstant.RPT_PRESCRIPTION_JASPER);
//				
//		boolean isReportGenerated = ReportUtils.generatePrescriptionReport(SIMSConstant.RPT_PRESCRIPTION_TITLE, destFile, reportFile, patientConsultation);
//		if (isReportGenerated) {
//			System.out.println("Report generated..");
//						
//			File pdfFile = new File(destFile.toString());
//			 
//			try {
//			     OutputStream os = response.getOutputStream();
//			     byte[] buf = new byte[8192];
//			     InputStream is = new FileInputStream(pdfFile);
//			     int c = 0;
//			     while ((c = is.read(buf, 0, buf.length)) > 0) {
//			        os.write(buf, 0, c);
//			        os.flush();
//			     }
//			     os.close();
//			     is.close();
//			 } catch (IOException e) {
//			     e.printStackTrace();
//			 }
//			
//		}
//		 
//
//	  }
//
//}
