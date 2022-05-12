package com.example.BookingMovieTicket.HeThongRap.Controller;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookingMovieTicket.HeThongRap.Dto.CreateRapDto;
import com.example.BookingMovieTicket.HeThongRap.Dto.CreateSeatDto;
import com.example.BookingMovieTicket.HeThongRap.Entity.Ghe;
import com.example.BookingMovieTicket.HeThongRap.Entity.Rap;
import com.example.BookingMovieTicket.HeThongRap.Repository.RapRepository;
import com.example.BookingMovieTicket.HeThongRap.Service.GheService;
import com.example.BookingMovieTicket.HeThongRap.Service.RapService;

@RestController
@RequestMapping("/api/v1")
public class RapController {
	private RapService service;
	private GheService gheService;
	public RapController(RapService service,GheService gheService) {
		// TODO Auto-generated constructor stub
		this.service=service;
		this.gheService=gheService;
	}
	@PostMapping("/admin/rap/create")
	public Object createRap(@Valid @RequestBody CreateRapDto dto,BindingResult err) {
		if(err.hasErrors())
			return "loi";
		Rap newRap=service.createNewRap(dto);
		if(newRap !=null)
		return newRap;
		return "loi";
		
		
			
		
		
		
		
	}
	@PostMapping("/admin/rap/ghe/create")
	public Object createSeat(@Valid @RequestBody CreateSeatDto dto,BindingResult err) {
		if(err.hasErrors())
			return "loi";
		Ghe ghe=gheService.createSeat(dto);
		if(ghe !=null)
			return ghe;
		return "loi";
		
		
		
	}
	

}
