package com.Carpoolline.Driver.Driver_release.Service;

import java.util.List;

import com.Carpoolline.Driver.Driver_release.Domain_Mapper.Driver_release_pojo;


public interface Driver_release_service_face {
	
	public String Insert_release(Driver_release_pojo release);
	
	public List Select_release(int driverId);
	
	public int  Delete_release(int waitingId);
	
	public int Update_release(Driver_release_pojo release);
	

}
