package com.Carpoolline.Passenger.User_Login.Controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.json.JsonArray;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Carpoolline.Passenger.User_Login.Domain_Mapper.User_login_pojo;
import com.Carpoolline.Passenger.User_Login.Service.User_login_service_face;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping(value="/Passenger_login",produces={"text/html;charset=UTF-8;","application/json;"})
public class User_login_controller {
	
	
	@Resource
	User_login_service_face login_service_face;
	/**
	 * usersÓÃ»§µÇÂ½
	 * @param userName
	 * @param userPassword
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/Submit",method= RequestMethod.POST)
	@ResponseBody
	public String passenger_login(@RequestParam("userName") String userName,@RequestParam("userPassword") String userPassword,HttpServletRequest request,HttpServletResponse response)
	{
		 JSONObject json=new JSONObject();
		
		List list=login_service_face.Login_user(userName);
		if(list.size()==0)
		{
			json.put("judge", "FALSE");
			return json.toJSONString();
		}
		User_login_pojo user =(User_login_pojo)list.get(0);
		String pass=user.getUserPassword();
		if(pass.equals(userPassword)&&userPassword!=null&&pass!=null)
		{
			HttpSession session=request.getSession();
			
			session.setAttribute("userName", userName);
			session.setAttribute("userPassword", userPassword);
			session.setAttribute("userId", user.getUserId());
			json.put("judge", "TRUE");
			json.put("users", user);
		
			json.put("sessionId", session.getId());
		}else{
			json.put("judge", "FALSE");
		}
		

		return json.toJSONString();
	}

}
