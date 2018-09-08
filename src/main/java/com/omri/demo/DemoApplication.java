package com.omri.demo;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	 @Bean
	   public Docket itemApi() {
	       return new Docket(DocumentationType.SWAGGER_2)
	               .groupName("demo")
	               .apiInfo(apiInfo())
	               .select()
	               .paths(regex ("/item.*"))
	               .build();
	   }
	    
	   private ApiInfo apiInfo() {
	       return new ApiInfoBuilder()
	               .title("Spring REST Sample with Swagger")
	               .description("Spring REST Sample with Swagger")
	               .license("Apache License Version 2.0")
	               .licenseUrl("https://github.com/mazmaz2k/Spring__swagger_api/blob/master/LICENSE")
	               .version("1.0")
	               .build();
	   }

}
