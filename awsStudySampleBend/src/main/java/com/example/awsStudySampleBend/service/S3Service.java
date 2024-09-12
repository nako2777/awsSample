package com.example.awsStudySampleBend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Request;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Response;
import software.amazon.awssdk.services.s3.model.S3Object;

@Service
public class S3Service {
	public List<S3Object> getS3List(String bucketName){
		S3Client s3 = S3Client.builder()
				.region(Region.AP_NORTHEAST_1).build();
		return listObjectsInBucket(s3, bucketName);
	}
	
	public static List<S3Object> listObjectsInBucket(S3Client s3, String bucketName) {
        try {
            ListObjectsV2Request listObjects = ListObjectsV2Request.builder()
                .bucket(bucketName)
                .build();
            
            ListObjectsV2Response listObjectsResponse = s3.listObjectsV2(listObjects);
            
            // S3バケットの内容をプリントする
            for (S3Object s3Object : listObjectsResponse.contents()) {
                System.out.println("Object Key: " + s3Object.key() + " (Size: " + s3Object.size() + " bytes)");
            }
            
            return listObjectsResponse.contents();
        } catch (Exception e) {
            e.printStackTrace();
        }
		return null;
    }
}
