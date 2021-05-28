package com.intense.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.intense.model.Employee;
import com.intense.response.MyResponse;

@RestController
public class HomeController {

	@GetMapping("/")
	public ResponseEntity<MyResponse> welcome()
	{
		return new ResponseEntity<MyResponse>(new MyResponse("default controller","",""),HttpStatus.OK);
	}
	
	
	@PostMapping("/employee")
	public ResponseEntity<MyResponse> save(@Valid @RequestBody Employee emp)
	{
		System.out.println("employee "+emp);
		
		return new ResponseEntity<MyResponse>(new MyResponse("saved", "success", emp),HttpStatus.CREATED);
	}
	
}
