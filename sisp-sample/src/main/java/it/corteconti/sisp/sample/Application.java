package it.corteconti.sisp.sample;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

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
public class Application extends SpringBootServletInitializer{

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
	
	@Component
	@Order(Ordered.HIGHEST_PRECEDENCE)
	protected static class CorsFilter implements Filter {

		public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
				throws IOException, ServletException {
			HttpServletResponse response = (HttpServletResponse) res;
			HttpServletRequest request = (HttpServletRequest) req;
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
			response.setHeader("Access-Control-Allow-Headers", "accept, Authorization, content-type ");
			response.setHeader("Access-Control-Max-Age", "3600");
			if (!request.getMethod().equals("OPTIONS")) {
				chain.doFilter(req, res);
			}
		}

		public void init(FilterConfig filterConfig) {
		}

		public void destroy() {
		}

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
