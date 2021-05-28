package com.intense.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.intense.model.Columns_Fields;
import com.intense.model.MyTable;
import com.intense.repository.ColumnsRepository;
import com.intense.repository.MyRepository;
import com.intense.repository.MyTableRepository;
import com.intense.response.MyResponse;

@RestController
public class HomeController {

	@Autowired
	private MyRepository myRepository;
	
	@Autowired
	private MyTableRepository myTableRepository;
	
	@Autowired
	private ColumnsRepository columnsRepository;
	
	@GetMapping("/")
	public ResponseEntity<MyResponse> welcome()
	{
	  return new ResponseEntity(new MyResponse("default path","welcome to my DB Metadata API",null),HttpStatus.OK);	
	}
	
	@GetMapping("/tables")
	public ResponseEntity<List<MyTable>> getAllTables() throws Exception
	{
		MyResponse myResponse=new MyResponse("list of all tables and columns", "list of all tables and columns in the database", myRepository.getAllTables());
		return new ResponseEntity(myResponse,HttpStatus.OK);
	}
	@PostMapping("/tables")
	public ResponseEntity<List<MyTable>> saveAllTables(@RequestBody List<MyTable> tableList)
	{
//		tableList.stream().forEach(
//				(table)->{List<Columns_Fields> columnList=table.getColumns();
//				columnList.stream().forEach(
//						(column)->{columnsRepository.save(column);});
//				myTableRepository.save(table);
//				});
		
		for(MyTable t:tableList)
		{
			List<Columns_Fields> columnList=t.getColumns();
			for(Columns_Fields c:columnList)
			{
				columnsRepository.save(c);
			}
			myTableRepository.save(t);
		}
		
		MyResponse myResponse=new MyResponse("all tables and columns saved successfully", "as response list of all tables and columns in the database", tableList);
		return new ResponseEntity(myResponse,HttpStatus.OK);
	}
}
