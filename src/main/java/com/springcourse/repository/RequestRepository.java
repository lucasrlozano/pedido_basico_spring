package com.springcourse.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springcourse.domains.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

	public List<Request> findAllByOwnerId(Long id);
}
