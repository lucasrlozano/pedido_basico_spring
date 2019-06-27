package com.springcourse.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcourse.domains.Request;
import com.springcourse.enums.RequestState;
import com.springcourse.exception.NotFoundException;
import com.springcourse.repository.RequestRepository;

@Service
public class RequestService {
	
	@Autowired private RequestRepository requestRepository;
	
	public Request save(Request request) {
		request.setState(RequestState.OPEN);
		request.setCriationDate(new Date());
		Request create = requestRepository.save(request);	
		return create;
	}
	
	public Request update(Request request) {
		Request updated = requestRepository.save(request);
		return updated;
	}
	
	public Request getById(Long id) {
		Optional<Request> result = requestRepository.findById(id);
		return result.orElseThrow(()-> new NotFoundException("There are not request with id = " + id));
	}
	public List<Request> getAll(){
		List<Request> requests = requestRepository.findAll();
		return requests;
	}
	
	public List<Request> getByOwner(Long ownerId){
		List<Request> requests =  requestRepository.findAllByOwnerId(ownerId);
		return requests;
	}
}
