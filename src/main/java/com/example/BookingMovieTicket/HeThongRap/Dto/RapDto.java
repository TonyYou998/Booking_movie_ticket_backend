package com.example.BookingMovieTicket.HeThongRap.Dto;

import java.util.List;
import java.util.Set;

import com.example.BookingMovieTicket.HeThongRap.Entity.Ghe;

import lombok.Data;

@Data
public class RapDto {
    private Long id;
    private String tenRap;
    private String cumRap;
    private List<Ghe> danhSachGhe;
}
