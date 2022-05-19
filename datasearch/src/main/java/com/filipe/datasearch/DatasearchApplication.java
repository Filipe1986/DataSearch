package com.filipe.datasearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class DatasearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatasearchApplication.class, args);
	}

}
