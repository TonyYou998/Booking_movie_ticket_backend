package com.example.BookingMovieTicket.HeThongRap.Service;

import java.util.List;

import javax.validation.Valid;

import com.example.BookingMovieTicket.HeThongRap.Dto.CreateHeThongRapDto;
import com.example.BookingMovieTicket.HeThongRap.Entity.HeThongRap;

public interface HeThongRapService {

	HeThongRap createHeThongRap(CreateHeThongRapDto dto, String savedPath);

	List<HeThongRap> getAllHeThongRap();
	
	
}
