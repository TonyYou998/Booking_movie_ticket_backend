package com.example.BookingMovieTicket.Seeders;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.BookingMovieTicket.HeThongRap.Entity.CumRap;
import com.example.BookingMovieTicket.HeThongRap.Entity.HeThongRap;
import com.example.BookingMovieTicket.HeThongRap.Repository.CumRapRepository;
import com.example.BookingMovieTicket.HeThongRap.Repository.HeThongRapRepository;
import com.example.BookingMovieTicket.User.Entity.User;

import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Component
@AllArgsConstructor
@Transactional
public class HeThongRapSeeder {
	private final Logger logger= LoggerFactory.getLogger(this.getClass());
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private final HeThongRapRepository repository;
	private final CumRapRepository cumRapRepository;
	
	@EventListener
	public void HeThongRapSeeder(ContextRefreshedEvent event) {
		seedHeThongRap();
		
	}

	private void seedHeThongRap() {
		// TODO Auto-generated method stub
		String query="SELECT  * FROM he_thong_rap";
		List<HeThongRap> heThongRap=jdbcTemplate.query(query,(ResultSet,rowNum)->null);
		if(heThongRap.size()<=0) {
			HeThongRap newHeThongRap=new HeThongRap();
			HeThongRap newHeThongRap2=new HeThongRap();
			HeThongRap newHeThongRap3=new HeThongRap();
			HeThongRap newHeThongRap4=new HeThongRap();
			HeThongRap newHeThongRap5=new HeThongRap();
			newHeThongRap5.setId((long)5);
			newHeThongRap4.setId((long) 4);
			newHeThongRap3.setId((long) 3);
			newHeThongRap2.setId((long)2);
			newHeThongRap.setId( (long) 1);
			newHeThongRap5.setTenHeThongRap("Lotte");
			newHeThongRap4.setTenHeThongRap("Galaxy");
			newHeThongRap3.setTenHeThongRap("Cinestar");
			newHeThongRap2.setTenHeThongRap("BHD");
			newHeThongRap.setTenHeThongRap("CGV");
			newHeThongRap5.setHinhAnh("https://movie0706.cybersoft.edu.vn/hinhanh/lotte-cinema.png");
			newHeThongRap4.setHinhAnh("https://movie0706.cybersoft.edu.vn/hinhanh/galaxy-cinema.png");
			newHeThongRap3.setHinhAnh("https://movie0706.cybersoft.edu.vn/hinhanh/cinestar.png");
			newHeThongRap.setHinhAnh("https://movie0706.cybersoft.edu.vn/hinhanh/cgv.png");
			newHeThongRap2.setHinhAnh("https://movie0706.cybersoft.edu.vn/hinhanh/bhd-star-cineplex.png");
			List<HeThongRap> lstHeThongRap=new ArrayList<>();
			lstHeThongRap.add(newHeThongRap);
			lstHeThongRap.add(newHeThongRap2);
			lstHeThongRap.add(newHeThongRap3);
			lstHeThongRap.add(newHeThongRap4);
			lstHeThongRap.add(newHeThongRap5);
			try {
				long start=System.currentTimeMillis();
				repository.saveAll(lstHeThongRap);
				long end=System.currentTimeMillis();
				logger.info("It took {}ms to execute",(end-start));
			}
			catch (){

			}

		}
		else
			System.out.println("he thong rap already exist");
	
		
		
	}


	

}
