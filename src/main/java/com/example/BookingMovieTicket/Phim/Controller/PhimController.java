package com.example.BookingMovieTicket.Phim.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookingMovieTicket.Phim.Dto.AddPhimDto;
import com.example.BookingMovieTicket.Phim.Dto.AddPhimLichChieuDto;
import com.example.BookingMovieTicket.Phim.Dto.PhimDto;
import com.example.BookingMovieTicket.Phim.Dto.addLichChieuDto;

import com.example.BookingMovieTicket.Phim.Entity.LichChieu;
import com.example.BookingMovieTicket.Phim.Entity.Phim;
import com.example.BookingMovieTicket.Phim.Service.PhimService;

@RestController
@RequestMapping("/api/v1")
public class PhimController {
	PhimService phimService;
	
	public  PhimController(PhimService phimService) {
		// TODO Auto-generated constructor stub
		this.phimService=phimService;
	}
	@PostMapping("/admin/phim/add")
	public Object addPhim(@Valid @RequestBody AddPhimDto dto) {
		
		Phim newPhim=phimService.addNewPhim(dto);
		
		return newPhim;
		
	}
	@GetMapping("/user/phim/get-phim")
	public Object getPhim() {
		  List<PhimDto> dsPhim=phimService.getAllPhim();
		  return dsPhim;
		
	}
	@PostMapping("/admin/admin/phim/lichchieu")
	public Object addLichChieu(@Valid @RequestBody addLichChieuDto dto) {
		LichChieu newLichChieu=phimService.addLichChieu(dto);
		
		return newLichChieu;
	}
	@PostMapping("/admin/phim/add-phim-lich-chieu/add")
	public Object addPhimLichChieu(@Valid @RequestBody AddPhimLichChieuDto dto,BindingResult result) {
			if(result.hasErrors()) {
				return "loi";
			}
			Phim newPhim=phimService.addPhimLichChieu(dto);
		
		return dto;
		
		
	}
	@GetMapping("/user/phim/lich-chieu/{id}")
	public Object getPhimTheoLichChieu(@PathVariable("id") Long id ) {
		
		List<Phim> lstPhim=phimService.getPhimByLichChieuId(id);
		
		return lstPhim;
	}
	@GetMapping("/user/cum-rap/{id}")
	public Object getPhimTheoHeThongRap(@PathVariable("id") Long id) {
		List<Phim> lstPhim=phimService.getPhimByCumRapId(id);
		return lstPhim;
		
		
	}
	@GetMapping("/{id}")
	public Object getDetailPhim(@PathVariable("id") Long id) {
		Phim phim=phimService.getPhimById(id);
		return phim;
		
		
	}
	
	

}
