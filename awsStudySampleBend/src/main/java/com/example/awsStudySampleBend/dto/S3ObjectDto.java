package com.example.awsStudySampleBend.dto;

import software.amazon.awssdk.services.s3.model.S3Object;

public class S3ObjectDto {
	private String key;
	private Long size;
	
	public S3ObjectDto(S3Object s3Object) {
		this.key = s3Object.key();
		this.size = s3Object.size();
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}
	
	
}
