package com.springcourse.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springcourse.domains.RequestStage;

@Repository
public interface RequestStageRepository extends JpaRepository<RequestStage, Long>{
	public List<RequestStage> findAllByRequestId(Long id);
	public Page<RequestStage> findAllByRequestId(Long id, org.springframework.data.domain.Pageable pageable);
}
