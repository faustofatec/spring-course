package com.springcourse.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springcourse.domain.User;
import com.springcourse.domain.enums.Role;

@SpringBootTest
public class UserRepositoryTests {
	@Autowired private UserRepository userRepository;
	
	@Test
	@Order(1)    
	public void saveTest() {
		User user = new User(null, "teste", "teste@teste.com", "123", Role.ADMINISTRATOR, null, null);
		User createUser = userRepository.save(user);
		
		assertThat(createUser.getId()).isEqualTo(1L);
		
	}
	
	@Test
	@Order(2)    
	public void updateTest() {
		User user = new User(1L, "teste111", "teste@teste.com", "123", Role.ADMINISTRATOR, null, null);
		User updateUser = userRepository.save(user);
		
		assertThat(updateUser.getName()).isEqualTo("teste111");
	}
	
	@Test
	@Order(3)    
	public void getByIdTest() {
		Optional<User> result = userRepository.findById(1L);
		User user = result.get();
		
		assertThat(user.getPassword()).isEqualTo("123");

	}
	
	@Test
	@Order(4)    
	public void listTest() {
		List<User> users = userRepository.findAll();
		
		assertThat(users.size()).isEqualTo(1);
	}
	
	@Test
	@Order(5)    
	public void loginTest() {
		Optional<User> result = userRepository.login("teste@teste.com", "123");
		
		User user = result.get();
		
		assertThat(user.getId()).isEqualTo(1L);
		
	}
	
	@Test
	public void updateRoleTest() {
		int affectedRows = userRepository.updateRole(4L, Role.ADMINISTRATOR);
		assertThat(affectedRows).isEqualTo(1);
	}

}
