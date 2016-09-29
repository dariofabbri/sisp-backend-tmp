package it.corteconti.sisp.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
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

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.paths(PathSelectors.regex("/giudizio-api.*"))
				.build();
	}
	
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Sample REST API")
                .description("API REST di esempio")
                .contact(new Contact("Engineering Ingegneria Informatica", "www.eng.it", null))
                .version("0.0.1")
                .build();
    }
}
