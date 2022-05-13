package com.example.BookingMovieTicket.HeThongRap.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.BookingMovieTicket.HeThongRap.Dto.CreateHeThongRapDto;
import com.example.BookingMovieTicket.HeThongRap.Entity.HeThongRap;
import com.example.BookingMovieTicket.HeThongRap.Repository.HeThongRapRepository;
@Service
public class HeThongRapServiceImpl implements HeThongRapService {
	HeThongRapRepository repository;
	public HeThongRapServiceImpl(HeThongRapRepository repository) {
		// TODO Auto-generated constructor stub
		this.repository=repository;
		
	}
	
	
	@Override
	public HeThongRap createHeThongRap(CreateHeThongRapDto dto,String savedPath) {
		// TODO Auto-generated method stub
		
		
		try {
			HeThongRap newHeThongRap=new HeThongRap();
			newHeThongRap.setTenHeThongRap(dto.getTenHeThongRap());
			newHeThongRap.setHinhAnh(savedPath);
			return repository.save(newHeThongRap);
		} catch (Exception e) {
			// TODO: handle exception
			
			return null;
		}
		
		
	}


	@Override
	public List<HeThongRap> getAllHeThongRap() {
		// TODO Auto-generated method stub
		List<HeThongRap> lstHeThongRap=repository.findAll();
		return lstHeThongRap;
	}
	
	

}
