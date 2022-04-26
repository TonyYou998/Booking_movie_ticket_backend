package com.example.BookingMovieTicket.User.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UpdateUserDto {
	@NotNull
	private Long id;
	@NotBlank
	private String username;
	@NotBlank
	private String email;
	@NotBlank
	private String password;

	
	

}
