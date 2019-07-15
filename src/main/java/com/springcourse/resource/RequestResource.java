package com.springcourse.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springcourse.domains.Request;
import com.springcourse.domains.RequestStage;
import com.springcourse.model.PageModel;
import com.springcourse.model.PageRequestModel;
import com.springcourse.service.RequestService;
import com.springcourse.service.RequestStageService;

@RestController
@RequestMapping(value = "requests")
public class RequestResource {
	@Autowired private RequestService requestService;
	@Autowired private RequestStageService stageService;
	
	@PostMapping
	public ResponseEntity<Request> save(@RequestBody Request request){
		Request createdRequest = requestService.save(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdRequest);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Request> update(@PathVariable(name = "id") Long id, @RequestBody Request request){
		request.setId(id);
		Request updatedRequest = requestService.save(request);
		return ResponseEntity.ok(updatedRequest);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Request> getById(@PathVariable(name = "id") Long id){
		Request request = requestService.getById(id);
		return ResponseEntity.ok(request);
	}
	
	@GetMapping
	public ResponseEntity<PageModel<Request>> listAll(
			@RequestParam(value = "size", required = false) String size,
			@RequestParam(value = "page", required = false) String page){
		if(page == null && size == null)
		{
			PageRequestModel pr = new PageRequestModel(0, Integer.MAX_VALUE);
			PageModel<Request> pm = requestService.listAllOnLazyModel(pr);
			return ResponseEntity.ok(pm);
		}
		else {
			PageRequestModel pr = new PageRequestModel(Integer.parseInt(page), Integer.parseInt(size));
			PageModel<Request> pm = requestService.listAllOnLazyModel(pr);
			return ResponseEntity.ok(pm);
		}		
		
	}	
	@GetMapping("/{id}/request-stages")
	public ResponseEntity<List<RequestStage>> listAllStagesById(@PathVariable(name = "id") Long id,
			@RequestParam(value = "size", defaultValue = "0") String size,
			@RequestParam(value = "page", defaultValue = "100") String page){
		PageRequestModel pr = new PageRequestModel(Integer.parseInt(page), Integer.parseInt(size));
		PageModel<RequestStage> pm = stageService.listAllByRequestIdOnLazyModel(id, pr);
		List<RequestStage> stages = stageService.listAllByRequestId(id);
		return ResponseEntity.ok(stages);	
	}

}
