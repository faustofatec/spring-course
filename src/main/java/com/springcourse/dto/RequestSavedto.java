package com.springcourse.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.springcourse.domain.Request;
import com.springcourse.domain.RequestStage;
import com.springcourse.domain.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestSavedto {
	@NotBlank(message = "Subject required")
	private String subject;

	private String description;

	@NotNull(message = "Owner required")
	private User owner;
	
	public Request transformToRequest() {
		Request request = new Request(null, this.subject, this.description, null, null, this.owner, this.stages);
		return request;
	}
	
	private List<RequestStage> stages = new ArrayList<RequestStage>();


}