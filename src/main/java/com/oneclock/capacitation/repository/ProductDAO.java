package com.oneclock.capacitation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.oneclock.capacitation.entities.Product;

public interface ProductDAO extends JpaRepository<Product, Integer> {

	@Query( value="SELECT * FROM product WHERE product_id = 1;", nativeQuery = true)
	Product findByProductByID(@Param("product_id") int productID);
}
