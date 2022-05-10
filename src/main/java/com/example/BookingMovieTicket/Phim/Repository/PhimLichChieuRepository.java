package com.example.BookingMovieTicket.Phim.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.BookingMovieTicket.Phim.Entity.Phim;

public interface PhimLichChieuRepository extends JpaRepository<Phim, Long> {
	@Query(value="SELECT * from phim as p, lich_chieu  as lc,phim_lich_chieu as plc where \r\n"
			+ "lc.id=?1 and lc.id=plc.lich_chieu_id and plc.phim_id=p.id",nativeQuery = true)
	List<Phim> findAllPhimByLichChieuId(Long id);
	@Query(value="select * from phim as p,phim_lich_chieu as plc, lich_chieu as lc, cum_rap cr where \r\n"
			+ "cr.id=?1 and lc.cum_rap_id=cr.id and lc.id=plc.lich_chieu_id and p.id=plc.phim_id;\r\n",nativeQuery=true)
	List<Phim> findAllPhimByCumRap(Long id);
	
	
}
