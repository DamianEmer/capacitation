package com.oneclock.capacitation.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BuyID implements Serializable{
	
	private static final long serialVersionUID =1L;
	
	@Column(name="user_id_fk", nullable=false)
	public int userID;
	
	@Column(name="product_id_fk", nullable=false)
	public int productID;

	public BuyID() {};
	public BuyID(int userID, int productID) {
		this.userID = userID;
		this.productID = productID;
	}
	

}
