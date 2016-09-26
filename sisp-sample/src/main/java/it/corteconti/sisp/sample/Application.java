package it.corteconti.sisp.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "it.corteconti.sisp")
@EnableSwagger2
@EnableCircuitBreaker
public class Application {

	public static void main(String[] args) {
		 
		SpringApplication.run(Application.class, args);
	}
}
