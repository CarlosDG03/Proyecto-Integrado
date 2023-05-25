package com.atos.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ConsultasJpaClubNauticoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsultasJpaClubNauticoApplication.class, args);
	}
	
	@Configuration
	@EnableWebMvc
	public class CORS implements WebMvcConfigurer {
		@Override
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**").allowedMethods("*").allowedOriginPatterns("http://localhost:4200").allowedHeaders("*").allowCredentials(true);
		}
	}

}
