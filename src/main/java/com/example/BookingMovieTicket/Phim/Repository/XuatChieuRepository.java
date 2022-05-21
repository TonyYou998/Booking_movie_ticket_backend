package com.example.BookingMovieTicket.Phim.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.BookingMovieTicket.Phim.Entity.XuatChieu;

@Repository
public interface XuatChieuRepository extends JpaRepository<XuatChieu, Long> {
	
	@Query(value = "select *  from heroku_12d5073315a2c6d.xuat_chieu xc, heroku_12d5073315a2c6d.lich_chieu lc where xc.phim_id=?1 and  lc.cum_rap_id=?2",nativeQuery = true)
	List<XuatChieu> findXuatChieuByPhimIdCumRapId(Long phimId, Long cumRapId);

}
