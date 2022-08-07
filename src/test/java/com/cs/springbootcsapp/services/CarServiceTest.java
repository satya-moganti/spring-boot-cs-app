package com.cs.springbootcsapp.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cs.springbootcsapp.jpa.model.CarEntity;
import com.cs.springbootcsapp.utils.Status;

@SpringBootTest
public class CarServiceTest {
	    @Mock
	    private CarService carService ;
	  
  
	  
	    @Test
	    void getCarDetails() {
	    	CarEntity carEntity= getMockCarEntity();
	        when(carService.getCarDetails(1)).thenReturn(carEntity);
	        assertEquals(carService.getCarDetails(1),carEntity);
	    }



		private CarEntity getMockCarEntity() {			
			return new CarEntity(1, "Flex", "L2x-4T67D", "VolksWagon", "Berlin", Status.AVAILABLE, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()));
		}			

}
