/*
 * Created on Jan 28, 2015
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.transport.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts.upload.FormFile;

import com.transport.constant.MapConstant;
import com.transport.model.ListValue;

/**
 * @author Edward.David
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class TransportUtils {
	
	private static List<ListValue> gpsTripIssueCategoryLOV;
	
	static String OS = System.getProperty("os.name").toLowerCase();
	
	/**
	 * This method is used for generic logging INFO  in console and a log file
	 * 
	 * @author dward
	 * @since 04Mar2015
	 * @exception
	 * @param log (Log4J Logger)
	 * @param message (String)
	 */
	public static void writeLogInfo(Logger log, String message) {
		if (log!=null) {
			log.info(message);
		}
		System.out.println(message);
	}
	
	/**
	 * This method is used for generic logging DEBUG  in console and a log file
	 * 
	 * @author dward
	 * @since 04Mar2015
	 * @exception
	 * @param log (Log4J Logger)
	 * @param message (String)
	 */
	public static void writeLogDebug(Logger log, String message) {
		if (log!=null && log.isDebugEnabled()) {
			log.debug(message);
			System.out.println(message);
		}
	}
	
	
	/**
	 * Checks whether the obj param is null
	 * @param Obj
	 * @return boolean true if obj param is null
	 */	
	public static boolean isNull(Object obj){
		return (obj==null);
	}
	/**
	 * To compare two non-primitive (object) values whether they are meaningfully equals.
	 * This will invoke the object's equals method and also handles null checking.
	 * @param obj1 - object1 
	 * @param obj2 - object2
	 * @return boolean true if both param are equals		 
	 */
	public static boolean isEqual(Object obj1, Object obj2){			
		return (
			(isNull(obj1) && isNull(obj2) && obj1==obj2) || 
			(!isNull(obj1) && !isNull(obj2) && obj1.equals(obj2))
		);//this formula already handles all (5) case scenarios.
	}
	
	/**
	 * To compare two numeric primitives values whether they are equals.
	 * This is also for char types since char is convertible to int. 
	 * @param v1 - value1
	 * @param v2 - value2
	 * @return boolean true if both param are equals		
	 */		
	public static boolean isEqual(double v1, double v2){
		return (v1==v2);
	}

	/**
	 * To compare two boolean values whether they are equals.	 
	 * @param v1 - value1
	 * @param v2 - value2
	 * @return boolean true if both param are equals		
	 */		
	public static boolean isEqual(boolean v1, boolean v2){
		return (v1==v2);
	}			
	
	//sample override equals in DTO below
//	//overrided equals()
//	public boolean equals(Object obj) {
//		boolean isEqual = true;
//		if(obj instanceof Building){
//			Building objDTO = (Building) obj;
//			PIBSUtilities util = new PIBSUtilities(); 
//			isEqual = (
//				util.isEqual(this.id, objDTO.getId()) && 
//				util.isEqual(this.description, objDTO.getDescription()) && 
//				util.isEqual(this.noOfFloor, objDTO.getNoOfFloor()) && 
//				util.isEqual(this.remarks, objDTO.getRemarks())  
//			);
//		}else{
//			isEqual = false;
//		}
//		return isEqual;
//	}
	
	public static void closeObjects(Object obj) throws Exception{
		if (obj instanceof ResultSet) {
			((ResultSet) obj).close();
		}
		if (obj instanceof Statement) {
			((Statement) obj).close();
		}
		if (obj instanceof Connection) {
			((Connection) obj).close();
		}
	}

	//Transport Revision 1 Dec2015
	public static int getSubAction(HashMap<String, Object> dataMap) throws Exception {		
		int subAction = 0;
		Object subActionObj = (Object) dataMap.get(MapConstant.SUB_ACTION);
		subAction = (subActionObj!=null ? Integer.parseInt(subActionObj.toString()) : 0 );
		return subAction;
	}
	
	public static String getReportPath(HttpServletRequest request) {
		String path = null;
		if (OS.indexOf("win") >= 0) {
			//Windows
			path = request.getSession().getServletContext().getRealPath("/") + "reports";//for local testing - reports (without '/') - Windows
		} else {
			path = request.getSession().getServletContext().getRealPath("/") + "/reports";//for production - /reports - UNIX
		}
		return path;
	}
	
	public static String getResourcesPath(HttpServletRequest request) {
		String path = null;
		if (OS.indexOf("win") >= 0) {
			//Windows
			path = request.getSession().getServletContext().getRealPath("/") + "resources";//for local testing - reports (without '/') - Windows
		} else {
			path = request.getSession().getServletContext().getRealPath("/") + "/resources";//for production - /reports - UNIX
		}
		return path;
	}
	
	public static String getStrMonth(int intMonth) {
		String month = "";
		switch (intMonth) {
			case 1: month = "January"; break;
			case 2: month = "February"; break;
			case 3: month = "March"; break;
			case 4: month = "April"; break;
			case 5: month = "May"; break;
			case 6: month = "June"; break;
			case 7: month = "July"; break;
			case 8: month = "August"; break;
			case 9: month = "September"; break;
			case 10: month = "October"; break;
			case 11: month = "November"; break;
			case 12: month = "December"; break;
		}
		return month;
	}
	
	/**
	 * 
	 * @param birthDate
	 * @param currentDate
	 * @return
	 */
	public static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
		return Period.between(birthDate, currentDate).getYears();
	}
	
	/**
	 * 
	 * @param newFile
	 * @param file
	 */
	public static void uploadPic(File newFile, FormFile file) {
	
		try {
	        FileOutputStream fos = new FileOutputStream(newFile);
	        fos.write(file.getFileData());
	        fos.flush();
	        fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param imgBytes
	 * @return
	 */
	public static String getPicBase64String(byte[] imgBytes) {
		String base64Encoded = null;
        byte[] encodeBase64 = Base64.getEncoder().encode(imgBytes);
        try {
			base64Encoded = new String(encodeBase64, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        return base64Encoded;
	}
	
	private static List<ListValue> getGpsTripIssueCategoryLOV() {
		return gpsTripIssueCategoryLOV;
	}

	public static void setGpsTripIssueCategoryLOV(List<ListValue> gpsTripIssueCategoryLOV) {
		TransportUtils.gpsTripIssueCategoryLOV = gpsTripIssueCategoryLOV;
	}
	
	public static String getGPSTripIssueCategoryById(int id) {
		String desc = null;
		for (ListValue item : getGpsTripIssueCategoryLOV()) {
			if (id == item.getId()) {
				desc = item.getListValue();
				break;
			}
		}
		return desc;
	}
	
	/**
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isMobile(Object obj) {
		boolean ans = false;
		if (obj!=null && ((String)obj).equals("true")) {
		 ans = true;	
		}
		return ans;
	}
	
	public static boolean isUserDriver(Object obj) {
		boolean ans = false;
		if (obj!=null && ((String)obj).equals("Driver")) {
		 ans = true;	
		}
		return ans;
	}
}
