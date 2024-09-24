package com.example.awsStudySampleBend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.awsStudySampleBend.entity.TestTable;
import com.example.awsStudySampleBend.repository.TestTableRepository;

//@Service
//public class RDSService {
//	
//	@Autowired
//	TestTableRepository testTableRepository;
//	
//	public List<TestTable> initRDS() {
//		TestTable user = new TestTable(null,"testUser",25L);
//		testTableRepository.save(user);
//		System.out.println(user.getName());
//		return getAll();
//	}
//	
//	public List<TestTable> getAll(){
//		return testTableRepository.findAll();
//	}
//	
//	
//}
