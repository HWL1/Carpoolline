package com.Carpoolline.Driver.User_registration.Dao;

import java.util.List;

import com.Carpoolline.Driver.User_registration.Domain_Mapper.User_Driver;

public interface User_Driver_registration_mapper_face {
	
       public void Insert(User_Driver user);
       
       public List Select(String UserName);
       
       public User_Driver Drivers_Search(int driverId);
}
