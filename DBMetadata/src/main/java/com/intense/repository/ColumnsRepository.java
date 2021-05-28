package com.intense.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intense.model.Columns_Fields;

@Repository
public interface ColumnsRepository extends JpaRepository<Columns_Fields, Integer>{

}
