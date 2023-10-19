package com.example.BookingMovieTicket.Phim.Dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;

import com.example.BookingMovieTicket.Phim.Entity.Phim;
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
	public AddPhimDto(Phim phim){
		this.tenPhim=phim.getTenPhim();
		this.doTuoi=phim.getDoTuoi();
		this.hinhAnh=phim.getHinhAnh();
		this.moTa=phim.getMoTa();
		this.rating=phim.getRating();
		this.ngayPhatHanh=phim.getNgayPhatHanh().toString();
		this.trailer=phim.getTrailer();
		this.theLoai=phim.getTheLoai();
	}
	public AddPhimDto(){

	}
	
	
}
