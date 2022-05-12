package com.example.BookingMovieTicket.HeThongRap.Controller;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookingMovieTicket.HeThongRap.Dto.CreateCumRapDto;
import com.example.BookingMovieTicket.HeThongRap.Entity.CumRap;
import com.example.BookingMovieTicket.HeThongRap.Service.CumRapService;
@RestController
@RequestMapping("/api/v1")
public class CumRapController {
	private CumRapService service;
	public CumRapController(CumRapService service) {
		// TODO Auto-generated constructor stub
		this.service=service;
	}
	
	@PostMapping("/admin/cumrap/create")
	public Object createCumRap(@Valid @RequestBody CreateCumRapDto dto,BindingResult err) {
		if(err.hasErrors())
			return "loi";
		CumRap newCumRap=  service.createCumRap(dto);
		if(newCumRap !=null)
			return newCumRap;
		return "loi";
		
		
		
	}
	
	
}
