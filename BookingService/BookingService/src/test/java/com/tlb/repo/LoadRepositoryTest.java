package com.tlb.repo;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.tlb.entity.TruckLoad;
import com.tlb.repo.LoadRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace =AutoConfigureTestDatabase.Replace.NONE)
public class LoadRepositoryTest {
	
	@Autowired
	LoadRepository loadRespository;
	
	@Test
	public void testfindByLoadId() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"Booked", LocalDate.now(), "MS-0001");
		
		loadRespository.save(truckLoad);
		List<TruckLoad> tlb =loadRespository.findByLoadId("LD-00001");
		Assertions.assertTrue(!tlb.isEmpty());
	}
	
	@Test
	public void testFindByPickupLocation() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"Booked", LocalDate.now(), "MS-0001");
		
		loadRespository.save(truckLoad);
		List<TruckLoad> tlb =loadRespository.findByPickupLocation("Pune");
		Assertions.assertTrue(!tlb.isEmpty());
	}
	
	@Test
	public void testFindByPickupDate() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"Booked", LocalDate.now(), "MS-0001");
		
		loadRespository.save(truckLoad);
		List<TruckLoad> tlb =loadRespository.findByPickupDate(LocalDate.now());
		Assertions.assertTrue(!tlb.isEmpty());
	}

	@Test
	public void testfindByLoadIdAndPickupLocation() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"Booked", LocalDate.now(), "MS-0001");
		
		loadRespository.save(truckLoad);
		List<TruckLoad> tlb =loadRespository.findByLoadIdAndPickupLocation("LD-00001","Pune");
		Assertions.assertTrue(!tlb.isEmpty());
	}
	

	@Test
	public void testfindByLoadIdAndPickupDate() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"Booked", LocalDate.now(), "MS-0001");
		
		loadRespository.save(truckLoad);
		List<TruckLoad> tlb =loadRespository.findByLoadIdAndPickupDate("LD-00001",LocalDate.now());
		Assertions.assertTrue(!tlb.isEmpty());
	}
	

	@Test
	public void testfindByPickupLocationAndPickupDate() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"Booked", LocalDate.now(), "MS-0001");
		
		loadRespository.save(truckLoad);
		List<TruckLoad> tlb =loadRespository.findByPickupLocationAndPickupDate("Pune",LocalDate.now());
		Assertions.assertTrue(!tlb.isEmpty());
	}

	@Test
	public void testfindByLoadIdAndPickupLocationAndPickupDate() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"Booked", LocalDate.now(), "MS-0001");
		
		loadRespository.save(truckLoad);
		List<TruckLoad> tlb =loadRespository.findByLoadIdAndPickupLocationAndPickupDate("LD-00001","Pune",LocalDate.now());
		Assertions.assertTrue(!tlb.isEmpty());
	}
	
	@Test
	public void testfindByLoadIdAndPickupLocationAndPickupDateAndBookingStatus() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"Booked", LocalDate.now(), "MS-0001");
		
		loadRespository.save(truckLoad);
		List<TruckLoad> tlb =loadRespository.findByLoadIdAndPickupLocationAndPickupDateAndBookingStatus("LD-00001","Pune",LocalDate.now(),"Booked");
		Assertions.assertTrue(!tlb.isEmpty());
	}
	
	@Test
	public void testfindByPickupLocationAndPickupDateAndBookingStatus() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"Booked", LocalDate.now(), "MS-0001");
		
		loadRespository.save(truckLoad);
		List<TruckLoad> tlb =loadRespository.findByPickupLocationAndPickupDateAndBookingStatus("Pune",LocalDate.now(),"Booked");
		Assertions.assertTrue(!tlb.isEmpty());
	}

	@Test
	public void testfindByLoadIdAndPickupDateAndBookingStatus() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"Booked", LocalDate.now(), "MS-0001");
		
		loadRespository.save(truckLoad);
		List<TruckLoad> tlb =loadRespository.findByLoadIdAndPickupDateAndBookingStatus("LD-00001",LocalDate.now(),"Booked");
		Assertions.assertTrue(!tlb.isEmpty());
	}
	
	@Test
	public void testfindByLoadIdAndPickupLocationAndBookingStatus() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"Booked", LocalDate.now(), "MS-0001");
		
		loadRespository.save(truckLoad);
		List<TruckLoad> tlb =loadRespository.findByLoadIdAndPickupLocationAndBookingStatus("LD-00001","Pune","Booked");
		Assertions.assertTrue(!tlb.isEmpty());
	}
	

	@Test
	public void testfindByPickupDateAndBookingStatus() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"Booked", LocalDate.now(), "MS-0001");
		
		loadRespository.save(truckLoad);
		List<TruckLoad> tlb =loadRespository.findByPickupDateAndBookingStatus(LocalDate.now(),"Booked");
		Assertions.assertTrue(!tlb.isEmpty());
	}

	@Test
	public void testfindByPickupLocationAndBookingStatus() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"Booked", LocalDate.now(), "MS-0001");
		
		loadRespository.save(truckLoad);
		List<TruckLoad> tlb =loadRespository.findByPickupLocationAndBookingStatus("Pune","Booked");
		Assertions.assertTrue(!tlb.isEmpty());
	}

	@Test
	public void testfindByLoadIdAndBookingStatus() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"Booked", LocalDate.now(), "MS-0001");
		
		loadRespository.save(truckLoad);
		List<TruckLoad> tlb =loadRespository.findByLoadIdAndBookingStatus("LD-00001","Booked");
		Assertions.assertTrue(!tlb.isEmpty());
	}
	
	@Test
	public void testfindByDriverIdAndBookingStatus() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"Booked", LocalDate.now(), "MS-0001");
		
		loadRespository.save(truckLoad);
		List<TruckLoad> tlb =loadRespository.findByDriverIdAndBookingStatus("MS-0001","Booked");
		Assertions.assertTrue(!tlb.isEmpty());
	}


}
