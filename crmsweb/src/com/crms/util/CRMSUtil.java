package com.crms.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.Period;

import org.springframework.ui.ModelMap;

import com.crms.constant.CRMSConstant;

public class CRMSUtil {
	
	public static int getRecordStartIndex(int page) {
		return (page-1) * CRMSConstant.RECORDS_PER_PAGE; 	
	}
	
	public static int getTotalNoOfPages(long totalNoOfRecords) {
		return (int) Math.ceil(totalNoOfRecords * 1.0 / CRMSConstant.RECORDS_PER_PAGE);
	}
	
	public static int getAge(java.time.LocalDate dob) {
		java.time.LocalDate curDate = java.time.LocalDate.now();
		return Period.between(dob, curDate).getYears();
	}
	
	public static boolean isUserSessionValid(ModelMap model) {
		return model.get("userid")!=null;
	}
	
	public static Integer getUserIdFromSession(ModelMap model) {
		return model.get("userid")!=null ? Integer.parseInt(model.get("userid").toString()) : 0;
	}

	/**
	 * 
	 * @param numStr
	 * @return
	 * @throws ParseException 
	 * @throws Exception
	 */
	public static Double convertNumStrWithCommaToDouble(String numStr) throws ParseException{
		NumberFormat format = NumberFormat.getInstance();
		Number num = format.parse(numStr);
		return num.doubleValue();
	}
	
	/**
	 * 
	 * @param num
	 * @return
	 * @throws Exception
	 */
	public static String convertBigDecimalToStrWithComma(BigDecimal num) throws NumberFormatException{
		DecimalFormat df = new DecimalFormat("###,###.00");
		return df.format(num.doubleValue());
	}
	
	
	//public static String getReportPath(HttpServletRequest request) {
	//	String path = null;
	//	if (OS.indexOf("win") >= 0) {
	//		//Windows
	//		//Not same behavior as TransportWeb, need to add File separator for PIBSWeb for Windows, need to check Why?
	//		path = request.getSession().getServletContext().getRealPath("/") + File.separator + "reports";//for local testing - Windows
	//	} else {
	//		path = request.getSession().getServletContext().getRealPath("/") + "/reports";//for production - /reports - UNIX
	//	}
	//    // Note: path when debugging
	//	//C:\eclipse\workspace_pibsweb\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\pibsweb\reports
	//	return path;
	//}
	//
	//private static String getConfigFilePath(HttpServletRequest request) {
	//	String path = null;
	//	if (OS.indexOf("win") >= 0) {
	//		//Windows
	//		//Not same behavior as TransportWeb, need to add File separator for PIBSWeb for Windows, need to check Why?
	//		path = request.getSession().getServletContext().getRealPath("/") + File.separator + "config/pibsconfig.txt";//for local testing - Windows
	//	} else {
	//		path = request.getSession().getServletContext().getRealPath("/") + "/config/pibsconfig.txt";//for production - /reports - UNIX
	//	}
	//    // Note: path when debugging
	//	//C:\eclipse\workspace_pibsweb\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\pibsweb\reports
	//	return path;
	//}
	//
	//public static String[] readConfigFile(HttpServletRequest request) throws Exception {
	//	String[] configArr = null;
	//	try (BufferedReader br = new BufferedReader(new FileReader(getConfigFilePath(request)))) {
	//		String line = null;
	//		while ((line = br.readLine()) != null) {
	//			configArr = line.split(",");
	//		}
	//	} catch (Exception e) {
	//		throw e;
	//	} finally {
	////		br.close(); //no need to close if user try-resources
	//	}
	//	return configArr;
	//}

}
