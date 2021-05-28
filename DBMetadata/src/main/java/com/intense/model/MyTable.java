package com.intense.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class MyTable {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	
	private String name;
	
	@OneToMany
	@JoinColumn(name = "table_id")
	private List<Columns_Fields> columns;
	
	
}
