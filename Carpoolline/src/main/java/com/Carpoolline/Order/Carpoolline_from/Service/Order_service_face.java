package com.Carpoolline.Order.Carpoolline_from.Service;

import java.util.List;

import com.Carpoolline.Order.Carpoolline_from.Domain_Mapper.Order_carpoolline_pojo;
import com.Carpoolline.Order.Carpoolline_from.Domain_Mapper.Ordertousers_pojo;

public interface Order_service_face {
	
	
	/**
	 * 生成订单表_order_carpoolline
	 * @param Order
	 * @return
	 */
	public Integer Create_order_carpoolline(Order_carpoolline_pojo Order);
	
	/**
	 * 生成订单表Ordertousers
	 * @param Ordertousers
	 * @return
	 */
	public boolean Create_ordertousers(List<Integer> list,Integer orderId);
	
	/**
	 * 查询订单order_carpoolline
	 * @param userId
	 * @return
	 */
	public List<Order_carpoolline_pojo> Select_order_carpoolline(Integer userId);

}
