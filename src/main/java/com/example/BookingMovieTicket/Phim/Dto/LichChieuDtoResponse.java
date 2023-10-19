package com.example.BookingMovieTicket.Phim.Dto;

import lombok.Data;

import java.util.List;

@Data
public class LichChieuDtoResponse  extends LichChieuDto{
     private List<AddPhimDto> danhSachPhim;
}
