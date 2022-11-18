package com.tlb.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tlb.entity.TruckLoad;

@Repository
public interface LoadRepository extends JpaRepository<TruckLoad, String> {

	List<TruckLoad> findByLoadId(String loadId);

	List<TruckLoad> findByPickupLocation(String location);

	List<TruckLoad> findByPickupDate(LocalDate date);

	List<TruckLoad> findByLoadIdAndPickupLocation(String loadId, String location);

	List<TruckLoad> findByLoadIdAndPickupDate(String loadId, LocalDate date);

	List<TruckLoad> findByPickupLocationAndPickupDate(String location, LocalDate date);

	List<TruckLoad> findByLoadIdAndPickupLocationAndPickupDate(String loadId, String location, LocalDate date);

	List<TruckLoad> findByLoadIdAndPickupLocationAndPickupDateAndBookingStatus(String loadId, String location,
			LocalDate date, String bookingStatus);

	List<TruckLoad> findByPickupLocationAndPickupDateAndBookingStatus(String location, LocalDate date, String bookingStatus);

	List<TruckLoad> findByLoadIdAndPickupDateAndBookingStatus(String loadId, LocalDate date, String bookingStatus);

	List<TruckLoad> findByLoadIdAndPickupLocationAndBookingStatus(String loadId, String location, String bookingStatus);

	List<TruckLoad> findByPickupDateAndBookingStatus(LocalDate date, String bookingStatus);

	List<TruckLoad> findByPickupLocationAndBookingStatus(String location, String bookingStatus);

	List<TruckLoad> findByLoadIdAndBookingStatus(String loadId, String bookingStatus);
	
	List<TruckLoad> findByDriverIdAndBookingStatus(String driverId, String bookingStatus);

}
