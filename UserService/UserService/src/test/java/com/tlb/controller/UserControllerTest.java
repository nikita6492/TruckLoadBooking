package com.tlb.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.tlb.entity.User;
import com.tlb.service.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class UserControllerTest {
	
	@InjectMocks
	UserController usercontroller;
	
	@Mock
	UserServiceImpl userServiceImpl;
	
	@Test
	public void testLoginUser() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        User user =new User();
        user.setEmail("test@gmail.com");
        user.setPassword("Test12345@");
        when(userServiceImpl.loginUser(any(User.class))).thenReturn(user);
         
        
        ResponseEntity<?> responseEntity = usercontroller.loginUser(user);
         assertEquals(responseEntity.getStatusCode(),HttpStatus.OK);
       
	}
	
	@Test
	public void testLoginUserException() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        User user =new User();
        user.setEmail("test@gmail.com");
        user.setPassword("Test12345@");
        when(userServiceImpl.loginUser(any(User.class))).thenReturn(null);
         
        
        ResponseEntity<?> responseEntity = usercontroller.loginUser(user);
         assertEquals(responseEntity.getStatusCode(),HttpStatus.OK);
       
	}
	
	
	@Test
	public void testRegisterUser() throws Exception {
		User user = new User("MS-001", "Mark", "Smith", "Test12345@", "test@gmail.com", new Date(0), 
				"Admin", "1234567896", "ABCDEFGHT123", LocalDate.now(), 22L, "Australia", "New South Wales", "Sydney");
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        when(userServiceImpl.fetchUserByEmailId(any(String.class))).thenReturn(user);
        when(userServiceImpl.registerUser(any(User.class))).thenReturn(user);
        ResponseEntity<?> responseEntity = usercontroller.registerUser(user);
        assertEquals(responseEntity.getStatusCode(),HttpStatus.OK);
        
	}
	

	@Test
	public void testfetchUserByEmailId() throws Exception {
		User user = new User("MS-001", "Mark", "Smith", "Test12345@", "test@gmail.com", new Date(0), 
				"Admin", "1234567896", "ABCDEFGHT123", LocalDate.now(), 22L, "Australia", "New South Wales", "Sydney");
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        when(userServiceImpl.fetchUserByEmailId(any(String.class))).thenReturn(user);
        //when(userServiceImpl.registerUser(any(User.class))).thenReturn(user);
        User obj = usercontroller.fetchUserByEmail("test@gmail.com");
        assertEquals(obj.getFirstName(),user.getFirstName());
        
	}
	

}
