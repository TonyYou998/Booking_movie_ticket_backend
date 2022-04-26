package com.example.BookingMovieTicket.Seeders;

import java.util.List;

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
@Component
@AllArgsConstructor
public class HeThongRapSeeder {
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
			HeThongRap newHethongRap=new HeThongRap();
			newHethongRap.setId( (long) 1);
			newHethongRap.setTenHeThongRap("CGV");
			newHethongRap.setHinhAnh("https://gigamall.com.vn/data/2019/05/06/11365490_logo-cgv-500x500.jpg");
			repository.save(newHethongRap);
		}
		else
			System.out.println("he thong rap already exist");
	
		
		
	}


	

}
