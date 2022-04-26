package com.example.BookingMovieTicket.Phim.Dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class AddPhimDto {
	@NotEmpty
	private String tenPhim;
	
	private String theLoai;
	private String trailer;
	private Integer rating;
	private LocalDateTime ngayPhatHanh;
	private String moTa;
	private String hinhAnh;
	private Integer doTuoi;
	
	
}
