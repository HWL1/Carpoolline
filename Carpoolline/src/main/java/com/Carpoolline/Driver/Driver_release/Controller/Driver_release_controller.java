package com.Carpoolline.Driver.Driver_release.Controller;




import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Carpoolline.Driver.Driver_release.Domain_Mapper.Driver_release_pojo;
import com.Carpoolline.Driver.Driver_release.Service.Driver_release_service_face;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping(value="/Driver_release",produces={"text/html;charset=UTF-8;","application/json;"})
public class Driver_release_controller {
	
	@Resource
	Driver_release_service_face service_face;
	/**
	 * 司机搜索自己发布的车程表
	 * @param driverId
	 * @param response
	 * @param request
	 * @return
	 */
	/*list*/
	@RequestMapping(value="/Select",method= RequestMethod.POST)
	public @ResponseBody String Select_waitingoar(@RequestParam("driverName") String  driverName,
			                                        @RequestParam("driverPassword") String  driverPassword,
			                                        @RequestParam("driverId") int driverId,
			                                        HttpServletRequest request,HttpServletResponse response)
	{
		

		JSONArray jsonA=new JSONArray();
		JSONObject jsonO=new JSONObject();
		HttpSession session=request.getSession();
		Boolean driver=false;

		
		if(session.getAttribute("DriverName")!=null&&session.getAttribute("DriverPassword")!=null&&driverName.equals(session.getAttribute("DriverName"))&&driverPassword.equals(session.getAttribute("DriverPassword")))
		{
			driver=true;
		}
		
		if(driver==false)
		{
			jsonO.put("LoginError", "LoginFailure");
			return jsonO.toJSONString();
		}

		
		List list=(List) service_face.Select_release(driverId);
		jsonA.add(list);
		
		
		return jsonA.toJSONString();
	}
	
	/**
	 * 司机发布车程表
	 * @param departure
	 * @param destination
	 * @param startTime
	 * @param endTime
	 * @param personNumber
	 * @param state
	 * @param response
	 * @param request
	 * @param stateClock
	 * @param endClock
	 * @return judge=TRUE/FALSE     LoginError=LoginFailure/LandingSuccess
	 */
	
	
	@RequestMapping(value="/Insert",method= RequestMethod.POST)
	@ResponseBody
	public String Insert_waitingcar(@RequestParam("driverName") String  driverName,
			                         @RequestParam("driverPassword") String  driverPassword,
			                         @RequestParam("departure") String departure,
			                         @RequestParam("destination") String destination,
			                         @RequestParam("startTime") Date startTime,
			                         @RequestParam("endTime") Date endTime,
			                         @RequestParam("personNumber") int personNumber, 
			                         @RequestParam("state")   String state,
			                         @RequestParam("smalldep") String smalldep, 
			                         @RequestParam("smalldes") String smalldes,
			                         @RequestParam("waitingTimeType") String waitingTimeType,
			                         @RequestParam("price") double price,
			                         @RequestParam("startClock") int startClock,
			                         @RequestParam("endClock") int endClock,
			                         HttpServletRequest request,HttpServletResponse response) 
	{
		

		JSONObject json=new JSONObject();
		Driver_release_pojo pojo=new Driver_release_pojo();
		HttpSession session=request.getSession();
        Boolean driver=false;

		
		if(session.getAttribute("DriverName")!=null&&session.getAttribute("DriverPassword")!=null&&driverName.equals(session.getAttribute("DriverName"))&&driverPassword.equals(session.getAttribute("DriverPassword")))
		{
			driver=true;
		}
		
		if(driver==false)
		{
			json.put("LoginError", "LoginFailure");
			return json.toJSONString();
		}
		int Driver_Id =(int) session.getAttribute("DriverId");
		
		
		pojo.setWaitingId(1);
		pojo.setDeparture(departure);
		pojo.setDestination(destination);
		pojo.setStartTime(startTime);
		pojo.setEndTime(endTime);
		pojo.setPersonNumber(0);
		pojo.setState(state);
		pojo.setDriverId(Driver_Id);
		pojo.setSmalldep(smalldep);
		pojo.setSmalldes(smalldes);
		pojo.setWaitingTimeType(waitingTimeType);
		pojo.setPrice(price);
		pojo.setStartClock(startClock);
		pojo.setEndClock(endClock);
		pojo.setVersion(1);
		json.put("judge", service_face.Insert_release(pojo));
		json.put("LoginError", "LandingSuccess");
		
		return json.toJSONString();
	}
	
	
	/**
	 * 
	 * @param driverName
	 * @param driverPassword
	 * @param departure
	 * @param destination
	 * @param startTime
	 * @param endTime
	 * @param state
	 * @param waitingId
	 * @param smalldep
	 * @param smalldes
	 * @param waitingTimeType
	 * @param price
	 * @param stateClock
	 * @param endClock
	 * @param request
	 * @param response
	 * @return
	 */
	/* judeg*/
	@RequestMapping(value="/Update",method= RequestMethod.POST)
	@ResponseBody
	public String Update_waitingcar(@RequestParam("driverName") String  driverName,
			                      @RequestParam("driverPassword") String  driverPassword,
			                      @RequestParam("departure") String departure,
			                      @RequestParam("destination") String destination,
			                      @RequestParam("startTime") Date startTime,
                                  @RequestParam("endTime") Date endTime, 
                                  @RequestParam("state")   String state,
                                  @RequestParam("waitingId") int waitingId,
                                  @RequestParam("smalldep") String smalldep, 
                                  @RequestParam("smalldes") String smalldes,
                                  @RequestParam("waitingTimeType") String waitingTimeType,
                                  @RequestParam("price") double price,
                                  @RequestParam("startClock") int startClock,
			                      @RequestParam("endClock") int endClock,
                                  HttpServletRequest request,HttpServletResponse response)
	{
		

		Driver_release_pojo pojo=new Driver_release_pojo();
		JSONObject json=new JSONObject();
		HttpSession session=request.getSession();
        Boolean driver=false;

		
		if(session.getAttribute("DriverName")!=null&&session.getAttribute("DriverPassword")!=null&&driverName.equals(session.getAttribute("DriverName"))&&driverPassword.equals(session.getAttribute("DriverPassword")))
		{
			driver=true;
		}
		
		if(driver==false)
		{
			json.put("LoginError", "LoginFailure");
			return json.toJSONString();
		}
		
		
		pojo.setDeparture(departure);
		pojo.setDestination(destination);
		pojo.setStartTime(startTime);
		pojo.setEndTime(endTime);
		pojo.setWaitingId(waitingId);
		pojo.setState(state);
		pojo.setSmalldep(smalldep);
		pojo.setSmalldes(smalldes);
		pojo.setWaitingTimeType(waitingTimeType);
		pojo.setPrice(price);
		pojo.setStartClock(startClock);
		pojo.setPersonNumber(endClock);
	
		if(service_face.Update_release(pojo)==0)
		{
			json.put("judge", "TRUE");
		}else {
			json.put("judge", "FALSE");
		}
		
		return json.toJSONString();
		
	}
	
	
	/**
	 * 司机删除自己发布的车程表
	 * @param waitingId
	 * @param response
	 * @param request
	 * @return
	 */
	
	@RequestMapping(value="/Delete",method= RequestMethod.POST)
	@ResponseBody
	public String Delete_waitingoar(@RequestParam("driverName") String  driverName,
			                        @RequestParam("driverPassword") String  driverPassword,
			                        @RequestParam("waitingId") int waitingId,
			                        HttpServletRequest request,HttpServletResponse response)
	{
	
		JSONObject json=new JSONObject();
		HttpSession session=request.getSession();
        Boolean driver=false;

		
		if(session.getAttribute("DriverName")!=null&&session.getAttribute("DriverPassword")!=null&&driverName.equals(session.getAttribute("DriverName"))&&driverPassword.equals(session.getAttribute("DriverPassword")))
		{
			driver=true;
		}
		
		if(driver==false)
		{
			json.put("LoginError", "LoginFailure");
			return json.toJSONString();
		}
		
		if(service_face.Delete_release(waitingId)==0)
		{
			
			json.put("judge", "TRUE");
			
		}else {
			json.put("judge", "FALSE");
		
		}
		return json.toJSONString();
		
		
		
	}

}
