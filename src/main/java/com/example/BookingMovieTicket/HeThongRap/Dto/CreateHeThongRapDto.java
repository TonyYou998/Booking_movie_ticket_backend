package com.example.BookingMovieTicket.HeThongRap.Dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateHeThongRapDto {
	@NotBlank
	private String tenHeThongRap;
	

	
	
}
