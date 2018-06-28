package com.Carpoolline.Driver.User_registration.Controller;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.text.SimpleDateFormat;

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

import com.Carpoolline.Driver.User_registration.Domain_Mapper.User_Driver;

import com.Carpoolline.Driver.User_registration.Service.User_Driver_Service_face;
import com.alibaba.fastjson.JSONObject;


@Controller
@RequestMapping(value="/Driver",produces={"text/html;charset=UTF-8;","application/json;"},method= RequestMethod.POST)
public class User_driver_registration_Controller {
	
	@Resource
	User_Driver_Service_face service_face;
	
	/**
	 * 
	 * @param driverName
	 * @param driverPassword
	 * @param driverTel
	 * @param carType
	 * @param carCard
	 * @param driverType
	 * @param driverStar
	 * @param response
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/Insert")
	@ResponseBody
	public String  insert_user(@RequestParam("driverName") String driverName,@RequestParam("driverPassword") String driverPassword, @RequestParam("driverTel") String driverTel,
			@RequestParam("carType") String carType,@RequestParam("carCard") String carCard,@RequestParam("driverType") String driverType,@RequestParam("driverStar") int driverStar,HttpServletResponse response,HttpServletRequest request)
	{

		 JSONObject json=new JSONObject();
		 
		 
		
		String ifl="TRUE";
		User_Driver user=new User_Driver();
		user.setDriverName(driverName);
		user.setDriverPassword(driverPassword);
		user.setDriverTel(driverTel);
		user.setCarType(carType);
		user.setCarCard(carCard);
		user.setDriverType(driverType);
		user.setDriverStar(driverStar);
		
		ifl=service_face.insert_service(user);	
	   
		json.put("judge", ifl);
		return json.toJSONString();
	}
	
	
	
	/**
	 * 
	 * @param driverName
	 * @param driverPassword
	 * @param response
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/Login")
	@ResponseBody
	public String Driver_Login(@RequestParam("driverName") String driverName,@RequestParam("driverPassword") String driverPassword,HttpServletResponse response,HttpServletRequest request)
	{
		 JSONObject json=new JSONObject();
		 List list=service_face.driver_login(driverName);
		
			
		 if(list.size()==0)
		 {
			 json.put("judge", "NO");
			 return json.toJSONString();
		 }else{
			 User_Driver user_driver=(User_Driver) list.get(0);
			 if(user_driver.getDriverPassword().equals(driverPassword)&&driverPassword!=null)
			 {
				 HttpSession session=request.getSession();
				 System.out.println(driverName);
				 session.setAttribute("DriverName", driverName);
				 session.setAttribute("DriverPassword", driverPassword);
				 session.setAttribute("DriverId", user_driver.getDiverId());
				 json.put("judge", "TRUE");
				 json.put("drivers", user_driver);
				 json.put("sessionId", session.getId());
			 }else{
				 json.put("judge", "FALSE");
				 
				 
			 }
		 }
		 
		 return json.toJSONString();
	}


	/**
	 * 查询司机信息
	 * 不需要session
	 * @param driverId
	 * @param response
	 * @param request
	 * @return driver =driver/null 
	 */
	@RequestMapping(value="/Search")
	@ResponseBody
   public String Driver_Search(@RequestParam("driverId") int driverId,HttpServletResponse response,HttpServletRequest request)
   {
	 JSONObject json=new JSONObject();
	 
	 
	 User_Driver driver=service_face.Drivers_Search(driverId);
	 if(driver!=null)
	 {
		 json.put("driver", driver);
	 }else {
		 json.put("driver", "null");
	 }
	 
	 
	   return json.toJSONString();
   }
}
	


