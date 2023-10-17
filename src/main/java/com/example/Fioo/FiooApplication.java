package com.example.Fioo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.example.Fioo.Actions", "com.example.Fioo.Classes", "com.example.Fioo.Curriculum", "com.example.Fioo.Guardian", "com.example.Fioo.LoginLog", "com.example.Fioo.Student"})
@EntityScan(basePackages = "com.example.Fioo.*")
@ComponentScan(basePackages = {"com.example.Fioo.*"})
public class FiooApplication {
	public static void main(String[] args) {
		SpringApplication.run(FiooApplication.class, args);
	}

}
