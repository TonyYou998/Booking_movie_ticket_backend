package com.example.BookingMovieTicket.Phim.Dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LayXuatChieuTheoPhimVaCumRapDto {
	@NotBlank
	private Long phimId;
	@NotBlank
	private Long cumRapId;

}
