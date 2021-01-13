package com.springcourse.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springcourse.domain.Request;
import com.springcourse.domain.RequestStage;
import com.springcourse.domain.enums.RequestState;

public interface RequestStageRepository extends JpaRepository<RequestStage, Long> {
	
	public List<RequestStage> findAllByRequestId(Long id);
	
	@Query("UPDATE request SET state = ?2 WHERE id = ?1")
	public Request updateStatus(Long id, RequestState state);
	
	public Page<RequestStage> findAllByRequestId(Long id, Pageable pageable);


}
