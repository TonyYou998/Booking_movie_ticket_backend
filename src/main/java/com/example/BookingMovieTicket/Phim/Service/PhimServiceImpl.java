package com.example.BookingMovieTicket.Phim.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.BookingMovieTicket.HeThongRap.Entity.CumRap;
import com.example.BookingMovieTicket.HeThongRap.Repository.CumRapRepository;
import com.example.BookingMovieTicket.Phim.Dto.AddPhimDto;
import com.example.BookingMovieTicket.Phim.Dto.AddPhimLichChieuDto;
import com.example.BookingMovieTicket.Phim.Dto.AddXuatChieuDto;
import com.example.BookingMovieTicket.Phim.Dto.PhimDto;
import com.example.BookingMovieTicket.Phim.Dto.addLichChieuDto;

import com.example.BookingMovieTicket.Phim.Entity.LichChieu;
import com.example.BookingMovieTicket.Phim.Entity.Phim;
import com.example.BookingMovieTicket.Phim.Entity.XuatChieu;
import com.example.BookingMovieTicket.Phim.Repository.LichChieuRepository;
import com.example.BookingMovieTicket.Phim.Repository.PhimLichChieuRepository;
import com.example.BookingMovieTicket.Phim.Repository.PhimRepository;
import com.example.BookingMovieTicket.Phim.Repository.XuatChieuRepository;
@Service
public class PhimServiceImpl implements PhimService {
	private PhimRepository phimRepository;
	private LichChieuRepository lichChieuRepository;
	private XuatChieuRepository xuatChieuRepository;
	private CumRapRepository cumRapRepository;
	private PhimLichChieuRepository phimLichChieuRepository;
	public PhimServiceImpl(PhimRepository repository,LichChieuRepository lichChieuRepository,CumRapRepository cumRapRepository,PhimLichChieuRepository phimLichChieuRepository,XuatChieuRepository xuatChieuRepository) {
		
		// TODO Auto-generated constructor stub
		this.phimRepository=repository;
		this.lichChieuRepository=lichChieuRepository;
		this.cumRapRepository=cumRapRepository;
		this.phimLichChieuRepository=phimLichChieuRepository;
		this.xuatChieuRepository=xuatChieuRepository;
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
		Phim phim=phimRepository.findById(dto.getPhimId()).get();
		
		LichChieu lichChieu=lichChieuRepository.findById(dto.getLichChieuId()).get();
		
		phim.setPhimLichChieu(lichChieu);
		phimRepository.save(phim);
		
		
		return phim;
	}
	@Override
	public List<Phim> getPhimByLichChieuId(Long id) {
		// TODO Auto-generated method stub
		List<Phim> lstPhim=phimLichChieuRepository.findAllPhimByLichChieuId(id);
		return lstPhim;
	}
	@Override
	public List<Phim> getPhimByCumRapId(Long id) {
		// TODO Auto-generated method stub
		List<Phim> lstPhim=phimLichChieuRepository.findAllPhimByCumRap(id);
		return lstPhim;
	}
	@Override
	public Phim getPhimById(Long id) {
		// TODO Auto-generated method stub
		Phim phim=phimRepository.findById(id).get();
		return phim;
	}
	@Override
	public XuatChieu addXuatChieu(AddXuatChieuDto dto) {
		// TODO Auto-generated method stub
		XuatChieu xuatChieu=new XuatChieu();
		Phim phim=phimRepository.findById(dto.getPhimId()).get();
		LichChieu lichChieu=lichChieuRepository.findById(dto.getLichChieuId()).get();
		xuatChieu.setPhim(phim);
		xuatChieu.setLichChieu(lichChieu);
		xuatChieu.setThoiGianBatDau(dto.getThoiGianBatDau());
		xuatChieu.setThoiGianKetThuc(dto.getThoiGianKetThuc());
		xuatChieu.setNgayChieu(dto.getNgayChieu());
		xuatChieuRepository.save(xuatChieu);

		return xuatChieu;
		
		
		
		
	}
	



}
