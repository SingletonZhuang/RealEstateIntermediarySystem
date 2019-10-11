package com.system.realestate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;




@SpringBootApplication
@ImportResource(locations= {"spring-context.xml"})
public class SpringBootAplication {
	public static void main(String[] args) {
	
		SpringApplication.run(SpringBootAplication.class, args);
	}
}
