package com;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan({"com.delivery.request"})
//@EntityScan("com.delivery.domain")
//@EnableJpaRepositories("com.delivery.repository")
//public class DayTiengAnhApplication  extends SpringBootServletInitializer {
	public class DayTiengAnhApplication{

	public static void main(String[] args) {
		SpringApplication.run(DayTiengAnhApplication.class, args);
	}

}
