package com.fruitweb;

import com.fruitweb.controller.admin.ProductAdminController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.io.File;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class DiamonSpringBootApplication {

	public static void main(String[] args) {


		SpringApplication.run(DiamonSpringBootApplication.class, args);
	}

}
