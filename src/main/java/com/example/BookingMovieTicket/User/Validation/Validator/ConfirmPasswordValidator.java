package com.example.BookingMovieTicket.User.Validation.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.BookingMovieTicket.User.Dto.CreateUserDto;
import com.example.BookingMovieTicket.User.Validation.Annotation.ConfirmPassword;

public class ConfirmPasswordValidator  implements ConstraintValidator<ConfirmPassword, CreateUserDto>{

	private String message;
	
	@Override
	public void initialize(ConfirmPassword constraintAnnotation) {
		// TODO Auto-generated method stub
		message=constraintAnnotation.message();
	}

	@Override
	public boolean isValid(CreateUserDto dto, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		if(dto.getPassword()==null||dto.getConfirmPassword()==null)
			return false;
		if (dto.getPassword().equals(dto.getConfirmPassword()))
			return true;
		return false;
	}

}
