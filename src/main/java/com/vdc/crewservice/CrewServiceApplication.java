package com.vdc.crewservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableCaching
//@ImportResource({"classpath*:application-context.xml"})
public class CrewServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrewServiceApplication.class, args);
	}

}
