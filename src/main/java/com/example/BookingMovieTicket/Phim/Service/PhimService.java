package com.example.BookingMovieTicket.Phim.Service;

import java.util.List;

import com.example.BookingMovieTicket.Phim.Dto.*;

import com.example.BookingMovieTicket.Phim.Entity.LichChieu;
import com.example.BookingMovieTicket.Phim.Entity.Phim;
import com.example.BookingMovieTicket.Phim.Entity.XuatChieu;
import org.springframework.web.multipart.MultipartFile;

public interface PhimService {

	 Phim addNewPhim(AddPhimDto dto, MultipartFile image);

	List<PhimDto> getAllPhim();

	

	LichChieu addLichChieu( addLichChieuDto dto);

	Phim addPhimLichChieu( AddPhimLichChieuDto dto);

	List<Phim> getPhimByLichChieuId(Long id);

	List<Phim> getPhimByCumRapId(Long id);

	Phim getPhimById(Long id);

	XuatChieu addXuatChieu( AddXuatChieuDto dto);

	List<XuatChieu> findXuatChieuByPhimIdCumRapId( Long phimId,Long cumRapId);

    LichChieuDtoResponse layLichChieuTheoNgay(String cumRapId, LichChieuDto selectedDate);

	



}
