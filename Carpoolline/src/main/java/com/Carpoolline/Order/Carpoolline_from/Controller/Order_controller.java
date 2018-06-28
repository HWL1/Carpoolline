package com.Carpoolline.Order.Carpoolline_from.Controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Carpoolline.Order.Carpoolline_from.Domain_Mapper.Order_carpoolline_pojo;
import com.Carpoolline.Order.Carpoolline_from.Service.Order_service_face;
import com.Carpoolline.Passenger.User_Query.Domain_Mapper.User_query_waitingcar_pojo;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping(value="/Order",produces={"text/html;charset=UTF-8;","application/json;"},method= RequestMethod.POST)
public class Order_controller {
	
	@Resource
	Order_service_face service;
	
	/**
	 * 
	 * @param userName
	 * @param userPassword
	 * @param userId
	 * @param request
	 * @param response
	 * @return jsonArray {json0,list} json0{LoginError =LoginFailure/LandingSuccess judge=TRUE(查找成功/FALSE(没有}
	 */
	@ResponseBody
	@RequestMapping(value="/Select_userId")
	public String Order_select_all_userId(@RequestParam("userName") String userName,
                                          @RequestParam("userPassword") String userPassword,
                                          @RequestParam("userId")  int userId,
                                          HttpServletRequest request,HttpServletResponse response)
	{
		JSONArray jsonArray=new JSONArray();
		JSONObject jsonO=new JSONObject();
		JSONObject json1=new JSONObject();
		Boolean Verification=false;
		
		List<Order_carpoolline_pojo> list=new ArrayList<>();
		
		HttpSession session=request.getSession();
         

		
		if(session.getAttribute("userName")!=null&&session.getAttribute("userPassword")!=null&&userName.equals(session.getAttribute("userName"))&&userPassword.equals(session.getAttribute("userPassword")))
		{
			Verification=true;
		}
		
		if(Verification==false)
		{
			jsonO.put("LoginError", "LoginFailure");
			jsonArray.add(jsonO);
			return jsonArray.toJSONString();
		}
		jsonO.put("LoginError", "LandingSuccess");
		//*******************
		
		list=service.Select_order_carpoolline(userId);
		
		jsonArray.add(jsonO);
		if(list.size()==0)
		{
			json1.put("judge", "FALSE");
			jsonArray.add(json1);
		}else {
			json1.put("judge", "TRUE");
			jsonArray.add(json1);
			jsonArray.add(list);
		}	
		
		return jsonArray.toJSONString();
	}
	
	

}
