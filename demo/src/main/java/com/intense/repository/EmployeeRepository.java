package com.intense.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.intense.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer>{

}
