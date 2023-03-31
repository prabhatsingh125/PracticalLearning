package com.example.textextractor.TextExtractor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("com.example.textextractor.TextExtractor.Repository")
public class TextExtractorApplication {

	public static void main(String[] args) {
		SpringApplication.run(TextExtractorApplication.class, args);
	}

}
