package com.Carpoolline.Order.Carpoolline_from.Domain_Mapper;

import java.io.Serializable;

public class Ordertousers_pojo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8535293330038779258L;

	Integer ordertousersId=0;
	Integer orderId=0;
	Integer userId=0;
	public Integer getOrdertousersId() {
		return ordertousersId;
	}
	public void setOrdertousersId(Integer ordertousersId) {
		this.ordertousersId = ordertousersId;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
