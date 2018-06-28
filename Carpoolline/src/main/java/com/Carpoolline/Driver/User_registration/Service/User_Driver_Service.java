package com.Carpoolline.Driver.User_registration.Service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.Carpoolline.Driver.User_registration.Dao.User_Driver_registration_mapper_face;
import com.Carpoolline.Driver.User_registration.Domain_Mapper.User_Driver;

@Service
public class User_Driver_Service implements User_Driver_Service_face {

	@Resource
	User_Driver_registration_mapper_face mapper_face;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
	public String insert_service(User_Driver user) {
		String s="TRUE";
		
	try {
		mapper_face.Insert(user);
	} catch (Exception e) {
		
		s="FALSE";
	}
		return s;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
	public List driver_login(String driver_login) {
		return mapper_face.Select(driver_login);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
	public User_Driver Drivers_Search(int driverId) {
		User_Driver driver=null;
		try {

			driver=mapper_face.Drivers_Search(driverId);
	}catch (Exception e) {
		return null;
	}
		
		
		return driver;
	}

}
