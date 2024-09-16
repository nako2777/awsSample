package com.example.awsStudySampleBend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.awsStudySampleBend.entity.TestTable;

public interface TestTableRepository extends JpaRepository<TestTable, Long>  {

}
