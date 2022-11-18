package com.tlb.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tlb.entity.CountryStateCity;

@Repository
public interface CountryStateCityRepository extends JpaRepository<CountryStateCity, Long> {
	
	
	public List<CountryStateCity> findByCountry(String country);
	
	public List<CountryStateCity> findByState(String state);
}
