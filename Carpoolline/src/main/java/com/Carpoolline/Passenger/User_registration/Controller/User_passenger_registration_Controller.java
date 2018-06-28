package com.Carpoolline.Passenger.User_registration.Controller;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Carpoolline.Passenger.User_registration.Domain_Mapper.User_Passenger;
import com.Carpoolline.Passenger.User_registration.Service.User_passenger_Service_face;
import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping(value="/Passenger_insert",produces={"text/html;charset=UTF-8;","application/json;"})
public class User_passenger_registration_Controller {
	
	@Resource
	User_passenger_Service_face service_face;
	
	/**
	 * usersÓÃ»§×¢²á
	 * @param username
	 * @param userpassword
	 * @param usertel
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/Submit",method= RequestMethod.POST)
	@ResponseBody
	public String  insert_user(@RequestParam("userName") String username,@RequestParam("userPassword") String userpassword,
                @RequestParam("userTel") String usertel,HttpServletRequest request,HttpServletResponse response)
	{

		 JSONObject json=new JSONObject();
		 
		
		String ifl="TRUE";
		User_Passenger user=new User_Passenger();
		
		
		user.setUserName(username);
		user.setUserPassword(userpassword);
		user.setUserTel(usertel);
		ifl=service_face.insert_service(user);
		json.put("judge", ifl);
		return json.toJSONString();
	}
	

}
