package com.example.BookingMovieTicket.HeThongRap.Service;

import java.util.List;

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
	
	public CumRapServiceImpl(CumRapRepository repository,HeThongRapRepository heThongRapRepository) {
		// TODO Auto-generated constructor stub
		this.repository=repository;
		this.heThongRapRepository=heThongRapRepository;
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
	public List<CumRap> findListCumRapByHrThongRapId(String cumRapId) {
		// TODO Auto-generated method stub
		List<CumRap> lstCumRap=repository.findListCumRapByHeThongRapId(cumRapId);
		return lstCumRap;
	}

}
