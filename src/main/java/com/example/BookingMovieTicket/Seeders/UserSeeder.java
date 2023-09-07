package com.example.BookingMovieTicket.Seeders;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.BookingMovieTicket.User.Entity.User;
import com.example.BookingMovieTicket.User.Repository.UserRepository;


@Component
public class UserSeeder {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private PasswordEncoder encoder;
	private UserRepository repository;
	
	public UserSeeder(PasswordEncoder encoder,UserRepository repository) {
		// TODO Auto-generated constructor stub
		this.encoder=encoder;
		this.repository=repository;
	}
	 @EventListener
	 public void seed(ContextRefreshedEvent event) {
		 
		 seedUserTable();
	 }

	private void seedUserTable() {
		// TODO Auto-generated method stub
			
//		String sql="select  *\r\n"
//				+ "from users u \r\n"
//				+ "where u.role=\"ROLE_ADMIN\"";
		String sql="SELECT * FROM users WHERE role='ROLE_ADMIN'";
		List<User> u=jdbcTemplate.query(sql,(ResultSet,rowNum)->null);
		if( u.size()<=0) {
			User newUser=new User();
			newUser.setUsername("admin");
			newUser.setId((long) 1);
			newUser.setPassword(encoder.encode("1234"));
			newUser.setEmail("tanvuu998@gamil.com");
			newUser.setRole("ROLE_Admin");
			repository.save(newUser);
			
		}
		else System.out.println("user is exist");
		
		
	}
	
}
