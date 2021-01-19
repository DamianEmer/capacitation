package com.oneclock.capacitation.entities;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="buy")
public class Buy {
	
	@EmbeddedId 
	private BuyID buyID;
	
	@Column(name="user_id_fk", insertable=false, updatable= false)
	private int userID;
	
	@Column(name="product_id_fk", insertable=false, updatable=false)
	private int productID;
	
	@Column(name="quantity", nullable=false)
	private int quantity;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="creation_date", nullable=false)
	private Date creationDate;

	public Buy() {};
	public Buy(BuyID buyID, int quantity) {
		this.buyID = buyID;
		this.quantity = quantity;
		this.creationDate = new Date();
	}
	public BuyID getBuyID() {
		return buyID;
	}
	public int getUserID() {
		return userID;
	}
	public int getProductID() {
		return productID;
	}
	public int getQuantity() {
		return quantity;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	
}
