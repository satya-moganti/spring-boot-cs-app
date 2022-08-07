package com.cs.springbootcsapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cs.springbootcsapp.dto.Car;
import com.cs.springbootcsapp.jpa.model.CarEntity;
import com.cs.springbootcsapp.jpa.repo.CarEntityRepository;
import com.cs.springbootcsapp.utils.CSUtils;

@Service
public class CarServiceImpl implements CarService {
	
	@Autowired
	CarEntityRepository carEntityRepository;
	

	@Override
	public List<CarEntity> findAll() {		
		return carEntityRepository.findAll();
	}

	@Override
	@Transactional
	@Modifying
	public List<CarEntity> saveCars(List<Car> carsList) {
		List<CarEntity> saveCarEntityList = new ArrayList<CarEntity>();		
		carsList.stream().forEach(car->{
			CarEntity carEntity=  CSUtils.mapCarToCarEntity(car, false, new CarEntity());
			saveCarEntityList.add(carEntity);
		} );

		return carEntityRepository.saveAll(saveCarEntityList);
	}

	@Override
	public CarEntity getCarDetails(Integer id) {
		Optional<CarEntity> OptCarEntity = carEntityRepository.findById(id);
		return OptCarEntity.isPresent() ? OptCarEntity.get() : null;
	}


	@Transactional
	@Modifying
	@Override
	public CarEntity saveOrUpdateCar(Car car, Integer id) {
		CarEntity saveEntity =null;
		boolean isUpdate = CSUtils.isUpdate(id); 
		CarEntity carEntity = (isUpdate) ? getCarDetails(id) :  new CarEntity();
		if(null!=carEntity){
			saveEntity = CSUtils.mapCarToCarEntity(car, isUpdate, carEntity);
			saveEntity = carEntityRepository.save(saveEntity); 	
		}
	
		return saveEntity;
	}



	
}
