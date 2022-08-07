package com.cs.springbootcsapp.web;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.cs.springbootcsapp.jpa.model.CarEntity;
import com.cs.springbootcsapp.services.CarService;
import com.cs.springbootcsapp.utils.Status;
 
@ExtendWith(MockitoExtension.class)
public class CarControllerTest 
{
    @InjectMocks
    FleetController fleetController;
     
    @Mock
    CarService carService;
     
    @Test
    public void testRequestQuestion() 
    {
		CarEntity mockCarEntity= new CarEntity(1, "Flex", "L2x-4T67D", "VolksWagon", "Berlin", Status.AVAILABLE, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()));
         Integer inputId= 1;
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
         
        when(carService.getCarDetails(any(Integer.class))).thenReturn(mockCarEntity);

        ResponseEntity<CarEntity> responseEntity = fleetController.getCarById(inputId);
         
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);    }
     
 }
