package com.springcourse.domains;

import java.util.Date;

import com.springcourse.enums.RequestState;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestStage {
	private long id;
	private Date realizationDate;
	private String description;
	private RequestState state;
	private Request request;
	private User user;
}
