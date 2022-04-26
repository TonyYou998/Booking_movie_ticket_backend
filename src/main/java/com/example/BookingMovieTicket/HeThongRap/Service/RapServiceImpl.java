package com.example.BookingMovieTicket.HeThongRap.Service;

import org.springframework.stereotype.Service;

import com.example.BookingMovieTicket.HeThongRap.Dto.CreateRapDto;
import com.example.BookingMovieTicket.HeThongRap.Entity.CumRap;
import com.example.BookingMovieTicket.HeThongRap.Entity.Rap;
import com.example.BookingMovieTicket.HeThongRap.Repository.CumRapRepository;
import com.example.BookingMovieTicket.HeThongRap.Repository.RapRepository;
@Service
public class RapServiceImpl implements RapService {
	 private RapRepository repository;
	 private CumRapRepository cumRapRepository;
	 public RapServiceImpl(RapRepository repository,CumRapRepository cumRapRepository) {
		// TODO Auto-generated constructor stub
		 this.repository=repository;
		 this.cumRapRepository=cumRapRepository;
		 
	}
	
	
	@Override
	public Rap createNewRap(CreateRapDto dto) {
		// TODO Auto-generated method stub
		
		
		Rap newRap=new Rap();
		CumRap cumRap=cumRapRepository.findById(dto.getCumRapId()).get();
		
		newRap.setTenRap(dto.getTenRap());
		newRap.setCumRap(cumRap);
			return repository.save(newRap);
	
	}
	
		
}
