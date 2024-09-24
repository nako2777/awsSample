package com.example.awsStudySampleBend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class})
public class AwsStudySampleBendApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsStudySampleBendApplication.class, args);
	}

}
