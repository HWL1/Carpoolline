package com.Carpoolline.Order.Carpoolline_from.Domain_Mapper;

import java.io.Serializable;
import java.util.Date;

public class Order_carpoolline_pojo implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 337474986145298449L;
	Integer orderId=0;
	String departure="";
	String destination="";
    Integer driverId=0;
    Date starTime;
    Date finalTime;
    double price=0;
    String state="";
    String note="";
    String smalldep="";
    String smalldes="";
    String waitingTimeType="";
    public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
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
	public Integer getDriverId() {
		return driverId;
	}
	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}
	public Date getStarTime() {
		return starTime;
	}
	public void setStarTime(Date starTime) {
		this.starTime = starTime;
	}
	public Date getFinalTime() {
		return finalTime;
	}
	public void setFinalTime(Date finalTime) {
		this.finalTime = finalTime;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
    
}
