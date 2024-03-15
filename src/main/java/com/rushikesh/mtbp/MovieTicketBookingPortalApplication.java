package com.rushikesh.mtbp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieTicketBookingPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieTicketBookingPortalApplication.class, args);
	}

//	@Bean
//	public Docket productApi() {
//		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.rushikesh.mtbp")).build();
//		
//	}

}
