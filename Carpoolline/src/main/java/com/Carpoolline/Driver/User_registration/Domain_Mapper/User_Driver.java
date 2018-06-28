package com.Carpoolline.Driver.User_registration.Domain_Mapper;

import java.io.Serializable;

public class User_Driver implements Serializable{
	
     /**
	 * 
	 */
	private static final long serialVersionUID = 6127291435038180852L;
	int driverId;
     String driverName;
     String driverPassword;
     String driverTel;
     String carType;
     String carCard;
     String driverType;
     int driverStar;
     public String getCarCard() {
		return carCard;
	}
	public void setCarCard(String carCard) {
		this.carCard = carCard;
	}
	
	public int getDiverId() {
		return driverId;
	}
	public void setDiverId(int driverId) {
		this.driverId = driverId;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getDriverPassword() {
		return driverPassword;
	}
	public void setDriverPassword(String driverPassword) {
		this.driverPassword = driverPassword;
	}
	public String getDriverTel() {
		return driverTel;
	}
	public void setDriverTel(String driverTel) {
		this.driverTel = driverTel;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public String getDriverType() {
		return driverType;
	}
	public void setDriverType(String driverType) {
		this.driverType = driverType;
	}
	public int getDriverStar() {
		return driverStar;
	}
	public void setDriverStar(int driverStar) {
		this.driverStar = driverStar;
	}
	
	
     
	

}
