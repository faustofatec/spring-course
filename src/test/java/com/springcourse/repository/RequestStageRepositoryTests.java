package com.springcourse.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springcourse.domain.Request;
import com.springcourse.domain.RequestStage;
import com.springcourse.domain.User;
import com.springcourse.domain.enums.RequestState;

@SpringBootTest
public class RequestStageRepositoryTests {
	
	@Autowired private RequestStageRepository requestStageRepository;
	
	@Test
	@Order(1)    
	public void saveTest() {
		User owner = new User();
		owner.setId(1L);
		Request request = new Request();
		request.setId(1L);
		RequestStage stage = new RequestStage(null, "Eu comprei um notebook HP", new Date(), RequestState.CLOSED, request, owner);
	
		RequestStage createStage = requestStageRepository.save(stage);
		
		assertThat(createStage.getId()).isEqualTo(1L);

	}
	
	@Test
	@Order(2)    
	public void getByIdTest() {
		Optional<RequestStage> result = requestStageRepository.findById(1L);
		
		RequestStage stage = result.get();
		
		assertThat(stage.getDescription()).isEqualTo("Eu comprei um notebook HP");
	}
	
	@Test
	@Order(3)    
	public void listByRequestIdTest() {
		List<RequestStage> stages = requestStageRepository.findAll();
		
		assertThat(stages.size()).isEqualTo(1);
	}

}
