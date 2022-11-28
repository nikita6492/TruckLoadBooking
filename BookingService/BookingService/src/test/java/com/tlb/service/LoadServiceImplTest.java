package com.tlb.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.tlb.entity.TruckLoad;
import com.tlb.entity.User;
import com.tlb.repo.LoadRepository;

@ExtendWith(MockitoExtension.class)
public class LoadServiceImplTest {

	@InjectMocks
	LoadServiceImpl loadServiceImpl;
	
	@Mock
	LoadRepository loadRepository;
	
	@BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

	
	@Test
	public void testCreateLoad() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"Booked", LocalDate.now(), "MS-0001");
		loadServiceImpl.createLoad(truckLoad);
		verify(loadRepository,times(1)).save(truckLoad);
	}
	
	@Test
	public void testSearchLoadByLoadId() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"Booked", LocalDate.now(), "MS-0001");
		List<TruckLoad> list =new ArrayList<>();
		list.add(truckLoad);
		when(loadRepository.findByLoadId("LD-00001")).thenReturn(list);
		List<TruckLoad> obj=loadServiceImpl.searchLoadByLoadId("LD-00001");
		Assertions.assertEquals(obj.get(0).getItemType(), list.get(0).getItemType());
		verify(loadRepository,times(1)).findByLoadId("LD-00001");
	}
	
	@Test
	public void testsearchLoadByPickUpLocation() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"Booked", LocalDate.now(), "MS-0001");
		List<TruckLoad> list =new ArrayList<>();
		list.add(truckLoad);
		when(loadRepository.findByPickupLocation("Pune")).thenReturn(list);
		List<TruckLoad> obj=loadServiceImpl.searchLoadByPickUpLocation("Pune");
		Assertions.assertEquals(obj.get(0).getItemType(), list.get(0).getItemType());
		verify(loadRepository,times(1)).findByPickupLocation("Pune");
	}
	
	@Test
	public void testsearchLoadByPickUpDate() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"Booked", LocalDate.now(), "MS-0001");
		List<TruckLoad> list =new ArrayList<>();
		list.add(truckLoad);
		when(loadRepository.findByPickupDate(LocalDate.now())).thenReturn(list);
		List<TruckLoad> obj=loadServiceImpl.searchLoadByPickUpDate(LocalDate.now());
		Assertions.assertEquals(obj.get(0).getItemType(), list.get(0).getItemType());
		verify(loadRepository,times(1)).findByPickupDate(LocalDate.now());
	}
	
	
	@Test
	public void testsearchLoadByLoadIdAndPickUpLocation() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"Booked", LocalDate.now(), "MS-0001");
		List<TruckLoad> list =new ArrayList<>();
		list.add(truckLoad);
		when(loadRepository.findByLoadIdAndPickupLocation("LD-00001","Pune")).thenReturn(list);
		List<TruckLoad> obj=loadServiceImpl.searchLoadByLoadIdAndPickUpLocation("LD-00001","Pune");
		Assertions.assertEquals(obj.get(0).getItemType(), list.get(0).getItemType());
		verify(loadRepository,times(1)).findByLoadIdAndPickupLocation("LD-00001", "Pune");
	}
	
	@Test
	public void testsearchLoadByLoadIdAndPickUpDate() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"Booked", LocalDate.now(), "MS-0001");
		List<TruckLoad> list =new ArrayList<>();
		list.add(truckLoad);
		when(loadRepository.findByLoadIdAndPickupDate("LD-00001",LocalDate.now())).thenReturn(list);
		List<TruckLoad> obj=loadServiceImpl.searchLoadByLoadIdAndPickUpDate("LD-00001",LocalDate.now());
		Assertions.assertEquals(obj.get(0).getItemType(), list.get(0).getItemType());
		verify(loadRepository,times(1)).findByLoadIdAndPickupDate("LD-00001",LocalDate.now());
	}
	
	@Test
	public void testsearchLoadByPickUpLocationAndPickUpDate() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"Booked", LocalDate.now(), "MS-0001");
		List<TruckLoad> list =new ArrayList<>();
		list.add(truckLoad);
		when(loadRepository.findByPickupLocationAndPickupDate("Pune",LocalDate.now())).thenReturn(list);
		List<TruckLoad> obj=loadServiceImpl.searchLoadByPickUpLocationAndPickUpDate("Pune",LocalDate.now());
		Assertions.assertEquals(obj.get(0).getItemType(), list.get(0).getItemType());
		verify(loadRepository,times(1)).findByPickupLocationAndPickupDate("Pune", LocalDate.now());
	}
	
	@Test
	public void testsearchLoadByLoadIdAndPickUpLocationAndPickUpDate() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"Booked", LocalDate.now(), "MS-0001");
		List<TruckLoad> list =new ArrayList<>();
		list.add(truckLoad);
		when(loadRepository.findByLoadIdAndPickupLocationAndPickupDate("LD-00001","Pune",LocalDate.now())).thenReturn(list);
		List<TruckLoad> obj=loadServiceImpl.searchLoadByLoadIdAndPickUpLocationAndPickUpDate("LD-00001","Pune",LocalDate.now());
		Assertions.assertEquals(obj.get(0).getItemType(), list.get(0).getItemType());
		verify(loadRepository,times(1)).findByLoadIdAndPickupLocationAndPickupDate("LD-00001", "Pune", LocalDate.now());
	}
	
	@Test
	public void testviewAllLoads() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"Booked", LocalDate.now(), "MS-0001");
		List<TruckLoad> list =new ArrayList<>();
		list.add(truckLoad);
		when(loadRepository.findAll()).thenReturn(list);
		List<TruckLoad> obj=loadServiceImpl.viewAllLoads();
		Assertions.assertTrue(!obj.isEmpty());
		verify(loadRepository,times(1)).findAll();
	}
	
	
	@Test
	public void testbookLoad() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"Booked", LocalDate.now(), "MS-0001");
		List<TruckLoad> list =new ArrayList<>();
		list.add(truckLoad);
		Optional<TruckLoad> tlb=Optional.of(truckLoad);
		
		when(loadRepository.findById("LD-00001")).thenReturn(tlb);
		TruckLoad obj=loadServiceImpl.bookLoad("LD-00001", "MS-0001");
		verify(loadRepository,times(1)).findById("LD-00001");
		verify(loadRepository,times(1)).save(truckLoad);
	}
	
	
	@Test
	public void testintransitLoad() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"InTransit", LocalDate.now(), "MS-0001");
		List<TruckLoad> list =new ArrayList<>();
		list.add(truckLoad);
		Optional<TruckLoad> tlb=Optional.of(truckLoad);
		
		when(loadRepository.findById("LD-00001")).thenReturn(tlb);
		TruckLoad obj=loadServiceImpl.intransitLoad("LD-00001", "MS-0001");
		verify(loadRepository,times(1)).findById("LD-00001");
		verify(loadRepository,times(1)).save(truckLoad);
	}
	
	
	@Test
	public void testcompleteLoad() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"Completed", LocalDate.now(), "MS-0001");
		List<TruckLoad> list =new ArrayList<>();
		list.add(truckLoad);
		Optional<TruckLoad> tlb=Optional.of(truckLoad);
		
		when(loadRepository.findById("LD-00001")).thenReturn(tlb);
		TruckLoad obj=loadServiceImpl.completeLoad("LD-00001", "MS-0001");
		verify(loadRepository,times(1)).findById("LD-00001");
		verify(loadRepository,times(1)).save(truckLoad);
	}
	
	@Test
	public void testcancelLoad() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"Cancelled", LocalDate.now(), "MS-0001");
		List<TruckLoad> list =new ArrayList<>();
		list.add(truckLoad);
		Optional<TruckLoad> tlb=Optional.of(truckLoad);
		
		when(loadRepository.findById("LD-00001")).thenReturn(tlb);
		TruckLoad obj=loadServiceImpl.cancelLoad("LD-00001");
		verify(loadRepository,times(1)).findById("LD-00001");
		verify(loadRepository,times(1)).save(truckLoad);
	}
	
	@Test
	public void testSearchLoadByLoadIdAndBookingStatus() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"Booked", LocalDate.now(), "MS-0001");
		List<TruckLoad> list =new ArrayList<>();
		list.add(truckLoad);
		when(loadRepository.findByLoadIdAndBookingStatus("LD-00001","Booked")).thenReturn(list);
		List<TruckLoad> obj=loadServiceImpl.searchLoadByLoadIdAndBookingStatus("LD-00001","Booked");
		Assertions.assertEquals(obj.get(0).getItemType(), list.get(0).getItemType());
		verify(loadRepository,times(1)).findByLoadIdAndBookingStatus("LD-00001","Booked");
	}
	
	@Test
	public void testsearchLoadByPickUpLocationAndBookingStatus() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"Booked", LocalDate.now(), "MS-0001");
		List<TruckLoad> list =new ArrayList<>();
		list.add(truckLoad);
		when(loadRepository.findByPickupLocationAndBookingStatus("Pune","Booked")).thenReturn(list);
		List<TruckLoad> obj=loadServiceImpl.searchLoadByPickUpLocationAndBookingStatus("Pune","Booked");
		Assertions.assertEquals(obj.get(0).getItemType(), list.get(0).getItemType());
		verify(loadRepository,times(1)).findByPickupLocationAndBookingStatus("Pune","Booked");
	}
	
	@Test
	public void testsearchLoadByPickUpDateAndBookingStatus() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"Booked", LocalDate.now(), "MS-0001");
		List<TruckLoad> list =new ArrayList<>();
		list.add(truckLoad);
		when(loadRepository.findByPickupDateAndBookingStatus(LocalDate.now(),"Booked")).thenReturn(list);
		List<TruckLoad> obj=loadServiceImpl.searchLoadByPickUpDateAndBookingStatus(LocalDate.now(),"Booked");
		Assertions.assertEquals(obj.get(0).getItemType(), list.get(0).getItemType());
		verify(loadRepository,times(1)).findByPickupDateAndBookingStatus(LocalDate.now(),"Booked");
	}
	
	
	@Test
	public void testsearchLoadByLoadIdAndPickUpLocationAndBookingStatus() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"Booked", LocalDate.now(), "MS-0001");
		List<TruckLoad> list =new ArrayList<>();
		list.add(truckLoad);
		when(loadRepository.findByLoadIdAndPickupLocationAndBookingStatus("LD-00001","Pune","Booked")).thenReturn(list);
		List<TruckLoad> obj=loadServiceImpl.searchLoadByLoadIdAndPickUpLocationAndBookingStatus("LD-00001","Pune","Booked");
		Assertions.assertEquals(obj.get(0).getItemType(), list.get(0).getItemType());
		verify(loadRepository,times(1)).findByLoadIdAndPickupLocationAndBookingStatus("LD-00001", "Pune","Booked");
	}
	
	@Test
	public void testsearchLoadByLoadIdAndPickUpDateAndBookingStatus() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"Booked", LocalDate.now(), "MS-0001");
		List<TruckLoad> list =new ArrayList<>();
		list.add(truckLoad);
		when(loadRepository.findByLoadIdAndPickupDateAndBookingStatus("LD-00001",LocalDate.now(),"Booked")).thenReturn(list);
		List<TruckLoad> obj=loadServiceImpl.searchLoadByLoadIdAndPickUpDateAndBookingStatus("LD-00001",LocalDate.now(),"Booked");
		Assertions.assertEquals(obj.get(0).getItemType(), list.get(0).getItemType());
		verify(loadRepository,times(1)).findByLoadIdAndPickupDateAndBookingStatus("LD-00001",LocalDate.now(),"Booked");
	}
	
	@Test
	public void testsearchLoadByPickUpLocationAndPickUpDateAndBookingStatus() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"Booked", LocalDate.now(), "MS-0001");
		List<TruckLoad> list =new ArrayList<>();
		list.add(truckLoad);
		when(loadRepository.findByPickupLocationAndPickupDateAndBookingStatus("Pune",LocalDate.now(),"Booked")).thenReturn(list);
		List<TruckLoad> obj=loadServiceImpl.searchLoadByPickUpLocationAndPickUpDateAndBookingStatus("Pune",LocalDate.now(),"Booked");
		Assertions.assertEquals(obj.get(0).getItemType(), list.get(0).getItemType());
		verify(loadRepository,times(1)).findByPickupLocationAndPickupDateAndBookingStatus("Pune", LocalDate.now(),"Booked");
	}
	
	@Test
	public void testsearchLoadByLoadIdAndPickUpLocationAndPickUpDateAndBookingStatus() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"Booked", LocalDate.now(), "MS-0001");
		List<TruckLoad> list =new ArrayList<>();
		list.add(truckLoad);
		when(loadRepository.findByLoadIdAndPickupLocationAndPickupDateAndBookingStatus("LD-00001","Pune",LocalDate.now(),"Booked")).thenReturn(list);
		List<TruckLoad> obj=loadServiceImpl.searchLoadByLoadIdAndPickUpLocationAndPickUpDateAndBookingStatus("LD-00001","Pune",LocalDate.now(),"Booked");
		Assertions.assertEquals(obj.get(0).getItemType(), list.get(0).getItemType());
		verify(loadRepository,times(1)).findByLoadIdAndPickupLocationAndPickupDateAndBookingStatus("LD-00001", "Pune", LocalDate.now(),"Booked");
	}
	
	@Test
	public void testviewBookedLoads() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"Booked", LocalDate.now(), "MS-0001");
		List<TruckLoad> list =new ArrayList<>();
		list.add(truckLoad);
		when(loadRepository.findByDriverIdAndBookingStatus("MS-0001","Booked")).thenReturn(list);
		List<TruckLoad> obj=loadServiceImpl.viewBookedLoads("MS-0001");
		Assertions.assertTrue(!obj.isEmpty());
		verify(loadRepository,times(1)).findByDriverIdAndBookingStatus("MS-0001", "Booked");
	}
	
	@Test
	public void testviewInTransitLoads() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"InTransit", LocalDate.now(), "MS-0001");
		List<TruckLoad> list =new ArrayList<>();
		list.add(truckLoad);
		when(loadRepository.findByDriverIdAndBookingStatus("MS-0001","InTransit")).thenReturn(list);
		List<TruckLoad> obj=loadServiceImpl.viewInTransitLoads("MS-0001");
		Assertions.assertTrue(!obj.isEmpty());
		verify(loadRepository,times(1)).findByDriverIdAndBookingStatus("MS-0001", "InTransit");
	}
	
	@Test
	public void testviewCompletedLoads() {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"Completed", LocalDate.now(), "MS-0001");
		List<TruckLoad> list =new ArrayList<>();
		list.add(truckLoad);
		when(loadRepository.findByDriverIdAndBookingStatus("MS-0001","Completed")).thenReturn(list);
		List<TruckLoad> obj=loadServiceImpl.viewCompletedLoads("MS-0001");
		Assertions.assertTrue(!obj.isEmpty());
		verify(loadRepository,times(1)).findByDriverIdAndBookingStatus("MS-0001", "Completed");
	}
}
