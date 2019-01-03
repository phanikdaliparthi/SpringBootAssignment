package com.cognizant.iiht.boot.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class SpringBootAsgnmtApplication {
	
	@Configuration
	@EnableWebMvc
	public class StaticResourceConfiguration implements WebMvcConfigurer{
       
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/robotpart/**").allowedOrigins("*").allowedMethods("GET", "POST","PUT", "DELETE");


            }
       
    }

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAsgnmtApplication.class, args);
	}

}

