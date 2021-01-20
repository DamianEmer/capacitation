package com.oneclock.capacitation.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id",  nullable = false)
	private int userID;
	
	@Column(name="user_name", length = 100, nullable = false)
	private String userName;
	
	@Column(name="user_last_name", length = 100, nullable = false )
	private String userLastName;

	public User() {}
	public User(int userID, String userName, String userLastName) {
		this.userID = userID;
		this.userName = userName;
		this.userLastName = userLastName;
	}

	public int getUserID() {
		return userID;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserLastName() {
		return userLastName;
	}
	
	
	
	
	
}
