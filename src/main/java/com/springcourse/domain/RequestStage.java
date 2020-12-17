package com.springcourse.domain;

import java.util.Date;

import com.springcourse.domain.enums.RequestState;

public class RequestStage {
	private Long id;
	private String description;
	private Date realizationDate;
	private RequestState state;
	private Request request;
	private User user;

}
