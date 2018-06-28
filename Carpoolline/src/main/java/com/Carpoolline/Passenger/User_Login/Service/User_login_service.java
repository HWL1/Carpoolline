package com.Carpoolline.Passenger.User_Login.Service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.Carpoolline.Passenger.User_Login.Dao.User_login_mapper_face;
import com.Carpoolline.Passenger.User_Login.Domain_Mapper.User_login_pojo;
@Service
public class User_login_service implements User_login_service_face{

	@Resource
	User_login_mapper_face mapper_face;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
	public List Login_user(String UserName) {
		
		return mapper_face.Select(UserName);
	}

}
