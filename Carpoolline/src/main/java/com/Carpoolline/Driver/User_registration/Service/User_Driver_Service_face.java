package com.Carpoolline.Driver.User_registration.Service;

import java.util.List;

import com.Carpoolline.Driver.User_registration.Domain_Mapper.User_Driver;

public interface User_Driver_Service_face {
	
	public List driver_login(String  driver_login);
	
	public String insert_service(User_Driver user);
	
	public User_Driver Drivers_Search(int driverId);

}
