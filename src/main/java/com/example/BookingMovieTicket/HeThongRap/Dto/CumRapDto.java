package com.example.BookingMovieTicket.HeThongRap.Dto;

import com.example.BookingMovieTicket.HeThongRap.Entity.Rap;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Data
public class CumRapDto {
    private Long id;
    private String tenCumRap;
    private String hinhAnh;
    private String diaChi;
    @JsonManagedReference
    private Set<Rap> danhSachRap;
    public CumRapDto(){

    }

}
