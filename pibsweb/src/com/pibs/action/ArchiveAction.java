package com.pibs.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.pibs.constant.ActionConstant;
import com.pibs.constant.MapConstant;
import com.pibs.constant.MiscConstant;
import com.pibs.constant.ModuleConstant;
import com.pibs.constant.ParamConstant;
import com.pibs.form.ArchiveFormBean;
import com.pibs.model.AdditionalServices;
import com.pibs.model.AdditionalServicesCategory;
import com.pibs.model.Building;
import com.pibs.model.Discount;
import com.pibs.model.Employee;
import com.pibs.model.Equipment;
import com.pibs.model.LaboratoryExamination;
import com.pibs.model.MedicalSupply;
import com.pibs.model.MonitorNursery;
import com.pibs.model.Patient;
import com.pibs.model.Professional;
import com.pibs.model.Radiology;
import com.pibs.model.Room;
import com.pibs.model.RoomCategory;
import com.pibs.model.Specialization;
import com.pibs.model.Surgery;
import com.pibs.model.User;
import com.pibs.service.ServiceManager;
import com.pibs.service.ServiceManagerImpl;
import com.pibs.util.PIBSUtils;


public class ArchiveAction extends Action {

	private final static Logger logger = Logger.getLogger(ArchiveAction.class);
	
	@Override
	@SuppressWarnings("unchecked")
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		
		ArchiveFormBean formBean = (ArchiveFormBean) form;
        String forwardAction = ActionConstant.NONE;
		String command = request.getParameter("command");
		
		
		//session expired checking
		if (request.getSession().getAttribute(MiscConstant.USER_SESSION) == null) {
			forwardAction = ActionConstant.SHOW_AJAX_EXPIRED;
		} else {
			if (command!=null) {
				
				int module = ModuleConstant.ARCHIVE;
				
				if (command.equalsIgnoreCase(ParamConstant.AJAX_RESTORE)) {
					//fetch the data
					
					int id = Integer.parseInt(request.getParameter("id"));
					
					User user = (User) request.getSession().getAttribute(MiscConstant.USER_SESSION);
					
					HashMap<String,Object> dataMap = new HashMap<String, Object>();
					
					String entity = (String) request.getSession().getAttribute(MiscConstant.UTILS_ENTITY_TYPE_CRITERIA);//get from session
					
					if (entity!=null) {
					   	switch(Integer.parseInt(entity)) {
			        		case MiscConstant.LOV_ENTITY_TYPE_PROFESSIONAL:
								Professional profModel = new Professional();
								profModel.setId(id);
								dataMap.put(MapConstant.CLASS_DATA, profModel);
								module = ModuleConstant.PROFESSIONAL;
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_SURGERY:
								Surgery surgModel = new Surgery();
								surgModel.setId(id);
								dataMap.put(MapConstant.CLASS_DATA, surgModel);
								module = ModuleConstant.SURGERY;
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_ROOM:
								Room roomModel = new Room();
								roomModel.setId(id);
								dataMap.put(MapConstant.CLASS_DATA, roomModel);
								module = ModuleConstant.ROOM;
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_ROOM_CATEGORY:
								RoomCategory roomCategModel = new RoomCategory();
								roomCategModel.setId(id);
								dataMap.put(MapConstant.CLASS_DATA, roomCategModel);
								module = ModuleConstant.ROOM_CATEGORY;
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_EQUIPMENT:
			        			Equipment equipModel = new Equipment();
			        			equipModel.setId(id);
								dataMap.put(MapConstant.CLASS_DATA, equipModel);
								module = ModuleConstant.EQUIPMENT;
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_DISCOUNT:
			        			Discount discModel = new Discount();
			        			discModel.setId(id);
								dataMap.put(MapConstant.CLASS_DATA, discModel);
								module = ModuleConstant.DISCOUNT;
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_ADDITIONAL_SERVICES:
			        			AdditionalServices addServModel = new AdditionalServices();
			        			addServModel.setId(id);
								dataMap.put(MapConstant.CLASS_DATA, addServModel);
								module = ModuleConstant.ADDITIONAL_SERVICES;
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_ADDITIONAL_SERVICES_CATEGORY:
			        			AdditionalServicesCategory addServCategModel = new AdditionalServicesCategory();
			        			addServCategModel.setId(id);
								dataMap.put(MapConstant.CLASS_DATA, addServCategModel);
								module = ModuleConstant.ADDITIONAL_SERVICES_CATEGORY;
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_RADIOLOGY:
			        			Radiology radModel = new Radiology();
			        			radModel.setId(id);
								dataMap.put(MapConstant.CLASS_DATA, radModel);
								module = ModuleConstant.RADIOLOGY;
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_MEDICAL_SUPPLY:
			        			MedicalSupply medModel = new MedicalSupply();
			        			medModel.setId(id);
								dataMap.put(MapConstant.CLASS_DATA, medModel);
								module = ModuleConstant.MEDICAL_SUPPLY;
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_SPECIALIZATION:
			        			Specialization specModel = new Specialization();
			        			specModel.setId(id);
								dataMap.put(MapConstant.CLASS_DATA, specModel);
								module = ModuleConstant.SPECIALIZATION;
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_BUILDING:
			        			Building buildModel = new Building();
			        			buildModel.setId(id);
								dataMap.put(MapConstant.CLASS_DATA, buildModel);
								module = ModuleConstant.BUILDING;
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_LABORATORY_EXAMINATION:
			        			LaboratoryExamination labModel = new LaboratoryExamination();
			        			labModel.setId(id);
								dataMap.put(MapConstant.CLASS_DATA, labModel);
								module = ModuleConstant.LABORATORY_EXAMINATION;
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_PATIENT:
								Patient patientModel = new Patient();
								patientModel.setId(id);
								dataMap.put(MapConstant.CLASS_DATA, patientModel);
								module = ModuleConstant.PATIENT;
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_NURSERY:
								MonitorNursery nurseryModel = new MonitorNursery();
								nurseryModel.setId(id);
								dataMap.put(MapConstant.CLASS_DATA, nurseryModel);
								module = ModuleConstant.NURSERY_INQUIRY;
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_EMPLOYEE:
								Employee empModel = new Employee();
								empModel.setId(id);
								dataMap.put(MapConstant.CLASS_DATA, empModel);
								module = ModuleConstant.EMPLOYEE;
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_USER:
								User userModel = new User();
								userModel.setId(id);
								dataMap.put(MapConstant.CLASS_DATA, userModel);
								module = ModuleConstant.USER;
			        			break;
			   			  default:
			        			break;
			        	}				
					}

					dataMap.put(MapConstant.ENTITY, entity);
			        dataMap.put(MapConstant.MODULE, module);
			        dataMap.put(MapConstant.ACTION, ActionConstant.RESTORE);
			        dataMap.put(MapConstant.USER_SESSION_DATA, user);
			        
			        ServiceManager service = new ServiceManagerImpl();
			        Map<String, Object> resultMap = service.executeRequest(dataMap);
					
			        if (resultMap!=null && !resultMap.isEmpty()) {
			        	//check resultmap action status
			        	boolean tranctionStatus = (boolean) resultMap.get(MapConstant.TRANSACTION_STATUS);

			        	formBean.setTransactionStatus(tranctionStatus);
			        	formBean.populateEntityTypeDropdownList(request);
			        	
			        	if (tranctionStatus) {
			        		//show success page
			        		//add confirmation message
			        		formBean.setTransactionMessage(MiscConstant.TRANS_MESSSAGE_RESTORED);

			        		//logger.info(MiscConstant.TRANS_MESSSAGE_DELETED);
			        		PIBSUtils.writeLogInfo(logger, MiscConstant.TRANS_MESSSAGE_RESTORED+" - "+module);
			        		forwardAction = ActionConstant.AJAX_SUCCESS;
			        	} else {
			        		formBean.setTransactionMessage(MiscConstant.TRANS_MESSSAGE_ERROR);
			        		//logger.info(MiscConstant.TRANS_MESSSAGE_ERROR);
			        		PIBSUtils.writeLogInfo(logger, MiscConstant.TRANS_MESSSAGE_RESTORED+" - "+module);
			        		forwardAction = ActionConstant.AJAX_FAILED;
			        	}
			        }

				} else if (command.equalsIgnoreCase(ParamConstant.AJAX_SEARCH)) {
					//get all the records from DB
									
					 int page = 1;
				     if(request.getParameter("page") != null) {
				         page = Integer.parseInt(request.getParameter("page")); 
				     }
				     
				    int offset = (page-1) * MiscConstant.RECORDS_PER_PAGE; 

					String entity = formBean.getEntity();
					request.getSession().setAttribute(MiscConstant.UTILS_ENTITY_TYPE_CRITERIA, entity);
					
					switch(Integer.parseInt(entity)) {
	        			case MiscConstant.LOV_ENTITY_TYPE_PROFESSIONAL:
	        				module = ModuleConstant.PROFESSIONAL;
	        				break;
	        			case MiscConstant.LOV_ENTITY_TYPE_SURGERY:
	        				module = ModuleConstant.SURGERY;
	        				break;
	        			case MiscConstant.LOV_ENTITY_TYPE_ROOM:
	        				module = ModuleConstant.ROOM;
	        				break;
	        			case MiscConstant.LOV_ENTITY_TYPE_ROOM_CATEGORY:
	        				module = ModuleConstant.ROOM_CATEGORY;
	        				break;
	        			case MiscConstant.LOV_ENTITY_TYPE_EQUIPMENT:
	        				module = ModuleConstant.EQUIPMENT;
	        				break;
	        			case MiscConstant.LOV_ENTITY_TYPE_DISCOUNT:
	        				module = ModuleConstant.DISCOUNT;
	        				break;
	        			case MiscConstant.LOV_ENTITY_TYPE_ADDITIONAL_SERVICES:
	        				module = ModuleConstant.ADDITIONAL_SERVICES;
	        				break;
	        			case MiscConstant.LOV_ENTITY_TYPE_ADDITIONAL_SERVICES_CATEGORY:
	        				module = ModuleConstant.ADDITIONAL_SERVICES_CATEGORY;
	        				break;
	        			case MiscConstant.LOV_ENTITY_TYPE_RADIOLOGY:
	        				module = ModuleConstant.RADIOLOGY;
	        				break;
	        			case MiscConstant.LOV_ENTITY_TYPE_MEDICAL_SUPPLY:
	        				module = ModuleConstant.MEDICAL_SUPPLY;
	        				break;
	        			case MiscConstant.LOV_ENTITY_TYPE_SPECIALIZATION:
	        				module = ModuleConstant.SPECIALIZATION;
	        				break;
	        			case MiscConstant.LOV_ENTITY_TYPE_BUILDING:
	        				module = ModuleConstant.BUILDING;
	        				break;
	        			case MiscConstant.LOV_ENTITY_TYPE_LABORATORY_EXAMINATION:
	        				module = ModuleConstant.LABORATORY_EXAMINATION;
	        				break;
	        			case MiscConstant.LOV_ENTITY_TYPE_PATIENT:
		        			module = ModuleConstant.PATIENT;
		        			break;
	        			case MiscConstant.LOV_ENTITY_TYPE_NURSERY:
		        			module = ModuleConstant.NURSERY_INQUIRY;//Entity type in Dropdown is Nursery
		        			break;
	        			case MiscConstant.LOV_ENTITY_TYPE_EMPLOYEE:
		        			module = ModuleConstant.EMPLOYEE;
		        			break;
	        			case MiscConstant.LOV_ENTITY_TYPE_USER:
		        			module = ModuleConstant.USER;
		        			break;
		        		default:
		        			break;
					}

					HashMap<String,Object> dataMap = new HashMap<String, Object>();
					dataMap.put(MapConstant.ENTITY, entity);
			        dataMap.put(MapConstant.MODULE, module);
				    dataMap.put(MapConstant.ACTION, ActionConstant.GET_INACTIVE_DATA);
				    dataMap.put(MapConstant.PAGINATION_LIMIT, MiscConstant.RECORDS_PER_PAGE);
				    dataMap.put(MapConstant.PAGINATION_OFFSET, offset);

			        ServiceManager service = new ServiceManagerImpl();
			        Map<String, Object> resultMap = service.executeRequest(dataMap);
			        
			        if (resultMap!=null && !resultMap.isEmpty()) {
				        
			        	switch(Integer.parseInt(entity)) {
				        	case MiscConstant.LOV_ENTITY_TYPE_PROFESSIONAL:
								List<Professional> profList =  (List<Professional>) resultMap.get(MapConstant.CLASS_LIST);     		
					        	formBean.setProfList(profList);
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_SURGERY:
								List<Surgery> surgeryList =  (List<Surgery>) resultMap.get(MapConstant.CLASS_LIST);     		
					        	formBean.setSurgeryList(surgeryList);
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_ROOM:
								List<Room> roomList =  (List<Room>) resultMap.get(MapConstant.CLASS_LIST);     		
					        	formBean.setRoomList(roomList);
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_ROOM_CATEGORY:
								List<RoomCategory> roomCategList =  (List<RoomCategory>) resultMap.get(MapConstant.CLASS_LIST);     		
					        	formBean.setRoomCategList(roomCategList);
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_EQUIPMENT:
								List<Equipment> equipList =  (List<Equipment>) resultMap.get(MapConstant.CLASS_LIST);     		
					        	formBean.setEquipList(equipList);
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_DISCOUNT:
								List<Discount> discountList =  (List<Discount>) resultMap.get(MapConstant.CLASS_LIST);     		
					        	formBean.setDiscountList(discountList);
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_ADDITIONAL_SERVICES:
								List<AdditionalServices> addServList =  (List<AdditionalServices>) resultMap.get(MapConstant.CLASS_LIST);     		
					        	formBean.setAddServList(addServList);
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_ADDITIONAL_SERVICES_CATEGORY:
								List<AdditionalServicesCategory> addServCategList =  (List<AdditionalServicesCategory>) resultMap.get(MapConstant.CLASS_LIST);     		
					        	formBean.setAddServCategList(addServCategList);
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_RADIOLOGY:
								List<Radiology> radList =  (List<Radiology>) resultMap.get(MapConstant.CLASS_LIST);     		
					        	formBean.setRadList(radList);
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_MEDICAL_SUPPLY:
								List<MedicalSupply> medList =  (List<MedicalSupply>) resultMap.get(MapConstant.CLASS_LIST);     		
					        	formBean.setMedList(medList);
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_SPECIALIZATION:
								List<Specialization> specList =  (List<Specialization>) resultMap.get(MapConstant.CLASS_LIST);     		
					        	formBean.setSpecList(specList);
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_BUILDING:
								List<Building> buildList =  (List<Building>) resultMap.get(MapConstant.CLASS_LIST);     		
					        	formBean.setBuildList(buildList);
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_LABORATORY_EXAMINATION:
								List<LaboratoryExamination> labList =  (List<LaboratoryExamination>) resultMap.get(MapConstant.CLASS_LIST);     		
					        	formBean.setLabList(labList);
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_PATIENT:
								List<Patient> patientList =  (List<Patient>) resultMap.get(MapConstant.CLASS_LIST);     		
					        	formBean.setPatientList(patientList);
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_NURSERY:
								List<MonitorNursery> nurseryList =  (List<MonitorNursery>) resultMap.get(MapConstant.CLASS_LIST);     		
					        	formBean.setNurseryList(nurseryList);
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_EMPLOYEE:
								List<Employee> empList =  (List<Employee>) resultMap.get(MapConstant.CLASS_LIST);     		
					        	formBean.setEmpList(empList);
			        			break;
			        		case MiscConstant.LOV_ENTITY_TYPE_USER:
								List<User> userList =  (List<User>) resultMap.get(MapConstant.CLASS_LIST);     		
					        	formBean.setUserList(userList);
			        			break;
			        		default:
			        			break;
			        	}

			        	
			        	int totalNoOfRecords = (int) resultMap.get(MapConstant.PAGINATION_TOTALRECORDS);
			            int noOfPages = (int) Math.ceil(totalNoOfRecords * 1.0 / MiscConstant.RECORDS_PER_PAGE);
						
			            formBean.setNoOfPages(noOfPages);
			            formBean.setCurrentPage(page);
			            
			        } else {
			        	formBean.setPatientList(null);
			        	//formBean.setModelList(null);
			            formBean.setNoOfPages(0);
			            formBean.setCurrentPage(0);
			        }
			        
			        forwardAction = ActionConstant.SHOW_AJAX_TABLE;
					
				}
			} else {
				//show main screen
				//load the LOV for Entity Master file
				formBean.populateEntityTypeDropdownList(request);
				if (request.getSession().getAttribute(MiscConstant.UTILS_ENTITY_TYPE_CRITERIA)!=null) {
					request.getSession().setAttribute(MiscConstant.UTILS_ENTITY_TYPE_CRITERIA, null);
				}
				forwardAction = ActionConstant.SHOW_AJAX_MAIN;
			}
			
		}
		
		return mapping.findForward(forwardAction);
	}	
	

}
