package com.intense.repository;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.intense.model.Columns_Fields;
import com.intense.model.MyTable;

@Repository
public class MyRepository {

	@Autowired
	private DataSource dataSource;

	public List<MyTable> getAllTables() throws Exception {

		List<MyTable> tableList=new ArrayList<MyTable>();
		Connection connection = dataSource.getConnection();
		
		DatabaseMetaData metaData = connection.getMetaData();
		String[] types = { "TABLE" };

		ResultSet rs = metaData.getTables(null, null, "%", types);
		
		MyTable table;
		while (rs.next()) {
			
			table=new MyTable();
			
			String tableName = rs.getString(3);
			 ResultSet columns = metaData.getColumns(null, null, tableName, null);
			 //System.out.println(tableName);
			 
			 //called setter
			 table.setName(tableName);
			 //System.out.println("*****************************");
		      //Printing the column name and size
			 List<Columns_Fields> columnList=columnList=new ArrayList<Columns_Fields>();;
		      while (columns.next()){
		    	  
		    	  
		    	  Columns_Fields column=new Columns_Fields();
		    	  String cName=columns.getString("COLUMN_NAME");
		    	  
		    	  column.setName(cName);
		   
		    	  String cType=columns.getString("TYPE_NAME");
		    	  
		    	  column.setType(cType);
		         //System.out.print("Column name and size: "+cName+"\n");
		        //System.out.println("Data type name: "+cType);
		         //System.out.println(" ");
		         columnList.add(column);
		      }
		      table.setColumns(columnList);
		      
		      tableList.add(table);

			System.out.println(tableName);
			
			
		}
		return tableList;
	}
}
