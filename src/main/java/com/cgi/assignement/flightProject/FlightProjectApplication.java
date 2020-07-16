package com.cgi.assignement.flightProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class FlightProjectApplication {

	@Autowired
	private Environment env;
	public static void main(String[] args) {
		SpringApplication.run(FlightProjectApplication.class, args);
	}

	/*@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/flightResults").allowedOrigins(env.getProperty("frontend.url"));
			}
		};

	}*/
}
