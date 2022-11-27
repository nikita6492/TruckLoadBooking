package com.tlb.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.tlb.entity.User;
import com.tlb.repo.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
	
	@InjectMocks
	UserServiceImpl userService;
	
	@Mock
	UserRepository userRepository;
	
	@BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

	
	@Test
	public void testRegisterUser() {
		User user = new User();
		user.setUserId("MS-0003");
		user.setEmail("test@gmail.com");
		user.setFirstName("Mark");
		user.setLastName("Smith");
		user.setPassword("Test12345@");
		userService.registerUser(user);
		verify(userRepository,times(1)).save(user);
		
	}
	
	@Test
	public void testLoginUser() {
		User user = new User();
		user.setUserId("MS-0003");
		user.setEmail("test@gmail.com");
		user.setFirstName("Mark");
		user.setLastName("Smith");
		user.setPassword("Test12345@");
		
		when(userRepository.findByEmail("test@gmail.com")).thenReturn(user);
		User obj=userService.loginUser(user);
		Assertions.assertEquals(user.getFirstName(), obj.getFirstName());
		verify(userRepository,times(1)).findByEmail("test@gmail.com");
	}
	
	@Test
	public void testFetchUserByEmailId() {
		User user = new User();
		user.setUserId("MS-0003");
		user.setEmail("test@gmail.com");
		user.setFirstName("Mark");
		user.setLastName("Smith");
		user.setPassword("Test12345@");
		
		when(userRepository.findByEmail("test@gmail.com")).thenReturn(user);
		User obj=userService.fetchUserByEmailId("test@gmail.com");
		Assertions.assertEquals(user.getFirstName(), obj.getFirstName());
		verify(userRepository,times(1)).findByEmail("test@gmail.com");
	}
}
