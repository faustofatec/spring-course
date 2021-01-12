package com.springcourse.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcourse.domain.Request;
import com.springcourse.domain.enums.RequestState;
import com.springcourse.exception.NotFoundException;
import com.springcourse.repository.RequestRepository;

@Service
public class RequestService {
	@Autowired private RequestRepository requestRepository;
	
	
	public Request save(Request request) {
		request.setState(RequestState.OPEN);
		request.setCreationDate(new Date());
		Request createRequest = requestRepository.save(request);
		return createRequest;
		
	}

	public Request update(Request request) {
	
		Request updateRequest = requestRepository.save(request);
		return updateRequest;
	}

	
	public Request getById(Long id) {
		Optional<Request> result = requestRepository.findById(id);
		return result.orElseThrow(()-> new NotFoundException("Não tem pedidos com esse id = "+ id));

	}
	
	public List<Request> listAll() {
		List<Request> requests = requestRepository.findAll();
		return requests;
	}
	
	public List<Request> listAllOwnerId(Long ownerId) {
		List<Request> requests = requestRepository.findAllByOwnerId(ownerId);
		return requests;
	}
	
}
