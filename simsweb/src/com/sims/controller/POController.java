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
import com.sims.bo.SupplierBo;
import com.sims.bo.POHeaderBo;
import com.sims.constant.SIMSConstant;
import com.sims.model.Item;
import com.sims.model.ListValue;
import com.sims.model.PODetails;
import com.sims.model.Supplier;
import com.sims.model.POHeader;
import com.sims.model.UserAccount;
import com.sims.util.SIMSUtil;

@Controller
@SessionAttributes(value =  {"userid","name"})
public class POController {
	
	private final static Logger logger = Logger.getLogger(POController.class);
	
	@Autowired
	private POHeaderBo pOHeaderBo;
	@Autowired
	private PODetailsBo pODetailsBo;
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
	
	@RequestMapping("/goToSearchPO")
	public ModelAndView goToSearchPO(ModelMap model) {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "poHeader", new POHeader());	
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("searchFlag", false);
		mv.addObject("poHeader", new POHeader());
		mv.setViewName("transaction/purchaseorder/searchPOHeader");
		return mv;
	}
	
	@RequestMapping("/goToAddPOHeader")
	public ModelAndView goToAddPOHeader(ModelMap model) {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "poHeader", new POHeader());	
		}
		
		supplierList = getSupplierList();
		model.addAttribute("supplierList", supplierList);
		
		return new ModelAndView("transaction/purchaseorder/addPOHeader", "poHeader", new POHeader());
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/searchPOHeader")
	public ModelAndView searchPOHeader(@RequestParam("page") String page, @ModelAttribute("poHeader") POHeader poHeader, 
    			BindingResult result, ModelMap model) throws Exception {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "poHeader", new POHeader());	
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
		
		return new ModelAndView("transaction/purchaseorder/searchPOHeader", "poHeader", poHeader);
	}
		
	@RequestMapping(value = "/savePOHeader", method = RequestMethod.POST)
	public ModelAndView savePOHeader(@ModelAttribute("poHeader") @Validated POHeader poHeader, 
		      BindingResult result, ModelMap model) throws Exception {
				
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "poHeader", new POHeader());	
		}
		
		if (result.hasErrors()) {
			return new ModelAndView("transaction/purchaseorder/addPOHeader", "poHeader", poHeader);
		}
		     
		poHeader.setPoNo(generatePONo());
		poHeader.setStatus(new ListValue(601)); //In Progress
		poHeader.setTransDate(new java.sql.Date(System.currentTimeMillis()));
		poHeader.setRequestedBy(SIMSUtil.getUserNameFromSession(model));
		poHeader.setCreatedBy(SIMSUtil.getUserIdFromSession(model));
		
		boolean isSuccess = pOHeaderBo.save(poHeader);
		
		if (isSuccess) {
			logger.info("Added PO Header.. Proceed to View PO Details");
			poHeader = pOHeaderBo.findByPONo(poHeader.getPoNo());
		}
		
		model.addAttribute("supplierList", supplierList);
		model.addAttribute("isSuccess", isSuccess);
		
		return new ModelAndView("transaction/purchaseorder/addPOHeader", "poHeader", poHeader);
	}
	
		
	@RequestMapping(value = "/viewPOHeader", method=RequestMethod.GET)
	public ModelAndView viewPOHeader(@RequestParam("poId") int poId, ModelMap model) throws Exception {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "poHeader", new POHeader());	
		}
		
		POHeader poHeader = pOHeaderBo.findById(poId);
		
		itemList = getItemList();
		model.addAttribute("itemList", itemList);
		model.addAttribute("totalAmount", poHeader.getTotalAmount());
		
		return new ModelAndView("transaction/purchaseorder/viewPOHeader", "poHeader", poHeader);
	}
		
	@RequestMapping(value = "/updatePOHeader", method = RequestMethod.POST)
	public ModelAndView updatePOHeader(@ModelAttribute("poHeader" ) @Validated POHeader poHeader, 
		      BindingResult result, ModelMap model) throws Exception {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "poHeader", new POHeader());	
		}
		
	    if (result.hasErrors()) {
	    	return new ModelAndView("transaction/purchaseorder/viewPOHeader", "poHeader", poHeader);
	    }
	          
	    poHeader.setModifiedBy(SIMSUtil.getUserIdFromSession(model));
	    
		boolean isSuccess = pOHeaderBo.update(poHeader);
		
		model.addAttribute("isSuccess", isSuccess);
		
		return new ModelAndView("transaction/purchaseorder/viewPOHeader", "poHeader", poHeader);
	}
	
	@RequestMapping(value = "/deletePOHeader", method=RequestMethod.GET)
	public ModelAndView deletePOHeader(@RequestParam("id") int id, ModelMap model) throws Exception {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "poHeader", new POHeader());	
		}
		
		POHeader user = pOHeaderBo.findById(id);
		
		user.setModifiedBy(SIMSUtil.getUserIdFromSession(model));
		
		boolean isSuccess =  pOHeaderBo.delete(user);
		model.addAttribute("isDeleted", isSuccess);
		
		return new ModelAndView("transaction/purchaseorder/searchPOHeader", "poHeader", new POHeader());
	}
	
	@RequestMapping(value = "/addNewPODetails", method = RequestMethod.GET)
	public ModelAndView addNewPODetails(@RequestParam("poHeaderId") int poHeaderId, 
			@RequestParam("itemId") int itemId, @RequestParam("qty") int qty, ModelMap model) throws Exception {
				
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "poHeader", new POHeader());	
		}
		
		boolean isSuccess = false;
		
		POHeader poHeader = pOHeaderBo.findById(poHeaderId);
		Item item = itemBo.findById(itemId);
		
		PODetails entity = new PODetails();
		entity.setPoHeader(poHeader);
		entity.setItem(item);
		entity.setQty(qty);
		entity.setPrice(item.getRetailOrigPrice());//temp code
		double amount = entity.getQty() * (entity.getPrice()!=null ? entity.getPrice().doubleValue() : 0.00D);
		entity.setAmount(new BigDecimal(amount));
		
		List<PODetails> list = new ArrayList<>();
		
		if (pODetailsBo.save(entity)) {
			//get the total amount
			list = pODetailsBo.getListByPOHeader(poHeader);
			double totalAmount = 0.0D;
			for (PODetails itemDetails: list) {
				totalAmount = totalAmount + itemDetails.getAmount().doubleValue();
			}
			poHeader.setTotalAmount(new BigDecimal(totalAmount));
			poHeader.setModifiedBy(SIMSUtil.getUserIdFromSession(model));
			if (pOHeaderBo.update(poHeader)) {
				isSuccess = true;
				logger.info("Added PO Details..");
			};
		}
				
		//update the header to get the details
		poHeader = pOHeaderBo.findById(poHeaderId);
		
		model.addAttribute("isSuccess", isSuccess);
		model.addAttribute("totalAmount", poHeader.getTotalAmount());
		
		return new ModelAndView("transaction/purchaseorder/ajaxPODetails", "poHeader", poHeader);
	}

	@RequestMapping("/deletePODetails")
	public ModelAndView deletePODetails(@RequestParam("poHeaderId") int poHeaderId,
			@RequestParam("poDetailsId") int poDetailsId, ModelMap model) {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		POHeader poHeader = pOHeaderBo.findById(poHeaderId);
		
		//delete the item details
		PODetails entity = pODetailsBo.findById(poDetailsId);
			
		List<PODetails> list = new ArrayList<>();
		
		if (pODetailsBo.delete(entity)) {
			//get the total amount
			list = pODetailsBo.getListByPOHeader(poHeader);
			double totalAmount = 0.0D;
			for (PODetails itemDetails: list) {
				totalAmount = totalAmount + itemDetails.getAmount().doubleValue();
			}
			poHeader.setTotalAmount(new BigDecimal(totalAmount));
			poHeader.setModifiedBy(SIMSUtil.getUserIdFromSession(model));
			if (pOHeaderBo.update(poHeader)) {
				logger.info("Deleted PO Details..");
			};
		}
		
		poHeader = pOHeaderBo.findById(poHeaderId);
		model.addAttribute("totalAmount", poHeader.getTotalAmount());
		
		return new ModelAndView("transaction/purchaseorder/ajaxPODetails", "poHeader", poHeader);
	}
	
		
	private List<Supplier> getSupplierList() {
		
		List<Supplier> list = supplierBo.getAllEntity();
		
		return list;
	}
	
	private List<Item> getItemList() {
		
		List<Item> list = itemBo.getAllEntity();
		
		return list;
	}
	
	private String generatePONo() {
		StringBuilder sb = new StringBuilder(15);
		try {
			Calendar now = Calendar.getInstance();
			int currentMonth = now.get(Calendar.MONTH) + 1;//0-11
			int currentDayOfMonth = now.get(Calendar.DAY_OF_MONTH);
			sb.append("P");
			sb.append(now.get(Calendar.YEAR));
			sb.append(String.format("%02d", currentMonth));
			sb.append(String.format("%02d", currentDayOfMonth));
			sb.append(String.format("%08d", pOHeaderBo.getTotalCount()+1));//get the total record count
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return sb.toString();
	}
	
}
