package com.Carpoolline.Passenger.User_payment.Service;

import java.util.List;

import com.Carpoolline.Order.Carpoolline_from.Domain_Mapper.Order_carpoolline_pojo;
import com.Carpoolline.Order.Carpoolline_from.Domain_Mapper.Ordertousers_pojo;

public interface Payment_service_face {
	
	
	/**
	 * �û�ȡ��/����
	 * @param waitingId
	 * @param userId
	 * @return
	 */
	public String user_refund(int waitingId,int userId,String fu);
	
	
	
/**
 * �����û�ȡ������
 * @param waitingId
 * @return
 */
	public String user_refund_all(int waitingId);
	
	
	/**
	 * �������ɶ���carpoolline_pojo 
	 * @param waitingId
	 * @return
	 */
	public Order_carpoolline_pojo Synthesis_order(int waitingId );
	
	/**
	 * �������ɶ���Ordertousers_pojo
	 * @param waitingId
	 * @return
	 */
	public List<Integer> Order_ordertousers(int waitingId);

}
