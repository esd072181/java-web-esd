package com.transport.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;

import com.transport.util.TransportUtils;

/**
 * 
 * @author dward
 * @since 25Mar2019
 * DateUpdated: 18Nov2019
 */
public class MaintenanceMonitoring implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String plateNo;
	private String trailerNo;
	private String lorryNo;	
	private int capacity;
	private int year;
	private int month;
	private String category;	
	private String gps1;
	private int gpsColor1;
	private String gpsRemarks1;
	private String maintenance1;
	private int maintenanceColor1;
	private String maintenanceRemarks1;
	private int availableVolume1;
	private String gps2;
	private int gpsColor2;
	private String gpsRemarks2;
	private String maintenance2;
	private int maintenanceColor2;
	private String maintenanceRemarks2;
	private int availableVolume2;
	private String gps3;
	private int gpsColor3;
	private String gpsRemarks3;
	private String maintenance3;
	private int maintenanceColor3;
	private String maintenanceRemarks3;
	private int availableVolume3;
	private String gps4;
	private int gpsColor4;
	private String gpsRemarks4;
	private String maintenance4;
	private int maintenanceColor4;
	private String maintenanceRemarks4;
	private int availableVolume4;
	private String gps5;
	private int gpsColor5;
	private String gpsRemarks5;
	private String maintenance5;
	private int maintenanceColor5;
	private String maintenanceRemarks5;
	private int availableVolume5;
	private String gps6;
	private int gpsColor6;
	private String gpsRemarks6;
	private String maintenance6;
	private int maintenanceColor6;
	private String maintenanceRemarks6;
	private int availableVolume6;
	private String gps7;
	private int gpsColor7;
	private String gpsRemarks7;
	private String maintenance7;
	private int maintenanceColor7;
	private String maintenanceRemarks7;
	private int availableVolume7;
	private String gps8;
	private int gpsColor8;
	private String gpsRemarks8;
	private String maintenance8;
	private int maintenanceColor8;
	private String maintenanceRemarks8;
	private int availableVolume8;
	private String gps9;
	private int gpsColor9;
	private String gpsRemarks9;
	private String maintenance9;
	private int maintenanceColor9;
	private String maintenanceRemarks9;
	private int availableVolume9;
	private String gps10;
	private int gpsColor10;
	private String gpsRemarks10;
	private String maintenance10;
	private int maintenanceColor10;
	private String maintenanceRemarks10;
	private int availableVolume10;
	private String gps11;
	private int gpsColor11;
	private String gpsRemarks11;
	private String maintenance11;
	private int maintenanceColor11;
	private String maintenanceRemarks11;
	private int availableVolume11;
	private String gps12;
	private int gpsColor12;
	private String gpsRemarks12;
	private String maintenance12;
	private int maintenanceColor12;
	private String maintenanceRemarks12;
	private int availableVolume12;
	private String gps13;
	private int gpsColor13;
	private String gpsRemarks13;
	private String maintenance13;
	private int maintenanceColor13;
	private String maintenanceRemarks13;
	private int availableVolume13;
	private String gps14;
	private int gpsColor14;
	private String gpsRemarks14;
	private String maintenance14;
	private int maintenanceColor14;
	private String maintenanceRemarks14;
	private int availableVolume14;
	private String gps15;
	private int gpsColor15;
	private String gpsRemarks15;
	private String maintenance15;
	private int maintenanceColor15;
	private String maintenanceRemarks15;
	private int availableVolume15;
	private String gps16;
	private int gpsColor16;
	private String gpsRemarks16;
	private String maintenance16;
	private int maintenanceColor16;
	private String maintenanceRemarks16;
	private int availableVolume16;
	private String gps17;
	private int gpsColor17;
	private String gpsRemarks17;
	private String maintenance17;
	private int maintenanceColor17;
	private String maintenanceRemarks17;
	private int availableVolume17;
	private String gps18;
	private int gpsColor18;
	private String gpsRemarks18;
	private String maintenance18;
	private int maintenanceColor18;
	private String maintenanceRemarks18;
	private int availableVolume18;
	private String gps19;
	private int gpsColor19;
	private String gpsRemarks19;
	private String maintenance19;
	private int maintenanceColor19;
	private String maintenanceRemarks19;
	private int availableVolume19;
	private String gps20;
	private int gpsColor20;
	private String gpsRemarks20;
	private String maintenance20;
	private int maintenanceColor20;
	private String maintenanceRemarks20;
	private int availableVolume20;
	private String gps21;
	private int gpsColor21;
	private String gpsRemarks21;
	private String maintenance21;
	private int maintenanceColor21;
	private String maintenanceRemarks21;
	private int availableVolume21;
	private String gps22;
	private int gpsColor22;
	private String gpsRemarks22;
	private String maintenance22;
	private int maintenanceColor22;
	private String maintenanceRemarks22;
	private int availableVolume22;
	private String gps23;
	private int gpsColor23;
	private String gpsRemarks23;
	private String maintenance23;
	private int maintenanceColor23;
	private String maintenanceRemarks23;
	private int availableVolume23;
	private String gps24;
	private int gpsColor24;
	private String gpsRemarks24;
	private String maintenance24;
	private int maintenanceColor24;
	private String maintenanceRemarks24;
	private int availableVolume24;
	private String gps25;
	private int gpsColor25;
	private String gpsRemarks25;
	private String maintenance25;
	private int maintenanceColor25;
	private String maintenanceRemarks25;
	private int availableVolume25;
	private String gps26;
	private int gpsColor26;
	private String gpsRemarks26;
	private String maintenance26;
	private int maintenanceColor26;
	private String maintenanceRemarks26;
	private int availableVolume26;
	private String gps27;
	private int gpsColor27;
	private String gpsRemarks27;
	private String maintenance27;
	private int maintenanceColor27;
	private String maintenanceRemarks27;
	private int availableVolume27;
	private String gps28;
	private int gpsColor28;
	private String gpsRemarks28;
	private String maintenance28;
	private int maintenanceColor28;
	private String maintenanceRemarks28;
	private int availableVolume28;
	private String gps29;
	private int gpsColor29;
	private String gpsRemarks29;
	private String maintenance29;
	private int maintenanceColor29;
	private String maintenanceRemarks29;
	private int availableVolume29;
	private String gps30;
	private int gpsColor30;
	private String gpsRemarks30;
	private String maintenance30;
	private int maintenanceColor30;
	private String maintenanceRemarks30;
	private int availableVolume30;
	private String gps31;
	private int gpsColor31;
	private String gpsRemarks31;
	private String maintenance31;
	private int maintenanceColor31;
	private String maintenanceRemarks31;
	private int availableVolume31;
	private int createdBy;
	private Timestamp createdOn;
	private int modifiedBy;
	private Timestamp modifiedOn;
	private int version;
	private boolean active;
	private int transportId;
	
	private int gpsTripIssue1;
	private int gpsTripIssue2;
	private int gpsTripIssue3;
	private int gpsTripIssue4;
	private int gpsTripIssue5;
	private int gpsTripIssue6;
	private int gpsTripIssue7;
	private int gpsTripIssue8;
	private int gpsTripIssue9;
	private int gpsTripIssue10;
	private int gpsTripIssue11;
	private int gpsTripIssue12;
	private int gpsTripIssue13;
	private int gpsTripIssue14;
	private int gpsTripIssue15;
	private int gpsTripIssue16;
	private int gpsTripIssue17;
	private int gpsTripIssue18;
	private int gpsTripIssue19;
	private int gpsTripIssue20;
	private int gpsTripIssue21;
	private int gpsTripIssue22;
	private int gpsTripIssue23;
	private int gpsTripIssue24;
	private int gpsTripIssue25;
	private int gpsTripIssue26;
	private int gpsTripIssue27;
	private int gpsTripIssue28;
	private int gpsTripIssue29;
	private int gpsTripIssue30;
	private int gpsTripIssue31;
	
	//non-persistent
	private int day;
	private int totalMaintenance;
	private int totalAvailableVolume;
	private int totalBreakdown;
	private int totalPM;
	private int totalPending;
	private int totalTargetDate;
	private int totalExtended;
	private int totalEarlyDone;
	private int totalTripsGPS;
	private int totalTripsGPSWeek1;
	private int totalAvailabilityWeek1;
	private int totalTripsGPSWeek2;
	private int totalAvailabilityWeek2;
	private int totalTripsGPSWeek3;
	private int totalAvailabilityWeek3;
	private int totalTripsGPSWeek4;
	private int totalAvailabilityWeek4;
	private int totalTripsGPSWeek5;
	private int totalGpsTripIssueTI;//Terminal Issue (1401)
	private int totalGpsTripIssueMI;//Maintenance Issue (1402)
	private int totalGpsTripIssueDI;//Driver Issue (1403)
	private int totalGpsTripIssueCI;//Customer Issue (1404)
	private int totalGpsTripIssueLV;//Low Volume (1405)
	private int totalGpsTripIssueLH;//Long Haul (1406)
	private int totalGpsTripIssueTBI;//Truck Ban Issue (1407)
	private int totalGpsTripIssueRI;//Road Issue (1408)
	private int gps1Vol;
	private int gps2Vol;
	private int gps3Vol;
	private int gps4Vol;
	private int gps5Vol;
	private int gps6Vol;
	private int gps7Vol;
	private int gps8Vol;
	private int gps9Vol;
	private int gps10Vol;
	private int gps11Vol;
	private int gps12Vol;
	private int gps13Vol;
	private int gps14Vol;
	private int gps15Vol;
	private int gps16Vol;
	private int gps17Vol;
	private int gps18Vol;
	private int gps19Vol;
	private int gps20Vol;
	private int gps21Vol;
	private int gps22Vol;
	private int gps23Vol;
	private int gps24Vol;
	private int gps25Vol;
	private int gps26Vol;
	private int gps27Vol;
	private int gps28Vol;
	private int gps29Vol;
	private int gps30Vol;
	private int gps31Vol;
	private int gpsWeek1Vol;
	private int gpsWeek2Vol;
	private int gpsWeek3Vol;
	private int gpsWeek4Vol;
	private int gpsWeek5Vol;
	private int gpsMonthVol;
	
	public MaintenanceMonitoring(){}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlateNo() {
		return plateNo;
	}

	public void setPlateNo(String plateNo) {
		this.plateNo = plateNo;
	}

	public String getTrailerNo() {
		return trailerNo;
	}

	public void setTrailerNo(String trailerNo) {
		this.trailerNo = trailerNo;
	}

	public String getLorryNo() {
		return lorryNo;
	}

	public void setLorryNo(String lorryNo) {
		this.lorryNo = lorryNo;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getGpsColor1() {
		return gpsColor1;
	}

	public void setGpsColor1(int gpsColor1) {
		this.gpsColor1 = gpsColor1;
	}

	public String getGpsRemarks1() {
		return gpsRemarks1;
	}

	public void setGpsRemarks1(String gpsRemarks1) {
		this.gpsRemarks1 = gpsRemarks1;
	}

	public String getMaintenance1() {
		return maintenance1;
	}

	public void setMaintenance1(String maintenance1) {
		this.maintenance1 = maintenance1;
	}

	public int getMaintenanceColor1() {
		return maintenanceColor1;
	}

	public void setMaintenanceColor1(int maintenanceColor1) {
		this.maintenanceColor1 = maintenanceColor1;
	}

	public String getMaintenanceRemarks1() {
		return maintenanceRemarks1;
	}

	public void setMaintenanceRemarks1(String maintenanceRemarks1) {
		this.maintenanceRemarks1 = maintenanceRemarks1;
	}

	public int getAvailableVolume1() {
		return availableVolume1;
	}

	public void setAvailableVolume1(int availableVolume1) {
		this.availableVolume1 = availableVolume1;
	}

	public int getGpsColor2() {
		return gpsColor2;
	}

	public void setGpsColor2(int gpsColor2) {
		this.gpsColor2 = gpsColor2;
	}

	public String getGpsRemarks2() {
		return gpsRemarks2;
	}

	public void setGpsRemarks2(String gpsRemarks2) {
		this.gpsRemarks2 = gpsRemarks2;
	}

	public String getMaintenance2() {
		return maintenance2;
	}

	public void setMaintenance2(String maintenance2) {
		this.maintenance2 = maintenance2;
	}

	public int getMaintenanceColor2() {
		return maintenanceColor2;
	}

	public void setMaintenanceColor2(int maintenanceColor2) {
		this.maintenanceColor2 = maintenanceColor2;
	}

	public String getMaintenanceRemarks2() {
		return maintenanceRemarks2;
	}

	public void setMaintenanceRemarks2(String maintenanceRemarks2) {
		this.maintenanceRemarks2 = maintenanceRemarks2;
	}

	public int getAvailableVolume2() {
		return availableVolume2;
	}

	public void setAvailableVolume2(int availableVolume2) {
		this.availableVolume2 = availableVolume2;
	}

	public int getGpsColor3() {
		return gpsColor3;
	}

	public void setGpsColor3(int gpsColor3) {
		this.gpsColor3 = gpsColor3;
	}

	public String getGpsRemarks3() {
		return gpsRemarks3;
	}

	public void setGpsRemarks3(String gpsRemarks3) {
		this.gpsRemarks3 = gpsRemarks3;
	}

	public String getMaintenance3() {
		return maintenance3;
	}

	public void setMaintenance3(String maintenance3) {
		this.maintenance3 = maintenance3;
	}

	public int getMaintenanceColor3() {
		return maintenanceColor3;
	}

	public void setMaintenanceColor3(int maintenanceColor3) {
		this.maintenanceColor3 = maintenanceColor3;
	}

	public String getMaintenanceRemarks3() {
		return maintenanceRemarks3;
	}

	public void setMaintenanceRemarks3(String maintenanceRemarks3) {
		this.maintenanceRemarks3 = maintenanceRemarks3;
	}

	public int getAvailableVolume3() {
		return availableVolume3;
	}

	public void setAvailableVolume3(int availableVolume3) {
		this.availableVolume3 = availableVolume3;
	}

	public int getGpsColor4() {
		return gpsColor4;
	}

	public void setGpsColor4(int gpsColor4) {
		this.gpsColor4 = gpsColor4;
	}

	public String getGpsRemarks4() {
		return gpsRemarks4;
	}

	public void setGpsRemarks4(String gpsRemarks4) {
		this.gpsRemarks4 = gpsRemarks4;
	}

	public String getMaintenance4() {
		return maintenance4;
	}

	public void setMaintenance4(String maintenance4) {
		this.maintenance4 = maintenance4;
	}

	public int getMaintenanceColor4() {
		return maintenanceColor4;
	}

	public void setMaintenanceColor4(int maintenanceColor4) {
		this.maintenanceColor4 = maintenanceColor4;
	}

	public String getMaintenanceRemarks4() {
		return maintenanceRemarks4;
	}

	public void setMaintenanceRemarks4(String maintenanceRemarks4) {
		this.maintenanceRemarks4 = maintenanceRemarks4;
	}

	public int getAvailableVolume4() {
		return availableVolume4;
	}

	public void setAvailableVolume4(int availableVolume4) {
		this.availableVolume4 = availableVolume4;
	}

	public int getGpsColor5() {
		return gpsColor5;
	}

	public void setGpsColor5(int gpsColor5) {
		this.gpsColor5 = gpsColor5;
	}

	public String getGpsRemarks5() {
		return gpsRemarks5;
	}

	public void setGpsRemarks5(String gpsRemarks5) {
		this.gpsRemarks5 = gpsRemarks5;
	}

	public String getMaintenance5() {
		return maintenance5;
	}

	public void setMaintenance5(String maintenance5) {
		this.maintenance5 = maintenance5;
	}

	public int getMaintenanceColor5() {
		return maintenanceColor5;
	}

	public void setMaintenanceColor5(int maintenanceColor5) {
		this.maintenanceColor5 = maintenanceColor5;
	}

	public String getMaintenanceRemarks5() {
		return maintenanceRemarks5;
	}

	public void setMaintenanceRemarks5(String maintenanceRemarks5) {
		this.maintenanceRemarks5 = maintenanceRemarks5;
	}

	public int getAvailableVolume5() {
		return availableVolume5;
	}

	public void setAvailableVolume5(int availableVolume5) {
		this.availableVolume5 = availableVolume5;
	}

	public int getGpsColor6() {
		return gpsColor6;
	}

	public void setGpsColor6(int gpsColor6) {
		this.gpsColor6 = gpsColor6;
	}

	public String getGpsRemarks6() {
		return gpsRemarks6;
	}

	public void setGpsRemarks6(String gpsRemarks6) {
		this.gpsRemarks6 = gpsRemarks6;
	}

	public String getMaintenance6() {
		return maintenance6;
	}

	public void setMaintenance6(String maintenance6) {
		this.maintenance6 = maintenance6;
	}

	public int getMaintenanceColor6() {
		return maintenanceColor6;
	}

	public void setMaintenanceColor6(int maintenanceColor6) {
		this.maintenanceColor6 = maintenanceColor6;
	}

	public String getMaintenanceRemarks6() {
		return maintenanceRemarks6;
	}

	public void setMaintenanceRemarks6(String maintenanceRemarks6) {
		this.maintenanceRemarks6 = maintenanceRemarks6;
	}

	public int getAvailableVolume6() {
		return availableVolume6;
	}

	public void setAvailableVolume6(int availableVolume6) {
		this.availableVolume6 = availableVolume6;
	}

	public int getGpsColor7() {
		return gpsColor7;
	}

	public void setGpsColor7(int gpsColor7) {
		this.gpsColor7 = gpsColor7;
	}

	public String getGpsRemarks7() {
		return gpsRemarks7;
	}

	public void setGpsRemarks7(String gpsRemarks7) {
		this.gpsRemarks7 = gpsRemarks7;
	}

	public String getMaintenance7() {
		return maintenance7;
	}

	public void setMaintenance7(String maintenance7) {
		this.maintenance7 = maintenance7;
	}

	public int getMaintenanceColor7() {
		return maintenanceColor7;
	}

	public void setMaintenanceColor7(int maintenanceColor7) {
		this.maintenanceColor7 = maintenanceColor7;
	}

	public String getMaintenanceRemarks7() {
		return maintenanceRemarks7;
	}

	public void setMaintenanceRemarks7(String maintenanceRemarks7) {
		this.maintenanceRemarks7 = maintenanceRemarks7;
	}

	public int getAvailableVolume7() {
		return availableVolume7;
	}

	public void setAvailableVolume7(int availableVolume7) {
		this.availableVolume7 = availableVolume7;
	}

	public int getGpsColor8() {
		return gpsColor8;
	}

	public void setGpsColor8(int gpsColor8) {
		this.gpsColor8 = gpsColor8;
	}

	public String getGpsRemarks8() {
		return gpsRemarks8;
	}

	public void setGpsRemarks8(String gpsRemarks8) {
		this.gpsRemarks8 = gpsRemarks8;
	}

	public String getMaintenance8() {
		return maintenance8;
	}

	public void setMaintenance8(String maintenance8) {
		this.maintenance8 = maintenance8;
	}

	public int getMaintenanceColor8() {
		return maintenanceColor8;
	}

	public void setMaintenanceColor8(int maintenanceColor8) {
		this.maintenanceColor8 = maintenanceColor8;
	}

	public String getMaintenanceRemarks8() {
		return maintenanceRemarks8;
	}

	public void setMaintenanceRemarks8(String maintenanceRemarks8) {
		this.maintenanceRemarks8 = maintenanceRemarks8;
	}

	public int getAvailableVolume8() {
		return availableVolume8;
	}

	public void setAvailableVolume8(int availableVolume8) {
		this.availableVolume8 = availableVolume8;
	}

	public int getGpsColor9() {
		return gpsColor9;
	}

	public void setGpsColor9(int gpsColor9) {
		this.gpsColor9 = gpsColor9;
	}

	public String getGpsRemarks9() {
		return gpsRemarks9;
	}

	public void setGpsRemarks9(String gpsRemarks9) {
		this.gpsRemarks9 = gpsRemarks9;
	}

	public String getMaintenance9() {
		return maintenance9;
	}

	public void setMaintenance9(String maintenance9) {
		this.maintenance9 = maintenance9;
	}

	public int getMaintenanceColor9() {
		return maintenanceColor9;
	}

	public void setMaintenanceColor9(int maintenanceColor9) {
		this.maintenanceColor9 = maintenanceColor9;
	}

	public String getMaintenanceRemarks9() {
		return maintenanceRemarks9;
	}

	public void setMaintenanceRemarks9(String maintenanceRemarks9) {
		this.maintenanceRemarks9 = maintenanceRemarks9;
	}

	public int getAvailableVolume9() {
		return availableVolume9;
	}

	public void setAvailableVolume9(int availableVolume9) {
		this.availableVolume9 = availableVolume9;
	}

	public int getGpsColor10() {
		return gpsColor10;
	}

	public void setGpsColor10(int gpsColor10) {
		this.gpsColor10 = gpsColor10;
	}

	public String getGpsRemarks10() {
		return gpsRemarks10;
	}

	public void setGpsRemarks10(String gpsRemarks10) {
		this.gpsRemarks10 = gpsRemarks10;
	}

	public String getMaintenance10() {
		return maintenance10;
	}

	public void setMaintenance10(String maintenance10) {
		this.maintenance10 = maintenance10;
	}

	public int getMaintenanceColor10() {
		return maintenanceColor10;
	}

	public void setMaintenanceColor10(int maintenanceColor10) {
		this.maintenanceColor10 = maintenanceColor10;
	}

	public String getMaintenanceRemarks10() {
		return maintenanceRemarks10;
	}

	public void setMaintenanceRemarks10(String maintenanceRemarks10) {
		this.maintenanceRemarks10 = maintenanceRemarks10;
	}

	public int getAvailableVolume10() {
		return availableVolume10;
	}

	public void setAvailableVolume10(int availableVolume10) {
		this.availableVolume10 = availableVolume10;
	}

	public int getGpsColor11() {
		return gpsColor11;
	}

	public void setGpsColor11(int gpsColor11) {
		this.gpsColor11 = gpsColor11;
	}

	public String getGpsRemarks11() {
		return gpsRemarks11;
	}

	public void setGpsRemarks11(String gpsRemarks11) {
		this.gpsRemarks11 = gpsRemarks11;
	}

	public String getMaintenance11() {
		return maintenance11;
	}

	public void setMaintenance11(String maintenance11) {
		this.maintenance11 = maintenance11;
	}

	public int getMaintenanceColor11() {
		return maintenanceColor11;
	}

	public void setMaintenanceColor11(int maintenanceColor11) {
		this.maintenanceColor11 = maintenanceColor11;
	}

	public String getMaintenanceRemarks11() {
		return maintenanceRemarks11;
	}

	public void setMaintenanceRemarks11(String maintenanceRemarks11) {
		this.maintenanceRemarks11 = maintenanceRemarks11;
	}

	public int getAvailableVolume11() {
		return availableVolume11;
	}

	public void setAvailableVolume11(int availableVolume11) {
		this.availableVolume11 = availableVolume11;
	}

	public int getGpsColor12() {
		return gpsColor12;
	}

	public void setGpsColor12(int gpsColor12) {
		this.gpsColor12 = gpsColor12;
	}

	public String getGpsRemarks12() {
		return gpsRemarks12;
	}

	public void setGpsRemarks12(String gpsRemarks12) {
		this.gpsRemarks12 = gpsRemarks12;
	}

	public String getMaintenance12() {
		return maintenance12;
	}

	public void setMaintenance12(String maintenance12) {
		this.maintenance12 = maintenance12;
	}

	public int getMaintenanceColor12() {
		return maintenanceColor12;
	}

	public void setMaintenanceColor12(int maintenanceColor12) {
		this.maintenanceColor12 = maintenanceColor12;
	}

	public String getMaintenanceRemarks12() {
		return maintenanceRemarks12;
	}

	public void setMaintenanceRemarks12(String maintenanceRemarks12) {
		this.maintenanceRemarks12 = maintenanceRemarks12;
	}

	public int getAvailableVolume12() {
		return availableVolume12;
	}

	public void setAvailableVolume12(int availableVolume12) {
		this.availableVolume12 = availableVolume12;
	}

	public int getGpsColor13() {
		return gpsColor13;
	}

	public void setGpsColor13(int gpsColor13) {
		this.gpsColor13 = gpsColor13;
	}

	public String getGpsRemarks13() {
		return gpsRemarks13;
	}

	public void setGpsRemarks13(String gpsRemarks13) {
		this.gpsRemarks13 = gpsRemarks13;
	}

	public String getMaintenance13() {
		return maintenance13;
	}

	public void setMaintenance13(String maintenance13) {
		this.maintenance13 = maintenance13;
	}

	public int getMaintenanceColor13() {
		return maintenanceColor13;
	}

	public void setMaintenanceColor13(int maintenanceColor13) {
		this.maintenanceColor13 = maintenanceColor13;
	}

	public String getMaintenanceRemarks13() {
		return maintenanceRemarks13;
	}

	public void setMaintenanceRemarks13(String maintenanceRemarks13) {
		this.maintenanceRemarks13 = maintenanceRemarks13;
	}

	public int getAvailableVolume13() {
		return availableVolume13;
	}

	public void setAvailableVolume13(int availableVolume13) {
		this.availableVolume13 = availableVolume13;
	}

	public int getGpsColor14() {
		return gpsColor14;
	}

	public void setGpsColor14(int gpsColor14) {
		this.gpsColor14 = gpsColor14;
	}

	public String getGpsRemarks14() {
		return gpsRemarks14;
	}

	public void setGpsRemarks14(String gpsRemarks14) {
		this.gpsRemarks14 = gpsRemarks14;
	}

	public String getMaintenance14() {
		return maintenance14;
	}

	public void setMaintenance14(String maintenance14) {
		this.maintenance14 = maintenance14;
	}

	public int getMaintenanceColor14() {
		return maintenanceColor14;
	}

	public void setMaintenanceColor14(int maintenanceColor14) {
		this.maintenanceColor14 = maintenanceColor14;
	}

	public String getMaintenanceRemarks14() {
		return maintenanceRemarks14;
	}

	public void setMaintenanceRemarks14(String maintenanceRemarks14) {
		this.maintenanceRemarks14 = maintenanceRemarks14;
	}

	public int getAvailableVolume14() {
		return availableVolume14;
	}

	public void setAvailableVolume14(int availableVolume14) {
		this.availableVolume14 = availableVolume14;
	}

	public int getGpsColor15() {
		return gpsColor15;
	}

	public void setGpsColor15(int gpsColor15) {
		this.gpsColor15 = gpsColor15;
	}

	public String getGpsRemarks15() {
		return gpsRemarks15;
	}

	public void setGpsRemarks15(String gpsRemarks15) {
		this.gpsRemarks15 = gpsRemarks15;
	}

	public String getMaintenance15() {
		return maintenance15;
	}

	public void setMaintenance15(String maintenance15) {
		this.maintenance15 = maintenance15;
	}

	public int getMaintenanceColor15() {
		return maintenanceColor15;
	}

	public void setMaintenanceColor15(int maintenanceColor15) {
		this.maintenanceColor15 = maintenanceColor15;
	}

	public String getMaintenanceRemarks15() {
		return maintenanceRemarks15;
	}

	public void setMaintenanceRemarks15(String maintenanceRemarks15) {
		this.maintenanceRemarks15 = maintenanceRemarks15;
	}

	public int getAvailableVolume15() {
		return availableVolume15;
	}

	public void setAvailableVolume15(int availableVolume15) {
		this.availableVolume15 = availableVolume15;
	}

	public int getGpsColor16() {
		return gpsColor16;
	}

	public void setGpsColor16(int gpsColor16) {
		this.gpsColor16 = gpsColor16;
	}

	public String getGpsRemarks16() {
		return gpsRemarks16;
	}

	public void setGpsRemarks16(String gpsRemarks16) {
		this.gpsRemarks16 = gpsRemarks16;
	}

	public String getMaintenance16() {
		return maintenance16;
	}

	public void setMaintenance16(String maintenance16) {
		this.maintenance16 = maintenance16;
	}

	public int getMaintenanceColor16() {
		return maintenanceColor16;
	}

	public void setMaintenanceColor16(int maintenanceColor16) {
		this.maintenanceColor16 = maintenanceColor16;
	}

	public String getMaintenanceRemarks16() {
		return maintenanceRemarks16;
	}

	public void setMaintenanceRemarks16(String maintenanceRemarks16) {
		this.maintenanceRemarks16 = maintenanceRemarks16;
	}

	public int getAvailableVolume16() {
		return availableVolume16;
	}

	public void setAvailableVolume16(int availableVolume16) {
		this.availableVolume16 = availableVolume16;
	}

	public int getGpsColor17() {
		return gpsColor17;
	}

	public void setGpsColor17(int gpsColor17) {
		this.gpsColor17 = gpsColor17;
	}

	public String getGpsRemarks17() {
		return gpsRemarks17;
	}

	public void setGpsRemarks17(String gpsRemarks17) {
		this.gpsRemarks17 = gpsRemarks17;
	}

	public String getMaintenance17() {
		return maintenance17;
	}

	public void setMaintenance17(String maintenance17) {
		this.maintenance17 = maintenance17;
	}

	public int getMaintenanceColor17() {
		return maintenanceColor17;
	}

	public void setMaintenanceColor17(int maintenanceColor17) {
		this.maintenanceColor17 = maintenanceColor17;
	}

	public String getMaintenanceRemarks17() {
		return maintenanceRemarks17;
	}

	public void setMaintenanceRemarks17(String maintenanceRemarks17) {
		this.maintenanceRemarks17 = maintenanceRemarks17;
	}

	public int getAvailableVolume17() {
		return availableVolume17;
	}

	public void setAvailableVolume17(int availableVolume17) {
		this.availableVolume17 = availableVolume17;
	}

	public int getGpsColor18() {
		return gpsColor18;
	}

	public void setGpsColor18(int gpsColor18) {
		this.gpsColor18 = gpsColor18;
	}

	public String getGpsRemarks18() {
		return gpsRemarks18;
	}

	public void setGpsRemarks18(String gpsRemarks18) {
		this.gpsRemarks18 = gpsRemarks18;
	}

	public String getMaintenance18() {
		return maintenance18;
	}

	public void setMaintenance18(String maintenance18) {
		this.maintenance18 = maintenance18;
	}

	public int getMaintenanceColor18() {
		return maintenanceColor18;
	}

	public void setMaintenanceColor18(int maintenanceColor18) {
		this.maintenanceColor18 = maintenanceColor18;
	}

	public String getMaintenanceRemarks18() {
		return maintenanceRemarks18;
	}

	public void setMaintenanceRemarks18(String maintenanceRemarks18) {
		this.maintenanceRemarks18 = maintenanceRemarks18;
	}

	public int getAvailableVolume18() {
		return availableVolume18;
	}

	public void setAvailableVolume18(int availableVolume18) {
		this.availableVolume18 = availableVolume18;
	}

	public int getGpsColor19() {
		return gpsColor19;
	}

	public void setGpsColor19(int gpsColor19) {
		this.gpsColor19 = gpsColor19;
	}

	public String getGpsRemarks19() {
		return gpsRemarks19;
	}

	public void setGpsRemarks19(String gpsRemarks19) {
		this.gpsRemarks19 = gpsRemarks19;
	}

	public String getMaintenance19() {
		return maintenance19;
	}

	public void setMaintenance19(String maintenance19) {
		this.maintenance19 = maintenance19;
	}

	public int getMaintenanceColor19() {
		return maintenanceColor19;
	}

	public void setMaintenanceColor19(int maintenanceColor19) {
		this.maintenanceColor19 = maintenanceColor19;
	}

	public String getMaintenanceRemarks19() {
		return maintenanceRemarks19;
	}

	public void setMaintenanceRemarks19(String maintenanceRemarks19) {
		this.maintenanceRemarks19 = maintenanceRemarks19;
	}

	public int getAvailableVolume19() {
		return availableVolume19;
	}

	public void setAvailableVolume19(int availableVolume19) {
		this.availableVolume19 = availableVolume19;
	}

	public int getGpsColor20() {
		return gpsColor20;
	}

	public void setGpsColor20(int gpsColor20) {
		this.gpsColor20 = gpsColor20;
	}

	public String getGpsRemarks20() {
		return gpsRemarks20;
	}

	public void setGpsRemarks20(String gpsRemarks20) {
		this.gpsRemarks20 = gpsRemarks20;
	}

	public String getMaintenance20() {
		return maintenance20;
	}

	public void setMaintenance20(String maintenance20) {
		this.maintenance20 = maintenance20;
	}

	public int getMaintenanceColor20() {
		return maintenanceColor20;
	}

	public void setMaintenanceColor20(int maintenanceColor20) {
		this.maintenanceColor20 = maintenanceColor20;
	}

	public String getMaintenanceRemarks20() {
		return maintenanceRemarks20;
	}

	public void setMaintenanceRemarks20(String maintenanceRemarks20) {
		this.maintenanceRemarks20 = maintenanceRemarks20;
	}

	public int getAvailableVolume20() {
		return availableVolume20;
	}

	public void setAvailableVolume20(int availableVolume20) {
		this.availableVolume20 = availableVolume20;
	}

	public int getGpsColor21() {
		return gpsColor21;
	}

	public void setGpsColor21(int gpsColor21) {
		this.gpsColor21 = gpsColor21;
	}

	public String getGpsRemarks21() {
		return gpsRemarks21;
	}

	public void setGpsRemarks21(String gpsRemarks21) {
		this.gpsRemarks21 = gpsRemarks21;
	}

	public String getMaintenance21() {
		return maintenance21;
	}

	public void setMaintenance21(String maintenance21) {
		this.maintenance21 = maintenance21;
	}

	public int getMaintenanceColor21() {
		return maintenanceColor21;
	}

	public void setMaintenanceColor21(int maintenanceColor21) {
		this.maintenanceColor21 = maintenanceColor21;
	}

	public String getMaintenanceRemarks21() {
		return maintenanceRemarks21;
	}

	public void setMaintenanceRemarks21(String maintenanceRemarks21) {
		this.maintenanceRemarks21 = maintenanceRemarks21;
	}

	public int getAvailableVolume21() {
		return availableVolume21;
	}

	public void setAvailableVolume21(int availableVolume21) {
		this.availableVolume21 = availableVolume21;
	}

	public int getGpsColor22() {
		return gpsColor22;
	}

	public void setGpsColor22(int gpsColor22) {
		this.gpsColor22 = gpsColor22;
	}

	public String getGpsRemarks22() {
		return gpsRemarks22;
	}

	public void setGpsRemarks22(String gpsRemarks22) {
		this.gpsRemarks22 = gpsRemarks22;
	}

	public String getMaintenance22() {
		return maintenance22;
	}

	public void setMaintenance22(String maintenance22) {
		this.maintenance22 = maintenance22;
	}

	public int getMaintenanceColor22() {
		return maintenanceColor22;
	}

	public void setMaintenanceColor22(int maintenanceColor22) {
		this.maintenanceColor22 = maintenanceColor22;
	}

	public String getMaintenanceRemarks22() {
		return maintenanceRemarks22;
	}

	public void setMaintenanceRemarks22(String maintenanceRemarks22) {
		this.maintenanceRemarks22 = maintenanceRemarks22;
	}

	public int getAvailableVolume22() {
		return availableVolume22;
	}

	public void setAvailableVolume22(int availableVolume22) {
		this.availableVolume22 = availableVolume22;
	}

	public int getGpsColor23() {
		return gpsColor23;
	}

	public void setGpsColor23(int gpsColor23) {
		this.gpsColor23 = gpsColor23;
	}

	public String getGpsRemarks23() {
		return gpsRemarks23;
	}

	public void setGpsRemarks23(String gpsRemarks23) {
		this.gpsRemarks23 = gpsRemarks23;
	}

	public String getMaintenance23() {
		return maintenance23;
	}

	public void setMaintenance23(String maintenance23) {
		this.maintenance23 = maintenance23;
	}

	public int getMaintenanceColor23() {
		return maintenanceColor23;
	}

	public void setMaintenanceColor23(int maintenanceColor23) {
		this.maintenanceColor23 = maintenanceColor23;
	}

	public String getMaintenanceRemarks23() {
		return maintenanceRemarks23;
	}

	public void setMaintenanceRemarks23(String maintenanceRemarks23) {
		this.maintenanceRemarks23 = maintenanceRemarks23;
	}

	public int getAvailableVolume23() {
		return availableVolume23;
	}

	public void setAvailableVolume23(int availableVolume23) {
		this.availableVolume23 = availableVolume23;
	}

	public int getGpsColor24() {
		return gpsColor24;
	}

	public void setGpsColor24(int gpsColor24) {
		this.gpsColor24 = gpsColor24;
	}

	public String getGpsRemarks24() {
		return gpsRemarks24;
	}

	public void setGpsRemarks24(String gpsRemarks24) {
		this.gpsRemarks24 = gpsRemarks24;
	}

	public String getMaintenance24() {
		return maintenance24;
	}

	public void setMaintenance24(String maintenance24) {
		this.maintenance24 = maintenance24;
	}

	public int getMaintenanceColor24() {
		return maintenanceColor24;
	}

	public void setMaintenanceColor24(int maintenanceColor24) {
		this.maintenanceColor24 = maintenanceColor24;
	}

	public String getMaintenanceRemarks24() {
		return maintenanceRemarks24;
	}

	public void setMaintenanceRemarks24(String maintenanceRemarks24) {
		this.maintenanceRemarks24 = maintenanceRemarks24;
	}

	public int getAvailableVolume24() {
		return availableVolume24;
	}

	public void setAvailableVolume24(int availableVolume24) {
		this.availableVolume24 = availableVolume24;
	}

	public int getGpsColor25() {
		return gpsColor25;
	}

	public void setGpsColor25(int gpsColor25) {
		this.gpsColor25 = gpsColor25;
	}

	public String getGpsRemarks25() {
		return gpsRemarks25;
	}

	public void setGpsRemarks25(String gpsRemarks25) {
		this.gpsRemarks25 = gpsRemarks25;
	}

	public String getMaintenance25() {
		return maintenance25;
	}

	public void setMaintenance25(String maintenance25) {
		this.maintenance25 = maintenance25;
	}

	public int getMaintenanceColor25() {
		return maintenanceColor25;
	}

	public void setMaintenanceColor25(int maintenanceColor25) {
		this.maintenanceColor25 = maintenanceColor25;
	}

	public String getMaintenanceRemarks25() {
		return maintenanceRemarks25;
	}

	public void setMaintenanceRemarks25(String maintenanceRemarks25) {
		this.maintenanceRemarks25 = maintenanceRemarks25;
	}

	public int getAvailableVolume25() {
		return availableVolume25;
	}

	public void setAvailableVolume25(int availableVolume25) {
		this.availableVolume25 = availableVolume25;
	}

	public int getGpsColor26() {
		return gpsColor26;
	}

	public void setGpsColor26(int gpsColor26) {
		this.gpsColor26 = gpsColor26;
	}

	public String getGpsRemarks26() {
		return gpsRemarks26;
	}

	public void setGpsRemarks26(String gpsRemarks26) {
		this.gpsRemarks26 = gpsRemarks26;
	}

	public String getMaintenance26() {
		return maintenance26;
	}

	public void setMaintenance26(String maintenance26) {
		this.maintenance26 = maintenance26;
	}

	public int getMaintenanceColor26() {
		return maintenanceColor26;
	}

	public void setMaintenanceColor26(int maintenanceColor26) {
		this.maintenanceColor26 = maintenanceColor26;
	}

	public String getMaintenanceRemarks26() {
		return maintenanceRemarks26;
	}

	public void setMaintenanceRemarks26(String maintenanceRemarks26) {
		this.maintenanceRemarks26 = maintenanceRemarks26;
	}

	public int getAvailableVolume26() {
		return availableVolume26;
	}

	public void setAvailableVolume26(int availableVolume26) {
		this.availableVolume26 = availableVolume26;
	}

	public int getGpsColor27() {
		return gpsColor27;
	}

	public void setGpsColor27(int gpsColor27) {
		this.gpsColor27 = gpsColor27;
	}

	public String getGpsRemarks27() {
		return gpsRemarks27;
	}

	public void setGpsRemarks27(String gpsRemarks27) {
		this.gpsRemarks27 = gpsRemarks27;
	}

	public String getMaintenance27() {
		return maintenance27;
	}

	public void setMaintenance27(String maintenance27) {
		this.maintenance27 = maintenance27;
	}

	public int getMaintenanceColor27() {
		return maintenanceColor27;
	}

	public void setMaintenanceColor27(int maintenanceColor27) {
		this.maintenanceColor27 = maintenanceColor27;
	}

	public String getMaintenanceRemarks27() {
		return maintenanceRemarks27;
	}

	public void setMaintenanceRemarks27(String maintenanceRemarks27) {
		this.maintenanceRemarks27 = maintenanceRemarks27;
	}

	public int getAvailableVolume27() {
		return availableVolume27;
	}

	public void setAvailableVolume27(int availableVolume27) {
		this.availableVolume27 = availableVolume27;
	}

	public int getGpsColor28() {
		return gpsColor28;
	}

	public void setGpsColor28(int gpsColor28) {
		this.gpsColor28 = gpsColor28;
	}

	public String getGpsRemarks28() {
		return gpsRemarks28;
	}

	public void setGpsRemarks28(String gpsRemarks28) {
		this.gpsRemarks28 = gpsRemarks28;
	}

	public String getMaintenance28() {
		return maintenance28;
	}

	public void setMaintenance28(String maintenance28) {
		this.maintenance28 = maintenance28;
	}

	public int getMaintenanceColor28() {
		return maintenanceColor28;
	}

	public void setMaintenanceColor28(int maintenanceColor28) {
		this.maintenanceColor28 = maintenanceColor28;
	}

	public String getMaintenanceRemarks28() {
		return maintenanceRemarks28;
	}

	public void setMaintenanceRemarks28(String maintenanceRemarks28) {
		this.maintenanceRemarks28 = maintenanceRemarks28;
	}

	public int getAvailableVolume28() {
		return availableVolume28;
	}

	public void setAvailableVolume28(int availableVolume28) {
		this.availableVolume28 = availableVolume28;
	}

	public int getGpsColor29() {
		return gpsColor29;
	}

	public void setGpsColor29(int gpsColor29) {
		this.gpsColor29 = gpsColor29;
	}

	public String getGpsRemarks29() {
		return gpsRemarks29;
	}

	public void setGpsRemarks29(String gpsRemarks29) {
		this.gpsRemarks29 = gpsRemarks29;
	}

	public String getMaintenance29() {
		return maintenance29;
	}

	public void setMaintenance29(String maintenance29) {
		this.maintenance29 = maintenance29;
	}

	public int getMaintenanceColor29() {
		return maintenanceColor29;
	}

	public void setMaintenanceColor29(int maintenanceColor29) {
		this.maintenanceColor29 = maintenanceColor29;
	}

	public String getMaintenanceRemarks29() {
		return maintenanceRemarks29;
	}

	public void setMaintenanceRemarks29(String maintenanceRemarks29) {
		this.maintenanceRemarks29 = maintenanceRemarks29;
	}

	public int getAvailableVolume29() {
		return availableVolume29;
	}

	public void setAvailableVolume29(int availableVolume29) {
		this.availableVolume29 = availableVolume29;
	}

	public int getGpsColor30() {
		return gpsColor30;
	}

	public void setGpsColor30(int gpsColor30) {
		this.gpsColor30 = gpsColor30;
	}

	public String getGpsRemarks30() {
		return gpsRemarks30;
	}

	public void setGpsRemarks30(String gpsRemarks30) {
		this.gpsRemarks30 = gpsRemarks30;
	}

	public String getMaintenance30() {
		return maintenance30;
	}

	public void setMaintenance30(String maintenance30) {
		this.maintenance30 = maintenance30;
	}

	public int getMaintenanceColor30() {
		return maintenanceColor30;
	}

	public void setMaintenanceColor30(int maintenanceColor30) {
		this.maintenanceColor30 = maintenanceColor30;
	}

	public String getMaintenanceRemarks30() {
		return maintenanceRemarks30;
	}

	public void setMaintenanceRemarks30(String maintenanceRemarks30) {
		this.maintenanceRemarks30 = maintenanceRemarks30;
	}

	public int getAvailableVolume30() {
		return availableVolume30;
	}

	public void setAvailableVolume30(int availableVolume30) {
		this.availableVolume30 = availableVolume30;
	}

	public int getGpsColor31() {
		return gpsColor31;
	}

	public void setGpsColor31(int gpsColor31) {
		this.gpsColor31 = gpsColor31;
	}

	public String getGpsRemarks31() {
		return gpsRemarks31;
	}

	public void setGpsRemarks31(String gpsRemarks31) {
		this.gpsRemarks31 = gpsRemarks31;
	}

	public String getMaintenance31() {
		return maintenance31;
	}

	public void setMaintenance31(String maintenance31) {
		this.maintenance31 = maintenance31;
	}

	public int getMaintenanceColor31() {
		return maintenanceColor31;
	}

	public void setMaintenanceColor31(int maintenanceColor31) {
		this.maintenanceColor31 = maintenanceColor31;
	}

	public String getMaintenanceRemarks31() {
		return maintenanceRemarks31;
	}

	public void setMaintenanceRemarks31(String maintenanceRemarks31) {
		this.maintenanceRemarks31 = maintenanceRemarks31;
	}

	public int getAvailableVolume31() {
		return availableVolume31;
	}

	public void setAvailableVolume31(int availableVolume31) {
		this.availableVolume31 = availableVolume31;
	}

	public int getTotalMaintenance() {
		return totalMaintenance;
	}

	public void setTotalMaintenance(int totalMaintenance) {
		this.totalMaintenance = totalMaintenance;
	}

	public int getTotalAvailableVolume() {
		return totalAvailableVolume;
	}

	public void setTotalAvailableVolume(int totalAvailableVolume) {
		this.totalAvailableVolume = totalAvailableVolume;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public int getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Timestamp modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getTransportId() {
		return transportId;
	}

	public void setTransportId(int transportId) {
		this.transportId = transportId;
	}

	public int getTotalBreakdown() {
		return totalBreakdown;
	}

	public void setTotalBreakdown(int totalBreakdown) {
		this.totalBreakdown = totalBreakdown;
	}

	public int getTotalPM() {
		return totalPM;
	}

	public void setTotalPM(int totalPM) {
		this.totalPM = totalPM;
	}

	public int getTotalPending() {
		return totalPending;
	}

	public void setTotalPending(int totalPending) {
		this.totalPending = totalPending;
	}

	public int getTotalTripsGPS() {
		return totalTripsGPS;
	}

	public void setTotalTripsGPS(int totalTripsGPS) {
		this.totalTripsGPS = totalTripsGPS;
	}
	
	public String getGps1() {
		return gps1;
	}

	public void setGps1(String gps1) {
		this.gps1 = gps1;
	}

	public String getGps2() {
		return gps2;
	}

	public void setGps2(String gps2) {
		this.gps2 = gps2;
	}

	public String getGps3() {
		return gps3;
	}

	public void setGps3(String gps3) {
		this.gps3 = gps3;
	}

	public String getGps4() {
		return gps4;
	}

	public void setGps4(String gps4) {
		this.gps4 = gps4;
	}

	public String getGps5() {
		return gps5;
	}

	public void setGps5(String gps5) {
		this.gps5 = gps5;
	}

	public String getGps6() {
		return gps6;
	}

	public void setGps6(String gps6) {
		this.gps6 = gps6;
	}

	public String getGps7() {
		return gps7;
	}

	public void setGps7(String gps7) {
		this.gps7 = gps7;
	}

	public String getGps8() {
		return gps8;
	}

	public void setGps8(String gps8) {
		this.gps8 = gps8;
	}

	public String getGps9() {
		return gps9;
	}

	public void setGps9(String gps9) {
		this.gps9 = gps9;
	}

	public String getGps10() {
		return gps10;
	}

	public void setGps10(String gps10) {
		this.gps10 = gps10;
	}

	public String getGps11() {
		return gps11;
	}

	public void setGps11(String gps11) {
		this.gps11 = gps11;
	}

	public String getGps12() {
		return gps12;
	}

	public void setGps12(String gps12) {
		this.gps12 = gps12;
	}

	public String getGps13() {
		return gps13;
	}

	public void setGps13(String gps13) {
		this.gps13 = gps13;
	}

	public String getGps14() {
		return gps14;
	}

	public void setGps14(String gps14) {
		this.gps14 = gps14;
	}

	public String getGps15() {
		return gps15;
	}

	public void setGps15(String gps15) {
		this.gps15 = gps15;
	}

	public String getGps16() {
		return gps16;
	}

	public void setGps16(String gps16) {
		this.gps16 = gps16;
	}

	public String getGps17() {
		return gps17;
	}

	public void setGps17(String gps17) {
		this.gps17 = gps17;
	}

	public String getGps18() {
		return gps18;
	}

	public void setGps18(String gps18) {
		this.gps18 = gps18;
	}

	public String getGps19() {
		return gps19;
	}

	public void setGps19(String gps19) {
		this.gps19 = gps19;
	}

	public String getGps20() {
		return gps20;
	}

	public void setGps20(String gps20) {
		this.gps20 = gps20;
	}

	public String getGps21() {
		return gps21;
	}

	public void setGps21(String gps21) {
		this.gps21 = gps21;
	}

	public String getGps22() {
		return gps22;
	}

	public void setGps22(String gps22) {
		this.gps22 = gps22;
	}

	public String getGps23() {
		return gps23;
	}

	public void setGps23(String gps23) {
		this.gps23 = gps23;
	}

	public String getGps24() {
		return gps24;
	}

	public void setGps24(String gps24) {
		this.gps24 = gps24;
	}

	public String getGps25() {
		return gps25;
	}

	public void setGps25(String gps25) {
		this.gps25 = gps25;
	}

	public String getGps26() {
		return gps26;
	}

	public void setGps26(String gps26) {
		this.gps26 = gps26;
	}

	public String getGps27() {
		return gps27;
	}

	public void setGps27(String gps27) {
		this.gps27 = gps27;
	}

	public String getGps28() {
		return gps28;
	}

	public void setGps28(String gps28) {
		this.gps28 = gps28;
	}

	public String getGps29() {
		return gps29;
	}

	public void setGps29(String gps29) {
		this.gps29 = gps29;
	}

	public String getGps30() {
		return gps30;
	}

	public void setGps30(String gps30) {
		this.gps30 = gps30;
	}

	public String getGps31() {
		return gps31;
	}

	public void setGps31(String gps31) {
		this.gps31 = gps31;
	}	

	public int getTotalTripsGPSWeek1() {
		return totalTripsGPSWeek1;
	}

	public void setTotalTripsGPSWeek1(int totalTripsGPSWeek1) {
		this.totalTripsGPSWeek1 = totalTripsGPSWeek1;
	}

	public int getTotalAvailabilityWeek1() {
		return totalAvailabilityWeek1;
	}

	public void setTotalAvailabilityWeek1(int totalAvailabilityWeek1) {
		this.totalAvailabilityWeek1 = totalAvailabilityWeek1;
	}

	public int getTotalTripsGPSWeek2() {
		return totalTripsGPSWeek2;
	}

	public void setTotalTripsGPSWeek2(int totalTripsGPSWeek2) {
		this.totalTripsGPSWeek2 = totalTripsGPSWeek2;
	}

	public int getTotalAvailabilityWeek2() {
		return totalAvailabilityWeek2;
	}

	public void setTotalAvailabilityWeek2(int totalAvailabilityWeek2) {
		this.totalAvailabilityWeek2 = totalAvailabilityWeek2;
	}

	public int getTotalTripsGPSWeek3() {
		return totalTripsGPSWeek3;
	}

	public void setTotalTripsGPSWeek3(int totalTripsGPSWeek3) {
		this.totalTripsGPSWeek3 = totalTripsGPSWeek3;
	}

	public int getTotalAvailabilityWeek3() {
		return totalAvailabilityWeek3;
	}

	public void setTotalAvailabilityWeek3(int totalAvailabilityWeek3) {
		this.totalAvailabilityWeek3 = totalAvailabilityWeek3;
	}

	public int getTotalTripsGPSWeek4() {
		return totalTripsGPSWeek4;
	}

	public void setTotalTripsGPSWeek4(int totalTripsGPSWeek4) {
		this.totalTripsGPSWeek4 = totalTripsGPSWeek4;
	}

	public int getTotalAvailabilityWeek4() {
		return totalAvailabilityWeek4;
	}

	public void setTotalAvailabilityWeek4(int totalAvailabilityWeek4) {
		this.totalAvailabilityWeek4 = totalAvailabilityWeek4;
	}


	public int getGpsTripIssue1() {
		return gpsTripIssue1;
	}

	public void setGpsTripIssue1(int gpsTripIssue1) {
		this.gpsTripIssue1 = gpsTripIssue1;
	}

	public int getGpsTripIssue2() {
		return gpsTripIssue2;
	}

	public void setGpsTripIssue2(int gpsTripIssue2) {
		this.gpsTripIssue2 = gpsTripIssue2;
	}

	public int getGpsTripIssue3() {
		return gpsTripIssue3;
	}

	public void setGpsTripIssue3(int gpsTripIssue3) {
		this.gpsTripIssue3 = gpsTripIssue3;
	}

	public int getGpsTripIssue4() {
		return gpsTripIssue4;
	}

	public void setGpsTripIssue4(int gpsTripIssue4) {
		this.gpsTripIssue4 = gpsTripIssue4;
	}

	public int getGpsTripIssue5() {
		return gpsTripIssue5;
	}

	public void setGpsTripIssue5(int gpsTripIssue5) {
		this.gpsTripIssue5 = gpsTripIssue5;
	}

	public int getGpsTripIssue6() {
		return gpsTripIssue6;
	}

	public void setGpsTripIssue6(int gpsTripIssue6) {
		this.gpsTripIssue6 = gpsTripIssue6;
	}

	public int getGpsTripIssue7() {
		return gpsTripIssue7;
	}

	public void setGpsTripIssue7(int gpsTripIssue7) {
		this.gpsTripIssue7 = gpsTripIssue7;
	}

	public int getGpsTripIssue8() {
		return gpsTripIssue8;
	}

	public void setGpsTripIssue8(int gpsTripIssue8) {
		this.gpsTripIssue8 = gpsTripIssue8;
	}

	public int getGpsTripIssue9() {
		return gpsTripIssue9;
	}

	public void setGpsTripIssue9(int gpsTripIssue9) {
		this.gpsTripIssue9 = gpsTripIssue9;
	}

	public int getGpsTripIssue10() {
		return gpsTripIssue10;
	}

	public void setGpsTripIssue10(int gpsTripIssue10) {
		this.gpsTripIssue10 = gpsTripIssue10;
	}

	public int getGpsTripIssue11() {
		return gpsTripIssue11;
	}

	public void setGpsTripIssue11(int gpsTripIssue11) {
		this.gpsTripIssue11 = gpsTripIssue11;
	}

	public int getGpsTripIssue12() {
		return gpsTripIssue12;
	}

	public void setGpsTripIssue12(int gpsTripIssue12) {
		this.gpsTripIssue12 = gpsTripIssue12;
	}

	public int getGpsTripIssue13() {
		return gpsTripIssue13;
	}

	public void setGpsTripIssue13(int gpsTripIssue13) {
		this.gpsTripIssue13 = gpsTripIssue13;
	}

	public int getGpsTripIssue14() {
		return gpsTripIssue14;
	}

	public void setGpsTripIssue14(int gpsTripIssue14) {
		this.gpsTripIssue14 = gpsTripIssue14;
	}

	public int getGpsTripIssue15() {
		return gpsTripIssue15;
	}

	public void setGpsTripIssue15(int gpsTripIssue15) {
		this.gpsTripIssue15 = gpsTripIssue15;
	}

	public int getGpsTripIssue16() {
		return gpsTripIssue16;
	}

	public void setGpsTripIssue16(int gpsTripIssue16) {
		this.gpsTripIssue16 = gpsTripIssue16;
	}

	public int getGpsTripIssue17() {
		return gpsTripIssue17;
	}

	public void setGpsTripIssue17(int gpsTripIssue17) {
		this.gpsTripIssue17 = gpsTripIssue17;
	}

	public int getGpsTripIssue18() {
		return gpsTripIssue18;
	}

	public void setGpsTripIssue18(int gpsTripIssue18) {
		this.gpsTripIssue18 = gpsTripIssue18;
	}

	public int getGpsTripIssue19() {
		return gpsTripIssue19;
	}

	public void setGpsTripIssue19(int gpsTripIssue19) {
		this.gpsTripIssue19 = gpsTripIssue19;
	}

	public int getGpsTripIssue20() {
		return gpsTripIssue20;
	}

	public void setGpsTripIssue20(int gpsTripIssue20) {
		this.gpsTripIssue20 = gpsTripIssue20;
	}

	public int getGpsTripIssue21() {
		return gpsTripIssue21;
	}

	public void setGpsTripIssue21(int gpsTripIssue21) {
		this.gpsTripIssue21 = gpsTripIssue21;
	}

	public int getGpsTripIssue22() {
		return gpsTripIssue22;
	}

	public void setGpsTripIssue22(int gpsTripIssue22) {
		this.gpsTripIssue22 = gpsTripIssue22;
	}

	public int getGpsTripIssue23() {
		return gpsTripIssue23;
	}

	public void setGpsTripIssue23(int gpsTripIssue23) {
		this.gpsTripIssue23 = gpsTripIssue23;
	}

	public int getGpsTripIssue24() {
		return gpsTripIssue24;
	}

	public void setGpsTripIssue24(int gpsTripIssue24) {
		this.gpsTripIssue24 = gpsTripIssue24;
	}

	public int getGpsTripIssue25() {
		return gpsTripIssue25;
	}

	public void setGpsTripIssue25(int gpsTripIssue25) {
		this.gpsTripIssue25 = gpsTripIssue25;
	}

	public int getGpsTripIssue26() {
		return gpsTripIssue26;
	}

	public void setGpsTripIssue26(int gpsTripIssue26) {
		this.gpsTripIssue26 = gpsTripIssue26;
	}

	public int getGpsTripIssue27() {
		return gpsTripIssue27;
	}

	public void setGpsTripIssue27(int gpsTripIssue27) {
		this.gpsTripIssue27 = gpsTripIssue27;
	}

	public int getGpsTripIssue28() {
		return gpsTripIssue28;
	}

	public void setGpsTripIssue28(int gpsTripIssue28) {
		this.gpsTripIssue28 = gpsTripIssue28;
	}

	public int getGpsTripIssue29() {
		return gpsTripIssue29;
	}

	public void setGpsTripIssue29(int gpsTripIssue29) {
		this.gpsTripIssue29 = gpsTripIssue29;
	}

	public int getGpsTripIssue30() {
		return gpsTripIssue30;
	}

	public void setGpsTripIssue30(int gpsTripIssue30) {
		this.gpsTripIssue30 = gpsTripIssue30;
	}

	public int getGpsTripIssue31() {
		return gpsTripIssue31;
	}

	public void setGpsTripIssue31(int gpsTripIssue31) {
		this.gpsTripIssue31 = gpsTripIssue31;
	}
	
	public double getTotalPercentage() {
		//cannot divide by 0
		double percentage = this.getTotalMaintenance() > 0 ? BigDecimal.valueOf(this.getTotalTripsGPS()).divide(BigDecimal.valueOf(this.getTotalMaintenance()), 2, RoundingMode.CEILING).doubleValue() : 0;			
		return percentage;
	}

	public double getPercentageWeek1() {
		//cannot divide by 0
		double percentage = this.getTotalAvailabilityWeek1() > 0 ? BigDecimal.valueOf(this.getTotalTripsGPSWeek1()).divide(BigDecimal.valueOf(this.getTotalAvailabilityWeek1()), 2, RoundingMode.CEILING).doubleValue() : 0;			
		return percentage;
	}

	public double getPercentageWeek2() {
		//cannot divide by 0
		double percentage = this.getTotalAvailabilityWeek2() > 0 ? BigDecimal.valueOf(this.getTotalTripsGPSWeek2()).divide(BigDecimal.valueOf(this.getTotalAvailabilityWeek2()), 2, RoundingMode.CEILING).doubleValue() : 0;			
		return percentage;
	}

	public double getPercentageWeek3() {
		//cannot divide by 0
		double percentage = this.getTotalAvailabilityWeek3() > 0 ? BigDecimal.valueOf(this.getTotalTripsGPSWeek3()).divide(BigDecimal.valueOf(this.getTotalAvailabilityWeek3()), 2, RoundingMode.CEILING).doubleValue() : 0;			
		return percentage;
	}
	
	public double getPercentageWeek4() {
		//cannot divide by 0
		double percentage = this.getTotalAvailabilityWeek4() > 0 ? BigDecimal.valueOf(this.getTotalTripsGPSWeek4()).divide(BigDecimal.valueOf(this.getTotalAvailabilityWeek4()), 2, RoundingMode.CEILING).doubleValue() : 0;			
		return percentage;
	}
	
	public String getGpsTripIssue1Desc() {
		return TransportUtils.getGPSTripIssueCategoryById(getGpsTripIssue1());
	}
	
	public String getGpsTripIssue2Desc() {
		return TransportUtils.getGPSTripIssueCategoryById(getGpsTripIssue2());
	}
	
	public String getGpsTripIssue3Desc() {
		return TransportUtils.getGPSTripIssueCategoryById(getGpsTripIssue3());
	}
	
	public String getGpsTripIssue4Desc() {
		return TransportUtils.getGPSTripIssueCategoryById(getGpsTripIssue4());
	}
	
	public String getGpsTripIssue5Desc() {
		return TransportUtils.getGPSTripIssueCategoryById(getGpsTripIssue5());
	}

	public String getGpsTripIssue6Desc() {
		return TransportUtils.getGPSTripIssueCategoryById(getGpsTripIssue6());
	}
	
	public String getGpsTripIssue7Desc() {
		return TransportUtils.getGPSTripIssueCategoryById(getGpsTripIssue7());
	}
	
	public String getGpsTripIssue8Desc() {
		return TransportUtils.getGPSTripIssueCategoryById(getGpsTripIssue8());
	}
	
	public String getGpsTripIssue9Desc() {
		return TransportUtils.getGPSTripIssueCategoryById(getGpsTripIssue9());
	}
	
	public String getGpsTripIssue10Desc() {
		return TransportUtils.getGPSTripIssueCategoryById(getGpsTripIssue10());
	}
	
	public String getGpsTripIssue11Desc() {
		return TransportUtils.getGPSTripIssueCategoryById(getGpsTripIssue11());
	}
	
	public String getGpsTripIssue12Desc() {
		return TransportUtils.getGPSTripIssueCategoryById(getGpsTripIssue12());
	}
	
	public String getGpsTripIssue13Desc() {
		return TransportUtils.getGPSTripIssueCategoryById(getGpsTripIssue13());
	}
	
	public String getGpsTripIssue14Desc() {
		return TransportUtils.getGPSTripIssueCategoryById(getGpsTripIssue14());
	}
	
	public String getGpsTripIssue15Desc() {
		return TransportUtils.getGPSTripIssueCategoryById(getGpsTripIssue15());
	}
	
	public String getGpsTripIssue16Desc() {
		return TransportUtils.getGPSTripIssueCategoryById(getGpsTripIssue16());
	}
	
	public String getGpsTripIssue17Desc() {
		return TransportUtils.getGPSTripIssueCategoryById(getGpsTripIssue17());
	}
	
	public String getGpsTripIssue18Desc() {
		return TransportUtils.getGPSTripIssueCategoryById(getGpsTripIssue18());
	}
	
	public String getGpsTripIssue19Desc() {
		return TransportUtils.getGPSTripIssueCategoryById(getGpsTripIssue19());
	}
	
	public String getGpsTripIssue20Desc() {
		return TransportUtils.getGPSTripIssueCategoryById(getGpsTripIssue20());
	}
	
	public String getGpsTripIssue21Desc() {
		return TransportUtils.getGPSTripIssueCategoryById(getGpsTripIssue21());
	}
	
	public String getGpsTripIssue22Desc() {
		return TransportUtils.getGPSTripIssueCategoryById(getGpsTripIssue22());
	}
	
	public String getGpsTripIssue23Desc() {
		return TransportUtils.getGPSTripIssueCategoryById(getGpsTripIssue23());
	}
	
	public String getGpsTripIssue24Desc() {
		return TransportUtils.getGPSTripIssueCategoryById(getGpsTripIssue24());
	}
	
	public String getGpsTripIssue25Desc() {
		return TransportUtils.getGPSTripIssueCategoryById(getGpsTripIssue25());
	}
	
	public String getGpsTripIssue26Desc() {
		return TransportUtils.getGPSTripIssueCategoryById(getGpsTripIssue26());
	}
	
	public String getGpsTripIssue27Desc() {
		return TransportUtils.getGPSTripIssueCategoryById(getGpsTripIssue27());
	}
	
	public String getGpsTripIssue28Desc() {
		return TransportUtils.getGPSTripIssueCategoryById(getGpsTripIssue28());
	}
	
	public String getGpsTripIssue29Desc() {
		return TransportUtils.getGPSTripIssueCategoryById(getGpsTripIssue29());
	}
	
	public String getGpsTripIssue30Desc() {
		return TransportUtils.getGPSTripIssueCategoryById(getGpsTripIssue30());
	}
	
	public String getGpsTripIssue31Desc() {
		return TransportUtils.getGPSTripIssueCategoryById(getGpsTripIssue31());
	}
	
	public int getTotalGpsTripIssueTI() {
		return totalGpsTripIssueTI;
	}

	public void setTotalGpsTripIssueTI(int totalGpsTripIssueTI) {
		this.totalGpsTripIssueTI = totalGpsTripIssueTI;
	}

	public int getTotalGpsTripIssueMI() {
		return totalGpsTripIssueMI;
	}

	public void setTotalGpsTripIssueMI(int totalGpsTripIssueMI) {
		this.totalGpsTripIssueMI = totalGpsTripIssueMI;
	}

	public int getTotalGpsTripIssueDI() {
		return totalGpsTripIssueDI;
	}

	public void setTotalGpsTripIssueDI(int totalGpsTripIssueDI) {
		this.totalGpsTripIssueDI = totalGpsTripIssueDI;
	}

	public int getTotalGpsTripIssueCI() {
		return totalGpsTripIssueCI;
	}

	public void setTotalGpsTripIssueCI(int totalGpsTripIssueCI) {
		this.totalGpsTripIssueCI = totalGpsTripIssueCI;
	}

	public int getTotalGpsTripIssueLV() {
		return totalGpsTripIssueLV;
	}

	public void setTotalGpsTripIssueLV(int totalGpsTripIssueLV) {
		this.totalGpsTripIssueLV = totalGpsTripIssueLV;
	}

	public int getTotalGpsTripIssueLH() {
		return totalGpsTripIssueLH;
	}

	public void setTotalGpsTripIssueLH(int totalGpsTripIssueLH) {
		this.totalGpsTripIssueLH = totalGpsTripIssueLH;
	}

	public int getTotalGpsTripIssueTBI() {
		return totalGpsTripIssueTBI;
	}

	public void setTotalGpsTripIssueTBI(int totalGpsTripIssueTBI) {
		this.totalGpsTripIssueTBI = totalGpsTripIssueTBI;
	}

	public int getTotalGpsTripIssueRI() {
		return totalGpsTripIssueRI;
	}

	public void setTotalGpsTripIssueRI(int totalGpsTripIssueRI) {
		this.totalGpsTripIssueRI = totalGpsTripIssueRI;
	}

	public int getTotalTripsGPSWeek5() {
		return totalTripsGPSWeek5;
	}

	public void setTotalTripsGPSWeek5(int totalTripsGPSWeek5) {
		this.totalTripsGPSWeek5 = totalTripsGPSWeek5;
	}

	public int getTotalTargetDate() {
		return totalTargetDate;
	}

	public void setTotalTargetDate(int totalTargetDate) {
		this.totalTargetDate = totalTargetDate;
	}

	public int getTotalExtended() {
		return totalExtended;
	}

	public void setTotalExtended(int totalExtended) {
		this.totalExtended = totalExtended;
	}

	public int getTotalEarlyDone() {
		return totalEarlyDone;
	}

	public void setTotalEarlyDone(int totalEarlyDone) {
		this.totalEarlyDone = totalEarlyDone;
	}

	public int getGps1Vol() {
		return gps1Vol;
	}

	public void setGps1Vol(int gps1Vol) {
		this.gps1Vol = gps1Vol;
	}


	public int getGps2Vol() {
		return gps2Vol;
	}


	public void setGps2Vol(int gps2Vol) {
		this.gps2Vol = gps2Vol;
	}


	public int getGps3Vol() {
		return gps3Vol;
	}


	public void setGps3Vol(int gps3Vol) {
		this.gps3Vol = gps3Vol;
	}


	public int getGps4Vol() {
		return gps4Vol;
	}


	public void setGps4Vol(int gps4Vol) {
		this.gps4Vol = gps4Vol;
	}


	public int getGps5Vol() {
		return gps5Vol;
	}


	public void setGps5Vol(int gps5Vol) {
		this.gps5Vol = gps5Vol;
	}


	public int getGps6Vol() {
		return gps6Vol;
	}


	public void setGps6Vol(int gps6Vol) {
		this.gps6Vol = gps6Vol;
	}


	public int getGps7Vol() {
		return gps7Vol;
	}


	public void setGps7Vol(int gps7Vol) {
		this.gps7Vol = gps7Vol;
	}


	public int getGps8Vol() {
		return gps8Vol;
	}


	public void setGps8Vol(int gps8Vol) {
		this.gps8Vol = gps8Vol;
	}


	public int getGps9Vol() {
		return gps9Vol;
	}


	public void setGps9Vol(int gps9Vol) {
		this.gps9Vol = gps9Vol;
	}


	public int getGps10Vol() {
		return gps10Vol;
	}


	public void setGps10Vol(int gps10Vol) {
		this.gps10Vol = gps10Vol;
	}


	public int getGps11Vol() {
		return gps11Vol;
	}


	public void setGps11Vol(int gps11Vol) {
		this.gps11Vol = gps11Vol;
	}


	public int getGps12Vol() {
		return gps12Vol;
	}


	public void setGps12Vol(int gps12Vol) {
		this.gps12Vol = gps12Vol;
	}


	public int getGps13Vol() {
		return gps13Vol;
	}


	public void setGps13Vol(int gps13Vol) {
		this.gps13Vol = gps13Vol;
	}


	public int getGps14Vol() {
		return gps14Vol;
	}


	public void setGps14Vol(int gps14Vol) {
		this.gps14Vol = gps14Vol;
	}


	public int getGps15Vol() {
		return gps15Vol;
	}


	public void setGps15Vol(int gps15Vol) {
		this.gps15Vol = gps15Vol;
	}


	public int getGps16Vol() {
		return gps16Vol;
	}


	public void setGps16Vol(int gps16Vol) {
		this.gps16Vol = gps16Vol;
	}


	public int getGps17Vol() {
		return gps17Vol;
	}


	public void setGps17Vol(int gps17Vol) {
		this.gps17Vol = gps17Vol;
	}


	public int getGps18Vol() {
		return gps18Vol;
	}


	public void setGps18Vol(int gps18Vol) {
		this.gps18Vol = gps18Vol;
	}


	public int getGps19Vol() {
		return gps19Vol;
	}


	public void setGps19Vol(int gps19Vol) {
		this.gps19Vol = gps19Vol;
	}


	public int getGps20Vol() {
		return gps20Vol;
	}


	public void setGps20Vol(int gps20Vol) {
		this.gps20Vol = gps20Vol;
	}


	public int getGps21Vol() {
		return gps21Vol;
	}


	public void setGps21Vol(int gps21Vol) {
		this.gps21Vol = gps21Vol;
	}


	public int getGps22Vol() {
		return gps22Vol;
	}


	public void setGps22Vol(int gps22Vol) {
		this.gps22Vol = gps22Vol;
	}


	public int getGps23Vol() {
		return gps23Vol;
	}


	public void setGps23Vol(int gps23Vol) {
		this.gps23Vol = gps23Vol;
	}


	public int getGps24Vol() {
		return gps24Vol;
	}


	public void setGps24Vol(int gps24Vol) {
		this.gps24Vol = gps24Vol;
	}


	public int getGps25Vol() {
		return gps25Vol;
	}


	public void setGps25Vol(int gps25Vol) {
		this.gps25Vol = gps25Vol;
	}


	public int getGps26Vol() {
		return gps26Vol;
	}


	public void setGps26Vol(int gps26Vol) {
		this.gps26Vol = gps26Vol;
	}


	public int getGps27Vol() {
		return gps27Vol;
	}


	public void setGps27Vol(int gps27Vol) {
		this.gps27Vol = gps27Vol;
	}


	public int getGps28Vol() {
		return gps28Vol;
	}


	public void setGps28Vol(int gps28Vol) {
		this.gps28Vol = gps28Vol;
	}


	public int getGps29Vol() {
		return gps29Vol;
	}


	public void setGps29Vol(int gps29Vol) {
		this.gps29Vol = gps29Vol;
	}


	public int getGps30Vol() {
		return gps30Vol;
	}


	public void setGps30Vol(int gps30Vol) {
		this.gps30Vol = gps30Vol;
	}


	public int getGps31Vol() {
		return gps31Vol;
	}


	public void setGps31Vol(int gps31Vol) {
		this.gps31Vol = gps31Vol;
	}


	public int getGpsWeek1Vol() {
		return gpsWeek1Vol;
	}


	public void setGpsWeek1Vol(int gpsWeek1Vol) {
		this.gpsWeek1Vol = gpsWeek1Vol;
	}


	public int getGpsWeek2Vol() {
		return gpsWeek2Vol;
	}


	public void setGpsWeek2Vol(int gpsWeek2Vol) {
		this.gpsWeek2Vol = gpsWeek2Vol;
	}


	public int getGpsWeek3Vol() {
		return gpsWeek3Vol;
	}


	public void setGpsWeek3Vol(int gpsWeek3Vol) {
		this.gpsWeek3Vol = gpsWeek3Vol;
	}


	public int getGpsWeek4Vol() {
		return gpsWeek4Vol;
	}


	public void setGpsWeek4Vol(int gpsWeek4Vol) {
		this.gpsWeek4Vol = gpsWeek4Vol;
	}


	public int getGpsWeek5Vol() {
		return gpsWeek5Vol;
	}


	public void setGpsWeek5Vol(int gpsWeek5Vol) {
		this.gpsWeek5Vol = gpsWeek5Vol;
	}


	public int getGpsMonthVol() {
		return gpsMonthVol;
	}


	public void setGpsMonthVol(int gpsMonthVol) {
		this.gpsMonthVol = gpsMonthVol;
	}
	
	
	
}
