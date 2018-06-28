package com.Carpoolline.Passenger.User_registration.Domain_Mapper;

import java.io.Serializable;

public class User_Passenger implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3968464108057513346L;
	int UserId;
	String UserName;
	String UserPassword;
	String UserTel;
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getUserPassword() {
		return UserPassword;
	}
	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}
	public String getUserTel() {
		return UserTel;
	}
	public void setUserTel(String userTel) {
		UserTel = userTel;
	}

}
