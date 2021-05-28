package com.intense.demoDeployNew.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intense.demoDeployNew.model.MyMsg;

@RestController
@CrossOrigin("*")
@RequestMapping("/app")
public class AppController {
     @GetMapping("/msg")
	public ResponseEntity<MyMsg> msg()
	{
		return new ResponseEntity<MyMsg>(new MyMsg("welcome to my API"),HttpStatus.OK);
	}
	
}
