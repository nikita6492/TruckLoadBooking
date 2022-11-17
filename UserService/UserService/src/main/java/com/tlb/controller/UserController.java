package com.tlb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tlb.entity.User;
import com.tlb.service.UserServiceImpl;

@RestController
@CrossOrigin(origins="*")
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/api/v1/tlb/login")
	public ResponseEntity<?> loginUser(@RequestBody User user){
		User userObj=userService.loginUser(user);
		if(userObj!=null) {
				if(userObj.getPassword().equals(user.getPassword())) {
				return new ResponseEntity(userObj.getRole(),HttpStatus.OK);
				}
				else {
					return new ResponseEntity("Password Incorrect !!", HttpStatus.NOT_FOUND);
				}
		}		
		else {
			return new ResponseEntity("User Not Found !!", HttpStatus.NOT_FOUND);
		
		}
			
		}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/api/v1/tlb/register")
	public ResponseEntity<?> registerUser(@RequestBody User user){
		return new ResponseEntity("User Not Found !!", HttpStatus.NOT_FOUND);
	}

}
