package com.example.BookingMovieTicket.Welcome;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class WelcomeController {
	@GetMapping("/welcome")
	public Object welcome() {
		return "Welcome to booking movie project this project is for education purpose";
	}

}
