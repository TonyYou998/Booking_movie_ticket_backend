package com.example.BookingMovieTicket.User.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Admin {
	private String username;
	private String password;
	public Admin(String username,String password) {
		this.username=username;
		this.password=password;
		
	}

}
