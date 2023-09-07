package com.example.BookingMovieTicket.HeThongRap.Controller;

import java.util.List;

import javax.validation.Valid;

import com.example.BookingMovieTicket.HeThongRap.Dto.CumRapDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
	@GetMapping("/user/cumrap/getall/heThongRapId")
	@ResponseBody
	public List<CumRapDto> getCumRap(@RequestParam(value="id") String heThongRapId)  {
		List<CumRapDto> lstCumRap=service.findListCumRapByHrThongRapId(heThongRapId);
		return lstCumRap;


	}
	
	
}
