package com.tlb.service;

import java.sql.Date;
import java.util.List;

import com.tlb.entity.TruckLoad;

public interface LoadService {

	public TruckLoad createLoad(TruckLoad load);
	
	public List<TruckLoad> searchLoadByLoadId(String loadId);
	public List<TruckLoad> searchLoadByPickUpLocation(String location);
	public List<TruckLoad> searchLoadByPickUpDate(Date date);

	public List<TruckLoad> searchLoadByLoadIdAndPickUpLocation(String loadId, String location);
	public List<TruckLoad> searchLoadByLoadIdAndPickUpDate(String loadId, Date date);
	
	public List<TruckLoad> searchLoadByPickUpLocationAndPickUpDate(String location, Date date);

	public List<TruckLoad> searchLoadByLoadIdAndPickUpLocationAndPickUpDate(String loadId, String location, Date date);
	
	public List<TruckLoad> searchLoadByLoadIdAndBookingStatus(String loadId, String bookingStatus);
	public List<TruckLoad> searchLoadByPickUpLocationAndBookingStatus(String location, String bookingStatus);
	public List<TruckLoad> searchLoadByPickUpDateAndBookingStatus(Date date, String bookingStatus);

	public List<TruckLoad> searchLoadByLoadIdAndPickUpLocationAndBookingStatus(String loadId, String location, String bookingStatus);
	public List<TruckLoad> searchLoadByLoadIdAndPickUpDateAndBookingStatus(String loadId, Date date, String bookingStatus);
	
	public List<TruckLoad> searchLoadByPickUpLocationAndPickUpDateAndBookingStatus(String location, Date date, String bookingStatus);

	public List<TruckLoad> searchLoadByLoadIdAndPickUpLocationAndPickUpDateAndBookingStatus(String loadId, String location, Date date, String bookingStatus);
	
	public List<TruckLoad> viewAllLoads();
	
	public List<TruckLoad> viewBookedLoads(String driverId);
	
	public TruckLoad bookLoad(String loadId, String driverId);
	
	public TruckLoad cancelLoad(String loadId);

	public List<TruckLoad> viewInTransitLoads(String userId);

	public List<TruckLoad> viewCompletedLoads(String userId);

	TruckLoad intransitLoad(String loadId, String driverID);

	TruckLoad completeLoad(String loadId, String driverID);
	
}
