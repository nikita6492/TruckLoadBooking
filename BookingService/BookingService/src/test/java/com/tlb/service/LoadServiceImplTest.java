package com.tlb.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.tlb.entity.User;
import com.tlb.repo.LoadRepository;

@ExtendWith(MockitoExtension.class)
public class LoadServiceImplTest {

	@InjectMocks
	LoadServiceImpl loadServiceImpl;
	
	@Mock
	LoadRepository loadRepository;
	
	@BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

	/*@Test
	public void testRegisterUser() {
		User user = new User();
		user.setUserId("MS-0003");
		user.setEmail("test@gmail.com");
		user.setFirstName("Mark");
		user.setLastName("Smith");
		user.setPassword("Test12345@");
		userService.registerUser(user);
		verify(userRepository,times(1)).save(user);
		
	}*/
}
