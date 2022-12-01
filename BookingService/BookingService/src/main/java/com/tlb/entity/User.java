package com.tlb.entity;

import java.sql.Date;
import java.time.LocalDate;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

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
