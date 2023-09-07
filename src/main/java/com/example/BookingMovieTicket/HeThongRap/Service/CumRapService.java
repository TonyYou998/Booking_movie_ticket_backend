package com.example.BookingMovieTicket.HeThongRap.Service;


import java.util.List;

import com.example.BookingMovieTicket.HeThongRap.Dto.CreateCumRapDto;
import com.example.BookingMovieTicket.HeThongRap.Dto.CumRapDto;
import com.example.BookingMovieTicket.HeThongRap.Entity.CumRap;

public interface CumRapService {
	public CumRap createCumRap(CreateCumRapDto dto);

	public List<CumRapDto> findListCumRapByHrThongRapId(String heThongRapId);

}
