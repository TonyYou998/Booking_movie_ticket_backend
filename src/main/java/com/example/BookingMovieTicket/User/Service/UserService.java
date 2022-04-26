package com.example.BookingMovieTicket.User.Service;

import java.util.List;

import javax.validation.Valid;

import com.example.BookingMovieTicket.User.Dto.CreateUserDto;
import com.example.BookingMovieTicket.User.Dto.UpdateUserDto;
import com.example.BookingMovieTicket.User.Dto.UserDto;
import com.example.BookingMovieTicket.User.Entity.User;

public interface UserService {
	User createUser(CreateUserDto dto);

	List<UserDto> findAllUser();

	String deleteById(Long id);

	String updateUser(UpdateUserDto dto, Long id);

	

}
