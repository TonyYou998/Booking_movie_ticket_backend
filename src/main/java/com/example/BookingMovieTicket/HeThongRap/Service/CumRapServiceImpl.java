package com.example.BookingMovieTicket.HeThongRap.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.example.BookingMovieTicket.HeThongRap.Dto.CumRapDto;
import com.example.BookingMovieTicket.HeThongRap.Dto.RapDto;
import com.example.BookingMovieTicket.HeThongRap.Entity.Rap;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.BookingMovieTicket.HeThongRap.Dto.CreateCumRapDto;
import com.example.BookingMovieTicket.HeThongRap.Entity.CumRap;
import com.example.BookingMovieTicket.HeThongRap.Entity.HeThongRap;
import com.example.BookingMovieTicket.HeThongRap.Repository.CumRapRepository;
import com.example.BookingMovieTicket.HeThongRap.Repository.HeThongRapRepository;
@Service
public class CumRapServiceImpl implements CumRapService {
	
	private CumRapRepository repository;
	private HeThongRapRepository heThongRapRepository;
	private ModelMapper mapper;
	
	public CumRapServiceImpl(CumRapRepository repository,HeThongRapRepository heThongRapRepository,ModelMapper modelMapper) {
		// TODO Auto-generated constructor stub
		this.repository=repository;
		this.heThongRapRepository=heThongRapRepository;
		this.mapper=modelMapper;
	}
	@Override
	public CumRap createCumRap(CreateCumRapDto dto) {
		// TODO Auto-generated method stub
		
		try {
			CumRap newCumRap=new CumRap();
			HeThongRap heThongRap= heThongRapRepository.findById(dto.getHeThongRapId()).get();
			
			
			newCumRap.setTenCumRap(dto.getTenCumRap());
			newCumRap.setDiaChi(dto.getDiaChi());
			newCumRap.setHinhAnh(dto.getHinhAnh());
			newCumRap.setHeThongRap(heThongRap);
			return repository.save(newCumRap);
			
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
		
	}
	@Override
	public List<CumRapDto> findListCumRapByHrThongRapId(String cumRapId) {
		// TODO Auto-generated method stub
		List<CumRap> lstCumRap=repository.findListCumRapByHeThongRapId(cumRapId);
		List<CumRapDto> lstDto=new ArrayList<>();
		for(CumRap item:lstCumRap){
//			CumRapDto dto=new CumRapDto();
//			dto.setId(item.getId());
//			dto.setTenCumRap(item.getTenCumRap());
//			dto.setDiaChi(item.getDiaChi());
//			List<Rap> lstRap=new ArrayList<>(item.getDanhSachRap());
//			dto.setDanhSachRap(lstRap);
//			lstDto.add(dto);
			CumRapDto dto=mapper.map(item,CumRapDto.class);
			lstDto.add(dto);
		}
		return lstDto;
	}

}
