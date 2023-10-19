package com.example.BookingMovieTicket.HeThongRap.Service;

import com.example.BookingMovieTicket.HeThongRap.Dto.RapDto;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.BookingMovieTicket.HeThongRap.Dto.CreateRapDto;
import com.example.BookingMovieTicket.HeThongRap.Dto.CumRapDto;
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

	@Override
	public RapDto getDetailRap(String rapId) {
		Rap rap = repository.findById(Long.parseLong(rapId)).orElse(null);
		if (rap == null)
			return null;
		RapDto rapDto = new RapDto();
		rapDto.setId(rap.getId());
		rapDto.setTenRap(rap.getTenRap());
		rapDto.setCumRap(rap.getCumRap().getTenCumRap());
		rapDto.setDanhSachGhe(rap.getDanhSachGhe());
		return rapDto;
	}


	@Override
	public CumRapDto findRapByCumRapId(String cumRapId) {
		// TODO Auto-generated method stub
			CumRap cumRap=cumRapRepository.findById(Long.parseLong(cumRapId)).orElse(null);
			if(cumRap==null)
				return null;
			CumRapDto cumRapDto=new CumRapDto();
			cumRapDto.setId(cumRap.getId());
			cumRapDto.setTenCumRap(cumRap.getTenCumRap());
			cumRapDto.setDiaChi(cumRap.getDiaChi());
			cumRapDto.setHinhAnh(cumRap.getHinhAnh());
			cumRapDto.setDanhSachRap(cumRap.getDanhSachRap());
			return cumRapDto;

	}

}
