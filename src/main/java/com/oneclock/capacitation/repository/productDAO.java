package com.oneclock.capacitation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oneclock.capacitation.entities.Product;

public interface productDAO extends JpaRepository<Product, Integer> {

}
