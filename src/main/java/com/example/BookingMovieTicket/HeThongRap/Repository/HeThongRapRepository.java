package com.example.BookingMovieTicket.HeThongRap.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BookingMovieTicket.HeThongRap.Entity.HeThongRap;

@Repository
public interface HeThongRapRepository extends JpaRepository<HeThongRap,Long> {
	
	

}
