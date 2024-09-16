package com.example.awsStudySampleBend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.awsStudySampleBend.dto.S3ObjectDto;

import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Request;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Response;
import software.amazon.awssdk.services.s3.model.S3Object;

@Service
public class S3Service {

	private S3Client initS3Client() {
		return S3Client.builder().region(Region.AP_NORTHEAST_1).build();
	}

	public List<S3ObjectDto> getS3List(String bucketName) {
		S3Client s3 = initS3Client();
		try {
			ListObjectsV2Request listObjects = ListObjectsV2Request.builder().bucket(bucketName).build();

			ListObjectsV2Response listObjectsResponse = s3.listObjectsV2(listObjects);

			List<S3ObjectDto> list = new ArrayList<>();
			// S3バケットの内容をプリントする
			for (S3Object s3Object : listObjectsResponse.contents()) {
				System.out.println("Object Key: " + s3Object.key() + " (Size: " + s3Object.size() + " bytes)");
				list.add(new S3ObjectDto(s3Object));
			}

			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ResponseEntity<InputStreamResource> getS3File(String bucketName, String keyName) {
		S3Client s3Client = initS3Client();

		try {
			GetObjectRequest getObjectRequest = GetObjectRequest.builder().bucket(bucketName).key(keyName).build();
			ResponseInputStream<GetObjectResponse> strream = s3Client.getObject(getObjectRequest);

			System.out.println(strream);
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + keyName + "\"")
					.contentType(MediaType.APPLICATION_OCTET_STREAM)
					.body(new InputStreamResource(strream));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return null;
	}
	
	
}
