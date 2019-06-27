package com.springcourse.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springcourse.domains.Request;
import com.springcourse.enums.RequestState;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

	public List<Request> findAllByOwnerId(Long id);
	
	@Transactional
	@Modifying
	@Query("UPDATE request SET state = ?2 WHERE id = ?1")
	public void updateStatus(Long id, RequestState state);
}
