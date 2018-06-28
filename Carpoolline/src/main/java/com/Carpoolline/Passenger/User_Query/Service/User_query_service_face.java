package com.Carpoolline.Passenger.User_Query.Service;

import java.sql.Date;
import java.util.List;

import com.Carpoolline.Passenger.User_Query.Domain_Mapper.User_query_waitingcar_pojo;

public interface User_query_service_face {
	/**
	 * ��ʱ����ѯ ��ƴ����
	 * @param startTime
	 * @param departure
	 * @param destination
	 * @param waitingTimeType
	 * @param stateClock
	 * @return
	 */
	public List<User_query_waitingcar_pojo> Query_waiting_form(Date startTime,String departure,String destination,String waitingTimeType,int stateClock);
	
	/**
	 * ��ʱ��β�ѯ ��ƴ���б�
	 * @param startTime
	 * @param departure
	 * @param destination
	 * @param waitingTimeType
	 * @return
	 */
	
	public List<User_query_waitingcar_pojo> Query_waiting_form(Date startTime,String departure,String destination,String waitingTimeType);
	
	
	/**
	 * ��userId��ѯ ��ƴ���б�
	 * @param userId
	 * @return
	 */
	public List<User_query_waitingcar_pojo> Query_waiting_form(int userId);
	
	
	
	/**
	 * ����û�
	 * @param waitingId
	 * @param userId
	 * @return
	 */
    public String Query_waitingcar_add_user(int waitingId,int userId,int personNumber);
    
    /**
     * �����û�
     * @param waitingId
     * @param userId
     * @return
     */
    public  String Query_waitingcar_remove_user(int waitingId,int userId ,int personNumber);
    
    
    /**
     * �������� waitingcar
     * @param waitingId
     * @return
     */
    public int Query_waitingcar_personNumber(int waitingId);
    
}
