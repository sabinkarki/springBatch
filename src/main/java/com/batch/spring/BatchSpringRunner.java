package com.batch.spring;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableBatchProcessing
@SpringBootApplication
public class BatchSpringRunner {

	public static void main(String[] args) {
		SpringApplication.run(BatchSpringRunner.class, args);
	}
}
