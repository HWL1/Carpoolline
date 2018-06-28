package com.Carpoolline.Passenger.User_registration.Service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.Carpoolline.Passenger.User_registration.Dao.User_registration_mapper_face;
import com.Carpoolline.Passenger.User_registration.Domain_Mapper.User_Passenger;
@Service
public class User_passenger_Service implements User_passenger_Service_face {

	@Resource
	User_registration_mapper_face mapper_face;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
	public String insert_service(User_Passenger user) {
		String s="TRUE";
	try {
		mapper_face.Insert(user);
	} catch (Exception e) {
		s="FALSE";
	}
			
			
		
			
		
		return s;
	}

}
