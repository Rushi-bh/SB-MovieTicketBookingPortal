package com.rushikesh.mtbp;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class SwaggerConfig {

	@Bean
	public GroupedOpenApi customApi() {
		return GroupedOpenApi.builder().group("api").pathsToMatch("/api/**").build();
	}

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().info(new Info().title("Movie Ticket Booking Portal")
				.description("This are Restful apis for Movie Ticket Booking Portal build using SpringBoot3")
				.version("1.0.0"));
	}
}
