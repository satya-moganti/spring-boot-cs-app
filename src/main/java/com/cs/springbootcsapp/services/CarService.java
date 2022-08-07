package com.cs.springbootcsapp.services;

import java.util.List;

import com.cs.springbootcsapp.dto.Car;
import com.cs.springbootcsapp.jpa.model.CarEntity;

public interface CarService {

	List<CarEntity> findAll();
	CarEntity getCarDetails(Integer id);
	CarEntity saveOrUpdateCar(Car car,Integer id);
	List<CarEntity> saveCars(List<Car> carsList);	
}
