package com.oneclock.capacitation.dto;

import java.math.BigDecimal;
import java.util.Date;

public class TicketDTO {

	private String userName;
	private String lastName;
	private String productName;
	private BigDecimal price;
	private Date creationDate;
	
	public TicketDTO(String userName, String lastName, String productName, BigDecimal price, Date creationDate) {
		this.userName = userName;
		this.lastName = lastName;
		this.productName = productName;
		this.price = price;
		this.creationDate = creationDate;
	}
	
	public String getUserName() {
		return userName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getProductName() {
		return productName;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	
	
	
	
	
}
