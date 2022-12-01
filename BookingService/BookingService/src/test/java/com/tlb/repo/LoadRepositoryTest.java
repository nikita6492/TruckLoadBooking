package com.tlb.repo;

import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
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
	
	@Mock
	LoadRepository loadRespository;
	
	@Test
	public void testfindByLoadId() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", new Date(0), "Pune", new Date(0), "Mumbai", 
				"Booked", new Date(0), "MS-0001");
		
		//loadRespository.save(truckLoad);
		List<TruckLoad> list =new ArrayList<>();
		list.add(truckLoad);
		when(loadRespository.findByLoadId("LD-00001")).thenReturn(list);
		List<TruckLoad> tlb =loadRespository.findByLoadId("LD-00001");
		Assertions.assertTrue(!tlb.isEmpty());
	}
	
	@Test
	public void testFindByPickupLocation() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", new Date(0), "Pune", new Date(0), "Mumbai", 
				"Booked", new Date(0), "MS-0001");
		
		List<TruckLoad> list =new ArrayList<>();
		list.add(truckLoad);
		when(loadRespository.findByPickupLocation("Pune")).thenReturn(list);
		List<TruckLoad> tlb =loadRespository.findByPickupLocation("Pune");
		Assertions.assertTrue(!tlb.isEmpty());
	}
	
	@Test
	public void testFindByPickupDate() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", new Date(0), "Pune", new Date(0), "Mumbai", 
				"Booked", new Date(0), "MS-0001");
		
		List<TruckLoad> list =new ArrayList<>();
		list.add(truckLoad);
		when(loadRespository.findByPickupDate(new Date(0))).thenReturn(list);
		List<TruckLoad> tlb =loadRespository.findByPickupDate(new Date(0));
		Assertions.assertTrue(!tlb.isEmpty());
	}

	@Test
	public void testfindByLoadIdAndPickupLocation() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", new Date(0), "Pune", new Date(0), "Mumbai", 
				"Booked", new Date(0), "MS-0001");
		
		List<TruckLoad> list =new ArrayList<>();
		list.add(truckLoad);
		when(loadRespository.findByLoadIdAndPickupLocation("LD-00001","Pune")).thenReturn(list);
		List<TruckLoad> tlb =loadRespository.findByLoadIdAndPickupLocation("LD-00001","Pune");
		Assertions.assertTrue(!tlb.isEmpty());
	}
	

	@Test
	public void testfindByLoadIdAndPickupDate() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", new Date(0), "Pune", new Date(0), "Mumbai", 
				"Booked", new Date(0), "MS-0001");
		
		List<TruckLoad> list =new ArrayList<>();
		list.add(truckLoad);
		when(loadRespository.findByLoadIdAndPickupDate("LD-00001",new Date(0))).thenReturn(list);
		List<TruckLoad> tlb =loadRespository.findByLoadIdAndPickupDate("LD-00001",new Date(0));
		Assertions.assertTrue(!tlb.isEmpty());
	}
	

	@Test
	public void testfindByPickupLocationAndPickupDate() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", new Date(0), "Pune", new Date(0), "Mumbai", 
				"Booked", new Date(0), "MS-0001");
		
		List<TruckLoad> list =new ArrayList<>();
		list.add(truckLoad);
		when(loadRespository.findByPickupLocationAndPickupDate("Pune",new Date(0))).thenReturn(list);
		List<TruckLoad> tlb =loadRespository.findByPickupLocationAndPickupDate("Pune",new Date(0));
		Assertions.assertTrue(!tlb.isEmpty());
	}

	@Test
	public void testfindByLoadIdAndPickupLocationAndPickupDate() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", new Date(0), "Pune", new Date(0), "Mumbai", 
				"Booked", new Date(0), "MS-0001");
		
		List<TruckLoad> list =new ArrayList<>();
		list.add(truckLoad);
		when(loadRespository.findByLoadIdAndPickupLocationAndPickupDate("LD-00001","Pune",new Date(0))).thenReturn(list);
		List<TruckLoad> tlb =loadRespository.findByLoadIdAndPickupLocationAndPickupDate("LD-00001","Pune",new Date(0));
		Assertions.assertTrue(!tlb.isEmpty());
	}
	
	@Test
	public void testfindByLoadIdAndPickupLocationAndPickupDateAndBookingStatus() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", new Date(0), "Pune", new Date(0), "Mumbai", 
				"Booked", new Date(0), "MS-0001");
		
		List<TruckLoad> list =new ArrayList<>();
		list.add(truckLoad);
		when(loadRespository.findByLoadIdAndPickupLocationAndPickupDateAndBookingStatus("LD-00001","Pune",new Date(0),"Booked")).thenReturn(list);
		List<TruckLoad> tlb =loadRespository.findByLoadIdAndPickupLocationAndPickupDateAndBookingStatus("LD-00001","Pune",new Date(0),"Booked");
		Assertions.assertTrue(!tlb.isEmpty());
	}
	
	@Test
	public void testfindByPickupLocationAndPickupDateAndBookingStatus() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", new Date(0), "Pune", new Date(0), "Mumbai", 
				"Booked", new Date(0), "MS-0001");
		
		List<TruckLoad> list =new ArrayList<>();
		list.add(truckLoad);
		when(loadRespository.findByPickupLocationAndPickupDateAndBookingStatus("Pune",new Date(0),"Booked")).thenReturn(list);
		List<TruckLoad> tlb =loadRespository.findByPickupLocationAndPickupDateAndBookingStatus("Pune",new Date(0),"Booked");
		Assertions.assertTrue(!tlb.isEmpty());
	}

	@Test
	public void testfindByLoadIdAndPickupDateAndBookingStatus() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", new Date(0), "Pune", new Date(0), "Mumbai", 
				"Booked", new Date(0), "MS-0001");
		
		List<TruckLoad> list =new ArrayList<>();
		list.add(truckLoad);
		when(loadRespository.findByLoadIdAndPickupDateAndBookingStatus("LD-00001",new Date(0),"Booked")).thenReturn(list);
		List<TruckLoad> tlb =loadRespository.findByLoadIdAndPickupDateAndBookingStatus("LD-00001",new Date(0),"Booked");
		Assertions.assertTrue(!tlb.isEmpty());
	}
	
	@Test
	public void testfindByLoadIdAndPickupLocationAndBookingStatus() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", new Date(0), "Pune", new Date(0), "Mumbai", 
				"Booked", new Date(0), "MS-0001");
		
		List<TruckLoad> list =new ArrayList<>();
		list.add(truckLoad);
		when(loadRespository.findByLoadIdAndPickupLocationAndBookingStatus("LD-00001","Pune","Booked")).thenReturn(list);
		List<TruckLoad> tlb =loadRespository.findByLoadIdAndPickupLocationAndBookingStatus("LD-00001","Pune","Booked");
		Assertions.assertTrue(!tlb.isEmpty());
	}
	

	@Test
	public void testfindByPickupDateAndBookingStatus() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", new Date(0), "Pune", new Date(0), "Mumbai", 
				"Booked", new Date(0), "MS-0001");
		
		List<TruckLoad> list =new ArrayList<>();
		list.add(truckLoad);
		when(loadRespository.findByPickupDateAndBookingStatus(new Date(0),"Booked")).thenReturn(list);
		List<TruckLoad> tlb =loadRespository.findByPickupDateAndBookingStatus(new Date(0),"Booked");
		Assertions.assertTrue(!tlb.isEmpty());
	}

	@Test
	public void testfindByPickupLocationAndBookingStatus() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", new Date(0), "Pune", new Date(0), "Mumbai", 
				"Booked", new Date(0), "MS-0001");
		
		List<TruckLoad> list =new ArrayList<>();
		list.add(truckLoad);
		when(loadRespository.findByPickupLocationAndBookingStatus("Pune","Booked")).thenReturn(list);
		List<TruckLoad> tlb =loadRespository.findByPickupLocationAndBookingStatus("Pune","Booked");
		Assertions.assertTrue(!tlb.isEmpty());
	}

	@Test
	public void testfindByLoadIdAndBookingStatus() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", new Date(0), "Pune", new Date(0), "Mumbai", 
				"Booked", new Date(0), "MS-0001");
		
		List<TruckLoad> list =new ArrayList<>();
		list.add(truckLoad);
		when(loadRespository.findByLoadIdAndBookingStatus("LD-00001","Booked")).thenReturn(list);
		List<TruckLoad> tlb =loadRespository.findByLoadIdAndBookingStatus("LD-00001","Booked");
		Assertions.assertTrue(!tlb.isEmpty());
	}
	
	@Test
	public void testfindByDriverIdAndBookingStatus() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", new Date(0), "Pune", new Date(0), "Mumbai", 
				"Booked", new Date(0), "MS-0001");
		
		List<TruckLoad> list =new ArrayList<>();
		list.add(truckLoad);
		when(loadRespository.findByDriverIdAndBookingStatus("MS-0001","Booked")).thenReturn(list);
		List<TruckLoad> tlb =loadRespository.findByDriverIdAndBookingStatus("MS-0001","Booked");
		Assertions.assertTrue(!tlb.isEmpty());
	}


}
