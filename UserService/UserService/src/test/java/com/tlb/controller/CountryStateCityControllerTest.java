package com.tlb.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.tlb.entity.CountryStateCity;
import com.tlb.entity.User;
import com.tlb.service.CountryStateCityServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CountryStateCityControllerTest {

	@InjectMocks
	CountryStateCityController countryStateCityController;
	
	@Mock
	CountryStateCityServiceImpl countryStateCityServiceImpl;
	
	@Test
	public void testGetCountries() {
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        CountryStateCity csc =new CountryStateCity(1L, "India", "Maharashtra", "Pune");
        CountryStateCity csc2 =new CountryStateCity(1L, "Australia", "New South Wales", "Sydney");
       List<CountryStateCity> list =new ArrayList<CountryStateCity>();
       list.add(csc);
       list.add(csc2);
       Set<String> set=list.stream().map(s->s.getCountry()).collect(Collectors.toSet());
        when(countryStateCityServiceImpl.getCountries()).thenReturn(set);
         
        
        Set<String> obj = countryStateCityController.getCountries();
        assertTrue(obj.size()>0);
	}
	
	@Test
	public void testGetState() {
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        CountryStateCity csc =new CountryStateCity(1L, "India", "Maharashtra", "Pune");
        CountryStateCity csc2 =new CountryStateCity(1L, "Australia", "New South Wales", "Sydney");
       List<CountryStateCity> list =new ArrayList<CountryStateCity>();
       list.add(csc);
       list.add(csc2);
       Set<String> set=list.stream().map(s->s.getState()).collect(Collectors.toSet());
        when(countryStateCityServiceImpl.getState(any(String.class))).thenReturn(set);
         
        
        Set<String> obj = countryStateCityController.getStates("India");
        assertTrue(obj.size()>0);
	}
	
	@Test
	public void testGetCities() {
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        CountryStateCity csc =new CountryStateCity(1L, "India", "Maharashtra", "Pune");
        CountryStateCity csc2 =new CountryStateCity(1L, "Australia", "New South Wales", "Sydney");
       List<CountryStateCity> list =new ArrayList<CountryStateCity>();
       list.add(csc);
       list.add(csc2);
       Set<String> set=list.stream().map(s->s.getCity()).collect(Collectors.toSet());
        when(countryStateCityServiceImpl.getCity(any(String.class))).thenReturn(set);
         
        
        Set<String> obj = countryStateCityController.getCities("Maharashtra");
        assertTrue(obj.size()>0);
	}
}
