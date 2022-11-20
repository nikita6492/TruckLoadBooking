package com.tlb.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tlb.entity.TruckLoad;
import com.tlb.entity.User;
import com.tlb.service.LoadService;

@RestController
@CrossOrigin(origins="*")
public class LoadController {

	@Autowired
	private LoadService loadService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/api/v1/tlb/search")
	public List<TruckLoad> searchload(@RequestParam(name = "loadId", required = false) String loadId,
			@RequestParam(name = "pickupLocation", required = false) String pickupLocation,
			@RequestParam(name = "pickupDate", required = false) LocalDate pickupDate) throws Exception {
		List<TruckLoad> load = null;
		if((loadId!=null) && (pickupLocation==null || pickupLocation.isEmpty()) && (pickupDate==null )) {
			load=loadService.searchLoadByLoadId(loadId);
		}else if((loadId==null || loadId.isEmpty()) && (pickupLocation!=null) && (pickupDate==null )) {
			load=loadService.searchLoadByPickUpLocation(pickupLocation);
		}else if((loadId==null || loadId.isEmpty()) && (pickupLocation==null || pickupLocation.isEmpty()) && (pickupDate!=null)) {
			load=loadService.searchLoadByPickUpDate(pickupDate);
		}else if(loadId!=null && pickupLocation!=null && (pickupDate==null )) {
			load=loadService.searchLoadByLoadIdAndPickUpLocation(loadId, pickupLocation);
		}else if(loadId!=null && (pickupLocation==null || pickupLocation.isEmpty()) && pickupDate!=null) {
			load=loadService.searchLoadByLoadIdAndPickUpDate(loadId, pickupDate);
		}else if((loadId==null || loadId.isEmpty()) && pickupLocation!=null && pickupDate!=null) {
			load=loadService.searchLoadByPickUpLocationAndPickUpDate(pickupLocation, pickupDate);
		}else if(loadId!=null && pickupLocation!=null && pickupDate!=null) {
			load =loadService.searchLoadByLoadIdAndPickUpLocationAndPickUpDate(loadId, pickupLocation, pickupDate);
		}
		if (load != null ) {
			return load;
		} else {
			throw new Exception("No load found!");
		}
	}
	
	@GetMapping("/api/v1/tlb/search/driver")
	public List<TruckLoad> searchloadByDriver(@RequestParam(name = "loadId", required = false) String loadId,
			@RequestParam(name = "pickupLocation", required = false) String pickupLocation,
			@RequestParam(name = "pickupDate", required = false) LocalDate pickupDate) throws Exception {
		List<TruckLoad> load = null;
		if((loadId!=null) && (pickupLocation==null || pickupLocation.isEmpty()) && (pickupDate==null )) {
			load=loadService.searchLoadByLoadIdAndBookingStatus(loadId,null);
		}else if((loadId==null || loadId.isEmpty()) && (pickupLocation!=null) && (pickupDate==null )) {
			load=loadService.searchLoadByPickUpLocationAndBookingStatus(pickupLocation,null);
		}else if((loadId==null || loadId.isEmpty()) && (pickupLocation==null || pickupLocation.isEmpty()) && (pickupDate!=null)) {
			load=loadService.searchLoadByPickUpDateAndBookingStatus(pickupDate,null);
		}else if(loadId!=null && pickupLocation!=null && (pickupDate==null )) {
			load=loadService.searchLoadByLoadIdAndPickUpLocationAndBookingStatus(loadId, pickupLocation,null);
		}else if(loadId!=null && (pickupLocation==null || pickupLocation.isEmpty()) && pickupDate!=null) {
			load=loadService.searchLoadByLoadIdAndPickUpDateAndBookingStatus(loadId, pickupDate,null);
		}else if((loadId==null || loadId.isEmpty()) && pickupLocation!=null && pickupDate!=null) {
			load=loadService.searchLoadByPickUpLocationAndPickUpDateAndBookingStatus(pickupLocation, pickupDate,null);
		}else if(loadId!=null && pickupLocation!=null && pickupDate!=null) {
			load =loadService.searchLoadByLoadIdAndPickUpLocationAndPickUpDateAndBookingStatus(loadId, pickupLocation, pickupDate,null);
		}
		if (load != null ) {
			return load;
		} else {
			throw new Exception("No load found!");
		}
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/api/v1/tlb/createLoad")
	public ResponseEntity<?> createLoad(@RequestBody TruckLoad load) throws Exception {
		try {
		loadService.createLoad(load);
		return new ResponseEntity("Load created!!",HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity("Exception Occurred!!",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/api/v1/tlb/cancelLoad/{loadId}")
	public ResponseEntity<?> cancelLoad(@PathVariable("loadId") String loadId){
		try {
			loadService.cancelLoad(loadId);
			return new ResponseEntity("",HttpStatus.OK);
			}catch(Exception ex) {
				return new ResponseEntity("Exception Occurred!!",HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/api/v1/tlb/bookLoad/{loadId}/{email}")
	public ResponseEntity<?> bookLoad(@PathVariable("loadId") String loadId, @PathVariable("email") String email){
		try {
			User user=restTemplate.getForObject("http://localhost:8090/api/v1/tlb/fetchDriverId/"+email, User.class);
			loadService.bookLoad(loadId, user.getUserId());
			return new ResponseEntity("",HttpStatus.OK);
			}catch(Exception ex) {
				return new ResponseEntity("Exception Occurred!!",HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/api/v1/tlb/intransitLoad/{loadId}/{email}")
	public ResponseEntity<?> inTransitLoad(@PathVariable("loadId") String loadId, @PathVariable("email") String email){
		try {
			User user=restTemplate.getForObject("http://localhost:8090/api/v1/tlb/fetchDriverId/"+email, User.class);
			loadService.intransitLoad(loadId, user.getUserId());
			return new ResponseEntity("",HttpStatus.OK);
			}catch(Exception ex) {
				return new ResponseEntity("Exception Occurred!!",HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/api/v1/tlb/completeLoad/{loadId}/{email}")
	public ResponseEntity<?> completeLoad(@PathVariable("loadId") String loadId, @PathVariable("email") String email){
		try {
			User user=restTemplate.getForObject("http://localhost:8090/api/v1/tlb/fetchDriverId/"+email, User.class);
			loadService.completeLoad(loadId, user.getUserId());
			return new ResponseEntity("",HttpStatus.OK);
			}catch(Exception ex) {
				return new ResponseEntity("Exception Occurred!!",HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}
	
	@GetMapping("/api/v1/tlb/viewBookedLoads/{email}")
	public List<TruckLoad> viewBookedLoads(@PathVariable("email") String email) throws Exception{
		try {
			User user=restTemplate.getForObject("http://localhost:8090/api/v1/tlb/fetchDriverId/"+email, User.class);
			List<TruckLoad> load=loadService.viewBookedLoads(user.getUserId());
			return load;
			}catch(Exception ex) {
				throw new Exception(ex.getMessage());
			}
	}
	
	@GetMapping("/api/v1/tlb/viewInTransitLoads/{email}")
	public List<TruckLoad> viewInTransitLoads(@PathVariable("email") String email) throws Exception{
		try {
			User user=restTemplate.getForObject("http://localhost:8090/api/v1/tlb/fetchDriverId/"+email, User.class);
			List<TruckLoad> load=loadService.viewInTransitLoads(user.getUserId());
			return load;
			}catch(Exception ex) {
				throw new Exception(ex.getMessage());
			}
	}
	
	@GetMapping("/api/v1/tlb/viewCompletedLoads/{email}")
	public List<TruckLoad> viewCompletedLoads(@PathVariable("email") String email) throws Exception{
		try {
			User user=restTemplate.getForObject("http://localhost:8090/api/v1/tlb/fetchDriverId/"+email, User.class);
			List<TruckLoad> load=loadService.viewCompletedLoads(user.getUserId());
			return load;
			}catch(Exception ex) {
				throw new Exception(ex.getMessage());
			}
	}
	
	@GetMapping("/api/v1/tlb/viewAllLoads")
	public List<TruckLoad> viewAllLoads() throws Exception{
		try {
			
			List<TruckLoad> load=loadService.viewAllLoads();
			return load;
			}catch(Exception ex) {
				throw new Exception(ex.getMessage());
			}
	}
	
}
