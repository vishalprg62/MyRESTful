package com.intense.demowithoracle.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.intense.demowithoracle.model.Customer;
import com.intense.demowithoracle.repository.CustomerRepository;
import com.intense.demowithoracle.response.MyResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class HomeController {
	
	
	private Logger logger=LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private CustomerRepository cRepository;
	
	@GetMapping("/customers")
	public ResponseEntity<MyResponse> getCustomers()
	{
		return new ResponseEntity<MyResponse>(new MyResponse("all customers info",cRepository.findAll()),HttpStatus.OK);
	}
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<MyResponse> getCustomer(@PathVariable int id)
	{
		return new ResponseEntity<MyResponse>(new MyResponse("data of customer with "+id, cRepository.findById(id)),HttpStatus.OK);
	}
	
	
	@PostMapping("/customer")
	public ResponseEntity<MyResponse> save(@RequestBody Customer customer) 
	{
		logger.info("saved customer {}",customer);
		Customer savedC=cRepository.save(customer); 
		return new ResponseEntity<MyResponse>(new MyResponse("data of customer with "+savedC.getCustomerId()+" saved",savedC) ,HttpStatus.OK);
	}
	
	@PutMapping("/customer/{id}")
	public ResponseEntity<MyResponse> updateCustomer(@RequestBody Customer customer,@PathVariable int id)
	{
	
		Customer updatedC=cRepository.save(customer); 
		logger.info("updated customer {}",updatedC);
		return new ResponseEntity<MyResponse>(new MyResponse("data of customer with "+updatedC.getCustomerId()+" is updated",updatedC) ,HttpStatus.OK);
	}
	
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<MyResponse> deleteCustomer(@PathVariable int id)
	{
		Customer customer=cRepository.findById(id).get();
		cRepository.deleteById(id);
		return new ResponseEntity<MyResponse>(new MyResponse("data of customer with "+id+" is deleted", customer),HttpStatus.OK);
	}
	
}
