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

import com.tlb.generator.UserSequenceIdGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="user_seq")
	@GenericGenerator(name="user_seq", 
	strategy = "com.tlb.generator.UserSequenceIdGenerator",
	parameters = {
			@Parameter(name=UserSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value="MS-"),
			@Parameter(name=UserSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value="%03d"),
			@Parameter(name=UserSequenceIdGenerator.INCREMENT_PARAM, value="5")})
	private String userId;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private Date dob;
	private String role;
	private String contactNo;
	private String pan;
	private LocalDate activationDate;
	private Long age;
	private String country;
	private String state;
	private String city;
	
}
