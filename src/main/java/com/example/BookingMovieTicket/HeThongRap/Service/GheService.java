package com.example.BookingMovieTicket.HeThongRap.Service;

import javax.validation.Valid;

import com.example.BookingMovieTicket.HeThongRap.Dto.CreateSeatDto;
import com.example.BookingMovieTicket.HeThongRap.Entity.Ghe;


public interface GheService {

	Ghe createSeat( CreateSeatDto dto);

}
