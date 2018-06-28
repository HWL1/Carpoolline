package com.Carpoolline.Driver.Driver_release.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.Carpoolline.Driver.Driver_release.Domain_Mapper.Driver_release_pojo;


public interface Driver_release_mapper_face {
	
	public void Insert_waitingcar(Driver_release_pojo release);
	
	public List Select_waitingcar_driverId(int driverId);
	
    public int Delete_waitingcar(@Param("waitingId") int waitingId,@Param("version") int version);
	
	public int Update_waitingcar(Driver_release_pojo release);
	
	public Driver_release_pojo Select_waitingcar_personNumber(int waitingId);

}
