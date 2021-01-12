package com.oneclock.capacitation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oneclock.capacitation.entities.User;

public interface UserDAO extends JpaRepository<User, Integer> {

}
