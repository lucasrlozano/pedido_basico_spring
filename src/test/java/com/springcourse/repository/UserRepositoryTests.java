package com.springcourse.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springcourse.domains.Request;
import com.springcourse.domains.RequestStage;
import com.springcourse.domains.User;
import com.springcourse.enums.Role;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
public class UserRepositoryTests {
	@Autowired private UserRepository userRepository;
	
	@Test
	public void AsaveTest() {
		User user = new User(1L, "kevin", "kevin@gmail.com", "123", Role.ADMINISTRATOR, null, null);
		User createdUser = userRepository.save(user);
		
		assertThat(createdUser.getId()).isEqualTo(1L); 
	}
	
	@Test
	public void BupdateTest() {
		User user = new User(1L, "kevin asd", "kevinASD@gmail.com", "123", Role.ADMINISTRATOR, null, null);
		User updatedUser = userRepository.save(user);
		
		assertThat(updatedUser.getName()).isEqualTo("kevin asd");
	}
	
	@Test
	public void getByIdTest() {
		Optional<User> result = userRepository.findById(1L);
		User user = result.get();
		assertThat(user.getPassword()).isEqualTo("123");
		
	}
	
	@Test
	public void listTest() {
		List<User> users = userRepository.findAll();
		assertThat(users.size()).isEqualTo(1);
		
	}
	
	@Test
	public void loginTest() {
		Optional<User> result = userRepository.login("kevinASD@gmail.com", "123");
		User loggedUser = result.get();
		assertThat(loggedUser.getId()).isEqualTo(1L);
	}
}
