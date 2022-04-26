package com.example.BookingMovieTicket.User.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.BookingMovieTicket.User.Dto.CreateUserDto;
import com.example.BookingMovieTicket.User.Dto.UpdateUserDto;
import com.example.BookingMovieTicket.User.Dto.UserDto;
import com.example.BookingMovieTicket.User.Entity.User;
import com.example.BookingMovieTicket.User.Repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {
	private UserRepository repository;
	private PasswordEncoder encoder;
	public UserServiceImpl(UserRepository repository,PasswordEncoder encoder) {
		
		// TODO Auto-generated constructor stub
		this.repository=repository;
		this.encoder=encoder;
	}
	@Override
	public User createUser(CreateUserDto dto) {
		// TODO Auto-generated method stub
		
		try {
			User newUser=new User();
			newUser.setRole("ROLE_Admin");
			newUser.setUsername(dto.getUsername());
			newUser.setPassword(encoder.encode(dto.getPassword()));
			newUser.setEmail(dto.getEmail());
			return repository.save(newUser) ;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	@Override
	public List<UserDto> findAllUser() {
		// TODO Auto-generated method stub
		return repository.findAllUserDto();
	}
	@Override
	public String deleteById(Long id) {
		// TODO Auto-generated method stub
		Optional<User> newUser=repository.findById(id);
		if(newUser.isPresent()) {
			repository.deleteById(id);
			return "delete success";
		}
		return "failed";
			
		
		
	}
	@Override
	public String updateUser(UpdateUserDto dto,Long id) {
		// TODO Auto-generated method stub
		Optional<User> user=repository.findById(id);
		if(user.isPresent()) {
			try {
				repository.update(id, dto.getUsername(), encoder.encode(dto.getPassword()), dto.getEmail());
				return "update success";
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
			
			
		
		}
		return "failed";
	}
	

}
