package com.Carpoolline.Driver.Driver_release.Service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.Carpoolline.Driver.Driver_release.Dao.Driver_release_mapper_face;
import com.Carpoolline.Driver.Driver_release.Domain_Mapper.Driver_release_pojo;



@Service
public class Driver_release_service implements Driver_release_service_face{

	
	@Resource
	Driver_release_mapper_face mapper_face;
	
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
	public String Insert_release(Driver_release_pojo release) {
		
		String judeg="TRUE";
		try {
			mapper_face.Insert_waitingcar(release);
		} catch (Exception e) {
			judeg="FALSE";
		}
		
		
		return judeg;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
	public List Select_release(int driverId) {
		
		return (List) mapper_face.Select_waitingcar_driverId(driverId);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
	public int  Delete_release(int waitingId ) {
		long N1=System.currentTimeMillis();
		while(true) {
			long N2=System.currentTimeMillis();
			if(N1-N2>100)
			{
				return 5;
			}
		Driver_release_pojo pojo=mapper_face.Select_waitingcar_personNumber(waitingId);
		int number=pojo.getPersonNumber();
		int version=pojo.getVersion();
		if(number>=1)
		{
			return number;
		}else {
			try {
				
			
			if(mapper_face.Delete_waitingcar(waitingId,version)==1)
			{
				return 0;
			}
			}catch (Exception e) {
				return 5;
			}
		}
	}
		
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
	public int  Update_release(Driver_release_pojo release) {
		
		long N1=System.currentTimeMillis();
		while(true) {
			long N2=System.currentTimeMillis();
			if(N1-N2>100)
			{
				return 5;
			}
		
		try {
		Driver_release_pojo pojo=mapper_face.Select_waitingcar_personNumber(release.getWaitingId());
		
		int number=pojo.getPersonNumber();
		int version=pojo.getVersion();
		release.setVersion(version);
		if(number>=1)
		{
			return number;
		}else {
			try {
			if(mapper_face.Update_waitingcar( release)==1)
			{
				return 0;
			}
			}catch (Exception e) {
				return 5;
			}
		}
		}catch (Exception e) {
			return 5;
		}
		
		}

	}



}

