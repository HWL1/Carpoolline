package com.Carpoolline.Passenger.User_Query.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.Carpoolline.Passenger.User_Query.Dao.User_query_mapper_face;
import com.Carpoolline.Passenger.User_Query.Domain_Mapper.User_query_waitingcar_pojo;
import com.Carpoolline.Passenger.User_Query.Domain_Mapper.User_query_waitingcartousers_pojo;
import com.Carpoolline.Passenger.User_payment.Service.Payment_service_face;


@Service
public class User_query_service  implements User_query_service_face{

	@Resource
	User_query_mapper_face  mapper_face;
	
	@Resource
	Payment_service_face paymen_service;
	
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
	public List<User_query_waitingcar_pojo> Query_waiting_form(Date startTime, String departure, String destination,
			String waitingTimeType, int startClock) {
		List<User_query_waitingcar_pojo> list=new ArrayList<>();
		
		try {
		Map<String,Object> map=new HashMap<>();
		map.put("startTime", startTime);               //开始日期
		map.put("departure",departure );               //出发地点
		map.put("destination",destination );           //到达地点
		map.put("waitingTimeType",waitingTimeType );   //时间类型
		map.put("startClock",startClock );     //出发时间
		
		list=mapper_face.select_waitingcar_Point(map);
		}catch (Exception e) {
			return list ;
		}
		
		return list;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
	public List<User_query_waitingcar_pojo> Query_waiting_form(Date startTime, String departure, String destination,
			String waitingTimeType) {
		try {
		
		Map<String,Object> map=new HashMap<>();
		map.put("startTime", startTime);
		map.put("departure",departure );
		map.put("destination",destination );
		map.put("waitingTimeType",waitingTimeType );
		
		
		return mapper_face.select_waitingcar_Slot(map);
		} catch (Exception e) {
			throw  new RuntimeException();
		}
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
	public String Query_waitingcar_add_user(int waitingId, int userId,int personNumber) {
		
	  	try {
		int number=0;
		long N1=System.currentTimeMillis();
		User_query_waitingcar_pojo waitingcar_pojo=null;
		int version=0;
		while(true) {
			
			long N2=System.currentTimeMillis();
			if(N2-N1>100)
			{
				return "FALSE";
			}
		waitingcar_pojo=mapper_face.select_waitingcar_waitingId(waitingId);
			
		List<Integer> list=mapper_face.select_waitingcartousers_userid(waitingId);
		
		number=waitingcar_pojo.getPersonNumber();
		version=waitingcar_pojo.getVersion();
		
		
		   for(int i=0;i<list.size();i++)
	        {
	        	if(userId==list.get(i))
	        	{
	        		return "existence";
	        	}
	        }
		
		if(number==4||number>(4-personNumber))
		{
			return "FULL";
		}

        
		
		if(number==(4-personNumber))
		{
			//获取四个用户id 向四个用户发送成功短信 并进入待付款状态
			if(mapper_face.update_waitingcar_personNumber_add(waitingId, version,personNumber)==1)
			{
				
				//调用发短信函数***************************************************************
				mapper_face.update_waitingcar_state("YES",waitingId);
				for(int i=0;i<personNumber;i++)
				{
				Map<String, Object> map=new HashMap<>();
    			map.put("waitingId", waitingId);
    			map.put("userId", userId);
    			map.put("state", "NO");
    			mapper_face.insert_waitingcartousers_user(map);
				}
				return "TRUE";
			}
			
			
		}
        if(number+personNumber<4) {
		
			//人数加一继续等待
        	
        	if(mapper_face.update_waitingcar_personNumber_add(waitingId, version,personNumber)==1)
        	{
        		for(int i=0;i<personNumber;i++)
        		{
        		Map<String, Object> map=new HashMap<>();
    			map.put("waitingId", waitingId);
    			map.put("userId", userId);
    			map.put("state", "NO");
    			mapper_face.insert_waitingcartousers_user(map);
    			
        		}
    			return "TRUE";
        	}
        	
			
		}
     }
		} catch (Exception e) {
			return "FALSE";
		}
	}
    
	@Override
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
	public String Query_waitingcar_remove_user(int waitingId, int userId,int personNumber) {
		int number=0;
		long N1=System.currentTimeMillis();
		User_query_waitingcar_pojo waitingcar_pojo=null;
		int version=0;
		try {
			
		
		while(true)
		{
			long N2=System.currentTimeMillis();
			if(N2-N1>100)
			{
				return "FALSE";
			}
			
			waitingcar_pojo=mapper_face.select_waitingcar_waitingId(waitingId);
			version=waitingcar_pojo.getVersion();
			number=waitingcar_pojo.getPersonNumber();
			List<Integer> list=mapper_face.select_waitingcartousers_userid(waitingId);
			boolean bool=false;
			 for(int i=0;i<list.size();i++)
		        {
		        	if(userId==list.get(i))
		        	{
		        		bool=true;
		        	}
		        }
			
			 if(bool==false)
			 {
				 return "existence";
			 }
			 
			if(number<4&&number>=personNumber)
			{
				if(mapper_face.update_waitingcar_personNumber_subtract(waitingId, version,personNumber)==1)
				{
					mapper_face.delete_waitingcartousers_userId(userId);
					return "TRUE";
				}else {
					continue;
				}
			}
			
			if(number==4)
			{
				if(mapper_face.update_waitingcar_personNumber_subtract(waitingId, version,personNumber)==1)
				{
					mapper_face.delete_waitingcartousers_userId(userId);
					
					//调用退款函数其他已经付完款的要全部退款并继续等待
					if(paymen_service.user_refund_all(waitingId).equals("NO"))
					{
						return "FALSE";
					}
					
					//短信通知**********************
					return "TRUE";
				}else {
					continue;
				}
					
				
			}
			if(number==0)
			{
				return "FALSE";
			}
			
			
			
		} 
		
	} catch (Exception e) {
		return "FALSE";
	}
	
	}

	@Override
	public int Query_waitingcar_personNumber(int waitingId) {
		int judge=0;
		try {
			
		judge=mapper_face.select_waitingcar_personNumber(waitingId);
		}catch (Exception e) {
			return 5;
		}
		
		return judge;
	}

	@Override
	public List<User_query_waitingcar_pojo> Query_waiting_form(int userId) {
		List<User_query_waitingcar_pojo> list =new ArrayList<>();
		try {
			List list1=mapper_face.select_waitingcartousers_waitingId(userId);
			
			for(int i=0;i<list1.size();i++)
			{
				User_query_waitingcar_pojo pojo=mapper_face.select_waitingcar_waitingId((int)list1.get(i));
				
				List list2=mapper_face.select_waitingcartousers_state((int)list1.get(i), userId,"NO");
				
				pojo.setPersonNumber(list2.size());
				
				if(pojo!=null&&list2.size()!=0)
				{
					list.add(pojo);
				}
				
			}
			
			
		}catch (Exception e) {
			return list;
		}
		
		
		
		return list;
	}

}
