package com.oneclock.capacitation.dto;

import java.math.BigDecimal;

public class ProductDTO {

	private int productID;
	private String productName;
	private int stock;
	private BigDecimal price;
	
	public ProductDTO(int productID, String productName, int stock, BigDecimal price) {
		this.productID = productID;
		this.productName = productName;
		this.stock = stock;
		this.price = price;
	}

	public int getProductID() {
		return productID;
	}

	public String getProductName() {
		return productName;
	}

	public int getStock() {
		return stock;
	}

	public BigDecimal getPrice() {
		return price;
	}
	
	
	
	
}
