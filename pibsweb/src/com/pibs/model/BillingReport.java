package com.pibs.model;

public class BillingReport {
	 
	private String item;
	private String category;
	private String qty;
	private String fee;
	private String amount;
	   
	   
	public BillingReport(){};
	
	public BillingReport(String item, String category, String qty, String fee, String amount){
		this.item = item;
		this.category = category;
		this.qty = qty;
		this.fee = fee;
		this.amount = amount;
	};
	
	
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public String getFee() {
		return fee;
	}
	public void setFee(String fee) {
		this.fee = fee;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}

	
	

}
