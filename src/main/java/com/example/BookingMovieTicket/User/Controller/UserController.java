package com.example.BookingMovieTicket.User.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookingMovieTicket.User.Dto.CreateUserDto;
import com.example.BookingMovieTicket.User.Dto.UpdateUserDto;
import com.example.BookingMovieTicket.User.Dto.UserDto;
import com.example.BookingMovieTicket.User.Entity.User;
import com.example.BookingMovieTicket.User.Service.UserService;

@RestController
@RequestMapping("api/v1/")
public class UserController {
	
	private UserService service;
	 public UserController(UserService service) {
		// TODO Auto-generated constructor stub
		 this.service=service; 
	}
	 


	@PostMapping("user/register")
	 @ResponseBody
	 public Object createUser(@Valid @RequestBody CreateUserDto dto,BindingResult err) {
		 if(err.hasErrors()) {
			 return "loi";
		 }
		User newUser=service.createUser(dto);
		if(newUser !=null)
			return newUser;
		return "loi";
		 
	 }
	 @GetMapping("/admin/get-user")
	 public Object getAllUser() {
		 List<UserDto> users=service.findAllUser();
		 return users;
		 
	 }
	 @DeleteMapping("admin/delete/{id}")
	 public Object deleteUser(@PathVariable("id") Long id) {
		  String result= service.deleteById(id);
		return result ;
		 
	 }
	 
	 @PutMapping("admin/update")
	 @ResponseBody
	 public Object updateUser(@Valid @RequestBody UpdateUserDto dto,BindingResult err) {
		 if(err.hasErrors())
			 return "loi";
		 String updatedUser=service.updateUser(dto,dto.getId());
		return updatedUser;
		 
	 }

}
