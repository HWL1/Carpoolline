package com.Carpoolline.Passenger.User_payment.Domain_Mapper;

import java.io.Serializable;

public class Payment_waitingcartousers_pojo implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -955771544271127376L;
	int  waitingcartousersId;
	int waitingId;
	int userId;
	//*****
	String state;
	//************
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
