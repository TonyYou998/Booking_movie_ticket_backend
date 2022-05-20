package com.example.BookingMovieTicket.Phim.Dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class AddXuatChieuDto {
	
	@NotNull
	private Long phimId;
	
	private Long lichChieuId;
	private LocalDateTime ngayChieu;

	private LocalDateTime thoiGianBatDau;

	private LocalDateTime thoiGianKetThuc;

}
