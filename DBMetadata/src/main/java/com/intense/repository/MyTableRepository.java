package com.intense.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intense.model.MyTable;

@Repository
public interface MyTableRepository extends JpaRepository<MyTable, Integer>{

}
