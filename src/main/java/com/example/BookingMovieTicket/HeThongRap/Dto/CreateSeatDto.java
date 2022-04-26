package com.example.BookingMovieTicket.HeThongRap.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CreateSeatDto {
	@NotBlank
	private String loaiGhe;
	@NotBlank
	private String soGhe;
	@NotNull
	private Long rapId;

}
