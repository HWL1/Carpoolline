package com.Carpoolline.Passenger.User_Query.Service;

import java.sql.Date;
import java.util.List;

import com.Carpoolline.Passenger.User_Query.Domain_Mapper.User_query_waitingcar_pojo;

public interface User_query_service_face {
	/**
	 * 按时间点查询 待拼车表
	 * @param startTime
	 * @param departure
	 * @param destination
	 * @param waitingTimeType
	 * @param stateClock
	 * @return
	 */
	public List<User_query_waitingcar_pojo> Query_waiting_form(Date startTime,String departure,String destination,String waitingTimeType,int stateClock);
	
	/**
	 * 按时间段查询 待拼车列表
	 * @param startTime
	 * @param departure
	 * @param destination
	 * @param waitingTimeType
	 * @return
	 */
	
	public List<User_query_waitingcar_pojo> Query_waiting_form(Date startTime,String departure,String destination,String waitingTimeType);
	
	
	/**
	 * 按userId查询 待拼车列表
	 * @param userId
	 * @return
	 */
	public List<User_query_waitingcar_pojo> Query_waiting_form(int userId);
	
	
	
	/**
	 * 添加用户
	 * @param waitingId
	 * @param userId
	 * @return
	 */
    public String Query_waitingcar_add_user(int waitingId,int userId,int personNumber);
    
    /**
     * 减少用户
     * @param waitingId
     * @param userId
     * @return
     */
    public  String Query_waitingcar_remove_user(int waitingId,int userId ,int personNumber);
    
    
    /**
     * 查找人数 waitingcar
     * @param waitingId
     * @return
     */
    public int Query_waitingcar_personNumber(int waitingId);
    
}
