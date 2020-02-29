package com.sims.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author dward
 *
 */
@NamedNativeQueries({
	@NamedNativeQuery(
	name = "callRetrieveItemFunction",
	query = "select * from sims.retrieve_item(:id)",
	resultClass = Item.class
	)
})
@Entity
@Table(name = "item", schema = "sims")
public class Item implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;	
	private String itemcode;
	private String description;
	private ListValue type;
	private Brand brand;
	private Category category;
	private SubCategory subCategory;
	private ListValue uom;
	private BigDecimal retailOrigPrice;
	private BigDecimal retailMarkupPercent;
	private BigDecimal retailMarkupPrice;
	private BigDecimal retailSellingPrice;
	private BigDecimal wholesaleOrigPrice;
	private BigDecimal wholesaleMarkupPercent;
	private BigDecimal wholesaleMarkupPrice;
	private BigDecimal wholesaleSellingPrice;
	private BigDecimal discountPercent;
	private BigDecimal discountAmount;
	private Date manufacturedDate;
	private Date expiryDate;
	private Integer criticalLevel;
	private Integer optimumLevel;
	private Integer maximumLevel;
	private Integer createdBy;
	private Timestamp createdOn;
	private Integer modifiedBy;
	private Timestamp modifiedOn;
	private Integer version;
	private Boolean active;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemId_generator")
	@SequenceGenerator(name="itemId_generator", sequenceName = "sims.itemseq", allocationSize=1)
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "itemcode", length = 20)
	public String getItemCode() {
		return itemcode;
	}
	public void setItemCode(String itemcode) {
		this.itemcode = itemcode;
	}
	
	@Column(name = "description", length = 50)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "typeid", nullable = false)
	public ListValue getType() {
		return type;
	}
	public void setType(ListValue type) {
		this.type = type;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "brandid", nullable = false)
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoryid", nullable = false)
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "subcategoryid", nullable = false)
	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "uomid", nullable = false)
	public ListValue getUom() {
		return uom;
	}

	public void setUom(ListValue uom) {
		this.uom = uom;
	}

	@Column(name = "retailorigprice", precision = 9)
	public BigDecimal getRetailOrigPrice() {
		return retailOrigPrice;
	}

	public void setRetailOrigPrice(BigDecimal retailOrigPrice) {
		this.retailOrigPrice = retailOrigPrice;
	}

	@Column(name = "retailmarkuppercent",  precision = 9)
	public BigDecimal getRetailMarkupPercent() {
		return retailMarkupPercent;
	}

	public void setRetailMarkupPercent(BigDecimal retailMarkupPercent) {
		this.retailMarkupPercent = retailMarkupPercent;
	}

	@Column(name = "retailmarkupprice", precision = 9)
	public BigDecimal getRetailMarkupPrice() {
		return retailMarkupPrice;
	}

	public void setRetailMarkupPrice(BigDecimal retailMarkupPrice) {
		this.retailMarkupPrice = retailMarkupPrice;
	}

	@Column(name = "retailsellingprice", precision = 9)
	public BigDecimal getRetailSellingPrice() {
		return retailSellingPrice;
	}

	public void setRetailSellingPrice(BigDecimal retailSellingPrice) {
		this.retailSellingPrice = retailSellingPrice;
	}

	@Column(name = "wholesaleorigprice", precision = 9)
	public BigDecimal getWholesaleOrigPrice() {
		return wholesaleOrigPrice;
	}

	public void setWholesaleOrigPrice(BigDecimal wholesaleOrigPrice) {
		this.wholesaleOrigPrice = wholesaleOrigPrice;
	}

	@Column(name = "wholesalemarkuppercent", precision = 9)
	public BigDecimal getWholesaleMarkupPercent() {
		return wholesaleMarkupPercent;
	}

	public void setWholesaleMarkupPercent(BigDecimal wholesaleMarkupPercent) {
		this.wholesaleMarkupPercent = wholesaleMarkupPercent;
	}

	@Column(name = "wholesalemarkupprice", precision = 9)
	public BigDecimal getWholesaleMarkupPrice() {
		return wholesaleMarkupPrice;
	}

	public void setWholesaleMarkupPrice(BigDecimal wholesaleMarkupPrice) {
		this.wholesaleMarkupPrice = wholesaleMarkupPrice;
	}

	@Column(name = "wholesalesellingprice", precision = 9)
	public BigDecimal getWholesaleSellingPrice() {
		return wholesaleSellingPrice;
	}

	public void setWholesaleSellingPrice(BigDecimal wholesaleSellingPrice) {
		this.wholesaleSellingPrice = wholesaleSellingPrice;
	}
	
	@Column(name = "discountPercent", precision = 9)
	public BigDecimal getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(BigDecimal discountPercent) {
		this.discountPercent = discountPercent;
	}

	@Column(name = "discountAmount", precision = 9)
	public BigDecimal getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}
	
	@Column(name = "manufactureddate")
	public Date getManufacturedDate() {
		return manufacturedDate;
	}

	public void setManufacturedDate(Date manufacturedDate) {
		this.manufacturedDate = manufacturedDate;
	}
	
	@Column(name = "expirydate")
	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Column(name = "criticallevel")
	public Integer getCriticalLevel() {
		return criticalLevel;
	}

	public void setCriticalLevel(Integer criticalLevel) {
		this.criticalLevel = criticalLevel;
	}

	@Column(name = "optimumlevel")
	public Integer getOptimumLevel() {
		return optimumLevel;
	}

	public void setOptimumLevel(Integer optimumLevel) {
		this.optimumLevel = optimumLevel;
	}

	@Column(name = "maximumlevel")
	public Integer getMaximumLevel() {
		return maximumLevel;
	}

	public void setMaximumLevel(Integer maximumLevel) {
		this.maximumLevel = maximumLevel;
	}
	
	@Column(name = "createdby")
	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "createdon")
	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	@Column(name = "modifiedby")
	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@Column(name = "modifiedon")
	public Timestamp getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Timestamp modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	@Column(name = "version")
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Column(name = "active")
	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", itemcode=" + itemcode + ", description="
				+ description + ", type=" + (type!=null ? type.getId() : "null") + ", brand=" + (brand!=null ? brand.getId() : "null")
				+ ", category=" + (category!=null ? category.getId() : "null") + ", subCategory=" + (subCategory!=null ? subCategory.getId() : "null")
				+ ", uom=" + (uom!=null ? uom.getId() : "null") + ", retailOrigPrice=" + retailOrigPrice
				+ ", retailMarkupPercent=" + retailMarkupPercent
				+ ", retailMarkupPrice=" + retailMarkupPrice
				+ ", retailSellingPrice=" + retailSellingPrice
				+ ", wholesaleOrigPrice=" + wholesaleOrigPrice
				+ ", wholesaleMarkupPercent=" + wholesaleMarkupPercent
				+ ", wholesaleMarkupPrice=" + wholesaleMarkupPrice
				+ ", wholesaleSellingPrice=" + wholesaleSellingPrice
				+ ", manufacturedDate=" + manufacturedDate + ", expiryDate="
				+ expiryDate + ", criticalLevel=" + criticalLevel
				+ ", optimumLevel=" + optimumLevel + ", maximumLevel="
				+ maximumLevel + ", createdBy=" + createdBy + ", createdOn="
				+ createdOn + ", modifiedBy=" + modifiedBy + ", modifiedOn="
				+ modifiedOn + ", version=" + version + ", active=" + active
				+ "]";
	}

	
	
	
}
