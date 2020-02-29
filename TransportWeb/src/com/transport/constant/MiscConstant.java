package com.transport.constant;

/**
 * 
 * @author dward
 * @since July2015
 * Last Date Updated: 11Dec2019
 */
public class MiscConstant {

	//pagination
	public static final int RECORDS_PER_PAGE = 10;
	
	//session
	public static final String USER_SESSION = "user_session";
	public static final String USER_ACCESS_LIST = "user_access_list";
	public static final String USER_ROLE_SESSION = "user_role_session";
	public static final String USER_EMP_ID_SESSION = "user_emp_id_session";
	public static final String TRANS_MESSAGE_SESSION = "trans_message_session";
	public static final String MF_EMPLOYEE_CUSTOM_LIST = "mf_employee_custom_list";
	public static final String MF_USER_CUSTOM_LIST = "mf_user_custom_list";
	public static final String MF_CORRECTIONS_LIST = "mf_corrections_list"; //Added for Revision 1 Dec2015
	public static final String MF_ITEMS_LIST = "mf_items_list"; //Added for Revision 1 Dec2015
	public static final String MF_ROOT_CAUSE_LIST = "mf_root_cause_list"; //Added for Revision 1 Dec2015
	public static final String MF_TIRE_BRAND_LIST = "mf_tire_brand_list"; //Added for Website Enhancement 1 20Aug2016
	public static final String TRANS_ITEM_LIST = "trans_item_list";
	public static final String TRANS_DRIVER_LIST = "trans_driver_list";
	public static final String TRANS_MECHANIC_LIST = "trans_mechanic_list";
	public static final String TRANS_STAFF_LIST = "trans_staff_list";
	public static final String TRANS_PERMIT_ISSUER_LIST = "trans_permit_issuer_list";
	public static final String TRANS_LORRY_LIST = "trans_lorry_list";
	public static final String TRANS_CORRECTIONS_LIST = "trans_corrections_list";
	public static final String TRANS_CHECKEDBY_LIST = "trans_checkedby_list";
	public static final String TRANS_FOLLOWUP_LIST = "trans_followup_list";
	public static final String TRANS_REMARKS_LIST = "trans_remarks_list";
	public static final String TRANS_TERMINAL_LIST = "trans_terminal_list";
	public static final String TRANS_FINDINGS_LIST = "trans_findings_list";
	public static final String TRANS_FINDINGS_POSITIVE_LIST = "trans_findings_positive_list";
	public static final String TRANS_FINDINGS_NEGATIVE_LIST = "trans_findings_negative_list";
	public static final String TRANS_ROOT_CAUSE_LIST = "trans_root_cause_list";
	public static final String TRANS_CLOSURE_LIST = "trans_closure_list";
	public static final String UTILS_ENTITY_TYPE_CRITERIA = "entity_type_criteria";
	public static final String RPT_SEARCH_CRITERIA = "rpt_search_criteria";//Verification and Validation
	public static final String WORK_PERMIT_SEARCH_CRITERIA = "work_permit_search_criteria";
	public static final String TRANSPORT_PROGRAM_CRITERIA = "transport_program_criteria";
	public static final String IS_MOBILE = "is_mobile";
	
	//session-lov
	public static final String LOV_ENTITY_TYPE_SESSION = "lov_entity_type_session";
	public static final String LOV_EMPLOYEE_CATEGORY_SESSION = "lov_employee_category_session";
	public static final String LOV_USER_ROLE_SESSION = "lov_user_role_session";
	public static final String LOV_USER_ACCESS_SESSION = "lov_user_access_session";
	public static final String LOV_VERIFICATION_CRITERIA_SESSION = "lov_verification_criteria_session";
	public static final String LOV_FINDINGS_TYPE_SESSION = "lov_findings_type_session";
	public static final String LOV_TRANSPORT_PROGRAM_SESSION = "lov_transport_program_session";
	public static final String LOV_WORK_PERMIT_CRITERIA_SESSION = "lov_work_permit_criteria_session";
	public static final String LOV_BOOLEAN_YN_SESSION = "lov_boolean_yn_session";
	public static final String WORK_PERMIT_TRANSPORT_PROGRAM_SESSION = "work_permit_transport_program_session";
	public static final String LOV_MAINTENANCE_PERSONNEL_SESSION = "lov_maintenance_personnel_session";
	public static final String LOV_GPS_PERSONNEL_SESSION = "lov_gps_personnel_session";
	public static final String LOV_LORRY_CATEGORY_SESSION = "lov_lorry_category_session";
	public static final String LOV_DRIVER_TRAINING_SESSION = "lov_driver_training_session";
	public static final String LOV_TRIP_ISSUE_CATEGORY_SESSION = "lov_trip_issue_category_session";
	
	//confirmation messages
	public static final String TRANS_MESSSAGE_SAVED = "Record successfully saved!";
	public static final String TRANS_MESSSAGE_UPDATED = "Record successfully updated!";
	public static final String TRANS_MESSSAGE_DELETED = "Record successfully deleted!";
	public static final String TRANS_MESSSAGE_VALID_USERNAME = "Please proceed to change your username and password.";
	public static final String TRANS_MESSSAGE_INVALID_USERNAME = "Invalid username or password!";
	public static final String TRANS_MESSSAGE_ERROR = "There was an error in processing.. Please contact System Administrator.";
	public static final String TRANS_MESSSAGE_RESET = "";
	public static final String TRANS_MESSSAGE_RESTORED = "Record successfully restored to Master File!";
	public static final String RPT_MESSSAGE_GENERATED_SUCCESS= "Report generated successfully!";
	public static final String RPT_MESSSAGE_GENERATED_FAILED = "Report generation failed!";
	
	//logging messages
	public static final String LOGGING_MESSSAGE_SAVE = "Entered save()...";
	public static final String LOGGING_MESSSAGE_UPDATE = "Entered update()...";
	public static final String LOGGING_MESSSAGE_DELETE = "Entered delete()...";
	public static final String LOGGING_MESSSAGE_SEARCH = "Entered search()...";
	public static final String LOGGING_MESSSAGE_GETDATA_BY_ID = "Entered getDataById()...";
	public static final String LOGGING_MESSSAGE_GETDATA_BY_DRIVER_ID = "Entered getDataByDriverId()...";
	public static final String LOGGING_MESSSAGE_GETDATA_BY_DRIVER_TRAINING_ID = "Entered getDataByDriverTrainingId()...";
	public static final String LOGGING_MESSSAGE_GETDATA_BY_USER_ID = "Entered getDataByUserId()...";
	public static final String LOGGING_MESSSAGE_GET_ACTIVE_DATA = "Entered getActiveData()...";
	public static final String LOGGING_MESSSAGE_GET_INACTIVE_DATA = "Entered getInActiveData()...";
	public static final String LOGGING_MESSSAGE_GET_DATA_BY_LIST_TYPE = "Entered getDataByListType()...";
	public static final String LOGGING_MESSSAGE_RESTORE = "Entered restore()...";
	public static final String LOGGING_MESSSAGE_UPDATE_USERNAME_PASSWORD = "Entered updateUsernamePassword()...";
	public static final String LOGGING_MESSSAGE_GETDATA_BY_CRITERIA = "Entered getDataByCriteria()...";
	
	//list type
	public static final int LOVTYPE_ENTITY_TYPE = 1;
	public static final int LOVTYPE_EMPLOYEE_CATEGORY = 2;
	public static final int LOVTYPE_USER_ROLE = 3;
	public static final int LOVTYPE_VERIFICATION_CRITERIA = 4;
	public static final int LOVTYPE_FINDINGS_TYPE = 5; //Added for Revision 1 Dec2015
	public static final int LOVTYPE_TRANPORT_PROGRAM = 6; //Added for Work Permit 05March2018
	public static final int LOVTYPE_BOOLEAN_YN = 7; //Added for Work Permit 05March2018
	public static final int LOVTYPE_WORK_PERMIT_CRITERIA = 8; //Added for Work Permit 05March2018
	public static final int LOVTYPE_USER_ACCESS = 9; //Added for Work Permit 11March2018
	public static final int LOVTYPE_LORRY_CATEGORY = 10;
	public static final int LOVTYPE_MAINTENANCE_PERSONNEL = 11;
	public static final int LOVTYPE_GPS_PERSONNEL = 12;
	public static final int LOVTYPE_DRIVER_TRAINING = 13;
	public static final int LOVTYPE_TRIP_ISSUE_CATEGORY = 14;//Added for Oct2019
	
	//LOV for Employee Category
	public static final String LOV_EMPCATEGORY_DRIVER = "Driver";
	public static final String LOV_EMPCATEGORY_CHECKER = "Checker";
	public static final String LOV_EMPCATEGORY_MANAGEMENT = "Management";
	public static final String LOV_EMPCATEGORY_MECHANIC = "Mechanic";
	
	//LOV for EntityType
	public static final int LOV_ENTITY_TYPE_EMPLOYEE = 101;
	public static final int LOV_ENTITY_TYPE_TERMINAL = 102;
	public static final int LOV_ENTITY_TYPE_LORRY = 103;
	public static final int LOV_ENTITY_TYPE_ITEMS = 104;
	public static final int LOV_ENTITY_TYPE_CORRECTIONS = 105;
	public static final int LOV_ENTITY_TYPE_FOLLOWUP = 106;
	public static final int LOV_ENTITY_TYPE_REMARKS = 107;
	public static final int LOV_ENTITY_TYPE_USER = 108;
	public static final int LOV_ENTITY_TYPE_VERIFICATION_AND_VALIDATION = 109;
	public static final int LOV_ENTITY_TYPE_FINDINGS = 110;
	public static final int LOV_ENTITY_TYPE_ROOT_CAUSE = 111;
	public static final int LOV_ENTITY_TYPE_CLOSURE = 112;
	public static final int LOV_ENTITY_TYPE_WORK_PERMIT = 113;
	public static final int LOV_ENTITY_TYPE_DRIVER_TRAINING = 114;
	public static final int LOV_ENTITY_TYPE_DRIVER_INCIDENT = 115;
	
	//LOV for UserRole
	public static final String LOV_USER_ROLE_STAFF = "Staff";
	public static final String LOV_USER_ROLE_ADMIN = "Admin";
	
	//LOV for VerificationCriteria
	public static final int LOV_VERIFICATION_CRITERIA_ITEM = 401;
	public static final int LOV_VERIFICATION_CRITERIA_FINDINGS= 402;
	public static final int LOV_VERIFICATION_CRITERIA_DRIVER = 403;
	public static final int LOV_VERIFICATION_CRITERIA_TERMINAL = 404;
	public static final int LOV_VERIFICATION_CRITERIA_LORRY = 405;
	public static final int LOV_VERIFICATION_CRITERIA_VERIFICATION_DATE = 406;
	public static final int LOV_VERIFICATION_CRITERIA_CORRECTIONS = 407;
	public static final int LOV_VERIFICATION_CRITERIA_CHECKEDBY_VERIFICATION = 408;
	public static final int LOV_VERIFICATION_CRITERIA_FOLLOWUP = 409;
	public static final int LOV_VERIFICATION_CRITERIA_DRIVER_VALIDATION = 410;
	public static final int LOV_VERIFICATION_CRITERIA_TERMINAL_VALIDATION = 411;
	public static final int LOV_VERIFICATION_CRITERIA_LORRY_VALIDATION = 412;
	public static final int LOV_VERIFICATION_CRITERIA_VALIDATION_DATE = 413;
	public static final int LOV_VERIFICATION_CRITERIA_CHECKEDBY_VALIDATION = 414;
	public static final int LOV_VERIFICATION_CRITERIA_REMARKS = 415;
	public static final int LOV_VERIFICATION_CRITERIA_ROOT_CAUSE = 416;
	public static final int LOV_VERIFICATION_CRITERIA_CLOSURE = 417;
	
	//LOV for Transport Program Criteria
	public static final int LOV_TRANSPORT_SHELL = 601;
	public static final int LOV_TRANSPORT_CALTEX = 602;
	
	//LOV for Work Permit Criteria
	public static final int LOV_WORK_PERMIT_CRITERIA_PERMIT_NO = 801;
	public static final int LOV_WORK_PERMIT_CRITERIA_PLATE_NO = 802;
	public static final int LOV_WORK_PERMIT_CRITERIA_LORRY_NO = 803;
	public static final int LOV_WORK_PERMIT_CRITERIA_ITEM_REPAIR = 804;
	public static final int LOV_WORK_PERMIT_CRITERIA_GAS_FREE = 805;
	public static final int LOV_WORK_PERMIT_CRITERIA_HOT_WORK = 806;
	public static final int LOV_WORK_PERMIT_CRITERIA_MECHANIC = 807;
	public static final int LOV_WORK_PERMIT_CRITERIA_PERMIT_ISSUER = 808;
	public static final int LOV_WORK_PERMIT_CRITERIA_DATE_STARTED = 809;
	public static final int LOV_WORK_PERMIT_CRITERIA_TIME_STARTED = 810;
	public static final int LOV_WORK_PERMIT_CRITERIA_DATE_ENDED = 811;
	public static final int LOV_WORK_PERMIT_CRITERIA_TIME_ENDED = 812;
	public static final int LOV_WORK_PERMIT_CRITERIA_RESCUE = 813;
	public static final int LOV_WORK_PERMIT_CRITERIA_ODOMETER = 814;
	public static final int LOV_WORK_PERMIT_CRITERIA_HUB = 815;
	public static final int LOV_WORK_PERMIT_CRITERIA_ITEM_REPLACE = 816;
	
	//LOV for Findings Type
	public static final int LOV_FINDINGS_TYPE_POSITIVE = 501;
	public static final int LOV_FINDINGS_TYPE_NEGATIVE = 502;
	
	//Reports - jasper
	public static final String RPT_VERIFICATION_AND_VALIDATION_TITLE = "Verification and Validation Compliance Tracker Report";
	public static final String RPT_VERIFICATION_AND_VALIDATION_REPORT = "Verification.jasper";
	public static final String RPT_WORK_PERMIT_TITLE = "Work Permit Report";
	public static final String RPT_WORK_PERMIT_REPORT = "WorkPermit.jasper";
	public static final String RPT_DRIVER_TRAINING_SUMMARY_TITLE = "Driver Training Summary Report";
	public static final String RPT_DRIVER_TRAINING_SUMMARY_REPORT = "DriverTrainingSummary.jasper";
	public static final String RPT_DRIVER_INCIDENT_TITLE = "Driver Incident Report";
	public static final String RPT_DRIVER_INCIDENT_REPORT = "DriverIncident.jasper";

	//Reports - pdf
	public static final String PDF_VERIFICATION_AND_VALIDATION_REPORT = "verification.pdf";
	public static final String XLS_VERIFICATION_AND_VALIDATION_REPORT = "verification.xlsx";
	public static final String PDF_WORK_PERMIT_REPORT = "workpermit.pdf";
	public static final String XLS_WORK_PERMIT_REPORT = "workpermit.xlsx";
	public static final String PDF_DRIVER_TRAINING_SUMMARY_REPORT = "DriverTrainingSummary.pdf";
	public static final String PDF_DRIVER_INCIDENT_REPORT = "DriverIncident.pdf";
	
}
