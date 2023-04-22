package com.spread.libserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// Enable transaction
@EnableTransactionManagement
@SpringBootApplication
public class LibserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibserverApplication.class, args);
	}

}
