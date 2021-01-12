package com.oneclock.capacitation.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name= "product_id", nullable = false)
	private int productID;
	
	@Column(name="product_name", nullable=false)
	private String productName;
	
	@Column(name="price", nullable=false)
	private BigDecimal price;
	
	@Column(name= "stock", nullable=false)
	private int stock;

	public Product(int productID, String productName, BigDecimal price, int stock) {
		this.productID = productID;
		this.productName = productName;
		this.price = price;
		this.stock = stock;
	}

	public int getProductID() {
		return productID;
	}

	public String getProductName() {
		return productName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public int getStock() {
		return stock;
	}
	
	
	 
	
	
}
