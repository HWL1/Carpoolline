package com.Carpoolline.Passenger.User_Query.Dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.Carpoolline.Passenger.User_Query.Domain_Mapper.User_query_waitingcar_pojo;

public interface User_query_mapper_face {
	
	
	/**
	 * 按时间点查找 
	 * @param map
	 * @return
	 */
	public List<User_query_waitingcar_pojo> select_waitingcar_Point(Map<String ,Object> map);
	
	/**
	 * 按时间段查找
	 * @param map
	 * @return
	 */
	public List<User_query_waitingcar_pojo> select_waitingcar_Slot(Map<String ,Object> map);
	
	/**
	 * 按waitingId查找
	 * @param waitingId
	 * @return
	 */
	public User_query_waitingcar_pojo  select_waitingcar_waitingId (int waitingId);
	
	
	/**
	 * 按waitingId state查找
	 * @param waitingId
	 * @param state
	 * @return
	 */
	public User_query_waitingcar_pojo select_waitingcar_waitingId_state(@Param("waitingId") int waitingId,@Param("state") String state);
	
	
	/**
	 * 按waitingId和userId查找state
	 * @param waitingId
	 * @param userId
	 * @return
	 */
	public List<String> select_waitingcartousers_state(@Param("waitingId") int waitingId,@Param("userId") int userId,@Param("state") String state);
	
	
	/**
	 * 添加用户数量   waitingcar
	 * @param waitingId
	 * @param version
	 * @param personNumber
	 * @return
	 */
	public int update_waitingcar_personNumber_add(@Param("waitingId")  int waitingId, @Param("version") int version,@Param("personNumber") int personNumber);
	
	
	/**
	 * 减少用户数量  waitingcar
	 * @param waitingId
	 * @param version
	 * @return
	 */
	public int update_waitingcar_personNumber_subtract(@Param("waitingId")  int waitingId, @Param("version") int version,@Param("personNumber") int personNumber);
	
	/**
	 * 改变waitingcar状态  YES
	 * @param state
	 */
    public void update_waitingcar_state(@Param("state") String state,@Param("waitingId") int waitingId);
    
    
    /**
     * 查找 waitingcar人数 YES
     * @param waitingId
     * @return
     */
    public int select_waitingcar_personNumber(@Param("waitingId") int waitingId);
    
    
	
	/**
	 * 查找用户id 和用户数量 waitingcartousers
	 * @param waitingId
	 * @return
	 */
	public List<Integer> select_waitingcartousers_userid(int waitingId);
	
	
	
	/**
	 * 查找用户waitingId 和数量 waitingcartousers
	 * @param userId
	 * @return
	 */
	public List<Integer> select_waitingcartousers_waitingId(int userId);
	
	/**
	 * 添加用户 id waitingcartousers
	 * @param map
	 */
	public void insert_waitingcartousers_user(Map<String ,Object> map);
	
	/**
	 * 删除用户id waitingcartousers  4 waitingId
	 * @param waitingId
	 */
	public void delete_waitingcartousers_user(int waitingId);
	
	/**
	 * 删除用户id waitingcartousers 1 userId
	 * @param userId
	 */
	public void delete_waitingcartousers_userId(int userId);
	

}
