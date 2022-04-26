package com.example.BookingMovieTicket.Security.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.BookingMovieTicket.Security.Dto.UserDetailsDto;
import com.example.BookingMovieTicket.User.Entity.User;
import com.example.BookingMovieTicket.User.Repository.UserRepository;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
		
		private UserRepository repository;
		public UserDetailsServiceImpl(UserRepository repository) {
			// TODO Auto-generated constructor stub
			this.repository=repository;
		}
		@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			// TODO Auto-generated method stub
			Optional<User> user = repository.findByUsernameAndRole(username);
			Set<GrantedAuthority> authorities= getAuthorities(user.get().getRole());
			if(!user.isPresent())
				throw new UsernameNotFoundException("Username is not existed.");
			
			
			
			return new UserDetailsDto(username, user.get().getPassword(), authorities);
		}
		private Set<GrantedAuthority> getAuthorities(String role) {
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		
		
			authorities.add(new SimpleGrantedAuthority(role));
		
		
		return authorities;
	}
	

}
