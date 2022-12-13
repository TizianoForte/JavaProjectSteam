package com.example.JavaGameLibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class JavaGameLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaGameLibraryApplication.class, args);
	}

}
