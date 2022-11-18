package com.tlb.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tlb.entity.CountryStateCity;
import com.tlb.repo.CountryStateCityRepository;

@Service
public class CountryStateCityServiceImpl implements CountryStateCityService{
	
	@Autowired
	private CountryStateCityRepository countryStateCityRepository;

	@Override
	public Set<String> getCountries() {
		List<CountryStateCity> csc= countryStateCityRepository.findAll();
		Set<String> list=csc.stream().map(s->s.getCountry()).collect(Collectors.toSet());
		return list;
		
	}

	@Override
	public Set<String> getState(String country) {
		List<CountryStateCity> csc= countryStateCityRepository.findByCountry(country);
		Set<String> list=csc.stream().map(s->s.getState()).collect(Collectors.toSet());
		return list;
	}

	@Override
	public Set<String> getCity(String state) {
		List<CountryStateCity> csc= countryStateCityRepository.findByState(state);
		Set<String> list=csc.stream().map(s->s.getCity()).collect(Collectors.toSet());
		return list;
		
	}

}
