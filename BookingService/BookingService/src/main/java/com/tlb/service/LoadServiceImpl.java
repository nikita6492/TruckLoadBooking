package com.tlb.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tlb.entity.TruckLoad;
import com.tlb.repo.LoadRepository;

@Service
public class LoadServiceImpl implements LoadService {
	
	@Autowired
	private LoadRepository loadRepository;

	@Override
	public TruckLoad createLoad(TruckLoad load) {
		
		return loadRepository.save(load);
	}

	@Override
	public List<TruckLoad> searchLoadByLoadId(String loadId) {
		return loadRepository.findByLoadId(loadId);
	}

	@Override
	public List<TruckLoad> searchLoadByPickUpLocation(String location) {
		
		return loadRepository.findByPickupLocation(location);
	}

	@Override
	public List<TruckLoad> searchLoadByPickUpDate(Date date) {
		return loadRepository.findByPickupDate(date);
	}

	@Override
	public List<TruckLoad> searchLoadByLoadIdAndPickUpLocation(String loadId, String location) {
		
		return loadRepository.findByLoadIdAndPickupLocation(loadId,location);
	}

	@Override
	public List<TruckLoad> searchLoadByLoadIdAndPickUpDate(String loadId, Date date) {
		
		return loadRepository.findByLoadIdAndPickupDate(loadId,date);
	}

	@Override
	public List<TruckLoad> searchLoadByPickUpLocationAndPickUpDate(String location, Date date) {
		
		return loadRepository.findByPickupLocationAndPickupDate(location,date);
	}

	@Override
	public List<TruckLoad> searchLoadByLoadIdAndPickUpLocationAndPickUpDate(String loadId, String location, Date date) {
		
		return loadRepository.findByLoadIdAndPickupLocationAndPickupDate(loadId,location,date);
	}

	@Override
	public List<TruckLoad> viewAllLoads() {
		
		return loadRepository.findAll();
	}

	@Override
	public TruckLoad bookLoad(String loadId, String driverID) {
		Optional<TruckLoad> load=loadRepository.findById(loadId);
		load.get().setBookingStatus("Booked");
		load.get().setDriverId(driverID);
		TruckLoad loadObj=loadRepository.save(load.get());
		return loadObj;
	}
	
	@Override
	public TruckLoad intransitLoad(String loadId, String driverID) {
		Optional<TruckLoad> load=loadRepository.findById(loadId);
		load.get().setBookingStatus("InTransit");
		load.get().setDriverId(driverID);
		TruckLoad loadObj=loadRepository.save(load.get());
		return loadObj;
	}
	
	@Override
	public TruckLoad completeLoad(String loadId, String driverID) {
		Optional<TruckLoad> load=loadRepository.findById(loadId);
		load.get().setBookingStatus("Completed");
		load.get().setDriverId(driverID);
		TruckLoad loadObj=loadRepository.save(load.get());
		return loadObj;
	}

	@Override
	public TruckLoad cancelLoad(String loadId) {
		Optional<TruckLoad> load=loadRepository.findById(loadId);
		load.get().setBookingStatus("Cancelled");
		load.get().setDriverId(null);
		TruckLoad loadObj=loadRepository.save(load.get());
		return loadObj;
	}

	@Override
	public List<TruckLoad> searchLoadByLoadIdAndBookingStatus(String loadId, String bookingStatus) {
		return loadRepository.findByLoadIdAndBookingStatus(loadId,bookingStatus);
	}

	@Override
	public List<TruckLoad> searchLoadByPickUpLocationAndBookingStatus(String location, String bookingStatus) {
		
		return loadRepository.findByPickupLocationAndBookingStatus(location,bookingStatus);
	}

	@Override
	public List<TruckLoad> searchLoadByPickUpDateAndBookingStatus(Date date, String bookingStatus) {
		return loadRepository.findByPickupDateAndBookingStatus(date,bookingStatus);
	}

	@Override
	public List<TruckLoad> searchLoadByLoadIdAndPickUpLocationAndBookingStatus(String loadId, String location, String bookingStatus) {
		
		return loadRepository.findByLoadIdAndPickupLocationAndBookingStatus(loadId,location,bookingStatus);
	}

	@Override
	public List<TruckLoad> searchLoadByLoadIdAndPickUpDateAndBookingStatus(String loadId, Date date, String bookingStatus) {
		
		return loadRepository.findByLoadIdAndPickupDateAndBookingStatus(loadId,date,bookingStatus);
	}

	@Override
	public List<TruckLoad> searchLoadByPickUpLocationAndPickUpDateAndBookingStatus(String location, Date date, String bookingStatus) {
		
		return loadRepository.findByPickupLocationAndPickupDateAndBookingStatus(location,date,bookingStatus);
	}

	@Override
	public List<TruckLoad> searchLoadByLoadIdAndPickUpLocationAndPickUpDateAndBookingStatus(String loadId, String location, Date date, String bookingStatus) {
		
		return loadRepository.findByLoadIdAndPickupLocationAndPickupDateAndBookingStatus(loadId,location,date,bookingStatus);
	}

	@Override
	public List<TruckLoad> viewBookedLoads(String driverId) {
		
		return loadRepository.findByDriverIdAndBookingStatus(driverId, "Booked");
	}

	@Override
	public List<TruckLoad> viewInTransitLoads(String driverId) {
		return loadRepository.findByDriverIdAndBookingStatus(driverId, "InTransit");
	}

	@Override
	public List<TruckLoad> viewCompletedLoads(String driverId) {
		return loadRepository.findByDriverIdAndBookingStatus(driverId, "Completed");
	}


}
