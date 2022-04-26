package com.example.BookingMovieTicket.HeThongRap.Service;

import org.springframework.stereotype.Service;

import com.example.BookingMovieTicket.HeThongRap.Dto.CreateSeatDto;
import com.example.BookingMovieTicket.HeThongRap.Entity.Ghe;
import com.example.BookingMovieTicket.HeThongRap.Entity.Rap;
import com.example.BookingMovieTicket.HeThongRap.Repository.GheRepository;
import com.example.BookingMovieTicket.HeThongRap.Repository.RapRepository;

@Service
public class GheServiceImpl implements GheService {

	private  GheRepository gheRepository;
	private  RapRepository rapRepository;
	public GheServiceImpl(GheRepository gheRepository,RapRepository rapRepository) {
		// TODO Auto-generated constructor stub
		
		this.gheRepository=gheRepository;
		this.rapRepository=rapRepository;
	}
	@Override
	public Ghe createSeat(CreateSeatDto dto) {
		// TODO Auto-generated method stub
		
		Rap rap=rapRepository.findById(dto.getRapId()).get();
		Ghe ghe=new Ghe();
		ghe.setLoaiGhe(dto.getLoaiGhe());
		ghe.setSoGhe(dto.getSoGhe());
		ghe.setRap(rap);
		return gheRepository.save(ghe);
		
	
	}
	

}
