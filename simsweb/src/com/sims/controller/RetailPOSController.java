package com.sims.controller;

import java.beans.PropertyEditorSupport;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sims.bo.ItemBo;
import com.sims.bo.ItemInventoryBo;
import com.sims.bo.ItemInventoryDetailsBo;
import com.sims.bo.SalesDetailsBo;
import com.sims.bo.SalesHeaderBo;
import com.sims.constant.SIMSConstant;
import com.sims.model.Customer;
import com.sims.model.Item;
import com.sims.model.ItemInventory;
import com.sims.model.ItemInventoryDetails;
import com.sims.model.ListValue;
import com.sims.model.SalesDetails;
import com.sims.model.SalesHeader;
import com.sims.model.UserAccount;
import com.sims.util.SIMSUtil;

@Controller
@SessionAttributes(value =  {"userid","roleid","name"})
public class RetailPOSController {
	
	private final static Logger logger = Logger.getLogger(RetailPOSController.class);
	
	@Autowired
	private ItemBo itemBo;
	@Autowired
	private SalesHeaderBo salesHeaderBo;
	@Autowired
	private SalesDetailsBo salesDetailsBo;
	@Autowired
	private ItemInventoryBo itemInventoryBo;
	@Autowired
	private ItemInventoryDetailsBo itemInventoryDetailsBo;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		        		
        binder.registerCustomEditor(Customer.class, new PropertyEditorSupport() {
        	@Override
			public void setAsText(String id) throws IllegalArgumentException {
			       this.setValue(new Customer(Integer.parseInt(id)));
			}
        });
        
	}
	
	@RequestMapping("/goToRetailPOS")
	public ModelAndView goToRetailPOS(ModelMap model) {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		return new ModelAndView("transaction/retailpos/retailPOS");
	}

	@RequestMapping("/newTransaction")
	public ModelAndView newTransaction( ModelMap model) {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		//create the sales header
		SalesHeader entity = new SalesHeader();
		entity.setTransNo(generateTransNo());
		entity.setTransDate(new java.sql.Date(System.currentTimeMillis()));
		entity.setCustomer("Guest");
		entity.setCashierName(SIMSUtil.getUserNameFromSession(model));	
		entity.setCreatedBy(SIMSUtil.getUserIdFromSession(model));
		salesHeaderBo.save(entity);

		SalesHeader headerEntity = salesHeaderBo.getEntityByTransNo(entity.getTransNo());		
		
		List<SalesDetails> salesDetails = new ArrayList<>();
		model.addAttribute("salesDetails", salesDetails);
		model.addAttribute("salesDetailsSize", salesDetails.size());
		model.addAttribute("salesHeaderId", headerEntity.getId());
		model.addAttribute("totalAmount", "0.00");
		
		return new ModelAndView("transaction/retailpos/ajaxSalesDetails");
	}

	@RequestMapping("/cancelTransaction")
	public ModelAndView cancelTransaction(@RequestParam("salesHeaderId") String salesHeaderId, ModelMap model) {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		//set sales header to active = false
		SalesHeader header = salesHeaderBo.findById(Integer.parseInt(salesHeaderId));
		header.setActive(false);
		header.setModifiedBy(SIMSUtil.getUserIdFromSession(model));
		salesHeaderBo.update(header);
	
		//Need to revert back all the qty of sales details in item inventory
		List<SalesDetails> salesDetailsList = salesDetailsBo.getListBySalesHeader(header);
		for (SalesDetails salesDetailsItem: salesDetailsList) {
		
			ItemInventory itemInv = salesDetailsItem.getItemInventory();
			int inputQty = salesDetailsItem.getQty();
			
			//add item inventory details for this delete sales transaction
			ItemInventoryDetails itemInvDetails = new ItemInventoryDetails();
			itemInvDetails.setItemInventory(itemInv);
			itemInvDetails.setPhysicalQty(itemInv.getStockOnHand());
			itemInvDetails.setInQty(inputQty);
			itemInvDetails.setUpdatedQty(itemInv.getStockOnHand() + inputQty);
			itemInvDetails.setModule(new ListValue(703));//Retail POS
			itemInvDetails.setTransRefNo(header.getTransNo());
			itemInvDetails.setCreatedBy(SIMSUtil.getUserIdFromSession(model));
			itemInventoryDetailsBo.save(itemInvDetails);
			//then update Item Inventory stock on hand
			itemInv.setStockOnHand(itemInv.getStockOnHand() + inputQty);
			itemInv.setModifiedBy(SIMSUtil.getUserIdFromSession(model));
			itemInventoryBo.update(itemInv);	
		}
		
		//reset
		List<SalesDetails> salesDetails = new ArrayList<>();
		model.addAttribute("salesDetails", salesDetails);
		model.addAttribute("salesDetailsSize", salesDetails.size());
		model.addAttribute("salesHeaderId", "");
		model.addAttribute("totalAmount", "0.00");
		
		return new ModelAndView("transaction/retailpos/ajaxSalesDetails");
	}
	
	@RequestMapping("/saveSalesDetail")
	public ModelAndView saveSalesDetail(@RequestParam("itemCode") String itemCode,@RequestParam("salesHeaderId") String salesHeaderId,
			@RequestParam("qty") String qty, ModelMap model) {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		SalesHeader header = salesHeaderBo.findById(Integer.parseInt(salesHeaderId));
	
		//retrieve the item details
		Item item = itemBo.findByItemCode(itemCode);
		
		//retrieve the item inventory by itemcode and get the first record
		List<ItemInventory> itemInvList = itemInventoryBo.findByItem(item);
		
		ItemInventory itemInv = itemInvList.size() > 0 ? itemInvList.get(0) : null;
		
		if (itemInv != null) {
			//create the sales details
			SalesDetails details = new SalesDetails();
			details.setSalesHeader(header);		
			details.setItemInventory(itemInv);
			details.setItem(item.getDescription());
			details.setQty(qty!=null && qty.trim().length() > 0 ? Integer.parseInt(qty.trim()) : 1);
			details.setPrice(itemInv.getRetailPrice()); //Item Inventory Retail Price
			details.setDiscount(item.getDiscountAmount()!=null ? item.getDiscountAmount() : new BigDecimal("0.00"));
			double totalSales = details.getQty() * details.getPrice().doubleValue();
			double totalDiscount = item.getDiscountAmount()!=null && item.getDiscountAmount().doubleValue() > 0.00D ? (details.getQty() * item.getDiscountAmount().doubleValue()) : 0.00D;
			double totalAmountDue = totalSales - totalDiscount;
			details.setTotalSales(new BigDecimal(totalSales));
			details.setTotalDiscount(new BigDecimal(totalDiscount));
			details.setAmountDue(new BigDecimal(totalAmountDue));
			if (salesDetailsBo.save(details)) {
				//add item inventory details for this sales transaction
				ItemInventoryDetails itemInvDetails = new ItemInventoryDetails();
				itemInvDetails.setItemInventory(itemInv);
				itemInvDetails.setPhysicalQty(itemInv.getStockOnHand());
				itemInvDetails.setOutQty(details.getQty());
				itemInvDetails.setUpdatedQty(itemInv.getStockOnHand() - details.getQty());
				itemInvDetails.setModule(new ListValue(703));//Retail POS
				itemInvDetails.setTransRefNo(header.getTransNo());
				itemInvDetails.setCreatedBy(SIMSUtil.getUserIdFromSession(model));
				itemInventoryDetailsBo.save(itemInvDetails);
				//then update Item Inventory stock on hand
				itemInv.setStockOnHand(itemInv.getStockOnHand() - details.getQty());
				itemInv.setModifiedBy(SIMSUtil.getUserIdFromSession(model));
				itemInventoryBo.update(itemInv);
			}
		}
				
		List<SalesDetails> salesDetails = salesDetailsBo.getListBySalesHeader(header);
		
		double totalSales = 0.0D;
		double totalDiscount = 0.0D;
		double totalAmountDue = 0.0D;
		
		for (SalesDetails salesItem: salesDetails) {
			totalSales = totalSales + salesItem.getTotalSales().doubleValue();
			totalDiscount = totalDiscount + salesItem.getTotalDiscount().doubleValue();
			totalAmountDue = totalAmountDue + salesItem.getAmountDue().doubleValue();
		}
		
		model.addAttribute("salesDetails", salesDetails);
		model.addAttribute("salesDetailsSize", salesDetails.size());
		model.addAttribute("salesHeaderId", salesHeaderId);
		model.addAttribute("totalSales", totalSales);
		model.addAttribute("totalDiscount", totalDiscount);
		model.addAttribute("totalAmountDue", totalAmountDue);
		
		return new ModelAndView("transaction/retailpos/ajaxSalesDetails");
	}
	
	
	@RequestMapping("/searchItemByDescription")
	public ModelAndView searchItemByDescription(@RequestParam("itemDescription") String itemDescription, ModelMap model) {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		Map<Object, Object> mapCriteria = new HashMap<>();
		mapCriteria.put("search_criteria", itemDescription);
		mapCriteria.put("record_start", 0);
		mapCriteria.put("max_result", 20);
		
		Map<Object, Object> returnMap = itemBo.findByDescription(mapCriteria);
		
		@SuppressWarnings("unchecked")
		List<Item> resultList = (ArrayList<Item>) returnMap.get("resultList");
		
		model.addAttribute("resultList", resultList);
		
		return new ModelAndView("transaction/retailpos/resultList");
	}

	@RequestMapping("/deleteSalesDetails")
	public ModelAndView deleteSalesDetails(@RequestParam("salesDetailsId") String salesDetailsId,
			@RequestParam("salesHeaderId") String salesHeaderId, ModelMap model) {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		SalesHeader header = salesHeaderBo.findById(Integer.parseInt(salesHeaderId));
				
		//delete the item details
		SalesDetails entity = salesDetailsBo.findById(Integer.parseInt(salesDetailsId));
		
		int inputQty = entity.getQty();
		ItemInventory itemInv = entity.getItemInventory();
		
		if (salesDetailsBo.delete(entity)) {
			//add item inventory details for this delete sales transaction
			ItemInventoryDetails itemInvDetails = new ItemInventoryDetails();
			itemInvDetails.setItemInventory(itemInv);
			itemInvDetails.setPhysicalQty(itemInv.getStockOnHand());
			itemInvDetails.setInQty(inputQty);
			itemInvDetails.setUpdatedQty(itemInv.getStockOnHand() + inputQty);
			itemInvDetails.setModule(new ListValue(703));//Retail POS
			itemInvDetails.setTransRefNo(header.getTransNo());
			itemInvDetails.setCreatedBy(SIMSUtil.getUserIdFromSession(model));
			itemInventoryDetailsBo.save(itemInvDetails);
			//then update Item Inventory stock on hand
			itemInv.setStockOnHand(itemInv.getStockOnHand() + inputQty);
			itemInv.setModifiedBy(SIMSUtil.getUserIdFromSession(model));
			itemInventoryBo.update(itemInv);
		}
			
			
		List<SalesDetails> salesDetails = salesDetailsBo.getListBySalesHeader(header);

		double totalSales = 0.0D;
		double totalDiscount = 0.0D;
		double totalAmountDue = 0.0D;
		
		for (SalesDetails salesItem: salesDetails) {
			totalSales = totalSales + salesItem.getTotalSales().doubleValue();
			totalDiscount = totalDiscount + salesItem.getTotalDiscount().doubleValue();
			totalAmountDue = totalAmountDue + salesItem.getAmountDue().doubleValue();
		}
		
		model.addAttribute("salesDetails", salesDetails);
		model.addAttribute("salesDetailsSize", salesDetails.size());
		model.addAttribute("salesHeaderId", salesHeaderId);
		model.addAttribute("totalSales", totalSales);
		model.addAttribute("totalDiscount", totalDiscount);
		model.addAttribute("totalAmountDue", totalAmountDue);
		
		return new ModelAndView("transaction/retailpos/ajaxSalesDetails");
	}

	@RequestMapping("/payNow")
	public ModelAndView payNow(@RequestParam("salesHeaderId") String salesHeaderId,@RequestParam("totalSales") String totalSales,
			@RequestParam("totalDiscount") String totalDiscount, @RequestParam("totalAmountDue") String totalAmountDue,
			@RequestParam("tenderedAmount") String tenderedAmount, ModelMap model) throws ParseException {
		
		if (!SIMSUtil.isUserSessionValid(model)) {
			logger.info(SIMSConstant.USER_INVALID_SESSION);
			return new ModelAndView("security/login", "userAccount", new UserAccount());	
		}
		
		//retrieve the sales header
		SalesHeader header = salesHeaderBo.findById(Integer.parseInt(salesHeaderId));
				
		double totalSalesNum = NumberFormat.getInstance().parse(totalSales).doubleValue();
		double totalDiscountNum = NumberFormat.getInstance().parse(totalDiscount).doubleValue();
		double totalAmountDueNum = NumberFormat.getInstance().parse(totalAmountDue).doubleValue();
		double tenderedAmountNum = NumberFormat.getInstance().parse(tenderedAmount).doubleValue();
		
		//compute
		double changeAmount = tenderedAmountNum - totalAmountDueNum;
		
		header.setTotalSales(new BigDecimal(totalSalesNum));
		header.setTotalDiscount(new BigDecimal(totalDiscountNum));
		header.setTotalAmtDue(new BigDecimal(totalAmountDueNum));
		header.setTenderedAmt(new BigDecimal(tenderedAmountNum));
		header.setChangeAmt(new BigDecimal(changeAmount));
		header.setPaymentMode("Cash");
		header.setCashierName(SIMSUtil.getUserNameFromSession(model));	
		header.setModifiedBy(SIMSUtil.getUserIdFromSession(model));
		salesHeaderBo.update(header);

		//get the updated entity
		SalesHeader headerEntity = salesHeaderBo.findById(Integer.parseInt(salesHeaderId));
		
		List<SalesDetails> salesDetails = salesDetailsBo.getListBySalesHeader(header);
		model.addAttribute("salesDetails", salesDetails);
		model.addAttribute("salesDetailsSize", salesDetails.size());
		model.addAttribute("salesHeaderId", headerEntity.getId());
		model.addAttribute("totalSales", totalSalesNum);
		model.addAttribute("totalDiscount", totalDiscountNum);
		model.addAttribute("totalAmountDue", totalAmountDueNum);
		model.addAttribute("tenderedAmount", tenderedAmountNum);
		model.addAttribute("changeAmount", changeAmount);
		
		return new ModelAndView("transaction/retailpos/ajaxSalesDetails");
	}
	
	private String generateTransNo() {
		StringBuilder sb = new StringBuilder(15);
		try {
			Calendar now = Calendar.getInstance();
			int currentMonth = now.get(Calendar.MONTH) + 1;//0-11
			int currentDayOfMonth = now.get(Calendar.DAY_OF_MONTH);
			sb.append("T");
			sb.append(now.get(Calendar.YEAR));
			sb.append(String.format("%02d", currentMonth));
			sb.append(String.format("%02d", currentDayOfMonth));
			sb.append(String.format("%08d", salesHeaderBo.getTotalCount()+1));//get the total record count
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return sb.toString();
	}
	
		
}
