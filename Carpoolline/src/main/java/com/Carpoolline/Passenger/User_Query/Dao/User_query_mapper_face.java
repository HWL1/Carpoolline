package com.Carpoolline.Passenger.User_Query.Dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.Carpoolline.Passenger.User_Query.Domain_Mapper.User_query_waitingcar_pojo;

public interface User_query_mapper_face {
	
	
	/**
	 * ��ʱ������ 
	 * @param map
	 * @return
	 */
	public List<User_query_waitingcar_pojo> select_waitingcar_Point(Map<String ,Object> map);
	
	/**
	 * ��ʱ��β���
	 * @param map
	 * @return
	 */
	public List<User_query_waitingcar_pojo> select_waitingcar_Slot(Map<String ,Object> map);
	
	/**
	 * ��waitingId����
	 * @param waitingId
	 * @return
	 */
	public User_query_waitingcar_pojo  select_waitingcar_waitingId (int waitingId);
	
	
	/**
	 * ��waitingId state����
	 * @param waitingId
	 * @param state
	 * @return
	 */
	public User_query_waitingcar_pojo select_waitingcar_waitingId_state(@Param("waitingId") int waitingId,@Param("state") String state);
	
	
	/**
	 * ��waitingId��userId����state
	 * @param waitingId
	 * @param userId
	 * @return
	 */
	public List<String> select_waitingcartousers_state(@Param("waitingId") int waitingId,@Param("userId") int userId,@Param("state") String state);
	
	
	/**
	 * ����û�����   waitingcar
	 * @param waitingId
	 * @param version
	 * @param personNumber
	 * @return
	 */
	public int update_waitingcar_personNumber_add(@Param("waitingId")  int waitingId, @Param("version") int version,@Param("personNumber") int personNumber);
	
	
	/**
	 * �����û�����  waitingcar
	 * @param waitingId
	 * @param version
	 * @return
	 */
	public int update_waitingcar_personNumber_subtract(@Param("waitingId")  int waitingId, @Param("version") int version,@Param("personNumber") int personNumber);
	
	/**
	 * �ı�waitingcar״̬  YES
	 * @param state
	 */
    public void update_waitingcar_state(@Param("state") String state,@Param("waitingId") int waitingId);
    
    
    /**
     * ���� waitingcar���� YES
     * @param waitingId
     * @return
     */
    public int select_waitingcar_personNumber(@Param("waitingId") int waitingId);
    
    
	
	/**
	 * �����û�id ���û����� waitingcartousers
	 * @param waitingId
	 * @return
	 */
	public List<Integer> select_waitingcartousers_userid(int waitingId);
	
	
	
	/**
	 * �����û�waitingId ������ waitingcartousers
	 * @param userId
	 * @return
	 */
	public List<Integer> select_waitingcartousers_waitingId(int userId);
	
	/**
	 * ����û� id waitingcartousers
	 * @param map
	 */
	public void insert_waitingcartousers_user(Map<String ,Object> map);
	
	/**
	 * ɾ���û�id waitingcartousers  4 waitingId
	 * @param waitingId
	 */
	public void delete_waitingcartousers_user(int waitingId);
	
	/**
	 * ɾ���û�id waitingcartousers 1 userId
	 * @param userId
	 */
	public void delete_waitingcartousers_userId(int userId);
	

}
