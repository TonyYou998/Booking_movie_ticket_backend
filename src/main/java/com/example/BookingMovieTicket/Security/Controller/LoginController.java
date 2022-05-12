package com.example.BookingMovieTicket.Security.Controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookingMovieTicket.Security.Jwt.JwtUtils;
import com.example.BookingMovieTicket.User.Dto.LoginDto;
@RestController
@RequestMapping("api/v1/")
public class LoginController {
	private final AuthenticationManager authenticationManager;
	private final JwtUtils jwtUtils;
	public LoginController(AuthenticationManager athentication,JwtUtils jwtUtils) {
		// TODO Auto-generated constructor stub
		this.authenticationManager=athentication;
		this.jwtUtils=jwtUtils;
	}
	@PostMapping("/user/login")
	public Object login(@Valid @RequestBody LoginDto dto,BindingResult err) {
		if(err.hasErrors())
			return "loi";
		Authentication auth=null;
		try {
			auth=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(),dto.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(auth);
			String token=jwtUtils.generateJwtToken(auth);
			return token;
			
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return "username or password are invalid";
		
		
		
	}
	
}
