package com.example.BookingMovieTicket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookingMovieTicketApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingMovieTicketApplication.class, args);
	}

}
