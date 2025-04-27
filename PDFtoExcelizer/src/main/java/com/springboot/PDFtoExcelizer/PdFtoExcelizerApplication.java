package com.springboot.PDFtoExcelizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "com.springboot.PDFtoExcelizer")
@EnableScheduling
public class PdFtoExcelizerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PdFtoExcelizerApplication.class, args);
	}
}
