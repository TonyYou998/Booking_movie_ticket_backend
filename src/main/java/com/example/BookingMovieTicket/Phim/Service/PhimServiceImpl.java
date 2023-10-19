package com.example.BookingMovieTicket.Phim.Service;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import com.example.BookingMovieTicket.Phim.Dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.BookingMovieTicket.HeThongRap.Entity.CumRap;
import com.example.BookingMovieTicket.HeThongRap.Repository.CumRapRepository;

import com.example.BookingMovieTicket.Phim.Entity.LichChieu;
import com.example.BookingMovieTicket.Phim.Entity.Phim;
import com.example.BookingMovieTicket.Phim.Entity.XuatChieu;
import com.example.BookingMovieTicket.Phim.Repository.LichChieuRepository;
import com.example.BookingMovieTicket.Phim.Repository.PhimLichChieuRepository;
import com.example.BookingMovieTicket.Phim.Repository.PhimRepository;
import com.example.BookingMovieTicket.Phim.Repository.XuatChieuRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
public class PhimServiceImpl implements PhimService {
	private final Logger logger= LoggerFactory.getLogger(this.getClass());
	private PhimRepository phimRepository;
	private LichChieuRepository lichChieuRepository;
	private XuatChieuRepository xuatChieuRepository;
	private CumRapRepository cumRapRepository;
	private PhimLichChieuRepository phimLichChieuRepository;
	private final String uploadDir="/src/main/resources/static/upload/";
	private final String domainName="http://localhost:8080/";
	public PhimServiceImpl(PhimRepository repository,LichChieuRepository lichChieuRepository,CumRapRepository cumRapRepository,PhimLichChieuRepository phimLichChieuRepository,XuatChieuRepository xuatChieuRepository) {
		
		// TODO Auto-generated constructor stub
		this.phimRepository=repository;
		this.lichChieuRepository=lichChieuRepository;
		this.cumRapRepository=cumRapRepository;
		this.phimLichChieuRepository=phimLichChieuRepository;
		this.xuatChieuRepository=xuatChieuRepository;
	}
	@Override
	public Phim addNewPhim(AddPhimDto dto, MultipartFile image) {
		// TODO Auto-generated method stub

		Phim newPhim=new Phim();
		try{
			String fileName= DigestUtils.md5DigestAsHex(image.getOriginalFilename().getBytes());
			fileName+="."+image.getOriginalFilename().split("\\.")[1];
			String userDir= Paths.get("").toAbsolutePath().toString();
			Path folderPath= Paths.get(userDir+uploadDir);
			if(!Files.exists(folderPath))
				Files.createDirectories(folderPath);
			Path path=Paths.get(userDir+uploadDir+fileName);
			Files.write(path, image.getBytes());
			final String savedPath=domainName+fileName;
			dto.setHinhAnh(savedPath);
		} catch (IOException e) {
			logger.info("There is an issue when upload image:{}",e.getMessage());
			throw new RuntimeException(e);
		}
		newPhim.setTenPhim(dto.getTenPhim());
		newPhim.setTheLoai(dto.getTheLoai());
		newPhim.setRating(dto.getRating());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		try {
			LocalDate formatedNgayPhatHanh = LocalDate.parse(dto.getNgayPhatHanh(), formatter);
		newPhim.setNgayPhatHanh(formatedNgayPhatHanh);
		newPhim.setMoTa(dto.getMoTa());
		newPhim.setHinhAnh(dto.getHinhAnh());
		newPhim.setDoTuoi(dto.getDoTuoi());
		newPhim.setTrailer(dto.getTrailer());

		return phimRepository.save(newPhim);
		} catch (DateTimeParseException e) {
			// TODO: handle exception
			logger.info(e.getMessage());
			return null;
		}
		
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
	@Override
	public List<XuatChieu> findXuatChieuByPhimIdCumRapId(Long phimId,Long cumRapId) {
		// TODO Auto-generated method stub
		List<XuatChieu> lstXuatChieu=xuatChieuRepository.findXuatChieuByPhimIdCumRapId(phimId,cumRapId);
		return lstXuatChieu;
	}
	@Override
	public LichChieuDtoResponse layLichChieuTheoNgay(String cumRapId, LichChieuDto selectedDate) {
		// TODO Auto-generated method stub
		CumRap cumRap=cumRapRepository.findById(Long.parseLong(cumRapId)).orElse(null);
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate=LocalDate.parse(selectedDate.getNgayChieu(),formatter);
		LichChieu lichChieu= lichChieuRepository.findByNgayChieuAndCumRap(localDate,cumRap);
		LichChieuDtoResponse dto=new LichChieuDtoResponse();
		dto.setCumRapName(lichChieu.getCumRap().getTenCumRap());
		dto.setNgayChieu(lichChieu.getNgayChieu().toString());
		List<AddPhimDto> lstPhim=new ArrayList<>();
		lichChieu.getPhim().forEach(item->{
			AddPhimDto addPhimDto=new AddPhimDto(item);
			lstPhim.add(addPhimDto);
		});
		dto.setDanhSachPhim(lstPhim);
		return dto;

		} catch (DateTimeParseException e ) {
			// TODO: handle exception
			logger.info(e.getMessage());
			return null;
		}
		catch (RuntimeException e){
			logger.info(e.getMessage());
			return  null;
		}
		
	}
	



}
