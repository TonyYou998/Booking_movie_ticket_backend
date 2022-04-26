package com.example.BookingMovieTicket.Phim.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.BookingMovieTicket.HeThongRap.Entity.CumRap;
import com.example.BookingMovieTicket.HeThongRap.Repository.CumRapRepository;
import com.example.BookingMovieTicket.Phim.Dto.AddPhimDto;
import com.example.BookingMovieTicket.Phim.Dto.AddPhimLichChieuDto;
import com.example.BookingMovieTicket.Phim.Dto.PhimDto;
import com.example.BookingMovieTicket.Phim.Dto.addLichChieuDto;

import com.example.BookingMovieTicket.Phim.Entity.LichChieu;
import com.example.BookingMovieTicket.Phim.Entity.Phim;
import com.example.BookingMovieTicket.Phim.Repository.LichChieuRepository;
import com.example.BookingMovieTicket.Phim.Repository.PhimRepository;
@Service
public class PhimServiceImpl implements PhimService {
	private PhimRepository phimRepository;
	private LichChieuRepository lichChieuRepository;
	private CumRapRepository cumRapRepository;
	public PhimServiceImpl(PhimRepository repository,LichChieuRepository lichChieuRepository,CumRapRepository cumRapRepository) {
		// TODO Auto-generated constructor stub
		this.phimRepository=repository;
		this.lichChieuRepository=lichChieuRepository;
		this.cumRapRepository=cumRapRepository;
	}
	@Override
	public Phim addNewPhim(AddPhimDto dto) {
		// TODO Auto-generated method stub
		
		Phim newPhim=new Phim();
		newPhim.setTenPhim(dto.getTenPhim());
		newPhim.setTheLoai(dto.getTheLoai());
		newPhim.setRating(dto.getRating());
		newPhim.setNgayPhatHanh(dto.getNgayPhatHanh());
		newPhim.setMoTa(dto.getMoTa());
		newPhim.setHinhAnh(dto.getHinhAnh());
		newPhim.setDoTuoi(dto.getDoTuoi());
		newPhim.setTrailer(dto.getTrailer());
		return phimRepository.save(newPhim);
	}
	@Override
	public List<PhimDto> getAllPhim() {
		// TODO Auto-generated method stub
			return	phimRepository.findAllDto();
	}
	@Override
	public LichChieu addLichChieu(addLichChieuDto dto) {
		// TODO Auto-generated method stub
		
		 
		 CumRap cumRap=cumRapRepository.findById(dto.getCumRapId()).get();
		 LichChieu newLichChieu=new LichChieu();
//		 newLichChieu.addPhim(phim);
		 newLichChieu.setCumRap(cumRap);
		 newLichChieu.setNgayChieu(dto.getNgayChieu());
		 lichChieuRepository.save(newLichChieu);
		 
		 
		 
		
		
		return newLichChieu;
	}
	@Override
	public Phim addPhimLichChieu(AddPhimLichChieuDto dto) {
		// TODO Auto-generated method stub
		Phim newPhim=new Phim();
		LichChieu lichChieu=lichChieuRepository.findById(dto.getLichChieuId()).get();
		
		newPhim.setPhimLichChieu(lichChieu);
		
		return null;
	}


}
