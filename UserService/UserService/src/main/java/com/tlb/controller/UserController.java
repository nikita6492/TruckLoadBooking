package com.tlb.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tlb.entity.User;
import com.tlb.service.UserService;

@RestController
@CrossOrigin(origins="*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/api/v1/tlb/login")
	public ResponseEntity<?> loginUser(@RequestBody User user) throws Exception{
		try {
		User userObj=userService.loginUser(user);
		if(userObj!=null) {
				if(userObj.getPassword().equals(user.getPassword())) {
				return new ResponseEntity(userObj.getRole(),HttpStatus.OK);
				}
				else {
					return new ResponseEntity("Password Incorrect",HttpStatus.OK);
				}
		}		
		else {
			return new ResponseEntity("User not found",HttpStatus.OK);
		
		}
		}catch(Exception ex) {
			return new ResponseEntity("Exception Occurred!!",HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/api/v1/tlb/register")
	public ResponseEntity<?> registerUser(@RequestBody User user) throws Exception{
		String emailId = user.getEmail();
		try {
		if(emailId!=null) {
			User userObj =userService.fetchUserByEmailId(emailId);
			if(userObj!=null) {
				return new ResponseEntity("Already Registered", HttpStatus.OK);
			}
		}
		User userObj =null;
		if(user.getDob()!=null){
			LocalDate curDate=LocalDate.now();
			long years=Period.between(user.getDob().toLocalDate(), curDate).getYears();
			if(years<18) {
				return new ResponseEntity("Age Issue",HttpStatus.OK);
			}else {
				user.setAge(years);
			}
		}
		user.setActivationDate(LocalDate.now());
		userObj=userService.registerUser(user);
		if(userObj!=null) {
		return new ResponseEntity("User Created", HttpStatus.OK);
		}else {
			return new ResponseEntity("User not created", HttpStatus.OK);
		}
		}catch(Exception ex) {
			return new ResponseEntity("Exception Occurred!!",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/api/v1/tlb/fetchDriverId")
	public User fetchUserByEmail(@RequestParam(name ="email") String email) throws Exception {
		try {
		User userObj =userService.fetchUserByEmailId(email);
		return userObj;
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
}
