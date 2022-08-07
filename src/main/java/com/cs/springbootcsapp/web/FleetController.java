package com.cs.springbootcsapp.web;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs.springbootcsapp.dto.Car;
import com.cs.springbootcsapp.jpa.model.CarEntity;
import com.cs.springbootcsapp.services.CarService;
import com.cs.springbootcsapp.utils.CSConstants;
import com.cs.springbootcsapp.utils.CSUtils;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@CrossOrigin
@RestController
@RequestMapping(CSConstants.URL_FLEET)
public class FleetController {

	public static final Logger LOGGER = LoggerFactory.getLogger(FleetController.class);

	@Autowired
	CarService carService;

	/**
	 * Fetches the details of Car Entity.
	 * @param id input the Integer 
	 * @return the Car Entity as response
	 *
	 * @ApiOperation ,@ApiResponses, @ApiParam these part of Swagger 
	 * to provide more details of this controller 
	 **/
	
	
	@GetMapping(value=CSConstants.URL_CARS_BY_ID,produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Request a Car details Data by id ", response = CarEntity.class, httpMethod = "GET",
	code = 200, notes = " Example : http://localhost:8080/fleet/cars/{id}")
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Fetches car details based on id provided"),
	        @ApiResponse(code = 400, message = "Not Valid Request"),
	        @ApiResponse(code = 401, message = "You are not authorized to view "),
	        @ApiResponse(code = 404, message = "Not found")
	})
	public ResponseEntity<CarEntity> getCarById( 
			@ApiParam( name =  "id", type = "Integer", value = "Id", example = "12345",  required = true)
			@PathVariable(CSConstants.PATHVRAIBALE_ID) Integer id) {
		LOGGER.info("FleetController Car Details By Id {}",id);
		CarEntity car = carService.getCarDetails(id);

		if (null != car) {
			LOGGER.info("FleetController method Car Details found {}",car);
			return new ResponseEntity<>(car, HttpStatus.OK);
		} else {
			LOGGER.debug("FleetController method Car Details not found");

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Save car details .
	 * @param car input the CarEntity 
	 * @return the saved Car Entity as response
	 *
	 * @ApiOperation ,@ApiResponses, @ApiParam these part of Swagger 
	 * to provide more details of this controller 
	 **/
	@PostMapping(value = CSConstants.URL_CARS,consumes=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Add Car Details ",  httpMethod= "POST",response = CarEntity.class,
	notes = " Example : http://localhost:8080/fleet/cars",consumes="application/json")
	@ApiResponses(value = {
	        @ApiResponse(code = 200,message= "creates car details in DB"),
	        @ApiResponse(code = 400, message = "Not Valid Request"),
	        @ApiResponse(code = 401, message = "You are not authorized to view "),
	        @ApiResponse(code = 404, message = "Not found"),
	        @ApiResponse(code = 500, message = "Internal Server Error")

	})
	public ResponseEntity<CarEntity> createCar(@Valid @RequestBody Car car) {
		try {
			CarEntity _car = carService.saveOrUpdateCar(car,null);
			return new ResponseEntity<>(_car, HttpStatus.CREATED);
		} catch (Exception e) {
			LOGGER.error("Exception during creation  {}",e.getMessage());

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	/**
	 * update car details .
	 * @param id  Input the  Integer 
	 * @param Car details   Input the CarEntity 
	 * @return the Updated Car details as response
	 *
	 * @ApiOperation ,@ApiResponses, @ApiParam these part of Swagger 
	 * to provide more details of this controller 
	 **/
	@PutMapping(value= CSConstants.URL_UPDATE_CARS_ID)
	@ApiOperation(value = "Add Car Details ", response = CarEntity.class, httpMethod= "PUT",
	code = 201, notes = " Example : http://localhost:8080/fleet/cars/{id}")
	@ApiResponses(value = {
	        @ApiResponse(code = 201, message = "Fetches updated car details from DB"),
	        @ApiResponse(code = 400, message = "Not Valid Request"),
	        @ApiResponse(code = 401, message = "You are not authorized to view "),
	        @ApiResponse(code = 404, message = "Not found"),
	        @ApiResponse(code = 500, message = "Internal Server Error")

	})
	public ResponseEntity<CarEntity> updateCar(@PathVariable(CSConstants.PATHVRAIBALE_ID) Integer id, @RequestBody Car car) {
		CarEntity updatedEntity=null;
		if (null != car ) {			
			updatedEntity=  carService.saveOrUpdateCar(car, id);
			if(null!=updatedEntity){
				return new ResponseEntity<>(carService.saveOrUpdateCar(car, id), HttpStatus.OK);
			}else{
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} else {
			LOGGER.debug("updateCar : Car details not found by id");

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	/**
	 * Fetches the List of Car Entities.
	 * @return the List of  Cars as response
	 *
	 * @ApiOperation ,@ApiResponses, @ApiParam these part of Swagger 
	 * to provide more details of this controller 
	 **/
	@GetMapping(value= CSConstants.URL_CARS,produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Request for Car Data ", response = CarEntity[].class, httpMethod = "GET",
	code = 200, notes = " Example : http://localhost:8080/fleet/cars")
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "List of Car details from DB"),
	        @ApiResponse(code = 400, message = "Not Valid Request"),
	        @ApiResponse(code = 404, message = "Not found"),
	        @ApiResponse(code = 500, message = "Internal Server Error")
	})
	public ResponseEntity<List<CarEntity>> getAllCars() {
		try {
			List<CarEntity> cars = new ArrayList<CarEntity>();
			carService.findAll().forEach(cars::add);
			if (cars.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

			return new ResponseEntity<>(cars, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("Exception during fectching cars details {}",e.getMessage());

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}




