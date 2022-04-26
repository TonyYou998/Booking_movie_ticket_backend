package com.example.BookingMovieTicket.User.Dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.example.BookingMovieTicket.User.Validation.Annotation.ConfirmPassword;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@ConfirmPassword
public class CreateUserDto {
	@NotBlank
	private String username;
	@NotBlank
	private String password;
	
	@NotBlank
	
	private String confirmPassword;
	@NotBlank
	@Email
	private String email;
	
	
	
	

}
