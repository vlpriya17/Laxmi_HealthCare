package com.health.care.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration(exclude=HibernateJpaAutoConfiguration.class)
@ComponentScan("com.health.care.*")
@PropertySource("classpath:application.properties")
@EnableJpaRepositories("com.health.care.service")
public class HealthCareApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(HealthCareApplication.class, args);
	}
}
