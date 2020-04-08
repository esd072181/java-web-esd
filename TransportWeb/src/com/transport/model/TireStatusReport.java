package com.transport.model;

import java.io.Serializable;

/**
 * 
 * @author dward
 * @since 20Aug2016
 * DateUpdated: 08Apr2020
 */
public class TireStatusReport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String serialNo;
	private String recapNo;
	private int threadDepth1;
	private int threadDepth2;
	private int threadDepth3;
	private String lorryNo;
	private String plateno;
	private String wheelPosition;
	
	public TireStatusReport() {}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getRecapNo() {
		return recapNo;
	}

	public void setRecapNo(String recapNo) {
		this.recapNo = recapNo;
	}

	public int getThreadDepth1() {
		return threadDepth1;
	}

	public void setThreadDepth1(int threadDepth1) {
		this.threadDepth1 = threadDepth1;
	}

	public int getThreadDepth2() {
		return threadDepth2;
	}

	public void setThreadDepth2(int threadDepth2) {
		this.threadDepth2 = threadDepth2;
	}

	public int getThreadDepth3() {
		return threadDepth3;
	}

	public void setThreadDepth3(int threadDepth3) {
		this.threadDepth3 = threadDepth3;
	}

	public String getPlateno() {
		return plateno;
	}

	public void setPlateno(String plateno) {
		this.plateno = plateno;
	}

	public String getWheelPosition() {
		return wheelPosition;
	}

	public void setWheelPosition(String wheelPosition) {
		this.wheelPosition = wheelPosition;
	}

	public String getLorryNo() {
		return lorryNo;
	}

	public void setLorryNo(String lorryNo) {
		this.lorryNo = lorryNo;
	}

	
}
