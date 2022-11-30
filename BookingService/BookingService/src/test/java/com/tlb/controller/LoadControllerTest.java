package com.tlb.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.tlb.entity.TruckLoad;
import com.tlb.entity.User;
import com.tlb.service.LoadServiceImpl;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class LoadControllerTest {
	
	@InjectMocks
	LoadController loadController;
	
	@Mock
	LoadServiceImpl loadService;
	
	 @Mock
	 RestTemplate restTemplate;
	
	@Test
	public void testCreateLoad() throws Exception {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"Booked", LocalDate.now(), "MS-0001");
		
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        when(loadService.createLoad(any(TruckLoad.class))).thenReturn(truckLoad);
         
        
        ResponseEntity<?> responseEntity = loadController.createLoad(truckLoad);
         assertEquals(responseEntity.getStatusCode(),HttpStatus.OK);
	}

	@Test
	public void testCancelLoad() throws Exception {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"Cancelled", LocalDate.now(), "MS-0001");
		
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        when(loadService.cancelLoad(any(String.class))).thenReturn(truckLoad);
         
        
        ResponseEntity<?> responseEntity = loadController.cancelLoad("LD-00001");
         assertEquals(responseEntity.getStatusCode(),HttpStatus.OK);
	}
	
	@Test
	public void testBookLoad() throws Exception {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"Booked", LocalDate.now(), "MS-0001");
		User user = new User("MS-001", "Mark", "Smith", "Test12345@", "test@gmail.com", LocalDate.now(), 
				"Admin", "1234567896", "ABCDEFGHT123", LocalDate.now(), 22L, "Australia", "New South Wales", "Sydney");
		ResponseEntity<User> entity=new ResponseEntity<User>(user,HttpStatus.OK);
		ParameterizedTypeReference<User> typeRef = new ParameterizedTypeReference<User>() {
		};
        Mockito.when(restTemplate.exchange("http://localhost:8090/api/v1/tlb/fetchDriverId/test@gmail.com", HttpMethod.GET, null, typeRef)).thenReturn(entity);
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        when(loadService.bookLoad(any(String.class), any(String.class))).thenReturn(truckLoad);
         
        
        ResponseEntity<?> responseEntity = loadController.bookLoad("LD-00001","test@gmail.com");
         assertEquals(responseEntity.getStatusCode(),HttpStatus.OK);
	}
	
	@Test
	public void testInTransit() throws Exception {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"InTransit", LocalDate.now(), "MS-0001");
		User user = new User("MS-001", "Mark", "Smith", "Test12345@", "test@gmail.com", LocalDate.now(), 
				"Admin", "1234567896", "ABCDEFGHT123", LocalDate.now(), 22L, "Australia", "New South Wales", "Sydney");
		ResponseEntity<User> entity=new ResponseEntity<User>(user,HttpStatus.OK);
		ParameterizedTypeReference<User> typeRef = new ParameterizedTypeReference<User>() {
		};
        Mockito.when(restTemplate.exchange("http://localhost:8090/api/v1/tlb/fetchDriverId/test@gmail.com", HttpMethod.GET, null, typeRef)).thenReturn(entity);
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        when(loadService.intransitLoad(any(String.class), any(String.class))).thenReturn(truckLoad);
         
        
        ResponseEntity<?> responseEntity = loadController.inTransitLoad("LD-00001","test@gmail.com");
         assertEquals(responseEntity.getStatusCode(),HttpStatus.OK);
	}
	
	@Test
	public void testCompleteLoad() throws Exception {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"Completed", LocalDate.now(), "MS-0001");
		User user = new User("MS-001", "Mark", "Smith", "Test12345@", "test@gmail.com", LocalDate.now(), 
				"Admin", "1234567896", "ABCDEFGHT123", LocalDate.now(), 22L, "Australia", "New South Wales", "Sydney");
		ResponseEntity<User> entity=new ResponseEntity<User>(user,HttpStatus.OK);
		ParameterizedTypeReference<User> typeRef = new ParameterizedTypeReference<User>() {
		};
        Mockito.when(restTemplate.exchange("http://localhost:8090/api/v1/tlb/fetchDriverId/test@gmail.com", HttpMethod.GET, null, typeRef)).thenReturn(entity);
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        when(loadService.completeLoad(any(String.class), any(String.class))).thenReturn(truckLoad);
         
        
        ResponseEntity<?> responseEntity = loadController.completeLoad("LD-00001","test@gmail.com");
         assertEquals(responseEntity.getStatusCode(),HttpStatus.OK);
	}
	
	@Test
	public void testViewBookedLoads() throws Exception {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"Booked", LocalDate.now(), "MS-0001");
		TruckLoad truckLoad1 = new TruckLoad("LD-00002", "TV", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"Booked", LocalDate.now(), "MS-0001");
		List<TruckLoad> list=new ArrayList<TruckLoad>();
		list.add(truckLoad);
		list.add(truckLoad1);
		User user = new User("MS-001", "Mark", "Smith", "Test12345@", "test@gmail.com", LocalDate.now(), 
				"Admin", "1234567896", "ABCDEFGHT123", LocalDate.now(), 22L, "Australia", "New South Wales", "Sydney");
		ResponseEntity<User> entity=new ResponseEntity<User>(user,HttpStatus.OK);
		ParameterizedTypeReference<User> typeRef = new ParameterizedTypeReference<User>() {
		};
        Mockito.when(restTemplate.exchange("http://localhost:8090/api/v1/tlb/fetchDriverId/test@gmail.com", HttpMethod.GET, null, typeRef)).thenReturn(entity);
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        when(loadService.viewBookedLoads(any(String.class))).thenReturn(list);
         
        
        List<TruckLoad> tl = loadController.viewBookedLoads("test@gmail.com");
         assertEquals(list.size(),tl.size());

	}
	
	@Test
	public void testViewInTransitLoads() throws Exception {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"InTransit", LocalDate.now(), "MS-0001");
		TruckLoad truckLoad1 = new TruckLoad("LD-00002", "TV", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"InTransit", LocalDate.now(), "MS-0001");
		List<TruckLoad> list=new ArrayList<TruckLoad>();
		list.add(truckLoad);
		list.add(truckLoad1);
		User user = new User("MS-001", "Mark", "Smith", "Test12345@", "test@gmail.com", LocalDate.now(), 
				"Admin", "1234567896", "ABCDEFGHT123", LocalDate.now(), 22L, "Australia", "New South Wales", "Sydney");
		ResponseEntity<User> entity=new ResponseEntity<User>(user,HttpStatus.OK);
		ParameterizedTypeReference<User> typeRef = new ParameterizedTypeReference<User>() {
		};
        Mockito.when(restTemplate.exchange("http://localhost:8090/api/v1/tlb/fetchDriverId/test@gmail.com", HttpMethod.GET, null, typeRef)).thenReturn(entity);
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        when(loadService.viewInTransitLoads(any(String.class))).thenReturn(list);
         
        
        List<TruckLoad> tl = loadController.viewInTransitLoads("test@gmail.com");
         assertEquals(list.size(),tl.size());
	}
	
	@Test
	public void testViewCompletedLoads() throws Exception {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"Completed", LocalDate.now(), "MS-0001");
		TruckLoad truckLoad1 = new TruckLoad("LD-00002", "TV", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"Completed", LocalDate.now(), "MS-0001");
		List<TruckLoad> list=new ArrayList<TruckLoad>();
		list.add(truckLoad);
		list.add(truckLoad1);
		User user = new User("MS-001", "Mark", "Smith", "Test12345@", "test@gmail.com", LocalDate.now(), 
				"Admin", "1234567896", "ABCDEFGHT123", LocalDate.now(), 22L, "Australia", "New South Wales", "Sydney");
		ResponseEntity<User> entity=new ResponseEntity<User>(user,HttpStatus.OK);
		ParameterizedTypeReference<User> typeRef = new ParameterizedTypeReference<User>() {
		};
        Mockito.when(restTemplate.exchange("http://localhost:8090/api/v1/tlb/fetchDriverId/test@gmail.com", HttpMethod.GET, null, typeRef)).thenReturn(entity);
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        when(loadService.viewCompletedLoads(any(String.class))).thenReturn(list);
         
        
        List<TruckLoad> tl = loadController.viewCompletedLoads("test@gmail.com");
         assertEquals(list.size(),tl.size());
	}
	
	@Test
	public void testViewAllLoads() throws Exception {
		TruckLoad truckLoad = new TruckLoad("LD-00001", "Fridge", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"Booked", LocalDate.now(), "MS-0001");
		TruckLoad truckLoad1 = new TruckLoad("LD-00002", "TV", LocalDate.now(), "Pune", LocalDate.now(), "Mumbai", 
				"Booked", LocalDate.now(), "MS-0001");
		List<TruckLoad> list=new ArrayList<TruckLoad>();
		list.add(truckLoad);
		list.add(truckLoad1);
		User user = new User("MS-001", "Mark", "Smith", "Test12345@", "test@gmail.com", LocalDate.now(), 
				"Admin", "1234567896", "ABCDEFGHT123", LocalDate.now(), 22L, "Australia", "New South Wales", "Sydney");
		ResponseEntity<User> entity=new ResponseEntity<User>(user,HttpStatus.OK);
		ParameterizedTypeReference<User> typeRef = new ParameterizedTypeReference<User>() {
		};
        Mockito.when(restTemplate.exchange("http://localhost:8090/api/v1/tlb/fetchDriverId/test@gmail.com", HttpMethod.GET, null, typeRef)).thenReturn(entity);
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        when(loadService.viewAllLoads()).thenReturn(list);
         
        
        List<TruckLoad> tl = loadController.viewAllLoads();
         assertEquals(list.size(),tl.size());
	}
}
