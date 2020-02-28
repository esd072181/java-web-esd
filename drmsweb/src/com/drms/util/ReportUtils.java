package com.drms.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.drms.constant.DRMSConstant;
import com.drms.model.PatientConsultation;

import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

public class ReportUtils {
	
	/**
	 * Creates a pdf file in the server, then the client browser will show the report in a new tab
	 * @param jasperReport
	 * @param parameters
	 * @param ds
	 * @param reportTitle
	 * @param localPath
	 * @return
	 * @throws Exception
	 */
	private static boolean generatePDFViaJasperReportsEngine(JasperReport jasperReport, Map<String, Object> parameters, JRBeanCollectionDataSource ds, String reportTitle, String destFile) throws Exception{
		boolean isReportGenerated = false;
		
		JasperPrint jasperPrint = null;
			
		try {		 
			// fills compiled report with parameters and a connection
			jasperPrint = JasperFillManager.fillReport (jasperReport, parameters, ds);

			//create pdf file
			JasperExportManager.exportReportToPdfFile(jasperPrint,destFile);
			 
			isReportGenerated = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jasperPrint!=null) {
				jasperPrint = null;	
			}
		}

		return isReportGenerated;
	}
		
	/**
	 * 
	 * @param reportTitle
	 * @param destFile
	 * @param reportFile
	 * @param dataList
	 * @param parameters
	 * @return
	 * @throws Exception
	 */
	public static boolean generateReport(String reportTitle, String destFile, File reportFile, List<Object> dataList, Map<String, Object> parameters) throws Exception{
						
		boolean isReportGenerated = false;
	
		if (!reportFile.exists()) {
			System.out.println("Destination File:" + destFile);
			System.out.println("Report File:" + reportFile);
			throw new JRRuntimeException(reportFile.toString() + " not found!");
		}
		
		JasperReport jasperReport = null;
		JRBeanCollectionDataSource  ds = null;
		
		try {
			//load the report
			jasperReport = (JasperReport) JRLoader.loadObject(reportFile);
			//load the data
			ds = new JRBeanCollectionDataSource(dataList);
			//generate the report
			isReportGenerated = ReportUtils.generatePDFViaJasperReportsEngine(jasperReport, parameters, ds, reportTitle, destFile);
		
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if (reportFile!=null) {
				reportFile = null;
			}
			if (jasperReport!=null) {
				jasperReport = null;
			}
			if (ds!=null) {
				ds = null;
			}
		}

		return isReportGenerated;
	}
	
	/**
	 * 
	 * @param title
	 * @param reportFile
	 * @param destFile
	 * @param patientLabRequest
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public static boolean generatePrescriptionReport(String title, String reportFile, File destFile, PatientConsultation patientConsultation) throws Exception{
		
	    Map<String, Object> paramMap = new HashMap<>();
		
	    //Header
	    paramMap.put("LabName", DRMSConstant.CLINIC_NAME);
	    paramMap.put("LabAddress", DRMSConstant.CLINIC_ADDRESS);
	    paramMap.put("LabTelNo", DRMSConstant.CLINIC_TEL_NO);
	    paramMap.put("ConsultNo", patientConsultation.getConsultNo());
	    paramMap.put("PatientName", patientConsultation.getPatient().getFullName());
	    paramMap.put("Sex", patientConsultation.getPatient().getGender());
	    paramMap.put("Age", String.valueOf(patientConsultation.getAge()));
	    paramMap.put("Date", DateUtils.sqlDateToString(patientConsultation.getConsultDate()));
	    paramMap.put("Physician", patientConsultation.getProfessional().getFullName());
	    paramMap.put("MedStatement", patientConsultation.getMedicationStatement());
	    paramMap.put("NextConsultationDate", patientConsultation.getNextConsultDate()!=null ? DateUtils.sqlDateToString(patientConsultation.getNextConsultDate()) : "");

	    //Details
	    List<Object> list = new ArrayList<>();
	    list.add(new Object());

		return generateReport(title, reportFile, destFile, list, paramMap);
	}
	
	
	
}
