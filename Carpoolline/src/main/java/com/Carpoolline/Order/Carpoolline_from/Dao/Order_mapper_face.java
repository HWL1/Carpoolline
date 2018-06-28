package com.Carpoolline.Order.Carpoolline_from.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.Carpoolline.Order.Carpoolline_from.Domain_Mapper.Order_carpoolline_pojo;
import com.Carpoolline.Order.Carpoolline_from.Domain_Mapper.Ordertousers_pojo;

public interface Order_mapper_face {
	
	/**
	 * ´´½¨ordertousers
	 * @param Ordertousers
	 */
     public void create_ordertousers(Ordertousers_pojo Ordertousers);
     
     
     
     public void create_order_carpoolline(Order_carpoolline_pojo order);
     
     
     
     public Order_carpoolline_pojo select_order_all_orderId(@Param("orderId") Integer orderId);
     
     
     public List<Integer> select_ordertousers_orderId_userId(@Param("userId") Integer userId);
     
     
     public int select_order_orderId_waitingId(@Param("waitingId") int waitingId);

}
