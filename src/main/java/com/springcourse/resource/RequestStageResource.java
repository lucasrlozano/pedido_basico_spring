package com.springcourse.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcourse.domains.RequestStage;
import com.springcourse.service.RequestStageService;

@RestController
@RequestMapping(value="request_stage")
public class RequestStageResource {

	@Autowired private RequestStageService stageService;
	
	@PostMapping
	public ResponseEntity<RequestStage> save (@RequestBody RequestStage requestStage){
		RequestStage created = stageService.save(requestStage);
		return ResponseEntity.status(HttpStatus.CREATED).body(created);
	}
	@GetMapping("/{id}")
	public ResponseEntity<RequestStage> getById(@PathVariable(name = "id") Long id){
		RequestStage stage = stageService.getById(id);
		return ResponseEntity.ok(stage);
	}

}
