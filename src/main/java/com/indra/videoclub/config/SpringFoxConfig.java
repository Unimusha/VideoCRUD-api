package com.indra.videoclub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {

	@Bean
	public Docket api() {

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.indra.videoclub.controller")).paths(PathSelectors.any()).build()
				.apiInfo(apiInfo());

	}

	@Bean
	public ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("API de Indra VideoCRUD")
				.description("Es la API para el desarrollo de la aplicación VideoCRUD").version("1.0")
				.contact(new Contact("Alexandre Clemente Felipe", "", "tecnolex.es@gmail.com")).build();

	}
}
