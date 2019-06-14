package com.springcourse.domains;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Request {
	private long id;	
	private String subject;
	private String description;
	private Date criationDate;
	private RequestStage state;
	private User user;
	private List<RequestStage> stages = new ArrayList<RequestStage>();
	
}
