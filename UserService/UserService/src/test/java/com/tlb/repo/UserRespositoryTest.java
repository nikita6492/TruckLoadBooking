package com.tlb.repo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.tlb.entity.User;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace =AutoConfigureTestDatabase.Replace.NONE)
public class UserRespositoryTest {
	
	@Autowired
	UserRepository userRepository;
	
	@Test
	public void testFindByEmail() {
		User user = new User();
		user.setUserId("MS-003");
		user.setEmail("test@gmail.com");
		user.setPassword("Test12345@");
		user.setFirstName("Mark");
		user.setLastName("Smith");
		userRepository.save(user);
		
		User userObj = userRepository.findByEmail("test@gmail.com");
		 Assertions.assertEquals(userObj.getFirstName(),user.getFirstName());
		
	}

}
