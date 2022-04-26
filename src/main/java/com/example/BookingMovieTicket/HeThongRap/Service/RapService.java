package com.example.BookingMovieTicket.HeThongRap.Service;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookingMovieTicket.HeThongRap.Dto.CreateRapDto;
import com.example.BookingMovieTicket.HeThongRap.Entity.Rap;

public interface RapService{

	public Rap createNewRap(@Valid CreateRapDto dto);
	
}
