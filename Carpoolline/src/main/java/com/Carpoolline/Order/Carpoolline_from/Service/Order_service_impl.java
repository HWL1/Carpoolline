package com.Carpoolline.Order.Carpoolline_from.Service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.Carpoolline.Order.Carpoolline_from.Dao.Order_mapper_face;
import com.Carpoolline.Order.Carpoolline_from.Domain_Mapper.Order_carpoolline_pojo;
import com.Carpoolline.Order.Carpoolline_from.Domain_Mapper.Ordertousers_pojo;

@Service
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
public class Order_service_impl implements Order_service_face{

	
	@Resource
	Order_mapper_face mapper_face;
	
	
	@Override
	public Integer Create_order_carpoolline(Order_carpoolline_pojo Order) {
		Integer orderId=0;
		try {
			Order_carpoolline_pojo pojo=new Order_carpoolline_pojo();
			mapper_face.create_order_carpoolline(Order);
			 orderId=pojo.getOrderId();
			
		}catch (Exception e) {
			return -1;
		}
		
		return orderId;
	}
	@Override
	public boolean Create_ordertousers(List<Integer>  list,Integer orderId) {
		
		try {
			
			for(int i=0;i<list.size();i++) {
				Ordertousers_pojo pojo=new Ordertousers_pojo();
				pojo.setOrderId(orderId);
				pojo.setOrdertousersId(1);
				pojo.setUserId(list.get(i));
			    mapper_face.create_ordertousers(pojo);
			
			}
		} catch (Exception e) {
			return false;
		}
	return true;
	}

	@Override
	public List<Order_carpoolline_pojo> Select_order_carpoolline(Integer userId) {
		
		List<Order_carpoolline_pojo> list=new ArrayList();
		List<Integer> orderId=new ArrayList();
		
		try {
			orderId=mapper_face.select_ordertousers_orderId_userId(userId);
			for(int i=0;i<orderId.size();i++)
			{
				Order_carpoolline_pojo pojo=mapper_face.select_order_all_orderId(orderId.get(i));
				if(pojo!=null)
				list.add(pojo);
			}
			
		} catch (Exception e) {
			return list;
		}
		
		
		return list;
	}

}
