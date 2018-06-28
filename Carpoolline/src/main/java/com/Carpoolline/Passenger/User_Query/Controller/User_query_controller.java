package com.Carpoolline.Passenger.User_Query.Controller;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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

import com.Carpoolline.Passenger.User_Query.Domain_Mapper.User_query_waitingcar_pojo;
import com.Carpoolline.Passenger.User_Query.Service.User_query_service_face;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping(value="/Query",produces={"text/html;charset=UTF-8;","application/json;"},method= RequestMethod.POST)
public class User_query_controller {
	
	@Resource
	User_query_service_face service_face;
	
	
	/**
	 * user查询待拼车表
	 * @param userName
	 * @param userPassword
	 * @param startTime
	 * @param departure
	 * @param destination
	 * @param waitingTimeType
	 * @param stateClock
	 * @param request
	 * @param response
	 * @return  JSONArray{json0,json1,List} json1{LoginError =LoginFailure/LandingSuccess}  json1{number} list{waitingcar_pojo}   number=0/
	 */
	@ResponseBody
	@RequestMapping(value="/From" )
	public String User_query_from_controller(@RequestParam("userName") String userName,
			                                  @RequestParam("userPassword") String userPassword,
			                                  @RequestParam("startTime") Date startTime,
			                                  @RequestParam("departure")  String departure,
			                                  @RequestParam("destination")  String destination,
			                                  @RequestParam("waitingTimeType")  String waitingTimeType,
			                                  @RequestParam("startClock")  int startClock,
			                                  HttpServletRequest request,HttpServletResponse response){
		//****************
		JSONArray jsonArray=new JSONArray();
		JSONObject jsonO=new JSONObject();
		JSONObject json1=new JSONObject();
		Boolean Verification=false;
		int number =0;
		List<User_query_waitingcar_pojo> list=new ArrayList<>();

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
		
		if(waitingTimeType.equals("PA"))
		{
			list=service_face.Query_waiting_form(startTime, departure, destination, waitingTimeType,startClock);
		}else {
			
			list=service_face.Query_waiting_form(startTime, departure, destination, waitingTimeType);
		}
		number=list.size();
		json1.put("number", number);
		jsonArray.add(jsonO);
		jsonArray.add(json1);
		jsonArray.add(list);
		
		return jsonArray.toJSONString();
		
	}
	

	
	
	/**
	 * user选择拼车表并等待拼车YES
	 * @param userName
	 * @param userName2
	 * @param userName3
	 * @param userName4
	 * @param userPassword
	 * @param waitingId
	 * @param personNumber
	 * @param request
	 * @param response
	 * @returnJSONObject  LoginError =LoginFailure/LandingSuccess judge=TRUE(拼车成功）/4(人数已满)/FALSE/EXISTENCE(用户已存在)
	 */
	@RequestMapping(value="/Carpoolling")
	@ResponseBody
	public String User_query_Carpoolling_controller(@RequestParam("userName") String userName,
			                                        @RequestParam("userName2") String userName2,
			                                        @RequestParam("userName3") String userName3,
			                                        @RequestParam("userName4") String userName4,
                                                    @RequestParam("userPassword") String userPassword,
                                                    @RequestParam("waitingId") int waitingId,
                                                    @RequestParam("personNumber") int personNumber,
                                                    HttpServletRequest request,HttpServletResponse response){
		
		//*********
		//JSONArray jsonArray=new JSONArray();
		JSONObject json=new JSONObject();
		Boolean Verification=false;
		List<User_query_waitingcar_pojo> list=new ArrayList<>();

		HttpSession session=request.getSession();
		
		if(session.getAttribute("userName")!=null&&session.getAttribute("userPassword")!=null&&userName.equals(session.getAttribute("userName"))&&userPassword.equals(session.getAttribute("userPassword")))
		{
			Verification=true;
		}
		
		if(Verification==false)
		{
			json.put("LoginError", "LoginFailure");
			return json.toJSONString();
		}
		json.put("LoginError", "LandingSuccess");
		//************
		
		
		
		int userId=(int) session.getAttribute("userId");
		

		String judge=service_face.Query_waitingcar_add_user(waitingId, userId,personNumber);
		if(judge.equals("FALSE"))
		{
			json.put("judge", "FALSE");
		}
		if(judge.equals("TRUE"))
		{
			json.put("judge", "TRUE");
		}
		if(judge.equals("FULL"))
		{
			json.put("judge", "4");
		}
		if(judge.equals("existence"))
		{
			json.put("judge", "EXISTENCE");
		}
		
		return json.toJSONString();
	}
	
	
	/**
	 * user 取消拼车YES
	 * @param userName
	 * @param userPassword
	 * @param waitingId
	 * @param request
	 * @param response
	 * @return JSONObject  LoginError =LoginFailure/LandingSuccess judge=TRUE(取消成功）/FALSE/EXISTENCE(用户已取消)
	 */
	@ResponseBody
	@RequestMapping(value="/Remove")
	public String User_query_Carpoolling_remove(@RequestParam("userName") String userName,
                                                    @RequestParam("userPassword") String userPassword,
                                                    @RequestParam("personNumber") int personNumber,
                                                    @RequestParam("waitingId") int waitingId,
                                                    HttpServletRequest request,HttpServletResponse response){
		
		//*********
		//JSONArray jsonArray=new JSONArray();
		JSONObject json=new JSONObject();
		Boolean Verification=false;
		List<User_query_waitingcar_pojo> list=new ArrayList<>();

		HttpSession session=request.getSession();
		
		if(session.getAttribute("userName")!=null&&session.getAttribute("userPassword")!=null&&userName.equals(session.getAttribute("userName"))&&userPassword.equals(session.getAttribute("userPassword")))
		{
			Verification=true;
		}
		
		if(Verification==false)
		{
			json.put("LoginError", "LoginFailure");
			return json.toJSONString();
		}
		json.put("LoginError", "LandingSuccess");
		//************
		int userId=(int) session.getAttribute("userId");
	
		String judge= service_face.Query_waitingcar_remove_user(waitingId, userId,personNumber);
	
		
		if(judge.equals("TRUE"))
		{
			json.put("judge", "TRUE");
		}
		if(judge.equals("FALSE"))
		{
			json.put("judge", "FALSE");
		}
		if(judge.equals("existence"))
		{
			json.put("judge", "EXISTENCE");
		}
		
		return json.toJSONString();
	}
	
	
	/**
	 * 查询拼车状态 state
	 * @param waitingId
	 * @param userName
	 * @param userPassword
	 * @param request
	 * @param response
	 * @return LoginError=LoginFailure/LandingSuccess  personNumber=0-4/5(查询失败)
	 */
	@RequestMapping(value="/State")
	@ResponseBody
	public String User_query_Carpooling_state(@RequestParam("waitingId") int waitingId,
			                                   @RequestParam("userName") String userName,
                                             @RequestParam("userPassword") String userPassword,
                                             HttpServletRequest request,HttpServletResponse response) {
		
		JSONObject json=new JSONObject();
		Boolean Verification=false;
		

		HttpSession session=request.getSession();
		
		if(session.getAttribute("userName")!=null&&session.getAttribute("userPassword")!=null&&userName.equals(session.getAttribute("userName"))&&userPassword.equals(session.getAttribute("userPassword")))
		{
			Verification=true;
		}
		
		if(Verification==false)
		{
			json.put("LoginError", "LoginFailure");
			return json.toJSONString();
		}
		json.put("LoginError", "LandingSuccess");
		//************
		
		json.put("personNumber", service_face.Query_waitingcar_personNumber(waitingId));
		
		
		return json.toJSONString();
	}

	
	/**
	 * user查找正在拼车表
	 * @param userName
	 * @param userPassword
	 * @param request
	 * @param response
	 * @return jsonArray{ json{LoginError=LoginFailure/LandingSuccess judge=FALSE/TRUE} {list} }
	 */
	@RequestMapping(value="/Waitingcar")
	@ResponseBody
	public String User_query_Carpoolline_waitingcar(@RequestParam("userName") String userName,
                                                   @RequestParam("userPassword") String userPassword,
                                                   HttpServletRequest request,HttpServletResponse response)
	{

		JSONObject json=new JSONObject();
		JSONArray Array=new JSONArray();
		Boolean Verification=false;
		int userId;

		HttpSession session=request.getSession();
		
		if(session.getAttribute("userName")!=null&&session.getAttribute("userPassword")!=null&&userName.equals(session.getAttribute("userName"))&&userPassword.equals(session.getAttribute("userPassword")))
		{
			Verification=true;
		}
		
		if(Verification==false)
		{
			json.put("LoginError", "LoginFailure");
			Array.add(json);
			return Array.toJSONString();
		}
		json.put("LoginError", "LandingSuccess");
		//************
		userId=(int) session.getAttribute("userId");
		
		
		List list=service_face.Query_waiting_form(userId);
		
		if(list.size()==0)
		{
			json.put("judge", "FALSE");
			Array.add(json);
		}else {
			
			json.put("judge", "TRUE");
			Array.add(json);
			
			Array.add(list);
		}
		
		return Array.toJSONString();
	}
	
	
}


