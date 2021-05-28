package com.intense.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class MyResponse {
	
	private String message;
	private String description;
	private Object body;
	
	
}
