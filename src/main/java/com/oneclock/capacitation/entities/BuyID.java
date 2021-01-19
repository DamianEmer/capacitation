package com.oneclock.capacitation.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BuyID implements Serializable{
	
	private static final long serialVersionUID =1L;
	
	@Column(name="user_id_fk", nullable=false)
	public User userID;
	
	@Column(name="product_id_fk", nullable=false)
	public Product productID;

	public BuyID() {};
	public BuyID(User userID, Product productID) {
		this.userID = userID;
		this.productID = productID;
	}
	

}
