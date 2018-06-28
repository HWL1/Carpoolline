package com.Carpoolline.Passenger.User_payment.Service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.Carpoolline.Order.Carpoolline_from.Domain_Mapper.Order_carpoolline_pojo;
import com.Carpoolline.Order.Carpoolline_from.Domain_Mapper.Ordertousers_pojo;
import com.Carpoolline.Passenger.User_Query.Dao.User_query_mapper_face;
import com.Carpoolline.Passenger.User_Query.Domain_Mapper.User_query_waitingcar_pojo;
import com.Carpoolline.Passenger.User_payment.Dao.Payment_mapper_face;

@Service
public class Payment_service_impl implements Payment_service_face{

	@Resource
	Payment_mapper_face mapper_face;
	@Resource
	User_query_mapper_face query_mapper;
	
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
	public String user_refund(int waitingId, int userId,String fu) {
		try {
			
			List<Integer> list=mapper_face.select_waitingcartousers_state(fu, waitingId);
			
			boolean bool=false;
			
			for(int i=0;i<list.size();i++)
			{
				if(userId==list.get(i))
				{
					
					bool=true;
				}
			}
			
			if(bool==true)
			{
				return "existence";
			}
			
			if(fu.equals("YES"))
			{
				mapper_face.update_waitingcar_state("YES", userId, waitingId);
			}else {
				mapper_face.update_waitingcar_state("NO", userId, waitingId);
			}
		
		
		list=mapper_face.select_waitingcartousers_state("YES", waitingId);
		
		int number=list.size();
		
		if(number==4)
		{
			
			return "KO";
		}
		
		} catch (Exception e) {
			return "NO";
		}
		
		
		return "YES";
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
	public String user_refund_all(int waitingId) {
	
		
		System.out.println("user_refund_all"+waitingId);
		List list=new ArrayList<>();
		list=mapper_face.select_waitingcartousers_state("YES", waitingId);
		try {
		for(int i=0;i<list.size();i++)
		{
			
			int x=(int) list.get(i);
			mapper_face.update_waitingcar_state("NO",x , waitingId);
		
			
		}
		}catch (Exception e) {
			throw  new RuntimeException();
			
		}
		
		return "YES";
	}

	@Override
	public Order_carpoolline_pojo Synthesis_order(int waitingId) {
		
		Order_carpoolline_pojo carpoolline_pojo=new Order_carpoolline_pojo();
		User_query_waitingcar_pojo quer_pojo=query_mapper.select_waitingcar_waitingId(waitingId);
		carpoolline_pojo.setOrderId(waitingId);
		carpoolline_pojo.setDeparture(quer_pojo.getDeparture());
		carpoolline_pojo.setDestination(quer_pojo.getDestination());
		carpoolline_pojo.setDriverId(quer_pojo.getDriverId());
		carpoolline_pojo.setStarTime(quer_pojo.getStartTime());
		carpoolline_pojo.setFinalTime(quer_pojo.getEndTime());
		carpoolline_pojo.setNote("");
		carpoolline_pojo.setPrice(quer_pojo.getPrice());
		carpoolline_pojo.setSmalldep(quer_pojo.getSmalldep());
		carpoolline_pojo.setSmalldes(quer_pojo.getSmalldes());
		carpoolline_pojo.setState("NO");
		carpoolline_pojo.setWaitingTimeType(quer_pojo.getWaitingTimeType());
		
		return carpoolline_pojo;
	}

	@Override
	public List<Integer> Order_ordertousers(int waitingId) {
		
		return mapper_face.select_waitingcartousers_state("YES", waitingId);
	}

}
