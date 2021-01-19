package com.oneclock.capacitation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.oneclock.capacitation.entities.User;

public interface UserDAO extends JpaRepository<User, Integer> {

	@Query(value="SELECT * FROM user WHERE user_id = :user_id", nativeQuery = true)
	User findUserById(@Param("user_id") int userID);
}
