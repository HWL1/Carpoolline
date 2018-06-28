package com.Carpoolline.Passenger.User_Query.Domain_Mapper;

import java.io.Serializable;
import java.sql.Date;

public class User_query_waitingcar_pojo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2475994994029036366L;
	int waitingId;
	String departure;
	String destination;
	Date   startTime;
	Date endTime;
	int personNumber;

	String state;
	int driverId;
	String smalldep;
	String smalldes;
	String waitingTimeType;
	double price;
	int    startClock;

	int   endClock;
	
	//**
	int version=0;
	//**

	public int getWaitingId() {
		return waitingId;
	}

	public void setWaitingId(int waitingId) {
		this.waitingId = waitingId;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public int getPersonNumber() {
		return personNumber;
	}

	public void setPersonNumber(int personNumber) {
		this.personNumber = personNumber;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public String getSmalldep() {
		return smalldep;
	}

	public void setSmalldep(String smalldep) {
		this.smalldep = smalldep;
	}

	public String getSmalldes() {
		return smalldes;
	}

	public void setSmalldes(String smalldes) {
		this.smalldes = smalldes;
	}

	public String getWaitingTimeType() {
		return waitingTimeType;
	}

	public void setWaitingTimeType(String waitingTimeType) {
		this.waitingTimeType = waitingTimeType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStartClock() {
		return startClock;
	}

	public void setStartClock(int startClock) {
		this.startClock = startClock;
	}

	public int getEndClock() {
		return endClock;
	}

	public void setEndClock(int endClock) {
		this.endClock = endClock;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	
	
	

}
