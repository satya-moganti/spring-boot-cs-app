package com.cs.springbootcsapp.jpa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cs.springbootcsapp.utils.Status;

@Entity
public class CarEntity {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO) //Auto increment id
	@Column
	private Integer id; 
	
	@Column(nullable = false,length=50)
	private String brand; 
	
	@Column(name = "license_plate",nullable = false,length = 15)
	private String licensePlate; 
	
	@Column(nullable = false,length = 50)
	private String manufacturer; 
	
	@Column(name = "operation_city", nullable = false,length = 100)
	private String operationCity;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Status status;   
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;  
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdatedAt;
	
	public CarEntity(){
		
	}
	
	public CarEntity(Integer id, String brand, String licensePlate, String manufacturer, String operationCity,
			Status status, Date createdAt, Date lastUpdatedAt) {
		super();
		this.id = id;
		this.brand = brand;
		this.licensePlate = licensePlate;
		this.manufacturer = manufacturer;
		this.operationCity = operationCity;
		this.status = status;
		this.createdAt = createdAt;
		this.lastUpdatedAt = lastUpdatedAt;
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getLastUpdatedAt() {
		return lastUpdatedAt;
	}

	public void setLastUpdatedAt(Date lastUpdatedAt) {
		this.lastUpdatedAt = lastUpdatedAt;
	}
	
	
	

}
