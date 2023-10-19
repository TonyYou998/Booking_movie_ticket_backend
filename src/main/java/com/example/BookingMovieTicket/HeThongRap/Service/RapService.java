package com.example.BookingMovieTicket.HeThongRap.Service;

import java.util.List;

import javax.validation.Valid;

import com.example.BookingMovieTicket.HeThongRap.Dto.RapDto;


import com.example.BookingMovieTicket.HeThongRap.Dto.CreateRapDto;
import com.example.BookingMovieTicket.HeThongRap.Dto.CumRapDto;
import com.example.BookingMovieTicket.HeThongRap.Entity.Rap;

public interface RapService{

	public Rap createNewRap(@Valid CreateRapDto dto);

    RapDto getDetailRap(String rapId);
    CumRapDto findRapByCumRapId(String cumRapId);
}
