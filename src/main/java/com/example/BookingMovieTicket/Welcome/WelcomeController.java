package com.example.BookingMovieTicket.Welcome;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookingMovieTicket.User.Entity.Admin;
import com.example.BookingMovieTicket.User.Entity.User;
import com.example.BookingMovieTicket.User.Service.UserService;
@RestController
public class WelcomeController {
	private UserService UserService;
	@GetMapping("/welcome")
	public Object welcome() {
		return "Welcome to booking movie project this project is for education purpose";
	}
	@GetMapping("/welcome/admin")
	public Object getAdminAccount() {
		Admin u=UserService.getAdminAccount();
		return u;
		
	}

}
