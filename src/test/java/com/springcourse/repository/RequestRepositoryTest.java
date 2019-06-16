package com.springcourse.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
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
import com.springcourse.domains.User;
import com.springcourse.enums.RequestState;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
public class RequestRepositoryTest {

	@Autowired private RequestRepository requestRepository;
	
	@Test
	public void AsaveTest() {
		User owner = new User();
		owner.setId(1L);
		Request request = new Request(1L, "Novo notebook", "Notebook Acer", new Date(), RequestState.OPEN, owner, null);
		Request createdRequest = requestRepository.save(request);
		assertThat(createdRequest.getId()).isEqualTo(1L);
	}
	
	@Test
	public void updateTest(){
		User owner = new User();
		owner.setId(1L);
		Request request = new Request(1L, "Novo notebook2", "Notebook Acer2", null, RequestState.OPEN, owner, null);
		Request updatedRequest = requestRepository.save(request);
		assertThat(updatedRequest.getDescription()).isEqualTo("Notebook Acer2");
	}
	
	@Test
	public void getByIdTest() {
		Optional<Request> result = requestRepository.findById(1L);
		Request request = result.get();
		assertThat(request.getSubject()).isEqualTo("Novo notebook2");
	}
	
	@Test
	public void listTest() {
		List<Request> request = requestRepository.findAll();
		assertThat(request.size()).isEqualTo(1);
	}
	
	@Test
	public void listTestByIdTest() {
		List<Request> request = requestRepository.findAllByOwnerId(1L);
		assertThat(request.size()).isEqualTo(1);
	}
	
}
