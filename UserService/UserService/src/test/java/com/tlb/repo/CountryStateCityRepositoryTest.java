package com.tlb.repo;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.tlb.entity.CountryStateCity;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace =AutoConfigureTestDatabase.Replace.NONE)
public class CountryStateCityRepositoryTest {

	@Autowired
	CountryStateCityRepository countryStateCityRepository;
	
	@Test
	public void testFindByCountry() {
		
		CountryStateCity csc =new CountryStateCity(1L, "India", "Madhya Pradesh", "Bhopal");
		countryStateCityRepository.save(csc);
		CountryStateCity csc1 =new CountryStateCity(2L, "Australia", "New South Wales", "Sydney");
		countryStateCityRepository.save(csc1);
		
		List<CountryStateCity> cscObj=countryStateCityRepository.findByCountry("Australia");
		Assertions.assertTrue(!cscObj.isEmpty());
		
	}
	
	@Test
	public void testFindByState() {
		CountryStateCity csc =new CountryStateCity(1L, "India", "Madhya Pradesh", "Bhopal");
		countryStateCityRepository.save(csc);
		CountryStateCity csc1 =new CountryStateCity(2L, "Australia", "New South Wales", "Sydney");
		countryStateCityRepository.save(csc1);
		
		List<CountryStateCity> cscObj=countryStateCityRepository.findByState("Madhya Pradesh");
		Assertions.assertTrue(!cscObj.isEmpty());
	}
}
