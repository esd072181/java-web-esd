package com.sims.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "salesdetails", schema = "sims")
public class SalesDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private SalesHeader salesHeader;
	private ItemInventory itemInventory;
	private String item;
	private Integer qty;
	private BigDecimal price;
	private BigDecimal discount;
	private BigDecimal totalSales;
	private BigDecimal totalDiscount;
	private BigDecimal amountDue;
		
	public SalesDetails(){}
	
	public SalesDetails(int id){
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "salesDetailsId_generator")
	@SequenceGenerator(name="salesDetailsId_generator", sequenceName = "sims.salesdetailsseq", allocationSize=1)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "salesid", nullable = false)
	public SalesHeader getSalesHeader() {
		return salesHeader;
	}
	
	public void setSalesHeader(SalesHeader salesHeader) {
		this.salesHeader = salesHeader;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "iteminventoryid", nullable = false)
	public ItemInventory getItemInventory() {
		return itemInventory;
	}
	
	public void setItemInventory(ItemInventory itemInventory) {
		this.itemInventory = itemInventory;
	}
	
	@Column(name = "item", length=100)
	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	@Column(name = "qty")
	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}
	
	@Column(name = "price", precision = 9)
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	@Column(name = "discount", precision = 9)
	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	@Column(name = "totalsales", precision = 9)
	public BigDecimal getTotalSales() {
		return totalSales;
	}

	public void setTotalSales(BigDecimal totalSales) {
		this.totalSales = totalSales;
	}

	@Column(name = "totaldiscount", precision = 9)
	public BigDecimal getTotalDiscount() {
		return totalDiscount;
	}

	public void setTotalDiscount(BigDecimal totalDiscount) {
		this.totalDiscount = totalDiscount;
	}
	
	@Column(name = "amountdue", precision = 9)
	public BigDecimal getAmountDue() {
		return amountDue;
	}

	public void setAmountDue(BigDecimal amountDue) {
		this.amountDue = amountDue;
	}	

	

}
