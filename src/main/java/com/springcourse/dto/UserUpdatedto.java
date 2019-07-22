package com.springcourse.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.springcourse.domains.Request;
import com.springcourse.domains.RequestStage;
import com.springcourse.domains.User;
import com.springcourse.enums.Role;

import lombok.Getter;
import lombok.Setter; 

@Getter @Setter 
public class UserUpdatedto {
	
	@NotBlank
	private String name;
	
	@Email
	private String email;
	
	@Size(min = 7, max=99, message="password must be between 7 and 99 ")
	private String password;
	private List<Request> requests = new ArrayList<Request>();
	private List<RequestStage> stages = new ArrayList<RequestStage>();
	private Role role;
	public User transformToUser() {
		User user = new User(1, this.name, this.email, this.password, null, this.requests, this.stages);
		return user;
	}
}
