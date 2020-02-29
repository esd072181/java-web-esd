package com.sims.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "poheader", schema = "sims")
public class POHeader implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String poNo;
	private Date transDate;
	private Supplier supplier;
	private BigDecimal totalAmount;
	private ListValue status;
	private String requestedBy;
	private Integer createdBy;
	private Timestamp createdOn;
	private Integer modifiedBy;
	private Timestamp modifiedOn;
	private Integer version;
	private Boolean active;
	
	private List<PODetails> poDetailsList = new ArrayList<>();
	
	private Integer itemId;
	
	public POHeader(){}
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "poHeader")
	public List<PODetails> getPoDetailsList() {
		return poDetailsList;
	}

	public void setPoDetailsList(List<PODetails> poDetailsList) {
		this.poDetailsList = poDetailsList;
	}
	
	public POHeader(int id){
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "poHeaderId_generator")
	@SequenceGenerator(name="poHeaderId_generator", sequenceName = "sims.poheaderseq", allocationSize=1)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "pono", length=20)
	public String getPoNo() {
		return poNo;
	}

	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	@Column(name = "transdate")
	public Date getTransDate() {
		return transDate;
	}

	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "supplierid", nullable = true)
	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	@Column(name = "totalamount",precision=9)
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "statusid", nullable = true)
	public ListValue getStatus() {
		return status;
	}

	public void setStatus(ListValue status) {
		this.status = status;
	}	

	@Column(name = "requestedby", length=30)
	public String getRequestedBy() {
		return requestedBy;
	}

	public void setRequestedBy(String requestedBy) {
		this.requestedBy = requestedBy;
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
	public Boolean getActive() {
		return active;
	}


	public void setActive(Boolean active) {
		this.active = active;
	}

	@javax.persistence.Transient
	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	@Override
	public String toString() {
		return "POHeader [id=" + id + ", poNo=" + poNo + ", transDate="
				+ transDate + ", supplier=" + supplier + ", totalAmount="
				+ totalAmount + ", status=" + (status!=null ? status.getId() : "N/A") + ", requestedBy="
				+ requestedBy + ", createdBy=" + createdBy + ", createdOn="
				+ createdOn + ", modifiedBy=" + modifiedBy + ", modifiedOn="
				+ modifiedOn + ", version=" + version + ", active=" + active
				+ "]";
	}


}
