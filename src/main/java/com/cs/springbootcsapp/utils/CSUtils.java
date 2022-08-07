package com.cs.springbootcsapp.utils;

import java.sql.Date;

import org.springframework.beans.BeanUtils;

import com.cs.springbootcsapp.dto.Car;
import com.cs.springbootcsapp.jpa.model.CarEntity;

public class CSUtils {


	public static CarEntity mapCarToCarEntity(Car car, boolean isUpdate, CarEntity saveEntity) {
		BeanUtils.copyProperties(car, saveEntity);
		setCarEntityStatusValue(car, saveEntity);
		if(isUpdate){			
			saveEntity.setLastUpdatedAt(new Date(System.currentTimeMillis()));
		}else{
			saveEntity.setLastUpdatedAt(new Date(System.currentTimeMillis()));
			saveEntity.setCreatedAt(new Date(System.currentTimeMillis()));
		}
		return saveEntity;
	}




	public static void setCarEntityStatusValue(Car car, CarEntity dbEntity) {
		if(car.getStatus().equalsIgnoreCase(CSConstants.AVAILABLE)){
			dbEntity.setStatus(Status.AVAILABLE);
		}
		if(car.getStatus().equalsIgnoreCase(CSConstants.IN_MAINTENANCE)){
			dbEntity.setStatus(Status.IN_MAINTENENCE);		
		}
		if(car.getStatus().equalsIgnoreCase(CSConstants.OUT_OF_SERVICE)){
			dbEntity.setStatus(Status.OUT_OF_SERVICE);
		}
	}
	
	public static boolean isUpdate(Integer id){
		return (null!=id);
	}




}
