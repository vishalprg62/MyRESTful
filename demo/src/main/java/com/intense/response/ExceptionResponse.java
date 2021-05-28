package com.intense.response;



import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {
	private Date date;
	private String message;
	private String description;
	

}
