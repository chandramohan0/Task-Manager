package com.chandraMohan.taskManager.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI myCustomConfig() {
		return new OpenAPI()
			.info(
					new Info().title("Task Manager APIs")
			          		  .description("By Chandra Mohan")
			)
			.servers(Arrays.asList(new Server().url("http://localhost:8080").description("local")));
	}
}
