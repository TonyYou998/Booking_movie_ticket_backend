package com.example.BookingMovieTicket.Phim.Controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.util.DigestUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.BookingMovieTicket.Common.ResponseHandler;
import com.example.BookingMovieTicket.Phim.Dto.AddPhimDto;
import com.example.BookingMovieTicket.Phim.Dto.AddPhimLichChieuDto;
import com.example.BookingMovieTicket.Phim.Dto.AddXuatChieuDto;
import com.example.BookingMovieTicket.Phim.Dto.LayXuatChieuTheoPhimVaCumRapDto;
import com.example.BookingMovieTicket.Phim.Dto.PhimDto;
import com.example.BookingMovieTicket.Phim.Dto.addLichChieuDto;

import com.example.BookingMovieTicket.Phim.Entity.LichChieu;
import com.example.BookingMovieTicket.Phim.Entity.Phim;
import com.example.BookingMovieTicket.Phim.Entity.XuatChieu;
import com.example.BookingMovieTicket.Phim.Service.PhimService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/v1")
public class PhimController {
	PhimService phimService;

//	private final String domainName="https://bookingmovieapi.herokuapp.com/";

	public  PhimController(PhimService phimService) {
		// TODO Auto-generated constructor stub
		this.phimService=phimService;
	}
	@PostMapping("/admin/phim/add")
	public Object addPhim(@ModelAttribute AddPhimDto dto,@RequestParam("image") MultipartFile image) {
		Phim newPhim=phimService.addNewPhim(dto,image);
		return newPhim;
	}
	@GetMapping("/user/phim/get-phim")
	public Object getPhim() {
		  List<PhimDto> dsPhim=phimService.getAllPhim();
		  return dsPhim;
		
	}
	@PostMapping("/admin/phim/lichchieu")
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
	public Object getPhimTheoCumRap(@PathVariable("id") Long cum_rap_id) {
		List<Phim> lstPhim=phimService.getPhimByCumRapId(cum_rap_id);
		return lstPhim;
		
		
	}
	@GetMapping("/{id}")
	public Object getDetailPhim(@PathVariable("id") Long id) {
		Phim phim=phimService.getPhimById(id);
		return phim;
		
		
	}
	@PostMapping("/admin/phim/add-xuat-chieu-lich-chieu/add")
	public Object addXuatChieuVaoLichChieu(@Valid @RequestBody AddXuatChieuDto dto,BindingResult result) {
		if(result.hasErrors())
			return "Loi";
		XuatChieu xuatChieu= phimService.addXuatChieu(dto);
		
		return xuatChieu;
		
	}
	@GetMapping("/user/xuat-chieu/phimid={phimId}&cumrapid={cumRapId}")
	public Object layXuatChieuTheoPhimVaCumRap(@PathVariable("phimId") Long phimId,@PathVariable("cumRapId") Long cumRapId) {
		
		List<XuatChieu> lstXuatChieu=phimService.findXuatChieuByPhimIdCumRapId(phimId,cumRapId);
		
		return ResponseHandler.getResponse(lstXuatChieu,HttpStatus.OK);
	}
	
	

}
