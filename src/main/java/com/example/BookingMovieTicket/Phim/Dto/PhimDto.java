package com.example.BookingMovieTicket.Phim.Dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

public interface PhimDto {
//	private String tenPhim;
//	private String theLoai;
//	private String doTuoi;
//	private String trailer;
//	private String moTa;
//	private String hinhAnh;
//	private LocalDateTime ngayPhatHanh;
	public Long getId();
	public String getTenPhim();
	public String getTheLoai();
	public String getDoTuoi();
	public String getTrailer();
	public String getMoTa();
	public String getHinhAnh();
	public LocalDateTime getNgayPhatHanh();
}
