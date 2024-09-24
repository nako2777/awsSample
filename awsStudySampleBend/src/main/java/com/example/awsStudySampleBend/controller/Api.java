package com.example.awsStudySampleBend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.awsStudySampleBend.dto.S3ObjectDto;
import com.example.awsStudySampleBend.entity.TestTable;
//import com.example.awsStudySampleBend.service.RDSService;
import com.example.awsStudySampleBend.service.S3Service;

import lombok.NoArgsConstructor;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class Api {
	
	
	@Autowired
	S3Service s3Service;
//	@Autowired
//	RDSService rdsService;
	
	@GetMapping("/healthCheck")
	public String healthCheck(){
		System.out.println("accept request!");
		return "you've passed the healthCheck!";
	};
	
	@GetMapping("/getS3List")
	public List<S3ObjectDto> getS3List(@RequestParam("bucketName") String bucketName){
		System.out.println(bucketName);
		return s3Service.getS3List(bucketName);
	}
	
	@GetMapping("/getS3File")
	public ResponseEntity<InputStreamResource> getS3File(String bucketName,String keyName){
		System.out.println(bucketName + keyName);
		return s3Service.getS3File(bucketName, keyName);
	}
	
//	@GetMapping("/initRDS")
//	public List<TestTable> initRDS() {
//		return rdsService.initRDS();
//	}
	
	@PostMapping("/cognito")
	public String cognito() {
		System.out.println("in cog");
		return "cognito access successful!";
	}
}
