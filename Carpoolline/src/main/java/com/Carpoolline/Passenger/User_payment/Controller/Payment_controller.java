package com.Carpoolline.Passenger.User_payment.Controller;

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
import com.Carpoolline.Order.Carpoolline_from.Domain_Mapper.Ordertousers_pojo;
import com.Carpoolline.Order.Carpoolline_from.Service.Order_service_face;
import com.Carpoolline.Passenger.User_Query.Domain_Mapper.User_query_waitingcar_pojo;
import com.Carpoolline.Passenger.User_payment.Service.Payment_service_face;
import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping(value="/Payment",produces={"text/html;charset=UTF-8;","application/json;"},method= RequestMethod.POST)
public class Payment_controller {
	
	@Resource
	Payment_service_face service_face;
	@Resource
	Order_service_face order_service;
	
	/**
	 * user付款
	 * @param userName
	 * @param userPassword
	 * @param waitingId
	 * @param request
	 * @param response
	 * @return JSONObject  LoginError=LoginFailure/LandingSuccess  judge=TRUE成功/FALSE/EXISTENCE(已经付款)
	 */
	@ResponseBody
	@RequestMapping(value="/Payment")
	public String User_payment(@RequestParam("userName") String userName,
                               @RequestParam("userPassword") String userPassword,
                                @RequestParam("waitingId") int waitingId,
                                @RequestParam("userId") int userId,
                                               HttpServletRequest request,HttpServletResponse response){

        //*********
       
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
          //*********
         
          
        String s=service_face.user_refund(waitingId, userId,"YES");
        if(s.equals("YES")||s.equals("KO"))
        {
        	json.put("judge", "TRUE");
        }
        if(s.equals("KO"))
        {
        	
        		Order_carpoolline_pojo order_pojo=service_face.Synthesis_order(waitingId);
        		
        		List list1=service_face.Order_ordertousers(waitingId);
        		
        		Integer orderId=order_service.Create_order_carpoolline(order_pojo);
        		
        		if(orderId!=-1)
        		{
        			
        			boolean boo2=order_service.Create_ordertousers(list1,waitingId);
        		}
        		
        	}
        
        if(s.equals("NO")){
        	json.put("judge", "FALSE");
        
        }
        	
        
         
        if(s.equals("existence"))
        {
        	json.put("judge", "EXISTENCE");
        }
          return json.toJSONString();  
    
	}
	
	
	
	
	/**
	 * user取消付款
	 * @param userName
	 * @param userPassword
	 * @param waitingId
	 * @param userId
	 * @param request
	 * @param response
	 * @return JSONObject  LoginError=LoginFailure/LandingSuccess  judge=true成功/false/existence(已经取消)
	 */
	@ResponseBody
	@RequestMapping(value="/Refund")
	public String User_Refund(@RequestParam("userName") String userName,
                               @RequestParam("userPassword") String userPassword,
                                @RequestParam("waitingId") int waitingId,
                                @RequestParam("userId") int userId,
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
          //*********
         
        String s=service_face.user_refund_all(waitingId);
        if(s.equals("YES"))
        {
        	json.put("judge", "TRUE");
        }
        if(s.equals("NO")) {
        	
        	json.put("judge", "FALSE");
        }
        if(s.equals("existence"))
        {
        	json.put("judge", "EXISTENCE");
        }
          
          return json.toJSONString();  
    
	}
}
