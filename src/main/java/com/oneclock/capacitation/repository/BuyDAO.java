package com.oneclock.capacitation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.oneclock.capacitation.entities.Buy;
import com.oneclock.capacitation.entities.BuyID;	

public interface BuyDAO extends JpaRepository<Buy, BuyID> {
	
	@Query(value="select * from buy where buy.user_id_fk = :user_id", nativeQuery = true )
	List<Buy> findByBuysID(@Param("user_id")int userID);

	
}
