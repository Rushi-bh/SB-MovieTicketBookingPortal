package com.rushikesh.mtbp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieTicketBookingPortalApplication {

	public <T extends Number> Object sum(T a, T b) {
		return a + b;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MovieTicketBookingPortalApplication.class, args);
	}

}
