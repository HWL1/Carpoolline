package com.Carpoolline.Passenger.User_Query.Domain_Mapper;

import java.io.Serializable;

public class User_query_waitingcartousers_pojo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2979421116172657604L;
	int  waitingcartousersId;
	int waitingId;
	int userId;
	//*****
	String state;
	//************
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public int getWaitingcartousersId() {
		return waitingcartousersId;
	}
	public void setWaitingcartousersId(int waitingcartousersId) {
		this.waitingcartousersId = waitingcartousersId;
	}
	public int getWaitingId() {
		return waitingId;
	}
	public void setWaitingId(int waitingId) {
		this.waitingId = waitingId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

}
