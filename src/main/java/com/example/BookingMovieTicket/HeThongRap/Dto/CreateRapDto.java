package com.example.BookingMovieTicket.HeThongRap.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateRapDto {
	@NotBlank
	private String tenRap;
	@NotNull
	private Long cumRapId;

}
