package com.intense.demowithoracle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intense.demowithoracle.model.Customer;
import com.intense.demowithoracle.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repository;
	
	
	public List<Customer> getCustomers()
	{
		return repository.findAll();
	}
}
