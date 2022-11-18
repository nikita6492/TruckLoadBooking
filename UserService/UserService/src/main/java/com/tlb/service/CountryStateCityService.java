package com.tlb.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;


public interface CountryStateCityService {
	
	public Set<String> getCountries();
	
	public Set<String> getState(String country);
	
	public Set<String> getCity(String state);

}
