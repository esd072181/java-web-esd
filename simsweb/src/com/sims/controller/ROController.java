package com.sims.controller;

import java.beans.PropertyEditorSupport;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
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
import com.sims.bo.ListValueBo;
import com.sims.bo.PODetailsBo;
import com.sims.bo.RODetailsBo;
import com.sims.bo.ROHeaderBo;
import com.sims.bo.SupplierBo;
import com.sims.bo.POHeaderBo;
import com.sims.constant.SIMSConstant;
import com.sims.model.Item;
import com.sims.model.ListValue;
import com.sims.model.PODetails;
import com.sims.model.RODetails;
import com.sims.model.ROHeader;
import com.sims.model.Supplier;
import com.sims.model.POHeader;
import com.sims.model.UserAccount;
import com.sims.util.SIMSUtil;

@Controller
@SessionAttributes(value =  {"userid","name"})
public class ROController {
	
	private final static Logger logger = Logger.getLogger(ROController.class);
	
	@Autowired
	private POHeaderBo pOHeaderBo;
	@Autowired
	private ROHeaderBo rOHeaderBo;
	@Autowired
	private RODetailsBo rODetailsBo;
	@Autowired
	private SupplierBo supplierBo;
	@Autowired
	private ListValueBo listValueBo;
	@Autowired
	private ItemBo itemBo;
	
	private List<Supplier> supplierList = new ArrayList<>();
	private List<Item> itemList = new ArrayList<>();
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
				
        binder.registerCustomEditor(ListValue.class, new PropertyEditorSupport() {
        	@Override
			public void setAsText(String id) throws IllegalArgumentException {
			        this.setValue(new ListValue(Integer.parseInt(id)));
			}
        });
 
		
	}
	
	@RequestMapping("/goToSearchPOInRO")
	public ModelAndView goToSearchPOInRO(ModelMap model) {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "poHeader", new POHeader());	
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("searchFlag", false);
		mv.addObject("poHeader", new POHeader());
		mv.setViewName("transaction/receiveorder/searchPOHeaderInRO");
		return mv;
	}
	
	@RequestMapping("/goToAddROHeader")
	public ModelAndView goToAddROHeader(ModelMap model) {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "poHeader", new POHeader());	
		}
		
		//get the PO header list with status = In Progress (601)
		
		supplierList = getSupplierList();
		model.addAttribute("supplierList", supplierList);
		
		
		return new ModelAndView("transaction/receiveorder/addROHeader", "roHeader", new ROHeader());
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/searchPOHeaderInRO")
	public ModelAndView searchPOHeaderInRO(@RequestParam("page") String page, @ModelAttribute("roHeader") POHeader poHeader, 
    			BindingResult result, ModelMap model) throws Exception {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "roHeader", new ROHeader());	
		}
		
		//Note: can use modelattribute in a form in jsp
		//or can simply pass a parameter
		
		Map<Object,Object> mapCriteria = new HashMap<Object,Object>();
		
		mapCriteria.put("search_criteria", poHeader.getSupplier().getName()!=null ? poHeader.getSupplier().getName() : "");
		mapCriteria.put("record_start", SIMSUtil.getRecordStartIndex(page!=null ? Integer.parseInt(page) : 1));
		mapCriteria.put("max_result", SIMSConstant.RECORDS_PER_PAGE);
		
		Map<Object,Object> resultMap = pOHeaderBo.findBySupplierName(mapCriteria);
		
		List<POHeader> resultList = (List<POHeader>) resultMap.get("resultList");
		Integer noOfPages = (Integer) resultMap.get("noOfPages");
		
		boolean gotRecords = resultList!=null && resultList.size() > 0 ? true : false;
		
		model.addAttribute("resultList", resultList);
		model.addAttribute("searchFlag", true);
		model.addAttribute("gotRecords", gotRecords);
		model.addAttribute("currentPage", page);
		model.addAttribute("noOfPages", noOfPages);
		
		return new ModelAndView("transaction/receiveorder/searchPOHeaderInRO", "poHeader", poHeader);
	}
		
	@RequestMapping(value = "/saveROHeader", method = RequestMethod.POST)
	public ModelAndView saveROHeader(@ModelAttribute("roHeader") @Validated ROHeader roHeader, 
		      BindingResult result, ModelMap model) throws Exception {
				
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "roHeader", new ROHeader());	
		}
		
		if (result.hasErrors()) {
			return new ModelAndView("transaction/receiveorder/addROHeader", "roHeader", roHeader);
		}
		     
//		poHeader.setPoNo(generatePONo());
//		poHeader.setStatus(new ListValue(601)); //In Progress
//		poHeader.setTransDate(new java.sql.Date(System.currentTimeMillis()));
//		poHeader.setRequestedBy(SIMSUtil.getUserNameFromSession(model));
//		poHeader.setCreatedBy(SIMSUtil.getUserIdFromSession(model));
//		
//		boolean isSuccess = pOHeaderBo.save(poHeader);
//		
//		if (isSuccess) {
//			logger.info("Added PO Header.. Proceed to View PO Details");
//			poHeader = pOHeaderBo.findByPONo(poHeader.getPoNo());
//		}
//		
//		model.addAttribute("supplierList", supplierList);
//		model.addAttribute("isSuccess", isSuccess);
		
		return new ModelAndView("transaction/receiveorder/addROHeader", "roHeader", roHeader);
	}
	
		
	@RequestMapping(value = "/viewPOHeaderInRO", method=RequestMethod.GET)
	public ModelAndView viewPOHeaderInRO(@RequestParam("poId") int poId, ModelMap model) throws Exception {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "roHeader", new ROHeader());	
		}
		
		POHeader poHeader = pOHeaderBo.findById(poId);
		
		itemList = getItemList();
		model.addAttribute("itemList", itemList);
		model.addAttribute("totalAmount", poHeader.getTotalAmount());
		
		return new ModelAndView("transaction/receiveorder/viewPOHeaderInRO", "poHeader", poHeader);
	}
		
	@RequestMapping(value = "/updateROHeader", method = RequestMethod.POST)
	public ModelAndView updateROHeader(@ModelAttribute("roHeader" ) @Validated ROHeader roHeader, 
		      BindingResult result, ModelMap model) throws Exception {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "roHeader", new ROHeader());	
		}
		
	    if (result.hasErrors()) {
	    	return new ModelAndView("transaction/receiveorder/viewROHeader", "roHeader", roHeader);
	    }
	          
	    roHeader.setModifiedBy(SIMSUtil.getUserIdFromSession(model));
	    
		boolean isSuccess = rOHeaderBo.update(roHeader);
		
		model.addAttribute("isSuccess", isSuccess);
		
		return new ModelAndView("transaction/receiveorder/viewROHeader", "roHeader", roHeader);
	}
	
	@RequestMapping(value = "/deleteROHeader", method=RequestMethod.GET)
	public ModelAndView deleteROHeader(@RequestParam("id") int id, ModelMap model) throws Exception {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "roHeader", new ROHeader());	
		}
		
		ROHeader user = rOHeaderBo.findById(id);
		
		user.setModifiedBy(SIMSUtil.getUserIdFromSession(model));
		
		boolean isSuccess =  rOHeaderBo.delete(user);
		model.addAttribute("isDeleted", isSuccess);
		
		return new ModelAndView("transaction/receiveorder/searchROHeader", "roHeader", new ROHeader());
	}
	
	@RequestMapping(value = "/addNewRODetails", method = RequestMethod.GET)
	public ModelAndView addNewRODetails(@RequestParam("roHeaderId") int roHeaderId, 
			@RequestParam("itemId") int itemId, @RequestParam("qty") int qty, ModelMap model) throws Exception {
				
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "poHeader", new POHeader());	
		}
		
		boolean isSuccess = false;
		
		ROHeader roHeader = rOHeaderBo.findById(roHeaderId);
		Item item = itemBo.findById(itemId);
		
		RODetails entity = new RODetails();
		entity.setRoHeader(roHeader);
		entity.setItem(item);
		entity.setQty(qty);
		entity.setPrice(item.getRetailOrigPrice());//temp code
		double amount = entity.getQty() * (entity.getPrice()!=null ? entity.getPrice().doubleValue() : 0.00D);
		entity.setAmount(new BigDecimal(amount));
		
		List<RODetails> list = new ArrayList<>();
		
		if (rODetailsBo.save(entity)) {
			//get the total amount
			list = rODetailsBo.getListByROHeader(roHeader);
			double totalAmount = 0.0D;
			for (RODetails itemDetails: list) {
				totalAmount = totalAmount + itemDetails.getAmount().doubleValue();
			}
			roHeader.setTotalAmount(new BigDecimal(totalAmount));
			roHeader.setModifiedBy(SIMSUtil.getUserIdFromSession(model));
			if (rOHeaderBo.update(roHeader)) {
				isSuccess = true;
				logger.info("Added RO Details..");
			};
		}
				
		//update the header to get the details
		roHeader = rOHeaderBo.findById(roHeaderId);
		
		model.addAttribute("isSuccess", isSuccess);
		model.addAttribute("totalAmount", roHeader.getTotalAmount());
		
		return new ModelAndView("transaction/receiveorder/ajaxRODetails", "roHeader", roHeader);
	}

	@RequestMapping("/deleteRODetails")
	public ModelAndView deleteRODetails(@RequestParam("roHeaderId") int roHeaderId,
			@RequestParam("roDetailsId") int roDetailsId, ModelMap model) {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		ROHeader roHeader = rOHeaderBo.findById(roHeaderId);
		
		//delete the item details
		RODetails entity = rODetailsBo.findById(roDetailsId);
			
		List<RODetails> list = new ArrayList<>();
		
		if (rODetailsBo.delete(entity)) {
			//get the total amount
			list = rODetailsBo.getListByROHeader(roHeader);
			double totalAmount = 0.0D;
			for (RODetails itemDetails: list) {
				totalAmount = totalAmount + itemDetails.getAmount().doubleValue();
			}
			roHeader.setTotalAmount(new BigDecimal(totalAmount));
			roHeader.setModifiedBy(SIMSUtil.getUserIdFromSession(model));
			if (rOHeaderBo.update(roHeader)) {
				logger.info("Deleted RO Details..");
			};
		}
		
		roHeader = rOHeaderBo.findById(roHeaderId);
		model.addAttribute("totalAmount", roHeader.getTotalAmount());
		
		return new ModelAndView("transaction/receiveorder/ajaxRODetails", "roHeader", roHeader);
	}
	
		
	private List<Supplier> getSupplierList() {
		
		List<Supplier> list = supplierBo.getAllEntity();
		
		return list;
	}
	
	private List<Item> getItemList() {
		
		List<Item> list = itemBo.getAllEntity();
		
		return list;
	}
	
	
}
