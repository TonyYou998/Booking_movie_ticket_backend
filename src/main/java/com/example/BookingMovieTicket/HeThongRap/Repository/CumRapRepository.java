package com.example.BookingMovieTicket.HeThongRap.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.BookingMovieTicket.HeThongRap.Entity.CumRap;
@Repository
public interface CumRapRepository extends JpaRepository<CumRap, Long> {
	
	@Query(value="select * from heroku_a0664cfe3265359.cum_rap cr where cr.he_thong_rap_id=?1",nativeQuery = true)
	List<CumRap> findListCumRapByHeThongRapId(String cumRapId);
		

}
