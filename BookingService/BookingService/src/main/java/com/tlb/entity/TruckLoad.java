package com.tlb.entity;

import java.sql.Date;
import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.tlb.generator.LoadSequenceIdGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TruckLoad {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="load_seq")
	@GenericGenerator(name="load_seq", 
	strategy = "com.tlb.generator.LoadSequenceIdGenerator",
	parameters = {
			@Parameter(name=LoadSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value="LD-"),
			@Parameter(name=LoadSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value="%05d"),
			@Parameter(name=LoadSequenceIdGenerator.INCREMENT_PARAM, value="5")})
	private String loadId;
	private String itemType;
	private Date pickupDate;
	private String pickupLocation;
	private Date dropDate;
	private String dropLocation;
	private String bookingStatus;
	private Date bookingDate;
	private String driverId;
}

