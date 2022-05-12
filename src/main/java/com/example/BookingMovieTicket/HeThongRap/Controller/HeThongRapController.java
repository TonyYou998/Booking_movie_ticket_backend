package com.example.BookingMovieTicket.HeThongRap.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookingMovieTicket.HeThongRap.Dto.CreateHeThongRapDto;
import com.example.BookingMovieTicket.HeThongRap.Entity.CumRap;
import com.example.BookingMovieTicket.HeThongRap.Entity.HeThongRap;
import com.example.BookingMovieTicket.HeThongRap.Service.CumRapService;
import com.example.BookingMovieTicket.HeThongRap.Service.HeThongRapService;

@RestController
@RequestMapping("/api/v1")
public class HeThongRapController {
	
	private HeThongRapService heThongRapService;

	public HeThongRapController(HeThongRapService heThongRapService ) {
		// TODO Auto-generated constructor stub
		this.heThongRapService=heThongRapService;
		
		
	}
	@PostMapping("/admin/he-thong-rap/create")
	public Object createHeThongRap(@Valid @RequestBody CreateHeThongRapDto dto,BindingResult err){
		if(err.hasErrors())
			return "loi";
		
		HeThongRap newHeThongRap=heThongRapService.createHeThongRap(dto);
		
		if(newHeThongRap !=null)
			return newHeThongRap;
		return "loi";
		
		
	}
	@GetMapping("/user/he-thong-rap/getall")
	public Object getHeThongRap() {
		 List <HeThongRap> lstHeThongRap=heThongRapService.getAllHeThongRap();
		 return lstHeThongRap;
		
	}
	

}
