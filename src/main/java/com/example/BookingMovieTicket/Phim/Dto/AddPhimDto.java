package com.example.BookingMovieTicket.Phim.Dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class AddPhimDto {
	@NotEmpty
	private String tenPhim;
	private String theLoai;
	private String trailer;
	private Integer rating;
	private String ngayPhatHanh;
	private String moTa;
	private Integer doTuoi;
//	private MultipartFile image;
	private String hinhAnh;
	
	
}
