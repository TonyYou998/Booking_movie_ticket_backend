package com.example.BookingMovieTicket.Phim.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BookingMovieTicket.Phim.Entity.XuatChieu;

@Repository
public interface XuatChieuRepository extends JpaRepository<XuatChieu, Long> {

}
