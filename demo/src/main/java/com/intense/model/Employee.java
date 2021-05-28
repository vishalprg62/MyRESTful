package com.intense.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	@Id
	@NotNull(message = "ID can't be empty")
	private int id;
	
	@Size(min = 5,message = "minimum size of name must be 5 character")
	private String name;
	
	@Size(min = 5,message = "minimum size of address must be 5 character")
	private String address;

	
	
}
