package com.Carpoolline.Passenger.User_payment.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface Payment_mapper_face {
	
	public void update_waitingcar_state(@Param("state") String state, @Param("userId") int userId,@Param("waitingId") int waitingId );

	
	public List<Integer> select_waitingcartousers_state(@Param("state") String state, @Param("waitingId") int waitingId);
	
}
