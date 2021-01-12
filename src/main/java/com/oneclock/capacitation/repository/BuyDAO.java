package com.oneclock.capacitation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oneclock.capacitation.entities.Buy;
import com.oneclock.capacitation.entities.BuyID;

public interface BuyDAO extends JpaRepository<Buy, BuyID> {

}
