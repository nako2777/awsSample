package com.example.awsStudySampleBend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.awsStudySampleBend.service.S3Service;

import software.amazon.awssdk.services.s3.model.S3Object;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class Api {
	
	
	@Autowired
	S3Service s3Service;
	@GetMapping("/healthCheck")
	public String healthCheck(){
		System.out.println("accept request!");
		return "you've passed the healthCheck!";
	};
	
	@GetMapping("/getS3List")
	public List<S3Object> getS3List(@RequestParam("bucketName") String bucketName){
		System.out.println(bucketName);
		return s3Service.getS3List(bucketName);
	}
	
	
}
