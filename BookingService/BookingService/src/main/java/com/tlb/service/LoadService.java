package com.tlb.service;

import java.time.LocalDate;
import java.util.List;

import com.tlb.entity.TruckLoad;

public interface LoadService {

	public TruckLoad createLoad(TruckLoad load);
	
	public List<TruckLoad> searchLoadByLoadId(String loadId);
	public List<TruckLoad> searchLoadByPickUpLocation(String location);
	public List<TruckLoad> searchLoadByPickUpDate(LocalDate date);

	public List<TruckLoad> searchLoadByLoadIdAndPickUpLocation(String loadId, String location);
	public List<TruckLoad> searchLoadByLoadIdAndPickUpDate(String loadId, LocalDate date);
	
	public List<TruckLoad> searchLoadByPickUpLocationAndPickUpDate(String location, LocalDate date);

	public List<TruckLoad> searchLoadByLoadIdAndPickUpLocationAndPickUpDate(String loadId, String location, LocalDate date);
	
	public List<TruckLoad> searchLoadByLoadIdAndBookingStatus(String loadId, String bookingStatus);
	public List<TruckLoad> searchLoadByPickUpLocationAndBookingStatus(String location, String bookingStatus);
	public List<TruckLoad> searchLoadByPickUpDateAndBookingStatus(LocalDate date, String bookingStatus);

	public List<TruckLoad> searchLoadByLoadIdAndPickUpLocationAndBookingStatus(String loadId, String location, String bookingStatus);
	public List<TruckLoad> searchLoadByLoadIdAndPickUpDateAndBookingStatus(String loadId, LocalDate date, String bookingStatus);
	
	public List<TruckLoad> searchLoadByPickUpLocationAndPickUpDateAndBookingStatus(String location, LocalDate date, String bookingStatus);

	public List<TruckLoad> searchLoadByLoadIdAndPickUpLocationAndPickUpDateAndBookingStatus(String loadId, String location, LocalDate date, String bookingStatus);
	
	public List<TruckLoad> viewAllLoads();
	
	public List<TruckLoad> viewBookedLoads(String driverId);
	
	public TruckLoad bookLoad(String loadId, String driverId);
	
	public TruckLoad cancelLoad(String loadId);

	public List<TruckLoad> viewInTransitLoads(String userId);

	public List<TruckLoad> viewCompletedLoads(String userId);
	
}
