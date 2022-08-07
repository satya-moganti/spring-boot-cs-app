package com.cs.springbootcsapp.utils;
public enum Status {
    AVAILABLE("available"),
    IN_MAINTENENCE("in-maintenance"),
    OUT_OF_SERVICE("out-of-service");

    private final String strStatus;
    
    Status(String strStatus){
    	this.strStatus = strStatus;
    }

	public String getStrStatus() {
		return strStatus;
	}    
}