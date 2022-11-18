package com.tlb.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tlb.service.CountryStateCityService;
import com.tlb.service.CountryStateCityServiceImpl;

@RestController
@CrossOrigin(origins="*")
public class CountryStateCityController {

	@Autowired
	private CountryStateCityService countryStateCityService;
	
	@GetMapping("api/v1/tlb/getCountries")
	public Set<String> getCountries(){
		return countryStateCityService.getCountries();
	}
	
	
	@GetMapping("api/v1/tlb/getStates/{country}")
	public Set<String> getStates(@PathVariable("country") String country){
		return countryStateCityService.getState(country);
	}
	
	@GetMapping("api/v1/tlb/getCities/{state}")
	public Set<String> getCities(@PathVariable("state") String state){
		return countryStateCityService.getCity(state);
	}
}
