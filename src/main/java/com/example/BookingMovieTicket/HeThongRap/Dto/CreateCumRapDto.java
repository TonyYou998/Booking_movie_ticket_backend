package com.example.BookingMovieTicket.HeThongRap.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CreateCumRapDto {
	@NotBlank
	private String tenCumRap;
	@NotBlank
	private String hinhAnh;
	@NotBlank
	private String diaChi;
	@NotNull
	private  Long heThongRapId;
	
}
