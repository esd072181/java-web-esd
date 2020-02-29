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
@Table(name = "rodetails", schema = "sims")
public class RODetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private ROHeader roHeader;
	private Item item;
	private Integer qty;
	private BigDecimal price;
	private BigDecimal amount;
	
	public RODetails(){}
	
	public RODetails(int id){
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roDetailsId_generator")
	@SequenceGenerator(name="roDetailsId_generator", sequenceName = "sims.rodetailsseq", allocationSize=1)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "roheaderid", nullable = false)
	public ROHeader getRoHeader() {
		return roHeader;
	}

	public void setRoHeader(ROHeader roHeader) {
		this.roHeader = roHeader;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "itemid", nullable = false)
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Column(name = "qty")
	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	@Column(name = "price",precision=9)
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Column(name = "amount",precision=9)
	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "RODetails [id=" + id + ", roHeader=" + (roHeader!=null ? roHeader.getId() : "N/A") + ", item="
				+ item + ", qty=" + qty + ", price=" + price + ", amount="
				+ amount + "]";
	}

	
	

}
