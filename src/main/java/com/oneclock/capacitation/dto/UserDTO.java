package com.oneclock.capacitation.dto;

public class UserDTO {

	
	private int userID;
	
	private String userName;
	
	private String userLastName;

	public UserDTO(int userID, String userName, String userLastName) {
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
