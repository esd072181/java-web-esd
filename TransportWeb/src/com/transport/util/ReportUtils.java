package com.transport.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFeatures;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.transport.constant.MapConstant;
import com.transport.constant.MiscConstant;
import com.transport.model.MaintenanceMonitoring;
import com.transport.model.MaintenanceMonitoringFleet;
import com.transport.model.MaintenanceMonitoringPreventive;
import com.transport.model.MaintenanceMonitoringPreventiveTotal;
import com.transport.model.MaintenanceMonitoringTotalPending;
import com.transport.model.VerificationAndValidation;

import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

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
	 *  Uses Viewer and will show only in the Server
	 * @param jasperReport
	 * @param parameters
	 * @param ds
	 * @param reportTitle
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	private static boolean generateViaJasperReportsEngine(JasperReport jasperReport, Map<String, Object> parameters, JRBeanCollectionDataSource ds, String reportTitle) throws Exception{
		boolean isReportGenerated = false;
		
		JasperPrint jasperPrint = null;
		
		try {
			 //fill the report
			 jasperPrint = JasperFillManager.fillReport (jasperReport, parameters, ds);
			 //allow export to pdf
			 JasperExportManager.exportReportToPdf(jasperPrint);
			 //show the report via viewer
			 JasperViewer jViewer = new JasperViewer(jasperPrint, false);
			 jViewer.setTitle(reportTitle);
			 jViewer.setVisible(true);	
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
	 *  Verification and Validation Compliance Tracker Report
	 * 
	 * @param dataList
	 * @param parameters
	 * @param localPath
	 * @return
	 * @throws Exception
	 */
	public static boolean generateVerificationReport (List<VerificationAndValidation> dataList, Map<String, Object> parameters, String localPath) throws Exception{
				
		String reportTitle = MiscConstant.RPT_VERIFICATION_AND_VALIDATION_TITLE;
		boolean isReportGenerated = false;
		
		String destFile = localPath + File.separator + MiscConstant.PDF_VERIFICATION_AND_VALIDATION_REPORT;
		File reportFile = new File(localPath + File.separator + MiscConstant.RPT_VERIFICATION_AND_VALIDATION_REPORT);


		if (!reportFile.exists()) {
			System.out.println("Destination File:" + destFile);
			System.out.println("Report File:" + reportFile);
			throw new JRRuntimeException(MiscConstant.RPT_VERIFICATION_AND_VALIDATION_REPORT + " not found!");
		}
		
		JasperReport jasperReport = null;
		JRBeanCollectionDataSource  ds = null;
		
		try {
			//load the report
			jasperReport = (JasperReport) JRLoader.loadObject(reportFile);
			//load the data
			ds = new JRBeanCollectionDataSource(dataList);
			//generate and view the report	
			isReportGenerated = ReportUtils.generatePDFViaJasperReportsEngine(jasperReport, parameters, ds, reportTitle, destFile);
		
			generateXLS(dataList, localPath); //Transport Revision 1 31Jan2016
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
	 * Generic generateReport()
	 * @param dataList
	 * @param parameters
	 * @param localPath
	 * @return
	 * @throws Exception
	 */
	public static boolean generateReport (List<Object> dataList, Map<String, Object> dataMap, Map<String, Object> parameters, String localPath) throws Exception{
		
		String reportTitle = (String) dataMap.get(MapConstant.RPT_TITLE);
		boolean isReportGenerated = false;
		
		String destFile = null;

		//check for driver training summary report
		Object driverName = parameters.get("DriverName"); 
		if (driverName!=null) {
			String driverFileName = ((String) driverName).replace(", ", "_");
			destFile = localPath + File.separator + driverFileName + "_" + (String) dataMap.get(MapConstant.RPT_PDF);
		} else {
			destFile = localPath + File.separator + (String) dataMap.get(MapConstant.RPT_PDF);
		}
		
		File reportFile = new File(localPath + File.separator + (String) dataMap.get(MapConstant.RPT_JASPER));

		if (!reportFile.exists()) {
			System.out.println("Destination File:" + destFile);
			System.out.println("Report File:" + reportFile);
			throw new JRRuntimeException(reportFile + " not found!");
		}

		JasperReport jasperReport = null;
		JRBeanCollectionDataSource  ds = null;
		
		try {
			//load the report
			jasperReport = (JasperReport) JRLoader.loadObject(reportFile);
			//load the data
			ds = new JRBeanCollectionDataSource(dataList);
			//generate and view the report	
			isReportGenerated = ReportUtils.generatePDFViaJasperReportsEngine(jasperReport, parameters, ds, reportTitle, destFile);
		
//			generateXLS(dataList, localPath);
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
	 *  Export report to excel file
	 *  (Transport Revision 1)
	 * 
	 * @throws Exception
	 */
	private static void generateXLS(List<VerificationAndValidation> dataList, String localPath) throws Exception {
		
        //Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook(); 
         
        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("VandV_Data");
          
        //insert the column header first
        Row rowHeader = sheet.createRow(0);
        int cellHeaderNum = 0;
        Cell cellHeader = rowHeader.createCell(cellHeaderNum++);
        cellHeader.setCellValue("ITEM");
        cellHeader = rowHeader.createCell(cellHeaderNum++);
        cellHeader.setCellValue("FINDINGS");
        cellHeader = rowHeader.createCell(cellHeaderNum++);
        cellHeader.setCellValue("DRIVER");
        cellHeader = rowHeader.createCell(cellHeaderNum++);
        cellHeader.setCellValue("TERMINAL");
        cellHeader = rowHeader.createCell(cellHeaderNum++);
        cellHeader.setCellValue("LORRY");
        cellHeader = rowHeader.createCell(cellHeaderNum++);
        cellHeader.setCellValue("TRAILER");
        cellHeader = rowHeader.createCell(cellHeaderNum++);
        cellHeader.setCellValue("VERIFICATION DATE");
        cellHeader = rowHeader.createCell(cellHeaderNum++);
        cellHeader.setCellValue("ROOT CAUSE");
        cellHeader = rowHeader.createCell(cellHeaderNum++);
        cellHeader.setCellValue("CORRECTIVE ACTIONS");
        cellHeader = rowHeader.createCell(cellHeaderNum++);
        cellHeader.setCellValue("VERIFIED BY");
        cellHeader = rowHeader.createCell(cellHeaderNum++);
        cellHeader.setCellValue("CLOSURE ON CORRECTIVE ACTIONS");
        cellHeader = rowHeader.createCell(cellHeaderNum++);
        cellHeader.setCellValue("CLOSURE DATE");
        cellHeader = rowHeader.createCell(cellHeaderNum++);
        cellHeader.setCellValue("CHECKED BY");
        cellHeader = rowHeader.createCell(cellHeaderNum++);
        cellHeader.setCellValue("STATUS");
        
        //insert the data
        int rownum = 1;
        for (int i=0; i<dataList.size();i++) {
        	Row row = sheet.createRow(rownum++);
        	VerificationAndValidation rowData = dataList.get(i);
        	int cellnum = 0;
            Cell cell = row.createCell(cellnum++);
            cell.setCellValue(rowData.getItem());
            cell = row.createCell(cellnum++);
            cell.setCellValue(rowData.getFindings());
            cell = row.createCell(cellnum++);
            cell.setCellValue(rowData.getDriver()); 
            cell = row.createCell(cellnum++);
            cell.setCellValue(rowData.getTerminal()); 
            cell = row.createCell(cellnum++);
            cell.setCellValue(rowData.getLorry()); 
            cell = row.createCell(cellnum++);
            cell.setCellValue(rowData.getTrailer()); 
            cell = row.createCell(cellnum++);
            cell.setCellValue(rowData.getVerificationDateStr()); 
            cell = row.createCell(cellnum++);
            cell.setCellValue(rowData.getRootCause()); 
            cell = row.createCell(cellnum++);
            cell.setCellValue(rowData.getCorrections());
            cell = row.createCell(cellnum++);
            cell.setCellValue(rowData.getVerificationCheckedBy()); 
            cell = row.createCell(cellnum++);
            cell.setCellValue(rowData.getClosure()); 
            cell = row.createCell(cellnum++);
            cell.setCellValue(rowData.getValidationDateStr());
            cell = row.createCell(cellnum++);
            cell.setCellValue(rowData.getValidationCheckedBy());
            cell = row.createCell(cellnum++);
            cell.setCellValue(rowData.getRemarks()); 
        }
        
        try
        {
            //Write the workbook in file system
        	String xlsFile = localPath + File.separator + MiscConstant.XLS_VERIFICATION_AND_VALIDATION_REPORT;
            FileOutputStream out = new FileOutputStream(new File(xlsFile)); 
            workbook.write(out);
            out.close();
            System.out.println("verification.xlsx written successfully on disk.");
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
	
	/**
	 * 
	 * @param dataMap
	 * @param localPath
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static boolean generateMaintenanceMonitoringExcelFile(HashMap<String, Object> dataMap, String localPath) {

		boolean isFileGenerated = false;
		
		//retrieve the data
		String month = TransportUtils.getStrMonth(Integer.valueOf((String)dataMap.get(MapConstant.MONTH_CRITERIA)));
		String year = (String) dataMap.get(MapConstant.YEAR_CRITERIA);
		List<MaintenanceMonitoring> qryList =  (List<MaintenanceMonitoring>) dataMap.get(MapConstant.CLASS_LIST);
		List<MaintenanceMonitoringFleet> qryListShellFleet =  (List<MaintenanceMonitoringFleet>) dataMap.get(MapConstant.CLASS_LIST_2);
		List<MaintenanceMonitoringFleet> qryListCaltexFleet =  (List<MaintenanceMonitoringFleet>) dataMap.get(MapConstant.CLASS_LIST_3);
		List<MaintenanceMonitoringFleet> qryListGrandTotalFleet =  (List<MaintenanceMonitoringFleet>) dataMap.get(MapConstant.CLASS_LIST_4);
		List<MaintenanceMonitoringPreventive> modelListPreventive =  (List<MaintenanceMonitoringPreventive>) dataMap.get(MapConstant.CLASS_LIST_5);
		List<MaintenanceMonitoringPreventiveTotal> modelListPreventiveTotal =  (List<MaintenanceMonitoringPreventiveTotal>) dataMap.get(MapConstant.CLASS_LIST_6);
		List<MaintenanceMonitoringTotalPending> modelListTotalPending =  (List<MaintenanceMonitoringTotalPending>) dataMap.get(MapConstant.CLASS_LIST_7);
		
		Map<Integer, Integer> totalPendingMap = new HashMap<>();

        //1. Create an Excel file
       WritableWorkbook workBook = null;
       
       String excelFile = localPath + File.separator + "maintenancemonitoring.xls";   

       try {

           workBook = Workbook.createWorkbook(new File(excelFile));
           // create an Excel sheet
           WritableSheet excelSheet = workBook.createSheet(month+year, 0);

           int columnNo = 0;
           int widthInChars = 20;
           excelSheet.setColumnView(columnNo, widthInChars); //column width

           //Cell Format
           WritableFont cellFont = new WritableFont(WritableFont.ARIAL, 11);
           cellFont.setBoldStyle(WritableFont.BOLD);
           WritableCellFormat wcf = new WritableCellFormat(cellFont);
           wcf.setAlignment(Alignment.LEFT);

           // add something into the Excel sheet
           Label label = new Label(0, 0, "Maintenance Monitoring", wcf);
           excelSheet.addCell(label);

           label = new Label(0, 1, month + " " + year, wcf);
           excelSheet.addCell(label);

           //default border
           WritableCellFormat wcfBorder = new WritableCellFormat();
           wcfBorder.setAlignment(Alignment.CENTRE);
           wcfBorder.setBorder(Border.ALL, BorderLineStyle.THIN);
           
           //Merge col[0-3] and row[2]
           excelSheet.mergeCells(0, 2, 3, 2);
           label = new Label(0, 2, "Day", wcfBorder);
           excelSheet.addCell(label);

           //Background Orange for GPS Trips Per Week, Availability and Percentage Columns
	       WritableCellFormat wcfOrange = new WritableCellFormat();
	       wcfOrange.setBackground(Colour.ORANGE); //Note: Dark Orange in JSP
	       wcfOrange.setAlignment(Alignment.CENTRE);
	       wcfOrange.setBorder(Border.ALL, BorderLineStyle.THIN);
	       
	       WritableCellFormat wcfRed = new WritableCellFormat();
	       wcfRed.setBackground(Colour.RED);
	       wcfRed.setAlignment(Alignment.CENTRE);
	       wcfRed.setBorder(Border.ALL, BorderLineStyle.THIN);
	       
	       WritableCellFormat wcfCyan = new WritableCellFormat();
	       wcfCyan.setBackground(Colour.TURQUOISE);
	       wcfCyan.setAlignment(Alignment.CENTRE);
	       wcfCyan.setBorder(Border.ALL, BorderLineStyle.THIN);

	       WritableCellFormat wcfGray = new WritableCellFormat();
	       wcfGray.setBackground(Colour.GRAY_25);
	       wcfGray.setAlignment(Alignment.CENTRE);
	       wcfGray.setBorder(Border.ALL, BorderLineStyle.THIN);
	       
	       WritableFont arialWhite = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);
	       arialWhite.setColour(jxl.format.Colour.WHITE);
	       WritableCellFormat wcfBlack = new WritableCellFormat(arialWhite);
	       wcfBlack.setBackground(Colour.DEFAULT_BACKGROUND); //for BLACK - Colour.Black not working
	       wcfBlack.setAlignment(Alignment.CENTRE);
	       wcfBlack.setBorder(Border.ALL, BorderLineStyle.THIN);
	       
	       WritableCellFormat wcfDarkGreen = new WritableCellFormat(arialWhite);
	       wcfDarkGreen.setBackground(Colour.DARK_GREEN);
	       wcfDarkGreen.setAlignment(Alignment.CENTRE);
	       wcfDarkGreen.setBorder(Border.ALL, BorderLineStyle.THIN);
	       
	       WritableCellFormat wcfLimeGreen = new WritableCellFormat();
	       wcfLimeGreen.setBackground(Colour.BRIGHT_GREEN);//Lime Green in JSP
	       wcfLimeGreen.setAlignment(Alignment.CENTRE);
	       wcfLimeGreen.setBorder(Border.ALL, BorderLineStyle.THIN);
	       
	       WritableCellFormat wcfViolet = new WritableCellFormat();
	       wcfViolet.setBackground(Colour.VIOLET);
	       wcfViolet.setAlignment(Alignment.CENTRE);
	       wcfViolet.setBorder(Border.ALL, BorderLineStyle.THIN);
	       
	       WritableCellFormat wcfYellow = new WritableCellFormat();
	       wcfYellow.setBackground(Colour.YELLOW);
	       wcfYellow.setAlignment(Alignment.CENTRE);
	       wcfYellow.setBorder(Border.ALL, BorderLineStyle.THIN);
	       
	       //For Committed Volume Row
	       WritableFont arialRed = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);
	       arialRed.setColour(jxl.format.Colour.RED);
	       WritableCellFormat wcfCv = new WritableCellFormat(arialRed);
	       wcfCv.setBackground(Colour.LIGHT_GREEN);
	       wcfCv.setAlignment(Alignment.CENTRE);
	       wcfCv.setBorder(Border.ALL, BorderLineStyle.THIN);
	       
	       WritableCellFormat wcfCv2 = new WritableCellFormat();
	       wcfCv2.setBackground(Colour.LIGHT_GREEN);
	       wcfCv2.setAlignment(Alignment.CENTRE);
	       wcfCv2.setBorder(Border.ALL, BorderLineStyle.THIN);
	       
           setDays(excelSheet, wcfBorder, wcfRed, wcfCyan, wcfGray, wcfDarkGreen, wcfBlack, wcfViolet, wcfOrange, wcfYellow);
           setHeaders(excelSheet, wcfBorder, wcfRed, wcfCyan, wcfGray, wcfDarkGreen, wcfBlack, wcfViolet, wcfOrange, wcfYellow);

           WritableFont cf = new WritableFont(WritableFont.ARIAL, 11);
           cf.setBoldStyle(WritableFont.BOLD);
           WritableCellFormat wcf2 = new WritableCellFormat(cf);
           wcf2.setAlignment(Alignment.CENTRE);
           wcf2.setBorder(Border.ALL, BorderLineStyle.THIN);
           
           //fill in the data
           WritableCellFormat wcf3 = null;
           WritableCellFeatures cellFeatures2 = null;
           int i = 0;
           int y = 0;
           int z = 0;
           int sumTrip1 = 0;
           int sumTrip2 = 0;
           int sumTrip3 = 0;
           int sumTrip4 = 0;
           int sumTrip5 = 0;
           int sumTrip6 = 0;
           int sumTrip7 = 0;
           int sumTrip8 = 0;
           int sumTrip9 = 0;
           int sumTrip10 = 0;
           int sumTrip11 = 0;
           int sumTrip12 = 0;
           int sumTrip13 = 0;
           int sumTrip14 = 0;
           int sumTrip15 = 0;
           int sumTrip16 = 0;
           int sumTrip17 = 0;
           int sumTrip18 = 0;
           int sumTrip19 = 0;
           int sumTrip20 = 0;
           int sumTrip21 = 0;
           int sumTrip22 = 0;
           int sumTrip23 = 0;
           int sumTrip24 = 0;
           int sumTrip25 = 0;
           int sumTrip26 = 0;
           int sumTrip27 = 0;
           int sumTrip28 = 0;
           int sumTrip29 = 0;
           int sumTrip30 = 0;
           int sumTrip31 = 0;
           int sumMaintenance1 = 0;
           int sumMaintenance2 = 0;
           int sumMaintenance3 = 0;
           int sumMaintenance4 = 0;
           int sumMaintenance5 = 0;
           int sumMaintenance6 = 0;
           int sumMaintenance7 = 0;
           int sumMaintenance8 = 0;
           int sumMaintenance9 = 0;
           int sumMaintenance10 = 0;
           int sumMaintenance11 = 0;
           int sumMaintenance12 = 0;
           int sumMaintenance13 = 0;
           int sumMaintenance14 = 0;
           int sumMaintenance15 = 0;
           int sumMaintenance16 = 0;
           int sumMaintenance17 = 0;
           int sumMaintenance18 = 0;
           int sumMaintenance19 = 0;
           int sumMaintenance20 = 0;
           int sumMaintenance21 = 0;
           int sumMaintenance22 = 0;
           int sumMaintenance23 = 0;
           int sumMaintenance24 = 0;
           int sumMaintenance25 = 0;
           int sumMaintenance26 = 0;
           int sumMaintenance27 = 0;
           int sumMaintenance28 = 0;
           int sumMaintenance29 = 0;
           int sumMaintenance30 = 0;
           int sumMaintenance31 = 0;
           int sumVol1 = 0;
           int sumVol2 = 0;
           int sumVol3 = 0;
           int sumVol4 = 0;
           int sumVol5 = 0;
           int sumVol6 = 0;
           int sumVol7 = 0;
           int sumVol8 = 0;
           int sumVol9 = 0;
           int sumVol10 = 0;
           int sumVol11 = 0;
           int sumVol12 = 0;
           int sumVol13 = 0;
           int sumVol14 = 0;
           int sumVol15 = 0;
           int sumVol16 = 0;
           int sumVol17 = 0;
           int sumVol18 = 0;
           int sumVol19 = 0;
           int sumVol20 = 0;
           int sumVol21 = 0;
           int sumVol22 = 0;
           int sumVol23 = 0;
           int sumVol24 = 0;
           int sumVol25 = 0;
           int sumVol26 = 0;
           int sumVol27 = 0;
           int sumVol28 = 0;
           int sumVol29 = 0;
           int sumVol30 = 0;
           int sumVol31 = 0;
           int sumVolWeek1 = 0;
           int sumVolWeek2 = 0;
           int sumVolWeek3 = 0;
           int sumVolWeek4 = 0;
           int sumVolWeek5 = 0;
           int totalLorryCountPerCategory = 0;
           int grandTotalPending1 = 0;
           int grandTotalPending2 = 0;
           int grandTotalPending3 = 0;
           int grandTotalPending4 = 0;
           int grandTotalPending5 = 0;
           int grandTotalPending6 = 0;
           int grandTotalPending7 = 0;
           int grandTotalPending8 = 0;
           int grandTotalPending9 = 0;
           int grandTotalPending10 = 0;
           int grandTotalPending11 = 0;
           int grandTotalPending12 = 0;
           int grandTotalPending13 = 0;
           int grandTotalPending14 = 0;
           int grandTotalPending15 = 0;
           int grandTotalPending16 = 0;
           int grandTotalPending17 = 0;
           int grandTotalPending18 = 0;
           int grandTotalPending19 = 0;
           int grandTotalPending20 = 0;
           int grandTotalPending21 = 0;
           int grandTotalPending22 = 0;
           int grandTotalPending23 = 0;
           int grandTotalPending24 = 0;
           int grandTotalPending25 = 0;
           int grandTotalPending26 = 0;
           int grandTotalPending27 = 0;
           int grandTotalPending28 = 0;
           int grandTotalPending29 = 0;
           int grandTotalPending30 = 0;
           int grandTotalPending31 = 0;
           int committedVolume = 0;
           int capacityOfTerminal = 0;
           String category = "";
           String gpsRemarks = null;
           String maintenanceRemarks = null;
           //First loop for Shell: trasportId = 601
           for(MaintenanceMonitoring item : qryList) {
        	   if (item.getTransportId() == 601) {
                   if (!category.equalsIgnoreCase(item.getCategory())) {
                	   if (!category.equals("")) {
                		   //Total Available and Percentage Rows Per Category
                		   excelSheet.mergeCells(0, i+4, 3, i+4);
                           label = new Label(0, i+4, "Total Available " + category + " in Maintenance", wcf2);
                           excelSheet.addCell(label);
                           label = new Label(4, i+4, String.valueOf(sumTrip1), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(5, i+4, String.valueOf(sumMaintenance1) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(6, i+4, String.valueOf(sumVol1), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(7, i+4, String.valueOf(sumTrip2), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(8, i+4, String.valueOf(sumMaintenance2) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(9, i+4, String.valueOf(sumVol2), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(10, i+4, String.valueOf(sumTrip3), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(11, i+4, String.valueOf(sumMaintenance3) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(12, i+4, String.valueOf(sumVol3), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(13, i+4, String.valueOf(sumTrip4), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(14, i+4, String.valueOf(sumMaintenance4) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(15, i+4, String.valueOf(sumVol4), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(16, i+4, String.valueOf(sumTrip5), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(17, i+4, String.valueOf(sumMaintenance5) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(18, i+4, String.valueOf(sumVol5), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(19, i+4, String.valueOf(sumTrip6), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(20, i+4, String.valueOf(sumMaintenance6) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(21, i+4, String.valueOf(sumVol6), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(22, i+4, String.valueOf(sumTrip7), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(23, i+4, String.valueOf(sumMaintenance7) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(24, i+4, String.valueOf(sumVol7), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(25, i+4, "", wcfOrange);
                           excelSheet.addCell(label);
                           label = new Label(26, i+4, String.valueOf(sumVolWeek1), wcfYellow);
                           excelSheet.addCell(label);
                           label = new Label(27, i+4, "", wcfOrange);
                           excelSheet.addCell(label);
                           label = new Label(28, i+4, "", wcfOrange);
                           excelSheet.addCell(label);
                           label = new Label(29, i+4, String.valueOf(sumTrip8), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(30, i+4, String.valueOf(sumMaintenance8) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(31, i+4, String.valueOf(sumVol8), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(32, i+4, String.valueOf(sumTrip9), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(33, i+4, String.valueOf(sumMaintenance9) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(34, i+4, String.valueOf(sumVol9), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(35, i+4, String.valueOf(sumTrip10), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(36, i+4, String.valueOf(sumMaintenance10) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(37, i+4, String.valueOf(sumVol10), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(38, i+4, String.valueOf(sumTrip11), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(39, i+4, String.valueOf(sumMaintenance11) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(40, i+4, String.valueOf(sumVol11), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(41, i+4, String.valueOf(sumTrip12), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(42, i+4, String.valueOf(sumMaintenance12) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(43, i+4, String.valueOf(sumVol12), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(44, i+4, String.valueOf(sumTrip13), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(45, i+4, String.valueOf(sumMaintenance13) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(46, i+4, String.valueOf(sumVol13), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(47, i+4, String.valueOf(sumTrip14), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(48, i+4, String.valueOf(sumMaintenance14) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(49, i+4, String.valueOf(sumVol14), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(50, i+4, "", wcfOrange);
                           excelSheet.addCell(label);
                           label = new Label(51, i+4, String.valueOf(sumVolWeek2), wcfYellow);
                           excelSheet.addCell(label);
                           label = new Label(52, i+4, "", wcfOrange);
                           excelSheet.addCell(label);
                           label = new Label(53, i+4, "", wcfOrange);
                           excelSheet.addCell(label);
                           label = new Label(54, i+4, String.valueOf(sumTrip15), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(55, i+4, String.valueOf(sumMaintenance15) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(56, i+4, String.valueOf(sumVol15), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(57, i+4, String.valueOf(sumTrip16), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(58, i+4, String.valueOf(sumMaintenance16) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(59, i+4, String.valueOf(sumVol16), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(60, i+4, String.valueOf(sumTrip17), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(61, i+4, String.valueOf(sumMaintenance17) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(62, i+4, String.valueOf(sumVol17), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(63, i+4, String.valueOf(sumTrip18), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(64, i+4, String.valueOf(sumMaintenance18) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(65, i+4, String.valueOf(sumVol18), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(66, i+4, String.valueOf(sumTrip19), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(67, i+4, String.valueOf(sumMaintenance19) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(68, i+4, String.valueOf(sumVol19), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(69, i+4, String.valueOf(sumTrip20), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(70, i+4, String.valueOf(sumMaintenance20) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(71, i+4, String.valueOf(sumVol20), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(72, i+4, String.valueOf(sumTrip21), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(73, i+4, String.valueOf(sumMaintenance21) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(74, i+4, String.valueOf(sumVol21), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(75, i+4, "", wcfOrange);
                           excelSheet.addCell(label);
                           label = new Label(76, i+4, String.valueOf(sumVolWeek3), wcfYellow);
                           excelSheet.addCell(label);
                           label = new Label(77, i+4, "", wcfOrange);
                           excelSheet.addCell(label);
                           label = new Label(78, i+4, "", wcfOrange);
                           excelSheet.addCell(label);
                           label = new Label(79, i+4, String.valueOf(sumTrip22), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(80, i+4, String.valueOf(sumMaintenance22) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(81, i+4, String.valueOf(sumVol22), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(82, i+4, String.valueOf(sumTrip23), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(83, i+4, String.valueOf(sumMaintenance23) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(84, i+4, String.valueOf(sumVol23), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(85, i+4, String.valueOf(sumTrip24), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(86, i+4, String.valueOf(sumMaintenance24) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(87, i+4, String.valueOf(sumVol24), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(88, i+4, String.valueOf(sumTrip25), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(89, i+4, String.valueOf(sumMaintenance25) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(90, i+4, String.valueOf(sumVol25), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(91, i+4, String.valueOf(sumTrip26), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(92, i+4, String.valueOf(sumMaintenance26) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(93, i+4, String.valueOf(sumVol26), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(94, i+4, String.valueOf(sumTrip27), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(95, i+4, String.valueOf(sumMaintenance27) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(96, i+4, String.valueOf(sumVol27), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(97, i+4, String.valueOf(sumTrip28), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(98, i+4, String.valueOf(sumMaintenance28) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(99, i+4, String.valueOf(sumVol28), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(100, i+4, "", wcfOrange);
                           excelSheet.addCell(label);
                           label = new Label(101, i+4, String.valueOf(sumVolWeek4), wcfYellow);
                           excelSheet.addCell(label);
                           label = new Label(102, i+4, "", wcfOrange);
                           excelSheet.addCell(label);
                           label = new Label(103, i+4, "", wcfOrange);
                           excelSheet.addCell(label);
                           label = new Label(104, i+4, String.valueOf(sumTrip29), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(105, i+4, String.valueOf(sumMaintenance29) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(106, i+4, String.valueOf(sumVol29), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(107, i+4, String.valueOf(sumTrip30), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(108, i+4, String.valueOf(sumMaintenance30) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(109, i+4, String.valueOf(sumVol30), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(110, i+4, String.valueOf(sumTrip31), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(111, i+4, String.valueOf(sumMaintenance31) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(112, i+4, String.valueOf(sumVol31), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(113, i+4, "", wcfOrange);
                           excelSheet.addCell(label);
                           label = new Label(114, i+4, String.valueOf(sumVolWeek5), wcfYellow);
                           excelSheet.addCell(label);
                           int monthVol = sumVolWeek1 + sumVolWeek2 + sumVolWeek3 + sumVolWeek4 + sumVolWeek5;
                           label = new Label(115, i+4, String.valueOf(monthVol), wcfYellow);
                           excelSheet.addCell(label);
                           label = new Label(116, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(117, i+4, "", wcfRed);
                           excelSheet.addCell(label);
                           label = new Label(118, i+4, "", wcfCyan);
                           excelSheet.addCell(label);
                           label = new Label(119, i+4, "", wcfGray);
                           excelSheet.addCell(label);
                           label = new Label(120, i+4, "", wcfDarkGreen);
                           excelSheet.addCell(label);
                           label = new Label(121, i+4, "", wcfBlack);
                           excelSheet.addCell(label);
                           label = new Label(122, i+4, "", wcfViolet);
                           excelSheet.addCell(label);
                           label = new Label(123, i+4, "", wcfOrange);
                           excelSheet.addCell(label);
                           label = new Label(124, i+4, "", wcfOrange);
                           excelSheet.addCell(label);
                           label = new Label(125, i+4, "", wcfOrange);
                           excelSheet.addCell(label);
                           label = new Label(126, i+4, "", wcfOrange);
                           excelSheet.addCell(label);
                           label = new Label(127, i+4, "", wcfOrange);
                           excelSheet.addCell(label);
                           label = new Label(128, i+4, "", wcfOrange);
                           excelSheet.addCell(label);
                           label = new Label(129, i+4, "", wcfOrange);
                           excelSheet.addCell(label);
                           label = new Label(130, i+4, "", wcfOrange);
                           excelSheet.addCell(label);
                           label = new Label(131, i+4, "", wcfOrange);
                           excelSheet.addCell(label);
                           label = new Label(132, i+4, "", wcfOrange);
                           excelSheet.addCell(label);
                           i += 1;
                           //Committed Volume
                           excelSheet.mergeCells(0, i+4, 1, i+4);
                           label = new Label(0, i+4, "Committed Volume", wcfCv);
                           excelSheet.addCell(label);
                           label = new Label(2, i+4, String.valueOf(committedVolume), wcfCv);
                           excelSheet.addCell(label);
                           if (category.equalsIgnoreCase("BATANGAS BLACK")) {
                        	   capacityOfTerminal = capacityOfTerminal * 1000; // Single Shift
                           } else {
                        	   capacityOfTerminal = capacityOfTerminal * 1000 * 2; // Double Shift
                           }
                           label = new Label(3, i+4, String.valueOf(capacityOfTerminal), wcfCv);
                           excelSheet.addCell(label);
                           label = new Label(4, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(5, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(6, i+4, String.valueOf((sumVol1-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(7, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(8, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(9, i+4, String.valueOf((sumVol2-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(10, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(11, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(12, i+4, String.valueOf((sumVol3-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(13, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(14, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(15, i+4, String.valueOf((sumVol4-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(16, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(17, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(18, i+4, String.valueOf((sumVol5-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(19, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(20, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(21, i+4, String.valueOf((sumVol6-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(22, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(23, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(24, i+4, String.valueOf((sumVol7-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(25, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(26, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(27, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(28, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(29, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(30, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(31, i+4, String.valueOf((sumVol8-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(32, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(33, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(34, i+4, String.valueOf((sumVol9-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(35, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(36, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(37, i+4, String.valueOf((sumVol10-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(38, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(39, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(40, i+4, String.valueOf((sumVol11-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(41, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(42, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(43, i+4, String.valueOf((sumVol12-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(44, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(45, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(46, i+4, String.valueOf((sumVol13-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(47, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(48, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(49, i+4, String.valueOf((sumVol14-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(50, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(51, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(52, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(53, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(54, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(55, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(56, i+4, String.valueOf((sumVol15-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(57, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(58, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(59, i+4, String.valueOf((sumVol16-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(60, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(61, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(62, i+4, String.valueOf((sumVol17-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(63, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(64, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(65, i+4, String.valueOf((sumVol18-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(66, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(67, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(68, i+4, String.valueOf((sumVol19-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(69, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(70, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(71, i+4, String.valueOf((sumVol20-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(72, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(73, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(74, i+4, String.valueOf((sumVol21-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(75, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(76, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(77, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(78, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(79, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(80, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(81, i+4, String.valueOf((sumVol22-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(82, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(83, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(84, i+4, String.valueOf((sumVol23-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(85, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(86, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(87, i+4, String.valueOf((sumVol24-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(88, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(89, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(90, i+4, String.valueOf((sumVol25-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(91, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(92, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(93, i+4, String.valueOf((sumVol26-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(94, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(95, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(96, i+4, String.valueOf((sumVol27-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(97, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(98, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(99, i+4, String.valueOf((sumVol28-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(100, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(101, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(102, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(103, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(104, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(105, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(106, i+4, String.valueOf((sumVol29-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(107, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(108, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(109, i+4, String.valueOf((sumVol30-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(110, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(111, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(112, i+4, String.valueOf((sumVol31-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(113, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(114, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(115, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(116, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(117, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(118, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(119, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(120, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(121, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(122, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(123, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(124, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(125, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(126, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(127, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(128, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(129, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(130, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(131, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(132, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           
                           i += 1;
                           excelSheet.mergeCells(0, i+4, 3, i+4);
                           label = new Label(0, i+4, "Daily Percentage " + category, wcf2);
                           excelSheet.addCell(label);
                           label = new Label(4, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(5, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance1).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(6, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(7, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(8, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance2).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(9, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(10, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(11, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance3).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(12, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(13, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(14, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance4).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(15, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(16, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(17, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance5).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(18, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(19, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(20, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance6).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(21, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(22, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(23, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance7).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(24, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(25, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(26, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(27, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(28, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(29, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(30, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance8).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(31, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(32, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(33, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance9).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(34, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(35, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(36, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance10).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(37, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(38, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(39, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance11).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(40, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(41, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(42, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance12).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(43, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(44, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(45, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance13).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(46, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(47, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(48, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance14).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(49, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(50, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(51, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(52, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(53, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(54, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(55, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance15).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(56, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(57, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(58, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance16).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(59, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(60, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(61, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance17).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(62, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(63, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(64, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance18).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(65, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(66, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(67, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance19).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(68, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(69, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(70, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance20).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(71, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(72, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(73, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance21).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(74, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(75, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(76, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(77, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(78, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(79, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(80, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance22).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(81, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(82, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(83, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance23).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(84, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(85, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(86, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance24).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(87, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(88, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(89, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance25).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(90, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(91, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(92, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance26).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(93, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(94, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(95, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance27).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(96, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(97, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(98, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance28).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(99, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(100, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(101, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(102, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(103, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(104, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(105, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance29).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(106, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(107, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(108, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance30).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(109, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(110, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(111, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance31).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(112, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(113, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(114, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(115, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(116, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(117, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(118, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(119, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(120, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(121, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(122, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(123, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(124, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(125, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(126, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(127, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(128, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(129, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(130, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(131, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(132, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           i += 1;
                	   }
                       //Merge col[0-3] and row[5]
                       excelSheet.mergeCells(0, i+4, 3, i+4);
                       label = new Label(0, i+4, item.getCategory(), wcf2);
                       excelSheet.addCell(label);
                       category = item.getCategory();
                       committedVolume = item.getCommittedVolume();
                       i += 1;
                       sumTrip1 = 0;
                       sumTrip2 = 0;
                       sumTrip3 = 0;
                       sumTrip4 = 0;
                       sumTrip5 = 0;
                       sumTrip6 = 0;
                       sumTrip7 = 0;
                       sumTrip8 = 0;
                       sumTrip9 = 0;
                       sumTrip10 = 0;
                       sumTrip11 = 0;
                       sumTrip12 = 0;
                       sumTrip13 = 0;
                       sumTrip14 = 0;
                       sumTrip15 = 0;
                       sumTrip16 = 0;
                       sumTrip17 = 0;
                       sumTrip18 = 0;
                       sumTrip19 = 0;
                       sumTrip20 = 0;
                       sumTrip21 = 0;
                       sumTrip22 = 0;
                       sumTrip23 = 0;
                       sumTrip24 = 0;
                       sumTrip25 = 0;
                       sumTrip26 = 0;
                       sumTrip27 = 0;
                       sumTrip28 = 0;
                       sumTrip29 = 0;
                       sumTrip30 = 0;
                       sumTrip31 = 0;
                       sumMaintenance1 = 0;
                       sumMaintenance2 = 0;
                       sumMaintenance3 = 0;
                       sumMaintenance4 = 0;
                       sumMaintenance5 = 0;
                       sumMaintenance6 = 0;
                       sumMaintenance7 = 0;
                       sumMaintenance8 = 0;
                       sumMaintenance9 = 0;
                       sumMaintenance10 = 0;
                       sumMaintenance11 = 0;
                       sumMaintenance12 = 0;
                       sumMaintenance13 = 0;
                       sumMaintenance14 = 0;
                       sumMaintenance15 = 0;
                       sumMaintenance16 = 0;
                       sumMaintenance17 = 0;
                       sumMaintenance18 = 0;
                       sumMaintenance19 = 0;
                       sumMaintenance20 = 0;
                       sumMaintenance21 = 0;
                       sumMaintenance22 = 0;
                       sumMaintenance23 = 0;
                       sumMaintenance24 = 0;
                       sumMaintenance25 = 0;
                       sumMaintenance26 = 0;
                       sumMaintenance27 = 0;
                       sumMaintenance28 = 0;
                       sumMaintenance29 = 0;
                       sumMaintenance30 = 0;
                       sumMaintenance31 = 0;
                       sumVol1 = 0;
                       sumVol2 = 0;
                       sumVol3 = 0;
                       sumVol4 = 0;
                       sumVol5 = 0;
                       sumVol6 = 0;
                       sumVol7 = 0;
                       sumVol8 = 0;
                       sumVol9 = 0;
                       sumVol10 = 0;
                       sumVol11 = 0;
                       sumVol12 = 0;
                       sumVol13 = 0;
                       sumVol14 = 0;
                       sumVol15 = 0;
                       sumVol16 = 0;
                       sumVol17 = 0;
                       sumVol18 = 0;
                       sumVol19 = 0;
                       sumVol20 = 0;
                       sumVol21 = 0;
                       sumVol22 = 0;
                       sumVol23 = 0;
                       sumVol24 = 0;
                       sumVol25 = 0;
                       sumVol26 = 0;
                       sumVol27 = 0;
                       sumVol28 = 0;
                       sumVol29 = 0;
                       sumVol30 = 0;
                       sumVol31 = 0;
                       sumVolWeek1 = 0;
                       sumVolWeek2 = 0;
                       sumVolWeek3 = 0;
                       sumVolWeek4 = 0;
                       sumVolWeek5 = 0;
                       totalLorryCountPerCategory = 0;
                       capacityOfTerminal = 0;
                   }
                   totalLorryCountPerCategory += 1;
                   capacityOfTerminal = capacityOfTerminal + item.getCapacity();
                   sumTrip1 = sumTrip1 + (item.getGps1()!=null ? Integer.parseInt(item.getGps1()) : 0 );
                   sumTrip2 = sumTrip2 + (item.getGps2()!=null ? Integer.parseInt(item.getGps2()) : 0 );
                   sumTrip3 = sumTrip3 + (item.getGps3()!=null ? Integer.parseInt(item.getGps3()) : 0 );
                   sumTrip4 = sumTrip4 + (item.getGps4()!=null ? Integer.parseInt(item.getGps4()) : 0 );
                   sumTrip5 = sumTrip5 + (item.getGps5()!=null ? Integer.parseInt(item.getGps5()) : 0 );
                   sumTrip6 = sumTrip6 + (item.getGps6()!=null ? Integer.parseInt(item.getGps6()) : 0 );
                   sumTrip7 = sumTrip7 + (item.getGps7()!=null ? Integer.parseInt(item.getGps7()) : 0 );
                   sumTrip8 = sumTrip8 + (item.getGps8()!=null ? Integer.parseInt(item.getGps8()) : 0 );
                   sumTrip9 = sumTrip9 + (item.getGps9()!=null ? Integer.parseInt(item.getGps9()) : 0 );
                   sumTrip10 = sumTrip10 + (item.getGps10()!=null ? Integer.parseInt(item.getGps10()) : 0 );
                   sumTrip11 = sumTrip11 + (item.getGps11()!=null ? Integer.parseInt(item.getGps11()) : 0 );
                   sumTrip12 = sumTrip12 + (item.getGps12()!=null ? Integer.parseInt(item.getGps12()) : 0 );
                   sumTrip13 = sumTrip13 + (item.getGps13()!=null ? Integer.parseInt(item.getGps13()) : 0 );
                   sumTrip14 = sumTrip14 + (item.getGps14()!=null ? Integer.parseInt(item.getGps14()) : 0 );
                   sumTrip15 = sumTrip15 + (item.getGps15()!=null ? Integer.parseInt(item.getGps15()) : 0 );
                   sumTrip16 = sumTrip16 + (item.getGps16()!=null ? Integer.parseInt(item.getGps16()) : 0 );
                   sumTrip17 = sumTrip17 + (item.getGps17()!=null ? Integer.parseInt(item.getGps17()) : 0 );
                   sumTrip18 = sumTrip18 + (item.getGps18()!=null ? Integer.parseInt(item.getGps18()) : 0 );
                   sumTrip19 = sumTrip19 + (item.getGps19()!=null ? Integer.parseInt(item.getGps19()) : 0 );
                   sumTrip20 = sumTrip20 + (item.getGps20()!=null ? Integer.parseInt(item.getGps20()) : 0 );
                   sumTrip21 = sumTrip21 + (item.getGps21()!=null ? Integer.parseInt(item.getGps21()) : 0 );
                   sumTrip22 = sumTrip22 + (item.getGps22()!=null ? Integer.parseInt(item.getGps22()) : 0 );
                   sumTrip23 = sumTrip23 + (item.getGps23()!=null ? Integer.parseInt(item.getGps23()) : 0 );
                   sumTrip24 = sumTrip24 + (item.getGps24()!=null ? Integer.parseInt(item.getGps24()) : 0 );
                   sumTrip25 = sumTrip25 + (item.getGps25()!=null ? Integer.parseInt(item.getGps25()) : 0 );
                   sumTrip26 = sumTrip26 + (item.getGps26()!=null ? Integer.parseInt(item.getGps26()) : 0 );
                   sumTrip27 = sumTrip27 + (item.getGps27()!=null ? Integer.parseInt(item.getGps27()) : 0 );
                   sumTrip28 = sumTrip28 + (item.getGps28()!=null ? Integer.parseInt(item.getGps28()) : 0 );
                   sumTrip29 = sumTrip29 + (item.getGps29()!=null ? Integer.parseInt(item.getGps29()) : 0 );
                   sumTrip30 = sumTrip30 + (item.getGps30()!=null ? Integer.parseInt(item.getGps30()) : 0 );
                   sumTrip31 = sumTrip31 + (item.getGps31()!=null ? Integer.parseInt(item.getGps31()) : 0 );
                   if (item.getMaintenance1()!=null && item.getMaintenance1().trim().equals("1")) {
                	   sumMaintenance1 += 1;
                   }
                   if (item.getMaintenance2()!=null && item.getMaintenance2().trim().equals("1")) {
                	   sumMaintenance2 += 1;
                   }
                   if (item.getMaintenance3()!=null && item.getMaintenance3().trim().equals("1")) {
                	   sumMaintenance3 += 1;
                   }
                   if (item.getMaintenance4()!=null && item.getMaintenance4().trim().equals("1")) {
                	   sumMaintenance4 += 1;
                   }
                   if (item.getMaintenance5()!=null && item.getMaintenance5().trim().equals("1")) {
                	   sumMaintenance5 += 1;
                   }
                   if (item.getMaintenance6()!=null && item.getMaintenance6().trim().equals("1")) {
                	   sumMaintenance6 += 1;
                   }
                   if (item.getMaintenance7()!=null && item.getMaintenance7().trim().equals("1")) {
                	   sumMaintenance7 += 1;
                   }
                   if (item.getMaintenance8()!=null && item.getMaintenance8().trim().equals("1")) {
                	   sumMaintenance8 += 1;
                   }
                   if (item.getMaintenance9()!=null && item.getMaintenance9().trim().equals("1")) {
                	   sumMaintenance9 += 1;
                   }
                   if (item.getMaintenance10()!=null && item.getMaintenance10().trim().equals("1")) {
                	   sumMaintenance10 += 1;
                   }
                   if (item.getMaintenance11()!=null && item.getMaintenance11().trim().equals("1")) {
                	   sumMaintenance11 += 1;
                   }
                   if (item.getMaintenance12()!=null && item.getMaintenance12().trim().equals("1")) {
                	   sumMaintenance12 += 1;
                   }
                   if (item.getMaintenance13()!=null && item.getMaintenance13().trim().equals("1")) {
                	   sumMaintenance13 += 1;
                   }
                   if (item.getMaintenance14()!=null && item.getMaintenance14().trim().equals("1")) {
                	   sumMaintenance14 += 1;
                   }
                   if (item.getMaintenance15()!=null && item.getMaintenance15().trim().equals("1")) {
                	   sumMaintenance15 += 1;
                   }
                   if (item.getMaintenance16()!=null && item.getMaintenance16().trim().equals("1")) {
                	   sumMaintenance16 += 1;
                   }
                   if (item.getMaintenance17()!=null && item.getMaintenance17().trim().equals("1")) {
                	   sumMaintenance17 += 1;
                   }
                   if (item.getMaintenance18()!=null && item.getMaintenance18().trim().equals("1")) {
                	   sumMaintenance18 += 1;
                   }
                   if (item.getMaintenance19()!=null && item.getMaintenance19().trim().equals("1")) {
                	   sumMaintenance19 += 1;
                   }
                   if (item.getMaintenance20()!=null && item.getMaintenance20().trim().equals("1")) {
                	   sumMaintenance20 += 1;
                   }
                   if (item.getMaintenance21()!=null && item.getMaintenance21().trim().equals("1")) {
                	   sumMaintenance21 += 1;
                   }
                   if (item.getMaintenance22()!=null && item.getMaintenance22().trim().equals("1")) {
                	   sumMaintenance22 += 1;
                   }
                   if (item.getMaintenance23()!=null && item.getMaintenance23().trim().equals("1")) {
                	   sumMaintenance23 += 1;
                   }
                   if (item.getMaintenance24()!=null && item.getMaintenance24().trim().equals("1")) {
                	   sumMaintenance24 += 1;
                   }
                   if (item.getMaintenance25()!=null && item.getMaintenance25().trim().equals("1")) {
                	   sumMaintenance25 += 1;
                   }
                   if (item.getMaintenance26()!=null && item.getMaintenance26().trim().equals("1")) {
                	   sumMaintenance26 += 1;
                   }
                   if (item.getMaintenance27()!=null && item.getMaintenance27().trim().equals("1")) {
                	   sumMaintenance27 += 1;
                   }
                   if (item.getMaintenance28()!=null && item.getMaintenance28().trim().equals("1")) {
                	   sumMaintenance28 += 1;
                   }
                   if (item.getMaintenance29()!=null && item.getMaintenance29().trim().equals("1")) {
                	   sumMaintenance29 += 1;
                   }
                   if (item.getMaintenance30()!=null && item.getMaintenance30().trim().equals("1")) {
                	   sumMaintenance30 += 1;
                   }
                   if (item.getMaintenance31()!=null && item.getMaintenance31().trim().equals("1")) {
                	   sumMaintenance31 += 1;
                   }
                   sumVol1 = sumVol1 + item.getGps1Vol();
                   sumVol2 = sumVol2 + item.getGps2Vol();
                   sumVol3 = sumVol3 + item.getGps3Vol();
                   sumVol4 = sumVol4 + item.getGps4Vol();
                   sumVol5 = sumVol5 + item.getGps5Vol();
                   sumVol6 = sumVol6 + item.getGps6Vol();
                   sumVol7 = sumVol7 + item.getGps7Vol();
                   sumVol8 = sumVol8 + item.getGps8Vol();
                   sumVol9 = sumVol9 + item.getGps9Vol();
                   sumVol10 = sumVol10 + item.getGps10Vol();
                   sumVol11 = sumVol11 + item.getGps11Vol();
                   sumVol12 = sumVol12 + item.getGps12Vol();
                   sumVol13 = sumVol13 + item.getGps13Vol();
                   sumVol14 = sumVol14 + item.getGps14Vol();
                   sumVol15 = sumVol15 + item.getGps15Vol();
                   sumVol16 = sumVol16 + item.getGps16Vol();
                   sumVol17 = sumVol17 + item.getGps17Vol();
                   sumVol18 = sumVol18 + item.getGps18Vol();
                   sumVol19 = sumVol19 + item.getGps19Vol();
                   sumVol20 = sumVol20 + item.getGps20Vol();
                   sumVol21 = sumVol21 + item.getGps21Vol();
                   sumVol22 = sumVol22 + item.getGps22Vol();
                   sumVol23 = sumVol23 + item.getGps23Vol();
                   sumVol24 = sumVol24 + item.getGps24Vol();
                   sumVol25 = sumVol25 + item.getGps25Vol();
                   sumVol26 = sumVol26 + item.getGps26Vol();
                   sumVol27 = sumVol27 + item.getGps27Vol();
                   sumVol28 = sumVol28 + item.getGps28Vol();
                   sumVol29 = sumVol29 + item.getGps29Vol();
                   sumVol30 = sumVol30 + item.getGps30Vol();
                   sumVol31 = sumVol31 + item.getGps31Vol();
                   sumVolWeek1 = sumVolWeek1 + item.getGpsWeek1Vol();
                   sumVolWeek2 = sumVolWeek2 + item.getGpsWeek2Vol();
                   sumVolWeek3 = sumVolWeek3 + item.getGpsWeek3Vol();
                   sumVolWeek4 = sumVolWeek4 + item.getGpsWeek4Vol();
                   sumVolWeek5 = sumVolWeek5 + item.getGpsWeek5Vol();
                   //total pending
                   if (item.getMaintenanceColor1() > 0 && item.getMaintenanceColor1() == 1105) {
                	   grandTotalPending1 += 1;
                   }
                   if (item.getMaintenanceColor2() > 0 && item.getMaintenanceColor2() == 1105) {
                	   grandTotalPending2 += 1;
                   }
                   if (item.getMaintenanceColor3() > 0 && item.getMaintenanceColor3() == 1105) {
                	   grandTotalPending3 += 1;
                   }
                   if (item.getMaintenanceColor4() > 0 && item.getMaintenanceColor4() == 1105) {
                	   grandTotalPending4 += 1;
                   }
                   if (item.getMaintenanceColor5() > 0 && item.getMaintenanceColor5() == 1105) {
                	   grandTotalPending5 += 1;
                   }
                   if (item.getMaintenanceColor6() > 0 && item.getMaintenanceColor6() == 1105) {
                	   grandTotalPending6 += 1;
                   }
                   if (item.getMaintenanceColor7() > 0 && item.getMaintenanceColor7() == 1105) {
                	   grandTotalPending7 += 1;
                   }
                   if (item.getMaintenanceColor8() > 0 && item.getMaintenanceColor8() == 1105) {
                	   grandTotalPending8 += 1;
                   }
                   if (item.getMaintenanceColor9() > 0 && item.getMaintenanceColor9() == 1105) {
                	   grandTotalPending9 += 1;
                   }
                   if (item.getMaintenanceColor10() > 0 && item.getMaintenanceColor10() == 1105) {
                	   grandTotalPending10 += 1;
                   }
                   if (item.getMaintenanceColor11() > 0 && item.getMaintenanceColor11() == 1105) {
                	   grandTotalPending11 += 1;
                   }
                   if (item.getMaintenanceColor12() > 0 && item.getMaintenanceColor12() == 1105) {
                	   grandTotalPending12 += 1;
                   }
                   if (item.getMaintenanceColor13() > 0 && item.getMaintenanceColor13() == 1105) {
                	   grandTotalPending13 += 1;
                   }
                   if (item.getMaintenanceColor14() > 0 && item.getMaintenanceColor14() == 1105) {
                	   grandTotalPending14 += 1;
                   }
                   if (item.getMaintenanceColor15() > 0 && item.getMaintenanceColor15() == 1105) {
                	   grandTotalPending15 += 1;
                   }
                   if (item.getMaintenanceColor16() > 0 && item.getMaintenanceColor16() == 1105) {
                	   grandTotalPending16 += 1;
                   }
                   if (item.getMaintenanceColor17() > 0 && item.getMaintenanceColor17() == 1105) {
                	   grandTotalPending17 += 1;
                   }
                   if (item.getMaintenanceColor18() > 0 && item.getMaintenanceColor18() == 1105) {
                	   grandTotalPending18 += 1;
                   }
                   if (item.getMaintenanceColor19() > 0 && item.getMaintenanceColor19() == 1105) {
                	   grandTotalPending19 += 1;
                   }
                   if (item.getMaintenanceColor20() > 0 && item.getMaintenanceColor20() == 1105) {
                	   grandTotalPending20 += 1;
                   }
                   if (item.getMaintenanceColor21() > 0 && item.getMaintenanceColor21() == 1105) {
                	   grandTotalPending21 += 1;
                   }
                   if (item.getMaintenanceColor22() > 0 && item.getMaintenanceColor22() == 1105) {
                	   grandTotalPending22 += 1;
                   }
                   if (item.getMaintenanceColor23() > 0 && item.getMaintenanceColor23() == 1105) {
                	   grandTotalPending23 += 1;
                   }
                   if (item.getMaintenanceColor24() > 0 && item.getMaintenanceColor24() == 1105) {
                	   grandTotalPending24 += 1;
                   }
                   if (item.getMaintenanceColor25() > 0 && item.getMaintenanceColor25() == 1105) {
                	   grandTotalPending25 += 1;
                   }
                   if (item.getMaintenanceColor26() > 0 && item.getMaintenanceColor26() == 1105) {
                	   grandTotalPending26 += 1;
                   }
                   if (item.getMaintenanceColor27() > 0 && item.getMaintenanceColor27() == 1105) {
                	   grandTotalPending27 += 1;
                   }
                   if (item.getMaintenanceColor28() > 0 && item.getMaintenanceColor28() == 1105) {
                	   grandTotalPending28 += 1;
                   }
                   if (item.getMaintenanceColor29() > 0 && item.getMaintenanceColor29() == 1105) {
                	   grandTotalPending29 += 1;
                   }
                   if (item.getMaintenanceColor30() > 0 && item.getMaintenanceColor30() == 1105) {
                	   grandTotalPending30 += 1;
                   }
                   if (item.getMaintenanceColor31() > 0 && item.getMaintenanceColor31() == 1105) {
                	   grandTotalPending31 += 1;
                   }
                   label = new Label(0, i+4, item.getPlateNo(), wcfBorder);
                   excelSheet.addCell(label);
                   label = new Label(1, i+4, item.getTrailerNo(), wcfBorder);
                   excelSheet.addCell(label);
                   label = new Label(2, i+4, item.getLorryNo(), wcfBorder);
                   excelSheet.addCell(label);
                   label = new Label(3, i+4, String.valueOf(item.getCapacity()), wcfBorder);
                   excelSheet.addCell(label);
                   z = 0;
                   for (y=1;y<=31;y++) {
                       //GPS
                       wcf3 = new WritableCellFormat(cf);
                       wcf3.setAlignment(Alignment.CENTRE);
                       wcf3.setBackground(getGPScolor(y,item));
                       wcf3.setBorder(Border.ALL, BorderLineStyle.THIN);
                       label = new Label(z+4, i+4, getGPS(y, item), wcf3);
                       gpsRemarks = getGPSremarks(y,item);
                       if (gpsRemarks!=null && gpsRemarks.trim().length() > 0) {
                    	   cellFeatures2 = new WritableCellFeatures();
                    	   cellFeatures2.setComment(gpsRemarks, 4, 2);   
                    	   label.setCellFeatures(cellFeatures2);
                       }
                       excelSheet.addCell(label);
                       wcf3 = null;
                       cellFeatures2 = null;
                       wcf3 = new WritableCellFormat(cf);
                       wcf3.setAlignment(Alignment.CENTRE);
                       wcf3.setBorder(Border.ALL, BorderLineStyle.THIN);
                       //Maintenance
                       wcf3.setBackground(getMaintenanceColor(y, item));
                       label = new Label(z+5, i+4, getMaintenance(y, item), wcf3);
                       maintenanceRemarks = getMaintenanceRemarks(y, item);
                       if (maintenanceRemarks!=null && maintenanceRemarks.trim().length() > 0) {
                           cellFeatures2 = new WritableCellFeatures();
                    	   cellFeatures2.setComment(maintenanceRemarks, 4, 2);
                    	   label.setCellFeatures(cellFeatures2);
                       }
                       excelSheet.addCell(label);
                       label = new Label(z+6, i+4, getGPSVol(y, item), wcfYellow);
                       excelSheet.addCell(label);
                       if (y==7) {
                    	   label = new Label(z+7, i+4, String.valueOf(item.getTotalTripsGPSWeek1()), wcfOrange);
                    	   excelSheet.addCell(label);
                    	   label = new Label(z+8, i+4, String.valueOf(item.getGpsWeek1Vol()), wcfYellow);
                    	   excelSheet.addCell(label);
                    	   label = new Label(z+9, i+4, String.valueOf(item.getTotalAvailabilityWeek1()), wcfOrange);
                    	   excelSheet.addCell(label);
                    	   label = new Label(z+10, i+4, String.valueOf(item.getPercentageWeek1()) , wcfOrange);
                    	   excelSheet.addCell(label);
                    	   z += 4;
                       }
                       if (y==14) {
                    	   label = new Label(z+7, i+4, String.valueOf(item.getTotalTripsGPSWeek2()), wcfOrange);
                    	   excelSheet.addCell(label);
                    	   label = new Label(z+8, i+4, String.valueOf(item.getGpsWeek2Vol()), wcfYellow);
                    	   excelSheet.addCell(label);
                    	   label = new Label(z+9, i+4, String.valueOf(item.getTotalAvailabilityWeek2()), wcfOrange);
                    	   excelSheet.addCell(label);
                    	   label = new Label(z+10, i+4, String.valueOf(item.getPercentageWeek2()), wcfOrange);
                    	   excelSheet.addCell(label);
                    	   z += 4;
                       }
                       if (y==21) {
                    	   label = new Label(z+7, i+4, String.valueOf(item.getTotalTripsGPSWeek3()), wcfOrange);
                    	   excelSheet.addCell(label);
                    	   label = new Label(z+8, i+4, String.valueOf(item.getGpsWeek3Vol()), wcfYellow);
                    	   excelSheet.addCell(label);
                    	   label = new Label(z+9, i+4, String.valueOf(item.getTotalAvailabilityWeek3()), wcfOrange);
                    	   excelSheet.addCell(label);
                    	   label = new Label(z+10, i+4, String.valueOf(item.getPercentageWeek3()), wcfOrange);
                    	   excelSheet.addCell(label);
                    	   z += 4;
                       }
                       if (y==28) {
                    	   label = new Label(z+7, i+4, String.valueOf(item.getTotalTripsGPSWeek4()), wcfOrange);
                    	   excelSheet.addCell(label);
                    	   label = new Label(z+8, i+4, String.valueOf(item.getGpsWeek4Vol()), wcfYellow);
                    	   excelSheet.addCell(label);
                    	   label = new Label(z+9, i+4, String.valueOf(item.getTotalAvailabilityWeek4()), wcfOrange);
                    	   excelSheet.addCell(label);
                    	   label = new Label(z+10, i+4, String.valueOf(item.getPercentageWeek4()), wcfOrange);
                    	   excelSheet.addCell(label);
                    	   z += 4;
                       }
                       //add the total column
                       if (y==31) {
                    	   label = new Label(z+7, i+4, String.valueOf(item.getTotalTripsGPSWeek5()), wcfOrange);
                    	   excelSheet.addCell(label);
                    	   label = new Label(z+8, i+4, String.valueOf(item.getGpsWeek5Vol()), wcfYellow);
                    	   excelSheet.addCell(label);
                    	   label = new Label(z+9, i+4, String.valueOf(item.getGpsMonthVol()), wcfYellow);
                    	   excelSheet.addCell(label);
                    	   label = new Label(z+10, i+4, String.valueOf(item.getTotalMaintenance()), wcfBorder);
                    	   excelSheet.addCell(label);
                    	   label = new Label(z+11, i+4, String.valueOf(item.getTotalBreakdown()), wcfRed);
                    	   excelSheet.addCell(label);
                    	   label = new Label(z+12, i+4, String.valueOf(item.getTotalPM()), wcfCyan);
                    	   excelSheet.addCell(label);
                    	   label = new Label(z+13, i+4, String.valueOf(item.getTotalPending()), wcfGray);
                    	   excelSheet.addCell(label);
                    	   label = new Label(z+14, i+4, String.valueOf(item.getTotalTargetDate()), wcfDarkGreen);
                    	   excelSheet.addCell(label);
                    	   label = new Label(z+15, i+4, String.valueOf(item.getTotalExtended()), wcfBlack);
                    	   excelSheet.addCell(label);
                    	   label = new Label(z+16, i+4, String.valueOf(item.getTotalEarlyDone()), wcfViolet);
                    	   excelSheet.addCell(label);
                    	   label = new Label(z+17, i+4, String.valueOf(item.getTotalTripsGPS()), wcfOrange);
                    	   excelSheet.addCell(label);
                    	   label = new Label(z+18, i+4, String.valueOf(item.getTotalPercentage()), wcfOrange);
                    	   excelSheet.addCell(label);
                    	   label = new Label(z+19, i+4, String.valueOf(item.getTotalGpsTripIssueTI()), wcfOrange);
                    	   excelSheet.addCell(label);
                    	   label = new Label(z+20, i+4, String.valueOf(item.getTotalGpsTripIssueMI()), wcfOrange);
                    	   excelSheet.addCell(label);
                    	   label = new Label(z+21, i+4, String.valueOf(item.getTotalGpsTripIssueDI()), wcfOrange);
                    	   excelSheet.addCell(label);
                    	   label = new Label(z+22, i+4, String.valueOf(item.getTotalGpsTripIssueCI()), wcfOrange);
                    	   excelSheet.addCell(label);
                    	   label = new Label(z+23, i+4, String.valueOf(item.getTotalGpsTripIssueLV()), wcfOrange);
                    	   excelSheet.addCell(label);
                    	   label = new Label(z+24, i+4, String.valueOf(item.getTotalGpsTripIssueLH()), wcfOrange);
                    	   excelSheet.addCell(label);
                    	   label = new Label(z+25, i+4, String.valueOf(item.getTotalGpsTripIssueTBI()), wcfOrange);
                    	   excelSheet.addCell(label);
                    	   label = new Label(z+26, i+4, String.valueOf(item.getTotalGpsTripIssueRI()), wcfOrange);
                    	   excelSheet.addCell(label);
                       }
                       z += 3;
                   }
                   i += 1;
        	   }
           }
           
           //Total Available and Daily Percentage of the Last Category of Shell
   		   excelSheet.mergeCells(0, i+4, 3, i+4);
           label = new Label(0, i+4, "Total Available " + category + " in Maintenance", wcf2);
           excelSheet.addCell(label);
           label = new Label(4, i+4, String.valueOf(sumTrip1), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(5, i+4, String.valueOf(sumMaintenance1) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(6, i+4, String.valueOf(sumVol1), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(7, i+4, String.valueOf(sumTrip2), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(8, i+4, String.valueOf(sumMaintenance2) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(9, i+4, String.valueOf(sumVol2), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(10, i+4, String.valueOf(sumTrip3), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(11, i+4, String.valueOf(sumMaintenance3) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(12, i+4, String.valueOf(sumVol3), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(13, i+4, String.valueOf(sumTrip4), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(14, i+4, String.valueOf(sumMaintenance4) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(15, i+4, String.valueOf(sumVol4), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(16, i+4, String.valueOf(sumTrip5), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(17, i+4, String.valueOf(sumMaintenance5) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(18, i+4, String.valueOf(sumVol5), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(19, i+4, String.valueOf(sumTrip6), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(20, i+4, String.valueOf(sumMaintenance6) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(21, i+4, String.valueOf(sumVol6), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(22, i+4, String.valueOf(sumTrip7), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(23, i+4, String.valueOf(sumMaintenance7) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(24, i+4, String.valueOf(sumVol7), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(25, i+4, "", wcfOrange);
           excelSheet.addCell(label);
           label = new Label(26, i+4, String.valueOf(sumVolWeek1), wcfYellow);
           excelSheet.addCell(label);
           label = new Label(27, i+4, "", wcfOrange);
           excelSheet.addCell(label);
           label = new Label(28, i+4, "", wcfOrange);
           excelSheet.addCell(label);
           label = new Label(29, i+4, String.valueOf(sumTrip8), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(30, i+4, String.valueOf(sumMaintenance8) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(31, i+4, String.valueOf(sumVol8), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(32, i+4, String.valueOf(sumTrip9), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(33, i+4, String.valueOf(sumMaintenance9) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(34, i+4, String.valueOf(sumVol9), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(35, i+4, String.valueOf(sumTrip10), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(36, i+4, String.valueOf(sumMaintenance10) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(37, i+4, String.valueOf(sumVol10), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(38, i+4, String.valueOf(sumTrip11), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(39, i+4, String.valueOf(sumMaintenance11) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(40, i+4, String.valueOf(sumVol11), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(41, i+4, String.valueOf(sumTrip12), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(42, i+4, String.valueOf(sumMaintenance12) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(43, i+4, String.valueOf(sumVol12), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(44, i+4, String.valueOf(sumTrip13), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(45, i+4, String.valueOf(sumMaintenance13) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(46, i+4, String.valueOf(sumVol13), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(47, i+4, String.valueOf(sumTrip14), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(48, i+4, String.valueOf(sumMaintenance14) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(49, i+4, String.valueOf(sumVol14), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(50, i+4, "", wcfOrange);
           excelSheet.addCell(label);
           label = new Label(51, i+4, String.valueOf(sumVolWeek2), wcfYellow);
           excelSheet.addCell(label);
           label = new Label(52, i+4, "", wcfOrange);
           excelSheet.addCell(label);
           label = new Label(53, i+4, "", wcfOrange);
           excelSheet.addCell(label);
           label = new Label(54, i+4, String.valueOf(sumTrip15), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(55, i+4, String.valueOf(sumMaintenance15) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(56, i+4, String.valueOf(sumVol15), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(57, i+4, String.valueOf(sumTrip16), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(58, i+4, String.valueOf(sumMaintenance16) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(59, i+4, String.valueOf(sumVol16), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(60, i+4, String.valueOf(sumTrip17), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(61, i+4, String.valueOf(sumMaintenance17) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(62, i+4, String.valueOf(sumVol17), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(63, i+4, String.valueOf(sumTrip18), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(64, i+4, String.valueOf(sumMaintenance18) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(65, i+4, String.valueOf(sumVol18), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(66, i+4, String.valueOf(sumTrip19), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(67, i+4, String.valueOf(sumMaintenance19) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(68, i+4, String.valueOf(sumVol19), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(69, i+4, String.valueOf(sumTrip20), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(70, i+4, String.valueOf(sumMaintenance20) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(71, i+4, String.valueOf(sumVol20), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(72, i+4, String.valueOf(sumTrip21), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(73, i+4, String.valueOf(sumMaintenance21) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(74, i+4, String.valueOf(sumVol21), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(75, i+4, "", wcfOrange);
           excelSheet.addCell(label);
           label = new Label(76, i+4, String.valueOf(sumVolWeek3), wcfYellow);
           excelSheet.addCell(label);
           label = new Label(77, i+4, "", wcfOrange);
           excelSheet.addCell(label);
           label = new Label(78, i+4, "", wcfOrange);
           excelSheet.addCell(label);
           label = new Label(79, i+4, String.valueOf(sumTrip22), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(80, i+4, String.valueOf(sumMaintenance22) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(81, i+4, String.valueOf(sumVol22), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(82, i+4, String.valueOf(sumTrip23), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(83, i+4, String.valueOf(sumMaintenance23) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(84, i+4, String.valueOf(sumVol23), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(85, i+4, String.valueOf(sumTrip24), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(86, i+4, String.valueOf(sumMaintenance24) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(87, i+4, String.valueOf(sumVol24), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(88, i+4, String.valueOf(sumTrip25), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(89, i+4, String.valueOf(sumMaintenance25) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(90, i+4, String.valueOf(sumVol25), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(91, i+4, String.valueOf(sumTrip26), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(92, i+4, String.valueOf(sumMaintenance26) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(93, i+4, String.valueOf(sumVol26), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(94, i+4, String.valueOf(sumTrip27), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(95, i+4, String.valueOf(sumMaintenance27) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(96, i+4, String.valueOf(sumVol27), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(97, i+4, String.valueOf(sumTrip28), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(98, i+4, String.valueOf(sumMaintenance28) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(99, i+4, String.valueOf(sumVol28), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(100, i+4, "", wcfOrange);
           excelSheet.addCell(label);
           label = new Label(101, i+4, String.valueOf(sumVolWeek4), wcfYellow);
           excelSheet.addCell(label);
           label = new Label(102, i+4, "", wcfOrange);
           excelSheet.addCell(label);
           label = new Label(103, i+4, "", wcfOrange);
           excelSheet.addCell(label);
           label = new Label(104, i+4, String.valueOf(sumTrip29), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(105, i+4, String.valueOf(sumMaintenance29) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(106, i+4, String.valueOf(sumVol29), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(107, i+4, String.valueOf(sumTrip30), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(108, i+4, String.valueOf(sumMaintenance30) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(109, i+4, String.valueOf(sumVol30), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(110, i+4, String.valueOf(sumTrip31), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(111, i+4, String.valueOf(sumMaintenance31) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(112, i+4, String.valueOf(sumVol31), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(113, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(114, i+4, String.valueOf(sumVolWeek5), wcfYellow);
           excelSheet.addCell(label);
           int monthVol = sumVolWeek1 + sumVolWeek2 + sumVolWeek3 + sumVolWeek4 + sumVolWeek5;
           label = new Label(115, i+4, String.valueOf(monthVol), wcfYellow);
           excelSheet.addCell(label);
           label = new Label(116, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(117, i+4, "", wcfRed);
           excelSheet.addCell(label);
           label = new Label(118, i+4, "", wcfCyan);
           excelSheet.addCell(label);
           label = new Label(119, i+4, "", wcfGray);
           excelSheet.addCell(label);
           label = new Label(120, i+4, "", wcfDarkGreen);
           excelSheet.addCell(label);
           label = new Label(121, i+4, "", wcfBlack);
           excelSheet.addCell(label);
           label = new Label(122, i+4, "", wcfViolet);
           excelSheet.addCell(label);
           label = new Label(123, i+4, "", wcfOrange);
           excelSheet.addCell(label);
           label = new Label(124, i+4, "", wcfOrange);
           excelSheet.addCell(label);
           label = new Label(125, i+4, "", wcfOrange);
           excelSheet.addCell(label);
           label = new Label(126, i+4, "", wcfOrange);
           excelSheet.addCell(label);
           label = new Label(127, i+4, "", wcfOrange);
           excelSheet.addCell(label);
           label = new Label(128, i+4, "", wcfOrange);
           excelSheet.addCell(label);
           label = new Label(129, i+4, "", wcfOrange);
           excelSheet.addCell(label);
           label = new Label(130, i+4, "", wcfOrange);
           excelSheet.addCell(label);
           label = new Label(131, i+4, "", wcfOrange);
           excelSheet.addCell(label);
           label = new Label(132, i+4, "", wcfOrange);
           excelSheet.addCell(label);
           
           i += 1;
           //Committed Volume
           excelSheet.mergeCells(0, i+4, 1, i+4);
           label = new Label(0, i+4, "Committed Volume", wcfCv);
           excelSheet.addCell(label);
           label = new Label(2, i+4, String.valueOf(committedVolume), wcfCv);
           excelSheet.addCell(label);
           if (category.equalsIgnoreCase("BATANGAS BLACK")) {
        	   capacityOfTerminal = capacityOfTerminal * 1000; // Single Shift
           } else {
        	   capacityOfTerminal = capacityOfTerminal * 1000 * 2; // Double Shift
           }
           label = new Label(3, i+4, String.valueOf(capacityOfTerminal), wcfCv);
           excelSheet.addCell(label);
           label = new Label(4, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(5, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(6, i+4, String.valueOf((sumVol1-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(7, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(8, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(9, i+4, String.valueOf((sumVol2-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(10, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(11, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(12, i+4, String.valueOf((sumVol3-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(13, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(14, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(15, i+4, String.valueOf((sumVol4-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(16, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(17, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(18, i+4, String.valueOf((sumVol5-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(19, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(20, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(21, i+4, String.valueOf((sumVol6-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(22, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(23, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(24, i+4, String.valueOf((sumVol7-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(25, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(26, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(27, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(28, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(29, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(30, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(31, i+4, String.valueOf((sumVol8-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(32, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(33, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(34, i+4, String.valueOf((sumVol9-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(35, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(36, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(37, i+4, String.valueOf((sumVol10-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(38, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(39, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(40, i+4, String.valueOf((sumVol11-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(41, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(42, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(43, i+4, String.valueOf((sumVol12-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(44, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(45, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(46, i+4, String.valueOf((sumVol13-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(47, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(48, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(49, i+4, String.valueOf((sumVol14-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(50, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(51, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(52, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(53, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(54, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(55, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(56, i+4, String.valueOf((sumVol15-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(57, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(58, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(59, i+4, String.valueOf((sumVol16-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(60, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(61, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(62, i+4, String.valueOf((sumVol17-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(63, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(64, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(65, i+4, String.valueOf((sumVol18-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(66, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(67, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(68, i+4, String.valueOf((sumVol19-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(69, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(70, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(71, i+4, String.valueOf((sumVol20-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(72, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(73, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(74, i+4, String.valueOf((sumVol21-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(75, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(76, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(77, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(78, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(79, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(80, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(81, i+4, String.valueOf((sumVol22-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(82, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(83, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(84, i+4, String.valueOf((sumVol23-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(85, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(86, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(87, i+4, String.valueOf((sumVol24-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(88, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(89, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(90, i+4, String.valueOf((sumVol25-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(91, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(92, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(93, i+4, String.valueOf((sumVol26-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(94, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(95, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(96, i+4, String.valueOf((sumVol27-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(97, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(98, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(99, i+4, String.valueOf((sumVol28-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(100, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(101, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(102, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(103, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(104, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(105, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(106, i+4, String.valueOf((sumVol29-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(107, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(108, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(109, i+4, String.valueOf((sumVol30-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(110, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(111, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(112, i+4, String.valueOf((sumVol31-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(113, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(114, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(115, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(116, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(117, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(118, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(119, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(120, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(121, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(122, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(123, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(124, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(125, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(126, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(127, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(128, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(129, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(130, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(131, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(132, i+4, "", wcfCv2);
           excelSheet.addCell(label);
        
           i += 1;
           excelSheet.mergeCells(0, i+4, 3, i+4);
           label = new Label(0, i+4, "Daily Percentage " + category, wcf2);
           excelSheet.addCell(label);
           label = new Label(4, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(5, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance1).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(6, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(7, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(8, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance2).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(9, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(10, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(11, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance3).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(12, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(13, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(14, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance4).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(15, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(16, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(17, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance5).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(18, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(19, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(20, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance6).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(21, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(22, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(23, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance7).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(24, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(25, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(26, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(27, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(28, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(29, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(30, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance8).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(31, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(32, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(33, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance9).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(34, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(35, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(36, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance10).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(37, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(38, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(39, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance11).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(40, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(41, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(42, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance12).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(43, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(44, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(45, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance13).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(46, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(47, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(48, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance14).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(49, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(50, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(51, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(52, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(53, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(54, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(55, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance15).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(56, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(57, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(58, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance16).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(59, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(60, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(61, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance17).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(62, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(63, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(64, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance18).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(65, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(66, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(67, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance19).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(68, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(69, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(70, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance20).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(71, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(72, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(73, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance21).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(74, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(75, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(76, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(77, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(78, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(79, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(80, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance22).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(81, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(82, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(83, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance23).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(84, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(85, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(86, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance24).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(87, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(88, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(89, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance25).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(90, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(91, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(92, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance26).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(93, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(94, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(95, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance27).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(96, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(97, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(98, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance28).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(99, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(100, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(101, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(102, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(103, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(104, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(105, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance29).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(106, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(107, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(108, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance30).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(109, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(110, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(111, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance31).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(112, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(113, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(114, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(115, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(116, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(117, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(118, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(119, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(120, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(121, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(122, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(123, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(124, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(125, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(126, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(127, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(128, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(129, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(130, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(131, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(132, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           i += 1;
           
           
           //Shell Fleet Availability
           //Merge col[0-3]
           excelSheet.mergeCells(0, i+4, 3, i+4);
           label = new Label(0, i+4, "Shell Transport Daily Availability", wcf2);
           excelSheet.addCell(label);
           for(MaintenanceMonitoringFleet item : qryListShellFleet) {
               z = 0;
               for (y=1;y<=31;y++) {
            	   label = new Label(z+4, i+4, getGPSDailyTotal(y, item), wcfBlack);
            	   excelSheet.addCell(label);
                   wcf3 = null;
                   wcf3 = new WritableCellFormat(cf);
                   wcf3.setAlignment(Alignment.CENTRE);
                   wcf3.setBorder(Border.ALL, BorderLineStyle.THIN);
                   wcf3.setBackground(Colour.BROWN);
                   label = new Label(z+5, i+4, getFleetAvailability(y, item), wcf3);
                   excelSheet.addCell(label);
                   label = new Label(z+6, i+4, "", wcfBorder);
                   excelSheet.addCell(label);
                   if (y==7) {
                	   label = new Label(z+7, i+4, String.valueOf(item.getGPSTotalWeek1()), wcfBlack);
                	   excelSheet.addCell(label);
                	   label = new Label(z+8, i+4, "", wcfYellow);
                	   excelSheet.addCell(label);
                	   label = new Label(z+9, i+4, "", wcfOrange);
                	   excelSheet.addCell(label);
                	   label = new Label(z+10, i+4, "", wcfOrange);
                	   excelSheet.addCell(label);
                	   z += 4;
                   }
                   if (y==14) {
                	   label = new Label(z+7, i+4,  String.valueOf(item.getGPSTotalWeek2()), wcfBlack);
                	   excelSheet.addCell(label);
                	   label = new Label(z+8, i+4, "", wcfYellow);
                	   excelSheet.addCell(label);
                	   label = new Label(z+9, i+4, "", wcfOrange);
                	   excelSheet.addCell(label);
                	   label = new Label(z+10, i+4, "", wcfOrange);
                	   excelSheet.addCell(label);
                	   z += 4;
                   }
                   if (y==21) {
                	   label = new Label(z+7, i+4,  String.valueOf(item.getGPSTotalWeek3()), wcfBlack);
                	   excelSheet.addCell(label);
                	   label = new Label(z+8, i+4, "", wcfYellow);
                	   excelSheet.addCell(label);
                	   label = new Label(z+9, i+4, "", wcfOrange);
                	   excelSheet.addCell(label);
                	   label = new Label(z+10, i+4, "", wcfOrange);
                	   excelSheet.addCell(label);
                	   z += 4;
                   }
                   if (y==28) {
                	   label = new Label(z+7, i+4,  String.valueOf(item.getGPSTotalWeek4()), wcfBlack);
                	   excelSheet.addCell(label);
                	   label = new Label(z+8, i+4, "", wcfYellow);
                	   excelSheet.addCell(label);
                	   label = new Label(z+9, i+4, "", wcfOrange);
                	   excelSheet.addCell(label);
                	   label = new Label(z+10, i+4, "", wcfOrange);
                	   excelSheet.addCell(label);
                	   z += 4;
                   }
  	               if (y == 31) {
                	   label = new Label(z+7, i+4,  String.valueOf(item.getGPSTotalWeek5()), wcfBlack);
                	   excelSheet.addCell(label);
  	            	   label = new Label(z+8, i+4, "", wcfBorder);
  	            	   excelSheet.addCell(label);
  	            	   label = new Label(z+9, i+4, "", wcfBorder);
	            	   excelSheet.addCell(label);
	            	   label = new Label(z+10, i+4, "", wcfBorder);
  	            	   excelSheet.addCell(label);
	               	   label = new Label(z+11, i+4, "", wcfRed);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+12, i+4, "", wcfCyan);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+13, i+4, "", wcfGray);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+14, i+4, "", wcfDarkGreen);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+15, i+4, "", wcfBlack);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+16, i+4, "", wcfViolet);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+17, i+4, String.valueOf(item.getGPSGrandTotal()), wcfBlack);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+18, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+19, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+20, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+21, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+22, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+23, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+24, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+25, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+26, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               }
                   z += 3;
               }
               //Total Transport Shell Fleet 
               i += 1;
               excelSheet.mergeCells(0, i+4, 3, i+4);
               label = new Label(0, i+4, "Total Transport Shell Fleet", wcf2);
               excelSheet.addCell(label);
               z = 0;
               for (y=1;y<=31;y++) {
            	   label = new Label(z+4, i+4, "", wcfBorder);
            	   excelSheet.addCell(label);
                   wcf3 = null;
                   wcf3 = new WritableCellFormat(cf);
                   wcf3.setAlignment(Alignment.CENTRE);
                   wcf3.setBorder(Border.ALL, BorderLineStyle.THIN);
                   wcf3.setBackground(Colour.WHITE);
                   label = new Label(z+5, i+4, String.valueOf(item.getTotalLorry()), wcf3);
                   excelSheet.addCell(label);
                   label = new Label(z+6, i+4, "", wcfBorder);
                   excelSheet.addCell(label);
                   if (y==7) {
                	   label = new Label(z+7, i+4, "", wcfOrange);
                	   excelSheet.addCell(label);
                	   label = new Label(z+8, i+4, "", wcfYellow);
                	   excelSheet.addCell(label);
                	   label = new Label(z+9, i+4, "", wcfOrange);
                	   excelSheet.addCell(label);
                	   label = new Label(z+10, i+4, "", wcfOrange);
                	   excelSheet.addCell(label);
                	   z += 4;
                   }
                   if (y==14) {
                	   label = new Label(z+7, i+4, "", wcfOrange);
                	   excelSheet.addCell(label);
                	   label = new Label(z+8, i+4, "", wcfYellow);
                	   excelSheet.addCell(label);
                	   label = new Label(z+9, i+4, "", wcfOrange);
                	   excelSheet.addCell(label);
                	   label = new Label(z+10, i+4, "", wcfOrange);
                	   excelSheet.addCell(label);
                	   z += 4;
                   }
                   if (y==21) {
                	   label = new Label(z+7, i+4, "", wcfOrange);
                	   excelSheet.addCell(label);
                	   label = new Label(z+8, i+4, "", wcfYellow);
                	   excelSheet.addCell(label);
                	   label = new Label(z+9, i+4, "", wcfOrange);
                	   excelSheet.addCell(label);
                	   label = new Label(z+10, i+4, "", wcfOrange);
                	   excelSheet.addCell(label);
                	   z += 4;
                   }
                   if (y==28) {
                	   label = new Label(z+7, i+4, "", wcfOrange);
                	   excelSheet.addCell(label);
                	   label = new Label(z+8, i+4, "", wcfYellow);
                	   excelSheet.addCell(label);
                	   label = new Label(z+9, i+4, "", wcfOrange);
                	   excelSheet.addCell(label);
                	   label = new Label(z+10, i+4, "", wcfOrange);
                	   excelSheet.addCell(label);
                	   z += 4;
                   }
  	               if (y == 31) {
                	   label = new Label(z+7, i+4, "", wcfOrange);
                	   excelSheet.addCell(label);
  	            	   label = new Label(z+8, i+4, "", wcfYellow);
  	            	   excelSheet.addCell(label);
  	            	   label = new Label(z+9, i+4, "", wcfYellow);
	            	   excelSheet.addCell(label);
	            	   label = new Label(z+10, i+4, "", wcfBorder);
  	            	   excelSheet.addCell(label);
	               	   label = new Label(z+11, i+4, "", wcfRed);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+12, i+4, "", wcfCyan);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+13, i+4, "", wcfGray);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+14, i+4, "", wcfDarkGreen);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+15, i+4, "", wcfBlack);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+16, i+4, "", wcfViolet);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+17, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+18, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+19, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+20, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+21, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+22, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+23, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+24, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+25, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+26, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               }
                   z += 3;
               }
               
               //Shell Transport Unavailable
               i += 1;
               excelSheet.mergeCells(0, i+4, 3, i+4);
               label = new Label(0, i+4, "Shell Transport Unavailable", wcf2);
               excelSheet.addCell(label);
               z = 0;
               for (y=1;y<=31;y++) {
            	   label = new Label(z+4, i+4, "", wcfBorder);
            	   excelSheet.addCell(label);
                   wcf3 = null;
                   wcf3 = new WritableCellFormat(cf);
                   wcf3.setAlignment(Alignment.CENTRE);
                   wcf3.setBorder(Border.ALL, BorderLineStyle.THIN);
                   wcf3.setBackground(Colour.RED);
                   label = new Label(z+5, i+4, getFleetUnavailable(y, item), wcf3);
                   excelSheet.addCell(label);
                   label = new Label(z+6, i+4, "", wcfBorder);
                   excelSheet.addCell(label);
                   if (y==7) {
                	   label = new Label(z+7, i+4, "", wcfOrange);
                	   excelSheet.addCell(label);
                	   label = new Label(z+8, i+4, "", wcfYellow);
                	   excelSheet.addCell(label);
                	   label = new Label(z+9, i+4, "", wcfOrange);
                	   excelSheet.addCell(label);
                	   label = new Label(z+10, i+4, "", wcfOrange);
                	   excelSheet.addCell(label);
                	   z += 4;
                   }
                   if (y==14) {
                	   label = new Label(z+7, i+4, "", wcfOrange);
                	   excelSheet.addCell(label);
                	   label = new Label(z+8, i+4, "", wcfYellow);
                	   excelSheet.addCell(label);
                	   label = new Label(z+9, i+4, "", wcfOrange);
                	   excelSheet.addCell(label);
                	   label = new Label(z+10, i+4, "", wcfOrange);
                	   excelSheet.addCell(label);
                	   z += 4;
                   }
                   if (y==21) {
                	   label = new Label(z+7, i+4, "", wcfOrange);
                	   excelSheet.addCell(label);
                	   label = new Label(z+8, i+4, "", wcfYellow);
                	   excelSheet.addCell(label);
                	   label = new Label(z+9, i+4, "", wcfOrange);
                	   excelSheet.addCell(label);
                	   label = new Label(z+10, i+4, "", wcfOrange);
                	   excelSheet.addCell(label);
                	   z += 4;
                   }
                   if (y==28) {
                	   label = new Label(z+7, i+4, "", wcfOrange);
                	   excelSheet.addCell(label);
                	   label = new Label(z+8, i+4, "", wcfYellow);
                	   excelSheet.addCell(label);
                	   label = new Label(z+9, i+4, "", wcfOrange);
                	   excelSheet.addCell(label);
                	   label = new Label(z+10, i+4, "", wcfOrange);
                	   excelSheet.addCell(label);
                	   z += 4;
                   }
  	               if (y == 31) {
                	   label = new Label(z+7, i+4, "", wcfOrange);
                	   excelSheet.addCell(label);
                	   label = new Label(z+8, i+4, "", wcfYellow);
                	   excelSheet.addCell(label);
                	   label = new Label(z+9, i+4, "", wcfYellow);
                	   excelSheet.addCell(label);
  	            	   label = new Label(z+10, i+4, "", wcfBorder);
  	            	   excelSheet.addCell(label);
	               	   label = new Label(z+11, i+4, "", wcfRed);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+12, i+4, "", wcfCyan);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+13, i+4, "", wcfGray);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+14, i+4, "", wcfDarkGreen);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+15, i+4, "", wcfBlack);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+16, i+4, "", wcfViolet);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+17, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+18, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+19, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+20, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+21, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+22, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+23, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+24, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+25, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+26, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               }
                   z += 3;
               }
           }
           
           //for Caltex/Chevron: trasportId = 602
           category = "";
           committedVolume = 0;
           capacityOfTerminal = 0;
           i += 1;
           for(MaintenanceMonitoring item : qryList) {
        	   if (item.getTransportId() == 602) {
                   if (!category.equalsIgnoreCase(item.getCategory())) {
                	   if (!category.equals("")) {
                		   //Total Available and Percentage Rows Per Category
                		   excelSheet.mergeCells(0, i+4, 3, i+4);
                           label = new Label(0, i+4, "Total Available " + category + " in Maintenance", wcf2);
                           excelSheet.addCell(label);
                           label = new Label(4, i+4, String.valueOf(sumTrip1), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(5, i+4, String.valueOf(sumMaintenance1) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(6, i+4, String.valueOf(sumVol1), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(7, i+4, String.valueOf(sumTrip2), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(8, i+4, String.valueOf(sumMaintenance2) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(9, i+4, String.valueOf(sumVol2), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(10, i+4, String.valueOf(sumTrip3), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(11, i+4, String.valueOf(sumMaintenance3) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(12, i+4, String.valueOf(sumVol3), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(13, i+4, String.valueOf(sumTrip4), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(14, i+4, String.valueOf(sumMaintenance4) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(15, i+4, String.valueOf(sumVol4), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(16, i+4, String.valueOf(sumTrip5), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(17, i+4, String.valueOf(sumMaintenance5) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(18, i+4, String.valueOf(sumVol5), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(19, i+4, String.valueOf(sumTrip6), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(20, i+4, String.valueOf(sumMaintenance6) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(21, i+4, String.valueOf(sumVol6), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(22, i+4, String.valueOf(sumTrip7), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(23, i+4, String.valueOf(sumMaintenance7) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(24, i+4, String.valueOf(sumVol7), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(25, i+4, "", wcfOrange);
                           excelSheet.addCell(label);
                           label = new Label(26, i+4, String.valueOf(sumVolWeek1), wcfYellow);
                           excelSheet.addCell(label);
                           label = new Label(27, i+4, "", wcfOrange);
                           excelSheet.addCell(label);
                           label = new Label(28, i+4, "", wcfOrange);
                           excelSheet.addCell(label);
                           label = new Label(29, i+4, String.valueOf(sumTrip8), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(30, i+4, String.valueOf(sumMaintenance8) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(31, i+4, String.valueOf(sumVol8), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(32, i+4, String.valueOf(sumTrip9), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(33, i+4, String.valueOf(sumMaintenance9) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(34, i+4, String.valueOf(sumVol9), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(35, i+4, String.valueOf(sumTrip10), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(36, i+4, String.valueOf(sumMaintenance10) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(37, i+4, String.valueOf(sumVol10), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(38, i+4, String.valueOf(sumTrip11), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(39, i+4, String.valueOf(sumMaintenance11) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(40, i+4, String.valueOf(sumVol11), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(41, i+4, String.valueOf(sumTrip12), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(42, i+4, String.valueOf(sumMaintenance12) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(43, i+4, String.valueOf(sumVol12), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(44, i+4, String.valueOf(sumTrip13), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(45, i+4, String.valueOf(sumMaintenance13) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(46, i+4, String.valueOf(sumVol13), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(47, i+4, String.valueOf(sumTrip14), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(48, i+4, String.valueOf(sumMaintenance14) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(49, i+4, String.valueOf(sumVol14), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(50, i+4, "", wcfOrange);
                           excelSheet.addCell(label);
                           label = new Label(51, i+4, String.valueOf(sumVolWeek2), wcfYellow);
                           excelSheet.addCell(label);
                           label = new Label(52, i+4, "", wcfOrange);
                           excelSheet.addCell(label);
                           label = new Label(53, i+4, "", wcfOrange);
                           excelSheet.addCell(label);
                           label = new Label(54, i+4, String.valueOf(sumTrip15), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(55, i+4, String.valueOf(sumMaintenance15) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(56, i+4, String.valueOf(sumVol15), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(57, i+4, String.valueOf(sumTrip16), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(58, i+4, String.valueOf(sumMaintenance16) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(59, i+4, String.valueOf(sumVol16), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(60, i+4, String.valueOf(sumTrip17), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(61, i+4, String.valueOf(sumMaintenance17) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(62, i+4, String.valueOf(sumVol17), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(63, i+4, String.valueOf(sumTrip18), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(64, i+4, String.valueOf(sumMaintenance18) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(65, i+4, String.valueOf(sumVol18), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(66, i+4, String.valueOf(sumTrip19), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(67, i+4, String.valueOf(sumMaintenance19) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(68, i+4, String.valueOf(sumVol19), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(69, i+4, String.valueOf(sumTrip20), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(70, i+4, String.valueOf(sumMaintenance20) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(71, i+4, String.valueOf(sumVol20), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(72, i+4, String.valueOf(sumTrip21), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(73, i+4, String.valueOf(sumMaintenance21) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(74, i+4, String.valueOf(sumVol21), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(75, i+4, "", wcfOrange);
                           excelSheet.addCell(label);
                           label = new Label(76, i+4, String.valueOf(sumVolWeek3), wcfYellow);
                           excelSheet.addCell(label);
                           label = new Label(77, i+4, "", wcfOrange);
                           excelSheet.addCell(label);
                           label = new Label(78, i+4, "", wcfOrange);
                           excelSheet.addCell(label);
                           label = new Label(79, i+4, String.valueOf(sumTrip22), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(80, i+4, String.valueOf(sumMaintenance22) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(81, i+4, String.valueOf(sumVol22), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(82, i+4, String.valueOf(sumTrip23), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(83, i+4, String.valueOf(sumMaintenance23) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(84, i+4, String.valueOf(sumVol23), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(85, i+4, String.valueOf(sumTrip24), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(86, i+4, String.valueOf(sumMaintenance24) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(87, i+4, String.valueOf(sumVol24), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(88, i+4, String.valueOf(sumTrip25), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(89, i+4, String.valueOf(sumMaintenance25) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(90, i+4, String.valueOf(sumVol25), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(91, i+4, String.valueOf(sumTrip26), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(92, i+4, String.valueOf(sumMaintenance26) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(93, i+4, String.valueOf(sumVol26), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(94, i+4, String.valueOf(sumTrip27), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(95, i+4, String.valueOf(sumMaintenance27) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(96, i+4, String.valueOf(sumVol27), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(97, i+4, String.valueOf(sumTrip28), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(98, i+4, String.valueOf(sumMaintenance28) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(99, i+4, String.valueOf(sumVol28), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(100, i+4, "", wcfOrange);
                           excelSheet.addCell(label);
                           label = new Label(101, i+4, String.valueOf(sumVolWeek4), wcfYellow);
                           excelSheet.addCell(label);
                           label = new Label(102, i+4, "", wcfOrange);
                           excelSheet.addCell(label);
                           label = new Label(103, i+4, "", wcfOrange);
                           excelSheet.addCell(label);
                           label = new Label(104, i+4, String.valueOf(sumTrip29), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(105, i+4, String.valueOf(sumMaintenance29) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(106, i+4, String.valueOf(sumVol29), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(107, i+4, String.valueOf(sumTrip30), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(108, i+4, String.valueOf(sumMaintenance30) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(109, i+4, String.valueOf(sumVol30), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(110, i+4, String.valueOf(sumTrip31), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(111, i+4, String.valueOf(sumMaintenance31) , wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(112, i+4, String.valueOf(sumVol31), wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(113, i+4, "", wcfOrange);
                           excelSheet.addCell(label);
                           label = new Label(114, i+4, String.valueOf(sumVolWeek5), wcfYellow);
                           excelSheet.addCell(label);
                           int monthVolCaltex = sumVolWeek1 + sumVolWeek2 + sumVolWeek3 + sumVolWeek4 + sumVolWeek5;
                           label = new Label(115, i+4, String.valueOf(monthVolCaltex), wcfYellow);
                           excelSheet.addCell(label);
                           label = new Label(116, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(117, i+4, "", wcfRed);
                           excelSheet.addCell(label);
                           label = new Label(118, i+4, "", wcfCyan);
                           excelSheet.addCell(label);
                           label = new Label(119, i+4, "", wcfDarkGreen);
                           excelSheet.addCell(label);
                           label = new Label(120, i+4, "", wcfBlack);
                           excelSheet.addCell(label);
                           label = new Label(121, i+4, "", wcfViolet);
                           excelSheet.addCell(label);
                           label = new Label(122, i+4, "", wcfGray);
                           excelSheet.addCell(label);
                           label = new Label(123, i+4, "", wcfOrange);
                           excelSheet.addCell(label);
                           label = new Label(124, i+4, "", wcfOrange);
                           excelSheet.addCell(label);
                           label = new Label(125, i+4, "", wcfOrange);
                           excelSheet.addCell(label);
                           label = new Label(126, i+4, "", wcfOrange);
                           excelSheet.addCell(label);
                           label = new Label(127, i+4, "", wcfOrange);
                           excelSheet.addCell(label);
                           label = new Label(128, i+4, "", wcfOrange);
                           excelSheet.addCell(label);
                           label = new Label(129, i+4, "", wcfOrange);
                           excelSheet.addCell(label);
                           label = new Label(130, i+4, "", wcfOrange);
                           excelSheet.addCell(label);
                           label = new Label(131, i+4, "", wcfOrange);
                           excelSheet.addCell(label);
                           label = new Label(132, i+4, "", wcfOrange);
                           excelSheet.addCell(label);
                           
                           i += 1;
                           //Committed Volume
                           excelSheet.mergeCells(0, i+4, 1, i+4);
                           label = new Label(0, i+4, "Committed Volume", wcfCv);
                           excelSheet.addCell(label);
                           label = new Label(2, i+4, String.valueOf(committedVolume), wcfCv);
                           excelSheet.addCell(label);
                           if (category.equalsIgnoreCase("BATANGAS BLACK")) {
                        	   capacityOfTerminal = capacityOfTerminal * 1000; // Single Shift
                           } else {
                        	   capacityOfTerminal = capacityOfTerminal * 1000 * 2; // Double Shift
                           }
                           label = new Label(3, i+4, String.valueOf(capacityOfTerminal), wcfCv);
                           excelSheet.addCell(label);
                           label = new Label(4, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(5, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(6, i+4, String.valueOf((sumVol1-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(7, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(8, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(9, i+4, String.valueOf((sumVol2-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(10, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(11, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(12, i+4, String.valueOf((sumVol3-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(13, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(14, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(15, i+4, String.valueOf((sumVol4-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(16, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(17, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(18, i+4, String.valueOf((sumVol5-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(19, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(20, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(21, i+4, String.valueOf((sumVol6-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(22, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(23, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(24, i+4, String.valueOf((sumVol7-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(25, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(26, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(27, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(28, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(29, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(30, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(31, i+4, String.valueOf((sumVol8-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(32, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(33, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(34, i+4, String.valueOf((sumVol9-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(35, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(36, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(37, i+4, String.valueOf((sumVol10-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(38, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(39, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(40, i+4, String.valueOf((sumVol11-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(41, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(42, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(43, i+4, String.valueOf((sumVol12-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(44, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(45, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(46, i+4, String.valueOf((sumVol13-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(47, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(48, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(49, i+4, String.valueOf((sumVol14-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(50, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(51, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(52, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(53, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(54, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(55, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(56, i+4, String.valueOf((sumVol15-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(57, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(58, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(59, i+4, String.valueOf((sumVol16-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(60, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(61, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(62, i+4, String.valueOf((sumVol17-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(63, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(64, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(65, i+4, String.valueOf((sumVol18-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(66, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(67, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(68, i+4, String.valueOf((sumVol19-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(69, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(70, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(71, i+4, String.valueOf((sumVol20-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(72, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(73, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(74, i+4, String.valueOf((sumVol21-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(75, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(76, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(77, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(78, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(79, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(80, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(81, i+4, String.valueOf((sumVol22-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(82, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(83, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(84, i+4, String.valueOf((sumVol23-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(85, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(86, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(87, i+4, String.valueOf((sumVol24-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(88, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(89, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(90, i+4, String.valueOf((sumVol25-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(91, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(92, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(93, i+4, String.valueOf((sumVol26-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(94, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(95, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(96, i+4, String.valueOf((sumVol27-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(97, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(98, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(99, i+4, String.valueOf((sumVol28-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(100, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(101, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(102, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(103, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(104, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(105, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(106, i+4, String.valueOf((sumVol29-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(107, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(108, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(109, i+4, String.valueOf((sumVol30-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(110, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(111, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(112, i+4, String.valueOf((sumVol31-committedVolume)) , wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(113, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(114, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(115, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(116, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(117, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(118, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(119, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(120, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(121, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(122, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(123, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(124, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(125, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(126, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(127, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(128, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(129, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(130, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(131, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                           label = new Label(132, i+4, "", wcfCv2);
                           excelSheet.addCell(label);
                        
                           i += 1;                      
                           excelSheet.mergeCells(0, i+4, 3, i+4);
                           label = new Label(0, i+4, "Daily Percentage " + category, wcf2);
                           excelSheet.addCell(label);
                           label = new Label(4, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(5, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance1).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(6, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(7, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(8, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance2).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(9, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(10, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(11, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance3).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(12, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(13, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(14, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance4).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(15, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(16, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(17, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance5).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(18, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(19, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(20, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance6).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(21, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(22, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(23, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance7).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(24, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(25, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(26, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(27, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(28, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(29, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(30, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance8).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(31, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(32, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(33, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance9).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(34, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(35, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(36, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance10).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(37, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(38, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(39, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance11).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(40, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(41, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(42, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance12).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(43, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(44, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(45, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance13).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(46, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(47, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(48, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance14).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(49, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(50, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(51, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(52, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(53, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(54, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(55, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance15).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(56, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(57, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(58, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance16).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(59, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(60, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(61, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance17).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(62, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(63, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(64, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance18).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(65, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(66, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(67, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance19).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(68, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(69, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(70, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance20).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(71, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(72, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(73, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance21).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(74, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(75, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(76, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(77, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(78, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(79, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(80, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance22).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(81, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(82, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(83, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance23).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(84, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(85, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(86, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance24).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(87, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(88, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(89, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance25).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(90, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(91, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(92, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance26).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(93, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(94, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(95, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance27).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(96, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(97, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(98, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance28).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(99, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(100, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(101, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(102, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(103, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(104, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(105, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance29).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(106, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(107, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(108, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance30).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(109, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(110, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(111, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance31).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(112, i+4, "", wcfLimeGreen);
                           excelSheet.addCell(label);
                           label = new Label(113, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(114, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(115, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(116, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(117, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(118, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(119, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(120, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(121, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(122, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(123, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(124, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(125, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(126, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(127, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(128, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(129, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(130, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(131, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           label = new Label(132, i+4, "", wcfBorder);
                           excelSheet.addCell(label);
                           i += 1;
                	   }
                       //Merge col[0-3] and row[5]
                       excelSheet.mergeCells(0, i+4, 3, i+4);
                       label = new Label(0, i+4, item.getCategory(), wcf2);
                       excelSheet.addCell(label);
                       category = item.getCategory();
                       committedVolume = item.getCommittedVolume();
                       i += 1;   
                       sumTrip1 = 0;
                       sumTrip2 = 0;
                       sumTrip3 = 0;
                       sumTrip4 = 0;
                       sumTrip5 = 0;
                       sumTrip6 = 0;
                       sumTrip7 = 0;
                       sumTrip8 = 0;
                       sumTrip9 = 0;
                       sumTrip10 = 0;
                       sumTrip11 = 0;
                       sumTrip12 = 0;
                       sumTrip13 = 0;
                       sumTrip14 = 0;
                       sumTrip15 = 0;
                       sumTrip16 = 0;
                       sumTrip17 = 0;
                       sumTrip18 = 0;
                       sumTrip19 = 0;
                       sumTrip20 = 0;
                       sumTrip21 = 0;
                       sumTrip22 = 0;
                       sumTrip23 = 0;
                       sumTrip24 = 0;
                       sumTrip25 = 0;
                       sumTrip26 = 0;
                       sumTrip27 = 0;
                       sumTrip28 = 0;
                       sumTrip29 = 0;
                       sumTrip30 = 0;
                       sumTrip31 = 0; 
                       sumMaintenance1 = 0;
                       sumMaintenance2 = 0;
                       sumMaintenance3 = 0;
                       sumMaintenance4 = 0;
                       sumMaintenance5 = 0;
                       sumMaintenance6 = 0;
                       sumMaintenance7 = 0;
                       sumMaintenance8 = 0;
                       sumMaintenance9 = 0;
                       sumMaintenance10 = 0;
                       sumMaintenance11 = 0;
                       sumMaintenance12 = 0;
                       sumMaintenance13 = 0;
                       sumMaintenance14 = 0;
                       sumMaintenance15 = 0;
                       sumMaintenance16 = 0;
                       sumMaintenance17 = 0;
                       sumMaintenance18 = 0;
                       sumMaintenance19 = 0;
                       sumMaintenance20 = 0;
                       sumMaintenance21 = 0;
                       sumMaintenance22 = 0;
                       sumMaintenance23 = 0;
                       sumMaintenance24 = 0;
                       sumMaintenance25 = 0;
                       sumMaintenance26 = 0;
                       sumMaintenance27 = 0;
                       sumMaintenance28 = 0;
                       sumMaintenance29 = 0;
                       sumMaintenance30 = 0;
                       sumMaintenance31 = 0;
                       sumVol1 = 0;
                       sumVol2 = 0;
                       sumVol3 = 0;
                       sumVol4 = 0;
                       sumVol5 = 0;
                       sumVol6 = 0;
                       sumVol7 = 0;
                       sumVol8 = 0;
                       sumVol9 = 0;
                       sumVol10 = 0;
                       sumVol11 = 0;
                       sumVol12 = 0;
                       sumVol13 = 0;
                       sumVol14 = 0;
                       sumVol15 = 0;
                       sumVol16 = 0;
                       sumVol17 = 0;
                       sumVol18 = 0;
                       sumVol19 = 0;
                       sumVol20 = 0;
                       sumVol21 = 0;
                       sumVol22 = 0;
                       sumVol23 = 0;
                       sumVol24 = 0;
                       sumVol25 = 0;
                       sumVol26 = 0;
                       sumVol27 = 0;
                       sumVol28 = 0;
                       sumVol29 = 0;
                       sumVol30 = 0;
                       sumVol31 = 0;
                       sumVolWeek1 = 0;
                       sumVolWeek2 = 0;
                       sumVolWeek3 = 0;
                       sumVolWeek4 = 0;
                       sumVolWeek5 = 0;
                       totalLorryCountPerCategory = 0;
                       capacityOfTerminal = 0;
                   }
                   totalLorryCountPerCategory += 1;
                   capacityOfTerminal = capacityOfTerminal + item.getCapacity();
                   sumTrip1 = sumTrip1 + (item.getGps1()!=null ? Integer.parseInt(item.getGps1()) : 0 );
                   sumTrip2 = sumTrip2 + (item.getGps2()!=null ? Integer.parseInt(item.getGps2()) : 0 );
                   sumTrip3 = sumTrip3 + (item.getGps3()!=null ? Integer.parseInt(item.getGps3()) : 0 );
                   sumTrip4 = sumTrip4 + (item.getGps4()!=null ? Integer.parseInt(item.getGps4()) : 0 );
                   sumTrip5 = sumTrip5 + (item.getGps5()!=null ? Integer.parseInt(item.getGps5()) : 0 );
                   sumTrip6 = sumTrip6 + (item.getGps6()!=null ? Integer.parseInt(item.getGps6()) : 0 );
                   sumTrip7 = sumTrip7 + (item.getGps7()!=null ? Integer.parseInt(item.getGps7()) : 0 );
                   sumTrip8 = sumTrip8 + (item.getGps8()!=null ? Integer.parseInt(item.getGps8()) : 0 );
                   sumTrip9 = sumTrip9 + (item.getGps9()!=null ? Integer.parseInt(item.getGps9()) : 0 );
                   sumTrip10 = sumTrip10 + (item.getGps10()!=null ? Integer.parseInt(item.getGps10()) : 0 );
                   sumTrip11 = sumTrip11 + (item.getGps11()!=null ? Integer.parseInt(item.getGps11()) : 0 );
                   sumTrip12 = sumTrip12 + (item.getGps12()!=null ? Integer.parseInt(item.getGps12()) : 0 );
                   sumTrip13 = sumTrip13 + (item.getGps13()!=null ? Integer.parseInt(item.getGps13()) : 0 );
                   sumTrip14 = sumTrip14 + (item.getGps14()!=null ? Integer.parseInt(item.getGps14()) : 0 );
                   sumTrip15 = sumTrip15 + (item.getGps15()!=null ? Integer.parseInt(item.getGps15()) : 0 );
                   sumTrip16 = sumTrip16 + (item.getGps16()!=null ? Integer.parseInt(item.getGps16()) : 0 );
                   sumTrip17 = sumTrip17 + (item.getGps17()!=null ? Integer.parseInt(item.getGps17()) : 0 );
                   sumTrip18 = sumTrip18 + (item.getGps18()!=null ? Integer.parseInt(item.getGps18()) : 0 );
                   sumTrip19 = sumTrip19 + (item.getGps19()!=null ? Integer.parseInt(item.getGps19()) : 0 );
                   sumTrip20 = sumTrip20 + (item.getGps20()!=null ? Integer.parseInt(item.getGps20()) : 0 );
                   sumTrip21 = sumTrip21 + (item.getGps21()!=null ? Integer.parseInt(item.getGps21()) : 0 );
                   sumTrip22 = sumTrip22 + (item.getGps22()!=null ? Integer.parseInt(item.getGps22()) : 0 );
                   sumTrip23 = sumTrip23 + (item.getGps23()!=null ? Integer.parseInt(item.getGps23()) : 0 );
                   sumTrip24 = sumTrip24 + (item.getGps24()!=null ? Integer.parseInt(item.getGps24()) : 0 );
                   sumTrip25 = sumTrip25 + (item.getGps25()!=null ? Integer.parseInt(item.getGps25()) : 0 );
                   sumTrip26 = sumTrip26 + (item.getGps26()!=null ? Integer.parseInt(item.getGps26()) : 0 );
                   sumTrip27 = sumTrip27 + (item.getGps27()!=null ? Integer.parseInt(item.getGps27()) : 0 );
                   sumTrip28 = sumTrip28 + (item.getGps28()!=null ? Integer.parseInt(item.getGps28()) : 0 );
                   sumTrip29 = sumTrip29 + (item.getGps29()!=null ? Integer.parseInt(item.getGps29()) : 0 );
                   sumTrip30 = sumTrip30 + (item.getGps30()!=null ? Integer.parseInt(item.getGps30()) : 0 );
                   sumTrip31 = sumTrip31 + (item.getGps31()!=null ? Integer.parseInt(item.getGps31()) : 0 );
                   if (item.getMaintenance1()!=null && item.getMaintenance1().trim().equals("1")) {
                	   sumMaintenance1 += 1;
                   }
                   if (item.getMaintenance2()!=null && item.getMaintenance2().trim().equals("1")) {
                	   sumMaintenance2 += 1;
                   }
                   if (item.getMaintenance3()!=null && item.getMaintenance3().trim().equals("1")) {
                	   sumMaintenance3 += 1;
                   }
                   if (item.getMaintenance4()!=null && item.getMaintenance4().trim().equals("1")) {
                	   sumMaintenance4 += 1;
                   }
                   if (item.getMaintenance5()!=null && item.getMaintenance5().trim().equals("1")) {
                	   sumMaintenance5 += 1;
                   }
                   if (item.getMaintenance6()!=null && item.getMaintenance6().trim().equals("1")) {
                	   sumMaintenance6 += 1;
                   }
                   if (item.getMaintenance7()!=null && item.getMaintenance7().trim().equals("1")) {
                	   sumMaintenance7 += 1;
                   }
                   if (item.getMaintenance8()!=null && item.getMaintenance8().trim().equals("1")) {
                	   sumMaintenance8 += 1;
                   }
                   if (item.getMaintenance9()!=null && item.getMaintenance9().trim().equals("1")) {
                	   sumMaintenance9 += 1;
                   }
                   if (item.getMaintenance10()!=null && item.getMaintenance10().trim().equals("1")) {
                	   sumMaintenance10 += 1;
                   }
                   if (item.getMaintenance11()!=null && item.getMaintenance11().trim().equals("1")) {
                	   sumMaintenance11 += 1;
                   }
                   if (item.getMaintenance12()!=null && item.getMaintenance12().trim().equals("1")) {
                	   sumMaintenance12 += 1;
                   }
                   if (item.getMaintenance13()!=null && item.getMaintenance13().trim().equals("1")) {
                	   sumMaintenance13 += 1;
                   }
                   if (item.getMaintenance14()!=null && item.getMaintenance14().trim().equals("1")) {
                	   sumMaintenance14 += 1;
                   }
                   if (item.getMaintenance15()!=null && item.getMaintenance15().trim().equals("1")) {
                	   sumMaintenance15 += 1;
                   }
                   if (item.getMaintenance16()!=null && item.getMaintenance16().trim().equals("1")) {
                	   sumMaintenance16 += 1;
                   }
                   if (item.getMaintenance17()!=null && item.getMaintenance17().trim().equals("1")) {
                	   sumMaintenance17 += 1;
                   }
                   if (item.getMaintenance18()!=null && item.getMaintenance18().trim().equals("1")) {
                	   sumMaintenance18 += 1;
                   }
                   if (item.getMaintenance19()!=null && item.getMaintenance19().trim().equals("1")) {
                	   sumMaintenance19 += 1;
                   }
                   if (item.getMaintenance20()!=null && item.getMaintenance20().trim().equals("1")) {
                	   sumMaintenance20 += 1;
                   }
                   if (item.getMaintenance21()!=null && item.getMaintenance21().trim().equals("1")) {
                	   sumMaintenance21 += 1;
                   }
                   if (item.getMaintenance22()!=null && item.getMaintenance22().trim().equals("1")) {
                	   sumMaintenance22 += 1;
                   }
                   if (item.getMaintenance23()!=null && item.getMaintenance23().trim().equals("1")) {
                	   sumMaintenance23 += 1;
                   }
                   if (item.getMaintenance24()!=null && item.getMaintenance24().trim().equals("1")) {
                	   sumMaintenance24 += 1;
                   }
                   if (item.getMaintenance25()!=null && item.getMaintenance25().trim().equals("1")) {
                	   sumMaintenance25 += 1;
                   }
                   if (item.getMaintenance26()!=null && item.getMaintenance26().trim().equals("1")) {
                	   sumMaintenance26 += 1;
                   }
                   if (item.getMaintenance27()!=null && item.getMaintenance27().trim().equals("1")) {
                	   sumMaintenance27 += 1;
                   }
                   if (item.getMaintenance28()!=null && item.getMaintenance28().trim().equals("1")) {
                	   sumMaintenance28 += 1;
                   }
                   if (item.getMaintenance29()!=null && item.getMaintenance29().trim().equals("1")) {
                	   sumMaintenance29 += 1;
                   }
                   if (item.getMaintenance30()!=null && item.getMaintenance30().trim().equals("1")) {
                	   sumMaintenance30 += 1;
                   }
                   if (item.getMaintenance31()!=null && item.getMaintenance31().trim().equals("1")) {
                	   sumMaintenance31 += 1;
                   }
                   sumVol1 = sumVol1 + item.getGps1Vol();
                   sumVol2 = sumVol2 + item.getGps2Vol();
                   sumVol3 = sumVol3 + item.getGps3Vol();
                   sumVol4 = sumVol4 + item.getGps4Vol();
                   sumVol5 = sumVol5 + item.getGps5Vol();
                   sumVol6 = sumVol6 + item.getGps6Vol();
                   sumVol7 = sumVol7 + item.getGps7Vol();
                   sumVol8 = sumVol8 + item.getGps8Vol();
                   sumVol9 = sumVol9 + item.getGps9Vol();
                   sumVol10 = sumVol10 + item.getGps10Vol();
                   sumVol11 = sumVol11 + item.getGps11Vol();
                   sumVol12 = sumVol12 + item.getGps12Vol();
                   sumVol13 = sumVol13 + item.getGps13Vol();
                   sumVol14 = sumVol14 + item.getGps14Vol();
                   sumVol15 = sumVol15 + item.getGps15Vol();
                   sumVol16 = sumVol16 + item.getGps16Vol();
                   sumVol17 = sumVol17 + item.getGps17Vol();
                   sumVol18 = sumVol18 + item.getGps18Vol();
                   sumVol19 = sumVol19 + item.getGps19Vol();
                   sumVol20 = sumVol20 + item.getGps20Vol();
                   sumVol21 = sumVol21 + item.getGps21Vol();
                   sumVol22 = sumVol22 + item.getGps22Vol();
                   sumVol23 = sumVol23 + item.getGps23Vol();
                   sumVol24 = sumVol24 + item.getGps24Vol();
                   sumVol25 = sumVol25 + item.getGps25Vol();
                   sumVol26 = sumVol26 + item.getGps26Vol();
                   sumVol27 = sumVol27 + item.getGps27Vol();
                   sumVol28 = sumVol28 + item.getGps28Vol();
                   sumVol29 = sumVol29 + item.getGps29Vol();
                   sumVol30 = sumVol30 + item.getGps30Vol();
                   sumVol31 = sumVol31 + item.getGps31Vol();
                   sumVolWeek1 = sumVolWeek1 + item.getGpsWeek1Vol();
                   sumVolWeek2 = sumVolWeek2 + item.getGpsWeek2Vol();
                   sumVolWeek3 = sumVolWeek3 + item.getGpsWeek3Vol();
                   sumVolWeek4 = sumVolWeek4 + item.getGpsWeek4Vol();
                   sumVolWeek5 = sumVolWeek5 + item.getGpsWeek5Vol();
                   //total pending
                   if (item.getMaintenanceColor1() > 0 && item.getMaintenanceColor1() == 1105) {
                	   grandTotalPending1 += 1;
                   }
                   if (item.getMaintenanceColor2() > 0 && item.getMaintenanceColor2() == 1105) {
                	   grandTotalPending2 += 1;
                   }
                   if (item.getMaintenanceColor3() > 0 && item.getMaintenanceColor3() == 1105) {
                	   grandTotalPending3 += 1;
                   }
                   if (item.getMaintenanceColor4() > 0 && item.getMaintenanceColor4() == 1105) {
                	   grandTotalPending4 += 1;
                   }
                   if (item.getMaintenanceColor5() > 0 && item.getMaintenanceColor5() == 1105) {
                	   grandTotalPending5 += 1;
                   }
                   if (item.getMaintenanceColor6() > 0 && item.getMaintenanceColor6() == 1105) {
                	   grandTotalPending6 += 1;
                   }
                   if (item.getMaintenanceColor7() > 0 && item.getMaintenanceColor7() == 1105) {
                	   grandTotalPending7 += 1;
                   }
                   if (item.getMaintenanceColor8() > 0 && item.getMaintenanceColor8() == 1105) {
                	   grandTotalPending8 += 1;
                   }
                   if (item.getMaintenanceColor9() > 0 && item.getMaintenanceColor9() == 1105) {
                	   grandTotalPending9 += 1;
                   }
                   if (item.getMaintenanceColor10() > 0 && item.getMaintenanceColor10() == 1105) {
                	   grandTotalPending10 += 1;
                   }
                   if (item.getMaintenanceColor11() > 0 && item.getMaintenanceColor11() == 1105) {
                	   grandTotalPending11 += 1;
                   }
                   if (item.getMaintenanceColor12() > 0 && item.getMaintenanceColor12() == 1105) {
                	   grandTotalPending12 += 1;
                   }
                   if (item.getMaintenanceColor13() > 0 && item.getMaintenanceColor13() == 1105) {
                	   grandTotalPending13 += 1;
                   }
                   if (item.getMaintenanceColor14() > 0 && item.getMaintenanceColor14() == 1105) {
                	   grandTotalPending14 += 1;
                   }
                   if (item.getMaintenanceColor15() > 0 && item.getMaintenanceColor15() == 1105) {
                	   grandTotalPending15 += 1;
                   }
                   if (item.getMaintenanceColor16() > 0 && item.getMaintenanceColor16() == 1105) {
                	   grandTotalPending16 += 1;
                   }
                   if (item.getMaintenanceColor17() > 0 && item.getMaintenanceColor17() == 1105) {
                	   grandTotalPending17 += 1;
                   }
                   if (item.getMaintenanceColor18() > 0 && item.getMaintenanceColor18() == 1105) {
                	   grandTotalPending18 += 1;
                   }
                   if (item.getMaintenanceColor19() > 0 && item.getMaintenanceColor19() == 1105) {
                	   grandTotalPending19 += 1;
                   }
                   if (item.getMaintenanceColor20() > 0 && item.getMaintenanceColor20() == 1105) {
                	   grandTotalPending20 += 1;
                   }
                   if (item.getMaintenanceColor21() > 0 && item.getMaintenanceColor21() == 1105) {
                	   grandTotalPending21 += 1;
                   }
                   if (item.getMaintenanceColor22() > 0 && item.getMaintenanceColor22() == 1105) {
                	   grandTotalPending22 += 1;
                   }
                   if (item.getMaintenanceColor23() > 0 && item.getMaintenanceColor23() == 1105) {
                	   grandTotalPending23 += 1;
                   }
                   if (item.getMaintenanceColor24() > 0 && item.getMaintenanceColor24() == 1105) {
                	   grandTotalPending24 += 1;
                   }
                   if (item.getMaintenanceColor25() > 0 && item.getMaintenanceColor25() == 1105) {
                	   grandTotalPending25 += 1;
                   }
                   if (item.getMaintenanceColor26() > 0 && item.getMaintenanceColor26() == 1105) {
                	   grandTotalPending26 += 1;
                   }
                   if (item.getMaintenanceColor27() > 0 && item.getMaintenanceColor27() == 1105) {
                	   grandTotalPending27 += 1;
                   }
                   if (item.getMaintenanceColor28() > 0 && item.getMaintenanceColor28() == 1105) {
                	   grandTotalPending28 += 1;
                   }
                   if (item.getMaintenanceColor29() > 0 && item.getMaintenanceColor29() == 1105) {
                	   grandTotalPending29 += 1;
                   }
                   if (item.getMaintenanceColor30() > 0 && item.getMaintenanceColor30() == 1105) {
                	   grandTotalPending30 += 1;
                   }
                   if (item.getMaintenanceColor31() > 0 && item.getMaintenanceColor31() == 1105) {
                	   grandTotalPending31 += 1;
                   }
                   label = new Label(0, i+4, item.getPlateNo(), wcfBorder);
                   excelSheet.addCell(label);
                   label = new Label(1, i+4, item.getTrailerNo(), wcfBorder);
                   excelSheet.addCell(label);
                   label = new Label(2, i+4, item.getLorryNo(), wcfBorder);
                   excelSheet.addCell(label);
                   label = new Label(3, i+4, String.valueOf(item.getCapacity()), wcfBorder);
                   excelSheet.addCell(label);
                   z = 0;
                   for (y=1;y<=31;y++) {
                       //GPS
                       wcf3 = new WritableCellFormat(cf);
                       wcf3.setAlignment(Alignment.CENTRE);
                       cellFeatures2 = null;
                       wcf3.setBackground(getGPScolor(y,item));
                       wcf3.setBorder(Border.ALL, BorderLineStyle.THIN);
                       label = new Label(z+4, i+4, getGPS(y, item), wcf3);
                       gpsRemarks = getGPSremarks(y,item);
                       if (gpsRemarks!=null && gpsRemarks.trim().length() > 0) {
                    	   cellFeatures2 = new WritableCellFeatures();
                    	   cellFeatures2.setComment(gpsRemarks, 4, 2);   
                    	   label.setCellFeatures(cellFeatures2);
                       }
                       excelSheet.addCell(label);
                       wcf3 = null;
                       cellFeatures2 = null;
                       wcf3 = new WritableCellFormat(cf);
                       wcf3.setAlignment(Alignment.CENTRE);
                       wcf3.setBorder(Border.ALL, BorderLineStyle.THIN);
                       //Maintenance
                       wcf3.setBackground(getMaintenanceColor(y, item));
                       label = new Label(z+5, i+4, getMaintenance(y, item), wcf3);
                       maintenanceRemarks = getMaintenanceRemarks(y, item);
                       if (maintenanceRemarks!=null && maintenanceRemarks.trim().length() > 0) {
                    	   cellFeatures2 = new WritableCellFeatures();
                    	   cellFeatures2.setComment(maintenanceRemarks, 4, 2);
                    	   label.setCellFeatures(cellFeatures2);
                       }
                       excelSheet.addCell(label);
                       label = new Label(z+6, i+4, getGPSVol(y, item), wcfYellow);
                       excelSheet.addCell(label);
                       if (y==7) {
                    	   label = new Label(z+7, i+4, String.valueOf(item.getTotalTripsGPSWeek1()), wcfOrange);
                    	   excelSheet.addCell(label);
                    	   label = new Label(z+8, i+4, String.valueOf(item.getGpsWeek1Vol()), wcfYellow);
                    	   excelSheet.addCell(label);
                    	   label = new Label(z+9, i+4, String.valueOf(item.getTotalAvailabilityWeek1()), wcfOrange);
                    	   excelSheet.addCell(label);
                    	   label = new Label(z+10, i+4, String.valueOf(item.getPercentageWeek1()), wcfOrange);
                    	   excelSheet.addCell(label);
                    	   z += 4;
                       }
                       if (y==14) {
                    	   label = new Label(z+7, i+4, String.valueOf(item.getTotalTripsGPSWeek2()), wcfOrange);
                    	   excelSheet.addCell(label);
                    	   label = new Label(z+8, i+4, String.valueOf(item.getGpsWeek2Vol()), wcfYellow);
                    	   excelSheet.addCell(label);
                    	   label = new Label(z+9, i+4, String.valueOf(item.getTotalAvailabilityWeek2()), wcfOrange);
                    	   excelSheet.addCell(label);
                    	   label = new Label(z+10, i+4, String.valueOf(item.getPercentageWeek2()), wcfOrange);
                    	   excelSheet.addCell(label);
                    	   z += 4;
                       }
                       if (y==21) {
                    	   label = new Label(z+7, i+4, String.valueOf(item.getTotalTripsGPSWeek3()), wcfOrange);
                    	   excelSheet.addCell(label);
                    	   label = new Label(z+8, i+4, String.valueOf(item.getGpsWeek3Vol()), wcfYellow);
                    	   excelSheet.addCell(label);
                    	   label = new Label(z+9, i+4, String.valueOf(item.getTotalAvailabilityWeek3()), wcfOrange);
                    	   excelSheet.addCell(label);
                    	   label = new Label(z+10, i+4, String.valueOf(item.getPercentageWeek3()), wcfOrange);
                    	   excelSheet.addCell(label);
                    	   z += 4;
                       }
                       if (y==28) {
                    	   label = new Label(z+7, i+4, String.valueOf(item.getTotalTripsGPSWeek4()), wcfOrange);
                    	   excelSheet.addCell(label);
                    	   label = new Label(z+8, i+4, String.valueOf(item.getGpsWeek4Vol()), wcfYellow);
                    	   excelSheet.addCell(label);
                    	   label = new Label(z+9, i+4, String.valueOf(item.getTotalAvailabilityWeek4()), wcfOrange);
                    	   excelSheet.addCell(label);
                    	   label = new Label(z+10, i+4, String.valueOf(item.getPercentageWeek4()), wcfOrange);
                    	   excelSheet.addCell(label);
                    	   z += 4;
                       }
                       //add the total column
                       if (y==31) {
                    	   label = new Label(z+7, i+4, String.valueOf(item.getTotalTripsGPSWeek5()), wcfOrange);
                    	   excelSheet.addCell(label);
                    	   label = new Label(z+8, i+4, String.valueOf(item.getGpsWeek5Vol()), wcfYellow);
                    	   excelSheet.addCell(label);
                    	   label = new Label(z+9, i+4, String.valueOf(item.getGpsMonthVol()), wcfYellow);
                    	   excelSheet.addCell(label);
                    	   label = new Label(z+10, i+4, String.valueOf(item.getTotalMaintenance()), wcfBorder);
                    	   excelSheet.addCell(label);
    	               	   label = new Label(z+11, i+4, String.valueOf(item.getTotalBreakdown()), wcfRed);
    	               	   excelSheet.addCell(label);
    	               	   label = new Label(z+12, i+4, String.valueOf(item.getTotalPM()), wcfCyan);
    	               	   excelSheet.addCell(label);
    	               	   label = new Label(z+13, i+4, String.valueOf(item.getTotalPending()), wcfGray);
    	               	   excelSheet.addCell(label);
    	               	   label = new Label(z+14, i+4, String.valueOf(item.getTotalTargetDate()), wcfDarkGreen);
    	               	   excelSheet.addCell(label);
    	               	   label = new Label(z+15, i+4, String.valueOf(item.getTotalExtended()), wcfBlack);
    	               	   excelSheet.addCell(label);
    	               	   label = new Label(z+16, i+4, String.valueOf(item.getTotalEarlyDone()), wcfViolet);
    	               	   excelSheet.addCell(label);
    	               	   label = new Label(z+17, i+4, String.valueOf(item.getTotalTripsGPS()), wcfOrange);
    	               	   excelSheet.addCell(label);
    	               	   label = new Label(z+18, i+4, String.valueOf(item.getTotalPercentage()), wcfOrange);
    	               	   excelSheet.addCell(label);
    	               	   label = new Label(z+19, i+4, String.valueOf(item.getTotalGpsTripIssueTI()), wcfOrange);
    	               	   excelSheet.addCell(label);
    	               	   label = new Label(z+20, i+4, String.valueOf(item.getTotalGpsTripIssueMI()), wcfOrange);
    	               	   excelSheet.addCell(label);
    	               	   label = new Label(z+21, i+4, String.valueOf(item.getTotalGpsTripIssueDI()), wcfOrange);
    	               	   excelSheet.addCell(label);
    	               	   label = new Label(z+22, i+4, String.valueOf(item.getTotalGpsTripIssueCI()), wcfOrange);
    	               	   excelSheet.addCell(label);
    	               	   label = new Label(z+23, i+4, String.valueOf(item.getTotalGpsTripIssueLV()), wcfOrange);
    	               	   excelSheet.addCell(label);
    	               	   label = new Label(z+24, i+4, String.valueOf(item.getTotalGpsTripIssueLH()), wcfOrange);
    	               	   excelSheet.addCell(label);
    	               	   label = new Label(z+25, i+4, String.valueOf(item.getTotalGpsTripIssueTBI()), wcfOrange);
    	               	   excelSheet.addCell(label);
    	               	   label = new Label(z+26, i+4, String.valueOf(item.getTotalGpsTripIssueRI()), wcfOrange);
    	               	   excelSheet.addCell(label);
                       }
                       z += 3;
                   }
                   i += 1;
        	   }
           }

           //Total Available and Daily Percentage of the Last Category of Caltex
           createTotalAvailableAndDailyPercentageOfLastCategoryOfCaltex(i, excelSheet, category, label, sumTrip1, wcf2, wcfBorder, wcfOrange, wcfYellow, wcfRed,
        		   wcfCyan, wcfGray, wcfBlack, wcfViolet, wcfDarkGreen, wcfLimeGreen, wcfCv, wcfCv2, sumMaintenance1, sumVol1, sumTrip2, sumMaintenance2, sumVol2,
        		   sumTrip3, sumMaintenance3, sumVol3, sumTrip4, sumMaintenance4, sumVol4, sumTrip5, sumMaintenance5, sumVol5, sumTrip6, sumMaintenance6, sumVol6,
        		   sumTrip7, sumMaintenance7, sumVol7, sumVolWeek1, sumVolWeek2, sumVolWeek3, sumVolWeek4, sumVolWeek5, sumTrip8, sumTrip9, sumTrip10, sumTrip11,
        		   sumTrip12, sumTrip13, sumTrip14, sumTrip15, sumTrip16, sumTrip17, sumTrip18, sumTrip19, sumTrip20, sumTrip21, sumTrip22, sumTrip23, sumTrip24,
        		   sumTrip25, sumTrip26, sumTrip27, sumTrip28, sumTrip29, sumTrip30, sumTrip31, sumMaintenance8, sumMaintenance9, sumMaintenance10, sumMaintenance11,
        		   sumMaintenance12, sumMaintenance13, sumMaintenance14, sumMaintenance15, sumMaintenance16, sumMaintenance17, sumMaintenance18, sumMaintenance19,
        		   sumMaintenance20, sumMaintenance21, sumMaintenance22, sumMaintenance23, sumMaintenance24, sumMaintenance25, sumMaintenance26, sumMaintenance27,
        		   sumMaintenance28, sumMaintenance29, sumMaintenance30, sumMaintenance31, sumVol8, sumVol9, sumVol10, sumVol11, sumVol12, sumVol13, sumVol14,
        		   sumVol15, sumVol16, sumVol17, sumVol18,sumVol19, sumVol20, sumVol21, sumVol22, sumVol23, sumVol24, sumVol25, sumVol26, sumVol27, sumVol28, sumVol29,
        		   sumVol30, sumVol31, committedVolume, capacityOfTerminal, totalLorryCountPerCategory);
        		   
           /**
            * NOTE:
            * need to update the variable i (row) because it is twice incremented by 1 
            * inside the createTotalAvailableAndDailyPercentageOfLastCategoryOfCaltex()
            */
           i += 1; //For Committed Volume Row inside createTotalAvailableAndDailyPercentageOfLastCategoryOfCaltex()
           i += 1; //For Daily Percentage Row inside createTotalAvailableAndDailyPercentageOfLastCategoryOfCaltex()
           
           //Chevron Daily Availability
           //Merge col[0-3]
   		   i += 1;
           createChevronDailyAvailabilityRow(i, excelSheet, label, qryListCaltexFleet, wcf2, wcf3, y, z, wcfBorder, cf, wcfOrange, wcfYellow, wcfRed, wcfCyan, wcfGray, wcfDarkGreen, wcfBlack, wcfViolet);
           
           /**
            * NOTE:
            * need to update the variable i (row) because it is twice incremented by 1 
            * inside the createChevronDailyAvailabilityRow()
            */
           i += 1; //For Total Chevron Fleet inside createChevronDailyAvailabilityRow()
           i += 1; //For Chevron Unavailable inside createChevronDailyAvailabilityRow()
           
           //Grand Total label
           i += 1;
           excelSheet.mergeCells(0, i+4, 3, i+4);
           label = new Label(0, i+4, "Grand Total", wcf2);
           excelSheet.addCell(label);
           
           //Total for Shell and Chevron Availability
           i += 1;
           createTotalAvailabilityRow(i, excelSheet, label, qryListGrandTotalFleet, wcf2, wcf3, y, z, wcfBorder, cf, wcfOrange, wcfYellow, wcfRed, wcfCyan, wcfGray, wcfDarkGreen, wcfBlack, wcfViolet);
           
           /**
            * NOTE:
            * need to update the variable i (row) because it was incremented by 1 
            * inside the createTotalAvailabilityRow()
            */
           i += 1; //For //Total of Shell and Chevron Unavailableinside createTotalAvailabilityRow()
           
           
           String remarks = null;
           
           //consolidate total pending 
           totalPendingMap.put(1, grandTotalPending1);
           totalPendingMap.put(2, grandTotalPending2);
           totalPendingMap.put(3, grandTotalPending3);
           totalPendingMap.put(4, grandTotalPending4);
           totalPendingMap.put(5, grandTotalPending5);
           totalPendingMap.put(6, grandTotalPending6);
           totalPendingMap.put(7, grandTotalPending7);
           totalPendingMap.put(8, grandTotalPending8);
           totalPendingMap.put(9, grandTotalPending9);
           totalPendingMap.put(10, grandTotalPending10);
           totalPendingMap.put(11, grandTotalPending11);
           totalPendingMap.put(12, grandTotalPending12);
           totalPendingMap.put(13, grandTotalPending13);
           totalPendingMap.put(14, grandTotalPending14);
           totalPendingMap.put(15, grandTotalPending15);
           totalPendingMap.put(16, grandTotalPending16);
           totalPendingMap.put(17, grandTotalPending17);
           totalPendingMap.put(18, grandTotalPending18);
           totalPendingMap.put(19, grandTotalPending19);
           totalPendingMap.put(20, grandTotalPending20);
           totalPendingMap.put(21, grandTotalPending21);
           totalPendingMap.put(22, grandTotalPending22);
           totalPendingMap.put(23, grandTotalPending23);
           totalPendingMap.put(24, grandTotalPending24);
           totalPendingMap.put(25, grandTotalPending25);
           totalPendingMap.put(26, grandTotalPending26);
           totalPendingMap.put(27, grandTotalPending27);
           totalPendingMap.put(28, grandTotalPending28);
           totalPendingMap.put(29, grandTotalPending29);
           totalPendingMap.put(30, grandTotalPending30);
           totalPendingMap.put(31, grandTotalPending31);

           
           //continue on next method to avoid 64Kb limit of capacity of each method...
           i += 1;
           continueToGenerateMaintenanceMonitoringReport(i, excelSheet, wcf2, wcf3, label, modelListPreventive, z, cellFeatures2, wcfGray, wcfBorder, wcfOrange, wcfYellow, wcfRed, wcfCyan, wcfDarkGreen, wcfBlack, wcfViolet, y, cf, remarks, totalPendingMap, modelListPreventiveTotal, modelListTotalPending);
           
           
           workBook.write();
           isFileGenerated = true;

       } catch (IOException e) {
           e.printStackTrace();
       } catch (WriteException e) {
           e.printStackTrace();
       } finally {
           if (workBook != null) {
               try {
            	   workBook.close();
               } catch (IOException e) {
                   e.printStackTrace();
               } catch (WriteException e) {
                   e.printStackTrace();
               }
           }
           System.out.println("Done.");
       }

		return isFileGenerated;
	
	}
	
	private static void createTotalAvailableAndDailyPercentageOfLastCategoryOfCaltex(int i, WritableSheet excelSheet, String category, Label label,
			int sumTrip1, WritableCellFormat wcf2, WritableCellFormat wcfBorder, WritableCellFormat wcfOrange, WritableCellFormat wcfYellow, WritableCellFormat wcfRed, 
			WritableCellFormat wcfCyan, WritableCellFormat wcfGray, WritableCellFormat wcfBlack, WritableCellFormat wcfViolet, WritableCellFormat wcfDarkGreen, WritableCellFormat wcfLimeGreen, 
			WritableCellFormat wcfCv, WritableCellFormat wcfCv2, int sumMaintenance1, int sumVol1, int  sumTrip2, int sumMaintenance2, int sumVol2, int  sumTrip3,
			int sumMaintenance3, int sumVol3, int  sumTrip4, int sumMaintenance4, int sumVol4, int  sumTrip5, int sumMaintenance5, int sumVol5, int  sumTrip6,
			int sumMaintenance6, int sumVol6, int  sumTrip7, int sumMaintenance7, int sumVol7, int sumVolWeek1, int sumVolWeek2, int sumVolWeek3, int sumVolWeek4,
			int sumVolWeek5, int  sumTrip8, int  sumTrip9, int  sumTrip10, int  sumTrip11, int  sumTrip12, int  sumTrip13, int  sumTrip14, int  sumTrip15,
			int  sumTrip16, int  sumTrip17, int  sumTrip18, int  sumTrip19, int  sumTrip20, int  sumTrip21, int  sumTrip22, int  sumTrip23, int  sumTrip24,
			int  sumTrip25, int  sumTrip26, int  sumTrip27, int  sumTrip28, int  sumTrip29, int  sumTrip30, int  sumTrip31, int sumMaintenance8, int sumMaintenance9,
			int sumMaintenance10, int sumMaintenance11, int sumMaintenance12, int sumMaintenance13, int sumMaintenance14, int sumMaintenance15, int sumMaintenance16,
			int sumMaintenance17, int sumMaintenance18, int sumMaintenance19, int sumMaintenance20, int sumMaintenance21, int sumMaintenance22, int sumMaintenance23,
			int sumMaintenance24, int sumMaintenance25, int sumMaintenance26, int sumMaintenance27, int sumMaintenance28, int sumMaintenance29, int sumMaintenance30,
			int sumMaintenance31, int sumVol8, int sumVol9, int sumVol10, int sumVol11, int sumVol12, int sumVol13, int sumVol14, int sumVol15, int sumVol16,
			int sumVol17, int sumVol18, int sumVol19, int sumVol20, int sumVol21, int sumVol22, int sumVol23, int sumVol24, int sumVol25, int sumVol26, int sumVol27,
			int sumVol28, int sumVol29, int sumVol30, int sumVol31, int committedVolume, int capacityOfTerminal, int totalLorryCountPerCategory) throws RowsExceededException, WriteException {
		
		   excelSheet.mergeCells(0, i+4, 3, i+4);
           label = new Label(0, i+4, "Total Available " + category + " in Maintenance", wcf2);
           excelSheet.addCell(label);
           label = new Label(4, i+4, String.valueOf(sumTrip1), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(5, i+4, String.valueOf(sumMaintenance1) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(6, i+4, String.valueOf(sumVol1), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(7, i+4, String.valueOf(sumTrip2), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(8, i+4, String.valueOf(sumMaintenance2) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(9, i+4, String.valueOf(sumVol2), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(10, i+4, String.valueOf(sumTrip3), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(11, i+4, String.valueOf(sumMaintenance3) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(12, i+4, String.valueOf(sumVol3), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(13, i+4, String.valueOf(sumTrip4), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(14, i+4, String.valueOf(sumMaintenance4) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(15, i+4, String.valueOf(sumVol4), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(16, i+4, String.valueOf(sumTrip5), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(17, i+4, String.valueOf(sumMaintenance5) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(18, i+4, String.valueOf(sumVol5), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(19, i+4, String.valueOf(sumTrip6), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(20, i+4, String.valueOf(sumMaintenance6) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(21, i+4, String.valueOf(sumVol6), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(22, i+4, String.valueOf(sumTrip7), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(23, i+4, String.valueOf(sumMaintenance7) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(24, i+4, String.valueOf(sumVol7), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(25, i+4, "", wcfOrange);
           excelSheet.addCell(label);
           label = new Label(26, i+4, String.valueOf(sumVolWeek1), wcfYellow);
           excelSheet.addCell(label);
           label = new Label(27, i+4, "", wcfOrange);
           excelSheet.addCell(label);
           label = new Label(28, i+4, "", wcfOrange);
           excelSheet.addCell(label);
           label = new Label(29, i+4, String.valueOf(sumTrip8), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(30, i+4, String.valueOf(sumMaintenance8) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(31, i+4, String.valueOf(sumVol8), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(32, i+4, String.valueOf(sumTrip9), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(33, i+4, String.valueOf(sumMaintenance9) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(34, i+4, String.valueOf(sumVol9), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(35, i+4, String.valueOf(sumTrip10), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(36, i+4, String.valueOf(sumMaintenance10) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(37, i+4, String.valueOf(sumVol10), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(38, i+4, String.valueOf(sumTrip11), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(39, i+4, String.valueOf(sumMaintenance11) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(40, i+4, String.valueOf(sumVol11), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(41, i+4, String.valueOf(sumTrip12), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(42, i+4, String.valueOf(sumMaintenance12) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(43, i+4, String.valueOf(sumVol12), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(44, i+4, String.valueOf(sumTrip13), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(45, i+4, String.valueOf(sumMaintenance13) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(46, i+4, String.valueOf(sumVol13), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(47, i+4, String.valueOf(sumTrip14), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(48, i+4, String.valueOf(sumMaintenance14) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(49, i+4, String.valueOf(sumVol14), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(50, i+4, "", wcfOrange);
           excelSheet.addCell(label);
           label = new Label(51, i+4, String.valueOf(sumVolWeek2), wcfYellow);
           excelSheet.addCell(label);
           label = new Label(52, i+4, "", wcfOrange);
           excelSheet.addCell(label);
           label = new Label(53, i+4, "", wcfOrange);
           excelSheet.addCell(label);
           label = new Label(54, i+4, String.valueOf(sumTrip15), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(55, i+4, String.valueOf(sumMaintenance15) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(56, i+4, String.valueOf(sumVol15), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(57, i+4, String.valueOf(sumTrip16), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(58, i+4, String.valueOf(sumMaintenance16) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(59, i+4, String.valueOf(sumVol16), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(60, i+4, String.valueOf(sumTrip17), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(61, i+4, String.valueOf(sumMaintenance17) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(62, i+4, String.valueOf(sumVol17), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(63, i+4, String.valueOf(sumTrip18), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(64, i+4, String.valueOf(sumMaintenance18) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(65, i+4, String.valueOf(sumVol18), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(66, i+4, String.valueOf(sumTrip19), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(67, i+4, String.valueOf(sumMaintenance19) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(68, i+4, String.valueOf(sumVol19), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(69, i+4, String.valueOf(sumTrip20), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(70, i+4, String.valueOf(sumMaintenance20) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(71, i+4, String.valueOf(sumVol20), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(72, i+4, String.valueOf(sumTrip21), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(73, i+4, String.valueOf(sumMaintenance21) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(74, i+4, String.valueOf(sumVol21), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(75, i+4, "", wcfOrange);
           excelSheet.addCell(label);
           label = new Label(76, i+4, String.valueOf(sumVolWeek3), wcfYellow);
           excelSheet.addCell(label);
           label = new Label(77, i+4, "", wcfOrange);
           excelSheet.addCell(label);
           label = new Label(78, i+4, "", wcfOrange);
           excelSheet.addCell(label);
           label = new Label(79, i+4, String.valueOf(sumTrip22), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(80, i+4, String.valueOf(sumMaintenance22) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(81, i+4, String.valueOf(sumVol22), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(82, i+4, String.valueOf(sumTrip23), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(83, i+4, String.valueOf(sumMaintenance23) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(84, i+4, String.valueOf(sumVol23), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(85, i+4, String.valueOf(sumTrip24), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(86, i+4, String.valueOf(sumMaintenance24) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(87, i+4, String.valueOf(sumVol24), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(88, i+4, String.valueOf(sumTrip25), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(89, i+4, String.valueOf(sumMaintenance25) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(90, i+4, String.valueOf(sumVol25), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(91, i+4, String.valueOf(sumTrip26), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(92, i+4, String.valueOf(sumMaintenance26) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(93, i+4, String.valueOf(sumVol26), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(94, i+4, String.valueOf(sumTrip27), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(95, i+4, String.valueOf(sumMaintenance27) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(96, i+4, String.valueOf(sumVol27), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(97, i+4, String.valueOf(sumTrip28), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(98, i+4, String.valueOf(sumMaintenance28) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(99, i+4, String.valueOf(sumVol28), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(100, i+4, "", wcfOrange);
           excelSheet.addCell(label);
           label = new Label(101, i+4, String.valueOf(sumVolWeek4), wcfYellow);
           excelSheet.addCell(label);
           label = new Label(102, i+4, "", wcfOrange);
           excelSheet.addCell(label);
           label = new Label(103, i+4, "", wcfOrange);
           excelSheet.addCell(label);
           label = new Label(104, i+4, String.valueOf(sumTrip29), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(105, i+4, String.valueOf(sumMaintenance29) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(106, i+4, String.valueOf(sumVol29), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(107, i+4, String.valueOf(sumTrip30), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(108, i+4, String.valueOf(sumMaintenance30) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(109, i+4, String.valueOf(sumVol30), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(110, i+4, String.valueOf(sumTrip31), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(111, i+4, String.valueOf(sumMaintenance31) , wcfBorder);
           excelSheet.addCell(label);
           label = new Label(112, i+4, String.valueOf(sumVol31), wcfBorder);
           excelSheet.addCell(label);
           label = new Label(113, i+4, "", wcfOrange);
           excelSheet.addCell(label);
           label = new Label(114, i+4, String.valueOf(sumVolWeek5), wcfYellow);
           excelSheet.addCell(label);
           int monthVolCaltex = sumVolWeek1 + sumVolWeek2 + sumVolWeek3 + sumVolWeek4 + sumVolWeek5;
           label = new Label(115, i+4, String.valueOf(monthVolCaltex), wcfYellow);
           excelSheet.addCell(label);
           label = new Label(116, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(117, i+4, "", wcfRed);
           excelSheet.addCell(label);
           label = new Label(118, i+4, "", wcfCyan);
           excelSheet.addCell(label);
           label = new Label(119, i+4, "", wcfGray);
           excelSheet.addCell(label);
           label = new Label(120, i+4, "", wcfDarkGreen);
           excelSheet.addCell(label);
           label = new Label(121, i+4, "", wcfBlack);
           excelSheet.addCell(label);
           label = new Label(122, i+4, "", wcfViolet);
           excelSheet.addCell(label);
           label = new Label(123, i+4, "", wcfOrange);
           excelSheet.addCell(label);
           label = new Label(124, i+4, "", wcfOrange);
           excelSheet.addCell(label);
           label = new Label(125, i+4, "", wcfOrange);
           excelSheet.addCell(label);
           label = new Label(126, i+4, "", wcfOrange);
           excelSheet.addCell(label);
           label = new Label(127, i+4, "", wcfOrange);
           excelSheet.addCell(label);
           label = new Label(128, i+4, "", wcfOrange);
           excelSheet.addCell(label);
           label = new Label(129, i+4, "", wcfOrange);
           excelSheet.addCell(label);
           label = new Label(130, i+4, "", wcfOrange);
           excelSheet.addCell(label);
           label = new Label(131, i+4, "", wcfOrange);
           excelSheet.addCell(label);
           label = new Label(132, i+4, "", wcfOrange);
           excelSheet.addCell(label);
           
           i += 1;
           //Committed Volume
           excelSheet.mergeCells(0, i+4, 1, i+4);
           label = new Label(0, i+4, "Committed Volume", wcfCv);
           excelSheet.addCell(label);
           label = new Label(2, i+4, String.valueOf(committedVolume), wcfCv);
           excelSheet.addCell(label);
           if (category.equalsIgnoreCase("BATANGAS BLACK")) {
        	   capacityOfTerminal = capacityOfTerminal * 1000; // Single Shift
           } else {
        	   capacityOfTerminal = capacityOfTerminal * 1000 * 2; // Double Shift
           }
           label = new Label(3, i+4, String.valueOf(capacityOfTerminal), wcfCv);
           excelSheet.addCell(label);
           label = new Label(4, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(5, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(6, i+4, String.valueOf((sumVol1-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(7, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(8, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(9, i+4, String.valueOf((sumVol2-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(10, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(11, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(12, i+4, String.valueOf((sumVol3-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(13, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(14, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(15, i+4, String.valueOf((sumVol4-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(16, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(17, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(18, i+4, String.valueOf((sumVol5-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(19, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(20, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(21, i+4, String.valueOf((sumVol6-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(22, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(23, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(24, i+4, String.valueOf((sumVol7-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(25, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(26, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(27, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(28, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(29, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(30, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(31, i+4, String.valueOf((sumVol8-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(32, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(33, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(34, i+4, String.valueOf((sumVol9-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(35, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(36, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(37, i+4, String.valueOf((sumVol10-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(38, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(39, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(40, i+4, String.valueOf((sumVol11-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(41, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(42, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(43, i+4, String.valueOf((sumVol12-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(44, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(45, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(46, i+4, String.valueOf((sumVol13-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(47, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(48, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(49, i+4, String.valueOf((sumVol14-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(50, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(51, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(52, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(53, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(54, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(55, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(56, i+4, String.valueOf((sumVol15-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(57, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(58, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(59, i+4, String.valueOf((sumVol16-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(60, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(61, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(62, i+4, String.valueOf((sumVol17-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(63, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(64, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(65, i+4, String.valueOf((sumVol18-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(66, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(67, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(68, i+4, String.valueOf((sumVol19-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(69, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(70, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(71, i+4, String.valueOf((sumVol20-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(72, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(73, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(74, i+4, String.valueOf((sumVol21-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(75, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(76, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(77, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(78, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(79, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(80, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(81, i+4, String.valueOf((sumVol22-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(82, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(83, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(84, i+4, String.valueOf((sumVol23-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(85, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(86, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(87, i+4, String.valueOf((sumVol24-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(88, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(89, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(90, i+4, String.valueOf((sumVol25-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(91, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(92, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(93, i+4, String.valueOf((sumVol26-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(94, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(95, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(96, i+4, String.valueOf((sumVol27-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(97, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(98, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(99, i+4, String.valueOf((sumVol28-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(100, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(101, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(102, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(103, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(104, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(105, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(106, i+4, String.valueOf((sumVol29-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(107, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(108, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(109, i+4, String.valueOf((sumVol30-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(110, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(111, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(112, i+4, String.valueOf((sumVol31-committedVolume)) , wcfCv2);
           excelSheet.addCell(label);
           label = new Label(113, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(114, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(115, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(116, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(117, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(118, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(119, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(120, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(121, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(122, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(123, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(124, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(125, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(126, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(127, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(128, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(129, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(130, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(131, i+4, "", wcfCv2);
           excelSheet.addCell(label);
           label = new Label(132, i+4, "", wcfCv2);
           excelSheet.addCell(label);
                  
           i += 1;
           excelSheet.mergeCells(0, i+4, 3, i+4);
           label = new Label(0, i+4, "Daily Percentage " + category, wcf2);
           excelSheet.addCell(label);
           label = new Label(4, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(5, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance1).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(6, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(7, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(8, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance2).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(9, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(10, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(11, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance3).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(12, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(13, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(14, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance4).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(15, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(16, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(17, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance5).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(18, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(19, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(20, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance6).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(21, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(22, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(23, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance7).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(24, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(25, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(26, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(27, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(28, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(29, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(30, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance8).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(31, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(32, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(33, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance9).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(34, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(35, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(36, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance10).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(37, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(38, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(39, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance11).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(40, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(41, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(42, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance12).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(43, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(44, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(45, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance13).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(46, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(47, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(48, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance14).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(49, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(50, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(51, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(52, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(53, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(54, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(55, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance15).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(56, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(57, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(58, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance16).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(59, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(60, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(61, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance17).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(62, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(63, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(64, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance18).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(65, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(66, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(67, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance19).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(68, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(69, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(70, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance20).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(71, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(72, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(73, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance21).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(74, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(75, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(76, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(77, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(78, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(79, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(80, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance22).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(81, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(82, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(83, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance23).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(84, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(85, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(86, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance24).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(87, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(88, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(89, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance25).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(90, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(91, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(92, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance26).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(93, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(94, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(95, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance27).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(96, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(97, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(98, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance28).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(99, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(100, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(101, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(102, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(103, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(104, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(105, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance29).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(106, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(107, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(108, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance30).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(109, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(110, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(111, i+4, String.valueOf(BigDecimal.valueOf(sumMaintenance31).divide(BigDecimal.valueOf(totalLorryCountPerCategory), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%") , wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(112, i+4, "", wcfLimeGreen);
           excelSheet.addCell(label);
           label = new Label(113, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(114, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(115, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(116, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(117, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(118, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(119, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(120, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(121, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(122, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(123, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(124, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(125, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(126, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(127, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(128, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(129, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(130, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(131, i+4, "", wcfBorder);
           excelSheet.addCell(label);
           label = new Label(132, i+4, "", wcfBorder);
           excelSheet.addCell(label);

	}
	
	private static void createChevronDailyAvailabilityRow(int i, WritableSheet excelSheet, Label label, List<MaintenanceMonitoringFleet> qryListCaltexFleet,
			WritableCellFormat wcf2, WritableCellFormat wcf3, int y, int z, WritableCellFormat wcfBorder, WritableFont cf, WritableCellFormat wcfOrange,
			WritableCellFormat wcfYellow, WritableCellFormat wcfRed, WritableCellFormat wcfCyan, WritableCellFormat wcfGray, WritableCellFormat wcfDarkGreen,
			WritableCellFormat wcfBlack, WritableCellFormat wcfViolet) throws RowsExceededException, WriteException {
        excelSheet.mergeCells(0, i+4, 3, i+4);
        label = new Label(0, i+4, "Chevron Daily Availability", wcf2);
        excelSheet.addCell(label);
        for(MaintenanceMonitoringFleet item : qryListCaltexFleet) {
            z = 0;
            for (y=1;y<=31;y++) {
         	   label = new Label(z+4, i+4, getGPSDailyTotal(y, item), wcfBlack);
         	   excelSheet.addCell(label);
                wcf3 = null;
                wcf3 = new WritableCellFormat(cf);
                wcf3.setAlignment(Alignment.CENTRE);
                wcf3.setBorder(Border.ALL, BorderLineStyle.THIN);
                wcf3.setBackground(Colour.BROWN);
                label = new Label(z+5, i+4, getFleetAvailability(y, item), wcf3);
                excelSheet.addCell(label);
                label = new Label(z+6, i+4, "", wcfBorder);
                excelSheet.addCell(label);
                if (y==7) {
             	   label = new Label(z+7, i+4, String.valueOf(item.getGPSTotalWeek1()), wcfBlack);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+10, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   z += 4;
                }
                if (y==14) {
             	   label = new Label(z+7, i+4, String.valueOf(item.getGPSTotalWeek2()), wcfBlack);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+10, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   z += 4;
                }
                if (y==21) {
             	   label = new Label(z+7, i+4, String.valueOf(item.getGPSTotalWeek3()), wcfBlack);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+10, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   z += 4;
                }
                if (y==28) {
             	   label = new Label(z+7, i+4, String.valueOf(item.getGPSTotalWeek4()), wcfBlack);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+10, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   z += 4;
                }
	               if (y == 31) {
             	   label = new Label(z+7, i+4, String.valueOf(item.getGPSTotalWeek5()), wcfBlack);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfBorder);
	            	   excelSheet.addCell(label);
	            	   label = new Label(z+9, i+4, "", wcfBorder);
	            	   excelSheet.addCell(label);
	            	   label = new Label(z+10, i+4, "", wcfBorder);
	            	   excelSheet.addCell(label);
	               	   label = new Label(z+11, i+4, "", wcfRed);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+12, i+4, "", wcfCyan);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+13, i+4, "", wcfGray);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+14, i+4, "", wcfDarkGreen);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+15, i+4, "", wcfBlack);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+16, i+4, "", wcfViolet);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+17, i+4, String.valueOf(item.getGPSGrandTotal()), wcfBlack);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+18, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+19, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+20, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+21, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+22, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+23, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+24, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+25, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+26, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               }
                z += 3;
            }
            //Total Chevron Fleet 
            i += 1;
            excelSheet.mergeCells(0, i+4, 3, i+4);
            label = new Label(0, i+4, "Total Chevron Fleet", wcf2);
            excelSheet.addCell(label);
            z = 0;
            for (y=1;y<=31;y++) {
         	   label = new Label(z+4, i+4, "", wcfBorder);
         	   excelSheet.addCell(label);
                wcf3 = null;
                wcf3 = new WritableCellFormat(cf);
                wcf3.setAlignment(Alignment.CENTRE);
                wcf3.setBorder(Border.ALL, BorderLineStyle.THIN);
                wcf3.setBackground(Colour.WHITE);
                label = new Label(z+5, i+4, String.valueOf(item.getTotalLorry()), wcf3);
                excelSheet.addCell(label);
                label = new Label(z+6, i+4, "", wcfBorder);
                excelSheet.addCell(label);
                if (y==7) {
             	   label = new Label(z+7, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+10, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   z += 4;
                }
                if (y==14) {
             	   label = new Label(z+7, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+10, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   z += 4;
                }
                if (y==21) {
             	   label = new Label(z+7, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+10, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   z += 4;
                }
                if (y==28) {
             	   label = new Label(z+7, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+10, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   z += 4;
                }
	               if (y == 31) {
             	   label = new Label(z+7, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
	            	   label = new Label(z+10, i+4, "", wcfBorder);
	            	   excelSheet.addCell(label);
	               	   label = new Label(z+11, i+4, "", wcfRed);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+12, i+4, "", wcfCyan);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+13, i+4, "", wcfGray);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+14, i+4, "", wcfDarkGreen);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+15, i+4, "", wcfBlack);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+16, i+4, "", wcfViolet);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+17, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+18, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+19, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+20, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+21, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+22, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+23, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+24, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+25, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+26, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               }
                z += 3;
            }
            
            //Chevron Unavailable
            i += 1;
            excelSheet.mergeCells(0, i+4, 3, i+4);
            label = new Label(0, i+4, "Chevron Unavailable", wcf2);
            excelSheet.addCell(label);
            z = 0;
            for (y=1;y<=31;y++) {
         	   label = new Label(z+4, i+4, "", wcfBorder);
         	   excelSheet.addCell(label);
                wcf3 = null;
                wcf3 = new WritableCellFormat(cf);
                wcf3.setAlignment(Alignment.CENTRE);
                wcf3.setBorder(Border.ALL, BorderLineStyle.THIN);
                wcf3.setBackground(Colour.RED);
                label = new Label(z+5, i+4, getFleetUnavailable(y, item), wcf3);
                excelSheet.addCell(label);
                label = new Label(z+6, i+4, "", wcfBorder);
                excelSheet.addCell(label);
                if (y==7) {
             	   label = new Label(z+7, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+10, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   z += 4;
                }
                if (y==14) {
             	   label = new Label(z+7, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+10, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   z += 4;
                }
                if (y==21) {
             	   label = new Label(z+7, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+10, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   z += 4;
                }
                if (y==28) {
             	   label = new Label(z+7, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+10, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   z += 4;
                }
	               if (y == 31) {
             	   label = new Label(z+7, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
	              	   label = new Label(z+10, i+4, "", wcfBorder);
	            	   excelSheet.addCell(label);
	               	   label = new Label(z+11, i+4, "", wcfRed);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+12, i+4, "", wcfCyan);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+13, i+4, "", wcfGray);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+14, i+4, "", wcfDarkGreen);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+15, i+4, "", wcfBlack);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+16, i+4, "", wcfViolet);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+17, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+18, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+19, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+20, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+21, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+22, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+23, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+24, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+25, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+26, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               }
                z += 3;
            }
        }
	}
	
	private static void createTotalAvailabilityRow(int i, WritableSheet excelSheet, Label label, List<MaintenanceMonitoringFleet> qryListGrandTotalFleet,
			WritableCellFormat wcf2, WritableCellFormat wcf3, int y, int z, WritableCellFormat wcfBorder, WritableFont cf, WritableCellFormat wcfOrange,
			WritableCellFormat wcfYellow, WritableCellFormat wcfRed, WritableCellFormat wcfCyan, WritableCellFormat wcfGray, WritableCellFormat wcfDarkGreen,
			WritableCellFormat wcfBlack, WritableCellFormat wcfViolet) throws RowsExceededException, WriteException {
		
        excelSheet.mergeCells(0, i+4, 3, i+4);
        label = new Label(0, i+4, "Total for Shell and Chevron Availability", wcf2);
        excelSheet.addCell(label);
        for(MaintenanceMonitoringFleet item : qryListGrandTotalFleet) {
            z = 0;
            for (y=1;y<=31;y++) {
         	   label = new Label(z+4, i+4, "", wcfBorder);
         	   excelSheet.addCell(label);
                wcf3 = null;
                wcf3 = new WritableCellFormat(cf);
                wcf3.setAlignment(Alignment.CENTRE);
                wcf3.setBorder(Border.ALL, BorderLineStyle.THIN);
                wcf3.setBackground(Colour.YELLOW);
                label = new Label(z+5, i+4, getFleetAvailability(y, item), wcf3);
                excelSheet.addCell(label);
                label = new Label(z+6, i+4, "", wcfBorder);
                excelSheet.addCell(label);
                if (y==7) {
             	   label = new Label(z+7, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+10, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   z += 4;
                }
                if (y==14) {
             	   label = new Label(z+7, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+10, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   z += 4;
                }
                if (y==21) {
             	   label = new Label(z+7, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+10, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   z += 4;
                }
                if (y==28) {
             	   label = new Label(z+7, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+10, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   z += 4;
                }
	               if (y == 31) {
             	   label = new Label(z+7, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
	            	   label = new Label(z+10, i+4, "", wcfBorder);
	            	   excelSheet.addCell(label);
	               	   label = new Label(z+11, i+4, "", wcfRed);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+12, i+4, "", wcfCyan);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+13, i+4, "", wcfGray);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+14, i+4, "", wcfDarkGreen);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+15, i+4, "", wcfBlack);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+16, i+4, "", wcfViolet);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+17, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+18, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+19, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+20, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+21, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+22, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+23, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+24, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+25, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+26, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               }
                z += 3;
            }
            
            //Total of Shell and Chevron Unavailable
            i += 1;
            excelSheet.mergeCells(0, i+4, 3, i+4);
            label = new Label(0, i+4, "Total of Shell and Chevron Unavailable", wcf2);
            excelSheet.addCell(label);
            z = 0;
            for (y=1;y<=31;y++) {
         	   label = new Label(z+4, i+4, "", wcfBorder);
         	   excelSheet.addCell(label);
                wcf3 = null;
                wcf3 = new WritableCellFormat(cf);
                wcf3.setAlignment(Alignment.CENTRE);
                wcf3.setBorder(Border.ALL, BorderLineStyle.THIN);
                wcf3.setBackground(Colour.RED);
                label = new Label(z+5, i+4, getFleetUnavailable(y, item), wcf3);
                excelSheet.addCell(label);
                label = new Label(z+6, i+4, "", wcfBorder);
                excelSheet.addCell(label);
                if (y==7) {
             	   label = new Label(z+7, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+10, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   z += 4;
                }
                if (y==14) {
             	   label = new Label(z+7, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+10, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   z += 4;
                }
                if (y==21) {
             	   label = new Label(z+7, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+10, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   z += 4;
                }
                if (y==28) {
             	   label = new Label(z+7, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+10, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   z += 4;
                }
	               if (y == 31) {
             	   label = new Label(z+7, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
	            	   label = new Label(z+10, i+4, "", wcfBorder);
	            	   excelSheet.addCell(label);
	               	   label = new Label(z+11, i+4, "", wcfRed);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+12, i+4, "", wcfCyan);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+13, i+4, "", wcfGray);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+14, i+4, "", wcfDarkGreen);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+15, i+4, "", wcfBlack);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+16, i+4, "", wcfViolet);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+17, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+18, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+19, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+20, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+21, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+22, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+23, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+24, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+25, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+26, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               }
                z += 3;
            }
        }

	}
	
	/**
	 * 
	 * @param i
	 * @param excelSheet
	 * @param wcf2
	 * @param wcf3
	 * @param label
	 * @param modelListTotalPending
	 * @param z
	 * @param cellFeatures2
	 * @param wcfGray
	 * @param wcfBorder
	 * @param wcfOrange
	 * @param wcfYellow
	 * @param wcfRed
	 * @param wcfCyan
	 * @param wcfDarkGreen
	 * @param wcfBlack
	 * @param wcfViolet
	 * @param remarks
	 * @param y
	 * @param cf
	 * @param totalPendingMap
	 * @throws RowsExceededException
	 * @throws WriteException
	 */
	private static void createTotalPendingRow(int i, WritableSheet  excelSheet, WritableCellFormat wcf2, WritableCellFormat wcf3, 
									Label label, List<MaintenanceMonitoringTotalPending> modelListTotalPending,int z, WritableCellFeatures  cellFeatures2,
									WritableCellFormat wcfGray, WritableCellFormat wcfBorder, WritableCellFormat wcfOrange, WritableCellFormat wcfYellow,
									WritableCellFormat wcfRed, WritableCellFormat wcfCyan, WritableCellFormat wcfDarkGreen, WritableCellFormat wcfBlack, WritableCellFormat wcfViolet,
									String remarks, int y, WritableFont cf, Map<Integer, Integer> totalPendingMap) throws RowsExceededException, WriteException{
		
        i += 1;
        excelSheet.mergeCells(0, i+4, 1, i+4);
        label = new Label(0, i+4, "", wcf2);
        excelSheet.addCell(label);
        excelSheet.mergeCells(2, i+4, 3, i+4);
        label = new Label(2, i+4, "Total Pending", wcf2);
        excelSheet.addCell(label);
        for(MaintenanceMonitoringTotalPending item : modelListTotalPending) {
            z = 0;
            for (y=1;y<=31;y++) {
         	   label = new Label(z+4, i+4, "", wcfGray);
         	   excelSheet.addCell(label);
                wcf3 = null;
                cellFeatures2 = null;
                wcf3 = new WritableCellFormat(cf);            
                wcf3.setAlignment(Alignment.CENTRE);
                wcf3.setBorder(Border.ALL, BorderLineStyle.THIN);
                wcf3.setBackground(Colour.RED); 
                label = new Label(z+5, i+4, String.valueOf(totalPendingMap.get(y)), wcfGray);
                remarks = getTotalPendingComment(y,item);
                if (remarks!=null && remarks.trim().length() > 0) {
             	   cellFeatures2 = new WritableCellFeatures();
             	   cellFeatures2.setComment(remarks, 4, 2);   
             	   label.setCellFeatures(cellFeatures2);
                }
                excelSheet.addCell(label);
                label = new Label(z+6, i+4, "", wcfGray);
                excelSheet.addCell(label);
                if (y==7) {
             	   label = new Label(z+7, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+10, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   z += 4;
                }
                if (y==14) {
             	   label = new Label(z+7, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+10, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   z += 4;
                }
                if (y==21) {
             	   label = new Label(z+7, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+10, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   z += 4;
                }
                if (y==28) {
             	   label = new Label(z+7, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+10, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   z += 4;
                }
	               if (y == 31) {
	             	   label = new Label(z+7, i+4, "", wcfOrange);
	             	   excelSheet.addCell(label);
	             	   label = new Label(z+8, i+4, "", wcfYellow);
	             	   excelSheet.addCell(label);
	             	   label = new Label(z+9, i+4, "", wcfYellow);
	             	   excelSheet.addCell(label);
	            	   label = new Label(z+10, i+4, "", wcfBorder);
	            	   excelSheet.addCell(label);
	               	   label = new Label(z+11, i+4, "", wcfRed);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+12, i+4, "", wcfCyan);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+13, i+4, "", wcfGray);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+14, i+4, "", wcfDarkGreen);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+15, i+4, "", wcfBlack);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+16, i+4, "", wcfViolet);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+17, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+18, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+19, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+20, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+21, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+22, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+23, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+24, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+25, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+26, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               }
                z += 3;
            } 
        }   
	}
	 
	/**
	 * 
	 * @param sh
	 * @param wcfBorder
	 * @param wcfRed
	 * @param wcfCyan
	 * @param wcfGray
	 * @param wcfOrange
	 * @throws RowsExceededException
	 * @throws WriteException
	 */
    private static void setDays(WritableSheet sh, WritableCellFormat wcfBorder, 
    							WritableCellFormat wcfRed, WritableCellFormat wcfCyan, WritableCellFormat wcfGray,
    							WritableCellFormat wcfDarkGreen, WritableCellFormat wcfBlack, WritableCellFormat wcfViolet,
    							WritableCellFormat wcfOrange, WritableCellFormat wcfYellow) throws RowsExceededException, WriteException {
	        Number number = null;
	        Label label = null;
	        int y = 0;
	        int week = 1;
	        int weekCounter = 1;
	        for(int x=1;x<=31;x++) {
	             number = new Number(y+4, 2, x, wcfBorder);
	             label = new Label(y+5, 2, "", wcfBorder);
	             sh.addCell(number);
	             sh.addCell(label);
	             label = new Label(y+6, 2, "", wcfBorder);
	             sh.addCell(label);
	             if (x == 7 || x == 14 || x == 21 || x == 28) {
	            	 switch(x) {
		            	 case 7: weekCounter = 1; break;
		            	 case 14: weekCounter = 2; break;
		            	 case 21: weekCounter = 3; break;
		            	 case 28: weekCounter = 4; break;
		            	 default: break;
	            	 }
	            	 label = new Label(y+7, 2, "GPS Trips Week " + week, wcfOrange);
	            	 sh.addCell(label);
	            	 label = new Label(y+8, 2, "Qty/Week" + weekCounter + " (ltrs)", wcfYellow);
	            	 sh.addCell(label);
	            	 label = new Label(y+9, 2, "Availability", wcfOrange);
	            	 sh.addCell(label);
	            	 label = new Label(y+10, 2, "Percentage", wcfOrange);
	            	 sh.addCell(label);
	            	 y += 4;
	            	 week += 1;
	             }
	             if (x == 31) {
		             label = new Label(y+7, 2, "GPS Trips Week 5", wcfOrange);
		             sh.addCell(label);
	            	 label = new Label(y+8, 2, "Qty/Week5 (ltrs)", wcfYellow);
	            	 sh.addCell(label);
	            	 label = new Label(y+9, 2, "Qty/Month (ltrs)", wcfYellow);
	            	 sh.addCell(label);
		             label = new Label(y+10, 2, "", wcfBorder);
		             sh.addCell(label);
		             label = new Label(y+11, 2, "Breakdown", wcfRed);
		             sh.addCell(label); 
		             label = new Label(y+12, 2, "PM", wcfCyan);
		             sh.addCell(label); 
		             label = new Label(y+13, 2, "Pending", wcfGray);
		             sh.addCell(label); 
		             label = new Label(y+14, 2, "Target Date", wcfDarkGreen);
		             sh.addCell(label); 
		             label = new Label(y+15, 2, "Extended", wcfBlack);
		             sh.addCell(label); 
		             label = new Label(y+16, 2, "Early Done", wcfViolet);
		             sh.addCell(label); 
		             label = new Label(y+17, 2, "GPS Trips/Month", wcfOrange);
		             sh.addCell(label); 
		             label = new Label(y+18, 2, "Percentage", wcfOrange);
		             sh.addCell(label); 
		             label = new Label(y+19, 2, "GPS Trip Terminal Issue (TI)", wcfOrange);
		             sh.addCell(label);
		             label = new Label(y+20, 2, "GPS Trip Maintenance Issue (MI)", wcfOrange);
		             sh.addCell(label);
		             label = new Label(y+21, 2, "GPS Trip Driver Issue (DI)", wcfOrange);
		             sh.addCell(label);
		             label = new Label(y+22, 2, "GPS Trip Customer Issue (CI)", wcfOrange);
		             sh.addCell(label);
		             label = new Label(y+23, 2, "GPS Trip Low Volume (LV)", wcfOrange);
		             sh.addCell(label);
		             label = new Label(y+24, 2, "GPS Trip Long Haul (LH)", wcfOrange);
		             sh.addCell(label);
		             label = new Label(y+25, 2, "GPS Trip Truck Ban Issue (TBI)", wcfOrange);
		             sh.addCell(label);
		             label = new Label(y+26, 2, "GPS Trip Road Issue (RI)", wcfOrange);
		             sh.addCell(label);
	             }
	             y += 3;
	        }
    }

   
    /**
     * 
     * @param sh
     * @param wcfBorder
     * @param wcfRed
     * @param wcfCyan
     * @param wcfGray
     * @param wcfOrange
     * @param wcfYellow
     * @throws RowsExceededException
     * @throws WriteException
     */
    private static void setHeaders(WritableSheet sh, WritableCellFormat wcfBorder, 
    							WritableCellFormat wcfRed, WritableCellFormat wcfCyan, WritableCellFormat wcfGray,
    							WritableCellFormat wcfDarkGreen, WritableCellFormat wcfBlack, WritableCellFormat wcfViolet,
    							WritableCellFormat wcfOrange, WritableCellFormat wcfYellow) throws RowsExceededException, WriteException {
	        Label label = new Label(0, 3, "Trailer Plate No", wcfBorder);
	        sh.addCell(label);
	        label = new Label(1, 3, "Tractor Plate No", wcfBorder);
	        sh.addCell(label);
	        label = new Label(2, 3, "Lorry No", wcfBorder);
	        sh.addCell(label);
	        label = new Label(3, 3, "(kl)", wcfBorder);
	        sh.addCell(label);
	        
	        int y = 0;
	        for(int x=1;x<=31;x++) {
	             label = new Label(y+4, 3, "IDLE", wcfBorder);
	             sh.addCell(label);
	             label = new Label(y+5, 3, "", wcfBorder);
	             sh.addCell(label);
	             label = new Label(y+6, 3, "Qty (ltrs)", wcfBorder);
	             sh.addCell(label);
	             if (x == 7 || x == 14 || x == 21 || x == 28) {
	            	 label = new Label(y+7, 3, "", wcfOrange);
	            	 sh.addCell(label);
	            	 label = new Label(y+8, 3, "", wcfYellow);
	            	 sh.addCell(label);
	            	 label = new Label(y+9, 3, "", wcfOrange);
	            	 sh.addCell(label);
	            	 label = new Label(y+10, 3, "", wcfOrange);
	            	 sh.addCell(label);
	            	 y += 4;
	             }
	             if (x == 31) {
	            	 label = new Label(y+7, 3, "", wcfOrange);
		             sh.addCell(label);
	            	 label = new Label(y+8, 3, "", wcfYellow);
		             sh.addCell(label);
	            	 label = new Label(y+9, 3, "", wcfYellow);
		             sh.addCell(label);
		             label = new Label(y+10, 3, "Total", wcfBorder);
		             sh.addCell(label); 
		             label = new Label(y+11, 3, "", wcfRed);
		             sh.addCell(label); 
		             label = new Label(y+12, 3, "", wcfCyan);
		             sh.addCell(label); 
		             label = new Label(y+13, 3, "", wcfGray);
		             sh.addCell(label); 
		             label = new Label(y+14, 3, "", wcfDarkGreen);
		             sh.addCell(label); 
		             label = new Label(y+15, 3, "", wcfBlack);
		             sh.addCell(label); 
		             label = new Label(y+16, 3, "", wcfViolet);
		             sh.addCell(label); 
		             label = new Label(y+17, 3, "", wcfOrange);
		             sh.addCell(label); 
		             label = new Label(y+18, 3, "", wcfOrange);
		             sh.addCell(label); 
		             label = new Label(y+19, 3, "", wcfOrange);
		             sh.addCell(label); 
		             label = new Label(y+20, 3, "", wcfOrange);
		             sh.addCell(label); 
		             label = new Label(y+21, 3, "", wcfOrange);
		             sh.addCell(label); 
		             label = new Label(y+22, 3, "", wcfOrange);
		             sh.addCell(label); 
		             label = new Label(y+23, 3, "", wcfOrange);
		             sh.addCell(label); 
		             label = new Label(y+24, 3, "", wcfOrange);
		             sh.addCell(label); 
		             label = new Label(y+25, 3, "", wcfOrange);
		             sh.addCell(label); 
		             label = new Label(y+26, 3, "", wcfOrange);
		             sh.addCell(label); 
	             }
	             y += 3;
	        }
    }
    
    /**
     * 
     * @param counter
     * @param item
     * @return
     */
    private static Colour getGPScolor(int counter, MaintenanceMonitoring item) {
    	int val = 0;
    	Colour color = null;
    	switch(counter){
    		case 1: val = item.getGpsColor1() > 0 ?  item.getGpsColor1() : 0; break;
    		case 2: val = item.getGpsColor2() > 0 ?  item.getGpsColor2() : 0; break;
    		case 3: val = item.getGpsColor3() > 0 ?  item.getGpsColor3() : 0; break;
    		case 4: val = item.getGpsColor4() > 0 ?  item.getGpsColor4() : 0; break;
    		case 5: val = item.getGpsColor5() > 0 ?  item.getGpsColor5() : 0; break;
    		case 6: val = item.getGpsColor6() > 0 ?  item.getGpsColor6() : 0; break;
    		case 7: val = item.getGpsColor7() > 0 ?  item.getGpsColor7() : 0; break;
    		case 8: val = item.getGpsColor8() > 0 ?  item.getGpsColor8() : 0; break;
    		case 9: val = item.getGpsColor9() > 0 ?  item.getGpsColor9() : 0; break;
    		case 10: val = item.getGpsColor10() > 0 ?  item.getGpsColor10() : 0; break;
    		case 11: val = item.getGpsColor11() > 0 ?  item.getGpsColor11() : 0; break;
    		case 12: val = item.getGpsColor12() > 0 ?  item.getGpsColor12() : 0; break;
    		case 13: val = item.getGpsColor13() > 0 ?  item.getGpsColor13() : 0; break;
    		case 14: val = item.getGpsColor14() > 0 ?  item.getGpsColor14() : 0; break;
    		case 15: val = item.getGpsColor15() > 0 ?  item.getGpsColor15() : 0; break;
    		case 16: val = item.getGpsColor16() > 0 ?  item.getGpsColor16() : 0; break;
    		case 17: val = item.getGpsColor17() > 0 ?  item.getGpsColor17() : 0; break;
    		case 18: val = item.getGpsColor18() > 0 ?  item.getGpsColor18() : 0; break;
    		case 19: val = item.getGpsColor19() > 0 ?  item.getGpsColor19() : 0; break;
    		case 20: val = item.getGpsColor20() > 0 ?  item.getGpsColor20() : 0; break;
    		case 21: val = item.getGpsColor21() > 0 ?  item.getGpsColor21() : 0; break;
    		case 22: val = item.getGpsColor22() > 0 ?  item.getGpsColor22() : 0; break;
    		case 23: val = item.getGpsColor23() > 0 ?  item.getGpsColor23() : 0; break;
    		case 24: val = item.getGpsColor24() > 0 ?  item.getGpsColor24() : 0; break;
    		case 25: val = item.getGpsColor25() > 0 ?  item.getGpsColor25() : 0; break;
    		case 26: val = item.getGpsColor26() > 0 ?  item.getGpsColor26() : 0; break;
    		case 27: val = item.getGpsColor27() > 0 ?  item.getGpsColor27() : 0; break;
    		case 28: val = item.getGpsColor28() > 0 ?  item.getGpsColor28() : 0; break;
    		case 29: val = item.getGpsColor29() > 0 ?  item.getGpsColor29() : 0; break;
    		case 30: val = item.getGpsColor30() > 0 ?  item.getGpsColor30() : 0; break;
    		case 31: val = item.getGpsColor31() > 0 ?  item.getGpsColor31() : 0; break;
    		default: break;
    	}
    	
    	switch(val) {
    		case 1201: color = Colour.LIGHT_ORANGE; break; //Note: Orange color in JSP
    		case 1202: color = Colour.GREEN; break;
    		case 1203: color = Colour.GRAY_25; break;
    		case 1204: color = Colour.LIGHT_GREEN; break; //Pale Green color in JSP
    		default: color = Colour.UNKNOWN;
    	}
    	
    	return color;
    }

    /**
     * 
     * @param counter
     * @param item
     * @return
     */
    private static String getGPS(int counter, MaintenanceMonitoring item) {
    	String val = ""; //label can return "", comment cannot
    	switch(counter){
	    	case 1: val = item.getGps1() != null ? item.getGps1() : ""; break;
			case 2: val = item.getGps2() != null ? item.getGps2() : ""; break;
			case 3: val = item.getGps3() != null ? item.getGps3() : ""; break;
			case 4: val = item.getGps4() != null ? item.getGps4() : ""; break;
			case 5: val = item.getGps5() != null ? item.getGps5() : ""; break;
			case 6: val = item.getGps6() != null ? item.getGps6() : ""; break;
			case 7: val = item.getGps7() != null ? item.getGps7() : ""; break;
			case 8: val = item.getGps8() != null ? item.getGps8() : ""; break;
			case 9: val = item.getGps9() != null ? item.getGps9() : ""; break;
			case 10: val = item.getGps10() != null ? item.getGps10() : ""; break;
			case 11: val = item.getGps11() != null ? item.getGps11() : ""; break;
			case 12: val = item.getGps12() != null ? item.getGps12() : ""; break;
			case 13: val = item.getGps13() != null ? item.getGps13() : ""; break;
			case 14: val = item.getGps14() != null ? item.getGps14() : ""; break;
			case 15: val = item.getGps15() != null ? item.getGps15() : ""; break;
			case 16: val = item.getGps16() != null ? item.getGps16() : ""; break;
			case 17: val = item.getGps17() != null ? item.getGps17() : ""; break;
			case 18: val = item.getGps18() != null ? item.getGps18() : ""; break;
			case 19: val = item.getGps19() != null ? item.getGps19() : ""; break;
			case 20: val = item.getGps20() != null ? item.getGps20() : ""; break;
			case 21: val = item.getGps21() != null ? item.getGps21() : ""; break;
			case 22: val = item.getGps22() != null ? item.getGps22() : ""; break;
			case 23: val = item.getGps23() != null ? item.getGps23() : ""; break;
			case 24: val = item.getGps24() != null ? item.getGps24() : ""; break;
			case 25: val = item.getGps25() != null ? item.getGps25() : ""; break;
			case 26: val = item.getGps26() != null ? item.getGps26() : ""; break;
			case 27: val = item.getGps27() != null ? item.getGps27() : ""; break;
			case 28: val = item.getGps28() != null ? item.getGps28() : ""; break;
			case 29: val = item.getGps29() != null ? item.getGps29() : ""; break;
			case 30: val = item.getGps30() != null ? item.getGps30() : ""; break;
			case 31: val = item.getGps31() != null ? item.getGps31() : ""; break;
    		default: break;
    	}
    	return val;
    }

    
    /**
     *  Note: Trip Issue is included in the comment with the Remarks
     * @param counter
     * @param item
     * @return
     */
    private static String getGPSremarks(int counter, MaintenanceMonitoring item) {
    	StringBuilder val = new StringBuilder(100); //label can return "", comment cannot
    	switch(counter){
    		case 1: val.append(item.getGpsRemarks1() !=null ? item.getGpsRemarks1() : ""); break;
    		case 2: val.append(item.getGpsRemarks2() !=null ? item.getGpsRemarks2() : ""); break;
    		case 3: val.append(item.getGpsRemarks3() !=null ? item.getGpsRemarks3() : ""); break;
    		case 4: val.append(item.getGpsRemarks4() !=null ? item.getGpsRemarks4() : ""); break;
    		case 5: val.append(item.getGpsRemarks5() !=null ? item.getGpsRemarks5() : ""); break;
    		case 6: val.append(item.getGpsRemarks6() !=null ? item.getGpsRemarks6() : ""); break;
    		case 7: val.append(item.getGpsRemarks7() !=null ? item.getGpsRemarks7() : ""); break;
    		case 8: val.append(item.getGpsRemarks8() !=null ? item.getGpsRemarks8() : ""); break;
    		case 9: val.append(item.getGpsRemarks9() !=null ? item.getGpsRemarks9() : ""); break;
    		case 10: val.append(item.getGpsRemarks10() !=null ? item.getGpsRemarks10() : ""); break;
    		case 11: val.append(item.getGpsRemarks11() !=null ? item.getGpsRemarks11() : ""); break;
    		case 12: val.append(item.getGpsRemarks12() !=null ? item.getGpsRemarks12() : ""); break;
    		case 13: val.append(item.getGpsRemarks13() !=null ? item.getGpsRemarks13() : ""); break;
    		case 14: val.append(item.getGpsRemarks14() !=null ? item.getGpsRemarks14() : ""); break;
    		case 15: val.append(item.getGpsRemarks15() !=null ? item.getGpsRemarks15() : ""); break;
    		case 16: val.append(item.getGpsRemarks16() !=null ? item.getGpsRemarks16() : ""); break;
    		case 17: val.append(item.getGpsRemarks17() !=null ? item.getGpsRemarks17() : ""); break;
    		case 18: val.append(item.getGpsRemarks18() !=null ? item.getGpsRemarks18() : ""); break;
    		case 19: val.append(item.getGpsRemarks19() !=null ? item.getGpsRemarks19() : ""); break;
    		case 20: val.append(item.getGpsRemarks20() !=null ? item.getGpsRemarks20() : ""); break;
    		case 21: val.append(item.getGpsRemarks21() !=null ? item.getGpsRemarks21() : ""); break;
    		case 22: val.append(item.getGpsRemarks22() !=null ? item.getGpsRemarks22() : ""); break;
    		case 23: val.append(item.getGpsRemarks23() !=null ? item.getGpsRemarks23() : ""); break;
    		case 24: val.append(item.getGpsRemarks24() !=null ? item.getGpsRemarks24() : ""); break;
    		case 25: val.append(item.getGpsRemarks25() !=null ? item.getGpsRemarks25() : ""); break;
    		case 26: val.append(item.getGpsRemarks26() !=null ? item.getGpsRemarks26() : ""); break;
    		case 27: val.append(item.getGpsRemarks27() !=null ? item.getGpsRemarks27() : ""); break;
    		case 28: val.append(item.getGpsRemarks28() !=null ? item.getGpsRemarks28() : ""); break;
    		case 29: val.append(item.getGpsRemarks29() !=null ? item.getGpsRemarks29() : ""); break;
    		case 30: val.append(item.getGpsRemarks30() !=null ? item.getGpsRemarks30() : ""); break;
    		case 31: val.append(item.getGpsRemarks31() !=null ? item.getGpsRemarks31() : ""); break;
    		default: break;
    	}
    	//include Trip Issue - append
    	switch(counter){
			case 1: if (item.getGpsTripIssue1() > 0)  {
						val.append(" - Trip Issue: ");
						val.append(TransportUtils.getGPSTripIssueCategoryById(item.getGpsTripIssue1()));
					}
					break;
			case 2: if (item.getGpsTripIssue2() > 0)  {
						val.append(" - Trip Issue: ");
						val.append(TransportUtils.getGPSTripIssueCategoryById(item.getGpsTripIssue2()));
					}	
					break; 
			case 3: if (item.getGpsTripIssue3() > 0)  {
						val.append(" - Trip Issue: ");
						val.append(TransportUtils.getGPSTripIssueCategoryById(item.getGpsTripIssue3()));
					}	
					break; 
			case 4: if (item.getGpsTripIssue4() > 0)  {
						val.append(" - Trip Issue: ");
						val.append(TransportUtils.getGPSTripIssueCategoryById(item.getGpsTripIssue4()));
					}	
					break;
			case 5: if (item.getGpsTripIssue5() > 0)  {
						val.append(" - Trip Issue: ");
						val.append(TransportUtils.getGPSTripIssueCategoryById(item.getGpsTripIssue5()));
					}	
					break;
			case 6: if (item.getGpsTripIssue6() > 0)  {
						val.append(" - Trip Issue: ");
						val.append(TransportUtils.getGPSTripIssueCategoryById(item.getGpsTripIssue6()));
					}	
					break;
			case 7: if (item.getGpsTripIssue7() > 0)  {
						val.append(" - Trip Issue: ");
						val.append(TransportUtils.getGPSTripIssueCategoryById(item.getGpsTripIssue7()));
					}	
					break;
			case 8: if (item.getGpsTripIssue8() > 0)  {
						val.append(" - Trip Issue: ");
						val.append(TransportUtils.getGPSTripIssueCategoryById(item.getGpsTripIssue8()));
					}	
					break;
			case 9: if (item.getGpsTripIssue9() > 0)  {
						val.append(" - Trip Issue: ");
						val.append(TransportUtils.getGPSTripIssueCategoryById(item.getGpsTripIssue9()));
					}	
					break;
			case 10: if (item.getGpsTripIssue10() > 0)  {
						val.append(" - Trip Issue: ");
						val.append(TransportUtils.getGPSTripIssueCategoryById(item.getGpsTripIssue10()));
					}	
					break; 
			case 11: if (item.getGpsTripIssue11() > 0)  {
						val.append(" - Trip Issue: ");
						val.append(TransportUtils.getGPSTripIssueCategoryById(item.getGpsTripIssue11()));
					}	
					break;
			case 12: if (item.getGpsTripIssue12() > 0)  {
						val.append(" - Trip Issue: ");
						val.append(TransportUtils.getGPSTripIssueCategoryById(item.getGpsTripIssue12()));
					}	
					break;
			case 13: if (item.getGpsTripIssue13() > 0)  {
						val.append(" - Trip Issue: ");
						val.append(TransportUtils.getGPSTripIssueCategoryById(item.getGpsTripIssue13()));
					}	
					break;
			case 14: if (item.getGpsTripIssue14() > 0)  {
						val.append(" - Trip Issue: ");
						val.append(TransportUtils.getGPSTripIssueCategoryById(item.getGpsTripIssue14()));
					}	
					break; 
			case 15: if (item.getGpsTripIssue15() > 0)  {
						val.append(" - Trip Issue: ");
						val.append(TransportUtils.getGPSTripIssueCategoryById(item.getGpsTripIssue15()));
					}	
					break;  
			case 16: if (item.getGpsTripIssue16() > 0)  {
						val.append(" - Trip Issue: ");
						val.append(TransportUtils.getGPSTripIssueCategoryById(item.getGpsTripIssue16()));
					}	
					break;  
			case 17: if (item.getGpsTripIssue17() > 0)  {
						val.append(" - Trip Issue: ");
						val.append(TransportUtils.getGPSTripIssueCategoryById(item.getGpsTripIssue17()));
					}	
					break;  
			case 18: if (item.getGpsTripIssue18() > 0)  {
						val.append(" - Trip Issue: ");
						val.append(TransportUtils.getGPSTripIssueCategoryById(item.getGpsTripIssue18()));
					}	
					break; 
			case 19: if (item.getGpsTripIssue19() > 0)  {
						val.append(" - Trip Issue: ");
						val.append(TransportUtils.getGPSTripIssueCategoryById(item.getGpsTripIssue19()));
					}	
					break;
			case 20: if (item.getGpsTripIssue20() > 0)  {
						val.append(" - Trip Issue: ");
						val.append(TransportUtils.getGPSTripIssueCategoryById(item.getGpsTripIssue20()));
					}	
					break; 
			case 21: if (item.getGpsTripIssue21() > 0)  {
						val.append(" - Trip Issue: ");
						val.append(TransportUtils.getGPSTripIssueCategoryById(item.getGpsTripIssue21()));
					}	
					break;  
			case 22: if (item.getGpsTripIssue22() > 0)  {
						val.append(" - Trip Issue: ");
						val.append(TransportUtils.getGPSTripIssueCategoryById(item.getGpsTripIssue22()));
					}	
					break; 
			case 23: if (item.getGpsTripIssue23() > 0)  {
						val.append(" - Trip Issue: ");
						val.append(TransportUtils.getGPSTripIssueCategoryById(item.getGpsTripIssue23()));
					}	
					break; 
			case 24: if (item.getGpsTripIssue24() > 0)  {
						val.append(" - Trip Issue: ");
						val.append(TransportUtils.getGPSTripIssueCategoryById(item.getGpsTripIssue24()));
					}	
					break; 
			case 25: if (item.getGpsTripIssue25() > 0)  {
						val.append(" - Trip Issue: ");
						val.append(TransportUtils.getGPSTripIssueCategoryById(item.getGpsTripIssue25()));
					}	
					break;  
			case 26: if (item.getGpsTripIssue26() > 0)  {
						val.append(" - Trip Issue: ");
						val.append(TransportUtils.getGPSTripIssueCategoryById(item.getGpsTripIssue26()));
					}	
					break; 
			case 27: if (item.getGpsTripIssue27() > 0)  {
						val.append(" - Trip Issue: ");
						val.append(TransportUtils.getGPSTripIssueCategoryById(item.getGpsTripIssue27()));
					}	
					break; 
			case 28: if (item.getGpsTripIssue28() > 0)  {
						val.append(" - Trip Issue: ");
						val.append(TransportUtils.getGPSTripIssueCategoryById(item.getGpsTripIssue28()));
					}	
					break; 
			case 29: if (item.getGpsTripIssue29() > 0)  {
						val.append(" - Trip Issue: ");
						val.append(TransportUtils.getGPSTripIssueCategoryById(item.getGpsTripIssue29()));
					}	
					break; 
			case 30: if (item.getGpsTripIssue30() > 0)  {
						val.append(" - Trip Issue: ");
						val.append(TransportUtils.getGPSTripIssueCategoryById(item.getGpsTripIssue30()));
					}	
					break;
			case 31: if (item.getGpsTripIssue31() > 0)  {
						val.append(" - Trip Issue: ");
						val.append(TransportUtils.getGPSTripIssueCategoryById(item.getGpsTripIssue31()));
					}	
					break;
			default: break;
		}	
    	return val.toString();
    }
  
    /**
     * 
     * @param counter
     * @param item
     * @return
     */
    private static Colour getMaintenanceColor(int counter, MaintenanceMonitoring item) {
    	int val = 0;
    	Colour color = null;
    	switch(counter){
			case 1: val = item.getMaintenanceColor1() > 0 ?  item.getMaintenanceColor1() : 0; break;
			case 2: val = item.getMaintenanceColor2() > 0 ?  item.getMaintenanceColor2() : 0; break;
			case 3: val = item.getMaintenanceColor3() > 0 ?  item.getMaintenanceColor3() : 0; break;
			case 4: val = item.getMaintenanceColor4() > 0 ?  item.getMaintenanceColor4() : 0; break;
			case 5: val = item.getMaintenanceColor5() > 0 ?  item.getMaintenanceColor5() : 0; break;
			case 6: val = item.getMaintenanceColor6() > 0 ?  item.getMaintenanceColor6() : 0; break;
			case 7: val = item.getMaintenanceColor7() > 0 ?  item.getMaintenanceColor7() : 0; break;
			case 8: val = item.getMaintenanceColor8() > 0 ?  item.getMaintenanceColor8() : 0; break;
			case 9: val = item.getMaintenanceColor9() > 0 ?  item.getMaintenanceColor9() : 0; break;
			case 10: val = item.getMaintenanceColor10() > 0 ?  item.getMaintenanceColor10() : 0; break;
			case 11: val = item.getMaintenanceColor11() > 0 ?  item.getMaintenanceColor11() : 0; break;
			case 12: val = item.getMaintenanceColor12() > 0 ?  item.getMaintenanceColor12() : 0; break;
			case 13: val = item.getMaintenanceColor13() > 0 ?  item.getMaintenanceColor13() : 0; break;
			case 14: val = item.getMaintenanceColor14() > 0 ?  item.getMaintenanceColor14() : 0; break;
			case 15: val = item.getMaintenanceColor15() > 0 ?  item.getMaintenanceColor15() : 0; break;
			case 16: val = item.getMaintenanceColor16() > 0 ?  item.getMaintenanceColor16() : 0; break;
			case 17: val = item.getMaintenanceColor17() > 0 ?  item.getMaintenanceColor17() : 0; break;
			case 18: val = item.getMaintenanceColor18() > 0 ?  item.getMaintenanceColor18() : 0; break;
			case 19: val = item.getMaintenanceColor19() > 0 ?  item.getMaintenanceColor19() : 0; break;
			case 20: val = item.getMaintenanceColor20() > 0 ?  item.getMaintenanceColor20() : 0; break;
			case 21: val = item.getMaintenanceColor21() > 0 ?  item.getMaintenanceColor21() : 0; break;
			case 22: val = item.getMaintenanceColor22() > 0 ?  item.getMaintenanceColor22() : 0; break;
			case 23: val = item.getMaintenanceColor23() > 0 ?  item.getMaintenanceColor23() : 0; break;
			case 24: val = item.getMaintenanceColor24() > 0 ?  item.getMaintenanceColor24() : 0; break;
			case 25: val = item.getMaintenanceColor25() > 0 ?  item.getMaintenanceColor25() : 0; break;
			case 26: val = item.getMaintenanceColor26() > 0 ?  item.getMaintenanceColor26() : 0; break;
			case 27: val = item.getMaintenanceColor27() > 0 ?  item.getMaintenanceColor27() : 0; break;
			case 28: val = item.getMaintenanceColor28() > 0 ?  item.getMaintenanceColor28() : 0; break;
			case 29: val = item.getMaintenanceColor29() > 0 ?  item.getMaintenanceColor29() : 0; break;
			case 30: val = item.getMaintenanceColor30() > 0 ?  item.getMaintenanceColor30() : 0; break;
			case 31: val = item.getMaintenanceColor31() > 0 ?  item.getMaintenanceColor31() : 0; break;
    		default: break;
    	}
    	
    	switch(val) {
			case 1101: color = Colour.RED; break;
			case 1102: color = Colour.DARK_GREEN; break;
			case 1103: color = Colour.DEFAULT_BACKGROUND; break; //for BLACK - Colour.Black not working
			case 1104: color = Colour.VIOLET; break;
			case 1105: color = Colour.GRAY_25; break;
			case 1106: color = Colour.TURQUOISE; break; //CYAN
			default: color = Colour.UNKNOWN;
    	}
        	
    	return color;
    }   
 
    /**
     * 
     * @param counter
     * @param item
     * @return
     */
    private static String getMaintenance(int counter, MaintenanceMonitoring item) {
    	String val = ""; //label can return "", comment cannot
    	switch(counter){
			case 1: val = item.getMaintenance1() != null ? item.getMaintenance1() : ""; break;
			case 2: val = item.getMaintenance2() != null ? item.getMaintenance2() : ""; break;
			case 3: val = item.getMaintenance3() != null ? item.getMaintenance3() : ""; break;
			case 4: val = item.getMaintenance4() != null ? item.getMaintenance4() : ""; break;
			case 5: val = item.getMaintenance5() != null ? item.getMaintenance5() : ""; break;
			case 6: val = item.getMaintenance6() != null ? item.getMaintenance6() : ""; break;
			case 7: val = item.getMaintenance7() != null ? item.getMaintenance7() : ""; break;
			case 8: val = item.getMaintenance8() != null ? item.getMaintenance8() : ""; break;
			case 9: val = item.getMaintenance9() != null ? item.getMaintenance9() : ""; break;
			case 10: val = item.getMaintenance10() != null ? item.getMaintenance10() : ""; break;
			case 11: val = item.getMaintenance11() != null ? item.getMaintenance11() : ""; break;
			case 12: val = item.getMaintenance12() != null ? item.getMaintenance12() : ""; break;
			case 13: val = item.getMaintenance13() != null ? item.getMaintenance13() : ""; break;
			case 14: val = item.getMaintenance14() != null ? item.getMaintenance14() : ""; break;
			case 15: val = item.getMaintenance15() != null ? item.getMaintenance15() : ""; break;
			case 16: val = item.getMaintenance16() != null ? item.getMaintenance16() : ""; break;
			case 17: val = item.getMaintenance17() != null ? item.getMaintenance17() : ""; break;
			case 18: val = item.getMaintenance18() != null ? item.getMaintenance18() : ""; break;
			case 19: val = item.getMaintenance19() != null ? item.getMaintenance19() : ""; break;
			case 20: val = item.getMaintenance20() != null ? item.getMaintenance20() : ""; break;
			case 21: val = item.getMaintenance21() != null ? item.getMaintenance21() : ""; break;
			case 22: val = item.getMaintenance22() != null ? item.getMaintenance22() : ""; break;
			case 23: val = item.getMaintenance23() != null ? item.getMaintenance23() : ""; break;
			case 24: val = item.getMaintenance24() != null ? item.getMaintenance24() : ""; break;
			case 25: val = item.getMaintenance25() != null ? item.getMaintenance25() : ""; break;
			case 26: val = item.getMaintenance26() != null ? item.getMaintenance26() : ""; break;
			case 27: val = item.getMaintenance27() != null ? item.getMaintenance27() : ""; break;
			case 28: val = item.getMaintenance28() != null ? item.getMaintenance28() : ""; break;
			case 29: val = item.getMaintenance29() != null ? item.getMaintenance29() : ""; break;
			case 30: val = item.getMaintenance30() != null ? item.getMaintenance30() : ""; break;
			case 31: val = item.getMaintenance31() != null ? item.getMaintenance31() : ""; break;
    		default: break;
    	}
    	return val;
    }
  
    /**
     * 
     * @param counter
     * @param item
     * @return
     */
    private static String getMaintenanceRemarks(int counter, MaintenanceMonitoring item) {
    	String val = null; //label can return "", comment cannot
    	switch(counter){
			case 1: val = item.getMaintenanceRemarks1() != null ? item.getMaintenanceRemarks1() : null; break;
			case 2: val = item.getMaintenanceRemarks2() != null ? item.getMaintenanceRemarks2() : null; break;
			case 3: val = item.getMaintenanceRemarks3() != null ? item.getMaintenanceRemarks3() : null; break;
			case 4: val = item.getMaintenanceRemarks4() != null ? item.getMaintenanceRemarks4() : null; break;
			case 5: val = item.getMaintenanceRemarks5() != null ? item.getMaintenanceRemarks5() : null; break;
			case 6: val = item.getMaintenanceRemarks6() != null ? item.getMaintenanceRemarks6() : null; break;
			case 7: val = item.getMaintenanceRemarks7() != null ? item.getMaintenanceRemarks7() : null; break;
			case 8: val = item.getMaintenanceRemarks8() != null ? item.getMaintenanceRemarks8() : null; break;
			case 9: val = item.getMaintenanceRemarks9() != null ? item.getMaintenanceRemarks9() : null; break;
			case 10: val = item.getMaintenanceRemarks10() != null ? item.getMaintenanceRemarks10() : null; break;
			case 11: val = item.getMaintenanceRemarks11() != null ? item.getMaintenanceRemarks11() : null; break;
			case 12: val = item.getMaintenanceRemarks12() != null ? item.getMaintenanceRemarks12() : null; break;
			case 13: val = item.getMaintenanceRemarks13() != null ? item.getMaintenanceRemarks13() : null; break;
			case 14: val = item.getMaintenanceRemarks14() != null ? item.getMaintenanceRemarks14() : null; break;
			case 15: val = item.getMaintenanceRemarks15() != null ? item.getMaintenanceRemarks15() : null; break;
			case 16: val = item.getMaintenanceRemarks16() != null ? item.getMaintenanceRemarks16() : null; break;
			case 17: val = item.getMaintenanceRemarks17() != null ? item.getMaintenanceRemarks17() : null; break;
			case 18: val = item.getMaintenanceRemarks18() != null ? item.getMaintenanceRemarks18() : null; break;
			case 19: val = item.getMaintenanceRemarks19() != null ? item.getMaintenanceRemarks19() : null; break;
			case 20: val = item.getMaintenanceRemarks20() != null ? item.getMaintenanceRemarks20() : null; break;
			case 21: val = item.getMaintenanceRemarks21() != null ? item.getMaintenanceRemarks21() : null; break;
			case 22: val = item.getMaintenanceRemarks22() != null ? item.getMaintenanceRemarks22() : null; break;
			case 23: val = item.getMaintenanceRemarks23() != null ? item.getMaintenanceRemarks23() : null; break;
			case 24: val = item.getMaintenanceRemarks24() != null ? item.getMaintenanceRemarks24() : null; break;
			case 25: val = item.getMaintenanceRemarks25() != null ? item.getMaintenanceRemarks25() : null; break;
			case 26: val = item.getMaintenanceRemarks26() != null ? item.getMaintenanceRemarks26() : null; break;
			case 27: val = item.getMaintenanceRemarks27() != null ? item.getMaintenanceRemarks27() : null; break;
			case 28: val = item.getMaintenanceRemarks28() != null ? item.getMaintenanceRemarks28() : null; break;
			case 29: val = item.getMaintenanceRemarks29() != null ? item.getMaintenanceRemarks29() : null; break;
			case 30: val = item.getMaintenanceRemarks30() != null ? item.getMaintenanceRemarks30() : null; break;
			case 31: val = item.getMaintenanceRemarks31() != null ? item.getMaintenanceRemarks31() : null; break;
    		default: break;
    	}
    	return val;
    }
 
    /**
     * 
     * @param counter
     * @param item
     * @return
     */
    private static String getGPSDailyTotal(int counter, MaintenanceMonitoringFleet item) {
    	int val = 0;
    	switch(counter){
			case 1: val = item.getTotalG1() > 0 ? item.getTotalG1() : 0; break;
			case 2: val = item.getTotalG2() > 0 ? item.getTotalG2() : 0; break;
			case 3: val = item.getTotalG3() > 0 ? item.getTotalG3() : 0; break;
			case 4: val = item.getTotalG4() > 0 ? item.getTotalG4() : 0; break;
			case 5: val = item.getTotalG5() > 0 ? item.getTotalG5() : 0; break;
			case 6: val = item.getTotalG6() > 0 ? item.getTotalG6() : 0; break;
			case 7: val = item.getTotalG7() > 0 ? item.getTotalG7() : 0; break;
			case 8: val = item.getTotalG8() > 0 ? item.getTotalG8() : 0; break;
			case 9: val = item.getTotalG9() > 0 ? item.getTotalG9() : 0; break;
			case 10: val = item.getTotalG10() > 0 ? item.getTotalG10() : 0; break;
			case 11: val = item.getTotalG11() > 0 ? item.getTotalG11() : 0; break;
			case 12: val = item.getTotalG12() > 0 ? item.getTotalG12() : 0; break;
			case 13: val = item.getTotalG13() > 0 ? item.getTotalG13() : 0; break;
			case 14: val = item.getTotalG14() > 0 ? item.getTotalG14() : 0; break;
			case 15: val = item.getTotalG15() > 0 ? item.getTotalG15() : 0; break;
			case 16: val = item.getTotalG16() > 0 ? item.getTotalG16() : 0; break;
			case 17: val = item.getTotalG17() > 0 ? item.getTotalG17() : 0; break;
			case 18: val = item.getTotalG18() > 0 ? item.getTotalG18() : 0; break;
			case 19: val = item.getTotalG19() > 0 ? item.getTotalG19() : 0; break;
			case 20: val = item.getTotalG20() > 0 ? item.getTotalG20() : 0; break;
			case 21: val = item.getTotalG21() > 0 ? item.getTotalG21() : 0; break;
			case 22: val = item.getTotalG22() > 0 ? item.getTotalG22() : 0; break;
			case 23: val = item.getTotalG23() > 0 ? item.getTotalG23() : 0; break;
			case 24: val = item.getTotalG24() > 0 ? item.getTotalG24() : 0; break;
			case 25: val = item.getTotalG25() > 0 ? item.getTotalG25() : 0; break;
			case 26: val = item.getTotalG26() > 0 ? item.getTotalG26() : 0; break;
			case 27: val = item.getTotalG27() > 0 ? item.getTotalG27() : 0; break;
			case 28: val = item.getTotalG28() > 0 ? item.getTotalG28() : 0; break;
			case 29: val = item.getTotalG29() > 0 ? item.getTotalG29() : 0; break;
			case 30: val = item.getTotalG30() > 0 ? item.getTotalG30() : 0; break;
			case 31: val = item.getTotalG31() > 0 ? item.getTotalG31() : 0; break;
    		default: break;
    	}
    	return String.valueOf(val);
    }
    
    /**
     * 
     * @param counter
     * @param item
     * @return
     */
    private static String getFleetAvailability(int counter, MaintenanceMonitoringFleet item) {
    	int val = 0;
    	switch(counter){
			case 1: val = item.getTotalM1() > 0 ? item.getTotalM1() : 0; break;
			case 2: val = item.getTotalM2() > 0 ? item.getTotalM2() : 0; break;
			case 3: val = item.getTotalM3() > 0 ? item.getTotalM3() : 0; break;
			case 4: val = item.getTotalM4() > 0 ? item.getTotalM4() : 0; break;
			case 5: val = item.getTotalM5() > 0 ? item.getTotalM5() : 0; break;
			case 6: val = item.getTotalM6() > 0 ? item.getTotalM6() : 0; break;
			case 7: val = item.getTotalM7() > 0 ? item.getTotalM7() : 0; break;
			case 8: val = item.getTotalM8() > 0 ? item.getTotalM8() : 0; break;
			case 9: val = item.getTotalM9() > 0 ? item.getTotalM9() : 0; break;
			case 10: val = item.getTotalM10() > 0 ? item.getTotalM10() : 0; break;
			case 11: val = item.getTotalM11() > 0 ? item.getTotalM11() : 0; break;
			case 12: val = item.getTotalM12() > 0 ? item.getTotalM12() : 0; break;
			case 13: val = item.getTotalM13() > 0 ? item.getTotalM13() : 0; break;
			case 14: val = item.getTotalM14() > 0 ? item.getTotalM14() : 0; break;
			case 15: val = item.getTotalM15() > 0 ? item.getTotalM15() : 0; break;
			case 16: val = item.getTotalM16() > 0 ? item.getTotalM16() : 0; break;
			case 17: val = item.getTotalM17() > 0 ? item.getTotalM17() : 0; break;
			case 18: val = item.getTotalM18() > 0 ? item.getTotalM18() : 0; break;
			case 19: val = item.getTotalM19() > 0 ? item.getTotalM19() : 0; break;
			case 20: val = item.getTotalM20() > 0 ? item.getTotalM20() : 0; break;
			case 21: val = item.getTotalM21() > 0 ? item.getTotalM21() : 0; break;
			case 22: val = item.getTotalM22() > 0 ? item.getTotalM22() : 0; break;
			case 23: val = item.getTotalM23() > 0 ? item.getTotalM23() : 0; break;
			case 24: val = item.getTotalM24() > 0 ? item.getTotalM24() : 0; break;
			case 25: val = item.getTotalM25() > 0 ? item.getTotalM25() : 0; break;
			case 26: val = item.getTotalM26() > 0 ? item.getTotalM26() : 0; break;
			case 27: val = item.getTotalM27() > 0 ? item.getTotalM27() : 0; break;
			case 28: val = item.getTotalM28() > 0 ? item.getTotalM28() : 0; break;
			case 29: val = item.getTotalM29() > 0 ? item.getTotalM29() : 0; break;
			case 30: val = item.getTotalM30() > 0 ? item.getTotalM30() : 0; break;
			case 31: val = item.getTotalM31() > 0 ? item.getTotalM31() : 0; break;
    		default: break;
    	}
    	return String.valueOf(val);
    }
 
    /**
     * 
     * @param counter
     * @param item
     * @return
     */
    private static String getFleetUnavailable(int counter, MaintenanceMonitoringFleet item) {
    	int val = 0;
    	switch(counter){
	    	case 1: val = item.getTotalU1() > 0 ? item.getTotalU1() : 0; break;
			case 2: val = item.getTotalU2() > 0 ? item.getTotalU2() : 0; break;
			case 3: val = item.getTotalU3() > 0 ? item.getTotalU3() : 0; break;
			case 4: val = item.getTotalU4() > 0 ? item.getTotalU4() : 0; break;
			case 5: val = item.getTotalU5() > 0 ? item.getTotalU5() : 0; break;
			case 6: val = item.getTotalU6() > 0 ? item.getTotalU6() : 0; break;
			case 7: val = item.getTotalU7() > 0 ? item.getTotalU7() : 0; break;
			case 8: val = item.getTotalU8() > 0 ? item.getTotalU8() : 0; break;
			case 9: val = item.getTotalU9() > 0 ? item.getTotalU9() : 0; break;
			case 10: val = item.getTotalU10() > 0 ? item.getTotalU10() : 0; break;
			case 11: val = item.getTotalU11() > 0 ? item.getTotalU11() : 0; break;
			case 12: val = item.getTotalU12() > 0 ? item.getTotalU12() : 0; break;
			case 13: val = item.getTotalU13() > 0 ? item.getTotalU13() : 0; break;
			case 14: val = item.getTotalU14() > 0 ? item.getTotalU14() : 0; break;
			case 15: val = item.getTotalU15() > 0 ? item.getTotalU15() : 0; break;
			case 16: val = item.getTotalU16() > 0 ? item.getTotalU16() : 0; break;
			case 17: val = item.getTotalU17() > 0 ? item.getTotalU17() : 0; break;
			case 18: val = item.getTotalU18() > 0 ? item.getTotalU18() : 0; break;
			case 19: val = item.getTotalU19() > 0 ? item.getTotalU19() : 0; break;
			case 20: val = item.getTotalU20() > 0 ? item.getTotalU20() : 0; break;
			case 21: val = item.getTotalU21() > 0 ? item.getTotalU21() : 0; break;
			case 22: val = item.getTotalU22() > 0 ? item.getTotalU22() : 0; break;
			case 23: val = item.getTotalU23() > 0 ? item.getTotalU23() : 0; break;
			case 24: val = item.getTotalU24() > 0 ? item.getTotalU24() : 0; break;
			case 25: val = item.getTotalU25() > 0 ? item.getTotalU25() : 0; break;
			case 26: val = item.getTotalU26() > 0 ? item.getTotalU26() : 0; break;
			case 27: val = item.getTotalU27() > 0 ? item.getTotalU27() : 0; break;
			case 28: val = item.getTotalU28() > 0 ? item.getTotalU28() : 0; break;
			case 29: val = item.getTotalU29() > 0 ? item.getTotalU29() : 0; break;
			case 30: val = item.getTotalU30() > 0 ? item.getTotalU30() : 0; break;
			case 31: val = item.getTotalU31() > 0 ? item.getTotalU31() : 0; break;
    		default: break;
    	}
    	return String.valueOf(val);
    }
 
    /**
     * 
     * @param counter
     * @param item
     * @return
     */
    private static String getGarage(int counter, MaintenanceMonitoringPreventive item) {
    	String val = "";
    	switch(counter){
	    	case 1: val = item.getPgarage1() != null ? item.getPgarage1() : ""; break;
			case 2: val = item.getPgarage2() != null ? item.getPgarage2() : ""; break;
			case 3: val = item.getPgarage3() != null ? item.getPgarage3() : ""; break;
			case 4: val = item.getPgarage4() != null ? item.getPgarage4() : ""; break;
			case 5: val = item.getPgarage5() != null ? item.getPgarage5() : ""; break;
			case 6: val = item.getPgarage6() != null ? item.getPgarage6() : ""; break;
			case 7: val = item.getPgarage7() != null ? item.getPgarage7() : ""; break;
			case 8: val = item.getPgarage8() != null ? item.getPgarage8() : ""; break;
			case 9: val = item.getPgarage9() != null ? item.getPgarage9() : ""; break;
			case 10: val = item.getPgarage10() != null ? item.getPgarage10() : ""; break;
			case 11: val = item.getPgarage11() != null ? item.getPgarage11() : ""; break;
			case 12: val = item.getPgarage12() != null ? item.getPgarage12() : ""; break;
			case 13: val = item.getPgarage13() != null ? item.getPgarage13() : ""; break;
			case 14: val = item.getPgarage14() != null ? item.getPgarage14() : ""; break;
			case 15: val = item.getPgarage15() != null ? item.getPgarage15() : ""; break;
			case 16: val = item.getPgarage16() != null ? item.getPgarage16() : ""; break;
			case 17: val = item.getPgarage17() != null ? item.getPgarage17() : ""; break;
			case 18: val = item.getPgarage18() != null ? item.getPgarage18() : ""; break;
			case 19: val = item.getPgarage19() != null ? item.getPgarage19() : ""; break;
			case 20: val = item.getPgarage20() != null ? item.getPgarage20() : ""; break;
			case 21: val = item.getPgarage21() != null ? item.getPgarage21() : ""; break;
			case 22: val = item.getPgarage22() != null ? item.getPgarage22() : ""; break;
			case 23: val = item.getPgarage23() != null ? item.getPgarage23() : ""; break;
			case 24: val = item.getPgarage24() != null ? item.getPgarage24() : ""; break;
			case 25: val = item.getPgarage25() != null ? item.getPgarage25() : ""; break;
			case 26: val = item.getPgarage26() != null ? item.getPgarage26() : ""; break;
			case 27: val = item.getPgarage27() != null ? item.getPgarage27() : ""; break;
			case 28: val = item.getPgarage28() != null ? item.getPgarage28() : ""; break;
			case 29: val = item.getPgarage29() != null ? item.getPgarage29() : ""; break;
			case 30: val = item.getPgarage30() != null ? item.getPgarage30() : ""; break;
			case 31: val = item.getPgarage31() != null ? item.getPgarage31() : ""; break;
    		default: break;
    	}
    	return val;
    }
 
    /**
     * 
     * @param counter
     * @param item
     * @return
     */
    private static String getGarageRemarks(int counter, MaintenanceMonitoringPreventive item) {
    	String val = null; //label can return "", comment cannot
    	switch(counter){
			case 1: val = item.getPgarageremarks1() != null ? item.getPgarageremarks1() : null; break;
			case 2: val = item.getPgarageremarks2() != null ? item.getPgarageremarks2() : null; break;
			case 3: val = item.getPgarageremarks3() != null ? item.getPgarageremarks3() : null; break;
			case 4: val = item.getPgarageremarks4() != null ? item.getPgarageremarks4() : null; break;
			case 5: val = item.getPgarageremarks5() != null ? item.getPgarageremarks5() : null; break;
			case 6: val = item.getPgarageremarks6() != null ? item.getPgarageremarks6() : null; break;
			case 7: val = item.getPgarageremarks7() != null ? item.getPgarageremarks7() : null; break;
			case 8: val = item.getPgarageremarks8() != null ? item.getPgarageremarks8() : null; break;
			case 9: val = item.getPgarageremarks9() != null ? item.getPgarageremarks9() : null; break;
			case 10: val = item.getPgarageremarks10() != null ? item.getPgarageremarks10() : null; break;
			case 11: val = item.getPgarageremarks11() != null ? item.getPgarageremarks11() : null; break;
			case 12: val = item.getPgarageremarks12() != null ? item.getPgarageremarks12() : null; break;
			case 13: val = item.getPgarageremarks13() != null ? item.getPgarageremarks13() : null; break;
			case 14: val = item.getPgarageremarks14() != null ? item.getPgarageremarks14() : null; break;
			case 15: val = item.getPgarageremarks15() != null ? item.getPgarageremarks15() : null; break;
			case 16: val = item.getPgarageremarks16() != null ? item.getPgarageremarks16() : null; break;
			case 17: val = item.getPgarageremarks17() != null ? item.getPgarageremarks17() : null; break;
			case 18: val = item.getPgarageremarks18() != null ? item.getPgarageremarks18() : null; break;
			case 19: val = item.getPgarageremarks19() != null ? item.getPgarageremarks19() : null; break;
			case 20: val = item.getPgarageremarks20() != null ? item.getPgarageremarks20() : null; break;
			case 21: val = item.getPgarageremarks21() != null ? item.getPgarageremarks21() : null; break;
			case 22: val = item.getPgarageremarks22() != null ? item.getPgarageremarks22() : null; break;
			case 23: val = item.getPgarageremarks23() != null ? item.getPgarageremarks23() : null; break;
			case 24: val = item.getPgarageremarks24() != null ? item.getPgarageremarks24() : null; break;
			case 25: val = item.getPgarageremarks25() != null ? item.getPgarageremarks25() : null; break;
			case 26: val = item.getPgarageremarks26() != null ? item.getPgarageremarks26() : null; break;
			case 27: val = item.getPgarageremarks27() != null ? item.getPgarageremarks27() : null; break;
			case 28: val = item.getPgarageremarks28() != null ? item.getPgarageremarks28() : null; break;
			case 29: val = item.getPgarageremarks29() != null ? item.getPgarageremarks29() : null; break;
			case 30: val = item.getPgarageremarks30() != null ? item.getPgarageremarks30() : null; break;
			case 31: val = item.getPgarageremarks31() != null ? item.getPgarageremarks31() : null; break;
    		default: break;
    	}
    	return val;
    }
 
    /**
     * 
     * @param counter
     * @param item
     * @return
     */
    private static String getFbase(int counter, MaintenanceMonitoringPreventive item) {
    	String val = "";
    	switch(counter){
	    	case 1: val = item.getPfbase1() != null ? item.getPfbase1() : ""; break;
			case 2: val = item.getPfbase2() != null ? item.getPfbase2() : ""; break;
			case 3: val = item.getPfbase3() != null ? item.getPfbase3() : ""; break;
			case 4: val = item.getPfbase4() != null ? item.getPfbase4() : ""; break;
			case 5: val = item.getPfbase5() != null ? item.getPfbase5() : ""; break;
			case 6: val = item.getPfbase6() != null ? item.getPfbase6() : ""; break;
			case 7: val = item.getPfbase7() != null ? item.getPfbase7() : ""; break;
			case 8: val = item.getPfbase8() != null ? item.getPfbase8() : ""; break;
			case 9: val = item.getPfbase9() != null ? item.getPfbase9() : ""; break;
			case 10: val = item.getPfbase10() != null ? item.getPfbase10() : ""; break;
			case 11: val = item.getPfbase11() != null ? item.getPfbase11() : ""; break;
			case 12: val = item.getPfbase12() != null ? item.getPfbase12() : ""; break;
			case 13: val = item.getPfbase13() != null ? item.getPfbase13() : ""; break;
			case 14: val = item.getPfbase14() != null ? item.getPfbase14() : ""; break;
			case 15: val = item.getPfbase15() != null ? item.getPfbase15() : ""; break;
			case 16: val = item.getPfbase16() != null ? item.getPfbase16() : ""; break;
			case 17: val = item.getPfbase17() != null ? item.getPfbase17() : ""; break;
			case 18: val = item.getPfbase18() != null ? item.getPfbase18() : ""; break;
			case 19: val = item.getPfbase19() != null ? item.getPfbase19() : ""; break;
			case 20: val = item.getPfbase20() != null ? item.getPfbase20() : ""; break;
			case 21: val = item.getPfbase21() != null ? item.getPfbase21() : ""; break;
			case 22: val = item.getPfbase22() != null ? item.getPfbase22() : ""; break;
			case 23: val = item.getPfbase23() != null ? item.getPfbase23() : ""; break;
			case 24: val = item.getPfbase24() != null ? item.getPfbase24() : ""; break;
			case 25: val = item.getPfbase25() != null ? item.getPfbase25() : ""; break;
			case 26: val = item.getPfbase26() != null ? item.getPfbase26() : ""; break;
			case 27: val = item.getPfbase27() != null ? item.getPfbase27() : ""; break;
			case 28: val = item.getPfbase28() != null ? item.getPfbase28() : ""; break;
			case 29: val = item.getPfbase29() != null ? item.getPfbase29() : ""; break;
			case 30: val = item.getPfbase30() != null ? item.getPfbase30() : ""; break;
			case 31: val = item.getPfbase31() != null ? item.getPfbase31() : ""; break;
    		default: break;
    	}
    	return val;
    }
 
    /**
     * 
     * @param counter
     * @param item
     * @return
     */
    private static String getFbaseRemarks(int counter, MaintenanceMonitoringPreventive item) {
    	String val = null; //label can return "", comment cannot
    	switch(counter){
	    	case 1: val = item.getPfbaseremarks1() != null ? item.getPfbaseremarks1() : null; break;
			case 2: val = item.getPfbaseremarks2() != null ? item.getPfbaseremarks2() : null; break;
			case 3: val = item.getPfbaseremarks3() != null ? item.getPfbaseremarks3() : null; break;
			case 4: val = item.getPfbaseremarks4() != null ? item.getPfbaseremarks4() : null; break;
			case 5: val = item.getPfbaseremarks5() != null ? item.getPfbaseremarks5() : null; break;
			case 6: val = item.getPfbaseremarks6() != null ? item.getPfbaseremarks6() : null; break;
			case 7: val = item.getPfbaseremarks7() != null ? item.getPfbaseremarks7() : null; break;
			case 8: val = item.getPfbaseremarks8() != null ? item.getPfbaseremarks8() : null; break;
			case 9: val = item.getPfbaseremarks9() != null ? item.getPfbaseremarks9() : null; break;
			case 10: val = item.getPfbaseremarks10() != null ? item.getPfbaseremarks10() : null; break;
			case 11: val = item.getPfbaseremarks11() != null ? item.getPfbaseremarks11() : null; break;
			case 12: val = item.getPfbaseremarks12() != null ? item.getPfbaseremarks12() : null; break;
			case 13: val = item.getPfbaseremarks13() != null ? item.getPfbaseremarks13() : null; break;
			case 14: val = item.getPfbaseremarks14() != null ? item.getPfbaseremarks14() : null; break;
			case 15: val = item.getPfbaseremarks15() != null ? item.getPfbaseremarks15() : null; break;
			case 16: val = item.getPfbaseremarks16() != null ? item.getPfbaseremarks16() : null; break;
			case 17: val = item.getPfbaseremarks17() != null ? item.getPfbaseremarks17() : null; break;
			case 18: val = item.getPfbaseremarks18() != null ? item.getPfbaseremarks18() : null; break;
			case 19: val = item.getPfbaseremarks19() != null ? item.getPfbaseremarks19() : null; break;
			case 20: val = item.getPfbaseremarks20() != null ? item.getPfbaseremarks20() : null; break;
			case 21: val = item.getPfbaseremarks21() != null ? item.getPfbaseremarks21() : null; break;
			case 22: val = item.getPfbaseremarks22() != null ? item.getPfbaseremarks22() : null; break;
			case 23: val = item.getPfbaseremarks23() != null ? item.getPfbaseremarks23() : null; break;
			case 24: val = item.getPfbaseremarks24() != null ? item.getPfbaseremarks24() : null; break;
			case 25: val = item.getPfbaseremarks25() != null ? item.getPfbaseremarks25() : null; break;
			case 26: val = item.getPfbaseremarks26() != null ? item.getPfbaseremarks26() : null; break;
			case 27: val = item.getPfbaseremarks27() != null ? item.getPfbaseremarks27() : null; break;
			case 28: val = item.getPfbaseremarks28() != null ? item.getPfbaseremarks28() : null; break;
			case 29: val = item.getPfbaseremarks29() != null ? item.getPfbaseremarks29() : null; break;
			case 30: val = item.getPfbaseremarks30() != null ? item.getPfbaseremarks30() : null; break;
			case 31: val = item.getPfbaseremarks31() != null ? item.getPfbaseremarks31() : null; break;
    		default: break;
    	}
    	return val;
    }
 
    /**
     * 
     * @param counter
     * @param item
     * @return
     */
    private static String getBfbase(int counter, MaintenanceMonitoringPreventive item) {
    	String val = "";
    	switch(counter){
	    	case 1: val = item.getBfbase1() != null ? item.getBfbase1() : ""; break;
			case 2: val = item.getBfbase2() != null ? item.getBfbase2() : ""; break;
			case 3: val = item.getBfbase3() != null ? item.getBfbase3() : ""; break;
			case 4: val = item.getBfbase4() != null ? item.getBfbase4() : ""; break;
			case 5: val = item.getBfbase5() != null ? item.getBfbase5() : ""; break;
			case 6: val = item.getBfbase6() != null ? item.getBfbase6() : ""; break;
			case 7: val = item.getBfbase7() != null ? item.getBfbase7() : ""; break;
			case 8: val = item.getBfbase8() != null ? item.getBfbase8() : ""; break;
			case 9: val = item.getBfbase9() != null ? item.getBfbase9() : ""; break;
			case 10: val = item.getBfbase10() != null ? item.getBfbase10() : ""; break;
			case 11: val = item.getBfbase11() != null ? item.getBfbase11() : ""; break;
			case 12: val = item.getBfbase12() != null ? item.getBfbase12() : ""; break;
			case 13: val = item.getBfbase13() != null ? item.getBfbase13() : ""; break;
			case 14: val = item.getBfbase14() != null ? item.getBfbase14() : ""; break;
			case 15: val = item.getBfbase15() != null ? item.getBfbase15() : ""; break;
			case 16: val = item.getBfbase16() != null ? item.getBfbase16() : ""; break;
			case 17: val = item.getBfbase17() != null ? item.getBfbase17() : ""; break;
			case 18: val = item.getBfbase18() != null ? item.getBfbase18() : ""; break;
			case 19: val = item.getBfbase19() != null ? item.getBfbase19() : ""; break;
			case 20: val = item.getBfbase20() != null ? item.getBfbase20() : ""; break;
			case 21: val = item.getBfbase21() != null ? item.getBfbase21() : ""; break;
			case 22: val = item.getBfbase22() != null ? item.getBfbase22() : ""; break;
			case 23: val = item.getBfbase23() != null ? item.getBfbase23() : ""; break;
			case 24: val = item.getBfbase24() != null ? item.getBfbase24() : ""; break;
			case 25: val = item.getBfbase25() != null ? item.getBfbase25() : ""; break;
			case 26: val = item.getBfbase26() != null ? item.getBfbase26() : ""; break;
			case 27: val = item.getBfbase27() != null ? item.getBfbase27() : ""; break;
			case 28: val = item.getBfbase28() != null ? item.getBfbase28() : ""; break;
			case 29: val = item.getBfbase29() != null ? item.getBfbase29() : ""; break;
			case 30: val = item.getBfbase30() != null ? item.getBfbase30() : ""; break;
			case 31: val = item.getBfbase31() != null ? item.getBfbase31() : ""; break;
    		default: break;
    	}
    	return val;
    }

    /**
     * 
     * @param counter
     * @param item
     * @return
     */
    private static String getBfbaseRemarks(int counter, MaintenanceMonitoringPreventive item) {
    	String val = null; //label can return "", comment cannot
    	switch(counter){
	    	case 1: val = item.getBfbaseremarks1() != null ? item.getBfbaseremarks1() : null; break;
			case 2: val = item.getBfbaseremarks2() != null ? item.getBfbaseremarks2() : null; break;
			case 3: val = item.getBfbaseremarks3() != null ? item.getBfbaseremarks3() : null; break;
			case 4: val = item.getBfbaseremarks4() != null ? item.getBfbaseremarks4() : null; break;
			case 5: val = item.getBfbaseremarks5() != null ? item.getBfbaseremarks5() : null; break;
			case 6: val = item.getBfbaseremarks6() != null ? item.getBfbaseremarks6() : null; break;
			case 7: val = item.getBfbaseremarks7() != null ? item.getBfbaseremarks7() : null; break;
			case 8: val = item.getBfbaseremarks8() != null ? item.getBfbaseremarks8() : null; break;
			case 9: val = item.getBfbaseremarks9() != null ? item.getBfbaseremarks9() : null; break;
			case 10: val = item.getBfbaseremarks10() != null ? item.getBfbaseremarks10() : null; break;
			case 11: val = item.getBfbaseremarks11() != null ? item.getBfbaseremarks11() : null; break;
			case 12: val = item.getBfbaseremarks12() != null ? item.getBfbaseremarks12() : null; break;
			case 13: val = item.getBfbaseremarks13() != null ? item.getBfbaseremarks13() : null; break;
			case 14: val = item.getBfbaseremarks14() != null ? item.getBfbaseremarks14() : null; break;
			case 15: val = item.getBfbaseremarks15() != null ? item.getBfbaseremarks15() : null; break;
			case 16: val = item.getBfbaseremarks16() != null ? item.getBfbaseremarks16() : null; break;
			case 17: val = item.getBfbaseremarks17() != null ? item.getBfbaseremarks17() : null; break;
			case 18: val = item.getBfbaseremarks18() != null ? item.getBfbaseremarks18() : null; break;
			case 19: val = item.getBfbaseremarks19() != null ? item.getBfbaseremarks19() : null; break;
			case 20: val = item.getBfbaseremarks20() != null ? item.getBfbaseremarks20() : null; break;
			case 21: val = item.getBfbaseremarks21() != null ? item.getBfbaseremarks21() : null; break;
			case 22: val = item.getBfbaseremarks22() != null ? item.getBfbaseremarks22() : null; break;
			case 23: val = item.getBfbaseremarks23() != null ? item.getBfbaseremarks23() : null; break;
			case 24: val = item.getBfbaseremarks24() != null ? item.getBfbaseremarks24() : null; break;
			case 25: val = item.getBfbaseremarks25() != null ? item.getBfbaseremarks25() : null; break;
			case 26: val = item.getBfbaseremarks26() != null ? item.getBfbaseremarks26() : null; break;
			case 27: val = item.getBfbaseremarks27() != null ? item.getBfbaseremarks27() : null; break;
			case 28: val = item.getBfbaseremarks28() != null ? item.getBfbaseremarks28() : null; break;
			case 29: val = item.getBfbaseremarks29() != null ? item.getBfbaseremarks29() : null; break;
			case 30: val = item.getBfbaseremarks30() != null ? item.getBfbaseremarks30() : null; break;
			case 31: val = item.getBfbaseremarks31() != null ? item.getBfbaseremarks31() : null; break;
    		default: break;
    	}
    	return val;
    }
    
    /**
     * 
     * @param counter
     * @param item
     * @return
     */
    private static String getBgarage(int counter, MaintenanceMonitoringPreventive item) {
    	String val = "";
    	switch(counter){
	    	case 1: val = item.getBgarage1() != null ? item.getBgarage1() : ""; break;
			case 2: val = item.getBgarage2() != null ? item.getBgarage2() : ""; break;
			case 3: val = item.getBgarage3() != null ? item.getBgarage3() : ""; break;
			case 4: val = item.getBgarage4() != null ? item.getBgarage4() : ""; break;
			case 5: val = item.getBgarage5() != null ? item.getBgarage5() : ""; break;
			case 6: val = item.getBgarage6() != null ? item.getBgarage6() : ""; break;
			case 7: val = item.getBgarage7() != null ? item.getBgarage7() : ""; break;
			case 8: val = item.getBgarage8() != null ? item.getBgarage8() : ""; break;
			case 9: val = item.getBgarage9() != null ? item.getBgarage9() : ""; break;
			case 10: val = item.getBgarage10() != null ? item.getBgarage10() : ""; break;
			case 11: val = item.getBgarage11() != null ? item.getBgarage11() : ""; break;
			case 12: val = item.getBgarage12() != null ? item.getBgarage12() : ""; break;
			case 13: val = item.getBgarage13() != null ? item.getBgarage13() : ""; break;
			case 14: val = item.getBgarage14() != null ? item.getBgarage14() : ""; break;
			case 15: val = item.getBgarage15() != null ? item.getBgarage15() : ""; break;
			case 16: val = item.getBgarage16() != null ? item.getBgarage16() : ""; break;
			case 17: val = item.getBgarage17() != null ? item.getBgarage17() : ""; break;
			case 18: val = item.getBgarage18() != null ? item.getBgarage18() : ""; break;
			case 19: val = item.getBgarage19() != null ? item.getBgarage19() : ""; break;
			case 20: val = item.getBgarage20() != null ? item.getBgarage20() : ""; break;
			case 21: val = item.getBgarage21() != null ? item.getBgarage21() : ""; break;
			case 22: val = item.getBgarage22() != null ? item.getBgarage22() : ""; break;
			case 23: val = item.getBgarage23() != null ? item.getBgarage23() : ""; break;
			case 24: val = item.getBgarage24() != null ? item.getBgarage24() : ""; break;
			case 25: val = item.getBgarage25() != null ? item.getBgarage25() : ""; break;
			case 26: val = item.getBgarage26() != null ? item.getBgarage26() : ""; break;
			case 27: val = item.getBgarage27() != null ? item.getBgarage27() : ""; break;
			case 28: val = item.getBgarage28() != null ? item.getBgarage28() : ""; break;
			case 29: val = item.getBgarage29() != null ? item.getBgarage29() : ""; break;
			case 30: val = item.getBgarage30() != null ? item.getBgarage30() : ""; break;
			case 31: val = item.getBgarage31() != null ? item.getBgarage31() : ""; break;
    		default: break;
    	}
    	return val;
    }
  
    /**
     * 
     * @param counter
     * @param item
     * @return
     */
    private static String getBgarageRemarks(int counter, MaintenanceMonitoringPreventive item) {
    	String val = null; //label can return "", comment cannot
    	switch(counter){
	    	case 1: val = item.getBgarageremarks1()!= null ? item.getBgarageremarks1() : null; break;
			case 2: val = item.getBgarageremarks2() != null ? item.getBgarageremarks2() : null; break;
			case 3: val = item.getBgarageremarks3() != null ? item.getBgarageremarks3() : null; break;
			case 4: val = item.getBgarageremarks4() != null ? item.getBgarageremarks4() : null; break;
			case 5: val = item.getBgarageremarks5() != null ? item.getBgarageremarks5() : null; break;
			case 6: val = item.getBgarageremarks6() != null ? item.getBgarageremarks6() : null; break;
			case 7: val = item.getBgarageremarks7() != null ? item.getBgarageremarks7() : null; break;
			case 8: val = item.getBgarageremarks8() != null ? item.getBgarageremarks8() : null; break;
			case 9: val = item.getBgarageremarks9() != null ? item.getBgarageremarks9() : null; break;
			case 10: val = item.getBgarageremarks10() != null ? item.getBgarageremarks10() : null; break;
			case 11: val = item.getBgarageremarks11() != null ? item.getBgarageremarks11() : null; break;
			case 12: val = item.getBgarageremarks12() != null ? item.getBgarageremarks12() : null; break;
			case 13: val = item.getBgarageremarks13() != null ? item.getBgarageremarks13() : null; break;
			case 14: val = item.getBgarageremarks14() != null ? item.getBgarageremarks14() : null; break;
			case 15: val = item.getBgarageremarks15() != null ? item.getBgarageremarks15() : null; break;
			case 16: val = item.getBgarageremarks16() != null ? item.getBgarageremarks16() : null; break;
			case 17: val = item.getBgarageremarks17() != null ? item.getBgarageremarks17() : null; break;
			case 18: val = item.getBgarageremarks18() != null ? item.getBgarageremarks18() : null; break;
			case 19: val = item.getBgarageremarks19() != null ? item.getBgarageremarks19() : null; break;
			case 20: val = item.getBgarageremarks20() != null ? item.getBgarageremarks20() : null; break;
			case 21: val = item.getBgarageremarks21() != null ? item.getBgarageremarks21() : null; break;
			case 22: val = item.getBgarageremarks22() != null ? item.getBgarageremarks22() : null; break;
			case 23: val = item.getBgarageremarks23() != null ? item.getBgarageremarks23() : null; break;
			case 24: val = item.getBgarageremarks24() != null ? item.getBgarageremarks24() : null; break;
			case 25: val = item.getBgarageremarks25() != null ? item.getBgarageremarks25() : null; break;
			case 26: val = item.getBgarageremarks26() != null ? item.getBgarageremarks26() : null; break;
			case 27: val = item.getBgarageremarks27() != null ? item.getBgarageremarks27() : null; break;
			case 28: val = item.getBgarageremarks28() != null ? item.getBgarageremarks28() : null; break;
			case 29: val = item.getBgarageremarks29() != null ? item.getBgarageremarks29() : null; break;
			case 30: val = item.getBgarageremarks30() != null ? item.getBgarageremarks30() : null; break;
			case 31: val = item.getBgarageremarks31() != null ? item.getBgarageremarks31() : null; break;
    		default: break;
    	}
    	return val;
    }
    
    /**
     * 
     * @param counter
     * @param item
     * @return
     */
    private static String getPreventiveTotal(int counter, MaintenanceMonitoringPreventiveTotal item) {
    	int val = 0;
    	switch(counter){
	    	case 1: val = item.getPreventiveTotal1() > 0 ? item.getPreventiveTotal1() : 0; break;
			case 2: val = item.getPreventiveTotal2() > 0 ? item.getPreventiveTotal2() : 0; break;
			case 3: val = item.getPreventiveTotal3() > 0 ? item.getPreventiveTotal3() : 0; break;
			case 4: val = item.getPreventiveTotal4() > 0 ? item.getPreventiveTotal4() : 0; break;
			case 5: val = item.getPreventiveTotal5() > 0 ? item.getPreventiveTotal5() : 0; break;
			case 6: val = item.getPreventiveTotal6() > 0 ? item.getPreventiveTotal6() : 0; break;
			case 7: val = item.getPreventiveTotal7() > 0 ? item.getPreventiveTotal7() : 0; break;
			case 8: val = item.getPreventiveTotal8() > 0 ? item.getPreventiveTotal8() : 0; break;
			case 9: val = item.getPreventiveTotal9() > 0 ? item.getPreventiveTotal9() : 0; break;
			case 10: val = item.getPreventiveTotal10() > 0 ? item.getPreventiveTotal10() : 0; break;
			case 11: val = item.getPreventiveTotal11() > 0 ? item.getPreventiveTotal11() : 0; break;
			case 12: val = item.getPreventiveTotal12() > 0 ? item.getPreventiveTotal12() : 0; break;
			case 13: val = item.getPreventiveTotal13() > 0 ? item.getPreventiveTotal13() : 0; break;
			case 14: val = item.getPreventiveTotal14() > 0 ? item.getPreventiveTotal14() : 0; break;
			case 15: val = item.getPreventiveTotal15() > 0 ? item.getPreventiveTotal15() : 0; break;
			case 16: val = item.getPreventiveTotal16() > 0 ? item.getPreventiveTotal16() : 0; break;
			case 17: val = item.getPreventiveTotal17() > 0 ? item.getPreventiveTotal17() : 0; break;
			case 18: val = item.getPreventiveTotal18() > 0 ? item.getPreventiveTotal18() : 0; break;
			case 19: val = item.getPreventiveTotal19() > 0 ? item.getPreventiveTotal19() : 0; break;
			case 20: val = item.getPreventiveTotal20() > 0 ? item.getPreventiveTotal20() : 0; break;
			case 21: val = item.getPreventiveTotal21() > 0 ? item.getPreventiveTotal21() : 0; break;
			case 22: val = item.getPreventiveTotal22() > 0 ? item.getPreventiveTotal22() : 0; break;
			case 23: val = item.getPreventiveTotal23() > 0 ? item.getPreventiveTotal23() : 0; break;
			case 24: val = item.getPreventiveTotal24() > 0 ? item.getPreventiveTotal24() : 0; break;
			case 25: val = item.getPreventiveTotal25() > 0 ? item.getPreventiveTotal25() : 0; break;
			case 26: val = item.getPreventiveTotal26() > 0 ? item.getPreventiveTotal26() : 0; break;
			case 27: val = item.getPreventiveTotal27() > 0 ? item.getPreventiveTotal27() : 0; break;
			case 28: val = item.getPreventiveTotal28() > 0 ? item.getPreventiveTotal28() : 0; break;
			case 29: val = item.getPreventiveTotal29() > 0 ? item.getPreventiveTotal29() : 0; break;
			case 30: val = item.getPreventiveTotal30() > 0 ? item.getPreventiveTotal30() : 0; break;
			case 31: val = item.getPreventiveTotal31() > 0 ? item.getPreventiveTotal31() : 0; break;
    		default: break;
    	}
    	return String.valueOf(val);
    }
  
    /**
     * 
     * @param counter
     * @param item
     * @return
     */
    private static String getTotalPendingComment(int counter, MaintenanceMonitoringTotalPending item) {
    	String val = null;
    	switch(counter){
	    	case 1: val = item.getTotalPendingComment1() !=null ? item.getTotalPendingComment1() : ""; break;
			case 2: val = item.getTotalPendingComment2() !=null ? item.getTotalPendingComment2() : ""; break;
			case 3: val = item.getTotalPendingComment3() !=null ? item.getTotalPendingComment3() : ""; break;
			case 4: val = item.getTotalPendingComment4() !=null ? item.getTotalPendingComment4() : ""; break;
			case 5: val = item.getTotalPendingComment5() !=null ? item.getTotalPendingComment5() : ""; break;
			case 6: val = item.getTotalPendingComment6() !=null ? item.getTotalPendingComment6() : ""; break;
			case 7: val = item.getTotalPendingComment7() !=null ? item.getTotalPendingComment7() : ""; break;
			case 8: val = item.getTotalPendingComment8() !=null ? item.getTotalPendingComment8() : ""; break;
			case 9: val = item.getTotalPendingComment9() !=null ? item.getTotalPendingComment9() : ""; break;
			case 10: val = item.getTotalPendingComment10() !=null ? item.getTotalPendingComment10() : ""; break;
			case 11: val = item.getTotalPendingComment11() !=null ? item.getTotalPendingComment11() : ""; break;
			case 12: val = item.getTotalPendingComment12() !=null ? item.getTotalPendingComment12() : ""; break;
			case 13: val = item.getTotalPendingComment13() !=null ? item.getTotalPendingComment13() : ""; break;
			case 14: val = item.getTotalPendingComment14() !=null ? item.getTotalPendingComment14() : ""; break;
			case 15: val = item.getTotalPendingComment15() !=null ? item.getTotalPendingComment15() : ""; break;
			case 16: val = item.getTotalPendingComment16() !=null ? item.getTotalPendingComment16() : ""; break;
			case 17: val = item.getTotalPendingComment17() !=null ? item.getTotalPendingComment17() : ""; break;
			case 18: val = item.getTotalPendingComment18() !=null ? item.getTotalPendingComment18() : ""; break;
			case 19: val = item.getTotalPendingComment19() !=null ? item.getTotalPendingComment19() : ""; break;
			case 20: val = item.getTotalPendingComment20() !=null ? item.getTotalPendingComment20() : ""; break;
			case 21: val = item.getTotalPendingComment21() !=null ? item.getTotalPendingComment21() : ""; break;
			case 22: val = item.getTotalPendingComment22() !=null ? item.getTotalPendingComment22() : ""; break;
			case 23: val = item.getTotalPendingComment23() !=null ? item.getTotalPendingComment23() : ""; break;
			case 24: val = item.getTotalPendingComment24() !=null ? item.getTotalPendingComment24() : ""; break;
			case 25: val = item.getTotalPendingComment25() !=null ? item.getTotalPendingComment25() : ""; break;
			case 26: val = item.getTotalPendingComment26() !=null ? item.getTotalPendingComment26() : ""; break;
			case 27: val = item.getTotalPendingComment27() !=null ? item.getTotalPendingComment27() : ""; break;
			case 28: val = item.getTotalPendingComment28() !=null ? item.getTotalPendingComment28() : ""; break;
			case 29: val = item.getTotalPendingComment29() !=null ? item.getTotalPendingComment29() : ""; break;
			case 30: val = item.getTotalPendingComment30() !=null ? item.getTotalPendingComment30() : ""; break;
			case 31: val = item.getTotalPendingComment31() !=null ? item.getTotalPendingComment31() : ""; break;
    		default: break;
    	}
    	return String.valueOf(val);
    }
    
    /**
     * 
     * @param counter
     * @param item
     * @return
     */
    private static String getGPSVol(int counter, MaintenanceMonitoring item) {
    	int val = 0;
    	switch(counter){
	    	case 1: val = item.getGps1Vol() > 0 ? item.getGps1Vol() : 0; break;
			case 2: val = item.getGps2Vol() > 0 ? item.getGps2Vol() : 0; break;
			case 3: val = item.getGps3Vol() > 0 ? item.getGps3Vol() : 0; break;
			case 4: val = item.getGps4Vol() > 0 ? item.getGps4Vol() : 0; break;
			case 5: val = item.getGps5Vol() > 0 ? item.getGps5Vol() : 0; break;
			case 6: val = item.getGps6Vol() > 0 ? item.getGps6Vol() : 0; break;
			case 7: val = item.getGps7Vol() > 0 ? item.getGps7Vol() : 0; break;
			case 8: val = item.getGps8Vol() > 0 ? item.getGps8Vol() : 0; break;
			case 9: val = item.getGps9Vol() > 0 ? item.getGps9Vol() : 0; break;
			case 10: val = item.getGps10Vol() > 0 ? item.getGps10Vol() : 0; break;
			case 11: val = item.getGps11Vol() > 0 ? item.getGps11Vol() : 0; break;
			case 12: val = item.getGps12Vol() > 0 ? item.getGps12Vol() : 0; break;
			case 13: val = item.getGps13Vol() > 0 ? item.getGps13Vol() : 0; break;
			case 14: val = item.getGps14Vol() > 0 ? item.getGps14Vol() : 0; break;
			case 15: val = item.getGps15Vol() > 0 ? item.getGps15Vol() : 0; break;
			case 16: val = item.getGps16Vol() > 0 ? item.getGps16Vol() : 0; break;
			case 17: val = item.getGps17Vol() > 0 ? item.getGps17Vol() : 0; break;
			case 18: val = item.getGps18Vol() > 0 ? item.getGps18Vol() : 0; break;
			case 19: val = item.getGps19Vol() > 0 ? item.getGps19Vol() : 0; break;
			case 20: val = item.getGps20Vol() > 0 ? item.getGps20Vol() : 0; break;
			case 21: val = item.getGps21Vol() > 0 ? item.getGps21Vol() : 0; break;
			case 22: val = item.getGps22Vol() > 0 ? item.getGps22Vol() : 0; break;
			case 23: val = item.getGps23Vol() > 0 ? item.getGps23Vol() : 0; break;
			case 24: val = item.getGps24Vol() > 0 ? item.getGps24Vol() : 0; break;
			case 25: val = item.getGps25Vol() > 0 ? item.getGps25Vol() : 0; break;
			case 26: val = item.getGps26Vol() > 0 ? item.getGps26Vol() : 0; break;
			case 27: val = item.getGps27Vol() > 0 ? item.getGps27Vol() : 0; break;
			case 28: val = item.getGps28Vol() > 0 ? item.getGps28Vol() : 0; break;
			case 29: val = item.getGps29Vol() > 0 ? item.getGps29Vol() : 0; break;
			case 30: val = item.getGps30Vol() > 0 ? item.getGps30Vol() : 0; break;
			case 31: val = item.getGps31Vol() > 0 ? item.getGps31Vol() : 0; break;
    		default: break;
    	}
    	return String.valueOf(val);
    }

    /**
     * 
     * @param i
     * @param excelSheet
     * @param wcf2
     * @param wcf3
     * @param label
     * @param modelListPreventive
     * @param z
     * @param cellFeatures2
     * @param wcfGray
     * @param wcfBorder
     * @param wcfOrange
     * @param wcfYellow
     * @param wcfRed
     * @param wcfCyan
     * @param wcfDarkGreen
     * @param wcfBlack
     * @param wcfViolet
     * @param y
     * @param cf
     * @param remarks
     * @param totalPendingMap
     * @param modelListPreventiveTotal
     * @param modelListTotalPending
     * @throws RowsExceededException
     * @throws WriteException
     */
	private static void continueToGenerateMaintenanceMonitoringReport(int i, WritableSheet  excelSheet, WritableCellFormat wcf2, WritableCellFormat wcf3, 
			Label label, List<MaintenanceMonitoringPreventive> modelListPreventive,int z, WritableCellFeatures  cellFeatures2,
			WritableCellFormat wcfGray, WritableCellFormat wcfBorder, WritableCellFormat wcfOrange, WritableCellFormat wcfYellow,
			WritableCellFormat wcfRed, WritableCellFormat wcfCyan, WritableCellFormat wcfDarkGreen, WritableCellFormat wcfBlack, WritableCellFormat wcfViolet,
			int y, WritableFont cf, String remarks, Map<Integer,Integer> totalPendingMap, List<MaintenanceMonitoringPreventiveTotal> modelListPreventiveTotal,
			List<MaintenanceMonitoringTotalPending> modelListTotalPending) throws RowsExceededException, WriteException{
		
		//Preventive and Breakdown
        excelSheet.mergeCells(0, i+4, 1, i+4);
        label = new Label(0, i+4, "PREVENTIVE MAINTENANCE", wcf2);
        excelSheet.addCell(label);
        excelSheet.mergeCells(2, i+4, 3, i+4);
        label = new Label(2, i+4, "Garage", wcf2);
        excelSheet.addCell(label);
        for(MaintenanceMonitoringPreventive item : modelListPreventive) {
            z = 0;
            for (y=1;y<=31;y++) {
         	   //Garage
         	   label = new Label(z+4, i+4, "", wcfBorder);
         	   excelSheet.addCell(label);
                wcf3 = null;
                cellFeatures2 = null;
                wcf3 = new WritableCellFormat(cf);            
                wcf3.setAlignment(Alignment.CENTRE);
                wcf3.setBorder(Border.ALL, BorderLineStyle.THIN);
                wcf3.setBackground(Colour.TURQUOISE); //CYAN
                label = new Label(z+5, i+4, getGarage(y, item), wcf3);
                remarks = getGarageRemarks(y,item);
                if (remarks!=null && remarks.trim().length() > 0) {
             	   cellFeatures2 = new WritableCellFeatures();
             	   cellFeatures2.setComment(remarks, 4, 2);   
             	   label.setCellFeatures(cellFeatures2);
                }
                excelSheet.addCell(label);
                label = new Label(z+6, i+4, "", wcfBorder);
                excelSheet.addCell(label);
                if (y==7) {
             	   label = new Label(z+7, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+10, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   z += 4;
                }
                if (y==14) {
             	   label = new Label(z+7, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+10, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   z += 4;
                }
                if (y==21) {
             	   label = new Label(z+7, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+10, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   z += 4;
                }
                if (y==28) {
             	   label = new Label(z+7, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+10, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   z += 4;
                }
	               if (y == 31) {
             	   label = new Label(z+7, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
	            	   label = new Label(z+10, i+4, "", wcfBorder);
	            	   excelSheet.addCell(label);
	               	   label = new Label(z+11, i+4, "", wcfRed);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+12, i+4, "", wcfCyan);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+13, i+4, "", wcfGray);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+14, i+4, "", wcfDarkGreen);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+15, i+4, "", wcfBlack);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+16, i+4, "", wcfViolet);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+17, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+18, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+19, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+20, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+21, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+22, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+23, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+24, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+25, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+26, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               }
                z += 3;
            }
            
            //Fieldbase
            i += 1;
            excelSheet.mergeCells(0, i+4, 1, i+4);
            label = new Label(0, i+4, "", wcf2);
            excelSheet.addCell(label);
            excelSheet.mergeCells(2, i+4, 3, i+4);
            label = new Label(2, i+4, "Fieldbase", wcf2);
            excelSheet.addCell(label);
            z = 0;
            for (y=1;y<=31;y++) {
         	   label = new Label(z+4, i+4, "", wcfBorder);
         	   excelSheet.addCell(label);
                wcf3 = null;
                cellFeatures2 = null;
                wcf3 = new WritableCellFormat(cf);
                wcf3.setAlignment(Alignment.CENTRE);
                wcf3.setBorder(Border.ALL, BorderLineStyle.THIN);
                wcf3.setBackground(Colour.TURQUOISE); //CYAN
                label = new Label(z+5, i+4, getFbase(y, item), wcf3);
                remarks = getFbaseRemarks(y,item);
                if (remarks!=null && remarks.trim().length() > 0) {
             	   cellFeatures2 = new WritableCellFeatures();
             	   cellFeatures2.setComment(remarks, 4, 2);   
             	   label.setCellFeatures(cellFeatures2);
                }
                excelSheet.addCell(label);
                label = new Label(z+6, i+4, "", wcfBorder);
                excelSheet.addCell(label);
                if (y==7) {
             	   label = new Label(z+7, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+10, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   z += 4;
                }
                if (y==14) {
             	   label = new Label(z+7, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+10, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   z += 4;
                }
                if (y==21) {
             	   label = new Label(z+7, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+10, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   z += 4;
                }
                if (y==28) {
             	   label = new Label(z+7, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+10, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   z += 4;
                }
	               if (y == 31) {
             	   label = new Label(z+7, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
	            	   label = new Label(z+10, i+4, "", wcfBorder);
	            	   excelSheet.addCell(label);
	               	   label = new Label(z+11, i+4, "", wcfRed);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+12, i+4, "", wcfCyan);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+13, i+4, "", wcfGray);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+14, i+4, "", wcfDarkGreen);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+15, i+4, "", wcfBlack);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+16, i+4, "", wcfViolet);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+17, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+18, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+19, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+20, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+21, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+22, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+23, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+24, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+25, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+26, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               }
                z += 3;
            }
            
            //Breakdown - Garage
            i += 1;
            excelSheet.mergeCells(0, i+4, 1, i+4);
            label = new Label(0, i+4, "BREAKDOWN", wcf2);
            excelSheet.addCell(label);
            excelSheet.mergeCells(2, i+4, 3, i+4);
            label = new Label(2, i+4, "Garage", wcf2);
            excelSheet.addCell(label);
            z = 0;
            for (y=1;y<=31;y++) {
         	   label = new Label(z+4, i+4, "", wcfBorder);
         	   excelSheet.addCell(label);
                wcf3 = null;
                cellFeatures2 = null;
                wcf3 = new WritableCellFormat(cf);
                wcf3.setAlignment(Alignment.CENTRE);
                wcf3.setBorder(Border.ALL, BorderLineStyle.THIN);
                wcf3.setBackground(Colour.RED);
                label = new Label(z+5, i+4, getBgarage(y, item), wcf3);
                remarks = getBgarageRemarks(y,item);
                if (remarks!=null && remarks.trim().length() > 0) {
             	   cellFeatures2 = new WritableCellFeatures();
             	   cellFeatures2.setComment(remarks, 4, 2);   
             	   label.setCellFeatures(cellFeatures2);
                }
                excelSheet.addCell(label);
                label = new Label(z+6, i+4, "", wcfBorder);
                excelSheet.addCell(label);
                if (y==7) {
             	   label = new Label(z+7, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+10, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   z += 4;
                }
                if (y==14) {
             	   label = new Label(z+7, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+10, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   z += 4;
                }
                if (y==21) {
             	   label = new Label(z+7, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+10, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   z += 4;
                }
                if (y==28) {
             	   label = new Label(z+7, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+10, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   z += 4;
                }
	               if (y == 31) {
             	   label = new Label(z+7, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
	            	   label = new Label(z+10, i+4, "", wcfBorder);
	            	   excelSheet.addCell(label);
	               	   label = new Label(z+11, i+4, "", wcfRed);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+12, i+4, "", wcfCyan);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+13, i+4, "", wcfGray);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+14, i+4, "", wcfDarkGreen);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+15, i+4, "", wcfBlack);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+16, i+4, "", wcfViolet);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+17, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+18, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+19, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+20, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+21, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+22, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+23, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+24, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+25, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+26, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               }
                z += 3;
            }      
            
            //Breakdown - Fieldbase
            i += 1;
            excelSheet.mergeCells(0, i+4, 1, i+4);
            label = new Label(0, i+4, "", wcf2);
            excelSheet.addCell(label);
            excelSheet.mergeCells(2, i+4, 3, i+4);
            label = new Label(2, i+4, "Fieldbase", wcf2);
            excelSheet.addCell(label);
            z = 0;
            for (y=1;y<=31;y++) {
         	   label = new Label(z+4, i+4, "", wcfBorder);
         	   excelSheet.addCell(label);
                wcf3 = null;
                cellFeatures2 = null;
                wcf3 = new WritableCellFormat(cf);
                wcf3.setAlignment(Alignment.CENTRE);
                wcf3.setBorder(Border.ALL, BorderLineStyle.THIN);
                wcf3.setBackground(Colour.RED);
                label = new Label(z+5, i+4, getBfbase(y, item), wcf3);
                remarks = getBfbaseRemarks(y,item);
                if (remarks!=null && remarks.trim().length() > 0) {
             	   cellFeatures2 = new WritableCellFeatures();
             	   cellFeatures2.setComment(remarks, 4, 2);   
             	   label.setCellFeatures(cellFeatures2);
                }
                excelSheet.addCell(label);
                label = new Label(z+6, i+4, "", wcfBorder);
                excelSheet.addCell(label);
                if (y==7) {
             	   label = new Label(z+7, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+10, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   z += 4;
                }
                if (y==14) {
             	   label = new Label(z+7, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+10, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   z += 4;
                }
                if (y==21) {
             	   label = new Label(z+7, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+10, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   z += 4;
                }
                if (y==28) {
             	   label = new Label(z+7, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+10, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   z += 4;
                }
	               if (y == 31) {
             	   label = new Label(z+7, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
	            	   label = new Label(z+10, i+4, "", wcfBorder);
	            	   excelSheet.addCell(label);
	               	   label = new Label(z+11, i+4, "", wcfRed);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+12, i+4, "", wcfCyan);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+13, i+4, "", wcfGray);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+14, i+4, "", wcfDarkGreen);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+15, i+4, "", wcfBlack);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+16, i+4, "", wcfViolet);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+17, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+18, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+19, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+20, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+21, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+22, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+23, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+24, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+25, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+26, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               }
                z += 3;
            }   
            
        }
        
        //TOTAL
        i += 1;
        excelSheet.mergeCells(0, i+4, 1, i+4);
        label = new Label(0, i+4, "", wcf2);
        excelSheet.addCell(label);
        excelSheet.mergeCells(2, i+4, 3, i+4);
        label = new Label(2, i+4, "TOTAL", wcf2);
        excelSheet.addCell(label);
        for(MaintenanceMonitoringPreventiveTotal item : modelListPreventiveTotal) {
            z = 0;
            for (y=1;y<=31;y++) {
         	   label = new Label(z+4, i+4, "", wcfBorder);
         	   excelSheet.addCell(label);
                wcf3 = null;
                cellFeatures2 = null;
                wcf3 = new WritableCellFormat(cf);            
                wcf3.setAlignment(Alignment.CENTRE);
                wcf3.setBorder(Border.ALL, BorderLineStyle.THIN);
                wcf3.setBackground(Colour.RED); 
                label = new Label(z+5, i+4, getPreventiveTotal(y, item), wcf3);
                excelSheet.addCell(label);
                label = new Label(z+6, i+4, "", wcfBorder);
                excelSheet.addCell(label);
                if (y==7) {
             	   label = new Label(z+7, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+10, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   z += 4;
                }
                if (y==14) {
             	   label = new Label(z+7, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+10, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   z += 4;
                }
                if (y==21) {
             	   label = new Label(z+7, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+10, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   z += 4;
                }
                if (y==28) {
             	   label = new Label(z+7, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+10, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   z += 4;
                }
	               if (y == 31) {
             	   label = new Label(z+7, i+4, "", wcfOrange);
             	   excelSheet.addCell(label);
             	   label = new Label(z+8, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
             	   label = new Label(z+9, i+4, "", wcfYellow);
             	   excelSheet.addCell(label);
	            	   label = new Label(z+10, i+4, "", wcfBorder);
	            	   excelSheet.addCell(label);
	               	   label = new Label(z+11, i+4, "", wcfRed);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+12, i+4, "", wcfCyan);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+13, i+4, "", wcfGray);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+14, i+4, "", wcfDarkGreen);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+15, i+4, "", wcfBlack);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+16, i+4, "", wcfViolet);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+17, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+18, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+19, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+20, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+21, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+22, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+23, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+24, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+25, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               	   label = new Label(z+26, i+4, "", wcfOrange);
	               	   excelSheet.addCell(label);
	               }
                z += 3;
            } 
        }      

        
        //TOTAL PENDING row
        createTotalPendingRow(i, excelSheet, wcf2, wcf3, label, modelListTotalPending, z, cellFeatures2, wcfGray, wcfBorder, wcfOrange, wcfYellow, wcfRed, wcfCyan, wcfDarkGreen, wcfBlack, wcfViolet, remarks, y, cf, totalPendingMap);
		
		
	}


}
