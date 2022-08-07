package com.cs.springbootcsapp.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Car {
	
	@NotNull(message="id is required and provide int value")
	private Integer id; 
	
	@NotBlank(message="brand value is required")
	private String brand; 	
	
	@NotBlank(message="licensePlate details required")
	private String licensePlate; 
	
	@NotBlank(message="manufacturer is required")
	private String manufacturer; 
	
	@NotBlank(message="opertionCity is required")	
	private String operationCity;	
	
	@NotBlank(message="Status is required")
	private String status;   	
	public Car(){
		
	}
	
	public Car(Integer id, String brand, String licensePlate, String manufacturer, String operationCity, String status) {
		super();
		this.id = id;
		this.brand = brand;
		this.licensePlate = licensePlate;
		this.manufacturer = manufacturer;
		this.operationCity = operationCity;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getOperationCity() {
		return operationCity;
	}

	public void setOperationCity(String operationCity) {
		this.operationCity = operationCity;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}
