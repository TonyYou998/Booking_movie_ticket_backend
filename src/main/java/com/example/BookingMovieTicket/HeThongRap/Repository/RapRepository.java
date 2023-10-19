package com.example.BookingMovieTicket.HeThongRap.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BookingMovieTicket.HeThongRap.Entity.CumRap;
import com.example.BookingMovieTicket.HeThongRap.Entity.Rap;
@Repository
public interface RapRepository extends JpaRepository<Rap,Long> {

    Optional<CumRap> findByIdOrderByIdAsc(long parseLong);
	
	

}
