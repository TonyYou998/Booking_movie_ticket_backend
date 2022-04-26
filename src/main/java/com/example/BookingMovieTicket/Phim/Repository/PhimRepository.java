package com.example.BookingMovieTicket.Phim.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.BookingMovieTicket.Phim.Dto.PhimDto;
import com.example.BookingMovieTicket.Phim.Entity.Phim;
@Repository
public interface PhimRepository extends JpaRepository<Phim, Long> {
	
	@Query("SELECT p FROM Phim p")
	List<PhimDto> findAllDto();
	

}
