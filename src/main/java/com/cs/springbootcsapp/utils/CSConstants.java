package com.cs.springbootcsapp.utils;

public class CSConstants {

	public static final String URL_FLEET = "fleet";
	
	public static final String PATHVRAIBALE_ID = "id";

	public static final String URL_UPDATE_CARS_ID = "/cars/{id}";

	public static final String URL_CARS_BY_ID = "cars/{id}";

	public static final String URL_CARS = "/cars";
	
	public static final String OUT_OF_SERVICE = "out-of-service";
	
	public static final String IN_MAINTENANCE = "in-maintenance";
	
	public static final String AVAILABLE = "available";

	public static final String SAMPLE_RESPONSE = "{'id': 12345,'brand': 'Flexa','licensePlate': 'L-CS8877E','status': 'available','operationCity':'Frankfurt','manufacturer':'Volkswagen'}";
	
	public static final String SAMPLE_RESPONSE_ARRAY = "[{'id': 12345,'brand': 'Flexa','licensePlate': 'L-CS8877E','status': 'available','operationCity':'Frankfurt','manufacturer':'Volkswagen'},"
														+ "{'id': 12346,'brand': 'HeinerLiner','licensePlate': 'L-CS8878E','status': 'available','operationCity':'Darmstadt','manufacturer':'Volkswagen'}]";

}
