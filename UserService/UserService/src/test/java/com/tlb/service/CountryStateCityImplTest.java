package com.tlb.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.tlb.entity.CountryStateCity;
import com.tlb.repo.CountryStateCityRepository;

@ExtendWith(MockitoExtension.class)
public class CountryStateCityImplTest {

	@InjectMocks
	CountryStateCityServiceImpl countryStateCityServiceImpl;
	
	@Mock
	CountryStateCityRepository countryStateCityRepository;
	

	@BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }
	
	@Test
	public void testGetCountries() {
		List<CountryStateCity> list=new ArrayList<>();
		CountryStateCity csc =new CountryStateCity(1L, "India", "Madhya Pradesh", "Bhopal");
		CountryStateCity csc1 =new CountryStateCity(2L, "Australia", "New South Wales", "Sydney");
		list.add(csc);
		list.add(csc1);
		
		when(countryStateCityRepository.findAll()).thenReturn(list);
		
		Set<String> cscList =countryStateCityServiceImpl.getCountries();
		
		Assertions.assertEquals(2,cscList.size());
		verify(countryStateCityRepository,times(1)).findAll();
	}
	
	@Test
	public void testGetState() {
		List<CountryStateCity> list=new ArrayList<>();
		CountryStateCity csc =new CountryStateCity(1L, "India", "Madhya Pradesh", "Bhopal");
		CountryStateCity csc1 =new CountryStateCity(2L, "Australia", "New South Wales", "Sydney");
		list.add(csc);
		list.add(csc1);
		
		when(countryStateCityRepository.findByCountry("India")).thenReturn(list.stream().filter(s->s.getCountry().equalsIgnoreCase("India")).collect(Collectors.toList()));
		
		Set<String> cscList =countryStateCityServiceImpl.getState("India");
		
		Assertions.assertEquals(1,cscList.size());
		verify(countryStateCityRepository,times(1)).findByCountry("India");
	}
	
	@Test
	public void testGetCities() {
		List<CountryStateCity> list=new ArrayList<>();
		CountryStateCity csc =new CountryStateCity(1L, "India", "Madhya Pradesh", "Bhopal");
		CountryStateCity csc1 =new CountryStateCity(2L, "Australia", "New South Wales", "Sydney");
		list.add(csc);
		list.add(csc1);
		
		when(countryStateCityRepository.findByState("Madhya Pradesh")).thenReturn(list.stream().filter(s->s.getState().equalsIgnoreCase("Madhya Pradesh")).collect(Collectors.toList()));
		
		
		
		Set<String> cscList =countryStateCityServiceImpl.getCity("Madhya Pradesh");
		
		Assertions.assertEquals(1,cscList.size());
		verify(countryStateCityRepository,times(1)).findByState("Madhya Pradesh");
	}
}
