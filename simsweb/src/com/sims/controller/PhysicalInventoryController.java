package com.sims.controller;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sims.bo.ItemBo;
import com.sims.bo.ItemInventoryBo;
import com.sims.bo.ItemInventoryDetailsBo;
import com.sims.bo.PhysicalInventoryDetailsBo;
import com.sims.bo.PhysicalInventoryBo;
import com.sims.constant.SIMSConstant;
import com.sims.model.Item;
import com.sims.model.ItemInventory;
import com.sims.model.ItemInventoryDetails;
import com.sims.model.ListValue;
import com.sims.model.PhysicalInventoryDetails;
import com.sims.model.PhysicalInventory;
import com.sims.propertyeditor.CustomSQLDateEditor;
import com.sims.util.SIMSUtil;
import com.sims.validator.PhysicalInventoryValidator;

@Controller
@SessionAttributes(value =  {"userid","name"})
public class PhysicalInventoryController {
	
	private final static Logger logger = Logger.getLogger(PhysicalInventoryController.class);
	
	@Autowired
	private PhysicalInventoryBo physicalInventoryBo;
	@Autowired
	private PhysicalInventoryDetailsBo physicalInventoryDetailsBo;
	@Autowired
	private ItemBo itemBo;
	@Autowired
	private ItemInventoryBo itemInventoryBo;
	@Autowired
	private ItemInventoryDetailsBo itemInventoryDetailsBo;
	@Autowired
	private PhysicalInventoryValidator physicalInventoryValidator;

	private List<Item> itemList = new ArrayList<>();
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
				
        CustomSQLDateEditor dateEditor = new CustomSQLDateEditor(null, true); //dateFormat not used.  DateUtil class is used instead
        binder.registerCustomEditor(Date.class, dateEditor);
	    
        if (binder.getObjectName().equals("physicalInventory")) {
        	binder.addValidators(physicalInventoryValidator);	
	    }
 
		
	}
	
	@RequestMapping("/goToSearchPhysicalInventory")
	public ModelAndView goToSearchPhysicalInventory(ModelMap model) {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "physicalInventory", new PhysicalInventory());	
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("searchFlag", false);
		mv.addObject("physicalInventory", new PhysicalInventory());
		mv.setViewName("transaction/physicalinventory/searchPhysicalInventory");
		return mv;
	}
	
	@RequestMapping("/goToAddPhysicalInventory")
	public ModelAndView goToAddPhysicalInventory(ModelMap model) {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "physicalInventory", new PhysicalInventory());	
		}
		
		return new ModelAndView("transaction/physicalinventory/addPhysicalInventory", "physicalInventory", new PhysicalInventory());
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/searchPhysicalInventory")
	public ModelAndView searchPhysicalInventory(@RequestParam("page") String page, @ModelAttribute("physicalInventory") PhysicalInventory physicalInventory, 
    			BindingResult result, ModelMap model) throws Exception {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "physicalInventory", new PhysicalInventory());	
		}
		
		//Note: can use modelattribute in a form in jsp
		//or can simply pass a parameter
		
		Map<Object,Object> mapCriteria = new HashMap<Object,Object>();
		
		mapCriteria.put("search_criteria", physicalInventory.getDateOfInventory()!=null ? physicalInventory.getDateOfInventory() : "01/01/1901");
		mapCriteria.put("record_start", SIMSUtil.getRecordStartIndex(page!=null ? Integer.parseInt(page) : 1));
		mapCriteria.put("max_result", SIMSConstant.RECORDS_PER_PAGE);
		
		Map<Object,Object> resultMap = physicalInventoryBo.findByDateOfInventory(mapCriteria);
		
		List<PhysicalInventory> resultList = (List<PhysicalInventory>) resultMap.get("resultList");
		Integer noOfPages = (Integer) resultMap.get("noOfPages");
		
		boolean gotRecords = resultList!=null && resultList.size() > 0 ? true : false;
		
		model.addAttribute("resultList", resultList);
		model.addAttribute("searchFlag", true);
		model.addAttribute("gotRecords", gotRecords);
		model.addAttribute("currentPage", page);
		model.addAttribute("noOfPages", noOfPages);
		
		return new ModelAndView("transaction/physicalinventory/searchPhysicalInventory", "physicalInventory", physicalInventory);
	}
		
	@RequestMapping(value = "/savePhysicalInventory", method = RequestMethod.POST)
	public ModelAndView savePhysicalInventory(@ModelAttribute("physicalInventory") @Validated PhysicalInventory physicalInventory, 
		      BindingResult result, ModelMap model) throws Exception {
				
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "physicalInventory", new PhysicalInventory());	
		}
		
		if (result.hasErrors()) {
			return new ModelAndView("transaction/physicalinventory/addPhysicalInventory", "physicalInventory", physicalInventory);
		}
		
		physicalInventory.setPiNo(generatePINo());
		physicalInventory.setCreatedBy(SIMSUtil.getUserIdFromSession(model));
		
		boolean isSuccess = physicalInventoryBo.save(physicalInventory);
		
		if (isSuccess) {
			logger.info("Added PhysicalInventory Header.. Proceed to View PhysicalInventory Details");
			physicalInventory = physicalInventoryBo.findByPINo(physicalInventory.getPiNo());
		}
		
		model.addAttribute("isSuccess", isSuccess);
		
		return new ModelAndView("transaction/physicalinventory/addPhysicalInventory", "physicalInventory", physicalInventory);
	}
	
		
	@RequestMapping(value = "/viewPhysicalInventory", method=RequestMethod.GET)
	public ModelAndView viewPhysicalInventory(@RequestParam("piId") int piId, ModelMap model) throws Exception {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "physicalInventory", new PhysicalInventory());	
		}
		
		PhysicalInventory physicalInventory = physicalInventoryBo.findById(piId);
		
		itemList = getItemList();
		model.addAttribute("itemList", itemList);
		
		//Order by item description - Physical Inventory Details list
		sortPhysicalInventoryDetailsByItemDescription(physicalInventory);
		
		return new ModelAndView("transaction/physicalinventory/viewPhysicalInventory", "physicalInventory", physicalInventory);
	}

	@RequestMapping(value = "/selectItem", method=RequestMethod.GET)
	public ModelAndView selectItem(@RequestParam("itemId") int itemId, ModelMap model) throws Exception {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "physicalInventory", new PhysicalInventory());	
		}
		
		Item item = itemBo.findById(itemId);
		List<ItemInventory> itemInventoryList = itemInventoryBo.findByItem(item);
		int systemQty = 0;
		for (ItemInventory rowItem : itemInventoryList) {
			systemQty = systemQty + rowItem.getStockOnHand();
		}
		
		model.addAttribute("systemQty", systemQty);
		
		return new ModelAndView("transaction/physicalinventory/ajaxItemSystemQty", "item", item);
	}
	
	@RequestMapping(value = "/updatePhysicalInventory", method = RequestMethod.POST)
	public ModelAndView updatePhysicalInventory(@ModelAttribute("physicalInventory" ) @Validated PhysicalInventory physicalInventory, 
		      BindingResult result, ModelMap model) throws Exception {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "physicalInventory", new PhysicalInventory());	
		}
		
	    if (result.hasErrors()) {
	    	return new ModelAndView("transaction/physicalinventory/viewPhysicalInventory", "physicalInventory", physicalInventory);
	    }
	          
	    physicalInventory.setModifiedBy(SIMSUtil.getUserIdFromSession(model));
	    
		boolean isSuccess = physicalInventoryBo.update(physicalInventory);
		
		model.addAttribute("isSuccess", isSuccess);
		
		return new ModelAndView("transaction/physicalinventory/viewPhysicalInventory", "physicalInventory", physicalInventory);
	}
	
	@RequestMapping(value = "/deletePhysicalInventory", method=RequestMethod.GET)
	public ModelAndView deletePhysicalInventory(@RequestParam("id") int id, ModelMap model) throws Exception {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "physicalInventory", new PhysicalInventory());	
		}
		
		PhysicalInventory user = physicalInventoryBo.findById(id);
		
		user.setModifiedBy(SIMSUtil.getUserIdFromSession(model));
		
		boolean isSuccess =  physicalInventoryBo.delete(user);
		model.addAttribute("isDeleted", isSuccess);
		
		return new ModelAndView("transaction/physicalinventory/searchPhysicalInventory", "physicalInventory", new PhysicalInventory());
	}
	
	@RequestMapping(value = "/addNewPhysicalInventoryDetails", method = RequestMethod.GET)
	public ModelAndView addNewPhysicalInventoryDetails(@RequestParam("physicalInventoryId") int physicalInventoryId, 
			@RequestParam("itemId") int itemId, @RequestParam("systemQty") int systemQty, @RequestParam("physicalCount") int physicalCount,
			ModelMap model) throws Exception {
				
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "physicalInventory", new PhysicalInventory());	
		}
		
		boolean isSuccess = false;
		
		PhysicalInventory physicalInventory = physicalInventoryBo.findById(physicalInventoryId);
		Item item = itemBo.findById(itemId);
		
		//Delete the existing physicalinventorydetails (set Active= false)
		physicalInventoryDetailsBo.deleteByPhysicalInventoryAndItem(physicalInventory, item);
		
		PhysicalInventoryDetails entity = new PhysicalInventoryDetails();
		entity.setPhysicalInventory(physicalInventory);
		entity.setItem(item);
		entity.setSystemQty(systemQty);
		entity.setPhysicalCount(physicalCount);
		int qtyVar = physicalCount - systemQty;
		entity.setQtyVariance(qtyVar);
		String strVar = null;
		if (qtyVar > 0) {
			strVar = SIMSConstant.VARIANCE_POSITIVE;
		} else if (qtyVar < 0) {
			strVar = SIMSConstant.VARIANCE_NEGATIVE;
		}else {
			strVar = SIMSConstant.VARIANCE_NONE;
		}
		entity.setVariance(strVar);

		if (physicalInventoryDetailsBo.save(entity)) {
			
			//Delete the existing iteminventory (set Active= false)
			itemInventoryBo.deleteByItem(item);
				
			//Create new record in iteminventory
			ItemInventory itemInv = new ItemInventory();
			itemInv.setItem(item);
			itemInv.setRetailPrice(item.getRetailSellingPrice()!=null ? item.getRetailSellingPrice() : new BigDecimal(0));
			itemInv.setWholesalePrice(item.getWholesaleSellingPrice()!=null ? item.getWholesaleSellingPrice() : new BigDecimal(0));
			itemInv.setStockOnHand(physicalCount);
			itemInv.setRemarks("Created in Physical Inventory");
			itemInventoryBo.save(itemInv);
						
			//Get the iteminventoryid
			List<ItemInventory> itemInvList = itemInventoryBo.findByItem(item);
			for (ItemInventory itemInvRow: itemInvList) {
				itemInv = itemInvRow;
			}
			
			//Create new record in iteminventory details
			ItemInventoryDetails itemInvDetails = new ItemInventoryDetails();
			itemInvDetails.setItemInventory(itemInv);
			itemInvDetails.setPhysicalQty(physicalCount);
			itemInvDetails.setModule(new ListValue(701));//Physical Inventory
			itemInvDetails.setTransRefNo(physicalInventory.getPiNo());
			isSuccess = itemInventoryDetailsBo.save(itemInvDetails);
					
			//update the header to get the details
			physicalInventory = physicalInventoryBo.findById(physicalInventoryId);	
			
			//Order by item description - Physical Inventory Details list
			sortPhysicalInventoryDetailsByItemDescription(physicalInventory);
			
		}
		
		model.addAttribute("isSuccess", isSuccess);
		
		return new ModelAndView("transaction/physicalinventory/ajaxPhysicalInventoryDetails", "physicalInventory", physicalInventory);
	}	
	
	private List<Item> getItemList() {
		
		List<Item> list = itemBo.getAllEntity();
			
		return list;
	}
	
	private String generatePINo() {
		StringBuilder sb = new StringBuilder(15);
		try {
			Calendar now = Calendar.getInstance();
			int currentMonth = now.get(Calendar.MONTH) + 1;//0-11
			int currentDayOfMonth = now.get(Calendar.DAY_OF_MONTH);
			sb.append("PI");
			sb.append(now.get(Calendar.YEAR));
			sb.append(String.format("%02d", currentMonth));
			sb.append(String.format("%02d", currentDayOfMonth));
			sb.append(String.format("%08d", physicalInventoryBo.getTotalCount()+1));//get the total record count
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return sb.toString();
	}
	
	private void sortPhysicalInventoryDetailsByItemDescription(PhysicalInventory physicalInventory) {

		Collections.sort(physicalInventory.getPiDetailsList(), new Comparator<PhysicalInventoryDetails>() {

			@Override
			public int compare(PhysicalInventoryDetails p1, PhysicalInventoryDetails p2) {
				// TODO Auto-generated method stub
				
				String item1Description = p1.getItem().getDescription().toUpperCase();
				String item2Description = p2.getItem().getDescription().toUpperCase();
				
				return item1Description.compareTo(item2Description);
			}
				
		});
		
	}
	
}
